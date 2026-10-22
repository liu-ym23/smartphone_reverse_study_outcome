package com.larus.bmhome.chat.component.title;

import ce8.c;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.actionbar.api.ChatUIBlockConfig;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.EditPos;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import s1a.a;
import ss8.g;
import t1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.title.ChatTitleComponent$updateRealtimeCallBtnInTitle$1$1", f = "ChatTitleComponent.kt", i = {}, l = {1366, 1386}, m = "invokeSuspend", n = {}, s = {})
public final class ChatTitleComponent$updateRealtimeCallBtnInTitle$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EditPos $editPos;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ com.larus.platform.api.g0 $titleBar;
    int label;
    final /* synthetic */ ChatTitleComponent this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.title.ChatTitleComponent$updateRealtimeCallBtnInTitle$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.title.ChatTitleComponent$updateRealtimeCallBtnInTitle$1$1$1", f = "ChatTitleComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $hookRealTimeCallBtnShow;
        final /* synthetic */ Ref.BooleanRef $isBtnVisible;
        final /* synthetic */ boolean $isRedDotVisible;
        final /* synthetic */ com.larus.platform.api.g0 $titleBar;
        int label;
        final /* synthetic */ ChatTitleComponent this$0;

        public AnonymousClass1(ChatTitleComponent r1, Ref.BooleanRef r2, com.larus.platform.api.g0 r3, boolean r4, boolean r5, Continuation<? super AnonymousClass1> r6) {
            this.this$0 = r1;
            this.$isBtnVisible = r2;
            this.$titleBar = r3;
            this.$isRedDotVisible = r4;
            this.$hookRealTimeCallBtnShow = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass1(this.this$0, this.$isBtnVisible, this.$titleBar, this.$isRedDotVisible, this.$hookRealTimeCallBtnShow, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L24;
            ResultKt.throwOnFailure(r6);
            b r7 = a.g(a.c(this.this$0));
            boolean r0 = false;
            if (r7 == null) goto L11;
            g r8 = r7.getAbility(g.class);
            if (r8 == null) goto L11;
            if (r8.bc(ChatUIBlockConfig.HIDE_TITLE_BAR_BUTTONS) != true) goto L11;
            boolean r9 = true;
        L13:
            if (this.$isBtnVisible.element == true) goto L15;
        L18:
            FLogger r1 = FLogger.a;
            ChatTitleComponent r2 = this.this$0;
            int r3 = ChatTitleComponent.P1;
            r1.i(r2.d4(), "[updateRealtimeCallBtnInTitle] setting isRealTimeCallVisible=" + r0 + ", isCallBlocked=" + r9);
            this.$titleBar.setRealTimeCallVisible(r0);
            this.$titleBar.setRedDotVisible(this.$isRedDotVisible);
            this.$titleBar.setRealtimeCallVisibleHookShow(this.$hookRealTimeCallBtnShow);
            if (this.$isBtnVisible.element == false) goto L22;
            final com.larus.platform.api.g0 r10 = this.$titleBar;
            final ChatTitleComponent r4 = this.this$0;
            final boolean r5 = this.$isRedDotVisible;
            r10.setRealtimeCallBtnClickListener(new t1(r10, r4, r5));
        L22:
            return Unit.INSTANCE;
        L15:
            if (c.a() == true) goto L18;
            if (r9 == true) goto L18;
            r0 = true;
        L11:
            r9 = false;
            goto L13
        L24:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ChatTitleComponent$updateRealtimeCallBtnInTitle$1$1(EditPos r1, ChatTitleComponent r2, boolean r3, com.larus.platform.api.g0 r4, Continuation<? super ChatTitleComponent$updateRealtimeCallBtnInTitle$1$1> r5) {
        this.$editPos = r1;
        this.this$0 = r2;
        this.$enabled = r3;
        this.$titleBar = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ChatTitleComponent$updateRealtimeCallBtnInTitle$1$1(this.$editPos, this.this$0, this.$enabled, this.$titleBar, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r13);
    L48:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r13);
    L13:
        boolean r14 = ((Boolean) r13).booleanValue();
        if (z2.a.R1().getRealtimeCallBtnShowTopRight() == true) goto L24;
        IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r2 == null) goto L20;
        r2.S();
        if (com.larus.home.impl.sdk.c1.a.a() != true) goto L20;
        boolean r3 = true;
    L21:
        if (r3 == true) goto L24;
        boolean r4 = false;
    L25:
        Ref.BooleanRef r7 = new Ref.BooleanRef();
        if (r14 == false) goto L31;
        if (r4 == false) goto L31;
        if (this.$enabled == false) goto L31;
        boolean r15 = true;
    L32:
        r7.element = r15;
        FLogger r16 = FLogger.a;
        ChatTitleComponent r5 = this.this$0;
        int r6 = ChatTitleComponent.P1;
        r16.i(r5.d4(), "[updateRealtimeCallBtnInTitle] isBtnVisible:" + r7.element + ", enable:" + this.$enabled + ", showTopRight:" + r4);
        com.larus.audio.p0 r17 = AudioServiceDelegate.a.getAudioConfig();
        if (this.$enabled == true) goto L35;
    L41:
        boolean r9 = false;
    L42:
        if (r9 == false) goto L44;
        r17.y();
    L44:
        boolean r10 = r17.B(this.$titleBar.Da());
        MainCoroutineDispatcher r18 = Dispatchers.getMain();
        AnonymousClass1 r8 = new AnonymousClass1(this.this$0, r7, this.$titleBar, r9, r10, null);
        this.label = 2;
        if (BuildersKt.withContext(r18, r8, this) != r0) goto L48;
        return r0;
    L35:
        if (r17.m() == false) goto L41;
        if (r17.i() == false) goto L41;
        if (AccountService.a.isLogin().booleanValue() == false) goto L41;
        r9 = true;
    L31:
        r15 = false;
    L20:
        r3 = false;
    L24:
        r4 = true;
        goto L25
    L10:
        ResultKt.throwOnFailure(r13);
        VoiceCallServiceDelegate r19 = VoiceCallServiceDelegate.a;
        EditPos r11 = this.$editPos;
        ChatTitleComponent r12 = this.this$0;
        int r20 = ChatTitleComponent.P1;
        BotModel r21 = r12.j0();
        String r22 = this.this$0.Q3();
        this.label = 1;
        r13 = r19.f(r11, r21, r22, this);
        if (r13 != r0) goto L13;
        return r0;
    }
}
