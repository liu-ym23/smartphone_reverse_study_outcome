package com.larus.reach.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class ReachInappPushPuller$b {
    public final String a;
    public final String b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ReachInappPushPuller$b) == true) goto L8;
        return false;
    L8:
        ReachInappPushPuller$b r6 = (ReachInappPushPuller$b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "PullTask(scene=" + this.a + ", launchSchema=" + this.b + ')';
    }

    public ReachInappPushPuller$b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.a = r2;
        this.b = r3;
    }
}
