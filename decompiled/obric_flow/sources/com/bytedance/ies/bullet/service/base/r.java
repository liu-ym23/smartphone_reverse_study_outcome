package com.bytedance.ies.bullet.service.base;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f5990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f5991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f5992c;
    public final ArrayList d;
    public final ArrayList e;

    public r(ArrayList r5, ArrayList r10, ArrayList r11, ArrayList r12, ArrayList r13) {
        this.f5990a = r5;
        this.f5991b = r10;
        this.f5992c = r11;
        this.d = r12;
        this.e = r13;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r) == true) goto L8;
        return false;
    L8:
        r r10 = (r) r5;
        ArrayList r11 = r10.f5990a;
        if (Intrinsics.areEqual(this.f5990a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f5991b, r10.f5991b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f5992c, r10.f5992c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f5990a.hashCode() * 31;
        int r10 = (this.f5991b.hashCode() + r5) * 31;
        int r11 = (this.f5992c.hashCode() + r10) * 31;
        int r12 = (this.d.hashCode() + r11) * 31;
        return this.e.hashCode() + r12;
    }

    public final String toString() {
        return "PreloadConfig(geckoChannel=" + this.f5990a + ", image=" + this.f5991b + ", font=" + this.f5992c + ", video=" + this.d + ", js=" + this.e + ')';
    }
}
