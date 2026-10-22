package com.bytedance.ies.bullet.service.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6016c;
    public final boolean d;
    public final String e;
    public final long f;

    public v(String r5, int r10, boolean r11, boolean r12, String r13, long r14) {
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r13, "memoryPriority");
        this.f6014a = r5;
        this.f6015b = r10;
        this.f6016c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof v) == true) goto L8;
        return false;
    L8:
        v r11 = (v) r10;
        String r5 = r11.f6014a;
        if (Intrinsics.areEqual(this.f6014a, r5) == true) goto L12;
        return false;
    L12:
        if (this.f6015b == r11.f6015b) goto L15;
        return false;
    L15:
        if (this.f6016c == r11.f6016c) goto L18;
        return false;
    L18:
        if (this.d == r11.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r11.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f6014a.hashCode() * 31;
        int r10 = kn.e.a(kn.e.a(k5.d.a(this.f6015b, r5), 31, this.f6016c), 31, this.d);
        int r11 = kk.a.b(this.e, r10, 31);
        return Long.hashCode(this.f) + r11;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("PreloadJsConfig(url=");
        r5.append(this.f6014a);
        r5.append(", priority=");
        r5.append(this.f6015b);
        r5.append(", serial=");
        r5.append(this.f6016c);
        r5.append(", enableMemory=");
        r5.append(this.d);
        r5.append(", memoryPriority=");
        r5.append(this.e);
        r5.append(", expire=");
        return androidx.room.jarjarred.org.antlr.runtime.a.t(r5, this.f, ')');
    }
}
