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
import ug0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/layoutmanager/MultiLinkHeightFitRecyclerLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Lug0/a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkHeightFitRecyclerLayoutManager extends RecyclerView.LayoutManager implements a {
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

    public MultiLinkHeightFitRecyclerLayoutManager(m r2) {
        Intrinsics.checkNotNullParameter(r2, "linkWindowLayoutConfig");
        this.b = r2;
    }

    @Override // ug0.a
    public final Pair<Integer, Integer> a(int r13) {
        List<m.d> r0 = this.b.h();
        int r1 = 0;
        m.d r3 = null;
        Object r4 = null;
        if (r0 == null) goto L14;
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L13;
        Object r5 = r2.next();
        if (((m.d) r5).c() != r13) goto L10;
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
        double r7 = r3.d();
        m.c r14 = this.b.d();
        Intrinsics.checkNotNull(r14);
        double r8 = r7 / ((double) r14.c());
        double r9 = r3.b();
        m.c r15 = this.b.d();
        Intrinsics.checkNotNull(r15);
        double r10 = r9 / ((double) r15.b());
        int r16 = n.a;
        int r17 = n.a(this.b.getUiLayout()) * 2;
        int r11 = getHeight();
        m.c r12 = this.b.d();
        Intrinsics.checkNotNull(r12);
        float r18 = r12.c();
        m.c r19 = this.b.d();
        Intrinsics.checkNotNull(r19);
        float r20 = r11 * (r18 / r19.b());
        int r21 = b.a;
        if (b.c(this.b) == false) goto L23;
        if (r3.e() != 0.0d) goto L23;
        r1 = getWidth() - ((int) r20);
    L23:
        return new Pair(Integer.valueOf((((int) (((double) r20) * r8)) - r17) + r1), Integer.valueOf(((int) (((double) r11) * r10)) - r17));
    L16:
        return new Pair(0, 0);
    }

    @Override // ug0.a
    public final Pair<Integer, Integer> c(int r11) {
        List<m.d> r0 = this.b.h();
        m.d r3 = null;
        Object r4 = null;
        if (r0 == null) goto L14;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L13;
        Object r5 = r1.next();
        if (((m.d) r5).c() != r11) goto L10;
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
        double r7 = r3.e();
        m.c r12 = this.b.d();
        Intrinsics.checkNotNull(r12);
        double r8 = r7 / ((double) r12.c());
        double r2 = r3.f();
        m.c r13 = this.b.d();
        Intrinsics.checkNotNull(r13);
        double r9 = r2 / ((double) r13.b());
        int r14 = n.a;
        int r15 = n.a(this.b.getUiLayout());
        int r10 = getHeight();
        m.c r16 = this.b.d();
        Intrinsics.checkNotNull(r16);
        float r17 = r16.c();
        m.c r18 = this.b.d();
        Intrinsics.checkNotNull(r18);
        float r19 = r10 * (r17 / r18.b());
        int r20 = b.a;
        if (b.c(this.b) == false) goto L20;
        int r21 = getWidth() - ((int) r19);
    L21:
        int r22 = Math.max(0, (((int) (((double) r19) * r8)) + r15) + r21);
        int r110 = Math.max(0, ((int) (((double) r10) * r9)) + r15);
        ALogger.i("IMultiLinkRVLayoutManager", "getChildViewAnchorPoint=" + r22 + " x " + r110 + " & width=" + getWidth() + " & isAspectFillAndRightAlign=" + b.c(this.b));
        this.b.getClass();
        return new Pair(Integer.valueOf(r22), Integer.valueOf(r110));
    L20:
        r21 = 0;
        goto L21
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
