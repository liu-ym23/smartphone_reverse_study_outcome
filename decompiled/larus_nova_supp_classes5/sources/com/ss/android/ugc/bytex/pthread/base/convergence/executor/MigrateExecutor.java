package com.ss.android.ugc.bytex.pthread.base.convergence.executor;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0000H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0000H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/MigrateExecutor;", "", "accepting", "", "executor", "migrateTo", "nextMigrant", "Ljava/lang/Runnable;", "notifyMigrated", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public interface MigrateExecutor {
    void accepting(MigrateExecutor r1);

    void migrateTo(MigrateExecutor r1);

    Runnable nextMigrant();

    void notifyMigrated();
}
