package com.obric.common.oea.foundation.animation.spec.spring;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.common.oea.foundation.animation.a.e;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0002\u0010\bJ(\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0002J\b\u0010\u001a\u001a\u00020\nH\u0016J \u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J-\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u001dJ(\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0015H\u0016J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006%"}, d2 = {"Lcom/obric/common/oea/foundation/animation/spec/spring/FloatSpringSpec;", "Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "", "dampingRatio", "stiffness", "delay", "", "visibilityThreshold", "(FFIF)V", "TAG", "", "getDampingRatio", "()F", "getDelay", "()I", "delta", "spring", "Lcom/obric/common/oea/foundation/animation/calculator/SpringSimulation;", "getStiffness", "getVisibilityThreshold", "clampPlayTimeNanos", "", "playTimeNanos", "initialValue", "targetValue", "initialVelocity", "dump", "getDurationNanos", "getValueFromNanos", "(JFFF)Ljava/lang/Float;", "getVelocityFromNanos", "isFinishedFromNanos", "", "durationNanos", "setAccuracy", "", LocationMonitorConst.ACCURACY, "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements com.obric.common.oea.foundation.animation.spec.a<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f7723b;
    private float c;
    private final float d;
    private final float e;
    private final int f;
    private final float g;

    public b() {
        this(0.0f, 0.0f, 0, 0.0f, 15, null);
    }

    public b(float r1, float r2, int r3, float r4) {
        this.d = r1;
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.f7722a = "FloatSpringSpec";
        e r5 = new e(1.0f);
        r5.b(r1);
        r5.a(r2);
        Unit r6 = Unit.INSTANCE;
        this.f7723b = r5;
        this.c = 1.0f;
    }

    public /* synthetic */ b(float r2, float r3, int r4, float r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = 1.0f;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 1.0f;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = 0;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = 0.01f;
    L14:
        this(r2, r3, r4, r5);
    }

    private final long c(long r9, float r11, float r12, float r13) {
        long r14 = a(r11, r12, r13);
        long r2 = r9 - (((long) this.f) * TimeUtils.NANOSECONDS_PER_MILLISECOND);
        if (r14 < 0) goto L5;
        long r6 = r14;
    L7:
        return RangesKt.coerceIn(r2, 0, r6);
    L5:
        r6 = 0;
        goto L7
    }

    public long a(float r3, float r4, float r5) {
        float r0 = this.f7723b.a();
        float r1 = this.f7723b.b();
        float r6 = r3 - r4;
        float r7 = this.g;
        float r8 = r5 / r7;
        return c.a(r0, r1, r8, r6 / r7, this.c) * TimeUtils.NANOSECONDS_PER_MILLISECOND;
    }

    @Override // com.obric.common.oea.foundation.animation.spec.a
    public /* synthetic */ long a(Float r3, Float r4, float r5) {
        return a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).floatValue(), r5);
    }

    public Float a(long r3, float r5, float r6, float r7) {
        long r4 = c(r3, r5, r6, r7) / TimeUtils.NANOSECONDS_PER_MILLISECOND;
        this.f7723b.c(r6);
        return Float.valueOf(this.f7723b.a(r5, r7, r4).a());
    }

    @Override // com.obric.common.oea.foundation.animation.spec.a
    public /* synthetic */ Float a(long r9, Float r11, Float r12, float r13) {
        return a(r9, ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).floatValue(), r13);
    }

    @Override // com.obric.common.oea.foundation.animation.spec.a
    public String a() {
        return "FloatSpringSpec(dampingRatio: " + this.d + ", stiffness: " + this.e + ", delay: " + this.f + ", visibilityThreshold: " + this.g + ", delta: " + this.c + ')';
    }

    public final void a(float r1) {
        this.c = r1;
    }

    @Override // com.obric.common.oea.foundation.animation.spec.a
    public boolean a(long r5, long r7) {
        if (r5 < (r7 + (((long) this.f) * TimeUtils.NANOSECONDS_PER_MILLISECOND))) goto L5;
        return true;
    L5:
        return false;
    }

    public float b(long r3, float r5, float r6, float r7) {
        long r4 = c(r3, r5, r6, r7) / TimeUtils.NANOSECONDS_PER_MILLISECOND;
        this.f7723b.c(r6);
        return this.f7723b.a(r5, r7, r4).b();
    }

    @Override // com.obric.common.oea.foundation.animation.spec.a
    public /* synthetic */ float b(long r9, Float r11, Float r12, float r13) {
        return b(r9, ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).floatValue(), r13);
    }
}
