package ub;

import android.content.Context;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static BatteryManager f13148a;

    static {
        new IntentFilter("android.intent.action.BATTERY_CHANGED");
    }

    public c() {
    }

    private static BatteryManager a(Context r10) {
        if (f13148a != null) goto L20;
        monitor-enter(c.class);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (f13148a == null) goto L9;
    L14:
        monitor-exit(c.class);     // Catch: Throwable -> L16
        goto L20
    L9:
        if (Build.VERSION.SDK_INT < 21) goto L11;
        f13148a = (BatteryManager) r10.getSystemService("batterymanager");     // Catch: Throwable -> L16
        goto L14
    L11:
        monitor-exit(c.class);     // Catch: Throwable -> L16
        return null;
    L20:
        return f13148a;
    }

    public static float b(Context r10) {
        if (Build.VERSION.SDK_INT < 21) goto L32;
        if (r10 == null) goto L32;
        BatteryManager r11 = a(r10);
        if (r11 != null) goto L9;
        return -1.0f;
    L9:
        float r12 = r11.getLongProperty(2);
        if (r12 < (-1.0E7f)) goto L32;
        if (r12 > 1.0E7f) goto L32;
        if (d.c() == true) goto L28;
        if (d.b() == true) goto L28;
        if (d.a() == false) goto L26;
        if (r12 > 10000.0f) goto L24;
        return r12;
    L24:
        return r12 / 1000.0f;
    L26:
        return r12 / 1000.0f;
    L28:
        if (r12 >= (-10000.0f)) goto L31;
        r12 = r12 / 1000.0f;
    L31:
        return -r12;
    L32:
        return -1.0f;
    }
}
