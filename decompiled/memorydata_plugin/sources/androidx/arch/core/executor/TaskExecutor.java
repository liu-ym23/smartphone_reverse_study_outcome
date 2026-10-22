package androidx.arch.core.executor;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class TaskExecutor {
    public TaskExecutor() {
    }

    public abstract void executeOnDiskIO(Runnable r1);

    public void executeOnMainThread(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (isMainThread() == false) goto L5;
        r4.run();
        return;
    L5:
        postToMainThread(r4);
    }

    public abstract boolean isMainThread();

    public abstract void postToMainThread(Runnable r1);
}
