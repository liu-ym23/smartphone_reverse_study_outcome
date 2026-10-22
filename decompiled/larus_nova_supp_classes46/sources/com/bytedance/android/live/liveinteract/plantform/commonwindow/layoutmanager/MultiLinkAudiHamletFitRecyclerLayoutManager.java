package com.bytedance.android.live.liveinteract.plantform.commonwindow.layoutmanager;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/layoutmanager/MultiLinkAudiHamletFitRecyclerLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Lug0/a;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkAudiHamletFitRecyclerLayoutManager extends RecyclerView.LayoutManager implements ug0.a {
    public int a;
    public m b;

    public static final class a {
    }

    static {
    }

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

    public MultiLinkAudiHamletFitRecyclerLayoutManager(m r2) {
        Intrinsics.checkNotNullParameter(r2, "linkWindowLayoutConfig");
        this.b = r2;
    }

    @Override // ug0.a
    public final Pair<Integer, Integer> a(int r7) {
        List<m.d> r0 = this.b.h();
        Object r1 = null;
        if (r0 == null) goto L14;
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L13;
        Object r4 = r2.next();
        if (((m.d) r4).c() != r7) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == false) goto L6;
        r1 = r4;
        goto L13
    L10:
        r5 = false;
    L13:
        r1 = (m.d) r1;
    L14:
        if (r1 == null) goto L16;
        int r3 = getHeight();
        int r6 = getWidth();
        if (r7 == 0) goto L20;
        int r8 = (int) (r3 * 0.093023255f);
        return new Pair(Integer.valueOf(r8), Integer.valueOf(r8));
    L20:
        return new Pair(Integer.valueOf(r6), Integer.valueOf(r3));
    L16:
        return new Pair(0, 0);
    }

    @Override // ug0.a
    public final Pair<Integer, Integer> c(int r9) {
        List<m.d> r0 = this.b.h();
        if (r0 == null) goto L11;
        int r1 = r0.size();
        if (r9 == 0) goto L7;
        float r2 = getHeight();
        float r4 = 0.046511628f * r2;
        float r3 = ((r2 - (2 * r4)) - ((0.023255814f * r2) * (r1 - 2))) / (r1 - 1);
        float r5 = getWidth();
        float r10 = r9 - 1;
        return new Pair(Integer.valueOf((int) ((r5 - r3) - (0.064257026f * r5))), Integer.valueOf((int) ((r4 + (r3 * r10)) + ((r10 * 0.023255814f) * r2))));
    L7:
        return new Pair(0, 0);
    L11:
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
