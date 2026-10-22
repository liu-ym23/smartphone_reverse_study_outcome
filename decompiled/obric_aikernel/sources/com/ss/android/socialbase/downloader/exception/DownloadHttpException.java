package com.ss.android.socialbase.downloader.exception;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadHttpException extends BaseException {
    private final int httpStatusCode;

    public DownloadHttpException(int r10, int r11, String r12) {
        super(r10, r12);
        this.httpStatusCode = r11;
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }
}
