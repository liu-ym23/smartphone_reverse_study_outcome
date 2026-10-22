package com.larus.bmhome.chat.component.bottom;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.list.cell.music.MusicCell;
import com.larus.bmhome.chat.list.cell.music.MusicCell$a;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.ChatSender;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.model.repo.u1$a;
import com.larus.bmhome.chat.model.repo.x1;
import com.larus.bmhome.chat.model.strategy.ChatSendUtils;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.TextContent;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.platform.api.m3;
import com.larus.platform.service.z2;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lr8.c;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 O2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001OB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u00ad\u0001\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000e2 \b\u0002\u0010\u001a\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0004\u0012\u00020\f\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020\u0014¢\u0006\u0002\u0010#JK\u0010$\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\u000e2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\b\u0010+\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010,\u001a\u00020\u00142\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0002\u0010-J:\u0010.\u001a\u00020\f2\b\u0010/\u001a\u0004\u0018\u00010&2\u0006\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0086@¢\u0006\u0002\u00103J\u0016\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u00106J\u007f\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\u001c2\u0006\u00109\u001a\u00020\u000e2\u0014\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00122\b\b\u0002\u0010;\u001a\u00020\u00142\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2\b\b\u0002\u0010@\u001a\u00020\u00142\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0002\u0010BJ*\u0010C\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ \u0010D\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\u000e2\b\b\u0002\u0010F\u001a\u00020GJ\u0018\u0010H\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010E\u001a\u00020GJ\b\u0010I\u001a\u00020\fH\u0002J:\u0010J\u001a\u00020\f2\b\u0010/\u001a\u0004\u0018\u00010&2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u001c0)2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J4\u0010L\u001a\u00020\f2\b\u0010/\u001a\u0004\u0018\u00010&2\u0006\u00108\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\"\u0010M\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010N\u001a\u00020\u000e2\b\b\u0002\u0010E\u001a\u00020GH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006P"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/ChatMessageViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/bmhome/chat/component/bottom/ChatMessageComponentState;", "<init>", "()V", "repo", "Lcom/larus/bmhome/chat/model/repo/ChatRepo;", "reader", "Lcom/larus/bmhome/chat/model/repo/ITtsReader;", "getReader", "()Lcom/larus/bmhome/chat/model/repo/ITtsReader;", "sendText", "", "conversationId", "", "content", "scene", "extra", "", "isAutoInterrupt", "", "status", "Lcom/larus/im/bean/message/MessageStatus;", "referenceInfo", "Lcom/larus/im/bean/message/ReferenceInfo;", "creationSendTraceId", "callback", "Lkotlin/Function2;", "Lcom/larus/im/bean/message/Message;", "Lcom/larus/im/callback/IIMError;", "chatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "sendClickTimestamp", "", "restoreInputOnCancel", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ZLcom/larus/im/bean/message/MessageStatus;Lcom/larus/im/bean/message/ReferenceInfo;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lcom/larus/bmhome/chat/bean/ChatPageContext;Ljava/lang/Long;Z)V", "sendFileAndTxt", "conversationLiveData", "Lcom/larus/im/bean/conversation/Conversation;", "txtScene", "strategyList", "", "Lcom/larus/bmhome/chat/bean/ISendMessageStrategy;", "fromScene", "sameScene", "(Lcom/larus/im/bean/conversation/Conversation;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/lang/Long;)V", "resendMessage", "conversation", "replyMessage", "traceScene", "resendScene", "(Lcom/larus/im/bean/conversation/Conversation;Lcom/larus/im/bean/message/Message;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/bean/ChatPageContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOnModifySendBeforeAck", "msg", "(Lcom/larus/im/bean/message/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "replaceMsgOnModifySendAfterAck", "message", "replaceText", "extras", "needReplaceTxtAndFile", "newAttachmentInfo", "Lcom/larus/bmhome/view/AttachmentInfo;", "newNestedFileContent", "Lcom/larus/im/bean/message/NestedFileContent;", "location", "attachmentEntityLocalMsgId", "(Lcom/larus/im/bean/message/Message;Ljava/lang/String;Ljava/util/Map;ZLcom/larus/bmhome/view/AttachmentInfo;Lcom/larus/im/bean/message/NestedFileContent;ZLjava/lang/String;Lcom/larus/bmhome/chat/bean/ChatPageContext;Ljava/lang/Long;)V", "sendSearch", "breakAllMsg", "breakReason", "breakReasonCode", "Lcom/larus/im/internal/jni/bean/OmniBreakReason;", "breakAnswer", "tryBreakMusic", "resendFileAndTxt", "messageList", "resendFileOrImg", "innerInterrupt", "reason", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatMessageViewModel extends ComponentViewModel<ChatMessageComponentState> {
    public static final a Companion = null;
    private static final String TAG = "ChatMessageViewModel";
    private final ChatRepo repo;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.ChatMessageViewModel$resendMessage$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.ChatMessageViewModel", f = "ChatMessageViewModel.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {144, 146}, m = "resendMessage", n = {"conversation", "replyMessage", "traceScene", "resendScene", "chatPageContext", "conversation", "replyMessage", "traceScene", "resendScene", "chatPageContext"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ChatMessageViewModel this$0;

        public AnonymousClass1(ChatMessageViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r8) {
            this.result = r8;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.resendMessage(null, null, null, null, null, this);
        }
    }

    static {
        Companion = new a();
    }

    private final void tryBreakMusic() {
        int r0 = MusicCell.g;
        MusicCell$a.a();
    }

    public final x1 getReader() {
        return this.repo.d.d;
    }

    public ChatMessageViewModel() {
        RepoDispatcher.a.getClass();
        this.repo = RepoDispatcher.d;
    }

    public final void breakAnswer(String r4, OmniBreakReason r5) {
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        Intrinsics.checkNotNullParameter(r5, "breakReason");
        FLogger.a.i(TAG, "[breakAnswer] conversationId:" + r4);
        this.repo.e.n1(r4, r5);
    }

    public final Object deleteOnModifySendBeforeAck(Message r4, Continuation<? super Unit> r5) {
        FLogger.a.i(TAG, "[deleteOnModifySendBeforeAck] msg:" + r4.getLocalMessageId());
        Object r6 = this.repo.e.n(r4, r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    private final void innerInterrupt(String r4, String r5, OmniBreakReason r6) {
        FLogger.a.i(TAG, "[innerInterrupt] reason:" + r5);
        int r0 = MusicCell.g;
        MusicCell$a.a();
        breakAnswer(r4, r6);
        this.repo.d.d.i6(r5, false);
    }

    public final void breakAllMsg(String r4, String r5, OmniBreakReason r6) {
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        Intrinsics.checkNotNullParameter(r5, "breakReason");
        Intrinsics.checkNotNullParameter(r6, "breakReasonCode");
        FLogger.a.i(TAG, "[breakAllMsg] breakReason:" + r5);
        tryBreakMusic();
        breakAnswer(r4, r6);
        getReader().i6("breakAll_" + r5, false);
    }

    public final void sendSearch(String r16, String r17, String r18, ChatPageContext r19) {
        Intrinsics.checkNotNullParameter(r17, "content");
        Intrinsics.checkNotNullParameter(r18, "scene");
        FLogger.a.i(TAG, "[sendSearch] scene:" + r18);
        ChatSendUtils r0 = ChatSendUtils.a;
        Pair[] r1 = {TuplesKt.to("search_view", "true")};
        r0.getClass();
        sendText$default(this, r16, r17, r18, ChatSendUtils.p(r1), false, null, null, null, null, r19, null, false, 3568, null);
    }

    public static /* synthetic */ void breakAnswer$default(ChatMessageViewModel r0, String r1, OmniBreakReason r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = OmniBreakReason.OmniBreakReason_OTHER;
    L5:
        r0.breakAnswer(r1, r2);
    }

    private final void resendFileAndTxt(e r11, List<Message> r12, String r13, String r14, ChatPageContext r15) {
        if (r11 == null) goto L10;
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[resendFileAndTxt] scene:");
        r1.append(r13);
        r1.append(", messageList:");
        List<Message> r2 = r12;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L5:
        if (r4.hasNext() == false) goto L7;
        r3.add(((Message) r4.next()).getLocalMessageId());
        goto L5
    L7:
        r1.append(r3);
        r0.i(TAG, r1.toString());
        String r5 = r11.a;
        innerInterrupt(r5, "resend_file_and_txt", OmniBreakReason.OmniBreakReason_REGENERATE_OR_SWITCH_MODE);
        this.repo.e.H(r11, r5, r12, r13, r14, r15);
        return;
    }

    private final void resendFileOrImg(e r8, Message r9, String r10, String r11, ChatPageContext r12) {
        if (r8 == null) goto L5;
        FLogger.a.i(TAG, "[resendFileOrImg] scene:" + r10 + ", message:" + r9.getLocalMessageId());
        innerInterrupt(r8.a, "resend_file_or_img", OmniBreakReason.OmniBreakReason_REGENERATE_OR_SWITCH_MODE);
        this.repo.e.I(r8, r9, r10, r11, r12);
        return;
    }

    public static /* synthetic */ void breakAllMsg$default(ChatMessageViewModel r0, String r1, String r2, OmniBreakReason r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = OmniBreakReason.OmniBreakReason_OTHER;
    L5:
        r0.breakAllMsg(r1, r2, r3);
    }

    public static /* synthetic */ void innerInterrupt$default(ChatMessageViewModel r0, String r1, String r2, OmniBreakReason r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = OmniBreakReason.OmniBreakReason_OTHER;
    L5:
        r0.innerInterrupt(r1, r2, r3);
    }

    public final Object resendMessage(e r21, Message r22, String r23, String r24, ChatPageContext r25, Continuation<? super Unit> r26) {
        Message r0 = r22;
        String r1 = r24;
        if ((r26 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r3 = (AnonymousClass1) r26;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        boolean r7 = true;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        ChatPageContext r8 = (ChatPageContext) r3.L$4;
        r1 = (String) r3.L$3;
        String r9 = (String) r3.L$2;
        Message r10 = (Message) r3.L$1;
        e r11 = (e) r3.L$0;
        ResultKt.throwOnFailure(r2);
        ChatPageContext r12 = r8;
        e r13 = r11;
        r0 = r10;
    L26:
        Message r14 = (Message) r2;
        if (r14 != null) goto L29;
    L31:
        boolean r15 = false;
    L32:
        if (r15 == false) goto L50;
        TextContent r16 = (TextContent) d.t(r14);
        String r17 = "";
        if (r16 == null) goto L39;
        String r18 = r16.text;
        if (r18 == null) goto L39;
        String r19 = r18;
    L41:
        if (com.larus.utils.o0.d(r19) == false) goto L75;
        if (r13 == null) goto L44;
        String r20 = r13.a;
    L45:
        String r27 = r20;
        ChatSendUtils r28 = ChatSendUtils.a;
        Pair[] r29 = new Pair[2];
        r29[0] = TuplesKt.to("regen_resend", r1);
        String r30 = r14.getMessageId();
        if (r30 == null) goto L49;
        r17 = r30;
    L49:
        r29[1] = TuplesKt.to("regen_resend_previous_id", r17);
        r28.getClass();
        sendText$default(this, r27, r19, r9, ChatSendUtils.p(r29), false, null, null, null, null, r12, null, false, 3568, null);
        goto L75
    L44:
        r20 = null;
    L75:
        return Unit.INSTANCE;
    L39:
        r19 = "";
        goto L41
    L50:
        if (r14 != null) goto L52;
    L54:
        boolean r31 = false;
    L55:
        if (r31 == true) goto L72;
        if (r14 != null) goto L58;
    L60:
        boolean r32 = false;
    L61:
        if (r32 == true) goto L72;
        if (r14 != null) goto L64;
    L66:
        r7 = false;
    L67:
        if (r7 == true) goto L72;
        if (c.a(r0) == false) goto L75;
        resendFileOrImg(r13, r0, r1, r9, r12);
        goto L75
    L64:
        if (c.a(r14) != true) goto L66;
    L58:
        if (r14.getContentType() != 7) goto L60;
        r32 = true;
    L72:
        resendFileOrImg(r13, r14, r1, r9, r12);
        goto L75
    L52:
        if (r14.getContentType() != 6) goto L54;
        r31 = true;
        goto L55
    L29:
        if (r14.getContentType() != 1) goto L31;
        r15 = true;
        goto L32
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ChatPageContext r33 = (ChatPageContext) r3.L$4;
        r1 = (String) r3.L$3;
        String r34 = (String) r3.L$2;
        Message r35 = (Message) r3.L$1;
        r13 = (e) r3.L$0;
        ResultKt.throwOnFailure(r2);
        ChatPageContext r36 = r33;
        r0 = r35;
        Object r37 = r2;
    L20:
        List<Message> r38 = (List) r37;
        if (r38.isEmpty() == false) goto L73;
        ChatRepo r39 = this.repo;
        r3.L$0 = r13;
        r3.L$1 = r0;
        r3.L$2 = r34;
        r3.L$3 = r1;
        r3.L$4 = r36;
        r3.label = 2;
        Object r40 = r39.y1(r0, r3);
        if (r40 != r5) goto L25;
        return r5;
    L25:
        r12 = r36;
        r2 = r40;
        r9 = r34;
        goto L26
    L73:
        resendFileAndTxt(r13, r38, r1, r34, r36);
        goto L75
    L16:
        ResultKt.throwOnFailure(r2);
        FLogger.a.i(TAG, "[resendMessage] replyMessage:" + r22.getLocalMessageId() + ", resendScene:" + r1);
        ChatRepo r41 = this.repo;
        r3.L$0 = r21;
        r3.L$1 = r0;
        r3.L$2 = r23;
        r3.L$3 = r1;
        r3.L$4 = r25;
        r3.label = 1;
        Object r42 = r41.s1(r0, r3);
        if (r42 != r5) goto L19;
        return r5;
    L19:
        r37 = r42;
        r36 = r25;
        r13 = r21;
        r34 = r23;
    L7:
        r3 = new AnonymousClass1(this, r26);
        goto L8
    }

    public final void sendFileAndTxt(e r13, String r14, List<? extends ic8.w> r15, String r16, boolean r17, Long r18) {
        Intrinsics.checkNotNullParameter(r14, "txtScene");
        Intrinsics.checkNotNullParameter(r15, "strategyList");
        if (r13 != null) goto L5;
        return;
    L5:
        FLogger.a.i(TAG, "[sendFileAndTxt] txtScene:" + r14 + ", fromScene:" + r16);
        breakAllMsg(r13.a, "send_file_and_txt", OmniBreakReason.OmniBreakReason_SEND_NEW_MSG);
        u1$a.e(this.repo.e, r13, r13.a, r14, r15, r16, null, r17, com.larus.platform.exp.s.c ^ true, r18, 32);
    }

    public static /* synthetic */ void sendFileAndTxt$default(ChatMessageViewModel r7, e r8, String r9, List r10, String r11, boolean r12, Long r13, int r14, Object r15) {
        if ((r14 & 16) == 0) goto L5;
        boolean r5 = false;
    L7:
        if ((r14 & 32) == 0) goto L9;
        r13 = null;
    L9:
        r7.sendFileAndTxt(r8, r9, r10, r11, r5, r13);
        return;
    L5:
        r5 = r12;
        goto L7
    }

    public final void replaceMsgOnModifySendAfterAck(Message r12, String r13, Map<String, String> r14, boolean r15, AttachmentInfo r16, NestedFileContent r17, boolean r18, String r19, ChatPageContext r20, Long r21) {
        Intrinsics.checkNotNullParameter(r12, "message");
        Intrinsics.checkNotNullParameter(r13, "replaceText");
        FLogger.a.i(TAG, "[replaceMsgOnModifySendAfterAck] message:" + r12.getLocalMessageId() + ", needReplaceTxtAndFile:" + r15);
        if (r18 == true) goto L5;
        if (r14 != null) goto L13;
        ChatSendUtils.a.getClass();
        Map<String, String> r0 = ChatSendUtils.p(new Pair[0]);
    L12:
        Map<String, String> r4 = r0;
    L14:
        this.repo.e.h(r12, r13, r4, r15, r16, r17, r19, r20, r21);
        return;
    L13:
        r4 = r14;
        goto L14
    L5:
        if (r14 == null) goto L9;
        Map<String, String> r6 = MapsKt.toMutableMap(r14);
        if (r6 == null) goto L9;
        r6.put("need_location", "1");
        r4 = r6;
    L9:
        ChatSendUtils r7 = ChatSendUtils.a;
        Pair[] r8 = {TuplesKt.to("need_location", "1")};
        r7.getClass();
        r0 = ChatSendUtils.p(r8);
        goto L12
    }

    public final void sendText(String r18, String r19, String r20, Map<String, String> r21, boolean r22, MessageStatus r23, ReferenceInfo r24, String r25, Function2<? super Message, ? super IIMError, Unit> r26, ChatPageContext r27, Long r28, boolean r29) {
        Intrinsics.checkNotNullParameter(r19, "content");
        Intrinsics.checkNotNullParameter(r20, "scene");
        z2 r2 = z2.a;
        m3 r3 = z2.d4();
        if (r3 == null) goto L5;
        boolean r4 = r3.messageVoicePlay();
    L6:
        if (r4 == true) goto L11;
        t19.s.j(t19.s.a, AppHost.a.getApplication(), "WIP", null, false, 28);
        if (r26 == null) goto L30;
        r26.invoke(null, null);
        return;
    L30:
        return;
    L11:
        FLogger.a.i(TAG, "[sendText] scene:" + r20 + ", isAutoInterrupt:" + r22);
        String r8 = UUID.randomUUID().toString();
        com.larus.bmhome.chat.trace.z.a.d(r8);
        String r7 = "";
        if (r22 == false) goto L17;
        if (r18 != null) goto L15;
        String r1 = "";
    L16:
        breakAnswer(r1, OmniBreakReason.OmniBreakReason_SEND_NEW_MSG);
        boolean r5 = true;
    L18:
        ChatSender r9 = this.repo.e;
        String r6 = StringsKt.trim(r19).toString();
        if (r18 == null) goto L22;
        r7 = r18;
    L22:
        if (r5 == true) goto L24;
    L27:
        boolean r10 = true;
    L28:
        u1$a.f(r9, r6, r7, r20, r21, r26, r23, r8, r10, r24, "ChatMessageViewModel#sendText", r25, r27, r28, r29, 8);
        return;
    L24:
        if (com.larus.platform.exp.s.c == false) goto L27;
        r10 = false;
        goto L28
    L15:
        r1 = r18;
        goto L16
    L17:
        r5 = false;
        goto L18
    L5:
        r4 = true;
        goto L6
    }

    public static /* synthetic */ void replaceMsgOnModifySendAfterAck$default(ChatMessageViewModel r14, Message r15, String r16, Map r17, boolean r18, AttachmentInfo r19, NestedFileContent r20, boolean r21, String r22, ChatPageContext r23, Long r24, int r25, Object r26) {
        if ((r25 & 8) == 0) goto L5;
        boolean r7 = false;
    L7:
        if ((r25 & 16) == 0) goto L9;
        AttachmentInfo r8 = null;
    L11:
        if ((r25 & 32) == 0) goto L13;
        NestedFileContent r9 = null;
    L15:
        if ((r25 & 64) == 0) goto L17;
        boolean r10 = false;
    L19:
        if ((r25 & 128) == 0) goto L21;
        String r11 = null;
    L23:
        if ((r25 & 512) == 0) goto L25;
        Long r13 = null;
    L26:
        r14.replaceMsgOnModifySendAfterAck(r15, r16, r17, r7, r8, r9, r10, r11, r23, r13);
        return;
    L25:
        r13 = r24;
        goto L26
    L21:
        r11 = r22;
        goto L23
    L17:
        r10 = r21;
        goto L19
    L13:
        r9 = r20;
        goto L15
    L9:
        r8 = r19;
        goto L11
    L5:
        r7 = r18;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void sendText$default(ChatMessageViewModel r16, String r17, String r18, String r19, Map r20, boolean r21, MessageStatus r22, ReferenceInfo r23, String r24, Function2 r25, ChatPageContext r26, Long r27, boolean r28, int r29, Object r30) {
        if ((r29 & 8) == 0) goto L5;
        Map r7 = null;
    L7:
        if ((r29 & 16) == 0) goto L9;
        boolean r8 = true;
    L11:
        if ((r29 & 32) == 0) goto L13;
        MessageStatus r9 = null;
    L15:
        if ((r29 & 64) == 0) goto L17;
        ReferenceInfo r10 = null;
    L19:
        if ((r29 & 128) == 0) goto L21;
        String r11 = null;
    L23:
        if ((r29 & 256) == 0) goto L25;
        Function2 r12 = null;
    L27:
        if ((r29 & 1024) == 0) goto L29;
        Long r14 = null;
    L31:
        if ((r29 & 2048) == 0) goto L33;
        boolean r15 = true;
    L34:
        r16.sendText(r17, r18, r19, r7, r8, r9, r10, r11, r12, r26, r14, r15);
        return;
    L33:
        r15 = r28;
        goto L34
    L29:
        r14 = r27;
        goto L31
    L25:
        r12 = r25;
        goto L27
    L21:
        r11 = r24;
        goto L23
    L17:
        r10 = r23;
        goto L19
    L13:
        r9 = r22;
        goto L15
    L9:
        r8 = r21;
        goto L11
    L5:
        r7 = r20;
        goto L7
    }
}
