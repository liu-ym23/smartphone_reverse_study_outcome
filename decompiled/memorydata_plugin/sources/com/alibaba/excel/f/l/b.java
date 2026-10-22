package com.alibaba.excel.f.l;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.i.e;
import com.alibaba.excel.metadata.data.f;
import com.alibaba.excel.metadata.j;
import java.time.LocalDate;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.alibaba.excel.f.b<LocalDate> {
    public b() {
    }

    @Override // com.alibaba.excel.f.b
    public Class<?> a() {
        return LocalDate.class;
    }

    @Override // com.alibaba.excel.f.b
    public /* synthetic */ LocalDate a(f r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        return b(r1, r2, r3);
    }

    @Override // com.alibaba.excel.f.b
    public CellDataTypeEnum b() {
        return CellDataTypeEnum.NUMBER;
    }

    public LocalDate b(f<?> r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        if (r2 != null) goto L4;
    L9:
        double r0 = r1.d().doubleValue();
        Boolean r4 = r3.b();
    L8:
        return e.c(r0, r4.booleanValue());
    L4:
        if (r2.c() == null) goto L9;
        r0 = r1.d().doubleValue();
        r4 = r2.c().b();
        goto L8
    }
}
