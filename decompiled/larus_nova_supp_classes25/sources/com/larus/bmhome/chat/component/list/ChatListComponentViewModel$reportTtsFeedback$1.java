package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.http.HttpExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponentViewModel$reportTtsFeedback$1", f = "ChatListComponentViewModel.kt", i = {}, l = {449}, m = "invokeSuspend", n = {}, s = {})
public final class ChatListComponentViewModel$reportTtsFeedback$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ int $feedbackStatus;
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $taskId;
    final /* synthetic */ long $ttsDuration;
    int label;

    public ChatListComponentViewModel$reportTtsFeedback$1(String r1, String r2, String r3, int r4, long r5, Continuation<? super ChatListComponentViewModel$reportTtsFeedback$1> r7) {
        this.$botId = r1;
        this.$messageId = r2;
        this.$taskId = r3;
        this.$feedbackStatus = r4;
        this.$ttsDuration = r5;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ChatListComponentViewModel$reportTtsFeedback$1(this.$botId, this.$messageId, this.$taskId, this.$feedbackStatus, this.$ttsDuration, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        JSONObject r4 = new JSONObject();
        String r5 = this.$botId;
        String r6 = this.$messageId;
        String r7 = this.$taskId;
        int r8 = this.$feedbackStatus;
        long r9 = this.$ttsDuration;
        r4.put("bot_id", r5);
        r4.put("message_id", r6);
        r4.put("task_id", r7);
        r4.put("feedback_type", 1);
        r4.put("feedback_status", r8);
        if (r8 != 3) goto L11;
        r4.put("tts_during_time_ms", r9);
    L11:
        Unit r10 = Unit.INSTANCE;
        this.label = 1;
        if (HttpExtKt.k("Audio", Object.class, "/alice/audio/voice_feedback", r4, null, null, false, null, null, null, this, 1008) != r0) goto L15;
        return r0;
    }
}
