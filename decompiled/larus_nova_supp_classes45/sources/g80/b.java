package g80;

import android.hardware.Camera;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    static {
    }

    public static void a(Camera r12) {
        f06.c r8 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r11 = new f06.b();
        if (r8.b(100101, "android/hardware/Camera", "release", r12, r9, "void", r11).a == false) goto L6;
        r8.a(100101, "android/hardware/Camera", "release", r12, r9, null, r11, false);
        return;
    L6:
        r12.release();
        r8.a(100101, "android/hardware/Camera", "release", r12, r9, null, r11, true);
    }

    @JvmStatic
    public static final Camera b(int r11, TokenCert r12) throws BPEAException {
        if (LiveInfraSettingKeys.LIVE_BPEA_SWITCH.getValue().booleanValue() == false) goto L5;
        int r0 = com.bytedance.bpea.entry.api.camera.a.a;
        return com.bytedance.bpea.entry.api.camera.a.a.a(r11, r12);
    L5:
        f06.c r13 = new f06.c();
        Object[] r8 = {Integer.valueOf(r11)};
        f06.b r9 = new f06.b();
        f06.d r14 = r13.b(100100, "android/hardware/Camera", "open", Camera.class, r8, "android.hardware.Camera", r9);
        if (r14.a == false) goto L8;
        r13.a(100100, "android/hardware/Camera", "open", Camera.class, r8, null, r9, false);
        return (Camera) r14.b;
    L8:
        Camera r15 = Camera.open(r11);
        r13.a(100100, "android/hardware/Camera", "open", Camera.class, r8, r15, r9, true);
        return r15;
    }

    @JvmStatic
    public static final void c(Camera r1, TokenCert r2) {
        Intrinsics.checkNotNullParameter(r1, NewBroadcastMonitor.STAGE.CAMERA);
    L8:
        e = move-exception;
        ALogger.e("CameraUtils", e);
        return;
    L4:
        if (LiveInfraSettingKeys.LIVE_BPEA_SWITCH.getValue().booleanValue() == false) goto L6;
        int r0 = com.bytedance.bpea.entry.api.camera.a.a;     // Catch: BPEAException -> L8
        com.bytedance.bpea.entry.api.camera.a.a.c(r1, r2);     // Catch: BPEAException -> L8
    L11:
        return;
    L6:
        a(r1);     // Catch: BPEAException -> L8
        goto L11
    }
}
