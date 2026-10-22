package com.alibaba.excel.f.o;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.f;
import com.alibaba.excel.metadata.j;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.alibaba.excel.f.b<Short> {
    public b() {
    }

    @Override // com.alibaba.excel.f.b
    public Class<Short> a() {
        return Short.class;
    }

    @Override // com.alibaba.excel.f.b
    public /* synthetic */ Short a(f r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        return b(r1, r2, r3);
    }

    @Override // com.alibaba.excel.f.b
    public CellDataTypeEnum b() {
        return CellDataTypeEnum.NUMBER;
    }

    public Short b(f<?> r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        return Short.valueOf(r1.d().shortValue());
    }
}
