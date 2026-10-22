package com.bytedance.android.live.browser.service;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.platform.IHostWebView;
import com.bytedance.android.livehostapi.platform.ISaasHostWebView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class AnnieExternalServiceImpl implements f9.b {
    public static String b;
    public final Lazy a;

    public static final class a {
    }

    public final void setCachePrefix(List<Pattern> r2) {
        Intrinsics.checkNotNullParameter(r2, "patterns");
    }

    static {
        b = "";
    }

    public final String getHostGeckoCacheDir() {
        return jc1.k.n(IHostWebView.class).getHostGeckoCacheDir();
    }

    public final List<String> getSafeJsbHostList() {
        ArrayList r0 = new ArrayList();
        r0.addAll(jc1.k.n(IHostWebView.class).getSafeJsbHostList());
        r0.add("lf-webcast-sourcecdn-tos.bytegecko.com");
        return r0;
    }

    public final void m1() {
        jc1.k.n(IHostWebView.class).initXBridge();
    }

    public AnnieExternalServiceImpl() {
        this.a = LazyKt.lazy(AnnieExternalServiceImpl$resourceInterceptor$2.INSTANCE);
    }

    public final Map<String, String> getHeaderMap(String r3) {
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L6;
        HashMap r4 = new HashMap();
        r4.put("x-use-ppe", GamePromoteDataContext.GAME_TYPE_MOBILE);
        r4.put("X-Tt-Env", jc1.k.n(IMiddleWareHostContext.class).getHostBoeParams().getPpeLane());
        return r4;
    L6:
        return new LinkedHashMap();
    }

    public final WebResourceResponse interceptRequest(String r7) {
        o30.a r0 = (o30.a) this.a.getValue();
        String r1 = b;
        r0.getClass();
        r0.a = r1 + File.separator;
        o30.a r2 = (o30.a) this.a.getValue();
        Uri r3 = UriProtector.parse(r7);
        r2.getClass();
        WebResourceResponse r4 = null;
        if (TextUtils.equals(r3.getScheme(), "liveresource") == true) goto L5;
    L28:
        WebResourceResponse r5 = null;
    L29:
        if (r5 != null) goto L44;
        ISaasHostWebView r6 = jc1.k.f(ISaasHostWebView.class);     // Catch: Exception -> L34
        if (r6 == null) goto L37;
        r4 = r6.interceptRequestWithHost(r7);     // Catch: Exception -> L34
    L37:
        return r4;
    L34:
        e = move-exception;
        ALogger.e("interceptRequestWithHost", e.getMessage());
        goto L37
    L44:
        return r5;
    L5:
        if (TextUtils.equals(r3.getHost(), "file") == false) goto L28;
        if (TextUtils.isEmpty(r2.a) == true) goto L28;
        String r8 = UriProtector.getQueryParameter(r3, "path");
        if (TextUtils.isEmpty(r8) == true) goto L28;
        PolarisFileWrapper r9 = new PolarisFileWrapper(r8);
        String r11 = r9.getCanonicalPath();     // Catch: IOException -> L16
    L18:
        if (TextUtils.isEmpty(r11) == true) goto L28;
        if (r11.startsWith(r2.a) == false) goto L28;
        if (r9.exists() == false) goto L28;
        r5 = new WebResourceResponse("", "", new PolarisFileInputStreamWrapper(r9));     // Catch: FileNotFoundException -> L27
    L16:
        r11 = null;
        goto L18
    }
}
