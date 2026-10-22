package com.larus.vesdk.impl.camera;

import android.view.SurfaceHolder;
import com.larus.utils.logger.FLogger;
import com.ss.android.vesdk.VERecorder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c0 implements SurfaceHolder.Callback {
    public final /* synthetic */ VeCameraImpl a;
    public final /* synthetic */ Ref.BooleanRef b;

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        VeCameraImpl r0 = this.a;
        if (r0.g == false) goto L6;
        FLogger.a.e("VeCameraImpl", "surfaceCreated, isFinishing");
        return;
    L6:
        VeCameraImpl.C(r0, this.b, r3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        this.b.element = false;
        if (this.a.b.getFirstStopPreview() == false) goto L5;
        VeCameraImpl.v(this.a);
        this.a.w();
        return;
    L5:
        this.a.w();
        VeCameraImpl.v(this.a);
    }

    public c0(VeCameraImpl r1, Ref.BooleanRef r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder r1, int r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "holder");
        VERecorder r5 = this.a.d;
        if (r5 == null) goto L6;
        r5.changeSurface(r1.getSurface());
        return;
    }
}
