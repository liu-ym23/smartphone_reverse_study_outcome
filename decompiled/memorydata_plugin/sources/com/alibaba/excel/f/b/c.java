package com.alibaba.excel.f.b;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.i.l;
import com.alibaba.excel.metadata.data.f;
import com.alibaba.excel.metadata.j;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.alibaba.excel.f.b<BigInteger> {
    public c() {
    }

    @Override // com.alibaba.excel.f.b
    public Class<BigInteger> a() {
        return BigInteger.class;
    }

    @Override // com.alibaba.excel.f.b
    public /* synthetic */ BigInteger a(f r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        return b(r1, r2, r3);
    }

    @Override // com.alibaba.excel.f.b
    public CellDataTypeEnum b() {
        return CellDataTypeEnum.STRING;
    }

    public BigInteger b(f<?> r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        return l.e(r1.e(), r2).toBigInteger();
    }
}
