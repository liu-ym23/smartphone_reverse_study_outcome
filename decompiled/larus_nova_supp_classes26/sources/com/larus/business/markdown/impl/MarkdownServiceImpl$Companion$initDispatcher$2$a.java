package com.larus.business.markdown.impl;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class MarkdownServiceImpl$Companion$initDispatcher$2$a extends CoroutineDispatcher {
    public MarkdownServiceImpl$Companion$initDispatcher$2$a() {
    }

    public final void dispatch(CoroutineContext r3, Runnable r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "block");
        PthreadThreadV2 r5 = new PthreadThreadV2(r4, "md-init-Thread-" + MarkdownServiceImpl.access$getThreadCounter$cp().getAndIncrement());
        r5.setDaemon(true);
        ThreadMethodProxy.start(r5);
    }
}
