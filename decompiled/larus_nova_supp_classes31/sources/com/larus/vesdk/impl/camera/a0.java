package com.larus.vesdk.impl.camera;

import com.larus.utils.logger.FLogger;
import com.ss.android.vesdk.VEInfo;
import com.ss.android.vesdk.VEListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a0 implements VEListener.VERecorderStateExtListener {
    public final /* synthetic */ VeCameraImpl a;

    public final void onError(int r1, String r2) {
    }

    public a0(VeCameraImpl r1) {
        this.a = r1;
    }

    public final void onHardEncoderInit(boolean r3) {
        FLogger.a.i("VeCameraImpl", "[initRecorder] onHardEncoderInit");
    }

    public final void onNativeInit(int r2, String r3) {
        FLogger.a.i("VeCameraImpl", "[initRecorder] onNativeInit");
    }

    public final void onInfo(int r1, int r2, String r3) {
        if (r1 != VEInfo.TE_INFO_PREVIEW_FIRST_FRAME_SCREEN) goto L8;
        FLogger.a.i("VeCameraImpl", "[initRecorder] first frame arrive");
        pq9.b r4 = this.a.n;
        if (r4 == null) goto L9;
        r4.e();
        return;
    L9:
        return;
    }
}
