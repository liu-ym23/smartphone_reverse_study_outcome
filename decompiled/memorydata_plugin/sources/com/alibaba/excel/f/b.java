package com.alibaba.excel.f;

import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.j;

/* JADX INFO: loaded from: classes.dex */
public interface b<T> {
    default Class<?> a() {
        throw new UnsupportedOperationException("The current operation is not supported by the current converter.");
    }

    default T a(f<?> r3) {
        return a(r3.a(), r3.b(), r3.c().d().b());
    }

    default T a(com.alibaba.excel.metadata.data.f<?> r1, com.alibaba.excel.metadata.a.c r2, j r3) {
        throw new UnsupportedOperationException("The current operation is not supported by the current converter.");
    }

    default CellDataTypeEnum b() {
        throw new UnsupportedOperationException("The current operation is not supported by the current converter.");
    }
}
