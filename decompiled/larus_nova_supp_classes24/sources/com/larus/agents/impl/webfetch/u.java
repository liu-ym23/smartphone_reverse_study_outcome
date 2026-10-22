package com.larus.agents.impl.webfetch;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class u {
    public static /* synthetic */ void a(AtomicReference r1, t r2) {
    L3:
        if (r1.compareAndSet(r2, null) == true) goto L4;
        if (r1.get() == r2) goto L3;
        return;
    }
}
