package t3;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.bytedance.ai.bridge.method.device.DeviceSensorInterval;
import com.google.gson.JsonObject;
import java.lang.ref.WeakReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class c implements e3.b {
    public final int a;
    public final String b;
    public final String c;
    public final WeakReference<e3.d> d;
    public final Object e;
    public SensorManager f;
    public a g;
    public boolean h;

    public static final class a implements SensorEventListener {
        public final /* synthetic */ c a;

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor r1, int r10) {
        }

        public a(c r1) {
            this.a = r1;
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            c r0 = this.a;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
            e3.d r11 = r0.d.get();     // Catch: Throwable -> L11
            if (r11 == null) goto L8;
            r11.a(r0.b, r0.c(r10));     // Catch: Throwable -> L11
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L11
        L9:
            Result.constructor-impl(r12);     // Catch: Throwable -> L11
            return;
        L8:
            r12 = null;
        L11:
            th = move-exception;
            Result.Companion r13 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public abstract JsonObject c(SensorEvent r1);

    @Override // e3.b
    public final void a() {
        Object r0 = this.e;
        monitor-enter(r0);
        this.h = true;     // Catch: Throwable -> L20
        a r1 = this.g;     // Catch: Throwable -> L20
        if (r1 != null) goto L25;
    L17:
        this.g = null;     // Catch: Throwable -> L20
        this.f = null;     // Catch: Throwable -> L20
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r0);
        return;
    L25:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L14
        SensorManager r12 = this.f;     // Catch: Throwable -> L14
        if (r12 == null) goto L11;
        b(r12, r1);     // Catch: Throwable -> L14
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L12:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L14
    L16:
        Result.box-impl(r14);     // Catch: Throwable -> L20
        goto L17
    L11:
        r13 = null;
    L14:
        th = move-exception;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L20
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public final boolean d() {
        Object r0 = this.e;
        monitor-enter(r0);
        boolean r1 = this.h;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final void f() {
        Object r0 = this.e;
        monitor-enter(r0);
        a r1 = this.g;     // Catch: Throwable -> L19
        if (r1 != null) goto L24;
    L16:
        this.g = null;     // Catch: Throwable -> L19
        this.f = null;     // Catch: Throwable -> L19
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r0);
        return;
    L24:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L13
        SensorManager r12 = this.f;     // Catch: Throwable -> L13
        if (r12 == null) goto L10;
        b(r12, r1);     // Catch: Throwable -> L13
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L11:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L13
    L15:
        Result.box-impl(r14);     // Catch: Throwable -> L19
        goto L16
    L10:
        r13 = null;
    L13:
        th = move-exception;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L19
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public static void b(SensorManager r1, SensorEventListener r10) {
        if (fna.g.d() == true) goto L6;
        r1.unregisterListener(r10);
        return;
    L6:
        r1.unregisterListener(r10);
        ona.b.c(new ona.a(r10.hashCode(), null));
    }

    public final r0 e(DeviceSensorInterval r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "interval");
        Intrinsics.checkNotNullParameter(r11, "bridgeName");
        if (d() == true) goto L5;
        e3.d r1 = this.d.get();
        if (r1 == null) goto L9;
        Context r12 = e3.e.b(r1);
        if (r12 == null) goto L13;
        Context r13 = r12.getApplicationContext();
        if (r13 == null) goto L18;
        r12 = r13;
    L18:
        Object r14 = r12.getSystemService("sensor");
        r0 r15 = null;
        if ((r14 instanceof SensorManager) == false) goto L21;
        SensorManager r16 = (SensorManager) r14;
    L22:
        if (r16 == null) goto L24;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L31
        r4.k r18 = r4.a.k;     // Catch: Throwable -> L31
        if (r18 == null) goto L28;
        Sensor r19 = r18.e(r16, r1, r11, this.a);     // Catch: Throwable -> L31
    L29:
        Object r20 = Result.constructor-impl(r19);     // Catch: Throwable -> L31
    L33:
        Throwable r21 = Result.exceptionOrNull-impl(r20);
        if (r21 != null) goto L73;
        Sensor r22 = (Sensor) r20;
        if (r22 == null) goto L38;
        a r23 = new a(this);
        Object r24 = this.e;
        monitor-enter(r24);
    L69:
        th = move-exception;
        throw th;
    L42:
        if (this.h == false) goto L80;
        r0 r25 = new r0("context is null", f3.a.f);     // Catch: Throwable -> L69
    L67:
        monitor-exit(r24);
        return r25;
    L80:
    L60:
        e = move-exception;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L63
        b(r16, r23);     // Catch: Throwable -> L63
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L63
    L66:
        r25 = new r0("start sensor failed: " + e.getMessage(), f3.a.f);     // Catch: Throwable -> L69
    L63:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L69
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L69
        goto L66
    L46:
        if (r16.registerListener(r23, r22, r10.getSensorDelay()) == true) goto L48;
        r15 = new r0("failed to register sensor listener", f3.a.f);     // Catch: Exception -> L60 Throwable -> L69
    L59:
        r25 = r15;
        goto L67
    L48:
        SensorManager r28 = this.f;     // Catch: Exception -> L60 Throwable -> L69
        a r29 = this.g;     // Catch: Exception -> L60 Throwable -> L69
        this.f = r16;     // Catch: Exception -> L60 Throwable -> L69
        this.g = r23;     // Catch: Exception -> L60 Throwable -> L69
        if (r29 == null) goto L59;
        if (r28 != null) goto L74;
        Unit r30 = null;
    L55:
        Object r31 = Result.constructor-impl(r30);     // Catch: Throwable -> L52
    L58:
        Result.box-impl(r31);     // Catch: Exception -> L60 Throwable -> L69
    L52:
        th = move-exception;
        Result.Companion r32 = Result.Companion;     // Catch: Exception -> L60 Throwable -> L69
        r31 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L60 Throwable -> L69
        goto L58
    L74:
        b(r28, r29);     // Catch: Throwable -> L52
        r30 = Unit.INSTANCE;     // Catch: Throwable -> L52
        goto L55
    L38:
        return new r0(this.c, f3.a.g);
    L73:
        return new r0("start sensor failed: " + r21.getMessage(), f3.a.f);
    L28:
        r19 = null;
    L31:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    L24:
        return new r0(this.c, f3.a.g);
    L21:
        r16 = null;
        goto L22
    L13:
        return new r0("context is null", f3.a.f);
    L9:
        return new r0("context is null", f3.a.f);
    L5:
        return new r0("context is null", f3.a.f);
    }

    public c(e3.d r10, int r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r12, "changeEventName");
        Intrinsics.checkNotNullParameter(r13, "unavailableMessage");
        this.a = r11;
        this.b = r12;
        this.c = r13;
        this.d = new WeakReference(r10);
        this.e = new Object();
    }
}
