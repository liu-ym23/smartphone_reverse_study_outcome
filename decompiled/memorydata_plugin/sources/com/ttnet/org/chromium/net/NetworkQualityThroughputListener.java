package com.ttnet.org.chromium.net;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes6.dex */
public abstract class NetworkQualityThroughputListener {
    private final Executor mExecutor;

    public NetworkQualityThroughputListener(Executor r3) {
        Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L7;
        this.mExecutor = r4;
        return;
    L7:
        throw new IllegalStateException("Executor must not be null");
    }

    public Executor getExecutor() {
        return this.mExecutor;
    }

    public abstract void onThroughputObservation(int r1, long r2, int r4);
}
