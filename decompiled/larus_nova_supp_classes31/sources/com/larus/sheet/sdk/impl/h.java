package com.larus.sheet.sdk.impl;

import ew4.e0;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h implements e0 {
    public h() {
    }

    public final int s() {
        pw9.c r0 = sw9.g.a;
        if (sw9.g.d == false) goto L6;
        return sw9.g.c;
    L6:
        return RangesKt.coerceAtLeast(sw9.g.a().b(), 0);
    }

    public final void j(ew4.a r3) {
        pw9.c r0 = sw9.g.a;
        sw9.g.b = r3;
        if (r3 != null) goto L5;
    L9:
        if (r3 == null) goto L12;
        r3.b(sw9.g.e);
        return;
    L12:
        return;
    L5:
        if (sw9.g.d == false) goto L7;
        int r1 = sw9.g.c;
    L8:
        r3.a(r1);
        goto L9
    L7:
        r1 = RangesKt.coerceAtLeast(sw9.g.a().b(), 0);
        goto L8
    }
}
