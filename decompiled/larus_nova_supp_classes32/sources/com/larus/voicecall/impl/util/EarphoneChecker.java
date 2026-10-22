package com.larus.voicecall.impl.util;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.AutoEndConversationTime;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class EarphoneChecker {
    public final Context a;
    public boolean b;
    public boolean c;
    public final CheckReceiver d;
    public final PthreadHandlerThreadV2 e;
    public Handler f;
    public boolean g;
    public final Handler h;
    public c i;
    public final AudioManager j;
    public final a k;
    public boolean l;
    public boolean m;
    public boolean n;
    public final b o;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/voicecall/impl/util/EarphoneChecker$CheckReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "(Lcom/larus/voicecall/impl/util/EarphoneChecker;)V", "onReceive", NameKeys.UnloadStrategy_No_Strategy, "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class CheckReceiver extends BroadcastReceiver {
        public final /* synthetic */ EarphoneChecker a;

        public CheckReceiver(EarphoneChecker r1) {
            this.a = r1;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r6, Intent r7) {
            if (r7 == null) goto L33;
            String r8 = r7.getAction();
            if (r8 != null) goto L7;
            return;
        L7:
            if (Intrinsics.areEqual(r8, "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED") == false) goto L19;
            int r9 = r7.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
            if (r9 == 0) goto L15;
            if (r9 != 2) goto L45;
            FLogger r10 = FLogger.a;
            this.a.getClass();
            r10.i("EarphoneChecker", "onReceive bluetooth on " + this.a.c);
            EarphoneChecker r11 = this.a;
            if (r11.c == true) goto L34;
            r11.b(true);
            return;
        L34:
            return;
        L45:
            return;
        L15:
            FLogger r12 = FLogger.a;
            this.a.getClass();
            r12.i("EarphoneChecker", "onReceive bluetooth off " + this.a.c);
            EarphoneChecker r13 = this.a;
            if (r13.c == false) goto L36;
            r13.b(false);
            return;
        L36:
            return;
        L19:
            if (Intrinsics.areEqual(r8, "android.intent.action.HEADSET_PLUG") == true) goto L21;
            return;
        L21:
            if (r7.hasExtra("state") == true) goto L23;
            return;
        L23:
            if (r7.getIntExtra("state", 2) != 0) goto L28;
            FLogger r14 = FLogger.a;
            this.a.getClass();
            r14.i("EarphoneChecker", "onReceive headset off " + this.a.b);
            EarphoneChecker r15 = this.a;
            if (r15.b == false) goto L40;
            r15.c(false);
            return;
        L40:
            return;
        L28:
            if (r7.getIntExtra("state", 2) != 1) goto L42;
            FLogger r16 = FLogger.a;
            this.a.getClass();
            r16.i("EarphoneChecker", "onReceive headset on " + this.a.b);
            EarphoneChecker r17 = this.a;
            if (r17.b == true) goto L43;
            r17.c(true);
            return;
        L43:
            return;
        L42:
            return;
        }
    }

    public static final class a extends AudioDeviceCallback {
        public final /* synthetic */ EarphoneChecker a;

        public a(EarphoneChecker r1) {
            this.a = r1;
        }

        @Override // android.media.AudioDeviceCallback
        public final void onAudioDevicesAdded(AudioDeviceInfo[] r4) {
            Intrinsics.checkNotNullParameter(r4, "devices");
            EarphoneChecker r5 = this.a;
            if (r5.g == false) goto L6;
            r5.g = false;
            return;
        L6:
            r5.e();
            EarphoneChecker r6 = this.a;
            c r0 = r6.i;
            if (r0 == null) goto L9;
            r6.h.removeCallbacks(r0);
        L9:
            c r1 = new c(r6);
            r6.i = r1;
            r6.h.postDelayed(r1, 2000);
        }

        @Override // android.media.AudioDeviceCallback
        public final void onAudioDevicesRemoved(AudioDeviceInfo[] r4) {
            Intrinsics.checkNotNullParameter(r4, "devices");
            this.a.e();
            EarphoneChecker r5 = this.a;
            c r0 = r5.i;
            if (r0 == null) goto L5;
            r5.h.removeCallbacks(r0);
        L5:
            c r1 = new c(r5);
            r5.i = r1;
            r5.h.postDelayed(r1, 2000);
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ EarphoneChecker a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.e();     // Catch: Throwable -> L6
            Handler r0 = this.a.f;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.postDelayed(this, AutoEndConversationTime.AFTER_60_SECONDS);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public b(EarphoneChecker r1) {
            this.a = r1;
        }
    }

    public final void a() {
        CheckReceiver r0 = this.d;
        if (r0 == null) goto L16;
        Context r1 = this.a;
        if (r1 == null) goto L16;
        ReceiverRegisterLancet.loge(r0, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L29;
        r1.unregisterReceiver(r0);
        goto L16
    L29:
    L12:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r0.toString());
        e.printStackTrace();
        goto L16
    L9:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r0, r1) == false) goto L16;
        r1.unregisterReceiver(r0);     // Catch: Exception -> L12
    L16:
        if (Build.VERSION.SDK_INT < 23) goto L22;
        a r2 = this.k;
        if (r2 == null) goto L22;
        AudioManager r3 = this.j;
        if (r3 == null) goto L22;
        r3.unregisterAudioDeviceCallback(r2);
    L22:
        Handler r4 = this.f;
        if (r4 == null) goto L25;
        r4.removeCallbacks(this.o);
    L25:
        this.e.quitSafely();
        c r5 = this.i;
        if (r5 == null) goto L31;
        this.h.removeCallbacks(r5);
        this.i = null;
        return;
    }

    public final void d() {
        boolean r0 = this.b;
        boolean r1 = this.c;
        boolean r3 = true;
        if (this.l == true) goto L6;
        this.l = true;
        this.m = r0;
        this.n = r1;
        return;
    L6:
        boolean r2 = this.m;
        boolean r4 = this.n;
        if (r2 != r0) goto L11;
        if (r4 != r1) goto L11;
        return;
    L11:
        if (r2 == true) goto L15;
        if (r4 == true) goto L15;
        boolean r5 = false;
    L16:
        if (r0 == true) goto L20;
        if (r1 == true) goto L20;
        r3 = false;
    L20:
        FLogger r6 = FLogger.a;
        r6.i("EarphoneChecker", "showSwitchToastIfNeeded hadEarphoneBefore = " + r5 + ", hasEarphoneAfter = " + r3);
        if (r5 == true) goto L23;
        final int r7 = 2131911028;
    L26:
        this.m = r0;
        this.n = r1;
        if (z2.a.enableRealtimeCallEarphoneSwitchToast() == true) goto L30;
        r6.i("EarphoneChecker", "showSwitchToastIfNeeded skip: experiment disabled");
        return;
    L30:
        this.h.post(new com.larus.voicecall.impl.util.b(r7, this));
        return;
    L23:
        if (r3 == true) goto L25;
        r7 = 2131911029;
        goto L26
    L25:
        r7 = 2131911027;
    L15:
        r5 = true;
        goto L16
    }

    public final void e() {
        Context r0 = this.a;
        Boolean r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.getSystemService(LynxResourceModule.AUDIO_TYPE);
    L7:
        if ((r2 instanceof AudioManager) == false) goto L9;
        AudioManager r3 = (AudioManager) r2;
    L10:
        if (r3 == null) goto L12;
        r1 = Boolean.valueOf(r3.isWiredHeadsetOn());
    L12:
        c(Intrinsics.areEqual(r1, Boolean.TRUE));
        boolean r4 = true;
        if (Build.VERSION.SDK_INT >= 34) goto L27;
        if (r3 != null) goto L16;
    L18:
        boolean r5 = false;
    L19:
        if (r5 == false) goto L25;
        BluetoothAdapter r6 = BluetoothAdapter.getDefaultAdapter();
        if (r6 == null) goto L25;
        if (r6.getProfileConnectionState(1) == 0) goto L25;
    L26:
        b(r4);
    L40:
        FLogger.a.i("EarphoneChecker", "[updateStatus] isHeadSetOn:" + this.b + ", isBlueToothOn:" + this.c);
        return;
    L25:
        r4 = false;
        goto L26
    L16:
        if (r3.isBluetoothScoAvailableOffCall() != true) goto L18;
        r5 = true;
        goto L19
    L27:
        if (r3 == null) goto L38;
        AudioDeviceInfo[] r7 = r3.getDevices(2);
        if (r7 == null) goto L38;
        int r8 = r7.length;
        int r9 = 0;
    L31:
        if (r9 >= r8) goto L38;
        AudioDeviceInfo r10 = r7[r9];
        if (r10.getType() == 7) goto L39;
        if (r10.getType() == 26) goto L39;
        r9 = r9 + 1;
    L39:
        b(r4);
    L38:
        r4 = false;
        goto L39
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    public final Context getContext() {
        return this.a;
    }

    public EarphoneChecker(Context r13) {
        this.a = r13;
        this.e = new PthreadHandlerThreadV2("background_earphone_check");
        this.g = true;
        this.h = new Handler(Looper.getMainLooper());
        this.o = new b(this);
        CheckReceiver r2 = new CheckReceiver(this);
        this.d = r2;
        IntentFilter r10 = new IntentFilter();
        r10.addAction("android.intent.action.HEADSET_PLUG");
        r10.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        AudioManager r11 = null;
        if (r13 != null) goto L5;
    L35:
        ThreadMethodProxy.start(this.e);
        Handler r14 = new Handler(this.e.getLooper());
        this.f = r14;
        r14.post(this.o);
        if (Build.VERSION.SDK_INT < 23) goto L56;
        Context r15 = this.a;
        if (r15 == null) goto L40;
        Object r16 = r15.getSystemService(LynxResourceModule.AUDIO_TYPE);
    L42:
        if ((r16 instanceof AudioManager) == false) goto L44;
        r11 = (AudioManager) r16;
    L44:
        this.j = r11;
        if (r11 == null) goto L56;
        a r17 = new a(this);
        this.k = r17;
        r11.registerAudioDeviceCallback(r17, new Handler(Looper.getMainLooper()));
        goto L56
    L40:
        r16 = null;
    L56:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L50
        e();     // Catch: Throwable -> L50
        this.l = true;     // Catch: Throwable -> L50
        this.m = this.b;     // Catch: Throwable -> L50
        this.n = this.c;     // Catch: Throwable -> L50
        FLogger.a.i("EarphoneChecker", "initializeToastBaseline headset=" + this.b + ", bluetooth=" + this.c);     // Catch: Throwable -> L50
        Object r18 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L50
    L52:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L61;
        FLogger.a.e("EarphoneChecker", "initializeToastBaseline error: " + r19.getMessage());
        return;
    L61:
        return;
    L50:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L52
    L5:
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L59;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L59:
    L30:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L34;
        ReceiverRegisterCrashOptimizer.registerReceiver(r2, r10);
        goto L35
    L34:
        throw e;
    L8:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L21;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L21;
        int r4 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r2, r10, 0, null, null, 2, r13).result;     // Catch: Exception -> L30
        if (r4 != 1) goto L14;
        r13.registerReceiver(r2, r10);     // Catch: Exception -> L30
    L58:
        goto L35
    L14:
        if (r4 != 2) goto L16;
        new Intent();     // Catch: Exception -> L30
        goto L58
    L16:
        if (r4 == 3) goto L58;
        r13.registerReceiver(r2, r10);     // Catch: Exception -> L30
    L21:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L24;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L30
        r13.registerReceiver(r2, r10, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L30
        goto L58
    L24:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L26;
    L28:
        r13.registerReceiver(r2, r10);     // Catch: Exception -> L30
        goto L58
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L28;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L30
        ContextCompat.registerReceiver(r13, r2, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L30
        goto L58
    }

    public final void b(boolean r6) {
        boolean r1 = false;
        if (this.c == r6) goto L5;
        boolean r0 = true;
    L6:
        RealtimeCallUtil r3 = RealtimeCallUtil.a;
        if (r6 == false) goto L9;
    L10:
        r1 = true;
    L11:
        r3.getClass();
        RealtimeCallUtil.d.setValue(Boolean.valueOf(r1));
        this.c = r6;
        if (r0 == false) goto L15;
        FLogger.a.i("EarphoneChecker", "isBlueToothOn changeTo = " + this.c);
        d();
        return;
    L15:
        return;
    L9:
        if (this.b == false) goto L11;
    L5:
        r0 = false;
        goto L6
    }

    public final void c(boolean r6) {
        boolean r1 = false;
        if (this.b == r6) goto L5;
        boolean r0 = true;
    L6:
        RealtimeCallUtil r3 = RealtimeCallUtil.a;
        if (r6 == false) goto L9;
    L10:
        r1 = true;
    L11:
        r3.getClass();
        RealtimeCallUtil.d.setValue(Boolean.valueOf(r1));
        this.b = r6;
        if (r0 == false) goto L15;
        FLogger.a.i("EarphoneChecker", "isHeadSetOn changeTo = " + this.b);
        d();
        return;
    L15:
        return;
    L9:
        if (this.c == false) goto L11;
    L5:
        r0 = false;
        goto L6
    }
}
