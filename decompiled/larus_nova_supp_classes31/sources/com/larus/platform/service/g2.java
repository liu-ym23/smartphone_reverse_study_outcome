package com.larus.platform.service;

import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g2 implements com.larus.platform.api.f1 {
    public static final g2 a = null;
    public static final Lazy b = null;

    public g2() {
    }

    static {
        a = new g2();
        b = LazyKt.lazy(new f2());
    }

    @Override // com.larus.platform.api.f1
    public final int a() {
        com.larus.platform.api.f1 r0 = (com.larus.platform.api.f1) b.getValue();
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.a();
    }

    @Override // com.larus.platform.api.f1
    public final int c() {
        com.larus.platform.api.f1 r0 = (com.larus.platform.api.f1) b.getValue();
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.c();
    }

    @Override // com.larus.platform.api.f1
    public final hq9.q0 d() {
        com.larus.platform.api.f1 r0 = (com.larus.platform.api.f1) b.getValue();
        if (r0 == null) goto L7;
        hq9.q0 r1 = r0.d();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new hq9.q0(-1.0d);
    }

    @Override // com.larus.platform.api.f1
    public final float e() {
        com.larus.platform.api.f1 r0 = (com.larus.platform.api.f1) b.getValue();
        if (r0 != null) goto L7;
        return -1.0f;
    L7:
        return r0.e();
    }

    @Override // com.larus.platform.api.f1
    public final hq9.g3 b(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        com.larus.platform.api.f1 r0 = (com.larus.platform.api.f1) b.getValue();
        if (r0 == null) goto L7;
        hq9.g3 r9 = r0.b(r8);
        if (r9 == null) goto L7;
        return r9;
    L7:
        return new hq9.g3(0, 0, 0);
    }
}
