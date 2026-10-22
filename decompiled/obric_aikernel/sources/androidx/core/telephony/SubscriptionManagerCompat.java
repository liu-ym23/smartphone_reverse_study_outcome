package androidx.core.telephony;

import android.os.Build;
import android.telephony.SubscriptionManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(22)
public class SubscriptionManagerCompat {
    private static Method sGetSlotIndexMethod;

    @RequiresApi(29)
    private static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static int getSlotIndex(int r10) {
            return SubscriptionManager.getSlotIndex(r10);
        }
    }

    private SubscriptionManagerCompat() {
    }

    public static int getSlotIndex(int r10) {
        if (r10 != (-1)) goto L5;
        return -1;
    L5:
        int r11 = Build.VERSION.SDK_INT;
        if (r11 >= 29) goto L8;
        if (sGetSlotIndexMethod == null) goto L12;
    L17:
        Integer r12 = (Integer) sGetSlotIndexMethod.invoke(null, new Object[]{Integer.valueOf(r10)});     // Catch: Throwable -> L22
        if (r12 == null) goto L21;
        return r12.intValue();
    L12:
        if (r11 < 26) goto L15;
        Method r13 = SubscriptionManager.class.getDeclaredMethod("getSlotIndex", new Class[]{Integer.TYPE});     // Catch: Throwable -> L22
    L14:
        sGetSlotIndexMethod = r13;     // Catch: Throwable -> L22
        sGetSlotIndexMethod.setAccessible(true);     // Catch: Throwable -> L22
        goto L17
    L15:
        r13 = SubscriptionManager.class.getDeclaredMethod("getSlotId", new Class[]{Integer.TYPE});     // Catch: Throwable -> L22
    L21:
        return -1;
    L8:
        return Api29Impl.getSlotIndex(r10);
    }
}
