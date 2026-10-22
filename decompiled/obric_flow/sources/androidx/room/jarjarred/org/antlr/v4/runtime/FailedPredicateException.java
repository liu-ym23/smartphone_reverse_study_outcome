package androidx.room.jarjarred.org.antlr.v4.runtime;

import androidx.room.jarjarred.org.antlr.v4.runtime.atn.AbstractPredicateTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.PredicateTransition;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class FailedPredicateException extends RecognitionException {
    private final String predicate;
    private final int predicateIndex;
    private final int ruleIndex;

    public FailedPredicateException(Parser r5) {
        this(r5, null);
    }

    private static String formatMessage(String r5, String r10) {
        if (r10 == null) goto L4;
        return r10;
    L4:
        Locale.getDefault();
        return "failed predicate: {" + r5 + "}?";
    }

    public int getPredIndex() {
        return this.predicateIndex;
    }

    public String getPredicate() {
        return this.predicate;
    }

    public int getRuleIndex() {
        return this.ruleIndex;
    }

    public FailedPredicateException(Parser r5, String r10) {
        this(r5, r10, null);
    }

    public FailedPredicateException(Parser r5, String r10, String r11) {
        super(formatMessage(r10, r11), r5, r5.getInputStream(), r5._ctx);
        AbstractPredicateTransition r12 = (AbstractPredicateTransition) r5.getInterpreter().atn.states.get(r5.getState()).transition(0);
        if ((r12 instanceof PredicateTransition) == false) goto L5;
        PredicateTransition r13 = (PredicateTransition) r12;
        this.ruleIndex = r13.ruleIndex;
        this.predicateIndex = r13.predIndex;
    L6:
        this.predicate = r10;
        setOffendingToken(r5.getCurrentToken());
        return;
    L5:
        this.ruleIndex = 0;
        this.predicateIndex = 0;
        goto L6
    }
}
