package com.obric.common.oea.foundation.animation.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J;\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016¢\u0006\u0002\u0010\rJ6\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016¨\u0006\u0012"}, d2 = {"Lcom/obric/common/oea/foundation/animation/calculator/IntAnimationValueCalculator;", "Lcom/obric/common/oea/foundation/animation/calculator/AnimationValueCalculator;", "", "()V", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "", "spec", "Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "(JIIFLcom/obric/common/oea/foundation/animation/spec/AnimationSpec;)Ljava/lang/Integer;", "getVelocityFromNanos", "isFinishedFromNanos", "", "durationNanos", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class c implements a<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f7668a = null;

    static {
        f7668a = new c();
    }

    private c() {
    }

    public Integer a(long r8, int r10, int r11, float r12, com.obric.common.oea.foundation.animation.spec.a<Integer> r13) {
        com.obric.common.oea.foundation.animation.spec.a r1 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r13, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "spec");
        return (Integer) ZeusTransformUtils.preCheckCast(r1.a(r8, Integer.valueOf(r10), Integer.valueOf(r11), r12), Integer.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.common.oea.foundation.animation.a.a
    public /* synthetic */ Integer a(long r10, Integer r12, Integer r13, float r14, com.obric.common.oea.foundation.animation.spec.a<Integer> r15) {
        com.obric.common.oea.foundation.animation.spec.a<Integer> r8 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r15, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
        return a(r10, ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).intValue(), r14, r8);
    }

    @Override // com.obric.common.oea.foundation.animation.a.a
    public boolean a(long r2, long r4, com.obric.common.oea.foundation.animation.spec.a<Integer> r6) {
        com.obric.common.oea.foundation.animation.spec.a r1 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "spec");
        return r1.a(r2, r4);
    }

    public float b(long r7, int r9, int r10, float r11, com.obric.common.oea.foundation.animation.spec.a<Integer> r12) {
        com.obric.common.oea.foundation.animation.spec.a r0 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "spec");
        return r0.b(r7, Integer.valueOf(r9), Integer.valueOf(r10), r11);
    }

    @Override // com.obric.common.oea.foundation.animation.a.a
    public /* synthetic */ float b(long r10, Integer r12, Integer r13, float r14, com.obric.common.oea.foundation.animation.spec.a<Integer> r15) {
        com.obric.common.oea.foundation.animation.spec.a<Integer> r8 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r15, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
        return b(r10, ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).intValue(), r14, r8);
    }
}
