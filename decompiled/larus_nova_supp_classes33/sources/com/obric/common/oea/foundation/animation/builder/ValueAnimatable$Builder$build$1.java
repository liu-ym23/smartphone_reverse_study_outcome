package com.obric.common.oea.foundation.animation.builder;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ValueAnimatable$Builder$build$1 extends MutablePropertyReference0Impl {
    public ValueAnimatable$Builder$build$1(d.a r7) {
        super(r7, d.a.class, "valueAnimationCommand", "getValueAnimationCommand()Lcom/obric/common/oea/foundation/animation/command/AnimationCommand;", 0);
    }

    public Object get() {
        dja.a<?> r0 = ((d.a) ((CallableReference) this).receiver).c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("valueAnimationCommand");
    L5:
        return r0;
    }

    public void set(Object r2) {
        dja.a<?> r3 = (dja.a) r2;
        ((d.a) ((CallableReference) this).receiver).c = r3;
    }
}
