package com.obric.common.oea.foundation.animation.spec.a;

import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.common.oea.foundation.animation.token.c;
import com.obric.common.oea.foundation.animation.token.d;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\nH\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J \u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J-\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u001dJ(\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\u0018\u0010 \u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0011H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Lcom/obric/common/oea/foundation/animation/spec/tween/FloatTweenSpec;", "Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "", "durationMillis", "", "delay", "easing", "Lcom/obric/common/oea/foundation/animation/token/Token$Easing;", "(IILcom/obric/common/oea/foundation/animation/token/Token$Easing;)V", "TAG", "", "getDelay", "()I", "getDurationMillis", "getEasing", "()Lcom/obric/common/oea/foundation/animation/token/Token$Easing;", "clampPlayTimeNanos", "", "playTimeNanos", "dump", "equals", "", "other", "", "getDurationNanos", "initialValue", "targetValue", "initialVelocity", "getValueFromNanos", "(JFFF)Ljava/lang/Float;", "getVelocityFromNanos", "hashCode", "isFinishedFromNanos", "durationNanos", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements com.obric.common.oea.foundation.animation.spec.a<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f7719b;
    private final int c;
    private final Token.Easing d;

    public a() {
        this(0, 0, null, 7, null);
    }

    public a(int r2, int r3, Token.Easing r4) {
        Intrinsics.checkNotNullParameter(r4, "easing");
        this.f7719b = r2;
        this.c = r3;
        this.d = r4;
        this.f7718a = "FloatTweenSpec";
    }

    public /* synthetic */ a(int r1, int r2, Token.Easing r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 300;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = 0;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = Token.Easing.OUI_ANIMATION_EASING_STANDARD;
    L11:
        this(r1, r2, r3);
    }

    private final long a(long r11) {
        return RangesKt.coerceIn(r11 - (((long) this.c) * TimeUtils.NANOSECONDS_PER_MILLISECOND), 0, ((long) this.f7719b) * TimeUtils.NANOSECONDS_PER_MILLISECOND);
    }

    public long a(float r1, float r2, float r3) {
        return ((long) this.f7719b) * TimeUtils.NANOSECONDS_PER_MILLISECOND;
    }

    @Override // com.obric.common.oea.foundation.animation.spec.a
    public /* synthetic */ long a(Float r3, Float r4, float r5) {
        return a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).floatValue(), r5);
    }

    public Float a(long r6, float r8, float r9, float r10) {
        long r7 = a(r6);
        int r11 = this.f7719b;
        float r0 = 1.0f;
        if (r11 != 0) goto L5;
        float r12 = 1.0f;
    L6:
        Token.Easing r13 = this.d;
        Token.Easing r14 = Token.Easing.OUI_ANIMATION_EASING_LINEAR;
        Token.Easing r5 = this.d;
        if (r13 != r14) goto L9;
        float r15 = d.b(r5).a(r12);
    L18:
        return Float.valueOf(c.b(r8, r9, r15));
    L9:
        com.obric.common.oea.foundation.animation.token.a r16 = d.a(r5);
        if (r12 >= 0.0f) goto L13;
        r12 = 0.0f;
    L13:
        if (r12 > 1.0f) goto L16;
        r0 = r12;
    L16:
        r15 = r16.a(r0);
        goto L18
    L5:
        r12 = r7 / (((long) r11) * TimeUtils.NANOSECONDS_PER_MILLISECOND);
        goto L6
    }

    @Override // com.obric.common.oea.foundation.animation.spec.a
    public /* synthetic */ Float a(long r9, Float r11, Float r12, float r13) {
        return a(r9, ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).floatValue(), r13);
    }

    @Override // com.obric.common.oea.foundation.animation.spec.a
    public String a() {
        return "FloatTweenSpec(durationMillis: " + this.f7719b + ", delay: " + this.c + ", easing: " + this.d + ')';
    }

    @Override // com.obric.common.oea.foundation.animation.spec.a
    public boolean a(long r5, long r7) {
        if (r5 < (r7 + (((long) this.c) * TimeUtils.NANOSECONDS_PER_MILLISECOND))) goto L5;
        return true;
    L5:
        return false;
    }

    public float b(long r10, float r12, float r13, float r14) {
        long r1 = a(r10);
        if (r1 >= 0) goto L6;
        return 0.0f;
    L6:
        if (r1 != 0) goto L8;
        return r14;
    L8:
        float r11 = a(r1 - TimeUtils.NANOSECONDS_PER_MILLISECOND, r12, r13, r14).floatValue();
        return (a(r1, r12, r13, r14).floatValue() - r11) * 1000.0f;
    }

    @Override // com.obric.common.oea.foundation.animation.spec.a
    public /* synthetic */ float b(long r9, Float r11, Float r12, float r13) {
        return b(r9, ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).floatValue(), r13);
    }

    public boolean equals(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, a.class) == true) goto L5;
        return false;
    L5:
        if (((a) ZeusTransformUtils.preCheckCast(r6, a.class, "com.obric.memorydata.plugin")).f7719b == this.f7719b) goto L7;
        return false;
    L7:
        if (((a) ZeusTransformUtils.preCheckCast(r6, a.class, "com.obric.memorydata.plugin")).c == this.c) goto L9;
        return false;
    L9:
        if (((a) ZeusTransformUtils.preCheckCast(r6, a.class, "com.obric.memorydata.plugin")).d != this.d) goto L15;
        return true;
    L15:
        return false;
    }

    public int hashCode() {
        return (((this.f7719b * 31) + this.d.hashCode()) * 31) + this.c;
    }
}
