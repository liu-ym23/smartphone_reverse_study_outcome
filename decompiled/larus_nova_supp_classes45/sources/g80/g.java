package g80;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.api.device.info.TelephonyManagerEntry;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g {
    static {
    }

    @JvmStatic
    public static final Integer a(Cert r2) {
        Object r0 = jc1.a.b().getSystemService("phone");
        if (r0 == null) goto L10;
        TelephonyManager r1 = (TelephonyManager) r0;
        if (LiveInfraSettingKeys.LIVE_BPEA_SWITCH.getValue().booleanValue() == false) goto L8;
        TelephonyManagerEntry.Companion.getClass();
        return TelephonyManagerEntry.Companion.b(r1, r2);
    L8:
        return Integer.valueOf(r1.getNetworkType());
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
    }

    @JvmStatic
    public static final String b(TokenCert r13) {
        Object r0 = jc1.a.b().getSystemService("phone");
        if (r0 == null) goto L13;
        TelephonyManager r1 = (TelephonyManager) r0;
        if (LiveInfraSettingKeys.LIVE_BPEA_SWITCH.getValue().booleanValue() == false) goto L7;
        TelephonyManagerEntry.Companion.getClass();
        return TelephonyManagerEntry.Companion.e(r1, r13);
    L7:
        f06.c r14 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r11 = new f06.b();
        f06.d r12 = r14.b(102021, "android/telephony/TelephonyManager", "getSimOperator", r1, r9, "java.lang.String", r11);
        if (r12.a == false) goto L10;
        r14.a(102021, "android/telephony/TelephonyManager", "getSimOperator", r1, r9, null, r11, false);
        return (String) r12.b;
    L10:
        String r15 = r1.getSimOperator();
        r14.a(102021, "android/telephony/TelephonyManager", "getSimOperator", r1, r9, r15, r11, true);
        return r15;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
    }

    @JvmStatic
    public static final void c(PhoneStateListener r2, int r3, TokenCert r4) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Object r0 = jc1.a.b().getSystemService("phone");
        if (r0 == null) goto L10;
        TelephonyManager r1 = (TelephonyManager) r0;
        if (LiveInfraSettingKeys.LIVE_BPEA_SWITCH.getValue().booleanValue() == false) goto L7;
        TelephonyManagerEntry.Companion.getClass();
        TelephonyManagerEntry.Companion.l(r1, r2, r3, r4);
        return;
    L7:
        r1.listen(r2, r3);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
    }
}
