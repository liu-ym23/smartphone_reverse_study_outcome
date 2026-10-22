package hha;

import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.utils.i;
import com.larus.im.bean.message.Message;
import com.larus.im.observer.MessageListState;
import com.larus.platform.IObricMessageExtService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.v2.core.AssistantAliveReason;
import com.obric.assistant.state.api.v2.core.ObricMsgInfoSaveDelegate;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricIslandPriority;
import com.obric.assistant.state.api.v2.core.bean.ObricIslandStateType;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import com.obric.assistant.state.impl.v2.core.g;
import com.obric.assistant.state.impl.v2.power.ObricPowerManager;
import com.obric.assistant.state.impl.v2.utils.e;
import com.obric.assistant.state.impl.v2.utils.f;
import com.obric.assistant.state.impl.v2.wakelock.ObricWakelockManager;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import lr8.c;
import nf9.b;
import vd9.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public final ConcurrentHashMap<String, String> a;
    public final ConcurrentHashMap<String, String> b;
    public final ConcurrentHashMap<String, ObricInteractionScene> c;
    public final ConcurrentHashMap<String, Long> d;
    public final Set<String> e;
    public final C0017a f;

    /* JADX INFO: renamed from: hha.a$a, reason: collision with other inner class name */
    public static final class C0017a implements b {
        public final /* synthetic */ a a;

        public C0017a(a r1) {
            this.a = r1;
        }

        public final void a(String r5, Message r6) {
            Intrinsics.checkNotNullParameter(r5, "cid");
            Intrinsics.checkNotNullParameter(r6, "msg");
            if (i.g(r5) == true) goto L6;
            FLogger r7 = FLogger.a;
            this.a.getClass();
            r7.d("[MessageStateHandler]", "onSendMessage, not in mainBot, return");
            return;
        L6:
            FLogger r0 = FLogger.a;
            this.a.getClass();
            r0.i("[MessageStateHandler]", "onSendMessage msg.id = " + r6.getMessageId() + ", statusLocal:" + r6.getMessageStatusLocal() + ", isNeedDeepThink: " + e.c(r6) + ", isNestedFileType(): " + c.a(r6) + ", msg.collectionId: " + com.larus.im.bean.message.a.g(r6));
            switch(r6.getMessageStatusLocal()) {
                case 11: goto L13;
                case 12: goto L10;
                case 13: goto L10;
                default: goto L30;
            };
        L30:
            return;
        L10:
            if (f.a == true) goto L27;
            ObricWakelockManager.d(ObricWakelockManager.a, ObricWakelockManager.LockReason.SEND_MSG);
            CoroutineScope r8 = ObricPowerManager.a;
            AssistantAliveReason r9 = AssistantAliveReason.SEND_MSG;
            ObricPowerManager.g(r9);
            ObricPowerManager.f(r9);
            return;
        L27:
            return;
        L13:
            if (c.a(r6) == false) goto L22;
            String r1 = com.larus.im.bean.message.a.g(r6);
            if (r1 != null) goto L17;
        L20:
            boolean r2 = true;
        L21:
            if (r2 == true) goto L22;
        L24:
            if (f.a == true) goto L29;
            ObricWakelockManager r10 = ObricWakelockManager.a;
            ObricWakelockManager.LockReason r11 = ObricWakelockManager.LockReason.SEND_MSG;
            r10.getClass();
            ObricWakelockManager.a(r11);
            CoroutineScope r12 = ObricPowerManager.a;
            AssistantAliveReason r13 = AssistantAliveReason.SEND_MSG;
            ObricPowerManager.d(r13);
            ObricPowerManager.c(r13);
            return;
        L29:
            return;
        L17:
            if (r1.length() == 0) goto L20;
            r2 = false;
        L22:
            this.a.a.put(r5, r6.getMessageId());
            ObricMsgInfoSaveDelegate.b.c(r6);
            goto L24
        }

        public final void d(String r4, Message r5) {
            Intrinsics.checkNotNullParameter(r4, "cid");
            Intrinsics.checkNotNullParameter(r5, "msg");
            FLogger r0 = FLogger.a;
            this.a.getClass();
            r0.d("[MessageStateHandler]", "onRegenMessage msg.id = " + r5.getMessageId() + ", statusLocal:" + r5.getMessageStatusLocal() + ", isNeedDeepThink: " + e.c(r5));
            this.a.a.put(r4, r5.getMessageId());
            ObricMsgInfoSaveDelegate.b.a(r5);
        }

        public final void f(String r3, Message r4) {
            Intrinsics.checkNotNullParameter(r3, "cid");
            Intrinsics.checkNotNullParameter(r4, "msg");
            FLogger r5 = FLogger.a;
            this.a.getClass();
            r5.d("[MessageStateHandler]", "onReceiveMessage, statusLocal:" + r4.getMessageStatusLocal() + ", senderId: " + r4.getSenderId() + ", contentType:" + r4.getContentType() + ", replyId: " + r4.getReplyId() + ", msgId: " + r4.getMessageId() + ", isSelf: " + d.G0(r4) + ", isSelfAndNeedDeepThink: " + e.c(r4) + ", isDeepThink: " + com.larus.im.bean.message.a.C0(r4) + ", isComplexTaskMessage: " + e.a(r4));
        }

        public final void g(String r24, Message r25) {
            if (r25.getContentType() != 800) goto L5;
            String r3 = "onOtherUpdateMessageInternal";
        L6:
            FLogger r5 = FLogger.a;
            this.a.getClass();
            StringBuilder r6 = new StringBuilder();
            r6.append(r3);
            r6.append(": statusLocal:");
            r6.append(r25.getMessageStatusLocal());
            r6.append(", contentType: ");
            r6.append(r25.getContentType());
            r6.append(", messageId: ");
            r6.append(r25.getMessageId());
            String r4 = ", replyId: ";
            r6.append(", replyId: ");
            r6.append(r25.getReplyId());
            r6.append(",  cvsId: ");
            r6.append(r25.getConversationId());
            r6.append(", isComplexTaskMessage: ");
            r6.append(e.a(r25));
            r6.append(", isThinkingMessage: ");
            r6.append(com.larus.im.bean.message.a.C0(r25));
            r6.append(", isDeepThinkingTyping: ");
            r6.append(d.f0(r25));
            r6.append(", isMultiContent: ");
            r6.append(d.x0(r25));
            r6.append(", isParentMsg: ");
            String r9 = "<this>";
            Intrinsics.checkNotNullParameter(r25, "<this>");
            boolean r11 = true;
            if (com.larus.im.bean.message.a.j0(r25) == false) goto L9;
        L12:
            boolean r10 = true;
        L13:
            r6.append(r10);
            r6.append(", isSubMessage: ");
            r6.append(com.larus.im.bean.message.a.y0(r25));
            r6.append(", isServerLoading: ");
            r6.append(com.larus.im.bean.message.a.r0(r25));
            r6.append(", isStickerType: ");
            r6.append(d.N0(r25));
            r6.append(", isMusicGenerating: ");
            r6.append(e.b(r25));
            r6.append(", isImageGenerating: ");
            Intrinsics.checkNotNullParameter(r25, "<this>");
            IObricMessageExtService.Companion r12 = IObricMessageExtService.a;
            r6.append(r12.i(r25));
            r6.append(", isInRealtimeCall: ");
            AudioServiceDelegate r13 = AudioServiceDelegate.a;
            r6.append(r13.e());
            r6.append(", isDouBaoNewsMessage: ");
            Intrinsics.checkNotNullParameter(r25, "<this>");
            if (r25.getContentType() == 100) goto L16;
        L18:
            boolean r14 = false;
        L19:
            r6.append(r14);
            r6.append(", content: ");
            r6.append(g2a.d.b(r25.getContent()));
            r5.i("[MessageStateHandler]", r6.toString());
            if (r13.e() == true) goto L22;
            boolean r7 = i.g(r24);
            int r15 = r25.getMessageStatusLocal();
            if (r15 != 12) goto L41;
        L151:
            this.a.getClass();
            r5.d("[MessageStateHandler]", "onMessageSendInterruptOrSendFailed");
            if (r7 == true) goto L154;
            return;
        L154:
            if (f.a == true) goto L163;
            ObricWakelockManager.d(ObricWakelockManager.a, ObricWakelockManager.LockReason.SEND_MSG);
            return;
        L163:
            return;
        L41:
            if (r15 == 13) goto L151;
            String r16 = ", conversationMsgObserveMap[cid]: ";
            String r8 = ", isDeepThink: ";
            switch(r15) {
                case 20: goto L77;
                case 21: goto L60;
                case 22: goto L45;
                case 23: goto L60;
                case 24: goto L77;
                default: goto L164;
            };
        L45:
            this.a.getClass();
            r5.d("[MessageStateHandler]", "onMessageReceiveFailed");
            a.a(this.a, r24, r25);
            if (r7 == true) goto L49;
            return;
        L49:
            if (Intrinsics.areEqual(r25.getReplyId(), this.a.a.get(r24)) == true) goto L51;
        L53:
            boolean r17 = false;
        L54:
            boolean r18 = Intrinsics.areEqual(r25.getReplyId(), this.a.b.get(r24));
            this.a.getClass();
            r5.i("[MessageStateHandler]", "isCurrentReplyMessage: " + r17 + ", isCurrentReplyDeepThinkMessage: " + r18 + ", isDeepThink: " + com.larus.im.bean.message.a.C0(r25) + ", isComplexTaskMessage: " + e.a(r25) + ", replyId: " + r25.getReplyId() + ", conversationMsgObserveMap[cid]: " + this.a.a.get(r24) + ", conversationDeepThinkMsgObserveMap: " + this.a.b.get(r24));
            if (r17 == false) goto L57;
            a.b(this.a, r24);
        L57:
            ObricMsgInfoSaveDelegate.b.d(r17, r25);
            if (f.a == true) goto L157;
            ObricWakelockManager.d(ObricWakelockManager.a, ObricWakelockManager.LockReason.RECEIVE_MSG);
            return;
        L157:
            return;
        L51:
            if (r25.getRegenVisible() == false) goto L53;
            r17 = true;
            goto L54
        L60:
            this.a.getClass();
            r5.d("[MessageStateHandler]", "onMessageReceiveEnd");
            a.a(this.a, r24, r25);
            if (r7 == true) goto L64;
            return;
        L64:
            if (Intrinsics.areEqual(r25.getReplyId(), this.a.a.get(r24)) == true) goto L66;
        L68:
            boolean r19 = false;
        L69:
            boolean r20 = Intrinsics.areEqual(r25.getReplyId(), this.a.b.get(r24));
            this.a.getClass();
            r5.i("[MessageStateHandler]", "isCurrentReplyMessage: " + r19 + ", isCurrentReplyDeepThinkMessage: " + r20 + ", isDeepThink: " + com.larus.im.bean.message.a.C0(r25) + ", isComplexTaskMessage: " + e.a(r25) + ", replyId: " + r25.getReplyId() + ", conversationMsgObserveMap[cid]: " + this.a.a.get(r24) + ", conversationDeepThinkMsgObserveMap: " + this.a.b.get(r24));
            if (r19 == false) goto L72;
            a.b(this.a, r24);
        L72:
            ObricMsgInfoSaveDelegate.b.d(r19, r25);
            boolean r1 = f.a;
            if (r1 == true) goto L75;
            ObricWakelockManager r2 = ObricWakelockManager.a;
            ObricWakelockManager.d(r2, ObricWakelockManager.LockReason.SEND_MSG);
            ObricWakelockManager.d(r2, ObricWakelockManager.LockReason.RECEIVE_MSG);
        L75:
            if (r1 == true) goto L159;
            CoroutineScope r21 = ObricPowerManager.a;
            AssistantAliveReason r22 = AssistantAliveReason.SEND_MSG;
            ObricPowerManager.g(r22);
            ObricPowerManager.f(r22);
            return;
        L159:
            return;
        L66:
            if (r25.getRegenVisible() == false) goto L68;
            r19 = true;
            goto L69
        L77:
            this.a.getClass();
            r5.d("[MessageStateHandler]", "onMessageReceiveBegin");
            a r110 = this.a;
            r110.getClass();
            String r111 = a.f(r24, r25);
            if (com.obric.assistant.state.impl.v2.utils.c.d(r25) == false) goto L81;
            r110.e.add(r111);
        L81:
            if (r110.e.contains(r111) == false) goto L83;
            r110.e(r24, r25);
            r110.d(r24, r25);
            r4 = ", replyId: ";
            r7 = r7;
            r9 = "<this>";
            r16 = ", conversationMsgObserveMap[cid]: ";
            r8 = ", isDeepThink: ";
        L129:
            boolean r23 = Intrinsics.areEqual(r25.getReplyId(), this.a.a.get(r24));
            this.a.getClass();
            r5.i("[MessageStateHandler]", "isCurrentReplyMessage: " + r23 + ", isComplexTaskMessage: " + e.a(r25) + r8 + com.larus.im.bean.message.a.C0(r25) + ", isDeepThinkingTyping: " + d.f0(r25) + r4 + r25.getReplyId() + r16 + this.a.a.get(r24) + ", ");
            if (r7 == true) goto L133;
            return;
        L133:
            if (f.a == true) goto L150;
            ObricWakelockManager.d(ObricWakelockManager.a, ObricWakelockManager.LockReason.SEND_MSG);
            if (i.g(r24) == false) goto L150;
            if (e.b(r25) == true) goto L150;
            String r26 = r9;
            Intrinsics.checkNotNullParameter(r25, r26);
            if (r12.i(r25) == true) goto L150;
            if (com.larus.im.bean.message.a.y0(r25) == true) goto L150;
            Intrinsics.checkNotNullParameter(r25, r26);
            if (r25.getContentType() == 800) goto L145;
        L147:
            boolean r112 = false;
        L148:
            if (r112 == true) goto L150;
            ObricWakelockManager.a(ObricWakelockManager.LockReason.RECEIVE_MSG);
            goto L150
        L145:
            if (Intrinsics.areEqual(r25.getBizContentType(), "dora_record") == false) goto L147;
            r112 = true;
        L150:
            ObricMsgInfoSaveDelegate.b.b(r25);
            return;
        L83:
            String r113 = a.f(r24, r25);
            if (r110.c.containsKey(r113) == false) goto L87;
            r7 = r7;
            r9 = "<this>";
        L117:
            if (com.larus.im.bean.message.a.C0(r25) == false) goto L129;
            if (d.f0(r25) == false) goto L129;
            if (e.a(r25) == true) goto L129;
            Long r27 = r110.d.get(r24);
            if (r27 != null) goto L126;
        L128:
            r110.e(r24, r25);
            r110.d.put(r24, Long.valueOf(r25.getLocalIndex()));
            a.c(r24, r25, ObricIslandStateType.DEEP_THINK_START, ObricInteractionScene.DEEP_THINK_SCENE);
            goto L129
        L126:
            if (r25.getLocalIndex() > r27.longValue()) goto L128;
        L87:
            if (com.larus.im.bean.message.a.C0(r25) == true) goto L89;
        L91:
            boolean r114 = false;
        L92:
            Long r28 = r110.d.get(r24);
            long r115 = r25.getLocalIndex();
            if (r28 != null) goto L96;
        L98:
            boolean r29 = false;
        L100:
            if (d.k(r25) == false) goto L104;
            Intrinsics.checkNotNullParameter(r25, "<this>");
            if (r.a(r25).isEmpty() == false) goto L104;
            boolean r30 = true;
        L105:
            if (r114 == true) goto L115;
            if (r29 == true) goto L115;
            if (e.a(r25) == true) goto L115;
            if (r30 == true) goto L115;
            ObricInteractionScene r31 = ObricInteractionScene.DEFAULT;
            if (r110.c.putIfAbsent(r113, r31) != null) goto L117;
            a.c(r24, r25, ObricIslandStateType.MSG_START, r31);
        L115:
            r5.i("[MessageStateHandler]", "filter MSG_START, cid=" + r24 + ", msgId=" + r25.getMessageId() + ", localIndex=" + r25.getLocalIndex() + ", isDeepThinkingMessage=" + r114 + ", isDeepThinkRound=" + r29 + ", isComplexTaskMessage=" + e.a(r25) + ", isEmptyBlockContentMessage=" + r30);
        L104:
            r30 = false;
            goto L105
        L96:
            if (r28.longValue() != r115) goto L98;
            r29 = true;
            goto L100
        L89:
            if (d.f0(r25) == false) goto L91;
            r114 = true;
            goto L92
        L164:
            return;
        L22:
            if (SetsKt.setOf(new Integer[]{21, 23, 22}).contains(Integer.valueOf(r25.getMessageStatusLocal())) == false) goto L36;
            a r32 = this.a;
            r32.getClass();
            String r33 = a.f(r24, r25);
            if (r32.c.containsKey(r33) == true) goto L34;
            Long r34 = r32.d.get(r24);
            long r35 = r25.getLocalIndex();
            if (r34 == null) goto L31;
            if (r34.longValue() == r35) goto L34;
        L31:
            if (r32.e.contains(r33) == true) goto L34;
            r11 = false;
        L34:
            if (r11 == false) goto L36;
            a.a(this.a, r24, r25);
        L36:
            this.a.getClass();
            r5.d("[MessageStateHandler]", "InRealtimeCall, return");
            return;
        L16:
            if (Intrinsics.areEqual(r25.getReplyId(), "0") == false) goto L18;
            r14 = true;
            goto L19
        L9:
            if (com.larus.im.bean.message.a.E0(r25) == true) goto L12;
            r10 = false;
            goto L13
        L5:
            r3 = "onUpdateMessageInternal";
            goto L6
        }

        public final void b(String r4, MessageListState r5, List<Message> r6) {
            Intrinsics.checkNotNullParameter(r4, "cid");
            Intrinsics.checkNotNullParameter(r5, "state");
            Intrinsics.checkNotNullParameter(r6, "msgList");
            FLogger r0 = FLogger.a;
            this.a.getClass();
            r0.d("[MessageStateHandler]", "onMessageListChanged, " + r4 + ", " + r5);
            Iterator<T> r7 = r6.iterator();
        L4:
            if (r7.hasNext() == false) goto L8;
            Message r8 = (Message) r7.next();
            String r9 = r8.getConversationId();
            if (r9 == null) goto L4;
            g(r9, r8);
            goto L4
        }

        public final void c(String r4, Message r5, Map<String, String> r6) {
            Intrinsics.checkNotNullParameter(r4, "cid");
            Intrinsics.checkNotNullParameter(r5, "msg");
            FLogger r7 = FLogger.a;
            this.a.getClass();
            StringBuilder r0 = new StringBuilder("onUpdateMessage, statusLocal:");
            r0.append(r5.getMessageStatusLocal());
            r0.append(", senderId: ");
            r0.append(r5.getSenderId());
            r0.append(", contentType:");
            r0.append(r5.getContentType());
            r0.append(", replyId: ");
            r0.append(r5.getReplyId());
            r0.append(", msgId: ");
            r0.append(r5.getMessageId());
            r0.append(", isDeepThink: ");
            r0.append(com.larus.im.bean.message.a.C0(r5));
            r0.append(", isComplexTaskMessage: ");
            r0.append(e.a(r5));
            r0.append(", isComplexTaskAskUserMessage: ");
            r0.append(com.obric.assistant.oauto.f.b(r5));
            r0.append(", ext: ");
            this.a.getClass();
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
            Object r2 = Result.constructor-impl(String.valueOf(r5.getExt()));     // Catch: Throwable -> L5
        L7:
            Throwable r3 = Result.exceptionOrNull-impl(r2);
            if (r3 == null) goto L11;
            r2 = "ext_to_string_failed:".concat(r3.getClass().getSimpleName());
        L11:
            r0.append((String) r2);
            r7.d("[MessageStateHandler]", r0.toString());
            g(r4, r5);
            return;
        L5:
            th = move-exception;
            Result.Companion r8 = Result.Companion;
            r2 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
        }

        public final void e(String r3, Message r4, Map<String, String> r5) {
            Intrinsics.checkNotNullParameter(r3, "cid");
            Intrinsics.checkNotNullParameter(r4, "msg");
            FLogger r6 = FLogger.a;
            this.a.getClass();
            r6.d("[MessageStateHandler]", "onReceiveMessage, statusLocal:" + r4.getMessageStatusLocal() + ", senderId: " + r4.getSenderId() + ", contentType:" + r4.getContentType() + ", replyId: " + r4.getReplyId() + ", msgId: " + r4.getMessageId() + ", isDeepThink: " + com.larus.im.bean.message.a.C0(r4) + ", isComplexTaskMessage: " + e.a(r4));
            g(r3, r4);
        }

        public final void onMessageListReplaced(String r2, List<Message> r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "oldMsgList");
            Intrinsics.checkNotNullParameter(r4, "newMsgList");
            FLogger r5 = FLogger.a;
            this.a.getClass();
            r5.d("[MessageStateHandler]", "onMessageListReplaced, " + r2);
        }
    }

    public a() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.e = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f = new C0017a(this);
    }

    public static final void b(a r3, String r4) {
        r3.getClass();
        FLogger.a.i("[MessageStateHandler]", "resetConversationMsgObserveMapByCid, cid: " + r4 + ", previous: " + r3.a.get(r4) + ", previousDeepThinking: " + r3.b.get(r4));
        r3.a.put(r4, "-1");
    }

    public static String f(String r1, Message r2) {
        return r1 + ':' + r2.getLocalIndex();
    }

    public final void d(String r8, Message r9) {
        Long r0 = this.d.get(r8);
        if (r0 == null) goto L5;
        long r1 = r0.longValue();
    L7:
        if (r1 > 0) goto L9;
    L11:
        boolean r2 = false;
    L12:
        FLogger.a.i("[MessageStateHandler]", "emitDeepThinkEnd, isStarted=" + r2 + ", msg.localIndex=" + r9.getLocalIndex() + ", currentDeepThinkingMsgIndex=" + r1);
        if (r2 == true) goto L15;
        return;
    L15:
        c(r8, r9, ObricIslandStateType.DEEP_THINK_END, ObricInteractionScene.DEEP_THINK_SCENE);
        this.d.put(r8, Long.valueOf(r9.getLocalIndex() + 1));
        return;
    L9:
        if (r1 != r9.getLocalIndex()) goto L11;
        r2 = true;
        goto L12
    L5:
        r1 = -1;
        goto L7
    }

    public final void e(String r3, Message r4) {
        ObricInteractionScene r0 = this.c.remove(f(r3, r4));
        if (r0 != null) goto L5;
        return;
    L5:
        c(r3, r4, ObricIslandStateType.MSG_END, r0);
    }

    public static final void a(a r2, String r3, Message r4) {
        r2.e(r3, r4);
        r2.d(r3, r4);
        r2.e.remove(f(r3, r4));
        FLogger.a.i("[MessageStateHandler]", "resetDeepThinkingMsgObserveMapByCid, cid: " + r3 + ", previousDeepThinking: " + r2.b.get(r3));
        r2.b.put(r3, "-1");
    }

    public static void c(String r11, Message r12, ObricIslandStateType r13, ObricInteractionScene r14) {
        a r0 = g.a;
        g.a(new ObricState(r13, r11, r14, ObricIslandPriority.LOW, r12.getMessageId(), null, null, 96, null));
    }
}
