package com.larus.bmhome.chat.model.strategy.block;

import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
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
import com.larus.im.callback.IIMCallback;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.obric.assistant.spi.chat.IObricChatSPIService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import component.ChatRepoComponent;
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
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.block.ChatBlockSendStrategy$sendMessage$2", f = "ChatBlockSendStrategy.kt", i = {0, 1, 2, 2}, l = {238, 240, 310}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "bot", "newStrategy"}, s = {"L$0", "L$0", "L$0", "L$1"})
public final class ChatBlockSendStrategy$sendMessage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<ux9.a.b> $audioAttempts;
    final /* synthetic */ IIMCallback<Message> $callback;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ String $localMessageId;
    final /* synthetic */ boolean $needInterrupt;
    final /* synthetic */ String $sendFuncChannel;
    final /* synthetic */ ic8.w $strategy;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ChatBlockSendStrategy this$0;

    public ChatBlockSendStrategy$sendMessage$2(wc9.e r1, ChatBlockSendStrategy r2, ic8.w r3, boolean r4, List<ux9.a.b> r5, String r6, IIMCallback<Message> r7, String r8, Continuation<? super ChatBlockSendStrategy$sendMessage$2> r9) {
        this.$conversation = r1;
        this.this$0 = r2;
        this.$strategy = r3;
        this.$needInterrupt = r4;
        this.$audioAttempts = r5;
        this.$localMessageId = r6;
        this.$callback = r7;
        this.$sendFuncChannel = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        ChatBlockSendStrategy$sendMessage$2 r10 = new ChatBlockSendStrategy$sendMessage$2(this.$conversation, this.this$0, this.$strategy, this.$needInterrupt, this.$audioAttempts, this.$localMessageId, this.$callback, this.$sendFuncChannel, r13);
        r10.L$0 = r12;
        return r10;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r28) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        boolean r12 = true;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        if (r0 != 3) goto L9;
        ic8.w r1 = (ic8.w) this.L$1;
        BotModel r2 = (BotModel) this.L$0;
        ResultKt.throwOnFailure(r28);
        Object r3 = r28;
    L127:
        Pair r4 = (Pair) r3;
        d0 r17 = d0.a;
        String r5 = this.$conversation.a;
        List r19 = CollectionsKt.listOf(r1);
        if (r2 == null) goto L130;
        String r20 = r2.getBotId();
    L131:
        MessageRequestV2 r6 = d0.n(r17, r5, r19, r20, (String) r4.getFirst(), (String) r4.getSecond(), 0, null, false, 224);
        final Message r8 = (Message) ListProtector.get(d0.o(r6), 0);
        final Map r9 = ChatRenderTrace.b.d(this.$conversation.a);
        final List<ux9.a.b> r10 = this.$audioAttempts;
        final IIMCallback<Message> r11 = this.$callback;
        final wc9.e r13 = this.$conversation;
        final String r14 = this.$localMessageId;
        final ic8.w r15 = this.$strategy;
        final ChatBlockSendStrategy r16 = this.this$0;
        final BotModel r22 = r2;
        IIMCallback<List<? extends Message>> r18 = new ChatBlockSendStrategy$sendMessage$2$cb$1(r10, r9, r11, r13, r22, r14, r15, r16, r8);
        Iterator<T> r21 = r10.iterator();
    L133:
        if (r21.hasNext() == false) goto L135;
        ((ux9.a.b) r21.next()).a();
        goto L133
    L135:
        com.larus.im.d.e().v(r6, r18);
        if (ArraysKt.contains(new Integer[]{Boxing.boxInt(1), Boxing.boxInt(2)}, Boxing.boxInt(z2.a.getSendMessageNetworkToastConfig().b())) == false) goto L138;
        ChatSendUtils.a.getClass();
        ChatSendUtils.t();
    L138:
        if (r2 == null) goto L145;
        Integer r23 = r2.getBotType();
        if (r23 == null) goto L145;
        if (r23.intValue() != 1) goto L145;
        boolean r24 = true;
    L146:
        if (r24 == false) goto L150;
        IFlowSdkDepend r25 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r25 == null) goto L150;
        r25.r0();
        e2 r26 = e2.a;
    L150:
        String r27 = this.$localMessageId;
        String r29 = this.$sendFuncChannel;
        wc9.e r30 = this.$conversation;
        com.larus.bmhome.chat.trace.appreciable.f r31 = com.larus.bmhome.chat.trace.appreciable.f.a;
        int r32 = r8.getContentType();
        String r33 = com.larus.bmhome.chat.bean.d.H(r8);
        com.larus.bmhome.instruction.c r110 = com.larus.bmhome.instruction.c.a;
        if (r2 == null) goto L153;
        String r111 = r2.getBotId();
    L154:
        if (r111 != null) goto L156;
        r111 = "";
    L156:
        ModelItemIdentity r112 = r110.a(r111, ActiveSwitchType.DEEPTHINK.getValue()).getModel();
        r31.getClass();
        com.larus.bmhome.chat.trace.appreciable.f.h(r27, r32, r33, r29, r112);
        ConcurrentHashMap r34 = ko8.b.a;
        ko8.b.c(r27, r8.getContentType(), r29);
        ChatControlTrace r113 = ChatControlTrace.b;
        Integer r35 = r30.v;
        if (r35 == null) goto L159;
        int r114 = r35.intValue();
    L160:
        if (r2 == null) goto L164;
        Integer r36 = r2.getBotType();
        if (r36 == null) goto L164;
        int r210 = r36.intValue();
    L165:
        if (r2 == null) goto L169;
        BotCreatorInfo r37 = r2.getBotCreatorInfo();
        if (r37 == null) goto L169;
        String r38 = r37.getId();
    L170:
        boolean r211 = Intrinsics.areEqual(r38, AccountService.a.getUserId());
        ChatSendUtils.a.getClass();
        boolean r212 = ChatSendUtils.o(r2);
        if (r2 == null) goto L179;
        String r39 = r2.getBgVideoModel();
        if (r39 == null) goto L179;
        if (r39.length() > 0) goto L178;
        r12 = false;
    L178:
        boolean r213 = r12;
    L180:
        if (r2 == null) goto L182;
        String r115 = r2.getBotId();
    L183:
        if (r115 != null) goto L185;
        String r214 = "";
    L186:
        ChatControlTrace.U(r113, r8, r114, r210, r211, r212, r213, r214, r9, 256);
        return Unit.INSTANCE;
    L185:
        r214 = r115;
        goto L186
    L182:
        r115 = null;
    L179:
        r213 = false;
    L169:
        r38 = null;
    L164:
        r210 = 0;
        goto L165
    L159:
        r114 = 0;
        goto L160
    L153:
        r111 = null;
    L145:
        r24 = false;
        goto L146
    L130:
        r20 = null;
        goto L131
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        CoroutineScope r40 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r28);
        Object r41 = r28;
    L21:
        r2 = (BotModel) r41;
        ChatBlockSendStrategy r42 = this.this$0;
        wc9.e r43 = this.$conversation;
        if (r2 == null) goto L24;
        String r44 = r2.getBotId();
    L25:
        if (r44 != null) goto L27;
        r44 = "";
    L27:
        int r45 = ChatBlockSendStrategy.d;
        r42.p(r43, r44, true);
        if (this.$needInterrupt == false) goto L30;
        RepoDispatcher.a.getClass();
        IConversationRepoService$a.f(RepoDispatcher.f, this.$conversation.a, false, false, OmniBreakReason.OmniBreakReason_SEND_NEW_MSG, 4);
    L30:
        com.larus.im.d.e().k(this.$conversation.a);
        ConcurrentHashMap r46 = v3.a;
        v3.f(this.$conversation, null, null);
        ic8.w r47 = this.$strategy;
        ChatBlockSendStrategy r48 = this.this$0;
        wc9.e r49 = this.$conversation;
        String r50 = this.$localMessageId;
        Map<String, String> r51 = r47.a();
        if (r51 == null) goto L34;
        Map<String, String> r52 = MapsKt.toMutableMap(r51);
        if (r52 == null) goto L34;
    L35:
        ConcurrentHashMap r116 = ChatRepoComponent.i;
        r52.putAll(ChatRepoComponent.a.a(r47));
        ChatBlockSendStrategy.k(r48, r52, r47.N());
        PluginManagerDelegate r53 = PluginManagerDelegate.a;
        Map<? extends String, ? extends String> r54 = PluginManagerDelegate.p(r49.a);
        if (r54 == null) goto L38;
        r52.putAll(r54);
    L38:
        r52.putAll(com.larus.bmhome.chat.model.a0.a());
        ChatSendUtils r55 = ChatSendUtils.a;
        IMessageExtService.a r117 = new IMessageExtService.a(r47.content(), 2);
        r55.getClass();
        ChatSendUtils.h(r52, r49, r117);
        ChatSendUtils.d(r50, null, r52);
        ChatSendUtils.b(r52);
        if (r2 == null) goto L41;
        String r118 = r2.getBotId();
    L42:
        if (r118 != null) goto L44;
        r118 = "";
    L44:
        ChatSendUtils.c(r47, r118, r52, r49);
        String r119 = r49.a;
        if (r2 == null) goto L47;
        String r120 = r2.getBotId();
    L48:
        ChatSendUtils.a(r119, r120, r50, r52);
        Map<? extends String, ? extends String> r56 = ChatSendUtils.g(r49.a);
        if (r56 == null) goto L52;
        r52.putAll(r56);
    L52:
        if (r52.containsKey("select_project_id") == false) goto L63;
        String r121 = r52.get("select_project_id");
        if (r121 != null) goto L56;
    L59:
        boolean r122 = true;
    L60:
        if (r122 == false) goto L62;
        r52.remove("project_id");
    L83:
        if (r52.containsKey("select_project_id") == false) goto L109;
        String r57 = r52.get("select_project_id");
        if (r57 != null) goto L87;
        r57 = "";
    L87:
        IFlowSdkDepend r123 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r123 == null) goto L103;
        r123.P();
        Fragment r124 = ChatServiceImpl.a.f();
        if (r124 == null) goto L103;
        t1a.b r125 = s1a.a.g(r124);
        if (r125 == null) goto L103;
        com.larus.bmhome.chat.component.cvs.y r126 = r125.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        if (r126 == null) goto L103;
        wc9.e r127 = r126.h();
        if (r127 == null) goto L103;
        if (Intrinsics.areEqual(r127.a, r49.a) == true) goto L101;
        r127 = null;
    L101:
        if (r127 == null) goto L103;
        r49 = r127;
    L103:
        String r58 = r49.I;
        if (r58 != null) goto L107;
        r58 = "";
    L107:
        if (Intrinsics.areEqual(r57, r58) == true) goto L109;
        r52.put("task_project_id", r57);
    L109:
        Map<String, String> r59 = r47.f();
        if (r59 == null) goto L113;
        Map<String, String> r60 = MapsKt.toMutableMap(r59);
        if (r60 == null) goto L113;
    L114:
        r60.putAll(v3.b());
        ChatPageContext r61 = r47.N();
        if (r61 == null) goto L124;
        Map<String, String> r62 = r61.getBizExt();
        if (r62 == null) goto L124;
        if ((!r62.isEmpty()) == true) goto L122;
        r62 = null;
    L122:
        if (r62 == null) goto L124;
        r60.putAll(r62);
    L124:
        r1 = r47.c(r52, r60);
        String r63 = this.$conversation.a;
        this.L$0 = r2;
        this.L$1 = r1;
        this.label = 3;
        r3 = r55.l(r63, this);
        if (r3 != r7) goto L127;
        return r7;
    L113:
        r60 = new LinkedHashMap();
        goto L114
    L62:
        r52.put("project_id", r121);
        goto L83
    L56:
        if (r121.length() == 0) goto L59;
        r122 = false;
        goto L60
    L63:
        String r128 = r52.get("project_id");
        if (r128 != null) goto L66;
    L69:
        boolean r129 = true;
    L70:
        if (r129 == false) goto L83;
        String r130 = r49.I;
        if (r130 == null) goto L83;
        if (r130.length() <= 0) goto L76;
        boolean r131 = true;
    L77:
        if (r131 == true) goto L80;
        r130 = null;
    L80:
        if (r130 == null) goto L83;
        r52.put("project_id", r130);
        goto L83
    L76:
        r131 = false;
        goto L77
    L66:
        if (StringsKt.isBlank(r128) == true) goto L69;
        r129 = false;
        goto L70
    L47:
        r120 = null;
        goto L48
    L41:
        r118 = null;
    L34:
        r52 = new LinkedHashMap();
        goto L35
    L24:
        r44 = null;
        goto L25
    L11:
        CoroutineScope r64 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r28);
        CoroutineScope r132 = r64;
        Object r65 = r28;
    L17:
        Boolean r66 = (Boolean) r65;
    L18:
        RepoDispatcher.a.getClass();
        BotRepo r67 = RepoDispatcher.g;
        String r68 = this.$conversation.a;
        this.L$0 = r132;
        this.label = 2;
        r41 = r67.j1(r68, false, this);
        if (r41 != r7) goto L21;
        return r7;
    L12:
        ResultKt.throwOnFailure(r28);
        r132 = (CoroutineScope) this.L$0;
        com.larus.bmhome.chat.helper.d0 r69 = com.larus.bmhome.chat.helper.d0.a;
        com.larus.bmhome.chat.helper.d0.c(this.$conversation);
        IObricChatSPIService r70 = (IObricChatSPIService) this.this$0.c.getValue();
        if (r70 == null) goto L18;
        String r71 = this.$conversation.a;
        Map<String, String> r72 = this.$strategy.a();
        this.L$0 = r132;
        this.label = 1;
        r65 = IObricChatSPIService.a.a(r70, r71, false, r72, this, 2);
        if (r65 != r7) goto L17;
        return r7;
    }
}
