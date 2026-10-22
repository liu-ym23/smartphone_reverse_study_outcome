package i3;

import android.text.TextUtils;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.framwork.core.sdkmonitor.f;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import t4.c;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f9376a = "POST";

    static {
    }

    public static c a(String r10, byte[] r11, Map<String, String> r12) {
        return b(r10, r11, f9376a, r12);
    }

    private static c b(String r10, byte[] r11, String r12, Map<String, String> r13) {
        if (r12 == null) goto L54;
        HttpURLConnection r14 = (HttpURLConnection) new URL(r10).openConnection();     // Catch: Throwable -> L48
        r14.setConnectTimeout(5000);     // Catch: Throwable -> L47
        r14.setReadTimeout(5000);     // Catch: Throwable -> L47
        if (r13 != null) goto L9;
    L17:
        r14.setDoOutput(TextUtils.equals(r12, f9376a));     // Catch: Throwable -> L47
        r14.setRequestMethod(r12);     // Catch: Throwable -> L47
        if (r11 != null) goto L20;
    L22:
        int r15 = r14.getResponseCode();     // Catch: Throwable -> L47
        if (r15 != 200) goto L43;
        InputStream r16 = r14.getInputStream();     // Catch: Throwable -> L47
        String r17 = r14.getContentEncoding();     // Catch: Throwable -> L56
        if (TextUtils.isEmpty(r17) == false) goto L28;
    L30:
        byte[] r18 = f.e(r16);     // Catch: Throwable -> L56
    L31:
        Map<String, List<String>> r19 = r14.getHeaderFields();     // Catch: Throwable -> L56
        HashMap r20 = new HashMap();     // Catch: Throwable -> L56
        Iterator<Map.Entry<String, List<String>>> r21 = r19.entrySet().iterator();     // Catch: Throwable -> L56
    L33:
        if (r21.hasNext() == false) goto L39;
        Map.Entry<String, List<String>> r22 = r21.next();     // Catch: Throwable -> L56
        String r23 = r22.getKey();     // Catch: Throwable -> L56
        List<String> r24 = r22.getValue();     // Catch: Throwable -> L56
        if (r24 == null) goto L33;
        if (r24.size() <= 0) goto L33;
        r20.put(r23, r24.get(0));     // Catch: Throwable -> L56
        goto L33
    L39:
        c r25 = new c(r15, r20, r18);     // Catch: Throwable -> L56
        IOUtils.closeQuietly(r16);
        r14.disconnect();     // Catch: Exception -> L55
    L42:
        return r25;
    L28:
        if (r17.equalsIgnoreCase(NetConst.GZIP) == false) goto L30;
        GZIPInputStream r26 = new GZIPInputStream(r16);     // Catch: Throwable -> L56
        r18 = f.e(r26);     // Catch: Throwable -> L56
        r26.close();     // Catch: Throwable -> L56
    L49:
        IOUtils.closeQuietly(r16);
        if (r14 != null) goto L64;
    L52:
        return null;
    L64:
        r14.disconnect();     // Catch: Exception -> L57
        goto L52
    L43:
        c r27 = new c(r15, null);     // Catch: Throwable -> L47
        IOUtils.closeQuietly(null);
        r14.disconnect();     // Catch: Exception -> L58
    L46:
        return r27;
    L20:
        if (r11.length <= 0) goto L22;
        DataOutputStream r28 = new DataOutputStream(r14.getOutputStream());     // Catch: Throwable -> L47
        r28.write(r11);     // Catch: Throwable -> L47
        r28.flush();     // Catch: Throwable -> L47
        r28.close();     // Catch: Throwable -> L47
        goto L22
    L9:
        if (r13.isEmpty() == true) goto L17;
        Iterator<Map.Entry<String, String>> r29 = r13.entrySet().iterator();     // Catch: Throwable -> L47
    L12:
        if (r29.hasNext() == false) goto L17;
        Map.Entry<String, String> r30 = r29.next();     // Catch: Throwable -> L47
        if (r30 == null) goto L12;
        r14.setRequestProperty(r30.getKey(), r30.getValue());     // Catch: Throwable -> L47
    L47:
        r16 = null;
    L48:
        r14 = null;
        r16 = null;
        goto L49
    L54:
        throw new IllegalArgumentException("request method is not null");
    }
}
