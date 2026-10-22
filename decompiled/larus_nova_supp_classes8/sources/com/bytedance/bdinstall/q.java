package com.bytedance.bdinstall;

import android.text.TextUtils;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import com.obric.assistant.network.okhttp.a;
import i84.j;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q {
    public static final String[] a = null;

    public q() {
    }

    static {
        a = new String[]{"GET", "POST"};
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection a(URL r7) throws IOException {
        String r3 = r7.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r4 = r7.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (a.c(r3, r4) == false) goto L11;
        FLogger.a.i("UrlConnLancet", "openConnection drop host=" + r3 + " path=" + r4);     // Catch: Throwable -> L8 IOException -> L12
        a.b(GlobalNetworkGate.a(r3, r4), r3, r4);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r7);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r7.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    public static d84.a b(int r7, String r8, HashMap<String, String> r9, byte[] r10) throws RangersHttpException {
        int r2 = t.a;
        d84.a r3 = null;
        BufferedReader r4 = null;
        r3 = null;
        r3 = null;
        HttpURLConnection r5 = (HttpURLConnection) a(new URL(r8));     // Catch: Throwable -> L59
        if (r7 != 0) goto L7;
        r5.setDoOutput(false);     // Catch: Throwable -> L59
    L10:
        r5.setRequestMethod(a[r7]);     // Catch: Throwable -> L59
        if (r9 != null) goto L13;
    L23:
        r5.setRequestProperty("Accept-Encoding", "gzip");     // Catch: Throwable -> L59
        if (r10 != null) goto L26;
    L29:
        DataOutputStream r11 = null;
    L30:
        int r12 = r5.getResponseCode();     // Catch: Throwable -> L57
        if (r12 != 200) goto L56;
        if (r5.getContentLength() >= 10240) goto L46;
        InputStream r6 = r5.getInputStream();     // Catch: Throwable -> L57
        if ("gzip".equalsIgnoreCase(r5.getContentEncoding()) == false) goto L37;
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new GZIPInputStream(r6)));     // Catch: Throwable -> L57
    L95:
        StringBuilder r13 = new StringBuilder(r6.available());     // Catch: Throwable -> L44
    L39:
        String r14 = r1.readLine();     // Catch: Throwable -> L44
        if (r14 == null) goto L42;
        r13.append(r14);     // Catch: Throwable -> L44
        r13.append("\n");     // Catch: Throwable -> L44
        goto L39
    L42:
        JSONObject r15 = new JSONObject(r13.toString());     // Catch: Throwable -> L44
        r15.put("HttpCode", 200);     // Catch: Throwable -> L44
        r15.put("Set-Cookie", r5.getHeaderField("Set-Cookie"));     // Catch: Throwable -> L44
        d84.a r16 = new d84.a(r8, r12, j.b(r5.getHeaderFields()), r15.toString());     // Catch: Throwable -> L44
        r4 = r1;
    L48:
        if (r11 != null) goto L93;
    L52:
        if (r4 != null) goto L86;
    L54:
        r3 = r16;
    L69:
        int r17 = t.a;
        return r3;
    L86:
        r4.close();     // Catch: IOException -> L81
        goto L54
    L93:
        r11.close();     // Catch: IOException -> L51
    L44:
        Throwable th = th;
    L90:
        t.e(th);     // Catch: Throwable -> L73
        if ((th instanceof RangersHttpException) == true) goto L72;
        if (r11 != null) goto L84;
    L67:
        if (r1 == null) goto L69;
        r1.close();     // Catch: IOException -> L82
        goto L69
    L84:
        r11.close();     // Catch: IOException -> L66
        goto L67
    L72:
        throw ((RangersHttpException) th);     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        if (r11 != null) goto L101;
    L78:
        if (r1 == null) goto L111;
        r1.close();     // Catch: IOException -> L83
        throw th;
    L112:
        throw th;
    L111:
        throw th;
    L101:
        r11.close();     // Catch: IOException -> L77
        goto L78
    L37:
        r1 = new BufferedReader(new InputStreamReader(r6));     // Catch: Throwable -> L57
        goto L95
    L46:
        t.e(null);     // Catch: Throwable -> L57
        r16 = null;
        goto L48
    L56:
        throw new RangersHttpException(r12, r5.getResponseMessage());     // Catch: Throwable -> L57
    L26:
        if (r10.length <= 0) goto L29;
        r11 = new DataOutputStream(r5.getOutputStream());     // Catch: Throwable -> L59
        r11.write(r10);     // Catch: Throwable -> L57
        r11.flush();     // Catch: Throwable -> L57
        r11.close();     // Catch: Throwable -> L57
    L57:
        th = th;
        r1 = null;
        goto L90
    L13:
        if (r9.isEmpty() == true) goto L23;
        Iterator<Map.Entry<String, String>> r18 = r9.entrySet().iterator();     // Catch: Throwable -> L59
    L16:
        if (r18.hasNext() == false) goto L23;
        Map.Entry<String, String> r19 = r18.next();     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r19.getKey()) == true) goto L22;
        if (TextUtils.isEmpty(r19.getValue()) == true) goto L22;
        r5.addRequestProperty(r19.getKey(), r19.getValue());     // Catch: Throwable -> L59
    L22:
        t.e(null);     // Catch: Throwable -> L59
        goto L16
    L7:
        if (r7 != 1) goto L9;
        r5.setDoOutput(true);     // Catch: Throwable -> L59
        goto L10
    L9:
        t.e(null);     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        th = th;
        r11 = null;
        r1 = null;
        goto L90
    }
}
