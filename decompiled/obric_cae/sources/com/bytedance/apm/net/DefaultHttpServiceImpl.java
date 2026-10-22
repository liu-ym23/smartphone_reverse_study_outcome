package com.bytedance.apm.net;

import android.text.TextUtils;
import com.bytedance.services.apm.api.IHttpService;
import g3.c;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import l6.a;
import u8.b;
import u8.e;

/* JADX INFO: loaded from: classes.dex */
public class DefaultHttpServiceImpl implements IHttpService {
    private static String METHOD_GET = "GET";
    private static String METHOD_POST = "POST";

    public DefaultHttpServiceImpl() {
    }

    private b doRequest(String r8, byte[] r10, String r11, Map<String, String> r12) {
        if (r11 == null) goto L70;
        HttpURLConnection r13 = (HttpURLConnection) new URL(r8).openConnection();     // Catch: Throwable -> L55
        r13.setConnectTimeout(5000);     // Catch: Throwable -> L53
        r13.setReadTimeout(5000);     // Catch: Throwable -> L53
        if (r12 == null) goto L18;
        if (r12.isEmpty() == true) goto L18;
        Iterator<Map.Entry<String, String>> r14 = r12.entrySet().iterator();     // Catch: Throwable -> L53
    L12:
        if (r14.hasNext() == false) goto L18;
        Map.Entry<String, String> r15 = r14.next();     // Catch: Throwable -> L53
        if (r15 == null) goto L12;
        r13.setRequestProperty(r15.getKey(), r15.getValue());     // Catch: Throwable -> L53
    L18:
        if (TextUtils.equals(r11, METHOD_POST) == false) goto L20;
        r13.setDoOutput(true);     // Catch: Throwable -> L53
    L21:
        r13.setRequestMethod(r11);     // Catch: Throwable -> L53
        if (r10 != null) goto L24;
    L26:
        int r16 = r13.getResponseCode();     // Catch: Throwable -> L53
        if (r16 != 200) goto L50;
        InputStream r17 = r13.getInputStream();     // Catch: Throwable -> L53
        String r18 = r13.getContentEncoding();     // Catch: Throwable -> L48
        if (TextUtils.isEmpty(r18) == false) goto L32;
    L34:
        byte[] r19 = toByteArray(r17);     // Catch: Throwable -> L48
    L35:
        Map<String, List<String>> r110 = r13.getHeaderFields();     // Catch: Throwable -> L48
        HashMap r20 = new HashMap();     // Catch: Throwable -> L48
        Iterator<String> r21 = r110.keySet().iterator();     // Catch: Throwable -> L48
    L37:
        if (r21.hasNext() == false) goto L43;
        String r22 = r21.next();     // Catch: Throwable -> L48
        List<String> r23 = r110.get(r22);     // Catch: Throwable -> L48
        if (r23 == null) goto L37;
        if (a.e0(r23) == true) goto L37;
        r20.put(r22, r23.get(0));     // Catch: Throwable -> L48
        goto L37
    L43:
        b r111 = new b(r16, r20, r19);     // Catch: Throwable -> L48
        if (r17 != null) goto L86;
    L84:
        r13.disconnect();     // Catch: Exception -> L72
    L47:
        return r111;
    L86:
        r17.close();     // Catch: Exception -> L71
        goto L84
    L32:
        if (r18.equalsIgnoreCase("gzip") == false) goto L34;
        GZIPInputStream r112 = new GZIPInputStream(r17);     // Catch: Throwable -> L48
        r19 = toByteArray(r112);     // Catch: Throwable -> L48
        r112.close();     // Catch: Throwable -> L48
    L48:
        Throwable th = th;
    L90:
        th.getMessage();     // Catch: Throwable -> L63
        a.R(th);     // Catch: Throwable -> L63
        if (r17 != null) goto L82;
    L60:
        if (r13 != null) goto L95;
    L62:
        return null;
    L95:
        r13.disconnect();     // Catch: Exception -> L74
        goto L62
    L82:
        r17.close();     // Catch: Exception -> L73
    L63:
        th = move-exception;
        if (r17 != null) goto L88;
    L66:
        if (r13 == null) goto L112;
        r13.disconnect();     // Catch: Exception -> L76
        throw th;
    L113:
        throw th;
    L112:
        throw th;
    L88:
        r17.close();     // Catch: Exception -> L75
        goto L66
    L50:
        b r113 = new b(r16, null);     // Catch: Throwable -> L53
        r13.disconnect();     // Catch: Exception -> L77
    L52:
        return r113;
    L24:
        if (r10.length <= 0) goto L26;
        DataOutputStream r114 = new DataOutputStream(r13.getOutputStream());     // Catch: Throwable -> L53
        r114.write(r10);     // Catch: Throwable -> L53
        r114.flush();     // Catch: Throwable -> L53
        r114.close();     // Catch: Throwable -> L53
        goto L26
    L20:
        r13.setDoOutput(false);     // Catch: Throwable -> L53
    L53:
        th = th;
        r17 = null;
    L55:
        th = move-exception;
        th = th;
        r13 = null;
        r17 = null;
        goto L90
    L70:
        throw new IllegalArgumentException("request method is not null");
    }

    public static byte[] toByteArray(InputStream r8) {
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();
        byte[] r11 = new byte[8192];
    L3:
        int r12 = r8.read(r11);
        if ((-1) == r12) goto L6;
        r10.write(r11, 0, r12);
        goto L3
    L6:
        r8.close();
        return r10.toByteArray();
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public e buildMultipartUpload(String r8, String r10, boolean r11) {
        return new w2.a(r8, r10, r11, null);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public b doGet(String r8, Map<String, String> r10) {
        return doRequest(r8, null, METHOD_GET, r10);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public b doPost(String r8, byte[] r10, Map<String, String> r11) {
        return doRequest(r8, r10, METHOD_POST, r11);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public b uploadFiles(String r8, List<File> r10, Map<String, String> r11) {
        return c.a(r8, r10, r11);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public e buildMultipartUpload(String r8, String r10, boolean r11, Map<String, String> r12) {
        return new w2.a(r8, r10, r11, r12);
    }
}
