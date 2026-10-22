package com.alibaba.excel.f.g;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.i.l;
import com.alibaba.excel.metadata.data.f;
import com.alibaba.excel.metadata.j;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.alibaba.excel.f.b<Double> {
    public c() {
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
        return CellDataTypeEnum.STRING;
    }

    public Double b(f<?> r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        return l.g(r1.e(), r2);
    }
}
