package com.bytedance.frameworks.baselib.network.http.util;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm6.util.constant.ReportConsts;
import java.io.IOException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f1890a = null;

    static {
        f1890a = Pattern.compile("(((?:(?i:http|https|rtsp|ws|wss)://(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:(([a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]](?:[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]_\\-]{0,61}[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]]){0,1}\\.)+(xn\\-\\-[\\w\\-]{0,58}\\w|[a-zA-Z[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]]{2,63})|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))))(?:\\:\\d{1,5})?)([/\\?](?:(?:[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]];/\\?:@&=#~\\-\\.\\+!\\*'\\(\\),_\\$])|(?:%[a-fA-F0-9]{2}))*)?(?:\\b|$|^))");
    }

    private static URI a(String r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.isEmpty() == true) goto L18;
        int r11 = r10.indexOf("?");     // Catch: Exception -> L11
        if (r11 <= 0) goto L9;
        r10 = r10.substring(0, r11);     // Catch: Exception -> L11
    L9:
        return URI.create(r10);
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    L18:
        return null;
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

    public static String c(Map<String, List<String>> r10, String r11) {
        StringBuilder r12 = new StringBuilder();
        Iterator<Map.Entry<String, List<String>>> r13 = r10.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L23;
        Map.Entry<String, List<String>> r14 = r13.next();
        String r15 = b(r14.getKey(), r11);
        List<String> r16 = r14.getValue();
        if (r16 == null) goto L4;
        if (r16.size() <= 0) goto L4;
        Iterator<String> r17 = r16.iterator();
    L11:
        if (r17.hasNext() == false) goto L4;
        String r18 = r17.next();
        if (r18 == null) goto L15;
        String r19 = b(r18, r11);
    L17:
        if (r12.length() <= 0) goto L19;
        r12.append("&");
    L19:
        r12.append(r15);
        if (r19.isEmpty() == true) goto L11;
        r12.append("=");
        r12.append(r19);
        goto L11
    L15:
        r19 = "";
        goto L17
    L23:
        return r12.toString();
    }

    private static boolean d(String r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.length() > 6) goto L7;
        return false;
    L7:
        if (r10.substring(0, 7).equalsIgnoreCase("http://") == false) goto L12;
        return true;
    L12:
        return false;
    }

    private static boolean e(String r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.length() > 7) goto L7;
        return false;
    L7:
        if (r10.substring(0, 8).equalsIgnoreCase(ReportConsts.HTTPS) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean f(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return false;
    L6:
        if (e(r10) == true) goto L18;
        if (d(r10) == true) goto L18;
        if (h(r10) == true) goto L18;
        if (g(r10) == true) goto L18;
        return false;
    L18:
        return f1890a.matcher(r10).matches();
    L20:
        return false;
    }

    private static boolean g(String r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.length() > 4) goto L7;
        return false;
    L7:
        if (r10.substring(0, 5).equalsIgnoreCase("ws://") == false) goto L12;
        return true;
    L12:
        return false;
    }

    private static boolean h(String r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.length() > 5) goto L7;
        return false;
    L7:
        if (r10.substring(0, 6).equalsIgnoreCase("wss://") == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean i(String r12, String r13) {
        if (r12 == null) goto L29;
        if (r13 == null) goto L29;
        int r10 = r12.length();
        int r11 = r13.length();
        int r14 = 0;
        int r15 = 0;
        int r16 = -1;
        int r17 = -1;
    L8:
        if (r14 >= r10) goto L22;
        if (r15 >= r11) goto L15;
        if (r13.charAt(r15) == '?') goto L14;
        if (r13.charAt(r15) != r12.charAt(r14)) goto L15;
    L14:
        r14 = r14 + 1;
        r15 = r15 + 1;
    L15:
        if (r15 >= r11) goto L19;
        if (r13.charAt(r15) != '*') goto L19;
        r17 = r14;
        r16 = r15;
        r15 = r15 + 1;
    L19:
        if (r16 == (-1)) goto L20;
        r15 = r16 + 1;
        r17 = r17 + 1;
        r14 = r17;
        goto L8
    L20:
        return false;
    L22:
        if (r15 >= r11) goto L27;
        if (r13.charAt(r15) != '*') goto L25;
        r15 = r15 + 1;
        goto L22
    L25:
        return false;
    L27:
        return true;
    L29:
        return false;
    }

    @Deprecated
    public static Pair<String, String> j(String r10, Map<String, String> r11) {
        if (com.bytedance.common.utility.g.b(r10) == true) goto L29;
        Uri r12 = Uri.parse(r10);     // Catch: Throwable -> L25
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L25
        String r14 = r12.getScheme();     // Catch: Throwable -> L25
        String r15 = r12.getHost();     // Catch: Throwable -> L25
        int r16 = r12.getPort();     // Catch: Throwable -> L25
        if (r15 == null) goto L11;
        if (r14 == null) goto L8;
        r13.append(r14);     // Catch: Throwable -> L25
        r13.append("://");     // Catch: Throwable -> L25
    L8:
        r13.append(r15);     // Catch: Throwable -> L25
        if (r16 <= 0) goto L11;
        r13.append(':');     // Catch: Throwable -> L25
        r13.append(r16);     // Catch: Throwable -> L25
    L11:
        String r17 = r13.toString();     // Catch: Throwable -> L25
        String r18 = r12.getEncodedPath();     // Catch: Throwable -> L25
        if (r11 == null) goto L23;
        String r19 = r12.getEncodedQuery();     // Catch: Throwable -> L25
        if (r19 == null) goto L23;
        String[] r20 = r19.split("&");     // Catch: Throwable -> L25
        int r21 = r20.length;     // Catch: Throwable -> L25
        int r22 = 0;
    L16:
        if (r22 >= r21) goto L23;
        String r23 = r20[r22];     // Catch: Throwable -> L25
        int r24 = r23.indexOf("=");     // Catch: Throwable -> L25
        if (r24 < 0) goto L21;
        r11.put(URLDecoder.decode(r23.substring(0, r24), "UTF-8"), URLDecoder.decode(r23.substring(r24 + 1), "UTF-8"));     // Catch: Throwable -> L25
    L22:
        r22 = r22 + 1;     // Catch: Throwable -> L25
        goto L16
    L21:
        r11.put(URLDecoder.decode(r23, "UTF-8"), "");     // Catch: Throwable -> L25
    L23:
        return new Pair(r17, r18);
    L25:
        th = move-exception;
        th.printStackTrace();
        throw new IOException("parseUrl url is fail !!!");
    L29:
        throw new IOException("parseUrl url is null !!!");
    }

    public static Pair<String, String> k(String r10, Map<String, List<String>> r11) {
        if (com.bytedance.common.utility.g.b(r10) == true) goto L35;
        Uri r12 = Uri.parse(r10);     // Catch: Throwable -> L31
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L31
        String r14 = r12.getScheme();     // Catch: Throwable -> L31
        String r15 = r12.getHost();     // Catch: Throwable -> L31
        int r16 = r12.getPort();     // Catch: Throwable -> L31
        if (r15 == null) goto L11;
        if (r14 == null) goto L8;
        r13.append(r14);     // Catch: Throwable -> L31
        r13.append("://");     // Catch: Throwable -> L31
    L8:
        r13.append(r15);     // Catch: Throwable -> L31
        if (r16 <= 0) goto L11;
        r13.append(':');     // Catch: Throwable -> L31
        r13.append(r16);     // Catch: Throwable -> L31
    L11:
        String r17 = r13.toString();     // Catch: Throwable -> L31
        String r18 = r12.getEncodedPath();     // Catch: Throwable -> L31
        if (r11 == null) goto L29;
        String r19 = r12.getEncodedQuery();     // Catch: Throwable -> L31
        if (r19 == null) goto L29;
        String[] r110 = r19.split("&");     // Catch: Throwable -> L31
        int r20 = r110.length;     // Catch: Throwable -> L31
        int r21 = 0;
    L16:
        if (r21 >= r20) goto L29;
        String r22 = r110[r21];     // Catch: Throwable -> L31
        int r23 = r22.indexOf("=");     // Catch: Throwable -> L31
        if (r23 < 0) goto L24;
        String r24 = URLDecoder.decode(r22.substring(0, r23), "UTF-8");     // Catch: Throwable -> L31
        List<String> r25 = r11.get(r24);     // Catch: Throwable -> L31
        if (r25 != null) goto L23;
        r25 = new LinkedList();     // Catch: Throwable -> L31
    L23:
        r25.add(URLDecoder.decode(r22.substring(r23 + 1), "UTF-8"));     // Catch: Throwable -> L31
        r11.put(r24, r25);     // Catch: Throwable -> L31
    L28:
        r21 = r21 + 1;     // Catch: Throwable -> L31
        goto L16
    L24:
        String r26 = URLDecoder.decode(r22, "UTF-8");     // Catch: Throwable -> L31
        List<String> r27 = r11.get(r26);     // Catch: Throwable -> L31
        if (r27 != null) goto L27;
        r27 = new LinkedList();     // Catch: Throwable -> L31
    L27:
        r27.add("");     // Catch: Throwable -> L31
        r11.put(r26, r27);     // Catch: Throwable -> L31
    L29:
        return new Pair(r17, r18);
    L31:
        th = move-exception;
        th.printStackTrace();
        throw new IOException("parseUrl url is fail !!!");
    L35:
        throw new IOException("parseUrl url is null !!!");
    }

    public static URI l(String r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.isEmpty() == true) goto L17;
        return new URI(r10);
    L8:
        return URI.create(r10.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L11:
        return a(r10);
    L17:
        return null;
    }
}
