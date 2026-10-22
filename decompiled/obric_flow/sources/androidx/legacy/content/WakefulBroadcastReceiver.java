package androidx.legacy.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;

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

    public static boolean completeWakefulIntent(Intent r5) {
        int r10 = r5.getIntExtra(EXTRA_WAKE_LOCK_ID, 0);
        if (r10 != 0) goto L5;
        return false;
    L5:
        SparseArray<PowerManager.WakeLock> r11 = sActiveWakeLocks;
        monitor-enter(r11);
        PowerManager.WakeLock r12 = r11.get(r10);     // Catch: Throwable -> L12
        if (r12 == null) goto L14;
        r12.release();     // Catch: Throwable -> L12
        r11.remove(r10);     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
        return true;
    L14:
        Log.w("WakefulBroadcastReceiv.", "No active wake lock id #" + r10);     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
        return true;
    L12:
        th = move-exception;
        throw th;
    }

    public static ComponentName startWakefulService(Context r5, Intent r10) {
        SparseArray<PowerManager.WakeLock> r11 = sActiveWakeLocks;
        monitor-enter(r11);
        int r12 = mNextId;     // Catch: Throwable -> L7
        int r13 = r12 + 1;     // Catch: Throwable -> L7
        mNextId = r13;     // Catch: Throwable -> L7
        if (r13 > 0) goto L9;
        mNextId = 1;     // Catch: Throwable -> L7
    L9:
        r10.putExtra(EXTRA_WAKE_LOCK_ID, r12);     // Catch: Throwable -> L7
        ComponentName r14 = r5.startService(r10);     // Catch: Throwable -> L7
        if (r14 != null) goto L14;
        monitor-exit(r11);     // Catch: Throwable -> L7
        return null;
    L14:
        PowerManager.WakeLock r15 = ((PowerManager) r5.getSystemService("power")).newWakeLock(1, "androidx.core:wake:" + r14.flattenToShortString());     // Catch: Throwable -> L7
        r15.setReferenceCounted(false);     // Catch: Throwable -> L7
        r15.acquire(60000);     // Catch: Throwable -> L7
        r11.put(r12, r15);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r14;
    L7:
        th = move-exception;
        throw th;
    }
}
