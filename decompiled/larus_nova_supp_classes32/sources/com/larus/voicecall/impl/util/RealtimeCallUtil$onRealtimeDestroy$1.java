package com.larus.voicecall.impl.util;

import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.obric.aivoice.core.data.NameKeys;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
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
@DebugMetadata(c = "com.larus.voicecall.impl.util.RealtimeCallUtil$onRealtimeDestroy$1", f = "RealtimeCallUtil.kt", i = {}, l = {636}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeCallUtil$onRealtimeDestroy$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ CopyOnWriteArraySet<String> $imAsrMsgNum;
    final /* synthetic */ CopyOnWriteArraySet<String> $imTtsMsgNum;
    final /* synthetic */ ConcurrentHashMap<String, String> $imTtsPreQueryMsgMap;
    final /* synthetic */ String $localCallId;
    final /* synthetic */ String $localConversationId;
    final /* synthetic */ IRealtimeCallTracer $tracer;
    final /* synthetic */ CopyOnWriteArraySet<String> $vuiAsrMsgIdSet;
    final /* synthetic */ CopyOnWriteArraySet<String> $vuiChatRespMsgIdSet;
    final /* synthetic */ int $vuiTtsRespMsgNum;
    int label;

    public RealtimeCallUtil$onRealtimeDestroy$1(String r1, String r2, String r3, String r4, IRealtimeCallTracer r5, CopyOnWriteArraySet<String> r6, CopyOnWriteArraySet<String> r7, ConcurrentHashMap<String, String> r8, CopyOnWriteArraySet<String> r9, CopyOnWriteArraySet<String> r10, int r11, Continuation<? super RealtimeCallUtil$onRealtimeDestroy$1> r12) {
        this.$botId = r1;
        this.$localConversationId = r2;
        this.$conversationId = r3;
        this.$localCallId = r4;
        this.$tracer = r5;
        this.$imAsrMsgNum = r6;
        this.$imTtsMsgNum = r7;
        this.$imTtsPreQueryMsgMap = r8;
        this.$vuiAsrMsgIdSet = r9;
        this.$vuiChatRespMsgIdSet = r10;
        this.$vuiTtsRespMsgNum = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r14, Continuation<?> r15) {
        return new RealtimeCallUtil$onRealtimeDestroy$1(this.$botId, this.$localConversationId, this.$conversationId, this.$localCallId, this.$tracer, this.$imAsrMsgNum, this.$imTtsMsgNum, this.$imTtsPreQueryMsgMap, this.$vuiAsrMsgIdSet, this.$vuiChatRespMsgIdSet, this.$vuiTtsRespMsgNum, r15);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        RealtimeCallUtil r2 = RealtimeCallUtil.a;
        String r16 = this.$botId;
        String r3 = this.$localConversationId;
        String r4 = this.$conversationId;
        String r5 = this.$localCallId;
        IRealtimeCallTracer r6 = this.$tracer;
        CopyOnWriteArraySet<String> r7 = this.$imAsrMsgNum;
        CopyOnWriteArraySet<String> r8 = this.$imTtsMsgNum;
        ConcurrentHashMap<String, String> r9 = this.$imTtsPreQueryMsgMap;
        CopyOnWriteArraySet<String> r10 = this.$vuiAsrMsgIdSet;
        CopyOnWriteArraySet<String> r11 = this.$vuiChatRespMsgIdSet;
        int r12 = this.$vuiTtsRespMsgNum;
        this.label = 1;
        if (RealtimeCallUtil.a(r2, r16, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, this) != r0) goto L12;
        return r0;
    }
}
