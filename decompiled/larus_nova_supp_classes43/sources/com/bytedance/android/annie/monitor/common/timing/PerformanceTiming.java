package com.bytedance.android.annie.monitor.common.timing;

import aa.b;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.mt.protector.impl.UriProtector;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import y9.h;
import y9.k;
import y9.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b'\u0018\u0000 U2\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004:\u0001VB\u0007¢\u0006\u0004\bS\u0010TJ\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\bJ\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\nJ\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f\u0018\u00010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001eR*\u0010*\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00101\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00107\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010\u001a\u001a\u0004\b8\u0010\u001c\"\u0004\b9\u0010\u001eR$\u0010:\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010\u001a\u001a\u0004\b;\u0010\u001c\"\u0004\b<\u0010\u001eR$\u0010=\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010C\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010>\u001a\u0004\bD\u0010@\"\u0004\bE\u0010BR$\u0010F\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010>\u001a\u0004\bG\u0010@\"\u0004\bH\u0010BR$\u0010I\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010\u001a\u001a\u0004\bI\u0010\u001c\"\u0004\bJ\u0010\u001eR$\u0010K\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010\u001a\u001a\u0004\bK\u0010\u001c\"\u0004\bL\u0010\u001eR\u0018\u0010M\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010>R\u0018\u0010N\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010>R\u0018\u0010O\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010>R\u0016\u0010P\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010\u001aR\u0018\u0010Q\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010R¨\u0006W"}, d2 = {"Lcom/bytedance/android/annie/monitor/common/timing/PerformanceTiming;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "Lorg/json/JSONObject;", "wrapMetrics", "wrapCategory", "", "preParseData", "", "getPerfTimingMap", "", "getPerfInfo", "Landroid/webkit/WebView;", "webView", "Lcom/bytedance/android/annie/monitor/common/timing/a;", "getTTWebViewLoadInfo", "Landroid/os/Bundle;", "initBundle", "Landroid/os/Bundle;", "getInitBundle", "()Landroid/os/Bundle;", "setInitBundle", "(Landroid/os/Bundle;)V", "engineType", "Ljava/lang/String;", "getEngineType", "()Ljava/lang/String;", "setEngineType", "(Ljava/lang/String;)V", "templateResType", "getTemplateResType", "setTemplateResType", "pageUrl", "getPageUrl", "setPageUrl", "pageType", "getPageType", "setPageType", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "viewRef", "Ljava/lang/ref/WeakReference;", "getViewRef", "()Ljava/lang/ref/WeakReference;", "setViewRef", "(Ljava/lang/ref/WeakReference;)V", "", "errorCode", "Ljava/lang/Integer;", "getErrorCode", "()Ljava/lang/Integer;", "setErrorCode", "(Ljava/lang/Integer;)V", "errorMsg", "getErrorMsg", "setErrorMsg", "errorReason", "getErrorReason", "setErrorReason", "realOpenTimeTs", "Ljava/lang/Long;", "getRealOpenTimeTs", "()Ljava/lang/Long;", "setRealOpenTimeTs", "(Ljava/lang/Long;)V", "resolveShortLinkStart", "getResolveShortLinkStart", "setResolveShortLinkStart", "resolveShortLinkEnd", "getResolveShortLinkEnd", "setResolveShortLinkEnd", "isContainerPreload", "setContainerPreload", "isPrerender", "setPrerender", "openTs", "activityOnCreateTs", "containerInitStartTs", "enterFrom", "ttWebViewLoadInfo", "Lcom/bytedance/android/annie/monitor/common/timing/a;", "<init>", "()V", "Companion", "a", "annie-monitor-common_release"}, k = 1, mv = {1, 4, 3})
public final class PerformanceTiming extends HashMap<String, Long> {
    public static final a Companion = null;
    public static boolean a;
    public static boolean b;
    public static boolean c;
    private Long activityOnCreateTs;
    private Long containerInitStartTs;
    private String engineType;
    private String enterFrom;
    private Integer errorCode;
    private String errorMsg;
    private String errorReason;
    private Bundle initBundle;
    private String isContainerPreload;
    private String isPrerender;
    private Long openTs;
    private String pageType;
    private String pageUrl;
    private Long realOpenTimeTs;
    private Long resolveShortLinkEnd;
    private Long resolveShortLinkStart;
    private String templateResType;
    private com.bytedance.android.annie.monitor.common.timing.a ttWebViewLoadInfo;
    private WeakReference<View> viewRef;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        a = true;
        b = true;
        c = true;
    }

    public final void c() {
        if (this.openTs != null) goto L6;
        this.openTs = b("open_time");
    L6:
        if (this.activityOnCreateTs != null) goto L9;
        this.activityOnCreateTs = b("container_activity_on_create");
    L9:
        if (this.containerInitStartTs != null) goto L11;
        this.containerInitStartTs = b("container_init_start_time");
    L11:
        this.realOpenTimeTs = b("real_open_time");
        if (this.resolveShortLinkStart != null) goto L15;
        this.resolveShortLinkStart = b("resolve_short_link_start");
    L15:
        if (this.resolveShortLinkEnd != null) goto L18;
        this.resolveShortLinkEnd = b("resolve_short_link_end");
        return;
    }

    public final Map<String, Object> getPerfInfo() {
        LinkedHashMap r0 = new LinkedHashMap();
        Bundle r1 = this.initBundle;
        if (r1 == null) goto L5;
        this.isPrerender = r1.getString("is_prerender");
        this.isContainerPreload = r1.getString("is_container_preload");
    L5:
        Bundle r10 = this.initBundle;
        boolean r11 = false;
        if (r10 == null) goto L8;
        r11 = r10.getBoolean("container_has_recreated", false);
    L8:
        r0.put("has_activity_recreated", Boolean.valueOf(r11));
        r0.put("main_res_type", this.templateResType);
        r0.put("first_open", Boolean.valueOf(a));
        if (Intrinsics.areEqual(this.engineType, IHybridComponent.HybridType.LYNX.getHybridName()) == false) goto L12;
        r0.put("first_open_lynx", Boolean.valueOf(c));
    L14:
        String r12 = this.isContainerPreload;
        if (r12 == null) goto L17;
        r0.put("is_container_preload", r12);
    L17:
        String r13 = this.isPrerender;
        if (r13 == null) goto L20;
        r0.put("is_prerender", r13);
    L20:
        return r0;
    L12:
        if (Intrinsics.areEqual(this.engineType, IHybridComponent.HybridType.H5.getHybridName()) == false) goto L14;
        r0.put("first_open_web", Boolean.valueOf(b));
        r0.put("is_ttwebview", Boolean.valueOf(((b) Annie.getService$default(b.class, null, 2, null)).isTTWebView()));
        goto L14
    }

    public final Map<String, Long> getPerfTimingMap() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(this);
        c();
        Long r1 = this.openTs;
        if (r1 != null) goto L5;
        r1 = (Long) get("open_time");
    L5:
        Long r10 = this.containerInitStartTs;
        if (r10 != null) goto L8;
        r10 = (Long) get("container_init_start");
    L8:
        if (r1 == null) goto L10;
        r0.put("open_time", r1);
    L10:
        if (r10 == null) goto L12;
        r0.put("container_init_start", r10);
    L12:
        Long r11 = this.activityOnCreateTs;
        if (r11 == null) goto L15;
        r0.put("container_activity_on_create", Long.valueOf(r11.longValue()));
    L15:
        Long r12 = this.realOpenTimeTs;
        if (r12 == null) goto L18;
        r0.put("real_open_time", Long.valueOf(r12.longValue()));
    L18:
        Long r13 = this.resolveShortLinkStart;
        if (r13 == null) goto L21;
        r0.put("resolve_short_link_start", Long.valueOf(r13.longValue()));
    L21:
        Long r14 = this.resolveShortLinkEnd;
        if (r14 == null) goto L24;
        r0.put("resolve_short_link_end", Long.valueOf(r14.longValue()));
    L24:
        return r0;
    }

    public final JSONObject wrapCategory() {
        JSONObject r0 = new JSONObject();
        r0.put(com.bytedance.android.ec.core.event.a.KEY_ENTER_FROM, this.enterFrom);
        r0.put("engine_type", this.engineType);
        r0.put("template_res_type", this.templateResType);
        r0.put("container_type", this.pageType);
        r0.put("first_open", String.valueOf(a));
        r0.put("lynx_first_open", String.valueOf(c));
        r0.put("web_first_open", String.valueOf(b));
        Map<String, Object> r1 = getPerfInfo();
        if (r1 == null) goto L5;
        Object r10 = MapsKt.getValue(r1, "has_activity_recreated");
    L6:
        r0.put("has_activity_recreated", String.valueOf(r10));
        boolean r11 = true;
        if (this.openTs == null) goto L9;
        boolean r12 = true;
    L10:
        r0.put("open_ts_valid", String.valueOf(r12));
        if (this.containerInitStartTs != null) goto L14;
        r11 = false;
    L14:
        r0.put("container_init_ts_valid", String.valueOf(r11));
        String r13 = this.errorMsg;
        if (r13 == null) goto L17;
        r0.put(com.bytedance.android.ec.core.event.a.KEY_ERROR_MSG, r13);
    L17:
        Integer r14 = this.errorCode;
        if (r14 == null) goto L20;
        r0.put(com.bytedance.android.ec.core.event.a.KEY_ERROR_CODE, String.valueOf(r14.intValue()));
    L20:
        String r15 = this.errorReason;
        if (r15 == null) goto L23;
        r0.put("error_reason", r15);
    L23:
        List<String> r16 = AnnieConfigSettingKeys.TIMING_AB_LIST.a();
        if (r16 == null) goto L36;
        Iterator<T> r17 = r16.iterator();
    L27:
        if (r17.hasNext() == false) goto L36;
        String r18 = (String) r17.next();
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L34
        String r20 = a(r18);     // Catch: Throwable -> L34
        if (r20 == null) goto L32;
        r0.put(r18, r20);     // Catch: Throwable -> L34
    L32:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L36:
        a = false;
        if (Intrinsics.areEqual(this.engineType, IHybridComponent.HybridType.LYNX.getHybridName()) == false) goto L40;
        c = false;
    L40:
        if (Intrinsics.areEqual(this.engineType, IHybridComponent.HybridType.H5.getHybridName()) == false) goto L42;
        b = false;
    L42:
        return r0;
    L9:
        r12 = false;
        goto L10
    L5:
        r10 = null;
        goto L6
    }

    public final JSONObject wrapMetrics() {
        JSONObject r0 = new JSONObject();
        Long r1 = this.openTs;
        if (r1 != null) goto L5;
        r1 = (Long) get("open_time");
    L5:
        Long r10 = this.containerInitStartTs;
        if (r10 != null) goto L8;
        r10 = (Long) get("container_init_start");
    L8:
        d(r0, "timing_open_cost", r1, r10);
        Long r11 = (Long) get("prepare_init_data_start");
        d(r0, "timing_activity_init_cost", r10, r11);
        Long r12 = this.activityOnCreateTs;
        if (r12 == null) goto L11;
        long r13 = r12.longValue();
        d(r0, "timing_activity_start_cost", r10, Long.valueOf(r13));
        d(r0, "timing_activity_on_create_cost", Long.valueOf(r13), r11);
    L11:
        Long r14 = (Long) get("container_init_end");
        d(r0, "timing_fragment_init_cost", r11, (Long) get("prepare_init_data_end"));
        d(r0, "timing_container_init_cost", r10, r14);
        d(r0, "timing_lynx_env_init_cost", (Long) get("prepare_component_lynx_env_start"), (Long) get("prepare_component_lynx_env_end"));
        Long r15 = (Long) get("prepare_component_jsb_start");
        Long r16 = (Long) get("prepare_component_jsb_end");
        d(r0, "timing_jsb_init_cost", r15, r16);
        Long r17 = (Long) get("prepare_component_start");
        Long r18 = (Long) get("prepare_component_end");
        d(r0, "timing_component_init_cost", r17, r18);
        d(r0, "timing_component_before_jsb_cost", r17, r15);
        d(r0, "timing_component_after_jsb_cost", r16, r18);
        d(r0, "timing_template_load_cost", (Long) get("prepare_template_start"), (Long) get("prepare_template_end"));
        d(r0, "timing_global_props_cost", (Long) get("prepare_component_global_props_start"), (Long) get("prepare_component_global_props_end"));
        d(r0, "timing_init_props_cost", (Long) get("prepare_component_initial_props_start"), (Long) get("prepare_component_initial_props_end"));
        d(r0, "timing_render_data_cost", (Long) get("prepare_render_data_start"), (Long) get("prepare_render_data_end"));
        Long r19 = (Long) get("prepare_engine_load_end");
        d(r0, "timing_engine_load_cost", (Long) get("prepare_engine_load_start"), r19);
        d(r0, "timing_engine_js_load_cost", r19, (Long) get("prepare_engine_js_load_end"));
        Long r20 = (Long) get("prepare_card_load_start");
        d(r0, "timing_card_create_cost", r14, r20);
        d(r0, "timing_card_load_cost", r20, r19);
        d(r0, "timing_container_route_cost", r1, r14);
        d(r0, "timing_container_card_cost", r14, r19);
        d(r0, "timing_container_total_cost", r1, r19);
        return r0;
    }

    public PerformanceTiming() {
        this.engineType = "unknown";
        this.templateResType = "unknown";
        this.pageType = "unknown";
        this.enterFrom = "unknown";
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Long>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set<Map.Entry<String, Long>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<Long> getValues() {
        return super.values();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    public final void preParseData() {
        c();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
        Bundle r1 = this.initBundle;     // Catch: Throwable -> L14
        if (r1 == null) goto L11;
        String r10 = r1.getString(com.bytedance.android.ec.core.event.a.KEY_URL);     // Catch: Throwable -> L14
        if (r10 == null) goto L11;
        this.pageUrl = r10;     // Catch: Throwable -> L14
        String r11 = UriProtector.getQueryParameter(UriProtector.parse(r10), com.bytedance.android.ec.core.event.a.KEY_ENTER_FROM);     // Catch: Throwable -> L14
        if (r11 != null) goto L10;
        r11 = "unknown";
    L10:
        this.enterFrom = r11;     // Catch: Throwable -> L14
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L12:
        Result.constructor-impl(r12);     // Catch: Throwable -> L14
        return;
    L11:
        r12 = null;
    L14:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<Long> values() {
        return getValues();
    }

    public final String getEngineType() {
        return this.engineType;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final String getErrorReason() {
        return this.errorReason;
    }

    public final Bundle getInitBundle() {
        return this.initBundle;
    }

    public final String getPageType() {
        return this.pageType;
    }

    public final String getPageUrl() {
        return this.pageUrl;
    }

    public final Long getRealOpenTimeTs() {
        return this.realOpenTimeTs;
    }

    public final Long getResolveShortLinkEnd() {
        return this.resolveShortLinkEnd;
    }

    public final Long getResolveShortLinkStart() {
        return this.resolveShortLinkStart;
    }

    public final String getTemplateResType() {
        return this.templateResType;
    }

    public final WeakReference<View> getViewRef() {
        return this.viewRef;
    }

    public final String isContainerPreload() {
        return this.isContainerPreload;
    }

    public final String isPrerender() {
        return this.isPrerender;
    }

    public static String a(String r10) {
        Map<String, JSONObject> r0 = h.a;
        if ((Annie.getService(n.class) instanceof k) == true) goto L5;
        boolean r1 = ((n) Annie.getService(n.class)).L0(r10);
    L10:
        if (r1 == true) goto L12;
        return null;
    L12:
        Boolean r11 = (Boolean) h.c(r10, Boolean.class, Boolean.FALSE);
        if (r11 != null) goto L15;
        return null;
    L15:
        return String.valueOf(r11);
    L5:
        h.b();
        JSONObject r12 = (JSONObject) ((ConcurrentHashMap) h.a).get("annie_setting_from_server_key");     // Catch: Exception -> L8
        Objects.requireNonNull(r12);     // Catch: Exception -> L8
        r1 = r12.has(r10);     // Catch: Exception -> L8
    L8:
        r1 = false;
        goto L10
    }

    public final Long b(String r10) {
        Bundle r0 = this.initBundle;
        if (r0 == null) goto L5;
        Long r11 = Long.valueOf(r0.getLong(r10));
    L6:
        if (r11 != null) goto L8;
        return null;
    L8:
        if (r11.longValue() > 0) goto L11;
        return null;
    L11:
        return r11;
    L5:
        r11 = null;
        goto L6
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return false;
    L7:
        return containsKey((String) r10);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r10) {
        if ((r10 instanceof Long) == true) goto L7;
        return false;
    L7:
        return containsValue((Long) r10);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Long get(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r10);
    }

    public final com.bytedance.android.annie.monitor.common.timing.a getTTWebViewLoadInfo(WebView r10) {
        Intrinsics.checkNotNullParameter(r10, "webView");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        Unit r11 = null;
        JSONObject r12 = ((b) Annie.getService$default(b.class, null, 2, null)).g0(r10);     // Catch: Throwable -> L8
        if (r12 == null) goto L6;
        List<String> r1 = com.bytedance.android.annie.monitor.common.timing.a.d;     // Catch: Throwable -> L8
        this.ttWebViewLoadInfo = com.bytedance.android.annie.monitor.common.timing.a.C0071a.a(r12, this.ttWebViewLoadInfo);     // Catch: Throwable -> L8
        r11 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Result.constructor-impl(r11);     // Catch: Throwable -> L8
    L11:
        return this.ttWebViewLoadInfo;
    L8:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Long remove(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r10);
    }

    public final void setContainerPreload(String r1) {
        this.isContainerPreload = r1;
    }

    public final void setEngineType(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.engineType = r10;
    }

    public final void setErrorCode(Integer r1) {
        this.errorCode = r1;
    }

    public final void setErrorMsg(String r1) {
        this.errorMsg = r1;
    }

    public final void setErrorReason(String r1) {
        this.errorReason = r1;
    }

    public final void setInitBundle(Bundle r1) {
        this.initBundle = r1;
    }

    public final void setPageType(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.pageType = r10;
    }

    public final void setPageUrl(String r1) {
        this.pageUrl = r1;
    }

    public final void setPrerender(String r1) {
        this.isPrerender = r1;
    }

    public final void setRealOpenTimeTs(Long r1) {
        this.realOpenTimeTs = r1;
    }

    public final void setResolveShortLinkEnd(Long r1) {
        this.resolveShortLinkEnd = r1;
    }

    public final void setResolveShortLinkStart(Long r1) {
        this.resolveShortLinkStart = r1;
    }

    public final void setTemplateResType(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.templateResType = r10;
    }

    public final void setViewRef(WeakReference<View> r1) {
        this.viewRef = r1;
    }

    public /* bridge */ boolean containsKey(String r1) {
        return super.containsKey(r1);
    }

    public /* bridge */ boolean containsValue(Long r1) {
        return super.containsValue(r1);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r10);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object r10) {
        if ((r10 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r10);
    }

    public /* bridge */ Long get(String r1) {
        return (Long) super.get(r1);
    }

    public /* bridge */ Long remove(String r1) {
        return (Long) super.remove(r1);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object r10, Object r11) {
        if ((r10 instanceof String) == true) goto L6;
        return r11;
    L6:
        return getOrDefault((String) r10, (Long) r11);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r10, Object r11) {
        if ((r10 instanceof String) == true) goto L6;
        return false;
    L6:
        if ((r11 instanceof Long) == true) goto L9;
        return false;
    L9:
        return remove((String) r10, (Long) r11);
    }

    public final /* bridge */ Long getOrDefault(Object r10, Long r11) {
        if ((r10 instanceof String) == true) goto L6;
        return r11;
    L6:
        return getOrDefault((String) r10, r11);
    }

    public /* bridge */ boolean remove(String r1, Long r10) {
        return super.remove(r1, r10);
    }

    public /* bridge */ Long getOrDefault(String r1, Long r10) {
        return (Long) super.getOrDefault(r1, r10);
    }

    public static void d(JSONObject r10, String r11, Long r12, Long r13) {
        if (r12 == null) goto L9;
        if (r13 == null) goto L9;
        if ((r13.longValue() - r12.longValue()) >= 0) goto L8;
        long r14 = -2;
    L10:
        r10.put(r11, r14);
        return;
    L8:
        r14 = r13.longValue() - r12.longValue();
    L9:
        r14 = -1;
        goto L10
    }
}
