package androidx.core.os;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class b implements Executor {
    public /* synthetic */ b() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r1) {
        Profiling.registerForAllProfilingResults.1.c(r1);
    }
}
