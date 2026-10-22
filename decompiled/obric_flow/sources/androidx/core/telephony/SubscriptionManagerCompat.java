package androidx.core.telephony;

import android.telephony.SubscriptionManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(22)
public class SubscriptionManagerCompat {
    private static Method sGetSlotIndexMethod;

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static int getSlotIndex(int r5) {
            return SubscriptionManager.getSlotIndex(r5);
        }
    }

    private SubscriptionManagerCompat() {
    }

    public static int getSlotIndex(int r5) {
        if (r5 != (-1)) goto L6;
        return -1;
    L6:
        return Api29Impl.getSlotIndex(r5);
    }
}
