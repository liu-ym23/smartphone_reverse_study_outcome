package com.larus.tts.impl;

import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.tts.impl.TtsReader$startTtsByMsgIdByQueue$1", f = "TtsReader.kt", i = {}, l = {475}, m = "invokeSuspend", n = {}, s = {})
final class TtsReader$startTtsByMsgIdByQueue$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatNext;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ boolean $isFromManual;
    final /* synthetic */ String $msgId;
    final /* synthetic */ String $questionId;
    final /* synthetic */ String $replyUniqueKey;
    final /* synthetic */ boolean $skipTtsChecked;
    final /* synthetic */ String $taskId;
    final /* synthetic */ CoroutineScope $useScopeMayVMScope;
    final /* synthetic */ p68.i $voiceStyleInfo;
    int label;
    final /* synthetic */ TtsReader this$0;

    public TtsReader$startTtsByMsgIdByQueue$1(TtsReader r1, String r2, String r3, String r4, String r5, boolean r6, p68.i r7, boolean r8, String r9, String r10, CoroutineScope r11, Continuation<? super TtsReader$startTtsByMsgIdByQueue$1> r12) {
        this.this$0 = r1;
        this.$taskId = r2;
        this.$questionId = r3;
        this.$conversationId = r4;
        this.$msgId = r5;
        this.$skipTtsChecked = r6;
        this.$voiceStyleInfo = r7;
        this.$isFromManual = r8;
        this.$replyUniqueKey = r9;
        this.$chatNext = r10;
        this.$useScopeMayVMScope = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r14, Continuation<?> r15) {
        return new TtsReader$startTtsByMsgIdByQueue$1(this.this$0, this.$taskId, this.$questionId, this.$conversationId, this.$msgId, this.$skipTtsChecked, this.$voiceStyleInfo, this.$isFromManual, this.$replyUniqueKey, this.$chatNext, this.$useScopeMayVMScope, r15);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x014b -> B:24:0x014d). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r34) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        int r5 = 1;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r34);
        TtsReader$startTtsByMsgIdByQueue$1 r3 = this;
        Object r4 = r1;
        Object r6 = r34;
    L25:
        if (((Boolean) r6).booleanValue() == false) goto L27;
        FLogger.a.i("TtsReader", "[TTS] queue play finished");
        r1 = r4;
        TtsReader$startTtsByMsgIdByQueue$1 r7 = r3;
        r5 = 1;
    L11:
        TtsReader r8 = r7.this$0;
        CoroutineScope r12 = r7.$useScopeMayVMScope;
        r7.label = r5;
        int r9 = TtsReader.i;
        r8.getClass();
        kotlinx.coroutines.j r13 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r7), r5);
        r13.C();
        Ref.BooleanRef r14 = new Ref.BooleanRef();
        TtsReader$b r15 = (TtsReader$b) r8.f.poll();
        if (r15 != null) goto L14;
    L16:
        FLogger.a.i("TtsReader", "[TTS][EMPTY_QUEUE_OR_NOT_ACTIVE] queue poll empty in queue playing tts code " + CoroutineScopeKt.isActive(r12));
        r14.element = true;
        r8.f.clear();
        Result.Companion r10 = Result.Companion;
        r13.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
    L17:
        r6 = r13.B();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        DebugProbesKt.probeCoroutineSuspended(r7);
    L20:
        r4 = r1;
        if (r6 != r4) goto L23;
        return r4;
    L23:
        r3 = r7;
        goto L25
    L14:
        if (CoroutineScopeKt.isActive(r12) == false) goto L16;
        FLogger.a.i("TtsReader", "[TTS] queue poll in queue playing tts task " + r15 + ' ' + CoroutineScopeKt.isActive(r12));
        m0 r11 = BuildersKt.launch$default(r12, Dispatchers.getIO(), null, new TtsReader$asyncPlayTtsByQueue$2$pullStateCorrectionJob$1(r14, r15, r8, r13, null), 2, null).invokeOnCompletion(h0.a);
        TtsReader.c(r8, r15.b, r15.c, r15.d, r15.e, r15.f, r15.g, r15.a, r15.h, new f0(r11, r14, r13), new g0(r11, r14, r8, r13), null, null, r15.i, 3072);
        goto L17
    L27:
        r3.this$0.g = false;
    L29:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r34);
        this.this$0.f.add(new TtsReader$b(this.$taskId, this.$questionId, this.$conversationId, this.$msgId, this.$skipTtsChecked, this.$voiceStyleInfo, this.$isFromManual, this.$replyUniqueKey, this.$chatNext));
        TtsReader r16 = this.this$0;
        if (r16.g == true) goto L29;
        r16.g = true;
        r7 = this;
        goto L11
    }
}
