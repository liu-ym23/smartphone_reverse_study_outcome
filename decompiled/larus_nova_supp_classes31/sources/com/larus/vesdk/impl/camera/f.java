package com.larus.vesdk.impl.camera;

import android.graphics.Bitmap;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.platform.model.camera.ve.VeCameraOutputParam;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.vesdk.VERecorder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class f implements VERecorder.IBitmapShotScreenCallback {
    public final /* synthetic */ VeCameraImpl a;
    public final /* synthetic */ pq9.i b;
    public final /* synthetic */ int c;

    public /* synthetic */ f(VeCameraImpl r1, pq9.i r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onShotScreen(Bitmap r8, int r9) {
        VeCameraImpl r0 = this.a;
        final pq9.i r1 = this.b;
        int r2 = this.c;
        if (Intrinsics.areEqual(r0.i, "FLASH_MODE_ON") == false) goto L5;
    L6:
        r0.G(false);
    L7:
        if (r8 != null) goto L9;
        r1.onError(String.valueOf(r9));
        return;
    L9:
        int r3 = r8.getWidth();
        int r4 = (r8.getWidth() * 4) / 3;
        c r5 = c.a;
        int r6 = r8.getHeight() - r4;
        r5.getClass();
        Bitmap r10 = c.a(r8, r2, r6, null);
        String r7 = c.b();
        boolean r11 = c.c(r10, r7, null);
        final VeCameraOutputParam r12 = new VeCameraOutputParam();
        r12.setPath(r7);
        r12.setPhoto(true);
        r12.setPhotoBitmap(r10);
        r12.setWidth(r3);
        r12.setHeight(r4);
        long r13 = new PolarisFileWrapper(r7).length();     // Catch: Exception -> L12
    L13:
        r12.setSize(r13);
        FLogger.a.i("VeCameraImpl", "shotScreen, ret:" + r9 + ",param:" + r12 + ",isSaveSuccess:" + r11);
        t0.e(new k(r1, r12));
        return;
    L12:
        r13 = 0;
        goto L13
    L5:
        if (Intrinsics.areEqual(r0.i, "FLASH_MODE_AUTO") == false) goto L7;
        goto L6
    }
}
