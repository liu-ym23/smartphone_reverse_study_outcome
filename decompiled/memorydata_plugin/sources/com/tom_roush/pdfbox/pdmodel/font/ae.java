package com.tom_roush.pdfbox.pdmodel.font;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
final class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, String> f16221a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, com.tom_roush.fontbox.a.e> f16222b = null;

    static {
        f16221a = new HashMap(38);
        f16222b = new HashMap(14);
        e("Courier-Bold");
        e("Courier-BoldOblique");
        e("Courier");
        e("Courier-Oblique");
        e("Helvetica");
        e("Helvetica-Bold");
        e("Helvetica-BoldOblique");
        e("Helvetica-Oblique");
        e("Symbol");
        e("Times-Bold");
        e("Times-BoldItalic");
        e("Times-Italic");
        e("Times-Roman");
        e("ZapfDingbats");
        a("CourierCourierNew", "Courier");
        a("CourierNew", "Courier");
        a("CourierNew,Italic", "Courier-Oblique");
        a("CourierNew,Bold", "Courier-Bold");
        a("CourierNew,BoldItalic", "Courier-BoldOblique");
        a("Arial", "Helvetica");
        a("Arial,Italic", "Helvetica-Oblique");
        a("Arial,Bold", "Helvetica-Bold");
        a("Arial,BoldItalic", "Helvetica-BoldOblique");
        a("TimesNewRoman", "Times-Roman");
        a("TimesNewRoman,Italic", "Times-Italic");
        a("TimesNewRoman,Bold", "Times-Bold");
        a("TimesNewRoman,BoldItalic", "Times-BoldItalic");
        a("Symbol,Italic", "Symbol");
        a("Symbol,Bold", "Symbol");
        a("Symbol,BoldItalic", "Symbol");
        a("Times", "Times-Roman");
        a("Times,Italic", "Times-Italic");
        a("Times,Bold", "Times-Bold");
        a("Times,BoldItalic", "Times-BoldItalic");
        a("ArialMT", "Helvetica");
        a("Arial-ItalicMT", "Helvetica-Oblique");
        a("Arial-BoldMT", "Helvetica-Bold");
        a("Arial-BoldItalicMT", "Helvetica-BoldOblique");
    }

    public static com.tom_roush.fontbox.a.e a(String r2) {
        String r3 = (String) ZeusTransformUtils.preCheckCast(f16221a.get(r2), String.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        return null;
    L6:
        Map<String, com.tom_roush.fontbox.a.e> r0 = f16222b;
        if (r0.get(r3) != null) goto L22;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L10:
        if (r0.get(r3) == null) goto L24;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        goto L22
    L24:
        d(r3);     // Catch: IOException -> L13 Throwable -> L18
    L13:
        e = move-exception;
        throw new IllegalArgumentException(e);     // Catch: Throwable -> L18
    L22:
        return (com.tom_roush.fontbox.a.e) ZeusTransformUtils.preCheckCast(r0.get(r3), com.tom_roush.fontbox.a.e.class, "com.obric.memorydata.plugin");
    }

    public static Set<String> a() {
        return Collections.unmodifiableSet(f16221a.keySet());
    }

    private static void a(String r1, String r2) {
        f16221a.put(r1, r2);
    }

    public static boolean b(String r1) {
        return f16221a.containsKey(r1);
    }

    public static String c(String r2) {
        return (String) ZeusTransformUtils.preCheckCast(f16221a.get(r2), String.class, "com.obric.memorydata.plugin");
    }

    private static void d(String r4) {
        String r0 = "com/tom_roush/pdfbox/resources/afm/" + r4 + ".afm";
        if (com.tom_roush.pdfbox.android.a.a() == false) goto L5;
        InputStream r1 = com.tom_roush.pdfbox.android.a.a(r0);
    L6:
        if (r1 == null) goto L15;
        BufferedInputStream r2 = new BufferedInputStream(r1);
        f16222b.put(r4, new com.tom_roush.fontbox.a.a(r2).a(true));     // Catch: Throwable -> L11
        r2.close();
        return;
    L11:
        th = move-exception;
        r2.close();
        throw th;
    L15:
        throw new IOException("resource '" + r0 + "' not found");
    L5:
        r1 = aa.class.getResourceAsStream("/" + r0);
        goto L6
    }

    private static void e(String r1) {
        f16221a.put(r1, r1);
    }
}
