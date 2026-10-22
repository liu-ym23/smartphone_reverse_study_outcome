package com.larus.bmhome.chat;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.im.bean.message.Message;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.FlowMessageImpl$reSendMessageThroughModify$1", f = "FlowMessageImpl.kt", i = {1}, l = {88, 93, 118}, m = "invokeSuspend", n = {"message"}, s = {"L$0"})
public final class FlowMessageImpl$reSendMessageThroughModify$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $extras;
    final /* synthetic */ boolean $isQuestion;
    final /* synthetic */ String $messageId;
    final /* synthetic */ ChatPageContext $pageContext;
    final /* synthetic */ String $scene;
    Object L$0;
    int label;
    final /* synthetic */ FlowMessageImpl this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.FlowMessageImpl$reSendMessageThroughModify$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.FlowMessageImpl$reSendMessageThroughModify$1$1", f = "FlowMessageImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $extras;
        final /* synthetic */ ChatPageContext $pageContext;
        final /* synthetic */ Message $sanitizedQuestion;
        final /* synthetic */ String $scene;
        int label;
        final /* synthetic */ FlowMessageImpl this$0;

        public AnonymousClass1(String r1, FlowMessageImpl r2, Message r3, Map<String, String> r4, ChatPageContext r5, Continuation<? super AnonymousClass1> r6) {
            this.$scene = r1;
            this.this$0 = r2;
            this.$sanitizedQuestion = r3;
            this.$extras = r4;
            this.$pageContext = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass1(this.$scene, this.this$0, this.$sanitizedQuestion, this.$extras, this.$pageContext, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L12;
            ResultKt.throwOnFailure(r5);
            if (Intrinsics.areEqual(this.$scene, "disable_deep_thinking") == false) goto L7;
        L8:
            FlowMessageImpl r6 = this.this$0;
            r6.b = this.$sanitizedQuestion.getLocalMessageId();
        L9:
            RepoDispatcher.a.getClass();
            RepoDispatcher.d.e.G(this.$sanitizedQuestion, this.$extras, this.$scene, this.$pageContext);
            return Unit.INSTANCE;
        L7:
            if (Intrinsics.areEqual(this.$scene, "deep_thinking") == false) goto L9;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public FlowMessageImpl$reSendMessageThroughModify$1(String r1, boolean r2, Map<String, String> r3, String r4, FlowMessageImpl r5, ChatPageContext r6, Continuation<? super FlowMessageImpl$reSendMessageThroughModify$1> r7) {
        this.$messageId = r1;
        this.$isQuestion = r2;
        this.$extras = r3;
        this.$scene = r4;
        this.this$0 = r5;
        this.$pageContext = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new FlowMessageImpl$reSendMessageThroughModify$1(this.$messageId, this.$isQuestion, this.$extras, this.$scene, this.this$0, this.$pageContext, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r50) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        ResultKt.throwOnFailure(r50);
    L52:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        Message r3 = (Message) this.L$0;
        ResultKt.throwOnFailure(r50);
        Object r4 = r50;
    L25:
        Message r5 = (Message) r4;
        if (r5 != null) goto L30;
        return Unit.INSTANCE;
    L30:
        if (Intrinsics.areEqual(r3.getConversationId(), r5.getConversationId()) == false) goto L32;
        Map<String, String> r6 = this.$extras;
        if (r6 == null) goto L36;
        String r7 = r6.get("conversation_fork_auto_route_reanswer");
    L38:
        if (Intrinsics.areEqual(r7, "1") == false) goto L47;
        Map r12 = r5.getExt();
        if (r12 != null) goto L42;
        r12 = MapsKt.emptyMap();
    L42:
        Map r13 = MapsKt.toMutableMap(r12);
        Iterator r18 = CollectionsKt.listOf(new String[]{"reply_mode", "agent_task_param", "need_deep_think", "force_enable_deepthink", "disable_deepthink", "model_item_key", "mode_id", "agent_mode", "reasoning_effort", "conversation_mode"}).iterator();
    L44:
        if (r18.hasNext() == false) goto L46;
        r13.remove((String) r18.next());
        goto L44
    L46:
        Unit r15 = Unit.INSTANCE;
        Object r8 = null;
        r5 = Message.copy$default(r5, null, null, null, 0, 0, null, 0, false, null, null, null, null, null, r13, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -8193, 31, null);
    L48:
        MainCoroutineDispatcher r9 = Dispatchers.getMain();
        String r10 = this.$scene;
        FlowMessageImpl r11 = this.this$0;
        AnonymousClass1 r14 = new AnonymousClass1(r10, r11, r5, this.$extras, this.$pageContext, null);
        this.L$0 = r8;
        this.label = 3;
        if (BuildersKt.withContext(r9, r14, this) != r1) goto L52;
        return r1;
    L47:
        r8 = null;
        goto L48
    L36:
        r7 = null;
        goto L38
    L32:
        return Unit.INSTANCE;
    L11:
        ResultKt.throwOnFailure(r50);
        Object r16 = r50;
    L15:
        r3 = (Message) r16;
        if (r3 != null) goto L20;
        return Unit.INSTANCE;
    L20:
        if (this.$isQuestion == false) goto L22;
        r5 = r3;
        goto L30
    L22:
        RepoDispatcher.a.getClass();
        ChatRepo r17 = RepoDispatcher.d;
        this.L$0 = r3;
        this.label = 2;
        r4 = r17.y1(r3, this);
        if (r4 != r1) goto L25;
        return r1;
    L12:
        ResultKt.throwOnFailure(r50);
        RepoDispatcher.a.getClass();
        ChatRepo r19 = RepoDispatcher.d;
        String r20 = this.$messageId;
        this.label = 1;
        r16 = r19.E1(r20, this);
        if (r16 != r1) goto L15;
        return r1;
    }
}
