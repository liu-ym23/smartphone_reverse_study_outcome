package i60;

import android.os.SystemClock;
import com.bytedance.android.live.base.model.message.n5;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public static final SettingKey<Boolean> a = null;
    public static final SettingKey<Boolean> b = null;
    public static final SettingKey<Boolean> c = null;
    public static long d;
    public static String e;
    public static long f;
    public static String g;

    static {
        new SettingKey("live_mt_enable_instant_cpu_rate", "mt是否使用采取瞬时获取cpurate的方法，1为是", 1, 1);
        Boolean r1 = Boolean.FALSE;
        a = new SettingKey("live_mt_enable_use_proc_file_cpu_rate", "mt是否在8.0以下使用proc计算CPU使用率", r1, r1);
        Boolean r3 = Boolean.TRUE;
        b = new SettingKey("live_mt_enable_cpu_rate", "mt是否使用CPU利用率（proc/stat 或者 adb top）", r3, r3);
        c = new SettingKey("live_mt_enable_cpu_speed_rate", "mt是否使用Jiffies计算CPU使用速率", r1, r1);
        d = -1;
        e = "";
        f = -1;
        g = "";
    }

    public static String a() {
        if (c.getValue().booleanValue() == false) goto L11;
        if ((SystemClock.elapsedRealtime() - f) <= n5.DEFAULT_SHOW_DURATION) goto L11;
        if (a.b != null) goto L9;
        a.b = new j60.a();
    L9:
        a.b.a();
        Logger.d("CommonMonitorUtil", "cpu Rate: " + a.b.b + ", cpu speed" + a.b.f);
        g = String.valueOf(a.b.f);
        f = SystemClock.elapsedRealtime();
    L11:
        return g;
    }

    public static String b() {
        if (b.getValue().booleanValue() == false) goto L14;
        if ((SystemClock.elapsedRealtime() - d) <= n5.DEFAULT_SHOW_DURATION) goto L14;
        if (a.c() == true) goto L9;
    L11:
        double r0 = a.d();
    L12:
        e = String.valueOf(r0);
        d = SystemClock.elapsedRealtime();
        goto L14
    L9:
        if (a.getValue().booleanValue() == false) goto L11;
        r0 = a.b();
    L14:
        return e;
    }
}
