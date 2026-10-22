package com.larus.vesdk.impl.camera;

import android.view.SurfaceHolder;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.vesdk.VERecorder;
import hq9.j0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e0 implements SurfaceHolder.Callback {
    public final /* synthetic */ VeCameraImpl a;

    public e0(VeCameraImpl r1) {
        this.a = r1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(final SurfaceHolder r5) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        VeCameraImpl r0 = this.a;
        if (r0.g == false) goto L7;
        FLogger.a.e("VeCameraImpl", "surfaceCreated, isFinishing");
        return;
    L7:
        if (((j0) r0.t.getValue()).b() == false) goto L10;
        final VeCameraImpl r1 = this.a;
        t0.d(new d0(r1, r5), ((j0) r1.t.getValue()).e());
        return;
    L10:
        pq9.b r2 = this.a.n;
        if (r2 == null) goto L13;
        r2.surfaceCreated(r5);
    L13:
        this.a.B("surfaceCreated");
        this.a.F(r5.getSurface());
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder r6) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        if (this.a.b.getFirstStopPreview() == false) goto L20;
        VeCameraImpl r7 = this.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        VeCameraImpl.v(r7);     // Catch: Throwable -> L7
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L39;
        FLogger.a.w("VeCameraImpl", "surfaceDestroyed: stopPreview failed, " + r9, r9);
    L39:
        this.a.w();     // Catch: Throwable -> L15
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L45;
        FLogger.a.w("VeCameraImpl", "surfaceDestroyed: closeCamera failed, " + r11, r11);
        return;
    L45:
        return;
    L15:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L20:
        VeCameraImpl r12 = this.a;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L23
        r12.w();     // Catch: Throwable -> L23
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L37;
        FLogger.a.w("VeCameraImpl", "surfaceDestroyed: closeCamera failed, " + r14, r14);
    L37:
        VeCameraImpl.v(this.a);     // Catch: Throwable -> L31
        Object r15 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L33:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L47;
        FLogger.a.w("VeCameraImpl", "surfaceDestroyed: stopPreview failed, " + r16, r16);
        return;
    L47:
        return;
    L31:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L23:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
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
