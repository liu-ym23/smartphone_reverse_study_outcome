package com.alibaba.excel.support.asm;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class g extends f {
    private int A;
    private int B;
    private d C;
    private int D;
    private d E;
    private x F;
    private x G;
    private c H;
    private int I;
    private final int c;
    private int d;
    private final z e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int[] j;
    private m k;
    private m l;
    private s m;
    private s n;
    private int o;
    private d p;
    private int q;
    private int r;
    private int s;
    private int t;
    private d u;
    private b v;
    private b w;
    private b x;
    private b y;
    private u z;

    public g(int r2) {
        this(null, r2);
    }

    public g(e r2, int r3) {
        super(589824);
        this.c = r3;
        if (r2 != null) goto L5;
        z r4 = new z(this);
    L6:
        this.e = r4;
        if ((r3 & 2) == 0) goto L10;
        int r5 = 4;
    L9:
        this.I = r5;
        return;
    L10:
        r5 = 1;
        if ((r3 & 1) != 0) goto L9;
        r5 = 0;
        goto L9
    L5:
        r4 = new z(this, r2);
        goto L6
    }

    private byte[] a(byte[] r4, boolean r5) {
        c[] r0 = d();
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        int r2 = 0;
        this.A = 0;
        this.B = 0;
        this.C = null;
        this.D = 0;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        if (r5 == false) goto L5;
        int r1 = 3;
    L6:
        this.I = r1;
        e r3 = new e(r4, 0, false);
        if (r5 == false) goto L9;
        r2 = 8;
    L9:
        r3.a(this, r0, r2 | 256);
        return b();
    L5:
        r1 = 0;
        goto L6
    }

    private c[] d() {
        c.a r0 = new c.a();
        r0.a(this.H);
        m r1 = this.k;
    L4:
        if (r1 == null) goto L6;
        r1.a(r0);
        r1 = (m) ZeusTransformUtils.preCheckCast(r1.f321b, m.class, "com.obric.memorydata.plugin");
        goto L4
    L6:
        s r2 = this.m;
    L7:
        if (r2 == null) goto L9;
        r2.a(r0);
        r2 = (s) ZeusTransformUtils.preCheckCast(r2.f331b, s.class, "com.obric.memorydata.plugin");
        goto L7
    L9:
        x r4 = this.F;
    L10:
        if (r4 == null) goto L13;
        r4.a(r0);
        r4 = (x) ZeusTransformUtils.preCheckCast(r4.f338b, x.class, "com.obric.memorydata.plugin");
        goto L10
    L13:
        return r0.a();
    }

    @Override // com.alibaba.excel.support.asm.f
    public final a a(int r2, ab r3, String r4, boolean r5) {
        if (r5 == false) goto L5;
        b r6 = b.a(this.e, r2, r3, r4, this.x);
        this.x = r6;
        return r6;
    L5:
        b r7 = b.a(this.e, r2, r3, r4, this.y);
        this.y = r7;
        return r7;
    }

    @Override // com.alibaba.excel.support.asm.f
    public final a a(String r2, boolean r3) {
        if (r3 == false) goto L5;
        b r4 = b.a(this.e, r2, this.v);
        this.v = r4;
        return r4;
    L5:
        b r5 = b.a(this.e, r2, this.w);
        this.w = r5;
        return r5;
    }

    @Override // com.alibaba.excel.support.asm.f
    public final l a(int r9, String r10, String r11, String r12, Object r13) {
        m r7 = new m(this.e, r9, r10, r11, r12, r13);
        if (this.k != null) goto L5;
        this.k = r7;
    L6:
        this.l = r7;
        return r7;
    L5:
        this.l.f321b = r7;
        goto L6
    }

    @Override // com.alibaba.excel.support.asm.f
    public final r a(int r10, String r11, String r12, String r13, String[] r14) {
        s r8 = new s(this.e, r10, r11, r12, r13, r14, this.I);
        if (this.m != null) goto L5;
        this.m = r8;
    L6:
        this.n = r8;
        return r8;
    L5:
        this.n.f331b = r8;
        goto L6
    }

    @Override // com.alibaba.excel.support.asm.f
    public final t a(String r4, int r5, String r6) {
        z r1 = this.e;
        int r7 = r1.e(r4).f339a;
        if (r6 != null) goto L5;
        int r8 = 0;
    L6:
        u r0 = new u(r1, r7, r5, r8);
        this.z = r0;
        return r0;
    L5:
        r8 = this.e.c(r6);
        goto L6
    }

    @Override // com.alibaba.excel.support.asm.f
    public final void a() {
    }

    @Override // com.alibaba.excel.support.asm.f
    public final void a(int r2, int r3, String r4, String r5, String r6, String[] r7) {
        this.d = r2;
        this.f = r3;
        int r8 = r2 & 65535;
        this.g = this.e.a(r8, r4);
        if (r5 == null) goto L5;
        this.s = this.e.c(r5);
    L5:
        int r9 = 0;
        if (r6 != null) goto L8;
        int r10 = 0;
    L9:
        this.h = r10;
        if (r7 == null) goto L18;
        if (r7.length <= 0) goto L18;
        int r11 = r7.length;
        this.i = r11;
        this.j = new int[r11];
    L15:
        if (r9 >= this.i) goto L18;
        this.j[r9] = this.e.a(r7[r9]).f339a;
        r9 = r9 + 1;
    L18:
        if (this.I == 1) goto L20;
        return;
    L20:
        if (r8 < 51) goto L25;
        this.I = 2;
        return;
    L25:
        return;
    L8:
        r10 = this.e.a(r6).f339a;
        goto L9
    }

    @Override // com.alibaba.excel.support.asm.f
    public final void a(c r2) {
        r2.f305b = this.H;
        this.H = r2;
    }

    @Override // com.alibaba.excel.support.asm.f
    public final void a(String r2) {
        this.A = this.e.a(r2).f339a;
    }

    @Override // com.alibaba.excel.support.asm.f
    public final void a(String r3, String r4) {
        if (r3 == null) goto L4;
        this.t = this.e.c(r3);
    L4:
        if (r4 == null) goto L7;
        this.u = new d().a(r4, 0, Integer.MAX_VALUE);
        return;
    }

    @Override // com.alibaba.excel.support.asm.f
    public final void a(String r2, String r3, String r4) {
        this.q = this.e.a(r2).f339a;
        if (r3 == null) goto L7;
        if (r4 == null) goto L8;
        this.r = this.e.a(r3, r4);
        return;
    L8:
        return;
    }

    @Override // com.alibaba.excel.support.asm.f
    public final void a(String r4, String r5, String r6, int r7) {
        if (this.p != null) goto L5;
        this.p = new d();
    L5:
        y r8 = this.e.a(r4);
        if (r8.g != 0) goto L17;
        this.o++;
        this.p.b(r8.f339a);
        d r0 = this.p;
        int r1 = 0;
        if (r5 != null) goto L10;
        int r9 = 0;
    L11:
        r0.b(r9);
        d r10 = this.p;
        if (r6 == null) goto L15;
        r1 = this.e.c(r6);
    L15:
        r10.b(r1);
        this.p.b(r7);
        r8.g = this.o;
        return;
    L10:
        r9 = this.e.a(r5).f339a;
        goto L11
    }

    @Override // com.alibaba.excel.support.asm.f
    public final w b(String r3, String r4, String r5) {
        x r0 = new x(this.e, r3, r4, r5);
        if (this.F != null) goto L5;
        this.F = r0;
    L6:
        this.G = r0;
        return r0;
    L5:
        this.G.f338b = r0;
        goto L6
    }

    public String b(String r6, String r7) {
        ClassLoader r5 = c();
        Class<?> r2 = Class.forName(r6.replace('/', '.'), false, r5);     // Catch: ClassNotFoundException -> L25
        Class<?> r8 = Class.forName(r7.replace('/', '.'), false, r5);     // Catch: ClassNotFoundException -> L22
        if (r2.isAssignableFrom(r8) == false) goto L9;
        return r6;
    L9:
        if (r8.isAssignableFrom(r2) == false) goto L12;
        return r7;
    L12:
        if (r2.isInterface() == false) goto L14;
        return "java/lang/Object";
    L14:
        if (r8.isInterface() == true) goto L34;
    L16:
        r2 = r2.getSuperclass();
        if (r2.isAssignableFrom(r8) == false) goto L16;
        return r2.getName().replace('.', '/');
    L34:
        return "java/lang/Object";
    L22:
        e = move-exception;
        throw new TypeNotPresentException(r7, e);
    L25:
        e = move-exception;
        throw new TypeNotPresentException(r6, e);
    }

    @Override // com.alibaba.excel.support.asm.f
    public final void b(String r2) {
        if (this.C != null) goto L5;
        this.C = new d();
    L5:
        this.B++;
        this.C.b(this.e.a(r2).f339a);
    }

    public byte[] b() {
        int r1 = (this.i * 2) + 24;
        m r3 = this.k;
        int r5 = 0;
    L4:
        if (r3 == null) goto L6;
        r5 = r5 + 1;
        r1 = r1 + r3.b();
        r3 = (m) ZeusTransformUtils.preCheckCast(r3.f321b, m.class, "com.obric.memorydata.plugin");
        goto L4
    L6:
        s r4 = this.m;
        int r7 = 0;
    L7:
        if (r4 == null) goto L9;
        r7 = r7 + 1;
        r1 = r1 + r4.g();
        r4 = (s) ZeusTransformUtils.preCheckCast(r4.f331b, s.class, "com.obric.memorydata.plugin");
        goto L7
    L9:
        d r6 = this.p;
        if (r6 == null) goto L12;
        r1 = r1 + (r6.f309b + 8);
        this.e.c("InnerClasses");
        int r8 = 1;
    L14:
        if (this.q == 0) goto L17;
        r8 = r8 + 1;
        r1 = r1 + 10;
        this.e.c("EnclosingMethod");
    L17:
        if ((this.f & 4096) == 0) goto L22;
        if ((this.d & 65535) >= 49) goto L22;
        r8 = r8 + 1;
        r1 = r1 + 6;
        this.e.c("Synthetic");
    L22:
        if (this.s == 0) goto L25;
        r8 = r8 + 1;
        r1 = r1 + 8;
        this.e.c("Signature");
    L25:
        if (this.t == 0) goto L27;
        r8 = r8 + 1;
        r1 = r1 + 8;
        this.e.c("SourceFile");
    L27:
        d r9 = this.u;
        if (r9 == null) goto L31;
        r8 = r8 + 1;
        r1 = r1 + (r9.f309b + 6);
        this.e.c("SourceDebugExtension");
    L31:
        if ((this.f & 131072) == 0) goto L33;
        r8 = r8 + 1;
        r1 = r1 + 6;
        this.e.c("Deprecated");
    L33:
        b r10 = this.v;
        if (r10 == null) goto L36;
        r8 = r8 + 1;
        r1 = r1 + r10.b("RuntimeVisibleAnnotations");
    L36:
        b r11 = this.w;
        if (r11 == null) goto L39;
        r8 = r8 + 1;
        r1 = r1 + r11.b("RuntimeInvisibleAnnotations");
    L39:
        b r12 = this.x;
        if (r12 == null) goto L42;
        r8 = r8 + 1;
        r1 = r1 + r12.b("RuntimeVisibleTypeAnnotations");
    L42:
        b r13 = this.y;
        if (r13 == null) goto L46;
        r8 = r8 + 1;
        r1 = r1 + r13.b("RuntimeInvisibleTypeAnnotations");
    L46:
        if (this.e.f() <= 0) goto L48;
        r8 = r8 + 1;
        r1 = r1 + this.e.f();
    L48:
        u r14 = this.z;
        if (r14 == null) goto L51;
        r8 = r8 + r14.b();
        r1 = r1 + this.z.c();
    L51:
        String r15 = "NestHost";
        if (this.A == 0) goto L54;
        r8 = r8 + 1;
        r1 = r1 + 8;
        this.e.c("NestHost");
    L54:
        d r16 = this.C;
        if (r16 == null) goto L57;
        r8 = r8 + 1;
        r1 = r1 + (r16.f309b + 8);
        this.e.c("NestMembers");
    L57:
        d r17 = this.E;
        if (r17 == null) goto L61;
        r8 = r8 + 1;
        r1 = r1 + (r17.f309b + 8);
        this.e.c("PermittedSubclasses");
    L61:
        if ((this.f & 65536) == 0) goto L63;
    L66:
        x r18 = this.F;
        int r20 = 0;
        int r21 = 0;
    L67:
        if (r18 == null) goto L69;
        r21 = r21 + 1;
        r20 = r20 + r18.b();
        r18 = (x) ZeusTransformUtils.preCheckCast(r18.f338b, x.class, "com.obric.memorydata.plugin");
        r15 = r15;
        goto L67
    L69:
        String r22 = r15;
        r8 = r8 + 1;
        r1 = r1 + (r20 + 8);
        this.e.c("Record");
        int r19 = r21;
    L70:
        c r110 = this.H;
        if (r110 == null) goto L73;
        int r23 = r8 + r110.b();
        r1 = r1 + this.H.a(this.e);
        r8 = r23;
    L73:
        int r2 = r1 + this.e.e();
        int r111 = this.e.d();
        int r24 = r19;
        if (r111 > 65535) goto L142;
        d r112 = new d(r2);
        r112.c(-889275714).c(this.d);
        this.e.a(r112);
        if ((this.d & 65535) >= 49) goto L78;
        int r25 = 4096;
    L79:
        int r26 = this.f;
        r112.b((~r25) & r26).b(this.g).b(this.h);
        r112.b(this.i);
        int r27 = 0;
    L81:
        if (r27 >= this.i) goto L83;
        r112.b(this.j[r27]);
        r27 = r27 + 1;
        goto L81
    L83:
        r112.b(r5);
        m r28 = this.k;
    L84:
        if (r28 == null) goto L86;
        r28.a(r112);
        r28 = (m) ZeusTransformUtils.preCheckCast(r28.f321b, m.class, "com.obric.memorydata.plugin");
        goto L84
    L86:
        r112.b(r7);
        s r29 = this.m;
        boolean r30 = false;
        boolean r31 = false;
    L87:
        if (r29 == null) goto L89;
        r30 = r30 | r29.d();
        r31 = r31 | r29.e();
        r29.a(r112);
        r29 = (s) ZeusTransformUtils.preCheckCast(r29.f331b, s.class, "com.obric.memorydata.plugin");
        goto L87
    L89:
        r112.b(r8);
        if (this.p == null) goto L93;
        r112.b(this.e.c("InnerClasses")).c(this.p.f309b + 2).b(this.o).a(this.p.f308a, 0, this.p.f309b);
    L93:
        if (this.q == 0) goto L96;
        r112.b(this.e.c("EnclosingMethod")).c(4).b(this.q).b(this.r);
    L96:
        if ((this.f & 4096) == 0) goto L101;
        if ((this.d & 65535) >= 49) goto L101;
        r112.b(this.e.c("Synthetic")).c(0);
    L101:
        if (this.s == 0) goto L103;
        int r32 = 2;
        r112.b(this.e.c("Signature")).c(2).b(this.s);
    L105:
        if (this.t == 0) goto L107;
        r112.b(this.e.c("SourceFile")).c(r32).b(this.t);
    L107:
        d r33 = this.u;
        if (r33 == null) goto L110;
        int r34 = r33.f309b;
        int r35 = 0;
        r112.b(this.e.c("SourceDebugExtension")).c(r34).a(this.u.f308a, 0, r34);
    L112:
        if ((this.f & 131072) == 0) goto L114;
        r112.b(this.e.c("Deprecated")).c(r35);
    L114:
        b.a(this.e, this.v, this.w, this.x, this.y, r112);
        this.e.b(r112);
        u r36 = this.z;
        if (r36 == null) goto L118;
        r36.a(r112);
    L118:
        if (this.A == 0) goto L121;
        r112.b(this.e.c(r22)).c(2).b(this.A);
    L121:
        if (this.C == null) goto L124;
        r112.b(this.e.c("NestMembers")).c(this.C.f309b + 2).b(this.B).a(this.C.f308a, 0, this.C.f309b);
    L124:
        if (this.E == null) goto L127;
        r112.b(this.e.c("PermittedSubclasses")).c(this.E.f309b + 2).b(this.D).a(this.E.f308a, 0, this.E.f309b);
    L127:
        if ((this.f & 65536) == 0) goto L129;
    L130:
        r112.b(this.e.c("Record")).c(r20 + 2).b(r24);
        x r37 = this.F;
    L131:
        if (r37 == null) goto L133;
        r37.a(r112);
        r37 = (x) ZeusTransformUtils.preCheckCast(r37.f338b, x.class, "com.obric.memorydata.plugin");
    L133:
        c r38 = this.H;
        if (r38 == null) goto L136;
        r38.a(this.e, r112);
    L136:
        if (r31 == false) goto L140;
        return a(r112.f308a, r30);
    L140:
        return r112.f308a;
    L129:
        if (this.F == null) goto L133;
    L110:
        r35 = 0;
        goto L112
    L103:
        r32 = 2;
        goto L105
    L78:
        r25 = 0;
        goto L79
    L142:
        throw new ClassTooLargeException(this.e.c(), r111);
    L63:
        if (this.F != null) goto L66;
        r22 = "NestHost";
        r19 = 0;
        r20 = 0;
        goto L70
    L12:
        r8 = 0;
        goto L14
    }

    public ClassLoader c() {
        ClassLoader r0 = Thread.currentThread().getContextClassLoader();     // Catch: Throwable -> L4
    L5:
        if (r0 == null) goto L8;
        return r0;
    L8:
        return getClass().getClassLoader();
    L4:
        r0 = null;
        goto L5
    }

    @Override // com.alibaba.excel.support.asm.f
    public final void c(String r2) {
        if (this.E != null) goto L5;
        this.E = new d();
    L5:
        this.D++;
        this.E.b(this.e.a(r2).f339a);
    }
}
