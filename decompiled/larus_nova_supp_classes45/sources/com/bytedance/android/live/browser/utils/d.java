package com.bytedance.android.live.browser.utils;

import com.bytedance.android.live.browser.jsbridge.upload.q;
import com.bytedance.common.utility.Logger;
import com.ss.bduploader.BDImageXInfo;
import com.ss.bduploader.BDImageXUploader;
import com.ss.bduploader.BDImageXUploaderListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements BDImageXUploaderListener {
    public final /* synthetic */ BDImageXUploaderListener a;
    public final /* synthetic */ BDImageXUploader b;

    public d(q.c r1, BDImageXUploader r2) {
        this.a = r1;
        this.b = r2;
    }

    public final int imageXUploadCheckNetState(int r2, int r3) {
        return this.a.imageXUploadCheckNetState(r2, r3);
    }

    public final void onLog(int r3, int r4, String r5) {
        Logger.i("ImageXUtil", "what = " + r3 + " code = " + r4 + " info = " + r5);
        this.a.onLog(r3, r4, r5);
    }

    public final void onNotify(int r2, long r3, BDImageXInfo r5) {
        this.a.onNotify(r2, r3, r5);
        if (r2 != 0) goto L7;
        this.b.close();
        return;
    }
}
