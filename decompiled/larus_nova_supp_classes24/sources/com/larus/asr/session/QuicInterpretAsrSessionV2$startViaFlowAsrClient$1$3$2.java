package com.larus.asr.session;

import com.larksuite.component.blockit.sub_process.IP0SubProcess;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final /* synthetic */ class QuicInterpretAsrSessionV2$startViaFlowAsrClient$1$3$2 extends FunctionReferenceImpl implements Function2<byte[], JSONObject, Unit> {
    public QuicInterpretAsrSessionV2$startViaFlowAsrClient$1$3$2(Object r8) {
        super(2, r8, QuicInterpretAsrSessionV2.class, "onReceiveTranslatedAudio", "onReceiveTranslatedAudio([BLorg/json/JSONObject;)V", 0);
    }

    public final void invoke(byte[] r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, IP0SubProcess.P0_PROCESS_NAME);
        QuicInterpretAsrSessionV2.l((QuicInterpretAsrSessionV2) ((CallableReference) this).receiver, r2, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((byte[]) r1, (JSONObject) r2);
        return Unit.INSTANCE;
    }
}
