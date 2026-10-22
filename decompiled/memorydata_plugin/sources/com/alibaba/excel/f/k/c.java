package com.alibaba.excel.f.k;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.i.l;
import com.alibaba.excel.metadata.data.f;
import com.alibaba.excel.metadata.j;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.alibaba.excel.f.b<Integer> {
    public c() {
    }

    @Override // com.alibaba.excel.f.b
    public Class<?> a() {
        return Integer.class;
    }

    @Override // com.alibaba.excel.f.b
    public /* synthetic */ Integer a(f r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        return b(r1, r2, r3);
    }

    @Override // com.alibaba.excel.f.b
    public CellDataTypeEnum b() {
        return CellDataTypeEnum.STRING;
    }

    public Integer b(f<?> r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        return l.c(r1.e(), r2);
    }
}
