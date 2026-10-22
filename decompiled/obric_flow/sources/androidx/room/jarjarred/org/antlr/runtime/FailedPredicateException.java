package androidx.room.jarjarred.org.antlr.runtime;

import ai.j0;

/* JADX INFO: loaded from: classes.dex */
public class FailedPredicateException extends RecognitionException {
    public String predicateText;
    public String ruleName;

    public FailedPredicateException() {
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder r5 = new StringBuilder("FailedPredicateException(");
        r5.append(this.ruleName);
        r5.append(",{");
        return j0.q(r5, this.predicateText, "}?)");
    }

    public FailedPredicateException(IntStream r5, String r10, String r11) {
        super(r5);
        this.ruleName = r10;
        this.predicateText = r11;
    }
}
