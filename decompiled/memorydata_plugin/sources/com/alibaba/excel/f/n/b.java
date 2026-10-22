package com.alibaba.excel.f.n;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.f;
import com.alibaba.excel.metadata.j;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.alibaba.excel.f.b<Long> {
    public b() {
    }

    @Override // com.alibaba.excel.f.b
    public Class<Long> a() {
        return Long.class;
    }

    @Override // com.alibaba.excel.f.b
    public /* synthetic */ Long a(f r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        return b(r1, r2, r3);
    }

    @Override // com.alibaba.excel.f.b
    public CellDataTypeEnum b() {
        return CellDataTypeEnum.NUMBER;
    }

    public Long b(f<?> r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        return Long.valueOf(r1.d().longValue());
    }
}
