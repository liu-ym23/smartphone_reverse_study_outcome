package com.bytedance.android.annie.monitor.lynx;

import android.os.SystemClock;
import android.view.View;
import com.bytedance.android.annie.lynx.f;
import com.bytedance.android.annie.monitor.lynx.glue.MonitorHelper;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.live.browser.AnnieNGInitHelper;
import com.bytedance.android.monitorV2.lynx.jsb.LynxViewMonitorModule;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.q1;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import m8.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieLynxMonitorCallback extends f {
    public static boolean h;
    public static final Lazy<Map<String, String>> i = null;
    public final String b;
    public String c;
    public boolean d;
    public long e;
    public long f;
    public n8.a g;

    public static final class a {
    }

    static {
        h = true;
        i = LazyKt.lazy(AnnieLynxMonitorCallback$Companion$annieMonitorAbConfig$2.INSTANCE);
    }

    @Override // com.bytedance.android.annie.lynx.f, com.bytedance.android.annie.card.base.b
    public final void onLynxEnvInitialized() {
        super.onLynxEnvInitialized();
        this.f = SystemClock.uptimeMillis() - this.e;
    }

    public AnnieLynxMonitorCallback(String r10) {
        Intrinsics.checkNotNullParameter(r10, "bizKey");
        super(null);
        this.b = r10;
        this.c = "";
        this.d = true;
    }

    @Override // com.bytedance.android.annie.lynx.f
    public final void a(LynxViewBuilder r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        Intrinsics.checkNotNullParameter(r10, "builder");
        int r1 = MonitorHelper.a;
        n8.a r11 = new n8.a();
        Intrinsics.checkNotNullParameter(r10, "builder");
        r10.registerModule("hybridMonitor", LynxViewMonitorModule.class, r11.a);
        this.g = r11;
    }

    @Override // com.bytedance.android.annie.lynx.f, com.bytedance.android.annie.card.base.b
    public final void n(LynxView r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.n(r10);
        if ((r10 instanceof LynxView) == false) goto L5;
        LynxView r0 = r10;
    L6:
        if (r0 == null) goto L13;
        JSONObject r11 = new JSONObject();
        r11.put("elapse_ts", this.f);
        JSONObject r12 = new JSONObject();
        if (this.d == false) goto L10;
        String r1 = "1";
    L11:
        r12.put("cold", r1);
        JSONObject r13 = new JSONObject();
        r13.put("virtual_aid", MonitorHelper.c(this.b));
        MonitorHelper.d(r10, "lynx_env_initialize", this.c, r12, r11, null, r13);
        return;
    L10:
        r1 = "0";
        goto L11
    L13:
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.bytedance.android.annie.lynx.f, com.bytedance.android.annie.card.base.b
    public final void onBeforeLynxEnvInitialize(boolean r10) {
        super.onBeforeLynxEnvInitialize(r10);
        this.d = r10;
        this.e = SystemClock.uptimeMillis();
    }

    @Override // com.bytedance.android.annie.lynx.f
    public final void f(LynxView r10, d8.a r11) {
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        Intrinsics.checkNotNullParameter(r11, "lynxMonitorConfig");
        n8.a r1 = this.g;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        r1.a.a = r10;
    L5:
        int r12 = MonitorHelper.a;
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        Intrinsics.checkNotNullParameter(r11, "monitorConfig");
        y9.a r0 = AnnieConfigSettingKeys.HYBRID_MONITOR_CONFIG.a();
        pz2.a r13 = new pz2.a("webcast_cn_container");
        r13.b = r0.a();
        r13.e = MonitorHelper.c("host");
        String r14 = r11.a;
        if (r14 != null) goto L8;
    L11:
        r14 = MonitorHelper.b();
    L12:
        if (r14 != null) goto L14;
    L19:
        r13.j = r11.b;
        com.bytedance.android.monitorV2.lynx_helper.b.a(r10, r13);
        b r15 = c.a.get("host");
        if (r15 == null) goto L41;
        Map<String, String> r16 = r15.b();
        if (r16 == null) goto L41;
        Iterator<T> r17 = r16.entrySet().iterator();
    L25:
        if (r17.hasNext() == false) goto L41;
        Map.Entry r18 = (Map.Entry) r17.next();
        MonitorHelper.a(r10, (String) r18.getKey(), (String) r18.getValue());
    L41:
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L37
        Iterator r20 = ((Map) i.getValue()).entrySet().iterator();     // Catch: Throwable -> L37
    L29:
        if (r20.hasNext() == false) goto L32;
        Map.Entry r21 = (Map.Entry) r20.next();     // Catch: Throwable -> L37
        MonitorHelper.a(r10, (String) r21.getKey(), (String) r21.getValue());     // Catch: Throwable -> L37
        goto L29
    L32:
        if (h == false) goto L34;
        String r22 = "yes";
    L35:
        MonitorHelper.a(r10, "engine_first_open", r22);     // Catch: Throwable -> L37
        h = false;     // Catch: Throwable -> L37
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L37
    L39:
        MonitorHelper.a(r10, "use_new_container", "1");
        return;
    L34:
        r22 = "no";
    L37:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    L14:
        if ((!StringsKt.isBlank(r14)) == true) goto L17;
        r14 = null;
    L17:
        if (r14 == null) goto L19;
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r13.g = r14;
        goto L19
    L8:
        if (StringsKt.isBlank(r14) == false) goto L10;
        r14 = MonitorHelper.b();
    L10:
        if (r14 != null) goto L12;
        goto L11
    }

    @Override // com.bytedance.android.annie.lynx.f, com.bytedance.android.annie.card.base.b
    public final void h(View r10, com.bytedance.android.annie.card.web.resource.a r11) {
        Intrinsics.checkNotNullParameter(r11, "resourceInfo");
        super.h(r10, r11);
        if ((r10 instanceof LynxView) == false) goto L5;
        LynxView r12 = (LynxView) r10;
    L6:
        LynxView r0 = r12;
        if (r0 == null) goto L14;
        String r13 = this.c;
        boolean r14 = r11.a;
        JSONObject r15 = new JSONObject();
        if (r14 == false) goto L11;
        char r16 = '1';
    L12:
        r15.put("offline", Character.valueOf(r16));
        JSONObject r17 = new JSONObject();
        r17.put("virtual_aid", MonitorHelper.c(this.b));
        MonitorHelper.d(r0, "template_offline", r13, r15, null, null, r17);
        return;
    L11:
        r16 = '0';
        goto L12
    L14:
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.bytedance.android.annie.lynx.f
    public final void r(LynxView r10, q1.b r11) {
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        if (r11 == null) goto L10;
        b r12 = c.a.get("host");
        if (r12 == null) goto L11;
        AnnieNGInitHelper.createMonitorProvider.1.providerFpsMonitor.1 r13 = r12.a();
        if (r13 == null) goto L12;
        r13.a(r11.c);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.annie.lynx.f
    public final void s(LynxView r10, q1.b r11) {
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        if (r11 == null) goto L10;
        b r0 = c.a.get("host");
        if (r0 == null) goto L11;
        AnnieNGInitHelper.createMonitorProvider.1.providerFpsMonitor.1 r1 = r0.a();
        if (r1 == null) goto L12;
        r1.b(r11.c, r10, this.c);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.annie.lynx.f, com.bytedance.android.annie.card.base.b
    public final void i(LynxView r1, String r10, String r11) {
        super.i(r1, r10, r11);
        if (r11 == null) goto L6;
        this.c = r11;
        return;
    }

    @Override // com.bytedance.android.annie.lynx.f
    public final void t(String r10, String r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r11, "path");
        super.t(r10, r11, r12, r13);
        JSONObject r14 = new JSONObject();
        r14.put("type", r10);
        r14.put("path", r11);
        JSONObject r15 = new JSONObject();
        r15.put("header_value", r12);
        r15.put("template_size", r13);
        JSONObject r16 = new JSONObject();
        r16.put("virtual_aid", MonitorHelper.c(this.b));
        MonitorHelper.d(null, "lynx_verify_template", r11, r14, null, r15, r16);
    }
}
