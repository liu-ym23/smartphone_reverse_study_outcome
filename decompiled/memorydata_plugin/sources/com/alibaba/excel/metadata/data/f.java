package com.alibaba.excel.metadata.data;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class f<T> extends a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BigDecimal f280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f281b;

    public f() {
    }

    public f(CellDataTypeEnum r1) {
        if (r1 == null) goto L7;
        a(r1);
        return;
    L7:
        throw new IllegalArgumentException("Type can not be null");
    }

    public f(CellDataTypeEnum r2, String r3) {
        if (r2 != CellDataTypeEnum.STRING) goto L5;
    L9:
        if (r3 == null) goto L13;
        a(r2);
        a(r3);
        return;
    L13:
        throw new IllegalArgumentException("StringValue can not be null");
    L5:
        if (r2 == CellDataTypeEnum.ERROR) goto L9;
        throw new IllegalArgumentException("Only support CellDataTypeEnum.STRING and  CellDataTypeEnum.ERROR");
    }

    public f(Boolean r2) {
        if (r2 == null) goto L7;
        a(CellDataTypeEnum.BOOLEAN);
        a(r2);
        return;
    L7:
        throw new IllegalArgumentException("BooleanValue can not be null");
    }

    public f(String r2) {
        this(CellDataTypeEnum.STRING, r2);
    }

    public f(BigDecimal r2) {
        if (r2 == null) goto L7;
        a(CellDataTypeEnum.NUMBER);
        a(r2);
        return;
    L7:
        throw new IllegalArgumentException("DoubleValue can not be null");
    }

    public static f<?> a(Boolean r1, Integer r2, Integer r3) {
        f<?> r0 = new f(r1);
        r0.a(r2);
        r0.b(r3);
        return r0;
    }

    public static f<?> a(Integer r2, Integer r3) {
        f<?> r0 = new f(CellDataTypeEnum.EMPTY);
        r0.a(r2);
        r0.b(r3);
        return r0;
    }

    public static f<?> a(String r1, Integer r2, Integer r3) {
        f<?> r0 = new f(r1);
        r0.a(r2);
        r0.b(r3);
        return r0;
    }

    public static f<?> a(BigDecimal r1, Integer r2, Integer r3) {
        f<?> r0 = new f(r1);
        r0.a(r2);
        r0.b(r3);
        r0.b(r1);
        r0.a(r1.round(com.alibaba.excel.d.b.f148a));
        return r0;
    }

    public void a(d r1) {
        this.f281b = r1;
    }

    @Override // com.alibaba.excel.metadata.data.a, com.alibaba.excel.metadata.a
    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, f.class);
    }

    public void b(BigDecimal r1) {
        this.f280a = r1;
    }

    public /* synthetic */ Object clone() {
        return i();
    }

    @Override // com.alibaba.excel.metadata.data.a, com.alibaba.excel.metadata.a
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r0 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.memorydata.plugin");
        if (r0.a(this) == true) goto L12;
        return false;
    L12:
        if (super.equals(r5) == true) goto L14;
        return false;
    L14:
        BigDecimal r6 = j();
        BigDecimal r2 = r0.j();
        if (r6 != null) goto L19;
        if (r2 != null) goto L20;
    L21:
        d r4 = k();
        d r7 = r0.k();
        if (r4 != null) goto L26;
        if (r7 != null) goto L27;
    L28:
        return true;
    L27:
        return false;
    L26:
        if (r4.equals(r7) == true) goto L28;
    L20:
        return false;
    L19:
        if (r6.equals(r2) == true) goto L21;
        goto L20
    }

    @Override // com.alibaba.excel.metadata.data.a, com.alibaba.excel.metadata.a
    public int hashCode() {
        int r0 = super.hashCode();
        BigDecimal r1 = j();
        int r2 = r0 * 59;
        int r3 = 43;
        if (r1 != null) goto L5;
        int r4 = 43;
    L6:
        d r5 = k();
        int r6 = (r2 + r4) * 59;
        if (r5 == null) goto L11;
        r3 = r5.hashCode();
    L11:
        return r6 + r3;
    L5:
        r4 = r1.hashCode();
        goto L6
    }

    public f<Object> i() {
        f<Object> r0 = new f();
        r0.a(getType());
        r0.a(d());
        r0.b(j());
        r0.a(e());
        r0.a(f());
        r0.b(g());
        if (k() == null) goto L6;
        r0.a(k().a());
    L6:
        if (h() == null) goto L8;
        r0.a(h().a());
    L8:
        return r0;
    }

    public BigDecimal j() {
        return this.f280a;
    }

    public d k() {
        return this.f281b;
    }
}
