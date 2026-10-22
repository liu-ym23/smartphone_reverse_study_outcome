package com.bytedance.watson.assist.b.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import com.bytedance.watson.assist.a.c;
import com.bytedance.watson.assist.b.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a extends b {
    private PowerManager c;
    private BatteryManager d;
    private boolean e;
    private int f;
    private int g;
    private float h;
    private long i;

    public a(Context r3, c r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin"));
        this.e = false;
        this.f = -1;
        this.g = 0;
        this.h = 0.0f;
        this.i = 0;
        this.c = (PowerManager) ZeusTransformUtils.preCheckCast(this.f3369a.getSystemService("power"), PowerManager.class, "com.obric.memorydata.plugin");
        this.d = (BatteryManager) ZeusTransformUtils.preCheckCast(this.f3369a.getSystemService("batterymanager"), BatteryManager.class, "com.obric.memorydata.plugin");
    }

    private int g() {
        if (Build.VERSION.SDK_INT < 21) goto L8;
        PowerManager r2 = this.c;
        if (r2 != null) goto L7;
        return -1;
    L7:
        return r2.isPowerSaveMode() ? 1 : 0;
    L8:
        return -1;
    }

    private synchronized void h() {
        monitor-enter(this);
        long r0 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L23
        long r2 = this.i;     // Catch: Throwable -> L23
        if (r2 != 0) goto L6;
    L7:
        this.i = r0;     // Catch: Throwable -> L23
        Intent r1 = ZeusTransformUtils.registerReceiver(this.f3369a, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (r1 != null) goto L11;
        monitor-exit(this);
        return;
    L11:
        int r3 = r1.getIntExtra("status", -1);     // Catch: Throwable -> L23
        this.f = r3;     // Catch: Throwable -> L23
        if (r3 != 2) goto L14;
    L19:
        boolean r4 = true;
    L20:
        this.e = r4;     // Catch: Throwable -> L23
        this.g = r1.getIntExtra("level", 0);     // Catch: Throwable -> L23
        this.h = r1.getIntExtra("temperature", 0) / 10.0f;     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);
        return;
    L14:
        if (r3 == 5) goto L16;
    L18:
        r4 = false;
        goto L20
    L16:
        if (i() == false) goto L18;
    L6:
        if ((r0 - r2) < 5000) goto L21;
    L23:
        th = move-exception;
        throw th;
    }

    private boolean i() {
        if (Build.VERSION.SDK_INT < 23) goto L8;
        BatteryManager r2 = this.d;
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.isCharging();
    L8:
        return false;
    }

    public boolean c() {
        h();
        return this.e;
    }

    public int d() {
        return g();
    }

    public int e() {
        h();
        return this.g;
    }

    public float f() {
        h();
        return this.h;
    }
}
