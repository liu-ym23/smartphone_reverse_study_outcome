package com.google.common.util.concurrent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class s {
    public static Executor a() {
        return DirectExecutor.INSTANCE;
    }

    static Executor a(Executor r2, final a<?> r3) {
        final Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r2, Executor.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        com.google.common.base.n.a(r3);
        if (r4 != a()) goto L6;
        return r4;
    L6:
        return new AnonymousClass1(r4, r3);
    }
}
