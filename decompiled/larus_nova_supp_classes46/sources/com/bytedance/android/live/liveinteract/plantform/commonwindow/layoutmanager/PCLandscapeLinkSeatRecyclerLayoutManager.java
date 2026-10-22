package com.bytedance.android.live.liveinteract.plantform.commonwindow.layoutmanager;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.n;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.o;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ug0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/layoutmanager/PCLandscapeLinkSeatRecyclerLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Lug0/a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PCLandscapeLinkSeatRecyclerLayoutManager extends RecyclerView.LayoutManager implements a {
    public float a;
    public float b;
    public o c;
    public boolean d;
    public int e;
    public m f;

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

    public final void p() {
        if (this.a > 0.0f) goto L5;
    L6:
        this.d = false;
        this.a = getWidth();
        this.b = this.f.s(getWidth(), getHeight());
        int r0 = n.a;
        this.c = n.b(this.f, getWidth(), getHeight());
        return;
    L5:
        if (this.d == true) goto L6;
    }

    public PCLandscapeLinkSeatRecyclerLayoutManager(m r2) {
        Intrinsics.checkNotNullParameter(r2, "linkWindowLayoutConfig");
        this.f = r2;
    }

    @Override // ug0.a
    public final Pair<Integer, Integer> a(int r8) {
        List<m.d> r0 = this.f.h();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.size();
    L6:
        m.d r4 = null;
        Object r5 = null;
        m.e r6 = null;
        Object r7 = null;
        if (r8 < r2) goto L30;
        int r9 = r8 - r2;
        List<m.e> r3 = this.f.k();
        if (r3 == null) goto L20;
        Iterator<T> r10 = r3.iterator();
    L12:
        if (r10.hasNext() == false) goto L19;
        Object r11 = r10.next();
        if (((m.e) r11).c() != r9) goto L16;
        boolean r12 = true;
    L17:
        if (r12 == false) goto L12;
        r5 = r11;
        goto L19
    L16:
        r12 = false;
    L19:
        r6 = (m.e) r5;
    L20:
        if (r6 == null) goto L56;
        p();
        o r13 = this.c;
        if (r13 == null) goto L25;
        int r14 = r13.c;
    L26:
        if (r13 == null) goto L28;
        r1 = r13.d;
    L28:
        int r15 = (int) (((double) r14) * r6.d());
        int r16 = (int) (((double) r1) * r6.b());
        return new Pair(Integer.valueOf(r15), Integer.valueOf(r16));
    L25:
        r14 = 0;
        goto L26
    L56:
        return new Pair(0, 0);
    L30:
        List<m.d> r17 = this.f.h();
        if (r17 == null) goto L42;
        Iterator<T> r18 = r17.iterator();
    L34:
        if (r18.hasNext() == false) goto L41;
        Object r19 = r18.next();
        if (((m.d) r19).c() != r8) goto L38;
        boolean r20 = true;
    L39:
        if (r20 == false) goto L34;
        r7 = r19;
        goto L41
    L38:
        r20 = false;
    L41:
        r4 = (m.d) r7;
    L42:
        if (r4 == null) goto L57;
        p();
        double r21 = r4.d();
        m.c r22 = this.f.d();
        Intrinsics.checkNotNull(r22);
        double r23 = r21 / ((double) r22.c());
        double r24 = r4.b();
        m.c r25 = this.f.d();
        Intrinsics.checkNotNull(r25);
        double r26 = r24 / ((double) r25.b());
        int r27 = (int) (((double) this.a) * r23);
        int r28 = (int) (((double) this.b) * r26);
        return new Pair(Integer.valueOf(r27), Integer.valueOf(r28));
    L57:
        return new Pair(0, 0);
    L5:
        r2 = 0;
        goto L6
    }

    @Override // ug0.a
    public final Pair<Integer, Integer> c(int r10) {
        List<m.d> r0 = this.f.h();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.size();
    L6:
        m.d r4 = null;
        Object r5 = null;
        m.e r6 = null;
        Object r7 = null;
        if (r10 < r2) goto L36;
        int r11 = r10 - r2;
        List<m.e> r3 = this.f.k();
        if (r3 == null) goto L20;
        Iterator<T> r8 = r3.iterator();
    L12:
        if (r8.hasNext() == false) goto L19;
        Object r9 = r8.next();
        if (((m.e) r9).c() != r11) goto L16;
        boolean r12 = true;
    L17:
        if (r12 == false) goto L12;
        r5 = r9;
        goto L19
    L16:
        r12 = false;
    L19:
        r6 = (m.e) r5;
    L20:
        if (r6 == null) goto L62;
        p();
        o r13 = this.c;
        if (r13 == null) goto L25;
        int r14 = r13.c;
    L26:
        if (r13 == null) goto L28;
        int r15 = r13.d;
    L29:
        if (r13 == null) goto L31;
        int r16 = r13.a;
    L32:
        if (r13 == null) goto L34;
        r1 = r13.b;
    L34:
        int r17 = (int) ((((double) r14) * r6.e()) + ((double) r16));
        int r18 = (int) ((((double) r15) * r6.f()) + ((double) r1));
        return new Pair(Integer.valueOf(r17), Integer.valueOf(r18));
    L31:
        r16 = 0;
        goto L32
    L28:
        r15 = 0;
        goto L29
    L25:
        r14 = 0;
        goto L26
    L62:
        return new Pair(0, 0);
    L36:
        List<m.d> r19 = this.f.h();
        if (r19 == null) goto L48;
        Iterator<T> r20 = r19.iterator();
    L40:
        if (r20.hasNext() == false) goto L47;
        Object r21 = r20.next();
        if (((m.d) r21).c() != r10) goto L44;
        boolean r22 = true;
    L45:
        if (r22 == false) goto L40;
        r7 = r21;
        goto L47
    L44:
        r22 = false;
    L47:
        r4 = (m.d) r7;
    L48:
        if (r4 == null) goto L63;
        p();
        double r23 = r4.e();
        m.c r110 = this.f.d();
        Intrinsics.checkNotNull(r110);
        double r24 = r23 / ((double) r110.c());
        double r25 = r4.f();
        m.c r111 = this.f.d();
        Intrinsics.checkNotNull(r111);
        double r26 = r25 / ((double) r111.b());
        int r112 = (int) (((double) this.a) * r24);
        int r27 = (int) (((double) this.b) * r26);
        return new Pair(Integer.valueOf(r112), Integer.valueOf(r27));
    L63:
        return new Pair(0, 0);
    L5:
        r2 = 0;
        goto L6
    }

    @Override // ug0.a
    public final void e(int r3) {
        ALogger.i("IMultiLinkRVLayoutManager", "updateGuestVisibility: " + r3);
        if (this.e == r3) goto L6;
        this.e = r3;
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
        r8.setVisibility(this.e);
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
        this.f = r1;
    }
}
