package com.bytedance.applog.priority;

import androidx.annotation.Keep;
import c4.m;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class NativeRunnable implements Runnable {
    private static final List<String> loggerTags = null;
    private final long nativeTaskPtr;

    static {
        loggerTags = Collections.singletonList("PriorityNativeRunnable");
    }

    public NativeRunnable(long r8) {
        this.nativeTaskPtr = r8;
    }

    public native void nativeRun(long r8);

    @Override // java.lang.Runnable
    public void run() {
        m.u().p(loggerTags, "run with native ptr: " + this.nativeTaskPtr, new Object[0]);
        nativeRun(this.nativeTaskPtr);
    }
}
