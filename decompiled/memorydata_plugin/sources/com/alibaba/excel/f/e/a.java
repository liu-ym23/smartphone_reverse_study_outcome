package com.alibaba.excel.f.e;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.f;
import com.alibaba.excel.metadata.j;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.alibaba.excel.f.b<Byte> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Byte f157a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Byte f158b = null;

    static {
        f157a = (byte) 1;
        f158b = (byte) 0;
    }

    public a() {
    }

    @Override // com.alibaba.excel.f.b
    public Class<?> a() {
        return Byte.class;
    }

    @Override // com.alibaba.excel.f.b
    public /* synthetic */ Byte a(f r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        return b(r1, r2, r3);
    }

    @Override // com.alibaba.excel.f.b
    public CellDataTypeEnum b() {
        return CellDataTypeEnum.BOOLEAN;
    }

    public Byte b(f<?> r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        if (r1.f().booleanValue() == false) goto L7;
        return f157a;
    L7:
        return f158b;
    }
}
