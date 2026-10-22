package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.constant.NetConst;
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

/* JADX INFO: loaded from: classes.dex */
public class f {
    public static byte[] a(byte[] r10, Map<String, String> r11) {
        if (r10.length <= 128) goto L13;
        ByteArrayOutputStream r12 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r13 = new GZIPOutputStream(r12);
        r13.write(r10);     // Catch: Throwable -> L7 IOException -> L9
        r13.close();
        byte[] r14 = r12.toByteArray();
        r11.put(NetConst.KEY_CONTENT_ENCODING, NetConst.GZIP);
        return r14;
    L7:
        th = move-exception;
        r13.close();
        throw th;
    L9:
        e = move-exception;
        throw e;     // Catch: Throwable -> L7
    L13:
        return r10;
    }

    public static t4.c b(String r10, byte[] r11, String r12, String r13, String r14, boolean r15, boolean r16) {
        InputStream r17 = null;
        LinkedList r18 = new LinkedList();     // Catch: Throwable -> L77
        if (r16 == false) goto L6;
        URL r19 = new URL(g3.a.g(r10, r18));     // Catch: Throwable -> L77
    L7:
        HttpURLConnection r20 = (HttpURLConnection) r19.openConnection();     // Catch: Throwable -> L77
        if (r16 == false) goto L19;
    L75:
        th = th;
    L76:
        Throwable r21 = th;
        HttpURLConnection r22 = r20;
        th = r21;
    L87:
        throw th;     // Catch: Throwable -> L80
    L80:
        th = move-exception;
        IOUtils.closeQuietly(r17);
        if (r22 != null) goto L98;
    L84:
        throw th;
    L98:
        r22.disconnect();     // Catch: Exception -> L86
        goto L84
    L10:
        if (r18.isEmpty() == true) goto L19;
        Iterator r110 = r18.iterator();     // Catch: Throwable -> L75
    L13:
        if (r110.hasNext() == false) goto L19;
        Pair r23 = (Pair) r110.next();     // Catch: Throwable -> L75
        if (r23 == null) goto L13;
        r20.setRequestProperty((String) r23.first, (String) r23.second);     // Catch: Throwable -> L75
    L19:
        if (r15 == false) goto L21;
        r20.setDoOutput(true);     // Catch: Throwable -> L75
    L22:
        if (r12 == null) goto L24;
        r20.setRequestProperty(NetConst.KEY_CONTENT_TYPE, r12);     // Catch: Throwable -> L75
    L24:
        if (r13 == null) goto L26;
        r20.setRequestProperty(NetConst.KEY_CONTENT_ENCODING, r13);     // Catch: Throwable -> L75
    L26:
        r20.setRequestProperty(NetConst.KEY_ACCEPT_ENCODING, NetConst.GZIP);     // Catch: Throwable -> L75
        if (r14 == null) goto L74;
        r20.setRequestMethod(r14);     // Catch: Throwable -> L75
        if (r11 != null) goto L31;
    L41:
        int r24 = r20.getResponseCode();     // Catch: Throwable -> L75
        if (r24 != 200) goto L72;
        InputStream r25 = r20.getInputStream();     // Catch: Throwable -> L75
        String r26 = r20.getContentEncoding();     // Catch: Throwable -> L69
        if (TextUtils.isEmpty(r26) == false) goto L47;
    L56:
        byte[] r27 = e(r25);     // Catch: Throwable -> L69
    L57:
        Map<String, List<String>> r28 = r20.getHeaderFields();     // Catch: Throwable -> L69
        HashMap r111 = new HashMap();     // Catch: Throwable -> L69
        Iterator<Map.Entry<String, List<String>>> r29 = r28.entrySet().iterator();     // Catch: Throwable -> L69
    L59:
        if (r29.hasNext() == false) goto L65;
        Map.Entry<String, List<String>> r30 = r29.next();     // Catch: Throwable -> L69
        String r31 = r30.getKey();     // Catch: Throwable -> L69
        List<String> r32 = r30.getValue();     // Catch: Throwable -> L69
        if (r32 == null) goto L59;
        if (l3.c.a(r32) == true) goto L59;
        r111.put(r31, r32.get(0));     // Catch: Throwable -> L69
        goto L59
    L65:
        t4.c r33 = new t4.c(r24, r111, r27);     // Catch: Throwable -> L69
        IOUtils.closeQuietly(r25);
        r20.disconnect();     // Catch: Exception -> L85
    L68:
        return r33;
    L47:
        if (r26.equalsIgnoreCase(NetConst.GZIP) == false) goto L56;
        GZIPInputStream r34 = new GZIPInputStream(r25);     // Catch: Throwable -> L53
        r27 = e(r34);     // Catch: Throwable -> L51
        IOUtils.closeQuietly(r34);     // Catch: Throwable -> L69
    L51:
        th = th;
        r17 = r34;
    L54:
        IOUtils.closeQuietly(r17);     // Catch: Throwable -> L69
        throw th;     // Catch: Throwable -> L69
    L53:
        th = th;
    L69:
        th = th;
        r17 = r25;
        goto L76
    L72:
        throw new HttpResponseException(r24, r20.getResponseMessage());     // Catch: Throwable -> L75
    L31:
        if (r11.length <= 0) goto L41;
        DataOutputStream r35 = new DataOutputStream(r20.getOutputStream());     // Catch: Throwable -> L37
        r35.write(r11);     // Catch: Throwable -> L35
        r35.flush();     // Catch: Throwable -> L35
        IOUtils.closeQuietly(r35);     // Catch: Throwable -> L75
    L35:
        th = th;
    L39:
        IOUtils.closeQuietly(r35);     // Catch: Throwable -> L75
        throw th;     // Catch: Throwable -> L75
    L37:
        th = th;
        r35 = null;
        goto L39
    L74:
        throw new IllegalArgumentException("request method is not null");     // Catch: Throwable -> L75
    L21:
        r20.setDoOutput(false);     // Catch: Throwable -> L75
        goto L22
    L6:
        r19 = new URL(r10);     // Catch: Throwable -> L77
    L77:
        th = th;
        r22 = null;
        goto L87
    }

    public static byte[] c(String r10, String r11, boolean r12) {
        if (TextUtils.isDigitsOnly(r10) == false) goto L7;
        return null;
    L7:
        return b(r10, null, r11, null, "GET", false, r12).b();
    }

    public static boolean d(Context r10) {
        if (r10 != null) goto L14;
        return false;
    L14:
        NetworkInfo r11 = ((ConnectivityManager) r10.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L11
        if (r11 == null) goto L16;
        if (r11.isConnected() == false) goto L17;
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

    public static byte[] e(InputStream r10) {
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
}
