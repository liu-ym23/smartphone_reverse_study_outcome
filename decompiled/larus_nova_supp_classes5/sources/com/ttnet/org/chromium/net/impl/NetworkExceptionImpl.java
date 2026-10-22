package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.NetworkException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class NetworkExceptionImpl extends NetworkException {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected final int mCronetInternalErrorCode;
    protected final int mErrorCode;

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder r0 = new StringBuilder(super.getMessage());
        r0.append(", ErrorCode=");
        r0.append(this.mErrorCode);
        if (this.mCronetInternalErrorCode == 0) goto L5;
        r0.append(", InternalErrorCode=");
        r0.append(this.mCronetInternalErrorCode);
    L5:
        r0.append(", Retryable=");
        r0.append(immediatelyRetryable());
        return r0.toString();
    }

    @Override // com.ttnet.org.chromium.net.NetworkException
    public boolean immediatelyRetryable() {
        int r0 = this.mErrorCode;
        if (r0 != 3) goto L5;
        return true;
    L5:
        if (r0 != 4) goto L7;
        return true;
    L7:
        if (r0 != 5) goto L9;
        return true;
    L9:
        if (r0 != 6) goto L11;
        return true;
    L11:
        if (r0 == 8) goto L19;
        return false;
    L19:
        return true;
    }

    static {
    }

    @Override // com.ttnet.org.chromium.net.NetworkException
    public int getCronetInternalErrorCode() {
        return this.mCronetInternalErrorCode;
    }

    @Override // com.ttnet.org.chromium.net.NetworkException
    public int getErrorCode() {
        return this.mErrorCode;
    }

    public NetworkExceptionImpl(String r2, int r3, int r4) {
        super(r2, null);
        this.mErrorCode = r3;
        this.mCronetInternalErrorCode = r4;
    }
}
