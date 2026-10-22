package androidx.arch.core.executor;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class ArchTaskExecutor extends TaskExecutor {
    private static final Executor sIOThreadExecutor = null;
    private static volatile ArchTaskExecutor sInstance;
    private static final Executor sMainThreadExecutor = null;
    private final TaskExecutor mDefaultTaskExecutor;
    private TaskExecutor mDelegate;

    static {
        sMainThreadExecutor = $$Lambda$ArchTaskExecutor$BNyukiANkmKkd3XkhAfbEit2Bs.INSTANCE;
        sIOThreadExecutor = $$Lambda$ArchTaskExecutor$660dvPX9TmFUAes_5pIFbpOEa8M.INSTANCE;
    }

    private ArchTaskExecutor() {
        DefaultTaskExecutor r0 = new DefaultTaskExecutor();
        this.mDefaultTaskExecutor = r0;
        this.mDelegate = r0;
    }

    public static Executor getIOThreadExecutor() {
        return sIOThreadExecutor;
    }

    public static ArchTaskExecutor getInstance() {
        if (sInstance == null) goto L7;
        return sInstance;
    L7:
        monitor-enter(ArchTaskExecutor.class);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (sInstance != null) goto L11;
        sInstance = new ArchTaskExecutor();     // Catch: Throwable -> L14
    L11:
        monitor-exit(ArchTaskExecutor.class);     // Catch: Throwable -> L14
        return sInstance;
    }

    public static Executor getMainThreadExecutor() {
        return sMainThreadExecutor;
    }

    static /* synthetic */ void lambda$static$0(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        getInstance().postToMainThread(r3);
    }

    static /* synthetic */ void lambda$static$1(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        getInstance().executeOnDiskIO(r3);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void executeOnDiskIO(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        this.mDelegate.executeOnDiskIO(r4);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public boolean isMainThread() {
        return this.mDelegate.isMainThread();
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void postToMainThread(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        this.mDelegate.postToMainThread(r4);
    }

    public void setDelegate(TaskExecutor r1) {
        if (r1 != null) goto L4;
        r1 = this.mDefaultTaskExecutor;
    L4:
        this.mDelegate = r1;
    }
}
