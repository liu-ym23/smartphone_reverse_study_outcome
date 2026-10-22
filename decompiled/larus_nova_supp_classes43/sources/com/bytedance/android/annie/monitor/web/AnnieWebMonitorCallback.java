package com.bytedance.android.annie.monitor.web;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.card.web.e;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.monitorV2.webview.m;
import i9.d;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieWebMonitorCallback extends e {
    public static boolean b;
    public static final Lazy<Map<String, String>> c = null;

    public static final class a {
    }

    public AnnieWebMonitorCallback() {
        super(null);
    }

    static {
        b = true;
        c = LazyKt.lazy(AnnieWebMonitorCallback$Companion$annieMonitorAbConfig$2.INSTANCE);
    }

    @Override // com.bytedance.android.annie.card.web.e
    public final void C() {
        m.f.getClass();
    }

    @Override // com.bytedance.android.annie.card.web.e
    public final void y() {
        m.f.getClass();
    }

    @Override // com.bytedance.android.annie.card.web.e
    public final void A(WebView r10) {
        Intrinsics.checkNotNullParameter(r10, "webView");
        Intrinsics.checkNotNullParameter(r10, "webView");
        if (AnnieConfigSettingKeys.ENABLE_HYBRID_KIT.a().booleanValue() == true) goto L6;
        m.f.A(r10);
        return;
    }

    @Override // com.bytedance.android.annie.card.web.e
    public final void B(WebView r10) {
        if (AnnieConfigSettingKeys.ENABLE_HYBRID_KIT.a().booleanValue() == true) goto L6;
        m.f.M(r10);
        return;
    }

    @Override // com.bytedance.android.annie.card.web.e
    public final void d(WebView r10) {
        if (AnnieConfigSettingKeys.ENABLE_HYBRID_KIT.a().booleanValue() == true) goto L6;
        m.f.E(r10);
        return;
    }

    @Override // com.bytedance.android.annie.card.web.e
    public final void e(WebView r10) {
        if (AnnieConfigSettingKeys.ENABLE_HYBRID_KIT.a().booleanValue() == true) goto L6;
        m.f.k(r10);
        return;
    }

    @Override // com.bytedance.android.annie.card.web.e
    public final void q(WebView r10) {
        if (AnnieConfigSettingKeys.ENABLE_HYBRID_KIT.a().booleanValue() == true) goto L6;
        m.f.l(r10);
        return;
    }

    @Override // com.bytedance.android.annie.card.web.e, com.bytedance.android.annie.card.base.b
    public final void g(View r10, String r11) {
        if ((r10 instanceof WebView) == true) goto L5;
        return;
    L5:
        super.g(r10, r11);
        if (AnnieConfigSettingKeys.ENABLE_HYBRID_KIT.a().booleanValue() == true) goto L9;
        m.f.H((WebView) r10, r11);
        return;
    }

    @Override // com.bytedance.android.annie.card.web.e
    public final void s(WebView r10, String r11) {
        if (AnnieConfigSettingKeys.ENABLE_HYBRID_KIT.a().booleanValue() == true) goto L6;
        m.f.F(r10, r11);
        return;
    }

    @Override // com.bytedance.android.annie.card.web.e
    public final void t(WebView r10, int r11) {
        if (AnnieConfigSettingKeys.ENABLE_HYBRID_KIT.a().booleanValue() == true) goto L6;
        m.f.K(r10, r11);
        return;
    }

    @Override // com.bytedance.android.annie.card.web.e
    public final void u(WebView r10, WebResourceRequest r11, WebResourceError r12) {
        boolean r0 = true;
        if (r11 != null) goto L5;
    L7:
        boolean r13 = false;
    L8:
        if (r13 == false) goto L20;
        Uri r14 = r11.getUrl();
        if (r14 == null) goto L16;
        String r15 = r14.getPath();
        if (r15 == null) goto L16;
        if (StringsKt.endsWith$default(r15, "favicon.ico", false, 2, null) != true) goto L16;
    L17:
        if (r0 == false) goto L20;
        return;
    L16:
        r0 = false;
    L20:
        if (AnnieConfigSettingKeys.ENABLE_HYBRID_KIT.a().booleanValue() == true) goto L23;
        m.f.u(r10, r11, r12);
        return;
    L23:
        return;
    L5:
        if (r11.isForMainFrame() == true) goto L7;
        r13 = true;
        goto L8
    }

    @Override // com.bytedance.android.annie.card.web.e
    public final void v(WebView r10, WebResourceRequest r11, WebResourceResponse r12) {
        boolean r0 = true;
        if (r11 != null) goto L5;
    L7:
        boolean r13 = false;
    L8:
        if (r13 == false) goto L20;
        Uri r14 = r11.getUrl();
        if (r14 == null) goto L16;
        String r15 = r14.getPath();
        if (r15 == null) goto L16;
        if (StringsKt.endsWith$default(r15, "favicon.ico", false, 2, null) != true) goto L16;
    L17:
        if (r0 == false) goto L20;
        return;
    L16:
        r0 = false;
    L20:
        if (AnnieConfigSettingKeys.ENABLE_HYBRID_KIT.a().booleanValue() == true) goto L23;
        m.f.x(r10, r11, r12);
        return;
    L23:
        return;
    L5:
        if (r11.isForMainFrame() == true) goto L7;
        r13 = true;
        goto L8
    }

    @Override // com.bytedance.android.annie.card.web.e, com.bytedance.android.annie.card.base.b
    public final void k(View r10, String r11, Bitmap r12, boolean r13) {
        if ((r10 instanceof WebView) == true) goto L31;
        return;
    L31:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L27
        String r1 = "yes";
        if (AnnieConfigSettingKeys.ENABLE_HYBRID_KIT.a().booleanValue() == true) goto L9;
        m.f.I((WebView) r10, r11);     // Catch: Throwable -> L27
    L14:
        String r14 = ((d) Annie.getService$default(d.class, null, 2, null)).k0();     // Catch: Throwable -> L27
        if (r14 == null) goto L17;
        m.f.i((WebView) r10, "webcast_sdk_version", r14);     // Catch: Throwable -> L27
    L17:
        m r15 = m.f;     // Catch: Throwable -> L27
        r15.i((WebView) r10, "use_new_container", "1");     // Catch: Throwable -> L27
        WebView r16 = (WebView) r10;     // Catch: Throwable -> L27
        if (b == true) goto L21;
        r1 = "no";
    L21:
        r15.i(r16, "engine_first_open", r1);     // Catch: Throwable -> L27
        b = false;     // Catch: Throwable -> L27
        Iterator r17 = ((Map) c.getValue()).entrySet().iterator();     // Catch: Throwable -> L27
    L23:
        if (r17.hasNext() == false) goto L25;
        Map.Entry r18 = (Map.Entry) r17.next();     // Catch: Throwable -> L27
        String r19 = (String) r18.getKey();     // Catch: Throwable -> L27
        String r20 = (String) r18.getValue();     // Catch: Throwable -> L27
        m.f.i((WebView) r10, r19, r20);     // Catch: Throwable -> L27
        goto L23
    L25:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        super.k(r10, r11, r12, r13);
        return;
    L9:
        m r21 = m.f;     // Catch: Throwable -> L27
        WebView r22 = (WebView) r10;     // Catch: Throwable -> L27
        if (AnnieConfigSettingKeys.ENABLE_WEB_PRE_CREATE.a().booleanValue() == false) goto L12;
        String r23 = "yes";
    L13:
        r21.i(r22, "webkit_pre_create", r23);     // Catch: Throwable -> L27
        goto L14
    L12:
        r23 = "no";
    L27:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    }
}
