package com.bytedance.android.annie.business.web;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.android.annie.card.base.HybridDomainUtils;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.android.annie.param.AnnieXLiveContext;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.common.util.HoneyCombV11Compat;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.kit.web.e;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import o7.l;
import t36.f;
import t36.j;
import y9.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieXLiveWebGlobalConfigService extends e26.a {
    public final Context b;

    public static final class a extends c26.b {
        public final List<String> a() {
            return null;
        }

        public final List<String> b() {
            return null;
        }

        public final List<String> c() {
            return null;
        }

        public final String j() {
            return "ToutiaoJSBridge";
        }

        public final String k() {
            return "bytedance";
        }

        public final List<String> e() {
            return (List) HybridDomainUtils.a.getValue();
        }

        public final Boolean g() {
            com.bytedance.android.anniex.assemble.a.h();
            return Boolean.FALSE;
        }

        public a() {
        }
    }

    public AnnieXLiveWebGlobalConfigService(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.b = r10;
    }

    public final c26.d X(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "providerFactory");
        return new b(r10);
    }

    public final e Z(final m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "providerFactory");
        return new AnnieXLiveWebGlobalConfigService$createWebViewLoadUrlInterceptorDelegate$1(r10);
    }

    public final c26.c e0(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "providerFactory");
        return new AnnieXLiveWebChromeClient(this.b, r10);
    }

    public final Map<String, Object> j0(m16.b r14) {
        Intrinsics.checkNotNullParameter(r14, "providerFactory");
        m16.c r0 = r14.a(AnnieXLiveContext.class);
        String r1 = null;
        if (r0 == null) goto L5;
        AnnieXLiveContext r10 = (AnnieXLiveContext) r0.provideInstance();
    L6:
        i<Boolean> r11 = AnnieConfigSettingKeys.ENABLE_ANNIEX_WEBCAST_GLOBALPROPS_REUSE;
        if (r11.a().booleanValue() == false) goto L14;
        if (r10 == null) goto L10;
        Map<String, Object> r12 = r10.getGlobalProps();
    L11:
        if (r12 == null) goto L14;
        return r10.getGlobalProps();
    L10:
        r12 = null;
    L14:
        m16.c r13 = r14.a(Context.class);
        if (r13 == null) goto L17;
        Context r15 = (Context) r13.provideInstance();
    L18:
        m16.c r16 = r14.a(BulletContext.class);
        if (r16 == null) goto L21;
        BulletContext r17 = (BulletContext) r16.provideInstance();
    L23:
        if (r10 == null) goto L26;
        Uri r18 = r10.getUri();
        if (r18 == null) goto L26;
    L36:
        if (r10 == null) goto L39;
        String r19 = r10.getBizKey();
        if (r19 == null) goto L39;
    L40:
        String r110 = r19;
        b8.a r20 = b8.a.a;
        b8.a.a(new b8.b("AnnieXLiveWebGlobalConfigService", LogLevel.ERROR, null, "url: " + r18 + '.'), true);
        LinkedHashMap r111 = new LinkedHashMap();
        r111.put("lynxVersion", "");
        r111.put("lynx_version", "");
        i7.a r21 = i7.a.a;
        if (r17 == null) goto L43;
        String r22 = r17.f;
    L44:
        if (r18 == null) goto L46;
        String r23 = r18.toString();
    L47:
        boolean r24 = !o7.e.a();
        if (r18 == null) goto L53;
        String r112 = UriProtector.getQueryParameter(r18, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r112 == null) goto L53;
        String r113 = r112;
    L56:
        i7.a.b(r21, r111, r22, r15, r23, r24, r113, r110);
        if (r11.a().booleanValue() == false) goto L61;
        if (r10 == null) goto L61;
        r10.setGlobalProps(r111);
    L61:
        return r111;
    L53:
        if (r18 == null) goto L55;
        r1 = r18.toString();
    L55:
        r113 = r1;
        goto L56
    L46:
        r23 = null;
        goto L47
    L43:
        r22 = null;
    L39:
        r19 = "host";
    L26:
        if (r17 != null) goto L28;
    L30:
        boolean r25 = false;
    L31:
        if (r25 == false) goto L35;
        t36.d r26 = r17.e;
        if (r26 == null) goto L35;
        r18 = r26.getOriginUrl();
    L35:
        r18 = null;
        goto L36
    L28:
        if (r17.G != true) goto L30;
        r25 = true;
        goto L31
    L21:
        r17 = null;
        goto L23
    L17:
        r15 = null;
        goto L18
    L5:
        r10 = null;
        goto L6
    }

    public final com.bytedance.ies.bullet.kit.web.jsbridge.e s0(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "providerFactory");
        return new a();
    }

    public final void h0(WebSettings r10, WebView r11, m16.b r12) {
        Intrinsics.checkNotNullParameter(r10, "settings");
        Intrinsics.checkNotNullParameter(r11, "webView");
        Intrinsics.checkNotNullParameter(r12, "providerFactory");
        super.h0(r10, r11, r12);
        boolean r0 = false;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        HoneyCombV11Compat.setDisplayZoomControl(r11.getSettings(), false);     // Catch: Throwable -> L5
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Result.exceptionOrNull-impl(r13);
        r10.setMixedContentMode(2);
        m16.c r14 = r12.a(BulletContext.class);
        Boolean r15 = null;
        if (r14 == null) goto L10;
        BulletContext r16 = (BulletContext) r14.provideInstance();
    L11:
        if (r16 == null) goto L15;
        j r17 = r16.g;
        if (r17 == null) goto L15;
        f r18 = r17.b;
    L17:
        if ((r18 instanceof v36.a) == false) goto L19;
        v36.a r19 = (v36.a) r18;
    L20:
        if (r19 == null) goto L28;
        y36.i r20 = r19.j;
        if (r20 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("enableFontScale");
        r20 = null;
    L25:
        if (r20 == null) goto L28;
        r15 = (Boolean) r20.b;
    L28:
        if (Intrinsics.areEqual(r15, Boolean.FALSE) == false) goto L30;
        r10.setTextZoom(100);
    L30:
        String r21 = l.e(this.b, r11);
        if (r21.length() != 0) goto L33;
        r0 = true;
    L33:
        if (r0 == true) goto L36;
        r21 = l.b(new StringBuilder(r21));
    L36:
        r10.setUserAgentString(r21);
        return;
    L19:
        r19 = null;
    L15:
        r18 = null;
        goto L17
    L10:
        r16 = null;
    L5:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
