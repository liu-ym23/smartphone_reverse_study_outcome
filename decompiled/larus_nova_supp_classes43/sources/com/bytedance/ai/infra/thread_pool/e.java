package com.bytedance.ai.infra.thread_pool;

import com.bytedance.common.utility.Logger;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e extends PThreadPoolExecutor {
    public final boolean a;

    /* JADX WARN: Multi-variable type inference failed */
    public final void shutdown() {
        if (this.a == false) goto L6;
        super/*java.util.concurrent.ThreadPoolExecutor*/.shutdown();
        return;
    L6:
        Logger.throwException(new Throwable("Trying to call shutdown() in a persist pool"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<Runnable> shutdownNow() {
        if (this.a == true) goto L5;
        Logger.throwException(new Throwable("Trying to call shutdownNow() in a persist pool"));
        return new ArrayList();
    L5:
        return super/*java.util.concurrent.ThreadPoolExecutor*/.shutdownNow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void afterExecute(Runnable r1, Throwable r10) {
        super/*java.util.concurrent.ThreadPoolExecutor*/.afterExecute(r1, r10);
        c5.c.a(r1, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean awaitTermination(long r10, TimeUnit r11) throws InterruptedException {
        Intrinsics.checkNotNullParameter(r11, "unit");
        if (this.a == true) goto L5;
        Logger.throwException(new Throwable("Trying to call awaitTermination() in a persist pool"));
        return true;
    L5:
        return super/*java.util.concurrent.ThreadPoolExecutor*/.awaitTermination(r10, r11);
    }

    public e(int r10, int r11, TimeUnit r12, BlockingQueue r13, d r14, c5.b r15) {
        super(r10, r11, 30, r12, r13, r14, r15);
        this.a = true;
        this.a = false;
    }

    public e(int r1, int r10, long r11, TimeUnit r12, BlockingQueue r13, d r14) {
        super(r1, r10, r11, r12, r13, r14);
        this.a = true;
        this.a = false;
    }
}
