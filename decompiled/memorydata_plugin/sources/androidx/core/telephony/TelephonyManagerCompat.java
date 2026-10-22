package androidx.core.telephony;

import android.os.Build;
import android.telephony.TelephonyManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class TelephonyManagerCompat {
    private static Method sGetDeviceIdMethod;
    private static Method sGetSubIdMethod;

    private static class Api23Impl {
        private Api23Impl() {
        }

        static String getDeviceId(TelephonyManager r0, int r1) {
            return r0.getDeviceId(r1);
        }
    }

    private static class Api26Impl {
        private Api26Impl() {
        }

        static String getImei(TelephonyManager r0) {
            return r0.getImei();
        }
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        static int getSubscriptionId(TelephonyManager r0) {
            return r0.getSubscriptionId();
        }
    }

    private TelephonyManagerCompat() {
    }

    public static String getImei(TelephonyManager r7) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.getImei(r7);
    L7:
        if (Build.VERSION.SDK_INT < 22) goto L24;
        int r0 = getSubscriptionId(r7);
        if (r0 == Integer.MAX_VALUE) goto L24;
        if (r0 == (-1)) goto L24;
        int r1 = SubscriptionManagerCompat.getSlotIndex(r0);
        if (Build.VERSION.SDK_INT >= 23) goto L15;
    L21:
        return null;
    L17:
        if (sGetDeviceIdMethod != null) goto L19;
        Method r2 = TelephonyManager.class.getDeclaredMethod("getDeviceId", new Class[]{Integer.TYPE});     // Catch: Throwable -> L21
        sGetDeviceIdMethod = r2;     // Catch: Throwable -> L21
        r2.setAccessible(true);     // Catch: Throwable -> L21
    L19:
        return (String) ZeusTransformUtils.preCheckCast(sGetDeviceIdMethod.invoke(r7, new Object[]{Integer.valueOf(r1)}), String.class, "com.obric.memorydata.plugin");
    L15:
        return Api23Impl.getDeviceId(r7, r1);
    L24:
        return r7.getDeviceId();
    }

    public static int getSubscriptionId(TelephonyManager r4) {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return Api30Impl.getSubscriptionId(r4);
    L7:
        if (Build.VERSION.SDK_INT >= 22) goto L20;
        return Integer.MAX_VALUE;
    L20:
        if (sGetSubIdMethod != null) goto L11;
        Method r0 = TelephonyManager.class.getDeclaredMethod("getSubId", new Class[0]);     // Catch: Throwable -> L19
        sGetSubIdMethod = r0;     // Catch: Throwable -> L19
        r0.setAccessible(true);     // Catch: Throwable -> L19
    L11:
        Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(sGetSubIdMethod.invoke(r4, new Object[0]), Integer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        if (r5 != null) goto L14;
        return Integer.MAX_VALUE;
    L14:
        if (r5.intValue() == (-1)) goto L23;
        return r5.intValue();
    L23:
        return Integer.MAX_VALUE;
    L24:
        return Integer.MAX_VALUE;
    }
}
