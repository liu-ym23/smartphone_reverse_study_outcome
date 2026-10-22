package com.bytedance.bdinstall;

/* JADX INFO: loaded from: classes.dex */
public class RangersHttpException extends Exception {
    private int mResponseCode;

    public RangersHttpException(int r10, String r11) {
        super(r11);
        this.mResponseCode = r10;
    }

    public RangersHttpException(int r10, Throwable r11) {
        super(r11);
        this.mResponseCode = r10;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }
}
