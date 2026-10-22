package com.obric.oui.texteffects;

import android.graphics.BlurMaskFilter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
final /* synthetic */ class OProtocolTextEffectTextView$drawTextLayer$2 extends FunctionReferenceImpl implements Function1<Float, BlurMaskFilter> {
    public OProtocolTextEffectTextView$drawTextLayer$2(Object r10) {
        super(1, r10, OProtocolTextEffectTextView.class, "getBlurMaskFilter", "getBlurMaskFilter(F)Landroid/graphics/BlurMaskFilter;", 0);
    }

    public final BlurMaskFilter invoke(float r5) {
        return ((OProtocolTextEffectTextView) this.receiver).n(r5);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ BlurMaskFilter invoke(Float r5) {
        return invoke(r5.floatValue());
    }
}
