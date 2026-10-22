package com.larus.tts.impl;

import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.d1;
import com.tencent.open.log.TraceLevel;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.tts.impl.TtsReader$startTtsByMsgId$3", f = "TtsReader.kt", i = {}, l = {593, 593}, m = "invokeSuspend", n = {}, s = {})
final class TtsReader$startTtsByMsgId$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatNext;
    final /* synthetic */ String $chatType;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ Function1<String, Unit> $failed;
    final /* synthetic */ boolean $isFromManual;
    final /* synthetic */ String $msgId;
    final /* synthetic */ Function0<Unit> $next;
    final /* synthetic */ String $questionId;
    final /* synthetic */ String $replyUniqueKey;
    final /* synthetic */ boolean $skipTtsChecked;
    final /* synthetic */ String $startReadMessageReason;
    final /* synthetic */ String $taskId;
    final /* synthetic */ p68.i $voiceStyleInfo;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ TtsReader this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public TtsReader$startTtsByMsgId$3(String r1, String r2, String r3, String r4, String r5, String r6, boolean r7, p68.i r8, boolean r9, Function0<Unit> r10, Function1<? super String, Unit> r11, String r12, String r13, TtsReader r14, Continuation<? super TtsReader$startTtsByMsgId$3> r15) {
        this.$questionId = r1;
        this.$replyUniqueKey = r2;
        this.$chatNext = r3;
        this.$msgId = r4;
        this.$taskId = r5;
        this.$conversationId = r6;
        this.$skipTtsChecked = r7;
        this.$voiceStyleInfo = r8;
        this.$isFromManual = r9;
        this.$next = r10;
        this.$failed = r11;
        this.$startReadMessageReason = r12;
        this.$chatType = r13;
        this.this$0 = r14;
        super(2, r15);
    }

    public final Continuation<Unit> create(Object r19, Continuation<?> r20) {
        return new TtsReader$startTtsByMsgId$3(this.$questionId, this.$replyUniqueKey, this.$chatNext, this.$msgId, this.$taskId, this.$conversationId, this.$skipTtsChecked, this.$voiceStyleInfo, this.$isFromManual, this.$next, this.$failed, this.$startReadMessageReason, this.$chatType, this.this$0, r20);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        int r3 = this.I$0;
        String r4 = (String) this.L$3;
        String r5 = (String) this.L$2;
        String r6 = (String) this.L$1;
        d1 r7 = (d1) this.L$0;
        ResultKt.throwOnFailure(r21);
        String r9 = r4;
        String r8 = r5;
        Object r10 = r21;
        String r11 = r6;
        d1 r12 = r7;
    L24:
        if (r3 == 0) goto L26;
        boolean r13 = true;
    L27:
        r12.d(r11, r8, r9, r13, (Map) r10, this.$skipTtsChecked, this.$voiceStyleInfo, this.$isFromManual, this.$next, this.$failed, this.$startReadMessageReason, this.$chatType);
        TtsReader.b(this.this$0, this.$questionId, this.$msgId, this.$taskId);
        return Unit.INSTANCE;
    L26:
        r13 = false;
        goto L27
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        int r14 = this.I$0;
        String r15 = (String) this.L$3;
        String r16 = (String) this.L$2;
        String r17 = (String) this.L$1;
        d1 r18 = (d1) this.L$0;
        ResultKt.throwOnFailure(r21);
        String r19 = r15;
        int r20 = r14;
        Object r22 = r21;
    L20:
        String r110 = this.$conversationId;
        this.L$0 = r18;
        this.L$1 = r17;
        this.L$2 = r16;
        this.L$3 = r19;
        this.I$0 = r20;
        this.label = 2;
        d1 r23 = AudioServiceDelegate.a.i0();
        r10 = r23.e((Map) r22, r110, this);
        if (r10 != r1) goto L23;
        return r1;
    L23:
        r3 = r20;
        r12 = r18;
        r9 = r19;
        String r111 = r17;
        r8 = r16;
        r11 = r111;
        goto L24
    L10:
        ResultKt.throwOnFailure(r21);
        HashMap r24 = new HashMap();
        r24.put("question_id", this.$questionId);
        r24.put("enable_toast_reading", "true");
        String r25 = this.$replyUniqueKey;
        if (r25 == null) goto L13;
        r24.put("reply_unique_key", r25);
    L13:
        String r26 = this.$chatNext;
        if (r26 == null) goto L16;
        r24.put("chat_next", r26);
    L16:
        IFlowTtsClientService.a.getClass();
        IFlowTtsClientService.a.a().d(this.$msgId, "startTtsByMsgId");
        AudioServiceDelegate r27 = AudioServiceDelegate.a;
        d1 r28 = r27.i0();
        r17 = this.$taskId;
        String r29 = this.$conversationId;
        r19 = this.$msgId;
        this.L$0 = r28;
        this.L$1 = r17;
        this.L$2 = r29;
        this.L$3 = r19;
        this.I$0 = 0;
        this.label = 1;
        r22 = r27.i0().c(r24, null, this);
        if (r22 != r1) goto L19;
        return r1;
    L19:
        r20 = 0;
        r18 = r28;
        r16 = r29;
        goto L20
    }
}
