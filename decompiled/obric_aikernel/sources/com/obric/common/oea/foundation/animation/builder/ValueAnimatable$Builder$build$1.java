package com.obric.common.oea.foundation.animation.builder;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ValueAnimatable$Builder$build$1 extends MutablePropertyReference0Impl {
    ValueAnimatable$Builder$build$1(c r10) {
        super(r10, c.class, "valueAnimationCommand", "getValueAnimationCommand()Lcom/obric/common/oea/foundation/animation/command/AnimationCommand;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return c.a((c) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r10) {
        c.b((c) this.receiver, (l8.a) r10);
    }
}
