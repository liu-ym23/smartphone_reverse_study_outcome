package com.alibaba.excel.f.p;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.f;
import com.alibaba.excel.metadata.j;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.alibaba.excel.f.b<String> {
    public b() {
    }

    @Override // com.alibaba.excel.f.b
    public Class<String> a() {
        return String.class;
    }

    @Override // com.alibaba.excel.f.b
    public /* synthetic */ String a(f r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        return b(r1, r2, r3);
    }

    @Override // com.alibaba.excel.f.b
    public CellDataTypeEnum b() {
        return CellDataTypeEnum.ERROR;
    }

    public String b(f<?> r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        return r1.e();
    }
}
