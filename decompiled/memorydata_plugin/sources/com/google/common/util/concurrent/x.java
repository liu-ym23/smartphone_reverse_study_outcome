package com.google.common.util.concurrent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public final class x {
    public static <V> V a(Future<V> r2) {
        Future r3 = (Future) ZeusTransformUtils.wrapperContextForParams(r2, Future.class, "com.obric.memorydata.plugin");
        boolean r0 = false;
    L12:
        V r4 = (V) r3.get();
    L4:
        if (r0 == false) goto L6;
        Thread.currentThread().interrupt();
    L6:
        return r4;
    L11:
        r0 = true;
    L7:
        th = move-exception;
        if (r0 == false) goto L10;
        Thread.currentThread().interrupt();
    L10:
        throw th;
    }
}
