package com.alibaba.excel.f.o;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.f;
import com.alibaba.excel.metadata.j;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.alibaba.excel.f.b<Short> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Short f169a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Short f170b = null;

    static {
        f169a = 1;
        f170b = 0;
    }

    public a() {
    }

    @Override // com.alibaba.excel.f.b
    public Class<Short> a() {
        return Short.class;
    }

    @Override // com.alibaba.excel.f.b
    public /* synthetic */ Short a(f r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        return b(r1, r2, r3);
    }

    @Override // com.alibaba.excel.f.b
    public CellDataTypeEnum b() {
        return CellDataTypeEnum.BOOLEAN;
    }

    public Short b(f<?> r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        if (r1.f().booleanValue() == false) goto L7;
        return f169a;
    L7:
        return f170b;
    }
}
