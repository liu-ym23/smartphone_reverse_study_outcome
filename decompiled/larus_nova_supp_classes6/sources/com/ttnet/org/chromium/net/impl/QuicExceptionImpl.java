package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.QuicException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class QuicExceptionImpl extends QuicException {
    private final NetworkExceptionImpl mNetworkException;
    private final int mQuicDetailedErrorCode;

    public int getCronetInternalErrorCode() {
        return this.mNetworkException.getCronetInternalErrorCode();
    }

    public int getErrorCode() {
        return this.mNetworkException.getErrorCode();
    }

    public String getMessage() {
        return this.mNetworkException.getMessage() + ", QuicDetailedErrorCode=" + this.mQuicDetailedErrorCode;
    }

    public boolean immediatelyRetryable() {
        return this.mNetworkException.immediatelyRetryable();
    }

    @Override // com.ttnet.org.chromium.net.QuicException
    public int getQuicDetailedErrorCode() {
        return this.mQuicDetailedErrorCode;
    }

    public QuicExceptionImpl(String r2, int r3, int r4, int r5) {
        super(r2, null);
        this.mNetworkException = new NetworkExceptionImpl(r2, r3, r4);
        this.mQuicDetailedErrorCode = r5;
    }
}
