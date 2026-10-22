package com.bytedance.ttnet.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.h;
import com.bytedance.crash.service.INetworkCallback;
import com.bytedance.frameworks.baselib.network.http.f;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.bytedance.rpc.internal.RpcUtils;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static String a(final String r11, Map<String, String> r12, Map<String, List<String>> r13, a r14) {
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        HttpURLConnection r3 = null;
        if (h.a(r11) == true) goto L92;
        if (r14 == null) goto L92;
        if (NetworkUtils.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L98;
        return null;
    L98:
    L85:
        th = th;
    L102:
        th.printStackTrace();     // Catch: Throwable -> L88
        throw th;     // Catch: Throwable -> L88
    L88:
        th = move-exception;
        if (r3 != null) goto L100;
    L91:
        throw th;
    L100:
        r3.disconnect();     // Catch: Exception -> L95
        goto L91
    L10:
        if (r14.g == false) goto L25;
        String r1 = f.a(r11, true, null);     // Catch: Throwable -> L85
        if (TextUtils.isEmpty(r1) == true) goto L25;
        if (r1.equals(r11) == false) goto L24;
        StringBuilder r17 = new StringBuilder(r1);     // Catch: Throwable -> L85
        if (r1.indexOf(63) >= 0) goto L19;
        String r2 = "?";
    L18:
        r17.append(r2);     // Catch: Throwable -> L85
        r17.append("aid=").append(TTNetInit.getTTNetDepend().h()).append("&device_platform=").append("android");     // Catch: Throwable -> L85
        if (TTNetInit.getCronetProvider() == null) goto L23;
        r17.append("&version_code=").append(TTNetInit.getCronetProvider().getVersionCode()).append("&channel=").append(TTNetInit.getCronetProvider().getChannel()).append("device_id").append(TTNetInit.getCronetProvider().getDeviceId());     // Catch: Throwable -> L85
    L23:
        r11 = r17.toString();     // Catch: Throwable -> L85
        goto L25
    L19:
        r2 = "&";
        goto L18
    L24:
        r11 = r1;
    L25:
        final HttpURLConnection r4 = (HttpURLConnection) ZeusTransformUtils.preCheckCast(new URL(r11).openConnection(), HttpURLConnection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L85
        r4.setRequestMethod(HttpMethodContrants.GET);     // Catch: Throwable -> L83
        r4.setConnectTimeout(f.a());     // Catch: Throwable -> L83
        r4.setReadTimeout(f.b());     // Catch: Throwable -> L83
        r4.setInstanceFollowRedirects(true);     // Catch: Throwable -> L83
        r4.setRequestProperty(NetConst.KEY_ACCEPT_ENCODING, NetConst.GZIP);     // Catch: Throwable -> L83
        if (r14.f == false) goto L29;
        String r5 = " HttpsURLConnection";
    L30:
        r4.setRequestProperty("User-Agent", INetworkCallback.TYPE_TTNET + r5);     // Catch: Throwable -> L83
        if (r15 != null) goto L33;
    L38:
        int r18 = r4.getResponseCode();     // Catch: Throwable -> L83
        r14.f3204a = r18;     // Catch: Throwable -> L83
        if (r16 == null) goto L51;
        if (r4.getHeaderFields() == null) goto L51;
        Map<String, List<String>> r6 = r4.getHeaderFields();     // Catch: Throwable -> L83
        if (r6 == null) goto L51;
        Iterator<Map.Entry<String, List<String>>> r7 = r6.entrySet().iterator();     // Catch: Throwable -> L83
    L46:
        if (r7.hasNext() == false) goto L51;
        Map.Entry r8 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L83
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L83
        if (TextUtils.isEmpty(r9) == true) goto L46;
        r16.put(r9.toLowerCase(), (List) ZeusTransformUtils.preCheckCast(r8.getValue(), List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L83
    L51:
        if (r14.f == true) goto L53;
        r14.e = r4.getHeaderField("X-SS-SIGN");     // Catch: Throwable -> L83
    L53:
        r14.h = r4.getHeaderField("x-ss-etag");     // Catch: Throwable -> L83
        r14.i = r4.getHeaderField("x-tt-tnc-abtest");     // Catch: Throwable -> L83
        r14.l = r4.getHeaderField("x-tt-tnc-control");     // Catch: Throwable -> L83
        r14.m = r4.getHeaderField("x-tt-tnc-config");     // Catch: Throwable -> L83
        r14.n = r4.getHeaderField("x-ss-canary");     // Catch: Throwable -> L83
        r14.j = r4.getHeaderField("x-tt-tnc-query-region");     // Catch: Throwable -> L83
        r14.k = r4.getHeaderField("x-tt-logid");     // Catch: Throwable -> L83
        if (r18 != 200) goto L82;
        InputStream r10 = r4.getInputStream();     // Catch: Throwable -> L83
        boolean r19 = NetConst.GZIP.equals(r4.getHeaderField(NetConst.KEY_CONTENT_ENCODING));     // Catch: Throwable -> L83
        String r110 = r4.getHeaderField(NetConst.KEY_CONTENT_TYPE);     // Catch: Throwable -> L83
        boolean r111 = com.bytedance.frameworks.baselib.network.http.parser.d.a(r110);     // Catch: Throwable -> L83
        Pair<String, String> r112 = RetrofitUtils.a(r110);     // Catch: Throwable -> L83
        if (r112 != null) goto L58;
    L62:
        String r113 = null;
    L63:
        if (r113 != null) goto L65;
        r113 = RpcUtils.CHARSET_UTF8;
    L65:
        int[] r114 = {0};     // Catch: Throwable -> L83
        byte[] r115 = com.bytedance.frameworks.baselib.network.http.parser.d.a(r19, r4.getHeaderFields(), -1, r10, r114, new AnonymousClass1(r11, r4));     // Catch: Throwable -> L83
        if (r115 != null) goto L68;
    L78:
        if (r4 != null) goto L104;
    L80:
        return null;
    L104:
        r4.disconnect();     // Catch: Exception -> L94
        goto L80
    L68:
        if (r114[0] <= 0) goto L78;
        if (r114[0] > r115.length) goto L78;
        if (r111 == false) goto L74;
        com.bytedance.frameworks.baselib.network.http.parser.d.a(r115, r114[0]);     // Catch: Throwable -> L83
    L74:
        String r116 = new String(r115, 0, r114[0], r113);     // Catch: Throwable -> L83
        if (r4 != null) goto L96;
    L77:
        return r116;
    L96:
        r4.disconnect();     // Catch: Exception -> L93
        goto L77
    L58:
        if (r112.second == null) goto L62;
        if (Charset.isSupported((String) ZeusTransformUtils.preCheckCast(r112.second, String.class, "com.obric.memorydata.plugin")) == false) goto L62;
        r113 = (String) ZeusTransformUtils.preCheckCast(r112.second, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L83
        goto L63
    L82:
        throw new IOException("err status = " + r18);     // Catch: Throwable -> L83
    L33:
        if (r15.size() <= 0) goto L38;
        Iterator r117 = r15.entrySet().iterator();     // Catch: Throwable -> L83
    L36:
        if (r117.hasNext() == false) goto L38;
        Map.Entry r20 = (Map.Entry) ZeusTransformUtils.preCheckCast(r117.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L83
        r4.setRequestProperty((String) ZeusTransformUtils.preCheckCast(r20.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r20.getValue(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L83
        goto L36
    L29:
        r5 = " HttpURLConnection";
    L83:
        th = th;
        r3 = r4;
    L92:
        return null;
    }
}
