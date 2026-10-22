package com.larus.audioplayer.impl.manager;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.view.KeyEvent;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audio.controller.GlobalAudioController;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.audio.controller.IGlobalAudioController;
import com.larus.audioplayer.impl.appletpayload.AppletMediaPlayerContextProvider;
import com.larus.audioplayer.impl.music.MusicPlayManager;
import com.larus.audioplayer.impl.utils.AudioVolumeChangeReceiver;
import com.larus.call_plugins_doubao_common.CommonAppletPlugin;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.v;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import me.ele.lancet.base.annotations.Skip;
import tx9.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\f\b\u0007\u0018\u0000 S2\u00020\u0001:\u0001SB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0016J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001bH\u0002J\b\u0010 \u001a\u00020\u0015H\u0002J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010$\u001a\u00020%H\u0016J\u001a\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010)\u001a\u00020\n2\u0006\u0010'\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010*\u001a\u00020\n2\u0006\u0010'\u001a\u00020\"H\u0016J\u001a\u0010+\u001a\u00020\n2\u0006\u0010'\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010,\u001a\u00020\n2\u0006\u0010'\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010\"H\u0016J,\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020/2\u0006\u0010'\u001a\u00020\"2\u0006\u00100\u001a\u00020/2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\"H\u0002J \u00103\u001a\u00020\u00152\u0006\u0010.\u001a\u00020/2\u0006\u0010'\u001a\u00020\"2\u0006\u00100\u001a\u00020/H\u0002J\u0010\u00104\u001a\u00020\u00152\u0006\u0010.\u001a\u00020/H\u0002J \u00105\u001a\u00020\u00152\u0006\u0010.\u001a\u00020/2\u0006\u0010'\u001a\u00020\"2\u0006\u00100\u001a\u00020/H\u0002J\u0010\u00106\u001a\u00020/2\u0006\u0010.\u001a\u00020/H\u0002J\u0018\u00107\u001a\u00020\n2\u0006\u00108\u001a\u0002092\u0006\u0010'\u001a\u00020\"H\u0016J\u0018\u0010:\u001a\u00020\n2\u0006\u00108\u001a\u0002092\u0006\u0010'\u001a\u00020\"H\u0016J\u0018\u0010;\u001a\u00020\n2\u0006\u00108\u001a\u0002092\u0006\u0010'\u001a\u00020\"H\u0016J \u0010<\u001a\u00020\n2\u0006\u00108\u001a\u0002092\u0006\u0010'\u001a\u00020\"2\u0006\u00100\u001a\u00020/H\u0002J \u0010=\u001a\u00020\n2\u0006\u00108\u001a\u0002092\u0006\u0010'\u001a\u00020\"2\u0006\u00100\u001a\u00020/H\u0002J1\u0010>\u001a\u00020\n2\u0006\u00108\u001a\u0002092\u0006\u0010'\u001a\u00020\"2\u0006\u00100\u001a\u00020/2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010/H\u0002¢\u0006\u0002\u0010@J\b\u0010A\u001a\u000209H\u0016J\u0018\u0010B\u001a\u00020\u00152\u0006\u0010C\u001a\u00020/2\u0006\u0010D\u001a\u00020/H\u0016J\b\u0010E\u001a\u00020\u0015H\u0016J\b\u0010F\u001a\u00020\u0015H\u0016J\u0010\u0010G\u001a\u00020\u00152\u0006\u0010H\u001a\u00020\u0006H\u0016J\u0010\u0010I\u001a\u00020\u00152\u0006\u0010H\u001a\u00020\u0006H\u0016J\u0010\u0010M\u001a\u00020\u00152\u0006\u0010N\u001a\u00020\nH\u0016J \u0010O\u001a\u00020\u00152\u0006\u0010P\u001a\u00020/2\u0006\u0010Q\u001a\u00020/2\u0006\u0010R\u001a\u00020/H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/larus/audioplayer/impl/manager/GlobalAudioControllerImpl;", "Lcom/larus/audio/controller/IGlobalAudioController;", "<init>", "()V", "mVolumeChangedListeners", "", "Lcom/larus/audio/controller/IAudioVolumeChangedListener;", "mCurrentParticipant", "Lcom/larus/audio/controller/IGlobalAudioParticipant;", "mDoraA2dpDisconnectReceiverRegistered", "", "mDoraA2dpDisconnectReceiver", "com/larus/audioplayer/impl/manager/GlobalAudioControllerImpl$mDoraA2dpDisconnectReceiver$1", "Lcom/larus/audioplayer/impl/manager/GlobalAudioControllerImpl$mDoraA2dpDisconnectReceiver$1;", "mMainHandler", "Landroid/os/Handler;", "getMMainHandler", "()Landroid/os/Handler;", "mMainHandler$delegate", "Lkotlin/Lazy;", "participate", "", "participant", "abstain", "registerDoraA2dpDisconnectReceiver", "unregisterDoraA2dpDisconnectReceiver", "getBluetoothDevice", "Landroid/bluetooth/BluetoothDevice;", "intent", "Landroid/content/Intent;", "isDoraDevice", "device", "pauseCurrentParticipantForDoraDisconnect", "getCurrentScene", "", "getCurrentBizScene", "getCurrentState", "Lcom/larus/audio/controller/GlobalAudioStateEnum;", "play", "scene", "doraScene", "pause", "stop", "playPrevious", "playNext", "asyncMediaCommand", "command", "", "controlType", "mQQMusicMediaApplicant", "Lcom/larus/media/model/MediaRequestApplicant;", "asyncDoMediaCommandByDora", "syncDoPlayCommandBySystem", "asyncDoMediaCommandBySystem", "mapCommandToKeyEvent", "increaseSystemVolume", "ratio", "", "decreaseSystemVolume", "setSystemVolume", "doSetSystemVolume", "doSetSystemVolumeByDora", "doSetSystemVolumeBySystem", "doraAbsVolumeSupported", "(DLjava/lang/String;ILjava/lang/Integer;)Z", "getSystemVolumeRatio", "onVolumeChanged", "volume", "prevVolume", "releaseMediaSession", "notifySystemFocusGrabbed", "registerVolumeChangedListener", "listener", "unregisterVolumeChangedListener", "mIsInDoraCall", "mDelayCommandFunc", "Lkotlin/Function0;", "setDoraCallStatus", "isInCall", "onDoraBudsEvent", "type", "key", "event", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class GlobalAudioControllerImpl implements IGlobalAudioController {
    public static final /* synthetic */ int g = 0;
    public final List<e78.b> a;
    public e78.c b;
    public boolean c;
    public final GlobalAudioControllerImpl$mDoraA2dpDisconnectReceiver$1 d;
    public final Lazy e;
    public final com.larus.media.model.a f;

    public static final class a {
    }

    public static final class b implements v {
        public b() {
        }

        public final boolean b(lk9.g r2) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            return true;
        }

        public final void e(lk9.g r1) {
            v.a.d(r1);
        }

        public final void f(MediaResourceManager.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }

        public final void a(lk9.g r1, float r2) {
            v.a.f(r1, r2);
        }

        public final void d(lk9.g r1, lk9.g r2) {
            v.a.c(r1, r2);
        }

        public final void g(lk9.g r1, float r2) {
            v.a.g(r1, r2);
        }

        public final void i(lk9.g r1, lk9.g r2) {
            v.a.e(r1, r2);
        }

        public final MediaOccupyStrategy c(lk9.g r1, lk9.g r2, int r3) {
            return v.a.a(this, r1, r2, r3);
        }

        public final MediaOccupyStrategy h(lk9.g r1, lk9.g r2, int r3) {
            return v.a.b(r1, r2);
        }
    }

    static {
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final double e() {
        Object r0 = AppHost.a.getApplication().getSystemService("audio");
        if ((r0 instanceof AudioManager) == false) goto L5;
        AudioManager r1 = (AudioManager) r0;
    L7:
        if (Build.VERSION.SDK_INT < 28) goto L10;
        if (r1 == null) goto L10;
        int r2 = r1.getStreamMinVolume(3);
    L11:
        if (r1 == null) goto L13;
        int r3 = r1.getStreamVolume(3);
    L14:
        if (r1 == null) goto L16;
        int r4 = r1.getStreamMaxVolume(3);
    L17:
        int r5 = r4 - r2;
        if (r5 != 0) goto L21;
        return 0.0d;
    L21:
        double r6 = ((double) (r3 - r2)) / ((double) r5);
        StringCompanionObject r7 = StringCompanionObject.INSTANCE;     // Catch: NumberFormatException -> L24
        return CastDoubleProtector.parseDouble(String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r6)}, 1)));
    L27:
        return r6;
    L16:
        r4 = 15;
        goto L17
    L13:
        r3 = 0;
    L10:
        r2 = 0;
        goto L11
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final String g() {
        e78.c r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getBizScene();
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final String getCurrentScene() {
        e78.c r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getScene();
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final GlobalAudioStateEnum getCurrentState() {
        e78.c r0 = this.b;
        if (r0 == null) goto L7;
        GlobalAudioStateEnum r1 = r0.getState();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return GlobalAudioStateEnum.NONE;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final void i() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L9;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L9;
        boolean r2 = true;
        if (r1.J() != true) goto L9;
    L10:
        if (r2 == true) goto L12;
        return;
    L12:
        if (GlobalAudioController.a.getCurrentState() == GlobalAudioStateEnum.NONE) goto L18;
        e78.c r3 = this.b;
        if (r3 == null) goto L19;
        r3.a();
        return;
    L19:
        return;
    L18:
        return;
    L9:
        r2 = false;
        goto L10
    }

    public final void t() {
        if (this.c == false) goto L5;
        return;
    L5:
        IntentFilter r0 = new IntentFilter("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        if (Build.VERSION.SDK_INT < 33) goto L36;
        Application r11 = AppHost.a.getApplication();
        GlobalAudioControllerImpl$mDoraA2dpDisconnectReceiver$1 r12 = this.d;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L71;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L71:
    L31:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L35;
        ReceiverRegisterCrashOptimizer.registerReceiver(r12, r0, 2);
    L64:
        this.c = true;
        return;
    L35:
        throw e;
    L11:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r0) == false) goto L22;
        int r1 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r12, r0, 2, null, null, 3, r11).result;     // Catch: Exception -> L31
        if (r1 == 1) goto L20;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L70;
        r11.registerReceiver(r12, r0, 2);     // Catch: Exception -> L31
    L70:
        goto L64
    L19:
        new Intent();     // Catch: Exception -> L31
        goto L70
    L20:
        r11.registerReceiver(r12, r0, 2);     // Catch: Exception -> L31
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L25;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L31
        r11.registerReceiver(r12, r0, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L31
        goto L70
    L25:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L27;
    L29:
        r11.registerReceiver(r12, r0, 2);     // Catch: Exception -> L31
        goto L70
    L27:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r0) == false) goto L29;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L31
        ContextCompat.registerReceiver(r11, r12, r0, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L31
        goto L70
    L36:
        Application r13 = AppHost.a.getApplication();
        GlobalAudioControllerImpl$mDoraA2dpDisconnectReceiver$1 r14 = this.d;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L68;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L68:
    L60:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L66;
        ReceiverRegisterCrashOptimizer.registerReceiver(r14, r0);
        goto L64
    L66:
        throw e;
    L40:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L51;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r0) == false) goto L51;
        int r2 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r14, r0, 0, null, null, 2, r13).result;     // Catch: Exception -> L60
        if (r2 == 1) goto L49;
        if (r2 == 2) goto L48;
        if (r2 == 3) goto L67;
        r13.registerReceiver(r14, r0);     // Catch: Exception -> L60
    L67:
        goto L64
    L48:
        new Intent();     // Catch: Exception -> L60
        goto L67
    L49:
        r13.registerReceiver(r14, r0);     // Catch: Exception -> L60
    L51:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L54;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L60
        r13.registerReceiver(r14, r0, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L60
        goto L67
    L54:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L56;
    L58:
        r13.registerReceiver(r14, r0);     // Catch: Exception -> L60
        goto L67
    L56:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r0) == false) goto L58;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L60
        ContextCompat.registerReceiver(r13, r14, r0, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L60
        goto L67
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.audioplayer.impl.manager.GlobalAudioControllerImpl$mDoraA2dpDisconnectReceiver$1] */
    public GlobalAudioControllerImpl() {
        this.a = new ArrayList();
        this.d = new GlobalAudioControllerImpl$mDoraA2dpDisconnectReceiver$1(this);
        this.e = LazyKt.lazy(new com.larus.audioplayer.impl.manager.b());
        this.f = new com.larus.media.model.a(null, GlobalAudioSceneEnum.MUSIC, true, 0, 2, false, 0, false, false, 0, false, new b(), 2025);
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final boolean a(String r4) {
        Intrinsics.checkNotNullParameter("cmd", "scene");
        if (q(2, "cmd", 4, r4) == false) goto L5;
        return true;
    L5:
        i1.c("cmd", 4, "app");
        e78.c r5 = this.b;
        if (r5 != null) goto L8;
    L10:
        return false;
    L8:
        if (r5.play() != true) goto L10;
        return true;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final boolean b(double r4) {
        Intrinsics.checkNotNullParameter("cmd", "scene");
        double r0 = e() + r4;
        if (r0 <= 1.0d) goto L6;
        r0 = 1.0d;
    L6:
        return r(r0, 1);
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final boolean c(double r3) {
        Intrinsics.checkNotNullParameter("cmd", "scene");
        return r(r3, 3);
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final synchronized void d(e78.c r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r7, "participant");     // Catch: Throwable -> L26
        if (Intrinsics.areEqual(this.b, r7) == false) goto L24;
        FLogger.a.i("GlobalAudioControllerImpl", "abstain triggered, scene: " + r7.getScene());     // Catch: Throwable -> L26
        this.b = null;     // Catch: Throwable -> L26
        if (this.c == true) goto L29;
    L17:
        r7.c();     // Catch: Throwable -> L26
        int r8 = AppletMediaPlayerContextProvider.a;     // Catch: Throwable -> L26
        Map r9 = AppletMediaPlayerContextProvider.a.a(null, null);     // Catch: Throwable -> L26
        if (r9 == null) goto L24;
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L26
        if (r0 == null) goto L24;
        r0.g(r9);     // Catch: Throwable -> L26
        goto L24
    L29:
        o(AppHost.a.getApplication(), this.d);     // Catch: Throwable -> L12 Exception -> L14
    L16:
        this.c = false;     // Catch: Throwable -> L26
        goto L17
    L14:
        e = move-exception;
        FLogger.a.e("GlobalAudioControllerImpl", "unregisterDoraA2dpDisconnectReceiver failed", e);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        this.c = false;     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L24:
        monitor-exit(this);
        return;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final boolean f(String r4) {
        Intrinsics.checkNotNullParameter("cmd", "scene");
        if (q(4, "cmd", 7, r4) == false) goto L5;
        return true;
    L5:
        i1.c("cmd", 7, "app");
        e78.c r5 = this.b;
        if (r5 != null) goto L8;
    L10:
        return false;
    L8:
        if (r5.e() != true) goto L10;
        return true;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final synchronized void h(e78.c r6) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r6, "participant");     // Catch: Throwable -> L22
        if (Intrinsics.areEqual(this.b, r6) == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        e78.c r1 = this.b;     // Catch: Throwable -> L22
        if (r1 == null) goto L11;
        String r2 = r1.getScene();     // Catch: Throwable -> L22
    L12:
        FLogger.a.i("GlobalAudioControllerImpl", "participate triggered, newScene: " + r6.getScene() + ", oldScene: " + r2);     // Catch: Throwable -> L22
        e78.c r0 = this.b;     // Catch: Throwable -> L22
        if (r0 == null) goto L15;
        r6.getScene();     // Catch: Throwable -> L22
        r0.c();     // Catch: Throwable -> L22
    L15:
        this.b = r6;     // Catch: Throwable -> L22
        t();     // Catch: Throwable -> L22
        r6.d();     // Catch: Throwable -> L22
        int r3 = AppletMediaPlayerContextProvider.a;     // Catch: Throwable -> L22
        Map r7 = AppletMediaPlayerContextProvider.a.a(r6.getScene(), r6.getBizScene());     // Catch: Throwable -> L22
        if (r7 == null) goto L20;
        IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L22
        if (r4 == null) goto L20;
        r4.g(r7);     // Catch: Throwable -> L22
    L20:
        monitor-exit(this);
        return;
    L11:
        r2 = null;
    L22:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final boolean j(String r4) {
        Intrinsics.checkNotNullParameter("cmd", "scene");
        if (q(5, "cmd", 6, r4) == false) goto L5;
        return true;
    L5:
        i1.c("cmd", 6, "app");
        e78.c r5 = this.b;
        if (r5 != null) goto L8;
    L10:
        return false;
    L8:
        if (r5.b() != true) goto L10;
        return true;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final synchronized void k(CommonAppletPlugin.b r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "listener");     // Catch: Throwable -> L10
        AudioVolumeChangeReceiver.a.c();     // Catch: Throwable -> L10
        if (((ArrayList) this.a).contains(r2) == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        ((ArrayList) this.a).add(r2);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final boolean m(double r4) {
        Intrinsics.checkNotNullParameter("cmd", "scene");
        double r0 = e() - r4;
        if (r0 >= 0.0d) goto L6;
        r0 = 0.0d;
    L6:
        return r(r0, 2);
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final synchronized void n(CommonAppletPlugin.b r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "listener");     // Catch: Throwable -> L8
        ((ArrayList) this.a).remove(r2);     // Catch: Throwable -> L8
        if (((ArrayList) this.a).isEmpty() == false) goto L6;
        AudioVolumeChangeReceiver.a.d();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final boolean pause(String r4) {
        Intrinsics.checkNotNullParameter("cmd", "scene");
        if (q(3, "cmd", 5, r4) == false) goto L5;
        return true;
    L5:
        i1.c("cmd", 5, "app");
        e78.c r5 = this.b;
        if (r5 != null) goto L8;
    L10:
        return false;
    L8:
        if (r5.pause() != true) goto L10;
        return true;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final boolean stop(String r4) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        if (q(3, r4, 5, null) == false) goto L5;
        return true;
    L5:
        e78.c r5 = this.b;
        if (r5 != null) goto L8;
    L10:
        return false;
    L8:
        if (r5.stop() != true) goto L10;
        return true;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void o(Application r1, GlobalAudioControllerImpl$mDoraA2dpDisconnectReceiver$1 r2) {
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

    public static final void p(GlobalAudioControllerImpl r3, int r4) {
        r3.getClass();
        if (r4 != 2) goto L5;
        int r5 = 126;
    L9:
        Object r6 = AppHost.a.getApplication().getSystemService("audio");
        if ((r6 instanceof AudioManager) == false) goto L12;
        AudioManager r7 = (AudioManager) r6;
    L13:
        if (r7 == null) goto L16;
        KeyEvent r0 = new KeyEvent(0, r5);
        KeyEvent r1 = new KeyEvent(1, r5);
        r7.dispatchMediaKeyEvent(r0);
        r7.dispatchMediaKeyEvent(r1);
        return;
    L16:
        return;
    L12:
        r7 = null;
        goto L13
    L5:
        if (r4 != 3) goto L17;
        r5 = 127;
        goto L9
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final void onVolumeChanged(int r1, int r2) {
        if (r1 != r2) goto L4;
        return;
    L4:
        Iterator r3 = new CopyOnWriteArrayList(this.a).iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        ((e78.b) r3.next()).a();
        goto L6
    }

    public final boolean r(double r14, int r16) {
        if (z2.a.isDoraAudioControlEnabled() == false) goto L9;
        IDoraService r1 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r1 != null) goto L7;
        FLogger.a.e("GlobalAudioControllerImpl", "asyncDoSetSystemVolumeByDora getDoraService fails");
        return false;
    L7:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new GlobalAudioControllerImpl$doSetSystemVolumeByDora$1(r1, this, r14, "cmd", r16, null), 3, null);
        return true;
    L9:
        return s(r14, "cmd", r16, null);
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final void l(int r4, int r5, int r6) {
        a88.a r7 = com.larus.audioplayer.impl.utils.a.a;
        a88.e r8 = MusicPlayManager.j;
        if (r8 == null) goto L20;
        String r9 = r8.a;
        if (r9 == null) goto L21;
        a88.a r10 = com.larus.audioplayer.impl.utils.a.a;
        if (r10 == null) goto L22;
        int r0 = MusicPlayManager.n;
        int r2 = 1;
        if (r6 != 1) goto L11;
        if (r0 != 3) goto L17;
        r2 = 5;
    L18:
        r10.c(r9, r2, MapsKt.mapOf(TuplesKt.to("enterMethod", "touchpad")));
        return;
    L17:
        r2 = 4;
        goto L18
    L11:
        if (r6 == 2) goto L18;
        if (r6 == 3) goto L14;
        r2 = -1;
        goto L18
    L14:
        r2 = 2;
        goto L18
    L22:
        return;
    L21:
        return;
    }

    public final boolean q(int r15, String r16, int r17, String r19) {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L9;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L9;
        if (r1.J() != true) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L48;
        a88.a r3 = com.larus.audioplayer.impl.utils.a.a;
        a88.e r4 = MusicPlayManager.j;
        if (r4 == null) goto L14;
        String r5 = r4.a;
    L15:
        int r7 = 4;
        if (r15 != 2) goto L18;
        char r11 = '~';
    L26:
        Intrinsics.checkNotNullParameter("query", "source");
        if (r5 == null) goto L44;
        a88.a r13 = com.larus.audioplayer.impl.utils.a.a;
        if (r13 == null) goto L44;
        if (r11 == 'W') goto L37;
        if (r11 == 'X') goto L36;
        if (r11 == '~') goto L38;
        if (r11 == 127) goto L35;
        r7 = -1;
        goto L38
    L35:
        r7 = 5;
    L38:
        Pair[] r6 = new Pair[2];
        r6[0] = TuplesKt.to("enterMethod", "query");
        if (r19 != null) goto L41;
        String r8 = "";
    L42:
        r6[1] = TuplesKt.to("scene", r8);
        r13.c(r5, r7, MapsKt.mapOf(r6));
        goto L44
    L41:
        r8 = r19;
        goto L42
    L36:
        r7 = 1;
        goto L38
    L37:
        r7 = 2;
    L44:
        if (z2.a.isDoraAudioControlEnabled() == false) goto L46;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new GlobalAudioControllerImpl$asyncDoMediaCommandByDora$1(r16, r17, this, r15, null), 3, null);
    L47:
        return true;
    L46:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new GlobalAudioControllerImpl$asyncDoMediaCommandBySystem$1(r15, r16, r17, this, null), 3, null);
        goto L47
    L18:
        if (r15 == 3) goto L24;
        if (r15 == 4) goto L23;
        if (r15 == 5) goto L22;
        FLogger.a.e("GlobalAudioControllerImpl", "mapCommandToKeyEvent unknown command: " + r15);
        r11 = 0;
        goto L26
    L22:
        r11 = 'W';
        goto L26
    L23:
        r11 = 'X';
        goto L26
    L24:
        r11 = 127;
        goto L26
    L14:
        r5 = null;
        goto L15
    L48:
        return false;
    L9:
        r2 = false;
        goto L10
    }

    public final boolean s(double r17, final String r19, final int r20, final Integer r21) {
        i1.c(r19, r20, "system");
        Object r5 = AppHost.a.getApplication().getSystemService("audio");     // Catch: Exception -> L20
        if ((r5 instanceof AudioManager) == false) goto L6;
        AudioManager r6 = (AudioManager) r5;     // Catch: Exception -> L20
    L7:
        final AudioManager r7 = r6;
        if (r7 != null) goto L11;
        return false;
    L11:
        if (Build.VERSION.SDK_INT < 28) goto L13;
        int r8 = r7.getStreamMinVolume(3);     // Catch: Exception -> L20
    L14:
        final int r9 = (int) ((((double) (r7.getStreamMaxVolume(3) - r8)) * r17) + ((double) r8));     // Catch: Exception -> L20
        r7.setStreamVolume(3, r9, 1);     // Catch: Exception -> L20
        FLogger.a.i("GlobalAudioControllerImpl", "setSystemVolumeBySystem with volume " + r9);     // Catch: Exception -> L20
        ((Handler) this.e.getValue()).postDelayed(new c(r7, r9, r19, r20, r21), 500);     // Catch: Exception -> L18
        return true;
    L18:
        e = e;
    L22:
        i1.b(r19, r20, "system", false, "exception:" + e, null, r21);
        FLogger.a.e("GlobalAudioControllerImpl", "setSystemVolumeBySystem " + r17 + " error", e);
        return false;
    L13:
        r8 = 0;
        goto L14
    L6:
        r6 = null;
    L20:
        e = e;
        goto L22
    }
}
