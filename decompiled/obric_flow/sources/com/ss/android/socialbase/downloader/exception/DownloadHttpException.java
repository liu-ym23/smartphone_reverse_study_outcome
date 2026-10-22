package com.ss.android.socialbase.downloader.exception;

import androidx.core.view.PointerIconCompat;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadHttpException extends BaseException {
    public final int d;

    public DownloadHttpException(int r5, String r10) {
        super(PointerIconCompat.TYPE_WAIT, r10);
        this.d = r5;
    }
}
