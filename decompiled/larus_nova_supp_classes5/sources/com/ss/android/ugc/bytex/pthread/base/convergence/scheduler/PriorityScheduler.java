package com.ss.android.ugc.bytex.pthread.base.convergence.scheduler;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.concurrent.Executor;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/PriorityScheduler;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/Scheduler;", "priority", "", "executor", "Ljava/util/concurrent/Executor;", "(ILjava/util/concurrent/Executor;)V", "scheduling", "", EffectConfiguration.KEY_TYPE, "runnable", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/PriorityRunnable;", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class PriorityScheduler implements Scheduler {
    private final Executor executor;
    private final int priority;

    public PriorityScheduler(int r1, Executor r2) {
        this.priority = r1;
        this.executor = r2;
    }

    public boolean scheduling(int r3, PriorityRunnable r4) {
        int r5 = r4.priorityAffinity();
        int r0 = this.priority;
        if (r5 >= r0) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r6 == false) goto L10;
        this.executor.execute(r4);
    L10:
        return r6;
    L5:
        if (r5 >= PriorityProvider.Companion.progressive(r0)) goto L7;
        r6 = true;
        goto L8
    }
}
