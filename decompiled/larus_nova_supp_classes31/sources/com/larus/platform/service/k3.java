package com.larus.platform.service;

import com.larus.platform.api.a4;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k3 implements a4 {
    public static final k3 a = null;
    public static final Lazy b = null;

    public k3() {
    }

    static {
        a = new k3();
        b = LazyKt.lazy(new j3());
    }

    @Override // com.larus.platform.api.a4
    public final boolean isInitialized() {
        a4 r0 = (a4) b.getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isInitialized();
    }

    @Override // com.larus.platform.api.a4
    public final void a(String r2, String r3, Function2<? super String, ? super String, Unit> r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "contentProducer");
        Intrinsics.checkNotNullParameter(r3, "contentPropagator");
        Intrinsics.checkNotNullParameter(r4, "monitorLogSend");
        Intrinsics.checkNotNullParameter(r5, "onInitFinished");
        a4 r0 = (a4) b.getValue();
        if (r0 != null) goto L6;
        r5.invoke();
        return;
    L6:
        r0.a(r2, r3, r4, r5);
    }
}
