package i8;

import android.os.Bundle;
import android.view.View;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.param.AnnieViewType;
import com.bytedance.android.annie.api.resource.AnnieResType;
import com.bytedance.android.annie.param.AnnieXLiveContext;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.monitorV2.AnnieXMonitorConstants;
import com.bytedance.android.monitorV2.exception.HybridCrashHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import y9.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends b7.a {
    public static boolean e;
    public static boolean f;
    public static boolean g;
    public String a;
    public final boolean b;
    public c7.a c;
    public boolean d;

    public static final class a {
    }

    static {
        e = true;
        f = true;
        g = true;
    }

    @Override // b7.a, b7.b
    public final void onBeforeGlobalPropsInitialize() {
        c("prepare_component_global_props_start");
    }

    @Override // b7.a, b7.b
    public final void onBeforeInitialPropsInitialize() {
        c("prepare_component_initial_props_start");
    }

    @Override // b7.a, b7.b
    public final void onBeforeJsbRegister() {
        c("prepare_component_jsb_start");
    }

    @Override // b7.a, b7.b
    public final void onBeforeOpenContainer() {
        String r1 = "webcast_cn";
        if (this.b == true) goto L5;
        az2.a r0 = az2.e.a;
        String r10 = bz2.g.a();
        ty2.a.d();
        this.a = r10;
        c7.a r11 = this.c;
        if (r11 == null) goto L75;
        r11.setMonitorID(r10);
    L75:
        az2.e.c(this.a, "container_name", "webcast_cn");
        az2.e.b(this.a, "open_time", a(this, "open_time"));
        return;
    L5:
        if (this.d == true) goto L11;
        c7.a r12 = this.c;
        if (r12 == null) goto L10;
        String r13 = r12.getUuid();
        if (r13 == null) goto L10;
    L12:
        this.a = r13;
        c7.a r14 = this.c;
        if (r14 == null) goto L77;
        r14.setMonitorID(r13);
    L77:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L22
        Iterator<Map.Entry<String, String>> r16 = AnnieConfigSettingKeys.ANNIE_MONITOR_AB_CONFIG.a().entrySet().iterator();     // Catch: Throwable -> L22
    L18:
        if (r16.hasNext() == false) goto L20;
        Map.Entry<String, String> r17 = r16.next();     // Catch: Throwable -> L22
        String r18 = r17.getKey();     // Catch: Throwable -> L22
        String r19 = r17.getValue();     // Catch: Throwable -> L22
        sz2.e r20 = g.a;     // Catch: Throwable -> L22
        g.b(this.a, r18, r19);     // Catch: Throwable -> L22
        goto L18
    L20:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        sz2.e r21 = g.a;
        String r22 = this.a;
        if ((this.c instanceof AnnieXLiveContext) == false) goto L27;
        r1 = "AnnieX";
    L27:
        g.d(r22, "container_name", r1);
        g.c(this.a, "open_time", a(this, "open_time"));
        String r23 = this.a;
        c7.a r24 = this.c;
        String r25 = null;
        if ((r24 instanceof com.bytedance.android.annie.param.a) == false) goto L30;
        com.bytedance.android.annie.param.a r26 = (com.bytedance.android.annie.param.a) r24;
    L32:
        if (r26 == null) goto L34;
        int r27 = r26.c;
    L35:
        Intrinsics.checkNotNullParameter(r23, "monitorId");
        Intrinsics.checkNotNullParameter("scene", "field");
        g.a.getClass();
        sz2.e.d(r23, "scene", r27);
        g.c(this.a, "container_activity_on_create", a(this, "container_activity_on_create"));
        String r28 = this.a;
        c7.a r29 = this.c;
        if (r29 == null) goto L40;
        Bundle r30 = r29.getBundle();
        if (r30 == null) goto L40;
        String r31 = r30.getString(com.bytedance.android.ec.core.event.a.KEY_ENTER_FROM);
    L41:
        if (r31 != null) goto L43;
        r31 = null;
    L43:
        if (r31 != null) goto L45;
        r31 = "";
    L45:
        g.b(r28, com.bytedance.android.ec.core.event.a.KEY_ENTER_FROM, r31);
        g.a(this.a, "first_open", e ? 1 : 0);
        g.b(this.a, "container_version", String.valueOf(AnnieXMonitorConstants.a()));
        String r32 = this.a;
        int r33 = h9.a.a;
        c7.a r34 = this.c;
        if (r34 == null) goto L48;
        r25 = r34.getUrl();
    L48:
        p.a r35 = h9.a.a(r25);
        if (r35 == null) goto L51;
        int r36 = r35.b();
    L52:
        g.b(r32, "desire_res_mode", String.valueOf(r36));
        String r37 = this.a;
        c7.a r38 = this.c;
        if (r38 == null) goto L58;
        AnnieViewType r39 = r38.getViewType();
        if (r39 == null) goto L58;
        String r40 = r39.getTag();
        if (r40 == null) goto L58;
    L59:
        g.b(r37, "annie_view_type", r40);
        String r41 = this.a;
        c7.a r42 = this.c;
        if (r42 == null) goto L62;
        Object r43 = Boolean.valueOf(r42.isFromFlow());
    L63:
        g.b(r41, "is_from_flow", String.valueOf(r43));
        Map<String, i36.d> r44 = MonitorManager.a;
        MonitorManager.W(this.a);
        String r45 = this.a;
        c7.a r46 = this.c;
        int r47 = -1;
        if (r46 == null) goto L66;
        int r48 = r46.getAnnieIsCard();
    L67:
        g.b(r45, "annie_is_card", String.valueOf(r48));
        String r49 = this.a;
        c7.a r50 = this.c;
        if (r50 == null) goto L70;
        r47 = r50.getAnnieIsPreRender();
    L70:
        g.b(r49, "annie_is_prerender", String.valueOf(r47));
        e = false;
        return;
    L66:
        r48 = -1;
        goto L67
    L62:
        r43 = "false";
    L58:
        r40 = AnnieViewType.CARD.getTag();
        goto L59
    L51:
        r36 = 0;
    L40:
        r31 = null;
        goto L41
    L34:
        r27 = 0;
        goto L35
    L30:
        r26 = null;
    L22:
        th = move-exception;
        Result.Companion r51 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L10:
        r13 = g.e();
        goto L12
    L11:
        r13 = g.e();
        goto L12
    }

    @Override // b7.a, b7.b
    public final void onCardLoadStart() {
        c("prepare_card_load_start");
    }

    @Override // b7.a, b7.b
    public final void onContainerInitEnd() {
        if (this.b == false) goto L5;
        sz2.e r0 = g.a;
        g.c(this.a, "container_init_end", System.currentTimeMillis());
        return;
    L5:
        az2.a r1 = az2.e.a;
        az2.e.b(this.a, "container_init_end", System.currentTimeMillis());
    }

    @Override // b7.a, b7.b
    public final void onContainerInitStart() {
        if (this.b == false) goto L5;
        sz2.e r0 = g.a;
        g.c(this.a, "container_init_start", a(this, "container_init_start_time"));
        return;
    L5:
        az2.a r1 = az2.e.a;
        az2.e.b(this.a, "container_init_start", a(this, "container_init_start_time"));
    }

    @Override // b7.a, b7.b
    public final void onEngineLoadEnd() {
        c("prepare_card_load_end");
        c("prepare_engine_load_end");
    }

    @Override // b7.a, b7.b
    public final void onEngineLoadStart() {
        c("prepare_engine_load_start");
    }

    @Override // b7.a, b7.b
    public final void onGlobalPropsInitialized() {
        c("prepare_component_global_props_end");
    }

    @Override // b7.a, b7.b
    public final void onInitialPropsInitialized() {
        c("prepare_component_initial_props_end");
    }

    @Override // b7.a, b7.b
    public final void onJsbRegistered() {
        c("prepare_component_jsb_end");
    }

    @Override // b7.a, b7.b
    public final void onLynxEnvInitialized() {
        c("prepare_component_lynx_env_end");
    }

    @Override // b7.a, b7.b
    public final void onPrepareComponentEnd() {
        if (this.b == false) goto L5;
        sz2.e r0 = g.a;
        g.c(this.a, "prepare_component_end", System.currentTimeMillis());
        return;
    L5:
        az2.a r1 = az2.e.a;
        az2.e.b(this.a, "prepare_component_end", System.currentTimeMillis());
    }

    @Override // b7.a, b7.b
    public final void onPrepareComponentStart() {
        if (this.b == false) goto L5;
        sz2.e r0 = g.a;
        g.c(this.a, "prepare_component_start", System.currentTimeMillis());
        return;
    L5:
        az2.a r1 = az2.e.a;
        az2.e.b(this.a, "prepare_component_start", System.currentTimeMillis());
    }

    @Override // b7.a, b7.b
    public final void onPrepareInitDataEnd() {
        if (this.b == false) goto L5;
        sz2.e r0 = g.a;
        g.c(this.a, "prepare_init_data_end", System.currentTimeMillis());
        return;
    L5:
        az2.a r1 = az2.e.a;
        az2.e.b(this.a, "prepare_init_data_end", System.currentTimeMillis());
    }

    @Override // b7.a, b7.b
    public final void onPrepareTemplateStart() {
        if (this.b == false) goto L5;
        sz2.e r0 = g.a;
        g.c(this.a, "prepare_template_start", System.currentTimeMillis());
        g.d(this.a, "template_res_type", "cdn");
        return;
    L5:
        az2.a r1 = az2.e.a;
        az2.e.b(this.a, "prepare_template_start", System.currentTimeMillis());
        az2.e.c(this.a, "template_res_type", "cdn");
    }

    @Override // b7.a, b7.b
    public final void onRelease() {
        c("container_close_end");
        if (this.b == false) goto L5;
        sz2.e r0 = g.a;
        String r1 = this.a;
        Intrinsics.checkNotNullParameter(r1, "monitorId");
        g.a.getClass();
        Intrinsics.checkNotNullParameter(r1, "monitorId");
        sz2.e.d.post(new sz2.d(r1));
        return;
    L5:
        az2.a r10 = az2.e.a;
        az2.e.e(this.a);
    }

    public b() {
        this.a = "";
        this.b = AnnieConfigSettingKeys.LIVE_HYBRID_USE_MONITOR_SAMPLE_RATE.a().booleanValue();
    }

    public final void c(String r10) {
        if (this.b == false) goto L5;
        sz2.e r0 = g.a;
        g.c(this.a, r10, System.currentTimeMillis());
        return;
    L5:
        az2.a r1 = az2.e.a;
        az2.e.b(this.a, r10, System.currentTimeMillis());
    }

    @Override // b7.a, b7.b
    public final void onAttachedToWindow(String r10) {
        Map<String, i36.d> r0 = MonitorManager.a;
        MonitorManager.g(this.a, r10);
    }

    @Override // b7.a, b7.b
    public final void onBeforeCreateRenderData(View r10) {
        Intrinsics.checkNotNullParameter(r10, "hybridView");
        c("prepare_render_data_start");
    }

    @Override // b7.a, b7.b
    public final void onBeforeLynxEnvInitialize(boolean r1) {
        c("prepare_component_lynx_env_start");
    }

    @Override // b7.a, b7.b
    public final void onInit(c7.a r10) {
        Intrinsics.checkNotNullParameter(r10, "annieContext");
        this.c = r10;
    }

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r10) {
        if (this.b == false) goto L5;
        sz2.e r11 = g.a;
        g.c(this.a, "prepare_engine_js_load_end", System.currentTimeMillis());
        return;
    L5:
        az2.a r12 = az2.e.a;
        az2.e.b(this.a, "prepare_engine_js_load_end", System.currentTimeMillis());
    }

    public static long a(b r10, String r11) {
        c7.a r12 = r10.c;
        if (r12 == null) goto L7;
        Bundle r13 = r12.getBundle();
        if (r13 == null) goto L7;
        Long r14 = Long.valueOf(r13.getLong(r11));
    L8:
        if (r14 == null) goto L14;
        if (r14.longValue() == 0) goto L14;
        return r14.longValue();
    L14:
        return System.currentTimeMillis();
    L7:
        r14 = null;
        goto L8
    }

    public final void b(int r10, String r11) {
        this.d = true;
        if (this.b == false) goto L5;
        sz2.e r1 = g.a;
        String r12 = this.a;
        Intrinsics.checkNotNullParameter(r12, "monitorId");
        Intrinsics.checkNotNullParameter("invoke_fallback", "field");
        sz2.e r13 = g.a;
        r13.getClass();
        sz2.e.c(r12, "invoke_fallback", true);
        String r0 = this.a;
        Intrinsics.checkNotNullParameter(r0, "monitorId");
        Intrinsics.checkNotNullParameter("fallback_error_code", "field");
        r13.getClass();
        sz2.e.d(r0, "fallback_error_code", r10);
        g.d(this.a, "fallback_error_msg", r11);
        String r14 = this.a;
        Intrinsics.checkNotNullParameter(r14, "monitorId");
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "monitorId");
        sz2.e.d.post(new sz2.d(r14));
        return;
    L5:
        az2.a r15 = az2.e.a;
        az2.e.a(this.a, "invoke_fallback", true);
        String r16 = this.a;
        ty2.a.d();
        az2.e.d(r16, "fallback_error_code", Integer.valueOf(r10));
        az2.e.c(this.a, "fallback_error_msg", r11);
        az2.e.e(this.a);
    }

    @Override // b7.a, b7.b
    public final void onCreateRenderData(View r10, Set<String> r11) {
        Intrinsics.checkNotNullParameter(r10, "hybridView");
        Intrinsics.checkNotNullParameter(r11, "stateKeys");
        c("prepare_render_data_end");
    }

    @Override // b7.a, b7.b
    public final boolean onFallback(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        b(r10, r11);
        return false;
    }

    @Override // b7.a, b7.b
    public final void onInnerFallback(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        b(r10, r11);
    }

    @Override // b7.a, b7.b
    public final void onLoadStart(View r10, boolean r11) {
        if (this.b == false) goto L5;
        sz2.e r12 = g.a;
        g.c(this.a, "prepare_engine_js_load_start", System.currentTimeMillis());
        return;
    L5:
        az2.a r13 = az2.e.a;
        az2.e.b(this.a, "prepare_engine_js_load_start", System.currentTimeMillis());
    }

    @Override // b7.a, b7.b
    public final void onPrepareTemplateEnd(boolean r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "resFrom");
        if (this.b == false) goto L5;
        sz2.e r12 = g.a;
        g.d(this.a, "template_res_type", r11);
        g.c(this.a, "prepare_template_end", System.currentTimeMillis());
        return;
    L5:
        az2.a r13 = az2.e.a;
        az2.e.c(this.a, "template_res_type", r11);
        az2.e.b(this.a, "prepare_template_end", System.currentTimeMillis());
    }

    @Override // b7.a, b7.b
    public final void onAttachView(View r10, IHybridComponent.HybridType r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "hybridType");
        String r0 = "lynx";
        if (this.b == false) goto L14;
        sz2.e r13 = g.a;
        String r14 = this.a;
        IHybridComponent.HybridType r15 = IHybridComponent.HybridType.LYNX;
        if (r11 == r15) goto L8;
        r0 = "web";
    L8:
        sz2.f r16 = new sz2.f(r10, r0);
        Intrinsics.checkNotNullParameter(r14, "monitorId");
        Intrinsics.checkNotNullParameter(r16, "ct");
        g.a.getClass();
        sz2.e.b(r14, r16);
        if (Intrinsics.areEqual(r11.getHybridName(), IHybridComponent.HybridType.H5.getHybridName()) == false) goto L12;
        g.a(this.a, "web_first_open", f ? 1 : 0);
        f = false;
    L12:
        if (Intrinsics.areEqual(r11.getHybridName(), r15.getHybridName()) == false) goto L20;
        g.a(this.a, "lynx_first_open", g ? 1 : 0);
        g = false;
        return;
    L20:
        return;
    L14:
        az2.a r17 = az2.e.a;
        String r18 = this.a;
        if (r11 == IHybridComponent.HybridType.LYNX) goto L18;
        r0 = "web";
    L18:
        az2.f r19 = new az2.f(r10, r0);
        r19.getType();
        ty2.a.d();
        az2.e.a.getClass();
        az2.a.c.put(r18, r19);
    }

    @Override // b7.a, b7.b
    public final void onContainerError(View r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "errorMessage");
        String r1 = "88888";
        String r13 = "host";
        if (this.b == false) goto L19;
        sz2.e r0 = g.a;
        String r14 = this.a;
        ConcurrentHashMap<String, com.bytedance.android.annie.ng.a> r15 = com.bytedance.android.annie.ng.g.c;
        c7.a r16 = this.c;
        if (r16 == null) goto L10;
        String r17 = r16.getBizKey();
        if (r17 == null) goto L10;
        r13 = r17;
    L10:
        com.bytedance.android.annie.ng.a r18 = r15.get(r13);
        if (r18 == null) goto L18;
        o8.f r19 = r18.b;
        if (r19 == null) goto L18;
        String r20 = r19.a;
        if (r20 == null) goto L18;
        r1 = r20;
    L18:
        sz2.b r21 = new sz2.b(r11, r12, r1, "");
        Intrinsics.checkNotNullParameter(r14, "monitorId");
        Intrinsics.checkNotNullParameter(r21, IHostStyleUIDepend.TOAST_TYPE_ERROR);
        g.a.getClass();
        sz2.e.j(r10, r14, r21);
        return;
    L19:
        az2.a r22 = az2.e.a;
        String r23 = this.a;
        ConcurrentHashMap<String, com.bytedance.android.annie.ng.a> r24 = com.bytedance.android.annie.ng.g.c;
        c7.a r25 = this.c;
        if (r25 == null) goto L25;
        String r26 = r25.getBizKey();
        if (r26 == null) goto L25;
        r13 = r26;
    L25:
        com.bytedance.android.annie.ng.a r27 = r24.get(r13);
        if (r27 == null) goto L33;
        o8.f r28 = r27.b;
        if (r28 == null) goto L33;
        String r29 = r28.a;
        if (r29 == null) goto L33;
        r1 = r29;
    L33:
        az2.b r30 = new az2.b(r11, r12, r1);
        ty2.a.d();
        az2.e.a.getClass();
        az2.f r31 = (az2.f) ((LinkedHashMap) az2.a.c).get(r23);
        if (r10 == null) goto L36;
        py2.a r32 = az2.a.d(r10);
    L40:
        if (r31 == null) goto L47;
        Map r33 = az2.e.b;
        LinkedHashMap r34 = (LinkedHashMap) r33;
        if (r34.get(r31.getType()) == null) goto L47;
        Object r35 = r34.get(r31.getType());
        if (r35 != null) goto L46;
        Intrinsics.throwNpe();
    L46:
        ((az2.c) r35).b(r10, r32, r30);
        return;
    L47:
        com.bytedance.android.monitor.webview.g r36 = new com.bytedance.android.monitor.webview.g();
        ly2.c.a(new az2.d(r30, r32), r36);
        return;
    L36:
        Map r37 = az2.a.a(r23);
        py2.a r38 = new py2.a(new ArrayList());
        if (r37 == null) goto L39;
        r38.a.add(r37);
    L39:
        r32 = r38;
        goto L40
    }

    @Override // b7.a, b7.b
    public final void onPrepareInitDataStart(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEME);
        Intrinsics.checkNotNullParameter(r11, "fallbackUrl");
        if (this.b == false) goto L5;
        sz2.e r0 = g.a;
        g.d(this.a, com.bytedance.android.ec.core.event.a.KEY_SCHEMA, r10);
        g.d(this.a, "fallback_url", r11);
        g.c(this.a, "prepare_init_data_start", System.currentTimeMillis());
        String r13 = this.a;
        Intrinsics.checkNotNullParameter(r13, "monitorId");
        Intrinsics.checkNotNullParameter("is_fallback", "field");
        g.a.getClass();
        sz2.e.c(r13, "is_fallback", r12);
    L6:
        String r14 = HybridCrashHelper.a;
        c7.a r15 = this.c;
        if (r15 == null) goto L9;
        String r16 = r15.getUrl();
    L10:
        HybridCrashHelper.b(r16, r10);
        return;
    L9:
        r16 = null;
        goto L10
    L5:
        az2.a r1 = az2.e.a;
        az2.e.c(this.a, com.bytedance.android.ec.core.event.a.KEY_SCHEMA, r10);
        az2.e.c(this.a, "fallback_url", r11);
        az2.e.b(this.a, "prepare_init_data_start", System.currentTimeMillis());
        az2.e.a(this.a, "is_fallback", r12);
        goto L6
    }

    @Override // b7.a, b7.b
    public final void onBeforeLoadRequest(String r10, AnnieResType r11, IHybridComponent.HybridType r12, Map<String, Object> r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "resType");
        Intrinsics.checkNotNullParameter(r12, "type");
        if (r13 == null) goto L6;
        r13.put("rl_container_uuid", this.a);
    L6:
        if (r11 != AnnieResType.WEB_MAIN_RESOURCE) goto L8;
    L9:
        sz2.e r14 = g.a;
        g.d(this.a, com.bytedance.android.ec.core.event.a.KEY_URL, r10);
        String r15 = "1";
        g.b(this.a, "enableForest", "1");
        String r16 = this.a;
        if (r13 == null) goto L12;
        boolean r17 = Intrinsics.areEqual(r13.get("use_ttnet"), Boolean.TRUE);
    L13:
        if (r17 == true) goto L16;
        r15 = "0";
    L16:
        g.b(r16, "use_ttnet", r15);
        return;
    L12:
        r17 = false;
        goto L13
    L8:
        if (r11 == AnnieResType.LYNX_TEMPLATE) goto L9;
    }
}
