package com.obric.oui.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes5.dex */
public class CLParsingException extends Exception {
    private final String mElementClass;
    private final int mLineNumber;
    private final String mReason;

    public CLParsingException(String r1, b r2) {
        super(r1);
        this.mReason = r1;
        if (r2 == null) goto L5;
        this.mElementClass = r2.d();
        int r3 = r2.c();
    L6:
        this.mLineNumber = r3;
        return;
    L5:
        this.mElementClass = "unknown";
        r3 = 0;
        goto L6
    }

    public String reason() {
        return this.mReason + " (" + this.mElementClass + " at line " + this.mLineNumber + ")";
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "CLParsingException (" + hashCode() + ") : " + reason();
    }
}
