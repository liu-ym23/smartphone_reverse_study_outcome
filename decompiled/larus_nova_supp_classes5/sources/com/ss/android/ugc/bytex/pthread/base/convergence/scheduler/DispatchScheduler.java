package com.ss.android.ugc.bytex.pthread.base.convergence.scheduler;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/DispatchScheduler;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/Scheduler;", "schedulers", "", "([Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/Scheduler;)V", "[Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/Scheduler;", "scheduling", "", EffectConfiguration.KEY_TYPE, "", "runnable", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/PriorityRunnable;", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class DispatchScheduler implements Scheduler {
    private final Scheduler[] schedulers;

    public DispatchScheduler(Scheduler[] r1) {
        this.schedulers = r1;
    }

    public boolean scheduling(int r5, PriorityRunnable r6) {
        Scheduler[] r0 = this.schedulers;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        if (r0[r2].scheduling(r5, r6) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L10:
        throw new RuntimeException("the runnable scheduling fail: " + r6);
    }
}
