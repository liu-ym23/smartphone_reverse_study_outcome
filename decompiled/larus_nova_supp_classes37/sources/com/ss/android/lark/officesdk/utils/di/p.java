package com.ss.android.lark.officesdk.utils.di;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class p {
    public static final List<String> a = null;
    public static final Pattern b = null;

    static {
        a = CollectionsKt.listOf(new String[]{".gif", ".txt", ".pdf", ".ppt", ".pptx", ".jpg", ".jpeg", ".png", ".doc", ".docx", ".xls", ".xlsx", ".mp4", ".mp3", ".js", ".css", ".svg"});
        b = PatternProtector.compile("((sht|doc|dox|bas|app|sld|bmn|fld|nod|box|jsn|img|isv|wik|wia|wib|wic|wid|wie|whb)(cn|us|lg|jp)[A-Za-z0-9]{22})|[A-Z][a-zA-Z0-9]{3}([sdbafnjiw])[a-zA-Z0-9]{4}([oaplmsih])[a-zA-Z0-9]{4}([txspdngvkabce])[a-zA-Z0-9]{4}([culj])[a-zA-Z0-9]{4}([nsgp])[a-zA-Z0-9]{2}");
    }

    public static String a(Uri r3) {
        String r0 = "";
        if (r3 != null) goto L6;
        return "";
    L6:
        if (TextUtils.isEmpty(r3.getAuthority()) == true) goto L8;
        String r1 = r3.getScheme();
    L10:
        if (TextUtils.isEmpty(r3.getAuthority()) == true) goto L13;
        r0 = r3.getAuthority();
    L13:
        return r1 + "://" + r0;
    L8:
        r1 = "";
        goto L10
    }

    public static String b(String r4) {
        if (r4 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L20;
        j.b("ReportUrlUtils", "originUrl isNullOrBlank");
        return "";
    L20:
        Uri r1 = UriProtector.parse(r4);     // Catch: Exception -> L17
        if (TextUtils.isEmpty(r1.getEncodedPath()) == true) goto L16;
        return d(r1.getEncodedPath());
    L16:
        return "";
    L17:
        e = move-exception;
        j.d("ReportUrlUtils", e);
        return r4;
    L4:
        if (StringsKt.isBlank(r4) == true) goto L7;
        r0 = false;
        goto L9
    }

    public static String c(String r5) {
        boolean r0 = true;
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L13;
        j.b("ReportUrlUtils", "originUrl isNullOrBlank");
        return "";
    L13:
        if (r5 != null) goto L38;
    L20:
        if (r0 == false) goto L22;
        String r1 = "";
    L23:
        int r3 = g.a;     // Catch: Throwable -> L18
        if (g.a.a("openplatform.webview.report.safe.url") == false) goto L27;
        j.e("ReportUrlUtils", "openplatform.webview.report.safe.url is open");     // Catch: Throwable -> L18
        String r6 = b(r5);     // Catch: Throwable -> L18
    L34:
        return r1 + r6;
    L18:
        th = move-exception;
        j.d("ReportUrlUtils", th);
        return "";
    L27:
        if (TextUtils.isEmpty(r5) == true) goto L33;
        Uri r7 = UriProtector.parse(r5);     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r7.getEncodedPath()) == true) goto L33;
        r6 = r7.getEncodedPath();     // Catch: Throwable -> L18
        if (r6 != null) goto L34;
    L33:
        r6 = "";
        goto L34
    L22:
        r1 = a(UriProtector.parse(r5));     // Catch: Throwable -> L18
        goto L23
    L38:
        if (StringsKt.isBlank(r5) == true) goto L20;
        r0 = false;
        goto L20
    L5:
        if (StringsKt.isBlank(r5) == true) goto L8;
        r2 = false;
        goto L10
    }

    public static String d(String r11) {
        boolean r0 = true;
        boolean r1 = false;
        if (r11 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L13;
        j.b("ReportUrlUtils", "originPath isNullOrBlank");
        return "";
    L13:
        Iterator<T> r3 = a.iterator();
    L15:
        if (r3.hasNext() == false) goto L20;
        String r6 = (String) r3.next();
        if (StringsKt.endsWith$default(r11, r6, false, 2, null) == false) goto L15;
        j.e("ReportUrlUtils", "find need filter info: file type is " + r6);
        return StringsKt.replace$default(r11, r6, ".***", false, 4, null);
    L20:
        if (r11 != null) goto L35;
    L27:
        if (r0 == true) goto L30;
        r1 = b.matcher(r11).find();     // Catch: Throwable -> L25
    L30:
        if (r1 == false) goto L34;
        return StringsKt.replace$default(r11, r11.substring(r11.length() - 4), "****", false, 4, null);
    L25:
        th = move-exception;
        j.d("ReportUrlUtils", th);
    L34:
        return r11;
    L35:
        if (StringsKt.isBlank(r11) == true) goto L27;
        r0 = false;
        goto L27
    L5:
        if (StringsKt.isBlank(r11) == true) goto L8;
        r2 = false;
        goto L10
    }
}
