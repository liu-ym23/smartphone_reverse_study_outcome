package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w0 implements MediaScannerConnection.OnScanCompletedListener {
    public final /* synthetic */ Context a;

    public w0(Context r1) {
        this.a = r1;
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public final void onScanCompleted(String r3, Uri r4) {
        Intent r0 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        r0.setData(r4);
        this.a.sendBroadcast(r0);
        ALogger.d(z0.u, "onScanCompleted,path=" + r3);
    }
}
