package com.ttnet.org.chromium.base.task;

import android.view.Choreographer;

/* JADX INFO: loaded from: classes2.dex */
final class ChoreographerTaskRunner implements SingleThreadTaskRunner {
    private final Choreographer mChoreographer;

    ChoreographerTaskRunner(Choreographer r10) {
        this.mChoreographer = r10;
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
    public void postDelayedTask(final Runnable r10, long r11) {
        this.mChoreographer.postFrameCallbackDelayed(new AnonymousClass2(this, r10), r11);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunner
    public void postTask(final Runnable r10) {
        this.mChoreographer.postFrameCallback(new AnonymousClass1(this, r10));
    }
}
