package com.bytedance.ies.bullet.service.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6010c;
    public final boolean d;

    public u(String r5, int r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r5, "url");
        this.f6008a = r5;
        this.f6009b = r10;
        this.f6010c = r11;
        this.d = r12;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u) == true) goto L8;
        return false;
    L8:
        u r10 = (u) r5;
        String r11 = r10.f6008a;
        if (Intrinsics.areEqual(this.f6008a, r11) == true) goto L12;
        return false;
    L12:
        if (this.f6009b == r10.f6009b) goto L15;
        return false;
    L15:
        if (this.f6010c == r10.f6010c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f6008a.hashCode() * 31;
        int r10 = kn.e.a(k5.d.a(this.f6009b, r5), 31, this.f6010c);
        return Boolean.hashCode(this.d) + r10;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("PreloadImageConfig(url=");
        r5.append(this.f6008a);
        r5.append(", priority=");
        r5.append(this.f6009b);
        r5.append(", serial=");
        r5.append(this.f6010c);
        r5.append(", enableMemory=");
        return androidx.constraintlayout.motion.widget.a.w(r5, this.d, ')');
    }
}
