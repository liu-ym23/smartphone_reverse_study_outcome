package g80;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f {
    static {
    }

    @JvmStatic
    public static final Sensor b(SensorManager r2, TokenCert r3) throws BPEAException {
        Intrinsics.checkNotNullParameter(r2, "manager");
        if (LiveInfraSettingKeys.LIVE_BPEA_SWITCH.getValue().booleanValue() == false) goto L6;
        int r0 = com.bytedance.bpea.entry.api.device.info.e.a;
        return com.bytedance.bpea.entry.api.device.info.e.a.a(r2, 1, r3);
    L6:
        return r2.getDefaultSensor(1);
    }

    @JvmStatic
    public static final Sensor a(SensorManager r1, int r2, TokenCert r3) {
        Intrinsics.checkNotNullParameter(r1, "manager");
        if (LiveInfraSettingKeys.LIVE_BPEA_SWITCH.getValue().booleanValue() == false) goto L10;
        int r0 = com.bytedance.bpea.entry.api.device.info.e.a;
        return com.bytedance.bpea.entry.api.device.info.e.a.a(r1, r2, r3);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    L10:
        return r1.getDefaultSensor(r2);
    }
}
