package androidx.core.telephony;

import android.os.Build;
import android.telephony.SubscriptionManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class SubscriptionManagerCompat {
    private static Method sGetSlotIndexMethod;

    private static class Api29Impl {
        private Api29Impl() {
        }

        static int getSlotIndex(int r0) {
            return SubscriptionManager.getSlotIndex(r0);
        }
    }

    private SubscriptionManagerCompat() {
    }

    public static int getSlotIndex(int r7) {
        if (r7 != (-1)) goto L6;
        return -1;
    L6:
        if (Build.VERSION.SDK_INT >= 29) goto L8;
        if (sGetSlotIndexMethod == null) goto L12;
    L17:
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(sGetSlotIndexMethod.invoke(null, new Object[]{Integer.valueOf(r7)}), Integer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (r8 == null) goto L21;
        return r8.intValue();
    L12:
        if (Build.VERSION.SDK_INT < 26) goto L15;
        Method r1 = SubscriptionManager.class.getDeclaredMethod("getSlotIndex", new Class[]{Integer.TYPE});     // Catch: Throwable -> L22
    L14:
        sGetSlotIndexMethod = r1;     // Catch: Throwable -> L22
        sGetSlotIndexMethod.setAccessible(true);     // Catch: Throwable -> L22
        goto L17
    L15:
        r1 = SubscriptionManager.class.getDeclaredMethod("getSlotId", new Class[]{Integer.TYPE});     // Catch: Throwable -> L22
    L21:
        return -1;
    L8:
        return Api29Impl.getSlotIndex(r7);
    }
}
