package com.larus.platform.service;

import com.larus.platform.api.o1;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i implements o1 {
    public static final i a = null;
    public static final Lazy b = null;

    public i() {
    }

    static {
        a = new i();
        b = LazyKt.lazy(new h());
    }

    @Override // com.larus.platform.api.o1
    public final boolean a() {
        o1 r0 = (o1) b.getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a();
    }

    @Override // com.larus.platform.api.o1
    public final int b() {
        o1 r0 = (o1) b.getValue();
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.b();
    }
}
