package com.larus.asr.session.component;

import com.larksuite.component.blockit.sub_process.IP0SubProcess;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final /* synthetic */ class AsrEngineStartPreComponent$startWithNormalAsr$3 extends FunctionReferenceImpl implements Function1<com.larus.audio.b, Unit> {
    public AsrEngineStartPreComponent$startWithNormalAsr$3(Object r8) {
        super(1, r8, b.class, "onSuccess", "onSuccess(Lcom/larus/audio/AsrSuccessResult;)V", 0);
    }

    public final void invoke(com.larus.audio.b r2) {
        Intrinsics.checkNotNullParameter(r2, IP0SubProcess.P0_PROCESS_NAME);
        ((b) ((CallableReference) this).receiver).d(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.larus.audio.b) r1);
        return Unit.INSTANCE;
    }
}
