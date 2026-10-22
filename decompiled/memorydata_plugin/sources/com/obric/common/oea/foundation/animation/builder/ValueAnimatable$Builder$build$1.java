package com.obric.common.oea.foundation.animation.builder;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ValueAnimatable$Builder$build$1 extends MutablePropertyReference0Impl {
    ValueAnimatable$Builder$build$1(c.a r7) {
        super(r7, c.a.class, "valueAnimationCommand", "getValueAnimationCommand()Lcom/obric/common/oea/foundation/animation/command/AnimationCommand;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return c.a.a((c.a) ZeusTransformUtils.preCheckCast(this.receiver, c.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r3) {
        c.a.a((c.a) ZeusTransformUtils.preCheckCast(this.receiver, c.a.class, "com.obric.memorydata.plugin"), (com.obric.common.oea.foundation.animation.b.a) ZeusTransformUtils.preCheckCast(r3, com.obric.common.oea.foundation.animation.b.a.class, "com.obric.memorydata.plugin"));
    }
}
