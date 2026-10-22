package com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.ui.SelfDisciplineEndView;
import com.bytedance.android.livesdk.utils.l3;
import com.bytedance.live.datacontext.m;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkSelfDisciplineEndViewBinder extends me.drakeet.multitype.b<a, ItemViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkSelfDisciplineEndViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        public final ViewGroup a;
        public final SelfDisciplineEndView b;

        public ItemViewHolder(View r2, ViewGroup r3) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            Intrinsics.checkNotNullParameter(r3, "parentView");
            super(r2);
            this.b = (SelfDisciplineEndView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131389765);
            this.a = r3;
        }
    }

    public static final class a extends tf0.e {
        public final ILinkPlayerInfoBridge k;
        public final int l;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.k, r4.k) == true) goto L8;
            return false;
        L8:
            if (this.l == r4.l) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            ILinkPlayerInfoBridge r0 = this.k;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L7:
            return (r1 * 31) + this.l;
        L5:
            r1 = 0;
            goto L7
        }

        public final String toString() {
            return "SelfDisciplineEndItemData(linkPlayerInfo=" + this.k + ", position=" + this.l + ")";
        }

        public a(ILinkPlayerInfoBridge r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "linkPlayerInfo");
            this.k = r2;
            this.l = r3;
        }
    }

    public MultiLinkSelfDisciplineEndViewBinder() {
    }

    public final void b(RecyclerView.ViewHolder r13, Object r14) {
        ItemViewHolder r15 = (ItemViewHolder) r13;
        a r16 = (a) r14;
        Intrinsics.checkNotNullParameter(r15, "holder");
        Intrinsics.checkNotNullParameter(r16, "item");
        ILinkPlayerInfoBridge r17 = r16.k;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r17, "linkPlayInfo");
        ALogger.d("MultiLinkSelfDisciplineEndViewBinder", "bind viewHolder: " + r15.hashCode());
        SelfDisciplineEndView r18 = r15.b;
        if (r18 == null) goto L37;
        SelfDisciplineContext.a r0 = SelfDisciplineContext.Companion;
        SelfDisciplineContext r1 = r0.getContext();
        if (r1 == null) goto L11;
        ConcurrentHashMap<String, Long> r2 = r1.getDurationHolder();
        if (r2 == null) goto L11;
        Long r3 = r2.get(je0.d.b0());
        if (r3 == null) goto L11;
        long r4 = r3.longValue();
    L12:
        Intrinsics.checkNotNullParameter(r17, "info");
        ConstraintLayout r5 = r18.a(2131367728);
        if (r5 == null) goto L15;
        r5.setVisibility(0);
    L15:
        TextView r6 = (TextView) r18.a(2131391254);
        long r7 = 60;
        long r8 = r4 % r7;
        TimeUnit r9 = TimeUnit.SECONDS;
        long r10 = r9.toMinutes(r4) % r7;
        r6.setText(SelfDisciplineEndView.b(r9.toHours(r4)) + ':' + SelfDisciplineEndView.b(r10) + ':' + SelfDisciplineEndView.b(r8));
        int r11 = SelfDisciplineContext.a.a();
        if (r11 != 2) goto L19;
        r18.a(2131371660).setVisibility(8);
    L31:
        HSImageView r19 = r18.a(2131376045);
        IBaseUser r110 = r17.getUser();
        if (r110 == null) goto L34;
        k r111 = r110.getAvatarMedium();
    L35:
        ImageLoader.bindImage(r19, r111, new l3(5));
        return;
    L34:
        r111 = null;
        goto L35
    L19:
        if (r11 != 1) goto L31;
        r18.a(2131371660).setVisibility(0);
        if (r4 >= r17.getSelfDisciplineTargetDuration()) goto L30;
        SelfDisciplineContext r12 = r0.getContext();
        if (r12 == null) goto L29;
        m<Integer> r20 = r12.getLastPunchStatus();
        if (r20 == null) goto L29;
        if (((Number) r20.getValue()).intValue() == 2) goto L30;
    L29:
        r18.a(2131371660).setImageResource(2131249934);
        ((TextView) r18.a(2131390740)).setText(r18.getContext().getResources().getString(2131922435));
    L30:
        r18.a(2131371660).setImageResource(2131249935);
        ((TextView) r18.a(2131390740)).setText(r18.getContext().getResources().getString(2131922434));
    L11:
        r4 = 0;
        goto L12
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new ItemViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131566333, r4, false), r4);
    }
}
