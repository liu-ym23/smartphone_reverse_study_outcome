package com.larus.asr.session;

import com.larksuite.component.blockit.sub_process.IP0SubProcess;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.asr.VoiceInputType;
import com.larus.asr.session.component.AsrEngineRoute;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public /* synthetic */ class LiveTutorAsrOnlySessionV2$createComponents$5 extends FunctionReferenceImpl implements Function1<com.larus.asr.session.component.f0, Unit> {
    public LiveTutorAsrOnlySessionV2$createComponents$5(Object r8) {
        super(1, r8, LiveTutorAsrOnlySessionV2.class, "startLiveTutorAsr", "startLiveTutorAsr(Lcom/larus/asr/session/component/AsrSessionContext;)V", 0);
    }

    public final void invoke(com.larus.asr.session.component.f0 r6) {
        Intrinsics.checkNotNullParameter(r6, IP0SubProcess.P0_PROCESS_NAME);
        LiveTutorAsrOnlySessionV2 r0 = (LiveTutorAsrOnlySessionV2) ((CallableReference) this).receiver;
        int r1 = LiveTutorAsrOnlySessionV2.j;
        r0.getClass();
        String r2 = r6.m;
        if (r2 == null) goto L10;
        r0.n(r6);
        AsrEngineRoute r3 = AsrEngineRoute.NORMAL;
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "route");
        r6.m = r2;
        r6.n = 0;
        r6.o = r3;
        r6.e(com.larus.bmhome.chat.component.bottom.core.speaker.g.c.a);
        VoiceInputType.a r7 = VoiceInputType.Companion;
        VoiceInputType r4 = r0.c;
        r7.getClass();
        if (VoiceInputType.a.a(r4) == true) goto L8;
        r0.i.invoke();
    L8:
        r0.a.onAsrStart(r0.b);
        r0.a.vb();
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.larus.asr.session.component.f0) r1);
        return Unit.INSTANCE;
    }
}
