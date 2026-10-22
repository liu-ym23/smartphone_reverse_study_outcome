package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import android.os.SystemClock;
import com.bytedance.android.livesdkapi.performance.IStallCallback;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w1 implements com.bytedance.android.scope.o {
    public static final ReadOnlyProperty g = null;
    public static final ReadOnlyProperty h = null;
    public static final ReadOnlyProperty i = null;
    public static final a j = null;
    public final com.bytedance.android.livesdk.revenue.service.performance.c a;
    public long b;
    public Disposable c;
    public y1 d;
    public boolean e;
    public final b f;

    public static final class a {
        public static final /* synthetic */ KProperty[] a = null;

        static {
            a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, "ENABLE_OPEN_GIFT_PANEL_FPS_MONITOR", "getENABLE_OPEN_GIFT_PANEL_FPS_MONITOR()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "OPEN_GIFT_PANEL_FPS_MONITOR_DURATION", "getOPEN_GIFT_PANEL_FPS_MONITOR_DURATION()J", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "ENABLE_GIFT_PANEL_MONITOR_WINDOW_FPS", "getENABLE_GIFT_PANEL_MONITOR_WINDOW_FPS()Z", 0))};
        }

        public a() {
        }
    }

    public static final class b implements IStallCallback {
        public final /* synthetic */ w1 a;

        public final void onBlockReady(long r1, int r3, long r4) {
        }

        public b(w1 r1) {
            this.a = r1;
        }

        public final void onFpsReady(double r23, JSONObject r25) {
            JSONObject r3 = r25;
            long r4 = SystemClock.uptimeMillis() - this.a.b;
            y1 r6 = new y1(0);
            r6.a = (float) r23;
            float r7 = 0.0f;
            if (r3 == null) goto L24;
            float r10 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.c.class).getFrameIntervalMillis();
            Iterator<String> r11 = r25.keys();
            long r13 = 0;
            long r14 = 0;
            long r16 = 0;
            float r8 = 0.0f;
            float r9 = 0.0f;
        L6:
            if (r11.hasNext() == false) goto L23;
            Iterator<String> r19 = r11;
            String r15 = r11.next();
            int r1 = CastIntegerProtector.parseInt(r15);
            int r2 = r3.optInt(r15);
            if (3 <= r1) goto L11;
        L13:
            long r20 = r4;
            if (7 > r1) goto L20;
            if (13 < r1) goto L20;
            r13 = r13 + ((long) r2);
            r8 = r8 + ((r1 * r2) * r10);
        L22:
            r3 = r25;
            r11 = r19;
            r4 = r20;
        L20:
            if (r1 < 14) goto L22;
            r14 = r14 + ((long) r2);
            r9 = r9 + ((r1 * r2) * r10);
            goto L22
        L11:
            if (6 < r1) goto L13;
            r20 = r4;
            r16 = r16 + ((long) r2);
            r7 = r7 + ((r1 * r2) * r10);
            goto L22
        L23:
            long r21 = r4;
            long r5 = r16;
        L25:
            r6.g = r5;
            r6.h = r7;
            r6.j = r13;
            r6.k = r8;
            r6.m = r14;
            r6.n = r9;
            r6.d = (r5 + r13) + r14;
            float r17 = (r7 + r8) + r9;
            r6.e = r17;
            long r18 = r21;
            r6.c = ((double) r17) / r18;
            float r24 = r18;
            r6.f = r7 / r24;
            r6.i = r8 / r24;
            r6.l = r9 / r24;
            r6.b = r18;
            this.a.d = r6;
            jy0.b.d("ttlive_gift_panel_metrics", "open_gift_panel duration=" + r18 + " fps=" + r23 + " dropFrame=" + r25 + " data=" + r6);
            return;
        L24:
            r21 = r4;
            r5 = 0;
            r13 = 0;
            r14 = 0;
            r8 = 0.0f;
            r9 = 0.0f;
            goto L25
        }
    }

    public final void onStart() {
    }

    static {
        j = new a();
        Boolean r1 = Boolean.TRUE;
        Class r2 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r0 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("enable_open_gift_panel_fps_monitor", r1, r2, false);
        KProperty[] r3 = a.a;
        KProperty r10 = r3[0];
        g = UltraSettingsManager.a().a(r0.a, r0.b, r0.getType(), r0.d, r10);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("open_gift_panel_fps_monitor_duration", 2500L, Long.TYPE, false);
        KProperty r11 = r3[1];
        h = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r11);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("enable_gift_panel_monitor_window_fps", Boolean.FALSE, r2, false);
        KProperty r8 = r3[2];
        i = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r8);
    }

    public final void onStop() {
        if (this.e == true) goto L5;
        this.a.stopMonitorFps("open_gift_panel", this.f);
        this.a.releaseFpsMonitor("open_gift_panel");
    L5:
        Disposable r0 = this.c;
        if (r0 == null) goto L9;
        r0.dispose();
        return;
    }

    public w1() {
        this.a = vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.c.class);
        this.b = -1;
        this.f = new b(this);
    }
}
