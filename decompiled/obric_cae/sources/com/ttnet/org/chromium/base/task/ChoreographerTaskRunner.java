package com.ttnet.org.chromium.base.task;

import android.view.Choreographer;

/* JADX INFO: loaded from: classes2.dex */
final class ChoreographerTaskRunner implements SingleThreadTaskRunner {
    private final Choreographer mChoreographer;

    public ChoreographerTaskRunner(Choreographer r8) {
        this.mChoreographer = r8;
    }

    @Override // com.ttnet.org.chromium.base.task.SingleThreadTaskRunner
    public boolean belongsToCurrentThread() {
        if (this.mChoreographer != Choreographer.getInstance()) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunner
    public void destroy() {
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunner
    public void disableLifetimeCheck() {
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunner
    public void initNativeTaskRunner() {
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunner
    public void postDelayedTask(final Runnable r8, long r10) {
        this.mChoreographer.postFrameCallbackDelayed(new AnonymousClass2(this, r8), r10);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunner
    public void postTask(final Runnable r8) {
        this.mChoreographer.postFrameCallback(new AnonymousClass1(this, r8));
    }
}
