package com.ss.android.socialbase.downloader.exception;

import androidx.core.view.PointerIconCompat;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadOnlyWifiException extends DownloadRetryNeedlessException {
    public DownloadOnlyWifiException() {
        super(PointerIconCompat.TYPE_ALL_SCROLL, "download only wifi");
    }
}
