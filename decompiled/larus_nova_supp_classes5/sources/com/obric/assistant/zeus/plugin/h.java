package com.obric.assistant.zeus.plugin;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import com.obric.activeness.IObricActivenessMonitorService;
import com.obric.activeness.ObricActiveReason;
import com.obric.assistant.t1;
import com.volcengine.zeus.PluginGroundProvider;
import com.volcengine.zeus.plugin.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h extends PluginGroundProvider implements k9a.b {
    public static final h a = null;
    public static final Handler b = null;
    public static final f c = null;
    public static final Lazy<IObricActivenessMonitorService> d = null;

    public final void b() {
        Long r0 = null;
        if (isForeground(null) == false) goto L6;
        FLogger.a.i("ZeusGroundProvider", "skip delayed dex2oat because is active");
        return;
    L6:
        Long r1 = Long.valueOf(t1.a.getObricZeusAutoFetchConfig().getDex2oatBootGuardMillis());
        if (r1.longValue() < 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
        r0 = r1;
    L12:
        if (r0 == null) goto L14;
        long r2 = r0.longValue();
    L15:
        long r4 = r2 - SystemClock.elapsedRealtime();
        if (r4 <= 0) goto L19;
        Handler r5 = b;
        f r6 = c;
        r5.removeCallbacks(r6);
        r5.postDelayed(r6, r4);
        FLogger.a.i("ZeusGroundProvider", "delay dex2oat for " + r4 + " ms after boot");
        return;
    L19:
        b.removeCallbacks(c);
        gqc.b.a().b();
        FLogger.a.i("ZeusGroundProvider", "performSecondaryDex2Oat33P");
        return;
    L14:
        r2 = 900000;
        goto L15
    L9:
        r3 = false;
        goto L10
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.assistant.zeus.plugin.f] */
    static {
        a = new h();
        b = new Handler(Looper.getMainLooper());
        c = new f();
        d = LazyKt.lazy(new g());
    }

    public h() {
    }

    @Override // com.volcengine.zeus.PluginGroundProvider
    public final boolean isForeground(String r5) {
        Lazy<IObricActivenessMonitorService> r6 = d;
        if (r6.isInitialized() == true) goto L6;
        return true;
    L6:
        return ((IObricActivenessMonitorService) r6.getValue()).a(SetsKt.setOf(new ObricActiveReason[]{ObricActiveReason.DEVICE_SCREEN_ON, ObricActiveReason.PLUGIN_UPDATE}));
    }

    public final void a(boolean r4, ObricActiveReason r5) {
        Intrinsics.checkNotNullParameter(r5, "stateChangeReason");
        FLogger.a.d("ZeusGroundProvider", "awareness changed " + r4 + ", reason = " + r5);
        i.b();
        if (r4 == false) goto L5;
        b.removeCallbacks(c);
        return;
    L5:
        b();
    }
}
