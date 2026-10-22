package com.larus.platform.service;

import com.lynx.lottieadapter.LottieAdapterView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class n1 implements com.larus.platform.api.s0 {
    public static final n1 a = null;
    public static final Lazy b = null;

    public n1() {
    }

    static {
        a = new n1();
        b = LazyKt.lazy(new m1());
    }

    @Override // com.larus.platform.api.s0
    public final void a(LottieAdapterView r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        com.larus.platform.api.s0 r0 = (com.larus.platform.api.s0) b.getValue();
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }
}
