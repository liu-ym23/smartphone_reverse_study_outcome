package com.bytedance.android.live.lynx.callback;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.lynx.f;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.livesdk.config.fs;
import com.bytedance.android.livesdk.config.q70;
import com.bytedance.android.livesdkapi.performance.IStallCallback;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.bytedance.android.monitor.lynx.LynxMonitor;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.q1;
import com.lynx.tasm.v0;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import rl0.b;
import rl0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class AnnieLynxMonitorCallback extends f {
    public c b;
    public String c;
    public boolean d;
    public long e;
    public long f;
    public final boolean g;
    public final Lazy h;

    public static final class a implements IStallCallback {
        public final /* synthetic */ q1.b a;
        public final /* synthetic */ AnnieLynxMonitorCallback b;

        public final void onBlockReady(long r1, int r3, long r4) {
        }

        public a(q1.b r1, AnnieLynxMonitorCallback r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onFpsReady(double r13, JSONObject r15) {
            AnnieLynxMonitorCallback r16 = this.b;
            Context r0 = this.a.a.getContext();
            String r1 = this.a.c;
            boolean r11 = ((Boolean) q70.a.getValue()).booleanValue();
            r16.getClass();
            JSONObject r8 = new JSONObject();
            r8.put("fps", r13);
            JSONObject r14 = new JSONObject();
            r14.put("tag", r1);
            r14.put("annie", "1");
            Object r17 = r0.getSystemService("window");
            if (r17 == null) goto L12;
            r14.put("refresh_rate", String.valueOf((int) ((WindowManager) r17).getDefaultDisplay().getRefreshRate()));
            JSONObject r18 = new JSONObject();
            r18.put("virtual_aid", "88888");
            if (r16.g == false) goto L9;
            if (r11 == false) goto L8;
            int r2 = b.a;
            rl0.a.b.k(null, "lynx_list_fps", r16.c, r14, r8, null, r18, 2);
            return;
        L8:
            int r3 = b.a;
            rl0.a.b.k(null, "lynx_list_fps", r16.c, r14, r8, null, r18, 0);
            return;
        L9:
            int r4 = b.a;
            rl0.a.b.j(null, "lynx_list_fps", r16.c, r14, r8, null, r18, r11);
            return;
        L12:
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
    }

    public AnnieLynxMonitorCallback() {
        super(null);
        this.c = "";
        this.d = true;
        this.g = ((Boolean) AnnieConfigSettingKeys.LIVE_HYBRID_USE_MONITOR_SAMPLE_RATE.a()).booleanValue();
        this.h = InfraKotlinExtsKt.mainThreadLazy(AnnieLynxMonitorCallback$hostPerformanceManager$2.INSTANCE);
    }

    public final void onLynxEnvInitialized() {
        super.onLynxEnvInitialized();
        this.f = SystemClock.uptimeMillis() - this.e;
    }

    public final void a(LynxViewBuilder r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        Intrinsics.checkNotNullParameter(r2, "builder");
        int r0 = b.a;
        this.b = rl0.a.b.h(r2);
    }

    public final void e(LynxView r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        int r0 = b.a;
        rl0.a.b.d(r2);
    }

    public final void n(LynxView r11) {
        Intrinsics.checkNotNullParameter(r11, "lynxView");
        super.n(r11);
        if ((r11 instanceof LynxView) == false) goto L13;
        int r0 = b.a;
        rl0.a r1 = rl0.a.b;
        r1.c(r11);
        JSONObject r6 = new JSONObject();
        r6.put("elapse_ts", this.f);
        JSONObject r5 = new JSONObject();
        if (this.d == false) goto L7;
        String r2 = "1";
    L8:
        r5.put("cold", r2);
        JSONObject r8 = new JSONObject();
        r8.put("virtual_aid", "88888");
        if (this.g == false) goto L11;
        r1.k(r11, "lynx_env_initialize", this.c, r5, r6, null, r8, 0);
        return;
    L11:
        r1.j(r11, "lynx_env_initialize", this.c, r5, r6, null, r8, false);
        return;
    L7:
        r2 = "0";
        goto L8
    }

    public final void o(LynxView r3) {
        Intrinsics.checkNotNullParameter(r3, "lynxView");
        Intrinsics.checkNotNullParameter(r3, "lynxView");
        int r0 = b.a;
        rl0.a.b.getClass();
        Intrinsics.checkNotNullParameter(r3, "view");
        if (rl0.a.a == false) goto L5;
        LynxViewMonitor.b.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "view");
        return;
    L5:
        LynxMonitor.j.h.getClass();
        com.bytedance.android.monitor.lynx.b.b(r3);
    }

    public final void onBeforeLynxEnvInitialize(boolean r3) {
        super.onBeforeLynxEnvInitialize(r3);
        this.d = r3;
        this.e = SystemClock.uptimeMillis();
    }

    public final void p(LynxView r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        int r0 = b.a;
        rl0.a.b.getClass();
        Intrinsics.checkNotNullParameter(r2, "view");
    }

    public final void d(LynxView r2, v0 r3) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        int r0 = b.a;
        rl0.a.b.b(r3, r2);
    }

    public final void f(LynxView r3, d8.a r4) {
        Intrinsics.checkNotNullParameter(r3, "lynxView");
        Intrinsics.checkNotNullParameter(r4, "lynxMonitorConfig");
        super.f(r3, r4);
        int r5 = b.a;
        rl0.a.b.i(r3);
        rl0.a.b.a(r3, "use_new_container", "1");
        rl0.a.b.a(r3, "container_version", String.valueOf(Annie.getAnnieVersionCode()));
        c r6 = this.b;
        if (r6 == null) goto L6;
        r6.a(r3);
        return;
    }

    public final void g(View r1, String r2) {
        if ((r1 instanceof LynxView) == false) goto L6;
        int r3 = b.a;
        rl0.a.b.g((LynxView) r1);
        return;
    }

    public final void onTemplateLoaded(View r10, boolean r11) {
        super.onTemplateLoaded(r10, r11);
        String r3 = this.c;
        JSONObject r4 = new JSONObject();
        r4.put("offline", String.valueOf(r11 ? 1 : 0));
        JSONObject r7 = new JSONObject();
        r7.put("virtual_aid", "88888");
        if (this.g == false) goto L5;
        int r12 = b.a;
        rl0.a.b.k(null, "template_offline", r3, r4, null, null, r7, 0);
        return;
    L5:
        int r13 = b.a;
        rl0.a.b.j(null, "template_offline", r3, r4, null, null, r7, false);
    }

    public final void q(LynxView r3, LynxError r4) {
        Intrinsics.checkNotNullParameter(r3, "lynxView");
        Intrinsics.checkNotNullParameter(r3, "lynxView");
        int r0 = b.a;
        rl0.a r1 = rl0.a.b;
        if ((r1 instanceof rl0.a) == true) goto L5;
        r1 = null;
    L5:
        if (r1 == null) goto L8;
        rl0.a.f(r3, r4);
        return;
    }

    public final void r(LynxView r2, q1.b r3) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        if (((Boolean) fs.a.getValue()).booleanValue() == false) goto L9;
        if (r3 == null) goto L10;
        IPerformanceManager r4 = (IPerformanceManager) this.h.getValue();
        if (r4 == null) goto L11;
        r4.startMonitorFps(r3.c);
        return;
    L11:
        return;
    L10:
        return;
    }

    public final void s(LynxView r3, q1.b r4) {
        Intrinsics.checkNotNullParameter(r3, "lynxView");
        Intrinsics.checkNotNullParameter(r3, "lynxView");
        if (((Boolean) fs.a.getValue()).booleanValue() == false) goto L12;
        if (r4 == null) goto L13;
        IPerformanceManager r5 = (IPerformanceManager) this.h.getValue();
        if (r5 == null) goto L8;
        r5.stopMonitorFps(r4.c, new a(r4, this));
    L8:
        IPerformanceManager r6 = (IPerformanceManager) this.h.getValue();
        if (r6 == null) goto L14;
        r6.releaseFpsMonitor(r4.c);
        return;
    L14:
        return;
    L13:
        return;
    }

    public final void i(LynxView r1, String r2, String r3) {
        super.i(r1, r2, r3);
        if (r3 == null) goto L6;
        this.c = r3;
        return;
    }

    public final void j(View r1, String r2, String r3) {
        super.j(r1, r2, r3);
    }

    public final void k(View r1, String r2, Bitmap r3, boolean r4) {
        super.k(r1, r2, r3, r4);
        if ((r1 instanceof LynxView) == false) goto L6;
        int r5 = b.a;
        rl0.a.b.e(r2, (LynxView) r1);
        return;
    }

    public final void t(String r12, String r13, int r14, int r15) {
        Intrinsics.checkNotNullParameter(r12, "type");
        Intrinsics.checkNotNullParameter(r13, "path");
        JSONObject r6 = new JSONObject();
        r6.put("type", r12);
        r6.put("path", r13);
        JSONObject r8 = new JSONObject();
        r8.put("header_value", r14);
        r8.put("template_size", r15);
        JSONObject r9 = new JSONObject();
        r9.put("virtual_aid", "88888");
        if (this.g == false) goto L5;
        int r16 = b.a;
        rl0.a.b.k(null, "lynx_verify_template", r13, r6, null, r8, r9, 0);
        return;
    L5:
        int r17 = b.a;
        rl0.a.b.j(null, "lynx_verify_template", r13, r6, null, r8, r9, false);
    }
}
