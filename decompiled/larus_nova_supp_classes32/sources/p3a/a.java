package p3a;

import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import q3a.p;
import r3a.i;
import r3a.j;
import r3a.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements p {

    /* JADX INFO: renamed from: p3a.a$a, reason: collision with other inner class name */
    public static final class C0106a {
    }

    static {
    }

    @Override // q3a.p
    public final void a() {
    }

    @Override // q3a.p
    public final void n() {
    }

    @Override // q3a.p
    public final String o() {
        return "LoggingCameraEventListener";
    }

    @Override // q3a.p
    public final void p(boolean r1, int r2) {
    }

    @Override // q3a.p
    public final void g() {
        FLogger.a.i("LoggingCameraEventListener", "First frame received");
    }

    @Override // q3a.p
    public final void r() {
        FLogger.a.i("LoggingCameraEventListener", "Camera open success");
    }

    public a() {
    }

    @Override // q3a.p
    public final void i(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "captureParams");
    }

    @Override // q3a.p
    public final void k(int r4) {
        FLogger.a.e("LoggingCameraEventListener", "Camera open failed: cameraType=" + r4);
    }

    @Override // q3a.p
    public final void l(s3a.b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // q3a.p
    public final void s(i r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("LoggingCameraEventListener", "Camera error: " + r4.a + " - " + r4.b, r4.c);
    }

    @Override // q3a.p
    public final void t(j r4) {
        Intrinsics.checkNotNullParameter(r4, "frame");
        FLogger.a.d("LoggingCameraEventListener", "Frame captured: textureId=" + r4.a + ", size=" + r4.b + 'x' + r4.c);
    }

    @Override // q3a.p
    public final void h(l r4, l r5) {
        Intrinsics.checkNotNullParameter(r4, "oldState");
        Intrinsics.checkNotNullParameter(r5, "newState");
        FLogger.a.i("LoggingCameraEventListener", "State changed: " + r4.getTag() + " -> " + r5.getTag());
    }
}
