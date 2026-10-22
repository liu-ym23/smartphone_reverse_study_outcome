package com.larus.bmhome.chat.component.regen;

import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.message.IObricMessageService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.regen.RegenAnswerComponent$resetByReply$1", f = "RegenAnswerComponent.kt", i = {}, l = {347, 415}, m = "invokeSuspend", n = {}, s = {})
public final class RegenAnswerComponent$resetByReply$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MessageAdapter $adapter;
    final /* synthetic */ Message $reply;
    int label;
    final /* synthetic */ RegenAnswerComponent this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.regen.RegenAnswerComponent$resetByReply$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.regen.RegenAnswerComponent$resetByReply$1$1", f = "RegenAnswerComponent.kt", i = {}, l = {348, 405}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MessageAdapter $adapter;
        final /* synthetic */ Message $reply;
        final /* synthetic */ String $sender;
        int label;
        final /* synthetic */ RegenAnswerComponent this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.component.regen.RegenAnswerComponent$resetByReply$1$1$a */
        public static final class a<T> implements Comparator {
            public a() {
            }

            @Override // java.util.Comparator
            public final int compare(T r3, T r4) {
                return ComparisonsKt.compareValues(Long.valueOf(((Message) r3).getLocalIndex()), Long.valueOf(((Message) r4).getLocalIndex()));
            }
        }

        public AnonymousClass1(Message r1, MessageAdapter r2, RegenAnswerComponent r3, String r4, Continuation<? super AnonymousClass1> r5) {
            this.$reply = r1;
            this.$adapter = r2;
            this.this$0 = r3;
            this.$sender = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$reply, this.$adapter, this.this$0, this.$sender, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r21v0, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r6v18, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r6v19 */
        /* JADX WARN: Type inference failed for: r6v21, types: [java.util.List] */
        public final Object invokeSuspend(Object r26) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            ResultKt.throwOnFailure(r26);
        L148:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r26);
            Object r3 = r26;
        L13:
            List r4 = CollectionsKt.sortedWith((Iterable) r3, new a());
            FLogger.a.i("RegenAnswerComponent", "resetByReply query replyId=" + this.$reply.getReplyId() + " replyLocalMsgId=" + this.$reply.getLocalMessageId() + " replyMsgId=" + this.$reply.getMessageId() + " listSize=" + r4.size());
            Integer[] r5 = {Boxing.boxInt(1), Boxing.boxInt(6), Boxing.boxInt(9999), Boxing.boxInt(2022)};
            Long r9 = null;
            if ((!r4.isEmpty()) == false) goto L50;
            Iterator r6 = r4.iterator();
        L17:
            if (r6.hasNext() == false) goto L45;
            Object r10 = r6.next();
            Message r11 = (Message) r10;
            if (com.larus.im.bean.message.a.b0(r11) == true) goto L21;
            String r12 = r11.getContent();
            if (r12 != null) goto L26;
        L29:
            boolean r13 = true;
        L30:
            if (r13 == false) goto L32;
        L42:
            boolean r14 = true;
        L43:
            if (r14 == false) goto L17;
        L46:
            if (r10 == null) goto L50;
            if (d.F0(this.$reply) == true) goto L50;
            boolean r7 = true;
        L51:
            if (r7 == false) goto L53;
            FLogger.a.i("RegenAnswerComponent", "resetByReply filterNotRegen invalidAnswer replyId=" + this.$reply.getReplyId() + " isSearchMixedText=" + d.F0(this.$reply));
        L53:
            if (r7 == true) goto L71;
            List<Message> r8 = this.$adapter.getCurrentList();
            String r15 = this.$sender;
            Iterator r16 = ((ArrayList) r8).iterator();
        L56:
            if (r16.hasNext() == false) goto L60;
            Object r17 = r16.next();
            if (Intrinsics.areEqual(((Message) r17).getSenderId(), r15) == false) goto L56;
        L61:
            Message r18 = (Message) r17;
            if (r18 != null) goto L64;
        L66:
            boolean r19 = false;
        L67:
            if (r19 == false) goto L71;
            if (Intrinsics.areEqual(r18.getMessageId(), this.$reply.getReplyId()) == true) goto L71;
            FLogger.a.i("RegenAnswerComponent", "resetByReply filterNotRegen notLatest replyId=" + this.$reply.getReplyId() + " latestSendMsgId=" + r18.getMessageId() + " latestSendLocalMsgId=" + r18.getLocalMessageId());
            r7 = true;
            goto L71
        L64:
            if (d.r0(r18) == true) goto L66;
            r19 = true;
            goto L67
        L60:
            r17 = null;
        L71:
            FLogger r20 = FLogger.a;
            StringBuilder r110 = new StringBuilder("resetByReply updateData question=");
            r110.append(this.$reply.getReplyId());
            r110.append(" selected=");
            r110.append(this.$reply.getLocalMessageId());
            r110.append(" answersSize=");
            if (r7 == false) goto L74;
            int r111 = 0;
        L75:
            r110.append(r111);
            r110.append(" filterNotRegen=");
            r110.append(r7);
            r110.append(" minLocalIndex=");
            List r21 = r4;
            Iterator r112 = r21.iterator();
            if (r112.hasNext() == true) goto L78;
            Long r113 = null;
        L84:
            long r114 = 0;
            if (r113 == null) goto L87;
            long r115 = r113.longValue();
        L88:
            r110.append(r115);
            r110.append(" noRegenAction=");
            if (r7 == true) goto L107;
            Iterator r116 = r21.iterator();
            if (r116.hasNext() == true) goto L93;
            Long r22 = null;
        L100:
            if (r22 == null) goto L102;
            long r117 = r22.longValue();
        L104:
            if (r117 <= 1000) goto L107;
            boolean r23 = false;
        L108:
            r110.append(r23);
            r20.i("RegenAnswerComponent", r110.toString());
            RegenAnswerComponent r24 = this.this$0;
            String r25 = this.$reply.getReplyId();
            if (r25 != null) goto L111;
            String r118 = "";
        L112:
            String r27 = this.$reply.getLocalMessageId();
            if (r27 != null) goto L115;
            String r28 = "";
        L116:
            if (r7 == false) goto L119;
            ?? r29 = CollectionsKt.emptyList();
        L118:
            ?? r210 = r29;
            if (r7 == true) goto L143;
            Iterator r30 = r21.iterator();
            if (r30.hasNext() == false) goto L137;
            Long r31 = Boxing.boxLong(((Message) r30.next()).getLocalIndex());
        L131:
            r9 = r31;
        L133:
            if (r30.hasNext() == false) goto L137;
            r31 = Boxing.boxLong(((Message) r30.next()).getLocalIndex());
            if (r9.compareTo(r31) <= 0) goto L133;
        L137:
            if (r9 == null) goto L140;
            r114 = r9.longValue();
        L140:
            if (r114 <= 1000) goto L143;
            boolean r211 = false;
        L144:
            this.label = 2;
            r24.getClass();
            if (BuildersKt.withContext(Dispatchers.getMain(), new RegenAnswerComponent$updateRegenAnswersData$2(r118, r28, r210, r211, r24, null), this) != r1) goto L148;
            return r1;
        L143:
            r211 = true;
            goto L144
        L119:
            r29 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
            Iterator r32 = r21.iterator();
        L121:
            if (r32.hasNext() == false) goto L118;
            String r119 = ((Message) r32.next()).getLocalMessageId();
            if (r119 != null) goto L125;
            r119 = "";
        L125:
            r29.add(r119);
            goto L121
        L115:
            r28 = r27;
            goto L116
        L111:
            r118 = r25;
            goto L112
        L102:
            r117 = 0;
            goto L104
        L93:
            r22 = Boxing.boxLong(((Message) r116.next()).getLocalIndex());
        L95:
            if (r116.hasNext() == false) goto L100;
            Long r33 = Boxing.boxLong(((Message) r116.next()).getLocalIndex());
            if (r22.compareTo(r33) <= 0) goto L95;
            r22 = r33;
        L107:
            r23 = true;
            goto L108
        L87:
            r115 = 0;
            goto L88
        L78:
            r113 = Boxing.boxLong(((Message) r112.next()).getLocalIndex());
        L80:
            if (r112.hasNext() == false) goto L84;
            Long r120 = Boxing.boxLong(((Message) r112.next()).getLocalIndex());
            if (r113.compareTo(r120) <= 0) goto L80;
            r113 = r120;
            goto L80
        L74:
            r111 = r4.size();
            goto L75
        L32:
            if (ArraysKt.contains(r5, Boxing.boxInt(r11.getContentType())) == false) goto L42;
            IObricMessageService r121 = (IObricMessageService) ServiceManager.get().getService(IObricMessageService.class);
            if (r121 != null) goto L36;
        L38:
            boolean r122 = false;
        L39:
            if (r122 == true) goto L42;
            r14 = false;
            goto L43
        L36:
            if (r121.isObricIntentMessage(r11) != true) goto L38;
            r122 = true;
            goto L39
        L26:
            if (r12.length() == 0) goto L29;
        L28:
            r13 = false;
            goto L30
        L21:
            if (com.larus.im.bean.message.a.e(r11).length() != 0) goto L28;
        L45:
            r10 = null;
        L50:
            r7 = false;
            goto L51
        L10:
            ResultKt.throwOnFailure(r26);
            RepoDispatcher.a.getClass();
            ChatRepo r34 = RepoDispatcher.d;
            Message r35 = this.$reply;
            this.label = 1;
            r34.getClass();
            r3 = ChatRepo.c(r35, this);
            if (r3 != r1) goto L13;
            return r1;
        }
    }

    public RegenAnswerComponent$resetByReply$1(Message r1, RegenAnswerComponent r2, MessageAdapter r3, Continuation<? super RegenAnswerComponent$resetByReply$1> r4) {
        this.$reply = r1;
        this.this$0 = r2;
        this.$adapter = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new RegenAnswerComponent$resetByReply$1(this.$reply, this.this$0, this.$adapter, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
    L18:
        Unit r13 = (Unit) r12;
    L20:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
        goto L20
    L10:
        ResultKt.throwOnFailure(r12);
        if (this.$reply == null) goto L15;
        FLogger.a.i("RegenAnswerComponent", "resetByReply called, reply is not null");
        String r8 = AccountService.a.getUserId();
        RepoDispatcher.a.getClass();
        ExecutorCoroutineDispatcher r14 = RepoDispatcher.b;
        AnonymousClass1 r2 = new AnonymousClass1(this.$reply, this.$adapter, this.this$0, r8, null);
        this.label = 1;
        if (BuildersKt.withContext(r14, r2, this) != r0) goto L20;
        return r0;
    L15:
        FLogger.a.i("RegenAnswerComponent", "resetByReply called, reply is null");
        RegenAnswerComponent r9 = this.this$0;
        List r7 = CollectionsKt.emptyList();
        this.label = 2;
        r9.getClass();
        r12 = BuildersKt.withContext(Dispatchers.getMain(), new RegenAnswerComponent$updateRegenAnswersData$2("", "", r7, false, r9, null), this);
        if (r12 != r0) goto L18;
        return r0;
    }
}
