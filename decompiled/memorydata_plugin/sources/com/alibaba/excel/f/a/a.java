package com.alibaba.excel.f.a;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.f;
import com.alibaba.excel.metadata.j;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.alibaba.excel.f.b<BigDecimal> {
    public a() {
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
        return CellDataTypeEnum.BOOLEAN;
    }

    public BigDecimal b(f<?> r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        if (r1.f().booleanValue() == false) goto L7;
        return BigDecimal.ONE;
    L7:
        return BigDecimal.ZERO;
    }
}
