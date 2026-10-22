package com.bytedance.applog.priority;

import com.bytedance.applog.log.q;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NativeRunnable implements Runnable {
    private static final List<String> loggerTags = null;
    private final long nativeTaskPtr;

    static {
        loggerTags = Collections.singletonList("PriorityNativeRunnable");
    }

    public NativeRunnable(long r1) {
        this.nativeTaskPtr = r1;
    }

    public native void nativeRun(long r1);

    @Override // java.lang.Runnable
    public void run() {
        q.a().a(loggerTags, "run with native ptr: " + this.nativeTaskPtr, new Object[0]);
        nativeRun(this.nativeTaskPtr);
    }
}
