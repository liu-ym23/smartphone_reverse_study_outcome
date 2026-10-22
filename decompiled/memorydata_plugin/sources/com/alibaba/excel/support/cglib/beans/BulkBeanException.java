package com.alibaba.excel.support.cglib.beans;

/* JADX INFO: loaded from: classes.dex */
public class BulkBeanException extends RuntimeException {
    private Throwable cause;
    private int index;

    public BulkBeanException(String r1, int r2) {
        super(r1);
        this.index = r2;
    }

    public BulkBeanException(Throwable r2, int r3) {
        super(r2.getMessage());
        this.index = r3;
        this.cause = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    public int getIndex() {
        return this.index;
    }
}
