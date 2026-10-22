package com.larus.platform.exp;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new f());
    }

    public static boolean a() {
        Lazy r0 = a;
        if (((kq9.n) r0.getValue()).a() == false) goto L5;
    L8:
        return true;
    L5:
        if (((kq9.n) r0.getValue()).b() == true) goto L8;
        return false;
    }
}
