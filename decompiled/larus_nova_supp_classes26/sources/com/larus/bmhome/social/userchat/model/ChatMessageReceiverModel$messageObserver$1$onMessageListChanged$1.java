package com.larus.bmhome.social.userchat.model;

import androidx.collection.LruCache;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.bmhome.social.page.datasource.event.RefreshTraceSource;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.observer.MessageListState;
import com.larus.platform.IFlowMessageService;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatService;
import com.larus.tts.TtsScene;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.spi.audio.ObricTtsControlDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.ChatMessageReceiverModel$messageObserver$1$onMessageListChanged$1", f = "ChatMessageReceiverModel.kt", i = {}, l = {449, 484}, m = "invokeSuspend", n = {}, s = {})
public final class ChatMessageReceiverModel$messageObserver$1$onMessageListChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cid;
    final /* synthetic */ String $listChangedTraceId;
    final /* synthetic */ List<Message> $msgList;
    final /* synthetic */ MessageListState $state;
    int label;
    final /* synthetic */ ChatMessageReceiverModel this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MessageListState.values().length];
            r0[MessageListState.DELETE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[MessageListState.REFRESH_ALL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[MessageListState.INSERT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[MessageListState.UPDATE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public ChatMessageReceiverModel$messageObserver$1$onMessageListChanged$1(ChatMessageReceiverModel r1, MessageListState r2, List<Message> r3, String r4, String r5, Continuation<? super ChatMessageReceiverModel$messageObserver$1$onMessageListChanged$1> r6) {
        this.this$0 = r1;
        this.$state = r2;
        this.$msgList = r3;
        this.$listChangedTraceId = r4;
        this.$cid = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ChatMessageReceiverModel$messageObserver$1$onMessageListChanged$1(this.this$0, this.$state, this.$msgList, this.$listChangedTraceId, this.$cid, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r62) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        Object r13 = null;
        boolean r14 = false;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        ResultKt.throwOnFailure(r62);
    L81:
        List<Message> r1 = this.$msgList;
        ChatMessageReceiverModel r2 = this.this$0;
        if (r2.h == false) goto L101;
        FLogger.a.i(r2.k, "interceptAndHideCollectionMessageButtons");
        List<Message> r3 = r1;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
    L85:
        if (r5.hasNext() == false) goto L100;
        Message r16 = (Message) r5.next();
        if (com.larus.bmhome.chat.bean.d.G0(r16) == true) goto L99;
        if (com.larus.im.bean.message.a.Z(r16) == false) goto L99;
        if (com.larus.im.bean.message.a.Y(r16) == false) goto L99;
        IChatRepoService r6 = zh8.a.a;
        String r7 = r16.getLocalMessageId();
        if (r7 != null) goto L95;
        r7 = "";
    L95:
        r6.r1(r7, new i());
        Map r8 = r16.getBusinessExt();
        if (r8 != null) goto L98;
        r8 = new LinkedHashMap();
    L98:
        Map r9 = MapsKt.toMutableMap(r8);
        r9.put("common_button_v2_hidden", "true");
        Unit r10 = Unit.INSTANCE;
        r16 = Message.copy$default(r16, null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, r9, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -4194305, 31, null);
    L99:
        r4.add(r16);
        goto L85
    L100:
        r1 = r4;
    L101:
        List<Message> r18 = r1;
        ChatMessageReceiverModel.j(this.this$0, 1, r18, false, null, this.$listChangedTraceId, RefreshTraceSource.LIST_INSERT, 12);
        if (ObricTtsControlDelegate.b.e() == false) goto L148;
        ChatMessageReceiverModel r12 = this.this$0;
        ArrayList r15 = new ArrayList();
        Iterator r17 = r1.iterator();
    L105:
        if (r17.hasNext() == false) goto L114;
        Object r19 = r17.next();
        Message r20 = (Message) r19;
        if (com.larus.bmhome.chat.bean.d.G0(r20) == true) goto L111;
        r12.getClass();
        if ((!com.larus.im.bean.message.a.C0(r20)) == false) goto L111;
        boolean r21 = true;
    L112:
        if (r21 == false) goto L105;
        r15.add(r19);
    L111:
        r21 = false;
        goto L112
    L114:
        Iterator r22 = r15.iterator();
        if (r22.hasNext() == false) goto L126;
        r13 = r22.next();
        if (r22.hasNext() == false) goto L126;
        long r23 = ((Message) r13).getLocalIndex();
    L121:
        Object r24 = r22.next();
        long r25 = ((Message) r24).getLocalIndex();
        if (r23 >= r25) goto L125;
        r13 = r24;
        r23 = r25;
    L125:
        if (r22.hasNext() == true) goto L121;
    L126:
        Message r110 = (Message) r13;
        if (r110 == null) goto L148;
        ChatMessageReceiverModel r26 = this.this$0;
        r26.u.a(r26.r, r26.n, r110, TtsScene.Auto_ReceiveMessage);
    L148:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r62);
    L13:
        ChatMessageReceiverModel r27 = this.this$0;
        String r28 = "onMessageListChanged " + this.$state + ' ';
        List<Message> r29 = this.$msgList;
        int r30 = ChatMessageReceiverModel.P;
        r27.r(r28, r29);
        MessageListState r31 = this.$state;
        if (r31 != MessageListState.INSERT) goto L16;
    L17:
        List<Message> r32 = this.$msgList;
        ChatMessageReceiverModel r33 = this.this$0;
        Iterator<T> r34 = r32.iterator();
    L19:
        if (r34.hasNext() == false) goto L28;
        Message r35 = (Message) r34.next();
        dh8.b r36 = dh8.b.a;
        Iterator<Message> r37 = r33.n.iterator();
    L22:
        if (r37.hasNext() == false) goto L26;
        Message r38 = r37.next();
        if (Intrinsics.areEqual(r38.getLocalMessageId(), r35.getLocalMessageId()) == false) goto L22;
    L27:
        r36.getClass();
        dh8.b.l(r35, r38);
        goto L19
    L26:
        r38 = null;
    L28:
        int r39 = a.a[this.$state.ordinal()];
        if (r39 == 1) goto L135;
        if (r39 != 2) goto L32;
        ChatMessageReceiverModel r40 = this.this$0;
        String r41 = this.$listChangedTraceId;
        r40.getClass();
        FLogger.a.i(r40.k, "receive REFRESH_ALL, clear all messages and get message list");
        r40.o.clear();
        r40.n.clear();
        RefreshTraceSource r42 = RefreshTraceSource.REFRESH_ALL;
        if (r41.length() != 0) goto L132;
        r14 = true;
    L132:
        if (r14 == false) goto L134;
        r41 = com.larus.bmhome.social.page.datasource.event.d.a(r42);
    L134:
        ChatMessageReceiverModel.u(r40, null, "refreshAllMessage", r41, r42, 3);
        ChatMessageReceiverModel.n(r40, r40.b, r40.c, Long.MAX_VALUE, false, RangesKt.coerceAtLeast((int) (r40.d - r40.e), r40.G.a()), 0, null, null, null, false, GuidePriority.COMMERCE_CREDIT_PRIORITY);
        goto L148
    L32:
        if (r39 == 3) goto L39;
        if (r39 != 4) goto L37;
        ChatMessageReceiverModel.j(this.this$0, 1, this.$msgList, false, null, this.$listChangedTraceId, RefreshTraceSource.LIST_UPDATE, 12);
        goto L148
    L37:
        throw new IllegalArgumentException("cid:" + this.$cid + "; state:" + this.$state + "; msgList:" + CollectionsKt.joinToString$default(this.$msgList, null, null, null, 0, null, null, 63, null));
    L39:
        if (this.$msgList.size() != 1) goto L50;
        if (com.larus.bmhome.chat.bean.d.G0((Message) ListProtector.get(this.$msgList, 0)) == false) goto L50;
        long r43 = ((Message) ListProtector.get(this.$msgList, 0)).getServerIndex();
        Message r44 = (Message) CollectionsKt.firstOrNull(this.this$0.n);
        if (r44 == null) goto L45;
        long r45 = r44.getServerIndex();
    L47:
        if (r43 <= r45) goto L50;
        FLogger.a.i(this.this$0.k, "insert latest message by INSERT, add to AnswerAnchorTopStrategy, new message index = " + r43 + ", last message index = " + r45);
        IAIChatService.a.b8(((Message) ListProtector.get(this.$msgList, 0)).getMessageId());
        goto L50
    L45:
        r45 = Long.MAX_VALUE;
    L50:
        if (this.$msgList.size() != 1) goto L81;
        Message r46 = (Message) ListProtector.get(this.$msgList, 0);
        Regex r47 = com.larus.bmhome.chat.bean.d.a;
        Intrinsics.checkNotNullParameter(r46, "<this>");
        Map r48 = r46.getExt();
        if (r48 == null) goto L54;
        String r49 = (String) r48.get("business_notify_extra");
    L56:
        if (o0.d(r49) == false) goto L81;
        Message r50 = (Message) ListProtector.get(this.$msgList, 0);
        LruCache<String, wc9.e> r51 = ko8.a.a;
        Function0<wc9.e> r52 = this.this$0.f;
        if (r52 == null) goto L60;
        wc9.e r53 = (wc9.e) r52.invoke();
    L61:
        String r54 = r50.getMessageId();
        if (r54 != null) goto L64;
        String r55 = "";
    L65:
        String r56 = r50.getSenderId();
        if (r56 != null) goto L68;
        String r57 = "";
    L69:
        Function0<BotModel> r58 = this.this$0.g;
        if (r58 == null) goto L74;
        BotModel r59 = (BotModel) r58.invoke();
        if (r59 == null) goto L74;
        Integer r60 = r59.getBotType();
    L75:
        this.label = 2;
        Object r61 = IAIChatControlTraceService.a.Aa(r53, r55, r50, null, r57, r60, 0, this);
        if (r61 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L79;
        r61 = Unit.INSTANCE;
    L79:
        if (r61 != r11) goto L81;
        return r11;
    L74:
        r60 = null;
        goto L75
    L68:
        r57 = r56;
        goto L69
    L64:
        r55 = r54;
        goto L65
    L60:
        r53 = null;
        goto L61
    L54:
        r49 = null;
        goto L56
    L135:
        List<Message> r63 = this.$msgList;
        ArrayList r64 = new ArrayList();
        Iterator<T> r65 = r63.iterator();
    L137:
        if (r65.hasNext() == false) goto L146;
        Object r66 = r65.next();
        Message r67 = (Message) r66;
        IFlowMessageService r68 = (IFlowMessageService) ServiceManager.get().getService(IFlowMessageService.class);
        if (r68 != null) goto L141;
    L143:
        boolean r69 = false;
    L144:
        if (r69 == true) goto L137;
        r64.add(r66);
        goto L137
    L141:
        if (r68.a(r67.getLocalMessageId()) != true) goto L143;
        r69 = true;
        goto L144
    L146:
        Boxing.boxBoolean(this.this$0.B(r64, RefreshTraceSource.REMOVE, this.$listChangedTraceId));
        goto L148
    L16:
        if (r31 != MessageListState.UPDATE) goto L28;
    L10:
        ResultKt.throwOnFailure(r62);
        CompletableDeferred<Unit> r70 = this.this$0.s;
        this.label = 1;
        if (r70.await(this) != r11) goto L13;
        return r11;
    }
}
