package com.obric.assistant.session.endpoint;

import android.app.Application;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.product.platform.api.pocketmode.PocketModeDetector;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.multiuser.api.IObricMultiUserService;
import com.obric.assistant.session.bean.ErrorCode;
import com.obric.assistant.session.model.IDoraOperation;
import com.obric.assistant.session.model.ISessionEndPoint;
import com.obric.assistant.session.model.IVoiceWakeupOperation;
import com.obric.assistant.spi.audio.ObricBackTraceLogDelegate;
import com.obric.assistant.spi.audio.ObricWakeupAudioCaptureDelegate;
import com.obric.assistant.spi.audio.ObricWakeupTruthUploadDelegate;
import com.obric.assistant.spi.audio.WakeupAudioCaptureTriggerType;
import com.obric.assistant.spi.wakeup.ObricOneshotDelegate;
import com.obric.assistant.spi.wakeup.WakeupLatencyTrackDelegate;
import com.obric.assistant.t1;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi;
import com.obric.assistant.wakeup.statistics.api.IWakeupStatisticsAPI;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a2\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0014H\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\b\u0010 \u001a\u00020\bH\u0016J\u0012\u0010!\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010\"\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%H\u0002J\f\u0010,\u001a\u00020\u0014*\u00020+H\u0002J\u0010\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u001bH\u0016J\u0013\u0010/\u001a\u00020\u001c*\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u00100J\f\u0010/\u001a\u00020\u001c*\u00020\u001cH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/assistant/session/endpoint/VoiceWakeupSessionEndpoint;", "Lcom/obric/assistant/session/model/ISessionEndPoint;", "Lcom/obric/assistant/session/model/IVoiceWakeupOperation;", "<init>", "()V", "isHandlingActivateTimerRunning", "", "uniqueWakeupId", "", "shouldNotifyVoiceWakeupGenerated", "notificationScope", "Lkotlinx/coroutines/CoroutineScope;", "prepareOrder", "getPrepareOrder", "()I", "processOrder", "getProcessOrder", "pocketModeDetector", "Lcom/obric/aiagent/product/platform/api/pocketmode/PocketModeDetector;", "onSessionPrepared", "", "context", "Landroid/content/Context;", "args", "Landroid/os/Bundle;", "onSessionProcess", "Lkotlin/Pair;", "Lcom/obric/assistant/session/bean/ErrorCode;", "", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearOneshotTask", "clearOneshotPipe", "getWakeupId", "trackWakeupS3", "handleOneshotParams", "notifyBreathCaptureInteractionStartIfNeeded", "interactionAudioStartTimeMs", "", "mainHandler", "Landroid/os/Handler;", "delayedClearOneshotPipe", "Ljava/lang/Runnable;", "countDownTimer", "Landroid/os/CountDownTimer;", "go", "onSessionCompleted", "code", "toLogTail", "(Ljava/lang/Integer;)Ljava/lang/String;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceWakeupSessionEndpoint implements ISessionEndPoint, IVoiceWakeupOperation {
    public static final /* synthetic */ int i = 0;
    public volatile boolean a;
    public volatile int b;
    public volatile boolean c;
    public final CoroutineScope d;
    public final PocketModeDetector e;
    public final Handler f;
    public final w0 g;
    public final c h;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ErrorCode.values().length];
            r0[ErrorCode.QUIT_SESSION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ErrorCode.ONLY_END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ErrorCode.END_ON_SHOW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ErrorCode.LAUNCH_ASSISTANT_DIRECTLY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class c extends CountDownTimer {
        public final /* synthetic */ VoiceWakeupSessionEndpoint a;

        @Override // android.os.CountDownTimer
        public final void onTick(long r1) {
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            this.a.a = false;
            FLogger r0 = FLogger.a;
            VoiceWakeupSessionEndpoint r1 = this.a;
            r1.getClass();
            r0.i(ISessionEndPoint.a.b(r1), "activate Countdown timer onFinish");
        }

        public c(VoiceWakeupSessionEndpoint r5) {
            this.a = r5;
            super(800, 200);
        }
    }

    static {
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int f() {
        return -50;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int h() {
        return 20;
    }

    @Override // com.obric.assistant.session.model.IVoiceWakeupOperation
    public final void a() {
        FLogger.a.i(ISessionEndPoint.a.b(this), "clearOneshotTask executes now !");
        wna.a.a();
        wna.a.d();
        ObricOneshotDelegate.b.g();
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTagName() {
        return "VoiceWakeupSessionEndpoint";
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.obric.assistant.session.endpoint.w0] */
    public VoiceWakeupSessionEndpoint() {
        this.b = -1;
        this.d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.e = PocketModeDetector.a;
        this.f = new Handler(Looper.getMainLooper());
        this.g = new w0(this);
        this.h = new c(this);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public Context getContext() {
        return ISessionEndPoint.a.getContext(this);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTAG() {
        return ISessionEndPoint.a.b(this);
    }

    @Override // com.obric.assistant.session.model.IVoiceWakeupOperation
    public final int b() {
        return this.b;
    }

    public static String c(Integer r3) {
        if (r3 == null) goto L13;
        String r4 = r3.toString();
        if (r4 == null) goto L13;
        if (r4.length() != 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        String r5 = "";
    L14:
        if (r5 != null) goto L17;
        return "";
    L17:
        return r5;
    L12:
        r5 = "***" + StringsKt.takeLast(r4, 4);
        goto L14
    L9:
        r1 = false;
    L13:
        r5 = null;
        goto L14
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void n(ErrorCode r10) {
        Intrinsics.checkNotNullParameter(r10, "code");
        FLogger r0 = FLogger.a;
        r0.i(ISessionEndPoint.a.b(this), "onSessionCompleted " + r10 + " requestFrom " + bga.j.a());
        if (Intrinsics.areEqual(bga.j.a(), IInteractionStateService$Companion.WAKEUP_SOURCE_VOICE) == false) goto L6;
        this.f.removeCallbacks(this.g);
    L6:
        if (r10 == ErrorCode.END_ON_SHOW) goto L8;
    L10:
        int r11 = b.a[r10.ordinal()];
        if (r11 == 1) goto L23;
        if (r11 == 2) goto L20;
        if (r11 == 3) goto L20;
        if (r11 == 4) goto L20;
        return;
    L20:
        if (Intrinsics.areEqual(bga.j.a(), IInteractionStateService$Companion.WAKEUP_SOURCE_VOICE) == false) goto L26;
        r0.i(ISessionEndPoint.a.b(this), "clearOneshotPipe");
        this.f.postDelayed(this.g, 0);
        return;
    L26:
        return;
    L23:
        if (Intrinsics.areEqual(bga.j.a(), IInteractionStateService$Companion.WAKEUP_SOURCE_VOICE) == false) goto L28;
        r0.i(ISessionEndPoint.a.b(this), "clearOneshotTask");
        a();
        return;
    L28:
        return;
    L8:
        if (this.c == false) goto L10;
        this.c = false;
        BuildersKt.launch$default(this.d, null, null, new VoiceWakeupSessionEndpoint$onSessionCompleted$1(null), 3, null);
        goto L10
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final Object d(Bundle r48, Continuation<? super Pair<? extends ErrorCode, String>> r49) {
        if ((r49 instanceof VoiceWakeupSessionEndpoint$onSessionProcess$1) == false) goto L7;
        VoiceWakeupSessionEndpoint$onSessionProcess$1 r2 = (VoiceWakeupSessionEndpoint$onSessionProcess$1) r49;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        ResultKt.throwOnFailure(r0);
        Object r22 = IInteractionStateService$Companion.WAKE_UP_SOURCE_DORA_VOICE_WAKEUP;
        Object r19 = "";
    L254:
        if (((Boolean) r0).booleanValue() == true) goto L256;
        boolean r1 = true;
    L258:
        if (Intrinsics.areEqual(bga.j.c(), "VOICE") == false) goto L260;
        ObricWakeupTruthUploadDelegate.b.d(this.b, r1);
    L260:
        if (r1 == false) goto L264;
        this.e.f(false, AppHost.a.a().isAppBackground(), new x0());
        FLogger.a.i(ISessionEndPoint.a.b(this), "onSessionProcess, return because in pocket mode");
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "Voice-in-pocket-mode");
    L264:
        if (Intrinsics.areEqual(bga.j.a(), IInteractionStateService$Companion.WAKEUP_SOURCE_VOICE) == false) goto L266;
    L269:
        boolean r6 = true;
    L270:
        this.c = r6;
        return TuplesKt.to(ErrorCode.CONTINUE, r19);
    L266:
        if (Intrinsics.areEqual(bga.j.a(), r22) == true) goto L269;
        r6 = false;
    L256:
        r1 = false;
        goto L258
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Bundle r7 = (Bundle) r2.L$0;
        ResultKt.throwOnFailure(r0);
    L20:
        Application r12 = AppHost.a.getApplication();
        IWakeupStatisticsAPI r8 = wha.a.a();
        if (r8 == null) goto L24;
        r8.clear();
    L24:
        if (r7 == null) goto L26;
        long r15 = r7.getLong("REQUEST_TIME");
    L27:
        if (r7 == null) goto L29;
        long r9 = r7.getLong("REQUEST_TIME");
    L30:
        long r10 = System.currentTimeMillis();
        if (r9 <= 0) goto L34;
        WakeupLatencyTrackDelegate r11 = WakeupLatencyTrackDelegate.b;
        r11.d(bga.j.a(), bga.j.c(), r9);
        r11.b(r10);
    L34:
        if (Intrinsics.areEqual(bga.j.a(), IInteractionStateService$Companion.WAKEUP_SOURCE_VOICE) == true) goto L37;
    L35:
        int r13 = -1;
    L48:
        FLogger.a.i(ISessionEndPoint.a.b(this), "onShow handle oneshot params ---> start! ");
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L51
        ObricBackTraceLogDelegate.b.b(r7.getInt("backtrace_history_length", 0));     // Catch: Throwable -> L51
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L51
    L54:
        if (r7 != null) goto L57;
        Object r16 = IInteractionStateService$Companion.WAKE_UP_SOURCE_DORA_VOICE_WAKEUP;
    L60:
        r22 = r16;
        r19 = "";
        Application r17 = r12;
        Object r410 = r4;
    L91:
        int r18 = r7.getInt("userHandleId", 0);
        IObricMultiUserService.a.getClass();
        IObricMultiUserService r20 = IObricMultiUserService.a.a();
        Unit r21 = null;
        if (r20 == null) goto L94;
        Integer r23 = Boxing.boxInt(r20.c());
    L95:
        FLogger r24 = FLogger.a;
        r24.i(ISessionEndPoint.a.b(this), "onShow check userhandle given " + c(Boxing.boxInt(r18)) + " and current " + c(r23) + " requestFrom " + bga.j.a());
        if (Intrinsics.areEqual(bga.j.a(), IInteractionStateService$Companion.WAKEUP_SOURCE_VOICE) == false) goto L104;
        if (r23 != null) goto L100;
    L101:
        r24.e(ISessionEndPoint.a.b(this), "onShow bad uid givenUid : " + c(Boxing.boxInt(r18)) + " myID : " + c(r23));
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "Voice-wrong-uid");
    L100:
        if (r18 != r23.intValue()) goto L101;
    L104:
        if (Intrinsics.areEqual(bga.j.a(), IInteractionStateService$Companion.WAKEUP_SOURCE_VOICE) == false) goto L145;
        IDoraService r25 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r25 == null) goto L110;
        DeviceService r26 = r25.device();
        if (r26 == null) goto L110;
        boolean r27 = r26.J();
    L111:
        if (r25 == null) goto L113;
        boolean r28 = r25.b();
    L114:
        if (r25 == null) goto L118;
        DeviceService r29 = r25.device();
        if (r29 == null) goto L118;
        boolean r30 = r29.M();
    L119:
        if (r30 == false) goto L125;
        if (r28 == true) goto L122;
    L124:
        boolean r31 = false;
    L126:
        r24.i(ISessionEndPoint.a.b(this), "from voice wakeup and dora state is  connect ? " + r27 + " switch " + r28 + ", suppressForDora " + r31);
        IDoraOperation r32 = bga.f.a();
        if (r32 == null) goto L129;
        boolean r33 = r32.c();
    L130:
        if (r33 == true) goto L145;
        if (r27 == false) goto L145;
        if (r31 == false) goto L145;
        if (Intrinsics.areEqual(bga.j.c(), "BREATH") == true) goto L145;
        r24.e(ISessionEndPoint.a.b(this), "onShow return caused by the dora is online  ,but the interactor is not working correctly");
        CoWakeupApi r34 = uha.a.a();     // Catch: Throwable -> L141
        if (r34 == null) goto L139;
        r34.reload();     // Catch: Throwable -> L141
        r21 = Unit.INSTANCE;     // Catch: Throwable -> L141
    L139:
        Result.constructor-impl(r21);     // Catch: Throwable -> L141
    L143:
        com.obric.assistant.utils.o.a.getClass();
        com.obric.assistant.utils.o.c(r7, "interactor not working", "Voice-sync-error");
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "Voice-sync-error");
    L141:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L143
    L129:
        r33 = false;
        goto L130
    L122:
        if (r25.device().S() == false) goto L124;
        r31 = true;
        goto L126
    L125:
        r31 = r28;
    L118:
        r30 = false;
        goto L119
    L113:
        r28 = false;
    L110:
        r27 = false;
    L145:
        int r36 = 2131911950;
        if (CollectionsKt.listOf(new Integer[]{Boxing.boxInt(2), Boxing.boxInt(1), Boxing.boxInt(3)}).contains(Boxing.boxInt(ISessionEndPoint.a.a().getMode())) == false) goto L183;
        boolean r37 = Intrinsics.areEqual(bga.j.c(), "VOICE");
        if (ISessionEndPoint.a.a().getMode() == 2) goto L153;
        int r110 = 1;
        if (ISessionEndPoint.a.a().getMode() == 1) goto L154;
        boolean r111 = false;
    L155:
        int r112 = ISessionEndPoint.a.a().getMode();
        if (r112 == r110) goto L167;
        if (r112 == 2) goto L165;
        if (r112 == 3) goto L162;
    L169:
        boolean r113 = false;
    L171:
        if (r37 == false) goto L175;
        if (r111 == false) goto L175;
        if (r113 == false) goto L175;
        r24.i(ISessionEndPoint.a.b(this), "onSessionProcess, bypass call/ringtone intercept for voice wakeup, mode=" + ISessionEndPoint.a.a().getMode() + ", rom concurrent record supported");
    L175:
        com.obric.assistant.utils.o r38 = com.obric.assistant.utils.o.a;
        String r39 = "Voice-mic-in-use-calling: " + ISessionEndPoint.a.a().getMode();
        r38.getClass();
        com.obric.assistant.utils.o.c(r7, "imic_in_use", r39);
        r24.i(ISessionEndPoint.a.b(this), "onSessionProcess, return because mode=" + ISessionEndPoint.a.a().getMode());
        if (r37 == false) goto L181;
        if (r113 == false) goto L179;
    L180:
        r36 = 2131911952;
        goto L181
    L179:
        if (ISessionEndPoint.a.a().getMode() == 3) goto L180;
    L181:
        aga.j.l(r36);
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "Voice-mic-in-use-calling");
    L162:
        if (com.obric.assistant.common.utils.y.f() == false) goto L164;
        r24.i("RomWakeupOptimizeUtils", "isSupportVoipCallOpt skipped: bluetooth connected but concurrent btmic not supported");
        goto L169
    L164:
        r113 = com.obric.assistant.common.utils.y.i(com.obric.assistant.common.utils.y.c());
        goto L171
    L165:
        r113 = com.obric.assistant.common.utils.y.h();
        goto L171
    L167:
        if (com.obric.assistant.common.utils.y.f() == false) goto L170;
        r24.i("RomWakeupOptimizeUtils", "isSupportMicInUseOpt skipped: bluetooth connected but concurrent btmic not supported");
        goto L169
    L170:
        r113 = com.obric.assistant.common.utils.y.g(com.obric.assistant.common.utils.y.c());
    L154:
        r111 = true;
        goto L155
    L153:
        r110 = 1;
    L183:
        List r40 = com.obric.assistant.common.utils.p.b(r17);
        Application r41 = r17;
        if (com.obric.assistant.common.utils.p.f(r41, r40) == false) goto L212;
        if (Intrinsics.areEqual(bga.j.c(), "BREATH") == true) goto L188;
    L191:
        com.obric.assistant.utils.o.a.getClass();
        com.obric.assistant.utils.o.c(r7, "mic_in_use", "Voice-mic-in-use-common");
        if (NetworkUtils.isNetworkAvailable(r41) == true) goto L194;
        r36 = 2131908080;
    L209:
        aga.j.l(r36);
        FLogger.a.i(ISessionEndPoint.a.b(this), "onSessionProcess, return because mic in use");
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "Voice-mic-in-use-common");
    L194:
        Intrinsics.checkNotNullParameter(r40, "micInUsePkgNames");
        ArrayList r42 = (ArrayList) r40;
        if (r42.isEmpty() == true) goto L203;
        Iterator r43 = r42.iterator();
    L199:
        if (r43.hasNext() == false) goto L203;
        if (com.obric.assistant.common.utils.p.a.contains((String) r43.next()) == false) goto L199;
        boolean r44 = true;
    L204:
        if (r44 == false) goto L207;
        r36 = 2131911951;
        goto L209
    L207:
        if (Intrinsics.areEqual(bga.j.c(), "VOICE") == false) goto L209;
        r36 = 2131911952;
    L203:
        r44 = false;
        goto L204
    L188:
        if (com.obric.assistant.common.utils.p.g() == false) goto L191;
        com.obric.assistant.utils.o.a.getClass();
        com.obric.assistant.utils.o.c(r7, "mic_in_use", "Voice-mic-in-use-and-breath");
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "Voice-mic-in-use-and-breath");
    L212:
        if (this.a == false) goto L215;
        r24.w(ISessionEndPoint.a.b(this), "an activating action is running , wait about 1s to try again");
        com.obric.assistant.utils.o.a.getClass();
        com.obric.assistant.utils.o.c(r7, "timer_running", "Voice-timer-running");
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "Voice-timer-running");
    L215:
        r24.w(ISessionEndPoint.a.b(this), "ready for activating....");
        this.h.start();
        r24.i(ISessionEndPoint.a.b(this), "activate Countdown timer onStart");
        this.a = true;
        FragmentActivity r45 = AppHost.a.a().getCurrentActivity();
        if ((r45 instanceof FragmentActivity) == false) goto L218;
        FragmentActivity r46 = r45;
    L219:
        r24.w(ISessionEndPoint.a.b(this), "onShow currentActivity is : " + r46);
        if (r46 == null) goto L224;
        t1a.b r47 = aga.j.g(r46);
        if (r47 == null) goto L224;
        maa.e r50 = (maa.e) r47.getAbility(maa.e.class);
    L225:
        if (r50 == null) goto L235;
        String r51 = ISessionEndPoint.a.b(this);
        StringBuilder r52 = new StringBuilder("checking if in clicktalking ");
        r52.append(r50.x3());
        r52.append(" , is oneshot ? ");
        ConcurrentMap r53 = wna.a.a;
        r52.append(!((ConcurrentHashMap) r53).isEmpty());
        r24.w(r51, r52.toString());
        if (Intrinsics.areEqual(bga.j.a(), IInteractionStateService$Companion.WAKEUP_SOURCE_VOICE) == false) goto L235;
        if (r50.x3() == false) goto L235;
        if ((!((ConcurrentHashMap) r53).isEmpty()) == false) goto L235;
        r24.w(ISessionEndPoint.a.b(this), "re-wakeup when the session is click talking , not handle any more");
        return TuplesKt.to(ErrorCode.QUIT_SESSION, "Voice-re-wakeup-when-sessioning");
    L235:
        if (Intrinsics.areEqual(bga.j.c(), "VOICE") == false) goto L248;
        if (t1.a.r1() == true) goto L248;
        IBluetoothHeadSetAPI r54 = tha.c.a();
        if (r54 == null) goto L244;
        if (r54.a() != true) goto L244;
        boolean r55 = true;
    L245:
        if (r55 == true) goto L248;
        boolean r56 = true;
    L249:
        if (r56 == false) goto L256;
        PocketModeDetector r57 = this.e;
        r2.L$0 = null;
        r2.label = 2;
        r0 = r57.d(r2);
        Object r58 = r410;
        if (r0 != r58) goto L254;
        return r58;
    L244:
        r55 = false;
    L248:
        r56 = false;
    L224:
        r50 = null;
        goto L225
    L218:
        r46 = null;
        goto L219
    L94:
        r23 = null;
        goto L95
    L57:
        if (Intrinsics.areEqual(bga.j.a(), IInteractionStateService$Companion.WAKEUP_SOURCE_VOICE) == true) goto L61;
        r16 = r8;
        if (Intrinsics.areEqual(bga.j.a(), r16) == false) goto L60;
    L62:
        String r59 = r7.getString("keyword", "");
        long r60 = r7.getLong("offsetTime", -1);
        if (Intrinsics.areEqual(bga.j.c(), "BREATH") == true) goto L66;
        r13 = r7.getInt("sessionid", 0);
    L66:
        r17 = r12;
        r410 = r4;
        long r114 = r7.getLong("stage1_start_time", 0);
        FLogger r115 = FLogger.a;
        r19 = "";
        r22 = r16;
        r115.i(ISessionEndPoint.a.b(this), "handleOneshotParams =========> " + r59 + " - " + r60 + " - " + r13);
        Intrinsics.checkNotNull(r59);
        if (r59.length() <= 0) goto L69;
        boolean r61 = true;
    L70:
        if (r61 == true) goto L75;
        long r210 = 0;
        if (r60 >= 0) goto L76;
        ObricOneshotDelegate.b.g();
    L76:
        ObricOneshotDelegate r62 = ObricOneshotDelegate.b;
        r62.i(r13, r59, r60);
        if (r114 <= r210) goto L85;
        r115.i(ISessionEndPoint.a.b(this), "handleOneshotParams useChipStage1StartTime, stage1StartTime=" + r114);
        long r63 = r114 - ((long) 100);
        r62.b(0, r63);
        if (Intrinsics.areEqual(bga.j.c(), "BREATH") == false) goto L91;
        ObricWakeupAudioCaptureDelegate r64 = ObricWakeupAudioCaptureDelegate.b;
        if (r64.a() == false) goto L91;
        long r310 = System.currentTimeMillis();
        r64.b(new hga.f(r310, WakeupAudioCaptureTriggerType.BREATH_WAKEUP, this.b, r63, r310, null, null, null, null, null, null, null, null, 0, 0.0f, 0.0f, 0, false, false, 1048516));
        goto L91
    L85:
        Object r65 = AppHost.a.getApplication().getSystemService("keyguard");
        Intrinsics.checkNotNull(r65, "null cannot be cast to non-null type android.app.KeyguardManager");
        boolean r66 = ((KeyguardManager) r65).isKeyguardLocked();
        if (Intrinsics.areEqual(bga.j.c(), "BREATH") == false) goto L89;
        if (r66 == false) goto L89;
        long r116 = 1600;
    L90:
        r62.b(r60 + r116, System.currentTimeMillis());
    L89:
        r116 = 1200;
        goto L90
    L75:
        r210 = 0;
        goto L76
    L69:
        r61 = false;
        goto L70
    L61:
        r16 = r8;
    L51:
        th = move-exception;
        Result.Companion r67 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L54
    L37:
        if (r15 == 0) goto L39;
        long r117 = r10 - r15;
        FLogger.a.i(ISessionEndPoint.a.b(this), "onShow login start with IPC is " + r117 + " and now is " + r10);
    L40:
        IWakeupStatisticsAPI r68 = wha.a.a();
        if (r68 == null) goto L35;
        r68.setStartTime(r10 - r117);
        r13 = -1;
        r68.b("wakeup_stage3_1_ipc", false, ((long) (-1)) * r117);
        r68.b("wakeup_stage3_2_on_show", false, r10);
        if (r7 == null) goto L46;
        Bundle r69 = r7.getBundle("REQUEST_TRACK_DURATION");
        if (r69 == null) goto L46;
    L47:
        r68.setBundle(r69);
    L46:
        r69 = com.larus.utils.f.c(new Pair[0]);
        goto L47
    L39:
        r117 = 0;
        goto L40
    L29:
        r9 = 0;
        goto L30
    L26:
        r15 = 0;
        goto L27
    L16:
        ResultKt.throwOnFailure(r0);
        r2.L$0 = r48;
        r2.label = 1;
        if (ISessionEndPoint.a.e(this) != r4) goto L19;
        return r4;
    L19:
        r7 = r48;
    L7:
        r2 = new VoiceWakeupSessionEndpoint$onSessionProcess$1(this, r49);
        goto L8
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void p(Context r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "args");
        ISessionEndPoint.a.d(this, r3, r4);
        FLogger r5 = FLogger.a;
        r5.i(ISessionEndPoint.a.b(this), "onSessionPrepared clearOneshotParam");
        this.c = false;
        ObricOneshotDelegate.b.g();
        if (Intrinsics.areEqual(bga.j.a(), IInteractionStateService$Companion.WAKEUP_SOURCE_VOICE) == false) goto L7;
        wna.a.c(r4);
        if (t1.a.r1() == true) goto L7;
        this.e.b();
        r5.i(ISessionEndPoint.a.b(this), "onSessionPrepared start pocket mode detection");
    L7:
        this.b = r4.getInt("wakeupId", -1);
    }
}
