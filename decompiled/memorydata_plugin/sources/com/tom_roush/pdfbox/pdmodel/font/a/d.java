package com.tom_roush.pdfbox.pdmodel.font.a;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d f16217a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d f16218b = null;
    private final Map<String, String> c;
    private final Map<String, String> d;
    private final Map<String, String> e;

    static {
        f16217a = a("glyphlist.txt", 4281);
        f16218b = a("zapfdingbats.txt", 201);
        if (System.getProperty("glyphlist_ext") != null) goto L7;
        return;
    L7:
        throw new UnsupportedOperationException("glyphlist_ext is no longer supported, use GlyphList.DEFAULT.addGlyphs(Properties) instead");     // Catch: SecurityException -> L9
    }

    public d(d r3, InputStream r4) {
        this.e = new ConcurrentHashMap();
        this.c = new HashMap(r3.c);
        this.d = new HashMap(r3.d);
        a(r4);
    }

    public d(InputStream r2, int r3) {
        this.e = new ConcurrentHashMap();
        this.c = new HashMap(r3);
        this.d = new HashMap(r3);
        a(r2);
    }

    public static d a() {
        return f16217a;
    }

    private static d a(String r4, int r5) {
        String r6 = "com/tom_roush/pdfbox/resources/glyphlist/" + r4;
    L13:
        th = move-exception;
        com.tom_roush.pdfbox.io.a.a(null);
        throw th;
    L15:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L13
    L4:
        if (com.tom_roush.pdfbox.android.a.a() == false) goto L6;
        InputStream r0 = com.tom_roush.pdfbox.android.a.a(r6);     // Catch: Throwable -> L13 IOException -> L15
    L7:
        if (r0 == null) goto L12;
        d r7 = new d(r0, r5);     // Catch: Throwable -> L13 IOException -> L15
        com.tom_roush.pdfbox.io.a.a(r0);
        return r7;
    L12:
        throw new IOException("GlyphList '" + r6 + "' not found");     // Catch: Throwable -> L13 IOException -> L15
    L6:
        r0 = d.class.getResourceAsStream("/" + r6);     // Catch: Throwable -> L13 IOException -> L15
        goto L7
    }

    private void a(InputStream r14) {
        BufferedReader r1 = new BufferedReader(new InputStreamReader(r14, "ISO-8859-1"));
    L39:
    L36:
        th = move-exception;
        r1.close();
        throw th;
    L4:
        if (r1.ready() == false) goto L34;
        String r15 = r1.readLine();     // Catch: Throwable -> L36
        if (r15 == null) goto L39;
        if (r15.startsWith("#") == true) goto L39;
        String[] r2 = r15.split(";");     // Catch: Throwable -> L36
        if (r2.length < 2) goto L33;
        boolean r16 = false;
        String r3 = r2[0];     // Catch: Throwable -> L36
        String[] r5 = r2[1].split(" ");     // Catch: Throwable -> L36
        if (this.c.containsKey(r3) == false) goto L14;
        Log.w("PdfBox-Android", "duplicate value for " + r3 + " -> " + r2[1] + " " + ((String) ZeusTransformUtils.preCheckCast(this.c.get(r3), String.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L36
    L14:
        int r4 = r5.length;     // Catch: Throwable -> L36
        int[] r6 = new int[r4];     // Catch: Throwable -> L36
        int r7 = r5.length;     // Catch: Throwable -> L36
        int r8 = 0;
        int r9 = 0;
    L15:
        if (r8 >= r7) goto L17;
        r6[r9] = Integer.parseInt(r5[r8], 16);     // Catch: Throwable -> L36
        r8 = r8 + 1;     // Catch: Throwable -> L36
        r9 = r9 + 1;     // Catch: Throwable -> L36
        goto L15
    L17:
        String r10 = new String(r6, 0, r4);     // Catch: Throwable -> L36
        this.c.put(r3, r10);     // Catch: Throwable -> L36
        if (k.c.a(r3) == false) goto L20;
    L27:
        r16 = true;
    L29:
        if (this.d.containsKey(r10) == false) goto L31;
        if (r16 == false) goto L39;
    L31:
        this.d.put(r10, r3);     // Catch: Throwable -> L36
        goto L39
    L20:
        if (g.d.a(r3) == true) goto L27;
        if (e.c.a(r3) == true) goto L27;
        if (i.c.a(r3) == true) goto L27;
        if (l.c.a(r3) == false) goto L29;
    L33:
        throw new IOException("Invalid glyph list entry: " + r15);     // Catch: Throwable -> L36
    L34:
        r1.close();
    }

    public static d b() {
        return f16218b;
    }

    public String a(String r12) {
        if (r12 != null) goto L5;
        return null;
    L5:
        String r0 = (String) ZeusTransformUtils.preCheckCast(this.c.get(r12), String.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        return r0;
    L8:
        String r1 = (String) ZeusTransformUtils.preCheckCast(this.e.get(r12), String.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
    L44:
        return r1;
    L11:
        if (r12.indexOf(46) <= 0) goto L14;
        r1 = a(r12.substring(0, r12.indexOf(46)));
    L42:
        if (r1 == null) goto L44;
        this.e.put(r12, r1);
        goto L44
    L14:
        if (r12.startsWith("uni") == false) goto L31;
        if (r12.length() != 7) goto L31;
        int r2 = r12.length();
        StringBuilder r8 = new StringBuilder();
        int r9 = 3;
    L18:
        int r10 = r9 + 4;
        if (r10 > r2) goto L26;
        int r11 = Integer.parseInt(r12.substring(r9, r10), 16);     // Catch: NumberFormatException -> L28
        if (r11 <= 55295) goto L24;
        if (r11 >= 57344) goto L24;
        Log.w("PdfBox-Android", "Unicode character name with disallowed code area: " + r12);     // Catch: NumberFormatException -> L28
    L25:
        r9 = r10;
    L24:
        r8.append((char) r11);     // Catch: NumberFormatException -> L28
    L28:
        StringBuilder r3 = new StringBuilder();
    L29:
        Log.w("PdfBox-Android", r3.append("Not a number in Unicode character name: ").append(r12).toString());
        goto L42
    L26:
        r1 = r8.toString();     // Catch: NumberFormatException -> L28
    L31:
        if (r12.startsWith("u") == false) goto L42;
        if (r12.length() != 5) goto L42;
        int r4 = Integer.parseInt(r12.substring(1), 16);     // Catch: NumberFormatException -> L41
        if (r4 <= 55295) goto L39;
        if (r4 >= 57344) goto L39;
        Log.w("PdfBox-Android", "Unicode character name with disallowed code area: " + r12);     // Catch: NumberFormatException -> L41
    L47:
    L39:
        r1 = String.valueOf((char) r4);     // Catch: NumberFormatException -> L41
    L41:
        r3 = new StringBuilder();
        goto L29
    }
}
