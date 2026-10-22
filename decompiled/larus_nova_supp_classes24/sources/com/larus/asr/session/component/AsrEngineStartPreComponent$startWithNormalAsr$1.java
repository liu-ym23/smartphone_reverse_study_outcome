package com.larus.asr.session.component;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final /* synthetic */ class AsrEngineStartPreComponent$startWithNormalAsr$1 extends FunctionReferenceImpl implements Function1<byte[], Unit> {
    public AsrEngineStartPreComponent$startWithNormalAsr$1(Object r8) {
        super(1, r8, b.class, "onAudioData", "onAudioData([B)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((byte[]) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(byte[] r2) {
        ((b) ((CallableReference) this).receiver).a(r2);
    }
}
