package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h0 {
    private final G2OtaHomeCardAction action;
    private final String targetVersion;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r6 = (h0) r5;
        if (Intrinsics.areEqual(this.targetVersion, r6.targetVersion) == true) goto L12;
        return false;
    L12:
        if (this.action == r6.action) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.targetVersion.hashCode() * 31) + this.action.hashCode();
    }

    public final String toString() {
        return "G2OtaHomeCardState(targetVersion=" + this.targetVersion + ", action=" + this.action + ')';
    }

    public final G2OtaHomeCardAction a() {
        return this.action;
    }

    public final String b() {
        return this.targetVersion;
    }

    public h0(String r2, G2OtaHomeCardAction r3) {
        Intrinsics.checkNotNullParameter(r2, "targetVersion");
        Intrinsics.checkNotNullParameter(r3, "action");
        this.targetVersion = r2;
        this.action = r3;
    }
}
