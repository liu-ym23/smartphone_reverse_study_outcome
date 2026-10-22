package com.larus.platform.service;

import com.larus.platform.api.b4;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class s2 implements com.larus.platform.api.u3 {
    public static final s2 a = null;
    public static final Lazy b = null;

    public s2() {
    }

    static {
        a = new s2();
        b = LazyKt.lazy(new r2());
    }

    @Override // com.larus.platform.api.u3
    public final b4 a(mr9.j r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
        com.larus.platform.api.u3 r0 = (com.larus.platform.api.u3) b.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(r2);
    }

    @Override // com.larus.platform.api.u3
    public final b4 b(mr9.j r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
        com.larus.platform.api.u3 r0 = (com.larus.platform.api.u3) b.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b(r2);
    }
}
