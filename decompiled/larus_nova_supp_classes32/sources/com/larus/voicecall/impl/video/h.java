package com.larus.voicecall.impl.video;

import android.view.ViewGroup;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h {
    public final int a;
    public final int b;
    public final int[] c;
    public final ViewGroup d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
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
        return (((((this.a * 31) + this.b) * 31) + Arrays.hashCode(this.c)) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "OriginParams(contentOriginWidth=" + this.a + ", contentOriginHeight=" + this.b + ", contentOriginLocation=" + Arrays.toString(this.c) + ", originParent=" + this.d + ')';
    }

    public h(int r2, int r3, int[] r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "contentOriginLocation");
        Intrinsics.checkNotNullParameter(r5, "originParent");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
