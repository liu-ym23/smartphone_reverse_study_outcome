package com.graphbuilder.curve;

import com.graphbuilder.math.ExpressionParseException;

/* JADX INFO: loaded from: classes3.dex */
public class ControlStringParseException extends RuntimeException {
    private String descrip;
    private ExpressionParseException epe;
    private int fromIndex;
    private int toIndex;

    public ControlStringParseException(String r3) {
        this.descrip = null;
        this.fromIndex = -1;
        this.toIndex = -1;
        this.epe = null;
        this.descrip = r3;
    }

    public ControlStringParseException(String r3, int r4) {
        this.descrip = null;
        this.fromIndex = -1;
        this.toIndex = -1;
        this.epe = null;
        this.descrip = r3;
        this.fromIndex = r4;
        this.toIndex = r4;
    }

    public ControlStringParseException(String r3, int r4, int r5) {
        this.descrip = null;
        this.fromIndex = -1;
        this.toIndex = -1;
        this.epe = null;
        this.descrip = r3;
        this.fromIndex = r4;
        this.toIndex = r5;
    }

    public ControlStringParseException(String r3, int r4, int r5, ExpressionParseException r6) {
        this.descrip = null;
        this.fromIndex = -1;
        this.toIndex = -1;
        this.epe = null;
        this.descrip = r3;
        this.fromIndex = r4;
        this.toIndex = r5;
        this.epe = r6;
    }

    public String getDescription() {
        return this.descrip;
    }

    public ExpressionParseException getExpressionParseException() {
        return this.epe;
    }

    public int getFromIndex() {
        return this.fromIndex;
    }

    public int getToIndex() {
        return this.toIndex;
    }

    @Override // java.lang.Throwable
    public String toString() {
        if (this.epe == null) goto L5;
        String r0 = "\n" + this.epe.toString();
    L6:
        int r1 = this.fromIndex;
        if (r1 != (-1)) goto L14;
        if (this.toIndex != (-1)) goto L14;
        StringBuilder r5 = new StringBuilder().append(this.descrip);
    L12:
        return r5.append(r0).toString();
    L14:
        if (r1 != this.toIndex) goto L17;
        StringBuilder r2 = new StringBuilder().append(this.descrip).append(" : [");
    L16:
        r5 = r2.append(this.toIndex).append("]");
        goto L12
    L17:
        r2 = new StringBuilder().append(this.descrip).append(" : [").append(this.fromIndex).append(", ");
        goto L16
    L5:
        r0 = "";
        goto L6
    }
}
