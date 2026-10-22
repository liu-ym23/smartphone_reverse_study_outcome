package com.ss.android.socialbase.downloader.constants;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DownloadStatus {
    public static boolean a(int r5) {
        if (r5 > 0) goto L4;
        return false;
    L4:
        if (r5 != 8) goto L6;
        return false;
    L6:
        if (r5 == 10) goto L12;
        return true;
    L12:
        return false;
    }
}
