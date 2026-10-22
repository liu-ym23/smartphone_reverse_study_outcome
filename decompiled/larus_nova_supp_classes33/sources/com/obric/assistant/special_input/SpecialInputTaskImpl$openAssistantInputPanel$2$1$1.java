package com.obric.assistant.special_input;

import android.os.Bundle;
import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.ability.ObricSpecialInputScene;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindow$DefaultImpls;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.util.SoundEffectHelper;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
import com.obric.assistant.reporter.IObricReporter;
import com.obric.assistant.spi.app.IObricLaunchService;
import com.obric.assistant.util.r2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.SpecialInputTaskImpl$openAssistantInputPanel$2$1$1", f = "SpecialInputTaskImpl.kt", i = {0, 0, 0, 0}, l = {165}, m = "invokeSuspend", n = {"$this$launch", "vContext", "inputScene", "obricSpecialInputAbility"}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class SpecialInputTaskImpl$openAssistantInputPanel$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $force;
    final /* synthetic */ boolean $isAppInnerCall;
    final /* synthetic */ boolean $isAutoOpen;
    final /* synthetic */ w0 $meta;
    final /* synthetic */ boolean $startWithAsr;
    final /* synthetic */ StateInfo $stateInfo;
    final /* synthetic */ Ref.ObjectRef<String> $topPkg;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ SpecialInputTaskImpl this$0;

    public SpecialInputTaskImpl$openAssistantInputPanel$2$1$1(StateInfo r1, boolean r2, boolean r3, w0 r4, SpecialInputTaskImpl r5, boolean r6, Ref.ObjectRef<String> r7, boolean r8, Continuation<? super SpecialInputTaskImpl$openAssistantInputPanel$2$1$1> r9) {
        this.$stateInfo = r1;
        this.$force = r2;
        this.$startWithAsr = r3;
        this.$meta = r4;
        this.this$0 = r5;
        this.$isAppInnerCall = r6;
        this.$topPkg = r7;
        this.$isAutoOpen = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        SpecialInputTaskImpl$openAssistantInputPanel$2$1$1 r10 = new SpecialInputTaskImpl$openAssistantInputPanel$2$1$1(this.$stateInfo, this.$force, this.$startWithAsr, this.$meta, this.this$0, this.$isAppInnerCall, this.$topPkg, this.$isAutoOpen, r13);
        r10.L$0 = r12;
        return r10;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r4 = null;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        laa.j r3 = (laa.j) this.L$3;
        ObricSpecialInputScene r5 = (ObricSpecialInputScene) this.L$2;
        t1a.b r7 = (t1a.b) this.L$1;
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r20);
        t1a.b r9 = r7;
        ObricSpecialInputScene r10 = r5;
        Object r6 = r20;
    L36:
        if (((Boolean) r6).booleanValue() != true) goto L38;
        laa.j r11 = r3;
        ObricSpecialInputScene r13 = r10;
        boolean r12 = true;
    L40:
        if (r12 == false) goto L51;
        FLogger r14 = FLogger.a;
        r14.i("SpecialInputTaskImpl", "show use existing ui");
        IAssistantChatWindow r15 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r15 == null) goto L44;
        r15.interruptMovingBackground();
    L44:
        if (r11 == null) goto L50;
        SpecialInputTaskImpl r16 = this.this$0;
        StateInfo r17 = this.$stateInfo;
        boolean r18 = this.$isAutoOpen;
        boolean r19 = this.$startWithAsr;
        w0 r21 = this.$meta;
        SpecialInputTaskImpl.i(r16);
        laa.j.a.a(r11, false, r17, r13, null, r18, false, 72);
        if (r19 == false) goto L49;
        SpecialInputTaskImpl.j(r16, r9, r17, r21);
    L49:
        return Unit.INSTANCE;
    L50:
        r14.w("SpecialInputTaskImpl", "show use existing ui failed");
    L80:
        if (this.$force == true) goto L92;
        w0 r22 = this.$meta;
        if (r22 != null) goto L84;
    L86:
        boolean r23 = false;
    L87:
        if (r23 == true) goto L92;
        if (com.obric.assistant.special_input.util.j.a(this.$stateInfo) == true) goto L92;
        FLogger.a.i("SpecialInputTaskImpl", "is not force open or not open mic to reply scene, return");
        return Unit.INSTANCE;
    L84:
        if (r22.c() != true) goto L86;
        r23 = true;
    L92:
        FLogger r24 = FLogger.a;
        r24.i("SpecialInputTaskImpl", "open new chat window");
        w0 r25 = this.$meta;
        if (r25 != null) goto L95;
    L97:
        boolean r26 = false;
    L98:
        if (r26 == false) goto L100;
    L154:
        r24.i("SpecialInputTaskImpl", "is open mic to reply scene");
        this.this$0.l(this.$stateInfo);
        SpecialInputTaskImpl r27 = this.this$0;
        StateInfo r28 = this.$stateInfo;
        w0 r29 = this.$meta;
        r27.getClass();
        SpecialInputTaskImpl.m(r28, r29);
    L156:
        return Unit.INSTANCE;
    L100:
        if (com.obric.assistant.special_input.util.j.a(this.$stateInfo) == true) goto L154;
        r24.i("SpecialInputTaskImpl", "is default scene");
        if (this.$isAppInnerCall == true) goto L131;
        SpecialInputTaskImpl r30 = this.this$0;
        StateInfo r31 = this.$stateInfo;
        String r32 = (String) this.$topPkg.element;
        int r33 = SpecialInputTaskImpl.j;
        r30.getClass();
        String r34 = r31.getTaskType();
        if (r34 == null) goto L130;
        int r35 = r34.hashCode();
        if (r35 == (-300091468)) goto L121;
        if (r35 == 1405882063) goto L117;
        if (r35 != 1439051435) goto L130;
        if (r34.equals("auto_gui") == false) goto L130;
    L119:
        String r36 = "oauto_input_icon";
        String r37 = "oauto_input_window";
    L124:
        IObricReporter.a.getClass();
        IObricReporter r38 = IObricReporter.a.a();
        if (r38 == null) goto L128;
        r38.n(r36, r37, false);
    L128:
        if (com.larus.utils.o0.d(r32) == false) goto L131;
        IAssistantInteractionServiceKt.getInteractionStateService().setWakeUpAppPkg(r32, "updateLaunchReportParams topPkg");
        goto L131
    L117:
        if (r34.equals("auto_timer_task") == true) goto L119;
    L121:
        if (r34.equals("complex_task") == false) goto L130;
        r36 = "mcp_input_icon";
        r37 = "mcp_input_window";
    L130:
        r24.w("SpecialInputTaskImpl", "updateLaunchReportParams unknown task type");
    L131:
        ObricSpecialInputScene.a r39 = ObricSpecialInputScene.Companion;
        String r40 = this.$stateInfo.getTaskType();
        r39.getClass();
        ObricSpecialInputScene.a.a(r40);
        if (this.$stateInfo.getRequestType() != 0) goto L145;
        String r41 = this.$stateInfo.getContent();
        if (r41 != null) goto L136;
    L139:
        boolean r42 = true;
    L140:
        if (r42 == true) goto L142;
    L144:
        boolean r43 = false;
    L146:
        SpecialInputTaskImpl.i(this.this$0);
        if (r43 == false) goto L151;
        this.this$0.getClass();
        if (ILoginService.a.getAccountInfo().a == false) goto L151;
        SoundEffectHelper.INSTANCE.playListening();
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_LONG_PRESS);
    L151:
        IAssistantChatWindow r44 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r44 == null) goto L156;
        Bundle r110 = new Bundle();
        StateInfo r45 = this.$stateInfo;
        r110.putBoolean("obric_open_special_input", true);
        r110.putParcelable("obric_special_input_state_info", r45);
        r110.putString("obric_special_input_task_type", r45.getTaskType());
        Unit r46 = Unit.INSTANCE;
        IAssistantChatWindow$DefaultImpls.openChatWindow$default(r44, "WAKEUP_SOURCE_SPECIAL_INPUT", r43, null, r110, false, false, null, null, AppHost.a.a().isAppBackground(), false, 756, null);
        goto L156
    L142:
        if (this.$startWithAsr == false) goto L144;
        r43 = true;
        goto L146
    L136:
        if (r41.length() == 0) goto L139;
        r42 = false;
        goto L140
    L145:
        r43 = this.$startWithAsr;
        goto L146
    L95:
        if (r25.c() != true) goto L97;
        r26 = true;
        goto L98
    L51:
        FLogger r47 = FLogger.a;
        r47.i("SpecialInputTaskImpl", "existing ui can not show input panel now");
        if (this.$startWithAsr == false) goto L80;
        if (r11 == null) goto L59;
        kotlinx.coroutines.flow.b1 r48 = r11.O4();
        if (r48 == null) goto L59;
        if (((Boolean) r48.getValue()).booleanValue() != true) goto L59;
        boolean r49 = true;
    L60:
        if (r49 == false) goto L80;
        laa.v r50 = (laa.v) r11.i80().getValue();
        if (r50 == null) goto L80;
        StateInfo r51 = r50.b;
        if (r51 == null) goto L80;
        StateInfo r52 = this.$stateInfo;
        SpecialInputTaskImpl r53 = this.this$0;
        w0 r111 = this.$meta;
        String r112 = r51.getRefMessageId();
        if (r52 == null) goto L69;
        r4 = r52.getRefMessageId();
    L69:
        if (Intrinsics.areEqual(r112, r4) == false) goto L80;
        if (Intrinsics.areEqual(r51.getTaskType(), r52.getTaskType()) == false) goto L80;
        if (r51.getRequestType() != r52.getRequestType()) goto L80;
        if (Intrinsics.areEqual(r51.getContent(), r52.getContent()) == false) goto L80;
        r47.i("SpecialInputTaskImpl", "tryTurnOnMic for existing ui");
        SpecialInputTaskImpl.j(r53, r9, r52, r111);
        return Unit.INSTANCE;
    L59:
        r49 = false;
        goto L60
    L38:
        laa.j r54 = r3;
    L39:
        r13 = r10;
        r11 = r54;
        r12 = false;
        goto L40
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r20);
        CoroutineScope r55 = (CoroutineScope) this.L$0;
        if (ILoginService.a.getAccountInfo().a == true) goto L15;
        FLogger.a.i("SpecialInputTaskImpl", "has not login, go login");
        IObricLaunchService r56 = (IObricLaunchService) ServiceManager.get().getService(IObricLaunchService.class);
        if (r56 == null) goto L14;
        r56.startLauncherIntent();
    L14:
        return Unit.INSTANCE;
    L15:
        boolean r57 = AppHost.a.a().isAppBackground();
        r9 = r2.a();
        if (r9 != null) goto L18;
        FLogger.a.i("SpecialInputTaskImpl", "not found chat fragment");
    L18:
        if (r9 == null) goto L22;
        com.larus.bmhome.chat.component.cvs.y r58 = r9.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        if (r58 == null) goto L22;
        wc9.e r59 = r58.h();
    L23:
        boolean r60 = ic8.n.v(r59);
        FLogger r113 = FLogger.a;
        r113.i("SpecialInputTaskImpl", "openAssistantInputPanel: isAppBackground = " + r57 + ", isMainConversation = " + r60);
        if (r57 == true) goto L80;
        if (r60 == false) goto L80;
        if (r9 == null) goto L80;
        r113.i("SpecialInputTaskImpl", "switch input mode");
        ObricSpecialInputScene.a r61 = ObricSpecialInputScene.Companion;
        String r62 = this.$stateInfo.getTaskType();
        r61.getClass();
        r10 = ObricSpecialInputScene.a.a(r62);
        if (r10 == null) goto L78;
        r54 = r9.getAbility(laa.j.class);
        fga.a r114 = r9.getAbility(fga.a.class);
        if (r114 == null) goto L39;
        boolean r115 = this.$force;
        this.L$0 = r55;
        this.L$1 = r9;
        this.L$2 = r10;
        this.L$3 = r54;
        this.label = 1;
        r6 = fga.a.C0055a.a(r114, r115, true, this, 1);
        if (r6 != r1) goto L34;
        return r1;
    L34:
        r3 = r54;
        goto L36
    L78:
        r113.w("SpecialInputTaskImpl", "not find scene for " + this.$stateInfo.getTaskType());
    L22:
        r59 = null;
        goto L23
    }
}
