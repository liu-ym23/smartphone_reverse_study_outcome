package com.obric.oui.indicator;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/indicator/IndicatorViewportState;", "", "totalCount", "", "selectedIndex", "visibleRange", "Lkotlin/ranges/IntRange;", "(IILkotlin/ranges/IntRange;)V", "getSelectedIndex", "()I", "getTotalCount", "getVisibleRange", "()Lkotlin/ranges/IntRange;", "component1", "component2", "component3", "copy", "dotVisualStateAt", "Lcom/obric/oui/indicator/IndicatorDotVisualState;", "index", "equals", "", "other", "hashCode", "isVisible", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f13955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13956b;
    private final IntRange c;

    public c(int r2, int r3, IntRange r4) {
        Intrinsics.checkNotNullParameter(r4, "visibleRange");
        this.f13955a = r2;
        this.f13956b = r3;
        this.c = r4;
    }

    public final int a() {
        return this.f13955a;
    }

    public final IndicatorDotVisualState a(int r6) {
        IntRange r0 = this.c;
        int r1 = r0.getFirst();
        boolean r3 = true;
        if (r6 > r0.getLast()) goto L6;
        if (r1 > r6) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L11;
        return IndicatorDotVisualState.HIDDEN;
    L11:
        if (r6 != this.f13956b) goto L15;
        return IndicatorDotVisualState.ACTIVE;
    L15:
        if (r6 == r0.getFirst()) goto L17;
    L19:
        boolean r4 = false;
    L21:
        if (r6 == r0.getLast()) goto L23;
    L25:
        r3 = false;
    L26:
        if (r4 == true) goto L31;
        if (r3 == true) goto L31;
        return IndicatorDotVisualState.NORMAL;
    L31:
        return IndicatorDotVisualState.EDGE;
    L23:
        if (r0.getLast() >= (this.f13955a - 1)) goto L25;
    L17:
        if (r0.getFirst() <= 0) goto L19;
        r4 = true;
    L6:
        r2 = false;
        goto L7
    }

    public final IntRange b() {
        return this.c;
    }

    public final boolean b(int r3) {
        IntRange r2 = this.c;
        int r0 = r2.getFirst();
        if (r3 > r2.getLast()) goto L7;
        if (r0 > r3) goto L8;
        return true;
    L8:
        return false;
    L7:
        return false;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
        if (this.f13955a == r6.f13955a) goto L12;
        return false;
    L12:
        if (this.f13956b == r6.f13956b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f13955a) * 31) + Integer.hashCode(this.f13956b)) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "IndicatorViewportState(totalCount=" + this.f13955a + ", selectedIndex=" + this.f13956b + ", visibleRange=" + this.c + ')';
    }
}
