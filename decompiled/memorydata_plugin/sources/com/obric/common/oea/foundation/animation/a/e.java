package com.obric.common.oea.foundation.animation.a;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0002J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\n\"\u0004\b\r\u0010\u0004R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\u0004¨\u0006 "}, d2 = {"Lcom/obric/common/oea/foundation/animation/calculator/SpringSimulation;", "", "finalPosition", "", "(F)V", "dampedFreq", "", EventBody.KEY_VALUE, "dampingRatio", "getDampingRatio", "()F", "setDampingRatio", "getFinalPosition", "setFinalPosition", "gammaMinus", "gammaPlus", "initialized", "", "naturalFreq", "stiffness", "getStiffness", "setStiffness", "getAcceleration", "lastDisplacement", "lastVelocity", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "updateValues", "Lcom/obric/common/oea/foundation/animation/calculator/Motion;", "timeElapsed", "", "updateValues$foundation_standardRelease", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f7670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7671b;
    private double c;
    private double d;
    private double e;
    private float f;
    private float g;

    public e(float r3) {
        this.g = r3;
        this.f7670a = Math.sqrt(50.0f);
        this.f = 1.0f;
    }

    private final void c() {
        if (this.f7671b == false) goto L6;
        return;
    L6:
        if (this.g == f.a()) goto L18;
        float r0 = this.f;
        double r1 = ((double) r0) * ((double) r0);
        float r4 = 1;
        if (r0 <= r4) goto L11;
        double r6 = this.f7670a;
        double r2 = r1 - ((double) 1);
        this.c = (((double) (-r0)) * r6) + (r6 * Math.sqrt(r2));
        double r5 = -this.f;
        double r7 = this.f7670a;
        this.d = (r5 * r7) - (r7 * Math.sqrt(r2));
    L15:
        this.f7671b = true;
        return;
    L11:
        if (r0 < 0) goto L15;
        if (r0 >= r4) goto L15;
        this.e = this.f7670a * Math.sqrt(((double) 1) - r1);
        goto L15
    L18:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Error: Final position of the spring must be set before the animation starts"), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final float a() {
        double r0 = this.f7670a;
        return (float) (r0 * r0);
    }

    public final d a(float r17, float r18, long r19) {
        c();
        double r2 = r19 / 1000.0d;
        float r4 = r17 - this.g;
        float r5 = this.f;
        if (r5 <= 1) goto L6;
        double r6 = r4;
        double r7 = this.d;
        double r10 = r18;
        double r12 = this.c;
        double r8 = r6 - (((r7 * r6) - r10) / (r7 - r12));
        double r9 = ((r6 * r7) - r10) / (r7 - r12);
        double r11 = (Math.exp(r7 * r2) * r8) + (Math.exp(this.c * r2) * r9);
        double r13 = this.d;
        double r14 = (r8 * r13) * Math.exp(r13 * r2);
        double r15 = this.c;
        double r16 = r14 + ((r9 * r15) * Math.exp(r15 * r2));
    L10:
        return f.a((float) (r11 + ((double) this.g)), (float) r16);
    L6:
        if (r5 != 1.0f) goto L8;
        double r20 = this.f7670a;
        double r21 = r4;
        double r22 = ((double) r18) + (r20 * r21);
        double r23 = r21 + (r22 * r2);
        double r24 = Math.exp((-r20) * r2) * r23;
        double r25 = r23 * Math.exp((-this.f7670a) * r2);
        double r110 = this.f7670a;
        r11 = r24;
        r16 = (r25 * (-r110)) + (r22 * Math.exp((-r110) * r2));
        goto L10
    L8:
        double r26 = ((double) 1) / this.e;
        double r111 = this.f7670a;
        double r112 = r4;
        double r27 = r26 * (((((double) r5) * r111) * r112) + ((double) r18));
        double r28 = Math.exp((((double) (-r5)) * r111) * r2) * ((Math.cos(this.e * r2) * r112) + (Math.sin(this.e * r2) * r27));
        double r29 = this.f7670a;
        float r1 = this.f;
        double r113 = ((-r29) * r28) * ((double) r1);
        double r30 = Math.exp((((double) (-r1)) * r29) * r2);
        double r114 = this.e;
        double r31 = ((-r114) * r112) * Math.sin(r114 * r2);
        double r115 = this.e;
        r16 = (r30 * (r31 + ((r27 * r115) * Math.cos(r115 * r2)))) + r113;
        r11 = r28;
        goto L10
    }

    public final void a(float r5) {
        if (a() <= 0) goto L7;
        this.f7670a = Math.sqrt(r5);
        this.f7671b = false;
        return;
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Spring stiffness constant must be positive."), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final float b() {
        return this.f;
    }

    public final void b(float r3) {
        if (r3 < 0) goto L7;
        this.f = r3;
        this.f7671b = false;
        return;
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Damping ratio must be non-negative"), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final void c(float r1) {
        this.g = r1;
    }
}
