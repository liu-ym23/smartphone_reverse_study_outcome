package com.alibaba.excel.f.k;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.f;
import com.alibaba.excel.metadata.j;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.alibaba.excel.f.b<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Integer f165a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Integer f166b = null;

    static {
        f165a = 1;
        f166b = 0;
    }

    public a() {
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
        return CellDataTypeEnum.BOOLEAN;
    }

    public Integer b(f<?> r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        if (r1.f().booleanValue() == false) goto L7;
        return f165a;
    L7:
        return f166b;
    }
}
