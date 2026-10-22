package com.bytedance.android.live.liveinteract.utils;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k0 {
    public String a;
    public long b;
    public long c;
    public boolean d;

    public k0() {
    }

    public final void b() {
        this.a = null;
        this.b = 0;
        this.c = 0;
    }

    public final void a(String[] r5, int[] r6) {
        String r0 = this.a;
        if (r0 == null) goto L25;
        if (r5 == null) goto L26;
        if (r6 != null) goto L7;
        return;
    L7:
        if (r5.length != r6.length) goto L30;
        Integer r7 = Integer.valueOf(ArraysKt.indexOf(r5, r0));
        if (r7.intValue() == (-1)) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == true) goto L16;
        r7 = null;
    L16:
        if (r7 != null) goto L18;
        return;
    L18:
        if (j22.c.c(r6[r7.intValue()], this.d) > 0) goto L20;
        this.c = 0;
        return;
    L20:
        if (this.c <= 0) goto L22;
        this.b += System.currentTimeMillis() - this.c;
    L22:
        this.c = System.currentTimeMillis();
        return;
    L12:
        r1 = false;
        goto L13
    L30:
        return;
    L26:
        return;
    }

    public final void c(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "interactId");
        this.a = r3;
        this.b = 0;
        this.c = 0;
        this.d = r4;
    }
}
