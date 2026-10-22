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
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.voice.VoiceMixInputComponent$observeNonStreamAsrSession$1$4", f = "VoiceMixInputComponent.kt", i = {}, l = {197, DoraCallStateCode.RTC_STOP_FROM_P2P_FAILED}, m = "invokeSuspend", n = {}, s = {})
final class VoiceMixInputComponent$observeNonStreamAsrSession$1$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VoiceMixInputComponent this$0;

    public VoiceMixInputComponent$observeNonStreamAsrSession$1$4(VoiceMixInputComponent r1, Continuation<? super VoiceMixInputComponent$observeNonStreamAsrSession$1$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new VoiceMixInputComponent$observeNonStreamAsrSession$1$4(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r5);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
    L13:
        VoiceMixInputComponent r6 = this.this$0;
        this.label = 2;
        if (VoiceMixInputComponent.Y2(r6, "canceled", this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r5);
        VoiceMixInputComponent r7 = this.this$0;
        List<Integer> r2 = VoiceMixInputComponent.x;
        z0<com.larus.bmhome.chat.component.bottom.voice.service.d> r8 = r7.p3();
        com.larus.bmhome.chat.component.bottom.voice.service.d.a r3 = com.larus.bmhome.chat.component.bottom.voice.service.d.a.a;
        this.label = 1;
        if (r8.emit(r3, this) != r0) goto L13;
        return r0;
    }
}
