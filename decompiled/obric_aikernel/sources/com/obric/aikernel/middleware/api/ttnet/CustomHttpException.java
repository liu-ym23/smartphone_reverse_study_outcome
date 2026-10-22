package com.obric.aikernel.middleware.api.ttnet;

import com.bytedance.common.utility.CommonHttpException;

/* JADX INFO: loaded from: classes2.dex */
public final class CustomHttpException extends CommonHttpException {
    private final int mInternalErrorCode;

    public CustomHttpException(int r10, int r11, String r12) {
        super(r10, r12);
        this.mInternalErrorCode = r11;
    }

    public final int getInternalErrorCode() {
        return this.mInternalErrorCode;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "CustomHttpException[responseCode=" + getResponseCode() + ", internalErrorCode=" + this.mInternalErrorCode + ']';
    }
}
