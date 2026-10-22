package com.bytedance.apm.net;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.apm.util.e;
import com.bytedance.apm.util.j;
import com.bytedance.apm.util.m;
import com.bytedance.apm.util.u;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.services.apm.api.IHttpService;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import t4.c;
import t4.g;

/* JADX INFO: loaded from: classes.dex */
public class DefaultHttpServiceImpl implements IHttpService {
    private static String METHOD_GET = "GET";
    private static String METHOD_POST = "POST";

    static {
    }

    public DefaultHttpServiceImpl() {
    }

    private c doRequest(String r10, byte[] r11, String r12, Map<String, String> r13) {
        if (r12 == null) goto L70;
        HttpURLConnection r14 = m.a(r10);     // Catch: Throwable -> L55
        r14.setConnectTimeout(5000);     // Catch: Throwable -> L53
        r14.setReadTimeout(5000);     // Catch: Throwable -> L53
        if (r13 == null) goto L18;
        if (r13.isEmpty() == true) goto L18;
        Iterator<Map.Entry<String, String>> r15 = r13.entrySet().iterator();     // Catch: Throwable -> L53
    L12:
        if (r15.hasNext() == false) goto L18;
        Map.Entry<String, String> r16 = r15.next();     // Catch: Throwable -> L53
        if (r16 == null) goto L12;
        r14.setRequestProperty(r16.getKey(), r16.getValue());     // Catch: Throwable -> L53
    L18:
        if (TextUtils.equals(r12, METHOD_POST) == false) goto L20;
        r14.setDoOutput(true);     // Catch: Throwable -> L53
    L21:
        r14.setRequestMethod(r12);     // Catch: Throwable -> L53
        if (r11 != null) goto L24;
    L26:
        int r17 = r14.getResponseCode();     // Catch: Throwable -> L53
        if (r17 != 200) goto L50;
        InputStream r18 = r14.getInputStream();     // Catch: Throwable -> L53
        String r19 = r14.getContentEncoding();     // Catch: Throwable -> L48
        if (TextUtils.isEmpty(r19) == false) goto L32;
    L34:
        byte[] r20 = toByteArray(r18);     // Catch: Throwable -> L48
    L35:
        Map<String, List<String>> r110 = r14.getHeaderFields();     // Catch: Throwable -> L48
        HashMap r21 = new HashMap();     // Catch: Throwable -> L48
        Iterator<String> r22 = r110.keySet().iterator();     // Catch: Throwable -> L48
    L37:
        if (r22.hasNext() == false) goto L43;
        String r23 = r22.next();     // Catch: Throwable -> L48
        List<String> r24 = r110.get(r23);     // Catch: Throwable -> L48
        if (r24 == null) goto L37;
        if (j.b(r24) == true) goto L37;
        r21.put(r23, r24.get(0));     // Catch: Throwable -> L48
        goto L37
    L43:
        c r111 = new c(r17, r21, r20);     // Catch: Throwable -> L48
        if (r18 != null) goto L91;
    L85:
        r14.disconnect();     // Catch: Exception -> L72
    L47:
        return r111;
    L91:
        r18.close();     // Catch: Exception -> L71
        goto L85
    L32:
        if (r19.equalsIgnoreCase(NetConst.GZIP) == false) goto L34;
        GZIPInputStream r112 = new GZIPInputStream(r18);     // Catch: Throwable -> L48
        r20 = toByteArray(r112);     // Catch: Throwable -> L48
        r112.close();     // Catch: Throwable -> L48
    L48:
        th = th;
    L97:
        e0.a.d("apm_debug", "http request msg: " + th.getMessage() + " ,stack: " + u.b(th, 10));     // Catch: Throwable -> L63
        if (r18 != null) goto L87;
    L60:
        if (r14 != null) goto L78;
    L62:
        return null;
    L78:
        r14.disconnect();     // Catch: Exception -> L74
        goto L62
    L87:
        r18.close();     // Catch: Exception -> L73
    L63:
        th = move-exception;
        if (r18 != null) goto L95;
    L66:
        if (r14 == null) goto L112;
        r14.disconnect();     // Catch: Exception -> L76
        throw th;
    L113:
        throw th;
    L112:
        throw th;
    L95:
        r18.close();     // Catch: Exception -> L75
        goto L66
    L50:
        c r113 = new c(r17, null);     // Catch: Throwable -> L53
        r14.disconnect();     // Catch: Exception -> L77
    L52:
        return r113;
    L24:
        if (r11.length <= 0) goto L26;
        DataOutputStream r114 = new DataOutputStream(r14.getOutputStream());     // Catch: Throwable -> L53
        r114.write(r11);     // Catch: Throwable -> L53
        r114.flush();     // Catch: Throwable -> L53
        r114.close();     // Catch: Throwable -> L53
        goto L26
    L20:
        r14.setDoOutput(false);     // Catch: Throwable -> L53
    L53:
        th = th;
        r18 = null;
    L55:
        th = th;
        r14 = null;
        r18 = null;
        goto L97
    L70:
        throw new IllegalArgumentException("request method is not null");
    }

    public static byte[] toByteArray(InputStream r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        byte[] r12 = new byte[8192];
    L3:
        int r13 = r10.read(r12);
        if ((-1) == r13) goto L6;
        r11.write(r12, 0, r13);
        goto L3
    L6:
        r10.close();
        return r11.toByteArray();
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public g buildMultipartUpload(String r10, String r11, boolean r12) {
        return new a(r10, r11, r12, null);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public g buildMultipartUpload(String r10, String r11, boolean r12, Map<String, String> r13) {
        return new a(r10, r11, r12, r13);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public c doGet(String r10, Map<String, String> r11) {
        return doRequest(r10, null, METHOD_GET, r11);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public c doPost(String r10, byte[] r11, Map<String, String> r12) {
        return doRequest(r10, r11, METHOD_POST, r12);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    @Nullable
    public c uploadFiles(String r10, List<File> r11, Map<String, String> r12) {
        return e.a(r10, r11, r12);
    }
}
