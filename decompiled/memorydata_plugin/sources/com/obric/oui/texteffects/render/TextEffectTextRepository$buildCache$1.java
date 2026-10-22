package com.obric.oui.texteffects.render;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* synthetic */ class TextEffectTextRepository$buildCache$1 extends FunctionReferenceImpl implements Function1<Float, Float> {
    TextEffectTextRepository$buildCache$1(Object r8) {
        super(1, r8, l.class, "computeStartX", "computeStartX(F)F", 0);
    }

    public final Float invoke(float r3) {
        return Float.valueOf(l.a((l) ZeusTransformUtils.preCheckCast(this.receiver, l.class, "com.obric.memorydata.plugin"), r3));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Float invoke(Float r3) {
        return invoke(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).floatValue());
    }
}
