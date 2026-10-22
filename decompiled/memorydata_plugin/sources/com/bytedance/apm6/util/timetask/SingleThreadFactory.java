package com.bytedance.apm6.util.timetask;

import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class SingleThreadFactory implements ThreadFactory {
    private final String threadName;

    public SingleThreadFactory(String r3) {
        this.threadName = "APM6-" + r3;
    }

    static /* synthetic */ String access$000(SingleThreadFactory r0) {
        return r0.threadName;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r3) {
        final Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (ApmBaseContext.isDebugMode() == false) goto L6;
        Logger.d(Constant.TAG, "creating newThread " + this.threadName);
    L6:
        return new Thread(new AnonymousClass1(this, r4), this.threadName);
    }
}
