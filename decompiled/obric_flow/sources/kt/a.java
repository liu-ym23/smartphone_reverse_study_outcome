package kt;

import android.content.Context;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.text.TextUtils;
import wn.f;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static BatteryManager f19479a;

    static {
        new IntentFilter("android.intent.action.BATTERY_CHANGED");
    }

    public static float a(Context r10) {
        if (r10 != null) goto L6;
        return -1.0f;
    L6:
        if (f19479a == null) goto L8;
    L18:
        BatteryManager r11 = f19479a;
        if (r11 != null) goto L21;
        return -1.0f;
    L21:
        int r5 = 2;
        float r12 = r11.getLongProperty(2);
        if (r12 >= (-1.0E7f)) goto L24;
    L75:
        return -1.0f;
    L24:
        if (r12 > 1.0E7f) goto L75;
        int r13 = f.f22891b;
        if (r13 == 3) goto L30;
        if (r13 == 1) goto L54;
    L41:
        int r14 = f.f22892c;
        if (r14 == 3) goto L45;
        if (r14 == 1) goto L54;
    L58:
        int r15 = f.f22890a;
        if (r15 == 3) goto L62;
        if (r15 == 1) goto L70;
    L74:
        return r12 / 1000.0f;
    L70:
        if (r12 > 10000.0f) goto L72;
        return r12;
    L72:
        return r12 / 1000.0f;
    L62:
        String r16 = Build.BRAND;
        if (TextUtils.isEmpty(r16) == false) goto L65;
    L67:
        f.f22890a = r5;
        if (r5 != 1) goto L74;
    L65:
        if (r16.toLowerCase().contains("oppo") == false) goto L67;
        r5 = 1;
        goto L67
    L45:
        String r17 = Build.BRAND;
        if (TextUtils.isEmpty(r17) == false) goto L48;
    L50:
        int r18 = 2;
    L51:
        f.f22892c = r18;
        if (r18 != 1) goto L58;
    L48:
        if (r17.toLowerCase().contains("samsung") == false) goto L50;
        r18 = 1;
    L54:
        if (r12 >= (-10000.0f)) goto L57;
        r12 = r12 / 1000.0f;
    L57:
        return -r12;
    L30:
        String r19 = Build.HARDWARE;
        if (TextUtils.isEmpty(r19) == false) goto L33;
    L37:
        int r20 = 2;
    L38:
        f.f22891b = r20;
        if (r20 != 1) goto L41;
    L33:
        if (r19.toLowerCase().contains("hi") == false) goto L35;
    L36:
        r20 = 1;
        goto L38
    L35:
        if (r19.toLowerCase().contains("kirin") == false) goto L37;
    L8:
        monitor-enter(a.class);
    L12:
        th = move-exception;
        throw th;
    L10:
        if (f19479a != null) goto L14;
        f19479a = (BatteryManager) r10.getSystemService("batterymanager");     // Catch: Throwable -> L12
    L14:
        monitor-exit(a.class);     // Catch: Throwable -> L12
        goto L18
    }
}
