package com.bytedance.bdinstall;

/* JADX INFO: loaded from: classes.dex */
public class RangersHttpException extends Exception {
    private int mResponseCode;

    public RangersHttpException(int r1, String r2) {
        super(r2);
        this.mResponseCode = r1;
    }

    public RangersHttpException(int r1, Throwable r2) {
        super(r2);
        this.mResponseCode = r1;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }
}
