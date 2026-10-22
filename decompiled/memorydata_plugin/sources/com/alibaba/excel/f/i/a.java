package com.alibaba.excel.f.i;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.f;
import com.alibaba.excel.metadata.j;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.alibaba.excel.f.b<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Float f163a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Float f164b = null;

    static {
        f163a = Float.valueOf(1.0f);
        f164b = Float.valueOf(0.0f);
    }

    public a() {
    }

    @Override // com.alibaba.excel.f.b
    public Class<?> a() {
        return Float.class;
    }

    @Override // com.alibaba.excel.f.b
    public /* synthetic */ Float a(f r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        return b(r1, r2, r3);
    }

    @Override // com.alibaba.excel.f.b
    public CellDataTypeEnum b() {
        return CellDataTypeEnum.BOOLEAN;
    }

    public Float b(f<?> r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        if (r1.f().booleanValue() == false) goto L7;
        return f163a;
    L7:
        return f164b;
    }
}
