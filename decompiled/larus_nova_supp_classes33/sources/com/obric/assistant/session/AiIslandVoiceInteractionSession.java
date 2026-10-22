package com.obric.assistant.session;

import aga.j;
import android.app.Application;
import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Parcelable;
import android.os.Trace;
import android.os.UserHandle;
import android.provider.Settings;
import android.service.voice.VoiceInteractionSession;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import bga.f;
import bga.i;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.audio.flow.client.FlowTtsClientImpl;
import com.larus.bmhome.chat.component.bottom.core.speaker.l;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL;
import com.obric.aiagent.product.platform.api.pocketmode.PocketModeDetector;
import com.obric.assistant.activation.presentation.contract.ObricListeningViewState;
import com.obric.assistant.activation.presentation.contract.ipc.VoiceInteractionSessionController;
import com.obric.assistant.activation.presentation.runtime.manager.ObricListeningMainProcessManager;
import com.obric.assistant.automic.IObricAutoMicService;
import com.obric.assistant.chat.IObricChatContextService;
import com.obric.assistant.chat.ObricChatContextServiceDelegate;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.multiuser.api.IObricMultiUserService;
import com.obric.assistant.session.bean.ErrorCode;
import com.obric.assistant.session.endpoint.AiKeySessionEndpoint;
import com.obric.assistant.session.model.IAiKeyOperation;
import com.obric.assistant.session.model.IAutoMicOperation;
import com.obric.assistant.session.model.IDoraOperation;
import com.obric.assistant.session.model.ISessionMaintaining;
import com.obric.assistant.session.singleton.AiKeyActionDetector;
import com.obric.assistant.session.singleton.DoraWakeupDetector;
import com.obric.assistant.session.singleton.SleepModeHelper$init$1;
import com.obric.assistant.session.singleton.e;
import com.obric.assistant.session.singleton.t;
import com.obric.assistant.session.singleton.u;
import com.obric.assistant.state.api.multitask.producer.IObricWakeupStateProducerService;
import com.obric.assistant.t1;
import com.obric.assistant.utils.o;
import com.obric.assistant.voice.ContentScene;
import com.obric.assistant.voice.ObricVoiceServiceImpl;
import com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import g78.g0;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class AiIslandVoiceInteractionSession extends VoiceInteractionSession implements zaa.a {
    public final AiIslandVoiceInteractionSession$sessionLifecycleOwner$1 a;
    public final CoroutineScope b;
    public final CoroutineScope c;
    public final MutexImpl d;
    public Long e;
    public VoiceInteractionSessionController f;
    public volatile boolean g;
    public final b h;

    public static final class a {
    }

    public static final class b extends CountDownTimer {
        public final /* synthetic */ AiIslandVoiceInteractionSession a;

        @Override // android.os.CountDownTimer
        public final void onTick(long r1) {
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            this.a.g = false;
            FLogger.a.i("AiIslandVoiceInteractionSession", "autoMicCountDownTimer activate Countdown timer onFinish");
        }

        public b(AiIslandVoiceInteractionSession r5) {
            this.a = r5;
            super(400, 200);
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.session.AiIslandVoiceInteractionSession$closeSystemDialogs$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.session.AiIslandVoiceInteractionSession$closeSystemDialogs$1", f = "AiIslandVoiceInteractionSession.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ VoiceInteractionSessionController $controller;
        final /* synthetic */ Long $sessionId;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(VoiceInteractionSessionController r1, Long r2, Continuation<? super AnonymousClass1> r3) {
            this.$controller = r1;
            this.$sessionId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$controller, this.$sessionId, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L18;
            ResultKt.throwOnFailure(r6);
            CoroutineScope r7 = (CoroutineScope) this.L$0;
            VoiceInteractionSessionController r8 = this.$controller;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
            r8.closeSystemDialogs();     // Catch: Throwable -> L7
            Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
        L9:
            Long r1 = this.$sessionId;
            if (Result.isSuccess-impl(r9) == false) goto L12;
            Unit r2 = (Unit) r9;
            FLogger.a.i("AiIslandVoiceInteractionSession", "closeSystemDialogs delegated to real session, id=" + r1);
        L12:
            Long r3 = this.$sessionId;
            Throwable r10 = Result.exceptionOrNull-impl(r9);
            if (r10 == null) goto L16;
            FLogger.a.e("AiIslandVoiceInteractionSession", "closeSystemDialogs delegate failed, id=" + r3, r10);
        L16:
            return Unit.INSTANCE;
        L7:
            th = move-exception;
            Result.Companion r4 = Result.Companion;
            r9 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L9
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onBackPressed() {
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onCancelRequest(VoiceInteractionSession.Request r1) {
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onCloseSystemDialogs() {
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onCreate() {
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onDestroy() {
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onHandleAssist(VoiceInteractionSession.AssistState r2) {
        Intrinsics.checkNotNullParameter(r2, "assistState");
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onHandleScreenshot(Bitmap r1) {
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onHide() {
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onPrepareShow(Bundle r1, int r2) {
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onRequestCommand(VoiceInteractionSession.CommandRequest r1) {
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onRequestConfirmation(VoiceInteractionSession.ConfirmationRequest r1) {
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onRequestPickOption(VoiceInteractionSession.PickOptionRequest r1) {
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void onShow(Bundle r1, int r2) {
    }

    static {
        FLogger r0 = FLogger.a;
        r0.i("AiIslandVoiceInteractionSession", "companion init");
        boolean r1 = u.a;
        boolean r3 = true;
        if (Build.VERSION.SDK_INT < 33) goto L34;
        r0.i("SleepModeHelper", "isDeviceSleeping");     // Catch: Throwable -> L8
        Object r2 = u.b.getValue();     // Catch: Throwable -> L8
        if (r2 == null) goto L10;
        Object r4 = r2.getClass().getMethod("inSleepMode", new Class[0]).invoke(r2, new Object[0]);     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Throwable -> L8
        boolean r5 = ((Boolean) r4).booleanValue();     // Catch: Throwable -> L8
    L11:
        u.a = r5;
        FLogger.a.i("SleepModeHelper", "init, is isDeviceSleeping = " + u.a);
        Application r6 = AppHost.a.getApplication();
        BroadcastReceiver r7 = new SleepModeHelper$init$1();
        IntentFilter r8 = new IntentFilter("com.bytedanceos.action.SLEEP_MODE_CHANGED");
        Handler r13 = t0.b;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L43;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L43:
    L29:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L33;
        ReceiverRegisterCrashOptimizer.registerReceiver(r7, r8, "android.permission.WRITE_SECURE_SETTINGS", r13, 2);
        goto L34
    L33:
        throw e;
    L16:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L18;
    L27:
        r6.registerReceiver(r7, r8, "android.permission.WRITE_SECURE_SETTINGS", r13, 2);     // Catch: Exception -> L29
    L42:
        goto L34
    L18:
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r8) == false) goto L27;
        int r9 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r7, r8, 2, "android.permission.WRITE_SECURE_SETTINGS", r13, 5, r6).result;     // Catch: Exception -> L29
        if (r9 == 1) goto L26;
        if (r9 != 2) goto L23;
        new Intent();     // Catch: Exception -> L29
        goto L42
    L23:
        if (r9 == 3) goto L42;
        r6.registerReceiver(r7, r8, "android.permission.WRITE_SECURE_SETTINGS", r13, 2);     // Catch: Exception -> L29
        goto L42
    L26:
        r6.registerReceiver(r7, r8, "android.permission.WRITE_SECURE_SETTINGS", r13, 2);     // Catch: Exception -> L29
    L10:
        r5 = false;
    L8:
        th = move-exception;
        FLogger.a.e("SleepModeHelper", "inSleepMode error!", th);
    L34:
        AppHost.Companion r10 = AppHost.a;
        Object r11 = r10.getApplication().getSystemService("connectivity");
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ((ConnectivityManager) r11).addDefaultNetworkActiveListener(new t());
        PocketModeDetector.a.init();
        boolean r12 = e.a;
        r10.getApplication().getContentResolver().registerContentObserver(Settings.Secure.getUriFor("lost_mode"), false, e.b);
        if (Settings.Secure.getInt(r10.getApplication().getContentResolver(), "lost_mode", 0) == 1) goto L38;
        r3 = false;
    L38:
        e.a = r3;
        FLogger.a.i("LostModeMonitor", "init lost mode state = " + e.a);
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final View onCreateContentView() {
        FLogger.a.i("AiIslandVoiceInteractionSession", "onCreateContentView: return null as we use WindowHost with TYPE_VOICE_INTERACTION");
        return null;
    }

    @Override // android.service.voice.VoiceInteractionSession
    public final void closeSystemDialogs() {
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == true) goto L5;
    L8:
        Long r0 = this.e;
        VoiceInteractionSessionController r2 = this.f;
        if (r0 == null) goto L14;
        if (r2 == null) goto L14;
        BuildersKt.launch$default(this.c, null, null, new AnonymousClass1(r2, r0, null), 3, null);
        return;
    L14:
        FLogger.a.w("AiIslandVoiceInteractionSession", "closeSystemDialogs skipped, real session unavailable");
        return;
    L5:
        if (t1.a.i() == true) goto L8;
        FLogger.a.i("AiIslandVoiceInteractionSession", "closeSystemDialogs skipped, keyguard locked and locked screen use disabled");
    }

    public AiIslandVoiceInteractionSession(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.a = new AiIslandVoiceInteractionSession$sessionLifecycleOwner$1();
        this.b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.d = kotlinx.coroutines.sync.b.a();
        FLogger.a.i("AiIslandVoiceInteractionSession", "init main-process proxy");
        IAiKeyOperation r5 = bga.b.a();
        if (r5 == null) goto L5;
        AiKeyActionDetector r0 = AiKeyActionDetector.a;
        AiKeySessionEndpoint r6 = r5.action();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "listener");
        AiKeyActionDetector.c = r6;
        ((bba.b) AiKeyActionDetector.e.getValue()).a(Long.valueOf(t1.a.getObricAiKeyConfig().getAiKeyDownTimeout()));
    L5:
        IDoraOperation r7 = f.a();
        if (r7 == null) goto L8;
        DoraWakeupDetector r1 = DoraWakeupDetector.a;
        DoraWakeupDetector.e(r7.action());
    L8:
        Iterator r8 = ((List) com.obric.assistant.session.lifecycle.e.a.getValue()).iterator();
    L10:
        if (r8.hasNext() == false) goto L12;
        ((i) r8.next()).onInit();
        goto L10
    L12:
        this.h = new b(this);
    }

    public final void c(final Bitmap r3) {
        if (r3 != null) goto L5;
        FLogger.a.w("AiIslandVoiceInteractionSession", "ignore null proxy screenshot");
        return;
    L5:
        com.obric.assistant.utils.b.a("onHandleScreenshot", new c(r3));
    }

    public final void e(long r1) {
        h(r1);
    }

    public final void h(long r8) {
        Long r0 = this.e;
        if (r0 != null) goto L6;
    L7:
        FLogger.a.i("AiIslandVoiceInteractionSession", "ignore stale proxy destroy, expected=" + r8 + ", current=" + this.e);
        return;
    L6:
        if (r0.longValue() != r8) goto L7;
        Unit r1 = null;
        this.e = null;
        this.f = null;
        VoiceInteractionSession r2 = ObricVoiceServiceImpl.d;
        Intrinsics.checkNotNullParameter(this, "expected");
        boolean r3 = false;
        if (ObricVoiceServiceImpl.d == this) goto L12;
        boolean r4 = false;
    L13:
        if (r4 == true) goto L15;
    L17:
        FLogger.a.i("AiIslandVoiceInteractionSession", "destroy proxy session, id=" + r8);
        CoroutineScopeKt.cancel$default(this.b, null, 1, null);
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L34
        AiIslandVoiceInteractionSession$sessionLifecycleOwner$1 r10 = this.a;     // Catch: Throwable -> L34
        LifecycleRegistry r11 = r10.a;     // Catch: Throwable -> L34
        if (r11 != null) goto L22;
        r11 = new LifecycleRegistry(r10);     // Catch: Throwable -> L34
        r10.a = r11;     // Catch: Throwable -> L34
    L22:
        if (r11.getCurrentState() == Lifecycle.State.INITIALIZED) goto L24;
        r3 = true;
    L24:
        if (r3 == true) goto L27;
        r10 = null;
    L27:
        if (r10 == null) goto L32;
        LifecycleRegistry r12 = r10.a;     // Catch: Throwable -> L34
        if (r12 != null) goto L31;
        r12 = new LifecycleRegistry(r10);     // Catch: Throwable -> L34
        r10.a = r12;     // Catch: Throwable -> L34
    L31:
        r12.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);     // Catch: Throwable -> L34
        r10.a = null;     // Catch: Throwable -> L34
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L34
    L32:
        Object r13 = Result.constructor-impl(r1);     // Catch: Throwable -> L34
    L37:
        if (Result.exceptionOrNull-impl(r13) == null) goto L39;
        FLogger.a.i("AiIslandVoiceInteractionSession", "onDestroy exception occurs");
    L39:
        Iterator r14 = ((List) com.obric.assistant.session.lifecycle.e.a.getValue()).iterator();
    L41:
        if (r14.hasNext() == false) goto L43;
        ((i) r14.next()).onDestroy();
        goto L41
    L43:
        return;
    L34:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L37
    L15:
        if (sha.b.a() == false) goto L17;
        ObricListeningMainProcessManager r5 = ObricListeningMainProcessManager.a;
        ObricListeningViewState r6 = ObricListeningViewState.d;
        r5.getClass();
        ObricListeningMainProcessManager.p(r6);
        goto L17
    L12:
        ObricVoiceServiceImpl.d = null;
        r4 = true;
        goto L13
    }

    public static void j(ContentScene r11, Parcelable r12) {
        Intrinsics.checkNotNullParameter(r11, "scene");
        maa.e r0 = j.e();
        ObricChatContextServiceDelegate r1 = ObricChatContextServiceDelegate.b;
        t1a.b r2 = IObricChatContextService.a.a(r1);
        if (r2 == null) goto L5;
        l r3 = (l) r2.getAbility(l.class);
    L6:
        t1a.b r4 = IObricChatContextService.a.a(r1);
        if (r4 == null) goto L9;
        com.obric.audio.continuous_talk.b r5 = (com.obric.audio.continuous_talk.b) r4.getAbility(com.obric.audio.continuous_talk.b.class);
    L10:
        t1a.b r6 = IObricChatContextService.a.a(r1);
        if (r6 == null) goto L13;
        com.obric.audio.continuous_talk.c r7 = (com.obric.audio.continuous_talk.c) r6.getAbility(com.obric.audio.continuous_talk.c.class);
    L14:
        PlayStateEnum r8 = ((FlowTtsClientImpl) g0.a.getValue()).n;
        FLogger r9 = FLogger.a;
        StringBuilder r10 = new StringBuilder("tryInterruptAssistant from scene ");
        r10.append(r11);
        r10.append(" with data ");
        r10.append(r12);
        r10.append(" using clickTalkAbility ");
        r10.append(r0);
        r10.append(" talking ");
        if (r0 == null) goto L17;
        Boolean r13 = Boolean.valueOf(r0.x3());
    L18:
        r10.append(r13);
        r10.append(" realActive ");
        if (r0 == null) goto L21;
        Boolean r14 = Boolean.valueOf(r0.gn());
    L22:
        r10.append(r14);
        r10.append(" and pressTalkAbility ");
        r10.append(r3);
        r10.append(" talking ");
        if (r3 == null) goto L25;
        Boolean r15 = Boolean.valueOf(r3.m0());
    L26:
        r10.append(r15);
        r10.append(" and continuousTalkAbility ");
        r10.append(r5);
        r10.append(" talking ");
        if (r5 == null) goto L29;
        Boolean r16 = Boolean.valueOf(r5.m0());
    L30:
        r10.append(r16);
        r10.append(" and ttsState ");
        r10.append(r8);
        r9.i("AiIslandVoiceInteractionSession", r10.toString());
        if (r8 != PlayStateEnum.PLAY_STATE_STOPPED) goto L33;
    L35:
        boolean r17 = false;
        if (r0 != null) goto L38;
    L40:
        boolean r18 = false;
    L41:
        if (r18 == false) goto L43;
        r9.i("AiIslandVoiceInteractionSession", "tryInterruptAssistant, interrupt clickTalkAbility");
        maa.e.a.a(r0, null, null, false, 7);
    L43:
        if (r3 != null) goto L45;
    L47:
        boolean r19 = false;
    L48:
        if (r19 == false) goto L50;
        r9.i("AiIslandVoiceInteractionSession", "tryInterruptAssistant, interrupt pressTalkAbility");
        AudioServiceDelegate.a.L().a(false);
        r3.A9();
    L50:
        if (r5 != null) goto L52;
    L54:
        if (r17 == false) goto L59;
        r9.i("AiIslandVoiceInteractionSession", "tryInterruptAssistant, interrupt continuousTalkUIAbility");
        if (r7 == null) goto L60;
        com.obric.audio.continuous_talk.c.a.a(r7, null, null, false, true, 7);
        return;
    L60:
        return;
    L59:
        return;
    L52:
        if (r5.m0() != true) goto L54;
        r17 = true;
        goto L54
    L45:
        if (r3.m0() != true) goto L47;
        r19 = true;
        goto L48
    L38:
        if (r0.gn() != true) goto L40;
        r18 = true;
        goto L41
    L33:
        if (r8 == PlayStateEnum.PLAY_STATE_FAIL) goto L35;
        j.m();
        goto L35
    L29:
        r16 = null;
        goto L30
    L25:
        r15 = null;
        goto L26
    L21:
        r14 = null;
        goto L22
    L17:
        r13 = null;
        goto L18
    L13:
        r7 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void b(long r7, VoiceInteractionSessionController r9) {
        Intrinsics.checkNotNullParameter(r9, "controller");
        Long r0 = this.e;
        if (r0 != null) goto L6;
    L8:
        Long r1 = this.e;
        if (r1 == null) goto L11;
        long r2 = r1.longValue();
        FLogger.a.w("AiIslandVoiceInteractionSession", "replace active proxy session, old=" + r2 + ", new=" + r7);
        h(r2);
    L11:
        this.e = Long.valueOf(r7);
        this.f = r9;
        FLogger.a.i("AiIslandVoiceInteractionSession", "create proxy session: " + this + ", id=" + r7);
        AiIslandVoiceInteractionSession$sessionLifecycleOwner$1 r8 = this.a;
        LifecycleRegistry r10 = r8.a;
        if (r10 != null) goto L14;
        r10 = new LifecycleRegistry(r8);
        r8.a = r10;
    L14:
        r10.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        ISessionMaintaining r11 = bga.j.b();
        if (r11 == null) goto L17;
        r11.t(getContext(), this);
    L17:
        Iterator r12 = ((List) com.obric.assistant.session.lifecycle.e.a.getValue()).iterator();
    L19:
        if (r12.hasNext() == false) goto L21;
        ((i) r12.next()).a(getContext());
        goto L19
    L21:
        VoiceInteractionSession r13 = ObricVoiceServiceImpl.d;
        Intrinsics.checkNotNullParameter(this, "newSession");
        ObricVoiceServiceImpl.d = this;
        FLogger r14 = FLogger.a;
        StringBuilder r15 = new StringBuilder("onCreate user info --> multisv ");
        IObricMultiUserService.a.getClass();
        r15.append(IObricMultiUserService.a.a());
        r15.append(" uid : ");
        IObricMultiUserService r16 = IObricMultiUserService.a.a();
        String r3 = null;
        if (r16 == null) goto L24;
        String r17 = Integer.valueOf(r16.c()).toString();
    L25:
        r15.append(com.obric.assistant.utils.j.d(r17));
        r15.append(" mainUser? ");
        IObricMultiUserService r18 = IObricMultiUserService.a.a();
        if (r18 == null) goto L28;
        Boolean r19 = Boolean.valueOf(r18.a());
    L29:
        r15.append(r19);
        r15.append(" userHandle ");
        IObricMultiUserService r20 = IObricMultiUserService.a.a();
        if (r20 == null) goto L34;
        UserHandle r21 = r20.b();
        if (r21 == null) goto L34;
        r3 = r21.toString();
    L34:
        r15.append(com.obric.assistant.utils.j.d(r3));
        r14.i("AiIslandVoiceInteractionSession", r15.toString());
        return;
    L28:
        r19 = null;
        goto L29
    L24:
        r17 = null;
        goto L25
    L6:
        if (r0.longValue() != r7) goto L8;
        this.f = r9;
        FLogger.a.i("AiIslandVoiceInteractionSession", "refresh real session controller, id=" + r7);
    }

    public final void d(Bundle r2, int r3) {
        if (this.e != null) goto L6;
        FLogger.a.w("AiIslandVoiceInteractionSession", "drop onProxyShow without real session");
        return;
    L6:
        Trace.beginSection("ObricAssistant onShow");
        i(r2, r3);     // Catch: Throwable -> L12
        Trace.endSection();
        IAgentVoiceInteractionIDL r4 = com.obric.aiagent.assistant.idl.u.a(Reflection.getOrCreateKotlinClass(IAgentVoiceInteractionIDL.class));
        if (r4 == null) goto L19;
        r4.onHide();
        return;
    L19:
        return;
    L12:
        th = move-exception;
        Trace.endSection();
        IAgentVoiceInteractionIDL r5 = com.obric.aiagent.assistant.idl.u.a(Reflection.getOrCreateKotlinClass(IAgentVoiceInteractionIDL.class));
        if (r5 == null) goto L16;
        r5.onHide();
    L16:
        throw th;
    }

    public final void i(Bundle r14, int r15) {
        final com.obric.assistant.common.utils.i.a r0 = com.obric.assistant.common.utils.i.a("ObricAiSession.onShow");
        if (r14 != null) goto L14;
        o.a.getClass();
        String r16 = "VOICE";
        if (r14 == null) goto L10;
        String r17 = r14.getString("sessionName", "VOICE");
        if (r17 == null) goto L10;
        r16 = r17;
    L10:
        o.b("do_show_failed", "args_null", r16);
        if (r0 == null) goto L16;
        r0.a();
        return;
    L16:
        return;
    L14:
        FLogger.a.i("AiIslandVoiceInteractionSession", "onShow , Now let's check the wakeup source from the args , detail is " + r14);
        final com.obric.assistant.common.utils.i.a r1 = com.obric.assistant.common.utils.i.a("ObricAiSession.onShow.waitLaunch");
        BuildersKt.launch$default(this.b, null, null, new AiIslandVoiceInteractionSession$doOnShow$job$1(r1, this, r14, r15, null), 3, null).invokeOnCompletion(new com.obric.assistant.session.a(r1, r0));
    }

    public final boolean k(ContentScene r13, Parcelable r14) {
        Intrinsics.checkNotNullParameter(r13, "scene");
        maa.e r0 = j.e();
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("tryTurnOnMicUsingClickTalk from ");
        r2.append(r13);
        r2.append(" with data ");
        r2.append(r14);
        r2.append(" and ability ");
        r2.append(r0);
        r2.append(" , talking ");
        if (r0 == null) goto L5;
        Boolean r4 = Boolean.valueOf(r0.x3());
    L6:
        r2.append(r4);
        r1.i("AiIslandVoiceInteractionSession", r2.toString());
        if (r0 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L14;
        return false;
    L14:
        IAutoMicOperation r5 = bga.e.a();
        if (r5 == null) goto L17;
        r5.a(r13, r14);
    L17:
        IObricAutoMicService.a.getClass();
        IObricAutoMicService r15 = IObricAutoMicService.a.a();
        if (r15 == null) goto L20;
        r15.l(r13);
    L20:
        CoWakeupApi r16 = uha.a.a();
        if (r16 != null) goto L23;
    L25:
        boolean r17 = false;
    L26:
        if (r17 == true) goto L28;
        i(com.larus.utils.f.c(new Pair[]{TuplesKt.to("REQUEST_FROM", IInteractionStateService$Companion.WAKEUP_SOURCE_AUTO_MIC)}), 0);
        return true;
    L28:
        if (this.g == false) goto L31;
        r1.i("AiIslandVoiceInteractionSession", "tryTurnOnMicUsingClickTalk, already started, just ignore");
        return false;
    L31:
        this.h.start();
        r1.i("AiIslandVoiceInteractionSession", "cleanup Countdown timer onStart");
        this.g = true;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AiIslandVoiceInteractionSession$tryTurnOnMicUsingClickTalk$1(null), 3, null);
        return true;
    L23:
        if (r16.b() != true) goto L25;
        r17 = true;
        goto L26
    L9:
        if (r0.x3() != true) goto L11;
        r3 = true;
        goto L12
    L5:
        r4 = null;
        goto L6
    }

    public static final void f(AiIslandVoiceInteractionSession r2, Bundle r3, ErrorCode r4) {
        r2.getClass();
        if (r4 == ErrorCode.QUIT_SESSION) goto L10;
        if (r4 == ErrorCode.ONLY_END) goto L10;
        if (r4 == ErrorCode.NA) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(r3.getString("REQUEST_FROM"), "VOICE_ASSIST") == false) goto L23;
        String r5 = r3.getString("sessionName");
        if (Intrinsics.areEqual(r5, "VOICE") == true) goto L18;
        if (Intrinsics.areEqual(r5, "BREATH") == true) goto L18;
        return;
    L18:
        if (r3.getInt("obric_listening_show_owner", -1) != 1) goto L25;
        FLogger.a.i("AiIslandVoiceInteractionSession", "finish rejected voice wakeup presentation, sessionName=" + r5 + ", errorCode=" + r4);
        int r6 = sha.b.a;
        ObricListeningMainProcessManager r7 = ObricListeningMainProcessManager.a;
        ObricListeningViewState r8 = ObricListeningViewState.d;
        r7.getClass();
        ObricListeningMainProcessManager.p(r8);
        return;
    L25:
        return;
    }

    public static final void g(AiIslandVoiceInteractionSession r5, Bundle r6, int r7) {
        r5.getClass();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        IObricWakeupStateProducerService r1 = (IObricWakeupStateProducerService) ServiceManager.get().getService(IObricWakeupStateProducerService.class);     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        String r2 = String.valueOf(r6.getInt("wakeupId", -1));     // Catch: Throwable -> L12
        String r3 = r6.getString("REQUEST_FROM");     // Catch: Throwable -> L12
        Pair[] r4 = new Pair[2];     // Catch: Throwable -> L12
        r4[0] = TuplesKt.to("show_flags", Integer.valueOf(r7));     // Catch: Throwable -> L12
        String r8 = r6.getString("REQUEST_FROM");     // Catch: Throwable -> L12
        if (r8 != null) goto L8;
        r8 = "";
    L8:
        r4[1] = TuplesKt.to("request_from", r8);     // Catch: Throwable -> L12
        r1.a(r2, r3, MapsKt.mapOf(r4));     // Catch: Throwable -> L12
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L12
    L14:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L20;
        FLogger.a.e("AiIslandVoiceInteractionSession", "dispatchWakeupState failed", r11);
        return;
    L20:
        return;
    L9:
        r9 = null;
    L12:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public final void a(int r6, int r7, boolean r8, final AssistStructure r9, final AssistContent r10) {
        LinkedHashSet r0 = new LinkedHashSet();
        boolean r1 = false;
        if (r9 == null) goto L7;
        int r2 = r9.getWindowNodeCount();
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L7;
        r0.add(Integer.valueOf(r9.getWindowNodeAt(r3).getDisplayId()));
        r3 = r3 + 1;
    L7:
        if (r7 != 0) goto L9;
    L13:
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("onHandleAssist index = ");
        r5.append(r6);
        r5.append(", count = ");
        r5.append(r7);
        r5.append(", isFocused = ");
        r5.append(r8);
        r5.append(", activityComponent = ");
        if (r9 == null) goto L16;
        ComponentName r11 = r9.getActivityComponent();
    L17:
        r5.append(r11);
        r5.append(", displayIds = ");
        r5.append(r0);
        r5.append(", shouldForwardToAgent = ");
        r5.append(r1);
        r4.i("AiIslandVoiceInteractionSession", r5.toString());
        if (r1 == false) goto L22;
        com.obric.assistant.utils.b.a("onHandleAssist", new com.obric.assistant.session.b(r9, r10));
        return;
    L22:
        return;
    L16:
        r11 = null;
        goto L17
    L9:
        if (r0.isEmpty() == false) goto L11;
    L12:
        r1 = true;
        goto L13
    L11:
        if (r0.contains(0) == false) goto L13;
        goto L12
    }
}
