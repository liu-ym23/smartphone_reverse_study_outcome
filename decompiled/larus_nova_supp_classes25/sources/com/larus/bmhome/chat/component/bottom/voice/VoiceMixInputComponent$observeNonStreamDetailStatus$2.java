package com.larus.bmhome.chat.component.bottom.voice;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/larus/bmhome/chat/component/bottom/voice/service/IVoiceMixInputService$NonStreamDetailStatus;", "it", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.voice.VoiceMixInputComponent$observeNonStreamDetailStatus$2", f = "VoiceMixInputComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VoiceMixInputComponent$observeNonStreamDetailStatus$2 extends SuspendLambda implements Function3<FlowCollector<? super com.larus.bmhome.chat.component.bottom.voice.service.d>, Throwable, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public VoiceMixInputComponent$observeNonStreamDetailStatus$2(Continuation<? super VoiceMixInputComponent$observeNonStreamDetailStatus$2> r2) {
        super(3, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((FlowCollector) r1, (Throwable) r2, (Continuation) r3);
    }

    public final Object invoke(FlowCollector<? super com.larus.bmhome.chat.component.bottom.voice.service.d> r1, Throwable r2, Continuation<? super Unit> r3) {
        VoiceMixInputComponent$observeNonStreamDetailStatus$2 r4 = new VoiceMixInputComponent$observeNonStreamDetailStatus$2(r3);
        r4.L$0 = r2;
        return r4.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        Throwable r4 = (Throwable) this.L$0;
        int r0 = d0.d;
        d0.a.a("catch observeNonStreamDetailStatus " + r4.getMessage());
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
