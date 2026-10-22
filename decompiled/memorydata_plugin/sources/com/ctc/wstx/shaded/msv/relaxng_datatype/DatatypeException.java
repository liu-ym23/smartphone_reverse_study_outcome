package com.ctc.wstx.shaded.msv.relaxng_datatype;

/* JADX INFO: loaded from: classes2.dex */
public class DatatypeException extends Exception {
    public static final int UNKNOWN = -1;
    private final int index;

    public DatatypeException() {
        this(-1, null);
    }

    public DatatypeException(int r1, String r2) {
        super(r2);
        this.index = r1;
    }

    public DatatypeException(String r2) {
        this(-1, r2);
    }

    public int getIndex() {
        return this.index;
    }
}
