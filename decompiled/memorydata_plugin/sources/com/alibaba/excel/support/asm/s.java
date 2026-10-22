package com.alibaba.excel.support.asm;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class s extends r {
    private static final int[] c = null;
    private final int[] A;
    private final int B;
    private b C;
    private b D;
    private int E;
    private b[] F;
    private int G;
    private b[] H;
    private b I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private b f332J;
    private d K;
    private int L;
    private d M;
    private c N;
    private final int O;
    private q P;
    private q Q;
    private q R;
    private int S;
    private int T;
    private int U;
    private int V;
    private int[] W;
    private int[] X;
    private boolean Y;
    private boolean Z;
    private int aa;
    private int ab;
    private int ac;
    private final z d;
    private final int e;
    private final int f;
    private final String g;
    private final int h;
    private final String i;
    private int j;
    private int k;
    private final d l;
    private p m;
    private p n;
    private int o;
    private d p;
    private int q;
    private d r;
    private int s;
    private d t;
    private int u;
    private d v;
    private b w;
    private b x;
    private c y;
    private final int z;

    static {
        c = new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 0, 0, 1, 2, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1, -1, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, -4, -3, -4, -3, -3, -3, -3, -1, -2, 1, 1, 1, 2, 2, 2, 0, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -2, -1, -2, -1, -2, 0, 1, 0, 1, -1, -1, 0, 0, 1, 1, -1, 0, -1, 0, 0, 0, -3, -1, -1, -3, -3, -1, -1, -1, -1, -1, -1, -2, -2, -2, -2, -2, -2, -2, -2, 0, 1, 0, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, -1, -1, 0, 0};
    }

    s(z r2, int r3, String r4, String r5, String r6, String[] r7, int r8) {
        super(589824);
        this.l = new d();
        this.d = r2;
        if ("<init>".equals(r4) == false) goto L5;
        int r0 = 262144 | r3;
    L6:
        this.e = r0;
        this.f = r2.c(r4);
        this.g = r4;
        this.h = r2.c(r5);
        this.i = r5;
        int r9 = 0;
        if (r6 != null) goto L9;
        int r10 = 0;
    L10:
        this.B = r10;
        if (r7 != null) goto L13;
    L18:
        this.z = 0;
        this.A = null;
    L19:
        this.O = r8;
        if (r8 == 0) goto L27;
        int r11 = aa.f(r5) >> 2;
        if ((r3 & 8) == 0) goto L24;
        r11 = r11 - 1;
    L24:
        this.k = r11;
        this.U = r11;
        q r12 = new q();
        this.P = r12;
        a(r12);
        return;
    L27:
        return;
    L13:
        if (r7.length <= 0) goto L18;
        int r13 = r7.length;
        this.z = r13;
        this.A = new int[r13];
    L16:
        if (r9 >= this.z) goto L19;
        this.A[r9] = r2.a(r7[r9]).f339a;
        r9 = r9 + 1;
        goto L16
    L9:
        r10 = r2.c(r6);
        goto L10
    L5:
        r0 = r3;
        goto L6
    }

    private void a(q r5, q[] r6) {
        q r0 = this.R;
        if (r0 == null) goto L18;
        int r1 = this.O;
        int r3 = 0;
        if (r1 != 4) goto L10;
        r0.h.a(171, 0, null, null);
        c(0, r5);
        q r7 = r5.a();
        r7.f329b = (short) (r7.f329b | 2);
        int r8 = r6.length;
        int r2 = 0;
    L7:
        if (r2 >= r8) goto L14;
        q r4 = r6[r2];
        c(0, r4);
        q r9 = r4.a();
        r9.f329b = (short) (r9.f329b | 2);
        r2 = r2 + 1;
    L14:
        j();
        return;
    L10:
        if (r1 != 1) goto L14;
        int r10 = this.S - 1;
        this.S = r10;
        c(r10, r5);
        int r11 = r6.length;
    L12:
        if (r3 >= r11) goto L14;
        c(this.S, r6[r3]);
        r3 = r3 + 1;
        goto L12
    }

    private void b(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, Integer.class) == false) goto L6;
        this.v.a(((Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L8;
        this.v.a(7).b(this.d.a((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin")).f339a);
        return;
    L8:
        this.v.a(8).b(((q) ZeusTransformUtils.preCheckCast(r4, q.class, "com.obric.memorydata.plugin")).c);
    }

    private void c(int r3, q r4) {
        q r0 = this.R;
        r0.j = new k(r3, r4, this.R.j);
    }

    private void g(int r4, int r5) {
    L2:
        if (r4 >= r5) goto L4;
        n.a(this.d, this.X[r4], this.v);
        r4 = r4 + 1;
        goto L2
    }

    private void h() {
        p r0 = this.m;
    L3:
        String r1 = "java/lang/Throwable";
        if (r0 == null) goto L13;
        if (r0.e == null) goto L9;
        r1 = r0.e;
    L9:
        int r2 = n.a(this.d, r1);
        q r3 = r0.c.a();
        r3.f329b = (short) (r3.f329b | 2);
        q r4 = r0.f326a.a();
        q r5 = r0.f327b.a();
    L10:
        if (r4 == r5) goto L12;
        r4.j = new k(r2, r3, r4.j);
        r4 = r4.i;
        goto L10
    L12:
        r0 = r0.f;
        goto L3
    L13:
        n r6 = this.P.h;
        r6.a(this.d, this.e, this.i, this.k);
        r6.a(this);
        q r7 = this.P;
        r7.k = q.f328a;
        int r8 = 0;
    L15:
        if (r7 == q.f328a) goto L28;
        q r9 = r7.k;
        r7.k = null;
        r7.f329b = (short) (r7.f329b | 8);
        int r10 = r7.h.a() + r7.f;
        if (r10 <= r8) goto L19;
        r8 = r10;
    L19:
        k r11 = r7.j;
    L20:
        if (r11 == null) goto L27;
        q r12 = r11.f319b.a();
        if (r7.h.a(this.d, r12.h, r11.f318a) == false) goto L26;
        if (r12.k != null) goto L26;
        r12.k = r9;
        r9 = r12;
    L26:
        r11 = r11.c;
        goto L20
    L27:
        r7 = r9;
        goto L15
    L28:
        q r13 = this.P;
    L29:
        if (r13 == null) goto L46;
        if ((r13.f329b & 10) != 10) goto L34;
        r13.h.a(this);
    L34:
        if ((r13.f329b & 8) != 0) goto L45;
        q r14 = r13.i;
        int r15 = r13.c;
        if (r14 != null) goto L38;
        int r16 = this.l.f309b;
    L39:
        int r17 = r16 - 1;
        if (r17 < r15) goto L45;
        int r18 = r15;
    L42:
        if (r18 >= r17) goto L44;
        this.l.f308a[r18] = 0;
        r18 = r18 + 1;
        goto L42
    L44:
        this.l.f308a[r17] = -65;
        this.X[a(r15, 0, 1)] = n.a(this.d, "java/lang/Throwable");
        f();
        this.m = p.a(this.m, r13, r14);
        r8 = Math.max(r8, 1);
        goto L45
    L38:
        r16 = r14.c;
    L45:
        r13 = r13.i;
        goto L29
    L46:
        this.j = r8;
    }

    private void i() {
        p r0 = this.m;
    L4:
        if (r0 == null) goto L14;
        q r2 = r0.c;
        q r3 = r0.f326a;
        q r4 = r0.f327b;
    L6:
        if (r3 == r4) goto L12;
        if ((r3.f329b & 16) != 0) goto L10;
        r3.j = new k(Integer.MAX_VALUE, r2, r3.j);
    L11:
        r3 = r3.i;
        goto L6
    L10:
        r3.j.c.c = new k(Integer.MAX_VALUE, r2, r3.j.c.c);
        goto L11
    L12:
        r0 = r0.f;
        goto L4
    L14:
        if (this.Y == false) goto L34;
        this.P.a(1);
        short r1 = 1;
        short r5 = 1;
    L16:
        if (r1 > r5) goto L28;
        q r6 = this.P;
    L18:
        if (r6 == null) goto L27;
        if ((r6.f329b & 16) == 0) goto L26;
        if (r6.g != r1) goto L26;
        q r7 = r6.j.c.f319b;
        if (r7.g != 0) goto L26;
        r5 = (short) (r5 + 1);
        r7.a(r5);
    L26:
        r6 = r6.i;
        goto L18
    L27:
        r1 = (short) (r1 + 1);
        goto L16
    L28:
        q r8 = this.P;
    L29:
        if (r8 == null) goto L34;
        if ((r8.f329b & 16) == 0) goto L33;
        r8.j.c.f319b.a(r8);
    L33:
        r8 = r8.i;
    L34:
        q r9 = this.P;
        r9.k = q.f328a;
        int r10 = this.j;
    L36:
        if (r9 == q.f328a) goto L53;
        q r11 = r9.k;
        short r12 = r9.d;
        int r13 = r9.f + r12;
        if (r13 <= r10) goto L40;
        r10 = r13;
    L40:
        k r14 = r9.j;
        if ((r9.f329b & 16) == 0) goto L43;
        r14 = r14.c;
    L43:
        r9 = r11;
    L44:
        if (r14 == null) goto L36;
        q r15 = r14.f319b;
        if (r15.k == null) goto L48;
    L52:
        r14 = r14.c;
        goto L44
    L48:
        if (r14.f318a != Integer.MAX_VALUE) goto L50;
        int r16 = 1;
    L51:
        r15.d = (short) r16;
        r15.k = r9;
        r9 = r15;
        goto L52
    L50:
        r16 = r14.f318a + r12;
        goto L51
    L53:
        this.j = r10;
    }

    private void j() {
        int r0 = this.O;
        if (r0 != 4) goto L7;
        q r1 = new q();
        r1.h = new n(r1);
        r1.a(this.l.f308a, this.l.f309b);
        this.Q.i = r1;
        this.Q = r1;
    L5:
        this.R = null;
        return;
    L7:
        if (r0 != 1) goto L10;
        q r2 = this.R;
        r2.f = (short) this.T;
        goto L5
    }

    private void k() {
        int[] r1 = this.X;
        int r3 = r1[1];
        int r2 = r1[2];
        int r5 = 0;
        if (this.d.b() >= 50) goto L7;
        this.v.b(this.X[0]).b(r3);
        int r4 = r3 + 3;
        g(3, r4);
        this.v.b(r2);
        g(r4, r2 + r4);
        return;
    L7:
        if (this.u != 0) goto L9;
        int r6 = this.X[0];
    L10:
        int r7 = this.W[1];
        int r8 = r3 - r7;
        if (r2 != 0) goto L19;
        switch(r8) {
            case -3: goto L18;
            case -2: goto L18;
            case -1: goto L18;
            case 0: goto L15;
            case 1: goto L14;
            case 2: goto L14;
            case 3: goto L14;
            default: goto L54;
        };
    L14:
        char r9 = 252;
    L26:
        if (r9 == 255) goto L34;
        int r15 = 3;
    L28:
        if (r5 >= r7) goto L34;
        if (r5 >= r3) goto L34;
        if (this.X[r15] != this.W[r15]) goto L32;
        r15 = r15 + 1;
        r5 = r5 + 1;
        goto L28
    L32:
        r9 = 255;
    L34:
        if (r9 == 0) goto L48;
        if (r9 == '@') goto L46;
        if (r9 == 247) goto L45;
        if (r9 == 248) goto L43;
        if (r9 == 251) goto L42;
        if (r9 == 252) goto L41;
        this.v.a(255).b(r6).b(r3);
        int r10 = r3 + 3;
        g(3, r10);
        this.v.b(r2);
        g(r10, r2 + r10);
        return;
    L41:
        this.v.a(r8 + 251).b(r6);
        g(r7 + 3, r3 + 3);
        return;
    L42:
        d r0 = this.v.a(251);
    L44:
        r0.b(r6);
        return;
    L43:
        r0 = this.v.a(r8 + 251);
        goto L44
    L45:
        this.v.a(247).b(r6);
    L47:
        g(r3 + 3, r3 + 4);
        return;
    L46:
        this.v.a(r6 + 64);
        goto L47
    L48:
        this.v.a(r6);
        return;
    L15:
        if (r6 >= 64) goto L17;
        r9 = 0;
        goto L26
    L17:
        r9 = 251;
        goto L26
    L18:
        r9 = 248;
        goto L26
    L54:
        r9 = 255;
        goto L26
    L19:
        if (r8 != 0) goto L25;
        if (r2 == 1) goto L22;
        r9 = 255;
        goto L26
    L22:
        if (r6 >= 63) goto L24;
        r9 = '@';
        goto L26
    L24:
        r9 = 247;
        goto L26
    L25:
        r9 = 255;
        goto L26
    L9:
        r6 = (this.X[0] - this.W[0]) - 1;
        goto L10
    }

    int a(int r3, int r4, int r5) {
        int r0 = (r4 + 3) + r5;
        int[] r1 = this.X;
        if (r1 != null) goto L5;
    L6:
        this.X = new int[r0];
    L7:
        int[] r2 = this.X;
        r2[0] = r3;
        r2[1] = r4;
        r2[2] = r5;
        return 3;
    L5:
        if (r1.length >= r0) goto L7;
        goto L6
    }

    @Override // com.alibaba.excel.support.asm.r
    public a a() {
        this.K = new d();
        return new b(this.d, false, this.K, null);
    }

    @Override // com.alibaba.excel.support.asm.r
    public a a(int r2, ab r3, String r4, boolean r5) {
        if (r5 == false) goto L5;
        b r6 = b.a(this.d, r2, r3, r4, this.I);
        this.I = r6;
        return r6;
    L5:
        b r7 = b.a(this.d, r2, r3, r4, this.f332J);
        this.f332J = r7;
        return r7;
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
        	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    @Override // com.alibaba.excel.support.asm.r
    public com.alibaba.excel.support.asm.a a(
    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
        	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r6v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */

    @Override // com.alibaba.excel.support.asm.r
    public a a(int r2, String r3, boolean r4) {
        if (r4 == false) goto L9;
        if (this.F != null) goto L6;
        this.F = new b[aa.c(this.i).length];
    L6:
        b[] r5 = this.F;
        b r1 = b.a(this.d, r3, r5[r2]);
        r5[r2] = r1;
        return r1;
    L9:
        if (this.H != null) goto L11;
        this.H = new b[aa.c(this.i).length];
    L11:
        b[] r6 = this.H;
        b r7 = b.a(this.d, r3, r6[r2]);
        r6[r2] = r7;
        return r7;
    }

    @Override // com.alibaba.excel.support.asm.r
    public a a(String r2, boolean r3) {
        if (r3 == false) goto L5;
        b r4 = b.a(this.d, r2, this.C);
        this.C = r4;
        return r4;
    L5:
        b r5 = b.a(this.d, r2, this.D);
        this.D = r5;
        return r5;
    }

    @Override // com.alibaba.excel.support.asm.r
    public void a(int r4) {
        this.aa = this.l.f309b;
        this.l.a(r4);
        q r0 = this.R;
        if (r0 == null) goto L22;
        int r1 = this.O;
        if (r1 != 4) goto L7;
    L13:
        r0.h.a(r4, 0, null, null);
    L15:
        if (r4 < 172) goto L19;
        if (r4 > 177) goto L19;
    L20:
        j();
        return;
    L19:
        if (r4 == 191) goto L20;
        return;
    L7:
        if (r1 == 3) goto L13;
        int r2 = this.S + c[r4];
        if (r2 <= this.T) goto L12;
        this.T = r2;
    L12:
        this.S = r2;
        goto L15
    }

    @Override // com.alibaba.excel.support.asm.r
    public void a(int r4, int r5) {
        this.aa = this.l.f309b;
        if (r4 != 17) goto L5;
        this.l.b(r4, r5);
    L6:
        q r0 = this.R;
        if (r0 == null) goto L21;
        int r1 = this.O;
        if (r1 != 4) goto L11;
    L19:
        r0.h.a(r4, r5, null, null);
        return;
    L11:
        if (r1 == 3) goto L19;
        if (r4 == 188) goto L22;
        int r6 = this.S + 1;
        if (r6 <= this.T) goto L18;
        this.T = r6;
    L18:
        this.S = r6;
        return;
    L22:
        return;
    L21:
        return;
    L5:
        this.l.a(r4, r5);
        goto L6
    }

    @Override // com.alibaba.excel.support.asm.r
    public void a(int r5, int r6, q r7, q... r8) {
        this.aa = this.l.f309b;
        int r3 = 0;
        this.l.a(170).a(null, 0, (4 - (this.l.f309b % 4)) % 4);
        r7.a(this.l, this.aa, true);
        this.l.c(r5).c(r6);
        int r9 = r8.length;
    L3:
        if (r3 >= r9) goto L5;
        r8[r3].a(this.l, this.aa, true);
        r3 = r3 + 1;
        goto L3
    L5:
        a(r7, r8);
    }

    @Override // com.alibaba.excel.support.asm.r
    public void a(int r13, int r14, Object[] r15, int r16, Object[] r17) {
        int r2 = this.O;
        if (r2 != 4) goto L5;
        return;
    L5:
        int r9 = 0;
        if (r2 == 3) goto L8;
        if (r13 != (-1)) goto L25;
        if (this.W != null) goto L17;
        int r1 = aa.f(this.i) >> 2;
        n r3 = new n(new q());
        r3.a(this.d, this.e, this.i, r1);
        r3.a(this);
    L17:
        this.U = r14;
        int r4 = a(this.l.f309b, r14, r16);
        int r5 = 0;
    L18:
        if (r5 >= r14) goto L20;
        this.X[r4] = n.a(this.d, r15[r5]);
        r5 = r5 + 1;
        r4 = r4 + 1;
        goto L18
    L20:
        int r6 = 0;
    L21:
        if (r6 >= r16) goto L23;
        this.X[r4] = n.a(this.d, r17[r6]);
        r6 = r6 + 1;
        r4 = r4 + 1;
        goto L21
    L23:
        f();
    L65:
        if (this.O != 2) goto L77;
        this.S = r16;
    L67:
        if (r9 >= r16) goto L74;
        if (r17[r9] != v.e) goto L71;
    L72:
        this.S++;
    L73:
        r9 = r9 + 1;
        goto L67
    L71:
        if (r17[r9] != v.d) goto L73;
    L74:
        int r7 = this.S;
        if (r7 <= this.T) goto L77;
        this.T = r7;
    L77:
        this.j = Math.max(this.j, r16);
        this.k = Math.max(this.k, this.U);
        return;
    L25:
        if (this.d.b() < 50) goto L80;
        if (this.v != null) goto L29;
        this.v = new d();
        int r8 = this.l.f309b;
    L35:
        if (r13 == 0) goto L57;
        if (r13 == 1) goto L54;
        int r10 = 251;
        if (r13 != 2) goto L40;
        this.U -= r14;
        d r11 = this.v;
        r10 = 251 - r14;
    L53:
        r11.a(r10).b(r8);
    L63:
        this.V = this.l.f309b;
        this.u++;
        goto L65
    L40:
        if (r13 == 3) goto L49;
        if (r13 != 4) goto L48;
        d r12 = this.v;
        if (r8 >= 64) goto L45;
        r12.a(r8 + 64);
    L46:
        b(r17[0]);
        goto L63
    L45:
        r12.a(247).b(r8);
        goto L46
    L48:
        throw new IllegalArgumentException();
    L49:
        r11 = this.v;
        if (r8 >= 64) goto L53;
        r11.a(r8);
        goto L63
    L54:
        this.U += r14;
        this.v.a(r14 + 251).b(r8);
        int r18 = 0;
    L55:
        if (r18 >= r14) goto L63;
        b(r15[r18]);
        r18 = r18 + 1;
        goto L55
    L57:
        this.U = r14;
        this.v.a(255).b(r8).b(r14);
        int r19 = 0;
    L58:
        if (r19 >= r14) goto L60;
        b(r15[r19]);
        r19 = r19 + 1;
        goto L58
    L60:
        this.v.b(r16);
        int r20 = 0;
    L61:
        if (r20 >= r16) goto L63;
        b(r17[r20]);
        r20 = r20 + 1;
        goto L61
    L29:
        r8 = (this.l.f309b - this.V) - 1;
        if (r8 >= 0) goto L35;
        if (r13 != 3) goto L34;
        return;
    L34:
        throw new IllegalStateException();
    L80:
        throw new IllegalArgumentException("Class versions V1_5 or less must use F_NEW frames.");
    L8:
        if (this.R.h != null) goto L11;
        this.R.h = new j(this.R);
        this.R.h.a(this.d, this.e, this.i, r14);
    L10:
        this.R.h.a(this);
        goto L65
    L11:
        if (r13 != (-1)) goto L10;
        this.R.h.a(this.d, r14, r15, r16, r17);
        goto L10
    }

    @Override // com.alibaba.excel.support.asm.r
    public void a(int r11, q r12) {
        this.aa = this.l.f309b;
        int r0 = 200;
        if (r11 < 200) goto L5;
        int r1 = r11 - 33;
    L7:
        if ((r12.f329b & 4) != 0) goto L9;
    L22:
        if (r1 == r11) goto L24;
        this.l.a(r11);
        d r13 = this.l;
        r12.a(r13, r13.f309b - 1, true);
    L25:
        boolean r14 = false;
    L26:
        q r2 = this.R;
        if (r2 == null) goto L51;
        int r3 = this.O;
        q r9 = null;
        if (r3 != 4) goto L34;
        r2.h.a(r1, 0, null, null);
        q r4 = r12.a();
        r4.f329b = (short) (r4.f329b | 2);
        c(0, r12);
        if (r1 == 167) goto L44;
        r9 = new q();
    L44:
        if (r9 == null) goto L48;
        if (r14 == false) goto L47;
        r9.f329b = (short) (r9.f329b | 2);
    L47:
        a(r9);
    L48:
        if (r1 != 167) goto L52;
        j();
        return;
    L52:
        return;
    L34:
        if (r3 != 3) goto L36;
        r2.h.a(r1, 0, null, null);
        goto L44
    L36:
        if (r3 != 2) goto L38;
        this.S += c[r1];
        goto L44
    L38:
        if (r1 == 168) goto L40;
        int r5 = this.S + c[r1];
        this.S = r5;
        c(r5, r12);
        goto L44
    L40:
        if ((r12.f329b & 32) != 0) goto L42;
        r12.f329b = (short) (r12.f329b | 32);
        this.Y = true;
    L42:
        q r6 = this.R;
        r6.f329b = (short) (r6.f329b | 16);
        c(this.S + 1, r12);
        r9 = new q();
        goto L44
    L51:
        return;
    L24:
        this.l.a(r1);
        d r15 = this.l;
        r12.a(r15, r15.f309b - 1, false);
        goto L25
    L9:
        if ((r12.c - this.l.f309b) >= (-32768)) goto L22;
        d r16 = this.l;
        if (r1 != 167) goto L13;
    L12:
        r16.a(r0);
        r14 = false;
    L21:
        d r7 = this.l;
        r12.a(r7, r7.f309b - 1, true);
        goto L26
    L13:
        if (r1 != 168) goto L17;
        r0 = 201;
        goto L12
    L17:
        if (r1 < 198) goto L19;
        int r8 = r1 ^ 1;
    L20:
        r16.a(r8);
        this.l.b(8);
        this.l.a(220);
        this.Z = true;
        r14 = true;
        goto L21
    L19:
        r8 = ((r1 + 1) ^ 1) - 1;
        goto L20
    L5:
        r1 = r11;
        goto L7
    }

    @Override // com.alibaba.excel.support.asm.r
    public void a(int r4, String r5) {
        this.aa = this.l.f309b;
        y r6 = this.d.a(r5);
        this.l.b(r4, r6.f339a);
        q r0 = this.R;
        if (r0 == null) goto L17;
        int r1 = this.O;
        if (r1 != 4) goto L7;
    L15:
        r0.h.a(r4, this.aa, r6, this.d);
        return;
    L7:
        if (r1 == 3) goto L15;
        if (r4 != 187) goto L18;
        int r7 = this.S + 1;
        if (r7 <= this.T) goto L14;
        this.T = r7;
    L14:
        this.S = r7;
        return;
    L18:
        return;
    }

    @Override // com.alibaba.excel.support.asm.r
    public void a(int r4, String r5, String r6, String r7) {
        this.aa = this.l.f309b;
        y r8 = this.d.a(r5, r6, r7);
        this.l.b(r4, r8.f339a);
        q r9 = this.R;
        if (r9 == null) goto L38;
        int r0 = this.O;
        int r2 = 0;
        if (r0 != 4) goto L7;
    L36:
        r9.h.a(r4, 0, r8, this.d);
        return;
    L7:
        if (r0 == 3) goto L36;
        char r10 = r7.charAt(0);
        int r11 = 1;
        int r12 = -2;
        switch(r4) {
            case 178: goto L26;
            case 179: goto L20;
            case 180: goto L15;
            default: goto L11;
        };
    L11:
        int r13 = this.S;
        if (r10 == 'D') goto L31;
        if (r10 == 'J') goto L31;
    L25:
        int r14 = r13 + r12;
    L33:
        if (r14 <= this.T) goto L35;
        this.T = r14;
    L35:
        this.S = r14;
        return;
    L31:
        r12 = -3;
        goto L25
    L15:
        int r15 = this.S;
        if (r10 == 'D') goto L18;
        if (r10 == 'J') goto L18;
    L19:
        r14 = r15 + r2;
    L18:
        r2 = 1;
        goto L19
    L20:
        r13 = this.S;
        if (r10 == 'D') goto L25;
        if (r10 == 'J') goto L25;
        r12 = -1;
        goto L25
    L26:
        int r16 = this.S;
        if (r10 == 'D') goto L29;
        if (r10 == 'J') goto L29;
    L30:
        r14 = r16 + r11;
    L29:
        r11 = 2;
        goto L30
    }

    @Override // com.alibaba.excel.support.asm.r
    public void a(int r2, String r3, String r4, String r5, boolean r6) {
        this.aa = this.l.f309b;
        y r7 = this.d.a(r3, r4, r5, r6);
        if (r2 != 185) goto L5;
        this.l.b(185, r7.f339a).a(r7.a() >> 2, 0);
    L6:
        q r8 = this.R;
        if (r8 == null) goto L23;
        int r9 = this.O;
        if (r9 != 4) goto L11;
    L21:
        r8.h.a(r2, 0, r7, this.d);
        return;
    L11:
        if (r9 == 3) goto L21;
        int r10 = r7.a();
        int r11 = (r10 & 3) - (r10 >> 2);
        if (r2 != 184) goto L16;
        int r12 = (this.S + r11) + 1;
    L18:
        if (r12 <= this.T) goto L20;
        this.T = r12;
    L20:
        this.S = r12;
        return;
    L16:
        r12 = this.S + r11;
        goto L18
    L23:
        return;
    L5:
        this.l.b(r2, r7.f339a);
        goto L6
    }

    @Override // com.alibaba.excel.support.asm.r
    public void a(int r1, boolean r2) {
        if (r2 == false) goto L4;
        this.E = r1;
        return;
    L4:
        this.G = r1;
    }

    final void a(c.a r2) {
        r2.a(this.N);
        r2.a(this.y);
    }

    @Override // com.alibaba.excel.support.asm.r
    public void a(c r2) {
        if (r2.a() == false) goto L5;
        r2.f305b = this.y;
        this.y = r2;
        return;
    L5:
        r2.f305b = this.N;
        this.N = r2;
    }

    void a(d r14) {
        if (this.d.b() >= 49) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        int r3 = 4096;
    L9:
        r14.b((~r3) & this.e).b(this.f).b(this.h);
        if (this.ab == 0) goto L14;
        r14.a(this.d.a().c, this.ab, this.ac);
        return;
    L14:
        if (this.l.f309b <= 0) goto L16;
        int r4 = 1;
    L18:
        if (this.z <= 0) goto L20;
        r4 = r4 + 1;
    L20:
        int r5 = this.e;
        if ((r5 & 4096) == 0) goto L25;
        if (r0 == false) goto L25;
        r4 = r4 + 1;
    L25:
        if (this.B == 0) goto L28;
        r4 = r4 + 1;
    L28:
        if ((131072 & r5) == 0) goto L31;
        r4 = r4 + 1;
    L31:
        if (this.C == null) goto L34;
        r4 = r4 + 1;
    L34:
        if (this.D == null) goto L37;
        r4 = r4 + 1;
    L37:
        if (this.F == null) goto L40;
        r4 = r4 + 1;
    L40:
        if (this.H == null) goto L43;
        r4 = r4 + 1;
    L43:
        if (this.I == null) goto L46;
        r4 = r4 + 1;
    L46:
        if (this.f332J == null) goto L49;
        r4 = r4 + 1;
    L49:
        if (this.K == null) goto L52;
        r4 = r4 + 1;
    L52:
        if (this.M == null) goto L54;
        r4 = r4 + 1;
    L54:
        c r1 = this.N;
        if (r1 == null) goto L57;
        r4 = r4 + r1.b();
    L57:
        r14.b(r4);
        if (this.l.f309b <= 0) goto L111;
        int r2 = (this.l.f309b + 10) + p.b(this.m);
        d r6 = this.v;
        if (r6 == null) goto L62;
        r2 = r2 + (r6.f309b + 8);
        int r7 = 1;
    L63:
        d r8 = this.p;
        if (r8 == null) goto L66;
        r2 = r2 + (r8.f309b + 8);
        r7 = r7 + 1;
    L66:
        d r9 = this.r;
        if (r9 == null) goto L69;
        r2 = r2 + (r9.f309b + 8);
        r7 = r7 + 1;
    L69:
        d r10 = this.t;
        if (r10 == null) goto L72;
        r2 = r2 + (r10.f309b + 8);
        r7 = r7 + 1;
    L72:
        b r11 = this.w;
        if (r11 == null) goto L75;
        r2 = r2 + r11.b("RuntimeVisibleTypeAnnotations");
        r7 = r7 + 1;
    L75:
        b r12 = this.x;
        if (r12 == null) goto L78;
        r2 = r2 + r12.b("RuntimeInvisibleTypeAnnotations");
        r7 = r7 + 1;
    L78:
        c r13 = this.y;
        if (r13 == null) goto L81;
        r2 = r2 + r13.a(this.d, this.l.f308a, this.l.f309b, this.j, this.k);
        r7 = r7 + this.y.b();
    L81:
        r14.b(this.d.c(com.tom_roush.pdfbox.pdmodel.a.d.i.K)).c(r2).b(this.j).b(this.k).c(this.l.f309b).a(this.l.f308a, 0, this.l.f309b);
        p.a(this.m, r14);
        r14.b(r7);
        if (this.v == null) goto L93;
        if (this.d.b() < 50) goto L86;
        boolean r15 = true;
    L87:
        z r16 = this.d;
        if (r15 == false) goto L90;
        String r17 = "StackMapTable";
    L91:
        r14.b(r16.c(r17)).c(this.v.f309b + 2).b(this.u).a(this.v.f308a, 0, this.v.f309b);
        goto L93
    L90:
        r17 = "StackMap";
        goto L91
    L86:
        r15 = false;
    L93:
        if (this.p == null) goto L96;
        r14.b(this.d.c("LineNumberTable")).c(this.p.f309b + 2).b(this.o).a(this.p.f308a, 0, this.p.f309b);
    L96:
        if (this.r == null) goto L99;
        r14.b(this.d.c("LocalVariableTable")).c(this.r.f309b + 2).b(this.q).a(this.r.f308a, 0, this.r.f309b);
    L99:
        if (this.t == null) goto L101;
        r14.b(this.d.c("LocalVariableTypeTable")).c(this.t.f309b + 2).b(this.s).a(this.t.f308a, 0, this.t.f309b);
    L101:
        b r18 = this.w;
        if (r18 == null) goto L104;
        r18.a(this.d.c("RuntimeVisibleTypeAnnotations"), r14);
    L104:
        b r19 = this.x;
        if (r19 == null) goto L107;
        r19.a(this.d.c("RuntimeInvisibleTypeAnnotations"), r14);
    L107:
        c r20 = this.y;
        if (r20 == null) goto L111;
        r20.a(this.d, this.l.f308a, this.l.f309b, this.j, this.k, r14);
        goto L111
    L62:
        r7 = 0;
    L111:
        if (this.z <= 0) goto L115;
        r14.b(this.d.c("Exceptions")).c((this.z * 2) + 2).b(this.z);
        int[] r21 = this.A;
        int r22 = r21.length;
        int r23 = 0;
    L113:
        if (r23 >= r22) goto L115;
        r14.b(r21[r23]);
        r23 = r23 + 1;
    L115:
        c.a(this.d, this.e, this.B, r14);
        b.a(this.d, this.C, this.D, this.I, this.f332J, r14);
        if (this.F == null) goto L122;
        int r24 = this.d.c("RuntimeVisibleParameterAnnotations");
        b[] r25 = this.F;
        int r26 = this.E;
        if (r26 != 0) goto L120;
        r26 = r25.length;
    L120:
        b.a(r24, r25, r26, r14);
    L122:
        if (this.H == null) goto L128;
        int r27 = this.d.c("RuntimeInvisibleParameterAnnotations");
        b[] r28 = this.H;
        int r29 = this.G;
        if (r29 != 0) goto L126;
        r29 = r28.length;
    L126:
        b.a(r27, r28, r29, r14);
    L128:
        if (this.K == null) goto L131;
        r14.b(this.d.c("AnnotationDefault")).c(this.K.f309b).a(this.K.f308a, 0, this.K.f309b);
    L131:
        if (this.M == null) goto L133;
        r14.b(this.d.c("MethodParameters")).c(this.M.f309b + 1).a(this.L).a(this.M.f308a, 0, this.M.f309b);
    L133:
        c r30 = this.N;
        if (r30 == null) goto L138;
        r30.a(this.d, r14);
        return;
    L138:
        return;
    L16:
        r4 = 0;
        goto L18
    L8:
        r3 = 0;
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.alibaba.excel.support.asm.r
    public void a(q r6) {
        this.Z |= r6.a(this.l.f308a, this.l.f309b);
        if ((r6.f329b & 1) == 0) goto L5;
        return;
    L5:
        int r0 = this.O;
        if (r0 != 4) goto L23;
        if (this.R == null) goto L15;
        if (r6.c != this.R.c) goto L13;
        q r1 = this.R;
        r1.f329b = (short) (r1.f329b | (r6.f329b & 2));
        r6.h = this.R.h;
        return;
    L13:
        c(0, r6);
    L15:
        if (this.Q != null) goto L17;
    L21:
        this.Q = r6;
        this.R = r6;
        r6.h = new n(r6);
        return;
    L17:
        if (r6.c != this.Q.c) goto L20;
        q r2 = this.Q;
        r2.f329b = (short) (r2.f329b | (r6.f329b & 2));
        r6.h = this.Q.h;
        this.R = this.Q;
        return;
    L20:
        this.Q.i = r6;
        goto L21
    L23:
        if (r0 != 3) goto L28;
        q r3 = this.R;
        if (r3 != null) goto L27;
    L26:
        this.R = r6;
        return;
    L27:
        r3.h.f322a = r6;
        return;
    L28:
        if (r0 != 1) goto L36;
        q r4 = this.R;
        if (r4 == null) goto L32;
        r4.f = (short) this.T;
        c(this.S, r6);
    L32:
        this.R = r6;
        this.S = 0;
        this.T = 0;
        q r5 = this.Q;
        if (r5 == null) goto L35;
        r5.i = r6;
    L35:
        this.Q = r6;
        return;
    L36:
        if (r0 == 2) goto L38;
        return;
    L38:
        if (this.R == null) goto L26;
    }

    @Override // com.alibaba.excel.support.asm.r
    public void a(q r8, q r9, q r10, String r11) {
        if (r11 == null) goto L5;
        int r0 = this.d.a(r11).f339a;
    L6:
        p r6 = new p(r8, r9, r10, r0, r11);
        if (this.m != null) goto L9;
        this.m = r6;
    L10:
        this.n = r6;
        return;
    L9:
        this.n.f = r6;
        goto L10
    L5:
        r0 = 0;
        goto L6
    }

    @Override // com.alibaba.excel.support.asm.r
    public void a(q r6, int[] r7, q[] r8) {
        this.aa = this.l.f309b;
        int r3 = 0;
        this.l.a(171).a(null, 0, (4 - (this.l.f309b % 4)) % 4);
        r6.a(this.l, this.aa, true);
        this.l.c(r8.length);
    L4:
        if (r3 >= r8.length) goto L6;
        this.l.c(r7[r3]);
        r8[r3].a(this.l, this.aa, true);
        r3 = r3 + 1;
        goto L4
    L6:
        a(r6, r8);
    }

    @Override // com.alibaba.excel.support.asm.r
    public void a(Object r8) {
        this.aa = this.l.f309b;
        y r9 = this.d.a(r8);
        int r0 = r9.f339a;
        int r2 = 1;
        if (r9.f340b != 5) goto L5;
    L14:
        boolean r1 = true;
    L16:
        if (r1 == false) goto L20;
        d r5 = this.l;
        int r6 = 20;
    L18:
        r5.b(r6, r0);
    L23:
        q r3 = this.R;
        if (r3 == null) goto L39;
        int r7 = this.O;
        if (r7 != 4) goto L28;
    L37:
        r3.h.a(18, 0, r9, this.d);
        return;
    L28:
        if (r7 == 3) goto L37;
        int r10 = this.S;
        if (r1 == false) goto L33;
        r2 = 2;
    L33:
        int r11 = r10 + r2;
        if (r11 <= this.T) goto L36;
        this.T = r11;
    L36:
        this.S = r11;
        return;
    L39:
        return;
    L20:
        if (r0 < 256) goto L22;
        r5 = this.l;
        r6 = 19;
        goto L18
    L22:
        this.l.a(18, r0);
        goto L23
    L5:
        if (r9.f340b == 6) goto L14;
        if (r9.f340b != 17) goto L13;
        char r4 = r9.e.charAt(0);
        if (r4 == 'J') goto L14;
        if (r4 == 'D') goto L14;
    L13:
        r1 = false;
        goto L16
    }

    @Override // com.alibaba.excel.support.asm.r
    public void a(String r2, int r3) {
        if (this.M != null) goto L5;
        this.M = new d();
    L5:
        this.L++;
        d r0 = this.M;
        if (r2 != null) goto L8;
        int r1 = 0;
    L9:
        r0.b(r1).b(r3);
        return;
    L8:
        r1 = this.d.c(r2);
        goto L9
    }

    @Override // com.alibaba.excel.support.asm.r
    public void a(String r3, String r4, o r5, Object... r6) {
        this.aa = this.l.f309b;
        y r7 = this.d.b(r3, r4, r5, r6);
        this.l.b(186, r7.f339a);
        this.l.b(0);
        q r8 = this.R;
        if (r8 == null) goto L15;
        int r0 = this.O;
        if (r0 != 4) goto L7;
    L13:
        r8.h.a(186, 0, r7, this.d);
        return;
    L7:
        if (r0 == 3) goto L13;
        int r9 = r7.a();
        int r10 = ((r9 & 3) - (r9 >> 2)) + 1;
        int r11 = this.S + r10;
        if (r11 <= this.T) goto L12;
        this.T = r11;
    L12:
        this.S = r11;
        return;
    }

    @Override // com.alibaba.excel.support.asm.r
    public void a(String r5, String r6, String r7, q r8, q r9, int r10) {
        int r0 = 1;
        if (r7 == null) goto L9;
        if (this.t != null) goto L7;
        this.t = new d();
    L7:
        this.s++;
        this.t.b(r8.c).b(r9.c - r8.c).b(this.d.c(r5)).b(this.d.c(r7)).b(r10);
    L9:
        if (this.r != null) goto L11;
        this.r = new d();
    L11:
        this.q++;
        this.r.b(r8.c).b(r9.c - r8.c).b(this.d.c(r5)).b(this.d.c(r6)).b(r10);
        if (this.O == 0) goto L22;
        char r11 = r6.charAt(0);
        if (r11 != 'J') goto L16;
    L17:
        r0 = 2;
    L18:
        int r12 = r10 + r0;
        if (r12 <= this.k) goto L23;
        this.k = r12;
        return;
    L23:
        return;
    L16:
        if (r11 != 'D') goto L18;
    }

    boolean a(e r3, boolean r4, boolean r5, int r6, int r7, int r8) {
        if (r3 == this.d.a()) goto L5;
    L36:
        return false;
    L5:
        if (r6 != this.h) goto L36;
        if (r7 != this.B) goto L36;
        if ((this.e & 131072) == 0) goto L11;
        boolean r9 = true;
    L12:
        if (r5 != r9) goto L36;
        if (this.d.b() < 49) goto L17;
    L19:
        boolean r10 = false;
    L20:
        if (r4 == r10) goto L22;
        return false;
    L22:
        if (r8 != 0) goto L27;
        if (this.z == 0) goto L35;
        return false;
    L35:
        return true;
    L27:
        if (r3.c(r8) != this.z) goto L35;
        int r11 = r8 + 2;
        int r12 = 0;
    L30:
        if (r12 >= this.z) goto L35;
        if (r3.c(r11) != this.A[r12]) goto L33;
        r11 = r11 + 2;
        r12 = r12 + 1;
        goto L30
    L33:
        return false;
    L17:
        if ((this.e & 4096) == 0) goto L19;
        r10 = true;
        goto L20
    L11:
        r9 = false;
        goto L12
    }

    @Override // com.alibaba.excel.support.asm.r
    public a b(int r2, ab r3, String r4, boolean r5) {
        if (r5 == false) goto L6;
        b r6 = b.a(this.d, (r2 & (-16776961)) | (this.aa << 8), r3, r4, this.w);
        this.w = r6;
        return r6;
    L6:
        b r7 = b.a(this.d, (r2 & (-16776961)) | (this.aa << 8), r3, r4, this.x);
        this.x = r7;
        return r7;
    }

    @Override // com.alibaba.excel.support.asm.r
    public void b() {
    }

    @Override // com.alibaba.excel.support.asm.r
    public void b(int r7, int r8) {
        this.aa = this.l.f309b;
        if (r8 >= 4) goto L10;
        if (r7 == 169) goto L10;
        if (r7 >= 54) goto L7;
        int r3 = ((r7 - 21) << 2) + 26;
    L8:
        this.l.a(r3 + r8);
    L13:
        q r4 = this.R;
        if (r4 == null) goto L27;
        int r5 = this.O;
        if (r5 != 4) goto L18;
    L26:
        r4.h.a(r7, r8, null, null);
        goto L27
    L18:
        if (r5 == 3) goto L26;
        if (r7 != 169) goto L22;
        r4.f329b = (short) (r4.f329b | 64);
        this.R.e = (short) this.S;
        j();
        goto L27
    L22:
        int r0 = this.S + c[r7];
        if (r0 <= this.T) goto L25;
        this.T = r0;
    L25:
        this.S = r0;
    L27:
        int r1 = this.O;
        if (r1 != 0) goto L30;
    L43:
        if (r7 < 54) goto L49;
        if (r1 == 4) goto L46;
        return;
    L46:
        if (this.m == null) goto L51;
        a(new q());
        return;
    L51:
        return;
    L49:
        return;
    L30:
        if (r7 != 22) goto L32;
    L39:
        int r9 = r8 + 2;
    L41:
        if (r9 <= this.k) goto L43;
        this.k = r9;
        goto L43
    L32:
        if (r7 == 24) goto L39;
        if (r7 == 55) goto L39;
        if (r7 == 57) goto L39;
        r9 = r8 + 1;
        goto L41
    L7:
        r3 = ((r7 - 54) << 2) + 59;
    L10:
        if (r8 < 256) goto L12;
        this.l.a(196).b(r7, r8);
        goto L13
    L12:
        this.l.a(r7, r8);
        goto L13
    }

    @Override // com.alibaba.excel.support.asm.r
    public void b(int r2, q r3) {
        if (this.p != null) goto L5;
        this.p = new d();
    L5:
        this.o++;
        this.p.b(r3.c);
        this.p.b(r2);
    }

    @Override // com.alibaba.excel.support.asm.r
    public void b(String r5, int r6) {
        this.aa = this.l.f309b;
        y r7 = this.d.a(r5);
        this.l.b(197, r7.f339a).a(r6);
        q r0 = this.R;
        if (r0 == null) goto L12;
        int r1 = this.O;
        if (r1 != 4) goto L7;
    L10:
        r0.h.a(197, r6, r7, this.d);
        return;
    L7:
        if (r1 == 3) goto L10;
        this.S += 1 - r6;
        return;
    }

    @Override // com.alibaba.excel.support.asm.r
    public a c(int r2, ab r3, String r4, boolean r5) {
        if (r5 == false) goto L5;
        b r6 = b.a(this.d, r2, r3, r4, this.w);
        this.w = r6;
        return r6;
    L5:
        b r7 = b.a(this.d, r2, r3, r4, this.x);
        this.x = r7;
        return r7;
    }

    @Override // com.alibaba.excel.support.asm.r
    public void c() {
    }

    @Override // com.alibaba.excel.support.asm.r
    public void c(int r4, int r5) {
        this.aa = this.l.f309b;
        if (r4 <= 255) goto L5;
    L10:
        this.l.a(196).b(132, r4).b(r5);
    L11:
        q r6 = this.R;
        if (r6 == null) goto L19;
        int r1 = this.O;
        if (r1 != 4) goto L16;
    L17:
        r6.h.a(132, r4, null, null);
        goto L19
    L16:
        if (r1 == 3) goto L17;
    L19:
        if (this.O == 0) goto L24;
        int r7 = r4 + 1;
        if (r7 <= this.k) goto L25;
        this.k = r7;
        return;
    L25:
        return;
    L24:
        return;
    L5:
        if (r5 > 127) goto L10;
        if (r5 < (-128)) goto L10;
        this.l.a(132).a(r4, r5);
        goto L11
    }

    @Override // com.alibaba.excel.support.asm.r
    public void d(int r3, int r4) {
        int r0 = this.O;
        if (r0 != 4) goto L6;
        h();
        return;
    L6:
        if (r0 != 1) goto L9;
        i();
        return;
    L9:
        if (r0 != 2) goto L11;
        this.j = this.T;
        return;
    L11:
        this.j = r3;
        this.k = r4;
    }

    boolean d() {
        if (this.u <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    void e(int r1, int r2) {
        this.X[r1] = r2;
    }

    boolean e() {
        return this.Z;
    }

    void f() {
        if (this.W != null) goto L5;
    L8:
        this.W = this.X;
        this.X = null;
        return;
    L5:
        if (this.v != null) goto L7;
        this.v = new d();
    L7:
        k();
        this.u++;
        goto L8
    }

    void f(int r1, int r2) {
        this.ab = r1 + 6;
        this.ac = r2 - 6;
    }

    int g() {
        if (this.ab == 0) goto L7;
        return this.ac + 6;
    L7:
        if (this.l.f309b > 0) goto L9;
        int r0 = 8;
    L43:
        if (this.z <= 0) goto L45;
        this.d.c("Exceptions");
        r0 = r0 + ((this.z * 2) + 8);
    L45:
        int r1 = (r0 + c.a(this.d, this.e, this.B)) + b.a(this.C, this.D, this.I, this.f332J);
        b[] r2 = this.F;
        if (r2 == null) goto L51;
        int r3 = this.E;
        if (r3 != 0) goto L50;
        r3 = r2.length;
    L50:
        r1 = r1 + b.a("RuntimeVisibleParameterAnnotations", r2, r3);
    L51:
        b[] r4 = this.H;
        if (r4 == null) goto L58;
        int r5 = this.G;
        if (r5 != 0) goto L56;
        r5 = r4.length;
    L56:
        r1 = r1 + b.a("RuntimeInvisibleParameterAnnotations", r4, r5);
    L58:
        if (this.K == null) goto L61;
        this.d.c("AnnotationDefault");
        r1 = r1 + (this.K.f309b + 6);
    L61:
        if (this.M == null) goto L63;
        this.d.c("MethodParameters");
        r1 = r1 + (this.M.f309b + 7);
    L63:
        c r6 = this.N;
        if (r6 != null) goto L66;
        return r1;
    L66:
        return r1 + r6.a(this.d);
    L9:
        if (this.l.f309b > 65535) goto L40;
        this.d.c(com.tom_roush.pdfbox.pdmodel.a.d.i.K);
        r0 = ((this.l.f309b + 16) + p.b(this.m)) + 8;
        if (this.v == null) goto L22;
        if (this.d.b() < 50) goto L15;
        boolean r7 = true;
    L16:
        z r8 = this.d;
        if (r7 == false) goto L19;
        String r9 = "StackMapTable";
    L20:
        r8.c(r9);
        r0 = r0 + (this.v.f309b + 8);
        goto L22
    L19:
        r9 = "StackMap";
        goto L20
    L15:
        r7 = false;
    L22:
        if (this.p == null) goto L25;
        this.d.c("LineNumberTable");
        r0 = r0 + (this.p.f309b + 8);
    L25:
        if (this.r == null) goto L28;
        this.d.c("LocalVariableTable");
        r0 = r0 + (this.r.f309b + 8);
    L28:
        if (this.t == null) goto L30;
        this.d.c("LocalVariableTypeTable");
        r0 = r0 + (this.t.f309b + 8);
    L30:
        b r10 = this.w;
        if (r10 == null) goto L33;
        r0 = r0 + r10.b("RuntimeVisibleTypeAnnotations");
    L33:
        b r11 = this.x;
        if (r11 == null) goto L36;
        r0 = r0 + r11.b("RuntimeInvisibleTypeAnnotations");
    L36:
        c r12 = this.y;
        if (r12 == null) goto L43;
        r0 = r0 + r12.a(this.d, this.l.f308a, this.l.f309b, this.j, this.k);
        goto L43
    L40:
        throw new MethodTooLargeException(this.d.c(), this.g, this.i, this.l.f309b);
    }
}
