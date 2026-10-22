package com.larus.uploader.impl.preheat;

import com.larus.utils.logger.FLogger;
import com.ss.bduploader.BDImageXInfo;
import com.ss.bduploader.BDImageXUploaderListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements BDImageXUploaderListener {
    public final /* synthetic */ long a;

    public final int imageXUploadCheckNetState(int r1, int r2) {
        return 1;
    }

    public a(long r1) {
        this.a = r1;
    }

    public final void onLog(int r4, int r5, String r6) {
        FLogger.a.i("ImgUploadPreheat", "[onLog] what:" + r4 + ", code:" + r5 + ", info" + r6);
    }

    public final void onNotify(int r5, long r6, BDImageXInfo r8) {
        FLogger r0 = FLogger.a;
        r0.i("ImgUploadPreheat", "what=" + r5 + ", parameter=" + r6 + ", info=" + r8);
        if (r5 != 123) goto L7;
        r0.i("ImgUploadPreheat", "preheat complete, costMs=" + (System.currentTimeMillis() - this.a));
        return;
    L7:
        if (r5 == 124) goto L9;
        return;
    L9:
        if (r6 != 1) goto L11;
        boolean r7 = true;
    L12:
        r0.i("ImgUploadPreheat", "[preheat] resultUsed hit=" + r7);
        return;
    L11:
        r7 = false;
        goto L12
    }
}
