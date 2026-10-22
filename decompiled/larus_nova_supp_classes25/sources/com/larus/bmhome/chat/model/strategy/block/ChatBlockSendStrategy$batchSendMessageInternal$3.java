package com.larus.bmhome.chat.model.strategy.block;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.chat.api.IMessageExtService;
import com.larus.bmhome.chat.auth.PluginManagerDelegate;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.IConversationRepoService$a;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.model.strategy.ChatSendUtils;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.chat.trace.ChatRenderTrace;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.utils.v3;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.home.impl.sdk.e2;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageRequestV2;
import com.larus.im.bean.message.MessageSpecificExtra;
import com.larus.im.bean.message.RequestMessage;
import com.larus.im.callback.IIMCallback;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.obric.assistant.spi.chat.IObricChatSPIService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import component.ChatRepoComponent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.block.ChatBlockSendStrategy$batchSendMessageInternal$3", f = "ChatBlockSendStrategy.kt", i = {2, 2}, l = {454, 456, 530}, m = "invokeSuspend", n = {"bot", "newStrategies"}, s = {"L$0", "L$1"})
public final class ChatBlockSendStrategy$batchSendMessageInternal$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<ux9.a.b> $audioAttempts;
    final /* synthetic */ IIMCallback<List<Message>> $callback;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ boolean $needInterrupt;
    final /* synthetic */ Map<String, String> $relatedDeletedMessageIds;
    final /* synthetic */ String $sendFuncChannel;
    final /* synthetic */ List<ic8.w> $strategies;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ChatBlockSendStrategy this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatBlockSendStrategy$batchSendMessageInternal$3(wc9.e r1, ChatBlockSendStrategy r2, Map<String, String> r3, boolean r4, List<? extends ic8.w> r5, List<ux9.a.b> r6, IIMCallback<List<Message>> r7, String r8, Continuation<? super ChatBlockSendStrategy$batchSendMessageInternal$3> r9) {
        this.$conversation = r1;
        this.this$0 = r2;
        this.$relatedDeletedMessageIds = r3;
        this.$needInterrupt = r4;
        this.$strategies = r5;
        this.$audioAttempts = r6;
        this.$callback = r7;
        this.$sendFuncChannel = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new ChatBlockSendStrategy$batchSendMessageInternal$3(this.$conversation, this.this$0, this.$relatedDeletedMessageIds, this.$needInterrupt, this.$strategies, this.$audioAttempts, this.$callback, this.$sendFuncChannel, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r33) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        String r13 = null;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        if (r0 != 3) goto L9;
        List r1 = (List) this.L$1;
        BotModel r2 = (BotModel) this.L$0;
        ResultKt.throwOnFailure(r33);
        List r22 = r1;
        Object r3 = r33;
    L137:
        Pair r4 = (Pair) r3;
        d0 r20 = d0.a;
        String r5 = this.$conversation.a;
        if (r2 == null) goto L140;
        String r23 = r2.getBotId();
    L141:
        final MessageRequestV2 r6 = d0.n(r20, r5, r22, r23, (String) r4.getFirst(), (String) r4.getSecond(), 0, this.$relatedDeletedMessageIds, false, 160);
        final List r8 = d0.o(r6);
        final Map r9 = ChatRenderTrace.b.d(this.$conversation.a);
        final IIMCallback<List<Message>> r10 = this.$callback;
        final List<ux9.a.b> r11 = this.$audioAttempts;
        final wc9.e r12 = this.$conversation;
        final ChatBlockSendStrategy r14 = this.this$0;
        final BotModel r28 = r2;
        IIMCallback<List<? extends Message>> r15 = new ChatBlockSendStrategy$batchSendMessageInternal$3$cb$1(r10, r11, r9, r12, r28, r6, r8, r14);
        Iterator<T> r16 = r11.iterator();
    L143:
        if (r16.hasNext() == false) goto L145;
        ((ux9.a.b) r16.next()).a();
        goto L143
    L145:
        com.larus.im.d.e().v(r6, r15);
        if (ArraysKt.contains(new Integer[]{Boxing.boxInt(1), Boxing.boxInt(2)}, Boxing.boxInt(z2.a.getSendMessageNetworkToastConfig().b())) == false) goto L148;
        ChatSendUtils.a.getClass();
        ChatSendUtils.t();
    L148:
        if (r2 == null) goto L156;
        Integer r17 = r2.getBotType();
        if (r17 == null) goto L156;
        if (r17.intValue() != 1) goto L156;
        boolean r18 = true;
    L157:
        if (r18 == false) goto L161;
        IFlowSdkDepend r19 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r19 == null) goto L161;
        r19.r0();
        e2 r21 = e2.a;
    L161:
        String r24 = this.$sendFuncChannel;
        wc9.e r25 = this.$conversation;
        Iterator r26 = ((ArrayList) r8).iterator();
    L163:
        if (r26.hasNext() == false) goto L218;
        Message r27 = (Message) r26.next();
        com.larus.bmhome.chat.trace.appreciable.f r29 = com.larus.bmhome.chat.trace.appreciable.f.a;
        String r30 = r27.getLocalMessageId();
        if (r30 != null) goto L167;
        r30 = "";
    L167:
        int r110 = r27.getContentType();
        String r111 = com.larus.bmhome.chat.bean.d.H(r27);
        com.larus.bmhome.instruction.c r112 = com.larus.bmhome.instruction.c.a;
        if (r2 == null) goto L170;
        String r113 = r2.getBotId();
    L171:
        if (r113 != null) goto L173;
        r113 = "";
    L173:
        ModelItemIdentity r31 = r112.a(r113, ActiveSwitchType.DEEPTHINK.getValue()).getModel();
        r29.getClass();
        com.larus.bmhome.chat.trace.appreciable.f.h(r30, r110, r111, r24, r31);
        ConcurrentHashMap r32 = ko8.b.a;
        ko8.b.c(r27.getLocalMessageId(), r27.getContentType(), r24);
        ChatControlTrace r34 = ChatControlTrace.b;
        Integer r35 = r25.v;
        if (r35 == null) goto L176;
        int r210 = r35.intValue();
    L177:
        if (r2 == null) goto L181;
        Integer r36 = r2.getBotType();
        if (r36 == null) goto L181;
        int r211 = r36.intValue();
    L182:
        if (r2 == null) goto L186;
        BotCreatorInfo r37 = r2.getBotCreatorInfo();
        if (r37 == null) goto L186;
        String r38 = r37.getId();
    L187:
        boolean r212 = Intrinsics.areEqual(r38, AccountService.a.getUserId());
        ChatSendUtils.a.getClass();
        boolean r213 = ChatSendUtils.o(r2);
        if (r2 == null) goto L196;
        String r39 = r2.getBgVideoModel();
        if (r39 == null) goto L196;
        if (r39.length() <= 0) goto L194;
        boolean r40 = true;
    L195:
        boolean r214 = r40;
    L197:
        if (r2 == null) goto L199;
        String r41 = r2.getBotId();
    L200:
        if (r41 != null) goto L202;
        String r215 = "";
    L203:
        Iterator r42 = r6.getRequestMessages().iterator();
    L205:
        if (r42.hasNext() == false) goto L209;
        Object r43 = r42.next();
        if (Intrinsics.areEqual(r27.getLocalMessageId(), ((RequestMessage) r43).getLocalMessageId()) == false) goto L205;
    L210:
        RequestMessage r44 = (RequestMessage) r43;
        if (r44 == null) goto L215;
        MessageSpecificExtra r45 = r44.getSpecificExtra();
        if (r45 == null) goto L215;
        Map r216 = r45.getForceTraceMap();
    L216:
        r34.getClass();
        ChatControlTrace.T(r27, r210, r211, r212, r213, r214, r215, r9, r216);
    L215:
        r216 = null;
        goto L216
    L209:
        r43 = null;
        goto L210
    L202:
        r215 = r41;
        goto L203
    L199:
        r41 = null;
        goto L200
    L194:
        r40 = false;
    L196:
        r214 = false;
    L186:
        r38 = null;
    L181:
        r211 = 0;
        goto L182
    L176:
        r210 = 0;
        goto L177
    L170:
        r113 = null;
        goto L171
    L218:
        return Unit.INSTANCE;
    L156:
        r18 = false;
        goto L157
    L140:
        r23 = null;
        goto L141
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r33);
        Object r46 = r33;
    L21:
        r2 = (BotModel) r46;
        ChatBlockSendStrategy r47 = this.this$0;
        wc9.e r48 = this.$conversation;
        if (r2 == null) goto L24;
        String r49 = r2.getBotId();
    L25:
        if (r49 != null) goto L28;
        r49 = "";
    L28:
        if (this.$relatedDeletedMessageIds != null) goto L30;
        boolean r50 = true;
    L31:
        int r51 = ChatBlockSendStrategy.d;
        r47.p(r48, r49, r50);
        if (this.$needInterrupt == false) goto L34;
        RepoDispatcher.a.getClass();
        IConversationRepoService$a.f(RepoDispatcher.f, this.$conversation.a, false, false, OmniBreakReason.OmniBreakReason_SEND_NEW_MSG, 4);
    L34:
        ConcurrentHashMap r52 = v3.a;
        v3.f(this.$conversation, null, null);
        Map<? extends String, ? extends String> r53 = v3.b();
        List<ic8.w> r54 = this.$strategies;
        ChatBlockSendStrategy r55 = this.this$0;
        wc9.e r56 = this.$conversation;
        ArrayList r57 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r54, 10));
        Iterator<T> r58 = r54.iterator();
    L36:
        if (r58.hasNext() == false) goto L133;
        ic8.w r114 = (ic8.w) r58.next();
        Map<String, String> r115 = r114.a();
        if (r115 == null) goto L41;
        Map<String, String> r116 = MapsKt.toMutableMap(r115);
        if (r116 == null) goto L41;
    L42:
        ConcurrentHashMap r117 = ChatRepoComponent.i;
        r116.putAll(ChatRepoComponent.a.a(r114));
        ChatBlockSendStrategy.k(r55, r116, r114.N());
        PluginManagerDelegate r118 = PluginManagerDelegate.a;
        Map<? extends String, ? extends String> r119 = PluginManagerDelegate.p(r56.a);
        if (r119 == null) goto L45;
        r116.putAll(r119);
    L45:
        r116.putAll(com.larus.bmhome.chat.model.a0.a());
        ChatSendUtils r120 = ChatSendUtils.a;
        IMessageExtService.a r59 = new IMessageExtService.a(r114.content(), 2);
        r120.getClass();
        ChatSendUtils.h(r116, r56, r59);
        ChatSendUtils.d(r114.b(), r13, r116);
        ChatSendUtils.b(r116);
        if (r2 == null) goto L48;
        String r60 = r2.getBotId();
    L49:
        if (r60 != null) goto L51;
        r60 = "";
    L51:
        ChatSendUtils.c(r114, r60, r116, r56);
        String r61 = r56.a;
        if (r2 == null) goto L54;
        String r121 = r2.getBotId();
    L55:
        ChatSendUtils.a(r61, r121, r114.b(), r116);
        Map<? extends String, ? extends String> r62 = ChatSendUtils.g(r56.a);
        if (r62 == null) goto L59;
        r116.putAll(r62);
    L59:
        if (r116.containsKey("select_project_id") == false) goto L70;
        String r122 = r116.get("select_project_id");
        if (r122 != null) goto L63;
    L66:
        boolean r123 = true;
    L67:
        if (r123 == false) goto L69;
        r116.remove("project_id");
    L90:
        if (r116.containsKey("select_project_id") == false) goto L117;
        String r63 = r116.get("select_project_id");
        if (r63 != null) goto L94;
        r63 = "";
    L94:
        IFlowSdkDepend r124 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r124 == null) goto L110;
        r124.P();
        Fragment r125 = ChatServiceImpl.a.f();
        if (r125 == null) goto L110;
        t1a.b r126 = s1a.a.g(r125);
        if (r126 == null) goto L110;
        com.larus.bmhome.chat.component.cvs.y r127 = r126.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        if (r127 == null) goto L110;
        wc9.e r128 = r127.h();
        if (r128 == null) goto L110;
        if (Intrinsics.areEqual(r128.a, r56.a) == true) goto L108;
        r128 = null;
    L108:
        if (r128 == null) goto L110;
    L111:
        String r129 = r128.I;
        if (r129 != null) goto L115;
        r129 = "";
    L115:
        if (Intrinsics.areEqual(r63, r129) == true) goto L117;
        r116.put("task_project_id", r63);
    L110:
        r128 = r56;
    L117:
        Map<String, String> r64 = r114.f();
        if (r64 == null) goto L121;
        Map<String, String> r65 = MapsKt.toMutableMap(r64);
        if (r65 == null) goto L121;
    L122:
        r65.putAll(r53);
        ChatPageContext r130 = r114.N();
        if (r130 == null) goto L132;
        Map<String, String> r131 = r130.getBizExt();
        if (r131 == null) goto L132;
        if ((!r131.isEmpty()) == true) goto L130;
        r131 = null;
    L130:
        if (r131 == null) goto L132;
        r65.putAll(r131);
    L132:
        r57.add(r114.c(r116, r65));
        r13 = null;
    L121:
        r65 = new LinkedHashMap();
        goto L122
    L69:
        r116.put("project_id", r122);
        goto L90
    L63:
        if (r122.length() == 0) goto L66;
        r123 = false;
        goto L67
    L70:
        String r132 = r116.get("project_id");
        if (r132 != null) goto L73;
    L76:
        boolean r133 = true;
    L77:
        if (r133 == false) goto L90;
        String r134 = r56.I;
        if (r134 == null) goto L90;
        if (r134.length() <= 0) goto L83;
        boolean r135 = true;
    L84:
        if (r135 == true) goto L87;
        r134 = r13;
    L87:
        if (r134 == null) goto L90;
        r116.put("project_id", r134);
        goto L90
    L83:
        r135 = false;
        goto L84
    L73:
        if (StringsKt.isBlank(r132) == true) goto L76;
        r133 = false;
        goto L77
    L54:
        r121 = r13;
        goto L55
    L48:
        r60 = r13;
    L41:
        r116 = new LinkedHashMap();
        goto L42
    L133:
        ChatSendUtils r66 = ChatSendUtils.a;
        String r67 = this.$conversation.a;
        this.L$0 = r2;
        this.L$1 = r57;
        this.label = 3;
        r3 = r66.l(r67, this);
        if (r3 != r7) goto L136;
        return r7;
    L136:
        r22 = r57;
        goto L137
    L30:
        r50 = false;
        goto L31
    L24:
        r49 = null;
        goto L25
    L11:
        ResultKt.throwOnFailure(r33);
        Object r68 = r33;
    L17:
        Boolean r69 = (Boolean) r68;
    L18:
        RepoDispatcher.a.getClass();
        BotRepo r70 = RepoDispatcher.g;
        String r71 = this.$conversation.a;
        this.label = 2;
        r46 = r70.j1(r71, false, this);
        if (r46 != r7) goto L21;
        return r7;
    L12:
        ResultKt.throwOnFailure(r33);
        com.larus.bmhome.chat.helper.d0 r72 = com.larus.bmhome.chat.helper.d0.a;
        com.larus.bmhome.chat.helper.d0.c(this.$conversation);
        IObricChatSPIService r73 = (IObricChatSPIService) this.this$0.c.getValue();
        if (r73 == null) goto L18;
        String r74 = this.$conversation.a;
        this.label = 1;
        r68 = IObricChatSPIService.a.a(r73, r74, false, null, this, 6);
        if (r68 != r7) goto L17;
        return r7;
    }
}
