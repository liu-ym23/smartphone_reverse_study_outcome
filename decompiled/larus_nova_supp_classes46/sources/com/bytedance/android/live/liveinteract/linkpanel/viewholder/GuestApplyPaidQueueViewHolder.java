package com.bytedance.android.live.liveinteract.linkpanel.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.linkpanel.view.PaidQueueTabView;
import com.bytedance.android.live.liveinteract.linkpanel.viewbinder.ApplyTitlePanelType;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/viewholder/GuestApplyPaidQueueViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GuestApplyPaidQueueViewHolder extends RecyclerView.ViewHolder {
    public final boolean a;
    public final Function1<Integer, Unit> b;
    public final Function1<Integer, Unit> c;

    public final void T3(final int r4, final ApplyTitlePanelType r5, final Pair<Integer, Integer> r6) {
        Intrinsics.checkNotNullParameter(r5, "panelType");
        Intrinsics.checkNotNullParameter(r6, "pair");
        Object r0 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r0 instanceof PaidQueueTabView) == true) goto L5;
        r0 = null;
    L5:
        PaidQueueTabView r1 = (PaidQueueTabView) r0;
        if (r1 == null) goto L28;
        r1.setTabOnClickListener(new GuestApplyPaidQueueViewHolder$bindView$$inlined$apply$lambda$1(this, r5, r4, r6));
        r1.setPanelType(r5);
        r1.setDefaultTab(r4);
        boolean r2 = true;
        r1.setQueueSortTypeVisibility(!this.a);
        r1.setApplyUserCount(r6);
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == true) goto L10;
        return;
    L10:
        if (o.c() == 4) goto L13;
        r2 = false;
    L13:
        if (r2 == true) goto L30;
        r1.setSortOnClickListener(this.c);
        if (r4 != 2) goto L20;
        View r7 = r1.e;
        if (r7 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mSortContainer");
    L19:
        r7.setVisibility(8);
        return;
    L20:
        View r8 = r1.e;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mSortContainer");
    L23:
        r8.setVisibility(0);
        TextView r9 = r1.f;
        if (r9 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mSortSwitchText");
    L26:
        r9.setText(r1.T5(r1.m.intValue()));
        return;
    L30:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuestApplyPaidQueueViewHolder(View r2, boolean r3, Function1<? super Integer, Unit> r4, Function1<? super Integer, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.a = r3;
        this.b = r4;
        this.c = r5;
    }
}
