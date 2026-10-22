package com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive.utils.TabDataHelper;
import com.bytedance.android.livesdk.dsl.recyclerview.BaseDSLViewHolder;
import com.bytedance.android.livesdk.dsl.recyclerview.SingleDSLViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yt1.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003\u0006\u0007\bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/descriptioncomponent/mylive/TabItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "<init>", "()V", "ItemViewHolder", "LoadingViewHolder", "SpaceViewHolder", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public TabDataHelper a;
    public final com.bytedance.android.livesdk.dsl.recyclerview.a b;
    public com.bytedance.android.livesdk.dsl.recyclerview.c c;
    public final List<com.bytedance.android.livesdk.dsl.recyclerview.e> d;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/descriptioncomponent/mylive/TabItemAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        public ItemViewHolder(TextView r2) {
            Intrinsics.checkNotNullParameter(r2, "mItemView");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/descriptioncomponent/mylive/TabItemAdapter$LoadingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LoadingViewHolder extends RecyclerView.ViewHolder {
        public final View a;
        public final TextView b;
        public final ImageView c;
        public final View d;

        public LoadingViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "mItemView");
            super(r2);
            this.d = r2;
            this.a = r2.findViewById(2131380582);
            this.b = (TextView) r2.findViewById(2131380584);
            this.c = (ImageView) r2.findViewById(2131380583);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/descriptioncomponent/mylive/TabItemAdapter$SpaceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SpaceViewHolder extends RecyclerView.ViewHolder {
        public final View a;

        public SpaceViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "spaceView");
            super(r2);
            this.a = r2;
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.d).size();
    }

    public TabItemAdapter() {
        this.b = new com.bytedance.android.livesdk.dsl.recyclerview.a();
        this.d = new ArrayList();
    }

    public final int getItemViewType(int r3) {
        int r0 = y2((com.bytedance.android.livesdk.dsl.recyclerview.e) ListProtector.get(this.d, r3));
        if (r0 == (-1)) goto L6;
        return r0;
    L6:
        return ((com.bytedance.android.livesdk.dsl.recyclerview.e) ListProtector.get(this.d, r3)).getItemType();
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewRecycled(r3);
        this.b.getClass();
        Intrinsics.checkNotNullParameter(r3, "holder");
        if ((r3 instanceof BaseDSLViewHolder) == false) goto L9;
        BaseDSLViewHolder r4 = (BaseDSLViewHolder) r3;
        com.bytedance.android.livesdk.dsl.recyclerview.b r0 = r4.a;
        if (r0 == null) goto L7;
        r0.a = null;
    L7:
        r4.a = null;
        r4.V3();
        return;
    }

    public final void setData(List<? extends com.bytedance.android.livesdk.dsl.recyclerview.e> r2) {
        Intrinsics.checkNotNullParameter(r2, "tabData");
        ((ArrayList) this.d).clear();
        ((ArrayList) this.d).addAll(r2);
    }

    public final int y2(com.bytedance.android.livesdk.dsl.recyclerview.e r6) {
        Intrinsics.checkNotNullParameter(r6, "item");
        com.bytedance.android.livesdk.dsl.recyclerview.a r0 = this.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "dslItem");
        if ((r6 instanceof com.bytedance.android.livesdk.dsl.recyclerview.b) == true) goto L5;
        r6 = null;
    L5:
        com.bytedance.android.livesdk.dsl.recyclerview.b r7 = (com.bytedance.android.livesdk.dsl.recyclerview.b) r6;
        if (r7 == null) goto L10;
        Long r8 = r7.b;
        if (r8 == null) goto L10;
        long r3 = r8.longValue();
    L12:
        if (r3 != (-1)) goto L14;
        return -1;
    L14:
        Integer r9 = (Integer) r0.b.get(Long.valueOf(r3));
        if (r9 != null) goto L18;
        r9 = Integer.valueOf(r0.a.a.addAndGet(1));
        r0.b.put(Long.valueOf(r3), r9);
    L18:
        return r9.intValue();
    L10:
        r3 = -1;
        goto L12
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        if (this.c == null) goto L24;
        com.bytedance.android.livesdk.dsl.recyclerview.a r1 = this.b;
        com.bytedance.android.livesdk.dsl.recyclerview.b r4 = (com.bytedance.android.livesdk.dsl.recyclerview.e) ListProtector.get(this.d, r8);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r7, "holder");
    L18:
        StringBuilder r0 = new StringBuilder("bind data error. ");
        if (r4 == null) goto L21;
        Object r2 = Integer.valueOf(r4.getItemType());
    L22:
        r0.append(r2);
        ALogger.e("DSLAdapterHelper", r0.toString());
        goto L24
    L21:
        r2 = "null";
        goto L22
    L6:
        if ((r7 instanceof BaseDSLViewHolder) == false) goto L24;
        if ((r4 instanceof com.bytedance.android.livesdk.dsl.recyclerview.b) == true) goto L10;
        com.bytedance.android.livesdk.dsl.recyclerview.b r3 = null;
    L11:
        com.bytedance.android.livesdk.dsl.recyclerview.b r5 = r3;     // Catch: Throwable -> L18
        if (r5 == null) goto L24;
        r5.d = r8;     // Catch: Throwable -> L18
        BaseDSLViewHolder r6 = (BaseDSLViewHolder) r7;     // Catch: Throwable -> L18
        r6.getClass();     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r5, "item");     // Catch: Throwable -> L18
        com.bytedance.android.livesdk.dsl.recyclerview.b r9 = r6.a;     // Catch: Throwable -> L18
        if (r9 == null) goto L16;
        r9.a = null;     // Catch: Throwable -> L18
    L16:
        r6.a = r5;     // Catch: Throwable -> L18
        r5.a = null;     // Catch: Throwable -> L18
        r5.a = new WeakReference(r6);     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r5, "slice");     // Catch: Throwable -> L18
        r6.U3(r5, false);     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r5, "slice");     // Catch: Throwable -> L18
        goto L24
    L10:
        r3 = r4;
    L24:
        if ((r7 instanceof LoadingViewHolder) == false) goto L47;
        LoadingViewHolder r10 = (LoadingViewHolder) r7;
        Object r12 = ListProtector.get(this.d, r8);
        if ((r12 instanceof rt0.a) == true) goto L28;
        r12 = null;
    L28:
        rt0.a r13 = (rt0.a) r12;
        TabDataHelper r14 = this.a;
        r10.getClass();
        if (r13 == null) goto L47;
        if (r13.c == false) goto L40;
        TextView r15 = r10.b;
        if (r15 == null) goto L36;
        r15.setText(s1.B(2131922691));
    L36:
        ImageView r16 = r10.c;
        if (r16 == null) goto L39;
        r16.setVisibility(8);
    L39:
        r10.d.setOnClickListener(null);
        goto L47
    L40:
        TextView r17 = r10.b;
        if (r17 == null) goto L43;
        r17.setText(s1.B(2131922692));
    L43:
        ImageView r18 = r10.c;
        if (r18 == null) goto L46;
        r18.setVisibility(0);
    L46:
        r10.d.setOnClickListener(new l(r10, r14));
    L47:
        boolean r19 = r7 instanceof SpaceViewHolder;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        com.bytedance.android.livesdk.dsl.recyclerview.c r0 = this.c;
        if (r0 == null) goto L11;
        this.b.getClass();
        Intrinsics.checkNotNullParameter(r0, "context");
        o r1 = r0.f.a(r5);
        if (r1 != null) goto L7;
        RecyclerView.ViewHolder r2 = null;
    L8:
        if (r2 == null) goto L11;
        return r2;
    L7:
        r2 = new SingleDSLViewHolder(r1, r0);
    L11:
        if (r5 != (-100)) goto L15;
        return new LoadingViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131567193, r4, false));
    L15:
        if (r5 == (-101)) goto L17;
        TextView r6 = new TextView(r4.getContext());
        r6.setLayoutParams(new ViewGroup.LayoutParams(-1, UtilityKotlinExtentionsKt.i(50)));
        r6.setGravity(16);
        r6.setBackgroundColor(ColorProtector.parseColor("#56141567"));
        return new ItemViewHolder(r6);
    L17:
        return new SpaceViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131567194, r4, false));
    }
}
