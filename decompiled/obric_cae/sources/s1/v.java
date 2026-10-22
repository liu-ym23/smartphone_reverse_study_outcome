package s1;

import android.content.Context;
import android.os.PowerManager;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;

/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f12005a = null;

    static {
        String r8 = androidx.work.m.f("WakeLocks");
        he.i.e(r8, "tagWithPrefix(\"WakeLocks\")");
        f12005a = r8;
    }

    public static final PowerManager.WakeLock a(Context r8, String r10) {
        he.i.f(r8, "context");
        he.i.f(r10, LocationMonitorConst.TAG);
        Object r11 = r8.getApplicationContext().getSystemService("power");
        he.i.d(r11, "null cannot be cast to non-null type android.os.PowerManager");
        String r12 = "WorkManager: ".concat(r10);
        PowerManager.WakeLock r13 = ((PowerManager) r11).newWakeLock(1, r12);
        w r14 = w.f12006a;
        monitor-enter(r14);
        String r15 = w.f12007b.put(r13, r12);     // Catch: Throwable -> L8
        monitor-exit(r14);
        he.i.e(r13, "wakeLock");
        return r13;
    L8:
        th = move-exception;
        throw th;
    }
}
