package com.bytedance.badger.t;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public a() {
    }

    public static d a(int r1, Object r2, Function1 r3, int r4) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = b.a;
    L8:
        c r5 = new c(r1);
        r3.invoke(r5);
        return r5.a(r2);
    }
}
