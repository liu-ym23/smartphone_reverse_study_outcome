package com.bytedance.android.live.liveinteract.plantform.commonwindow.layoutmanager;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.n;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ug0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/layoutmanager/MultiLinkWidthFitRecyclerLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Lug0/a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkWidthFitRecyclerLayoutManager extends RecyclerView.LayoutManager implements a {
    public int a;
    public m b;

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

    public MultiLinkWidthFitRecyclerLayoutManager(m r2) {
        Intrinsics.checkNotNullParameter(r2, "linkWindowLayoutConfig");
        this.b = r2;
    }

    @Override // ug0.a
    public final Pair<Integer, Integer> a(int r7) {
        List<m.d> r0 = this.b.h();
        m.d r3 = null;
        Object r4 = null;
        if (r0 == null) goto L14;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L13;
        Object r5 = r1.next();
        if (((m.d) r5).c() != r7) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == false) goto L6;
        r4 = r5;
        goto L13
    L10:
        r6 = false;
    L13:
        r3 = (m.d) r4;
    L14:
        if (r3 == null) goto L16;
        double r2 = r3.d();
        m.c r8 = this.b.d();
        Intrinsics.checkNotNull(r8);
        double r9 = r2 / ((double) r8.c());
        double r10 = r3.b();
        m.c r11 = this.b.d();
        Intrinsics.checkNotNull(r11);
        double r12 = r10 / ((double) r11.b());
        int r13 = n.a;
        int r14 = n.a(this.b.getUiLayout()) * 2;
        int r15 = ((int) (((double) getWidth()) * r9)) - r14;
        int r16 = ((int) (((double) getHeight()) * r12)) - r14;
        return new Pair(Integer.valueOf(r15), Integer.valueOf(r16));
    L16:
        return new Pair(0, 0);
    }

    @Override // ug0.a
    public final Pair<Integer, Integer> c(int r7) {
        List<m.d> r0 = this.b.h();
        m.d r3 = null;
        Object r4 = null;
        if (r0 == null) goto L14;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L13;
        Object r5 = r1.next();
        if (((m.d) r5).c() != r7) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == false) goto L6;
        r4 = r5;
        goto L13
    L10:
        r6 = false;
    L13:
        r3 = (m.d) r4;
    L14:
        if (r3 == null) goto L16;
        double r2 = r3.e();
        m.c r8 = this.b.d();
        Intrinsics.checkNotNull(r8);
        double r9 = r2 / ((double) r8.c());
        double r10 = r3.f();
        m.c r11 = this.b.d();
        Intrinsics.checkNotNull(r11);
        double r12 = r10 / ((double) r11.b());
        int r13 = n.a;
        int r14 = n.a(this.b.getUiLayout());
        int r15 = ((int) (((double) getWidth()) * r9)) + r14;
        int r16 = ((int) (((double) getHeight()) * r12)) + r14;
        return new Pair(Integer.valueOf(r15), Integer.valueOf(r16));
    L16:
        return new Pair(0, 0);
    }

    @Override // ug0.a
    public final void e(int r3) {
        ALogger.i("IMultiLinkRVLayoutManager", "updateGuestVisibility: " + r3);
        if (this.a == r3) goto L6;
        this.a = r3;
        requestLayout();
        return;
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
    public final void U3(m r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "layoutConfig");
        this.b = r1;
    }
}
