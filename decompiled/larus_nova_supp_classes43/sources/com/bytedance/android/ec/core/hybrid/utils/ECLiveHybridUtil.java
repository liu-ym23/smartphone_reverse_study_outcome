package com.bytedance.android.ec.core.hybrid.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.ECLiveEntranceMonitor;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.host.api.hybrid.IECForestHostService;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.hybrid.data.gecko.HybridForestLoader;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECLiveHybridUtil {
    public static final a a = null;
    public static final ConcurrentHashMap<ti.j, JsEventSubscriber> b = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/utils/ECLiveHybridUtil$HybridType;", "", "(Ljava/lang/String;I)V", "LYNX", "WEB", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum HybridType extends Enum<HybridType> {
        private static final /* synthetic */ HybridType[] $VALUES = null;
        public static final HybridType LYNX = null;
        public static final HybridType WEB = null;

        static {
            HybridType r1 = new HybridType("LYNX", 0);
            LYNX = r1;
            HybridType r10 = new HybridType("WEB", 1);
            WEB = r10;
            $VALUES = new HybridType[]{r1, r10};
        }

        public static HybridType valueOf(String r1) {
            return (HybridType) r27.a.a(HybridType.class, r1);
        }

        public static HybridType[] values() {
            return (HybridType[]) $VALUES.clone();
        }

        private HybridType(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static final class a implements ti.k {
        public a() {
        }

        public final void b() {
            Intrinsics.checkNotNullParameter("", "errorMessage");
            Intrinsics.checkNotNullParameter("", "errorMessage");
        }

        public final void onFirstScreen(View r10) {
            Intrinsics.checkNotNullParameter(r10, "lynxView");
            Intrinsics.checkNotNullParameter(r10, "lynxView");
        }

        public final void onLoadSuccess(View r10) {
            Intrinsics.checkNotNullParameter(r10, "lynxView");
            Intrinsics.checkNotNullParameter(r10, "lynxView");
        }

        public final void onRuntimeReady(View r10) {
            Intrinsics.checkNotNullParameter(r10, "lynxView");
            Intrinsics.checkNotNullParameter(r10, "lynxView");
        }

        public final void g(View r1, String r10) {
            Intrinsics.checkNotNullParameter(r1, "view");
            Intrinsics.checkNotNullParameter(r1, "view");
        }

        public final void onLoadFailed(View r1, String r10) {
            Intrinsics.checkNotNullParameter(r1, "lynxView");
            Intrinsics.checkNotNullParameter(r1, "lynxView");
        }

        public final void onPageStart(View r1, String r10) {
            Intrinsics.checkNotNullParameter(r1, "lynxView");
            Intrinsics.checkNotNullParameter(r1, "lynxView");
        }

        public final void s(View r1, String r10, String r11) {
            Intrinsics.checkNotNullParameter(r1, "view");
            Intrinsics.checkNotNullParameter(r1, "view");
        }
    }

    public static final class b implements ti.k {
        public final /* synthetic */ ti.k a;
        public final /* synthetic */ ti.k b;

        public final void b() {
            Intrinsics.checkNotNullParameter("", "errorMessage");
            this.a.b();
        }

        public final void g(View r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "view");
            this.a.g(r10, r11);
        }

        public final void onFirstScreen(View r10) {
            Intrinsics.checkNotNullParameter(r10, "lynxView");
            this.a.onFirstScreen(r10);
        }

        public final void onLoadSuccess(View r10) {
            Intrinsics.checkNotNullParameter(r10, "lynxView");
            this.a.onLoadSuccess(r10);
        }

        public final void onPageStart(View r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "lynxView");
            this.a.onPageStart(r10, r11);
        }

        public final void onRuntimeReady(View r10) {
            Intrinsics.checkNotNullParameter(r10, "lynxView");
            this.a.onRuntimeReady(r10);
        }

        public final void s(View r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r10, "view");
            this.a.s(r10, r11, r12);
        }

        public b(ti.k r1) {
            this.b = r1;
            this.a = r1;
        }

        public final void onLoadFailed(View r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "lynxView");
            this.b.onLoadFailed(r10, r11);
            Object r12 = r10.getParent();
            if ((r12 instanceof HybridCard) == false) goto L11;
            ViewParent r13 = ((HybridCard) r12).getParent();
            if ((r13 instanceof ViewGroup) == true) goto L7;
            r13 = null;
        L7:
            ViewGroup r14 = (ViewGroup) r13;
            if (r14 == null) goto L12;
            r14.removeView((View) r12);
            return;
        L12:
            return;
        }
    }

    public static final class c implements JsEventSubscriber {
        public final /* synthetic */ ti.j a;

        public c(ti.j r1) {
            this.a = r1;
        }

        public final void onReceiveJsEvent(Js2NativeEvent r10) {
            Intrinsics.checkNotNullParameter(r10, "jsEvent");
            ti.j r0 = this.a;
            int r1 = k.a;
            XReadableMap r11 = r10.getParams();
            if (r11 == null) goto L5;
            Map r12 = r11.toMap();
        L6:
            r0.a(k.b(r12));
            return;
        L5:
            r12 = null;
            goto L6
        }
    }

    public static final class d implements JsEventSubscriber {
        public final /* synthetic */ ti.j a;

        public d(ti.j r1) {
            this.a = r1;
        }

        public final void onReceiveJsEvent(Js2NativeEvent r10) {
            Intrinsics.checkNotNullParameter(r10, "jsEvent");
            ti.j r0 = this.a;
            int r1 = k.a;
            XReadableMap r11 = r10.getParams();
            if (r11 == null) goto L5;
            Map r12 = r11.toMap();
        L6:
            r0.a(k.b(r12));
            return;
        L5:
            r12 = null;
            goto L6
        }
    }

    static {
        kg.a.a("ECLiveHybridUtil");
        a = new a();
        b = new ConcurrentHashMap();
    }

    public static void h() {
        boolean r0 = ECServiceManager.a;
        pd.e r1 = ((IAdapterService) ECServiceManager.c(IAdapterService.class)).getIExternaHybridService();
        if (r1 == null) goto L9;
        final pd.f r10 = r1.getExternalJsBridgeMethodInjectorAdapter();
        if (r10 == null) goto L10;
        r10.b(new ECLiveHybridUtil$injectECLiveBridges$1(r10));
        r10.c(new ECLiveHybridUtil$injectECLiveBridges$2(r10));
        ((s83.g) ECServiceManager.c(s83.g.class)).s();
        return;
    L10:
        return;
    }

    public static boolean i(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (StringsKt.startsWith$default(r10, "sslocal://webcast_lynxview", false, 2, null) == false) goto L5;
        return true;
    L5:
        if (StringsKt.startsWith$default(r10, "sslocal://webcast_webview", false, 2, null) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public static ti.k d(ti.k r0, boolean r1) {
        if (r1 == true) goto L4;
        return r0;
    L4:
        if (r0 != null) goto L7;
        r0 = a;
    L7:
        return new b(r0);
    }

    @JvmStatic
    public static final void f(String r1, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r1, "eventName");
        Intrinsics.checkNotNullParameter(r10, "params");
        int r0 = ECSdk.a;
        IAdapterService r11 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r11 == null) goto L8;
        pd.e r12 = r11.getIExternaHybridService();
        if (r12 == null) goto L9;
        r12.enqueueEvent(r1, r10);
        return;
    L9:
        return;
    }

    public static void g(String r10, final Function1 r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "callback");
        int r0 = ECSdk.a;
        IECHostService r1 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r1 == null) goto L5;
        IECForestHostService r12 = r1.getECForestHostService();
    L6:
        if (r12 == null) goto L9;
        r12.fetchLiveResourceAsync(r10, r11);
        return;
    L9:
        Map r13 = HybridForestLoader.a;
        Forest r14 = HybridForestLoader.e();
        if (r14 == null) goto L13;
        r14.fetchResourceAsync(r10, new RequestParams(0), new ECLiveHybridUtil$fetchLiveResourceAsync$1(r11));
        return;
    L13:
        return;
    L5:
        r12 = null;
        goto L6
    }

    public static void l(String r1, boolean r10) {
        if (com.bytedance.android.shopping.anchorv3.a.b(r1) == false) goto L10;
        int r0 = ECSdk.a;
        IAdapterService r11 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r11 == null) goto L11;
        pd.e r12 = r11.getIExternaHybridService();
        if (r12 == null) goto L12;
        r12.preloadResourceForLynx(r1, r10);
        return;
    L12:
        return;
    L11:
        return;
    }

    @JvmStatic
    public static final void m(String r10, ti.j r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Intrinsics.checkNotNullParameter(r11, "subscriber");
        c r0 = new c(r11);
        b.put(r11, r0);
        EventCenter.registerJsEventSubscriber(r10, r0);
    }

    @JvmStatic
    public static final void n(String r10, ti.j r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Intrinsics.checkNotNullParameter(r11, "subscriber");
        ConcurrentHashMap<ti.j, JsEventSubscriber> r0 = b;
        if (r0.containsKey(r11) == false) goto L5;
        return;
    L5:
        d r1 = new d(r11);
        r0.put(r11, r1);
        EventCenter.registerJsEventSubscriber(r10, r1);
    }

    @JvmStatic
    public static final <T> void o(String r1, T r10) {
        Intrinsics.checkNotNullParameter(r1, "event");
        int r0 = ECSdk.a;
        IAdapterService r11 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r11 == null) goto L8;
        pd.e r12 = r11.getIExternaHybridService();
        if (r12 == null) goto L9;
        r12.sendEventToAllJsBridges(r1, r10);
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final void p(String r1, ti.j r10) {
        Intrinsics.checkNotNullParameter(r1, "eventName");
        Intrinsics.checkNotNullParameter(r10, "subscriber");
        JsEventSubscriber r11 = b.remove(r10);
        if (r11 == null) goto L6;
        EventCenter.unregisterJsEventSubscriber(r1, r11);
        return;
    }

    public static pd.b a(Context r10, String r11, pd.c r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r12, "lifecycle");
        int r0 = ECSdk.a;
        IAdapterService r1 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r1 == null) goto L5;
        pd.e r13 = r1.getIExternaHybridService();
    L6:
        if (r13 != null) goto L8;
        return null;
    L8:
        return r13.createAnnieComponent(r10, r11, r12);
    L5:
        r13 = null;
        goto L6
    }

    public static /* synthetic */ void k(Context r10, String r11, boolean r12, boolean r13, boolean r14, String r15, int r16) {
        if ((r16 & 8) == 0) goto L5;
        boolean r17 = false;
    L7:
        if ((r16 & 16) == 0) goto L9;
        boolean r18 = false;
    L11:
        if ((r16 & 32) == 0) goto L13;
        boolean r19 = false;
    L15:
        if ((r16 & 128) == 0) goto L17;
        r15 = null;
    L17:
        j(r10, r11, null, r17, r18, r19, null, r15);
        return;
    L13:
        r19 = r14;
        goto L15
    L9:
        r18 = r13;
        goto L11
    L5:
        r17 = r12;
        goto L7
    }

    @JvmStatic
    public static final void j(Context r17, String r18, Bundle r19, boolean r20, boolean r21, boolean r22, String r23, String r24) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, com.bytedance.android.ec.core.event.a.KEY_URL);
        String r0 = j.c(r18, r20, 4);
        int r10 = com.bytedance.android.ec.core.hybrid.utils.a.a;
        Intrinsics.checkNotNullParameter(r0, com.bytedance.android.ec.core.event.a.KEY_URL);
        Uri r11 = UriProtector.parse(r0);
        String r12 = UriProtector.getQueryParameter(r11, "fallback_url");
        if (TextUtils.isEmpty(r12) == false) goto L5;
    L4:
        String r13 = r0;
        JSONObject r1 = p.a;
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (StringsKt.contains$default(r13, "ecommerce_buynow", false, 2, null) == true) goto L336;
    L44:
        String r14 = r13;
        if (ECAppInfoService.e.isLocalTest() == false) goto L296;
    L297:
        int r15 = ECSdk.a;
        com.bytedance.android.ec.core.monitor.o r16 = (com.bytedance.android.ec.core.monitor.o) ECSdk.a(com.bytedance.android.ec.core.monitor.o.class);
        if (r16 != null) goto L300;
    L319:
        if (r22 == true) goto L321;
    L325:
        int r25 = ECSdk.a;
        IAdapterService r26 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r26 == null) goto L379;
        IAdapterService.a.a(r26, r17, UriProtector.parse(r14), r21, 8);
        return;
    L379:
        return;
    L321:
        if (l0.b(r17) == null) goto L325;
        nj.d r27 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r27 == null) goto L325;
        r27.i();
        goto L325
    L300:
        if (r19 == null) goto L303;
        String r28 = r19.getString("vmsdk_scene");
        if (r28 == null) goto L303;
    L304:
        String r29 = r28;
        if (r19 == null) goto L307;
        String r30 = r19.getString("vmsdk_contextProvider");
    L309:
        if (r19 == null) goto L311;
        String r110 = r19.getString("vmsdk_scriptPath");
    L312:
        r16.a(r17, r29, r14, r30, r110);
        if (r19 == null) goto L315;
        r19.remove("vmsdk_scene");
    L315:
        if (r19 == null) goto L317;
        r19.remove("vmsdk_contextProvider");
    L317:
        if (r19 == null) goto L319;
        r19.remove("vmsdk_scriptPath");
        goto L319
    L311:
        r110 = null;
        goto L312
    L307:
        r30 = null;
    L303:
        r28 = "hybrid";
        goto L304
    L296:
        if (ECSettingKeys.l() == false) goto L319;
    L336:
        Uri r31 = UriProtector.parse(r13);     // Catch: Exception -> L292
        p.c = r31;
        if ((!Intrinsics.areEqual(UriProtector.getQueryParameter(r31, "ec_order_prefetch"), "1")) == false) goto L45;
        ECLiveEntranceMonitor.trace$default("ec_order_prefetch is not enable", "BuyNowPrefetch", false, 4, null);
        goto L44
    L45:
        int r32 = zg.a.a;
        int r33 = com.bytedance.android.ec.core.opt.ab.m.a;
        boolean r34 = ECServiceManager.a;
        s83.g r35 = (s83.g) ECServiceManager.c(s83.g.class);
        String r111 = "";
        if (r35 == null) goto L51;
        s83.a r36 = r35.q();
        if (r36 == null) goto L51;
        Object r37 = r36.e("ec_order_prefetch_config");
        if (r37 == null) goto L51;
    L346:
        String r38 = Uri.decode((String) r37);     // Catch: Exception -> L222
    L348:
        Set r112 = UriProtector.getQueryParameterNames(p.c);     // Catch: JSONException -> L235
        JSONObject r113 = new JSONObject(r38);     // Catch: JSONException -> L235
        JSONArray r39 = r113.optJSONArray("no_prefetch_buynow");     // Catch: JSONException -> L235
        if (r39 == null) goto L233;
        int r40 = r39.length();     // Catch: JSONException -> L235
        int r41 = 0;
    L228:
        if (r41 >= r40) goto L233;
        String r114 = r39.optString(r41, "");     // Catch: JSONException -> L235
        if (r112.contains(r114) == true) goto L231;
        r41 = r41 + 1;     // Catch: JSONException -> L235
        goto L228
    L231:
        ECLiveEntranceMonitor.trace$default("no need for prefetch: " + r114, "BuyNowPrefetch", false, 4, null);     // Catch: JSONException -> L235
    L237:
        boolean r42 = false;
    L238:
        if (r42 == false) goto L286;
        String r43 = UriProtector.getQueryParameter(p.c, "mega_object_id");
        if (r43 == null) goto L246;
        HashMap<String, JSONObject> r44 = j.a;
        JSONObject r45 = j.d(r43);
        if (r45 == null) goto L246;
        p.a = new JSONObject(r45.optString(com.bytedance.android.ec.core.event.a.KEY_CJ_INFO));     // Catch: Exception -> L329
    L344:
        p.b = new JSONObject(r45.optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO));     // Catch: Exception -> L330
    L246:
        Iterator r46 = ((LinkedHashMap) p.d).entrySet().iterator();
    L248:
        if (r46.hasNext() == false) goto L250;
        Map.Entry r47 = (Map.Entry) r46.next();
        p.e.put((String) r47.getKey(), p.c((l) r47.getValue()));
        goto L248
    L250:
        Iterator r48 = ((LinkedHashMap) p.f).entrySet().iterator();
    L252:
        if (r48.hasNext() == false) goto L254;
        Map.Entry r49 = (Map.Entry) r48.next();
        p.g.put((String) r49.getKey(), p.c((l) r49.getValue()));
        goto L252
    L254:
        Iterator r50 = ((LinkedHashMap) p.h).entrySet().iterator();
    L256:
        if (r50.hasNext() == false) goto L258;
        Map.Entry r51 = (Map.Entry) r50.next();
        p.i.put((String) r51.getKey(), p.c((l) r51.getValue()));
        goto L256
    L258:
        String r52 = UUID.randomUUID().toString();
        p.j.put(r52, null);
        Map<String, Object> r53 = p.g;     // Catch: Exception -> L283
        if ((r53 instanceof Map) == true) goto L262;
        r53 = null;
    L262:
        if (r53 != null) goto L264;
        r53 = MapsKt.emptyMap();     // Catch: Exception -> L283
    L264:
        JSONObject r54 = new JSONObject(r53);     // Catch: Exception -> L283
        Map<String, Object> r115 = p.i;     // Catch: Exception -> L283
        if ((r115 instanceof Map) == true) goto L267;
        r115 = null;
    L267:
        if (r115 != null) goto L269;
        r115 = MapsKt.emptyMap();     // Catch: Exception -> L283
    L269:
        JSONObject r55 = new JSONObject(r115);     // Catch: Exception -> L283
        JSONArray r116 = new JSONArray();     // Catch: Exception -> L283
        r116.put(0, r55);     // Catch: Exception -> L283
        JSONArray r56 = new JSONArray();     // Catch: Exception -> L283
        r56.put(0, r54);     // Catch: Exception -> L283
        r54.put("product_requests", r116);     // Catch: Exception -> L283
        String r57 = p.b.toString();     // Catch: Exception -> L283
        JSONObject r117 = new JSONObject();     // Catch: Exception -> L283
        String r118 = p.a.optString(com.bytedance.android.ec.core.event.a.KEY_INSTALLMENT_INFO, null);     // Catch: Exception -> L283
        if (r118 == null) goto L340;
        r117.put("top_pay_type", 8);     // Catch: Exception -> L283
        r117.put("default_pay_type", 8);     // Catch: Exception -> L283
        r117.put(com.bytedance.android.ec.core.event.a.KEY_INSTALLMENT_INFO, r118);     // Catch: Exception -> L283
    L340:
        r117.put("checkout_id", 1);     // Catch: Exception -> L331
        String r58 = p.a.optString(com.bytedance.android.ec.core.event.a.KEY_BIO_TYPE, null);     // Catch: Exception -> L331
        if (r58 == null) goto L277;
        r117.put(com.bytedance.android.ec.core.event.a.KEY_BIO_TYPE, r58);     // Catch: Exception -> L331
    L277:
        String r59 = r117.toString();     // Catch: Exception -> L331
        JSONObject r119 = new JSONObject();     // Catch: Exception -> L331
        Iterator r120 = ((LinkedHashMap) p.e).entrySet().iterator();     // Catch: Exception -> L331
    L279:
        if (r120.hasNext() == false) goto L281;
        Map.Entry r121 = (Map.Entry) r120.next();     // Catch: Exception -> L331
        r119.put((String) r121.getKey(), r121.getValue());     // Catch: Exception -> L331
        goto L279
    L281:
        r119.put("customize_pay_type", r59);     // Catch: Exception -> L331
        r119.put("shop_requests", r56);     // Catch: Exception -> L331
        r119.put("entrance_params", r57);     // Catch: Exception -> L331
        bg4.b.b(((OrderDetailApi) com.bytedance.android.ec.sdk.helper.n.a.create("https://ken.snssdk.com/", OrderDetailApi.class)).prefetchOrderDetailData2(2, r119)).subscribe(new m(SystemClock.elapsedRealtime(), r52), new n(r52));     // Catch: Exception -> L331
        r111 = r52;
    L284:
        p.e(new q("", 3), r52);
        p.a();
    L286:
        if (r111.length() <= 0) goto L288;
        boolean r60 = true;
    L289:
        if (r60 == false) goto L291;
        r13 = p.c.buildUpon().appendQueryParameter("ec_request_id", r111).build().toString();
        goto L44
    L291:
        ECLiveEntranceMonitor.trace$default("prefetch failed as request_id is empty", "BuyNowPrefetch", false, 4, null);
        goto L44
    L288:
        r60 = false;
    L233:
        p.d("ec_order_outside", r113);     // Catch: JSONException -> L235
        p.d("ec_order_shop_request", r113);     // Catch: JSONException -> L235
        p.d("ec_order_product_request", r113);     // Catch: JSONException -> L235
        r42 = true;
    L235:
        e = move-exception;
        ECLiveEntranceMonitor.trace$default("parseSetting failed: " + e.getMessage(), "BuyNowPrefetch", false, 4, null);
    L222:
        e = move-exception;
        ECLiveEntranceMonitor.trace$default("decode ec_order_prefetch_config failed: " + e.getMessage(), "BuyNowPrefetch", false, 4, null);
        r38 = "";
    L51:
        int r61 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r62 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r63 = Result.Companion;     // Catch: Throwable -> L212
        Object r64 = com.bytedance.android.ec.base.settings.d.c.get("ec_order_prefetch_config");     // Catch: Throwable -> L105
        if (r64 != null) goto L57;
    L102:
        Object r122 = null;
    L103:
        Object r65 = Result.constructor-impl(r122);     // Catch: Throwable -> L105
    L107:
        Throwable r123 = Result.exceptionOrNull-impl(r65);     // Catch: Throwable -> L212
        if (r123 == null) goto L111;
        EnsureManager.ensureNotReachHere(r123);     // Catch: Throwable -> L212
    L111:
        if (Result.isFailure-impl(r65) == false) goto L114;
        r65 = null;
    L114:
        if ((r65 instanceof String) == true) goto L116;
        r65 = null;
    L116:
        r37 = (String) r65;     // Catch: Throwable -> L212
        if (r37 != null) goto L123;
        Object r66 = com.bytedance.android.ec.base.settings.d.a.get("ec_order_prefetch_config");     // Catch: Throwable -> L212
        if ((r66 instanceof String) == true) goto L122;
        r66 = null;
    L122:
        r37 = (String) r66;     // Catch: Throwable -> L212
    L123:
        if (r37 != null) goto L346;
        int r67 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L212
        Object r68 = com.bytedance.android.ec.base.settings.d.c.get("ec_order_prefetch_config");     // Catch: Throwable -> L178
        if (r68 != null) goto L130;
    L175:
        Object r124 = null;
    L176:
        Object r69 = Result.constructor-impl(r124);     // Catch: Throwable -> L178
    L180:
        Throwable r125 = Result.exceptionOrNull-impl(r69);     // Catch: Throwable -> L203
        if (r125 == null) goto L184;
        EnsureManager.ensureNotReachHere(r125);     // Catch: Throwable -> L203
    L184:
        if (Result.isFailure-impl(r69) == false) goto L187;
        r69 = null;
    L187:
        if ((r69 instanceof String) == true) goto L189;
        r69 = null;
    L189:
        r37 = (String) r69;     // Catch: Throwable -> L203
        if (r37 != null) goto L210;
        IHybridHostService r70 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L203
        if (r70 == null) goto L195;
        Object r71 = r70.getHostABValue("ec_order_prefetch_config", "");     // Catch: Throwable -> L203
    L196:
        if (r71 != null) goto L198;
    L209:
        r37 = "";
        goto L210
    L198:
        if ((r71 instanceof String) == true) goto L200;
        r71 = null;
    L200:
        r37 = (String) r71;     // Catch: Throwable -> L203
        if (r37 != null) goto L210;
    L203:
        th = move-exception;
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L212
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L212
        Throwable r127 = Result.exceptionOrNull-impl(r37);     // Catch: Throwable -> L212
        if (r127 == null) goto L208;
        EnsureManager.ensureNotReachHere(r127);     // Catch: Throwable -> L212
    L208:
        if (Result.isFailure-impl(r37) == false) goto L210;
    L195:
        r71 = null;
    L210:
        com.bytedance.android.ec.base.settings.d.d("ec_order_prefetch_config", r37);     // Catch: Throwable -> L212
        goto L346
    L130:
        if ((r68 instanceof String) == true) goto L132;
        Object r128 = null;
    L133:
        r124 = (String) r128;     // Catch: Throwable -> L178
        if (r124 != null) goto L176;
        if ((r68 instanceof Number) == false) goto L163;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L145;
        Float r72 = Float.valueOf(((Number) r68).floatValue());     // Catch: Throwable -> L178
        if ((r72 instanceof String) == true) goto L143;
        r72 = null;
    L143:
        r124 = (String) r72;     // Catch: Throwable -> L178
        goto L176
    L145:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L151;
        Double r73 = Double.valueOf(((Number) r68).doubleValue());     // Catch: Throwable -> L178
        if ((r73 instanceof String) == true) goto L149;
        r73 = null;
    L149:
        r124 = (String) r73;     // Catch: Throwable -> L178
        goto L176
    L151:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L157;
        Integer r74 = Integer.valueOf(((Number) r68).intValue());     // Catch: Throwable -> L178
        if ((r74 instanceof String) == true) goto L155;
        r74 = null;
    L155:
        r124 = (String) r74;     // Catch: Throwable -> L178
        goto L176
    L157:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L163;
        Long r75 = Long.valueOf(((Number) r68).longValue());     // Catch: Throwable -> L178
        if ((r75 instanceof String) == true) goto L161;
        r75 = null;
    L161:
        r124 = (String) r75;     // Catch: Throwable -> L178
    L163:
        if ((r68 instanceof JSONObject) == false) goto L165;
    L338:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L171
        Object r76 = SDKSettingsCacheManager.a().fromJson(r68.toString(), String.class);     // Catch: Throwable -> L171
        if ((r76 instanceof String) == true) goto L169;
        r76 = null;
    L169:
        Object r77 = Result.constructor-impl((String) r76);     // Catch: Throwable -> L171
    L173:
        r124 = r77;
        if (Result.isFailure-impl(r124) == false) goto L176;
    L171:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L178
        r77 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L178
        goto L173
    L165:
        if ((r68 instanceof JSONArray) == false) goto L175;
    L132:
        r128 = r68;
    L178:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L203
        r69 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L203
        goto L180
    L57:
        if ((r64 instanceof String) == true) goto L59;
        Object r131 = null;
    L60:
        r122 = (String) r131;     // Catch: Throwable -> L105
        if (r122 != null) goto L103;
        if ((r64 instanceof Number) == false) goto L90;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L72;
        Float r78 = Float.valueOf(((Number) r64).floatValue());     // Catch: Throwable -> L105
        if ((r78 instanceof String) == true) goto L70;
        r78 = null;
    L70:
        r122 = (String) r78;     // Catch: Throwable -> L105
        goto L103
    L72:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L78;
        Double r79 = Double.valueOf(((Number) r64).doubleValue());     // Catch: Throwable -> L105
        if ((r79 instanceof String) == true) goto L76;
        r79 = null;
    L76:
        r122 = (String) r79;     // Catch: Throwable -> L105
        goto L103
    L78:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L84;
        Integer r80 = Integer.valueOf(((Number) r64).intValue());     // Catch: Throwable -> L105
        if ((r80 instanceof String) == true) goto L82;
        r80 = null;
    L82:
        r122 = (String) r80;     // Catch: Throwable -> L105
        goto L103
    L84:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L90;
        Long r81 = Long.valueOf(((Number) r64).longValue());     // Catch: Throwable -> L105
        if ((r81 instanceof String) == true) goto L88;
        r81 = null;
    L88:
        r122 = (String) r81;     // Catch: Throwable -> L105
    L90:
        if ((r64 instanceof JSONObject) == false) goto L92;
    L332:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L98
        Object r82 = SDKSettingsCacheManager.a().fromJson(r64.toString(), String.class);     // Catch: Throwable -> L98
        if ((r82 instanceof String) == true) goto L96;
        r82 = null;
    L96:
        Object r83 = Result.constructor-impl((String) r82);     // Catch: Throwable -> L98
    L100:
        r122 = r83;
        if (Result.isFailure-impl(r122) == false) goto L103;
    L98:
        th = move-exception;
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L105
        r83 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L105
        goto L100
    L92:
        if ((r64 instanceof JSONArray) == false) goto L102;
    L59:
        r131 = r64;
    L105:
        th = move-exception;
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L212
        r65 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L212
    L212:
        th = move-exception;
        Result.Companion r134 = Result.Companion;
        r37 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r135 = Result.exceptionOrNull-impl(r37);
        if (r135 == null) goto L217;
        EnsureManager.ensureNotReachHere(r135);
    L217:
        if (Result.isFailure-impl(r37) == false) goto L346;
        r37 = "";
        goto L346
    L5:
        Uri r84 = UriProtector.parse(r12);
        Uri.Builder r85 = r84.buildUpon();
        Iterator r136 = UriProtector.getQueryParameterNames(r11).iterator();
    L7:
        if (r136.hasNext() == false) goto L19;
        String r137 = (String) r136.next();
        if (Intrinsics.areEqual(r137, "fallback_url") == true) goto L7;
        if (Intrinsics.areEqual(r137, "mega_object") == true) goto L7;
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r84, r137)) == false) goto L7;
    L18:
        r85.appendQueryParameter(r137, UriProtector.getQueryParameter(r11, r137));
    L16:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L18
    L19:
        String r86 = r85.build().toString();
        if (r11 != null) goto L23;
    L36:
        r0 = String.valueOf(r11);
        goto L4
    L23:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r11, "fallback_url")) == true) goto L36;
        Uri.Builder r87 = r11.buildUpon();
        r87.clearQuery();
        Iterator r88 = UriProtector.getQueryParameterNames(r11).iterator();
    L27:
        if (r88.hasNext() == false) goto L35;
        String r138 = (String) r88.next();
        if ((!Intrinsics.areEqual(r138, "fallback_url")) == true) goto L30;
        r87.appendQueryParameter(r138, r86);
        goto L27
    L30:
        Iterator r139 = UriProtector.getQueryParameters(r11, r138).iterator();
    L32:
        if (r139.hasNext() == false) goto L27;
        r87.appendQueryParameter(r138, (String) r139.next());
        goto L32
    L35:
        r11 = r87.build();
        goto L36
    }

    public static f c(Activity r10, String r11, Map r12, ViewGroup r13, ti.k r14, boolean r15, boolean r16, LifecycleOwner r17, Function1 r18) {
        int r1 = ECSdk.a;     // Catch: Exception -> L9
        IAdapterService r19 = (IAdapterService) ECSdk.a(IAdapterService.class);     // Catch: Exception -> L9
        if (r19 == null) goto L11;
        pd.e r20 = r19.getIExternaHybridService();     // Catch: Exception -> L9
        if (r20 == null) goto L11;
        pd.j r21 = r20.createLynxComponent(r10, r11, new g(r14), r15);     // Catch: Exception -> L9
    L12:
        if (r21 != null) goto L14;
        return null;
    L14:
        r21.getHybridView().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (r13 == null) goto L17;
        r13.addView(r21.getHybridView());
    L17:
        if (r16 == false) goto L24;
        if (r17 == null) goto L20;
    L23:
        r21.c(r17);
        goto L24
    L20:
        if ((r10 instanceof LifecycleOwner) == true) goto L22;
        r10 = null;
    L22:
        r17 = (LifecycleOwner) r10;
    L24:
        f r22 = new f(r21);
        if (r18 == null) goto L27;
        Unit r23 = (Unit) r18.invoke(r22);
    L27:
        r21.renderTemplate(r11, r12);
        return r22;
    L11:
        r21 = null;
    L9:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L11
    }

    public static h e(Activity r10, String r11, Map r12, ViewGroup r13, ti.k r14, boolean r15, boolean r16, LifecycleOwner r17, Function1 r18) {
        int r0 = ECSdk.a;     // Catch: Exception -> L9
        IAdapterService r1 = (IAdapterService) ECSdk.a(IAdapterService.class);     // Catch: Exception -> L9
        if (r1 == null) goto L11;
        pd.e r19 = r1.getIExternaHybridService();     // Catch: Exception -> L9
        if (r19 == null) goto L11;
        pd.g r20 = r19.createWebViewRecord(r10, r11, new i(r14), r15);     // Catch: Exception -> L9
    L12:
        if (r20 != null) goto L14;
        return null;
    L14:
        r20.getHybridView().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (r13 == null) goto L18;
        r13.addView(r20.getHybridView());
    L18:
        if (StringsKt.startsWith$default(r11, "http", false, 2, null) == false) goto L38;
    L23:
        if (r16 == false) goto L30;
        if (r17 == null) goto L26;
    L29:
        r20.c();
        goto L30
    L26:
        if ((r10 instanceof LifecycleOwner) == true) goto L28;
        r10 = null;
    L28:
        LifecycleOwner r21 = (LifecycleOwner) r10;
    L30:
        h r22 = new h(r20);
        if (r18 == null) goto L33;
        Unit r23 = (Unit) r18.invoke(r22);
    L33:
        if (r11 == null) goto L35;
        r20.loadUrl(r11);
    L35:
        return r22;
    L38:
        r11 = UriProtector.getQueryParameter(UriProtector.parse(r11), com.bytedance.android.ec.core.event.a.KEY_URL);     // Catch: Exception -> L22
    L22:
        r11 = "";
    L11:
        r20 = null;
    L9:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L11
    }

    public static ti.l b(Context r17, String r18, Map r19, ViewGroup r20, ti.k r21, HybridType r22, Lifecycle r23, boolean r24, LifecycleOwner r25, Function1 r26, boolean r27, int r28) {
        if ((r28 & 4) == 0) goto L5;
        Map r10 = null;
    L7:
        if ((r28 & 8) == 0) goto L9;
        ViewGroup r11 = null;
    L11:
        if ((r28 & 16) == 0) goto L13;
        ti.k r12 = null;
    L15:
        if ((r28 & 32) == 0) goto L17;
        HybridType r13 = HybridType.LYNX;
    L19:
        if ((r28 & 64) != 0) goto L21;
        Lifecycle r14 = r23;
    L30:
        if ((r28 & 256) == 0) goto L32;
        boolean r15 = false;
    L34:
        if ((r28 & 512) == 0) goto L36;
        LifecycleOwner r16 = null;
    L38:
        if ((r28 & 1024) == 0) goto L40;
        Function1 r110 = null;
    L42:
        if ((r28 & 2048) == 0) goto L44;
        boolean r111 = false;
    L45:
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, com.bytedance.android.ec.core.event.a.KEY_URL);
        Lazy r0 = ECSettingKeys.a;
        int r1 = com.bytedance.android.ec.core.opt.ab.p.a;
        Lazy r112 = ECAppInfoService.a;
        Object r113 = Boolean.valueOf(ECAppInfoService.m());
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L50
        jj4.b r115 = jj4.b.b;     // Catch: Throwable -> L50
        Object r29 = jj4.a.a("ec_use_annie_component", Boolean.class, r113, false);     // Catch: Throwable -> L50
        if (r29 != null) goto L57;
        Intrinsics.throwNpe();     // Catch: Throwable -> L50
    L57:
        if (((Boolean) r29).booleanValue() == true) goto L62;
        Lazy r30 = ECAppInfoService.a;
        if (ECAppInfoService.j() == true) goto L62;
        boolean r31 = false;
    L64:
        if ((r17 instanceof MutableContextWrapper) == false) goto L71;
        Context r116 = r17;
    L67:
        if ((r116 instanceof Activity) == true) goto L73;
        if ((r116 instanceof ContextWrapper) == false) goto L73;
        r116 = ((ContextWrapper) r116).getBaseContext();
    L73:
        if ((r116 instanceof Activity) == true) goto L75;
        r116 = null;
    L75:
        Activity r117 = (Activity) r116;
        if (r117 != null) goto L78;
        r117 = com.bytedance.android.ec.sdk.plugin.e.getActivity(r17);
    L78:
        if (r117 == null) goto L118;
        final Ref.ObjectRef r32 = new Ref.ObjectRef();
        r32.element = null;
        final Lifecycle r118 = r14;
        if (r13 != HybridType.LYNX) goto L95;
        if (StringsKt.startsWith$default(r18, "http", false, 2, null) == false) goto L85;
        r32.element = c(r117, r18, r10, r11, d(r12, r111), r31, r15, r16, r110);
    L109:
        if (((ti.l) r32.element) == null) goto L113;
        if (r118 == null) goto L113;
        r118.addObserver(new ECLiveHybridUtil$createLiveHybridComponent$$inlined$let$lambda$1(r118, r32));
    L113:
        return (ti.l) r32.element;
    L85:
        String r33 = UriProtector.parse(r18).getHost();
        if (r33 == null) goto L109;
        if (r33.hashCode() != 469921128) goto L109;
        if (r33.equals("webcast_lynxview") == false) goto L109;
        r32.element = c(r117, r18, r10, r11, d(r12, r111), r31, r15, r16, r110);
        goto L109
    L95:
        if (r13 != HybridType.WEB) goto L109;
        if (StringsKt.startsWith$default(r18, "http", false, 2, null) == false) goto L99;
        r32.element = e(r117, r18, r10, r11, d(r12, r111), r31, r15, r16, r110);
        goto L109
    L99:
        String r34 = UriProtector.parse(r18).getHost();
        if (r34 == null) goto L109;
        if (r34.hashCode() != 1435311181) goto L109;
        if (r34.equals("webcast_webview") == false) goto L109;
        r32.element = e(r117, r18, r10, r11, d(r12, r111), r31, r15, r16, r110);
        goto L109
    L118:
        return null;
    L71:
        r116 = r17;
    L62:
        r31 = true;
    L50:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        Object r35 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r35) == true) goto L55;
        r113 = r35;
    L55:
        r29 = r113;
        goto L57
    L44:
        r111 = r27;
        goto L45
    L40:
        r110 = r26;
        goto L42
    L36:
        r16 = r25;
        goto L38
    L32:
        r15 = r24;
        goto L34
    L21:
        if ((r17 instanceof FragmentActivity) == true) goto L23;
        Context r36 = null;
    L24:
        FragmentActivity r37 = (FragmentActivity) r36;
        if (r37 == null) goto L27;
        r14 = r37.getLifecycle();
        goto L30
    L27:
        r14 = null;
        goto L30
    L23:
        r36 = r17;
        goto L24
    L17:
        r13 = r22;
        goto L19
    L13:
        r12 = r21;
        goto L15
    L9:
        r11 = r20;
        goto L11
    L5:
        r10 = r19;
        goto L7
    }
}
