package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SynchronousExecutor implements Executor {
    public SynchronousExecutor() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable r10) {
        r10.run();
    }
}
