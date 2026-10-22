package s1;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class u implements Executor {
    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r8) {
        r8.run();
    }
}
