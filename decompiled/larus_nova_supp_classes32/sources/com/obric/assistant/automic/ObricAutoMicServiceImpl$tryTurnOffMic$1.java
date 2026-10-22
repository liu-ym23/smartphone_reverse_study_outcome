package com.obric.assistant.automic;

import aga.j;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.ability.audio.ExitClickSpeakerType;
import com.obric.assistant.session.model.IAutoMicOperation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import maa.e$a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.automic.ObricAutoMicServiceImpl$tryTurnOffMic$1", f = "ObricAutoMicServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricAutoMicServiceImpl$tryTurnOffMic$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $taskId;
    int label;
    final /* synthetic */ ObricAutoMicServiceImpl this$0;

    public ObricAutoMicServiceImpl$tryTurnOffMic$1(ObricAutoMicServiceImpl r1, String r2, Continuation<? super ObricAutoMicServiceImpl$tryTurnOffMic$1> r3) {
        this.this$0 = r1;
        this.$taskId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricAutoMicServiceImpl$tryTurnOffMic$1(this.this$0, this.$taskId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r5);
        ObricAutoMicServiceImpl r6 = this.this$0;
        int r0 = ObricAutoMicServiceImpl.i;
        r6.getClass();
        if (ObricAutoMicServiceImpl.p() == null) goto L13;
        String r7 = this.$taskId;
        maa.e r1 = j.e();
        FLogger.a.i("AiIslandVoiceInteractionSession", "tryTurnOffMicUsingClickTalk from taskid " + r7 + " using ability " + r1);
        if (r1 == null) goto L9;
        e$a.a(r1, ExitClickSpeakerType.INTERRUPT, null, false, 6);
    L9:
        IAutoMicOperation r8 = bga.e.a();
        if (r8 == null) goto L13;
        r8.reset();
    L13:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
