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
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.voice.VoiceMixInputComponent$observeNonStreamAsrSession$1$2", f = "VoiceMixInputComponent.kt", i = {}, l = {DoraCallStateCode.DOUBAO_STOP_RECORD_BY_GUI, DoraCallStateCode.ENV_OBSERVE_USER_TIMER_END}, m = "invokeSuspend", n = {}, s = {})
final class VoiceMixInputComponent$observeNonStreamAsrSession$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.chat.component.bottom.core.speaker.e.c $event;
    int label;
    final /* synthetic */ VoiceMixInputComponent this$0;

    public VoiceMixInputComponent$observeNonStreamAsrSession$1$2(VoiceMixInputComponent r1, com.larus.bmhome.chat.component.bottom.core.speaker.e.c r2, Continuation<? super VoiceMixInputComponent$observeNonStreamAsrSession$1$2> r3) {
        this.this$0 = r1;
        this.$event = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new VoiceMixInputComponent$observeNonStreamAsrSession$1$2(this.this$0, this.$event, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r9);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
    L13:
        VoiceMixInputComponent r10 = this.this$0;
        this.label = 2;
        if (VoiceMixInputComponent.Y2(r10, "success", this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r9);
        VoiceMixInputComponent r11 = this.this$0;
        List<Integer> r2 = VoiceMixInputComponent.x;
        z0<com.larus.bmhome.chat.component.bottom.voice.service.d> r12 = r11.p3();
        com.larus.bmhome.chat.component.bottom.core.speaker.e.c r5 = this.$event;
        com.larus.bmhome.chat.component.bottom.voice.service.d.C0055d r3 = new com.larus.bmhome.chat.component.bottom.voice.service.d.C0055d(new com.larus.bmhome.chat.component.bottom.voice.service.e(((com.larus.bmhome.chat.component.bottom.core.speaker.e.c.g) r5).a, false, ((com.larus.bmhome.chat.component.bottom.core.speaker.e.c.g) r5).b));
        this.label = 1;
        if (r12.emit(r3, this) != r0) goto L13;
        return r0;
    }
}
