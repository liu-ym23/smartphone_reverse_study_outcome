package com.lynx.tasm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class r0 {
    public final int a;
    public final String b;
    public final String c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final Map<String, a8a.a> h;
    public final long i;
    public final long j;
    public final String k;

    public r0(int r5, String r6, long r7, long r9, long r11, long r13, Map r15, long r16, long r18, String r20) {
        this.a = r5;
        this.b = null;
        this.c = r6;
        this.d = r7;
        this.e = r9;
        this.f = r11;
        this.g = r13;
        if (r15 != null) goto L5;
    L8:
        this.h = Collections.emptyMap();
    L9:
        this.i = r16;
        this.j = r18;
        this.k = r20;
        return;
    L5:
        if (r15.isEmpty() == true) goto L8;
        this.h = Collections.unmodifiableMap(new HashMap(r15));
        goto L9
    }
}
