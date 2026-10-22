package r3a;

import com.larus.utils.logger.FLogger;
import com.ss.android.vesdk.VECameraCapture;
import com.ss.android.vesdk.VEListener;
import com.ss.android.vesdk.VERecorder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g implements VEListener.VECameraStateExtListener {
    public final /* synthetic */ f a;

    public final /* synthetic */ void onInfoForTrack(int r1, int r2, String r3, long r4) {
        VEListener.VECameraStateExtListener.-CC.$default$onInfoForTrack(this, r1, r2, r3, r4);
    }

    public final void cameraOpenSuccess() {
        FLogger r0 = FLogger.a;
        r0.i("CameraContextImpl", "Camera open success callback");
        f r1 = this.a;
        p3a.c r2 = r1.q;
        r2.b = true;
        r2.c = false;
        q3a.o r3 = r1.d;
        if (r3.c.get() == true) goto L7;
        r0.i("CameraEventDispatcher", "Dispatching camera open success");
        r3.c("onCameraOpenSuccess", new q3a.m());
        return;
    }

    public g(f r1) {
        this.a = r1;
    }

    public final void cameraOpenFailed(final int r5) {
        FLogger r0 = FLogger.a;
        r0.e("CameraContextImpl", "Camera open failed callback, cameraType: " + r5);
        q3a.o r1 = this.a.d;
        if (r1.c.get() == true) goto L6;
        r0.e("CameraEventDispatcher", "Dispatching camera open failed: cameraType=" + r5);
        r1.c("onCameraOpenFailed", new q3a.k(r5));
    L6:
        i r2 = new i(1, "Camera open failed, cameraType: " + r5, null);
        f r6 = this.a;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r2, "error");
        r6.d.b(r2);
    }

    public final void onError(int r4, String r5) {
        FLogger.a.e("CameraContextImpl", "Camera error callback, ret: " + r4 + ", msg: " + r5);
        if (r5 != null) goto L5;
        r5 = "Unknown camera error";
    L5:
        i r0 = new i(r4, r5, null);
        f r6 = this.a;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "error");
        r6.d.b(r0);
    }

    public final void onInfo(int r6, int r7, String r8) {
        FLogger r0 = FLogger.a;
        r0.i("CameraContextImpl", "Camera info callback, infoType: " + r6 + ", ext: " + r7 + ", msg: " + r8);
        if (r6 != 3) goto L8;
        q3a.o r9 = this.a.d;
        if (r9.c.get() == true) goto L8;
        r0.i("CameraEventDispatcher", "Dispatching first frame received");
        r9.c("onFirstFrameReceived", new q3a.l());
    L8:
        if (r6 != 0) goto L15;
        if (r7 != 0) goto L15;
        q3a.o r10 = this.a.d;
        if (r10.c.get() == true) goto L15;
        r0.i("CameraEventDispatcher", "Dispatching preview success");
        r10.c("onPreviewSuccess", new q3a.d());
    L15:
        if (r6 != 109) goto L28;
        f r11 = this.a;
        r11.q.c = true;
        if (r11.l.get() == true) goto L19;
        return;
    L19:
        if (((Boolean) this.a.h.getValue()).booleanValue() == false) goto L23;
        VERecorder r12 = this.a.B().b;
        if (r12 == null) goto L23;
        r12.stopPreview();
    L23:
        VECameraCapture r13 = this.a.n;
        if (r13 == null) goto L26;
        r13.destroy();
    L26:
        this.a.B().c();
        r0.i("CameraContextImpl", "destroy recorder from onInfo callback");
        return;
    }
}
