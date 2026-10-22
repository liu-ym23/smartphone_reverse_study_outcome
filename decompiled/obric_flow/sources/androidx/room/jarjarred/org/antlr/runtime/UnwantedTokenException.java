package androidx.room.jarjarred.org.antlr.runtime;

import ai.j0;

/* JADX INFO: loaded from: classes.dex */
public class UnwantedTokenException extends MismatchedTokenException {
    public UnwantedTokenException() {
    }

    public Token getUnexpectedToken() {
        return this.token;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.MismatchedTokenException, java.lang.Throwable
    public String toString() {
        String r5 = ", expected " + this.expecting;
        if (this.expecting != 0) goto L6;
        r5 = "";
    L6:
        if (this.token != null) goto L10;
        return j0.k("UnwantedTokenException(found=null", r5, ")");
    L10:
        return "UnwantedTokenException(found=" + this.token.getText() + r5 + ")";
    }

    public UnwantedTokenException(int r5, IntStream r10) {
        super(r5, r10);
    }
}
