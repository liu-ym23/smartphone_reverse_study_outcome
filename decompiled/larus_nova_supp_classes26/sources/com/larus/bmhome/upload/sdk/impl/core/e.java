package com.larus.bmhome.upload.sdk.impl.core;

import is8.j;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public final ConcurrentHashMap<String, d> a;

    public e() {
        this.a = new ConcurrentHashMap();
    }

    public final void a(String r2, j r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "state");
        d r4 = this.a.get(r2);
        if (r4 == null) goto L8;
        z0<j> r5 = r4.c;
        if (r5 == null) goto L9;
        r5.setValue(r3);
        return;
    L9:
        return;
    }
}
