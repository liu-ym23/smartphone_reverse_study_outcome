package com.larus.audio.call;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class n {
    public final String a;
    public final String b;
    public final int c;

    public n() {
        this(null, 7);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L8;
        return false;
    L8:
        n r6 = (n) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c;
    }

    public final String toString() {
        return "SceneModel(key=" + this.a + ", speakerId=" + this.b + ", listenWaitingTime=" + this.c + ')';
    }

    public /* synthetic */ n(String r3, int r4) {
        String r1 = "";
        if ((r4 & 1) == 0) goto L6;
        r3 = "";
    L6:
        if ((r4 & 2) != 0) goto L9;
        r1 = null;
    L9:
        this(r3, r1, 0);
    }

    public n(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "speakerId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
