package com.bytedance.bdinstall;

import android.text.TextUtils;
import com.obric.sva.sdk.data.ISmModel;
import d84.a;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class p implements g0 {
    public final q a;

    public p() {
        this.a = new q();
    }

    public final String get(String r3, Map<String, String> r4) throws Exception {
        this.a.getClass();
        a r5 = q.b(0, r3, (HashMap) r4, null);
        if (r5 != null) goto L5;
        return "";
    L5:
        return r5.d;
    }

    public final String post(String r2, byte[] r3, Map<String, String> r4) throws Exception {
        this.a.getClass();
        a r5 = q.b(1, r2, (HashMap) r4, r3);
        if (r5 != null) goto L5;
        return "";
    L5:
        return r5.d;
    }

    public final byte[] postStream(String r5, byte[] r6, Map<String, String> r7) throws RangersHttpException {
        this.a.getClass();
        int r1 = t.a;
        byte[] r2 = null;
        HttpURLConnection r8 = (HttpURLConnection) q.a(new URL(r5));     // Catch: Throwable -> L44
        r8.setDoOutput(true);     // Catch: Throwable -> L44
        r8.setRequestMethod(q.a[1]);     // Catch: Throwable -> L44
        HashMap r9 = (HashMap) r7;     // Catch: Throwable -> L44
        if (r9.isEmpty() == true) goto L14;
        Iterator r10 = r9.entrySet().iterator();     // Catch: Throwable -> L44
    L7:
        if (r10.hasNext() == false) goto L14;
        Map.Entry r3 = (Map.Entry) r10.next();     // Catch: Throwable -> L44
        if (TextUtils.isEmpty((CharSequence) r3.getKey()) == true) goto L13;
        if (TextUtils.isEmpty((CharSequence) r3.getValue()) == true) goto L13;
        r8.addRequestProperty((String) r3.getKey(), (String) r3.getValue());     // Catch: Throwable -> L44
    L13:
        t.e(null);     // Catch: Throwable -> L44
    L14:
        r8.setRequestProperty("Accept-Encoding", "gzip");     // Catch: Throwable -> L44
        if (r6 != null) goto L17;
    L20:
        DataOutputStream r11 = null;
    L21:
        int r12 = r8.getResponseCode();     // Catch: Throwable -> L41
        if (r12 != 200) goto L40;
        InputStream r13 = r8.getInputStream();     // Catch: Throwable -> L41
        if ("gzip".equalsIgnoreCase(r8.getContentEncoding()) == true) goto L26;
    L62:
        ByteArrayOutputStream r14 = new ByteArrayOutputStream();     // Catch: Throwable -> L37
        byte[] r0 = new byte[ISmModel.VERSION_0400];     // Catch: Throwable -> L35
    L30:
        int r4 = r13.read(r0);     // Catch: Throwable -> L35
        if (r4 == (-1)) goto L33;
        r14.write(r0, 0, r4);     // Catch: Throwable -> L35
        goto L30
    L33:
        r2 = r14.toByteArray();     // Catch: Throwable -> L35
    L48:
        c1.d(r11);
        c1.d(r13);
        c1.d(r14);
        return r2;
    L35:
        Throwable th = th;
    L57:
        t.e(th);     // Catch: Throwable -> L52
        if ((th instanceof RangersHttpException) == false) goto L48;
        throw ((RangersHttpException) th);     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        c1.d(r11);
        c1.d(r13);
        c1.d(r14);
        throw th;
    L37:
        th = move-exception;
        th = th;
    L43:
        r14 = null;
        goto L57
    L26:
        r13 = new GZIPInputStream(r13);     // Catch: Throwable -> L41
        goto L62
    L40:
        throw new RangersHttpException(r12, r8.getResponseMessage());     // Catch: Throwable -> L41
    L17:
        if (r6.length <= 0) goto L20;
        r11 = new DataOutputStream(r8.getOutputStream());     // Catch: Throwable -> L44
        r11.write(r6);     // Catch: Throwable -> L41
        r11.flush();     // Catch: Throwable -> L41
        r11.close();     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        th = th;
        r13 = null;
    L44:
        th = move-exception;
        th = th;
        r14 = null;
        r13 = null;
        r11 = null;
        goto L57
    }
}
