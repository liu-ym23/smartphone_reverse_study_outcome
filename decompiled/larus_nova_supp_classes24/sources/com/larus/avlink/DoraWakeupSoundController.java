package com.larus.avlink;

import android.os.SystemClock;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larus.avlink.activeSummary.SoundPlayManager;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class DoraWakeupSoundController {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static volatile boolean d;
    public static volatile long e;
    public static volatile boolean f;
    public static volatile boolean g;
    public static volatile q1 h;

    public DoraWakeupSoundController() {
    }

    static {
        a = LazyKt.lazy(new h1());
        b = LazyKt.lazy(new i1());
        c = LazyKt.lazy(new j1());
    }

    public static final boolean a() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L16;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L16;
        boolean r2 = r1.p0(null);
        if (r1.M() == false) goto L10;
        boolean r3 = r1.I();
    L11:
        boolean r4 = r1.f0();
        n1.d("DoraWakeupSoundController", "canPlayFuzzyVoice: deviceEnable=" + r2 + ", isNaturalConversationOpen=" + r4 + ", isConvStartEndSoundEnabled = " + r3);
        if (r2 == false) goto L16;
        if (r4 == false) goto L16;
        if (r3 == false) goto L16;
        return true;
    L10:
        r3 = true;
    L16:
        return false;
    }

    public static void d() {
        long r0 = SystemClock.elapsedRealtime();
        f = false;
        BuildersKt.launch$default((CoroutineScope) b.getValue(), null, null, new DoraWakeupSoundController$onWakeReject$1(r0, null), 3, null);
    }

    public static final void b(long r7) {
        if (e > 0) goto L5;
        long r0 = -1;
    L6:
        n1.d("DoraWakeupSoundController", "tryPlayWakeRejectVoice, elapsed=" + r0);
        if (r0 <= LKUIToast.DURATION_SHORT) goto L11;
        q1 r1 = new q1("dora_wake_reject_sound_play_duration", r7, -1);
        r1.e = SystemClock.elapsedRealtime();
        g = true;
        h = r1;
        ((SoundPlayManager) c.getValue()).g(AppHost.a.getApplication(), "dora_natural_wake_reject.mp3", "dora_natural_wake_reject.wav", new m1(), r1.l);
        return;
    L11:
        return;
    L5:
        long r2 = e;
        e = 0;
        r0 = SystemClock.elapsedRealtime() - r2;
        goto L6
    }

    public static void c(int r9) {
        long r0 = SystemClock.elapsedRealtime();
        BuildersKt.launch$default((CoroutineScope) b.getValue(), null, null, new DoraWakeupSoundController$onFuzzyWakeup$1(r9, r0, null), 3, null);
    }

    public static void e(int r8) {
        if (r8 == 45) goto L5;
        boolean r0 = true;
    L6:
        f = false;
        BuildersKt.launch$default((CoroutineScope) b.getValue(), null, null, new DoraWakeupSoundController$onWakeupStop$1(r8, r0, null), 3, null);
        return;
    L5:
        r0 = false;
        goto L6
    }
}
