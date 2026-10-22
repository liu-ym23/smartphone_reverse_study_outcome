package com.larus.bmhome.bigimg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n1 {
    public final String a;
    public final t1 b;
    public final String c;
    public final String d;
    public final String e;
    public final Long f;
    public final Long g;

    public n1(String r9) {
        this(r9, null, r9, r9, r9, null, null);
    }

    public n1(String r10, t1 r11) {
        Intrinsics.checkNotNullParameter(r11, "mediaItem");
        this(r10, r11, r10, r10, r10, null, null);
    }

    public n1(String r9, String r10) {
        this(r9, null, r10, null, null, null, null);
    }

    public /* synthetic */ n1(String r9, String r10, String r11, String r12, Long r13, Long r14) {
        this(r9, null, r10, r11, r12, r13, r14);
    }

    public n1(String r1, t1 r2, String r3, String r4, String r5, Long r6, Long r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
