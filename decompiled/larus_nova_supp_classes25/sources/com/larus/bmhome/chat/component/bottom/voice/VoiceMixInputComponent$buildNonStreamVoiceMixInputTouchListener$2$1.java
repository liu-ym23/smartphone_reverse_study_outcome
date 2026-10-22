package com.larus.bmhome.chat.component.bottom.voice;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.speaker.l$a;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.voice.VoiceMixInputComponent$buildNonStreamVoiceMixInputTouchListener$2$1", f = "VoiceMixInputComponent.kt", i = {}, l = {333}, m = "invokeSuspend", n = {}, s = {})
public final class VoiceMixInputComponent$buildNonStreamVoiceMixInputTouchListener$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VoiceMixInputComponent this$0;

    public VoiceMixInputComponent$buildNonStreamVoiceMixInputTouchListener$2$1(VoiceMixInputComponent r1, Continuation<? super VoiceMixInputComponent$buildNonStreamVoiceMixInputTouchListener$2$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new VoiceMixInputComponent$buildNonStreamVoiceMixInputTouchListener$2$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r17);
    L11:
        VoiceMixInputComponent r3 = this.this$0;
        List<Integer> r4 = VoiceMixInputComponent.x;
        r3.C3().a();
        com.larus.bmhome.chat.component.bottom.core.speaker.l r5 = this.this$0.B3();
        if (r5 == null) goto L15;
        l$a.a(r5, true, true, null, false, new com.larus.audio.asr.c0(null, null, 1, 251), null, null, null, null, null, 1004);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        VoiceMixInputComponent r6 = this.this$0;
        this.label = 1;
        if (VoiceMixInputComponent.h3(r6, this) != r1) goto L11;
        return r1;
    }
}
