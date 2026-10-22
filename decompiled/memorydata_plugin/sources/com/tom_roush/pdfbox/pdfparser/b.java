package com.tom_roush.pdfbox.pdfparser;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.tom_roush.pdfbox.a.k;
import com.tom_roush.pdfbox.a.m;
import com.tom_roush.pdfbox.a.n;
import com.tom_roush.pdfbox.pdmodel.encryption.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes6.dex */
public class b extends a {
    protected static final char[] e = null;
    protected static final char[] f = null;
    private static final char[] k = null;
    private static final char[] l = null;
    private static final char[] m = null;
    private static final byte[] n = null;
    private static final byte[] o = null;
    private static final char[] u = null;
    private static final char[] v = null;
    private Long A;
    private List<Long> B;
    private List<Long> C;
    private com.tom_roush.pdfbox.pdmodel.encryption.e D;
    private int E;
    private final byte[] F;
    protected final com.tom_roush.pdfbox.io.g d;
    protected long g;
    protected boolean h;
    protected l i;
    protected XrefTrailerResolver j;
    private final byte[] p;
    private com.tom_roush.pdfbox.pdmodel.encryption.a q;
    private InputStream r;
    private String s;
    private String t;
    private long w;
    private boolean x;
    private boolean y;
    private Map<m, Long> z;

    static {
        k = new char[]{'x', 'r', 'e', 'f'};
        l = new char[]{'/', 'X', 'R', 'e', 'f'};
        m = new char[]{'s', 't', 'a', 'r', 't', 'x', 'r', 'e', 'f'};
        n = new byte[]{101, 110, 100, 115, 116, 114, 101, 97, 109};
        o = new byte[]{101, 110, 100, 111, 98, 106};
        e = new char[]{'%', '%', 'E', 'O', 'F'};
        f = new char[]{'o', 'b', 'j'};
        u = new char[]{'t', 'r', 'a', 'i', 'l', 'e', 'r'};
        v = new char[]{'/', 'O', 'b', 'j', 'S', 't', 'm'};
    }

    public b(com.tom_roush.pdfbox.io.g r4, String r5, InputStream r6, String r7) {
        com.tom_roush.pdfbox.io.g r8 = (com.tom_roush.pdfbox.io.g) ZeusTransformUtils.wrapperContextForParams(r4, com.tom_roush.pdfbox.io.g.class, "com.obric.memorydata.plugin");
        super(new i(r8));
        this.p = new byte[2048];
        this.r = null;
        this.s = "";
        this.t = null;
        this.x = true;
        this.h = false;
        this.y = false;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.i = null;
        this.E = 2048;
        this.j = new XrefTrailerResolver();
        this.F = new byte[8192];
        this.d = r8;
        this.s = r5;
        this.t = r7;
        this.r = r6;
    }

    private void A() {
        if (this.x == true) goto L5;
        return;
    L5:
        Map<m, Long> r0 = this.j.d();
        if (a(r0) == true) goto L11;
        B();
        if (this.z.isEmpty() == true) goto L12;
        Log.d("PdfBox-Android", "Replaced read xref table with the results of a brute force search");
        r0.clear();
        r0.putAll(this.z);
        return;
    L12:
        return;
    }

    private void B() {
        if (this.z != null) goto L60;
        C();
        this.z = new HashMap();
        long r1 = this.d.a();
        int r3 = Integer.MIN_VALUE;
        char[] r4 = "ndo".toCharArray();
        char[] r5 = "bj".toCharArray();
        long r6 = Long.MIN_VALUE;
        long r11 = Long.MIN_VALUE;
        long r13 = 6;
        boolean r15 = false;
    L5:
        this.d.a(r13);
        int r8 = this.d.read();
        r13 = r13 + 1;
        if (d(r8) == false) goto L32;
        if (a(f) == false) goto L32;
        long r9 = r13 - 2;
        this.d.a(r9);
        int r10 = this.d.d();
        if (f(r10) == false) goto L42;
        int r12 = r10 - 48;
        long r14 = r9 - 1;
        this.d.a(r14);
        if (i() == false) goto L42;
    L15:
        if (r14 <= 6) goto L19;
        if (i() == false) goto L19;
        r14 = r14 - 1;
        this.d.a(r14);
    L19:
        boolean r16 = false;
    L21:
        if (r14 <= 6) goto L25;
        if (k() == false) goto L25;
        r14 = r14 - 1;
        this.d.a(r14);
        r16 = true;
    L25:
        if (r16 == false) goto L42;
        this.d.read();
        long r24 = m();
        if (r11 <= 0) goto L29;
        this.z.put(new m(r6, r3), Long.valueOf(r11));
    L29:
        r11 = r14 + 1;
        r13 = r13 + ((long) (f.length - 1));
        r3 = r12;
        r6 = r24;
        r15 = false;
    L42:
        if (r13 >= this.A.longValue()) goto L46;
        if (this.d.e() == false) goto L5;
    L46:
        if (this.A.longValue() < Long.MAX_VALUE) goto L49;
        if (r15 == true) goto L49;
    L51:
        this.d.a(r1);
        return;
    L49:
        if (r11 <= 0) goto L51;
        this.z.put(new m(r6, r3), Long.valueOf(r11));
    L32:
        if (r8 != 101) goto L42;
        if (a(r4) == false) goto L42;
        r13 = r13 + ((long) r4.length);
        this.d.a(r13);
        if (this.d.e() == false) goto L39;
    L37:
        r15 = true;
        goto L42
    L39:
        if (a(r5) == false) goto L42;
        r13 = r13 + ((long) r5.length);
        goto L37
    }

    private void C() {
        if (this.A != null) goto L27;
        long r0 = this.d.a();
        this.d.a(6);
    L6:
        if (this.d.e() == true) goto L16;
        if (a(e) == false) goto L15;
        long r2 = this.d.a();
        this.d.a(5 + r2);
        l();     // Catch: IOException -> L14
        if (a(k) == true) goto L15;
        m();     // Catch: IOException -> L14
        n();     // Catch: IOException -> L14
    L14:
        this.A = Long.valueOf(r2);
    L15:
        this.d.read();
        goto L6
    L16:
        this.d.a(r0);
        if (this.A != null) goto L28;
        this.A = Long.MAX_VALUE;
        return;
    L28:
        return;
    }

    private void D() {
        HashMap r3 = new HashMap();
        long r4 = this.d.a();
        long r7 = 6;
        this.d.a(6);
        char[] r6 = " obj".toCharArray();
    L3:
        long r10 = 0;
        boolean r14 = true;
        if (this.d.e() == true) goto L38;
        if (a(v) == false) goto L36;
        long r15 = this.d.a();
        long r17 = -1;
        int r9 = 1;
        boolean r19 = false;
    L9:
        if (r9 >= 40) goto L35;
        if (r19 == true) goto L35;
        long r8 = r15 - ((long) (r9 * 10));
        if (r8 <= r10) goto L33;
        this.d.a(r8);
        int r13 = 0;
    L15:
        if (r13 >= 10) goto L33;
        if (a(r6) == true) goto L18;
        r8 = r8 + 1;
        this.d.read();
        r13 = r13 + 1;
        goto L15
    L18:
        long r11 = r8 - 1;
        this.d.a(r11);
        if (f(this.d.d()) == false) goto L30;
        long r12 = r11 - 1;
        this.d.a(r12);
        if (j() == false) goto L30;
        long r16 = r12 - 1;
        this.d.a(r16);
        int r18 = 0;
        long r21 = 6;
    L24:
        if (r16 <= 6) goto L28;
        if (k() == false) goto L28;
        r16 = r16 - 1;
        this.d.a(r16);
        r18 = r18 + 1;
    L28:
        if (r18 <= 0) goto L31;
        this.d.read();
        r17 = this.d.a();
        r3.put(Long.valueOf(r17), new m(m(), n()));
    L31:
        long r20 = r17;
        Log.d("PdfBox-Android", "Dictionary start for object stream -> " + r20);
        r17 = r20;
        r19 = true;
    L34:
        r9 = r9 + 1;
        r7 = r21;
        r10 = 0;
    L30:
        r21 = 6;
    L33:
        r21 = 6;
    L35:
        long r22 = r7;
        this.d.a(((long) v.length) + r15);
    L37:
        this.d.read();
        r7 = r22;
        goto L3
    L36:
        r22 = r7;
        goto L37
    L38:
        Iterator r23 = r3.keySet().iterator();
    L40:
        if (r23.hasNext() == false) goto L98;
        Long r24 = (Long) ZeusTransformUtils.preCheckCast(r23.next(), Long.class, "com.obric.memorydata.plugin");
        Long r25 = (Long) ZeusTransformUtils.preCheckCast(this.z.get(r3.get(r24)), Long.class, "com.obric.memorydata.plugin");
        if (r25 == null) goto L43;
        if (r24.equals(r25) == false) goto L96;
        this.d.a(r24.longValue());
        long r110 = m();
        int r26 = n();
        a(f, r14);
        com.tom_roush.pdfbox.a.d r111 = a();     // Catch: Throwable -> L85 IOException -> L87
        int r112 = r111.i(com.tom_roush.pdfbox.a.i.cU);     // Catch: Throwable -> L85 IOException -> L87
        int r113 = r111.i(com.tom_roush.pdfbox.a.i.fg);     // Catch: Throwable -> L85 IOException -> L87
        HashMap r114 = r3;
        if (r112 == (-1)) goto L83;
        if (r113 == (-1)) goto L83;
        n r115 = a(r111);     // Catch: Throwable -> L85 IOException -> L101
        l r5 = this.i;     // Catch: IOException -> L81 Throwable -> L92
        long r27 = r4;
        if (r5 != null) goto L108;
    L58:
        e r28 = new e(r115, this.c);     // Catch: IOException -> L100 Throwable -> L92
        ArrayList r29 = new ArrayList(r113);     // Catch: IOException -> L100 Throwable -> L92
        int r30 = 0;
    L59:
        if (r30 >= r113) goto L62;
        r29.add(Long.valueOf(r28.m()));     // Catch: IOException -> L100 Throwable -> L92
        r28.p();     // Catch: IOException -> L100 Throwable -> L92
        r30 = r30 + 1;
        goto L59
    L62:
        if (r115 == null) goto L65;
        r115.close();
    L65:
        if (r29.size() >= r113) goto L67;
        Log.d("PdfBox-Android", "Skipped corrupt stream: (" + r110 + " 0 at offset " + r24);
    L97:
        r3 = r114;
        r4 = r27;
        r14 = true;
        goto L40
    L67:
        Map<m, Long> r31 = this.j.d();
        Iterator r32 = r29.iterator();
    L69:
        if (r32.hasNext() == false) goto L97;
        m r33 = new m(((Long) ZeusTransformUtils.preCheckCast(r32.next(), Long.class, "com.obric.memorydata.plugin")).longValue(), 0);
        Long r34 = (Long) ZeusTransformUtils.preCheckCast(this.z.get(r33), Long.class, "com.obric.memorydata.plugin");
        if (r34 == null) goto L77;
        if (r34.longValue() >= 0) goto L77;
        r34 = (Long) ZeusTransformUtils.preCheckCast(this.z.get(new m(Math.abs(r34.longValue()), 0)), Long.class, "com.obric.memorydata.plugin");
    L77:
        if (r34 == null) goto L80;
        if (r24.longValue() <= r34.longValue()) goto L69;
    L80:
        long r116 = -r110;
        this.z.put(r33, Long.valueOf(r116));
        r31.put(r33, Long.valueOf(r116));
        goto L69
    L108:
        r5.a(r115, r110, r26);     // Catch: IOException -> L100 Throwable -> L92
    L89:
        Log.d("PdfBox-Android", "Skipped corrupt stream: (" + r110 + " 0 at offset " + r24);     // Catch: Throwable -> L92
        if (r115 == null) goto L97;
        r115.close();
        goto L97
    L92:
        th = th;
    L93:
        if (r115 == null) goto L95;
        r115.close();
    L95:
        throw th;
    L81:
        r27 = r4;
        goto L89
    L88:
        r27 = r4;
        r115 = null;
    L83:
        r27 = r4;
    L87:
        r114 = r3;
    L85:
        th = th;
        r115 = null;
        goto L93
    L96:
        r114 = r3;
        r27 = r4;
        goto L97
    L43:
        Log.w("PdfBox-Android", "Skipped incomplete object stream:" + r3.get(r24) + " at " + r24);
        goto L40
    L98:
        this.d.a(r4);
    }

    private void E() {
        if (this.B != null) goto L19;
        this.B = new ArrayList();
        long r0 = this.d.a();
        this.d.a(6);
    L6:
        if (this.d.e() == true) goto L14;
        if (a(k) == false) goto L13;
        long r2 = this.d.a();
        this.d.a(r2 - 1);
        if (i() == false) goto L12;
        this.B.add(Long.valueOf(r2));
    L12:
        this.d.a(r2 + 4);
    L13:
        this.d.read();
        goto L6
    L14:
        this.d.a(r0);
        return;
    }

    private void F() {
        if (this.C != null) goto L53;
        this.C = new ArrayList();
        long r1 = this.d.a();
        this.d.a(6);
        char[] r3 = " obj".toCharArray();
    L6:
        if (this.d.e() == true) goto L40;
        if (a(l) == false) goto L39;
        long r6 = this.d.a();
        int r12 = 1;
        boolean r13 = false;
        long r14 = -1;
    L11:
        if (r12 >= 40) goto L36;
        if (r13 == true) goto L36;
        long r8 = r6 - ((long) (r12 * 10));
        if (r8 <= 0) goto L34;
        this.d.a(r8);
        int r10 = 0;
    L17:
        if (r10 >= 10) goto L34;
        if (a(r3) == true) goto L20;
        r8 = r8 + 1;
        this.d.read();
        r10 = r10 + 1;
        goto L17
    L20:
        long r9 = r8 - 1;
        this.d.a(r9);
        if (f(this.d.d()) == false) goto L32;
        long r11 = r9 - 1;
        this.d.a(r11);
        if (j() == false) goto L32;
        long r15 = r11 - 1;
        this.d.a(r15);
        int r16 = 0;
    L26:
        if (r15 <= 6) goto L30;
        if (k() == false) goto L30;
        r15 = r15 - 1;
        this.d.a(r15);
        r16 = r16 + 1;
    L30:
        if (r16 <= 0) goto L32;
        this.d.read();
        r14 = this.d.a();
    L32:
        Log.d("PdfBox-Android", "Fixed reference for xref stream " + r6 + " -> " + r14);
        r13 = true;
    L34:
        r12 = r12 + 1;
    L36:
        if (r14 <= (-1)) goto L38;
        this.C.add(Long.valueOf(r14));
    L38:
        this.d.a(r6 + 5);
    L39:
        this.d.read();
        goto L6
    L40:
        this.d.a(r1);
        return;
    }

    private long G() {
        if (a(m) == false) goto L5;
        g();
        l();
        return p();
    L5:
        return -1;
    }

    private boolean H() {
        this.w = this.d.a();
        if (this.x == false) goto L13;
    L4:
        int r0 = this.d.d();
        if (r0 == 116) goto L13;
        if (f(r0) == false) goto L13;
        if (this.d.a() != this.w) goto L11;
        Log.w("PdfBox-Android", "Expected trailer object at offset " + this.w + ", keep trying");
    L11:
        h();
    L13:
        if (this.d.d() == 116) goto L15;
        return false;
    L15:
        long r1 = this.d.a();
        String r3 = h();
        if (r3.trim().equals("trailer") == false) goto L18;
    L21:
        l();
        this.j.a(a());
        l();
        return true;
    L18:
        if (r3.startsWith("trailer") == false) goto L20;
        this.d.a(r1 + ((long) 7));
        goto L21
    L20:
        return false;
    }

    private void I() {
        if (this.D == null) goto L5;
        return;
    L5:
        com.tom_roush.pdfbox.a.b r0 = this.c.f().l(com.tom_roush.pdfbox.a.i.cD);
        if (r0 != null) goto L8;
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r0, com.tom_roush.pdfbox.a.j.class) == false) goto L11;
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(r0, com.tom_roush.pdfbox.a.l.class) == false) goto L34;
        c((com.tom_roush.pdfbox.a.l) ZeusTransformUtils.preCheckCast(r0, com.tom_roush.pdfbox.a.l.class, "com.obric.memorydata.plugin"));
    L34:
        this.D = new com.tom_roush.pdfbox.pdmodel.encryption.e(this.c.b());     // Catch: Throwable -> L22 Exception -> L24 IOException -> L27
        if (this.r == null) goto L16;
        KeyStore r1 = KeyStore.getInstance("PKCS12");     // Catch: Throwable -> L22 Exception -> L24 IOException -> L27
        r1.load(this.r, this.s.toCharArray());     // Catch: Throwable -> L22 Exception -> L24 IOException -> L27
        com.tom_roush.pdfbox.pdmodel.encryption.b r2 = new com.tom_roush.pdfbox.pdmodel.encryption.g(r1, this.t, this.s);     // Catch: Throwable -> L22 Exception -> L24 IOException -> L27
    L17:
        l r3 = this.D.a();     // Catch: Throwable -> L22 Exception -> L24 IOException -> L27
        this.i = r3;     // Catch: Throwable -> L22 Exception -> L24 IOException -> L27
        r3.a(this.D, this.c.c(), r2);     // Catch: Throwable -> L22 Exception -> L24 IOException -> L27
        this.q = this.i.c();     // Catch: Throwable -> L22 Exception -> L24 IOException -> L27
        InputStream r4 = this.r;
        if (r4 == null) goto L36;
        com.tom_roush.pdfbox.io.a.a(r4);
        return;
    L36:
        return;
    L16:
        r2 = new com.tom_roush.pdfbox.pdmodel.encryption.n(this.s);     // Catch: Throwable -> L22 Exception -> L24 IOException -> L27
    L22:
        th = move-exception;
        InputStream r5 = this.r;
        if (r5 == null) goto L32;
        com.tom_roush.pdfbox.io.a.a(r5);
    L32:
        throw th;
    L27:
        e = move-exception;
        throw e;     // Catch: Throwable -> L22
    L24:
        e = move-exception;
        throw new IOException("Error (" + e.getClass().getSimpleName() + ") while creating security handler for decryption", e);     // Catch: Throwable -> L22
    }

    private int a(com.tom_roush.pdfbox.a.d r9, Set<com.tom_roush.pdfbox.a.l> r10) {
        Set<com.tom_roush.pdfbox.a.l> r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.memorydata.plugin");
        com.tom_roush.pdfbox.a.b r0 = r9.a(com.tom_roush.pdfbox.a.i.el);
        int r3 = 0;
        if (ZeusTransformUtils.instanceOf(r0, com.tom_roush.pdfbox.a.a.class) == false) goto L27;
        com.tom_roush.pdfbox.a.a r1 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r0, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        Iterator<? extends com.tom_roush.pdfbox.a.b> r2 = r1.d().iterator();
    L6:
        if (r2.hasNext() == false) goto L27;
        com.tom_roush.pdfbox.a.b r4 = (com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r2.next(), com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, com.tom_roush.pdfbox.a.l.class) == false) goto L26;
        if (r11.contains((com.tom_roush.pdfbox.a.l) ZeusTransformUtils.preCheckCast(r4, com.tom_roush.pdfbox.a.l.class, "com.obric.memorydata.plugin")) == true) goto L26;
        com.tom_roush.pdfbox.a.l r5 = (com.tom_roush.pdfbox.a.l) ZeusTransformUtils.preCheckCast(r4, com.tom_roush.pdfbox.a.l.class, "com.obric.memorydata.plugin");
        com.tom_roush.pdfbox.a.b r6 = r5.a();
        if (r6 == null) goto L25;
        if (r6.equals(com.tom_roush.pdfbox.a.j.f16062b) == true) goto L25;
        if (ZeusTransformUtils.instanceOf(r6, com.tom_roush.pdfbox.a.d.class) == false) goto L6;
        com.tom_roush.pdfbox.a.d r7 = (com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r6, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin");
        com.tom_roush.pdfbox.a.i r8 = r7.b(com.tom_roush.pdfbox.a.i.iz);
        if (com.tom_roush.pdfbox.a.i.ga.equals(r8) == true) goto L21;
        if (com.tom_roush.pdfbox.a.i.fW.equals(r8) == false) goto L6;
        r3 = r3 + 1;
        goto L6
    L21:
        r11.add(r5);
        r3 = r3 + a(r7, r11);
    L25:
        Log.w("PdfBox-Android", "Removed null object " + r4 + " from pages dictionary");
    L26:
        r1.b(r4);
    L27:
        r9.a(com.tom_roush.pdfbox.a.i.bk, r3);
        return r3;
    }

    private long a(long r6, boolean r8) {
        long r0 = m();
        long r2 = this.c.g();
        this.c.a(Math.max(r2, r0));
        n();
        a(f, true);
        com.tom_roush.pdfbox.a.d r1 = a();
        n r3 = a(r1);
        a(r3, r6, r8);
        r3.close();
        return r1.j(com.tom_roush.pdfbox.a.i.gs);
    }

    private long a(com.tom_roush.pdfbox.a.l r3) {
        long r0 = r3.f() << 32;
        return ((long) r3.g()) | r0;
    }

    private long a(List<Long> r12, long r13) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        int r14 = r11.size();
        Long r2 = null;
        int r3 = 0;
        int r4 = -1;
    L3:
        if (r3 >= r14) goto L10;
        long r5 = r13 - ((Long) ZeusTransformUtils.preCheckCast(r11.get(r3), Long.class, "com.obric.memorydata.plugin")).longValue();
        if (r2 != null) goto L7;
    L8:
        r2 = Long.valueOf(r5);
        r4 = r3;
    L9:
        r3 = r3 + 1;
        goto L3
    L7:
        if (Math.abs(r2.longValue()) <= Math.abs(r5)) goto L9;
    L10:
        if (r4 > (-1)) goto L17;
        return -1;
    L17:
        return ((Long) ZeusTransformUtils.preCheckCast(r11.get(r4), Long.class, "com.obric.memorydata.plugin")).longValue();
    }

    private com.tom_roush.pdfbox.a.d a(m r3, long r4) {
        if (r4 >= 0) goto L10;
        com.tom_roush.pdfbox.a.l r5 = this.c.a(r3);
        if (r5.a() != null) goto L7;
        h((int) (-r4));
    L7:
        com.tom_roush.pdfbox.a.b r2 = r5.a();
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.a.d.class) == true) goto L20;
        return null;
    L20:
        return (com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r2, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin");
    L10:
        this.d.a(r4);
        m();
        n();
        a(f, true);
        if (this.d.d() == 60) goto L17;
        return null;
    L17:
        return a();
    L15:
        Log.d("PdfBox-Android", "Skipped object " + r3 + ", either it's corrupt or not a dictionary");
        return null;
    }

    private k a(com.tom_roush.pdfbox.a.b r6, com.tom_roush.pdfbox.a.i r7) {
        if (r6 != null) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, k.class) == false) goto L10;
        Object r5 = ZeusTransformUtils.preCheckCast(r6, k.class, "com.obric.memorydata.plugin");
    L22:
        return (k) r5;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, com.tom_roush.pdfbox.a.l.class) == false) goto L28;
        com.tom_roush.pdfbox.a.l r8 = (com.tom_roush.pdfbox.a.l) ZeusTransformUtils.preCheckCast(r6, com.tom_roush.pdfbox.a.l.class, "com.obric.memorydata.plugin");
        com.tom_roush.pdfbox.a.b r1 = r8.a();
        if (r1 != null) goto L14;
        long r3 = this.d.a();
        a(r8, com.tom_roush.pdfbox.a.i.fv.equals(r7));
        this.d.a(r3);
        r1 = r8.a();
    L14:
        if (r1 == null) goto L26;
        if (com.tom_roush.pdfbox.a.j.f16062b != r1) goto L20;
        Log.w("PdfBox-Android", "Length object (" + r8.f() + " " + r8.g() + ") not found");
        return null;
    L20:
        if (ZeusTransformUtils.instanceOf(r1, k.class) == false) goto L24;
        r5 = ZeusTransformUtils.preCheckCast(r1, k.class, "com.obric.memorydata.plugin");
        goto L22
    L24:
        throw new IOException("Wrong type of referenced length object " + r8 + ": " + r1.getClass().getSimpleName());
    L26:
        throw new IOException("Length object content was not read.");
    L28:
        throw new IOException("Wrong type of length object: " + r6.getClass().getSimpleName());
    }

    private com.tom_roush.pdfbox.a.l a(com.tom_roush.pdfbox.a.l r5, Long r6, com.tom_roush.pdfbox.a.l r7, Long r8) {
        if (r7 != null) goto L4;
        return r5;
    L4:
        if (r7.f() == r5.f()) goto L6;
        if (r8 == null) goto L15;
        if (r6.longValue() <= r8.longValue()) goto L15;
        return r5;
    L15:
        return r7;
    L6:
        if (r7.g() >= r5.g()) goto L9;
        return r5;
    L9:
        return r7;
    }

    private m a(m r10, long r11, Map<m, Long> r13) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        if (r11 >= 6) goto L43;
        return null;
    L43:
        this.d.a(r11);     // Catch: IOException -> L40
        b();     // Catch: IOException -> L40
        if (this.d.a() != r11) goto L25;
        this.d.a(r11 - 1);     // Catch: IOException -> L40
        if (this.d.a() >= r11) goto L25;
        if (k() == true) goto L12;
        this.d.read();     // Catch: IOException -> L40
        goto L25
    L12:
        long r7 = this.d.a();     // Catch: IOException -> L40
        com.tom_roush.pdfbox.io.g r2 = this.d;     // Catch: IOException -> L40
    L13:
        r7 = r7 - 1;     // Catch: IOException -> L40
        r2.a(r7);     // Catch: IOException -> L40
        if (k() == false) goto L16;
        r2 = this.d;     // Catch: IOException -> L40
        goto L13
    L16:
        m r8 = new m(m(), n());     // Catch: IOException -> L40
        Long r15 = (Long) ZeusTransformUtils.preCheckCast(r14.get(r8), Long.class, "com.obric.memorydata.plugin");     // Catch: IOException -> L40
        if (r15 != null) goto L19;
    L24:
        this.d.a(r11);     // Catch: IOException -> L40
        goto L25
    L19:
        if (r15.longValue() <= 0) goto L24;
        if (Math.abs(r11 - r15.longValue()) >= 10) goto L24;
        Log.d("PdfBox-Android", "Found the object " + r8 + " instead of " + r10 + " at offset " + r11 + " - ignoring");     // Catch: IOException -> L40
        return null;
    L25:
        long r3 = m();     // Catch: IOException -> L40
        if (r10.b() == r3) goto L31;
        Log.w("PdfBox-Android", "found wrong object number. expected [" + r10.b() + "] found [" + r3 + "]");     // Catch: IOException -> L40
        if (this.x == true) goto L30;
        return null;
    L30:
        r10 = new m(r3, r10.a());     // Catch: IOException -> L40
    L31:
        int r16 = n();     // Catch: IOException -> L40
        a(f, true);     // Catch: IOException -> L40
        if (r16 != r10.a()) goto L35;
        return r10;
    L35:
        if (this.x == true) goto L37;
    L42:
        return null;
    L37:
        if (r16 <= r10.a()) goto L42;
        return new m(r10.b(), r16);
    L40:
        e = move-exception;
        Log.d("PdfBox-Android", "No valid object at given location " + r11 + " - ignoring", e);
        goto L42
    }

    private void a(n r2, long r3, boolean r5) {
        if (r5 == false) goto L4;
        this.j.a(r3, XrefTrailerResolver.XRefType.STREAM);
        this.j.a(r2);
    L4:
        new h(r2, this.c, this.j).r();
    }

    private void a(OutputStream r12) {
        byte[] r0 = n;
        int r2 = 0;
    L3:
        int r3 = this.d.read(this.p, r2, 2048 - r2);
        if (r3 <= 0) goto L43;
        int r4 = r3 + r2;
        int r5 = r4 - 5;
        int r6 = r2;
    L6:
        if (r2 >= r4) goto L36;
        int r7 = r2 + 5;
        if (r6 != 0) goto L15;
        if (r7 >= r5) goto L15;
        byte r8 = this.p[r7];
        if (r8 <= 116) goto L13;
    L14:
        r2 = r7;
    L35:
        r2 = r2 + 1;
        goto L6
    L13:
        if (r8 < 97) goto L14;
    L15:
        byte r9 = this.p[r2];
        if (r9 != r0[r6]) goto L21;
        r6 = r6 + 1;
        if (r6 != r0.length) goto L35;
        r2 = r2 + 1;
        goto L36
    L21:
        if (r6 != 3) goto L26;
        r0 = o;
        if (r9 != r0[r6]) goto L26;
        r6 = r6 + 1;
    L26:
        if (r9 != 101) goto L29;
        int r1 = 1;
    L34:
        r6 = r1;
        r0 = n;
        goto L35
    L29:
        if (r9 == 110) goto L31;
    L33:
        r1 = 0;
        goto L34
    L31:
        if (r6 != 7) goto L33;
        r1 = 2;
    L36:
        int r10 = Math.max(0, r2 - r6);
        if (r10 <= 0) goto L40;
        r12.write(this.p, 0, r10);
    L40:
        if (r6 == r0.length) goto L41;
        System.arraycopy(r0, 0, this.p, 0, r6);
        r2 = r6;
        goto L3
    L41:
        this.d.a(r4 - r10);
    L43:
        r12.flush();
    }

    private void a(OutputStream r6, k r7) {
        long r0 = r7.b();
    L4:
        if (r0 <= 0) goto L14;
        if (r0 <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) goto L8;
        int r8 = 8192;
    L9:
        int r2 = this.d.read(this.F, 0, r8);
        if (r2 <= 0) goto L13;
        r6.write(this.F, 0, r2);
        r0 = r0 - ((long) r2);
        goto L4
    L13:
        throw new IOException("read error at offset " + this.d.a() + ": expected " + r8 + " bytes, but read() returns " + r2);
    L8:
        r8 = (int) r0;
        goto L9
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void a(Long r16, m r17, com.tom_roush.pdfbox.a.l r18) {
        this.d.a(r16.longValue());
        long r2 = m();
        int r4 = n();
        a(f, true);
        if (r2 != r17.b()) goto L34;
        if (r4 != r17.a()) goto L34;
        l();
        com.tom_roush.pdfbox.a.b r5 = f();
        String r13 = g();
        if (r13.equals(CozeCloudExt.API_KEY_HTTP_STREAM_METHOD) == false) goto L22;
        this.d.a(r13.getBytes(com.tom_roush.pdfbox.util.a.d).length);
        if (ZeusTransformUtils.instanceOf(r5, com.tom_roush.pdfbox.a.d.class) == false) goto L21;
        n r6 = a((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r5, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"));
        l r7 = this.i;
        if (r7 == null) goto L13;
        r7.a(r6, r17.b(), r17.a());
    L13:
        l();
        r13 = h();
        com.tom_roush.pdfbox.a.b r8 = r6;
        if (r13.startsWith("endobj") == true) goto L25;
        r8 = r6;
        if (r13.startsWith("endstream") == false) goto L25;
        r13 = r13.substring(9).trim();
        r8 = r6;
        if (r13.length() != 0) goto L25;
        r13 = h();
        r8 = r6;
    L25:
        r18.a(r8);
        if (r13.startsWith("endobj") == false) goto L28;
        return;
    L28:
        if (this.x == false) goto L31;
        Log.w("PdfBox-Android", "Object (" + r2 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r4 + ") at offset " + r16 + " does not end with 'endobj' but with '" + r13 + "'");
        return;
    L31:
        throw new IOException("Object (" + r2 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r4 + ") at offset " + r16 + " does not end with 'endobj' but with '" + r13 + "'");
    L21:
        throw new IOException("Stream not preceded by dictionary (offset: " + r16 + ").");
    L22:
        l r9 = this.i;
        r8 = r5;
        if (r9 == null) goto L25;
        r9.a(r5, r17.b(), r17.a());
        r8 = r5;
    L34:
        throw new IOException("XREF for " + r17.b() + ParameterizedMessage.ERROR_MSG_SEPARATOR + r17.a() + " points to wrong object: " + r2 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r4 + " at offset " + r16);
    }

    private void a(Queue<com.tom_roush.pdfbox.a.b> r3, com.tom_roush.pdfbox.a.b r4, Set<Long> r5) {
        Queue r6 = (Queue) ZeusTransformUtils.wrapperContextForParams(r3, Queue.class, "com.obric.memorydata.plugin");
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, com.tom_roush.pdfbox.a.l.class) == false) goto L8;
        if (r7.add(Long.valueOf(a((com.tom_roush.pdfbox.a.l) ZeusTransformUtils.preCheckCast(r4, com.tom_roush.pdfbox.a.l.class, "com.obric.memorydata.plugin")))) == true) goto L11;
        return;
    L11:
        r6.add(r4);
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r4, com.tom_roush.pdfbox.a.d.class) == true) goto L11;
        if (ZeusTransformUtils.instanceOf(r4, com.tom_roush.pdfbox.a.a.class) == true) goto L11;
    }

    private void a(Queue<com.tom_roush.pdfbox.a.b> r4, Collection<com.tom_roush.pdfbox.a.b> r5, Set<Long> r6) {
        Queue<com.tom_roush.pdfbox.a.b> r7 = (Queue) ZeusTransformUtils.wrapperContextForParams(r4, Queue.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        Set<Long> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        a(r7, (com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r10.next(), com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin"), r9);
        goto L4
    }

    private void a(com.tom_roush.pdfbox.a.i[] r6, com.tom_roush.pdfbox.a.d r7, Set<Long> r8) {
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L10;
        int r0 = r6.length;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L14;
        com.tom_roush.pdfbox.a.b r3 = r7.l(r6[r2]);
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.a.l.class) == false) goto L9;
        r9.add(Long.valueOf(a((com.tom_roush.pdfbox.a.l) ZeusTransformUtils.preCheckCast(r3, com.tom_roush.pdfbox.a.l.class, "com.obric.memorydata.plugin"))));
    L9:
        r2 = r2 + 1;
        goto L5
    L14:
        return;
    }

    private boolean a(String r8, String r9) {
        String r0 = h();
        if (r0.contains(r8) == true) goto L11;
    L4:
        r0 = h();
        if (r0.contains(r8) == true) goto L11;
        if (r0.length() <= 0) goto L4;
        if (Character.isDigit(r0.charAt(0)) == false) goto L4;
    L11:
        if (r0.contains(r8) == true) goto L14;
        this.d.a(0);
        return false;
    L14:
        int r1 = r0.indexOf(r8);
        if (r1 <= 0) goto L18;
        r0 = r0.substring(r1);
    L18:
        if (r0.startsWith(r8) == true) goto L20;
    L25:
        float r10 = -1.0f;
        String[] r2 = r0.split("-");     // Catch: NumberFormatException -> L30
        if (r2.length != 2) goto L33;
        r10 = Float.parseFloat(r2[1]);     // Catch: NumberFormatException -> L30
    L33:
        if (r10 < 0.0f) goto L35;
    L39:
        this.c.a(r10);
        this.d.a(0);
        return true;
    L35:
        if (this.x == false) goto L38;
        r10 = 1.7f;
        goto L39
    L38:
        throw new IOException("Error getting header version: " + r0);
    L30:
        e = move-exception;
        Log.d("PdfBox-Android", "Can't parse the header version.", e);
        goto L33
    L20:
        if (r0.matches(r8 + "\\d.\\d") == true) goto L25;
        if (r0.length() >= (r8.length() + 3)) goto L24;
        r0 = r8 + r9;
        Log.d("PdfBox-Android", "No version found, set to " + r9 + " as default.");
        goto L25
    L24:
        String r11 = r0.substring(r8.length() + 3, r0.length()) + "\n";
        r0 = r0.substring(0, r8.length() + 3);
        this.d.a(r11.getBytes(com.tom_roush.pdfbox.util.a.d).length);
        goto L25
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean a(Map<m, Long> r12) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L5;
        return true;
    L5:
        HashMap r2 = new HashMap();
        HashSet r3 = new HashSet();
        Iterator r4 = r13.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L19;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        m r6 = (m) ZeusTransformUtils.preCheckCast(r5.getKey(), m.class, "com.obric.memorydata.plugin");
        Long r7 = (Long) ZeusTransformUtils.preCheckCast(r5.getValue(), Long.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L7;
        if (r7.longValue() < 0) goto L7;
        m r8 = a(r6, r7.longValue(), r13);
        if (r8 == null) goto L14;
        if (r8 != r6) goto L17;
        r3.add(r6);
        goto L7
    L17:
        r2.put(r6, r8);
        goto L7
    L14:
        Log.d("PdfBox-Android", "Stop checking xref offsets as at least one (" + r6 + ") couldn't be dereferenced");
        return false;
    L19:
        HashMap r11 = new HashMap();
        Iterator r9 = r2.entrySet().iterator();
    L21:
        if (r9.hasNext() == false) goto L25;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r3.contains(r10.getValue()) == true) goto L21;
        r11.put(r10.getValue(), r13.get(r10.getKey()));
        goto L21
    L25:
        Iterator r14 = r2.entrySet().iterator();
    L27:
        if (r14.hasNext() == false) goto L29;
        r13.remove(((Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getKey());
        goto L27
    L29:
        Iterator r15 = r11.entrySet().iterator();
    L31:
        if (r15.hasNext() == false) goto L33;
        Map.Entry r16 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r13.put(r16.getKey(), r16.getValue());
        goto L31
    L33:
        return true;
    }

    private boolean a(byte[] r6) {
        if (this.d.d() != r6[0]) goto L14;
        int r0 = r6.length;
        byte[] r2 = new byte[r0];
        int r1 = this.d.read(r2, 0, r0);
    L5:
        if (r1 >= r0) goto L10;
        int r3 = this.d.read(r2, r1, r0 - r1);
        if (r3 < 0) goto L10;
        r1 = r1 + r3;
    L10:
        boolean r7 = Arrays.equals(r6, r2);
        this.d.a(r1);
        return r7;
    L14:
        return false;
    }

    private boolean a(char[] r8) {
        long r0 = this.d.a();
        int r2 = r8.length;
        boolean r3 = false;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L8;
        if (this.d.read() != r8[r4]) goto L9;
        r4 = r4 + 1;
    L9:
        this.d.a(r0);
        return r3;
    L8:
        r3 = true;
        goto L9
    }

    private long b(long r9, boolean r11) {
        if (r9 >= 0) goto L7;
        StringBuilder r8 = new StringBuilder().append("Invalid object offset ").append(r9).append(" when searching for a xref table/stream");
    L5:
        Log.e("PdfBox-Android", r8.toString());
        return 0;
    L7:
        long r4 = c(r9, r11);
        if (r4 <= (-1)) goto L11;
        Log.d("PdfBox-Android", "Fixed reference for xref table/stream " + r9 + " -> " + r4);
        return r4;
    L11:
        r8 = new StringBuilder().append("Can't find the object xref table/stream at offset ").append(r9);
        goto L5
    }

    private com.tom_roush.pdfbox.a.d b(com.tom_roush.pdfbox.a.l r6) {
        m r0 = new m(r6);
        Long r7 = (Long) ZeusTransformUtils.preCheckCast(this.z.get(r0), Long.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L6;
        long r1 = this.d.a();
        com.tom_roush.pdfbox.a.d r8 = a(r0, r7.longValue());
        this.d.a(r1);
        return r8;
    L6:
        return null;
    }

    private long c(long r8, boolean r10) {
        if (r10 == true) goto L4;
        E();
    L4:
        F();
        if (r10 == true) goto L9;
        List<Long> r11 = this.B;
        if (r11 == null) goto L9;
        long r2 = a(r11, r8);
    L10:
        List<Long> r12 = this.C;
        if (r12 == null) goto L13;
        long r4 = a(r12, r8);
    L15:
        if (r2 > (-1)) goto L17;
    L21:
        if (r2 <= (-1)) goto L24;
    L22:
        this.B.remove(Long.valueOf(r2));
        return r2;
    L24:
        if (r4 <= (-1)) goto L28;
    L25:
        this.C.remove(Long.valueOf(r4));
        return r4;
    L28:
        return -1;
    L17:
        if (r4 <= (-1)) goto L21;
        if (Math.abs(r8 - r2) <= Math.abs(r8 - r4)) goto L22;
    L13:
        r4 = -1;
    L9:
        r2 = -1;
        goto L10
    }

    private void c(com.tom_roush.pdfbox.a.l r4) {
        a(r4, true);
        if (ZeusTransformUtils.instanceOf(r4.a(), com.tom_roush.pdfbox.a.d.class) == false) goto L14;
        Iterator<com.tom_roush.pdfbox.a.b> r5 = ((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r4.a(), com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin")).f().iterator();
    L6:
        if (r5.hasNext() == false) goto L12;
        com.tom_roush.pdfbox.a.b r0 = (com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r5.next(), com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, com.tom_roush.pdfbox.a.l.class) == false) goto L6;
        com.tom_roush.pdfbox.a.l r1 = (com.tom_roush.pdfbox.a.l) ZeusTransformUtils.preCheckCast(r0, com.tom_roush.pdfbox.a.l.class, "com.obric.memorydata.plugin");
        if (r1.a() != null) goto L6;
        c(r1);
        goto L6
    L12:
        return;
    L14:
        throw new IOException("Dictionary object expected at offset " + this.d.a());
    }

    private boolean c(long r11) {
        long r0 = this.d.a();
        long r2 = r0 + r11;
        boolean r8 = false;
        if (r2 <= this.g) goto L5;
        Log.w("PdfBox-Android", "The end of the stream is out of range, using workaround to read the stream, stream start position: " + r0 + ", length: " + r11 + ", expected end position: " + r2);
    L10:
        return r8;
    L5:
        this.d.a(r2);
        l();
        if (a(n) == true) goto L8;
        Log.w("PdfBox-Android", "The end of the stream doesn't point to the correct offset, using workaround to read the stream, stream start position: " + r0 + ", length: " + r11 + ", expected end position: " + r2);
    L9:
        this.d.a(r0);
        goto L10
    L8:
        r8 = true;
        goto L9
    }

    private long d(long r3) {
        if (this.x == true) goto L5;
        return r3;
    L5:
        this.d.a(r3);
        l();
        if (this.d.d() != 120) goto L11;
        if (a(k) == false) goto L11;
        return r3;
    L11:
        if (r3 > 0) goto L13;
        return -1;
    L13:
        if (e(r3) == false) goto L16;
        return r3;
    L16:
        return b(r3, false);
    }

    private boolean e(long r5) {
        if (this.x == true) goto L5;
    L17:
        return true;
    L5:
        if (r5 == 0) goto L17;
        this.d.a(r5 - 1);
        if (d(this.d.read()) == false) goto L20;
        l();
        if (k() == false) goto L21;
        m();     // Catch: IOException -> L14
        n();     // Catch: IOException -> L14
        a(f, true);     // Catch: IOException -> L14
        com.tom_roush.pdfbox.a.d r0 = a();     // Catch: IOException -> L14
        this.d.a(r5);     // Catch: IOException -> L14
        if ("XRef".equals(r0.g(com.tom_roush.pdfbox.a.i.iz)) == false) goto L22;
        return true;
    L22:
        return false;
    L14:
        this.d.a(r5);
        return false;
    L21:
        return false;
    L20:
        return false;
    }

    private boolean e(com.tom_roush.pdfbox.a.d r10) {
        long r0 = this.d.a();
        this.d.a(6);
    L3:
        boolean r3 = false;
        if (this.d.e() == true) goto L39;
        char[] r2 = u;
        if (a(r2) == false) goto L38;
        com.tom_roush.pdfbox.io.g r4 = this.d;
        r4.a(r4.a() + ((long) r2.length));
        l();     // Catch: IOException -> L41
        com.tom_roush.pdfbox.a.d r5 = a();     // Catch: IOException -> L41
        com.tom_roush.pdfbox.a.l r6 = r5.c(com.tom_roush.pdfbox.a.i.gY);     // Catch: IOException -> L41
        if (r6 == null) goto L15;
        com.tom_roush.pdfbox.a.d r7 = b(r6);     // Catch: IOException -> L41
        if (r7 == null) goto L15;
        if (c(r7) == false) goto L15;
        boolean r8 = true;
    L16:
        com.tom_roush.pdfbox.a.l r9 = r5.c(com.tom_roush.pdfbox.a.i.dV);     // Catch: IOException -> L41
        if (r9 == null) goto L23;
        com.tom_roush.pdfbox.a.d r11 = b(r9);     // Catch: IOException -> L41
        if (r11 == null) goto L23;
        if (g(r11) == false) goto L23;
        r3 = true;
    L23:
        if (r8 == false) goto L38;
        if (r3 == false) goto L38;
        r10.a(com.tom_roush.pdfbox.a.i.gY, r6);     // Catch: IOException -> L41
        r10.a(com.tom_roush.pdfbox.a.i.dV, r9);     // Catch: IOException -> L41
        if (r5.m(com.tom_roush.pdfbox.a.i.cD) == false) goto L33;
        com.tom_roush.pdfbox.a.l r12 = r5.c(com.tom_roush.pdfbox.a.i.cD);     // Catch: IOException -> L41
        if (r12 == null) goto L33;
        if (b(r12) == null) goto L33;
        r10.a(com.tom_roush.pdfbox.a.i.cD, r12);     // Catch: IOException -> L41
    L33:
        if (r5.m(com.tom_roush.pdfbox.a.i.dJ) == false) goto L37;
        com.tom_roush.pdfbox.a.b r13 = r5.l(com.tom_roush.pdfbox.a.i.dJ);     // Catch: IOException -> L41
        if (ZeusTransformUtils.instanceOf(r13, com.tom_roush.pdfbox.a.a.class) == false) goto L37;
        r10.a(com.tom_roush.pdfbox.a.i.dJ, r13);     // Catch: IOException -> L41
    L37:
        return true;
    L15:
        r8 = false;
    L38:
        this.d.read();
        goto L3
    L39:
        this.d.a(r0);
        return false;
    }

    private boolean f(com.tom_roush.pdfbox.a.d r11) {
        Iterator<Map.Entry<m, Long>> r0 = this.z.entrySet().iterator();
        com.tom_roush.pdfbox.a.l r1 = null;
        com.tom_roush.pdfbox.a.l r2 = null;
        Long r3 = null;
        Long r4 = null;
    L4:
        if (r0.hasNext() == false) goto L18;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        com.tom_roush.pdfbox.a.d r6 = a((m) ZeusTransformUtils.preCheckCast(r5.getKey(), m.class, "com.obric.memorydata.plugin"), ((Long) ZeusTransformUtils.preCheckCast(r5.getValue(), Long.class, "com.obric.memorydata.plugin")).longValue());
        if (r6 == null) goto L4;
        if (c(r6) == true) goto L10;
        if (g(r6) == false) goto L4;
        com.tom_roush.pdfbox.a.l r7 = this.c.a((m) ZeusTransformUtils.preCheckCast(r5.getKey(), m.class, "com.obric.memorydata.plugin"));
        r2 = a(r7, (Long) ZeusTransformUtils.preCheckCast(r5.getValue(), Long.class, "com.obric.memorydata.plugin"), r2, r4);
        if (r2 != r7) goto L4;
        r4 = (Long) ZeusTransformUtils.preCheckCast(r5.getValue(), Long.class, "com.obric.memorydata.plugin");
        goto L4
    L10:
        com.tom_roush.pdfbox.a.l r8 = this.c.a((m) ZeusTransformUtils.preCheckCast(r5.getKey(), m.class, "com.obric.memorydata.plugin"));
        r1 = a(r8, (Long) ZeusTransformUtils.preCheckCast(r5.getValue(), Long.class, "com.obric.memorydata.plugin"), r1, r3);
        if (r1 != r8) goto L4;
        r3 = (Long) ZeusTransformUtils.preCheckCast(r5.getValue(), Long.class, "com.obric.memorydata.plugin");
        goto L4
    L18:
        if (r1 == null) goto L20;
        r11.a(com.tom_roush.pdfbox.a.i.gY, r1);
    L20:
        if (r2 == null) goto L22;
        r11.a(com.tom_roush.pdfbox.a.i.dV, r2);
    L22:
        if (r1 == null) goto L24;
        return true;
    L24:
        return false;
    }

    private boolean g(com.tom_roush.pdfbox.a.d r2) {
        if (r2.m(com.tom_roush.pdfbox.a.i.ge) == false) goto L5;
        return false;
    L5:
        if (r2.m(com.tom_roush.pdfbox.a.i.f16057a) == false) goto L7;
        return false;
    L7:
        if (r2.m(com.tom_roush.pdfbox.a.i.bH) == false) goto L10;
        return false;
    L10:
        if (r2.m(com.tom_roush.pdfbox.a.i.fe) == false) goto L12;
    L25:
        return true;
    L12:
        if (r2.m(com.tom_roush.pdfbox.a.i.ii) == true) goto L25;
        if (r2.m(com.tom_roush.pdfbox.a.i.L) == true) goto L25;
        if (r2.m(com.tom_roush.pdfbox.a.i.hR) == true) goto L25;
        if (r2.m(com.tom_roush.pdfbox.a.i.ej) == true) goto L25;
        if (r2.m(com.tom_roush.pdfbox.a.i.bn) == true) goto L25;
        if (r2.m(com.tom_roush.pdfbox.a.i.gz) == true) goto L25;
        if (r2.m(com.tom_roush.pdfbox.a.i.bm) == true) goto L25;
        return false;
    }

    private void h(int r9) {
        com.tom_roush.pdfbox.a.b r2 = a(r9, 0, true);
        if (ZeusTransformUtils.instanceOf(r2, n.class) == true) goto L27;
        return;
    L27:
        e r3 = new e((n) ZeusTransformUtils.preCheckCast(r2, n.class, "com.obric.memorydata.plugin"), this.c);     // Catch: IOException -> L20
        r3.r();     // Catch: IOException -> L14
        Iterator<com.tom_roush.pdfbox.a.l> r0 = r3.s().iterator();
    L8:
        if (r0.hasNext() == false) goto L38;
        com.tom_roush.pdfbox.a.l r4 = (com.tom_roush.pdfbox.a.l) ZeusTransformUtils.preCheckCast(r0.next(), com.tom_roush.pdfbox.a.l.class, "com.obric.memorydata.plugin");
        m r5 = new m(r4);
        Long r6 = (Long) ZeusTransformUtils.preCheckCast(this.j.d().get(r5), Long.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L8;
        if (r6.longValue() != (-r9)) goto L8;
        this.c.a(r5).a(r4.a());
        goto L8
    L38:
        return;
    L14:
        e = move-exception;
        if (this.x == false) goto L19;
        Log.d("PdfBox-Android", "Stop reading object stream " + r9 + " due to an exception", e);
        return;
    L19:
        throw e;
    L20:
        e = move-exception;
        if (this.x == false) goto L25;
        Log.e("PdfBox-Android", "object stream " + r9 + " could not be parsed due to an exception", e);
        return;
    L25:
        throw e;
    }

    public int a(char[] r4, byte[] r5, int r6) {
        int r3 = r4.length - 1;
        char r0 = r4[r3];
    L3:
        int r1 = r3;
    L4:
        r6 = r6 - 1;
        if (r6 < 0) goto L14;
        if (r5[r6] == r0) goto L8;
        if (r1 >= r3) goto L4;
        r0 = r4[r3];
        goto L3
    L8:
        r1 = r1 - 1;
        if (r1 < 0) goto L10;
        r0 = r4[r1];
        goto L4
    L10:
        return r6;
    L14:
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public com.tom_roush.pdfbox.a.b a(long r10, int r12, boolean r13) {
        m r0 = new m(r10, r12);
        com.tom_roush.pdfbox.a.l r1 = this.c.a(r0);
        if (r1.a() != null) goto L46;
        Long r2 = (Long) ZeusTransformUtils.preCheckCast(this.c.i().get(r0), Long.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L12;
        if (this.x == false) goto L12;
        B();
        r2 = (Long) ZeusTransformUtils.preCheckCast(this.z.get(r0), Long.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L12;
        Log.d("PdfBox-Android", "Set missing offset " + r2 + " for object " + r0);
        this.c.i().put(r0, r2);
    L12:
        if (r13 == false) goto L20;
        if (r2 == null) goto L18;
        if (r2.longValue() > 0) goto L20;
    L18:
        throw new IOException("Object must be defined and must not be compressed object: " + r0.b() + ParameterizedMessage.ERROR_MSG_SEPARATOR + r0.a());
    L20:
        if (r1.b() == true) goto L44;
        r1.c();
        if (r2 == null) goto L24;
    L36:
        if (r2 != null) goto L39;
        r1.a(com.tom_roush.pdfbox.a.j.f16062b);
    L42:
        r1.d();
        goto L46
    L39:
        if (r2.longValue() <= 0) goto L41;
        a(r2, r0, r1);
        goto L42
    L41:
        h((int) (-r2.longValue()));
        goto L42
    L24:
        if (this.x == false) goto L36;
        if (this.z != null) goto L36;
        B();
        if (this.z.isEmpty() == true) goto L36;
        Log.d("PdfBox-Android", "Add all new read objects from brute force search to the xref table");
        Map<m, Long> r11 = this.c.i();
        Iterator<Map.Entry<m, Long>> r14 = this.z.entrySet().iterator();
    L31:
        if (r14.hasNext() == false) goto L35;
        Map.Entry r15 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        m r16 = (m) ZeusTransformUtils.preCheckCast(r15.getKey(), m.class, "com.obric.memorydata.plugin");
        if (r11.containsKey(r16) == true) goto L31;
        r11.put(r16, r15.getValue());
        goto L31
    L35:
        r2 = (Long) ZeusTransformUtils.preCheckCast(r11.get(r0), Long.class, "com.obric.memorydata.plugin");
        goto L36
    L44:
        throw new IOException("Possible recursion detected when dereferencing object " + r10 + " " + r12);
    L46:
        return r1.a();
    }

    public final com.tom_roush.pdfbox.a.b a(com.tom_roush.pdfbox.a.l r3, boolean r4) {
        return a(r3.f(), r3.g(), r4);
    }

    public com.tom_roush.pdfbox.a.d a(long r17) {
        this.d.a(r17);
        long r4 = 0;
        long r2 = Math.max(0, G());
        long r6 = d(r2);
        long r8 = -1;
        if (r6 <= (-1)) goto L5;
        r2 = r6;
    L5:
        this.c.b(r2);
        HashSet r7 = new HashSet();
        long r10 = r2;
    L6:
        boolean r9 = true;
        if (r10 <= r4) goto L54;
        r7.add(Long.valueOf(r10));
        this.d.a(r10);
        l();
        r7.add(Long.valueOf(this.d.a()));
        if (this.d.d() == 120) goto L11;
        long r5 = a(r10, true);
        com.tom_roush.pdfbox.a.d r11 = this.j.b();
    L41:
        if (r5 <= 0) goto L47;
        r10 = d(r5);
        long r12 = -1;
        if (r10 > (-1)) goto L45;
    L48:
        r10 = r5;
    L50:
        if (r7.contains(Long.valueOf(r10)) == true) goto L53;
        r4 = 0;
        r8 = r12;
        goto L6
    L53:
        throw new IOException("/Prev loop at offset " + r10);
    L45:
        if (r10 == r5) goto L48;
        r11.a(com.tom_roush.pdfbox.a.i.gs, r10);
        goto L50
    L47:
        r12 = -1;
        goto L48
    L11:
        if (b(r10) == false) goto L38;
        if (H() == false) goto L38;
        r11 = this.j.b();
        if (r11.m(com.tom_roush.pdfbox.a.i.jk) == false) goto L36;
        int r0 = r11.i(com.tom_roush.pdfbox.a.i.jk);
        long r13 = r0;
        long r14 = d(r13);
        if (r14 > r8) goto L19;
    L21:
        int r15 = r0;
        if (r15 <= 0) goto L32;
        this.d.a(r15);
        l();
        a(r10, false);     // Catch: IOException -> L26
    L26:
        e = move-exception;
        if (this.x == false) goto L30;
        Log.e("PdfBox-Android", "Failed to parse /XRefStm at offset " + r15, e);
        goto L36
    L30:
        throw e;
    L32:
        if (this.x == false) goto L35;
        Log.e("PdfBox-Android", "Skipped XRef stream due to a corrupt offset:" + r15);
        goto L36
    L35:
        throw new IOException("Skipped XRef stream due to a corrupt offset:" + r15);
    L19:
        if (r14 == r13) goto L21;
        Log.w("PdfBox-Android", "/XRefStm offset " + r0 + " is incorrect, corrected to " + r14);
        r0 = (int) r14;
        r11.a(com.tom_roush.pdfbox.a.i.jk, r0);
    L36:
        r5 = r11.j(com.tom_roush.pdfbox.a.i.gs);
    L38:
        throw new IOException("Expected trailer object at offset " + this.d.a());
    L54:
        this.j.a(r2);
        com.tom_roush.pdfbox.a.d r1 = this.j.c();
        this.c.b(r1);
        com.tom_roush.pdfbox.a.e r3 = this.c;
        if (XrefTrailerResolver.XRefType.STREAM == this.j.a()) goto L58;
        r9 = false;
    L58:
        r3.b(r9);
        A();
        this.c.a(this.j.d());
        return r1;
    }

    public n a(com.tom_roush.pdfbox.a.d r8) {
        n r0 = this.c.a(r8);
        g();
        b();
        k r9 = a(r8.l(com.tom_roush.pdfbox.a.i.ew), r8.b(com.tom_roush.pdfbox.a.i.iz));
        if (r9 == null) goto L5;
    L9:
        if (r9 != null) goto L11;
    L18:
        OutputStream r2 = r0.i();
        a(new c(r2));     // Catch: Throwable -> L41
        r2.close();
        if (r9 == null) goto L23;
    L22:
        r0.a(com.tom_roush.pdfbox.a.i.ew, r9);
    L23:
        String r10 = g();
        if (r10.equals("endobj") == false) goto L30;
        if (this.x == false) goto L30;
        Log.w("PdfBox-Android", "stream ends with 'endobj' instead of 'endstream' at offset " + this.d.a());
        com.tom_roush.pdfbox.io.g r7 = this.d;
        int r11 = o.length;
    L28:
        r7.a(r11);
    L38:
        return r0;
    L30:
        if (r10.length() <= 9) goto L37;
        if (this.x == false) goto L37;
        if (r10.startsWith("endstream") == false) goto L37;
        Log.w("PdfBox-Android", "stream ends with '" + r10 + "' instead of 'endstream' at offset " + this.d.a());
        r7 = this.d;
        r11 = r10.substring(9).getBytes(com.tom_roush.pdfbox.util.a.d).length;
    L37:
        if (r10.equals("endstream") == true) goto L38;
        throw new IOException("Error reading stream, expected='endstream' actual='" + r10 + "' at offset " + this.d.a());
    L41:
        th = move-exception;
        r2.close();
        if (r9 == null) goto L45;
        r0.a(com.tom_roush.pdfbox.a.i.ew, r9);
    L45:
        throw th;
    L11:
        if (c(r9.b()) == false) goto L18;
        OutputStream r3 = r0.i();
        a(r3, r9);     // Catch: Throwable -> L15
        r3.close();
    L15:
        th = move-exception;
        r3.close();
        r0.a(com.tom_roush.pdfbox.a.i.ew, r9);
        throw th;
    L5:
        if (this.x == false) goto L8;
        Log.w("PdfBox-Android", "The stream doesn't provide any stream length, using fallback readUntilEnd, at offset " + this.d.a());
        goto L9
    L8:
        throw new IOException("Missing length for stream.");
    }

    public void a(com.tom_roush.pdfbox.a.d r20, com.tom_roush.pdfbox.a.i... r21) {
        LinkedList r1 = new LinkedList();
        TreeMap r2 = new TreeMap();
        HashSet r3 = new HashSet();
        HashSet r4 = new HashSet();
        a(r21, r20, r3);
        a(r1, r20.f(), r4);
    L4:
        if (r1.isEmpty() == false) goto L7;
        if (r2.isEmpty() == false) goto L7;
        return;
    L7:
        com.tom_roush.pdfbox.a.b r5 = (com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r1.poll(), com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L62;
        if (ZeusTransformUtils.instanceOf(r5, com.tom_roush.pdfbox.a.d.class) == true) goto L11;
        if (ZeusTransformUtils.instanceOf(r5, com.tom_roush.pdfbox.a.a.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r5, com.tom_roush.pdfbox.a.l.class) == false) goto L7;
        com.tom_roush.pdfbox.a.l r6 = (com.tom_roush.pdfbox.a.l) ZeusTransformUtils.preCheckCast(r5, com.tom_roush.pdfbox.a.l.class, "com.obric.memorydata.plugin");
        long r8 = a(r6);
        m r10 = new m(r6.f(), r6.g());
        if (r3.contains(Long.valueOf(r8)) == true) goto L7;
        Long r9 = (Long) ZeusTransformUtils.preCheckCast(this.c.i().get(r10), Long.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L25;
    L29:
        if (r9 == null) goto L60;
        if (r9.longValue() == 0) goto L60;
        if (r9.longValue() > 0) goto L34;
        m r13 = new m((int) (-r9.longValue()), 0);
        Long r7 = (Long) ZeusTransformUtils.preCheckCast(this.c.i().get(r13), Long.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L40;
        if (r7.longValue() <= 0) goto L40;
    L44:
        List r11 = (List) ZeusTransformUtils.preCheckCast(r2.get(r7), List.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L48;
        r11 = new ArrayList();
        r2.put(r7, r11);
    L49:
        r11.add(r6);
        goto L7
    L48:
        if (ZeusTransformUtils.instanceOf(r11, ArrayList.class) == true) goto L49;
        throw new IOException(r6 + " cannot be assigned to offset " + r7 + ", this belongs to " + r11.get(0));
    L40:
        if (this.x == false) goto L54;
        B();
        r7 = (Long) ZeusTransformUtils.preCheckCast(this.z.get(r13), Long.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L43;
        String r12 = "Invalid object stream xref object reference for key '" + r10 + "': " + r7;
    L53:
        Log.w("PdfBox-Android", r12);
        goto L7
    L43:
        Log.d("PdfBox-Android", "Set missing " + r7 + " for object " + r13);
        this.c.i().put(r13, r7);
        goto L44
    L54:
        r12 = "Invalid object stream xref object reference for key '" + r10 + "': " + r7;
        if (this.x == false) goto L59;
        if (r7 == null) goto L53;
    L59:
        throw new IOException(r12);
    L34:
        r2.put(r9, Collections.singletonList(r6));
    L60:
        this.c.a(r10).a(com.tom_roush.pdfbox.a.j.f16062b);
        goto L7
    L25:
        if (this.x == false) goto L29;
        B();
        r9 = (Long) ZeusTransformUtils.preCheckCast(this.z.get(r10), Long.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L29;
        Log.d("PdfBox-Android", "Set missing " + r9 + " for object " + r10);
        this.c.i().put(r10, r9);
        goto L29
    L14:
        Iterator<com.tom_roush.pdfbox.a.b> r14 = ((com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r5, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r14.hasNext() == false) goto L7;
        a(r1, (com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r14.next(), com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin"), r4);
        goto L16
    L11:
        a(r1, ((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r5, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin")).f(), r4);
        goto L7
    L62:
        if (r2.isEmpty() == true) goto L106;
        Iterator r15 = ((List) ZeusTransformUtils.preCheckCast(r2.remove(r2.firstKey()), List.class, "com.obric.memorydata.plugin")).iterator();
    L66:
        if (r15.hasNext() == false) goto L4;
        com.tom_roush.pdfbox.a.l r16 = (com.tom_roush.pdfbox.a.l) ZeusTransformUtils.preCheckCast(r15.next(), com.tom_roush.pdfbox.a.l.class, "com.obric.memorydata.plugin");
        com.tom_roush.pdfbox.a.b r17 = a(r16, false);
        if (r17 == null) goto L66;
        r16.a(r17);
        a(r1, r17, r4);
        r3.add(Long.valueOf(a(r16)));
        goto L66
    }

    public void b(com.tom_roush.pdfbox.a.d r3) {
        if (this.y == false) goto L9;
        if (r3 == null) goto L10;
        com.tom_roush.pdfbox.a.b r4 = r3.a(com.tom_roush.pdfbox.a.i.ga);
        if (ZeusTransformUtils.instanceOf(r4, com.tom_roush.pdfbox.a.d.class) == false) goto L11;
        a((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r4, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"), new HashSet());
        return;
    L11:
        return;
    L10:
        return;
    }

    public boolean b(long r14) {
        if (this.d.d() == 120) goto L6;
        return false;
    L6:
        if (g().trim().equals("xref") == true) goto L8;
        return false;
    L8:
        String r0 = g();
        this.d.a(r0.getBytes(com.tom_roush.pdfbox.util.a.d).length);
        this.j.a(r14, XrefTrailerResolver.XRefType.TABLE);
        if (r0.startsWith("trailer") == false) goto L13;
        String r13 = "skipping empty xref table";
    L11:
        Log.w("PdfBox-Android", r13);
        return false;
    L13:
        String r15 = h();
        String[] r2 = r15.split("\\s");
        if (r2.length != 2) goto L15;
        long r5 = Long.parseLong(r2[0]);     // Catch: NumberFormatException -> L51
        int r16 = Integer.parseInt(r2[1]);     // Catch: NumberFormatException -> L50
        l();
        int r3 = 0;
    L21:
        if (r3 >= r16) goto L47;
        if (this.d.e() == true) goto L47;
        if (a((char) this.d.d()) == true) goto L47;
        if (this.d.d() == 116) goto L47;
        String r7 = h();
        String[] r8 = r7.split("\\s");
        if (r8.length < 3) goto L32;
        if (r8[r8.length - 1].equals("n") == false) goto L43;
        long r9 = Long.parseLong(r8[0]);     // Catch: NumberFormatException -> L39
        if (r9 <= 0) goto L44;
        this.j.a(new m(r5, Integer.parseInt(r8[1])), r9);     // Catch: NumberFormatException -> L39
    L44:
        r5 = r5 + 1;
        l();
        r3 = r3 + 1;
    L39:
        e = move-exception;
        throw new IOException(e);
    L43:
        if (r8[2].equals(com.bytedance.apm.util.f.f1488a) == true) goto L44;
        throw new IOException("Corrupt XRefTable Entry - ObjID:" + r5);
    L32:
        Log.w("PdfBox-Android", "invalid xref line: " + r7);
    L47:
        l();
        if (k() == true) goto L13;
        return true;
    L50:
        StringBuilder r17 = new StringBuilder();
        String r1 = "XRefTable: invalid number of objects: ";
    L16:
        r13 = r17.append(r1).append(r15).toString();
    L51:
        r17 = new StringBuilder();
        r1 = "XRefTable: invalid ID for the first object: ";
        goto L16
    L15:
        r17 = new StringBuilder();
        r1 = "Unexpected XRefTable Entry: ";
        goto L16
    }

    public boolean c(com.tom_roush.pdfbox.a.d r2) {
        return com.tom_roush.pdfbox.a.i.au.equals(r2.b(com.tom_roush.pdfbox.a.i.iz));
    }

    public com.tom_roush.pdfbox.a.b d(com.tom_roush.pdfbox.a.d r5) {
        Iterator<com.tom_roush.pdfbox.a.b> r0 = r5.f().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        com.tom_roush.pdfbox.a.b r1 = (com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r0.next(), com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, com.tom_roush.pdfbox.a.l.class) == false) goto L4;
        a((com.tom_roush.pdfbox.a.l) ZeusTransformUtils.preCheckCast(r1, com.tom_roush.pdfbox.a.l.class, "com.obric.memorydata.plugin"), false);
        goto L4
    L8:
        com.tom_roush.pdfbox.a.l r4 = r5.c(com.tom_roush.pdfbox.a.i.gY);
        if (r4 == null) goto L13;
        return r4.a();
    L13:
        throw new IOException("Missing root object specification in trailer.");
    }

    public void g(int r2) {
        if (r2 <= 15) goto L6;
        this.E = r2;
        return;
    }

    public com.tom_roush.pdfbox.a.d r() {
        com.tom_roush.pdfbox.a.d r0 = null;
        long r1 = s();     // Catch: IOException -> L8
        if (r1 <= (-1)) goto L6;
        r0 = a(r1);     // Catch: IOException -> L8
        boolean r2 = false;
    L25:
    L12:
        if (r0 != null) goto L14;
    L16:
        if (r2 == true) goto L28;
        I();
        Map<m, Long> r3 = this.z;
        if (r3 != null) goto L21;
        return r0;
    L21:
        if (r3.isEmpty() == true) goto L30;
        D();
        return r0;
    L30:
        return r0;
    L28:
        return u();
    L14:
        if (r0.l(com.tom_roush.pdfbox.a.i.gY) != null) goto L16;
        r2 = t();
        goto L16
    L6:
        r2 = t();     // Catch: IOException -> L8
    L8:
        e = move-exception;
        if (t() == false) goto L24;
        r2 = true;
        goto L12
    L24:
        throw e;
    }

    public final long s() {
        long r2 = this.g;     // Catch: Throwable -> L27
        int r4 = this.E;     // Catch: Throwable -> L27
        if (r2 >= r4) goto L6;
        r4 = (int) r2;     // Catch: Throwable -> L27
    L6:
        byte[] r5 = new byte[r4];     // Catch: Throwable -> L27
        long r3 = r2 - ((long) r4);     // Catch: Throwable -> L27
        this.d.a(r3);     // Catch: Throwable -> L27
        int r6 = 0;
    L7:
        if (r6 >= r4) goto L13;
        int r8 = r4 - r6;     // Catch: Throwable -> L27
        int r7 = this.d.read(r5, r6, r8);     // Catch: Throwable -> L27
        if (r7 < 1) goto L12;
        r6 = r6 + r7;     // Catch: Throwable -> L27
        goto L7
    L12:
        throw new IOException("No more bytes to read for trailing buffer, but expected: " + r8);     // Catch: Throwable -> L27
    L13:
        this.d.a(0);
        char[] r0 = e;
        int r1 = a(r0, r5, r4);
        if (r1 < 0) goto L16;
        r4 = r1;
    L21:
        int r10 = a(m, r5, r4);
        if (r10 < 0) goto L26;
        return r3 + ((long) r10);
    L26:
        throw new IOException("Missing 'startxref' marker.");
    L16:
        if (this.x == false) goto L19;
        Log.d("PdfBox-Android", "Missing end of file marker '" + new String(r0) + "'");
        goto L21
    L19:
        throw new IOException("Missing end of file marker '" + new String(r0) + "'");
    L27:
        th = move-exception;
        this.d.a(0);
        throw th;
    }

    public boolean t() {
        return this.x;
    }

    public final com.tom_roush.pdfbox.a.d u() {
        B();
        if (this.z == null) goto L16;
        this.j.e();
        this.j.a(0, XrefTrailerResolver.XRefType.TABLE);
        Iterator<Map.Entry<m, Long>> r0 = this.z.entrySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        this.j.a((m) ZeusTransformUtils.preCheckCast(r2.getKey(), m.class, "com.obric.memorydata.plugin"), ((Long) ZeusTransformUtils.preCheckCast(r2.getValue(), Long.class, "com.obric.memorydata.plugin")).longValue());
        goto L6
    L8:
        this.j.a(0);
        com.tom_roush.pdfbox.a.d r1 = this.j.c();
        x().b(r1);
        boolean r3 = false;
        if (e(r1) == false) goto L11;
    L13:
        I();
        if (r3 == true) goto L17;
        D();
    L17:
        this.y = true;
        return r1;
    L11:
        if (f(r1) == true) goto L13;
        D();
        f(r1);
        r3 = true;
        goto L13
    L16:
        r1 = null;
        goto L17
    }

    public boolean v() {
        return a("%PDF-", "1.4");
    }

    public boolean w() {
        return a("%FDF-", "1.0");
    }

    public com.tom_roush.pdfbox.a.e x() {
        if (this.c == null) goto L7;
        return this.c;
    L7:
        throw new IOException("You must parse the document first before calling getDocument()");
    }

    public com.tom_roush.pdfbox.pdmodel.encryption.e y() {
        if (this.c == null) goto L7;
        return this.D;
    L7:
        throw new IOException("You must parse the document first before calling getEncryption()");
    }

    public com.tom_roush.pdfbox.pdmodel.encryption.a z() {
        if (this.c == null) goto L7;
        return this.q;
    L7:
        throw new IOException("You must parse the document first before calling getAccessPermission()");
    }
}
