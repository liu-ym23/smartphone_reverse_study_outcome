package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.UrlRequest$StatusListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class VersionSafeCallbacks$UrlRequestStatusListener extends UrlRequest$StatusListener {
    private final UrlRequest$StatusListener mWrappedListener;

    public VersionSafeCallbacks$UrlRequestStatusListener(UrlRequest$StatusListener r1) {
        this.mWrappedListener = r1;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest$StatusListener
    public void onStatus(int r2) {
        this.mWrappedListener.onStatus(r2);
    }
}
