package com.alibaba.excel.f.c;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.f;
import com.alibaba.excel.metadata.j;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.alibaba.excel.f.b<Boolean> {
    public b() {
    }

    @Override // com.alibaba.excel.f.b
    public Class<?> a() {
        return Boolean.class;
    }

    @Override // com.alibaba.excel.f.b
    public /* synthetic */ Boolean a(f r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        return b(r1, r2, r3);
    }

    @Override // com.alibaba.excel.f.b
    public CellDataTypeEnum b() {
        return CellDataTypeEnum.NUMBER;
    }

    public Boolean b(f<?> r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        if (BigDecimal.ONE.compareTo(r1.d()) != 0) goto L7;
        return Boolean.TRUE;
    L7:
        return Boolean.FALSE;
    }
}
