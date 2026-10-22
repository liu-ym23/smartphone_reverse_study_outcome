package com.alibaba.excel.metadata.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f250a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Field f251b;
    private com.alibaba.excel.f.b<?> c;
    private b d;
    private g e;
    private j f;
    private e g;

    static {
        f250a = new c();
    }

    public c() {
    }

    public Field a() {
        return this.f251b;
    }

    public void a(com.alibaba.excel.f.b<?> r3) {
        this.c = (com.alibaba.excel.f.b) ZeusTransformUtils.wrapperContextForParams(r3, com.alibaba.excel.f.b.class, "com.obric.memorydata.plugin");
    }

    public void a(b r1) {
        this.d = r1;
    }

    public void a(e r1) {
        this.g = r1;
    }

    public void a(g r1) {
        this.e = r1;
    }

    public void a(j r1) {
        this.f = r1;
    }

    public void a(Field r1) {
        this.f251b = r1;
    }

    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, c.class);
    }

    public com.alibaba.excel.f.b<?> b() {
        return this.c;
    }

    public b c() {
        return this.d;
    }

    public g d() {
        return this.e;
    }

    public j e() {
        return this.f;
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
        Field r0 = a();
        Field r2 = r6.a();
        if (r0 != null) goto L16;
        if (r2 != null) goto L17;
    L18:
        com.alibaba.excel.f.b<?> r1 = b();
        com.alibaba.excel.f.b<?> r3 = r6.b();
        if (r1 != null) goto L23;
        if (r3 != null) goto L24;
    L25:
        b r4 = c();
        b r7 = r6.c();
        if (r4 != null) goto L30;
        if (r7 != null) goto L31;
    L32:
        g r8 = d();
        g r9 = r6.d();
        if (r8 != null) goto L37;
        if (r9 != null) goto L38;
    L39:
        j r10 = e();
        j r11 = r6.e();
        if (r10 != null) goto L44;
        if (r11 != null) goto L45;
    L46:
        e r12 = f();
        e r13 = r6.f();
        if (r12 != null) goto L51;
        if (r13 != null) goto L52;
    L53:
        return true;
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

    public e f() {
        return this.g;
    }

    public int hashCode() {
        Field r0 = a();
        int r1 = 43;
        if (r0 != null) goto L5;
        int r2 = 43;
    L6:
        com.alibaba.excel.f.b<?> r3 = b();
        int r4 = (r2 + 59) * 59;
        if (r3 != null) goto L9;
        int r5 = 43;
    L10:
        int r6 = r4 + r5;
        b r7 = c();
        int r8 = r6 * 59;
        if (r7 != null) goto L13;
        int r9 = 43;
    L14:
        int r10 = r8 + r9;
        g r11 = d();
        int r12 = r10 * 59;
        if (r11 != null) goto L17;
        int r13 = 43;
    L18:
        int r14 = r12 + r13;
        j r15 = e();
        int r16 = r14 * 59;
        if (r15 != null) goto L21;
        int r17 = 43;
    L22:
        e r18 = f();
        int r19 = (r16 + r17) * 59;
        if (r18 == null) goto L27;
        r1 = r18.hashCode();
    L27:
        return r19 + r1;
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
}
