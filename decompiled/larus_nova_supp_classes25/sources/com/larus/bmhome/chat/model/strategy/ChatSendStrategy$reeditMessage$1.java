package com.larus.bmhome.chat.model.strategy;

import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.api.AppletPayloadProviderDelegate;
import com.larus.bmhome.chat.api.IMessageExtService;
import com.larus.bmhome.chat.auth.PluginManagerDelegate;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.chat.trace.appreciable.f;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.utils.v3;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.home.impl.sdk.e2;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.ClientControllerParam;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageRequestType;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.spi.chat.IObricChatSPIService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.ChatSendStrategy$reeditMessage$1", f = "ChatSendStrategy.kt", i = {1, 1, 2}, l = {623, 634, 646}, m = "invokeSuspend", n = {"ext", "collectionId", "ext"}, s = {"L$0", "L$1", "L$0"})
public final class ChatSendStrategy$reeditMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChatPageContext $chatPageContext;
    final /* synthetic */ String $content;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ Map<String, String> $extras;
    final /* synthetic */ Message $message;
    final /* synthetic */ boolean $needReplaceTxtAndFile;
    final /* synthetic */ AttachmentInfo $newAttachmentInfo;
    final /* synthetic */ String $scene;
    final /* synthetic */ Long $sendClickTimestamp;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ChatSendStrategy this$0;

    public static final class a implements IIMCallback<List<? extends Message>> {
        public final /* synthetic */ String a;
        public final /* synthetic */ yc9.f0 b;
        public final /* synthetic */ wc9.e c;
        public final /* synthetic */ BotModel d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ boolean g;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r24) {
            Intrinsics.checkNotNullParameter(r24, "error");
            Intrinsics.checkNotNullParameter(r24, "error");
            f.f(f.a, this.a, null, this.b.e, r24, null, 16);
            ChatControlTrace r8 = ChatControlTrace.b;
            yc9.f0 r1 = this.b;
            String r2 = r1.i;
            if (r2 != null) goto L5;
            String r9 = "";
        L6:
            Message r10 = com.larus.im.internal.core.message.converter.c.a(r1);
            Integer r3 = this.c.v;
            if (r3 == null) goto L9;
            int r13 = r3.intValue();
        L10:
            BotModel r4 = this.d;
            if (r4 == null) goto L15;
            Integer r5 = r4.getBotType();
            if (r5 == null) goto L15;
            int r14 = r5.intValue();
        L16:
            boolean r15 = this.e;
            boolean r6 = this.f;
            boolean r7 = this.g;
            BotModel r11 = this.d;
            if (r11 == null) goto L22;
            String r12 = r11.getBotId();
            if (r12 == null) goto L22;
            String r18 = r12;
        L23:
            ChatControlTrace.W(r8, r9, r10, null, "im_error", r13, r14, r15, r6, r7, r18, false, null, null, 7168);
            return;
        L22:
            r18 = "";
        L15:
            r14 = 1;
            goto L16
        L9:
            r13 = 0;
            goto L10
        L5:
            r9 = r2;
            goto L6
        }

        public final void onSuccess(Object r19) {
            List r1 = (List) r19;
            Intrinsics.checkNotNullParameter(r1, "result");
            Iterator r2 = r1.iterator();
        L4:
            if (r2.hasNext() == false) goto L31;
            Message r5 = (Message) r2.next();
            com.larus.bmhome.chat.trace.appreciable.y.c(r5);
            f r6 = f.a;
            String r7 = this.a;
            String r3 = r5.getMessageId();
            if (r3 != null) goto L8;
            String r8 = "";
        L9:
            f.f(r6, r7, r8, r5.getContentType(), null, null, 24);
            ChatControlTrace r4 = ChatControlTrace.b;
            String r9 = this.b.i;
            if (r9 != null) goto L12;
            r9 = "";
        L12:
            String r10 = r5.getMessageId();
            if (r10 != null) goto L15;
            r10 = "";
        L15:
            Integer r11 = this.c.v;
            if (r11 == null) goto L18;
            int r12 = r11.intValue();
        L19:
            BotModel r13 = this.d;
            if (r13 == null) goto L24;
            Integer r14 = r13.getBotType();
            if (r14 == null) goto L24;
            int r15 = r14.intValue();
        L25:
            boolean r16 = this.e;
            boolean r17 = this.f;
            boolean r18 = this.g;
            BotModel r110 = this.d;
            if (r110 == null) goto L29;
            String r111 = r110.getBotId();
            if (r111 == null) goto L29;
        L30:
            ChatControlTrace.W(r4, r9, r5, r10, "", r12, r15, r16, r17, r18, r111, false, null, null, 7168);
        L29:
            r111 = "";
        L24:
            r15 = 1;
            goto L25
        L18:
            r12 = 0;
            goto L19
        L8:
            r8 = r3;
            goto L9
        }

        public a(String r1, yc9.f0 r2, wc9.e r3, BotModel r4, boolean r5, boolean r6, boolean r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }
    }

    public ChatSendStrategy$reeditMessage$1(wc9.e r1, Message r2, String r3, ChatSendStrategy r4, Map<String, String> r5, AttachmentInfo r6, String r7, Long r8, boolean r9, ChatPageContext r10, Continuation<? super ChatSendStrategy$reeditMessage$1> r11) {
        this.$conversation = r1;
        this.$message = r2;
        this.$scene = r3;
        this.this$0 = r4;
        this.$extras = r5;
        this.$newAttachmentInfo = r6;
        this.$content = r7;
        this.$sendClickTimestamp = r8;
        this.$needReplaceTxtAndFile = r9;
        this.$chatPageContext = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        return new ChatSendStrategy$reeditMessage$1(this.$conversation, this.$message, this.$scene, this.this$0, this.$extras, this.$newAttachmentInfo, this.$content, this.$sendClickTimestamp, this.$needReplaceTxtAndFile, this.$chatPageContext, r14);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r62) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        String r11 = "";
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        if (r0 != 3) goto L9;
        Map r1 = (Map) this.L$0;
        ResultKt.throwOnFailure(r62);
        Object r2 = r62;
    L60:
        BotModel r3 = (BotModel) r2;
        Message r15 = this.$message;
        String r4 = this.$content;
        Map r5 = r15.getBusinessExt();
        if (r5 != null) goto L63;
        r5 = new LinkedHashMap();
    L63:
        Message r6 = Message.copy$default(r15, null, null, null, 0, 0, null, 0, false, null, r4, null, null, null, r1, null, null, 0, 0, false, null, null, null, com.larus.utils.h.c(r5, new Pair[]{TuplesKt.to("send_loading", "1")}), null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -4203009, 31, null);
        ChatSendUtils.a.getClass();
        yc9.f0 r8 = com.larus.bmhome.chat.bean.d.g1(r6, ChatSendUtils.k(r3));
        if (r3 == null) goto L68;
        BotCreatorInfo r9 = r3.getBotCreatorInfo();
        if (r9 == null) goto L68;
        String r10 = r9.getId();
    L69:
        boolean r12 = Intrinsics.areEqual(r10, AccountService.a.getUserId());
        if (r3 == null) goto L72;
        String r13 = r3.getBgImgUrl();
    L73:
        if (r13 != null) goto L75;
    L78:
        boolean r14 = true;
    L79:
        if (r14 == false) goto L81;
    L83:
        boolean r16 = false;
    L84:
        if (r3 == null) goto L86;
        String r17 = r3.getBgVideoModel();
    L87:
        if (r17 != null) goto L89;
    L92:
        boolean r18 = true;
    L93:
        if (r18 == false) goto L95;
    L97:
        boolean r19 = false;
    L98:
        ChatControlTrace r110 = ChatControlTrace.b;
        String r20 = r8.i;
        if (r20 != null) goto L101;
        r20 = "";
    L101:
        r110.getClass();
        ChatControlTrace.X(r20);
        String r21 = r8.i;
        if (r21 != null) goto L104;
        r21 = "";
    L104:
        f.l(f.a, r21, r8.a, "edit", 0, null, null, null, this.$sendClickTimestamp, 120);
        Message r111 = com.larus.im.internal.core.message.converter.c.a(r8);
        Integer r22 = this.$conversation.v;
        if (r22 == null) goto L107;
        int r112 = r22.intValue();
    L108:
        if (r3 == null) goto L112;
        Integer r23 = r3.getBotType();
        if (r23 == null) goto L112;
        int r113 = r23.intValue();
    L113:
        if (r3 == null) goto L115;
        String r24 = r3.getBotId();
    L116:
        ChatControlTrace.U(r110, r111, r112, r113, r12, r16, r19, r24, null, 384);
        if (r3 == null) goto L124;
        Integer r25 = r3.getBotType();
        if (r25 == null) goto L124;
        if (r25.intValue() != 1) goto L124;
        boolean r26 = true;
    L125:
        if (r26 == false) goto L129;
        IFlowSdkDepend r27 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r27 == null) goto L129;
        r27.r0();
        e2 r28 = e2.a;
        Unit r29 = Unit.INSTANCE;
    L129:
        AppletPayloadProviderDelegate r30 = AppletPayloadProviderDelegate.a;
        String r114 = r8.a;
        if (r3 == null) goto L132;
        String r115 = r3.getBotId();
    L133:
        String r31 = r8.i;
        if (r31 != null) goto L136;
        r31 = "";
    L136:
        r8.A = r30.b(r114, r115, r31);
        Unit r32 = Unit.INSTANCE;
        ConcurrentHashMap r33 = v3.a;
        v3.f(this.$conversation, null, null);
        com.larus.bmhome.instruction.c r34 = com.larus.bmhome.instruction.c.a;
        if (r3 == null) goto L139;
        String r35 = r3.getBotId();
    L140:
        if (r35 != null) goto L142;
        r35 = "";
    L142:
        ReplyOption r36 = r34.a(r35, ActiveSwitchType.DEEPTHINK.getValue());
        if (r3 == null) goto L148;
        String r37 = r3.getBotId();
        if (r37 == null) goto L148;
        String r38 = r37;
    L149:
        LinkedHashMap r39 = new LinkedHashMap();
        wc9.e r116 = this.$conversation;
        Map r117 = r8.r;
        if (r117 == null) goto L152;
        r39.putAll(r117);
    L152:
        PluginManagerDelegate r118 = PluginManagerDelegate.a;
        Map r119 = PluginManagerDelegate.p(r8.a);
        if (r119 == null) goto L155;
        r39.putAll(r119);
    L155:
        r39.putAll(com.larus.bmhome.chat.model.a0.a());
        Map r120 = r8.r;
        if (r120 != null) goto L158;
    L160:
        Iterator r121 = ServiceManager.get().getServices(IMessageExtService.class, true).iterator();
    L162:
        if (r121.hasNext() == false) goto L164;
        ((IMessageExtService) r121.next()).a(r39, r116, new IMessageExtService.a(r8.f, 2));
        r121 = r121;
        r11 = r11;
        goto L162
    L164:
        String r310 = r11;
        LinkedHashMap r122 = new LinkedHashMap();
        r122.putAll(r8.w);
        ConcurrentHashMap r123 = v3.a;
        r122.putAll(v3.b());
        yc9.f0 r40 = yc9.f0.a(r8, null, null, null, 0, null, null, null, 0, r39, this.$message.getBizContentType(), null, null, r122, null, r38, 515506175);
        f r124 = f.a;
        int r125 = r8.e;
        String r126 = r8.f;
        ModelItemIdentity r41 = r36.getModel();
        r124.getClass();
        f.h(r21, r125, r126, "replaceTextOnModify", r41);
        f.j(r21, r8.e);
        AttachmentInfo r42 = this.$newAttachmentInfo;
        if (r42 == null) goto L188;
        ChatPageContext r127 = this.$chatPageContext;
        String r128 = r42.getFilePath();
        String r129 = r42.getTosKey();
        Integer r130 = r42.getHeight();
        if (r130 == null) goto L169;
        int r131 = r130.intValue();
    L170:
        Integer r132 = Boxing.boxInt(r131);
        Integer r43 = r42.getWidth();
        if (r43 == null) goto L173;
        int r44 = r43.intValue();
    L174:
        ai8.e r133 = new ai8.e(r128, r129, r132, Boxing.boxInt(r44), null, null, null, null, null, null, false, r127, null, null, 28656);
        String r45 = r40.a;
        String r311 = AccountService.a.getUserId();
        if (r3 == null) goto L180;
        String r134 = r3.getBotId();
        if (r134 == null) goto L180;
        String r56 = r134;
    L181:
        Pair[] r135 = new Pair[1];
        String r46 = (String) r1.get("collection_id");
        if (r46 != null) goto L184;
        r46 = UUID.randomUUID().toString();
    L184:
        r135[0] = TuplesKt.to("collection_id", r46);
        Map r49 = MapsKt.mutableMapOf(r135);
        ChatSendUtils.a.getClass();
        ClientControllerParam r55 = ChatSendUtils.k(r3);
        String r47 = r133.content();
        String r136 = r133.h;
        if (r136 != null) goto L187;
        int r137 = wf9.b.a;
        r136 = com.flow.kmp.common.util.i.a();
    L187:
        String r48 = r136;
        MessageRequestType r312 = r133.d();
        LinkedHashMap r138 = new LinkedHashMap();
        Pair<String, String> r50 = r133.h();
        r138.put(r50.getFirst(), r50.getSecond());
        Unit r51 = Unit.INSTANCE;
        yc9.f0 r52 = new yc9.f0(r45, r312, r311, 1, 6, r47, r48, null, 0, null, false, null, r49, null, null, null, null, r138, r55, r56, null, 507117248);
    L189:
        int r53 = wf9.b.a;
        String r54 = com.flow.kmp.common.util.i.a();
        yc9.e0 r139 = new yc9.e0(this.$needReplaceTxtAndFile, r40, r52, r54);
        ChatControlTrace r140 = ChatControlTrace.b;
        String r141 = r40.i;
        if (r141 != null) goto L192;
        r141 = r310;
    L192:
        String r142 = this.$scene;
        String r143 = "edit";
        if (r142 != null) goto L195;
        r142 = "edit";
    L195:
        r140.Ma(r141, r142);
        if (r52 == null) goto L203;
        String r144 = this.$scene;
        String r145 = r52.i;
        if (r145 != null) goto L200;
        r145 = r310;
    L200:
        if (r144 != null) goto L202;
        r144 = "edit";
    L202:
        r140.Ma(r145, r144);
        Unit r146 = Unit.INSTANCE;
    L203:
        String r147 = this.$scene;
        if (r147 == null) goto L207;
        r143 = r147;
    L207:
        r140.Ma(r54, r143);
        ChatSendUtils.e(ChatSendUtils.a, r54, r40.r);
        if (r52 == null) goto L210;
        Map r57 = r52.r;
    L211:
        ChatSendUtils.d(r54, null, r57);
        com.larus.im.d.e().modifyMessageContent(r139, new a(r21, r8, this.$conversation, r3, r12, r16, r19));
        return Unit.INSTANCE;
    L210:
        r57 = null;
    L180:
        r56 = r310;
        goto L181
    L173:
        r44 = 0;
        goto L174
    L169:
        r131 = 0;
        goto L170
    L188:
        r52 = null;
        goto L189
    L158:
        if (((String) r120.get("need_deep_think")) == null) goto L160;
        String r148 = (String) r39.put("need_deep_think", String.valueOf(r36.getModel().getDeprecatedItemId()));
    L148:
        r38 = "";
        goto L149
    L139:
        r35 = null;
        goto L140
    L132:
        r115 = null;
    L124:
        r26 = false;
        goto L125
    L115:
        r24 = null;
    L112:
        r113 = 1;
        goto L113
    L107:
        r112 = 0;
        goto L108
    L95:
        if (z2.a.chatImmerseEnable() == false) goto L97;
        r19 = true;
        goto L98
    L89:
        if (StringsKt.isBlank(r17) == true) goto L92;
        r18 = false;
        goto L93
    L86:
        r17 = null;
        goto L87
    L81:
        if (z2.a.chatImmerseEnable() == false) goto L83;
        r16 = true;
        goto L84
    L75:
        if (StringsKt.isBlank(r13) == true) goto L78;
        r14 = false;
        goto L79
    L72:
        r13 = null;
    L68:
        r10 = null;
        goto L69
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        String r58 = (String) this.L$1;
        Map r59 = (Map) this.L$0;
        ResultKt.throwOnFailure(r62);
        String r60 = r58;
        r1 = r59;
    L44:
        if (o0.d(r60) == false) goto L46;
    L47:
        r1.put("collection_id", UUID.randomUUID().toString());
    L49:
        if (this.$message.getLocalMessageId() == null) goto L54;
        String r61 = this.$message.getLocalMessageId();
        if (r61 != null) goto L53;
        r61 = "";
    L53:
        r1.put("modified_from", r61);
    L54:
        RepoDispatcher.a.getClass();
        BotRepo r63 = RepoDispatcher.g;
        String r64 = this.$message.getConversationId();
        if (r64 != null) goto L57;
        r64 = "";
    L57:
        this.L$0 = r1;
        this.L$1 = null;
        this.label = 3;
        r2 = r63.j1(r64, false, this);
        if (r2 != r7) goto L60;
        return r7;
    L46:
        if (this.$newAttachmentInfo == null) goto L49;
    L11:
        ResultKt.throwOnFailure(r62);
        Object r65 = r62;
    L17:
        Boolean r66 = (Boolean) r65;
    L18:
        Map r67 = this.$message.getExt();
        if (r67 == null) goto L22;
        r1 = MapsKt.toMutableMap(r67);
        if (r1 == null) goto L22;
    L26:
        Map<String, String> r68 = this.$extras;
        ChatSendStrategy r69 = this.this$0;
        ChatPageContext r70 = this.$chatPageContext;
        if (r68 == null) goto L29;
        r1.putAll(r68);
    L29:
        r1.remove("conversation_fork_auto_route_reanswer");
        ChatSendStrategy.k(r69, r1, r70);
        Map r71 = this.$message.getExt();
        if (r71 == null) goto L32;
        r60 = (String) r71.get("collection_id");
    L33:
        if (r60 != null) goto L35;
    L38:
        boolean r72 = true;
    L39:
        if (r72 == true) goto L44;
        ChatSendUtils r73 = ChatSendUtils.a;
        Message r74 = this.$message;
        this.L$0 = r1;
        this.L$1 = r60;
        this.label = 2;
        if (r73.r(r74, this) != r7) goto L44;
        return r7;
    L35:
        if (StringsKt.isBlank(r60) == true) goto L38;
        r72 = false;
        goto L39
    L32:
        r60 = null;
    L22:
        Map<String, String> r75 = this.$extras;
        if (r75 == null) goto L25;
        r1 = MapsKt.toMutableMap(r75);
        goto L26
    L25:
        r1 = new LinkedHashMap();
        goto L26
    L12:
        ResultKt.throwOnFailure(r62);
        com.larus.bmhome.chat.helper.d0 r76 = com.larus.bmhome.chat.helper.d0.a;
        com.larus.bmhome.chat.helper.d0.c(this.$conversation);
        FLogger.a.i("ChatSendStrategy", "reeditMessage: messageId = " + this.$message.getMessageId() + ", scene = " + this.$scene);
        IObricChatSPIService r77 = (IObricChatSPIService) this.this$0.d.getValue();
        if (r77 == null) goto L18;
        String r78 = this.$conversation.a;
        this.label = 1;
        r65 = IObricChatSPIService.a.a(r77, r78, false, null, this, 6);
        if (r65 != r7) goto L17;
        return r7;
    }
}
