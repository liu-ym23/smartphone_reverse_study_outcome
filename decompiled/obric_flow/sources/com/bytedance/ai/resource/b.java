package com.bytedance.ai.resource;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2564c;
    public final String d;

    public b(int r5, long r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "sessionId");
        this.f2562a = r10;
        this.f2563b = r11;
        this.f2564c = r5;
        this.d = r12;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        long r5 = r11.f2562a;
        if (this.f2562a == r5) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f2563b, r11.f2563b) == true) goto L15;
        return false;
    L15:
        if (this.f2564c == r11.f2564c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r5 = Long.hashCode(this.f2562a) * 31;
        String r10 = this.f2563b;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r5 + r11) * 31;
        int r13 = k5.d.a(this.f2564c, r12);
        return this.d.hashCode() + r13;
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("PackageRuntimeInfo(versionCode=");
        r5.append(this.f2562a);
        r5.append(", scmVersion=");
        r5.append(this.f2563b);
        r5.append(", useCount=");
        r5.append(this.f2564c);
        r5.append(", sessionId=");
        return j0.p(r5, this.d, ')');
    }
}
