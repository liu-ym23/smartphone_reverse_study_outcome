package com.larus.bmhome.chat.component.list;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.PausingDispatcherKt;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowMessageService;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
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
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;
import s1a.a;
import s1a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponent$onViewCreated$1", f = "ChatListComponent.kt", i = {}, l = {1927}, m = "invokeSuspend", n = {}, s = {})
public final class ChatListComponent$onViewCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $completionExtJson;
    int label;
    final /* synthetic */ ChatListComponent this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.list.ChatListComponent$onViewCreated$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponent$onViewCreated$1$1", f = "ChatListComponent.kt", i = {0, 1, 1, 1, 2}, l = {1939, 1954, 1990}, m = "invokeSuspend", n = {"completionExt", "completionExt", "targetConversationId", "attempt", "completionExt"}, s = {"L$0", "L$0", "L$2", "I$2", "L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $completionExtJson;
        int I$0;
        int I$1;
        int I$2;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ ChatListComponent this$0;

        public AnonymousClass1(ChatListComponent r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$completionExtJson = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$completionExtJson, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x0255 -> B:106:0x0257). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r27) {
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            long r3 = 200;
            String r5 = null;
            if (r0 == 0) goto L12;
            if (r0 == 1) goto L11;
            if (r0 == 2) goto L10;
            if (r0 != 3) goto L9;
            int r1 = this.I$1;
            int r11 = this.I$0;
            ComponentFeature r12 = (ChatListComponent) this.L$1;
            Map r13 = (Map) this.L$0;
            ResultKt.throwOnFailure(r27);
            long r6 = 200;
            ComponentFeature r14 = r12;
            Map r15 = r13;
            int r16 = r11;
            AnonymousClass1 r17 = this;
        L106:
            r1 = r1 + 1;
            r3 = r6;
            r5 = null;
        L25:
            if (r1 >= r16) goto L107;
            Bundle r18 = a.c(r14).getArguments();
            if (r18 != null) goto L29;
        L31:
            boolean r7 = false;
        L32:
            if (r7 == false) goto L38;
            r17.L$0 = r15;
            r17.L$1 = r14;
            r17.I$0 = r16;
            r17.I$1 = r1;
            r17.label = 1;
            if (DelayKt.delay(r3, r17) != r2) goto L37;
            return r2;
        L37:
            r6 = r3;
            r15 = r15;
            goto L106
        L38:
            int r8 = ChatListComponent.W3;
            wc9.e r9 = r14.R4();
            if (r9 == null) goto L41;
            String r10 = r9.a;
        L42:
            if (r10 != null) goto L44;
            final String r19 = "";
        L45:
            List r20 = ((ChatListComponent) r14).V0;
            if (r20 != null) goto L48;
            r20 = CollectionsKt.emptyList();
        L48:
            Iterator r4 = SequencesKt.filter(CollectionsKt.asSequence(r20), new j6(r19)).iterator();
            if (r4.hasNext() == true) goto L51;
            Object r21 = r5;
        L60:
            Message r22 = (Message) r21;
            if (r22 == null) goto L63;
            String r23 = r22.getMessageId();
        L64:
            if (r23 != null) goto L67;
            r23 = "";
        L67:
            if ((!StringsKt.isBlank(r23)) == true) goto L70;
            r23 = r5;
        L70:
            if (r23 == null) goto L76;
            RepoDispatcher.a.getClass();
            ChatRepo r24 = RepoDispatcher.d;
            r17.L$0 = r15;
            r17.L$1 = r14;
            r17.L$2 = r19;
            r17.I$0 = r16;
            r17.I$1 = r1;
            r17.I$2 = r1;
            r17.label = 2;
            Object r25 = r24.E1(r23, r17);
            if (r25 != r2) goto L74;
            return r2;
        L74:
            AnonymousClass1 r26 = r17;
            int r110 = r1;
        L75:
            String r28 = (Message) r25;
        L77:
            if (r28 == null) goto L79;
            String r29 = r28.getConversationId();
        L81:
            if (Intrinsics.areEqual(r29, r19) == false) goto L98;
            Map r30 = r28.getExt();
            if (r30 != null) goto L85;
            r30 = MapsKt.emptyMap();
        L85:
            Map r31 = MapsKt.toMutableMap(r30);
            r31.putAll(r15);
            Iterator r32 = CollectionsKt.listOf(new String[]{"reply_mode", "agent_task_param", "need_deep_think", "force_enable_deepthink", "disable_deepthink", "model_item_key", "mode_id", "agent_mode", "reasoning_effort", "conversation_mode"}).iterator();
        L87:
            if (r32.hasNext() == false) goto L89;
            r31.remove((String) r32.next());
            goto L87
        L89:
            r31.put("conversation_fork_auto_route_reanswer", "1");
            IFlowMessageService r111 = (IFlowMessageService) ServiceManager.get().getService(IFlowMessageService.class);
            if (r111 == null) goto L96;
            String r33 = r28.getMessageId();
            if (r33 != null) goto L94;
            String r112 = "";
        L95:
            r111.d(r112, true, r31, "edit", (ChatPageContext) d.a(r14).a(ChatPageContext.class));
            goto L96
        L94:
            r112 = r33;
        L96:
            FLogger.a.i(((ChatListComponent) r14).n, "auto-route fork reanswer requested, conversationId=" + r19 + ", messageId=" + r28.getMessageId());
            return Unit.INSTANCE;
        L98:
            if (r1 > 0) goto L100;
        L102:
            r26.L$0 = r15;
            r26.L$1 = r14;
            r26.L$2 = r5;
            r26.I$0 = r16;
            r26.I$1 = r110;
            r26.label = 3;
            r6 = 200;
            if (DelayKt.delay(200, r26) != r2) goto L105;
            return r2;
        L105:
            r1 = r110;
            r17 = r26;
            goto L106
        L100:
            if ((r1 % 5) != 0) goto L102;
            r14.cE();
            goto L102
        L79:
            r29 = r5;
            goto L81
        L76:
            r28 = r5;
            r26 = r17;
            r110 = r1;
            goto L77
        L63:
            r23 = r5;
            goto L64
        L51:
            r21 = r4.next();
            if (r4.hasNext() == false) goto L60;
            long r113 = ((Message) r21).getLocalIndex();
        L55:
            Object r34 = r4.next();
            long r210 = ((Message) r34).getLocalIndex();
            if (r113 >= r210) goto L59;
            r21 = r34;
            r113 = r210;
        L59:
            if (r4.hasNext() == true) goto L55;
        L44:
            r19 = r10;
            goto L45
        L41:
            r10 = r5;
            goto L42
        L29:
            if (r18.containsKey("reply_mode") != true) goto L31;
            r7 = true;
            goto L32
        L107:
            FLogger.a.e(r17.this$0.n, "auto-route fork reanswer failed: copied query unavailable");
            t19.s r35 = t19.s.a;
            Context r36 = a.c(r17.this$0).requireContext();
            r35.getClass();
            t19.s.b(r36, 2131901132, false);
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            r1 = this.I$2;
            r110 = this.I$1;
            r16 = this.I$0;
            r19 = (String) this.L$2;
            r14 = (ChatListComponent) this.L$1;
            r15 = (Map) this.L$0;
            ResultKt.throwOnFailure(r27);
            r25 = r27;
            r26 = this;
            goto L75
        L11:
            r1 = this.I$1;
            int r114 = this.I$0;
            ComponentFeature r115 = (ChatListComponent) this.L$1;
            Map r116 = (Map) this.L$0;
            ResultKt.throwOnFailure(r27);
            r14 = r115;
            r16 = r114;
            r17 = this;
            r6 = 200;
            r15 = r116;
            goto L106
        L12:
            ResultKt.throwOnFailure(r27);
            CoroutineScope r37 = (CoroutineScope) this.L$0;
            String r38 = this.$completionExtJson;
            Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L19
            JSONObject r118 = new JSONObject(r38);     // Catch: Throwable -> L19
            Sequence r39 = SequencesKt.asSequence(r118.keys());     // Catch: Throwable -> L19
            LinkedHashMap r119 = new LinkedHashMap();     // Catch: Throwable -> L19
            Iterator r40 = r39.iterator();     // Catch: Throwable -> L19
        L15:
            if (r40.hasNext() == false) goto L17;
            Object r120 = r40.next();     // Catch: Throwable -> L19
            r119.put(r120, r118.optString((String) r120));     // Catch: Throwable -> L19
            goto L15
        L17:
            Object r41 = Result.constructor-impl(r119);     // Catch: Throwable -> L19
        L21:
            Map r121 = MapsKt.emptyMap();
            if (Result.isFailure-impl(r41) == false) goto L24;
            r41 = r121;
        L24:
            r16 = 50;
            r15 = (Map) r41;
            r14 = this.this$0;
            r1 = 0;
            r17 = this;
        L19:
            th = move-exception;
            Result.Companion r122 = Result.Companion;
            r41 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L21
        }
    }

    public ChatListComponent$onViewCreated$1(ChatListComponent r1, String r2, Continuation<? super ChatListComponent$onViewCreated$1> r3) {
        this.this$0 = r1;
        this.$completionExtJson = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatListComponent$onViewCreated$1(this.this$0, this.$completionExtJson, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        Lifecycle r8 = a.c(this.this$0).getLifecycle();
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, this.$completionExtJson, null);
        this.label = 1;
        if (PausingDispatcherKt.whenResumed(r8, r2, this) != r0) goto L12;
        return r0;
    }
}
