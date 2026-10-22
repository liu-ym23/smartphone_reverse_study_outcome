package com.alibaba.excel.metadata.a;

import com.alibaba.excel.i.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Short f255b;
    private Boolean c;
    private Boolean d;
    private Short e;
    private Short f;
    private Byte g;
    private Integer h;
    private Boolean i;

    public e() {
    }

    public static e a(com.alibaba.excel.b.b.a.a r2) {
        com.alibaba.excel.b.b.a.a r3 = (com.alibaba.excel.b.b.a.a) ZeusTransformUtils.wrapperContextForParams(r2, com.alibaba.excel.b.b.a.a.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        return null;
    L6:
        e r0 = new e();
        if (o.c(r3.a()) == false) goto L10;
        r0.a(r3.a());
    L10:
        if (r3.b() < 0) goto L12;
        r0.a(Short.valueOf(r3.b()));
    L12:
        r0.a(r3.c().getBooleanValue());
        r0.b(r3.d().getBooleanValue());
        if (r3.e() < 0) goto L16;
        r0.b(Short.valueOf(r3.e()));
    L16:
        if (r3.f() < 0) goto L19;
        r0.c(Short.valueOf(r3.f()));
    L19:
        if (r3.g() < 0) goto L22;
        r0.a(Byte.valueOf(r3.g()));
    L22:
        if (r3.h() < 0) goto L24;
        r0.a(Integer.valueOf(r3.h()));
    L24:
        r0.c(r3.i().getBooleanValue());
        return r0;
    }

    public String a() {
        return this.f254a;
    }

    public void a(Boolean r1) {
        this.c = r1;
    }

    public void a(Byte r1) {
        this.g = r1;
    }

    public void a(Integer r1) {
        this.h = r1;
    }

    public void a(Short r1) {
        this.f255b = r1;
    }

    public void a(String r1) {
        this.f254a = r1;
    }

    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, e.class);
    }

    public Short b() {
        return this.f255b;
    }

    public void b(Boolean r1) {
        this.d = r1;
    }

    public void b(Short r1) {
        this.e = r1;
    }

    public Boolean c() {
        return this.c;
    }

    public void c(Boolean r1) {
        this.i = r1;
    }

    public void c(Short r1) {
        this.f = r1;
    }

    public Boolean d() {
        return this.d;
    }

    public Short e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
        if (r6.a(this) == true) goto L11;
        return false;
    L11:
        Short r0 = b();
        Short r2 = r6.b();
        if (r0 != null) goto L16;
        if (r2 != null) goto L17;
    L18:
        Boolean r1 = c();
        Boolean r3 = r6.c();
        if (r1 != null) goto L23;
        if (r3 != null) goto L24;
    L25:
        Boolean r4 = d();
        Boolean r7 = r6.d();
        if (r4 != null) goto L30;
        if (r7 != null) goto L31;
    L32:
        Short r8 = e();
        Short r9 = r6.e();
        if (r8 != null) goto L37;
        if (r9 != null) goto L38;
    L39:
        Short r10 = f();
        Short r11 = r6.f();
        if (r10 != null) goto L44;
        if (r11 != null) goto L45;
    L46:
        Byte r12 = g();
        Byte r13 = r6.g();
        if (r12 != null) goto L51;
        if (r13 != null) goto L52;
    L53:
        Integer r14 = h();
        Integer r15 = r6.h();
        if (r14 != null) goto L58;
        if (r15 != null) goto L59;
    L60:
        Boolean r16 = i();
        Boolean r17 = r6.i();
        if (r16 != null) goto L65;
        if (r17 != null) goto L66;
    L67:
        String r18 = a();
        String r19 = r6.a();
        if (r18 != null) goto L72;
        if (r19 != null) goto L73;
    L74:
        return true;
    L73:
        return false;
    L72:
        if (r18.equals(r19) == true) goto L74;
    L66:
        return false;
    L65:
        if (r16.equals(r17) == true) goto L67;
    L59:
        return false;
    L58:
        if (r14.equals(r15) == true) goto L60;
    L52:
        return false;
    L51:
        if (r12.equals(r13) == true) goto L53;
    L45:
        return false;
    L44:
        if (r10.equals(r11) == true) goto L46;
    L38:
        return false;
    L37:
        if (r8.equals(r9) == true) goto L39;
    L31:
        return false;
    L30:
        if (r4.equals(r7) == true) goto L32;
    L24:
        return false;
    L23:
        if (r1.equals(r3) == true) goto L25;
    L17:
        return false;
    L16:
        if (r0.equals(r2) == true) goto L18;
        goto L17
    }

    public Short f() {
        return this.f;
    }

    public Byte g() {
        return this.g;
    }

    public Integer h() {
        return this.h;
    }

    public int hashCode() {
        Short r0 = b();
        int r1 = 43;
        if (r0 != null) goto L5;
        int r2 = 43;
    L6:
        Boolean r3 = c();
        int r4 = (r2 + 59) * 59;
        if (r3 != null) goto L9;
        int r5 = 43;
    L10:
        int r6 = r4 + r5;
        Boolean r7 = d();
        int r8 = r6 * 59;
        if (r7 != null) goto L13;
        int r9 = 43;
    L14:
        int r10 = r8 + r9;
        Short r11 = e();
        int r12 = r10 * 59;
        if (r11 != null) goto L17;
        int r13 = 43;
    L18:
        int r14 = r12 + r13;
        Short r15 = f();
        int r16 = r14 * 59;
        if (r15 != null) goto L21;
        int r17 = 43;
    L22:
        int r18 = r16 + r17;
        Byte r19 = g();
        int r20 = r18 * 59;
        if (r19 != null) goto L25;
        int r21 = 43;
    L26:
        int r22 = r20 + r21;
        Integer r23 = h();
        int r24 = r22 * 59;
        if (r23 != null) goto L29;
        int r25 = 43;
    L30:
        int r26 = r24 + r25;
        Boolean r27 = i();
        int r28 = r26 * 59;
        if (r27 != null) goto L33;
        int r29 = 43;
    L34:
        String r30 = a();
        int r31 = (r28 + r29) * 59;
        if (r30 == null) goto L39;
        r1 = r30.hashCode();
    L39:
        return r31 + r1;
    L33:
        r29 = r27.hashCode();
        goto L34
    L29:
        r25 = r23.hashCode();
        goto L30
    L25:
        r21 = r19.hashCode();
        goto L26
    L21:
        r17 = r15.hashCode();
        goto L22
    L17:
        r13 = r11.hashCode();
        goto L18
    L13:
        r9 = r7.hashCode();
        goto L14
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public Boolean i() {
        return this.i;
    }
}
