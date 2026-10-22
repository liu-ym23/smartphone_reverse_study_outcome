package com.ss.android.lark.image.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public int a;
    public String b;
    public int c;
    public int d;
    public int e;
    public int f;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "resultCode:" + this.a + ",errorMsg:" + this.b + ",latency:" + this.c + ",size:" + this.d + ",width:" + this.e + ",height:" + this.f;
    }

    public d(int r3, String r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r4 = "";
    L8:
        Intrinsics.checkNotNullParameter(r4, "errorMsg");
        this.a = r3;
        this.b = r4;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
    }
}
