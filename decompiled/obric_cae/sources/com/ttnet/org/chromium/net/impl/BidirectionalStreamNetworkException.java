package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
public class BidirectionalStreamNetworkException extends NetworkExceptionImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public BidirectionalStreamNetworkException(String r8, int r10, int r11) {
        super(r8, r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.NetworkExceptionImpl, com.ttnet.org.chromium.net.NetworkException
    public boolean immediatelyRetryable() {
        int r8 = this.mCronetInternalErrorCode;
        if (r8 != (-358)) goto L5;
        return true;
    L5:
        if (r8 != (-352)) goto L7;
        return true;
    L7:
        return super.immediatelyRetryable();
    }
}
