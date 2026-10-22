package com.bytedance.ai.model;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.bytedance.ai.model.widgets.WebViewFloatingPageV2;
import com.bytedance.ai.monitor.bridge.BridgeType;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r {
    @JavascriptInterface
    public final void appletPostMessage(String r10) {
        a3.i r5 = a3.i.f83a;
        WebViewFloatingPageV2 r11 = ((u) this).f2301a;
        String r12 = r11.f2329a.f2197h.F;
        BridgeType r13 = BridgeType.f2387b;
        Intrinsics.checkNotNullParameter("appletPostMessageWebView", "name");
        Intrinsics.checkNotNullParameter(r13, "type");
        Object r14 = null;
        z2.d.b("applet_old_bridge", new com.bytedance.ies.web.jsbridge2.p(1, "appletPostMessageWebView", r13, r12, r14));
        if (r10 == null) goto L63;
        final AppletRuntime r15 = r11.f2329a;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r10, "param");
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r10) == false) goto L56;
    L7:
        JSONObject r17 = null;
    L12:
        if (r17 == null) goto L16;
        String r18 = r17.optString("eventName");     // Catch: Throwable -> L14
    L17:
        Object r19 = Result.m124constructorimpl(r18);     // Catch: Throwable -> L14
    L21:
        if (Result.m130isFailureimpl(r19) == false) goto L23;
        r19 = null;
    L23:
        String r20 = (String) r19;
    L33:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        Object r22 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L40:
        if (Result.m130isFailureimpl(r22) == true) goto L43;
        r14 = r22;
    L43:
        JSONObject r23 = (JSONObject) r14;
        final JavaOnlyMap r24 = new JavaOnlyMap();
        if (r20 == null) goto L46;
        r24.put("eventName", r20);
    L46:
        if (r23 == null) goto L52;
        JavaOnlyMap r25 = new JavaOnlyMap();
        Iterator<String> r26 = r23.keys();
    L49:
        if (r26.hasNext() == false) goto L51;
        String r27 = r26.next();
        r25.put(r27, r23.get(r27));
        goto L49
    L51:
        r24.put("data", r25);
    L52:
        r15.t().d(new h(r15, r24));
        return;
    L25:
        if (TextUtils.isEmpty(r10) == false) goto L60;
    L26:
        JSONObject r28 = null;
    L31:
        if (r28 == null) goto L35;
        JSONObject r29 = r28.getJSONObject("data");     // Catch: Throwable -> L33
    L36:
        r22 = Result.m124constructorimpl(r29);     // Catch: Throwable -> L33
        goto L40
    L35:
        r29 = null;
        goto L36
    L60:
        r28 = new JSONObject(r10);     // Catch: JSONException -> L29 Throwable -> L33
    L29:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L33
        goto L26
    L16:
        r18 = null;
        goto L17
    L56:
        r17 = new JSONObject(r10);     // Catch: JSONException -> L10 Throwable -> L14
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r19 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L21
    }
}
