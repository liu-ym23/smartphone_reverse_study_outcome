package com.ss.thor;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static BatteryManager f15770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static IntentFilter f15771b;

    static {
        f15771b = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    }

    public c() {
    }

    public static float a(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return -1.0f;
    L5:
        Intent r7 = ZeusTransformUtils.registerReceiver(r6, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), "com.obric.memorydata.plugin");
        if (r7 != null) goto L9;
        return -1.0f;
    L9:
        return r7.getIntExtra("voltage", -1) / 1000.0f;
    }

    public static float b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L32;
        if (r5 == null) goto L32;
        BatteryManager r6 = d(r5);
        if (r6 != null) goto L9;
        return -1.0f;
    L9:
        float r7 = r6.getLongProperty(2);
        if (r7 < (-1.0E7f)) goto L32;
        if (r7 > 1.0E7f) goto L32;
        if (d.b() == true) goto L28;
        if (d.c() == true) goto L28;
        if (d.a() == false) goto L26;
        if (r7 > 10000.0f) goto L24;
        return r7;
    L24:
        return r7 / 1000.0f;
    L26:
        return r7 / 1000.0f;
    L28:
        if (r7 >= (-10000.0f)) goto L31;
        r7 = r7 / 1000.0f;
    L31:
        return -r7;
    L32:
        return -1.0f;
    }

    public static long c(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L11;
        if (r5 == null) goto L11;
        BatteryManager r6 = d(r5);
        if (r6 != null) goto L10;
        return -1;
    L10:
        return r6.getLongProperty(4);
    L11:
        return -1;
    }

    private static BatteryManager d(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (f15770a != null) goto L20;
        monitor-enter(c.class);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (f15770a == null) goto L9;
    L14:
        monitor-exit(c.class);     // Catch: Throwable -> L16
        goto L20
    L9:
        if (Build.VERSION.SDK_INT < 21) goto L11;
        f15770a = (BatteryManager) ZeusTransformUtils.preCheckCast(r4.getSystemService("batterymanager"), BatteryManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        goto L14
    L11:
        monitor-exit(c.class);     // Catch: Throwable -> L16
        return null;
    L20:
        return f15770a;
    }
}
