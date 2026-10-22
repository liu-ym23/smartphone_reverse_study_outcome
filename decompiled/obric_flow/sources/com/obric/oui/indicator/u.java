package com.obric.oui.indicator;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f13511c;

    public u(int r5, int r10, float r11) {
        this.f13509a = r5;
        this.f13510b = r10;
        this.f13511c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u) == true) goto L8;
        return false;
    L8:
        u r10 = (u) r5;
        int r11 = r10.f13509a;
        if (this.f13509a == r11) goto L12;
        return false;
    L12:
        if (this.f13510b == r10.f13510b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(Float.valueOf(this.f13511c), Float.valueOf(r10.f13511c)) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = Integer.hashCode(this.f13509a) * 31;
        int r10 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f13510b, r5, 31);
        return Float.hashCode(this.f13511c) + r10;
    }

    public final String toString() {
        return "ScrollState(selectedPosition=" + this.f13509a + ", nextPosition=" + this.f13510b + ", positionOffset=" + this.f13511c + ')';
    }
}
