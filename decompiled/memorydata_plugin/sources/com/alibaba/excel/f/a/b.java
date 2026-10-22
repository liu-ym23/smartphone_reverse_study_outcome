package com.alibaba.excel.f.a;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.f;
import com.alibaba.excel.metadata.j;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.alibaba.excel.f.b<BigDecimal> {
    public b() {
    }

    @Override // com.alibaba.excel.f.b
    public Class<BigDecimal> a() {
        return BigDecimal.class;
    }

    @Override // com.alibaba.excel.f.b
    public /* synthetic */ BigDecimal a(f r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        return b(r1, r2, r3);
    }

    @Override // com.alibaba.excel.f.b
    public CellDataTypeEnum b() {
        return CellDataTypeEnum.NUMBER;
    }

    public BigDecimal b(f<?> r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        return r1.d();
    }
}
