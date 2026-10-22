package com.bytedance.common.utility;

/* JADX INFO: loaded from: classes.dex */
public class CommonHttpException extends Exception {
    private int mResponseCode;

    public CommonHttpException(int r10, String r11) {
        super(r11);
        this.mResponseCode = r10;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }
}
