package a9;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.ttnet.TTNetInit;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static String a(String r8, HashMap r10, HashMap r11, a r12) {
        HttpURLConnection r13 = null;
        if (r5.f.b(r8) == false) goto L5;
        return null;
    L5:
        if (r5.e.e(TTNetInit.getTTNetDepend().getContext()) == true) goto L126;
        return null;
    L126:
    L12:
        th = th;
    L128:
        th.printStackTrace();     // Catch: Throwable -> L110
        throw th;     // Catch: Throwable -> L110
    L110:
        th = move-exception;
        if (r13 != null) goto L136;
    L113:
        throw th;
    L136:
        r13.disconnect();     // Catch: Exception -> L118
        goto L113
    L8:
        if (r12.f131c == false) goto L28;
        w6.e.a r14 = w6.e.f13022c;     // Catch: Throwable -> L12
        if (r14 == null) goto L14;
        String r15 = r14.addCommonParams(r8, true);     // Catch: Throwable -> L12
    L16:
        if (TextUtils.isEmpty(r15) == true) goto L28;
        if (r15.equals(r8) == false) goto L27;
        StringBuilder r16 = new StringBuilder(r15);     // Catch: Throwable -> L12
        if (r15.indexOf(63) >= 0) goto L22;
        String r17 = "?";
    L23:
        r16.append(r17);     // Catch: Throwable -> L12
        r16.append("aid=");     // Catch: Throwable -> L12
        r16.append(TTNetInit.getTTNetDepend().getAppId());     // Catch: Throwable -> L12
        r16.append("&device_platform=android");     // Catch: Throwable -> L12
        if (TTNetInit.getCronetProvider() == null) goto L26;
        r16.append("&version_code=");     // Catch: Throwable -> L12
        r16.append(TTNetInit.getCronetProvider().getVersionCode());     // Catch: Throwable -> L12
        r16.append("&channel=");     // Catch: Throwable -> L12
        r16.append(TTNetInit.getCronetProvider().getChannel());     // Catch: Throwable -> L12
        r16.append("device_id");     // Catch: Throwable -> L12
        r16.append(TTNetInit.getCronetProvider().getDeviceId());     // Catch: Throwable -> L12
    L26:
        r8 = r16.toString();     // Catch: Throwable -> L12
        goto L28
    L22:
        r17 = "&";
        goto L23
    L27:
        r8 = r15;
        goto L28
    L14:
        r15 = r8;
    L28:
        HttpURLConnection r18 = (HttpURLConnection) new URL(r8).openConnection();     // Catch: Throwable -> L12
        r18.setRequestMethod(HttpMethodContrants.GET);     // Catch: Throwable -> L106
        w6.e.d r19 = w6.e.f13020a;     // Catch: Throwable -> L106
        r18.setConnectTimeout(BWDLInnerConstant.DATA_LINK_TOUT);     // Catch: Throwable -> L106
        r18.setReadTimeout(BWDLInnerConstant.DATA_LINK_TOUT);     // Catch: Throwable -> L106
        r18.setInstanceFollowRedirects(true);     // Catch: Throwable -> L106
        r18.setRequestProperty("Accept-Encoding", "gzip");     // Catch: Throwable -> L106
        if (r12.f130b == false) goto L32;
        String r20 = " HttpsURLConnection";
    L33:
        r18.setRequestProperty("User-Agent", "ttnet".concat(r20));     // Catch: Throwable -> L106
        if (r10.size() <= 0) goto L39;
        Iterator r21 = r10.entrySet().iterator();     // Catch: Throwable -> L106
    L37:
        if (r21.hasNext() == false) goto L39;
        Map.Entry r22 = (Map.Entry) r21.next();     // Catch: Throwable -> L106
        r18.setRequestProperty((String) r22.getKey(), (String) r22.getValue());     // Catch: Throwable -> L106
    L39:
        int r23 = r18.getResponseCode();     // Catch: Throwable -> L106
        if (r11 == null) goto L52;
        if (r18.getHeaderFields() == null) goto L52;
        Map<String, List<String>> r24 = r18.getHeaderFields();     // Catch: Throwable -> L106
        if (r24 == null) goto L52;
        Iterator<Map.Entry<String, List<String>>> r25 = r24.entrySet().iterator();     // Catch: Throwable -> L106
    L47:
        if (r25.hasNext() == false) goto L52;
        Map.Entry<String, List<String>> r26 = r25.next();     // Catch: Throwable -> L106
        String r27 = r26.getKey();     // Catch: Throwable -> L106
        if (TextUtils.isEmpty(r27) == true) goto L47;
        r11.put(r27.toLowerCase(), r26.getValue());     // Catch: Throwable -> L106
    L52:
        if (r12.f130b == true) goto L54;
        r18.getHeaderField("X-SS-SIGN");     // Catch: Throwable -> L106
    L54:
        r12.f132d = r18.getHeaderField("x-ss-etag");     // Catch: Throwable -> L106
        r12.f133e = r18.getHeaderField("x-tt-tnc-abtest");     // Catch: Throwable -> L106
        if (r23 != 200) goto L105;
        InputStream r28 = r18.getInputStream();     // Catch: Throwable -> L106
        boolean r29 = "gzip".equals(r18.getHeaderField("Content-Encoding"));     // Catch: Throwable -> L106
        String r30 = r18.getHeaderField("Content-Type");     // Catch: Throwable -> L106
        boolean r110 = h7.c.d(r30);     // Catch: Throwable -> L106
        CopyOnWriteArrayList<Interceptor> r31 = e9.d.f7208a;     // Catch: Throwable -> L106
        if (r30 != null) goto L124;
        Pair r32 = null;
    L68:
        if (r32 == null) goto L74;
        Object r33 = r32.second;     // Catch: Throwable -> L106
        if (r33 == null) goto L74;
        if (Charset.isSupported((String) r33) == false) goto L74;
        String r34 = (String) r32.second;     // Catch: Throwable -> L106
    L75:
        if (r34 != null) goto L77;
        r34 = "UTF-8";
    L77:
        int[] r35 = {0};     // Catch: Throwable -> L106
        r18.getHeaderFields();     // Catch: Throwable -> L106
        d r36 = new d(r18);     // Catch: Throwable -> L106
        if (r28 != null) goto L130;
    L85:
        byte[] r37 = null;
    L86:
        if (r37 == null) goto L132;
        int r38 = r35[0];     // Catch: Throwable -> L106
        if (r38 <= 0) goto L132;
        if (r38 > r37.length) goto L132;
        if (r110 == false) goto L94;
        h7.c.a(r38, r37);     // Catch: Throwable -> L106
    L94:
        String r39 = new String(r37, 0, r35[0], r34);     // Catch: Throwable -> L106
        r18.disconnect();     // Catch: Exception -> L115
    L96:
        return r39;
    L132:
        r18.disconnect();     // Catch: Exception -> L116
    L98:
        return null;
    L130:
        r37 = h7.c.b(r29, -1, r28, r35, null);     // Catch: Exception -> L99 Throwable -> L106
        if (r37 == null) goto L85;
        if (r35[0] > 0) goto L86;
    L99:
        e = move-exception;
        HttpURLConnection r40 = r36.f134a;     // Catch: Throwable -> L117
        if (r40 == null) goto L103;
        r40.disconnect();     // Catch: Throwable -> L117
    L103:
        throw e;     // Catch: Throwable -> L106
    L74:
        r34 = null;
        goto L75
    L124:
        h7.a r41 = new h7.a(r30);     // Catch: Throwable -> L64
        String r42 = r41.a();     // Catch: Throwable -> L64
        String r43 = r41.b();     // Catch: Throwable -> L62
    L67:
        r32 = new Pair(r42, r43);     // Catch: Throwable -> L106
    L62:
        Throwable th = th;
    L66:
        th.printStackTrace();     // Catch: Throwable -> L106
        r43 = null;
    L64:
        th = move-exception;
        th = th;
        r42 = null;
        goto L66
    L105:
        throw new IOException("err status = " + r23);     // Catch: Throwable -> L106
    L32:
        r20 = " HttpURLConnection";
    L106:
        th = th;
        r13 = r18;
        goto L128
    }
}
