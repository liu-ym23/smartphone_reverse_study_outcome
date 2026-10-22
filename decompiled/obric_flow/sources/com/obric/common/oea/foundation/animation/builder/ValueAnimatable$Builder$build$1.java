package com.obric.common.oea.foundation.animation.builder;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ValueAnimatable$Builder$build$1 extends MutablePropertyReference0Impl {
    public ValueAnimatable$Builder$build$1(c r10) {
        super(r10, c.class, "valueAnimationCommand", "getValueAnimationCommand()Lcom/obric/common/oea/foundation/animation/command/AnimationCommand;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        hp.a r5 = ((c) this.receiver).f11317a;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("valueAnimationCommand");
    L5:
        return r5;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r5) {
        hp.a r10 = (hp.a) r5;
        ((c) this.receiver).f11317a = r10;
    }
}
