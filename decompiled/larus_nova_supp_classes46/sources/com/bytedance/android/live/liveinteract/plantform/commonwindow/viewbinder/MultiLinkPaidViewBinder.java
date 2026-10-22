package com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.chatroom.view.NoPaddingTextView;
import com.bytedance.android.livesdk.utils.l3;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.facebook.drawee.backends.pipeline.Fresco;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkPaidViewBinder extends me.drakeet.multitype.b<a, ItemViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/viewbinder/MultiLinkPaidViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int h = 0;
        public final String a;
        public final ViewGroup b;
        public final HSImageView c;
        public final HSImageView d;
        public final LinearLayout e;
        public final NoPaddingTextView f;
        public boolean g;

        public ItemViewHolder(View r2, ViewGroup r3) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            Intrinsics.checkNotNullParameter(r3, "parentView");
            super(r2);
            this.a = "https://" + LiveCommonConstants.INSTANCE.getObjectTosPath() + "/obj/live-android/ttlive_video_bid_paid_coin_anim.webp";
            this.c = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131363821);
            this.d = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131373322);
            this.e = (LinearLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131371637);
            this.f = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131371638);
            this.b = r3;
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
            return "PaidItemData(linkPlayerInfo=" + this.k + ", position=" + this.l + ")";
        }

        public a(ILinkPlayerInfoBridge r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "linkPlayerInfo");
            this.k = r2;
            this.l = r3;
        }
    }

    public MultiLinkPaidViewBinder() {
    }

    public final void b(RecyclerView.ViewHolder r8, Object r9) {
        ItemViewHolder r10 = (ItemViewHolder) r8;
        a r11 = (a) r9;
        Intrinsics.checkNotNullParameter(r10, "holder");
        Intrinsics.checkNotNullParameter(r11, "item");
        ILinkPlayerInfoBridge r12 = r11.k;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r12, "linkPlayInfo");
        ALogger.d("MultiLinkPaidViewBinder", "bind viewHolder: " + r10.hashCode());
        if (r10.g == true) goto L10;
        HSImageView r0 = r10.d;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L11:
        if (r1 == false) goto L14;
        ALogger.d("MultiLinkPaidViewBinder", "bind viewHolder: " + r10.hashCode() + ", return");
        return;
    L14:
        if (r12.isPaidUserLeave() == true) goto L16;
        return;
    L16:
        if (r12.getPaidCount() <= 0) goto L31;
        IBaseUser r2 = r12.getUser();
        if (r2 == null) goto L22;
        k r3 = r2.getAvatarThumbKt();
        if (r3 == null) goto L22;
        ImageLoader.bindImage(r10.c, r3, new l3(5, r10.b.getWidth() / r10.b.getHeight(), null));
    L22:
        HSImageView r4 = r10.d;
        if (r4 == null) goto L25;
        UtilityKotlinExtentionsKt.w(r4);
    L25:
        HSImageView r5 = r10.d;
        if (r5 == null) goto L32;
        r5.setController(Fresco.newDraweeControllerBuilder().setUri(r10.a).setAutoPlayAnimations(true).setControllerListener(new f(r10, r12)).build());
        return;
    L32:
        return;
    L31:
        return;
    L7:
        if (r0.isAnimating() != true) goto L9;
    L10:
        r1 = true;
        goto L11
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        Intrinsics.checkNotNullParameter(r6, "parent");
        View r7 = LayoutInflater.from(r6.getContext()).inflate(2131566331, r6, false);
        TextView r0 = (TextView) r7.findViewById(2131371639);
        if (r0 == null) goto L6;
        r0.setText(s1.C(2131918167, new Object[]{r3.c()}));
    L6:
        return new ItemViewHolder(r7, r6);
    }

    public final void c(RecyclerView.ViewHolder r2, Object r3, List r4) {
        ItemViewHolder r5 = (ItemViewHolder) r2;
        a r6 = (a) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r6, "item");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        b(r5, r6);
    }
}
