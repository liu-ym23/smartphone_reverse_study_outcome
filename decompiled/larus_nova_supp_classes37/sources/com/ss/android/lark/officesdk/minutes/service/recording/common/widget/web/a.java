package com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web;

import android.os.Build;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class a extends WebViewClient {
    public final e a;

    public a(e r2) {
        Intrinsics.checkNotNullParameter(r2, "renderGoneHandler");
        this.a = r2;
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView r8, RenderProcessGoneDetail r9) {
        e r0 = this.a;
        r0.getClass();
        long r1 = System.currentTimeMillis();
        int r3 = Build.VERSION.SDK_INT;
        int r4 = 0;
        if (r3 < 26) goto L6;
        if (r9 == null) goto L6;
        boolean r6 = r9.didCrash();
    L7:
        if (r3 < 26) goto L10;
        if (r9 == null) goto L10;
        r4 = r9.rendererPriorityAtExit();
    L10:
        lvb.a.b(r0.b, "[handleRenderProcessGone] didCrash=" + r6 + ", rendererPriority=" + r4 + ", isInBackground=" + r0.e + ", recreateCount=" + r0.c);
        if (((Boolean) r0.a.d.invoke(r8)).booleanValue() == true) goto L17;
        String r10 = r0.b;
        StringBuilder r2 = new StringBuilder("[handleRenderProcessGone] ignore stale webView callback, callbackWebView=");
        if (r8 == null) goto L15;
        Integer r11 = Integer.valueOf(r8.hashCode());
    L16:
        r2.append(r11);
        lvb.a.b(r10, r2.toString());
    L27:
        return true;
    L15:
        r11 = null;
        goto L16
    L17:
        r0.a.e.invoke();
        Function2<String, JSONObject, Unit> r12 = r0.a.h;
        JSONObject r13 = new JSONObject();
        r13.put("did_crash", r6);
        r13.put("renderer_priority", r4);
        r13.put("web_view_type", r0.a.a);
        r13.put("is_in_background", r0.e);
        r13.put("recreate_count", r0.c);
        Unit r5 = Unit.INSTANCE;
        r12.invoke("mm_webview_render_gone", r13);
        long r7 = r1 - r0.d;
        e.b r14 = r0.a;
        if (r7 >= r14.c) goto L21;
        lvb.a.b(r0.b, "[handleRenderProcessGone] in cooldown period, mark load failed");
        r0.a.g.invoke();
        goto L27
    L21:
        if (r0.c < r14.b) goto L24;
        lvb.a.b(r0.b, "[handleRenderProcessGone] max recreate count reached");
        r0.a.g.invoke();
        goto L27
    L24:
        if (r0.e == false) goto L26;
        lvb.a.e(r0.b, "[handleRenderProcessGone] in background, mark need recreate on resume");
        r0.f = true;
        goto L27
    L26:
        r0.b();
    L6:
        r6 = false;
        goto L7
    }
}
