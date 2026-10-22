package com.ss.android.lark.chat.service.impl;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.MessageFoldDetail;
import com.bytedance.lark.pb.basic.v1.QuasiMessage;
import com.bytedance.lark.pb.basic.v1.Thread;
import com.bytedance.lark.pb.im.v1.AIRoundInfo;
import com.bytedance.lark.pb.im.v1.PushMessageReactions;
import com.bytedance.lark.pb.im.v1.PushMessageReadStates;
import com.bytedance.lark.pb.im.v1.PushMessageResponse;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.SmartReplyEntryInfo;
import com.ss.android.lark.chat.entity.reaction.Reaction;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.ModelParserMessage;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class MessagePushV2 implements m6b.u {
    public static final AtomicLong l = null;
    public static final Executor m = null;
    public final String a;
    public final com.bytedance.lark.rustclient.api.l b;
    public final CopyOnWriteArrayList<com.ss.android.lark.biz.im.api.k0> c;
    public final CopyOnWriteArrayList<g0> d;
    public final Map<String, List<com.ss.android.lark.biz.im.api.f1>> e;
    public final CompositeDisposable f;
    public final long g;
    public final b h;
    public final Lazy i;
    public final c j;
    public final Lazy<Boolean> k;

    public static final class a {
    }

    public static final class b implements Function1<Throwable, Unit> {
        public b() {
        }

        public final Object invoke(Object r2) {
            Throwable r3 = (Throwable) r2;
            Intrinsics.checkNotNullParameter(r3, "throwable");
            Log.e("MessagePush", r3);
            return Unit.INSTANCE;
        }
    }

    public static final class c implements Function1<PushMessageResponse, Unit> {
        public final /* synthetic */ MessagePushV2 a;

        public c(MessagePushV2 r1) {
            this.a = r1;
        }

        public final Object invoke(Object r7) {
            PushMessageResponse r8 = (PushMessageResponse) r7;
            Intrinsics.checkNotNullParameter(r8, "response");
            HashMap r1 = new HashMap();     // Catch: Throwable -> L17
            List r2 = r8.ai_last_round_infos;     // Catch: Throwable -> L17
            if (r2 != null) goto L6;
        L9:
            boolean r3 = true;
        L10:
            if (r3 == true) goto L20;
            Iterator r4 = r8.ai_last_round_infos.iterator();     // Catch: Throwable -> L17
        L13:
            if (r4.hasNext() == false) goto L15;
            AIRoundInfo r5 = (AIRoundInfo) r4.next();     // Catch: Throwable -> L17
            r1.put(Long.valueOf(r5.round_last_position.intValue()), r5);     // Catch: Throwable -> L17
            goto L13
        L15:
            CoreThreadPool.getDefault().getUIExecutor().execute(new g1(r8, this.a));     // Catch: Throwable -> L17
        L20:
            return Unit.INSTANCE;
        L6:
            if (r2.isEmpty() == true) goto L9;
            r3 = false;
        L17:
            th = move-exception;
            Log.e("MessagePush", th, true);
            goto L20
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ MessagePushV2 a;
        public final /* synthetic */ MessageInfo b;

        public d(MessagePushV2 r1, MessageInfo r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<g0> r0 = this.a.d.iterator();     // Catch: Throwable -> L7
        L4:
            if (r0.hasNext() == false) goto L16;
            r0.next().c(this.b);     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    static {
        l = new AtomicLong(0);
        m = PThreadExecutorsUtils.newSingleThreadExecutor(new com.larksuite.framework.thread.n("thread-pool-message-push"));
    }

    @Override // m6b.u
    public final void dispose() {
        Log.i("MessagePush", "dispose id:" + this.g + ",uid:" + this.a);
        this.f.dispose();
    }

    @Override // m6b.u
    public final void I(MessageInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "preMessageInfo");
        m.execute(new d(this, r3));
    }

    @Override // m6b.u
    public final void K3(g0 r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.d.addIfAbsent(r5) == false) goto L8;
        Log.i("MessagePush", "addPushPreMessageListener success:" + ((Boolean) this.k.getValue()).booleanValue() + ",id:" + this.g);
        return;
    L8:
        Log.i("MessagePush", "addPushPreMessageListener duplicated,id:" + this.g);
    }

    @Override // m6b.u
    public final void O3(com.ss.android.lark.biz.im.api.k0 r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Log.i("MessagePush", "removePushMessageListener success:" + this.c.remove(r4) + ",id:" + this.g);
    }

    @Override // m6b.u
    public final void gc(com.ss.android.lark.biz.im.api.k0 r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.c.addIfAbsent(r5) == false) goto L8;
        Log.i("MessagePush", "addPushMessageListener success:" + ((Boolean) this.k.getValue()).booleanValue() + ",id:" + this.g);
        return;
    L8:
        Log.i("MessagePush", "addPushMessageListener duplicated,id:" + this.g);
    }

    @Override // m6b.u
    public final void kd(g0 r4) {
        Log.i("MessagePush", "removePushPreMessageListener success:" + this.d.remove(r4) + ",id:" + this.g);
    }

    @Inject
    public MessagePushV2(String r4, com.bytedance.lark.rustclient.api.l r5) {
        Intrinsics.checkNotNullParameter(r4, "currentUserId");
        Intrinsics.checkNotNullParameter(r5, "userClient");
        this.a = r4;
        this.b = r5;
        this.c = new CopyOnWriteArrayList();
        this.d = new CopyOnWriteArrayList();
        this.e = new ConcurrentHashMap();
        this.f = new CompositeDisposable();
        long r0 = l.getAndIncrement();
        this.g = r0;
        this.h = new b();
        LazyThreadSafetyMode r6 = LazyThreadSafetyMode.SYNCHRONIZED;
        this.i = LazyKt.lazy(r6, new MessagePushV2$roundInfoDisposable$2(this));
        this.j = new c(this);
        this.k = LazyKt.lazy(r6, new MessagePushV2$observePushMessageResult$1(this));
        Log.i("MessagePush", "init uid:" + r4 + ",id:" + r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(final MessagePushV2 r27, PushMessageResponse r28) {
        r27.getClass();
        Function5<MessageInfo, Chat, ThreadTopic, List<? extends MessageInfo>, List<? extends MessageInfo>, Unit> r6 = new MessagePushV2$handlePushMessage$1(r27);
        Function1<MessageInfo, Unit> r7 = new MessagePushV2$handlePushMessage$2(r27);
        Intrinsics.checkNotNullParameter(r28, "pushMessageResponse");
        Entity r8 = r28.entity;
        String r9 = "MessagePush";
        if (r8 != null) goto L5;
        Log.i("MessagePush", "handlePushMessage entity == null");
        return;
    L5:
        List r0 = r28.message_items;
        Map r10 = ModelParserMessage.h(r8);
        int r11 = 1;
        com.ss.android.lark.chat.entity.chatter.a r12 = com.ss.android.lark.parser.internal.b.d(r8, true);
        ThreadTopic r13 = null;
        Map r14 = com.ss.android.lark.parser.internal.h.d(r8.chats, null, r8.mail_setting);
        Map r1 = r8.threads;
        LinkedHashMap r15 = new LinkedHashMap();
        if (r1 == null) goto L13;
        Iterator r2 = r1.keySet().iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        String r3 = (String) r2.next();
        ThreadTopic r4 = com.ss.android.lark.parser.internal.b0.a((Thread) r1.get(r3));
        if (r4 == null) goto L9;
        r15.put(r3, r4);
    L13:
        HashMap r5 = new HashMap();
        Iterator r16 = r0.iterator();
    L15:
        if (r16.hasNext() == false) goto L182;
        PushMessageResponse.MessageItem r17 = (PushMessageResponse.MessageItem) r16.next();
        String r18 = r17.item_id;
        PushMessageResponse.MessageItem.ItemType r19 = r17.item_type;
        if (r19 != null) goto L19;
        int r20 = -1;
    L21:
        if (r20 != r11) goto L23;
    L54:
        HashMap r110 = r5;
        Intrinsics.checkNotNull(r8);
        Intrinsics.checkNotNull(r12);
        Intrinsics.checkNotNull(r18);
        if (r17.item_type != PushMessageResponse.MessageItem.ItemType.EPHEMERAL_MESSAGE) goto L57;
        boolean r21 = true;
    L58:
        Intrinsics.checkNotNullParameter(r8, "entity");
        Intrinsics.checkNotNullParameter(r10, "allMessagesMap");
        Intrinsics.checkNotNullParameter(r12, "chatChatters");
        Intrinsics.checkNotNullParameter(r110, "messageInfoMap");
        Intrinsics.checkNotNullParameter(r18, "itemId");
        LinkedHashMap r22 = (LinkedHashMap) r10;
        Message r23 = (Message) r22.get(r18);
        if (r21 == false) goto L61;
        com.bytedance.lark.pb.basic.v1.Message r24 = (com.bytedance.lark.pb.basic.v1.Message) r8.ephemeral_messages.get(r18);
    L62:
        if (r23 == null) goto L134;
        if (r24 == null) goto L134;
        r23.setEphemeral(r21);
        Log.i("MessagePushV2", "push message:" + r23);
        ChatChatter r25 = r12.b(r23.getChatId(), r23.getFromId());
        String r26 = r23.getId();
        String r111 = r23.getChatId();
        MessageInfo r112 = (MessageInfo) r110.get(r26);
        if (r112 != null) goto L68;
        MessageInfo r29 = new MessageInfo(r23, r25);
    L69:
        r29.setPin(com.ss.android.lark.parser.internal.a.h(r24.pin, r111, r12));
        boolean r30 = Intrinsics.areEqual(r23.getFoldId(), r23.getId());
        Long r31 = StringsKt.toLongOrNull(r23.getFoldId());
        if (r30 == false) goto L82;
        if (r31 == null) goto L82;
        Function5<MessageInfo, Chat, ThreadTopic, List<? extends MessageInfo>, List<? extends MessageInfo>, Unit> r113 = r6;
        Log.i("MessagePushV2", "push message is a fold root, msg id " + r23.getId() + " , fold id is " + r31);
        MessageFoldDetail r32 = (MessageFoldDetail) r8.message_fold_details.get(r31);
        if (r32 != null) goto L75;
        Log.w("MessagePushV2", "push fold root message, but not push fold");
    L80:
        if (r29.getMessageFoldDetail() != null) goto L83;
        r29.setMessageFoldDetail(new com.ss.android.lark.chat.entity.message.MessageFoldDetail.Builder().foldId(r23.getFoldId()).build());
    L83:
        ArrayList r33 = new ArrayList();
        Iterator r34 = r24.reactions.iterator();
    L85:
        if (r34.hasNext() == false) goto L94;
        Reaction r35 = com.ss.android.lark.parser.internal.x.a((com.bytedance.lark.pb.basic.v1.Message.Reaction) r34.next());
        List<String> r114 = r35.getChatterIds();
        Iterator r210 = r34;
        HashMap r36 = new HashMap();
        Iterator<String> r115 = r114.iterator();
    L88:
        if (r115.hasNext() == false) goto L93;
        r115 = r115;
        String r116 = r115.next();
        r10 = r10;
        ChatChatter r117 = r12.b(r111, r116);
        if (r117 != null) goto L91;
        Log.w("MessagePushV2", "reactionChatter is null, chatid: " + r111 + "  reactionChatterId: " + r116);
        r15 = r15;
        goto L88
    L91:
        r36.put(r117.getId(), r117);
        goto L88
    L93:
        r33.add(new ReactionInfo(r35, r36));
        r34 = r210;
        r10 = r10;
        goto L85
    L94:
        Map r211 = r10;
        LinkedHashMap r212 = r15;
        r29.setReactionInfoList(r33);
        com.ss.android.lark.parser.internal.a.m(r24, r29, r12);
        String r37 = r23.getRecallerId();
        if (TextUtils.isEmpty(r37) == true) goto L97;
        r29.setRecallUser(r12.b(r111, r37));
    L97:
        r29.setTranslateInfo(com.ss.android.lark.parser.internal.d0.e(r23, r8, true));
        com.ss.android.lark.parser.internal.a.j(r23, r12);
        r29.setOriginalSender(com.ss.android.lark.parser.internal.a.g(r23, r12));
        com.ss.android.lark.parser.internal.a.i(r23, r12);
        com.ss.android.lark.parser.internal.b0.b(r23, r8, r29);
        ThreadTopic r38 = null;
        com.ss.android.lark.parser.internal.a.c(r23, r8, r29, r12, null);
        com.ss.android.lark.parser.internal.a.a(r23, r8, r29);
        com.bytedance.lark.pb.basic.v1.Message.AIReplyEntryInfo r39 = r24.ai_reply_entry_info;
        if (r39 == null) goto L101;
        r29.setSmartReplyEntryInfo(new SmartReplyEntryInfo(r39.has_pre_generation.booleanValue(), r39.ai_reply_id, null));
    L101:
        String r40 = r23.getRootId();
        if (TextUtils.isEmpty(r40) == true) goto L110;
        MessageInfo r41 = (MessageInfo) r110.get(r40);
        Message r42 = (Message) r22.get(r40);
        if (r41 != null) goto L109;
        if (r42 == null) goto L109;
        ChatChatter r118 = r12.b(r111, r42.getFromId());
        if (r118 == null) goto L109;
        r41 = new MessageInfo(r42, r118);
        r110.put(r40, r41);
    L109:
        r29.setRootMessageInfo(r41);
    L110:
        String r43 = r23.getParentId();
        if (TextUtils.isEmpty(r43) == true) goto L119;
        MessageInfo r44 = (MessageInfo) r110.get(r43);
        Message r45 = (Message) r22.get(r43);
        if (r44 != null) goto L118;
        if (r45 == null) goto L118;
        ChatChatter r119 = r12.b(r111, r45.getFromId());
        if (r119 == null) goto L118;
        r44 = new MessageInfo(r45, r119);
        r110.put(r43, r44);
    L118:
        r29.setParentMessageInfo(r44);
    L119:
        String r46 = String.valueOf(r23.getSyncToChatThreadRootId());
        if (TextUtils.isEmpty(r46) == true) goto L133;
        MessageInfo r47 = (MessageInfo) r110.get(r46);
        Message r48 = (Message) r22.get(r46);
        if (r23.getSyncToChatThreadRootId() == 0) goto L127;
        if (r48 != null) goto L127;
        Map r49 = ImSdkService.f().ie(CollectionsKt.listOf(r46));
        if (r49 == null) goto L127;
        r48 = (Message) r49.get(r46);
    L127:
        if (r47 != null) goto L132;
        if (r48 == null) goto L132;
        ChatChatter r50 = r12.b(r111, r48.getFromId());
        if (r50 == null) goto L132;
        r47 = new MessageInfo(r48, r50);
        r110.put(r46, r47);
    L132:
        r29.setThreadParentMessageInfo(r47);
    L133:
        r110.put(r26, r29);
        MessageInfo r51 = r29;
    L135:
        if (r51 == 0) goto L155;
        String r52 = r51.getMessage().getThreadId();
        if (TextUtils.isEmpty(r52) == false) goto L139;
        ThreadTopic r53 = r38;
        LinkedHashMap r54 = r212;
    L140:
        ArrayList r55 = new ArrayList();
        if (r53 != null) goto L143;
    L154:
        Map r56 = r211;
        List<MessageInfo> r120 = com.ss.android.lark.chat.api.service.impl.q1.a(r8, r53, r12, r56);
        r113.invoke(r51, ((HashMap) r14).get(r51.getMessage().getChatId()), r53, r55, r120);
    L156:
        r13 = r38;
        r15 = r54;
        r10 = r56;
        r5 = r110;
        r9 = r9;
        r7 = r7;
        r6 = r113;
        r14 = r14;
        r11 = 1;
        goto L15
    L143:
        if (CollectionUtils.isNotEmpty(r53.getLastReplyIds()) == false) goto L154;
        Iterator r57 = r53.getLastReplyIds().iterator();
    L146:
        if (r57.hasNext() == false) goto L154;
        String r58 = (String) r57.next();
        Message r121 = (Message) r22.get(r58);
        if (r121 == null) goto L149;
        ChatChatter r122 = r12.b(r121.getChatId(), r121.getFromId());
        if (r122 == null) goto L152;
        MessageInfo r59 = new MessageInfo(r121, r122);
        r59.setTranslateInfo(com.ss.android.lark.parser.internal.d0.e(r121, r8, true));
        r55.add(r59);
        goto L146
    L152:
        Log.e("MessagePushV2", "message sender is null, replyId=" + r58);
        goto L146
    L149:
        Log.e("MessagePushV2", "message is null, replyId=" + r58);
        goto L146
    L139:
        r54 = r212;
        r53 = (ThreadTopic) r54.get(r52);
        goto L140
    L155:
        r56 = r211;
        r54 = r212;
        goto L156
    L75:
        Pair r60 = ModelParserMessage.g(r8, r23.getFoldId());
        if (r60 == null) goto L78;
        Message r61 = (Message) r60.getFirst();
        com.ss.android.lark.chat.entity.message.MessageFoldDetail r62 = com.ss.android.lark.parser.internal.a.d(r32, r61, r12, (com.bytedance.lark.pb.basic.v1.Chat) r8.chats.get(r23.getChatId()));
        Log.i("MessagePushV2", "try to get fold from push entity is " + r62);
        r29.setMessage(r61);
        r29.setMessageFoldDetail(r62);
        goto L80
    L78:
        Log.w("MessagePushV2", "parseMessageFromFold get empty result");
    L82:
        r113 = r6;
        r14 = r14;
        goto L83
    L68:
        r29 = r112;
    L134:
        r113 = r6;
        r211 = r10;
        r38 = r13;
        r14 = r14;
        r212 = r15;
        Log.e("MessagePushV2", "Failed to find message or pbMessage, item id is: " + r18);
        r51 = r38;
        goto L135
    L61:
        r24 = (com.bytedance.lark.pb.basic.v1.Message) r8.messages.get(r18);
        goto L62
    L57:
        r21 = false;
        goto L58
    L23:
        if (r20 == 2) goto L54;
        if (r20 != 3) goto L27;
        r110 = r5;
        Intrinsics.checkNotNull(r8);
        Intrinsics.checkNotNull(r12);
        Intrinsics.checkNotNull(r18);
        QuasiMessage r63 = (QuasiMessage) r8.quasi_messages.get(r18);
        if (r63 != null) goto L49;
        Log.e("MessagePushV2", "Fail to find pbMessage, item id is: " + r18);
        ThreadTopic r64 = r13;
    L50:
        if (r64 == null) goto L52;
        Log.i(r9, "handlePushPreMessage, message:" + r64);
        r7.invoke(r64);
    L52:
        r113 = r6;
        r7 = r7;
        r9 = r9;
        r56 = r10;
        r38 = r13;
        r14 = r14;
        r54 = r15;
        goto L156
    L49:
        Message r65 = ModelParserMessage.d(r8, r63);
        Log.i("MessagePushV2", "push premessage: " + r65);
        r64 = ModelParserMessage.k(r65, r8, r12, r13);
        goto L50
    L27:
        if (r20 != 4) goto L29;
        Log.i(r9, "handlePushFoldMessage, push fold id is : " + r17.item_id);
        Pair r66 = ModelParserMessage.g(r8, r17.item_id);
        if (r66 != null) goto L35;
        Log.w(r9, "handlePushFoldMessage, pushFold: try to getFold message by id, but get null");
    L41:
        r110 = r5;
        goto L52
    L35:
        com.bytedance.lark.pb.basic.v1.Message r67 = (com.bytedance.lark.pb.basic.v1.Message) r66.getSecond();
        ChatChatter r68 = r12.b(r67.chat_id, r67.from_id);
        if (r68 != null) goto L38;
        Log.w(r9, "handlePushFoldMessage, pushFold: no chatter");
        goto L41
    L38:
        MessageInfo r69 = new MessageInfo((Message) r66.getFirst(), r68);
        Long r70 = StringsKt.toLongOrNull(r69.getMessage().getFoldId());
        if (r70 != null) goto L42;
        Log.w(r9, "handlePushFoldMessage, pushFold: fold is is empty");
        goto L41
    L42:
        com.ss.android.lark.chat.entity.message.MessageFoldDetail r71 = com.ss.android.lark.parser.internal.a.d((MessageFoldDetail) r8.message_fold_details.get(r70), r69.getMessage(), r12, (com.bytedance.lark.pb.basic.v1.Chat) r8.chats.get(r69.getMessage().getChatId()));
        if (r71 != null) goto L45;
        r71 = new com.ss.android.lark.chat.entity.message.MessageFoldDetail.Builder().foldId(r69.getMessage().getFoldId()).build();
    L45:
        r69.setMessageFoldDetail(r71);
        Log.i("MessagePushV2", "pushMessage: push fold");
        Function5<MessageInfo, Chat, ThreadTopic, List<? extends MessageInfo>, List<? extends MessageInfo>, Unit> r72 = r6;
        r110 = r5;
        r72.invoke(r69, ((HashMap) r14).get(r69.getMessage().getChatId()), null, CollectionsKt.emptyList(), CollectionsKt.emptyList());
        goto L52
    L29:
        if (r20 == 5) goto L31;
        Log.w("MessagePushV2", "pushMessage, message type is unknown, item id is: " + r18);
        goto L41
    L31:
        Log.w("MessagePushV2", "pushMessage, message type is unknown, item id is: " + r18);
        goto L41
    L19:
        r20 = m6b.w.a[r19.ordinal()];
        goto L21
    }

    public static final void b(MessagePushV2 r14, PushMessageReactions r15) {
        r14.getClass();
        if (r15.msg_id2reactions != null) goto L5;
        Log.i("MessagePushV2", "handleReactionPushMessage, reactions or msg_id2reactions is null");
        return;
    L5:
        StringBuilder r0 = new StringBuilder("handleReactionPushMessage: ");
        StringBuilder r2 = new StringBuilder();
        r2.append(", chat_id=");
        r2.append(r15.chat_id);
        Map r3 = r15.msg_id2reactions;
        if (r3 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == true) goto L14;
        r2.append(", msg_id2reactions=");
        Map r5 = r15.msg_id2reactions;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r2.append(CollectionsKt.joinToString$default(r5.entrySet(), ", ", "{", "}", 0, null, ToStringHelper$asString$1.INSTANCE, 24, null));
    L14:
        StringBuilder r6 = r2.replace(0, 2, "PushMessageReactions{");
        r6.append('}');
        r0.append(r6.toString());
        Log.i("MessagePushV2", r0.toString());
        CoreThreadPool.getDefault().getUIExecutor().execute(new e1(r14, r15));
        return;
    L8:
        if (r3.isEmpty() == true) goto L11;
        r4 = false;
        goto L12
    }

    public static final void c(MessagePushV2 r2, PushMessageReadStates r3) {
        r2.getClass();
        Log.i("MessagePush", "handlePushReadStates chatId:" + r3.chat_id);
        CoreThreadPool.getDefault().getUIExecutor().execute(new f1(r2, r3));
    }

    @Override // m6b.u
    public final void Hd(String r6, Long r7, com.ss.android.lark.biz.im.api.f1 r8) {
        Intrinsics.checkNotNullParameter(r6, "chatId");
        if (r8 != null) goto L5;
        return;
    L5:
        if (r7 != null) goto L7;
    L9:
        List r9 = (List) ((ConcurrentHashMap) this.e).get(r6);
        Log.i("MessagePush", "removePushAIRoundInfoListener, use key: " + r6);
        if (r9 == null) goto L13;
        r9.remove(r8);
        return;
    L13:
        return;
    L7:
        if (r7.longValue() == 0) goto L9;
        r6 = r6 + '_' + r7;
        goto L9
    }

    @Override // m6b.u
    public final void pb(String r6, Long r7, com.ss.android.lark.biz.im.api.f1 r8) {
        Intrinsics.checkNotNullParameter(r6, "chatId");
        if (r8 != null) goto L5;
        return;
    L5:
        if (r7 != null) goto L7;
    L9:
        List r9 = (List) ((ConcurrentHashMap) this.e).get(r6);
        if (r9 != null) goto L12;
        r9 = new CopyOnWriteArrayList();
        ((ConcurrentHashMap) this.e).put(r6, r9);
    L12:
        Log.i("MessagePush", "addPushAIRoundInfoListener, use key: " + r6);
        r9.add(r8);
        Disposable r10 = (Disposable) this.i.getValue();
        Log.i("MessagePush", "add listener to roundInfoDisposable");
        return;
    L7:
        if (r7.longValue() == 0) goto L9;
        r6 = r6 + '_' + r7;
        goto L9
    }
}
