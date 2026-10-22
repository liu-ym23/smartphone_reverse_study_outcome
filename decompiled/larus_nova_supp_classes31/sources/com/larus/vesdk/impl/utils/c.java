package com.larus.vesdk.impl.utils;

import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.ss.android.vesdk.VERecorder;
import com.ss.android.vesdk.VESize;
import com.ss.android.vesdk.algorithm.VEBachQRCodeParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public static final /* synthetic */ int c = 0;
    public final pq9.a a;
    public final VEBachQRCodeParam b;

    public static final class a {
    }

    static {
    }

    public c(VERecorder r1, CameraCaptureViewModel.d r2, VESize r3) {
        this.a = r2;
        this.b = new VEBachQRCodeParam.Builder().setCodeType(1023).setScanMode(VEBachQRCodeParam.VE_SCAN_MODE.CAMERA).build();
    }
}
