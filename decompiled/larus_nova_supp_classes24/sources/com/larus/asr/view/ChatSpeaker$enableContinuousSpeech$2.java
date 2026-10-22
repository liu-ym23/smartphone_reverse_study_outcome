package com.larus.asr.view;

import com.larksuite.component.blockit.sub_process.IP0SubProcess;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.asr.config.ChatSpeakerStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final /* synthetic */ class ChatSpeaker$enableContinuousSpeech$2 extends FunctionReferenceImpl implements Function1<ChatSpeakerStatus, Unit> {
    public ChatSpeaker$enableContinuousSpeech$2(Object r8) {
        super(1, r8, ChatSpeaker.class, "updateContinuousSpeechStatus", "updateContinuousSpeechStatus(Lcom/larus/asr/config/ChatSpeakerStatus;)V", 0);
    }

    public final void invoke(ChatSpeakerStatus r3) {
        Intrinsics.checkNotNullParameter(r3, IP0SubProcess.P0_PROCESS_NAME);
        ChatSpeaker r0 = (ChatSpeaker) ((CallableReference) this).receiver;
        int r1 = ChatSpeaker.T;
        r0.getClass();
        if (r3 != ChatSpeakerStatus.Normal) goto L5;
        r3 = r0.T7();
    L5:
        r0.Z8(r3, r0.L);
        r0.M7(r0.K, r0.L);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ChatSpeakerStatus) r1);
        return Unit.INSTANCE;
    }
}
