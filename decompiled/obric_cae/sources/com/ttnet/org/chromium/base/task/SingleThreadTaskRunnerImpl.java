package com.ttnet.org.chromium.base.task;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base")
public class SingleThreadTaskRunnerImpl extends TaskRunnerImpl implements SingleThreadTaskRunner {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Handler mHandler;
    private final boolean mPostTaskAtFrontOfQueue;

    public SingleThreadTaskRunnerImpl(Handler r8, TaskTraits r10) {
        this(r8, r10, false);
    }

    @SuppressLint({"NewApi"})
    private void postAtFrontOfQueue() {
        Message r8 = Message.obtain(this.mHandler, this.mRunPreNativeTaskClosure);
        r8.setAsynchronous(true);
        this.mHandler.sendMessageAtFrontOfQueue(r8);
    }

    @Override // com.ttnet.org.chromium.base.task.SingleThreadTaskRunner
    public boolean belongsToCurrentThread() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        long r10 = this.mNativeTaskRunnerAndroid;     // Catch: Throwable -> L16
        if (r10 == 0) goto L9;
        boolean r11 = nativeBelongsToCurrentThread(r10);     // Catch: Throwable -> L16
        monitor-exit(r8);     // Catch: Throwable -> L16
        return r11;
    L9:
        monitor-exit(r8);     // Catch: Throwable -> L16
        Handler r12 = this.mHandler;
        if (r12 != null) goto L13;
        return false;
    L13:
        if (r12.getLooper().getThread() != Thread.currentThread()) goto L21;
        return true;
    L21:
        return false;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunnerImpl
    public void schedulePreNativeTask() {
        Handler r8 = this.mHandler;
        if (r8 != null) goto L6;
        return;
    L6:
        if (this.mPostTaskAtFrontOfQueue == false) goto L8;
        postAtFrontOfQueue();
        return;
    L8:
        r8.post(this.mRunPreNativeTaskClosure);
    }

    public SingleThreadTaskRunnerImpl(Handler r8, TaskTraits r10, boolean r11) {
        super(r10, "SingleThreadTaskRunnerImpl", 2);
        this.mHandler = r8;
        this.mPostTaskAtFrontOfQueue = r11;
    }
}
