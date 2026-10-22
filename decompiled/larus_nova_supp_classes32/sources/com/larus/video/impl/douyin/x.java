package com.larus.video.impl.douyin;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class x {
    public String a;
    public String b;
    public boolean c;
    public int d;
    public int e;

    public x() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof x) == true) goto L8;
        return false;
    L8:
        x r6 = (x) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        int r5 = (r3 + r1) * 31;
        if (this.c == false) goto L13;
        int r6 = 1231;
    L15:
        return ((((r5 + r6) * 31) + this.d) * 31) + this.e;
    L13:
        r6 = 1237;
        goto L15
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "LoadMoreParamsFromVideoSource(search_id=" + this.a + ", query=" + this.b + ", has_more=" + this.c + ", offset=" + this.d + ", limit=" + this.e + ')';
    }

    public x(int r1) {
        this.a = NameKeys.UnloadStrategy_No_Strategy;
        this.b = NameKeys.UnloadStrategy_No_Strategy;
        this.c = false;
        this.d = 0;
        this.e = 1;
    }
}
