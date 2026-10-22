package io.reactivex.internal.schedulers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes6.dex */
public final class ScheduledDirectTask extends AbstractDirectTask implements Callable<Void> {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectTask(Runnable r3) {
        super((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Void call() {
        return call2();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public Void call2() {
        this.runner = Thread.currentThread();
        this.runnable.run();     // Catch: Throwable -> L6
        lazySet(FINISHED);
        this.runner = null;
        return null;
    L6:
        th = move-exception;
        lazySet(FINISHED);
        this.runner = null;
        throw th;
    }

    @Override // io.reactivex.internal.schedulers.AbstractDirectTask
    public /* bridge */ /* synthetic */ Runnable getWrappedRunnable() {
        return super.getWrappedRunnable();
    }
}
