package com.obric.assistant.wakeup.bluetooth_headset.impl;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.dora.api.DoraConfig;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.spi.audio.IObricContinuousTalkService;
import com.obric.assistant.state.api.multitask.ForegroundInteractionPhase;
import com.obric.assistant.state.api.multitask.ObricInteractionProjectionDelegate;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import com.obric.assistant.wakeup.bluetooth_headset.api.BlueAudioScoState;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import me.ele.lancet.base.annotations.Skip;
import uha.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ObricBluetoothAudioManager {
    public static final ObricBluetoothAudioManager a = null;
    public static long b;
    public static boolean c;
    public static boolean d;
    public static volatile boolean e;
    public static final AtomicBoolean f = null;
    public static final Handler g = null;
    public static final Map<UUID, Function1<BlueAudioScoState, Unit>> h = null;
    public static final Lazy i = null;
    public static final Lazy j = null;
    public static final ObricBluetoothAudioManager$headsetReceiver$1 k = null;
    public static final ObricBluetoothAudioManager$scoStateReceiver$1 l = null;
    public static boolean m;

    public ObricBluetoothAudioManager() {
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.obric.assistant.wakeup.bluetooth_headset.impl.ObricBluetoothAudioManager$headsetReceiver$1] */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.obric.assistant.wakeup.bluetooth_headset.impl.ObricBluetoothAudioManager$scoStateReceiver$1] */
    static {
        a = new ObricBluetoothAudioManager();
        b = -1;
        f = new AtomicBoolean(false);
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("blue-sco-thread-in-obric");
        ThreadMethodProxy.start(r0);
        g = new Handler(r0.getLooper(), new b());
        h = new LinkedHashMap();
        i = LazyKt.lazy(new c());
        j = LazyKt.lazy(new d());
        k = new ObricBluetoothAudioManager$headsetReceiver$1();
        l = new ObricBluetoothAudioManager$scoStateReceiver$1();
    }

    public static AudioManager d() {
        return (AudioManager) j.getValue();
    }

    public static boolean f() {
        ObricInteractionType r0 = ObricInteractionProjectionDelegate.b.a(DoraConfig.g()).c;
        FLogger.a.w("Obric-BluetoothAudioManager", "isUnSupportMode check mode is " + r0);
        if (r0 != ObricInteractionType.AutoHalfDuplex) goto L5;
    L11:
        return false;
    L5:
        if (r0 == ObricInteractionType.DefaultMode) goto L11;
        if (r0 == ObricInteractionType.NullMode) goto L11;
        if (r0 == ObricInteractionType.TextMode) goto L11;
        return true;
    }

    public static void g() {
        long r1 = System.currentTimeMillis();
        long r3 = b;
        long r2 = r1 - r3;
        long r5 = 0;
        if (r3 > 0) goto L5;
    L11:
        FLogger r4 = FLogger.a;
        r4.i("Obric-BluetoothAudioManager", "needDelayTime for sco operation is " + r5 + " , with gap " + r2);
        if (1 <= r5) goto L14;
    L16:
        boolean r6 = false;
    L17:
        if (r6 == false) goto L25;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L20
        r4.w("Obric-BluetoothAudioManager", "nap..zzzZZZ start ,will take " + r5 + " ms");     // Catch: Throwable -> L20
        Thread.sleep(r5);     // Catch: Throwable -> L20
        r4.w("Obric-BluetoothAudioManager", "nap..zzzZZZ end");     // Catch: Throwable -> L20
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L25:
        return;
    L14:
        if (r5 >= 201) goto L16;
        r6 = true;
        goto L17
    L5:
        if (r2 < 0) goto L11;
        if (r2 >= 200) goto L11;
        r5 = 200 - r2;
        goto L11
    }

    public static void h() {
        ObricInteractionProjectionDelegate r0 = ObricInteractionProjectionDelegate.b;
        zga.b r2 = r0.a(null);
        boolean r3 = r2.b();
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("onActiveDeviceChanged , mode listening ? ");
        r5.append(r3);
        r5.append(" lastStateListening ");
        r5.append(m);
        r5.append("  thinking ? ");
        ForegroundInteractionPhase r8 = r2.e;
        ForegroundInteractionPhase r9 = ForegroundInteractionPhase.Thinking;
        if (r8 != r9) goto L5;
        boolean r10 = true;
    L6:
        r5.append(r10);
        r4.w("Obric-BluetoothAudioManager", r5.toString());
        if (r3 == false) goto L10;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new onActiveDeviceChanged.1(null), 3, null);
        m = true;
        return;
    L10:
        if (r2.e != r9) goto L12;
        boolean r6 = true;
    L13:
        r4.w("Obric-BluetoothAudioManager", "onActiveDeviceChanged , mode listening ? " + r3 + " lastStateListening " + m + ' ');
        if (((Boolean) ((Pair) IAssistantInteractionServiceKt.getInteractionStateService().getPreSoundEffectState().getValue()).getFirst()).booleanValue() == false) goto L23;
        IBluetoothHeadSetAPI r7 = tha.c.a();
        if (r7 != null) goto L18;
    L20:
        boolean r11 = false;
    L21:
        if (r11 == false) goto L23;
        IAssistantInteractionServiceKt.getInteractionStateService().getPreSoundEffectState().setValue(TuplesKt.to(Boolean.FALSE, "clear"));
        boolean r12 = true;
    L24:
        ObricInteractionType r1 = r0.a(DoraConfig.g()).c;
        if (r6 == false) goto L47;
        IBluetoothHeadSetAPI r13 = tha.c.a();
        if (r13 != null) goto L29;
    L31:
        boolean r14 = false;
    L32:
        if (r14 == false) goto L47;
        if (r12 == true) goto L47;
        if (r1 == ObricInteractionType.TextMode) goto L47;
        if (r1 == ObricInteractionType.RealtimeCallMode) goto L47;
        AtomicBoolean r15 = f;
        if (r6 == true) goto L41;
    L43:
        boolean r16 = false;
    L44:
        r15.compareAndSet(false, r16);
        if (r15.getAndSet(false) == false) goto L48;
        BuildersKt.runBlocking$default(null, new onActiveDeviceChanged.2(null), 1, null);
    L48:
        m = false;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new ObricBluetoothAudioManager$onActiveDeviceChanged$3(null), 3, null);
        return;
    L41:
        if (m == false) goto L43;
        r16 = true;
        goto L44
    L29:
        if (r13.a() != true) goto L31;
        r14 = true;
    L47:
        f.set(false);
        goto L48
    L18:
        if (r7.a() != true) goto L20;
        r11 = true;
    L23:
        r12 = false;
        goto L24
    L12:
        r6 = false;
        goto L13
    L5:
        r10 = false;
        goto L6
    }

    public final synchronized boolean i() {
        monitor-enter(this);
        FLogger r2 = FLogger.a;     // Catch: Throwable -> L28
        r2.w("Obric-BluetoothAudioManager", "releaseBluetoothConnection start to check.... scoEstablishedByMe=" + e);     // Catch: Throwable -> L28
        if (e == true) goto L10;
        r2.w("Obric-BluetoothAudioManager", "releaseBluetoothConnection 【 returned 】 not established by me");     // Catch: Throwable -> L28
        monitor-exit(this);
        return false;
    L10:
        if (d().isBluetoothScoOn() == true) goto L14;
        r2.w("Obric-BluetoothAudioManager", "releaseBluetoothConnection 【 returned 】 sco already off at system level, clear flag");     // Catch: Throwable -> L28
        e = false;     // Catch: Throwable -> L28
        monitor-exit(this);
        return false;
    L14:
        IObricContinuousTalkService r1 = (IObricContinuousTalkService) ServiceManager.get().getService(IObricContinuousTalkService.class);     // Catch: Throwable -> L28
        if (r1 != null) goto L17;
    L19:
        boolean r3 = false;
    L20:
        r2.i("Obric-BluetoothAudioManager", "isObricContinuousTalkActive : " + r3);     // Catch: Throwable -> L28
        if (r3 == false) goto L25;
        r2.w("Obric-BluetoothAudioManager", "releaseBluetoothConnection 【 returned 】 continuous talk still active");     // Catch: Throwable -> L28
        monitor-exit(this);
        return false;
    L25:
        r2.w("Obric-BluetoothAudioManager", "releaseBluetoothConnection now");     // Catch: Throwable -> L28
        d().stopBluetoothSco();     // Catch: Throwable -> L28
        r2.w("Obric-BluetoothAudioManager", "releaseBluetoothConnection executed");     // Catch: Throwable -> L28
        d().setBluetoothScoOn(false);     // Catch: Throwable -> L28
        e = false;     // Catch: Throwable -> L28
        r2.w("Obric-BluetoothAudioManager", "checkScoOn ? " + d().isBluetoothScoOn() + ", scoEstablishedByMe = false");     // Catch: Throwable -> L28
        monitor-exit(this);
        return true;
    L17:
        if (r1.isActive() != true) goto L19;
        r3 = true;
    L28:
        th = move-exception;
        throw th;
    }

    public static int c() {
        BluetoothAdapter r0 = BluetoothAdapter.getDefaultAdapter();
        if (r0 != null) goto L5;
        return -2;
    L5:
        int r4 = 1;
        if (r0.isEnabled() == true) goto L8;
    L12:
        int r1 = -2;
    L13:
        if (r1 == (-2)) goto L15;
    L17:
        r4 = r1;
    L18:
        FLogger.a.i("Obric-BluetoothAudioManager", "getHeadsetStatus result " + r4 + " hfpDevice " + ObricBluetoothDeviceManager.g);
        if (r4 != 2) goto L24;
        if (ObricBluetoothDeviceManager.g != null) goto L24;
        return -2;
    L24:
        return r4;
    L15:
        if (d().isWiredHeadsetOn() == false) goto L17;
    L8:
        if (((Boolean) i.getValue()).booleanValue() == false) goto L12;
        if (r0.getProfileConnectionState(1) != 2) goto L12;
        r1 = 2;
        goto L13
    }

    public static boolean e() {
        CoWakeupApi r0 = a.a();
        if (r0 == null) goto L5;
        boolean r1 = r0.b();
    L6:
        FLogger.a.w("Obric-BluetoothAudioManager", "isDoraLinkConnectedAudioOn(ignore switch) : " + r1);
        return r1;
    L5:
        r1 = false;
        goto L6
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void b(Application r1, BroadcastReceiver r2) {
        ReceiverRegisterLancet.loge(r2, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r1.unregisterReceiver(r2);
        return;
    L14:
    L8:
        e = move-exception;
        if (r2 == null) goto L11;
        Npth.addTag("unregisterReceiver", r2.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r2, r1) == false) goto L16;
        r1.unregisterReceiver(r2);     // Catch: Exception -> L8
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Application r8, BroadcastReceiver r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L22;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8).result;     // Catch: Exception -> L33
        if (r0 != 1) goto L12;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L12:
        if (r0 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r0 == 3) goto L40;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }
}
