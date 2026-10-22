package com.ss.android.socialbase.downloader.exception;

/* JADX INFO: loaded from: classes6.dex */
public class DownloadHttpException extends BaseException {
    private final int httpStatusCode;

    public DownloadHttpException(int r1, int r2, String r3) {
        super(r1, r3);
        this.httpStatusCode = r2;
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }
}
