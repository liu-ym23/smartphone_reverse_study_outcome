package com.ss.android.ugc.bytex.pthread.base.convergence.executor;

import com.ss.android.ugc.bytex.pthread.base.convergence.dredge.IDredgeHandler;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\t\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0096\u0001J\t\u0010\u0012\u001a\u00020\bH\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0096\u0001J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/AdaptiveExecutor;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/IAdaptiveExecutor;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/IResourceExecutor;", "resourceExecutor", "dredgeHandler", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/IDredgeHandler;", "(Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/IResourceExecutor;Lcom/ss/android/ugc/bytex/pthread/base/convergence/dredge/IDredgeHandler;)V", "accepting", "", "executor", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/MigrateExecutor;", "execute", "command", "Ljava/lang/Runnable;", "getInstrumentation", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/Instrumentation;", "migrateTo", "nextMigrant", "notifyMigrated", "prestart", EffectConfiguration.KEY_COUNT, "", "updateAdaptiveRange", "minSize", "maxSize", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class AdaptiveExecutor implements IAdaptiveExecutor, IResourceExecutor {
    private final IDredgeHandler dredgeHandler;
    private final IResourceExecutor resourceExecutor;

    public AdaptiveExecutor(IResourceExecutor r1, IDredgeHandler r2) {
        this.resourceExecutor = r1;
        this.dredgeHandler = r2;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.MigrateExecutor
    public void accepting(MigrateExecutor r2) {
        this.resourceExecutor.accepting(r2);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r2) {
        this.resourceExecutor.execute(r2);
        this.dredgeHandler.requestDredge();
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.IResourceExecutor
    public Instrumentation getInstrumentation() {
        return this.resourceExecutor.getInstrumentation();
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.MigrateExecutor
    public void migrateTo(MigrateExecutor r2) {
        this.resourceExecutor.migrateTo(r2);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.MigrateExecutor
    public Runnable nextMigrant() {
        return this.resourceExecutor.nextMigrant();
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.MigrateExecutor
    public void notifyMigrated() {
        this.resourceExecutor.notifyMigrated();
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.PrestartableExecutor
    public void prestart(int r2) {
        this.resourceExecutor.prestart(r2);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.executor.IAdaptiveExecutor
    public void updateAdaptiveRange(int r2, int r3) {
        this.dredgeHandler.updateAdaptiveRange(r2, r3);
    }
}
