package com.obric.common.oea.foundation.animation.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J;\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016¢\u0006\u0002\u0010\fJ6\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016J&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/common/oea/foundation/animation/calculator/FloatAnimationValueCalculator;", "Lcom/obric/common/oea/foundation/animation/calculator/AnimationValueCalculator;", "", "()V", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "spec", "Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "(JFFFLcom/obric/common/oea/foundation/animation/spec/AnimationSpec;)Ljava/lang/Float;", "getVelocityFromNanos", "isFinishedFromNanos", "", "durationNanos", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements a<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f7667a = null;

    static {
        f7667a = new b();
    }

    private b() {
    }

    public Float a(long r8, float r10, float r11, float r12, com.obric.common.oea.foundation.animation.spec.a<Float> r13) {
        com.obric.common.oea.foundation.animation.spec.a r1 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r13, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "spec");
        return (Float) ZeusTransformUtils.preCheckCast(r1.a(r8, Float.valueOf(r10), Float.valueOf(r11), r12), Float.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.common.oea.foundation.animation.a.a
    public /* synthetic */ Float a(long r10, Float r12, Float r13, float r14, com.obric.common.oea.foundation.animation.spec.a<Float> r15) {
        com.obric.common.oea.foundation.animation.spec.a<Float> r8 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r15, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
        return a(r10, ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).floatValue(), r14, r8);
    }

    @Override // com.obric.common.oea.foundation.animation.a.a
    public boolean a(long r2, long r4, com.obric.common.oea.foundation.animation.spec.a<Float> r6) {
        com.obric.common.oea.foundation.animation.spec.a r1 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "spec");
        return r1.a(r2, r4);
    }

    public float b(long r7, float r9, float r10, float r11, com.obric.common.oea.foundation.animation.spec.a<Float> r12) {
        com.obric.common.oea.foundation.animation.spec.a r0 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "spec");
        return r0.b(r7, Float.valueOf(r9), Float.valueOf(r10), r11);
    }

    @Override // com.obric.common.oea.foundation.animation.a.a
    public /* synthetic */ float b(long r10, Float r12, Float r13, float r14, com.obric.common.oea.foundation.animation.spec.a<Float> r15) {
        com.obric.common.oea.foundation.animation.spec.a<Float> r8 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r15, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
        return b(r10, ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).floatValue(), r14, r8);
    }
}
