package iba;

import android.content.Context;
import android.os.UserManager;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Method;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final long a(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Object r10 = r9.getSystemService("user");
        Number r2 = null;
        if ((r10 instanceof UserManager) == false) goto L5;
        UserManager r11 = (UserManager) r10;
    L7:
        if (r11 != null) goto L20;
        FLogger.a.e("UserUnlockRealtimeCompat", "getUserUnlockRealtime failed: UserManager unavailable");
        return -1;
    L20:
        Method r5 = UserManager.class.getDeclaredMethod("getUserUnlockRealtime", new Class[0]);     // Catch: Exception -> L17
        r5.setAccessible(true);     // Catch: Exception -> L17
        Object r12 = r5.invoke(r11, new Object[0]);     // Catch: Exception -> L17
        if ((r12 instanceof Number) == false) goto L13;
        r2 = (Number) r12;     // Catch: Exception -> L17
    L13:
        if (r2 != null) goto L21;
        FLogger.a.e("UserUnlockRealtimeCompat", "getUserUnlockRealtime failed: unexpected value=" + r12);     // Catch: Exception -> L17
        return -1;
    L21:
        return r2.longValue();
    L17:
        e = move-exception;
        FLogger.a.e("UserUnlockRealtimeCompat", "getUserUnlockRealtime failed", e);
        return -1;
    L5:
        r11 = null;
        goto L7
    }
}
