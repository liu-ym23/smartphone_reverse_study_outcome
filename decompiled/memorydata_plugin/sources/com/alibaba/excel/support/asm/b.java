package com.alibaba.excel.support.asm;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class b extends a {
    private final z c;
    private final boolean d;
    private final d e;
    private final int f;
    private int g;
    private final b h;
    private b i;

    b(z r2, boolean r3, d r4, b r5) {
        super(589824);
        this.c = r2;
        this.d = r3;
        this.e = r4;
        if (r4.f309b != 0) goto L5;
        int r6 = -1;
    L6:
        this.f = r6;
        this.h = r5;
        if (r5 == null) goto L10;
        r5.i = this;
        return;
    L10:
        return;
    L5:
        r6 = r4.f309b - 2;
        goto L6
    }

    static int a(b r2, b r3, b r4, b r5) {
        int r0 = 0;
        if (r2 == null) goto L5;
        r0 = 0 + r2.b("RuntimeVisibleAnnotations");
    L5:
        if (r3 == null) goto L7;
        r0 = r0 + r3.b("RuntimeInvisibleAnnotations");
    L7:
        if (r4 == null) goto L9;
        r0 = r0 + r4.b("RuntimeVisibleTypeAnnotations");
    L9:
        if (r5 != null) goto L11;
        return r0;
    L11:
        return r0 + r5.b("RuntimeInvisibleTypeAnnotations");
    }

    static int a(String r4, b[] r5, int r6) {
        int r0 = (r6 * 2) + 7;
        int r2 = 0;
    L3:
        if (r2 >= r6) goto L9;
        b r3 = r5[r2];
        if (r3 != null) goto L7;
        int r7 = 0;
    L8:
        r0 = r0 + r7;
        r2 = r2 + 1;
        goto L3
    L7:
        r7 = r3.b(r4) - 8;
        goto L8
    L9:
        return r0;
    }

    static b a(z r1, int r2, ab r3, String r4, b r5) {
        d r0 = new d();
        ac.a(r2, r0);
        ab.a(r3, r0);
        r0.b(r1.c(r4)).b(0);
        return new b(r1, true, r0, r5);
    }

    static b a(z r2, String r3, b r4) {
        d r0 = new d();
        r0.b(r2.c(r3)).b(0);
        return new b(r2, true, r0, r4);
    }

    static void a(int r6, b[] r7, int r8, d r9) {
        int r0 = (r8 * 2) + 1;
        int r2 = 0;
    L4:
        if (r2 >= r8) goto L10;
        b r4 = r7[r2];
        if (r4 != null) goto L8;
        int r3 = 0;
    L9:
        r0 = r0 + r3;
        r2 = r2 + 1;
        goto L4
    L8:
        r3 = r4.b(null) - 8;
        goto L9
    L10:
        r9.b(r6);
        r9.c(r0);
        r9.a(r8);
        int r10 = 0;
    L11:
        if (r10 >= r8) goto L19;
        b r1 = r7[r10];
        int r5 = 0;
        b r11 = null;
    L13:
        if (r1 == null) goto L15;
        r1.a();
        r5 = r5 + 1;
        r11 = r1;
        r1 = r1.h;
        goto L13
    L15:
        r9.b(r5);
    L16:
        if (r11 == null) goto L18;
        r9.a(r11.e.f308a, 0, r11.e.f309b);
        r11 = r11.i;
        goto L16
    L18:
        r10 = r10 + 1;
        goto L11
    }

    static void a(z r1, b r2, b r3, b r4, b r5, d r6) {
        if (r2 == null) goto L4;
        r2.a(r1.c("RuntimeVisibleAnnotations"), r6);
    L4:
        if (r3 == null) goto L6;
        r3.a(r1.c("RuntimeInvisibleAnnotations"), r6);
    L6:
        if (r4 == null) goto L8;
        r4.a(r1.c("RuntimeVisibleTypeAnnotations"), r6);
    L8:
        if (r5 == null) goto L11;
        r5.a(r1.c("RuntimeInvisibleTypeAnnotations"), r6);
        return;
    }

    @Override // com.alibaba.excel.support.asm.a
    public a a(String r4) {
        this.g++;
        if (this.d == false) goto L5;
        this.e.b(this.c.c(r4));
    L5:
        this.e.b(91, 0);
        return new b(this.c, false, this.e, null);
    }

    @Override // com.alibaba.excel.support.asm.a
    public a a(String r4, String r5) {
        this.g++;
        if (this.d == false) goto L5;
        this.e.b(this.c.c(r4));
    L5:
        this.e.b(64, this.c.c(r5)).b(0);
        return new b(this.c, true, this.e, null);
    }

    @Override // com.alibaba.excel.support.asm.a
    public void a() {
        if (this.f == (-1)) goto L6;
        byte[] r0 = this.e.f308a;
        int r1 = this.f;
        int r3 = this.g;
        r0[r1] = (byte) (r3 >>> 8);
        r0[r1 + 1] = (byte) r3;
        return;
    }

    void a(int r6, d r7) {
        int r1 = 2;
        b r2 = null;
        int r3 = 0;
    L3:
        if (this == null) goto L5;
        this.a();
        r1 = r1 + this.e.f309b;
        r3 = r3 + 1;
        r2 = this;
        b this = this.h;
        goto L3
    L5:
        r7.b(r6);
        r7.c(r1);
        r7.b(r3);
    L6:
        if (r2 == null) goto L8;
        r7.a(r2.e.f308a, 0, r2.e.f309b);
        r2 = r2.i;
        goto L6
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
    @Override // com.alibaba.excel.support.asm.a
    public void a(String r18, Object r19) {
        this.g++;
        if (this.d == false) goto L6;
        this.e.b(this.c.c(r18));
    L6:
        if (ZeusTransformUtils.instanceOf(r19, String.class) == false) goto L10;
        d r2 = this.e;
        int r3 = 115;
        z r0 = this.c;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r19, String.class, "com.obric.memorydata.plugin");
    L8:
        r2.b(r3, r0.c(r1));
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r19, Byte.class) == false) goto L13;
        this.e.b(66, this.c.a(((Byte) ZeusTransformUtils.preCheckCast(r19, Byte.class, "com.obric.memorydata.plugin")).byteValue()).f339a);
        return;
    L13:
        if (ZeusTransformUtils.instanceOf(r19, Boolean.class) == false) goto L16;
        this.e.b(90, this.c.a(((Boolean) ZeusTransformUtils.preCheckCast(r19, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() ? 1 : 0).f339a);
        return;
    L16:
        if (ZeusTransformUtils.instanceOf(r19, Character.class) == false) goto L19;
        this.e.b(67, this.c.a(((Character) ZeusTransformUtils.preCheckCast(r19, Character.class, "com.obric.memorydata.plugin")).charValue()).f339a);
        return;
    L19:
        if (ZeusTransformUtils.instanceOf(r19, Short.class) == false) goto L22;
        this.e.b(83, this.c.a(((Short) ZeusTransformUtils.preCheckCast(r19, Short.class, "com.obric.memorydata.plugin")).shortValue()).f339a);
        return;
    L22:
        if (ZeusTransformUtils.instanceOf(r19, aa.class) == false) goto L25;
        r2 = this.e;
        r3 = 99;
        r0 = this.c;
        r1 = ((aa) ZeusTransformUtils.preCheckCast(r19, aa.class, "com.obric.memorydata.plugin")).d();
        goto L8
    L25:
        if ((r19 instanceof byte[]) == false) goto L30;
        byte[] r4 = (byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r19, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin");
        this.e.b(91, r4.length);
        int r5 = r4.length;
        int r6 = 0;
    L27:
        if (r6 >= r5) goto L79;
        this.e.b(66, this.c.a(r4[r6]).f339a);
        r6 = r6 + 1;
        goto L27
    L79:
        return;
    L30:
        if ((r19 instanceof boolean[]) == false) goto L35;
        boolean[] r7 = (boolean[]) ZeusTransformUtils.preCheckCast((boolean[]) ZeusTransformUtils.preCheckCast(r19, boolean[].class, "com.obric.memorydata.plugin"), boolean[].class, "com.obric.memorydata.plugin");
        this.e.b(91, r7.length);
        int r8 = r7.length;
        int r9 = 0;
    L32:
        if (r9 >= r8) goto L80;
        this.e.b(90, this.c.a(r7[r9] ? 1 : 0).f339a);
        r9 = r9 + 1;
        goto L32
    L80:
        return;
    L35:
        if ((r19 instanceof short[]) == false) goto L40;
        short[] r10 = (short[]) ZeusTransformUtils.preCheckCast((short[]) ZeusTransformUtils.preCheckCast(r19, short[].class, "com.obric.memorydata.plugin"), short[].class, "com.obric.memorydata.plugin");
        this.e.b(91, r10.length);
        int r11 = r10.length;
        int r12 = 0;
    L37:
        if (r12 >= r11) goto L81;
        this.e.b(83, this.c.a(r10[r12]).f339a);
        r12 = r12 + 1;
        goto L37
    L81:
        return;
    L40:
        if ((r19 instanceof char[]) == false) goto L45;
        char[] r13 = (char[]) ZeusTransformUtils.preCheckCast((char[]) ZeusTransformUtils.preCheckCast(r19, char[].class, "com.obric.memorydata.plugin"), char[].class, "com.obric.memorydata.plugin");
        this.e.b(91, r13.length);
        int r14 = r13.length;
        int r15 = 0;
    L42:
        if (r15 >= r14) goto L82;
        this.e.b(67, this.c.a(r13[r15]).f339a);
        r15 = r15 + 1;
        goto L42
    L82:
        return;
    L45:
        if ((r19 instanceof int[]) == false) goto L50;
        int[] r16 = (int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r19, int[].class, "com.obric.memorydata.plugin"), int[].class, "com.obric.memorydata.plugin");
        this.e.b(91, r16.length);
        int r17 = r16.length;
        int r20 = 0;
    L47:
        if (r20 >= r17) goto L83;
        this.e.b(73, this.c.a(r16[r20]).f339a);
        r20 = r20 + 1;
        goto L47
    L83:
        return;
    L50:
        if ((r19 instanceof long[]) == false) goto L55;
        long[] r21 = (long[]) ZeusTransformUtils.preCheckCast((long[]) ZeusTransformUtils.preCheckCast(r19, long[].class, "com.obric.memorydata.plugin"), long[].class, "com.obric.memorydata.plugin");
        this.e.b(91, r21.length);
        int r22 = r21.length;
        int r23 = 0;
    L52:
        if (r23 >= r22) goto L84;
        this.e.b(74, this.c.a(r21[r23]).f339a);
        r23 = r23 + 1;
        goto L52
    L84:
        return;
    L55:
        if ((r19 instanceof float[]) == false) goto L60;
        float[] r24 = (float[]) ZeusTransformUtils.preCheckCast((float[]) ZeusTransformUtils.preCheckCast(r19, float[].class, "com.obric.memorydata.plugin"), float[].class, "com.obric.memorydata.plugin");
        this.e.b(91, r24.length);
        int r25 = r24.length;
        int r26 = 0;
    L57:
        if (r26 >= r25) goto L85;
        this.e.b(70, this.c.a(r24[r26]).f339a);
        r26 = r26 + 1;
        goto L57
    L85:
        return;
    L60:
        if ((r19 instanceof double[]) == false) goto L64;
        double[] r27 = (double[]) ZeusTransformUtils.preCheckCast((double[]) ZeusTransformUtils.preCheckCast(r19, double[].class, "com.obric.memorydata.plugin"), double[].class, "com.obric.memorydata.plugin");
        this.e.b(91, r27.length);
        int r28 = r27.length;
        int r29 = 0;
    L62:
        if (r29 >= r28) goto L86;
        this.e.b(68, this.c.a(r27[r29]).f339a);
        r29 = r29 + 1;
        goto L62
    L86:
        return;
    L64:
        y r30 = this.c.a(r19);
        this.e.b(".s.IFJDCS".charAt(r30.f340b), r30.f339a);
    }

    @Override // com.alibaba.excel.support.asm.a
    public void a(String r3, String r4, String r5) {
        this.g++;
        if (this.d == false) goto L5;
        this.e.b(this.c.c(r3));
    L5:
        this.e.b(101, this.c.c(r4)).b(this.c.c(r5));
    }

    int b(String r2) {
        if (r2 == null) goto L4;
        this.c.c(r2);
    L4:
        int r3 = 8;
    L5:
        if (this == null) goto L7;
        r3 = r3 + this.e.f309b;
        b this = this.h;
        goto L5
    L7:
        return r3;
    }
}
