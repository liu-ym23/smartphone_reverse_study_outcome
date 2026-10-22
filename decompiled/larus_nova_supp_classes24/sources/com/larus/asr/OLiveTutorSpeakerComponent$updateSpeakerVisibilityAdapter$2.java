package com.larus.asr;

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
final /* synthetic */ class OLiveTutorSpeakerComponent$updateSpeakerVisibilityAdapter$2 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public OLiveTutorSpeakerComponent$updateSpeakerVisibilityAdapter$2(Object r8) {
        super(1, r8, OLiveTutorSpeakerComponent.class, "onCanceled", "onCanceled(Ljava/lang/String;)V", 0);
    }

    public final void invoke(String r2) {
        Intrinsics.checkNotNullParameter(r2, IP0SubProcess.P0_PROCESS_NAME);
        OLiveTutorSpeakerComponent.B4((OLiveTutorSpeakerComponent) ((CallableReference) this).receiver, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
