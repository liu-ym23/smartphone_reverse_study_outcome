package com.bytedance.common.utility;

/* JADX INFO: loaded from: classes2.dex */
public class CommonHttpException extends Exception {
    private int mResponseCode;

    public CommonHttpException(int r5, String r10) {
        super(r10);
        this.mResponseCode = r5;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }
}
