package vwb;

import android.text.TextUtils;
import android.webkit.CookieManager;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.officesdk.utils.di.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static String a(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L8:
        if (r4 != null) goto L11;
        return "null";
    L11:
        if (TextUtils.isEmpty(r4) == false) goto L14;
        return "empty";
    L14:
        if (r4.length() <= 24) goto L20;
        String r0 = r4.substring(0, 12);
        String r2 = r4.substring(r4.length() - 12);
        return r0 + r4.substring(12, r4.length() - 12).replaceAll("[\\s\\S]", "*") + r2;
    L20:
        return "less 24,currentLength:" + r4.length();
    L5:
        if (r4.startsWith("http") == false) goto L8;
        return UriProtector.parse(r4).getHost();
    }

    public static String b(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L26;
        j.b("SessionUtils", "getSession empty url");
        return "";
    L26:
        CookieManager r2 = a.C0202a.a.a;     // Catch: Throwable -> L23
        if (r2 != null) goto L9;
        j.e("LarkCookieManager", "getCookie mCookieManager is null");     // Catch: Throwable -> L23
        String r11 = null;
    L11:
        if (TextUtils.isEmpty(r11) == true) goto L21;
        StringBuffer r3 = new StringBuffer();     // Catch: Throwable -> L23
        String[] r12 = r11.split(";");     // Catch: Throwable -> L23
        int r6 = 0;
    L14:
        if (r6 >= r12.length) goto L20;
        String[] r7 = r12[r6].trim().split("=");     // Catch: Throwable -> L23
        if (r7.length < 2) goto L18;
        r3.append(r7[0]);     // Catch: Throwable -> L23
        r3.append("=");     // Catch: Throwable -> L23
        r3.append(a(r7[1]));     // Catch: Throwable -> L23
        r3.append(";");     // Catch: Throwable -> L23
    L18:
        r6 = r6 + 1;     // Catch: Throwable -> L23
        goto L14
    L20:
        return r3.toString();
    L21:
        j.b("SessionUtils", "getSession empty cookie");     // Catch: Throwable -> L23
        return "";
    L9:
        r11 = r2.getCookie(r10);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        j.d("SessionUtils", th);
        return "";
    }
}
