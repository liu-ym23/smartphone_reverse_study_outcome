package com.obric.common.oea.foundation.animation;

import androidx.exifinterface.media.ExifInterface;
import com.obric.common.oea.foundation.animation.a.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002BM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u0012\b\b\u0002\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000eJ\t\u0010.\u001a\u00020\u0004HÆ\u0003J\u000e\u0010/\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000e\u00100\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000\bHÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000f\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\fHÆ\u0003J\t\u00104\u001a\u00020\nHÆ\u0003Jh\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00028\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u00002\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\b\b\u0002\u0010\r\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u00106J\u0006\u00107\u001a\u00020\u0004J\u0013\u00108\u001a\u00020!2\b\u00109\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\u0006\u0010:\u001a\u00020\u0014J\u0006\u0010;\u001a\u00020\u0014J\u0013\u0010<\u001a\u00028\u00002\u0006\u0010=\u001a\u00020\u0014¢\u0006\u0002\u0010>J\u000e\u0010?\u001a\u00020\n2\u0006\u0010=\u001a\u00020\u0014J\t\u0010@\u001a\u00020AHÖ\u0001J\u000e\u0010B\u001a\u00020!2\u0006\u0010=\u001a\u00020\u0014J\u0006\u0010 \u001a\u00020!J\u001e\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020!2\u0006\u0010F\u001a\u00020!2\u0006\u0010G\u001a\u00020!J\u000e\u0010H\u001a\u00020D2\u0006\u0010I\u001a\u00020\u0014J\u000e\u0010J\u001a\u00020D2\u0006\u0010I\u001a\u00020\u0014J\u000e\u0010K\u001a\u00020D2\u0006\u0010I\u001a\u00020\u0014J\u000e\u0010L\u001a\u00020D2\u0006\u0010E\u001a\u00020!J\t\u0010M\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\r\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u00028\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001c\u0010\u0006\u001a\u00028\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006N"}, d2 = {"Lcom/obric/common/oea/foundation/animation/AnimationInfo;", ExifInterface.GPS_DIRECTION_TRUE, "", "property", "", "initialValue", "targetValue", "spec", "Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "initialVelocity", "", "valueClass", "Lkotlin/reflect/KClass;", "currentVelocity", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;Ljava/lang/Float;Lkotlin/reflect/KClass;F)V", "getCurrentVelocity", "()F", "setCurrentVelocity", "(F)V", "durationNanos", "", "firstFrameTimeNanos", "getInitialValue", "()Ljava/lang/Object;", "setInitialValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getInitialVelocity", "()Ljava/lang/Float;", "setInitialVelocity", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "isRunning", "", "lastFrameTimeNanos", "getProperty", "()Ljava/lang/String;", "publicDurationNanos", "getPublicDurationNanos", "()J", "getSpec", "()Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "getTargetValue", "setTargetValue", "getValueClass", "()Lkotlin/reflect/KClass;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;Ljava/lang/Float;Lkotlin/reflect/KClass;F)Lcom/obric/common/oea/foundation/animation/AnimationInfo;", "dump", "equals", "other", "getFirstFrameTimeNanos", "getLastFrameTimeNanos", "getValueFromNanos", "playTimeNanos", "(J)Ljava/lang/Object;", "getVelocityVectorFromNanos", "hashCode", "", "isFinishedFromNanos", "reset", "", "running", "reverse", "clearVelocity", "setDurationNanos", "timeNanos", "setFirstFrameTimeNanos", "setLastFrameTimeNanos", "setRunning", "toString", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f7665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f7666b;
    private long c;
    private boolean d;
    private final String e;
    private T f;
    private T g;
    private final com.obric.common.oea.foundation.animation.spec.a<T> h;
    private Float i;
    private final KClass<T> j;
    private float k;

    public a(String r3, T r4, T r5, com.obric.common.oea.foundation.animation.spec.a<T> r6, Float r7, KClass<T> r8, float r9) {
        com.obric.common.oea.foundation.animation.spec.a<T> r10 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
        KClass<T> r11 = (KClass) ZeusTransformUtils.wrapperContextForParams(r8, KClass.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "property");
        Intrinsics.checkNotNullParameter(r4, "initialValue");
        Intrinsics.checkNotNullParameter(r5, "targetValue");
        Intrinsics.checkNotNullParameter(r10, "spec");
        Intrinsics.checkNotNullParameter(r11, "valueClass");
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r10;
        this.i = r7;
        this.j = r11;
        this.k = r9;
        this.f7665a = -1;
        this.f7666b = -1;
        this.c = -1;
        this.d = true;
    }

    public /* synthetic */ a(String r11, Object r12, Object r13, com.obric.common.oea.foundation.animation.spec.a r14, Float r15, KClass r16, float r17, int r18, DefaultConstructorMarker r19) {
        com.obric.common.oea.foundation.animation.spec.a r6 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r14, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
        KClass r8 = (KClass) ZeusTransformUtils.wrapperContextForParams(r16, KClass.class, "com.obric.memorydata.plugin");
        if ((r18 & 64) == 0) goto L5;
        float r9 = 0.0f;
    L6:
        this(r11, r12, r13, r6, r15, r8, r9);
        return;
    L5:
        r9 = r17;
        goto L6
    }

    public final long a() {
        if (this.f7665a >= 0) goto L10;
        com.obric.common.oea.foundation.animation.spec.a<T> r0 = this.h;
        T r1 = this.f;
        T r2 = this.g;
        Float r3 = this.i;
        if (r3 == null) goto L7;
        float r4 = r3.floatValue();
    L8:
        this.f7665a = r0.a(r1, r2, r4);
        goto L10
    L7:
        r4 = 0.0f;
    L10:
        return this.f7665a;
    }

    public final void a(long r1) {
        this.f7666b = r1;
    }

    public final void a(Float r1) {
        this.i = r1;
    }

    public final void a(boolean r1) {
        this.d = r1;
    }

    public final void a(boolean r3, boolean r4, boolean r5) {
        this.d = r3;
        if (r5 == false) goto L5;
        float r6 = 0.0f;
    L6:
        this.k = r6;
        this.f7666b = -1;
        this.c = -1;
        if (r4 == false) goto L10;
        T r7 = this.f;
        this.f = this.g;
        this.g = r7;
        return;
    L10:
        return;
    L5:
        r6 = this.k;
        goto L6
    }

    public final long b() {
        return this.f7666b;
    }

    public final void b(long r1) {
        this.c = r1;
    }

    public final T c(long r9) {
        KClass<T> r0 = this.j;
        if (Intrinsics.areEqual(r0, Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L7;
        Object r1 = com.obric.common.oea.foundation.animation.a.b.f7667a;
    L5:
        Objects.requireNonNull(r1, "null cannot be cast to non-null type com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator<T>");
        com.obric.common.oea.foundation.animation.a.a r2 = (com.obric.common.oea.foundation.animation.a.a) ZeusTransformUtils.preCheckCast(r1, com.obric.common.oea.foundation.animation.a.a.class, "com.obric.memorydata.plugin");
        T r4 = this.f;
        T r5 = this.g;
        Float r3 = this.i;
        if (r3 == null) goto L12;
        float r6 = r3.floatValue();
    L14:
        return (T) r2.a(r9, r4, r5, r6, this.h);
    L12:
        r6 = 0.0f;
        goto L14
    L7:
        if (Intrinsics.areEqual(r0, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L16;
        r1 = c.f7668a;
        goto L5
    L16:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Unsupported type " + this.j), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final boolean c() {
        return this.d;
    }

    public final float d(long r9) {
        KClass<T> r0 = this.j;
        if (Intrinsics.areEqual(r0, Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L7;
        Object r1 = com.obric.common.oea.foundation.animation.a.b.f7667a;
    L5:
        Objects.requireNonNull(r1, "null cannot be cast to non-null type com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator<T>");
        com.obric.common.oea.foundation.animation.a.a r2 = (com.obric.common.oea.foundation.animation.a.a) ZeusTransformUtils.preCheckCast(r1, com.obric.common.oea.foundation.animation.a.a.class, "com.obric.memorydata.plugin");
        T r4 = this.f;
        T r5 = this.g;
        Float r3 = this.i;
        if (r3 == null) goto L12;
        float r6 = r3.floatValue();
    L13:
        float r10 = r2.b(r9, r4, r5, r6, this.h);
        this.k = r10;
        return r10;
    L12:
        r6 = 0.0f;
        goto L13
    L7:
        if (Intrinsics.areEqual(r0, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L16;
        r1 = c.f7668a;
        goto L5
    L16:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Unsupported type " + this.j), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final String d() {
        return "AnimationInfo(property: " + this.e + ", initialValue: " + this.f + ", targetValue: " + this.g + ", spec: " + this.h.a() + ", initialVelocity: " + this.i + ", valueClass: " + this.j + ", currentVelocity: " + this.k + ", durationNanos: " + this.f7665a + ", firstFrameTimeNanos: " + this.f7666b + ", lastFrameTimeNanos: " + this.c + ", isRunning: " + this.d + ')';
    }

    public final String e() {
        return this.e;
    }

    public final boolean e(long r8) {
        KClass<T> r0 = this.j;
        if (Intrinsics.areEqual(r0, Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L7;
        Object r1 = com.obric.common.oea.foundation.animation.a.b.f7667a;
    L5:
        Objects.requireNonNull(r1, "null cannot be cast to non-null type com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator<T>");
        return ((com.obric.common.oea.foundation.animation.a.a) ZeusTransformUtils.preCheckCast(r1, com.obric.common.oea.foundation.animation.a.a.class, "com.obric.memorydata.plugin")).a(r8, a(), this.h);
    L7:
        if (Intrinsics.areEqual(r0, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L12;
        r1 = c.f7668a;
        goto L5
    L12:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Unsupported type " + this.j), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, a.class) == false) goto L21;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L19;
        return false;
    L19:
        if (Float.compare(this.k, r4.k) == 0) goto L32;
        return false;
    L32:
        return true;
    L21:
        return false;
    }

    public final T f() {
        return this.f;
    }

    public final T g() {
        return this.g;
    }

    public final Float h() {
        return this.i;
    }

    public int hashCode() {
        String r0 = this.e;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        T r4 = this.f;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        T r7 = this.g;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        com.obric.common.oea.foundation.animation.spec.a<T> r10 = this.h;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Float r13 = this.i;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        KClass<T> r16 = this.j;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return ((r15 + r1) * 31) + Float.hashCode(this.k);
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final float i() {
        return this.k;
    }

    public String toString() {
        return "AnimationInfo(property=" + this.e + ", initialValue=" + this.f + ", targetValue=" + this.g + ", spec=" + this.h + ", initialVelocity=" + this.i + ", valueClass=" + this.j + ", currentVelocity=" + this.k + ")";
    }
}
