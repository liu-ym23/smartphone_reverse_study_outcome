package com.ttnet.org.chromium.base.task;

import android.view.Choreographer;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
final class ChoreographerTaskRunner implements SingleThreadTaskRunner {
    private final Choreographer mChoreographer;

    ChoreographerTaskRunner(Choreographer r1) {
        this.mChoreographer = r1;
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
    public void postDelayedTask(Runnable r3, long r4) {
        final Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        this.mChoreographer.postFrameCallbackDelayed(new AnonymousClass2(this, r5), r4);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunner
    public void postTask(Runnable r3) {
        final Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        this.mChoreographer.postFrameCallback(new AnonymousClass1(this, r4));
    }
}
