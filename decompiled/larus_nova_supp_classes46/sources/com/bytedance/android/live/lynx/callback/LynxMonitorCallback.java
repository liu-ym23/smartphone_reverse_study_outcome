package com.bytedance.android.live.lynx.callback;

import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.lynx.components.l;
import com.bytedance.android.live.lynx.monitor.LynxMonitor;
import com.bytedance.android.livesdk.config.na;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.v0;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import rl0.a;
import rl0.b;
import rl0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LynxMonitorCallback extends l {
    public String a;
    public String b;
    public long c;
    public long d;
    public long e;
    public long f;
    public int g;
    public int h;
    public boolean i;
    public v0 j;
    public v0 k;
    public c l;
    public final Lazy m;

    public LynxMonitorCallback() {
        this.a = "";
        this.b = "";
        this.m = InfraKotlinExtsKt.mainThreadLazy(LynxMonitorCallback$hostPerformanceManager$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.lynx.components.l
    public final void j() {
        v.a();
        boolean r0 = LynxMonitor.a;
        int r1 = !this.i ? 1 : 0;
        Pair<String, ? extends Object>[] r2 = new Pair[2];
        r2[0] = TuplesKt.to("ev_type", "performance");
        JSONObject r3 = new JSONObject();
        JSONObject r5 = new JSONObject();
        r5.put("initStart", this.c);
        r5.put("pageStart", this.d);
        r5.put("loadEnd", this.f);
        r5.put("firstScreen", this.e);
        Unit r6 = Unit.INSTANCE;
        r3.put("navigation", r5);
        if (this.j == null) goto L5;
        Object r7 = new JSONObject();
    L6:
        r3.put("performance", r7);
        r2[1] = TuplesKt.to("event", r3);
        Map<String, Object> r4 = n(r2);
        Intrinsics.checkNotNullParameter(r4, "extra");
        r4.put("lynx_version", LynxEnv.inst().getLynxVersion());
        LiveSlardarMonitor.monitorStatus("ttlive_lynx_overview_service", r1, r4);
        return;
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.lynx.components.l
    public final void a(LynxViewBuilder r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        Intrinsics.checkNotNullParameter(r2, "builder");
        v.a();
        int r0 = b.a;
        this.l = a.b.h(r2);
    }

    @Override // com.bytedance.android.live.lynx.components.l
    public final void d(LynxView r10) {
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        v.a();
        int r0 = b.a;
        a.b.c(r10);
        long r1 = System.currentTimeMillis();
        this.e = r1;
        boolean r11 = LynxMonitor.a;
        long r2 = r1 - this.d;
        Pair<String, ? extends Object>[] r12 = new Pair[2];
        r12[0] = TuplesKt.to("ev_type", "performance");
        JSONObject r3 = new JSONObject();
        JSONObject r5 = new JSONObject();
        r5.put("initStart", this.c);
        r5.put("pageStart", this.d);
        r5.put("loadEnd", this.f);
        r5.put("firstScreen", this.e);
        Unit r6 = Unit.INSTANCE;
        r3.put("navigation", r5);
        if (this.k == null) goto L5;
        r3.put("performance", new JSONObject());
    L5:
        r12[1] = TuplesKt.to("event", r3);
        Map<String, Object> r13 = n(r12);
        Intrinsics.checkNotNullParameter(r13, "extra");
        r13.put("lynx_version", LynxEnv.inst().getLynxVersion());
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_lynx_first_screen", 0, r2, r13);
    }

    @Override // com.bytedance.android.live.lynx.components.l
    public final void e(LynxView r6) {
        Intrinsics.checkNotNullParameter(r6, "lynxView");
        Intrinsics.checkNotNullParameter(r6, "lynxView");
        v.a();
        int r0 = b.a;
        a.b.d(r6);
        this.i = true;
        this.f = System.currentTimeMillis();
        boolean r7 = LynxMonitor.a;
        long r1 = System.currentTimeMillis() - this.d;
        Map<String, Object> r2 = n(new Pair[0]);
        Intrinsics.checkNotNullParameter(r2, "extra");
        r2.put("lynx_version", LynxEnv.inst().getLynxVersion());
        LiveSlardarMonitor.monitorStatusAndDuration(LiveSlardarConstants.suffixAll("ttlive_lynx_page_load"), 0, r1, r2);
    }

    @Override // com.bytedance.android.live.lynx.components.l
    public final void f(LynxView r4) {
        Intrinsics.checkNotNullParameter(r4, "lynxView");
        Intrinsics.checkNotNullParameter(r4, "lynxView");
        v.a();
        int r0 = b.a;
        a.b.i(r4);
        a.b.a(r4, "use_new_container", "0");
        c r1 = this.l;
        if (r1 == null) goto L6;
        r1.a(r4);
        return;
    }

    @Override // com.bytedance.android.live.lynx.components.l
    public final void k(LynxView r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        v.a();
        int r0 = b.a;
        a.b.g(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map<String, Object> n(Pair<String, ? extends Object>... r7) {
        Pair[] r0 = new Pair[5];
        int r2 = 0;
        r0[0] = TuplesKt.to("ts", Long.valueOf(System.currentTimeMillis()));
        if (this.g >= 2) goto L5;
        boolean r1 = true;
    L6:
        r0[1] = TuplesKt.to("isFirstTime", Boolean.valueOf(r1));
        r0[2] = TuplesKt.to("offline", Integer.valueOf(this.h));
        r0[3] = TuplesKt.to("template_url", this.a);
        r0[4] = TuplesKt.to("path", this.b);
        Map<String, Object> r3 = MapsKt.mutableMapOf(r0);
        int r4 = r7.length;
    L7:
        if (r2 >= r4) goto L9;
        Pair<String, ? extends Object> r5 = r7[r2];
        r3.put(r5.getFirst(), r5.getSecond());
        r2 = r2 + 1;
        goto L7
    L9:
        return r3;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.lynx.components.l
    public final void c(LynxView r2, v0 r3) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        v.a();
        this.k = r3;
        int r0 = b.a;
        a.b.b(r3, r2);
    }

    @Override // com.bytedance.android.live.lynx.components.l
    public final void g(LynxView r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "lynxView");
        Intrinsics.checkNotNullParameter(r5, "lynxView");
        v.a();
        int r0 = b.a;
        a.b.e(r6, r5);
        this.d = System.currentTimeMillis();
        boolean r7 = LynxMonitor.a;
        long r8 = System.currentTimeMillis() - this.c;
        Map<String, Object> r1 = n(new Pair[0]);
        Intrinsics.checkNotNullParameter(r1, "extra");
        r1.put("lynx_version", LynxEnv.inst().getLynxVersion());
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_lynx_page_start", 0, r8, r1);
    }

    @Override // com.bytedance.android.live.lynx.components.l
    public final void h(LynxView r12, LynxError r13) {
        Intrinsics.checkNotNullParameter(r12, "lynxView");
        Intrinsics.checkNotNullParameter(r12, "lynxView");
        v.a();
        int r0 = b.a;
        a r1 = a.b;
        if ((r1 instanceof a) == true) goto L5;
        r1 = null;
    L5:
        if (r1 == null) goto L8;
        a.f(r12, r13);
    L8:
        if (r13 == null) goto L10;
        int r2 = r13.getErrorCode();
    L11:
        if (r13 == null) goto L14;
        String r14 = r13.getMsg();
        if (r14 == null) goto L14;
    L16:
        if (r2 == 102) goto L18;
        if (r2 == 102) goto L18;
        return;
    L18:
        this.i = false;
        this.f = System.currentTimeMillis();
        boolean r3 = LynxMonitor.a;
        long r4 = System.currentTimeMillis() - this.d;
        Map<String, Object> r5 = n(new Pair[]{TuplesKt.to("err_msg", r14)});
        Intrinsics.checkNotNullParameter(r5, "extra");
        r5.put("lynx_version", LynxEnv.inst().getLynxVersion());
        LiveSlardarMonitor.monitorStatusAndDuration(LiveSlardarConstants.suffixAll("ttlive_lynx_page_load"), 1, r4, r5);
        long r6 = System.currentTimeMillis() - this.d;
        Map<String, Object> r7 = n(new Pair[]{TuplesKt.to("err_code", Integer.valueOf(r2)), TuplesKt.to("err_msg", r14), TuplesKt.to("type", 2)});
        Intrinsics.checkNotNullParameter(r7, "extra");
        r7.put("lynx_version", LynxEnv.inst().getLynxVersion());
        LiveSlardarMonitor.monitorStatusAndDuration(LiveSlardarConstants.suffixError("ttlive_lynx_page_load"), 1, r6, r7);
        LocalTestManager.a(new Class[]{wy.a.class});
        if (LynxEnv.inst().hasInited() == true) goto L21;
        LynxMonitor.FallbackType r15 = LynxMonitor.FallbackType.INIT_FAILED;
    L22:
        LynxMonitor.b(r15, r14, this.b, r2, 16);
        return;
    L21:
        r15 = LynxMonitor.FallbackType.LOAD_FAILED;
    L14:
        r14 = "";
        goto L16
    L10:
        r2 = 0;
        goto L11
    }

    @Override // com.bytedance.android.live.lynx.components.l
    public final void i(LynxView r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "lynxView");
        Intrinsics.checkNotNullParameter(r3, "lynxView");
        v.a();
        int r0 = b.a;
        a.b.getClass();
        Intrinsics.checkNotNullParameter(r3, "view");
        if (((Boolean) na.a.getValue()).booleanValue() == false) goto L6;
        boolean r5 = LynxMonitor.a;
        Map<String, Object> r6 = n(new Pair[]{TuplesKt.to("err_log", r4)});
        Intrinsics.checkNotNullParameter(r6, "extra");
        r6.put("lynx_version", LynxEnv.inst().getLynxVersion());
        LiveSlardarMonitor.monitorStatus("ttlive_lynx_error", 0, r6);
        return;
    }

    @Override // com.bytedance.android.live.lynx.components.l
    public final void l(LynxView r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        v.a();
        this.h = r11 ? 1 : 0;
        boolean r12 = LynxMonitor.a;
        int r13 = 1;
        if (r11 != true) goto L5;
        r13 = 0;
    L5:
        Map<String, Object> r14 = n(new Pair[0]);
        Intrinsics.checkNotNullParameter(r14, "extra");
        r14.put("lynx_version", LynxEnv.inst().getLynxVersion());
        LiveSlardarMonitor.monitorStatus("ttlive_lynx_offline", r13, r14);
        int r15 = this.h;
        Map<String, Object> r16 = n(new Pair[0]);
        Intrinsics.checkNotNullParameter(r16, "extra");
        r16.put("lynx_version", LynxEnv.inst().getLynxVersion());
        LiveSlardarMonitor.monitorStatus("ttlive_lynx_offline_v2", r15, r16);
        Object r17 = r16.get("path");
        if ((r17 instanceof String) == true) goto L8;
        r17 = null;
    L8:
        String r3 = (String) r17;
        JSONObject r4 = new JSONObject();
        r4.put("offline", String.valueOf(r15));
        JSONObject r7 = new JSONObject();
        r7.put("virtual_aid", "88888");
        if (LynxMonitor.a == false) goto L11;
        int r18 = b.a;
        a.b.k(null, "template_offline", r3, r4, null, null, r7, 0);
        return;
    L11:
        int r19 = b.a;
        a.b.j(null, "template_offline", r3, r4, null, null, r7, false);
    }

    @Override // com.bytedance.android.live.lynx.components.l
    public final void m(LynxView r8, v0 r9) {
        Intrinsics.checkNotNullParameter(r8, "lynxView");
        Intrinsics.checkNotNullParameter(r8, "lynxView");
        v.a();
        this.j = r9;
        boolean r10 = LynxMonitor.a;
        Pair<String, ? extends Object>[] r11 = new Pair[2];
        r11[0] = TuplesKt.to("ev_type", "performance");
        JSONObject r0 = new JSONObject();
        JSONObject r3 = new JSONObject();
        r3.put("initStart", this.c);
        r3.put("pageStart", this.d);
        r3.put("loadEnd", this.f);
        r3.put("firstScreen", this.e);
        Unit r4 = Unit.INSTANCE;
        r0.put("navigation", r3);
        if (r9 == null) goto L5;
        JSONObject r12 = new JSONObject();
    L6:
        r0.put("performance", r12);
        r11[1] = TuplesKt.to("event", r0);
        Map<String, Object> r13 = n(r11);
        Intrinsics.checkNotNullParameter(r13, "extra");
        r13.put("lynx_version", LynxEnv.inst().getLynxVersion());
        LiveSlardarMonitor.monitorStatus("ttlive_lynx_update_page", 0, r13);
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.lynx.components.l
    public final void b(LynxView r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "lynxView");
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r5, "path");
        super.b(r3, r4, r5);
        this.g++;
        this.c = System.currentTimeMillis();
        this.a = r4;
        this.b = r5;
    }
}
