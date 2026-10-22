package com.alibaba.excel.f.p;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.i.e;
import com.alibaba.excel.i.k;
import com.alibaba.excel.i.l;
import com.alibaba.excel.i.o;
import com.alibaba.excel.metadata.data.f;
import com.alibaba.excel.metadata.j;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.alibaba.excel.f.b<String> {
    public c() {
    }

    @Override // com.alibaba.excel.f.b
    public Class<?> a() {
        return String.class;
    }

    @Override // com.alibaba.excel.f.b
    public /* synthetic */ String a(f r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        return b(r1, r2, r3);
    }

    @Override // com.alibaba.excel.f.b
    public CellDataTypeEnum b() {
        return CellDataTypeEnum.NUMBER;
    }

    public String b(f<?> r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        if (r2 != null) goto L4;
    L7:
        if (r2 == null) goto L13;
        if (r2.d() == null) goto L13;
        return l.a(r1.d(), r2);
    L13:
        if (r1.k() != null) goto L15;
    L19:
        boolean r0 = false;
    L20:
        if (r0 == false) goto L24;
        return k.a(r1.d(), r1.k().b(), r1.k().c(), r3);
    L24:
        return l.a(r1.d(), r2);
    L15:
        if (r1.k().b() == null) goto L19;
        if (o.a(r1.k().c()) == true) goto L19;
        r0 = true;
        goto L20
    L4:
        if (r2.c() == null) goto L7;
        return e.a(r1.d(), r2.c().b(), r2.c().a());
    }
}
