package androidx.work.impl.utils;

import android.os.PowerManager;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
final class WakeLocksHolder {
    public static final WakeLocksHolder INSTANCE = null;
    private static final WeakHashMap<PowerManager.WakeLock, String> wakeLocks = null;

    static {
        INSTANCE = new WakeLocksHolder();
        wakeLocks = new WeakHashMap();
    }

    private WakeLocksHolder() {
    }

    public final WeakHashMap<PowerManager.WakeLock, String> getWakeLocks() {
        return wakeLocks;
    }
}
