package l7;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import java.io.IOException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f9175a = null;

    static {
        f9175a = Pattern.compile("(((?:(?i:http|https|rtsp|ws|wss)://(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:(([a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]](?:[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]_\\-]{0,61}[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]]){0,1}\\.)+(xn\\-\\-[\\w\\-]{0,58}\\w|[a-zA-Z[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]]{2,63})|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))))(?:\\:\\d{1,5})?)([/\\?](?:(?:[a-zA-Z0-9[ -\ud7ff豈-﷏ﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]];/\\?:@&=#~\\-\\.\\+!\\*'\\(\\),_\\$])|(?:%[a-fA-F0-9]{2}))*)?(?:\\b|$|^))");
    }

    public static boolean a(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return false;
    L5:
        boolean r10 = true;
        if (r8 != null) goto L8;
    L12:
        boolean r11 = false;
    L13:
        if (r11 == true) goto L42;
        if (r8 != null) goto L17;
    L21:
        boolean r12 = false;
    L22:
        if (r12 == true) goto L42;
        if (r8 != null) goto L26;
    L30:
        boolean r13 = false;
    L31:
        if (r13 == true) goto L42;
        if (r8 != null) goto L34;
    L38:
        r10 = false;
    L39:
        if (r10 == true) goto L42;
        return false;
    L34:
        if (r8.length() <= 4) goto L38;
        if (r8.substring(0, 5).equalsIgnoreCase("ws://") == false) goto L38;
    L26:
        if (r8.length() <= 5) goto L30;
        if (r8.substring(0, 6).equalsIgnoreCase("wss://") == false) goto L30;
        r13 = true;
        goto L31
    L17:
        if (r8.length() <= 6) goto L21;
        if (r8.substring(0, 7).equalsIgnoreCase("http://") == false) goto L21;
        r12 = true;
    L42:
        return f9175a.matcher(r8).matches();
    L8:
        if (r8.length() <= 7) goto L12;
        if (r8.substring(0, 8).equalsIgnoreCase("https://") == false) goto L12;
        r11 = true;
        goto L13
    }

    public static boolean b(String r12, String r13) {
        if (r12 == null) goto L29;
        if (r13 == null) goto L29;
        int r8 = r12.length();
        int r10 = r13.length();
        int r11 = 0;
        int r14 = 0;
        int r15 = -1;
        int r16 = -1;
    L8:
        if (r11 >= r8) goto L22;
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

    @Deprecated
    public static Pair c(String r10, LinkedHashMap r11) {
        if (r5.f.b(r10) == true) goto L27;
        Uri r12 = Uri.parse(r10);     // Catch: Throwable -> L23
        StringBuilder r8 = new StringBuilder();     // Catch: Throwable -> L23
        String r13 = r12.getScheme();     // Catch: Throwable -> L23
        String r14 = r12.getHost();     // Catch: Throwable -> L23
        int r15 = r12.getPort();     // Catch: Throwable -> L23
        if (r14 == null) goto L11;
        if (r13 == null) goto L8;
        r8.append(r13);     // Catch: Throwable -> L23
        r8.append("://");     // Catch: Throwable -> L23
    L8:
        r8.append(r14);     // Catch: Throwable -> L23
        if (r15 <= 0) goto L11;
        r8.append(':');     // Catch: Throwable -> L23
        r8.append(r15);     // Catch: Throwable -> L23
    L11:
        String r16 = r8.toString();     // Catch: Throwable -> L23
        String r17 = r12.getEncodedPath();     // Catch: Throwable -> L23
        String r18 = r12.getEncodedQuery();     // Catch: Throwable -> L23
        if (r18 == null) goto L21;
        String[] r19 = r18.split("&");     // Catch: Throwable -> L23
        int r20 = r19.length;     // Catch: Throwable -> L23
        int r21 = 0;
    L14:
        if (r21 >= r20) goto L21;
        String r22 = r19[r21];     // Catch: Throwable -> L23
        int r23 = r22.indexOf("=");     // Catch: Throwable -> L23
        if (r23 < 0) goto L19;
        r11.put(URLDecoder.decode(r22.substring(0, r23), "UTF-8"), URLDecoder.decode(r22.substring(r23 + 1), "UTF-8"));     // Catch: Throwable -> L23
    L20:
        r21 = r21 + 1;     // Catch: Throwable -> L23
        goto L14
    L19:
        r11.put(URLDecoder.decode(r22, "UTF-8"), "");     // Catch: Throwable -> L23
    L21:
        return new Pair(r16, r17);
    L23:
        th = move-exception;
        th.printStackTrace();
        throw new IOException("parseUrl url is fail !!!");
    L27:
        throw new IOException("parseUrl url is null !!!");
    }

    public static Pair d(String r10, LinkedHashMap r11) {
        if (r5.f.b(r10) == true) goto L33;
        Uri r12 = Uri.parse(r10);     // Catch: Throwable -> L29
        StringBuilder r8 = new StringBuilder();     // Catch: Throwable -> L29
        String r13 = r12.getScheme();     // Catch: Throwable -> L29
        String r14 = r12.getHost();     // Catch: Throwable -> L29
        int r15 = r12.getPort();     // Catch: Throwable -> L29
        if (r14 == null) goto L11;
        if (r13 == null) goto L8;
        r8.append(r13);     // Catch: Throwable -> L29
        r8.append("://");     // Catch: Throwable -> L29
    L8:
        r8.append(r14);     // Catch: Throwable -> L29
        if (r15 <= 0) goto L11;
        r8.append(':');     // Catch: Throwable -> L29
        r8.append(r15);     // Catch: Throwable -> L29
    L11:
        String r16 = r8.toString();     // Catch: Throwable -> L29
        String r17 = r12.getEncodedPath();     // Catch: Throwable -> L29
        String r18 = r12.getEncodedQuery();     // Catch: Throwable -> L29
        if (r18 == null) goto L27;
        String[] r19 = r18.split("&");     // Catch: Throwable -> L29
        int r20 = r19.length;     // Catch: Throwable -> L29
        int r21 = 0;
    L14:
        if (r21 >= r20) goto L27;
        String r22 = r19[r21];     // Catch: Throwable -> L29
        int r23 = r22.indexOf("=");     // Catch: Throwable -> L29
        if (r23 < 0) goto L22;
        String r24 = URLDecoder.decode(r22.substring(0, r23), "UTF-8");     // Catch: Throwable -> L29
        List r25 = (List) r11.get(r24);     // Catch: Throwable -> L29
        if (r25 != null) goto L21;
        r25 = new LinkedList();     // Catch: Throwable -> L29
    L21:
        r25.add(URLDecoder.decode(r22.substring(r23 + 1), "UTF-8"));     // Catch: Throwable -> L29
        r11.put(r24, r25);     // Catch: Throwable -> L29
    L26:
        r21 = r21 + 1;     // Catch: Throwable -> L29
        goto L14
    L22:
        String r26 = URLDecoder.decode(r22, "UTF-8");     // Catch: Throwable -> L29
        List r27 = (List) r11.get(r26);     // Catch: Throwable -> L29
        if (r27 != null) goto L25;
        r27 = new LinkedList();     // Catch: Throwable -> L29
    L25:
        r27.add("");     // Catch: Throwable -> L29
        r11.put(r26, r27);     // Catch: Throwable -> L29
    L27:
        return new Pair(r16, r17);
    L29:
        th = move-exception;
        th.printStackTrace();
        throw new IOException("parseUrl url is fail !!!");
    L33:
        throw new IOException("parseUrl url is null !!!");
    }

    public static URI e(String r8) {
        if (r8 != null) goto L5;
    L22:
        return null;
    L5:
        if (r8.isEmpty() == true) goto L22;
        return new URI(r8);
    L9:
        return URI.create(r8.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L12:
        if (r8.isEmpty() == true) goto L28;
        int r10 = r8.indexOf("?");     // Catch: Exception -> L19
        if (r10 <= 0) goto L17;
        r8 = r8.substring(0, r10);     // Catch: Exception -> L19
    L17:
        return URI.create(r8);
    L19:
        e = move-exception;
        throw new RuntimeException(e);
    L28:
        return null;
    }
}
