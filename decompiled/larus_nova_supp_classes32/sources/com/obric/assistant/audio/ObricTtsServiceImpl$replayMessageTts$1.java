package com.obric.assistant.audio;

import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.audio.ObricTtsServiceImpl$replayMessageTts$1", f = "ObricTtsServiceImpl.kt", i = {}, l = {129, 135}, m = "invokeSuspend", n = {}, s = {})
public final class ObricTtsServiceImpl$replayMessageTts$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $messageId;
    final /* synthetic */ int $policy;
    int label;
    final /* synthetic */ ObricTtsServiceImpl this$0;

    public ObricTtsServiceImpl$replayMessageTts$1(String r1, ObricTtsServiceImpl r2, int r3, Continuation<? super ObricTtsServiceImpl$replayMessageTts$1> r4) {
        this.$messageId = r1;
        this.this$0 = r2;
        this.$policy = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricTtsServiceImpl$replayMessageTts$1(this.$messageId, this.this$0, this.$policy, r5);
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
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
    L13:
        Message r6 = (Message) r5;
        if (r6 != null) goto L17;
        FLogger.a.i("ObricTtsServiceImpl", "can't find message " + this.$messageId);
        return Unit.INSTANCE;
    L17:
        ObricTtsServiceImpl r2 = this.this$0;
        int r3 = this.$policy;
        this.label = 2;
        if (ObricTtsServiceImpl.g(r2, r6, null, r3, this) != r0) goto L21;
        return r0;
    L10:
        ResultKt.throwOnFailure(r5);
        IChatRepoService r7 = zh8.a.a;
        IChatRepoService r8 = zh8.a.a;
        String r4 = this.$messageId;
        this.label = 1;
        r5 = r8.E1(r4, this);
        if (r5 != r0) goto L13;
        return r0;
    }
}
