package com.bytedance.ai.infra.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends CoroutineDispatcher {
    public final ExecutorService a;

    public a(ExecutorService r10) {
        Intrinsics.checkNotNullParameter(r10, "executor");
        this.a = r10;
    }

    public final CoroutineContext plus(CoroutineContext r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        return super/*kotlin.coroutines.AbstractCoroutineContextElement*/.plus(r10);
    }

    public final void dispatch(CoroutineContext r10, Runnable r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "block");
        this.a.execute(r11);     // Catch: RejectedExecutionException -> L5
        return;
    }
}
