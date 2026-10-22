package com.bytedance.badger.collect.impl.network;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class RangersHttpException extends Exception {
    private int mResponseCode;

    public int getResponseCode() {
        return this.mResponseCode;
    }

    public RangersHttpException(int r1, String r2) {
        super(r2);
        this.mResponseCode = r1;
    }

    public RangersHttpException(int r1, Throwable r2) {
        super(r2);
        this.mResponseCode = r1;
    }
}
