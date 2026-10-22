package com.ctc.wstx.shaded.msv_core.datatype.regexp;

/* JADX INFO: loaded from: classes2.dex */
class ParseException extends RuntimeException {
    int location;

    public ParseException(String r1, int r2) {
        super(r1);
        this.location = r2;
    }

    public int getLocation() {
        return this.location;
    }
}
