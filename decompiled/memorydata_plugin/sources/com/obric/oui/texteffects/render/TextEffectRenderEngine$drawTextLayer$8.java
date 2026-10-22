package com.obric.oui.texteffects.render;

import android.graphics.BlurMaskFilter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* synthetic */ class TextEffectRenderEngine$drawTextLayer$8 extends FunctionReferenceImpl implements Function1<Float, BlurMaskFilter> {
    TextEffectRenderEngine$drawTextLayer$8(Object r8) {
        super(1, r8, k.class, "getBlurMaskFilter", "getBlurMaskFilter(F)Landroid/graphics/BlurMaskFilter;", 0);
    }

    public final BlurMaskFilter invoke(float r3) {
        return ((k) ZeusTransformUtils.preCheckCast(this.receiver, k.class, "com.obric.memorydata.plugin")).a(r3);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ BlurMaskFilter invoke(Float r3) {
        return invoke(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).floatValue());
    }
}
