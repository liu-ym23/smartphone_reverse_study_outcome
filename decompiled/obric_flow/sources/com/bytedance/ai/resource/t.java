package com.bytedance.ai.resource;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2758b;

    public t(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "accessKey");
        Intrinsics.checkNotNullParameter(r10, "dirName");
        this.f2757a = r5;
        this.f2758b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof t) == true) goto L8;
        return false;
    L8:
        t r10 = (t) r5;
        String r11 = r10.f2757a;
        if (Intrinsics.areEqual(this.f2757a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f2758b, r10.f2758b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f2757a.hashCode() * 31;
        int r10 = kk.a.b(this.f2758b, r5, 31);
        return Boolean.hashCode(true) + r10;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("AppletGeckoConfig(accessKey=");
        r5.append(this.f2757a);
        r5.append(", dirName=");
        return j0.q(r5, this.f2758b, ", isRelative=true)");
    }
}
