package com.alibaba.excel.metadata.data;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.i.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class a<T> extends com.alibaba.excel.metadata.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CellDataTypeEnum f270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BigDecimal f271b;
    private String c;
    private Boolean d;
    private T e;
    private e f;

    /* JADX INFO: renamed from: com.alibaba.excel.metadata.data.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f272a = null;

        static {
            int[] r0 = new int[CellDataTypeEnum.values().length];
            f272a = r0;
            r0[CellDataTypeEnum.STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f272a[CellDataTypeEnum.DIRECT_STRING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f272a[CellDataTypeEnum.ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f272a[CellDataTypeEnum.NUMBER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f272a[CellDataTypeEnum.BOOLEAN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public a() {
    }

    public void a(CellDataTypeEnum r1) {
        this.f270a = r1;
    }

    public void a(e r1) {
        this.f = r1;
    }

    public void a(Boolean r1) {
        this.d = r1;
    }

    public void a(String r1) {
        this.c = r1;
    }

    public void a(BigDecimal r1) {
        this.f271b = r1;
    }

    @Override // com.alibaba.excel.metadata.a
    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, a.class);
    }

    public void b(T r1) {
        this.e = r1;
    }

    public void c() {
        if (this.f270a != null) goto L5;
        this.f270a = CellDataTypeEnum.EMPTY;
    L5:
        int r0 = AnonymousClass1.f272a[this.f270a.ordinal()];
        if (r0 == 1) goto L25;
        if (r0 == 2) goto L25;
        if (r0 == 3) goto L25;
        if (r0 == 4) goto L21;
        if (r0 == 5) goto L17;
        return;
    L17:
        if (this.d != null) goto L28;
        this.f270a = CellDataTypeEnum.EMPTY;
        return;
    L28:
        return;
    L21:
        if (this.f271b != null) goto L29;
        this.f270a = CellDataTypeEnum.EMPTY;
        return;
    L29:
        return;
    L25:
        if (o.a(this.c) == false) goto L30;
        this.f270a = CellDataTypeEnum.EMPTY;
        return;
    }

    public BigDecimal d() {
        return this.f271b;
    }

    public String e() {
        return this.c;
    }

    @Override // com.alibaba.excel.metadata.a
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r0 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        if (r0.a(this) == true) goto L12;
        return false;
    L12:
        if (super.equals(r5) == true) goto L14;
        return false;
    L14:
        Boolean r6 = f();
        Boolean r2 = r0.f();
        if (r6 != null) goto L19;
        if (r2 != null) goto L20;
    L21:
        CellDataTypeEnum r7 = getType();
        CellDataTypeEnum r3 = r0.getType();
        if (r7 != null) goto L26;
        if (r3 != null) goto L27;
    L28:
        BigDecimal r8 = d();
        BigDecimal r4 = r0.d();
        if (r8 != null) goto L33;
        if (r4 != null) goto L34;
    L35:
        String r9 = e();
        String r10 = r0.e();
        if (r9 != null) goto L40;
        if (r10 != null) goto L41;
    L42:
        T r11 = g();
        Object r12 = r0.g();
        if (r11 != null) goto L47;
        if (r12 != null) goto L48;
    L49:
        e r13 = h();
        e r14 = r0.h();
        if (r13 != null) goto L54;
        if (r14 != null) goto L55;
    L56:
        return true;
    L55:
        return false;
    L54:
        if (r13.equals(r14) == true) goto L56;
    L48:
        return false;
    L47:
        if (r11.equals(r12) == true) goto L49;
    L41:
        return false;
    L40:
        if (r9.equals(r10) == true) goto L42;
    L34:
        return false;
    L33:
        if (r8.equals(r4) == true) goto L35;
    L27:
        return false;
    L26:
        if (r7.equals(r3) == true) goto L28;
    L20:
        return false;
    L19:
        if (r6.equals(r2) == true) goto L21;
        goto L20
    }

    public Boolean f() {
        return this.d;
    }

    public T g() {
        return this.e;
    }

    public CellDataTypeEnum getType() {
        return this.f270a;
    }

    public e h() {
        return this.f;
    }

    @Override // com.alibaba.excel.metadata.a
    public int hashCode() {
        int r0 = super.hashCode();
        Boolean r1 = f();
        int r2 = r0 * 59;
        int r3 = 43;
        if (r1 != null) goto L5;
        int r4 = 43;
    L6:
        int r5 = r2 + r4;
        CellDataTypeEnum r6 = getType();
        int r7 = r5 * 59;
        if (r6 != null) goto L9;
        int r8 = 43;
    L10:
        int r9 = r7 + r8;
        BigDecimal r10 = d();
        int r11 = r9 * 59;
        if (r10 != null) goto L13;
        int r12 = 43;
    L14:
        int r13 = r11 + r12;
        String r14 = e();
        int r15 = r13 * 59;
        if (r14 != null) goto L17;
        int r16 = 43;
    L18:
        int r17 = r15 + r16;
        T r18 = g();
        int r19 = r17 * 59;
        if (r18 != null) goto L21;
        int r20 = 43;
    L22:
        e r21 = h();
        int r22 = (r19 + r20) * 59;
        if (r21 == null) goto L27;
        r3 = r21.hashCode();
    L27:
        return r22 + r3;
    L21:
        r20 = r18.hashCode();
        goto L22
    L17:
        r16 = r14.hashCode();
        goto L18
    L13:
        r12 = r10.hashCode();
        goto L14
    L9:
        r8 = r6.hashCode();
        goto L10
    L5:
        r4 = r1.hashCode();
        goto L6
    }
}
