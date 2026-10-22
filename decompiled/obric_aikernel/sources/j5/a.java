package j5;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import g5.c;
import h5.b;

/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PowerManager f9769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BatteryManager f9770d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f9771e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f9772f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f9773g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f9774h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f9775i;

    public a(Context r10, c r11) {
        super(r10, r11);
        this.f9771e = false;
        this.f9772f = -1;
        this.f9773g = 0;
        this.f9774h = 0.0f;
        this.f9775i = 0;
        this.f9769c = (PowerManager) this.f9182a.getSystemService("power");
        this.f9770d = (BatteryManager) this.f9182a.getSystemService("batterymanager");
    }

    private int e() {
        if (Build.VERSION.SDK_INT < 21) goto L8;
        PowerManager r10 = this.f9769c;
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.isPowerSaveMode() ? 1 : 0;
    L8:
        return -1;
    }

    private boolean g() {
        if (Build.VERSION.SDK_INT < 23) goto L8;
        BatteryManager r10 = this.f9770d;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.isCharging();
    L8:
        return false;
    }

    private synchronized void i() {
        monitor-enter(this);
        long r10 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L23
        long r11 = this.f9775i;     // Catch: Throwable -> L23
        if (r11 != 0) goto L6;
    L7:
        this.f9775i = r10;     // Catch: Throwable -> L23
        Intent r12 = this.f9182a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));     // Catch: Throwable -> L23
        if (r12 != null) goto L11;
        monitor-exit(this);
        return;
    L11:
        int r13 = r12.getIntExtra("status", -1);     // Catch: Throwable -> L23
        this.f9772f = r13;     // Catch: Throwable -> L23
        if (r13 != 2) goto L14;
    L19:
        boolean r14 = true;
    L20:
        this.f9771e = r14;     // Catch: Throwable -> L23
        this.f9773g = r12.getIntExtra("level", 0);     // Catch: Throwable -> L23
        this.f9774h = r12.getIntExtra("temperature", 0) / 10.0f;     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);
        return;
    L14:
        if (r13 == 5) goto L16;
    L18:
        r14 = false;
        goto L20
    L16:
        if (g() == false) goto L18;
    L6:
        if ((r10 - r11) < 5000) goto L21;
    L23:
        th = move-exception;
        throw th;
    }

    public int c() {
        i();
        return this.f9773g;
    }

    public float d() {
        i();
        return this.f9774h;
    }

    public boolean f() {
        i();
        return this.f9771e;
    }

    public int h() {
        return e();
    }
}
