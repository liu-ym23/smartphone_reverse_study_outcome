package com.bytedance.android.live.broadcastgame.opengame.sonicgame.checker;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.view.Window;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class PerformanceChecker {
    public final Lazy a;
    public final Lazy b;
    public final na4.b c;
    public final PluginContext d;

    public PerformanceChecker(na4.b r2, PluginContext r3) {
        Intrinsics.checkNotNullParameter(r3, "pluginContext");
        this.c = r2;
        this.d = r3;
        this.a = LazyKt.lazy(new PerformanceChecker$fpsMonitor$2(this));
        this.b = LazyKt.lazy(new PerformanceChecker$blackScreenMonitor$2(this));
    }

    public final void a(final long r14, final boolean r16, final String r17, a r18, final Window r19, boolean r21) {
        Intrinsics.checkNotNullParameter(r17, "loadResult");
        Intrinsics.checkNotNullParameter(r18, "config");
        final c r3 = (c) this.b.getValue();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r17, "loadResult");
        Intrinsics.checkNotNullParameter(r18, "config");
        if (Build.VERSION.SDK_INT < 26) goto L38;
        if (r19 != null) goto L7;
        return;
    L7:
        if (r3.a >= r3.b) goto L44;
        boolean r4 = true;
        if (r3.a != 0) goto L17;
        r3.a++;
        if (r14 < r3.c) goto L15;
        r4 = false;
    L15:
        r3.d = r4;
    L20:
        if (Intrinsics.areEqual(r17, "sonic_game_load_fail") == false) goto L23;
        r3.d = false;
        return;
    L23:
        if (Intrinsics.areEqual(r17, "sonic_game_load_unknown") == true) goto L36;
        if (r16 == false) goto L36;
        final Rect r5 = r18.b();
        if (r5 == null) goto L45;
        final Bitmap r6 = r18.a();
        if (r6 == null) goto L46;
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("game_black_screen_checker");
        ThreadMethodProxy.start(r0);
        final Handler r11 = new Handler(r0.getLooper());
        Function0<Unit> r12 = new GameBlackScreenMonitor$realCheckBlackScreen$detectionTask$1(r3, r19, r5, r6, r16, r14, r17, r11);
        if (r21 == false) goto L35;
        r11.post(new b(r12));
        return;
    L35:
        r12.invoke();
        return;
    L46:
        return;
    L45:
        return;
    L36:
        r3.a(true, r3.a, r16, r14, r17, "uncheck");
        return;
    L17:
        if (r3.d == false) goto L39;
        r3.d = false;
        r3.a++;
        goto L20
    L39:
        return;
    L44:
        return;
    }
}
