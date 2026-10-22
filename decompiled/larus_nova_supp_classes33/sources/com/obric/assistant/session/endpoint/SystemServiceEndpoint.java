package com.obric.assistant.session.endpoint;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.media.MediaResourceManager;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ObricAssistantDelegate;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.session.bean.ErrorCode;
import com.obric.assistant.session.model.IAiKeyOperation;
import com.obric.assistant.session.model.IDoraOperation;
import com.obric.assistant.session.model.ILaunchMethodOperation;
import com.obric.assistant.session.model.ISessionEndPoint;
import com.obric.assistant.session.model.ISessionMaintaining;
import com.obric.assistant.session.model.ISystemServiceOperation;
import com.obric.assistant.spi.keyguard.IKeyguardService$a;
import com.obric.assistant.spi.keyguard.KeyguardService;
import com.obric.assistant.spi.startup.AssistantStartupTelemetry;
import com.obric.assistant.spi.startup.IAssistantStartupTelemetry;
import com.obric.assistant.state.api.v2.ObricStateService;
import com.obric.audio.continuous_talk.ContinuousTalkStatus;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000fJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0003J\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0006*\u00020\u000eH\u0002¢\u0006\u0002\u0010\u0013J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/session/endpoint/SystemServiceEndpoint;", "Lcom/obric/assistant/session/model/ISessionEndPoint;", "Lcom/obric/assistant/session/model/ISystemServiceOperation;", "<init>", "()V", "processOrder", "", "getProcessOrder", "()I", "onSessionProcess", "Lkotlin/Pair;", "Lcom/obric/assistant/session/bean/ErrorCode;", "", "args", "Landroid/os/Bundle;", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startCreationCanvas", "", "readDisplayId", "(Landroid/os/Bundle;)Ljava/lang/Integer;", "startCameraResult", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SystemServiceEndpoint implements ISessionEndPoint, ISystemServiceOperation {

    public static final class a implements oga.a {
        public final /* synthetic */ SystemServiceEndpoint a;
        public final /* synthetic */ String b;

        @Override // oga.a
        public final void onDismissFailed() {
            FLogger r0 = FLogger.a;
            SystemServiceEndpoint r1 = this.a;
            r1.getClass();
            r0.i(ISessionEndPoint.a.b(r1), "dismiss failed");
            String r4 = this.b;
            if (r4 == null) goto L6;
            IAssistantStartupTelemetry.a.a(AssistantStartupTelemetry.a, r4, "blocked", "dismiss_keyguard_failed", null, 24);
            return;
        }

        @Override // oga.a
        public final void onDismissSucceeded() {
            FLogger r0 = FLogger.a;
            SystemServiceEndpoint r1 = this.a;
            r1.getClass();
            r0.i(ISessionEndPoint.a.b(r1), "dismiss success");
            String r4 = this.b;
            if (r4 == null) goto L5;
            IAssistantStartupTelemetry.a.a(AssistantStartupTelemetry.a, r4, "dropped", "legacy_launcher_fallback", null, 24);
        L5:
            IAiKeyOperation r2 = bga.b.a();
            if (r2 == null) goto L9;
            r2.startLauncherIntent();
            return;
        }

        public a(SystemServiceEndpoint r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public SystemServiceEndpoint() {
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int f() {
        return 0;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int h() {
        return 50;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTagName() {
        return "SystemServiceEndpoint";
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public Context getContext() {
        return ISessionEndPoint.a.getContext(this);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTAG() {
        return ISessionEndPoint.a.b(this);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void n(ErrorCode r1) {
        ISessionEndPoint.a.c(this, r1);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final Object d(Bundle r10, Continuation<? super Pair<? extends ErrorCode, String>> r11) {
        if ((r11 instanceof SystemServiceEndpoint$onSessionProcess$1) == false) goto L7;
        SystemServiceEndpoint$onSessionProcess$1 r0 = (SystemServiceEndpoint$onSessionProcess$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r10 = (Bundle) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L17:
        String r4 = null;
        ContinuousTalkStatus r5 = null;
        r4 = null;
        boolean r6 = false;
        String r7 = "";
        if (Intrinsics.areEqual(bga.j.a(), "WAKEUP_SOURCE_ALL_SEARCH") == false) goto L32;
        String r13 = r10.getString("all_search");
        if (r13 == null) goto L23;
        r7 = r13;
    L23:
        ILaunchMethodOperation r14 = bga.g.a();
        if (r14 == null) goto L26;
        ILaunchMethodOperation.a.a(r14, null, "global_search", 1);
    L26:
        com.obric.assistant.reporter.b.a("global_search", null, 6);
        FLogger.a.i(ISessionEndPoint.a.b(this), "mark global search launch method");
        ISessionMaintaining r15 = bga.j.b();
        if (r15 == null) goto L30;
        ISessionMaintaining.a.a(r15, com.larus.utils.f.c(new Pair[]{TuplesKt.to("all_search", r7)}), null, false, 29);
    L30:
        return TuplesKt.to(ErrorCode.LAUNCH_ASSISTANT_DIRECTLY, "System-all-search-launch");
    L32:
        if (Intrinsics.areEqual(bga.j.a(), "WAKEUP_SOURCE_CANVAS_PS") == false) goto L62;
        if (r10 != null) goto L35;
        FLogger.a.i(ISessionEndPoint.a.b(this), "startCreationCanvas args is null");
    L60:
        return TuplesKt.to(ErrorCode.LAUNCH_ASSISTANT_DIRECTLY, "Album-canvas-ps");
    L35:
        String r16 = r10.getString("local_uri", null);
        if (r10.containsKey("display_id") == false) goto L44;
        Integer r8 = Integer.valueOf(r10.getInt("display_id", 0));
        if (r8.intValue() < 0) goto L41;
        boolean r9 = true;
    L42:
        if (r9 == false) goto L44;
    L45:
        FLogger.a.i(ISessionEndPoint.a.b(this), "startCreationCanvas uri = " + r16 + ", displayId = " + r8);
        if (r16 != null) goto L48;
    L49:
        r6 = true;
    L50:
        if (r6 == true) goto L60;
        ILaunchMethodOperation r17 = bga.g.a();
        if (r17 == null) goto L55;
        ILaunchMethodOperation.a.a(r17, null, "doubao_edit_from_album", 1);
    L55:
        ILaunchMethodOperation r18 = bga.g.a();
        if (r18 == null) goto L58;
        r18.k("open_doubao");
    L58:
        IAssistantInteractionServiceKt.getInteractionStateService().setWakeUpAppPkg(v0.a(r10), "SystemServiceEndpoint startCreationCanvas ");
        ObricAssistantDelegate.b.a(r16, r8);
        IApplog.a.o("obric_doubao_edit_photo_click");
        goto L60
    L48:
        if (r16.length() != 0) goto L50;
    L41:
        r9 = false;
    L44:
        r8 = null;
        goto L45
    L62:
        if (Intrinsics.areEqual(bga.j.a(), "WAKEUP_SOURCE_CAMERA_RESULT_PS") == false) goto L82;
        if (r10 != null) goto L65;
        FLogger.a.i(ISessionEndPoint.a.b(this), "startCameraResult args is null");
    L80:
        return TuplesKt.to(ErrorCode.LAUNCH_ASSISTANT_DIRECTLY, "Album-camera-result");
    L65:
        String r19 = r10.getString("local_uri", null);
        FLogger.a.i(ISessionEndPoint.a.b(this), "startCameraResult uri = " + r19);
        if (r19 != null) goto L68;
    L69:
        r6 = true;
    L70:
        if (r6 == true) goto L80;
        ILaunchMethodOperation r110 = bga.g.a();
        if (r110 == null) goto L75;
        ILaunchMethodOperation.a.a(r110, null, "gui_photo_qa", 1);
    L75:
        ILaunchMethodOperation r111 = bga.g.a();
        if (r111 == null) goto L78;
        r111.k("open_doubao");
    L78:
        ObricAssistantDelegate.b.d(r19);
        IApplog.a.o("obric_gui_photo_qa_click");
        goto L80
    L68:
        if (r19.length() != 0) goto L70;
    L82:
        if (Build.VERSION.SDK_INT >= 33) goto L84;
    L190:
        FLogger.a.i(ISessionEndPoint.a.b(this), "launch doubao as click launcher icon");
        String r112 = r10.getString("obric_startup_attempt_id");
        if (r112 != null) goto L193;
    L195:
        IKeyguardService$a.a(KeyguardService.a, new a(this, r4), false, false, false, false, null, 62);
        return TuplesKt.to(ErrorCode.ONLY_END, "System-dismiss-keyguard");
    L193:
        if ((!StringsKt.isBlank(r112)) == false) goto L195;
        r4 = r112;
        goto L195
    L84:
        if (ObricFeatureServiceDelegate.b.c() == false) goto L190;
        if (r10.getInt("REQUEST_PULL_UP_ONCE") != 1) goto L90;
        FLogger.a.i(ISessionEndPoint.a.b(this), "onShow pull up once , no showing , then hide!");
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "System-pullup-once");
    L90:
        AppHost.Companion r113 = AppHost.a;
        Object r20 = r113.getApplication().getSystemService("display");
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        if (((DisplayManager) r20).getDisplay(0).getRotation() == 0) goto L102;
        IAssistantChatWindow r21 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r21 != null) goto L95;
    L97:
        boolean r22 = false;
    L98:
        if (r22 == true) goto L102;
        aga.j.l(2131911966);
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "System-rotate-display");
    L95:
        if (r21.isWindowMode() != true) goto L97;
        r22 = true;
    L102:
        if (ObricStateService.a.a() == false) goto L105;
        FLogger.a.i(ISessionEndPoint.a.b(this), "doOnShow, isRealtimeCalling, return");
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "System-realtime-calling");
    L105:
        FragmentActivity r114 = r113.a().getCurrentActivity();
        if ((r114 instanceof FragmentActivity) == false) goto L108;
        FragmentActivity r115 = r114;
    L109:
        FLogger r23 = FLogger.a;
        r23.w(ISessionEndPoint.a.b(this), "onShow currentActivity is : " + r115);
        if (r115 == null) goto L114;
        t1a.b r24 = aga.j.g(r115);
        if (r24 == null) goto L114;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r25 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) r24.getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
    L115:
        if (r115 == null) goto L119;
        t1a.b r116 = aga.j.g(r115);
        if (r116 == null) goto L119;
        com.obric.audio.continuous_talk.b r117 = (com.obric.audio.continuous_talk.b) r116.getAbility(com.obric.audio.continuous_talk.b.class);
    L120:
        IAiKeyOperation r26 = bga.b.a();
        if (r26 != null) goto L123;
    L125:
        boolean r27 = false;
    L126:
        IDoraOperation r28 = bga.f.a();
        if (r28 != null) goto L129;
    L131:
        boolean r29 = false;
    L132:
        if (r25 != null) goto L134;
    L136:
        boolean r30 = false;
    L137:
        if (r117 == null) goto L140;
        r5 = r117.u10();
    L140:
        if (r5 != ContinuousTalkStatus.RUNNING) goto L142;
        boolean r118 = true;
    L143:
        if (r27 == true) goto L181;
        if (r29 == true) goto L181;
        if (r30 == true) goto L181;
        if (r118 == true) goto L181;
        if (aga.j.i() == false) goto L153;
        r23.i(ISessionEndPoint.a.b(this), "user guide is showing, ignore");
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "System-user-guiding");
    L153:
        if (com.obric.assistant.voice.n.a == false) goto L157;
        r23.i(ISessionEndPoint.a.b(this), "onShow while vocie enrolling, ignore request");
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "System-voice-enrolling");
    L157:
        if (r10.getBoolean("IGNORE_REQUEST", false) != true) goto L161;
        r23.i(ISessionEndPoint.a.b(this), "onShow ignore request");
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "System-ignore-request");
    L161:
        if (Intrinsics.areEqual("WAKEUP_SOURCE_ON_START_UP", bga.j.a()) == false) goto L165;
        r23.i(ISessionEndPoint.a.b(this), "onShow on start up");
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "System-startup");
    L165:
        if (((Set) aga.c.a.getValue()).contains(bga.j.a()) == true) goto L168;
        r23.w(ISessionEndPoint.a.b(this), "onShow don't wakeup assistant for unsupported source: ".concat(bga.j.a()));
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "System-invalid-request-from");
    L168:
        IAssistantChatWindow r119 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r119 != null) goto L171;
    L173:
        if (r6 == false) goto L179;
        IAssistantChatWindow r120 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r120 == null) goto L178;
        r120.onWakeupBlockedBySystemAlertWindowPermission();
    L178:
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "Blocked-by-system-alert-window-permission");
    L179:
        Lazy r121 = MediaResourceManager.a;
        ((com.larus.media.j0) MediaResourceManager.a.getValue()).getClass();
        MediaResourceManager.g().d = true;
        return TuplesKt.to(ErrorCode.CONTINUE, "");
    L171:
        if (r119.isNewGlobalPanelBlockedByPermission() != true) goto L173;
        r6 = true;
    L181:
        if (r27 == false) goto L183;
        String r122 = "System-aiKeyPressing";
    L188:
        r23.i(ISessionEndPoint.a.b(this), "ai key pressing or chatBottom is in speaking, So ignore .... [detail is : isAiKeyPressing " + r27 + ", isDoraPressing " + r29 + ", isClickTalkSpeaking " + r30 + ", isContinuousTalkRunning " + r118 + ']');
        return TuplesKt.to(ErrorCode.QUIT_SESSION, r122);
    L183:
        if (r29 == false) goto L185;
        r122 = "System-doraPressing";
        goto L188
    L185:
        if (r30 == false) goto L187;
        r122 = "System-clickTalkSpeaking";
        goto L188
    L187:
        r122 = "System-continuousTalkRunning";
        goto L188
    L142:
        r118 = false;
        goto L143
    L134:
        if (r25.m0() != true) goto L136;
        r30 = true;
        goto L137
    L129:
        if (r28.b() != true) goto L131;
        r29 = true;
        goto L132
    L123:
        if (r26.isAiKeyPressing() != true) goto L125;
        r27 = true;
    L119:
        r117 = null;
    L114:
        r25 = null;
        goto L115
    L108:
        r115 = null;
        goto L109
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        r0.L$0 = r10;
        r0.label = 1;
        if (ISessionEndPoint.a.e(this) != r2) goto L17;
        return r2;
    L7:
        r0 = new SystemServiceEndpoint$onSessionProcess$1(this, r11);
        goto L8
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void p(Context r1, Bundle r2) {
        ISessionEndPoint.a.d(this, r1, r2);
    }
}
