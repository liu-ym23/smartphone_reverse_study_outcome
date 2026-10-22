package androidx.room.jarjarred.org.antlr.runtime;

import ai.j0;

/* JADX INFO: loaded from: classes.dex */
public class NoViableAltException extends RecognitionException {
    public int decisionNumber;
    public String grammarDecisionDescription;
    public int stateNumber;

    public NoViableAltException() {
    }

    @Override // java.lang.Throwable
    public String toString() {
        if ((this.input instanceof CharStream) == false) goto L6;
        StringBuilder r5 = new StringBuilder("NoViableAltException('");
        r5.append((char) getUnexpectedType());
        r5.append("'@[");
        return j0.q(r5, this.grammarDecisionDescription, "])");
    L6:
        StringBuilder r10 = new StringBuilder("NoViableAltException(");
        r10.append(getUnexpectedType());
        r10.append("@[");
        return j0.q(r10, this.grammarDecisionDescription, "])");
    }

    public NoViableAltException(String r5, int r10, int r11, IntStream r12) {
        super(r12);
        this.grammarDecisionDescription = r5;
        this.decisionNumber = r10;
        this.stateNumber = r11;
    }
}
