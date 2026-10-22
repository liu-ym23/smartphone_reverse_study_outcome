package com.bytedance.android.live.liveinteract.utils;

import android.os.Handler;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.livesdk.config.LiveKtvRealtimeChorusDynamicSettingConfig;
import com.bytedance.android.livesdk.config.wl0;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n1 {
    public static final Handler a = null;
    public static final a b = null;
    public static final boolean c = false;
    public static final long d = 0;
    public static volatile boolean e;
    public static final b f = null;

    public static final class a implements Runnable {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        L19:
            return;
        L3:
            if (n1.e == false) goto L13;
            a r0 = n1.b;     // Catch: Throwable -> L10
            if (r0 == null) goto L17;
            Handler r1 = n1.a;     // Catch: Throwable -> L10
            if (r1 == null) goto L18;
            r1.postDelayed(r0, ((long) 1000) / n1.d);     // Catch: Throwable -> L10
            return;
        L18:
            return;
        L17:
            return;
        }
    }

    public static final class b {
        public b() {
        }

        public static boolean a() {
            if (n1.c == false) goto L17;
            boolean r0 = ((LiveKtvRealtimeChorusDynamicSettingConfig) wl0.a.getValue()).getEnableSwitchStreamOpt();
            IInteractService r2 = (IInteractService) jc1.k.f(IInteractService.class);
            if (r0 == false) goto L13;
            if (r2 != null) goto L8;
        L9:
            if (r2 == null) goto L13;
            if (r2.getCurrentUiLayout() != 62) goto L13;
        L12:
            boolean r1 = true;
        L14:
            if (r1 == true) goto L18;
            return true;
        L18:
            return false;
        L8:
            if (r2.isVideoChorus() == true) goto L12;
        L13:
            r1 = false;
            goto L14
        L17:
            return false;
        }

        public static void b(uf2.d0 r8) {
            if (a() == true) goto L6;
            return;
        L6:
            if (n1.e == false) goto L12;
            if (r8 == null) goto L22;
            uf2.z r9 = r8.C();
            if (r9 == null) goto L23;
            r9.e();
            return;
        L23:
            return;
        L22:
            return;
        L12:
            if (r8 == null) goto L16;
            r8.v();
            Handler r0 = n1.a;
            uf2.z r10 = r8.C();
            if (r10 == null) goto L17;
            r10.e();
        L17:
            Handler r11 = n1.a;
            a r1 = n1.b;
            if (r11 == null) goto L24;
            if (r1 == null) goto L25;
            n1.e = true;
            r11.post(r1);
            return;
        L25:
            return;
        L24:
            return;
        L16:
            TalkRoomBusinessFullLinkMonitor r12 = TalkRoomBusinessFullLinkMonitor.a;
            Throwable r2 = new Throwable("LiveCore is null!");
            r12.getClass();
            Intrinsics.checkNotNullParameter(r2, "throwable");
            JSONObject r3 = new JSONObject();
            r3.put("error_msg", ExceptionsKt.stackTraceToString(r2));
            nd0.c.o(nd0.c.a, LinkMonitorData.SingleViewTriggerTaskException, r3, 0, null, false, 28);
            goto L17
        }

        public static void c(uf2.d0 r3) {
            if (a() == true) goto L5;
            return;
        L5:
            Handler r0 = n1.a;
            a r1 = n1.b;
            if (r0 == null) goto L17;
            if (r1 == null) goto L18;
            n1.e = false;
            r0.removeCallbacks(r1);
            if (r3 == null) goto L19;
            uf2.z r4 = r3.C();
            if (r4 == null) goto L20;
            uf2.z.a r2 = r4.K0();
            if (r2 == null) goto L15;
            r2.name();
        L15:
            r4.e();
            return;
        L20:
            return;
        L19:
            return;
        L18:
            return;
        }
    }

    static {
        f = new b();
        ReadOnlyProperty r0 = vm2.d.E;
        KProperty[] r1 = vm2.d.a;
        c = ((Boolean) r0.getValue(null, r1[28])).booleanValue();
        long r2 = ((Number) vm2.d.F.getValue(null, r1[29])).longValue();
        d = r2;
        PthreadHandlerThreadV2 r3 = new PthreadHandlerThreadV2("TriggerLayer");
        ThreadMethodProxy.start(r3);
        a = new Handler(r3.getLooper());
        if (r2 >= 15) goto L6;
        d = 15;
    L8:
        b = a.a;
        return;
    L6:
        if (r2 <= 30) goto L8;
        d = 30;
        goto L8
    }
}
