package com.larus.video.impl.sdk;

import com.larus.platform.api.z3;
import com.larus.platform.service.q3;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j implements com.larus.platform.api.b {
    public j() {
    }

    public final void a(com.larus.platform.api.c r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public final void b(com.larus.platform.api.c r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Lazy r3 = q3.a;
        z3 r4 = q3.a();
        if (r4 == null) goto L6;
        r4.n(null);
        return;
    }
}
