package com.larus.asr.session;

import com.larksuite.component.blockit.sub_process.IP0SubProcess;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public /* synthetic */ class LiveTutorAsrOnlySessionV2$createComponents$4 extends FunctionReferenceImpl implements Function1<com.larus.asr.session.component.f0, Boolean> {
    public LiveTutorAsrOnlySessionV2$createComponents$4(Object r8) {
        super(1, r8, LiveTutorAsrOnlySessionV2.class, "beforeShowSpeaker", "beforeShowSpeaker(Lcom/larus/asr/session/component/AsrSessionContext;)Z", 0);
    }

    public final Boolean invoke(com.larus.asr.session.component.f0 r2) {
        Intrinsics.checkNotNullParameter(r2, IP0SubProcess.P0_PROCESS_NAME);
        return Boolean.valueOf(((LiveTutorAsrOnlySessionV2) ((CallableReference) this).receiver).l(r2));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((com.larus.asr.session.component.f0) r1);
    }
}
