package androidx.legacy.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {
    private static final String EXTRA_WAKE_LOCK_ID = "androidx.contentpager.content.wakelockid";
    private static int mNextId;
    private static final SparseArray<PowerManager.WakeLock> sActiveWakeLocks = null;

    static {
        sActiveWakeLocks = new SparseArray();
        mNextId = 1;
    }

    public WakefulBroadcastReceiver() {
    }

    public static boolean completeWakefulIntent(Intent r10) {
        int r11 = r10.getIntExtra(EXTRA_WAKE_LOCK_ID, 0);
        if (r11 != 0) goto L5;
        return false;
    L5:
        SparseArray<PowerManager.WakeLock> r12 = sActiveWakeLocks;
        monitor-enter(r12);
        PowerManager.WakeLock r13 = r12.get(r11);     // Catch: Throwable -> L15
        if (r13 == null) goto L12;
        r13.release();     // Catch: Throwable -> L15
        r12.remove(r11);     // Catch: Throwable -> L15
        monitor-exit(r12);     // Catch: Throwable -> L15
        return true;
    L12:
        Log.w("WakefulBroadcastReceiv.", "No active wake lock id #" + r11);     // Catch: Throwable -> L15
        monitor-exit(r12);     // Catch: Throwable -> L15
        return true;
    L15:
        th = move-exception;
        throw th;
    }

    public static ComponentName startWakefulService(Context r10, Intent r11) {
        SparseArray<PowerManager.WakeLock> r12 = sActiveWakeLocks;
        monitor-enter(r12);
        int r13 = mNextId;     // Catch: Throwable -> L15
        int r14 = r13 + 1;     // Catch: Throwable -> L15
        mNextId = r14;     // Catch: Throwable -> L15
        if (r14 > 0) goto L7;
        mNextId = 1;     // Catch: Throwable -> L15
    L7:
        r11.putExtra(EXTRA_WAKE_LOCK_ID, r13);     // Catch: Throwable -> L15
        ComponentName r15 = r10.startService(r11);     // Catch: Throwable -> L15
        if (r15 == null) goto L10;
        PowerManager.WakeLock r16 = ((PowerManager) r10.getSystemService("power")).newWakeLock(1, "androidx.core:wake:" + r15.flattenToShortString());     // Catch: Throwable -> L15
        r16.setReferenceCounted(false);     // Catch: Throwable -> L15
        r16.acquire(VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER);     // Catch: Throwable -> L15
        r12.put(r13, r16);     // Catch: Throwable -> L15
        monitor-exit(r12);     // Catch: Throwable -> L15
        return r15;
    L10:
        monitor-exit(r12);     // Catch: Throwable -> L15
        return null;
    L15:
        th = move-exception;
        throw th;
    }
}
