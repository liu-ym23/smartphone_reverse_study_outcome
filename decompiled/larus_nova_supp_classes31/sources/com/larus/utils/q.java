package com.larus.utils;

import android.media.MediaScannerConnection;
import android.net.Uri;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class q implements MediaScannerConnection.OnScanCompletedListener {
    public /* synthetic */ q() {
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public final void onScanCompleted(String r4, Uri r5) {
        FLogger.a.d("FileUtils", "onScanCompleted: path: " + r4 + ", uri: " + r5);
    }
}
