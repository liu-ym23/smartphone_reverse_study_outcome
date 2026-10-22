package com.larus.asr.view;

import com.larksuite.component.blockit.sub_process.IP0SubProcess;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final /* synthetic */ class ChatSpeaker$enableContinuousSpeech$1 extends AdaptedFunctionReference implements Function1<Pair<? extends Float, ? extends Float>, Unit> {
    public ChatSpeaker$enableContinuousSpeech$1(Object r8) {
        super(1, r8, ChatSpeaker.class, "handleRelease", "handleRelease(Lkotlin/Pair;Z)V", 0);
    }

    public final void invoke(Pair<Float, Float> r3) {
        Intrinsics.checkNotNullParameter(r3, IP0SubProcess.P0_PROCESS_NAME);
        ChatSpeaker r0 = (ChatSpeaker) ((AdaptedFunctionReference) this).receiver;
        int r1 = ChatSpeaker.T;
        r0.H6(r3, true);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Pair) r1);
        return Unit.INSTANCE;
    }
}
