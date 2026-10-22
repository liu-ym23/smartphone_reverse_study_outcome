package com.larus.bmhome.chat.model.strategy;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.api.AppletPayloadProviderDelegate;
import com.larus.bmhome.chat.api.IMessageExtService;
import com.larus.bmhome.chat.auth.PluginManagerDelegate;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.BotRepo;
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
import com.obric.assistant.spi.chat.IObricChatSPIService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import component.ChatRepoComponent;
import hq9.j0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.ChatSendStrategy$batchSendMessage$1", f = "ChatSendStrategy.kt", i = {1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3}, l = {330, 332, 381, 405}, m = "invokeSuspend", n = {"requests", "requests", "bot", "sendMessageTrackExtMap", "replyOption", "groupIdExt", "destination$iv$iv", "index$iv$iv", "index", "requests", "bot", "sendMessageTrackExtMap", "newRequest"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$8", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3"})
public final class ChatSendStrategy$batchSendMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IIMCallback<List<Message>> $callback;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ String $sendFuncChannel;
    final /* synthetic */ List<ic8.w> $strategies;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    final /* synthetic */ ChatSendStrategy this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.model.strategy.ChatSendStrategy$batchSendMessage$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.ChatSendStrategy$batchSendMessage$1$3", f = "ChatSendStrategy.kt", i = {}, l = {406}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatSendStrategy this$0;

        public AnonymousClass3(ChatSendStrategy r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
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

    /* JADX WARN: Multi-variable type inference failed */
    public ChatSendStrategy$batchSendMessage$1(wc9.e r1, ChatSendStrategy r2, List<? extends ic8.w> r3, String r4, IIMCallback<List<Message>> r5, Continuation<? super ChatSendStrategy$batchSendMessage$1> r6) {
        this.$conversation = r1;
        this.this$0 = r2;
        this.$strategies = r3;
        this.$sendFuncChannel = r4;
        this.$callback = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ChatSendStrategy$batchSendMessage$1(this.$conversation, this.this$0, this.$strategies, this.$sendFuncChannel, this.$callback, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x02b6 -> B:106:0x02c0). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r45) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L14;
        if (r0 == 1) goto L13;
        if (r0 == 2) goto L12;
        if (r0 == 3) goto L11;
        if (r0 != 4) goto L10;
        List r1 = (List) this.L$3;
        Map r2 = (Map) this.L$2;
        BotModel r3 = (BotModel) this.L$1;
        List r4 = (List) this.L$0;
        ResultKt.throwOnFailure(r45);
        ChatSendStrategy$batchSendMessage$1 r9 = this;
        List r5 = r4;
    L133:
        final Map r6 = r2;
        final BotModel r8 = r3;
        final List r10 = r5;
    L135:
        NativeMessageServiceImpl r11 = com.larus.im.d.e();
        List r12 = r1;
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r14 = r12.iterator();
    L137:
        if (r14.hasNext() == false) goto L143;
        yc9.f0 r26 = (yc9.f0) r14.next();
        if (r8 == null) goto L141;
        String r41 = r8.getBotId();
    L142:
        ChatSendUtils.a.getClass();
        yc9.f0 r15 = yc9.f0.a(r26, null, null, null, 0, null, null, null, 0, null, null, null, null, null, ChatSendUtils.k(r8), r41, 511705087);
        ChatSendUtils.d(r15.i, null, r15.r);
        ChatSendUtils.b(r15.r);
        r13.add(r15);
        goto L137
    L141:
        r41 = null;
        goto L142
    L143:
        final IIMCallback<List<Message>> r16 = r9.$callback;
        final wc9.e r17 = r9.$conversation;
        final ChatSendStrategy r18 = r9.this$0;
        r11.batchSendMessage(r13, new AnonymousClass5(r16, r17, r8, r6, r10, r18));
        if (ArraysKt.contains(new Integer[]{Boxing.boxInt(1), Boxing.boxInt(2)}, Boxing.boxInt(z2.a.getSendMessageNetworkToastConfig().b())) == false) goto L147;
        ChatSendUtils.a.getClass();
        ChatSendUtils.t();
    L147:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        int r19 = this.I$1;
        int r20 = this.I$0;
        Collection r21 = (Collection) this.L$10;
        Iterator r22 = (Iterator) this.L$9;
        Collection r23 = (Collection) this.L$8;
        wc9.e r24 = (wc9.e) this.L$7;
        ChatSendStrategy r110 = (ChatSendStrategy) this.L$6;
        List<ic8.w> r111 = (List) this.L$5;
        Map r112 = (Map) this.L$4;
        ReplyOption r113 = (ReplyOption) this.L$3;
        Map r25 = (Map) this.L$2;
        BotModel r114 = (BotModel) this.L$1;
        List r27 = (List) this.L$0;
        ResultKt.throwOnFailure(r45);
        int r115 = r20;
        int r28 = r19;
        ChatSendStrategy r29 = r110;
        Map r116 = r112;
        List<ic8.w> r117 = r111;
        wc9.e r118 = r24;
        List r30 = r27;
        ReplyOption r31 = r113;
        ChatSendStrategy$batchSendMessage$1 r119 = this;
        Object r32 = r45;
        Collection r33 = r21;
        Collection r34 = r23;
        Iterator r35 = r22;
    L106:
        yc9.f0 r36 = (yc9.f0) r32;
        Collection r46 = r34;
        LinkedHashMap r37 = new LinkedHashMap();
        ConcurrentHashMap r120 = ChatRepoComponent.i;
        Iterator r121 = r35;
        r37.putAll(ChatRepoComponent.a.a((ic8.w) ListProtector.get(r117, r28)));
        Map r38 = r36.r;
        if (r38 == null) goto L109;
        r37.putAll(r38);
        Unit r39 = Unit.INSTANCE;
    L109:
        ChatSendStrategy.k(r29, r37, ((ic8.w) ListProtector.get(r117, r28)).N());
        PluginManagerDelegate r40 = PluginManagerDelegate.a;
        Map r42 = PluginManagerDelegate.p(r36.a);
        if (r42 == null) goto L112;
        r37.putAll(r42);
        Unit r43 = Unit.INSTANCE;
    L112:
        r37.putAll(com.larus.bmhome.chat.model.a0.a());
        ChatSendStrategy r122 = r29;
        r37.put("need_deep_think", String.valueOf(r31.getModel().getDeprecatedItemId()));
        List r123 = r30;
        Iterator r44 = ServiceManager.get().getServices(IMessageExtService.class, true).iterator();
    L114:
        if (r44.hasNext() == false) goto L116;
        ((IMessageExtService) r44.next()).a(r37, r118, new IMessageExtService.a(r36.f, 2));
        r44 = r44;
        r7 = r7;
        goto L114
    L116:
        Object r210 = r7;
        LinkedHashMap r47 = new LinkedHashMap();
        r47.putAll(r36.w);
        r47.putAll(r116);
        ChatPageContext r48 = ((ic8.w) ListProtector.get(r117, r28)).N();
        if (r48 == null) goto L126;
        Map<String, String> r49 = r48.getBizExt();
        if (r49 == null) goto L126;
        if ((!r49.isEmpty()) == true) goto L124;
        r49 = null;
    L124:
        if (r49 == null) goto L126;
        r47.putAll(r49);
    L126:
        Unit r50 = Unit.INSTANCE;
        r33.add(yc9.f0.a(r36, null, null, null, 0, null, null, null, 0, r37, null, null, null, r47, null, null, 532545535));
        r34 = r46;
        r2 = r25;
        r9 = r119;
        wc9.e r124 = r118;
        List<ic8.w> r125 = r117;
        BotModel r51 = r114;
        int r52 = r115;
        Map r126 = r116;
        ChatSendStrategy r127 = r122;
        r35 = r121;
        List r53 = r123;
        r7 = r210;
    L98:
        if (r35.hasNext() == false) goto L127;
        Object r128 = r35.next();
        r115 = r52 + 1;
        if (r52 >= 0) goto L102;
        CollectionsKt.throwIndexOverflow();
    L102:
        ChatSendUtils r54 = ChatSendUtils.a;
        r9.L$0 = r53;
        r9.L$1 = r51;
        r9.L$2 = r2;
        r9.L$3 = r31;
        r9.L$4 = r126;
        r9.L$5 = r125;
        r9.L$6 = r127;
        r9.L$7 = r124;
        r9.L$8 = r34;
        r9.L$9 = r35;
        r9.L$10 = r34;
        r9.I$0 = r115;
        r9.I$1 = r52;
        int r410 = r52;
        r9.label = 3;
        r32 = r54.f((yc9.f0) r128, r9);
        if (r32 != r7) goto L105;
        return r7;
    L105:
        r114 = r51;
        r29 = r127;
        r33 = r34;
        r116 = r126;
        r117 = r125;
        r118 = r124;
        r119 = r9;
        r25 = r2;
        r28 = r410;
        r30 = r53;
        goto L106
    L127:
        r1 = (List) r34;
        if (((j0) r9.this$0.b.getValue()).c() == false) goto L134;
        CoroutineDispatcher r55 = Dispatchers.getDefault();
        AnonymousClass3 r56 = new AnonymousClass3(r9.this$0, null);
        r9.L$0 = r53;
        r9.L$1 = r51;
        r9.L$2 = r2;
        r9.L$3 = r1;
        r9.L$4 = null;
        r9.L$5 = null;
        r9.L$6 = null;
        r9.L$7 = null;
        r9.L$8 = null;
        r9.L$9 = null;
        r9.L$10 = null;
        r9.label = 4;
        if (BuildersKt.withContext(r55, r56, r9) != r7) goto L132;
        return r7;
    L132:
        r3 = r51;
        r5 = r53;
        goto L133
    L134:
        r8 = r51;
        r10 = r53;
        r6 = r2;
        goto L135
    L12:
        List r57 = (List) this.L$0;
        ResultKt.throwOnFailure(r45);
        List r58 = r57;
        Object r59 = r45;
    L27:
        BotModel r60 = (BotModel) r59;
        ChatRenderTrace r61 = ChatRenderTrace.b;
        Map r62 = r61.d(this.$conversation.a);
        if (r62 == null) goto L30;
        r61.n(this.$conversation.a, "creation_task_id");
    L31:
        com.larus.bmhome.instruction.c r63 = com.larus.bmhome.instruction.c.a;
        if (r60 == null) goto L34;
        String r64 = r60.getBotId();
    L36:
        if (r64 != null) goto L38;
        r64 = "";
    L38:
        ReplyOption r65 = r63.a(r64, ActiveSwitchType.DEEPTHINK.getValue());
        List r66 = r58;
        wc9.e r67 = this.$conversation;
        String r68 = this.$sendFuncChannel;
        Iterator r129 = r66.iterator();
    L40:
        if (r129.hasNext() == false) goto L79;
        yc9.f0 r130 = (yc9.f0) r129.next();
        ChatControlTrace r131 = ChatControlTrace.b;
        Map r132 = r130.r;
        r131.getClass();
        Integer r133 = ChatControlTrace.p(r132);
        String r134 = r130.i;
        Map r135 = r130.r;
        if (r135 == null) goto L44;
        String r136 = (String) r135.get("action_bar_instruction_type");
    L45:
        ChatControlTrace.f0(r134, r136, r133);
        String r137 = r130.i;
        if (r137 != null) goto L48;
        r137 = "";
    L48:
        ChatControlTrace.X(r137);
        Message r138 = com.larus.im.internal.core.message.converter.c.a(r130);
        Integer r139 = r67.v;
        if (r139 == null) goto L51;
        int r140 = r139.intValue();
    L52:
        if (r60 == null) goto L56;
        Integer r141 = r60.getBotType();
        if (r141 == null) goto L56;
        int r142 = r141.intValue();
    L57:
        if (r60 == null) goto L61;
        BotCreatorInfo r143 = r60.getBotCreatorInfo();
        if (r143 == null) goto L61;
        String r144 = r143.getId();
    L62:
        boolean r211 = Intrinsics.areEqual(r144, AccountService.a.getUserId());
        ChatSendUtils.a.getClass();
        boolean r212 = ChatSendUtils.o(r60);
        if (r60 == null) goto L71;
        String r145 = r60.getBgVideoModel();
        if (r145 == null) goto L71;
        if (r145.length() <= 0) goto L69;
        boolean r146 = true;
    L70:
        boolean r213 = r146;
    L72:
        if (r60 == null) goto L74;
        String r147 = r60.getBotId();
    L75:
        if (r147 != null) goto L77;
        String r214 = "";
    L78:
        ChatControlTrace.U(r131, r138, r140, r142, r211, r212, r213, r214, r62, 256);
        f r148 = f.a;
        String r149 = r130.i;
        int r150 = r130.e;
        String r151 = r130.f;
        ModelItemIdentity r152 = r65.getModel();
        r148.getClass();
        f.h(r149, r150, r151, r68, r152);
        goto L40
    L77:
        r214 = r147;
        goto L78
    L74:
        r147 = null;
        goto L75
    L69:
        r146 = false;
    L71:
        r213 = false;
    L61:
        r144 = null;
    L56:
        r142 = 0;
        goto L57
    L51:
        r140 = 0;
        goto L52
    L44:
        r136 = null;
        goto L45
    L79:
        RepoDispatcher.a.getClass();
        IConversationRepoService$a.f(RepoDispatcher.f, this.$conversation.a, false, false, OmniBreakReason.OmniBreakReason_SEND_NEW_MSG, 4);
        if (r60 == null) goto L87;
        Integer r69 = r60.getBotType();
        if (r69 == null) goto L87;
        if (r69.intValue() != 1) goto L87;
        boolean r70 = true;
    L88:
        if (r70 == false) goto L92;
        IFlowSdkDepend r71 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r71 == null) goto L92;
        r71.r0();
        e2 r72 = e2.a;
        Unit r73 = Unit.INSTANCE;
    L92:
        Iterator r74 = r66.iterator();
    L94:
        if (r74.hasNext() == false) goto L96;
        yc9.f0 r75 = (yc9.f0) r74.next();
        r75.A = AppletPayloadProviderDelegate.a.b(r75.a, r75.y, r75.i);
        Unit r76 = Unit.INSTANCE;
        goto L94
    L96:
        ConcurrentHashMap r77 = v3.a;
        v3.f(this.$conversation, null, null);
        Map r78 = v3.b();
        List<ic8.w> r79 = this.$strategies;
        ChatSendStrategy r80 = this.this$0;
        r124 = this.$conversation;
        ArrayList r153 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r66, 10));
        r35 = r66.iterator();
        r126 = r78;
        r127 = r80;
        r53 = r58;
        r9 = this;
        r34 = r153;
        r125 = r79;
        r31 = r65;
        r2 = r62;
        r51 = r60;
        r52 = 0;
    L87:
        r70 = false;
        goto L88
    L34:
        r64 = null;
        goto L36
    L30:
        r62 = null;
        goto L31
    L13:
        ResultKt.throwOnFailure(r45);
        Object r81 = r45;
    L19:
        Boolean r82 = (Boolean) r81;
    L20:
        List<ic8.w> r83 = this.$strategies;
        wc9.e r84 = this.$conversation;
        ArrayList r85 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r83, 10));
        Iterator<T> r86 = r83.iterator();
    L22:
        if (r86.hasNext() == false) goto L24;
        ic8.w r87 = (ic8.w) r86.next();
        com.larus.bmhome.chat.model.strategy.block.d0 r88 = com.larus.bmhome.chat.model.strategy.block.d0.a;
        String r89 = r84.a;
        r88.getClass();
        r85.add(com.larus.bmhome.chat.model.strategy.block.d0.m(r87, r89, -1));
        goto L22
    L24:
        RepoDispatcher.a.getClass();
        BotRepo r90 = RepoDispatcher.g;
        String r91 = this.$conversation.a;
        this.L$0 = r85;
        this.label = 2;
        r59 = r90.j1(r91, false, this);
        r58 = r85;
        if (r59 != r7) goto L27;
        return r7;
    L14:
        ResultKt.throwOnFailure(r45);
        com.larus.bmhome.chat.helper.d0 r92 = com.larus.bmhome.chat.helper.d0.a;
        com.larus.bmhome.chat.helper.d0.c(this.$conversation);
        IObricChatSPIService r93 = (IObricChatSPIService) this.this$0.d.getValue();
        if (r93 == null) goto L20;
        String r94 = this.$conversation.a;
        this.label = 1;
        r81 = IObricChatSPIService.a.a(r93, r94, false, null, this, 6);
        if (r81 != r7) goto L19;
        return r7;
    }
}
