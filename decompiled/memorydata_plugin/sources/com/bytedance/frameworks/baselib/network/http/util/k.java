package com.bytedance.frameworks.baselib.network.http.util;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f2553a = null;

    static {
        f2553a = Pattern.compile("(((?:(?i:http|https|rtsp|ws|wss)://(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:(([a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]](?:[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]_\\-]{0,61}[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]]){0,1}\\.)+(xn\\-\\-[\\w\\-]{0,58}\\w|[a-zA-Z[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]]{2,63})|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))))(?:\\:\\d{1,5})?)([/\\?](?:(?:[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]];/\\?:@&=#~\\-\\.\\+!\\*'\\(\\),_\\$])|(?:%[a-fA-F0-9]{2}))*)?(?:\\b|$|^))");
    }

    @Deprecated
    public static Pair<String, String> a(String r9, Map<String, String> r10) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        if (com.bytedance.common.utility.h.a(r9) == true) goto L29;
        Uri r12 = Uri.parse(r9);     // Catch: Throwable -> L25
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L25
        String r1 = r12.getScheme();     // Catch: Throwable -> L25
        String r2 = r12.getHost();     // Catch: Throwable -> L25
        int r3 = r12.getPort();     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        if (r1 == null) goto L8;
        r0.append(r1);     // Catch: Throwable -> L25
        r0.append("://");     // Catch: Throwable -> L25
    L8:
        r0.append(r2);     // Catch: Throwable -> L25
        if (r3 <= 0) goto L11;
        r0.append(':');     // Catch: Throwable -> L25
        r0.append(r3);     // Catch: Throwable -> L25
    L11:
        String r4 = r0.toString();     // Catch: Throwable -> L25
        String r5 = r12.getEncodedPath();     // Catch: Throwable -> L25
        if (r11 == null) goto L23;
        String r13 = r12.getEncodedQuery();     // Catch: Throwable -> L25
        if (r13 == null) goto L23;
        String[] r14 = r13.split("&");     // Catch: Throwable -> L25
        int r6 = r14.length;     // Catch: Throwable -> L25
        int r7 = 0;
    L16:
        if (r7 >= r6) goto L23;
        String r8 = r14[r7];     // Catch: Throwable -> L25
        int r15 = r8.indexOf("=");     // Catch: Throwable -> L25
        if (r15 < 0) goto L21;
        r11.put(URLDecoder.decode(r8.substring(0, r15), RpcUtils.CHARSET_UTF8), URLDecoder.decode(r8.substring(r15 + 1), RpcUtils.CHARSET_UTF8));     // Catch: Throwable -> L25
    L22:
        r7 = r7 + 1;     // Catch: Throwable -> L25
        goto L16
    L21:
        r11.put(URLDecoder.decode(r8, RpcUtils.CHARSET_UTF8), "");     // Catch: Throwable -> L25
    L23:
        return new Pair(r4, r5);
    L25:
        th = move-exception;
        th.printStackTrace();
        throw new IOException("parseUrl url is fail !!!");
    L29:
        throw new IOException("parseUrl url is null !!!");
    }

    public static String a(Map<String, List<String>> r6, String r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder();
        Iterator r9 = r8.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L23;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r3 = b((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), r7);
        List r4 = (List) ZeusTransformUtils.preCheckCast(r2.getValue(), List.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L4;
        if (r4.size() <= 0) goto L4;
        Iterator r5 = r4.iterator();
    L11:
        if (r5.hasNext() == false) goto L4;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L15;
        String r11 = b(r10, r7);
    L17:
        if (r0.length() <= 0) goto L19;
        r0.append("&");
    L19:
        r0.append(r3);
        if (r11.isEmpty() == true) goto L11;
        r0.append("=");
        r0.append(r11);
        goto L11
    L15:
        r11 = "";
        goto L17
    L23:
        return r0.toString();
    }

    public static URI a(String r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.isEmpty() == true) goto L17;
        return new URI(r2);
    L8:
        return URI.create(r2.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L11:
        return c(r2);
    L17:
        return null;
    }

    public static boolean a(String r12, String r13) {
        if (r12 == null) goto L29;
        if (r13 == null) goto L29;
        int r1 = r12.length();
        int r2 = r13.length();
        int r4 = 0;
        int r5 = 0;
        int r6 = -1;
        int r7 = -1;
    L8:
        if (r4 >= r1) goto L22;
        if (r5 >= r2) goto L15;
        if (r13.charAt(r5) == '?') goto L14;
        if (r13.charAt(r5) != r12.charAt(r4)) goto L15;
    L14:
        r4 = r4 + 1;
        r5 = r5 + 1;
    L15:
        if (r5 >= r2) goto L19;
        if (r13.charAt(r5) != '*') goto L19;
        r7 = r4;
        r6 = r5;
        r5 = r5 + 1;
    L19:
        if (r6 == (-1)) goto L20;
        r5 = r6 + 1;
        r7 = r7 + 1;
        r4 = r7;
        goto L8
    L20:
        return false;
    L22:
        if (r5 >= r2) goto L27;
        if (r13.charAt(r5) != '*') goto L25;
        r5 = r5 + 1;
        goto L22
    L25:
        return false;
    L27:
        return true;
    L29:
        return false;
    }

    public static Pair<String, String> b(String r12, Map<String, List<String>> r13) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        if (com.bytedance.common.utility.h.a(r12) == true) goto L35;
        Uri r15 = Uri.parse(r12);     // Catch: Throwable -> L31
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L31
        String r2 = r15.getScheme();     // Catch: Throwable -> L31
        String r3 = r15.getHost();     // Catch: Throwable -> L31
        int r4 = r15.getPort();     // Catch: Throwable -> L31
        if (r3 == null) goto L11;
        if (r2 == null) goto L8;
        r0.append(r2);     // Catch: Throwable -> L31
        r0.append("://");     // Catch: Throwable -> L31
    L8:
        r0.append(r3);     // Catch: Throwable -> L31
        if (r4 <= 0) goto L11;
        r0.append(':');     // Catch: Throwable -> L31
        r0.append(r4);     // Catch: Throwable -> L31
    L11:
        String r1 = r0.toString();     // Catch: Throwable -> L31
        String r5 = r15.getEncodedPath();     // Catch: Throwable -> L31
        if (r14 == null) goto L29;
        String r16 = r15.getEncodedQuery();     // Catch: Throwable -> L31
        if (r16 == null) goto L29;
        String[] r17 = r16.split("&");     // Catch: Throwable -> L31
        int r6 = r17.length;     // Catch: Throwable -> L31
        int r7 = 0;
    L16:
        if (r7 >= r6) goto L29;
        String r8 = r17[r7];     // Catch: Throwable -> L31
        int r9 = r8.indexOf("=");     // Catch: Throwable -> L31
        if (r9 < 0) goto L24;
        String r10 = URLDecoder.decode(r8.substring(0, r9), RpcUtils.CHARSET_UTF8);     // Catch: Throwable -> L31
        List r11 = (List) ZeusTransformUtils.preCheckCast(r14.get(r10), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        if (r11 != null) goto L23;
        r11 = new LinkedList();     // Catch: Throwable -> L31
    L23:
        r11.add(URLDecoder.decode(r8.substring(r9 + 1), RpcUtils.CHARSET_UTF8));     // Catch: Throwable -> L31
        r14.put(r10, r11);     // Catch: Throwable -> L31
    L28:
        r7 = r7 + 1;     // Catch: Throwable -> L31
        goto L16
    L24:
        String r18 = URLDecoder.decode(r8, RpcUtils.CHARSET_UTF8);     // Catch: Throwable -> L31
        List r19 = (List) ZeusTransformUtils.preCheckCast(r14.get(r18), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        if (r19 != null) goto L27;
        r19 = new LinkedList();     // Catch: Throwable -> L31
    L27:
        r19.add("");     // Catch: Throwable -> L31
        r14.put(r18, r19);     // Catch: Throwable -> L31
    L29:
        return new Pair(r1, r5);
    L31:
        th = move-exception;
        th.printStackTrace();
        throw new IOException("parseUrl url is fail !!!");
    L35:
        throw new IOException("parseUrl url is null !!!");
    }

    private static String b(String r0, String r1) {
        if (r1 != null) goto L10;
        r1 = "ISO-8859-1";
    L10:
        return URLEncoder.encode(r0, r1);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static boolean b(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return false;
    L6:
        if (d(r2) == true) goto L18;
        if (e(r2) == true) goto L18;
        if (f(r2) == true) goto L18;
        if (g(r2) == true) goto L18;
        return false;
    L18:
        return f2553a.matcher(r2).matches();
    L20:
        return false;
    }

    private static URI c(String r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.isEmpty() == true) goto L18;
        int r0 = r2.indexOf("?");     // Catch: Exception -> L11
        if (r0 <= 0) goto L9;
        r2 = r2.substring(0, r0);     // Catch: Exception -> L11
    L9:
        return URI.create(r2);
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    L18:
        return null;
    }

    private static boolean d(String r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.length() > 7) goto L7;
        return false;
    L7:
        if (r3.substring(0, 8).equalsIgnoreCase(ReportConsts.HTTPS) == false) goto L12;
        return true;
    L12:
        return false;
    }

    private static boolean e(String r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.length() > 6) goto L7;
        return false;
    L7:
        if (r3.substring(0, 7).equalsIgnoreCase("http://") == false) goto L12;
        return true;
    L12:
        return false;
    }

    private static boolean f(String r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.length() > 5) goto L7;
        return false;
    L7:
        if (r3.substring(0, 6).equalsIgnoreCase("wss://") == false) goto L12;
        return true;
    L12:
        return false;
    }

    private static boolean g(String r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.length() > 4) goto L7;
        return false;
    L7:
        if (r3.substring(0, 5).equalsIgnoreCase("ws://") == false) goto L12;
        return true;
    L12:
        return false;
    }
}
