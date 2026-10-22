package com.obric.oui.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes3.dex */
public class CLParsingException extends Exception {
    private final String mElementClass;
    private final int mLineNumber;
    private final String mReason;

    public CLParsingException(String r5, a r10) {
        super(r5);
        this.mReason = r5;
        this.mElementClass = "unknown";
        this.mLineNumber = 0;
    }

    public String reason() {
        StringBuilder r5 = new StringBuilder();
        r5.append(this.mReason);
        r5.append(" (");
        r5.append(this.mElementClass);
        r5.append(" at line ");
        return androidx.constraintlayout.motion.widget.a.s(r5, this.mLineNumber, ")");
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "CLParsingException (" + hashCode() + ") : " + reason();
    }
}
