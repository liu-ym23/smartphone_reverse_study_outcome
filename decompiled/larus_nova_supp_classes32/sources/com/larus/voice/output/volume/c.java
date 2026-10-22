package com.larus.voice.output.volume;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public final int a;
    public final boolean b;
    public final String c;
    public final Map<String, String> d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (((r0 + r1) * 31) + this.c.hashCode()) * 31;
        Map<String, String> r3 = this.d;
        if (r3 != null) goto L9;
        int r4 = 0;
    L11:
        return r2 + r4;
    L9:
        r4 = r3.hashCode();
        goto L11
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ZeroVolumeHandlerContext(strategyId=" + this.a + ", enableAutoPlayToast=" + this.b + ", scene=" + this.c + ", bizExt=" + this.d + ')';
    }

    public c(int r2, boolean r3, String r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
