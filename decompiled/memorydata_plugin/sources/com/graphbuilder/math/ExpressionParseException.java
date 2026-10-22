package com.graphbuilder.math;

/* JADX INFO: loaded from: classes3.dex */
public class ExpressionParseException extends RuntimeException {
    private String descrip;
    private int index;

    public ExpressionParseException(String r2, int r3) {
        this.descrip = null;
        this.index = 0;
        this.descrip = r2;
        this.index = r3;
    }

    public String getDescription() {
        return this.descrip;
    }

    public int getIndex() {
        return this.index;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "(" + this.index + ") " + this.descrip;
    }
}
