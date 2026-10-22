package com.ss.android.socialbase.downloader.exception;

import androidx.core.view.PointerIconCompat;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadPauseReserveWifiException extends DownloadRetryNeedlessException {
    public DownloadPauseReserveWifiException() {
        super(PointerIconCompat.TYPE_ALL_SCROLL, "download reserve wifi");
    }
}
