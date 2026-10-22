package com.obric.assistant.activation.presentation.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ObricListeningVisualView$fakeAmplitudePlayer$2$2 extends FunctionReferenceImpl implements Function1<Float, Unit> {
    public ObricListeningVisualView$fakeAmplitudePlayer$2$2(Object r8) {
        super(1, r8, ObricListeningVisualView.class, "applyAmplitude", "applyAmplitude(F)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Number) r1).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float r3) {
        ObricListeningVisualView r0 = (ObricListeningVisualView) ((CallableReference) this).receiver;
        int r1 = ObricListeningVisualView.i;
        r0.a(r3);
    }
}
