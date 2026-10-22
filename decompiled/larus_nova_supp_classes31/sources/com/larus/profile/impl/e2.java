package com.larus.profile.impl;

import com.larus.profile.api.bean.LandingTab;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e2 {
    public final String a;
    public final LandingTab b;
    public final Boolean c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e2) == true) goto L8;
        return false;
    L8:
        e2 r6 = (e2) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        Boolean r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "ProfileSelectorData(fragmentTag=" + this.a + ", landingTab=" + this.b + ", isEmpty=" + this.c + ')';
    }

    public e2(String r2, LandingTab r3, Boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "fragmentTag");
        Intrinsics.checkNotNullParameter(r3, "landingTab");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
