package com.larus.audio.report;

import android.app.Application;
import android.content.Context;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.audiov3.report.IAudioEventCommonParams;
import com.larus.audio.audiov3.util.IAudioDeviceHelper;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.c1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.o;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0014\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u001e\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006!"}, d2 = {"Lcom/larus/audio/report/AudioEventCommonParamsServiceImpl;", "Lcom/larus/audio/audiov3/report/IAudioEventCommonParams;", "<init>", "()V", "appContext", "Landroid/app/Application;", "enabled", "", "registered", "cachedInfo", "Lcom/larus/audio/audiov3/util/IAudioDeviceHelper$DeviceInfo;", "lastScreenReaderEnabled", "Ljava/lang/Boolean;", "audioDeviceCallback", "Landroid/media/AudioDeviceCallback;", "getAudioDeviceCallback", "()Landroid/media/AudioDeviceCallback;", "audioDeviceCallback$delegate", "Lkotlin/Lazy;", "appBackgroundListener", "com/larus/audio/report/AudioEventCommonParamsServiceImpl$appBackgroundListener$1", "Lcom/larus/audio/report/AudioEventCommonParamsServiceImpl$appBackgroundListener$1;", "updateInfo", "", "context", "Landroid/content/Context;", "enable", "disable", "updateParamsWhenAppForeground", "currentInfo", "initListener", "application", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AudioEventCommonParamsServiceImpl implements IAudioEventCommonParams {
    public static final /* synthetic */ int g = 0;
    public Application a;
    public boolean b;
    public boolean c;
    public volatile IAudioDeviceHelper.a d;
    public volatile Boolean e;
    public final Lazy f;

    public static final class a {
    }

    public static final class b implements f09.a.b {
        public final /* synthetic */ AudioEventCommonParamsServiceImpl a;

        public final void onAllActivityDestroyed() {
        }

        public final void onAppBackground() {
        }

        public final void onAppForeground() {
            AudioEventCommonParamsServiceImpl r0 = this.a;
            int r1 = AudioEventCommonParamsServiceImpl.g;
            r0.e();
        }

        public b(AudioEventCommonParamsServiceImpl r1) {
            this.a = r1;
        }
    }

    public static final class c extends AudioDeviceCallback {
        public final /* synthetic */ AudioEventCommonParamsServiceImpl a;

        public c(AudioEventCommonParamsServiceImpl r1) {
            this.a = r1;
        }

        @Override // android.media.AudioDeviceCallback
        public final void onAudioDevicesAdded(AudioDeviceInfo[] r2) {
            super.onAudioDevicesAdded(r2);
            AudioEventCommonParamsServiceImpl r3 = this.a;
            Application r0 = r3.a;
            if (r0 == null) goto L6;
            r3.d(r0);
            return;
        }

        @Override // android.media.AudioDeviceCallback
        public final void onAudioDevicesRemoved(AudioDeviceInfo[] r2) {
            super.onAudioDevicesRemoved(r2);
            AudioEventCommonParamsServiceImpl r3 = this.a;
            Application r0 = r3.a;
            if (r0 == null) goto L6;
            r3.d(r0);
            return;
        }
    }

    static {
    }

    @Override // com.larus.audio.audiov3.report.IAudioEventCommonParams
    public final IAudioDeviceHelper.a a() {
        if (this.b == true) goto L7;
        return null;
    L7:
        if (this.d != null) goto L21;
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L10:
        if (this.d != null) goto L14;
        Application r0 = this.a;     // Catch: Throwable -> L17
        if (r0 == null) goto L14;
        d(r0);     // Catch: Throwable -> L17
    L14:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(this);
    L21:
        return this.d;
    }

    @Override // com.larus.audio.audiov3.report.IAudioEventCommonParams
    public final void disable() {
        if (this.b == false) goto L6;
        this.b = false;
        o r0 = o.a;
        r0.c("input_device", new f());
        r0.c("output_device", new f());
        r0.c("bluetooth_device_name", new f());
        return;
    }

    public final void e() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L7;
        r0.S();
        boolean r1 = true;
        if (c1.a.a() != true) goto L7;
    L9:
        if (Intrinsics.areEqual(this.e, Boolean.valueOf(r1)) == false) goto L11;
        return;
    L11:
        this.e = Boolean.valueOf(r1);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AudioEventCommonParamsServiceImpl$updateParamsWhenAppForeground$1(r1, null), 2, null);
        return;
    L7:
        r1 = false;
        goto L9
    }

    public AudioEventCommonParamsServiceImpl() {
        this.f = LazyKt.lazy(new e(this));
        b r0 = new b(this);
        if (z2.a.enableBluetoothDevicesReportEvent() == false) goto L5;
        c(null);
    L5:
        AppHost.a.a().j(r0);
        e();
    }

    @Override // com.larus.audio.audiov3.report.IAudioEventCommonParams
    public final void b(Application r3) {
        if (z2.a.enableBluetoothDevicesReportEvent() == true) goto L7;
        FLogger.a.w("AudioInfoCommonParams", "disabled by config");
        this.b = false;
        return;
    L7:
        if (this.c == true) goto L10;
        this.a = r3;
        c(r3);
    L10:
        if (this.b == true) goto L13;
        o r4 = o.a;
        r4.c("input_device", new com.larus.audio.report.b(this));
        r4.c("output_device", new com.larus.audio.report.c(this));
        r4.c("bluetooth_device_name", new d(this));
        this.b = true;
        return;
    }

    public final void c(Application r9) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L25
        if (z2.a.enableBluetoothDevicesReportEvent() == true) goto L5;
    L23:
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L35;
        FLogger.a.e("AudioInfoCommonParams", "init error: " + r11.getMessage());
        return;
    L35:
        return;
    L5:
        if (r9 == null) goto L33;
    L16:
        this.a = r9;     // Catch: Throwable -> L25
        if (Build.VERSION.SDK_INT < 23) goto L23;
        Object r12 = r9.getSystemService("audio");     // Catch: Throwable -> L25
        if ((r12 instanceof AudioManager) == false) goto L21;
        AudioManager r13 = (AudioManager) r12;     // Catch: Throwable -> L25
    L22:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AudioEventCommonParamsServiceImpl$initListener$1$1(r13, this, null), 3, null);     // Catch: Throwable -> L25
        this.c = true;     // Catch: Throwable -> L25
        goto L23
    L21:
        r13 = null;
        goto L22
    L33:
        Object r14 = Result.constructor-impl(AppHost.a.getApplication());     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r14) == false) goto L13;
        r14 = null;
    L13:
        r9 = (Application) r14;     // Catch: Throwable -> L25
        if (r9 != null) goto L16;
        return;
    L8:
        th = move-exception;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L25
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    }

    public final void d(Context r3) {
        IAudioDeviceHelper r0 = (IAudioDeviceHelper) ServiceManager.get().getService(IAudioDeviceHelper.class);
        if (r0 != null) goto L5;
        return;
    L5:
        this.d = r0.a(r3);
    }
}
