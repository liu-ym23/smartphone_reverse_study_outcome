package com.larus.vesdk.impl.utils;

import com.ss.android.vesdk.VEUtils;
import com.ss.android.vesdk.algorithm.VEBachQRCodeParam;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class o implements Runnable {
    public final /* synthetic */ VEBachQRCodeParam a;
    public final /* synthetic */ Function1 b;

    public /* synthetic */ o(VEBachQRCodeParam r1, com.larus.camera.impl.ui.component.capture.scan.d r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VEBachQRCodeParam r0 = this.a;
        this.b.invoke(VEUtils.scanPicture(r0).getResult());
    }
}
