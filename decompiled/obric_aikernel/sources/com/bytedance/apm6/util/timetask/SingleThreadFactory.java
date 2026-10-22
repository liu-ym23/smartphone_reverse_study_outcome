package com.bytedance.apm6.util.timetask;

import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class SingleThreadFactory implements ThreadFactory {
    private final String threadName;

    public SingleThreadFactory(String r10) {
        this.threadName = "APM6-" + r10;
    }

    static /* synthetic */ String access$000(SingleThreadFactory r10) {
        return r10.threadName;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable r10) {
        if (ApmBaseContext.isDebugMode() == false) goto L6;
        Logger.d(Constant.TAG, "creating newThread " + this.threadName);
    L6:
        return new Thread(new AnonymousClass1(this, r10), this.threadName);
    }
}
