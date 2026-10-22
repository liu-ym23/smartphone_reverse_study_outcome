package com.tom_roush.pdfbox.pdmodel.font;

import android.util.Log;
import com.tom_roush.fontbox.f.ah;
import com.tom_roush.pdfbox.android.PDFBoxConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
final class d extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a> f16226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f16227b;

    /* JADX INFO: renamed from: com.tom_roush.pdfbox.pdmodel.font.d$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f16230a = null;

        static {
            int[] r0 = new int[FontFormat.values().length];
            f16230a = r0;
            r0[FontFormat.PFB.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f16230a[FontFormat.TTF.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f16230a[FontFormat.OTF.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    private static class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f16231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final FontFormat f16232b;
        private final com.tom_roush.pdfbox.pdmodel.font.b c;
        private final int d;
        private final int e;
        private final int f;
        private final int g;
        private final int h;
        private final v i;
        private final File j;
        private final d k;

        private a(File r1, FontFormat r2, String r3, com.tom_roush.pdfbox.pdmodel.font.b r4, int r5, int r6, int r7, int r8, int r9, byte[] r10, d r11) {
            this.j = r1;
            this.f16232b = r2;
            this.f16231a = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            if (r10 != null) goto L5;
        L7:
            v r12 = null;
        L8:
            this.i = r12;
            this.k = r11;
            return;
        L5:
            if (r10.length < 10) goto L7;
            r12 = new v(r10);
            goto L8
        }

        /* synthetic */ a(File r1, FontFormat r2, String r3, com.tom_roush.pdfbox.pdmodel.font.b r4, int r5, int r6, int r7, int r8, int r9, byte[] r10, d r11, AnonymousClass1 r12) {
            this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        }

        private ah a(String r4, File r5) {
            ah r3 = b(r4, r5);     // Catch: IOException -> L7
            if (PDFBoxConfig.b() == false) goto L6;
            Log.d("PdfBox-Android", "Loaded " + r4 + " from " + r5);     // Catch: IOException -> L7
        L6:
            return r3;
        L7:
            e = move-exception;
            Log.w("PdfBox-Android", "Could not load font file: " + r5, e);
            return null;
        }

        static /* synthetic */ String a(a r0) {
            return r0.f16231a;
        }

        private ah b(String r3, File r4) {
            if (r4.getName().toLowerCase().endsWith(".ttc") == false) goto L14;
            com.tom_roush.fontbox.f.ag r2 = new com.tom_roush.fontbox.f.ag(r4);
            ah r0 = r2.a(r3);     // Catch: IOException -> L10
            if (r0 == null) goto L8;
            return r0;
        L8:
            r2.close();
            throw new IOException("Font " + r3 + " not found in " + r4);
        L10:
            e = move-exception;
            r2.close();
            throw e;
        L14:
            return new com.tom_roush.fontbox.f.ae(false, true).b(r4);
        }

        static /* synthetic */ FontFormat b(a r0) {
            return r0.f16232b;
        }

        private com.tom_roush.fontbox.f.x c(String r5, File r6) {
        L19:
            e = move-exception;
            Log.w("PdfBox-Android", "Could not load font file: " + r6, e);
            return null;
        L4:
            if (r6.getName().toLowerCase().endsWith(".ttc") == false) goto L15;
            com.tom_roush.fontbox.f.ag r1 = new com.tom_roush.fontbox.f.ag(r6);     // Catch: IOException -> L19
            ah r2 = r1.a(r5);     // Catch: IOException -> L12
            if (r2 != null) goto L9;
            r1.close();     // Catch: IOException -> L19
            throw new IOException("Font " + r5 + " not found in " + r6);     // Catch: IOException -> L19
        L9:
            return (com.tom_roush.fontbox.f.x) ZeusTransformUtils.preCheckCast(r2, com.tom_roush.fontbox.f.x.class, "com.obric.memorydata.plugin");
        L12:
            e = move-exception;
            Log.e("PdfBox-Android", e.getMessage(), e);     // Catch: IOException -> L19
            r1.close();     // Catch: IOException -> L19
            return null;
        L15:
            com.tom_roush.fontbox.f.x r3 = new com.tom_roush.fontbox.f.v(false, true).a(r6);     // Catch: IOException -> L19
            if (PDFBoxConfig.b() == false) goto L18;
            Log.d("PdfBox-Android", "Loaded " + r5 + " from " + r6);     // Catch: IOException -> L19
        L18:
            return r3;
        }

        static /* synthetic */ com.tom_roush.pdfbox.pdmodel.font.b c(a r0) {
            return r0.c;
        }

        static /* synthetic */ int d(a r0) {
            return r0.d;
        }

        private com.tom_roush.fontbox.type1.b d(String r6, File r7) {
            FileInputStream r0 = null;
            FileInputStream r1 = new FileInputStream(r7);     // Catch: Throwable -> L13 IOException -> L15
            com.tom_roush.fontbox.type1.b r2 = com.tom_roush.fontbox.type1.b.a(r1);     // Catch: Throwable -> L9 IOException -> L11
            if (PDFBoxConfig.b() == false) goto L7;
            Log.d("PdfBox-Android", "Loaded " + r6 + " from " + r7);     // Catch: Throwable -> L9 IOException -> L11
        L7:
            com.tom_roush.pdfbox.io.a.a(r1);
            return r2;
        L11:
            e = e;
        L17:
            Log.w("PdfBox-Android", "Could not load font file: " + r7, e);     // Catch: Throwable -> L9
            com.tom_roush.pdfbox.io.a.a(r1);
            return null;
        L9:
            th = th;
            r0 = r1;
        L20:
            com.tom_roush.pdfbox.io.a.a(r0);
            throw th;
        L15:
            e = e;
            r1 = null;
        L13:
            th = th;
            goto L20
        }

        static /* synthetic */ int e(a r0) {
            return r0.e;
        }

        static /* synthetic */ int f(a r0) {
            return r0.f;
        }

        static /* synthetic */ int g(a r0) {
            return r0.g;
        }

        static /* synthetic */ int h(a r0) {
            return r0.h;
        }

        static /* synthetic */ v i(a r0) {
            return r0.i;
        }

        static /* synthetic */ File j(a r0) {
            return r0.j;
        }

        @Override // com.tom_roush.pdfbox.pdmodel.font.f
        public String a() {
            return this.f16231a;
        }

        @Override // com.tom_roush.pdfbox.pdmodel.font.f
        public FontFormat b() {
            return this.f16232b;
        }

        @Override // com.tom_roush.pdfbox.pdmodel.font.f
        public com.tom_roush.pdfbox.pdmodel.font.b c() {
            return this.c;
        }

        @Override // com.tom_roush.pdfbox.pdmodel.font.f
        public synchronized com.tom_roush.fontbox.b d() {
            monitor-enter(this);
            com.tom_roush.fontbox.b r0 = d.a(this.k).a(this);     // Catch: Throwable -> L22
            if (r0 == null) goto L7;
            monitor-exit(this);
            return r0;
        L7:
            int r1 = AnonymousClass2.f16230a[this.f16232b.ordinal()];     // Catch: Throwable -> L22
            if (r1 != 1) goto L10;
            com.tom_roush.fontbox.b r2 = d(this.f16231a, this.j);     // Catch: Throwable -> L22
        L18:
            if (r2 == null) goto L20;
            d.a(this.k).a(this, r2);     // Catch: Throwable -> L22
        L20:
            monitor-exit(this);
            return r2;
        L10:
            if (r1 != 2) goto L12;
            r2 = a(this.f16231a, this.j);     // Catch: Throwable -> L22
            goto L18
        L12:
            if (r1 != 3) goto L15;
            r2 = c(this.f16231a, this.j);     // Catch: Throwable -> L22
            goto L18
        L15:
            throw new RuntimeException("can't happen");     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            throw th;
        }

        @Override // com.tom_roush.pdfbox.pdmodel.font.f
        public int e() {
            return this.e;
        }

        @Override // com.tom_roush.pdfbox.pdmodel.font.f
        public int f() {
            return this.d;
        }

        @Override // com.tom_roush.pdfbox.pdmodel.font.f
        public int g() {
            return this.f;
        }

        @Override // com.tom_roush.pdfbox.pdmodel.font.f
        public int h() {
            return this.g;
        }

        @Override // com.tom_roush.pdfbox.pdmodel.font.f
        public int i() {
            return this.h;
        }

        @Override // com.tom_roush.pdfbox.pdmodel.font.f
        public v j() {
            return this.i;
        }

        @Override // com.tom_roush.pdfbox.pdmodel.font.f
        public String toString() {
            return super.toString() + " " + this.j;
        }
    }

    private static final class b extends a {
        private b(File r14, FontFormat r15, String r16) {
            super(r14, r15, r16, null, 0, 0, 0, 0, 0, null, null, null);
        }

        /* synthetic */ b(File r1, FontFormat r2, String r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }
    }

    d(e r6) {
        this.f16226a = new ArrayList();
        this.f16227b = r6;
        if (PDFBoxConfig.a() != PDFBoxConfig.FontLoadLevel.NONE) goto L6;
        return;
    L6:
        if (PDFBoxConfig.a() == PDFBoxConfig.FontLoadLevel.MINIMUM) goto L34;
    L33:
    L30:
        e = move-exception;
        Log.e("PdfBox-Android", "Error accessing the file system", e);
        return;
    L12:
        if (PDFBoxConfig.b() == false) goto L14;
        Log.d("PdfBox-Android", "Will search the local system for fonts");     // Catch: AccessControlException -> L30
    L14:
        List<URI> r7 = new com.tom_roush.fontbox.g.a.c().a();     // Catch: AccessControlException -> L30
        ArrayList r1 = new ArrayList(r7.size());     // Catch: AccessControlException -> L30
        Iterator<URI> r8 = r7.iterator();     // Catch: AccessControlException -> L30
    L16:
        if (r8.hasNext() == false) goto L19;
        r1.add(new File((URI) ZeusTransformUtils.preCheckCast(r8.next(), URI.class, "com.obric.memorydata.plugin")));     // Catch: AccessControlException -> L30
        goto L16
    L19:
        if (PDFBoxConfig.b() == false) goto L22;
        Log.d("PdfBox-Android", "Found " + r1.size() + " fonts on the local system");     // Catch: AccessControlException -> L30
    L22:
        if (r1.isEmpty() == true) goto L37;
        List<a> r9 = b(r1);     // Catch: AccessControlException -> L30
        if (r9 != null) goto L26;
    L28:
        Log.w("PdfBox-Android", "Building on-disk font cache, this may take a while");     // Catch: AccessControlException -> L30
        a(r1);     // Catch: AccessControlException -> L30
        c();     // Catch: AccessControlException -> L30
        Log.w("PdfBox-Android", "Finished building on-disk font cache, found " + this.f16226a.size() + " fonts");     // Catch: AccessControlException -> L30
        return;
    L26:
        if (r9.isEmpty() == true) goto L28;
        this.f16226a.addAll(r9);     // Catch: AccessControlException -> L30
        return;
    L37:
        return;
    L34:
        b(new File("/system/fonts/DroidSans.ttf"));     // Catch: IOException -> L9
        b(new File("/system/fonts/DroidSans-Bold.ttf"));     // Catch: IOException -> L9
        b(new File("/system/fonts/DroidSansMono.ttf"));     // Catch: IOException -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L33
    }

    static /* synthetic */ e a(d r0) {
        return r0.f16227b;
    }

    /* JADX WARN: Not initialized variable reg: 23, insn: 0x0182: MOVE (r1 I:??[OBJECT, ARRAY]) = (r23 I:??[OBJECT, ARRAY]), block:B:43:0x017f */
    private void a(ah r25, File r26) {
        String r12 = "PdfBox-Android";
        AnonymousClass1 r11 = null;
    L73:
        e = e;
        r26 = r26;
    L75:
        d r2 = this;
    L76:
        r2.f16226a.add(new b(r26, FontFormat.TTF, "*skipexception*", r11));     // Catch: Throwable -> L71
        Log.w(r12, "Could not load font file: " + r26, e);     // Catch: Throwable -> L71
    L77:
        r25.close();
        return;
    L71:
        th = move-exception;
        r25.close();
        throw th;
    L4:
        if (r25.b() == null) goto L9;
        if (r25.b().contains("|") == false) goto L9;
        this.f16226a.add(new b(r26, FontFormat.TTF, "*skippipeinname*", r11));     // Catch: Throwable -> L71 IOException -> L73
        Log.w("PdfBox-Android", "Skipping font with '|' in name " + r25.b() + " in file " + r26);     // Catch: Throwable -> L71 IOException -> L73
    L9:
        if (r25.b() != null) goto L93;
        r12 = "PdfBox-Android";
        r2 = this;
        r26 = r26;
        r11 = null;
        r2.f16226a.add(new b(r26, FontFormat.TTF, "*skipnoname*", r11));     // Catch: IOException -> L66 Throwable -> L71
        Log.w(r12, "Missing 'name' entry for PostScript name in font " + r26);     // Catch: IOException -> L66 Throwable -> L71
    L66:
        e = e;
    L68:
        e = e;
    L70:
        r11 = null;
        goto L76
    L93:
    L59:
        e = e;
        r12 = "PdfBox-Android";
        r2 = this;
        r26 = r26;
        r11 = null;
        goto L76
    L11:
        if (r25.m() != null) goto L15;
        this.f16226a.add(new b(r26, FontFormat.TTF, r25.b(), r11));     // Catch: Throwable -> L71 IOException -> L73
        r25.close();
        return;
    L15:
        int r10 = r25.m().b();     // Catch: IOException -> L59 Throwable -> L71
        com.tom_roush.fontbox.f.u r3 = r25.k();     // Catch: IOException -> L59 Throwable -> L71
        if (r3 == null) goto L20;
        int r4 = r3.c();     // Catch: Throwable -> L71 IOException -> L73
        int r5 = r3.e();     // Catch: Throwable -> L71 IOException -> L73
        int r6 = (int) r3.a();     // Catch: Throwable -> L71 IOException -> L73
        int r7 = (int) r3.b();     // Catch: Throwable -> L71 IOException -> L73
        byte[] r16 = r3.d();     // Catch: Throwable -> L71 IOException -> L73
        int r8 = r6;
        int r9 = r7;
        int r13 = r4;
        int r14 = r5;
    L21:
        if (ZeusTransformUtils.instanceOf(r25, com.tom_roush.fontbox.f.x.class) == true) goto L86;
    L37:
        String r23 = "PdfBox-Android";
    L56:
        e = e;
        r12 = r23;
    L58:
        r2 = this;
        goto L70
    L39:
        if (r25.h().containsKey("gcid") == false) goto L44;
        byte[] r1 = r25.b((com.tom_roush.fontbox.f.af) ZeusTransformUtils.preCheckCast(r25.h().get("gcid"), com.tom_roush.fontbox.f.af.class, "com.obric.memorydata.plugin"));     // Catch: IOException -> L42 Throwable -> L71
        String r15 = new String(r1, 10, 64, com.tom_roush.pdfbox.util.a.f16297a);     // Catch: IOException -> L42 Throwable -> L71
        String r17 = r15.substring(0, r15.indexOf(0));     // Catch: IOException -> L42 Throwable -> L71
        String r18 = new String(r1, 76, 64, com.tom_roush.pdfbox.util.a.f16297a);     // Catch: IOException -> L42 Throwable -> L71
        com.tom_roush.pdfbox.pdmodel.font.b r19 = new com.tom_roush.pdfbox.pdmodel.font.b(r17, r18.substring(0, r18.indexOf(0)), (r1[141(0x8d, float:1.98E-43)] & 255) & (r1[140(0x8c, float:1.96E-43)] << 8));     // Catch: IOException -> L42 Throwable -> L71
    L45:
        String r110 = "TTF";
        this.f16226a.add(new a(r26, FontFormat.TTF, r25.b(), r19, r14, r13, r8, r9, r10, r16, this, null));     // Catch: IOException -> L56 Throwable -> L71
    L46:
        String r20 = r110;
        if (PDFBoxConfig.b() == false) goto L77;
        com.tom_roush.fontbox.f.t r21 = r25.i();     // Catch: IOException -> L56 Throwable -> L71
        if (r21 == null) goto L77;
        String r0 = r20 + ": '" + r21.c() + "' / '" + r21.a() + "' / '" + r21.b() + "'";     // Catch: IOException -> L56 Throwable -> L71
        r12 = r23;
        Log.d(r12, r0);     // Catch: IOException -> L54 Throwable -> L71
    L54:
        e = e;
        goto L58
    L44:
        r19 = null;
        goto L45
    L86:
    L35:
        e = e;
        r26 = r26;
        goto L75
    L25:
        if (((com.tom_roush.fontbox.f.x) ZeusTransformUtils.preCheckCast(r25, com.tom_roush.fontbox.f.x.class, "com.obric.memorydata.plugin")).f() == false) goto L37;
        r110 = "OTF";
        com.tom_roush.fontbox.b.h r22 = ((com.tom_roush.fontbox.f.x) ZeusTransformUtils.preCheckCast(r25, com.tom_roush.fontbox.f.x.class, "com.obric.memorydata.plugin")).a().a();     // Catch: IOException -> L35 Throwable -> L71
        if (ZeusTransformUtils.instanceOf(r22, com.tom_roush.fontbox.b.a.class) == false) goto L30;
        com.tom_roush.fontbox.b.a r24 = (com.tom_roush.fontbox.b.a) ZeusTransformUtils.preCheckCast(r22, com.tom_roush.fontbox.b.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L71 IOException -> L73
        com.tom_roush.pdfbox.pdmodel.font.b r27 = new com.tom_roush.pdfbox.pdmodel.font.b(r24.a(), r24.e(), r24.f());     // Catch: Throwable -> L71 IOException -> L73
    L31:
        r23 = "PdfBox-Android";
        this.f16226a.add(new a(r26, FontFormat.OTF, r25.b(), r27, r14, r13, r8, r9, r10, r16, this, null));     // Catch: IOException -> L42 Throwable -> L71
        goto L46
    L30:
        r27 = null;
    L42:
        e = e;
        r2 = this;
        r12 = r23;
        goto L70
    L20:
        r14 = -1;
        r13 = -1;
        r8 = 0;
        r9 = 0;
        r16 = null;
        goto L21
    }

    static /* synthetic */ void a(d r0, ah r1, File r2) {
        r0.a(r1, r2);
    }

    private void a(final File r5) {
        com.tom_roush.fontbox.f.ag r0 = null;
        com.tom_roush.fontbox.f.ag r1 = new com.tom_roush.fontbox.f.ag(r5);     // Catch: Throwable -> L10 IOException -> L12
        r1.a(new AnonymousClass1(this, r5));     // Catch: Throwable -> L6 IOException -> L8
        r1.close();
        return;
    L8:
        e = e;
        r0 = r1;
    L13:
        Log.w("PdfBox-Android", "Could not load font file: " + r5, e);     // Catch: Throwable -> L10
        if (r0 == null) goto L26;
        r0.close();
        return;
    L26:
        return;
    L6:
        th = th;
        r0 = r1;
    L17:
        if (r0 == null) goto L19;
        r0.close();
    L19:
        throw th;
    L12:
        e = e;
    L10:
        th = th;
        goto L17
    }

    private void a(List<File> r6) {
        Iterator r7 = ((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L24;
        File r0 = (File) ZeusTransformUtils.preCheckCast(r7.next(), File.class, "com.obric.memorydata.plugin");
        String r2 = r0.getPath().toLowerCase();     // Catch: IOException -> L22
        if (r2.endsWith(".ttf") == true) goto L20;
        if (r2.endsWith(".otf") == true) goto L20;
        if (r2.endsWith(".ttc") == true) goto L19;
        if (r2.endsWith(".otc") == true) goto L19;
        if (r2.endsWith(".pfb") == false) goto L4;
        c(r0);     // Catch: IOException -> L22
    L19:
        a(r0);     // Catch: IOException -> L22
    L20:
        b(r0);     // Catch: IOException -> L22
    L22:
        e = move-exception;
        Log.w("PdfBox-Android", "Error parsing font " + r0.getPath(), e);
        goto L4
    }

    private static boolean a(String r1) {
        if (r1 != null) goto L4;
    L9:
        return true;
    L4:
        if (new File(r1).isDirectory() == false) goto L9;
        if (new File(r1).canWrite() == false) goto L9;
        return false;
    }

    private File b() {
        String r2 = System.getProperty("pdfbox.fontcache");
        if (a(r2) == false) goto L8;
        r2 = System.getProperty("user.home");
        if (a(r2) == false) goto L8;
        r2 = System.getProperty("java.io.tmpdir");
    L8:
        return new File(r2, ".pdfbox.cache");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v6 */
    private List<a> b(List<File> r22) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        HashSet r2 = new HashSet(r0.size());
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r2.add(((File) ZeusTransformUtils.preCheckCast(r1.next(), File.class, "com.obric.memorydata.plugin")).getAbsolutePath());
        goto L4
    L6:
        ArrayList r3 = new ArrayList();
        char r4 = 0;
        File r5 = b();     // Catch: SecurityException -> L10
        ?? r6 = r5.exists();     // Catch: SecurityException -> L68
    L73:
        if (r6 == 0) goto L65;
        BufferedReader r7 = new BufferedReader(new FileReader(r5));     // Catch: Throwable -> L52 IOException -> L54
    L74:
        String r8 = r7.readLine();     // Catch: IOException -> L50 Throwable -> L60
        if (r8 == null) goto L49;
        String[] r9 = r8.split("\\|", 10);     // Catch: IOException -> L50 Throwable -> L60
        if (r9.length < 10) goto L19;
        String r10 = r9[r4];     // Catch: IOException -> L50 Throwable -> L60
        FontFormat r11 = FontFormat.valueOf(r9[1]);     // Catch: IOException -> L50 Throwable -> L60
        if (r9[2].length() <= 0) goto L23;
        String[] r12 = r9[2].split("-");     // Catch: IOException -> L50 Throwable -> L60
        com.tom_roush.pdfbox.pdmodel.font.b r13 = new com.tom_roush.pdfbox.pdmodel.font.b(r12[r4], r12[1], Integer.parseInt(r12[2]));     // Catch: IOException -> L50 Throwable -> L60
    L25:
        if (r9[3].length() <= 0) goto L27;
        int r14 = (int) Long.parseLong(r9[3], 16);     // Catch: IOException -> L50 Throwable -> L60
    L29:
        if (r9[4].length() <= 0) goto L31;
        int r15 = (int) Long.parseLong(r9[4], 16);     // Catch: IOException -> L50 Throwable -> L60
    L32:
        HashSet r20 = r2;
        int r16 = (int) Long.parseLong(r9[5], 16);     // Catch: IOException -> L50 Throwable -> L60
        int r17 = (int) Long.parseLong(r9[6], 16);     // Catch: IOException -> L50 Throwable -> L60
        if (r9[7].length() <= 0) goto L35;
        int r18 = (int) Long.parseLong(r9[7], 16);     // Catch: IOException -> L50 Throwable -> L60
    L36:
        char r19 = '\b';
        if (r9[8].length() <= 0) goto L42;
        int r21 = 10;
        byte[] r23 = new byte[10];     // Catch: IOException -> L50 Throwable -> L60
        int r110 = 0;
    L39:
        if (r110 >= r21) goto L41;
        String r24 = r9[r19];     // Catch: IOException -> L50 Throwable -> L60
        int r25 = r110 * 2;     // Catch: IOException -> L50 Throwable -> L60
        r23[r110] = (byte) (Integer.parseInt(r24.substring(r25, r25 + 2), 16) & 255);     // Catch: IOException -> L50 Throwable -> L60
        r110 = r110 + 1;     // Catch: IOException -> L50 Throwable -> L60
        r21 = 10;
        r19 = '\b';
        goto L39
    L41:
        byte[] r111 = r23;
    L43:
        File r26 = new File(r9[9]);     // Catch: IOException -> L50 Throwable -> L60
        if (r26.exists() == false) goto L46;
        r3.add(new a(r26, r11, r10, r13, r14, r15, r16, r17, r18, r111, this, null));     // Catch: IOException -> L50 Throwable -> L60
    L47:
        r2 = r20;
        r2.remove(r26.getAbsolutePath());     // Catch: IOException -> L50 Throwable -> L60
        r4 = 0;
        goto L74
    L46:
        Log.d("PdfBox-Android", "Font file " + r26.getAbsolutePath() + " not found, skipped");     // Catch: IOException -> L50 Throwable -> L60
        goto L47
    L42:
        r111 = null;
        goto L43
    L35:
        r18 = -1;
        goto L36
    L31:
        r15 = -1;
        goto L32
    L27:
        r14 = -1;
        goto L29
    L23:
        r13 = null;
        goto L25
    L19:
        Log.w("PdfBox-Android", "Incorrect line '" + r8 + "' in font disk cache is skipped");     // Catch: IOException -> L50 Throwable -> L60
        goto L74
    L49:
        com.tom_roush.pdfbox.io.a.a(r7);
    L50:
        e = e;
    L56:
        Log.w("PdfBox-Android", "Error loading font cache, will be re-built", e);     // Catch: Throwable -> L60
        com.tom_roush.pdfbox.io.a.a(r7);
        return null;
    L54:
        e = e;
        r7 = null;
    L52:
        th = th;
        ?? r27 = 0;
    L62:
        com.tom_roush.pdfbox.io.a.a(r27);
        throw th;
    L65:
        if (r2.isEmpty() == true) goto L67;
        Log.w("PdfBox-Android", "New fonts found, font cache will be re-built");
        return null;
    L67:
        return r3;
    L60:
        th = th;
        r27 = r6;
    L11:
        r6 = 0;
    L10:
        r5 = null;
        goto L11
    }

    private void b(File r4) {
    L8:
        e = move-exception;
        Log.w("PdfBox-Android", "Could not load font file: " + r4, e);
        return;
    L3:
        if (r4.getPath().toLowerCase().endsWith(".otf") == false) goto L6;
        ah r0 = new com.tom_roush.fontbox.f.v(false, true).a(r4);     // Catch: IOException -> L8
    L5:
        a(r0, r4);     // Catch: IOException -> L8
        return;
    L6:
        r0 = new com.tom_roush.fontbox.f.ae(false, true).b(r4);     // Catch: IOException -> L8
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    private void c() {
        ?? r2 = 0;
        BufferedWriter r3 = null;
        BufferedWriter r4 = new BufferedWriter(new FileWriter(b()));     // Catch: Throwable -> L35 IOException -> L37 SecurityException -> L43
        Iterator<a> r9 = this.f16226a.iterator();     // Catch: Throwable -> L31 IOException -> L33
    L5:
        boolean r5 = r9.hasNext();     // Catch: Throwable -> L31 IOException -> L33
        if (r5 == false) goto L30;
        a r6 = (a) ZeusTransformUtils.preCheckCast(r9.next(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31 IOException -> L33
        r4.write(a.a(r6).trim());     // Catch: Throwable -> L31 IOException -> L33
        r4.write("|");     // Catch: Throwable -> L31 IOException -> L33
        r4.write(a.b(r6).toString());     // Catch: Throwable -> L31 IOException -> L33
        r4.write("|");     // Catch: Throwable -> L31 IOException -> L33
        if (a.c(r6) == null) goto L10;
        r4.write(a.c(r6).a() + '-' + a.c(r6).b() + '-' + a.c(r6).c());     // Catch: Throwable -> L31 IOException -> L33
    L10:
        r4.write("|");     // Catch: Throwable -> L31 IOException -> L33
        if (a.d(r6) <= (-1)) goto L13;
        r4.write(Integer.toHexString(a.d(r6)));     // Catch: Throwable -> L31 IOException -> L33
    L13:
        r4.write("|");     // Catch: Throwable -> L31 IOException -> L33
        if (a.e(r6) <= (-1)) goto L16;
        r4.write(Integer.toHexString(a.e(r6)));     // Catch: Throwable -> L31 IOException -> L33
    L16:
        r4.write("|");     // Catch: Throwable -> L31 IOException -> L33
        r4.write(Integer.toHexString(a.f(r6)));     // Catch: Throwable -> L31 IOException -> L33
        r4.write("|");     // Catch: Throwable -> L31 IOException -> L33
        r4.write(Integer.toHexString(a.g(r6)));     // Catch: Throwable -> L31 IOException -> L33
        r4.write("|");     // Catch: Throwable -> L31 IOException -> L33
        if (a.h(r6) <= (-1)) goto L19;
        r4.write(Integer.toHexString(a.h(r6)));     // Catch: Throwable -> L31 IOException -> L33
    L19:
        r4.write("|");     // Catch: Throwable -> L31 IOException -> L33
        if (a.i(r6) == null) goto L28;
        byte[] r7 = a.i(r6).k();     // Catch: Throwable -> L31 IOException -> L33
        int r8 = 0;
    L23:
        if (r8 >= 10) goto L28;
        String r10 = Integer.toHexString(r7[r8]);     // Catch: Throwable -> L31 IOException -> L33
        if (r10.length() != 1) goto L27;
        r4.write(48);     // Catch: Throwable -> L31 IOException -> L33
    L27:
        r4.write(r10);     // Catch: Throwable -> L31 IOException -> L33
        r8 = r8 + 1;     // Catch: Throwable -> L31 IOException -> L33
    L28:
        r4.write("|");     // Catch: Throwable -> L31 IOException -> L33
        r4.write(a.j(r6).getAbsolutePath());     // Catch: Throwable -> L31 IOException -> L33
        r4.newLine();     // Catch: Throwable -> L31 IOException -> L33
        goto L5
    L30:
        com.tom_roush.pdfbox.io.a.a(r4);
        r2 = r5;
    L45:
        return;
    L33:
        e = e;
        r3 = r4;
    L38:
        Log.w("PdfBox-Android", "Could not write to font cache", e);     // Catch: Throwable -> L35
        Log.w("PdfBox-Android", "Installed fonts information will have to be reloaded for each start");     // Catch: Throwable -> L35
        Log.w("PdfBox-Android", "You can assign a directory to the 'pdfbox.fontcache' property");     // Catch: Throwable -> L35
        com.tom_roush.pdfbox.io.a.a(r3);
        r2 = r3;
    L31:
        th = th;
        r2 = r4;
    L41:
        com.tom_roush.pdfbox.io.a.a(r2);
        throw th;
    L35:
        th = th;
    L37:
        e = e;
    L43:
        com.tom_roush.pdfbox.io.a.a(null);
    }

    private void c(File r23) {
        FileInputStream r12 = new FileInputStream(r23);
        com.tom_roush.fontbox.type1.b r16 = com.tom_roush.fontbox.type1.b.a(r12);     // Catch: Throwable -> L21 IOException -> L23
        AnonymousClass1 r2 = null;
        if (r16.b() != null) goto L9;
        this.f16226a.add(new b(r23, FontFormat.PFB, "*skipnoname*", r2));     // Catch: Throwable -> L21 IOException -> L23
        Log.w("PdfBox-Android", "Missing 'name' entry for PostScript name in font " + r23);     // Catch: Throwable -> L21 IOException -> L23
        r12.close();
        return;
    L9:
        if (r16.b().contains("|") == false) goto L14;
        this.f16226a.add(new b(r23, FontFormat.PFB, "*skippipeinname*", r2));     // Catch: Throwable -> L21 IOException -> L23
        Log.w("PdfBox-Android", "Skipping font with '|' in name " + r16.b() + " in file " + r23);     // Catch: Throwable -> L21 IOException -> L23
        r12.close();
        return;
    L14:
        FileInputStream r17 = r12;
        String r14 = "PdfBox-Android";
        this.f16226a.add(new a(r23, FontFormat.PFB, r16.b(), null, -1, -1, 0, 0, -1, null, this, null));     // Catch: IOException -> L19 Throwable -> L28
        if (PDFBoxConfig.b() == false) goto L26;
        Log.d(r14, "PFB: '" + r16.b() + "' / '" + r16.e() + "' / '" + r16.f() + "'");     // Catch: IOException -> L19 Throwable -> L28
    L26:
        r17.close();
        return;
    L19:
        e = e;
    L25:
        Log.w(r14, "Could not load font file: " + r23, e);     // Catch: Throwable -> L28
    L28:
        th = th;
    L29:
        r17.close();
        throw th;
    L23:
        e = e;
        r17 = r12;
        r14 = "PdfBox-Android";
    L21:
        th = th;
        r17 = r12;
        goto L29
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.k
    public List<? extends f> a() {
        return this.f16226a;
    }
}
