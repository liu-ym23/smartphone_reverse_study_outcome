package com.bytedance.apm.net;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.apm.util.g;
import com.bytedance.services.apm.api.IHttpService;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import oj.b;
import td.e;
import wn.f;
import ym.a;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultHttpServiceImpl implements IHttpService {
    private static String METHOD_GET = "GET";
    private static String METHOD_POST = "POST";

    public DefaultHttpServiceImpl() {
    }

    private b doRequest(String r10, byte[] r11, String r12, Map<String, String> r13) throws Exception {
        if (r12 == null) goto L70;
        HttpURLConnection r14 = g.a(r10);     // Catch: Throwable -> L55
        r14.setConnectTimeout(5000);     // Catch: Throwable -> L17
        r14.setReadTimeout(5000);     // Catch: Throwable -> L17
        if (r13 == null) goto L20;
        if (r13.isEmpty() == true) goto L20;
        Iterator<Map.Entry<String, String>> r15 = r13.entrySet().iterator();     // Catch: Throwable -> L17
    L12:
        if (r15.hasNext() == false) goto L20;
        Map.Entry<String, String> r5 = r15.next();     // Catch: Throwable -> L17
        if (r5 == null) goto L12;
        r14.setRequestProperty(r5.getKey(), r5.getValue());     // Catch: Throwable -> L17
    L20:
        if (TextUtils.equals(r12, METHOD_POST) == false) goto L22;
        r14.setDoOutput(true);     // Catch: Throwable -> L17
    L23:
        r14.setRequestMethod(r12);     // Catch: Throwable -> L17
        if (r11 != null) goto L26;
    L28:
        int r16 = r14.getResponseCode();     // Catch: Throwable -> L17
        if (r16 != 200) goto L52;
        InputStream r17 = r14.getInputStream();     // Catch: Throwable -> L17
        String r18 = r14.getContentEncoding();     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r18) == false) goto L34;
    L38:
        byte[] r19 = toByteArray(r17);     // Catch: Throwable -> L36
    L39:
        Map<String, List<String>> r110 = r14.getHeaderFields();     // Catch: Throwable -> L36
        HashMap r20 = new HashMap();     // Catch: Throwable -> L36
        Iterator<String> r21 = r110.keySet().iterator();     // Catch: Throwable -> L36
    L41:
        if (r21.hasNext() == false) goto L47;
        String r22 = r21.next();     // Catch: Throwable -> L36
        List<String> r23 = r110.get(r22);     // Catch: Throwable -> L36
        if (r23 == null) goto L41;
        if (f.j(r23) == true) goto L41;
        r20.put(r22, r23.get(0));     // Catch: Throwable -> L36
        goto L41
    L47:
        b r111 = new b(r16, r20, r19);     // Catch: Throwable -> L36
        if (r17 != null) goto L82;
    L78:
        r14.disconnect();     // Catch: Exception -> L72
    L51:
        return r111;
    L82:
        r17.close();     // Catch: Exception -> L71
        goto L78
    L34:
        if (r18.equalsIgnoreCase("gzip") == false) goto L38;
        GZIPInputStream r112 = new GZIPInputStream(r17);     // Catch: Throwable -> L36
        r19 = toByteArray(r112);     // Catch: Throwable -> L36
        r112.close();     // Catch: Throwable -> L36
    L36:
        th = th;
    L96:
        th.getMessage();     // Catch: Throwable -> L63
        a.g(10, th);     // Catch: Throwable -> L63
        if (r17 != null) goto L86;
    L60:
        if (r14 != null) goto L80;
    L62:
        return null;
    L80:
        r14.disconnect();     // Catch: Exception -> L74
        goto L62
    L86:
        r17.close();     // Catch: Exception -> L73
    L63:
        th = move-exception;
        if (r17 != null) goto L94;
    L66:
        if (r14 == null) goto L112;
        r14.disconnect();     // Catch: Exception -> L76
        throw th;
    L113:
        throw th;
    L112:
        throw th;
    L94:
        r17.close();     // Catch: Exception -> L75
        goto L66
    L52:
        b r113 = new b(r16, null);     // Catch: Throwable -> L17
        r14.disconnect();     // Catch: Exception -> L77
    L54:
        return r113;
    L26:
        if (r11.length <= 0) goto L28;
        DataOutputStream r114 = new DataOutputStream(r14.getOutputStream());     // Catch: Throwable -> L17
        r114.write(r11);     // Catch: Throwable -> L17
        r114.flush();     // Catch: Throwable -> L17
        r114.close();     // Catch: Throwable -> L17
        goto L28
    L22:
        r14.setDoOutput(false);     // Catch: Throwable -> L17
    L17:
        th = th;
        r17 = null;
    L55:
        th = th;
        r14 = null;
        r17 = null;
        goto L96
    L70:
        throw new IllegalArgumentException("request method is not null");
    }

    public static byte[] toByteArray(InputStream r5) throws IOException {
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();
        byte[] r11 = new byte[8192];
    L3:
        int r12 = r5.read(r11);
        if ((-1) == r12) goto L6;
        r10.write(r11, 0, r12);
        goto L3
    L6:
        r5.close();
        return r10.toByteArray();
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public oj.f buildMultipartUpload(String r5, String r10, boolean r11) throws IOException {
        return new nh.b(r5, r10, r11, null);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public b doGet(String r5, Map<String, String> r10) throws Exception {
        return doRequest(r5, null, METHOD_GET, r10);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public b doPost(String r5, byte[] r10, Map<String, String> r11) throws Exception {
        return doRequest(r5, r10, METHOD_POST, r11);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    @Nullable
    public b uploadFiles(String r5, List<File> r10, Map<String, String> r11) throws Exception {
        return e.o(r5, r10, r11);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public oj.f buildMultipartUpload(String r5, String r10, boolean r11, Map<String, String> r12) throws Exception {
        return new nh.b(r5, r10, r11, r12);
    }
}
