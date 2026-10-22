package com.larus.tts.impl;

import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.im.bean.message.Message;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import zh8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.tts.impl.TtsReader$startTtsByMsgIdTrace$1", f = "TtsReader.kt", i = {}, l = {674}, m = "invokeSuspend", n = {}, s = {})
final class TtsReader$startTtsByMsgIdTrace$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $recMsgId;
    final /* synthetic */ String $sendMsgId;
    final /* synthetic */ String $taskId;
    int label;
    final /* synthetic */ TtsReader this$0;

    public TtsReader$startTtsByMsgIdTrace$1(String r1, TtsReader r2, String r3, String r4, Continuation<? super TtsReader$startTtsByMsgIdTrace$1> r5) {
        this.$sendMsgId = r1;
        this.this$0 = r2;
        this.$recMsgId = r3;
        this.$taskId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new TtsReader$startTtsByMsgIdTrace$1(this.$sendMsgId, this.this$0, this.$recMsgId, this.$taskId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L13:
        Message r7 = (Message) r6;
    L15:
        if (r7 == null) goto L22;
        String r8 = r7.getLocalMessageId();
        if (r8 == null) goto L22;
        TtsReader r2 = this.this$0;
        String r3 = this.$recMsgId;
        String r4 = this.$sendMsgId;
        String r5 = this.$taskId;
        int r9 = TtsReader.i;
        r2.getClass();
        TtsReader.d(r3, r8, r4, r5);
        return Unit.INSTANCE;
    L22:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        if (o0.d(this.$sendMsgId) == false) goto L14;
        IChatRepoService r10 = a.a;
        String r11 = this.$sendMsgId;
        this.label = 1;
        r6 = r10.E1(r11, this);
        if (r6 != r0) goto L13;
        return r0;
    L14:
        r7 = null;
        goto L15
    }
}
