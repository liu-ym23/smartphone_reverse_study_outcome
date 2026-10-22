package com.bytedance.ies.bullet.forest;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5420b;

    public t(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "srcUrl");
        this.f5419a = r5;
        this.f5420b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof t) == true) goto L8;
        return false;
    L8:
        t r10 = (t) r5;
        String r11 = r10.f5419a;
        if (Intrinsics.areEqual(this.f5419a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f5420b, r10.f5420b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f5419a.hashCode() * 31;
        String r10 = this.f5420b;
        if (r10 != null) goto L5;
        int r11 = 0;
    L7:
        return r5 + r11;
    L5:
        r11 = r10.hashCode();
        goto L7
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("RequestInfoCacheKey(srcUrl=");
        r5.append(this.f5419a);
        r5.append(", cdnUrl=");
        return j0.p(r5, this.f5420b, ')');
    }
}
