package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static com.bytedance.services.apm.api.c a(String r7, byte[] r8, String r9, String r10, String r11, boolean r12, boolean r13) {
        InputStream r2 = null;
        LinkedList r3 = new LinkedList();     // Catch: Throwable -> L78
        if (r13 == false) goto L6;
        URL r4 = new URL(com.bytedance.frameworks.core.encrypt.a.a(r7, r3));     // Catch: Throwable -> L78
    L7:
        HttpURLConnection r14 = (HttpURLConnection) ZeusTransformUtils.preCheckCast(r4.openConnection(), HttpURLConnection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L78
        if (r13 == false) goto L19;
    L76:
        th = th;
    L77:
        Throwable r6 = th;
        HttpURLConnection r15 = r14;
        th = r6;
    L88:
        throw th;     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        IOUtils.closeQuietly(r2);
        if (r15 != null) goto L90;
    L85:
        throw th;
    L90:
        r15.disconnect();     // Catch: Exception -> L87
        goto L85
    L10:
        if (r3.isEmpty() == true) goto L19;
        Iterator r16 = r3.iterator();     // Catch: Throwable -> L76
    L13:
        if (r16.hasNext() == false) goto L19;
        Pair r5 = (Pair) ZeusTransformUtils.preCheckCast(r16.next(), Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L76
        if (r5 == null) goto L13;
        r14.setRequestProperty((String) ZeusTransformUtils.preCheckCast(r5.first, String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r5.second, String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L76
    L19:
        if (r12 == false) goto L21;
        r14.setDoOutput(true);     // Catch: Throwable -> L76
    L22:
        if (r9 == null) goto L24;
        r14.setRequestProperty(NetConst.KEY_CONTENT_TYPE, r9);     // Catch: Throwable -> L76
    L24:
        if (r10 == null) goto L26;
        r14.setRequestProperty(NetConst.KEY_CONTENT_ENCODING, r10);     // Catch: Throwable -> L76
    L26:
        r14.setRequestProperty(NetConst.KEY_ACCEPT_ENCODING, NetConst.GZIP);     // Catch: Throwable -> L76
        if (r11 == null) goto L75;
        r14.setRequestMethod(r11);     // Catch: Throwable -> L76
        if (r8 != null) goto L31;
    L41:
        int r17 = r14.getResponseCode();     // Catch: Throwable -> L76
        if (r17 != 200) goto L73;
        InputStream r18 = r14.getInputStream();     // Catch: Throwable -> L76
        String r19 = r14.getContentEncoding();     // Catch: Throwable -> L70
        if (TextUtils.isEmpty(r19) == false) goto L47;
    L56:
        byte[] r110 = a(r18);     // Catch: Throwable -> L70
    L57:
        Map<String, List<String>> r111 = r14.getHeaderFields();     // Catch: Throwable -> L70
        HashMap r112 = new HashMap();     // Catch: Throwable -> L70
        Iterator<String> r0 = r111.keySet().iterator();     // Catch: Throwable -> L70
    L59:
        if (r0.hasNext() == false) goto L65;
        String r20 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        List r21 = (List) ZeusTransformUtils.preCheckCast(r111.get(r20), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        if (r21 == null) goto L59;
        if (com.bytedance.framwork.core.sdklib.b.c.a(r21) == true) goto L59;
        r112.put(r20, r21.get(0));     // Catch: Throwable -> L70
        goto L59
    L65:
        com.bytedance.services.apm.api.c r113 = new com.bytedance.services.apm.api.c(r17, r112, r110);     // Catch: Throwable -> L70
        IOUtils.closeQuietly(r18);
        if (r14 != null) goto L96;
    L69:
        return r113;
    L96:
        r14.disconnect();     // Catch: Exception -> L86
        goto L69
    L47:
        if (r19.equalsIgnoreCase(NetConst.GZIP) == false) goto L56;
        GZIPInputStream r114 = new GZIPInputStream(r18);     // Catch: Throwable -> L53
        r110 = a(r114);     // Catch: Throwable -> L51
        IOUtils.closeQuietly(r114);     // Catch: Throwable -> L70
    L51:
        th = th;
        r2 = r114;
    L54:
        IOUtils.closeQuietly(r2);     // Catch: Throwable -> L70
        throw th;     // Catch: Throwable -> L70
    L53:
        th = th;
    L70:
        th = th;
        r2 = r18;
        goto L77
    L73:
        throw new HttpResponseException(r17, r14.getResponseMessage());     // Catch: Throwable -> L76
    L31:
        if (r8.length <= 0) goto L41;
        DataOutputStream r22 = new DataOutputStream(r14.getOutputStream());     // Catch: Throwable -> L37
        r22.write(r8);     // Catch: Throwable -> L35
        r22.flush();     // Catch: Throwable -> L35
        IOUtils.closeQuietly(r22);     // Catch: Throwable -> L76
    L35:
        th = th;
    L39:
        IOUtils.closeQuietly(r22);     // Catch: Throwable -> L76
        throw th;     // Catch: Throwable -> L76
    L37:
        th = th;
        r22 = null;
        goto L39
    L75:
        throw new IllegalArgumentException("request method is not null");     // Catch: Throwable -> L76
    L21:
        r14.setDoOutput(false);     // Catch: Throwable -> L76
        goto L22
    L6:
        r4 = new URL(r7);     // Catch: Throwable -> L78
    L78:
        th = th;
        r15 = null;
        goto L88
    }

    public static boolean a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L14;
        return false;
    L14:
        NetworkInfo r5 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(r4.getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin")).getActiveNetworkInfo();     // Catch: Exception -> L11
        if (r5 == null) goto L16;
        if (r5.isConnected() == false) goto L17;
        return true;
    L17:
        return false;
    L16:
        return false;
    L11:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static byte[] a(InputStream r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[8192];
    L3:
        int r3 = r4.read(r1);
        if ((-1) == r3) goto L6;
        r0.write(r1, 0, r3);
        goto L3
    L6:
        if (r4 == null) goto L9;
        r4.close();
    L9:
        return r0.toByteArray();
    }

    public static byte[] a(String r7, String r8, boolean r9) {
        if (TextUtils.isDigitsOnly(r7) == false) goto L7;
        return null;
    L7:
        return a(r7, null, r8, null, HttpMethodContrants.GET, false, r9).b();
    }

    public static byte[] a(byte[] r2, Map<String, String> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (r2.length <= 128) goto L13;
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r1 = new GZIPOutputStream(r0);
        r1.write(r2);     // Catch: Throwable -> L7 IOException -> L9
        r1.close();
        byte[] r5 = r0.toByteArray();
        r4.put(NetConst.KEY_CONTENT_ENCODING, NetConst.GZIP);
        return r5;
    L9:
        e = move-exception;
        throw e;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        r1.close();
        throw th;
    L13:
        return r2;
    }
}
