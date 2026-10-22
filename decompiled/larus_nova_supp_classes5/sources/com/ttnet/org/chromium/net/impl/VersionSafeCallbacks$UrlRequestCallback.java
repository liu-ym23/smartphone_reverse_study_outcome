package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.UrlRequest;
import com.ttnet.org.chromium.net.UrlResponseInfo;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class VersionSafeCallbacks$UrlRequestCallback extends UrlRequest.Callback {
    private final UrlRequest.Callback mWrappedCallback;

    public VersionSafeCallbacks$UrlRequestCallback(UrlRequest.Callback r1) {
        this.mWrappedCallback = r1;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
    public void onCanceled(UrlRequest r2, UrlResponseInfo r3) {
        this.mWrappedCallback.onCanceled(r2, r3);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
    public void onSucceeded(UrlRequest r2, UrlResponseInfo r3) {
        this.mWrappedCallback.onSucceeded(r2, r3);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
    public void onFailed(UrlRequest r2, UrlResponseInfo r3, CronetException r4) {
        this.mWrappedCallback.onFailed(r2, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
    public void onReadCompleted(UrlRequest r2, UrlResponseInfo r3, ByteBuffer r4) throws Exception {
        this.mWrappedCallback.onReadCompleted(r2, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
    public void onResponseStarted(UrlRequest r2, UrlResponseInfo r3, String r4) throws Exception {
        this.mWrappedCallback.onResponseStarted(r2, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
    public void onRedirectReceived(UrlRequest r2, UrlResponseInfo r3, String r4, String r5) throws Exception {
        this.mWrappedCallback.onRedirectReceived(r2, r3, r4, r5);
    }
}
