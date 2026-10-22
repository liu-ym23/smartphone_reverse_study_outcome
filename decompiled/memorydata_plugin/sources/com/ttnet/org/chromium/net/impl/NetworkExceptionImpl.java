package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.NetworkException;

/* JADX INFO: loaded from: classes6.dex */
public class NetworkExceptionImpl extends NetworkException {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected final int mCronetInternalErrorCode;
    protected final int mErrorCode;

    static {
    }

    public NetworkExceptionImpl(String r2, int r3, int r4) {
        super(r2, null);
        this.mErrorCode = r3;
        this.mCronetInternalErrorCode = r4;
    }

    @Override // com.ttnet.org.chromium.net.NetworkException
    public int getCronetInternalErrorCode() {
        return this.mCronetInternalErrorCode;
    }

    @Override // com.ttnet.org.chromium.net.NetworkException
    public int getErrorCode() {
        return this.mErrorCode;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder r0 = new StringBuilder(super.getMessage());
        r0.append(", ErrorCode=").append(this.mErrorCode);
        if (this.mCronetInternalErrorCode == 0) goto L5;
        r0.append(", InternalErrorCode=").append(this.mCronetInternalErrorCode);
    L5:
        r0.append(", Retryable=").append(immediatelyRetryable());
        return r0.toString();
    }

    @Override // com.ttnet.org.chromium.net.NetworkException
    public boolean immediatelyRetryable() {
        int r1 = this.mErrorCode;
        if (r1 != 3) goto L5;
        return true;
    L5:
        if (r1 != 4) goto L7;
        return true;
    L7:
        if (r1 != 5) goto L9;
        return true;
    L9:
        if (r1 != 6) goto L11;
        return true;
    L11:
        if (r1 == 8) goto L19;
        return false;
    L19:
        return true;
    }
}
