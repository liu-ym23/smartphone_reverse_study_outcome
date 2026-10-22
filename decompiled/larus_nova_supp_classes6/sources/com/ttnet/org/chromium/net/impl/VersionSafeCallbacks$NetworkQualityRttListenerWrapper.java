package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.NetworkQualityRttListener;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class VersionSafeCallbacks$NetworkQualityRttListenerWrapper extends NetworkQualityRttListener {
    private final NetworkQualityRttListener mWrappedListener;

    @Override // com.ttnet.org.chromium.net.NetworkQualityRttListener
    public Executor getExecutor() {
        return this.mWrappedListener.getExecutor();
    }

    public int hashCode() {
        return this.mWrappedListener.hashCode();
    }

    public VersionSafeCallbacks$NetworkQualityRttListenerWrapper(NetworkQualityRttListener r2) {
        super(r2.getExecutor());
        this.mWrappedListener = r2;
    }

    public boolean equals(Object r2) {
        if (r2 != null) goto L4;
        return false;
    L4:
        if ((r2 instanceof VersionSafeCallbacks$NetworkQualityRttListenerWrapper) == true) goto L7;
        return false;
    L7:
        return this.mWrappedListener.equals(((VersionSafeCallbacks$NetworkQualityRttListenerWrapper) r2).mWrappedListener);
    }

    @Override // com.ttnet.org.chromium.net.NetworkQualityRttListener
    public void onRttObservation(int r2, long r3, int r5) {
        this.mWrappedListener.onRttObservation(r2, r3, r5);
    }
}
