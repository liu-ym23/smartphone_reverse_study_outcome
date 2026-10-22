package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.RequestFinishedInfo;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class VersionSafeCallbacks$RequestFinishedInfoListener extends RequestFinishedInfo.Listener {
    private final RequestFinishedInfo.Listener mWrappedListener;

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Listener
    public Executor getExecutor() {
        return this.mWrappedListener.getExecutor();
    }

    public VersionSafeCallbacks$RequestFinishedInfoListener(RequestFinishedInfo.Listener r2) {
        super(r2.getExecutor());
        this.mWrappedListener = r2;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Listener
    public void onRequestFinished(RequestFinishedInfo r2) {
        this.mWrappedListener.onRequestFinished(r2);
    }
}
