package com.ttnet.org.chromium.net;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public abstract class NetworkQualityRttListener {
    private final Executor mExecutor;

    public abstract void onRttObservation(int r1, long r2, int r4);

    public Executor getExecutor() {
        return this.mExecutor;
    }

    public NetworkQualityRttListener(Executor r2) {
        if (r2 == null) goto L7;
        this.mExecutor = r2;
        return;
    L7:
        throw new IllegalStateException("Executor must not be null");
    }
}
