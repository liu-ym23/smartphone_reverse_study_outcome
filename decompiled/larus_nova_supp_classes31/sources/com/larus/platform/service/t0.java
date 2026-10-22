package com.larus.platform.service;

import com.larus.platform.api.o2;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class t0 implements o2 {
    public static final t0 a = null;
    public static final Lazy b = null;

    public t0() {
    }

    static {
        a = new t0();
        b = LazyKt.lazy(new s0());
    }

    @Override // com.larus.platform.api.o2
    public final void a() {
        o2 r0 = (o2) b.getValue();
        if (r0 == null) goto L6;
        r0.a();
        return;
    }
}
