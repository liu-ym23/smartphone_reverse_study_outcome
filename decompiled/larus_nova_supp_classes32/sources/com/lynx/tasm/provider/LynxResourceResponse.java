package com.lynx.tasm.provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxResourceResponse<T> {
    public static final int FAILED = -1;
    public static final int SUCCESS = 0;
    private int mCode;
    private T mData;
    private Throwable mError;

    public boolean success() {
        if (this.mData == null) goto L5;
        return true;
    L5:
        return false;
    }

    public int getCode() {
        return this.mCode;
    }

    public T getData() {
        return this.mData;
    }

    public Throwable getError() {
        return this.mError;
    }

    private LynxResourceResponse(T r1) {
        this.mData = r1;
    }

    public static <T> LynxResourceResponse<T> success(T r1) {
        LynxResourceResponse<T> r0 = new LynxResourceResponse(r1);
        ((LynxResourceResponse) r0).mCode = 0;
        return r0;
    }

    private LynxResourceResponse(int r1, Throwable r2) {
        this.mCode = r1;
        this.mError = r2;
    }

    public static LynxResourceResponse failed(int r1, Throwable r2) {
        return new LynxResourceResponse(r1, r2);
    }
}
