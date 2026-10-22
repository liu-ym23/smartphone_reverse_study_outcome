package com.alibaba.excel.f.n;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.f;
import com.alibaba.excel.metadata.j;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.alibaba.excel.f.b<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Long f167a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Long f168b = null;

    static {
        f167a = 1L;
        f168b = 0L;
    }

    public a() {
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
        return CellDataTypeEnum.BOOLEAN;
    }

    public Long b(f<?> r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        if (r1.f().booleanValue() == false) goto L7;
        return f167a;
    L7:
        return f168b;
    }
}
