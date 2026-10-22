package com.alibaba.excel.metadata;

import com.alibaba.excel.enums.CacheLocationEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<List<String>> f262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Class<?> f263b;
    private List<com.alibaba.excel.f.b<?>> c;
    private Boolean d;
    private Boolean e;
    private Locale f;
    private Boolean g;
    private CacheLocationEnum h;

    public d() {
    }

    public List<List<String>> a() {
        return this.f262a;
    }

    public void a(Boolean r1) {
        this.d = r1;
    }

    public void a(Class<?> r1) {
        this.f263b = r1;
    }

    public void a(List<List<String>> r3) {
        this.f262a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, d.class);
    }

    public Class<?> b() {
        return this.f263b;
    }

    public void b(Boolean r1) {
        this.e = r1;
    }

    public void b(List<com.alibaba.excel.f.b<?>> r3) {
        this.c = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public List<com.alibaba.excel.f.b<?>> c() {
        return this.c;
    }

    public Boolean d() {
        return this.d;
    }

    public Boolean e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
        if (r6.a(this) == true) goto L11;
        return false;
    L11:
        Boolean r0 = d();
        Boolean r2 = r6.d();
        if (r0 != null) goto L16;
        if (r2 != null) goto L17;
    L18:
        Boolean r1 = e();
        Boolean r3 = r6.e();
        if (r1 != null) goto L23;
        if (r3 != null) goto L24;
    L25:
        Boolean r4 = g();
        Boolean r7 = r6.g();
        if (r4 != null) goto L30;
        if (r7 != null) goto L31;
    L32:
        List<List<String>> r8 = a();
        List<List<String>> r9 = r6.a();
        if (r8 != null) goto L37;
        if (r9 != null) goto L38;
    L39:
        Class<?> r10 = b();
        Class<?> r11 = r6.b();
        if (r10 != null) goto L44;
        if (r11 != null) goto L45;
    L46:
        List<com.alibaba.excel.f.b<?>> r12 = c();
        List<com.alibaba.excel.f.b<?>> r13 = r6.c();
        if (r12 != null) goto L51;
        if (r13 != null) goto L52;
    L53:
        Locale r14 = f();
        Locale r15 = r6.f();
        if (r14 != null) goto L58;
        if (r15 != null) goto L59;
    L60:
        CacheLocationEnum r16 = h();
        CacheLocationEnum r17 = r6.h();
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

    public Locale f() {
        return this.f;
    }

    public Boolean g() {
        return this.g;
    }

    public CacheLocationEnum h() {
        return this.h;
    }

    public int hashCode() {
        Boolean r0 = d();
        int r1 = 43;
        if (r0 != null) goto L5;
        int r2 = 43;
    L6:
        Boolean r3 = e();
        int r4 = (r2 + 59) * 59;
        if (r3 != null) goto L9;
        int r5 = 43;
    L10:
        int r6 = r4 + r5;
        Boolean r7 = g();
        int r8 = r6 * 59;
        if (r7 != null) goto L13;
        int r9 = 43;
    L14:
        int r10 = r8 + r9;
        List<List<String>> r11 = a();
        int r12 = r10 * 59;
        if (r11 != null) goto L17;
        int r13 = 43;
    L18:
        int r14 = r12 + r13;
        Class<?> r15 = b();
        int r16 = r14 * 59;
        if (r15 != null) goto L21;
        int r17 = 43;
    L22:
        int r18 = r16 + r17;
        List<com.alibaba.excel.f.b<?>> r19 = c();
        int r20 = r18 * 59;
        if (r19 != null) goto L25;
        int r21 = 43;
    L26:
        int r22 = r20 + r21;
        Locale r23 = f();
        int r24 = r22 * 59;
        if (r23 != null) goto L29;
        int r25 = 43;
    L30:
        CacheLocationEnum r26 = h();
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
}
