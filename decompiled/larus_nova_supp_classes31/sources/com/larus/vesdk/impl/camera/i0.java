package com.larus.vesdk.impl.camera;

import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i0 implements pq9.d {
    public final /* synthetic */ long a;
    public final /* synthetic */ VeCameraImpl b;
    public final /* synthetic */ int c;
    public final /* synthetic */ pq9.i d;

    @Override // pq9.c
    public final void onResult(boolean r6) {
        long r0 = System.currentTimeMillis() - this.a;
        FLogger.a.i("VeCameraImpl", "detect result, isDark:" + r6 + ",costTime:" + r0);
        if (r6 == false) goto L5;
        this.b.G(true);
    L5:
        VeCameraImpl r1 = this.b;
        int r2 = this.c;
        pq9.i r3 = this.d;
        r1.getClass();
        r1.E(new f(r1, r3, r2), r6, false);
    }

    public i0(long r1, VeCameraImpl r3, int r4, CameraCaptureViewModel.a r5) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
