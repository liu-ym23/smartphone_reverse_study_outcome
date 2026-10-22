package com.larus.platform.service;

import com.larus.platform.api.q2;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class v0 implements q2 {
    public static final v0 a = null;
    public static final Lazy b = null;

    public v0() {
    }

    static {
        a = new v0();
        b = LazyKt.lazy(new u0());
    }

    @Override // com.larus.platform.api.q2
    public final String a() {
        q2 r0 = (q2) b.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    @Override // com.larus.platform.api.q2
    public final boolean b() {
        q2 r0 = (q2) b.getValue();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.b() != true) goto L7;
        return true;
    }
}
