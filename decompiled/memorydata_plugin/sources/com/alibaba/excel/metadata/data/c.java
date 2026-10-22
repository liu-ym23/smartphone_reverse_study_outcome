package com.alibaba.excel.metadata.data;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Integer f275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Integer f276b;
    private Integer c;
    private Integer d;
    private Integer e;
    private Integer f;
    private Integer g;
    private Integer h;

    public c() {
    }

    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, c.class);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
        if (r6.a(this) == true) goto L11;
        return false;
    L11:
        Integer r0 = h();
        Integer r2 = r6.h();
        if (r0 != null) goto L16;
        if (r2 != null) goto L17;
    L18:
        Integer r1 = i();
        Integer r3 = r6.i();
        if (r1 != null) goto L23;
        if (r3 != null) goto L24;
    L25:
        Integer r4 = j();
        Integer r7 = r6.j();
        if (r4 != null) goto L30;
        if (r7 != null) goto L31;
    L32:
        Integer r8 = k();
        Integer r9 = r6.k();
        if (r8 != null) goto L37;
        if (r9 != null) goto L38;
    L39:
        Integer r10 = l();
        Integer r11 = r6.l();
        if (r10 != null) goto L44;
        if (r11 != null) goto L45;
    L46:
        Integer r12 = m();
        Integer r13 = r6.m();
        if (r12 != null) goto L51;
        if (r13 != null) goto L52;
    L53:
        Integer r14 = n();
        Integer r15 = r6.n();
        if (r14 != null) goto L58;
        if (r15 != null) goto L59;
    L60:
        Integer r16 = o();
        Integer r17 = r6.o();
        if (r16 != null) goto L65;
        if (r17 != null) goto L66;
    L67:
        return true;
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

    public Integer h() {
        return this.f275a;
    }

    public int hashCode() {
        Integer r0 = h();
        int r1 = 43;
        if (r0 != null) goto L5;
        int r2 = 43;
    L6:
        Integer r3 = i();
        int r4 = (r2 + 59) * 59;
        if (r3 != null) goto L9;
        int r5 = 43;
    L10:
        int r6 = r4 + r5;
        Integer r7 = j();
        int r8 = r6 * 59;
        if (r7 != null) goto L13;
        int r9 = 43;
    L14:
        int r10 = r8 + r9;
        Integer r11 = k();
        int r12 = r10 * 59;
        if (r11 != null) goto L17;
        int r13 = 43;
    L18:
        int r14 = r12 + r13;
        Integer r15 = l();
        int r16 = r14 * 59;
        if (r15 != null) goto L21;
        int r17 = 43;
    L22:
        int r18 = r16 + r17;
        Integer r19 = m();
        int r20 = r18 * 59;
        if (r19 != null) goto L25;
        int r21 = 43;
    L26:
        int r22 = r20 + r21;
        Integer r23 = n();
        int r24 = r22 * 59;
        if (r23 != null) goto L29;
        int r25 = 43;
    L30:
        Integer r26 = o();
        int r27 = (r24 + r25) * 59;
        if (r26 == null) goto L35;
        r1 = r26.hashCode();
    L35:
        return r27 + r1;
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

    public Integer i() {
        return this.f276b;
    }

    public Integer j() {
        return this.c;
    }

    public Integer k() {
        return this.d;
    }

    public Integer l() {
        return this.e;
    }

    public Integer m() {
        return this.f;
    }

    public Integer n() {
        return this.g;
    }

    public Integer o() {
        return this.h;
    }
}
