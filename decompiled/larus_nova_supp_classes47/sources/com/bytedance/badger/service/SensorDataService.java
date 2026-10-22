package com.bytedance.badger.service;

import a74.a;
import a74.l;
import a74.q;
import a74.r;
import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.IBinder;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.badger.e;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import fna.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import ona.b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class SensorDataService extends Service implements SensorEventListener {
    public static final /* synthetic */ int q = 0;
    public volatile int a;
    public volatile int b;
    public volatile long c;
    public boolean d;
    public boolean e;
    public SensorManager f;
    public Sensor g;
    public Sensor h;
    public final List i;
    public final List j;
    public volatile q k;
    public final Object l;
    public final AtomicBoolean m;
    public final AtomicBoolean n;
    public volatile PthreadHandlerThreadV2 o;
    public volatile Handler p;

    public SensorDataService() {
        this.a = 10;
        this.b = 3;
        this.c = 0;
        this.d = false;
        this.e = false;
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.l = new Object();
        this.m = new AtomicBoolean(false);
        this.n = new AtomicBoolean(false);
    }

    public static String c(List r12) {
        StringBuilder r0 = new StringBuilder();
        int r2 = 0;
    L4:
        if (r2 >= ((ArrayList) r12).size()) goto L10;
        float[] r3 = (float[]) ListProtector.get(r12, r2);
        if (r2 <= 0) goto L8;
        r0.append(":");
    L8:
        r0.append(String.format(Locale.US, "%.0f,%.0f,%.0f", new Object[]{Double.valueOf(((double) r3[0]) * 1.0E8d), Double.valueOf(((double) r3[1]) * 1.0E8d), Double.valueOf(((double) r3[2]) * 1.0E8d)}));
        r2 = r2 + 1;
        goto L4
    L10:
        return r0.toString();
    }

    public final void d() {
        Object r0 = this.l;
        monitor-enter(r0);
        q r1 = this.k;     // Catch: Throwable -> L23
        long r2 = this.c;     // Catch: Throwable -> L23
        ArrayList r4 = new ArrayList(this.i);     // Catch: Throwable -> L23
        ArrayList r5 = new ArrayList(this.j);     // Catch: Throwable -> L23
        ((ArrayList) this.i).clear();     // Catch: Throwable -> L23
        ((ArrayList) this.j).clear();     // Catch: Throwable -> L23
        this.k = null;     // Catch: Throwable -> L23
        this.d = false;     // Catch: Throwable -> L23
        this.e = false;     // Catch: Throwable -> L23
        this.c = 0;     // Catch: Throwable -> L23
        this.n.set(false);     // Catch: Throwable -> L23
        this.m.set(false);     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        if (r1 != null) goto L28;
        return;
    L28:
        JSONObject r3 = new JSONObject();     // Catch: JSONException -> L20
        if (r4.isEmpty() == true) goto L14;
        r3.put(DataType.TRUE, r2 + "#" + c(r4));     // Catch: JSONException -> L20
    L14:
        if (r5.isEmpty() == false) goto L17;
    L18:
        r1.a(r3);     // Catch: JSONException -> L20
        return;
    L17:
        r3.put("2", r2 + "#" + c(r5));     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        r1.a("JSON generation failed: " + e.getMessage());
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public final void f(String r6) {
        Object r0 = this.l;
        monitor-enter(r0);
        q r1 = this.k;     // Catch: Throwable -> L9
        this.k = null;     // Catch: Throwable -> L9
        this.d = false;     // Catch: Throwable -> L9
        this.e = false;     // Catch: Throwable -> L9
        this.c = 0;     // Catch: Throwable -> L9
        this.n.set(false);     // Catch: Throwable -> L9
        this.m.set(false);     // Catch: Throwable -> L9
        ((ArrayList) this.i).clear();     // Catch: Throwable -> L9
        ((ArrayList) this.j).clear();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (r1 == null) goto L14;
        r1.a(r6);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void g() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.o == null) goto L7;
        monitor-exit(this);
        return;
    L7:
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("Badger-Sensor", 10);     // Catch: Throwable -> L10
        ThreadMethodProxy.start(r0);     // Catch: Throwable -> L10
        this.o = r0;     // Catch: Throwable -> L10
        this.p = new Handler(r0.getLooper());     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor r1, int r2) {
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r1) {
        return new r(this);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        e.f("event_behavior# ", "onDestroy####");
        final PthreadHandlerThreadV2 r0 = this.o;
        Handler r1 = this.p;
        this.o = null;
        this.p = null;
        if (r0 == null) goto L6;
        if (r1 == null) goto L6;
        r1.post(new a(this, r0));
    L6:
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r1, int r2, int r3) {
        return 2;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        SensorManager r0 = (SensorManager) getSystemService("sensor");
        this.f = r0;
        this.g = r0.getDefaultSensor(1);
        this.h = this.f.getDefaultSensor(4);
        g();
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent r10) {
        if (this.m.get() == true) goto L5;
        return;
    L5:
        if (this.n.get() == true) goto L68;
        float[] r1 = r10.values;
        float[] r0 = {r1[0], r1[1], r1[2]};
        Object r2 = this.l;
        monitor-enter(r2);
    L56:
        th = move-exception;
        throw th;
    L10:
        if (this.c != 0) goto L12;
        this.c = System.currentTimeMillis();     // Catch: Throwable -> L56
    L12:
        int r12 = r10.sensor.getType();     // Catch: Throwable -> L56
        if (r12 == 1) goto L22;
        if (r12 == 4) goto L18;
    L25:
        if (this.d == true) goto L27;
    L30:
        boolean r13 = true;
    L32:
        if (this.e == true) goto L34;
    L37:
        boolean r3 = true;
    L39:
        if (this.d == false) goto L41;
    L42:
        if (r13 == false) goto L45;
        if (r3 == false) goto L45;
        boolean r14 = true;
    L46:
        monitor-exit(r2);     // Catch: Throwable -> L56
        if (r14 == true) goto L49;
        return;
    L49:
        if (this.n.compareAndSet(false, true) == false) goto L66;
        e.f("event_behavior# ", "stopSamplingInternal=" + ThreadMethodProxy.currentThread().getName());
        SensorManager r15 = this.f;     // Catch: Throwable -> L60
        if (r15 == null) goto L54;
        b(r15, this);     // Catch: Throwable -> L60
    L54:
        d();     // Catch: Throwable -> L60
        return;
    L67:
        return;
    L66:
        return;
    L45:
        r14 = false;
        goto L46
    L41:
        if (this.e == false) goto L45;
    L34:
        if (((ArrayList) this.j).size() >= this.a) goto L37;
        r3 = false;
        goto L39
    L27:
        if (((ArrayList) this.i).size() >= this.a) goto L30;
        r13 = false;
        goto L32
    L18:
        if (((ArrayList) this.j).size() >= this.a) goto L25;
        ArrayList r16 = (ArrayList) this.j;     // Catch: Throwable -> L56
    L20:
        r16.add(r0);     // Catch: Throwable -> L56
        goto L25
    L22:
        if (((ArrayList) this.i).size() >= this.a) goto L25;
        r16 = (ArrayList) this.i;     // Catch: Throwable -> L56
        goto L20
    }

    public static void b(SensorManager r1, SensorEventListener r2) {
        if (g.d() == true) goto L6;
        r1.unregisterListener(r2);
        return;
    L6:
        r1.unregisterListener(r2);
        if (r2 == null) goto L9;
        int r3 = r2.hashCode();
    L10:
        b.c(new ona.a(r3, null));
        return;
    L9:
        r3 = 0;
        goto L10
    }

    public final void e(int r6, int r7, l r8) {
        int r2 = 1;
        if (this.m.compareAndSet(false, true) == true) goto L7;
        r8.a("Service is already collecting data.");
        return;
    L7:
        if (this.g == null) goto L9;
    L12:
        e.b("sensor#", " start. size" + r6 + ",type" + r7);
        g();
        this.n.set(false);
        this.k = r8;
        Object r9 = this.l;
        monitor-enter(r9);
        ((ArrayList) this.i).clear();     // Catch: Throwable -> L33
        ((ArrayList) this.j).clear();     // Catch: Throwable -> L33
        this.c = 0;     // Catch: Throwable -> L33
        monitor-exit(r9);     // Catch: Throwable -> L33
        if (r6 > 0) goto L18;
        r6 = 10;
    L18:
        this.a = r6;
        if (r7 != 0) goto L21;
        r2 = 0;
    L27:
        this.b = r2;
        this.d = false;
        this.e = false;
        Handler r10 = this.p;
        if (r10 != null) goto L31;
        f("sensor_thread_null");
        return;
    L31:
        r10.post(new a74.b(this));
        return;
    L21:
        if (r7 == 20) goto L27;
        if (r7 == 60) goto L25;
        r2 = 3;
        goto L27
    L25:
        r2 = 2;
    L33:
        th = move-exception;
        throw th;
    L9:
        if (this.h != null) goto L12;
        r8.a("not support sensor");
        this.m.set(false);
    }

    public static boolean a(SensorManager r2, SensorDataService r3, Sensor r4, int r5, Handler r6) {
        if (g.d() == true) goto L6;
        Boolean r7 = Boolean.valueOf(r2.registerListener(r3, r4, r5, r6));
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type kotlin.Boolean");
        return r7.booleanValue();
    L6:
        Boolean r8 = Boolean.valueOf(r2.registerListener(r3, r4, r5, r6));
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlin.Boolean");
        boolean r9 = r8.booleanValue();
        b.a(new ona.a(r3.hashCode(), Integer.valueOf(r4.hashCode())));
        return r9;
    }
}
