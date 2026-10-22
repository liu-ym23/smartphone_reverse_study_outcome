package com.larus.bmhome.chat.model.strategy;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.api.AppletPayloadProviderDelegate;
import com.larus.bmhome.chat.api.IMessageExtService;
import com.larus.bmhome.chat.auth.PluginManagerDelegate;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.IConversationRepoService$a;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.chat.trace.ChatRenderTrace;
import com.larus.bmhome.chat.trace.appreciable.f;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.utils.v3;
import com.larus.home.impl.sdk.e2;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.obric.assistant.spi.chat.IObricChatSPIService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import component.ChatRepoComponent;
import hq9.j0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.ChatSendStrategy$sendMessage$1", f = "ChatSendStrategy.kt", i = {2, 3, 3, 4, 4, 4, 4, 4}, l = {DoraCallStateCode.DOUBAO_STOP_SI_BY_EXCEPTION, DoraCallStateCode.DOUBAO_RAPID_FLASHING_END, DoraCallStateCode.DOUBAO_START_LIVE_TUTOR, 173, 218}, m = "invokeSuspend", n = {"request", "request", "cvs", "request", "cvs", "bot", "newRequest", "sendMessageTrackExtMap"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4"})
public final class ChatSendStrategy$sendMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IIMCallback<Message> $callback;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ yc9.f0 $req;
    final /* synthetic */ String $sendFuncChannel;
    final /* synthetic */ ic8.w $strategy;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ ChatSendStrategy this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.model.strategy.ChatSendStrategy$sendMessage$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.ChatSendStrategy$sendMessage$1$2", f = "ChatSendStrategy.kt", i = {}, l = {219}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatSendStrategy this$0;

        public AnonymousClass2(ChatSendStrategy r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            long r3 = ((j0) this.this$0.b.getValue()).f();
            this.label = 1;
            if (DelayKt.delay(r3, this) != r0) goto L12;
            return r0;
        }
    }

    public ChatSendStrategy$sendMessage$1(wc9.e r1, ChatSendStrategy r2, yc9.f0 r3, String r4, ic8.w r5, IIMCallback<Message> r6, Continuation<? super ChatSendStrategy$sendMessage$1> r7) {
        this.$conversation = r1;
        this.this$0 = r2;
        this.$req = r3;
        this.$sendFuncChannel = r4;
        this.$strategy = r5;
        this.$callback = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ChatSendStrategy$sendMessage$1(this.$conversation, this.this$0, this.$req, this.$sendFuncChannel, this.$strategy, this.$callback, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r51) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        String r15 = null;
        if (r0 == 0) goto L17;
        if (r0 == 1) goto L16;
        if (r0 == 2) goto L15;
        if (r0 == 3) goto L14;
        if (r0 == 4) goto L13;
        if (r0 != 5) goto L12;
        Map r1 = (Map) this.L$4;
        yc9.f0 r2 = (yc9.f0) this.L$3;
        BotModel r3 = (BotModel) this.L$2;
        wc9.e r4 = (wc9.e) this.L$1;
        yc9.f0 r5 = (yc9.f0) this.L$0;
        ResultKt.throwOnFailure(r51);
    L10:
        final Map r24 = r1;
        final yc9.f0 r18 = r5;
        NativeMessageServiceImpl r6 = com.larus.im.d.e();
        if (r3 == null) goto L85;
        String r48 = r3.getBotId();
    L86:
        ChatSendUtils.a.getClass();
        yc9.f0 r8 = yc9.f0.a(r2, null, null, null, 0, null, null, null, 0, null, null, null, null, null, ChatSendUtils.k(r3), r48, 511705087);
        ChatSendUtils.d(r8.i, null, r8.r);
        ChatSendUtils.b(r8.r);
        final IIMCallback<Message> r9 = this.$callback;
        final ChatSendStrategy r10 = this.this$0;
        final wc9.e r19 = r4;
        final BotModel r20 = r3;
        r6.sendMessage(r8, new AnonymousClass4(r9, r18, r19, r20, r24, r10));
        if (ArraysKt.contains(new Integer[]{Boxing.boxInt(1), Boxing.boxInt(2)}, Boxing.boxInt(z2.a.getSendMessageNetworkToastConfig().b())) == false) goto L89;
        ChatSendUtils.t();
    L89:
        if (r3 == null) goto L96;
        Integer r11 = r3.getBotType();
        if (r11 == null) goto L96;
        if (r11.intValue() != 1) goto L96;
        boolean r12 = true;
    L97:
        if (r12 == false) goto L101;
        IFlowSdkDepend r13 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r13 == null) goto L101;
        r13.r0();
        e2 r14 = e2.a;
        Unit r16 = Unit.INSTANCE;
    L101:
        ChatControlTrace r17 = ChatControlTrace.b;
        Message r110 = com.larus.im.internal.core.message.converter.c.a(r2);
        Integer r21 = r4.v;
        if (r21 == null) goto L104;
        int r111 = r21.intValue();
    L105:
        if (r3 == null) goto L109;
        Integer r22 = r3.getBotType();
        if (r22 == null) goto L109;
        int r112 = r22.intValue();
    L110:
        if (r3 == null) goto L114;
        BotCreatorInfo r23 = r3.getBotCreatorInfo();
        if (r23 == null) goto L114;
        r15 = r23.getId();
    L114:
        boolean r25 = Intrinsics.areEqual(r15, AccountService.a.getUserId());
        boolean r26 = ChatSendUtils.o(r3);
        if (r3 == null) goto L123;
        String r27 = r3.getBgVideoModel();
        if (r27 == null) goto L123;
        if (r27.length() <= 0) goto L121;
        boolean r113 = true;
    L122:
        boolean r28 = r113;
    L124:
        if (r3 == null) goto L129;
        String r29 = r3.getBotId();
        if (r29 == null) goto L129;
        String r210 = r29;
    L130:
        ChatControlTrace.U(r17, r110, r111, r112, r25, r26, r28, r210, r24, 256);
        return Unit.INSTANCE;
    L129:
        r210 = "";
        goto L130
    L121:
        r113 = false;
    L123:
        r28 = false;
    L109:
        r112 = 0;
        goto L110
    L104:
        r111 = 0;
    L96:
        r12 = false;
        goto L97
    L85:
        r48 = null;
        goto L86
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        wc9.e r30 = (wc9.e) this.L$1;
        yc9.f0 r31 = (yc9.f0) this.L$0;
        ResultKt.throwOnFailure(r51);
        r4 = r30;
        r5 = r31;
        Object r32 = r51;
    L41:
        r3 = (BotModel) r32;
        ChatControlTrace r33 = ChatControlTrace.b;
        String r34 = r5.i;
        if (r34 != null) goto L44;
        r34 = "";
    L44:
        r33.getClass();
        ChatControlTrace.X(r34);
        RepoDispatcher.a.getClass();
        IConversationRepoService$a.f(RepoDispatcher.f, r5.a, false, false, OmniBreakReason.OmniBreakReason_SEND_NEW_MSG, 4);
        com.larus.im.d.e().k(r5.a);
        com.larus.bmhome.instruction.c r35 = com.larus.bmhome.instruction.c.a;
        if (r3 == null) goto L47;
        String r36 = r3.getBotId();
    L48:
        if (r36 != null) goto L50;
        r36 = "";
    L50:
        ReplyOption r37 = r35.a(r36, ActiveSwitchType.DEEPTHINK.getValue());
        f r38 = f.a;
        String r39 = r5.i;
        yc9.f0 r40 = this.$req;
        int r114 = r40.e;
        String r41 = r40.f;
        String r115 = this.$sendFuncChannel;
        ModelItemIdentity r42 = r37.getModel();
        r38.getClass();
        f.h(r39, r114, r41, r115, r42);
        AppletPayloadProviderDelegate r43 = AppletPayloadProviderDelegate.a;
        String r44 = r5.a;
        if (r3 == null) goto L53;
        String r45 = r3.getBotId();
    L54:
        r5.A = r43.b(r44, r45, r5.i);
        Unit r46 = Unit.INSTANCE;
        v3.f(r4, null, null);
        LinkedHashMap r47 = new LinkedHashMap();
        ic8.w r49 = this.$strategy;
        ChatSendStrategy r50 = this.this$0;
        wc9.e r52 = this.$conversation;
        ConcurrentHashMap r116 = ChatRepoComponent.i;
        r47.putAll(ChatRepoComponent.a.a(r49));
        Map r117 = r5.r;
        if (r117 == null) goto L57;
        r47.putAll(r117);
    L57:
        ChatSendStrategy.k(r50, r47, r49.N());
        PluginManagerDelegate r53 = PluginManagerDelegate.a;
        Map r54 = PluginManagerDelegate.p(r5.a);
        if (r54 == null) goto L60;
        r47.putAll(r54);
    L60:
        r47.putAll(com.larus.bmhome.chat.model.a0.a());
        if (r47.containsKey("need_deep_think") == true) goto L63;
        r47.put("need_deep_think", String.valueOf(r37.getModel().getDeprecatedItemId()));
    L63:
        Iterator r55 = ServiceManager.get().getServices(IMessageExtService.class, true).iterator();
    L65:
        if (r55.hasNext() == false) goto L67;
        ((IMessageExtService) r55.next()).a(r47, r52, new IMessageExtService.a(r5.f, 2));
        goto L65
    L67:
        Unit r56 = Unit.INSTANCE;
        LinkedHashMap r57 = new LinkedHashMap();
        ChatSendStrategy r58 = this.this$0;
        ic8.w r59 = this.$strategy;
        r57.putAll(r5.w);
        ConcurrentHashMap r60 = v3.a;
        r57.putAll(v3.b());
        ChatPageContext r61 = r59.N();
        r58.getClass();
        if (r61 == null) goto L77;
        Map<String, String> r62 = r61.getBizExt();
        if (r62 == null) goto L77;
        if ((!r62.isEmpty()) == true) goto L75;
        r62 = null;
    L75:
        if (r62 == null) goto L77;
        r57.putAll(r62);
    L77:
        r2 = yc9.f0.a(r5, null, null, null, 0, null, null, null, 0, r47, null, null, null, r57, null, null, 532545535);
        r1 = ChatRenderTrace.b.d(r5.a);
        if (((j0) this.this$0.b.getValue()).c() == false) goto L10;
        CoroutineDispatcher r63 = Dispatchers.getDefault();
        AnonymousClass2 r64 = new AnonymousClass2(this.this$0, null);
        this.L$0 = r5;
        this.L$1 = r4;
        this.L$2 = r3;
        this.L$3 = r2;
        this.L$4 = r1;
        this.label = 5;
        if (BuildersKt.withContext(r63, r64, this) != r7) goto L10;
        return r7;
    L53:
        r45 = null;
        goto L54
    L47:
        r36 = null;
        goto L48
    L14:
        yc9.f0 r65 = (yc9.f0) this.L$0;
        ResultKt.throwOnFailure(r51);
        yc9.f0 r118 = r65;
        Object r66 = r51;
    L31:
        wc9.e r67 = (wc9.e) r66;
        if (r67 == null) goto L34;
        yc9.f0 r68 = r118;
    L37:
        RepoDispatcher.a.getClass();
        BotRepo r69 = RepoDispatcher.g;
        String r70 = r67.a;
        this.L$0 = r68;
        this.L$1 = r67;
        this.label = 4;
        r32 = r69.j1(r70, false, this);
        if (r32 != r7) goto L40;
        return r7;
    L40:
        r4 = r67;
        r5 = r68;
        goto L41
    L34:
        return Unit.INSTANCE;
    L15:
        ResultKt.throwOnFailure(r51);
        Object r71 = r51;
    L26:
        r68 = (yc9.f0) r71;
        r67 = IAIChatControlTraceService.a.h(ChatControlTrace.b, r68.a);
        if (r67 != null) goto L37;
        RepoDispatcher.a.getClass();
        ConversationRepo r72 = RepoDispatcher.f;
        String r73 = r68.a;
        this.L$0 = r68;
        this.label = 3;
        r118 = r68;
        r66 = IConversationRepoService$a.c(r72, r73, false, null, this, 6);
        if (r66 != r7) goto L31;
        return r7;
    L16:
        ResultKt.throwOnFailure(r51);
        Object r74 = r51;
    L22:
        Boolean r75 = (Boolean) r74;
    L23:
        ChatSendUtils r76 = ChatSendUtils.a;
        yc9.f0 r77 = this.$req;
        this.label = 2;
        r71 = r76.f(r77, this);
        if (r71 != r7) goto L26;
        return r7;
    L17:
        ResultKt.throwOnFailure(r51);
        com.larus.bmhome.chat.helper.d0 r78 = com.larus.bmhome.chat.helper.d0.a;
        com.larus.bmhome.chat.helper.d0.c(this.$conversation);
        IObricChatSPIService r79 = (IObricChatSPIService) this.this$0.d.getValue();
        if (r79 == null) goto L23;
        String r80 = this.$conversation.a;
        Map r81 = this.$req.r;
        this.label = 1;
        r74 = IObricChatSPIService.a.a(r79, r80, false, r81, this, 2);
        if (r74 != r7) goto L22;
        return r7;
    }
}
