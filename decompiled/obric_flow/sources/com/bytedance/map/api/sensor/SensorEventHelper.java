package com.bytedance.map.api.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.WindowManager;
import com.bytedance.amap.model.AliMarker;
import com.bytedance.map.api.model.IMarker;
import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: classes2.dex */
public class SensorEventHelper implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SensorManager f6935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Sensor f6936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f6937c;
    public float d;
    public final LynxContext e;
    public IMarker f;

    public SensorEventHelper(LynxContext r5) {
        this.f6937c = 0;
        this.e = r5;
        SensorManager r10 = (SensorManager) r5.getSystemService("sensor");
        this.f6935a = r10;
        this.f6936b = r10.getDefaultSensor(3);
    }

    public final void a() {
        this.f6935a.registerListener(this, this.f6936b, 3);
    }

    public final void b() {
        this.f6935a.unregisterListener(this, this.f6936b);
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor r5, int r10) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent r5) {
        if ((System.currentTimeMillis() - this.f6937c) >= 100) goto L6;
        return;
    L6:
        if (r5.sensor.getType() != 3) goto L35;
        int r10 = 0;
        float r11 = r5.values[0];
        int r12 = ((WindowManager) this.e.getSystemService("window")).getDefaultDisplay().getRotation();
        if (r12 != 1) goto L11;
        r10 = 90;
    L17:
        float r13 = (r11 + r10) % 360.0f;
        if (r13 <= 180.0f) goto L21;
        r13 = r13 - 360.0f;
    L24:
        if (Math.abs(this.d - r13) >= 3.0f) goto L27;
        return;
    L27:
        if (Float.isNaN(r13) == false) goto L29;
        r13 = 0.0f;
    L29:
        this.d = r13;
        IMarker r14 = this.f;
        if (r14 == null) goto L32;
        ((AliMarker) r14).b(360.0f - r13);
    L32:
        this.f6937c = System.currentTimeMillis();
        return;
    L21:
        if (r13 >= (-180.0f)) goto L24;
        r13 = r13 + 360.0f;
        goto L24
    L11:
        if (r12 == 2) goto L15;
        if (r12 != 3) goto L17;
        r10 = -90;
        goto L17
    L15:
        r10 = 180;
        goto L17
    }
}
