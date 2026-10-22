package com.ttnet.org.chromium.base.library_loader;

/* JADX INFO: loaded from: classes2.dex */
public class ProcessInitException extends Exception {
    private int mErrorCode;

    public ProcessInitException(int r8) {
        this.mErrorCode = r8;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public ProcessInitException(int r8, Throwable r10) {
        super(null, r10);
        this.mErrorCode = r8;
    }
}
