package n7;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static InterfaceC0119a f9470a;

    /* JADX INFO: renamed from: n7.a$a, reason: collision with other inner class name */
    public interface InterfaceC0119a {
        boolean d();

        boolean e();

        boolean f();
    }

    public static Uri a(String r8, String r10, String r11, String r12, String r13, int r14) {
        StringBuilder r15 = new StringBuilder();
        if (r10 == null) goto L9;
        if (r8 == null) goto L6;
        r15.append(r8);
        r15.append("://");
    L6:
        r15.append(r10);
        if (r14 <= 0) goto L9;
        r15.append(':');
        r15.append(r14);
    L9:
        if (r11 != null) goto L11;
    L12:
        r15.append('/');
    L13:
        if (r11 == null) goto L15;
        r15.append(r11);
    L15:
        if (r12 == null) goto L17;
        r15.append('?');
        r15.append(r12);
    L17:
        if (r13 == null) goto L20;
        r15.append('#');
        r15.append(r13);
    L20:
        return Uri.parse(r15.toString());
    L11:
        if (r11.startsWith("/") == true) goto L13;
        goto L12
    }

    public static String b(String r8) {
        return URLEncoder.encode(r8, "UTF-8");
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static String c(LinkedList r8, boolean r10) {
        StringBuilder r11 = new StringBuilder();
        Iterator r12 = r8.iterator();
    L4:
        if (r12.hasNext() == false) goto L25;
        Pair r13 = (Pair) r12.next();
        String r14 = (String) r13.first;
        if (r10 == false) goto L8;
        r14 = b(r14);
    L8:
        List r15 = (List) r13.second;
        if (r15 == null) goto L4;
        if (r15.size() <= 0) goto L4;
        Iterator r16 = r15.iterator();
    L14:
        if (r16.hasNext() == false) goto L4;
        String r17 = (String) r16.next();
        if (r10 == false) goto L21;
        if (r17 == null) goto L19;
        r17 = b(r17);
        goto L21
    L19:
        r17 = "";
    L21:
        if (r11.length() <= 0) goto L23;
        r11.append("&");
    L23:
        r11.append(r14);
        r11.append("=");
        r11.append(r17);
        goto L14
    L25:
        return r11.toString();
    }

    public static void d(Uri r10, LinkedHashMap r11) {
        if (r10 == null) goto L25;
        String r12 = r10.getEncodedQuery();     // Catch: Throwable -> L21
        if (r12 == null) goto L20;
        String[] r13 = r12.split("&");     // Catch: Throwable -> L21
        int r8 = r13.length;     // Catch: Throwable -> L21
        int r14 = 0;
    L7:
        if (r14 >= r8) goto L31;
        String r15 = r13[r14];     // Catch: Throwable -> L21
        int r16 = r15.indexOf("=");     // Catch: Throwable -> L21
        if (r16 < 0) goto L15;
        String r17 = URLDecoder.decode(r15.substring(0, r16), "UTF-8");     // Catch: Throwable -> L21
        List r18 = (List) r11.get(r17);     // Catch: Throwable -> L21
        if (r18 != null) goto L14;
        r18 = new LinkedList();     // Catch: Throwable -> L21
    L14:
        r18.add(URLDecoder.decode(r15.substring(r16 + 1), "UTF-8"));     // Catch: Throwable -> L21
        r11.put(r17, r18);     // Catch: Throwable -> L21
    L19:
        r14 = r14 + 1;
        goto L7
    L15:
        String r19 = URLDecoder.decode(r15, "UTF-8");     // Catch: Throwable -> L21
        List r20 = (List) r11.get(r19);     // Catch: Throwable -> L21
        if (r20 != null) goto L18;
        r20 = new LinkedList();     // Catch: Throwable -> L21
    L18:
        r20.add("");     // Catch: Throwable -> L21
        r11.put(r19, r20);     // Catch: Throwable -> L21
        goto L19
    L31:
        return;
    L20:
        return;
    L21:
        th = move-exception;
        th.printStackTrace();
        throw new IOException("parseUrl url is null !!!");
    L25:
        throw new IOException("parseUrl url is null !!!");
    }

    public static void e(String r8, LinkedList r10, LinkedHashMap r11) {
        if (TextUtils.isEmpty(r8) == false) goto L6;
        return;
    L6:
        if (r11.containsKey(r8) == false) goto L11;
        r10.add(new Pair(r8, r11.get(r8)));
        if (f9470a.f() == true) goto L12;
        r11.remove(r8);
        return;
    L12:
        return;
    }

    public static String f(String r10, LinkedList r11) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return r10;
    L6:
        if (f9470a != null) goto L8;
        return r10;
    L8:
        LinkedHashMap r8 = new LinkedHashMap();
        Uri r12 = Uri.parse(r10);     // Catch: Throwable -> L32
        d(r12, r8);     // Catch: Throwable -> L32
        LinkedList r13 = new LinkedList();     // Catch: Throwable -> L32
        e("device_id", r13, r8);     // Catch: Throwable -> L32
        e("device_type", r13, r8);     // Catch: Throwable -> L32
        e(LocationMonitorConst.DEVICE_BRAND, r13, r8);     // Catch: Throwable -> L32
        e("uuid", r13, r8);     // Catch: Throwable -> L32
        e("openudid", r13, r8);     // Catch: Throwable -> L32
        String r14 = c(r13, false);     // Catch: Throwable -> L32
        if (TextUtils.isEmpty(r14) == false) goto L12;
        return r10;
    L12:
        byte[] r15 = r14.getBytes();     // Catch: Throwable -> L32
        byte[] r16 = EncryptorUtil.a(r15.length, r15);     // Catch: Throwable -> L32
        if (r16 != null) goto L15;
        return r10;
    L15:
        String r17 = Base64.encodeToString(r16, 2);     // Catch: Throwable -> L32
        LinkedList r18 = new LinkedList();     // Catch: Throwable -> L32
        if (f9470a.d() == false) goto L19;
        LinkedList r19 = new LinkedList();     // Catch: Throwable -> L32
        r19.add(r17);     // Catch: Throwable -> L32
        r18.add(new Pair("ss_queries", r19));     // Catch: Throwable -> L32
    L19:
        if (f9470a.e() == false) goto L22;
        r11.add(new Pair("X-SS-QUERIES", b(r17)));     // Catch: Throwable -> L32
    L22:
        if (r8.isEmpty() == true) goto L30;
        Iterator r110 = r8.entrySet().iterator();     // Catch: Throwable -> L32
    L25:
        if (r110.hasNext() == false) goto L30;
        Map.Entry r20 = (Map.Entry) r110.next();     // Catch: Throwable -> L32
        if (r20 == null) goto L25;
        r18.add(new Pair(r20.getKey(), r20.getValue()));     // Catch: Throwable -> L32
    L30:
        String r21 = c(r18, true);     // Catch: Throwable -> L32
        String r22 = r12.getScheme();     // Catch: Throwable -> L32
        String r23 = r12.getHost();     // Catch: Throwable -> L32
        int r24 = r12.getPort();     // Catch: Throwable -> L32
        return a(r22, r23, r12.getPath(), r21, r12.getFragment(), r24).toString();
    L32:
        th = move-exception;
        th.printStackTrace();
        return r10;
    }
}
