package g3;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.bdinstall.Api;
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
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static InterfaceC0172a f8957a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f8958b = false;

    /* JADX INFO: renamed from: g3.a$a, reason: collision with other inner class name */
    public interface InterfaceC0172a {
        boolean d();

        boolean e();

        boolean k();
    }

    static {
    }

    private static Uri a(String r10, String r11, int r12, String r13, String r14, String r15) {
        StringBuilder r16 = new StringBuilder();
        if (r11 == null) goto L9;
        if (r10 == null) goto L6;
        r16.append(r10);
        r16.append("://");
    L6:
        r16.append(r11);
        if (r12 <= 0) goto L9;
        r16.append(':');
        r16.append(r12);
    L9:
        if (r13 != null) goto L11;
    L12:
        r16.append('/');
    L13:
        if (r13 == null) goto L15;
        r16.append(r13);
    L15:
        if (r14 == null) goto L17;
        r16.append('?');
        r16.append(r14);
    L17:
        if (r15 == null) goto L20;
        r16.append('#');
        r16.append(r15);
    L20:
        return Uri.parse(r16.toString());
    L11:
        if (r13.startsWith("/") == true) goto L13;
        goto L12
    }

    private static String b(String r10, String r11) {
        if (r11 != null) goto L10;
        r11 = "ISO-8859-1";
    L10:
        return URLEncoder.encode(r10, r11);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    private static String c(List<Pair<String, List<String>>> r10, boolean r11, String r12) {
        StringBuilder r13 = new StringBuilder();
        Iterator<Pair<String, List<String>>> r14 = r10.iterator();
    L4:
        if (r14.hasNext() == false) goto L25;
        Pair<String, List<String>> r15 = r14.next();
        Object r16 = r15.first;
        String r17 = (String) r16;
        if (r11 == false) goto L8;
        r17 = b((String) r16, r12);
    L8:
        List r18 = (List) r15.second;
        if (r18 == null) goto L4;
        if (r18.size() <= 0) goto L4;
        Iterator r19 = r18.iterator();
    L14:
        if (r19.hasNext() == false) goto L4;
        String r20 = (String) r19.next();
        if (r11 == false) goto L21;
        if (r20 == null) goto L19;
        r20 = b(r20, r12);
        goto L21
    L19:
        r20 = "";
    L21:
        if (r13.length() <= 0) goto L23;
        r13.append("&");
    L23:
        r13.append(r17);
        r13.append("=");
        r13.append(r20);
        goto L14
    L25:
        return r13.toString();
    }

    public static void d(Uri r10, Map<String, List<String>> r11) {
        if (r10 == null) goto L26;
        if (r11 != null) goto L27;
        return;
    L27:
        String r12 = r10.getEncodedQuery();     // Catch: Throwable -> L21
        if (r12 == null) goto L32;
        String[] r13 = r12.split("&");     // Catch: Throwable -> L21
        int r14 = r13.length;     // Catch: Throwable -> L21
        int r15 = 0;
    L8:
        if (r15 >= r14) goto L33;
        String r16 = r13[r15];     // Catch: Throwable -> L21
        int r17 = r16.indexOf("=");     // Catch: Throwable -> L21
        if (r17 < 0) goto L16;
        String r18 = URLDecoder.decode(r16.substring(0, r17), "UTF-8");     // Catch: Throwable -> L21
        List<String> r19 = r11.get(r18);     // Catch: Throwable -> L21
        if (r19 != null) goto L15;
        r19 = new LinkedList();     // Catch: Throwable -> L21
    L15:
        r19.add(URLDecoder.decode(r16.substring(r17 + 1), "UTF-8"));     // Catch: Throwable -> L21
        r11.put(r18, r19);     // Catch: Throwable -> L21
    L20:
        r15 = r15 + 1;
        goto L8
    L16:
        String r20 = URLDecoder.decode(r16, "UTF-8");     // Catch: Throwable -> L21
        List<String> r21 = r11.get(r20);     // Catch: Throwable -> L21
        if (r21 != null) goto L19;
        r21 = new LinkedList();     // Catch: Throwable -> L21
    L19:
        r21.add("");     // Catch: Throwable -> L21
        r11.put(r20, r21);     // Catch: Throwable -> L21
        goto L20
    L33:
        return;
    L32:
        return;
    L21:
        th = move-exception;
        th.printStackTrace();
        throw new IOException("parseUrl url is null !!!");
    L26:
        throw new IOException("parseUrl url is null !!!");
    }

    public static void e(InterfaceC0172a r10) {
        f8957a = r10;
    }

    private static boolean f(Map<String, List<String>> r10, List<Pair<String, List<String>>> r11, String r12) {
        if (TextUtils.isEmpty(r12) == false) goto L5;
        return false;
    L5:
        if (r11 != null) goto L8;
        return false;
    L8:
        if (r10.containsKey(r12) == false) goto L14;
        r11.add(new Pair(r12, r10.get(r12)));
        if (f8957a.e() == true) goto L15;
        r10.remove(r12);
        return true;
    L15:
        return true;
    L14:
        return false;
    }

    public static String g(String r11, List<Pair<String, String>> r12) {
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return r11;
    L6:
        if (f8957a != null) goto L9;
        return r11;
    L9:
        if (f8958b == false) goto L11;
        return r11;
    L11:
        LinkedHashMap r10 = new LinkedHashMap();
        Uri r13 = Uri.parse(r11);     // Catch: Throwable -> L36
        d(r13, r10);     // Catch: Throwable -> L36
        LinkedList r14 = new LinkedList();     // Catch: Throwable -> L36
        f(r10, r14, "device_id");     // Catch: Throwable -> L36
        f(r10, r14, Api.KEY_DEVICE_TYPE);     // Catch: Throwable -> L36
        f(r10, r14, "device_brand");     // Catch: Throwable -> L36
        f(r10, r14, Api.KEY_UUID);     // Catch: Throwable -> L36
        f(r10, r14, "openudid");     // Catch: Throwable -> L36
        String r15 = c(r14, false, "UTF-8");     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r15) == false) goto L15;
        return r11;
    L15:
        byte[] r16 = r15.getBytes();     // Catch: Throwable -> L36
        byte[] r17 = EncryptorUtil.a(r16, r16.length);     // Catch: Throwable -> L36
        if (r17 != null) goto L18;
        return r11;
    L18:
        String r18 = Base64.encodeToString(r17, 2);     // Catch: Throwable -> L36
        LinkedList r19 = new LinkedList();     // Catch: Throwable -> L36
        if (f8957a.k() == false) goto L22;
        LinkedList r20 = new LinkedList();     // Catch: Throwable -> L36
        r20.add(r18);     // Catch: Throwable -> L36
        r19.add(new Pair("ss_queries", r20));     // Catch: Throwable -> L36
    L22:
        if (f8957a.d() == false) goto L26;
        if (r12 == null) goto L26;
        r12.add(new Pair("X-SS-QUERIES", b(r18, "UTF-8")));     // Catch: Throwable -> L36
    L26:
        if (r10.isEmpty() == true) goto L34;
        Iterator r110 = r10.entrySet().iterator();     // Catch: Throwable -> L36
    L29:
        if (r110.hasNext() == false) goto L34;
        Map.Entry r21 = (Map.Entry) r110.next();     // Catch: Throwable -> L36
        if (r21 == null) goto L29;
        r19.add(new Pair(r21.getKey(), r21.getValue()));     // Catch: Throwable -> L36
    L34:
        String r22 = c(r19, true, "UTF-8");     // Catch: Throwable -> L36
        return a(r13.getScheme(), r13.getHost(), r13.getPort(), r13.getPath(), r22, r13.getFragment()).toString();
    L36:
        th = move-exception;
        th.printStackTrace();
        return r11;
    }
}
