package com.bytedance.android.live.effect.utils;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.livehostapi.foundation.depend.LiveCall;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.common.utility.Lists;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.ss.android.ugc.effectmanager.common.EffectRequest;
import com.ss.android.ugc.effectmanager.knadapt.InputStreamByteRead;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e extends d {
    public final HashMap<String, Retrofit> b;

    public e() {
        this.b = new HashMap();
    }

    public static String b(SsResponse r4) {
        if (Lists.notEmpty(r4.headers()) == false) goto L10;
        Iterator r5 = r4.headers().iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        Header r0 = (Header) r5.next();
        if (StringsKt.equals("x-tt-logid", r0.getName(), true) == false) goto L6;
        return r0.getValue();
    L10:
        return "";
    }

    public final Retrofit c(String r3) {
        Retrofit r0 = this.b.get(r3);
        if (r0 != null) goto L6;
        Retrofit r1 = com.bytedance.android.live.network.c.b().c().newBuilder().setEndpoint(r3).build();
        this.b.put(r3, r1);
        return r1;
    L6:
        return r0;
    }

    @Override // com.bytedance.android.live.effect.utils.d
    public final InputStream execute(EffectRequest r9) {
        Intrinsics.checkNotNullParameter(r9, "request");
        InputStream r1 = null;
        if (TextUtils.isEmpty(r9.getHttpMethod()) == false) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual("GET", r9.getHttpMethod()) == true) goto L57;
        LinkedHashMap r3 = new LinkedHashMap();
        boolean r4 = r9.isUseCommonParams();
        Pair r5 = UrlUtils.parseUrl(r9.getUrl(), r3);
        ALogger.i("EffectPlatform", "request begin : " + r9.getUrl());     // Catch: Exception -> L39 IOException -> L41
        String r2 = (String) r5.first;     // Catch: Exception -> L39 IOException -> L41
        String r6 = (String) r5.second;     // Catch: Exception -> L39 IOException -> L41
        EffectNetworkAPIForSaas r7 = (EffectNetworkAPIForSaas) c(r2).create(EffectNetworkAPIForSaas.class);     // Catch: Exception -> L39 IOException -> L41
        if (Intrinsics.areEqual("POST", r9.getHttpMethod()) == false) goto L12;
        SsResponse r8 = r7.doPost(r4, Integer.MAX_VALUE, r6, r9.getParams()).execute();     // Catch: Exception -> L39 IOException -> L41
    L13:
        List r11 = r8.headers();     // Catch: Exception -> L39 IOException -> L41
        if (r11 == null) goto L28;
        HashMap r12 = new HashMap();     // Catch: Exception -> L39 IOException -> L41
        Iterator r13 = r11.iterator();     // Catch: Exception -> L39 IOException -> L41
    L17:
        if (r13.hasNext() == false) goto L26;
        Header r14 = (Header) r13.next();     // Catch: Exception -> L39 IOException -> L41
        if (r14 == null) goto L17;
        if (TextUtils.isEmpty(r14.getName()) == true) goto L17;
        if (TextUtils.isEmpty(r14.getValue()) == true) goto L17;
        r12.put(r14.getName(), r14.getValue());     // Catch: Exception -> L39 IOException -> L41
        goto L17
    L26:
        r9.setResponseHeaders(r12);     // Catch: Exception -> L39 IOException -> L41
    L28:
        if (r8.isSuccessful() == false) goto L31;
        r1 = ((TypedInput) r8.body()).in();     // Catch: Exception -> L39 IOException -> L41
        r9.setContentLength(((TypedInput) r8.body()).length());     // Catch: Exception -> L39 IOException -> L41
    L37:
        r9.setLogId(b(r8));     // Catch: Exception -> L39 IOException -> L41
    L43:
        ALogger.i("EffectPlatform", "request end: " + r9.getUrl());
        return r1;
    L31:
        if (r8.errorBody() == null) goto L35;
        InputStream r15 = r8.errorBody().in();     // Catch: Exception -> L39 IOException -> L41
        if (r15 == null) goto L35;
        String r16 = com.ss.ugc.effectplatform.extension.c.a(new InputStreamByteRead(r15));     // Catch: Exception -> L39 IOException -> L41
    L36:
        r9.setErrorMsg("statusCode:" + r8.code() + "errorMsg:" + r16);     // Catch: Exception -> L39 IOException -> L41
    L35:
        r16 = null;
        goto L36
    L12:
        r8 = r7.doGet(r4, Integer.MAX_VALUE, r6, r3).execute();     // Catch: Exception -> L39 IOException -> L41
    L41:
        e = move-exception;
        r9.setErrorMsg(e.getMessage());
    L39:
        e = move-exception;
        r9.setErrorMsg(e.getMessage());
        goto L43
    L57:
        return a(r9.getUrl(), r9.getHeaders());
    }

    @Override // com.bytedance.android.live.effect.utils.d
    public final InputStream a(String r8, Map<String, String> r9) {
        Intrinsics.checkNotNullParameter(r8, LiveSlardarConstants.EXTRA_KEY_URL);
        Intrinsics.checkNotNullParameter(r9, "headers");
        ArrayList r5 = new ArrayList();
        if (r9.size() <= 0) goto L28;
        Iterator<Map.Entry<String, String>> r11 = r9.entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L28;
        Map.Entry<String, String> r0 = r11.next();
        if (r0 == null) goto L6;
        r5.add(new NameValuePair(r0.getKey(), r0.getValue()));
    L28:
        boolean r2 = false;
        if (StringsKt.startsWith$default(r8, "https://webcast-open.douyin.com/", false, 2, null) == false) goto L14;
        boolean r1 = true;
    L15:
        boolean r3 = StringsKt.startsWith$default(r8, "https://effect.snssdk.com", false, 2, null);     // Catch: Throwable -> L25
        if (r1 == true) goto L20;
        if (r3 == true) goto L20;
        if (((Boolean) LiveConfigSettingKeys.USE_COMMON_PARAM_FOR_EFFECT_DOWNLOAD.getValue()).booleanValue() == true) goto L20;
    L21:
        LiveCall r12 = this.a.downloadFileStreaming(r2, Integer.MAX_VALUE, r8, r5, null);     // Catch: Throwable -> L25
        if (r12 == null) goto L27;
        return ((HttpResponse) r12.execute()).getStream();
    L27:
        return null;
    L20:
        r2 = true;
        goto L21
    L14:
        r1 = false;
    L25:
        th = move-exception;
        th.printStackTrace();
        goto L27
    }
}
