package com.larus.bmhome.chat.component.bottom.voice.service;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.voice.service.VoiceMixInputService$interruptVoiceMixInput$1", f = "VoiceMixInputService.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
public final class VoiceMixInputService$interruptVoiceMixInput$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $flushTextStream;
    final /* synthetic */ Function0<Unit> $onBeforeStop;
    int label;
    final /* synthetic */ VoiceMixInputService this$0;

    public VoiceMixInputService$interruptVoiceMixInput$1(Function0<Unit> r1, boolean r2, VoiceMixInputService r3, Continuation<? super VoiceMixInputService$interruptVoiceMixInput$1> r4) {
        this.$onBeforeStop = r1;
        this.$flushTextStream = r2;
        this.this$0 = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new VoiceMixInputService$interruptVoiceMixInput$1(this.$onBeforeStop, this.$flushTextStream, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        this.$onBeforeStop.invoke();
        if (this.$flushTextStream == false) goto L14;
        VoiceMixInputManager.TextStreamWrapper r5 = this.this$0.e();
        this.label = 1;
        if (r5.d() != r0) goto L14;
        return r0;
    }
}
