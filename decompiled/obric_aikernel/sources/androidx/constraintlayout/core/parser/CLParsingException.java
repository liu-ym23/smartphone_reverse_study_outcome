package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes.dex */
public class CLParsingException extends Exception {
    private final String mElementClass;
    private final int mLineNumber;
    private final String mReason;

    public CLParsingException(String r10, CLElement r11) {
        this.mReason = r10;
        if (r11 == null) goto L5;
        this.mElementClass = r11.getStrClass();
        int r12 = r11.getLine();
    L6:
        this.mLineNumber = r12;
        return;
    L5:
        this.mElementClass = "unknown";
        r12 = 0;
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
