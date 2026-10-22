package com.bytedance.ies.bullet.service.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6005c;
    public final boolean d;
    public final long e;

    public s(String r5, int r10, boolean r11, boolean r12, long r13) {
        Intrinsics.checkNotNullParameter(r5, "url");
        this.f6003a = r5;
        this.f6004b = r10;
        this.f6005c = r11;
        this.d = r12;
        this.e = r13;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof s) == true) goto L8;
        return false;
    L8:
        s r11 = (s) r10;
        String r5 = r11.f6003a;
        if (Intrinsics.areEqual(this.f6003a, r5) == true) goto L12;
        return false;
    L12:
        if (this.f6004b == r11.f6004b) goto L15;
        return false;
    L15:
        if (this.f6005c == r11.f6005c) goto L18;
        return false;
    L18:
        if (this.d == r11.d) goto L21;
        return false;
    L21:
        if (this.e == r11.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f6003a.hashCode() * 31;
        int r10 = kn.e.a(kn.e.a(k5.d.a(this.f6004b, r5), 31, this.f6005c), 31, this.d);
        return Long.hashCode(this.e) + r10;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("PreloadFontConfig(url=");
        r5.append(this.f6003a);
        r5.append(", priority=");
        r5.append(this.f6004b);
        r5.append(", serial=");
        r5.append(this.f6005c);
        r5.append(", enableMemory=");
        r5.append(this.d);
        r5.append(", expire=");
        return androidx.room.jarjarred.org.antlr.runtime.a.t(r5, this.e, ')');
    }
}
