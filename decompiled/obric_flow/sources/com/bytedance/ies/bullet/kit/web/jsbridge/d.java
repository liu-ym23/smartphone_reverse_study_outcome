package com.bytedance.ies.bullet.kit.web.jsbridge;

import android.text.TextUtils;
import bd.f;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.web.jsbridge2.o;
import com.bytedance.ies.web.jsbridge2.p;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SSWebView f5548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f5549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f5550c;
    public final ArrayList d;
    public final ArrayList e;
    public final ArrayList f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f5551h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public xk.c f5552i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ce.b f5553j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public p f5554k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public o f5555l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Function2 f5556m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LinkedHashMap f5557n;

    public d(SSWebView r5) {
        Intrinsics.checkNotNullParameter(r5, "webView");
        this.f5548a = r5;
        this.f5550c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        ((com.bytedance.android.anniex.base.depend.b) com.bytedance.android.anniex.base.depend.a.f3113b.getValue()).getClass();
        this.g = "ToutiaoJSBridge";
        this.f5551h = "bytedance";
        LazyKt.lazy(WebJsBridge$gson$2.f5542a);
        this.f5557n = new LinkedHashMap();
    }

    public final void a(com.bytedance.ies.bullet.core.kit.bridge.b r5, String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r5, "method");
        LinkedHashMap r12 = this.f5557n;
        if (r10 == null) goto L7;
        com.bytedance.ies.bullet.core.kit.bridge.c r13 = (com.bytedance.ies.bullet.core.kit.bridge.c) r12.get(r10);
        if (r13 != null) goto L8;
        r13 = new com.bytedance.ies.bullet.core.kit.bridge.c();
        r12.put(r10, r13);
    L8:
        if (r13 == null) goto L10;
        r13.e = System.currentTimeMillis();
    L10:
        ce.b r14 = this.f5553j;
        if (r14 == null) goto L13;
        r14.g(r10, r11);
    L13:
        if (r13 == null) goto L22;
        r13.f = System.currentTimeMillis();
        r13.g = System.currentTimeMillis();
        if (r13.a() == false) goto L23;
        if (r10 == null) goto L18;
        com.bytedance.ies.bullet.core.kit.bridge.c r15 = (com.bytedance.ies.bullet.core.kit.bridge.c) r12.remove(r10);
    L18:
        Function2 r16 = this.f5556m;
        if (r16 == null) goto L24;
        r16.mo2invoke(r5.g(), r13);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L7:
        r13 = null;
        goto L8
    }

    public final void b(String r5, JSONObject r10) {
        ce.b r11 = this.f5553j;
        if (r11 == null) goto L12;
        if (TextUtils.isEmpty(r5) == true) goto L13;
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L9
        r12.put("__msg_type", "event");     // Catch: Exception -> L9
        r12.put("__event_id", r5);     // Catch: Exception -> L9
        r12.put("__params", r10);     // Catch: Exception -> L9
        r11.h(r12);     // Catch: Exception -> L9
        return;
    L13:
        return;
    L14:
        return;
    }
}
