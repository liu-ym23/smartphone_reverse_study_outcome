package com.bytedance.ai.multiprocess;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2404b;

    public b(long r5, String r10) {
        this.f2403a = r5;
        this.f2404b = r10;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        long r5 = r11.f2403a;
        if (this.f2403a == r5) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f2404b, r11.f2404b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = Long.hashCode(this.f2403a) * 31;
        String r10 = this.f2404b;
        if (r10 != null) goto L5;
        int r11 = 0;
    L7:
        return r5 + r11;
    L5:
        r11 = r10.hashCode();
        goto L7
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("ForcedPackageVersion(versionCode=");
        r5.append(this.f2403a);
        r5.append(", scmVersion=");
        return j0.p(r5, this.f2404b, ')');
    }
}
