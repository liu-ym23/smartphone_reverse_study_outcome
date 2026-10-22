package com.larus.dora.obric.device_management.device_home;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j2 {
    public final Function0<Long> a;
    public final long b;
    public Long c;

    public final void a() {
        this.c = (Long) this.a.invoke();
    }

    public j2(Function0 r3) {
        Intrinsics.checkNotNullParameter(r3, "elapsedRealtime");
        this.a = r3;
        this.b = 800;
    }
}
