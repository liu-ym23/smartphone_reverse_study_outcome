package androidx.core.telephony;

import android.annotation.SuppressLint;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class TelephonyManagerCompat {
    private static Method sGetDeviceIdMethod;
    private static Method sGetSubIdMethod;

    @RequiresApi(23)
    private static class Api23Impl {
        private Api23Impl() {
        }

        @SuppressLint({"MissingPermission"})
        @Nullable
        @RequiresPermission("android.permission.READ_PHONE_STATE")
        @DoNotInline
        static String getDeviceId(TelephonyManager r10, int r11) {
            return r10.getDeviceId(r11);
        }
    }

    @RequiresApi(26)
    private static class Api26Impl {
        private Api26Impl() {
        }

        @SuppressLint({"MissingPermission"})
        @Nullable
        @RequiresPermission("android.permission.READ_PHONE_STATE")
        @DoNotInline
        static String getImei(TelephonyManager r10) {
            return r10.getImei();
        }
    }

    @RequiresApi(30)
    private static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static int getSubscriptionId(TelephonyManager r10) {
            return r10.getSubscriptionId();
        }
    }

    private TelephonyManagerCompat() {
    }

    @Nullable
    @RequiresPermission("android.permission.READ_PHONE_STATE")
    @SuppressLint({"MissingPermission"})
    public static String getImei(@NonNull TelephonyManager r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 26) goto L7;
        return Api26Impl.getImei(r10);
    L7:
        if (r11 < 22) goto L24;
        int r12 = getSubscriptionId(r10);
        if (r12 == Integer.MAX_VALUE) goto L24;
        if (r12 == (-1)) goto L24;
        int r13 = SubscriptionManagerCompat.getSlotIndex(r12);
        if (r11 >= 23) goto L15;
    L21:
        return null;
    L17:
        if (sGetDeviceIdMethod != null) goto L19;
        Method r14 = TelephonyManager.class.getDeclaredMethod("getDeviceId", new Class[]{Integer.TYPE});     // Catch: Throwable -> L21
        sGetDeviceIdMethod = r14;     // Catch: Throwable -> L21
        r14.setAccessible(true);     // Catch: Throwable -> L21
    L19:
        return (String) sGetDeviceIdMethod.invoke(r10, new Object[]{Integer.valueOf(r13)});
    L15:
        return Api23Impl.getDeviceId(r10, r13);
    L24:
        return r10.getDeviceId();
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static int getSubscriptionId(@NonNull TelephonyManager r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 30) goto L7;
        return Api30Impl.getSubscriptionId(r10);
    L7:
        if (r11 >= 22) goto L20;
        return Integer.MAX_VALUE;
    L20:
        if (sGetSubIdMethod != null) goto L11;
        Method r12 = TelephonyManager.class.getDeclaredMethod("getSubId", new Class[0]);     // Catch: Throwable -> L19
        sGetSubIdMethod = r12;     // Catch: Throwable -> L19
        r12.setAccessible(true);     // Catch: Throwable -> L19
    L11:
        Integer r13 = (Integer) sGetSubIdMethod.invoke(r10, new Object[0]);     // Catch: Throwable -> L19
        if (r13 != null) goto L14;
        return Integer.MAX_VALUE;
    L14:
        if (r13.intValue() == (-1)) goto L23;
        return r13.intValue();
    L23:
        return Integer.MAX_VALUE;
    L24:
        return Integer.MAX_VALUE;
    }
}
