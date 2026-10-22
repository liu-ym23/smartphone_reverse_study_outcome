package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.Logger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@JvmName(name = "WakeLocks")
public final class WakeLocks {
    private static final String TAG = null;

    static {
        String r10 = Logger.tagWithPrefix("WakeLocks");
        Intrinsics.checkNotNullExpressionValue(r10, "tagWithPrefix(\"WakeLocks\")");
        TAG = r10;
    }

    public static final void checkWakeLocks() {
        LinkedHashMap r10 = new LinkedHashMap();
        WakeLocksHolder r11 = WakeLocksHolder.INSTANCE;
        monitor-enter(r11);
        r10.putAll(r11.getWakeLocks());     // Catch: Throwable -> L18
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r11);
        Iterator r13 = r10.entrySet().iterator();
    L8:
        if (r13.hasNext() == false) goto L17;
        Map.Entry r14 = (Map.Entry) r13.next();
        PowerManager.WakeLock r15 = (PowerManager.WakeLock) r14.getKey();
        String r16 = (String) r14.getValue();
        boolean r17 = true;
        if (r15 != null) goto L12;
    L14:
        r17 = false;
    L15:
        if (r17 == false) goto L8;
        Logger.get().warning(TAG, "WakeLock held for " + r16);
        goto L8
    L12:
        if (r15.isHeld() != true) goto L14;
    L17:
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public static final PowerManager.WakeLock newWakeLock(Context r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "tag");
        Object r12 = r10.getApplicationContext().getSystemService("power");
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.os.PowerManager");
        String r13 = "WorkManager: " + r11;
        PowerManager.WakeLock r14 = ((PowerManager) r12).newWakeLock(1, r13);
        WakeLocksHolder r15 = WakeLocksHolder.INSTANCE;
        monitor-enter(r15);
        String r16 = r15.getWakeLocks().put(r14, r13);     // Catch: Throwable -> L8
        monitor-exit(r15);
        Intrinsics.checkNotNullExpressionValue(r14, "wakeLock");
        return r14;
    L8:
        th = move-exception;
        throw th;
    }
}
