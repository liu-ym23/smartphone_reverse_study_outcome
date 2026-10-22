package com.alibaba.excel.f.m;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.i.e;
import com.alibaba.excel.metadata.data.f;
import com.alibaba.excel.metadata.j;
import java.time.LocalDateTime;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.alibaba.excel.f.b<LocalDateTime> {
    public c() {
    }

    @Override // com.alibaba.excel.f.b
    public Class<?> a() {
        return LocalDateTime.class;
    }

    @Override // com.alibaba.excel.f.b
    public /* synthetic */ LocalDateTime a(f r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        return b(r1, r2, r3);
    }

    @Override // com.alibaba.excel.f.b
    public CellDataTypeEnum b() {
        return CellDataTypeEnum.STRING;
    }

    public LocalDateTime b(f<?> r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        if (r2 != null) goto L4;
    L9:
        String r0 = r1.e();
        String r4 = null;
    L8:
        return e.a(r0, r4, r3.c());
    L4:
        if (r2.c() == null) goto L9;
        r0 = r1.e();
        r4 = r2.c().a();
        goto L8
    }
}
