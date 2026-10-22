package com.larus.bmhome.chat.component.bottom.voice;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.voice.VoiceMixInputComponent$observeNonStreamAsrSession$1$1", f = "VoiceMixInputComponent.kt", i = {}, l = {DoraCallStateCode.DOUBAO_FOCUS_CHANGED}, m = "invokeSuspend", n = {}, s = {})
final class VoiceMixInputComponent$observeNonStreamAsrSession$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.chat.component.bottom.core.speaker.e.c $event;
    int label;
    final /* synthetic */ VoiceMixInputComponent this$0;

    public VoiceMixInputComponent$observeNonStreamAsrSession$1$1(VoiceMixInputComponent r1, com.larus.bmhome.chat.component.bottom.core.speaker.e.c r2, Continuation<? super VoiceMixInputComponent$observeNonStreamAsrSession$1$1> r3) {
        this.this$0 = r1;
        this.$event = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new VoiceMixInputComponent$observeNonStreamAsrSession$1$1(this.this$0, this.$event, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        VoiceMixInputComponent r8 = this.this$0;
        List<Integer> r2 = VoiceMixInputComponent.x;
        z0<com.larus.bmhome.chat.component.bottom.voice.service.d> r9 = r8.p3();
        com.larus.bmhome.chat.component.bottom.voice.service.d.c r3 = new com.larus.bmhome.chat.component.bottom.voice.service.d.c(new com.larus.bmhome.chat.component.bottom.voice.service.e(((com.larus.bmhome.chat.component.bottom.core.speaker.e.c.f) this.$event).a, true, -1));
        this.label = 1;
        if (r9.emit(r3, this) != r0) goto L12;
        return r0;
    }
}
