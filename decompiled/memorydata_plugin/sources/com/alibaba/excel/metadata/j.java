package com.alibaba.excel.metadata;

import com.alibaba.excel.enums.CacheLocationEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Boolean f294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Boolean f295b;
    private Locale c;
    private Boolean d;
    private CacheLocationEnum e;

    public j() {
        this.f294a = Boolean.TRUE;
        this.f295b = Boolean.FALSE;
        this.c = Locale.getDefault();
        this.d = Boolean.FALSE;
        this.e = CacheLocationEnum.THREAD_LOCAL;
    }

    public Boolean a() {
        return this.f294a;
    }

    public void a(CacheLocationEnum r1) {
        this.e = r1;
    }

    public void a(Boolean r1) {
        this.f294a = r1;
    }

    public void a(Locale r1) {
        this.c = r1;
    }

    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, j.class);
    }

    public Boolean b() {
        return this.f295b;
    }

    public void b(Boolean r1) {
        this.f295b = r1;
    }

    public Locale c() {
        return this.c;
    }

    public void c(Boolean r1) {
        this.d = r1;
    }

    public Boolean d() {
        return this.d;
    }

    public CacheLocationEnum e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L8;
        return false;
    L8:
        j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.memorydata.plugin");
        if (r6.a(this) == true) goto L11;
        return false;
    L11:
        Boolean r0 = a();
        Boolean r2 = r6.a();
        if (r0 != null) goto L16;
        if (r2 != null) goto L17;
    L18:
        Boolean r1 = b();
        Boolean r3 = r6.b();
        if (r1 != null) goto L23;
        if (r3 != null) goto L24;
    L25:
        Boolean r4 = d();
        Boolean r7 = r6.d();
        if (r4 != null) goto L30;
        if (r7 != null) goto L31;
    L32:
        Locale r8 = c();
        Locale r9 = r6.c();
        if (r8 != null) goto L37;
        if (r9 != null) goto L38;
    L39:
        CacheLocationEnum r10 = e();
        CacheLocationEnum r11 = r6.e();
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

    public int hashCode() {
        Boolean r0 = a();
        int r1 = 43;
        if (r0 != null) goto L5;
        int r2 = 43;
    L6:
        Boolean r3 = b();
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
        Locale r11 = c();
        int r12 = r10 * 59;
        if (r11 != null) goto L17;
        int r13 = 43;
    L18:
        CacheLocationEnum r14 = e();
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
