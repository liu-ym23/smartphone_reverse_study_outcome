package com.bytedance.frameworks.baselib.network.http.util;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f4694a = null;

    static {
        f4694a = Pattern.compile("(((?:(?i:http|https|rtsp|ws|wss)://(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:(([a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]](?:[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]_\\-]{0,61}[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]]){0,1}\\.)+(xn\\-\\-[\\w\\-]{0,58}\\w|[a-zA-Z[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]]{2,63})|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))))(?:\\:\\d{1,5})?)([/\\?](?:(?:[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]];/\\?:@&=#~\\-\\.\\+!\\*'\\(\\),_\\$])|(?:%[a-fA-F0-9]{2}))*)?(?:\\b|$|^))");
    }

    public static boolean a(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return false;
    L6:
        if (r5 == null) goto L13;
        if (r5.length() <= 7) goto L13;
        if (r5.substring(0, 8).equalsIgnoreCase("https://") == false) goto L13;
    L32:
        return f4694a.matcher(r5).matches();
    L13:
        if (r5 == null) goto L20;
        if (r5.length() <= 6) goto L20;
        if (r5.substring(0, 7).equalsIgnoreCase("http://") == true) goto L32;
    L20:
        if (r5 != null) goto L22;
    L26:
        if (r5 != null) goto L28;
    L33:
        return false;
    L28:
        if (r5.length() <= 4) goto L33;
        if (r5.substring(0, 5).equalsIgnoreCase("ws://") == false) goto L33;
    L22:
        if (r5.length() <= 5) goto L26;
        if (r5.substring(0, 6).equalsIgnoreCase("wss://") == false) goto L26;
        goto L26
    }

    public static boolean b(String r12, String r13) {
        if (r12 == null) goto L29;
        if (r13 == null) goto L29;
        int r5 = r12.length();
        int r10 = r13.length();
        int r11 = 0;
        int r14 = 0;
        int r15 = -1;
        int r16 = -1;
    L8:
        if (r11 >= r5) goto L22;
        if (r14 >= r10) goto L15;
        if (r13.charAt(r14) == '?') goto L14;
        if (r13.charAt(r14) != r12.charAt(r11)) goto L15;
    L14:
        r11 = r11 + 1;
        r14 = r14 + 1;
    L15:
        if (r14 >= r10) goto L19;
        if (r13.charAt(r14) != '*') goto L19;
        r16 = r11;
        r15 = r14;
        r14 = r14 + 1;
    L19:
        if (r15 == (-1)) goto L20;
        r14 = r15 + 1;
        r16 = r16 + 1;
        r11 = r16;
        goto L8
    L20:
        return false;
    L22:
        if (r14 >= r10) goto L27;
        if (r13.charAt(r14) != '*') goto L25;
        r14 = r14 + 1;
        goto L22
    L25:
        return false;
    L27:
        return true;
    L29:
        return false;
    }

    public static Pair c(String r10, HashMap r11) {
        if (com.bytedance.common.utility.b.b(r10) == true) goto L28;
        Uri r12 = Uri.parse(r10);     // Catch: Throwable -> L8
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L8
        String r13 = r12.getScheme();     // Catch: Throwable -> L8
        String r14 = r12.getHost();     // Catch: Throwable -> L8
        int r15 = r12.getPort();     // Catch: Throwable -> L8
        if (r14 == null) goto L13;
        if (r13 == null) goto L10;
        r5.append(r13);     // Catch: Throwable -> L8
        r5.append("://");     // Catch: Throwable -> L8
    L10:
        r5.append(r14);     // Catch: Throwable -> L8
        if (r15 <= 0) goto L13;
        r5.append(':');     // Catch: Throwable -> L8
        r5.append(r15);     // Catch: Throwable -> L8
    L13:
        String r16 = r5.toString();     // Catch: Throwable -> L8
        String r17 = r12.getEncodedPath();     // Catch: Throwable -> L8
        String r18 = r12.getEncodedQuery();     // Catch: Throwable -> L8
        if (r18 == null) goto L23;
        String[] r19 = r18.split("&");     // Catch: Throwable -> L8
        int r20 = r19.length;     // Catch: Throwable -> L8
        int r21 = 0;
    L16:
        if (r21 >= r20) goto L23;
        String r22 = r19[r21];     // Catch: Throwable -> L8
        int r23 = r22.indexOf("=");     // Catch: Throwable -> L8
        if (r23 < 0) goto L21;
        r11.put(URLDecoder.decode(r22.substring(0, r23), "UTF-8"), URLDecoder.decode(r22.substring(r23 + 1), "UTF-8"));     // Catch: Throwable -> L8
    L22:
        r21 = r21 + 1;     // Catch: Throwable -> L8
        goto L16
    L21:
        r11.put(URLDecoder.decode(r22, "UTF-8"), "");     // Catch: Throwable -> L8
    L23:
        return new Pair(r16, r17);
    L8:
        th = move-exception;
        th.printStackTrace();
        throw new IOException("parseUrl url is fail !!!");
    L28:
        throw new IOException("parseUrl url is null !!!");
    }

    public static Pair d(String r10, LinkedHashMap r11) {
        if (com.bytedance.common.utility.b.b(r10) == true) goto L34;
        Uri r12 = Uri.parse(r10);     // Catch: Throwable -> L8
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L8
        String r13 = r12.getScheme();     // Catch: Throwable -> L8
        String r14 = r12.getHost();     // Catch: Throwable -> L8
        int r15 = r12.getPort();     // Catch: Throwable -> L8
        if (r14 == null) goto L13;
        if (r13 == null) goto L10;
        r5.append(r13);     // Catch: Throwable -> L8
        r5.append("://");     // Catch: Throwable -> L8
    L10:
        r5.append(r14);     // Catch: Throwable -> L8
        if (r15 <= 0) goto L13;
        r5.append(':');     // Catch: Throwable -> L8
        r5.append(r15);     // Catch: Throwable -> L8
    L13:
        String r16 = r5.toString();     // Catch: Throwable -> L8
        String r17 = r12.getEncodedPath();     // Catch: Throwable -> L8
        String r18 = r12.getEncodedQuery();     // Catch: Throwable -> L8
        if (r18 == null) goto L29;
        String[] r19 = r18.split("&");     // Catch: Throwable -> L8
        int r20 = r19.length;     // Catch: Throwable -> L8
        int r21 = 0;
    L16:
        if (r21 >= r20) goto L29;
        String r22 = r19[r21];     // Catch: Throwable -> L8
        int r23 = r22.indexOf("=");     // Catch: Throwable -> L8
        if (r23 < 0) goto L24;
        String r24 = URLDecoder.decode(r22.substring(0, r23), "UTF-8");     // Catch: Throwable -> L8
        List r25 = (List) r11.get(r24);     // Catch: Throwable -> L8
        if (r25 != null) goto L23;
        r25 = new LinkedList();     // Catch: Throwable -> L8
    L23:
        r25.add(URLDecoder.decode(r22.substring(r23 + 1), "UTF-8"));     // Catch: Throwable -> L8
        r11.put(r24, r25);     // Catch: Throwable -> L8
    L28:
        r21 = r21 + 1;     // Catch: Throwable -> L8
        goto L16
    L24:
        String r26 = URLDecoder.decode(r22, "UTF-8");     // Catch: Throwable -> L8
        List r27 = (List) r11.get(r26);     // Catch: Throwable -> L8
        if (r27 != null) goto L27;
        r27 = new LinkedList();     // Catch: Throwable -> L8
    L27:
        r27.add("");     // Catch: Throwable -> L8
        r11.put(r26, r27);     // Catch: Throwable -> L8
    L29:
        return new Pair(r16, r17);
    L8:
        th = move-exception;
        th.printStackTrace();
        throw new IOException("parseUrl url is fail !!!");
    L34:
        throw new IOException("parseUrl url is null !!!");
    }
}
