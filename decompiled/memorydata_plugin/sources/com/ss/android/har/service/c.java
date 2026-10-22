package com.ss.android.har.service;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
class c implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SensorManager f15236b;
    private Sensor c;
    private Sensor d;
    private Sensor e;
    private boolean f;
    private a g;
    private boolean h;
    private boolean i;
    private boolean j;
    private List<Float> k;
    private List<Float> l;
    private List<Float> m;
    private List<Float> n;
    private List<Float> o;
    private List<Float> p;
    private List<Float> q;
    private List<Float> r;
    private List<Float> s;

    public interface a {
        void a(float[] r1);
    }

    private void b() {
        if (b.f15233a == false) goto L5;
        long r0 = System.currentTimeMillis();
    L6:
        boolean r2 = this.f;
        SensorManager r3 = this.f15236b;
        Sensor r4 = this.c;
        Sensor r5 = this.d;
        Sensor r6 = this.e;
        if (r2 == false) goto L14;
        if (r3 == null) goto L14;
        if (r4 == null) goto L14;
        if (r5 == null) goto L14;
        if (r6 == null) goto L14;
        r3.unregisterListener(this, r4);
        r3.unregisterListener(this, r5);
        r3.unregisterListener(this, r6);
        this.f = false;
    L14:
        if (b.f15233a == false) goto L17;
        b.a("HAR", "HarSensorManager.unregister cost:" + (System.currentTimeMillis() - r0) + " hasRegister:" + r2);
        return;
    L17:
        return;
    L5:
        r0 = 0;
        goto L6
    }

    private void c() {
        if (this.k.size() >= 100) goto L5;
        return;
    L5:
        if (this.l.size() >= 100) goto L7;
        return;
    L7:
        if (this.m.size() >= 100) goto L9;
        return;
    L9:
        if (this.n.size() >= 100) goto L11;
        return;
    L11:
        if (this.o.size() >= 100) goto L13;
        return;
    L13:
        if (this.p.size() >= 100) goto L15;
        return;
    L15:
        if (this.q.size() >= 100) goto L17;
        return;
    L17:
        if (this.r.size() >= 100) goto L19;
        return;
    L19:
        if (this.s.size() < 100) goto L48;
        int r0 = this.k.size();
        int r2 = this.n.size();
        int r3 = this.q.size();
        if (b.f15233a == false) goto L23;
        long r4 = System.currentTimeMillis();
    L24:
        float[] r7 = new float[900];
        int r9 = 0;
    L25:
        if (r9 >= 100) goto L27;
        int r10 = r9 * 9;
        r7[r10 + 0] = ((Float) ZeusTransformUtils.preCheckCast(this.k.get(r9), Float.class, "com.obric.memorydata.plugin")).floatValue();
        r7[r10 + 1] = ((Float) ZeusTransformUtils.preCheckCast(this.l.get(r9), Float.class, "com.obric.memorydata.plugin")).floatValue();
        r7[r10 + 2] = ((Float) ZeusTransformUtils.preCheckCast(this.m.get(r9), Float.class, "com.obric.memorydata.plugin")).floatValue();
        r7[r10 + 3] = ((Float) ZeusTransformUtils.preCheckCast(this.q.get(r9), Float.class, "com.obric.memorydata.plugin")).floatValue();
        r7[r10 + 4] = ((Float) ZeusTransformUtils.preCheckCast(this.r.get(r9), Float.class, "com.obric.memorydata.plugin")).floatValue();
        r7[r10 + 5] = ((Float) ZeusTransformUtils.preCheckCast(this.s.get(r9), Float.class, "com.obric.memorydata.plugin")).floatValue();
        r7[r10 + 6] = ((Float) ZeusTransformUtils.preCheckCast(this.n.get(r9), Float.class, "com.obric.memorydata.plugin")).floatValue();
        r7[r10 + 7] = ((Float) ZeusTransformUtils.preCheckCast(this.o.get(r9), Float.class, "com.obric.memorydata.plugin")).floatValue();
        r7[r10 + 8] = ((Float) ZeusTransformUtils.preCheckCast(this.p.get(r9), Float.class, "com.obric.memorydata.plugin")).floatValue();
        r9 = r9 + 1;
        goto L25
    L27:
        this.k.clear();
        this.l.clear();
        this.m.clear();
        this.q.clear();
        this.r.clear();
        this.s.clear();
        this.n.clear();
        this.o.clear();
        this.p.clear();
        if (b.f15233a == false) goto L30;
        b.a("HAR", "HarSensorManager.buildPredictInputData cost: " + (System.currentTimeMillis() - r4) + " aSize:" + r0 + " gSize:" + r2 + " lSize:" + r3 + " inputs.size:900");
    L30:
        a r1 = this.g;
        if (r1 == null) goto L34;
        r1.a(r7);
    L34:
        if (this.h == false) goto L49;
        this.h = false;
        this.i = true;
        if (b.f15233a == false) goto L50;
        b.a("HAR", "HarSensorManager.onlyTrackDataOnce");
        return;
    L50:
        return;
    L49:
        return;
    L23:
        r4 = 0;
        goto L24
    }

    public void a() {
        if (b.f15233a == false) goto L5;
        b.a("HAR", "HarSensorManager.stop");
    L5:
        this.j = false;
        b();
    }

    public void a(boolean r3) {
        if (b.f15233a == false) goto L5;
        b.a("HAR", "HarSensorManager.onlyTrackDataOnceWithSensorKeepRegister only:" + r3);
    L5:
        this.h = r3;
        this.i = false;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor r1, int r2) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent r8) {
        if (this.f15235a == true) goto L5;
        return;
    L5:
        if (this.j == true) goto L7;
        return;
    L7:
        if (this.i == true) goto L26;
        Sensor r0 = r8.sensor;
        if (r0.getType() != 1) goto L15;
        if (this.k.size() >= 300) goto L27;
        this.k.add(Float.valueOf(r8.values[0]));
        this.l.add(Float.valueOf(r8.values[1]));
        List<Float> r1 = this.m;
        float r9 = r8.values[2];
    L13:
        r1.add(Float.valueOf(r9));
        c();
        return;
    L27:
        return;
    L15:
        if (r0.getType() != 4) goto L20;
        if (this.n.size() >= 300) goto L29;
        this.n.add(Float.valueOf(r8.values[0]));
        this.o.add(Float.valueOf(r8.values[1]));
        r1 = this.p;
        r9 = r8.values[2];
        goto L13
    L29:
        return;
    L20:
        if (r0.getType() == 10) goto L22;
        return;
    L22:
        if (this.q.size() >= 300) goto L31;
        this.q.add(Float.valueOf(r8.values[0]));
        this.r.add(Float.valueOf(r8.values[1]));
        r1 = this.s;
        r9 = r8.values[2];
        goto L13
    L31:
        return;
    }
}
