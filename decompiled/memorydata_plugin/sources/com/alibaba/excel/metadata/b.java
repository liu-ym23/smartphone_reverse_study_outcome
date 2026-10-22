package com.alibaba.excel.metadata;

import com.alibaba.excel.enums.CacheLocationEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Boolean f260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<List<String>> f261b;
    private Class<?> c;
    private j d;
    private Map<com.alibaba.excel.f.c.a, com.alibaba.excel.f.b<?>> e;

    public b() {
    }

    public b(d r3, b r4) {
        this.f260a = Boolean.TRUE;
        if (r3.a() == null) goto L5;
    L8:
        List<List<String>> r0 = r3.a();
    L9:
        this.f261b = r0;
        if (r3.a() == null) goto L12;
    L15:
        Class<?> r1 = r3.b();
    L16:
        this.c = r1;
        this.d = new j();
        if (r3.d() != null) goto L20;
        if (r4 == null) goto L23;
        j r2 = this.d;
        Boolean r5 = r4.f().a();
    L21:
        r2.a(r5);
    L23:
        if (r3.e() != null) goto L26;
        if (r4 == null) goto L29;
        j r6 = this.d;
        Boolean r7 = r4.f().b();
    L27:
        r6.b(r7);
    L29:
        if (r3.f() != null) goto L32;
        if (r4 == null) goto L35;
        j r8 = this.d;
        Locale r9 = r4.f().c();
    L33:
        r8.a(r9);
    L35:
        if (r3.h() != null) goto L38;
        if (r4 == null) goto L41;
        j r10 = this.d;
        CacheLocationEnum r11 = r4.f().e();
    L39:
        r10.a(r11);
        return;
    L41:
        return;
    L38:
        r10 = this.d;
        r11 = r3.h();
        goto L39
    L32:
        r8 = this.d;
        r9 = r3.f();
        goto L33
    L26:
        r6 = this.d;
        r7 = r3.e();
        goto L27
    L20:
        r2 = this.d;
        r5 = r3.d();
        goto L21
    L12:
        if (r3.b() != null) goto L15;
        if (r4 == null) goto L15;
        r1 = r4.e();
        goto L16
    L5:
        if (r3.b() != null) goto L8;
        if (r4 == null) goto L8;
        r0 = r4.d();
        goto L9
    }

    public Map<com.alibaba.excel.f.c.a, com.alibaba.excel.f.b<?>> a() {
        return g();
    }

    public void a(Map<com.alibaba.excel.f.c.a, com.alibaba.excel.f.b<?>> r3) {
        this.e = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, b.class);
    }

    @Override // com.alibaba.excel.metadata.g
    public j b() {
        return f();
    }

    public Boolean c() {
        return this.f260a;
    }

    public List<List<String>> d() {
        return this.f261b;
    }

    public Class<?> e() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (r6.a(this) == true) goto L11;
        return false;
    L11:
        Boolean r0 = c();
        Boolean r2 = r6.c();
        if (r0 != null) goto L16;
        if (r2 != null) goto L17;
    L18:
        List<List<String>> r1 = d();
        List<List<String>> r3 = r6.d();
        if (r1 != null) goto L23;
        if (r3 != null) goto L24;
    L25:
        Class<?> r4 = e();
        Class<?> r7 = r6.e();
        if (r4 != null) goto L30;
        if (r7 != null) goto L31;
    L32:
        j r8 = f();
        j r9 = r6.f();
        if (r8 != null) goto L37;
        if (r9 != null) goto L38;
    L39:
        Map<com.alibaba.excel.f.c.a, com.alibaba.excel.f.b<?>> r10 = g();
        Map<com.alibaba.excel.f.c.a, com.alibaba.excel.f.b<?>> r11 = r6.g();
        if (r10 != null) goto L44;
        if (r11 != null) goto L45;
    L46:
        return true;
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

    public j f() {
        return this.d;
    }

    public Map<com.alibaba.excel.f.c.a, com.alibaba.excel.f.b<?>> g() {
        return this.e;
    }

    public int hashCode() {
        Boolean r0 = c();
        int r1 = 43;
        if (r0 != null) goto L5;
        int r2 = 43;
    L6:
        List<List<String>> r3 = d();
        int r4 = (r2 + 59) * 59;
        if (r3 != null) goto L9;
        int r5 = 43;
    L10:
        int r6 = r4 + r5;
        Class<?> r7 = e();
        int r8 = r6 * 59;
        if (r7 != null) goto L13;
        int r9 = 43;
    L14:
        int r10 = r8 + r9;
        j r11 = f();
        int r12 = r10 * 59;
        if (r11 != null) goto L17;
        int r13 = 43;
    L18:
        Map<com.alibaba.excel.f.c.a, com.alibaba.excel.f.b<?>> r14 = g();
        int r15 = (r12 + r13) * 59;
        if (r14 == null) goto L23;
        r1 = r14.hashCode();
    L23:
        return r15 + r1;
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
