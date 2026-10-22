package com.bytedance.android.annie.monitor.common.timing.jsb;

import android.view.View;
import android.webkit.WebView;
import c7.a;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.container.fragment.o;
import com.bytedance.android.annie.monitor.common.timing.PerformanceTiming;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import m16.b;
import org.json.JSONObject;
import sz2.e;
import y6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "getPerfTiming")
public final class GetPerfTimingMethod extends f<JSONObject, Object> {
    public final c a;
    public final Lazy b;
    public final Lazy c;

    public final void onTerminate() {
    }

    public GetPerfTimingMethod(b r10) {
        Intrinsics.checkNotNullParameter(r10, "contextProviderFactory");
        this.b = LazyKt.lazy(GetPerfTimingMethod$mainLooper$2.INSTANCE);
        this.c = LazyKt.lazy(new GetPerfTimingMethod$mHandler$2(this));
        JSBridgeManager r11 = (JSBridgeManager) r10.c(JSBridgeManager.class);
        if (r11 == null) goto L6;
        this.a = r11;
        return;
    }

    public GetPerfTimingMethod(c r10) {
        Intrinsics.checkNotNullParameter(r10, "manager");
        this.b = LazyKt.lazy(GetPerfTimingMethod$mainLooper$2.INSTANCE);
        this.c = LazyKt.lazy(new GetPerfTimingMethod$mHandler$2(this));
        this.a = r10;
    }

    public static final int j(GetPerfTimingMethod r10, JSONObject r11) {
        r10.getClass();
        if (r11.optInt("is_memory") != 1) goto L5;
        int r12 = 1;
    L7:
        if (r11.optInt("is_preloaded") != 1) goto L10;
        r12 = r12 + 2;
    L10:
        if (r11.optInt("is_request_reused") == 1) goto L12;
        return r12;
    L12:
        return r12 + 4;
    L5:
        r12 = 0;
        goto L7
    }

    public final void invoke(Object r14, final CallContext r15) {
        JSONObject r16 = (JSONObject) r14;
        Intrinsics.checkNotNullParameter(r16, "params");
        Intrinsics.checkNotNullParameter(r15, "context");
        final JSONObject r10 = new JSONObject();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L67
        c r11 = this.a;     // Catch: Throwable -> L67
        Map<String, Long> r12 = null;
        if (r11 == null) goto L17;
        IHybridComponent r13 = r11.c();     // Catch: Throwable -> L67
        if (r13 == null) goto L17;
        if ((r13 instanceof o) == true) goto L11;
        r13 = null;
    L11:
        if (r13 == null) goto L17;
        a r17 = ((o) r13).getAnnieContext();     // Catch: Throwable -> L67
        if (r17 == null) goto L17;
        String r18 = r17.getUuid();     // Catch: Throwable -> L67
        if (r18 == null) goto L17;
    L23:
        final int r19 = r16.optInt("level");     // Catch: Throwable -> L67
        if (r19 != 0) goto L64;
        c r110 = this.a;     // Catch: Throwable -> L67
        if (r110 == null) goto L30;
        IHybridComponent r111 = r110.c();     // Catch: Throwable -> L67
        if (r111 == null) goto L30;
        Map<String, Long> r112 = r111.getExtraPerfInfo();     // Catch: Throwable -> L67
    L31:
        ConcurrentHashMap<String, PerformanceTiming> r20 = l8.b.a;     // Catch: Throwable -> L67
        Intrinsics.checkNotNullParameter(r18, "uuid");     // Catch: Throwable -> L67
        ConcurrentHashMap<String, PerformanceTiming> r21 = l8.b.a;     // Catch: Throwable -> L67
        PerformanceTiming r22 = r21.get(r18);     // Catch: Throwable -> L67
        if (r22 == null) goto L35;
        Map<String, Object> r23 = r22.getPerfInfo();     // Catch: Throwable -> L67
    L37:
        if (r23 == null) goto L52;
        JSONObject r24 = new JSONObject(r23);     // Catch: Throwable -> L67
        if (r112 == null) goto L44;
        Long r25 = r112.get("res_from");     // Catch: Throwable -> L67
        if (r25 == null) goto L44;
        long r26 = r25.longValue();     // Catch: Throwable -> L67
    L46:
        if (r26 != 0) goto L49;
        r24.put("main_res_type", "gecko");     // Catch: Throwable -> L67
    L51:
        r10.put("container_info", r24);     // Catch: Throwable -> L67
        goto L52
    L49:
        if (r26 != 1) goto L51;
        r24.put("main_res_type", "cdn");     // Catch: Throwable -> L67
    L44:
        r26 = -1;
    L52:
        Intrinsics.checkNotNullParameter(r18, "uuid");     // Catch: Throwable -> L67
        PerformanceTiming r0 = r21.get(r18);     // Catch: Throwable -> L67
        if (r0 == null) goto L55;
        r12 = r0.getPerfTimingMap();     // Catch: Throwable -> L67
    L55:
        LinkedHashMap r27 = new LinkedHashMap();     // Catch: Throwable -> L67
        if (r12 == null) goto L58;
        r27.putAll(r12);     // Catch: Throwable -> L67
    L58:
        if (r112 == null) goto L61;
        r27.putAll(r112);     // Catch: Throwable -> L67
        r27.remove("res_from");     // Catch: Throwable -> L67
    L61:
        if ((!r27.isEmpty()) == false) goto L63;
        r10.put("container_timing", new JSONObject(r27));     // Catch: Throwable -> L67
    L63:
        k(r15, r18, r10);     // Catch: Throwable -> L67
        finishWithResult(r10);     // Catch: Throwable -> L67
    L65:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L67
        return;
    L35:
        r23 = null;
    L30:
        r112 = null;
        goto L31
    L64:
        int r113 = r16.optInt("waitCompleteData");     // Catch: Throwable -> L67
        e r28 = e.a;     // Catch: Throwable -> L67
        final String r29 = r18;
        Function1<JSONObject, Unit> r30 = new GetPerfTimingMethod$invoke$1$1$4(r10, this, r15, r29, r19);     // Catch: Throwable -> L67
        r28.getClass();     // Catch: Throwable -> L67
        e.g(r18, r113, r30);     // Catch: Throwable -> L67
    L17:
        c r31 = this.a;     // Catch: Throwable -> L67
        if (r31 == null) goto L22;
        IHybridComponent r32 = r31.c();     // Catch: Throwable -> L67
        if (r32 == null) goto L22;
        r18 = r32.containerId();     // Catch: Throwable -> L67
    L22:
        r18 = "";
    L67:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static void k(CallContext r10, String r11, JSONObject r12) {
        View r13 = r10.d;
        if (r13 == null) goto L39;
        Map<String, Object> r1 = null;
        if ((r13 instanceof WebView) == true) goto L8;
        r13 = null;
    L8:
        if (r13 == null) goto L40;
        WebView r14 = (WebView) r13;
        ConcurrentHashMap<String, PerformanceTiming> r0 = l8.b.a;
        Intrinsics.checkNotNullParameter(r11, "uuid");
        Intrinsics.checkNotNullParameter(r14, "webView");
        PerformanceTiming r15 = l8.b.a.get(r11);
        if (r15 == null) goto L12;
        com.bytedance.android.annie.monitor.common.timing.a r16 = r15.getTTWebViewLoadInfo(r14);
    L13:
        if (r16 == null) goto L38;
    L22:
        if (r16 == null) goto L41;
        Map<String, Long> r17 = r16.a;
        if (r17.isEmpty() == false) goto L26;
        r17 = null;
    L26:
        if (r17 == null) goto L28;
        r12.put("ttwebview_timing", new JSONObject(r17));
    L28:
        Map<String, Object> r18 = r16.b;
        if (r18.isEmpty() == true) goto L32;
        r1 = r18;
    L32:
        if (r1 == null) goto L34;
        r12.put("ttwebview_info", new JSONObject(r1));
    L34:
        String r19 = r16.c;
        if (r19 == null) goto L42;
        r12.put("ttwebview_new_metrics", new JSONObject(r19));
        return;
    L42:
        return;
    L41:
        return;
    L38:
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L19
        JSONObject r21 = ((aa.b) Annie.getService$default(aa.b.class, null, 2, null)).g0(r14);     // Catch: Throwable -> L19
        if (r21 == null) goto L17;
        List<String> r22 = com.bytedance.android.annie.monitor.common.timing.a.d;     // Catch: Throwable -> L19
        r16 = com.bytedance.android.annie.monitor.common.timing.a.C0071a.a(r21, null);     // Catch: Throwable -> L19
        goto L22
    L17:
        Result.constructor-impl(null);     // Catch: Throwable -> L19
    L21:
        r16 = null;
    L19:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L12:
        r16 = null;
        goto L13
    L40:
        return;
    }
}
