package com.alibaba.excel.support.cglib.core;

/* JADX INFO: loaded from: classes.dex */
public class CodeGenerationException extends RuntimeException {
    private Throwable cause;

    public CodeGenerationException(Throwable r3) {
        super(r3.getClass().getName() + "-->" + r3.getMessage());
        this.cause = r3;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
