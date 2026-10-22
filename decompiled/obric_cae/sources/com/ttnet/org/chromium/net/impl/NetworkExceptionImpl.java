package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.NetworkException;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkExceptionImpl extends NetworkException {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f6743a = 0;
    protected final int mCronetInternalErrorCode;
    protected final int mErrorCode;

    public NetworkExceptionImpl(String r8, int r10, int r11) {
        super(r8, null);
        this.mErrorCode = r10;
        this.mCronetInternalErrorCode = r11;
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
        StringBuilder r8 = new StringBuilder(super.getMessage());
        r8.append(", ErrorCode=");
        r8.append(this.mErrorCode);
        if (this.mCronetInternalErrorCode == 0) goto L5;
        r8.append(", InternalErrorCode=");
        r8.append(this.mCronetInternalErrorCode);
    L5:
        r8.append(", Retryable=");
        r8.append(immediatelyRetryable());
        return r8.toString();
    }

    @Override // com.ttnet.org.chromium.net.NetworkException
    public boolean immediatelyRetryable() {
        int r8 = this.mErrorCode;
        if (r8 != 3) goto L5;
        return true;
    L5:
        if (r8 != 4) goto L7;
        return true;
    L7:
        if (r8 != 5) goto L9;
        return true;
    L9:
        if (r8 != 6) goto L11;
        return true;
    L11:
        if (r8 == 8) goto L19;
        return false;
    L19:
        return true;
    }
}
