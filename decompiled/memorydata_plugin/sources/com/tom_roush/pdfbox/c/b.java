package com.tom_roush.pdfbox.c;

import android.util.Log;
import com.tom_roush.pdfbox.pdmodel.common.h;
import com.tom_roush.pdfbox.pdmodel.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.StringWriter;
import java.io.Writer;
import java.text.Bidi;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class b extends com.tom_roush.pdfbox.c.a {
    private static final String[] G = null;
    private static Map<Character, Character> I = null;
    private static float e = 2.0f;
    private static float f = 2.5f;
    private float A;
    private float B;
    private float C;
    private List<h> D;
    private Map<String, TreeMap<Float, TreeSet<Float>>> E;
    private boolean F;
    private List<Pattern> H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f16082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected ArrayList<List<com.tom_roush.pdfbox.c.c>> f16083b;
    protected com.tom_roush.pdfbox.pdmodel.c c;
    protected Writer d;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private int o;
    private int p;
    private int q;
    private com.tom_roush.pdfbox.pdmodel.interactive.b.b.a r;
    private int s;
    private int t;
    private com.tom_roush.pdfbox.pdmodel.interactive.b.b.a u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private float z;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static a f16084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.tom_roush.pdfbox.c.c f16085b;

        static {
            f16084a = new a();
        }

        private a() {
            this.f16085b = null;
        }

        a(com.tom_roush.pdfbox.c.c r1) {
            this.f16085b = r1;
        }

        public static a a() {
            return f16084a;
        }

        public com.tom_roush.pdfbox.c.c b() {
            return this.f16085b;
        }

        public boolean c() {
            if (this.f16085b != null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    /* JADX INFO: renamed from: com.tom_roush.pdfbox.c.b$b, reason: collision with other inner class name */
    private static final class C0850b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f16086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f16087b;
        private boolean c;
        private boolean d;
        private boolean e;
        private com.tom_roush.pdfbox.c.c f;

        C0850b(com.tom_roush.pdfbox.c.c r2) {
            this.f16086a = false;
            this.f16087b = false;
            this.c = false;
            this.d = false;
            this.e = false;
            this.f = null;
            this.f = r2;
        }

        public com.tom_roush.pdfbox.c.c a() {
            return this.f;
        }

        public boolean b() {
            return this.f16086a;
        }

        public void c() {
            this.f16086a = true;
        }

        public boolean d() {
            return this.f16087b;
        }

        public void e() {
            this.f16087b = true;
        }

        public boolean f() {
            return this.e;
        }

        public void g() {
            this.e = true;
        }

        public boolean h() {
            return this.d;
        }

        public void i() {
            this.d = true;
        }
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f16088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List<com.tom_roush.pdfbox.c.c> f16089b;

        c(String r3, List<com.tom_roush.pdfbox.c.c> r4) {
            List<com.tom_roush.pdfbox.c.c> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            this.f16088a = r3;
            this.f16089b = r5;
        }

        public String a() {
            return this.f16088a;
        }

        public List<com.tom_roush.pdfbox.c.c> b() {
            return this.f16089b;
        }
    }

    static {
        BufferedInputStream r3 = null;
        String r4 = b.class.getSimpleName().toLowerCase();     // Catch: SecurityException -> L6
        String r5 = System.getProperty(r4 + ".indent");     // Catch: SecurityException -> L6
        String r6 = System.getProperty(r4 + ".drop");     // Catch: SecurityException -> L39
    L8:
        if (r5 != null) goto L10;
    L12:
        if (r6 != null) goto L14;
    L16:
        G = new String[]{"\\.", "\\d+\\.", "\\[\\d+\\]", "\\d+\\)", "[A-Z]\\.", "[a-z]\\.", "[A-Z]\\)", "[a-z]\\)", "[IVXL]+\\.", "[ivxl]+\\."};
        I = new HashMap();
    L24:
        e = move-exception;
        Log.e("PdfBox-Android", "Could not close BidiMirroring.txt ", e);
        return;
    L28:
        e = move-exception;
        Log.w("PdfBox-Android", "Could not parse BidiMirroring.txt, mirroring char map will be empty: " + e.getMessage());     // Catch: Throwable -> L26
        r3.close();     // Catch: IOException -> L24
        return;
    L18:
        if (com.tom_roush.pdfbox.android.a.a() == false) goto L20;
        r3 = new BufferedInputStream(com.tom_roush.pdfbox.android.a.a("com/tom_roush/pdfbox/resources/text/BidiMirroring.txt"));     // Catch: Throwable -> L26 IOException -> L28
    L21:
        a(r3);     // Catch: Throwable -> L26 IOException -> L28
        r3.close();     // Catch: IOException -> L24
        return;
    L20:
        r3 = new BufferedInputStream(b.class.getResourceAsStream("/com/tom_roush/pdfbox/resources/text/BidiMirroring.txt"));     // Catch: Throwable -> L26 IOException -> L28
    L26:
        th = move-exception;
        r3.close();     // Catch: IOException -> L34
    L36:
        throw th;
    L34:
        e = move-exception;
        Log.e("PdfBox-Android", "Could not close BidiMirroring.txt ", e);
        goto L36
    L14:
        if (r6.length() <= 0) goto L16;
        f = Float.parseFloat(r6);     // Catch: NumberFormatException -> L38
        goto L16
    L10:
        if (r5.length() <= 0) goto L12;
        e = Float.parseFloat(r5);     // Catch: NumberFormatException -> L37
    L7:
        r6 = null;
    L6:
        r5 = null;
        goto L7
    }

    public b() {
        String r0 = System.getProperty("line.separator");
        this.f16082a = r0;
        this.g = r0;
        this.h = " ";
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = r0;
        this.m = "";
        this.n = "";
        this.o = 0;
        this.p = 1;
        this.q = Integer.MAX_VALUE;
        this.r = null;
        this.s = -1;
        this.t = -1;
        this.u = null;
        this.v = true;
        this.w = true;
        this.x = false;
        this.y = false;
        this.z = e;
        this.A = f;
        this.B = 0.5f;
        this.C = 0.3f;
        this.D = null;
        this.f16083b = new ArrayList();
        this.E = new HashMap();
        this.H = null;
    }

    private void L() {
        this.o = 0;
        this.c = null;
        ArrayList<List<com.tom_roush.pdfbox.c.c>> r0 = this.f16083b;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        this.E.clear();
    }

    private C0850b a(C0850b r1, C0850b r2, C0850b r3, float r4) {
        r1.c();
        b(r1, r2, r3, r4);
        if (r1.d() == true) goto L5;
        p();
    L12:
        return r1;
    L5:
        if (r2.f() == true) goto L7;
        p();
        F();
        goto L12
    L7:
        if (r2.b() == false) goto L9;
        p();
    L9:
        G();
        goto L12
    }

    private StringBuilder a(List<c> r3, StringBuilder r4, List<com.tom_roush.pdfbox.c.c> r5, a r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r6.c() == false) goto L5;
        r7.add(d(r4.toString(), new ArrayList(r8)));
        StringBuilder r9 = new StringBuilder();
        r8.clear();
        return r9;
    L5:
        com.tom_roush.pdfbox.c.c r2 = r6.b();
        r4.append(r2.a());
        r8.add(r2);
        return r4;
    }

    private Pattern a(C0850b r1) {
        return c(r1.a().a(), K());
    }

    private static void a(InputStream r8) {
        LineNumberReader r0 = new LineNumberReader(new InputStreamReader(r8));
    L3:
        String r9 = r0.readLine();
        if (r9 == null) goto L5;
        int r1 = r9.indexOf(35);
        if (r1 == (-1)) goto L10;
        r9 = r9.substring(0, r1);
    L10:
        if (r9.length() < 2) goto L3;
        StringTokenizer r2 = new StringTokenizer(r9, ";");
        int r10 = r2.countTokens();
        Character[] r4 = new Character[r10];
        int r5 = 0;
    L13:
        if (r5 >= r10) goto L15;
        r4[r5] = Character.valueOf((char) Integer.parseInt(r2.nextToken().trim(), 16));
        r5 = r5 + 1;
        goto L13
    L15:
        if (r10 != 2) goto L3;
        I.put(r4[0], r4[1]);
        goto L3
    }

    private void a(List<c> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = r7.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r7.get(r2), c.class, "com.obric.memorydata.plugin");
        b(r3.a(), r3.b());
        if (r2 >= (r0 - 1)) goto L7;
        q();
    L7:
        r2 = r2 + 1;
        goto L3
    }

    private boolean a(float r1, float r2, float r3) {
        if (r2 < (r1 + r3)) goto L5;
    L7:
        return false;
    L5:
        if (r2 <= (r1 - r3)) goto L7;
        return true;
    }

    private boolean a(float r2, float r3, float r4, float r5) {
        if (a(r2, r4, 0.1f) == false) goto L5;
    L14:
        return true;
    L5:
        if (r4 > r2) goto L9;
        if (r4 >= (r2 - r3)) goto L14;
    L9:
        if (r2 <= r4) goto L11;
    L13:
        return false;
    L11:
        if (r2 < (r4 - r5)) goto L13;
        goto L13
    }

    private float b(float r1, float r2) {
        return Math.round((r1 * r2) * 1000.0f) / 1000.0f;
    }

    private String b(String r11) {
        Bidi r10 = new Bidi(r11, -2);
        if (r10.isMixed() == false) goto L5;
    L7:
        int r0 = r10.getRunCount();
        byte[] r1 = new byte[r0];
        Integer[] r2 = new Integer[r0];
        int r3 = 0;
        int r4 = 0;
    L8:
        if (r4 >= r0) goto L10;
        r1[r4] = (byte) r10.getRunLevel(r4);
        r2[r4] = Integer.valueOf(r4);
        r4 = r4 + 1;
        goto L8
    L10:
        Bidi.reorderVisually(r1, 0, r2, 0, r0);
        StringBuilder r5 = new StringBuilder();
    L11:
        if (r3 >= r0) goto L25;
        int r6 = r2[r3].intValue();
        int r7 = r10.getRunStart(r6);
        int r8 = r10.getRunLimit(r6);
        if ((r1[r6] & 1) == 0) goto L22;
    L14:
        r8 = r8 - 1;
        if (r8 < r7) goto L23;
        char r9 = r11.charAt(r8);
        if (Character.isMirrored(r11.codePointAt(r8)) == false) goto L21;
        if (I.containsKey(Character.valueOf(r9)) == false) goto L21;
        r5.append(I.get(Character.valueOf(r9)));
    L21:
        r5.append(r9);
    L23:
        r3 = r3 + 1;
        goto L11
    L22:
        r5.append(r11, r7, r8);
        goto L23
    L25:
        return r5.toString();
    L5:
        if (r10.getBaseLevel() != 0) goto L7;
        return r11;
    }

    private List<c> b(List<a> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        LinkedList r0 = new LinkedList();
        StringBuilder r2 = new StringBuilder();
        ArrayList r3 = new ArrayList();
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L7;
        r2 = a(r0, r2, r3, (a) ZeusTransformUtils.preCheckCast(r9.next(), a.class, "com.obric.memorydata.plugin"));
        goto L4
    L7:
        if (r2.length() <= 0) goto L9;
        r0.add(d(r2.toString(), r3));
    L9:
        return r0;
    }

    private void b(C0850b r6, C0850b r7, C0850b r8, float r9) {
        boolean r0 = true;
        if (r8 == null) goto L32;
        float r10 = Math.abs(r6.a().f() - r7.a().f());
        float r11 = b(y(), r9);
        float r1 = r6.a().d() - r8.a().d();
        float r2 = b(x(), r6.a().m());
        float r3 = b(0.25f, r6.a().g());
        if (r10 > r11) goto L32;
        if (r1 <= r2) goto L15;
        if (r8.d() == false) goto L32;
    L13:
        r6.i();
    L31:
        r0 = false;
        goto L32
    L15:
        if (r1 >= (-r6.a().m())) goto L20;
        if (r8.d() == true) goto L31;
    L20:
        if (Math.abs(r1) >= r3) goto L31;
        if (r8.h() == true) goto L13;
        if (r8.d() == false) goto L31;
        Pattern r12 = a(r8);
        if (r12 == null) goto L31;
        if (r12 != a(r6)) goto L31;
    L32:
        if (r0 == false) goto L35;
        r6.e();
        return;
    }

    private String c(String r7) {
        int r0 = r7.length();
        int r1 = 0;
        StringBuilder r3 = null;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L25;
        char r4 = r7.charAt(r1);
        if (64256 > r4) goto L9;
        if (r4 > 65023) goto L9;
    L12:
        if (r3 != null) goto L14;
        r3 = new StringBuilder(r0 * 2);
    L14:
        r3.append(r7, r2, r1);
        if (r4 != 65010) goto L22;
        if (r1 <= 0) goto L22;
        int r5 = r1 - 1;
        if (r7.charAt(r5) != 1575) goto L20;
    L21:
        String r6 = "لله";
    L23:
        r3.append(r6);
        r2 = r1 + 1;
    L24:
        r1 = r1 + 1;
        goto L3
    L20:
        if (r7.charAt(r5) == 65165) goto L21;
    L22:
        r6 = Normalizer.normalize(r7.substring(r1, r1 + 1), Normalizer.Form.NFKC).trim();
    L9:
        if (65136 > r4) goto L24;
        if (r4 > 65279) goto L24;
    L25:
        if (r3 == null) goto L27;
        r3.append(r7, r2, r1);
        return b(r3.toString());
    L27:
        return b(r7);
    }

    public static Pattern c(String r3, List<Pattern> r4) {
        Iterator r5 = ((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Pattern r0 = (Pattern) ZeusTransformUtils.preCheckCast(r5.next(), Pattern.class, "com.obric.memorydata.plugin");
        if (r0.matcher(r3).matches() == false) goto L4;
        return r0;
    L8:
        return null;
    }

    private c d(String r3, List<com.tom_roush.pdfbox.c.c> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        return new c(c(r3), r5);
    }

    private void d(g r6) {
        this.D = new ArrayList();
        Iterator<com.tom_roush.pdfbox.pdmodel.interactive.pagenavigation.a> r0 = r6.j().iterator();
    L4:
        if (r0.hasNext() == false) goto L17;
        com.tom_roush.pdfbox.pdmodel.interactive.pagenavigation.a r1 = (com.tom_roush.pdfbox.pdmodel.interactive.pagenavigation.a) ZeusTransformUtils.preCheckCast(r0.next(), com.tom_roush.pdfbox.pdmodel.interactive.pagenavigation.a.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L16;
        if (r1.b() == null) goto L16;
        h r2 = r1.b();
        h r3 = r6.g();
        float r4 = r3.f() - r2.c();
        r2.b(r3.f() - r2.f());
        r2.d(r4);
        h r5 = r6.h();
        if (r5.b() == 0.0f) goto L13;
    L14:
        r2.a(r2.b() - r5.b());
        r2.b(r2.c() - r5.c());
        r2.c(r2.d() - r5.b());
        r2.d(r2.f() - r5.c());
    L15:
        this.D.add(r2);
        goto L4
    L13:
        if (r5.c() == 0.0f) goto L15;
    L16:
        this.D.add(null);
        goto L4
    }

    public String A() {
        return this.j;
    }

    public String B() {
        return this.k;
    }

    public String C() {
        return this.l;
    }

    public String D() {
        return this.m;
    }

    public String E() {
        return this.n;
    }

    public void F() {
        H();
        G();
    }

    public void G() {
        if (this.F == false) goto L5;
        H();
        this.F = false;
    L5:
        this.d.write(z());
        this.F = true;
    }

    public void H() {
        if (this.F == true) goto L5;
        G();
    L5:
        this.d.write(A());
        this.F = false;
    }

    public void I() {
        this.d.write(B());
    }

    public void J() {
        this.d.write(C());
    }

    public List<Pattern> K() {
        if (this.H != null) goto L8;
        this.H = new ArrayList();
        String[] r0 = G;
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L8;
        Pattern r3 = Pattern.compile(r0[r2]);
        this.H.add(r3);
        r2 = r2 + 1;
    L8:
        return this.H;
    }

    public String a(com.tom_roush.pdfbox.pdmodel.c r2) {
        StringWriter r0 = new StringWriter();
        a(r2, r0);
        return r0.toString();
    }

    public void a(int r1) {
        this.p = r1;
    }

    @Override // com.tom_roush.pdfbox.c.a
    public void a(com.tom_roush.pdfbox.c.c r14) {
        int r1 = 0;
        if (this.v == false) goto L20;
        String r0 = r14.a();
        float r4 = r14.c();
        float r5 = r14.e();
        TreeMap<Float, TreeSet<Float>> r6 = (TreeMap) ZeusTransformUtils.preCheckCast(this.E.get(r0), TreeMap.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L7;
        r6 = new TreeMap();
        this.E.put(r0, r6);
    L7:
        float r7 = (r14.g() / r0.length()) / 3.0f;
        Iterator<TreeSet<Float>> r2 = r6.subMap(Float.valueOf(r4 - r7), Float.valueOf(r4 + r7)).values().iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        if (((TreeSet) ZeusTransformUtils.preCheckCast(r2.next(), TreeSet.class, "com.obric.memorydata.plugin")).subSet(Float.valueOf(r5 - r7), Float.valueOf(r5 + r7)).isEmpty() == true) goto L9;
        boolean r3 = true;
    L14:
        if (r3 == true) goto L19;
        TreeSet<Float> r8 = (TreeSet) ZeusTransformUtils.preCheckCast(r6.get(Float.valueOf(r4)), TreeSet.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L18;
        r8 = new TreeSet();
        r6.put(Float.valueOf(r4), r8);
    L18:
        r8.add(Float.valueOf(r5));
        goto L20
    L19:
        boolean r9 = false;
    L21:
        if (r9 == false) goto L73;
        float r10 = r14.c();
        float r11 = r14.e();
        if (this.w == false) goto L50;
        int r12 = 0;
        int r13 = -1;
        int r15 = -1;
        int r16 = -1;
        int r17 = -1;
    L26:
        if (r12 >= this.D.size()) goto L49;
        if (r13 != (-1)) goto L49;
        h r18 = (h) ZeusTransformUtils.preCheckCast(this.D.get(r12), h.class, "com.obric.memorydata.plugin");
        if (r18 != null) goto L31;
        r13 = 0;
    L48:
        r12 = r12 + 1;
        goto L26
    L31:
        if (r18.a(r10, r11) == false) goto L34;
        r13 = (r12 * 2) + 1;
        goto L48
    L34:
        if (r10 >= r18.b()) goto L36;
    L37:
        if (r15 != (-1)) goto L40;
        r15 = r12 * 2;
    L40:
        if (r10 >= r18.b()) goto L44;
        if (r16 != (-1)) goto L44;
        r16 = r12 * 2;
    L44:
        if (r11 >= r18.f()) goto L48;
        if (r17 != (-1)) goto L48;
        r17 = r12 * 2;
        goto L48
    L36:
        if (r11 >= r18.f()) goto L40;
    L49:
        r1 = r13;
    L51:
        if (r1 != (-1)) goto L60;
        if (r15 == (-1)) goto L55;
        r1 = r15;
        goto L60
    L55:
        if (r16 == (-1)) goto L57;
        r1 = r16;
        goto L60
    L57:
        if (r17 == (-1)) goto L59;
        r1 = r17;
        goto L60
    L59:
        r1 = this.f16083b.size() - 1;
    L60:
        List r19 = (List) ZeusTransformUtils.preCheckCast(this.f16083b.get(r1), List.class, "com.obric.memorydata.plugin");
        if (r19.isEmpty() == false) goto L63;
    L62:
        r19.add(r14);
        return;
    L63:
        com.tom_roush.pdfbox.c.c r20 = (com.tom_roush.pdfbox.c.c) ZeusTransformUtils.preCheckCast(r19.get(r19.size() - 1), com.tom_roush.pdfbox.c.c.class, "com.obric.memorydata.plugin");
        if (r14.o() == false) goto L69;
        if (r20.a(r14) == false) goto L69;
        r20.b(r14);
        return;
    L69:
        if (r20.o() == false) goto L62;
        if (r14.a(r20) == false) goto L62;
        r14.b(r20);
        r19.remove(r19.size() - 1);
        goto L62
    L50:
        r15 = -1;
        r16 = -1;
        r17 = -1;
        goto L51
    L73:
        return;
    L13:
        r3 = false;
    L20:
        r9 = true;
        goto L21
    }

    public void a(com.tom_roush.pdfbox.pdmodel.c r1, Writer r2) {
        L();
        this.c = r1;
        this.d = r2;
        if (t() == false) goto L5;
        String r3 = this.g;
        this.j = r3;
        this.k = r3;
        this.m = r3;
        this.n = r3;
    L5:
        b(this.c);
        a(this.c.c());
        c(this.c);
    }

    @Override // com.tom_roush.pdfbox.c.a, com.tom_roush.pdfbox.contentstream.b
    public void a(g r8) {
        int r0 = this.o;
        if (r0 >= this.p) goto L5;
        return;
    L5:
        if (r0 > this.q) goto L31;
        int r1 = this.s;
        if (r1 == (-1)) goto L9;
        if (r0 >= r1) goto L9;
        return;
    L9:
        int r2 = this.t;
        if (r2 == (-1)) goto L12;
        if (r0 <= r2) goto L12;
        return;
    L12:
        b(r8);
        int r3 = 1;
        if (this.w == false) goto L15;
        d(r8);
        r3 = 1 + (this.D.size() * 2);
    L15:
        int r4 = this.f16083b.size();
        this.f16083b.ensureCapacity(r3);
        int r5 = Math.max(r3, r4);
        int r6 = 0;
    L16:
        if (r6 >= r5) goto L24;
        ArrayList<List<com.tom_roush.pdfbox.c.c>> r7 = this.f16083b;
        if (r6 >= r4) goto L20;
        ((List) ZeusTransformUtils.preCheckCast(r7.get(r6), List.class, "com.obric.memorydata.plugin")).clear();
    L23:
        r6 = r6 + 1;
        goto L16
    L20:
        if (r3 >= r4) goto L22;
        r7.remove(r6);
        goto L23
    L22:
        r7.add(new ArrayList());
        goto L23
    L24:
        this.E.clear();
        super.a(r8);
        o();
        c(r8);
        return;
    }

    public void a(com.tom_roush.pdfbox.pdmodel.h r4) {
        com.tom_roush.pdfbox.pdmodel.interactive.b.b.a r0 = this.r;
        g r1 = null;
        if (r0 != null) goto L5;
        g r2 = null;
    L7:
        if (r2 == null) goto L9;
        this.s = r4.a(r2) + 1;
    L10:
        com.tom_roush.pdfbox.pdmodel.interactive.b.b.a r3 = this.u;
        if (r3 == null) goto L14;
        r1 = r3.a(this.c);
    L14:
        if (r1 == null) goto L16;
        this.t = r4.a(r1) + 1;
    L18:
        if (this.s != (-1)) goto L28;
        com.tom_roush.pdfbox.pdmodel.interactive.b.b.a r5 = this.r;
        if (r5 == null) goto L28;
        if (this.t != (-1)) goto L28;
        if (this.u == null) goto L28;
        if (r5.a() != this.u.a()) goto L28;
        this.s = 0;
        this.t = 0;
    L28:
        Iterator<g> r6 = r4.iterator();
    L30:
        if (r6.hasNext() == false) goto L34;
        g r7 = (g) ZeusTransformUtils.preCheckCast(r6.next(), g.class, "com.obric.memorydata.plugin");
        this.o++;
        if (r7.f() == false) goto L30;
        a(r7);
        goto L30
    L34:
        return;
    L16:
        this.t = -1;
        goto L18
    L9:
        this.s = -1;
        goto L10
    L5:
        r2 = r0.a(this.c);
        goto L7
    }

    public void a(String r1) {
        this.d.write(r1);
    }

    public void a(boolean r1) {
        this.d.write(D());
    }

    public void b(int r1) {
        this.q = r1;
    }

    public void b(com.tom_roush.pdfbox.pdmodel.c r1) {
    }

    public void b(g r1) {
    }

    public void b(String r3, List<com.tom_roush.pdfbox.c.c> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        a(r3);
    }

    public void b(boolean r1) {
        this.x = r1;
    }

    public void c(com.tom_roush.pdfbox.pdmodel.c r1) {
    }

    public void c(g r1) {
    }

    public void m() {
        a(true);
    }

    public void n() {
        this.d.write(E());
    }

    public void o() {
        if (this.f16083b.size() <= 0) goto L5;
        I();
    L5:
        Iterator<List<com.tom_roush.pdfbox.c.c>> r1 = this.f16083b.iterator();
        C0850b r3 = null;
        C0850b r7 = null;
        float r8 = -3.4028235E38f;
        float r9 = -1.0f;
        float r10 = -1.0f;
        float r11 = -1.0f;
        float r12 = Float.MAX_VALUE;
        boolean r13 = true;
    L7:
        if (r1.hasNext() == false) goto L87;
        String r2 = "com.obric.memorydata.plugin";
        List r14 = (List) ZeusTransformUtils.preCheckCast(r1.next(), List.class, "com.obric.memorydata.plugin");
        if (u() == false) goto L14;
        d r15 = new d();
        Collections.sort(r14, r15);     // Catch: IllegalArgumentException -> L13
    L13:
        com.tom_roush.pdfbox.util.b.a(r14, r15);
    L14:
        m();
        ArrayList r16 = new ArrayList();
        Iterator r17 = r14.iterator();
        float r18 = -1.0f;
        boolean r19 = true;
    L16:
        if (r17.hasNext() == false) goto L83;
        com.tom_roush.pdfbox.c.c r4 = (com.tom_roush.pdfbox.c.c) ZeusTransformUtils.preCheckCast(r17.next(), com.tom_roush.pdfbox.c.c.class, r2);
        C0850b r5 = new C0850b(r4);
        String r20 = r4.a();
        if (r3 == null) goto L24;
        Iterator<List<com.tom_roush.pdfbox.c.c>> r23 = r1;
        if (r4.l() == r3.a().l()) goto L22;
    L23:
        r18 = -1.0f;
    L26:
        if (u() == false) goto L28;
        float r6 = r4.d();
        float r21 = r4.f();
        float r22 = r4.h();
        float r24 = r4.j();
    L29:
        float r25 = r12;
        float r30 = r24;
        String r26 = r2;
        int r110 = r4.n().length;
        float r27 = r4.m();
        if (r27 != 0.0f) goto L32;
    L38:
        float r111 = Float.MAX_VALUE;
    L39:
        float r112 = r22 / r110;
        if (r18 >= 0.0f) goto L42;
        r18 = r112;
    L43:
        float r113 = w() * r18;
        if (r9 == (-1.0f)) goto L46;
        float r28 = r9 + Math.min(r111, r113);
    L47:
        if (r3 == null) goto L69;
        if (r19 == false) goto L51;
        r3.g();
        r19 = false;
    L51:
        if (a(r21, r30, r8, r11) == true) goto L53;
        a(b(r16));
        r16.clear();
        r7 = a(r5, r3, r7, r11);
        r11 = -1.0f;
        r8 = -3.4028235E38f;
        r28 = -3.4028235E38f;
        float r114 = -3.4028235E38f;
        r25 = Float.MAX_VALUE;
    L55:
        if (r28 == r114) goto L66;
        if (r28 >= r6) goto L66;
        if (this.h.isEmpty() == false) goto L61;
    L64:
        r16.add(a.a());
        goto L66
    L61:
        if (r3.a().a() == null) goto L66;
        if (r3.a().a().endsWith(this.h) == false) goto L64;
    L66:
        if (Math.abs(r4.c() - r3.a().c()) <= (r27 + r111)) goto L69;
        r8 = r114;
        r11 = -1.0f;
        float r115 = Float.MAX_VALUE;
    L71:
        if (r21 < r8) goto L73;
        r8 = r21;
    L73:
        r9 = r6 + r22;
        if (r20 == null) goto L79;
        if (r13 == false) goto L78;
        if (r3 != null) goto L78;
        G();
    L78:
        r16.add(new a(r4));
    L79:
        r11 = Math.max(r11, r30);
        r12 = Math.min(r115, r21 - r30);
        if (r13 == false) goto L82;
        r5.e();
        r5.c();
        r7 = r5;
        r13 = false;
    L82:
        r3 = r5;
        r1 = r23;
        r2 = r26;
        r10 = r27;
        goto L16
    L53:
        r114 = -3.4028235E38f;
    L69:
        r115 = r25;
        goto L71
    L46:
        r28 = -3.4028235E38f;
        goto L47
    L42:
        r18 = (r18 + r112) / 2.0f;
        goto L43
    L32:
        if (Float.isNaN(r27) == true) goto L38;
        if (r10 >= 0.0f) goto L37;
        r111 = v() * r27;
        goto L39
    L37:
        r111 = ((r27 + r10) / 2.0f) * v();
        goto L39
    L28:
        r6 = r4.c();
        r21 = r4.e();
        r22 = r4.g();
        r24 = r4.i();
        goto L29
    L22:
        if (r4.k() == r3.a().k()) goto L26;
    L24:
        r23 = r1;
        goto L26
    L83:
        Iterator<List<com.tom_roush.pdfbox.c.c>> r29 = r1;
        float r210 = r12;
        if (r16.size() <= 0) goto L86;
        a(b(r16));
        H();
    L86:
        n();
        r1 = r29;
        r12 = r210;
        goto L7
    L87:
        J();
    }

    public void p() {
        this.d.write(r());
    }

    public void q() {
        this.d.write(s());
    }

    public String r() {
        return this.g;
    }

    public String s() {
        return this.h;
    }

    public boolean t() {
        return this.y;
    }

    public boolean u() {
        return this.x;
    }

    public float v() {
        return this.B;
    }

    public float w() {
        return this.C;
    }

    public float x() {
        return this.z;
    }

    public float y() {
        return this.A;
    }

    public String z() {
        return this.i;
    }
}
