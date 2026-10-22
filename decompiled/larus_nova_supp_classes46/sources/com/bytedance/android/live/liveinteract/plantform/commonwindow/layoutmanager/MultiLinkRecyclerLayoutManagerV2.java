package com.bytedance.android.live.liveinteract.plantform.commonwindow.layoutmanager;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import pn0.f;
import ug0.a;
import ug0.b;
import yg0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/layoutmanager/MultiLinkRecyclerLayoutManagerV2;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Lug0/a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class MultiLinkRecyclerLayoutManagerV2 extends RecyclerView.LayoutManager implements a {
    public int a;
    public f b;

    @Override // ug0.a
    public final boolean isDynamicAnimating() {
        return false;
    }

    @Override // ug0.a
    public final void setDynamicAnimatorListener(Function0<Unit> r1) {
    }

    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-1, -1);
    }

    public Pair<Integer, Integer> a(int r5) {
        Iterator<T> r0 = this.b.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((f.c) r1).a != r5) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        f.c r2 = (f.c) r1;
        if (r2 != null) goto L17;
        return new Pair(0, 0);
    L17:
        return new Pair(Integer.valueOf(r2.e), Integer.valueOf(r2.f));
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    @Override // ug0.a
    public final Pair<Integer, Integer> c(int r5) {
        Iterator<T> r0 = this.b.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((f.c) r1).a != r5) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        f.c r2 = (f.c) r1;
        if (r2 != null) goto L17;
        return new Pair(0, 0);
    L17:
        return new Pair(Integer.valueOf(r2.c), Integer.valueOf(r2.d));
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    @Override // ug0.a
    public final void e(int r3) {
        ALogger.i("IMultiLinkRVLayoutManager", "updateGuestVisibility: " + r3);
        if (this.a == r3) goto L6;
        this.a = r3;
        requestLayout();
        return;
    }

    public MultiLinkRecyclerLayoutManagerV2(m r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "linkWindowLayoutConfig");
        Intrinsics.checkNotNullParameter(r3, "layoutConfigResult");
        this.b = r3;
    }

    public final void onLayoutChildren(RecyclerView.Recycler r10, RecyclerView.State r11) {
        Intrinsics.checkNotNullParameter(r10, "recycler");
        Intrinsics.checkNotNullParameter(r11, "state");
        if (r11.getItemCount() != 0) goto L6;
        removeAndRecycleAllViews(r10);
        return;
    L6:
        detachAndScrapAttachedViews(r10);
        int r12 = r11.getItemCount();
        if (r12 != 0) goto L9;
        removeAndRecycleAllViews(r10);
        return;
    L9:
        int r1 = 0;
    L10:
        if (r1 >= r12) goto L20;
        View r8 = r10.getViewForPosition(r1);
        Pair<Integer, Integer> r2 = a(r1);
        int r3 = ((Number) r2.component1()).intValue();
        int r4 = ((Number) r2.component2()).intValue();
        r8.getLayoutParams().width = r3;
        r8.getLayoutParams().height = r4;
        addView(r8);
        measureChild(r8, 0, 0);
        Pair<Integer, Integer> r5 = c(r1);
        int r6 = ((Number) r5.component1()).intValue();
        int r7 = ((Number) r5.component2()).intValue();
        layoutDecorated(r8, r6, r7, r6 + getDecoratedMeasuredWidth(r8), r7 + getDecoratedMeasuredHeight(r8));
        if (r1 == 0) goto L14;
        r8.setVisibility(this.a);
    L15:
        r1 = r1 + 1;
        goto L10
    L14:
        r8.setVisibility(0);
        goto L15
    }

    @Override // ug0.a
    public final void U3(m r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "layoutConfig");
        f r0 = r4.d;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        this.b = r0;
        return;
    L5:
        int r1 = b.a;
        Pair r7 = b.b(r4.m(), r4.getUiLayout(), r5, r6);
        Pair r8 = b.a();
        ln0.a r2 = h.a;
        f r9 = h.a(r4, new Triple(r7.getFirst(), r7.getSecond(), "MultiLinkRecyclerLayoutManagerV2#updateLinkWindowLayoutConfig#backup"), r8);
        r4.d = r9;
        this.b = r9;
    }
}
