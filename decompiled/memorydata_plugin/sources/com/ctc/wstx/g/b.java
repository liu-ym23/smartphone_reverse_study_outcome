package com.ctc.wstx.g;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.ctc.wstx.util.InternCache;
import com.ctc.wstx.util.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final InternCache f3510a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final String f3511b;
    protected final String c;
    protected a[] d;
    protected int e;
    protected int f;
    protected a[] g;
    protected int h;
    protected boolean i;
    protected int j;
    protected m k;
    protected int[] l;
    protected int m;
    protected int n;
    protected int o;
    private final m p;

    static {
        f3510a = InternCache.getInstance();
    }

    public b(com.ctc.wstx.a.b r4, boolean r5) {
        this.i = false;
        this.k = null;
        this.p = new m(6);
        this.l = null;
        if (r4.j() == false) goto L5;
        int r1 = -1;
    L6:
        this.j = r1;
        if (r5 == false) goto L9;
        this.f3511b = "xml";
        String r6 = OaidModel.KEY_ID;
    L10:
        this.c = r6;
        this.o = r4.p();
        return;
    L9:
        this.f3511b = null;
        r6 = "xml:id";
        goto L10
    L5:
        r1 = -2;
        goto L6
    }

    private int[] a(String r3, String r4, int[] r5, int r6, int r7, int r8, int r9) {
        a r10 = this.d[r6];
        if (r10.f3508a != r4) goto L11;
        String r11 = r10.c;
        if (r11 == r3) goto L9;
        if (r11 == null) goto L11;
        if (r11.equals(r3) == false) goto L11;
    L9:
        return null;
    L11:
        if ((r7 + 1) < r5.length) goto L13;
        r5 = com.ctc.wstx.util.c.a(r5, 8);
    L13:
        if (r9 >= r7) goto L25;
        if (r5[r9] != r8) goto L24;
        int r12 = r5[r9 + 1];
        a r13 = this.d[r12];
        if (r13.f3508a != r4) goto L24;
        String r14 = r13.c;
        if (r14 == r3) goto L23;
        if (r14 == null) goto L24;
        if (r14.equals(r3) == false) goto L24;
    L23:
        return null;
    L24:
        r9 = r9 + 2;
        goto L13
    L25:
        r5[r7] = r8;
        return r5;
    }

    private void f() {
        this.n = 4;
        this.m = 4;
        int[] r1 = this.l;
        if (r1 != null) goto L5;
    L6:
        this.l = new int[4 + 1];
    L7:
        int[] r0 = this.l;
        r0[3] = 0;
        r0[2] = 0;
        r0[1] = 0;
        r0[0] = 0;
        e();
        return;
    L5:
        if (r1.length >= 4) goto L7;
        goto L6
    }

    public int a(f r17, com.ctc.wstx.util.j r18) {
        f r9 = (f) ZeusTransformUtils.wrapperContextForParams(r17, f.class, "com.obric.memorydata.plugin");
        int r10 = this.e;
        this.f = r10;
        boolean r11 = true;
        if (r10 >= 1) goto L7;
        this.n = 0;
        this.m = 0;
    L6:
        return this.j;
    L7:
        int r1 = 0;
    L8:
        if (r1 >= r10) goto L20;
        a r2 = this.d[r1];
        String r3 = r2.f3509b;
        if (r3 == null) goto L19;
        if (r3 != "xml") goto L14;
        r2.c = "http://www.w3.org/XML/1998/namespace";
        goto L19
    L14:
        String r5 = r18.a(r3);
        if (r5 != null) goto L17;
        r9.a(com.ctc.wstx.b.a.H, r3, r2.f3508a);
    L17:
        r2.c = r5;
    L19:
        r1 = r1 + 1;
        goto L8
    L20:
        int[] r4 = this.l;
        int r12 = 4;
    L21:
        if (r12 >= ((r10 >> 2) + r10)) goto L23;
        r12 = r12 + r12;
        goto L21
    L23:
        this.m = r12;
        int r6 = (r12 >> 4) + r12;
        if (r4 != null) goto L26;
    L29:
        r4 = new int[r6];
    L30:
        int r13 = r12 - 1;
        int r14 = 0;
        int[] r7 = r4;
        int r15 = r12;
    L31:
        if (r14 >= r10) goto L44;
        a r0 = this.d[r14];
        String r8 = r0.f3508a;
        int r16 = r8.hashCode();
        String r19 = r0.c;
        if (r19 == null) goto L35;
        int r20 = r19.hashCode() ^ r16;
    L36:
        int r21 = r20 & r13;
        if (r7[r21] != 0) goto L39;
        r7[r21] = r14 + 1;
        boolean r22 = r11;
    L43:
        r14 = r14 + 1;
        r11 = r22;
        goto L31
    L39:
        int r23 = r7[r21] - 1;
        r7 = a(r19, r8, r7, r23, r15, r20, r12);
        if (r7 != null) goto L42;
        a(r9, r23);
        r22 = true;
        goto L43
    L42:
        int r110 = r15 + 1;
        r7[r110] = r14;
        r22 = true;
        r15 = r110 + 1;
        goto L43
    L35:
        r20 = r16;
        goto L36
    L44:
        this.n = r15;
        this.l = r7;
        goto L6
    L26:
        if (r4.length < r6) goto L29;
        Arrays.fill(r4, 0, r12, 0);
        goto L30
    }

    public int a(String r12, String r13, String r14, String r15) {
        int r0 = this.e;
        if (r0 >= 1) goto L5;
        f();
    L5:
        int r2 = r12.hashCode();
        if (r13 != null) goto L8;
    L10:
        int r9 = r2;
        int r10 = this.m;
        int r3 = (r10 - 1) & r9;
        int[] r6 = this.l;
        if (r6[r3] != 0) goto L13;
        r6[r3] = r0 + 1;
    L18:
        a(r14, r12);
        a r16 = this.d[this.e - 1];
        r16.c = r13;
        r16.a(r15);
        return this.e - 1;
    L13:
        int r7 = r6[r3] - 1;
        int r4 = this.n;
        int[] r5 = a(r13, r12, r6, r7, r4, r9, r10);
        if (r5 != null) goto L17;
        return -1;
    L17:
        int r8 = r4 + 1;
        r5[r8] = r0;
        this.l = r5;
        this.n = r8 + 1;
        goto L18
    L8:
        if (r13.length() <= 0) goto L10;
        r2 = r2 ^ r13.hashCode();
        goto L10
    }

    public a a(int r4, boolean r5) {
        a r0 = this.g[r4];
        String r1 = this.p.b();
        int r2 = this.h;
        if (r2 == 0) goto L9;
        int r6 = r4 + 1;
        if (r6 >= r2) goto L8;
        r1 = r0.a(r1, this.g[r6].d);
        goto L9
    L8:
        r1 = r0.b(r1);
    L9:
        if (r5 == true) goto L11;
    L13:
        r0.c = r1;
        return r0;
    L11:
        if (r1.length() <= 0) goto L13;
        r1 = f3510a.intern(r1);
        goto L13
    }

    public m a(String r6) {
        int r0 = this.h;
        int r1 = 0;
        if (r0 == 0) goto L5;
        if (r6 == null) goto L14;
    L9:
        if (r1 >= r0) goto L14;
        if (r6 == this.g[r1].f3508a) goto L12;
        r1 = r1 + 1;
        goto L9
    L12:
        return null;
    L14:
        a[] r2 = this.g;
        if (r0 < r2.length) goto L21;
        int r3 = this.e + this.h;
        int r4 = this.o;
        if (r3 >= r4) goto L20;
        this.g = (a[]) ZeusTransformUtils.preCheckCast((a[]) ZeusTransformUtils.preCheckCast(com.ctc.wstx.util.c.a(r2, r4), a[].class, "com.obric.memorydata.plugin"), a[].class, "com.obric.memorydata.plugin");
        goto L21
    L20:
        throw new XMLStreamException("Attribute limit (" + this.o + ") exceeded");
    L21:
        int r5 = this.p.d();
        a[] r7 = this.g;
        a r8 = r7[r0];
        if (r8 != null) goto L24;
        r7[r0] = new a(null, r6, r5);
    L25:
        this.h++;
        return this.p;
    L24:
        r8.a(null, r6, r5);
        goto L25
    L5:
        if (this.g != null) goto L7;
        this.g = new a[Math.min(6, this.o)];
    L7:
        this.g[0] = new a(null, r6, 0);
        goto L25
    }

    public final m a(String r5, String r6) {
        if (this.e == 0) goto L5;
        int r0 = this.k.d();
        int r1 = this.e;
        a[] r2 = this.d;
        if (r1 < r2.length) goto L15;
        int r3 = r1 + this.h;
        int r4 = this.o;
        if (r3 >= r4) goto L14;
        this.d = (a[]) ZeusTransformUtils.preCheckCast((a[]) ZeusTransformUtils.preCheckCast(com.ctc.wstx.util.c.a(r2, r4), a[].class, "com.obric.memorydata.plugin"), a[].class, "com.obric.memorydata.plugin");
        goto L15
    L14:
        throw new XMLStreamException("Attribute limit (" + this.o + ") exceeded");
    L15:
        a[] r7 = this.d;
        int r8 = this.e;
        a r9 = r7[r8];
        if (r9 != null) goto L18;
        r7[r8] = new a(r5, r6, r0);
    L19:
        int r10 = this.e + 1;
        this.e = r10;
        if (r6 != this.c) goto L27;
        if (r5 != this.f3511b) goto L27;
        if (this.j == (-2)) goto L27;
        this.j = r10 - 1;
    L27:
        return this.k;
    L18:
        r9.a(r5, r6, r0);
        goto L19
    L5:
        if (this.d != null) goto L7;
        e();
    L7:
        this.d[0] = new a(r5, r6, 0);
        goto L19
    }

    public void a() {
        if (this.h <= 0) goto L6;
        this.p.a();
        this.i = false;
        this.h = 0;
    L6:
        if (this.e <= 0) goto L11;
        this.k.a();
        this.e = 0;
        if (this.j < 0) goto L12;
        this.j = -1;
        return;
    L12:
        return;
    }

    public void a(int r4) {
        String r0 = com.ctc.wstx.util.i.a(this.k.c(), g(r4), g(r4 + 1));
        if (r0 == null) goto L6;
        this.d[r4].a(r0);
        return;
    }

    public void a(int r9, org.codehaus.stax2.validation.g r10) {
        a r0 = this.d[r9];
        String r8 = r10.a(r0.f3508a, r0.c, r0.f3509b, this.k.c(), g(r9), g(r9 + 1));
        if (r8 == null) goto L6;
        r0.a(r8);
        return;
    }

    public void a(f r3, int r4) {
        ((f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin")).e("Duplicate attribute '" + e(r4) + "'.");
    }

    public int b() {
        return this.h;
    }

    public String b(int r2) {
        if (r2 >= 0) goto L4;
    L5:
        h(r2);
    L7:
        return this.d[r2].f3509b;
    L4:
        if (r2 < this.e) goto L7;
        goto L5
    }

    public final int c() {
        return this.e;
    }

    public String c(int r2) {
        if (r2 >= 0) goto L4;
    L5:
        h(r2);
    L7:
        return this.d[r2].f3508a;
    L4:
        if (r2 < this.e) goto L7;
        goto L5
    }

    public m d() {
        if (this.i == false) goto L5;
        return null;
    L5:
        this.i = true;
        return a(null);
    }

    public String d(int r2) {
        if (r2 >= 0) goto L4;
    L5:
        h(r2);
    L7:
        return this.d[r2].c;
    L4:
        if (r2 < this.e) goto L7;
        goto L5
    }

    public QName e(int r2) {
        if (r2 >= 0) goto L4;
    L5:
        h(r2);
    L7:
        return this.d[r2].a();
    L4:
        if (r2 < this.e) goto L7;
        goto L5
    }

    public final void e() {
        if (this.d != null) goto L6;
        this.d = new a[Math.min(8, this.o)];
    L6:
        if (this.k != null) goto L9;
        this.k = new m(12);
        return;
    }

    public final String f(int r4) {
        if (r4 >= 0) goto L4;
    L5:
        h(r4);
    L6:
        String r0 = this.k.b();
        a[] r1 = this.d;
        a r2 = r1[r4];
        int r5 = r4 + 1;
        if (r5 >= this.e) goto L11;
        return r2.a(r0, r1[r5].d);
    L11:
        return r2.b(r0);
    L4:
        if (r4 < this.e) goto L6;
        goto L5
    }

    public int g(int r2) {
        if (r2 >= this.e) goto L7;
        return this.d[r2].d;
    L7:
        return this.k.d();
    }

    public void h(int r4) {
        throw new IllegalArgumentException("Invalid index " + r4 + "; current element has only " + c() + " attributes");
    }
}
