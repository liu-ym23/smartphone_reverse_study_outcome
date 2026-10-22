package rl0;

import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.livesdk.config.LiveInitSettingKeys;
import com.bytedance.android.livesdk.config.b01;
import com.bytedance.android.livesdk.config.g91;
import com.bytedance.android.livesdk.config.n01;
import com.bytedance.android.monitor.HybridMonitor;
import com.bytedance.android.monitor.lynx.LynxMonitor;
import com.bytedance.android.monitor.lynx.jsb.LynxMonitorModule;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.android.monitorV2.lynx.impl.LynxViewDataManager;
import com.bytedance.android.monitorV2.lynx.impl.LynxViewNavigationDataManager;
import com.bytedance.android.monitorV2.lynx.jsb.LynxViewMonitorModule;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.v0;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import py2.j;
import qz2.e;
import vy2.d;
import vy2.f;
import vy2.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final boolean a = false;
    public static final a b = null;

    /* JADX INFO: renamed from: rl0.a$a, reason: collision with other inner class name */
    public static final class C0268a implements rl0.c {
        public final /* synthetic */ com.bytedance.android.monitorV2.lynx.jsb.a a;

        public C0268a(com.bytedance.android.monitorV2.lynx.jsb.a r1) {
            this.a = r1;
        }

        @Override // rl0.c
        public final void a(LynxView r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a.a = r2;
        }
    }

    public static final class b implements rl0.c {
        public final /* synthetic */ xy2.a a;

        public b(xy2.a r1) {
            this.a = r1;
        }

        @Override // rl0.c
        public final void a(LynxView r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a.a = r2;
        }
    }

    public static final class c implements com.bytedance.android.monitor.webview.a {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void a(String r3, JSONObject r4) {
            LiveSlardarMonitor.monitorStatusAndDurationDirect(r3, 0, null, r4);
        }
    }

    public a() {
    }

    static {
        b = new a();
        a = ((Boolean) AnnieConfigSettingKeys.LIVE_HYBRID_USE_MONITOR_SAMPLE_RATE.a()).booleanValue();
    }

    public final void c(LynxView r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        if (a == false) goto L10;
        LynxViewMonitor.b.a.getClass();
        Intrinsics.checkNotNullParameter(r5, "view");
        LynxViewDataManager r6 = LynxViewDataManager.j.a(r5, null);
        if (r6.d() == false) goto L20;
        LynxViewNavigationDataManager r7 = r6.d;
        if (r7 == null) goto L18;
        r7.i();
        return;
    L18:
        return;
    L20:
        return;
    L10:
        LynxMonitor r0 = LynxMonitor.j;
        com.bytedance.android.monitor.lynx.b r1 = r0.h;
        r1.getClass();
        if (com.bytedance.android.monitor.lynx.b.b(r5) == false) goto L21;
        d r2 = r0.c.a(r5);
        if (r2 == null) goto L16;
        r2.c = System.currentTimeMillis();
    L16:
        r1.a(r5);
        return;
    }

    public final void d(LynxView r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        if (a == false) goto L5;
        LynxViewMonitor.b.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "view");
        LynxViewDataManager.j.a(r3, null).g();
        return;
    L5:
        LynxMonitor.j.h.d(r3);
    }

    public final void g(LynxView r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        if (a == false) goto L10;
        LynxViewMonitor.b.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "view");
        LynxViewDataManager r4 = LynxViewDataManager.j.a(r3, null);
        if (r4.d() == false) goto L14;
        LynxViewNavigationDataManager r5 = r4.d;
        if (r5 == null) goto L12;
        r5.m();
        return;
    L12:
        return;
    L14:
        return;
    L10:
        LynxMonitor.j.h.f(r3);
    }

    public final rl0.c h(LynxViewBuilder r5) {
        Intrinsics.checkNotNullParameter(r5, "build");
        if (a == false) goto L6;
        com.bytedance.android.monitorV2.lynx.jsb.a r0 = new com.bytedance.android.monitorV2.lynx.jsb.a(0);
        C0268a r2 = new C0268a(r0);
        r5.registerModule("hybridMonitor", LynxViewMonitorModule.class, r0);
        return r2;
    L6:
        xy2.a r1 = new xy2.a();
        b r3 = new b(r1);
        r5.registerModule("hybridMonitor", LynxMonitorModule.class, r1);
        return r3;
    }

    public final void i(LynxView r8) {
        Intrinsics.checkNotNullParameter(r8, "lynxView");
        if (a == false) goto L11;
        pz2.a r0 = new pz2.a("webcast_cn_container");
        kjc.c r5 = new kjc.c();
        if (2 != kjc.a.a()) goto L8;
        kjc.b r4 = r5.a;
        r4.a = (g91) b01.a.getValue();
        r5.b = true;
    L8:
        if (r5.b == true) goto L10;
        kjc.b r3 = r5.a;
        r3.a = LiveInitSettingKeys.get_LIVW_WEBVIEW_MONITOR_CONFIG();
    L10:
        r0.b = ((g91) r5.a.a).e();
        r0.e = "88888";
        LynxViewMonitor r2 = LynxViewMonitor.b;
        r2.getClass();
        LynxViewMonitor.i(r8, r0);
        Integer r1 = Integer.valueOf(com.bytedance.android.livesdk.paas.c.b());
        r2.getClass();
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter("webcast_sdk_version", "key");
        Intrinsics.checkNotNullParameter(r1, "o");
        LynxViewMonitor.g(r8, "webcast_sdk_version", r1.toString());
        return;
    L11:
        uy2.b r6 = new uy2.b(c.a);
        kjc.c r7 = new kjc.c();
        if (2 != kjc.a.a()) goto L15;
        kjc.b r9 = r7.a;
        r9.a = (g91) b01.a.getValue();
        r7.b = true;
    L15:
        if (r7.b == true) goto L17;
        kjc.b r10 = r7.a;
        r10.a = LiveInitSettingKeys.get_LIVW_WEBVIEW_MONITOR_CONFIG();
    L17:
        g91 r11 = (g91) r7.a.a;
        r6.b = r11.e();
        r6.c = r11.d();
        r6.d = r11.a();
        r6.e = r11.c();
        r6.f = r11.b();
        r6.h = "88888";
        LynxMonitor r12 = LynxMonitor.j;
        ((WeakHashMap) r12.a.a).put(r8, r6);
        r12.c(r8, "webcast_sdk_version", Integer.valueOf(com.bytedance.android.livesdk.paas.c.b()));
    }

    public static void f(LynxView r3, LynxError r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        if (a == false) goto L8;
        LynxViewMonitor r0 = LynxViewMonitor.b;
        e r1 = new e();
        if (r4 == null) goto L7;
        r1.c = r4.getErrorCode();
        r1.d = r4.getMsg();
    L7:
        r0.getClass();
        LynxViewMonitor.l(r3, r1, null);
        return;
    L8:
        LynxMonitor r2 = LynxMonitor.j;
        f r5 = new f();
        if (r4 == null) goto L11;
        r5.c = r4.getErrorCode();
        r5.d = r4.getMsg();
    L11:
        r2.k(r3, r5);
    }

    public final void b(v0 r5, LynxView r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        if (a == false) goto L6;
        if (r5 == null) goto L9;
        com.bytedance.android.monitorV2.lynx.a r7 = LynxViewMonitor.b.a;
        b.getClass();
        qz2.f r1 = new qz2.f();
        r1.b = 0.0d;
        r1.c = 0.0d;
        r1.d = 0.0d;
        r1.e = 0.0d;
        r1.f = 0.0d;
        r1.g = 0.0d;
        r1.h = 0.0d;
        r1.i = 0.0d;
        r1.j = 0.0d;
        r1.k = 0.0d;
        r1.m = new JSONObject();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r1, "lynxPerfData");
        Intrinsics.checkNotNullParameter(r6, "view");
        LynxViewDataManager.j.a(r6, null).f(r1);
        return;
    L9:
        return;
    L6:
        if (r5 == null) goto L11;
        com.bytedance.android.monitor.lynx.b r8 = LynxMonitor.j.h;
        b.getClass();
        g r0 = new g();
        r0.b = 0.0d;
        r0.c = 0.0d;
        r0.d = 0.0d;
        r0.e = 0.0d;
        r0.f = 0.0d;
        r0.g = 0.0d;
        r0.h = 0.0d;
        r0.i = 0.0d;
        r0.j = 0.0d;
        r0.k = 0.0d;
        r0.m = new JSONObject();
        r8.c(r0, r6);
        return;
    }

    public final void e(String r3, LynxView r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        if (a == false) goto L5;
        LynxViewMonitor.b.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "view");
        LynxViewDataManager.j.a(r4, null).h(r3);
        return;
    L5:
        LynxMonitor.j.h.e(r3, r4);
    }

    public final void l(LynxView r4, j r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "jsbInfo");
        LynxMonitor r0 = LynxMonitor.j;
        uy2.b r1 = r0.a.a(r4);
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.e == false) goto L13;
        LynxMonitor.e().getClass();
        vy2.b r2 = r0.b.c(r4);
        if (r2 == null) goto L12;
        Map r3 = az2.a.a;
        LynxMonitor.f(r2, az2.a.d(r4), r5, r1, null);
        return;
    L12:
        return;
    }

    public final void a(LynxView r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        if (a == false) goto L5;
        LynxViewMonitor.b.getClass();
        LynxViewMonitor.g(r2, r3, r4);
        return;
    L5:
        LynxMonitor.j.c(r2, r3, r4);
    }

    public final void j(LynxView r14, String r15, String r16, JSONObject r17, JSONObject r18, JSONObject r19, JSONObject r20, boolean r21) {
        kjc.c r0 = new kjc.c();
        boolean r3 = true;
        if (2 != kjc.a.a()) goto L6;
        kjc.b r1 = r0.a;
        LynxMonitor.j.j(r14, r15, r16, r17, r18, r19, r20, r21);
        r1.a = Unit.INSTANCE;
        r0.b = true;
    L6:
        if (r0.b == true) goto L31;
        kjc.b r2 = r0.a;
        if (((Boolean) n01.a.getValue()).booleanValue() == false) goto L29;
        HybridMonitor r4 = HybridMonitor.getInstance();
        if (r16 == null) goto L16;
        if (r16.length() == 0) goto L16;
        r3 = false;
    L16:
        if (r3 == false) goto L20;
        if (r14 == null) goto L19;
        String r5 = r14.getTemplateUrl();
    L21:
        if (r20 != null) goto L23;
        JSONObject r6 = new JSONObject();
    L24:
        py2.d r7 = new py2.d();
        r7.c = r15;
        r7.a = r5;
        r7.b = "webcast";
        r7.d = r17;
        r7.e = r18;
        if (r19 == null) goto L27;
        JSONObject r8 = r19;
    L28:
        r7.f = r8;
        r7.g = null;
        r7.h = r6;
        r7.j = r21;
        r7.i = null;
        r7.k = HybridMonitor.getInstance().getCustomReportMonitor();
        r4.customReport(r7);
    L30:
        r2.a = Unit.INSTANCE;
        goto L31
    L27:
        r8 = new JSONObject();
        goto L28
    L23:
        r6 = r20;
        goto L24
    L19:
        r5 = null;
        goto L21
    L20:
        r5 = r16;
        goto L21
    L29:
        LynxMonitor.j.j(r14, r15, r16, r17, r18, r19, r20, r21);
    L31:
        Object r9 = r0.a.a;
    }

    public final void k(LynxView r2, String r3, String r4, JSONObject r5, JSONObject r6, JSONObject r7, JSONObject r8, int r9) {
        LynxViewMonitor.b.getClass();
        LynxViewMonitor.j(r2, r3, r4, r5, r6, r7, r8, r9);
    }
}
