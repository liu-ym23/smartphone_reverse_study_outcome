package com.alibaba.excel.support.cglib.proxy;

import com.alibaba.excel.support.cglib.core.CodeGenerationException;

/* JADX INFO: loaded from: classes.dex */
public class UndeclaredThrowableException extends CodeGenerationException {
    public UndeclaredThrowableException(Throwable r1) {
        super(r1);
    }

    public Throwable getUndeclaredThrowable() {
        return getCause();
    }
}
