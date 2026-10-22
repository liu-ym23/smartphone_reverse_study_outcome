package x4;

import android.text.TextUtils;
import com.bytedance.retrofit2.HttpMethodContrants;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f13533a = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f13534a;
    }

    static {
        f13533a = new String[]{HttpMethodContrants.GET, HttpMethodContrants.POST};
    }

    public static f5.a a(int r8, String r10, HashMap<String, String> r11, byte[] r12) {
        int r13 = r.f13543a;
        f5.a r14 = null;
        BufferedReader r15 = null;
        r14 = null;
        r14 = null;
        HttpURLConnection r16 = (HttpURLConnection) new URL(r10).openConnection();     // Catch: Throwable -> L54
        if (r8 != 0) goto L7;
        r16.setDoOutput(false);     // Catch: Throwable -> L54
    L9:
        r16.setRequestMethod(f13533a[r8]);     // Catch: Throwable -> L54
        if (r11.isEmpty() == true) goto L20;
        Iterator<Map.Entry<String, String>> r17 = r11.entrySet().iterator();     // Catch: Throwable -> L54
    L13:
        if (r17.hasNext() == false) goto L20;
        Map.Entry<String, String> r18 = r17.next();     // Catch: Throwable -> L54
        if (TextUtils.isEmpty(r18.getKey()) == true) goto L19;
        if (TextUtils.isEmpty(r18.getValue()) == true) goto L19;
        r16.addRequestProperty(r18.getKey(), r18.getValue());     // Catch: Throwable -> L54
    L19:
        int r19 = r.f13543a;     // Catch: Throwable -> L54
    L20:
        r16.setRequestProperty("Accept-Encoding", "gzip");     // Catch: Throwable -> L54
        if (r12 != null) goto L23;
    L26:
        DataOutputStream r20 = null;
    L27:
        int r21 = r16.getResponseCode();     // Catch: Throwable -> L52
        if (r21 != 200) goto L51;
        if (r16.getContentLength() >= 10240) goto L43;
        InputStream r22 = r16.getInputStream();     // Catch: Throwable -> L52
        if ("gzip".equalsIgnoreCase(r16.getContentEncoding()) == false) goto L34;
        BufferedReader r23 = new BufferedReader(new InputStreamReader(new GZIPInputStream(r22)));     // Catch: Throwable -> L52
    L78:
        StringBuilder r24 = new StringBuilder(r22.available());     // Catch: Throwable -> L41
    L36:
        String r25 = r23.readLine();     // Catch: Throwable -> L41
        if (r25 == null) goto L39;
        r24.append(r25);     // Catch: Throwable -> L41
        r24.append("\n");     // Catch: Throwable -> L41
        goto L36
    L39:
        JSONObject r26 = new JSONObject(r24.toString());     // Catch: Throwable -> L41
        r26.put("HttpCode", 200);     // Catch: Throwable -> L41
        r26.put("Set-Cookie", r16.getHeaderField("Set-Cookie"));     // Catch: Throwable -> L41
        f5.a r27 = new f5.a(r10, r21, k5.e.b(r16.getHeaderFields()), r26.toString());     // Catch: Throwable -> L41
        r15 = r23;
    L45:
        if (r20 != null) goto L93;
    L47:
        if (r15 != null) goto L88;
    L49:
        r14 = r27;
    L62:
        int r28 = r.f13543a;
        return r14;
    L88:
        r15.close();     // Catch: IOException -> L73
        goto L49
    L93:
        r20.close();     // Catch: IOException -> L72
    L41:
        s0 th = th;
    L84:
        int r29 = r.f13543a;     // Catch: Throwable -> L66
        if ((th instanceof s0) == true) goto L65;
        if (r20 != null) goto L91;
    L60:
        if (r23 == null) goto L62;
        r23.close();     // Catch: IOException -> L74
        goto L62
    L91:
        r20.close();     // Catch: IOException -> L75
        goto L60
    L65:
        throw th;     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        if (r20 != null) goto L86;
    L69:
        if (r23 == null) goto L105;
        r23.close();     // Catch: IOException -> L77
        throw th;
    L106:
        throw th;
    L105:
        throw th;
    L86:
        r20.close();     // Catch: IOException -> L76
        goto L69
    L34:
        r23 = new BufferedReader(new InputStreamReader(r22));     // Catch: Throwable -> L52
        goto L78
    L43:
        int r30 = r.f13543a;     // Catch: Throwable -> L52
        r27 = null;
        goto L45
    L51:
        throw new s0(r21, r16.getResponseMessage());     // Catch: Throwable -> L52
    L23:
        if (r12.length <= 0) goto L26;
        r20 = new DataOutputStream(r16.getOutputStream());     // Catch: Throwable -> L54
        r20.write(r12);     // Catch: Throwable -> L52
        r20.flush();     // Catch: Throwable -> L52
        r20.close();     // Catch: Throwable -> L52
    L52:
        th = th;
        r23 = null;
        goto L84
    L7:
        if (r8 != 1) goto L9;
        r16.setDoOutput(true);     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        th = th;
        r20 = null;
        r23 = null;
        goto L84
    }
}
