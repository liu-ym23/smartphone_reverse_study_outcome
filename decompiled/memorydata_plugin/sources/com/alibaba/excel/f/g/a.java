package com.alibaba.excel.f.g;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.f;
import com.alibaba.excel.metadata.j;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.alibaba.excel.f.b<Double> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Double f161a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Double f162b = null;

    static {
        f161a = Double.valueOf(1.0d);
        f162b = Double.valueOf(0.0d);
    }

    public a() {
    }

    @Override // com.alibaba.excel.f.b
    public Class<?> a() {
        return Double.class;
    }

    @Override // com.alibaba.excel.f.b
    public /* synthetic */ Double a(f r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        return b(r1, r2, r3);
    }

    @Override // com.alibaba.excel.f.b
    public CellDataTypeEnum b() {
        return CellDataTypeEnum.BOOLEAN;
    }

    public Double b(f<?> r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        if (r1.f().booleanValue() == false) goto L7;
        return f161a;
    L7:
        return f162b;
    }
}
