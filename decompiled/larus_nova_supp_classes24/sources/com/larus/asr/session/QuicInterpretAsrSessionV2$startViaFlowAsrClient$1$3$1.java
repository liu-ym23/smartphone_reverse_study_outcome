package com.larus.asr.session;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final /* synthetic */ class QuicInterpretAsrSessionV2$startViaFlowAsrClient$1$3$1 extends FunctionReferenceImpl implements Function0<Integer> {
    public QuicInterpretAsrSessionV2$startViaFlowAsrClient$1$3$1(Object r8) {
        super(0, r8, QuicInterpretAsrSessionV2.class, "currentSpeakerMode", "currentSpeakerMode()I", 0);
    }

    public final Integer invoke() {
        QuicInterpretAsrSessionV2 r0 = (QuicInterpretAsrSessionV2) ((CallableReference) this).receiver;
        int r1 = QuicInterpretAsrSessionV2.n;
        return Integer.valueOf(r0.m());
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m402invoke() {
        return invoke();
    }
}
