package com.larus.bmhome.bigimg;

import android.media.MediaScannerConnection;
import android.net.Uri;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h1 implements MediaScannerConnection.OnScanCompletedListener {
    public h1() {
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public final void onScanCompleted(String r4, Uri r5) {
        FLogger.a.d("ImageFileUtils", "onScanCompleted: path: " + r4 + ", uri: " + r5);
    }
}
