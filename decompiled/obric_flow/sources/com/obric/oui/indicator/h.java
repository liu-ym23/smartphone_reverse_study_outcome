package com.obric.oui.indicator;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IntRange f13481c;

    public h(int r5, int r10, IntRange r11) {
        Intrinsics.checkNotNullParameter(r11, "visibleRange");
        this.f13479a = r5;
        this.f13480b = r10;
        this.f13481c = r11;
    }

    public final boolean a(int r5) {
        IntRange r10 = this.f13481c;
        int r11 = r10.getFirst();
        if (r5 > r10.getLast()) goto L7;
        if (r11 > r5) goto L8;
        return true;
    L8:
        return false;
    L7:
        return false;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r10 = (h) r5;
        int r11 = r10.f13479a;
        if (this.f13479a == r11) goto L12;
        return false;
    L12:
        if (this.f13480b == r10.f13480b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f13481c, r10.f13481c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = Integer.hashCode(this.f13479a) * 31;
        int r10 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f13480b, r5, 31);
        return this.f13481c.hashCode() + r10;
    }

    public final String toString() {
        return "IndicatorViewportState(totalCount=" + this.f13479a + ", selectedIndex=" + this.f13480b + ", visibleRange=" + this.f13481c + ')';
    }
}
