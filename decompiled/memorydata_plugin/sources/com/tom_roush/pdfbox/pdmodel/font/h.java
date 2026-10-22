package com.tom_roush.pdfbox.pdmodel.font;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import com.tom_roush.fontbox.f.ah;
import com.tom_roush.pdfbox.android.PDFBoxConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes6.dex */
final class h implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final e f16234a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private k f16235b;
    private Map<String, f> c;
    private final ah d;
    private final Map<String, List<String>> e;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final k f16236a = null;

        static {
            f16236a = new d(h.b());
        }

        static /* synthetic */ k a() {
            return f16236a;
        }
    }

    private static class b implements Comparable<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        double f16237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final f f16238b;

        b(f r1) {
            this.f16238b = r1;
        }

        public int a(b r3) {
            return Double.compare(r3.f16237a, this.f16237a);
        }

        @Override // java.lang.Comparable
        public /* synthetic */ int compareTo(b r3) {
            return a((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f16234a = new e();
    }

    h() {
        this.e = new HashMap();
        a("Courier", new ArrayList(Arrays.asList(new String[]{"CourierNew", "CourierNewPSMT", "LiberationMono", "NimbusMonL-Regu", "DroidSansMono"})));
        a("Courier-Bold", new ArrayList(Arrays.asList(new String[]{"CourierNewPS-BoldMT", "CourierNew-Bold", "LiberationMono-Bold", "NimbusMonL-Bold", "DroidSansMono"})));
        a("Courier-Oblique", new ArrayList(Arrays.asList(new String[]{"CourierNewPS-ItalicMT", "CourierNew-Italic", "LiberationMono-Italic", "NimbusMonL-ReguObli", "DroidSansMono"})));
        a("Courier-BoldOblique", new ArrayList(Arrays.asList(new String[]{"CourierNewPS-BoldItalicMT", "CourierNew-BoldItalic", "LiberationMono-BoldItalic", "NimbusMonL-BoldObli", "DroidSansMono"})));
        a("Helvetica", new ArrayList(Arrays.asList(new String[]{"ArialMT", "Arial", "LiberationSans", "NimbusSanL-Regu", "Roboto-Regular"})));
        a("Helvetica-Bold", new ArrayList(Arrays.asList(new String[]{"Arial-BoldMT", "Arial-Bold", "LiberationSans-Bold", "NimbusSanL-Bold", "Roboto-Bold"})));
        a("Helvetica-Oblique", new ArrayList(Arrays.asList(new String[]{"Arial-ItalicMT", "Arial-Italic", "Helvetica-Italic", "LiberationSans-Italic", "NimbusSanL-ReguItal", "Roboto-Italic"})));
        a("Helvetica-BoldOblique", new ArrayList(Arrays.asList(new String[]{"Arial-BoldItalicMT", "Helvetica-BoldItalic", "LiberationSans-BoldItalic", "NimbusSanL-BoldItal", "Roboto-BoldItalic"})));
        a("Times-Roman", new ArrayList(Arrays.asList(new String[]{"TimesNewRomanPSMT", "TimesNewRoman", "TimesNewRomanPS", "LiberationSerif", "NimbusRomNo9L-Regu", "Roboto-Regular"})));
        a("Times-Bold", new ArrayList(Arrays.asList(new String[]{"TimesNewRomanPS-BoldMT", "TimesNewRomanPS-Bold", "TimesNewRoman-Bold", "LiberationSerif-Bold", "NimbusRomNo9L-Medi", "DroidSerif-Bold", "Roboto-Bold"})));
        a("Times-Italic", new ArrayList(Arrays.asList(new String[]{"TimesNewRomanPS-ItalicMT", "TimesNewRomanPS-Italic", "TimesNewRoman-Italic", "LiberationSerif-Italic", "NimbusRomNo9L-ReguItal", "DroidSerif-Italic", "Roboto-Italic"})));
        a("Times-BoldItalic", new ArrayList(Arrays.asList(new String[]{"TimesNewRomanPS-BoldItalicMT", "TimesNewRomanPS-BoldItalic", "TimesNewRoman-BoldItalic", "LiberationSerif-BoldItalic", "NimbusRomNo9L-MediItal", "DroidSerif-BoldItalic", "Roboto-BoldItalic"})));
        a("Symbol", new ArrayList(Arrays.asList(new String[]{"Symbol", "SymbolMT", "StandardSymL"})));
        a("ZapfDingbats", new ArrayList(Arrays.asList(new String[]{"ZapfDingbatsITCbyBT-Regular", "ZapfDingbatsITC", "Dingbats", "MS-Gothic"})));
        Iterator<String> r0 = ae.a().iterator();
    L4:
        if (r0.hasNext() == false) goto L20;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        if (c(r1).isEmpty() == false) goto L4;
        a(r1, b(ae.c(r1).toLowerCase(Locale.ENGLISH)));
        goto L4
    L20:
    L17:
        e = move-exception;
        throw new RuntimeException(e);
    L9:
        if (com.tom_roush.pdfbox.android.a.a() == false) goto L11;
        InputStream r2 = com.tom_roush.pdfbox.android.a.a("com/tom_roush/pdfbox/resources/ttf/LiberationSans-Regular.ttf");     // Catch: IOException -> L17
    L12:
        if (r2 == null) goto L16;
        this.d = new com.tom_roush.fontbox.f.ae().b(new BufferedInputStream(r2));     // Catch: IOException -> L17
        return;
    L16:
        throw new IOException("resource 'com/tom_roush/pdfbox/resources/ttf/LiberationSans-Regular.ttf' not found");     // Catch: IOException -> L17
    L11:
        r2 = g.class.getResourceAsStream("/com/tom_roush/pdfbox/resources/ttf/LiberationSans-Regular.ttf");     // Catch: IOException -> L17
        goto L12
    }

    private com.tom_roush.fontbox.b a(FontFormat r7, String r8) {
        if (r8 != null) goto L6;
        return null;
    L6:
        if (this.f16235b != null) goto L8;
        a();
    L8:
        f r1 = b(r7, r8);
        if (r1 != null) goto L11;
        f r2 = b(r7, r8.replace("-", ""));
        if (r2 != null) goto L15;
        Iterator<String> r3 = c(r8).iterator();
    L18:
        if (r3.hasNext() == false) goto L23;
        f r4 = b(r7, (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin"));
        if (r4 == null) goto L18;
        return r4.d();
    L23:
        f r5 = b(r7, r8.replace(",", "-"));
        if (r5 != null) goto L26;
        f r6 = b(r7, r8 + "-Regular");
        if (r6 != null) goto L30;
        return null;
    L30:
        return r6.d();
    L26:
        return r5.d();
    L15:
        return r2.d();
    L11:
        return r1.d();
    }

    private String a(q r6) {
        if (r6 == null) goto L52;
        boolean r0 = false;
        if (r6.g() == null) goto L13;
        String r5 = r6.g().toLowerCase();
        if (r5.contains("bold") == false) goto L8;
    L11:
        r0 = true;
        goto L13
    L8:
        if (r5.contains("black") == true) goto L11;
        if (r5.contains("heavy") == true) goto L11;
    L13:
        if (r6.a() == false) goto L29;
        String r7 = "Courier";
        if (r0 == true) goto L17;
    L20:
        if (r0 == false) goto L25;
        StringBuilder r8 = new StringBuilder();
    L22:
        StringBuilder r9 = r8.append(r7).append("-Bold");
    L54:
        return r9.toString();
    L25:
        if (r6.d() == false) goto L55;
        StringBuilder r10 = new StringBuilder();
    L27:
        r9 = r10.append(r7).append("-Oblique");
        goto L54
    L55:
        return "Courier";
    L17:
        if (r6.d() == false) goto L20;
        StringBuilder r11 = new StringBuilder();
    L19:
        r9 = r11.append(r7).append("-BoldOblique");
        goto L54
    L29:
        if (r6.b() == false) goto L42;
        r7 = "Times";
        if (r0 == true) goto L33;
    L36:
        if (r0 == false) goto L39;
        r8 = new StringBuilder();
        goto L22
    L39:
        if (r6.d() == false) goto L41;
        StringBuilder r12 = new StringBuilder().append("Times");
        String r13 = "-Italic";
    L35:
        r9 = r12.append(r13);
        goto L54
    L41:
        r12 = new StringBuilder().append("Times");
        r13 = "-Roman";
        goto L35
    L33:
        if (r6.d() == false) goto L36;
        r12 = new StringBuilder().append("Times");
        r13 = "-BoldItalic";
        goto L35
    L42:
        r7 = "Helvetica";
        if (r0 == true) goto L45;
    L47:
        if (r0 == false) goto L50;
        r8 = new StringBuilder();
        goto L22
    L50:
        if (r6.d() == false) goto L56;
        r10 = new StringBuilder();
        goto L27
    L56:
        return "Helvetica";
    L45:
        if (r6.d() == false) goto L47;
        r11 = new StringBuilder();
        goto L19
    L52:
        return "Times-Roman";
    }

    private Map<String, f> a(List<? extends f> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L9;
        f r2 = (f) ZeusTransformUtils.preCheckCast(r9.next(), f.class, "com.obric.memorydata.plugin");
        Iterator<String> r3 = a(r2.a()).iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        r0.put(((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin")).toLowerCase(Locale.ENGLISH), r2);
        goto L7
    L9:
        return r0;
    }

    private PriorityQueue<b> a(q r17, o r18) {
        PriorityQueue<b> r2 = new PriorityQueue(20);
        Iterator<f> r3 = this.c.values().iterator();
    L4:
        if (r3.hasNext() == false) goto L71;
        f r4 = (f) ZeusTransformUtils.preCheckCast(r3.next(), f.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L10;
        if (a(r18, r4) == false) goto L4;
    L10:
        b r5 = new b(r4);
        if (r17.s() == null) goto L64;
        if (r4.j() == null) goto L64;
        v r6 = r17.s().a();
        if (r6.a() != r4.j().a()) goto L70;
        if (r6.a() != 0) goto L26;
        if (r4.a().toLowerCase().contains("barcode") == true) goto L23;
        if (r4.a().startsWith(com.tom_roush.pdfbox.pdmodel.a.d.i.K) == false) goto L26;
    L23:
        if (b(r17) == false) goto L4;
    L26:
        if (r6.b() != r4.j().b()) goto L30;
        double r11 = r5.f16237a + 2.0d;
    L28:
        r5.f16237a = r11;
    L53:
        int r7 = r4.j().c();
        int r8 = r4.k();
        if (Math.abs(r7 - r8) <= 2) goto L57;
        r7 = r8;
    L57:
        if (r6.c() != r7) goto L60;
        double r9 = r5.f16237a + 2.0d;
    L69:
        r5.f16237a = r9;
        goto L70
    L60:
        if (r6.c() <= 1) goto L70;
        if (r7 <= 1) goto L70;
        float r10 = Math.abs(r6.c() - r7);
        double r12 = r5.f16237a;
    L68:
        r9 = r12 + (1.0d - (((double) r10) * 0.5d));
        goto L69
    L30:
        if (r6.b() < 2) goto L39;
        if (r6.b() > 5) goto L39;
        if (r4.j().b() < 2) goto L39;
        if (r4.j().b() > 5) goto L39;
        r11 = r5.f16237a + 1.0d;
    L39:
        if (r6.b() < 11) goto L48;
        if (r6.b() > 13) goto L48;
        if (r4.j().b() < 11) goto L48;
        if (r4.j().b() > 13) goto L48;
        double r13 = r5.f16237a + 1.0d;
    L52:
        r5.f16237a = r13;
    L48:
        if (r6.b() == 0) goto L53;
        if (r4.j().b() == 0) goto L53;
        r13 = r5.f16237a - 1.0d;
    L70:
        r2.add(r5);
    L64:
        if (r17.i() <= 0.0f) goto L70;
        if (r4.f() <= 0) goto L70;
        float r14 = Math.abs(r17.i() - r4.f());
        r12 = r5.f16237a;
        r10 = r14 / 100.0f;
        goto L68
    L71:
        return r2;
    }

    private Set<String> a(String r3) {
        HashSet r2 = new HashSet(2);
        r2.add(r3);
        r2.add(r3.replace("-", ""));
        return r2;
    }

    private void a(String r3, List<String> r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.e.put(r3.toLowerCase(Locale.ENGLISH), r5);
    }

    private boolean a(o r18, f r19) {
        if (r19.c() != null) goto L5;
        long r3 = r19.l();
        if ("MalgunGothic-Semilight".equals(r19.a()) == false) goto L14;
        r3 = r3 & (-1441793);
    L14:
        if (r18.b().equals("GB1") == false) goto L19;
        if ((r3 & PlaybackStateCompat.ACTION_SET_REPEAT_MODE) != PlaybackStateCompat.ACTION_SET_REPEAT_MODE) goto L19;
        return true;
    L19:
        if (r18.b().equals("CNS1") == false) goto L24;
        if ((r3 & 1048576) != 1048576) goto L24;
        return true;
    L24:
        if (r18.b().equals("Japan1") == false) goto L29;
        if ((r3 & PlaybackStateCompat.ACTION_PREPARE_FROM_URI) != PlaybackStateCompat.ACTION_PREPARE_FROM_URI) goto L29;
        return true;
    L29:
        if (r18.b().equals("Korea1") == true) goto L31;
        return false;
    L31:
        if ((r3 & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) == PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) goto L35;
        if ((r3 & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) == PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) goto L35;
        return false;
    L35:
        return true;
    L5:
        if (r19.c().a().equals(r18.a()) == true) goto L7;
        return false;
    L7:
        if (r19.c().b().equals(r18.b()) == true) goto L9;
        return false;
    L9:
        return true;
    }

    static /* synthetic */ e b() {
        return f16234a;
    }

    private f b(FontFormat r4, String r5) {
        if (r5.contains(Marker.ANY_NON_NULL_MARKER) == false) goto L5;
        r5 = r5.substring(r5.indexOf(43) + 1);
    L5:
        f r3 = (f) ZeusTransformUtils.preCheckCast(this.c.get(r5.toLowerCase(Locale.ENGLISH)), f.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L8;
        return null;
    L8:
        if (r3.b() == r4) goto L10;
        return null;
    L10:
        if (PDFBoxConfig.b() == false) goto L12;
        Log.d("PdfBox-Android", String.format("getFont('%s','%s') returns %s", new Object[]{r4, r5, r3}));
    L12:
        return r3;
    }

    private List<String> b(String r3) {
        return new ArrayList((Collection) ZeusTransformUtils.preCheckCast(this.e.get(r3), Collection.class, "com.obric.memorydata.plugin"));
    }

    private boolean b(q r3) {
        String r2 = r3.h();
        String r0 = "";
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        String r4 = r3.g();
        if (r4 == null) goto L10;
        r0 = r4;
    L10:
        if (r2.startsWith(com.tom_roush.pdfbox.pdmodel.a.d.i.K) == false) goto L12;
    L19:
        return true;
    L12:
        if (r2.toLowerCase().contains("barcode") == true) goto L19;
        if (r0.startsWith(com.tom_roush.pdfbox.pdmodel.a.d.i.K) == true) goto L19;
        if (r0.toLowerCase().contains("barcode") == true) goto L19;
        return false;
    }

    private List<String> c(String r3) {
        List<String> r2 = (List) ZeusTransformUtils.preCheckCast(this.e.get(r3.replace(" ", "").toLowerCase(Locale.ENGLISH)), List.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        return r2;
    L6:
        return Collections.emptyList();
    }

    private com.tom_roush.fontbox.b d(String r4) {
        com.tom_roush.fontbox.type1.b r0 = (com.tom_roush.fontbox.type1.b) ZeusTransformUtils.preCheckCast(a(FontFormat.PFB, r4), com.tom_roush.fontbox.type1.b.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        ah r1 = (ah) ZeusTransformUtils.preCheckCast(a(FontFormat.TTF, r4), ah.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L8;
        return r1;
    L8:
        com.tom_roush.fontbox.f.x r3 = (com.tom_roush.fontbox.f.x) ZeusTransformUtils.preCheckCast(a(FontFormat.OTF, r4), com.tom_roush.fontbox.f.x.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        return r3;
    L11:
        return null;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.g
    public com.tom_roush.pdfbox.pdmodel.font.a a(String r6, q r7, o r8) {
        com.tom_roush.fontbox.f.x r0 = (com.tom_roush.fontbox.f.x) ZeusTransformUtils.preCheckCast(a(FontFormat.OTF, r6), com.tom_roush.fontbox.f.x.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        ah r1 = (ah) ZeusTransformUtils.preCheckCast(a(FontFormat.TTF, r6), ah.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        return new com.tom_roush.pdfbox.pdmodel.font.a(null, r1, false);
    L11:
        if (r8 == null) goto L33;
        String r2 = r8.a() + "-" + r8.b();
        if (r2.equals("Adobe-GB1") == false) goto L15;
    L20:
        b r9 = (b) ZeusTransformUtils.preCheckCast(a(r7, r8).poll(), b.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L33;
        if (PDFBoxConfig.b() == false) goto L25;
        Log.d("PdfBox-Android", "Best match for '" + r6 + "': " + r9.f16238b);
    L25:
        com.tom_roush.fontbox.b r10 = r9.f16238b.d();
        if (ZeusTransformUtils.instanceOf(r10, com.tom_roush.fontbox.f.x.class) == true) goto L28;
        if (r10 == null) goto L33;
        return new com.tom_roush.pdfbox.pdmodel.font.a(null, r10, true);
    L28:
        return new com.tom_roush.pdfbox.pdmodel.font.a((com.tom_roush.fontbox.f.x) ZeusTransformUtils.preCheckCast(r10, com.tom_roush.fontbox.f.x.class, "com.obric.memorydata.plugin"), null, true);
    L15:
        if (r2.equals("Adobe-CNS1") == true) goto L20;
        if (r2.equals("Adobe-Japan1") == true) goto L20;
        if (r2.equals("Adobe-Korea1") == true) goto L20;
    L33:
        return new com.tom_roush.pdfbox.pdmodel.font.a(null, this.d, true);
    L5:
        return new com.tom_roush.pdfbox.pdmodel.font.a(r0, null, false);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.g
    public j<ah> a(String r3, q r4) {
        ah r5 = (ah) ZeusTransformUtils.preCheckCast(a(FontFormat.TTF, r3), ah.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        String r6 = a(r4);
        ah r7 = (ah) ZeusTransformUtils.preCheckCast(a(FontFormat.TTF, r6), ah.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L10;
        r7 = this.d;
    L10:
        return new j(r7, true);
    L5:
        return new j(r5, false);
    }

    public synchronized k a() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f16235b != null) goto L6;
        a(a.a());     // Catch: Throwable -> L9
    L6:
        k r0 = this.f16235b;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public synchronized void a(k r2) {
        monitor-enter(this);
        this.c = a(r2.a());     // Catch: Throwable -> L6
        this.f16235b = r2;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.g
    public j<com.tom_roush.fontbox.b> b(String r1, q r2) {
        com.tom_roush.fontbox.b r3 = d(r1);
        if (r3 != null) goto L5;
        com.tom_roush.fontbox.b r4 = d(a(r2));
        if (r4 != null) goto L10;
        r4 = this.d;
    L10:
        return new j(r4, true);
    L5:
        return new j(r3, false);
    }
}
