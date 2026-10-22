package androidx.room.jarjarred.org.antlr.v4.runtime;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNConfig;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNConfigSet;
import androidx.room.jarjarred.org.antlr.v4.runtime.dfa.DFA;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Interval;
import java.util.BitSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class DiagnosticErrorListener extends BaseErrorListener {
    protected final boolean exactOnly;

    public DiagnosticErrorListener() {
        this(true);
    }

    public BitSet getConflictingAlts(BitSet r5, ATNConfigSet r10) {
        if (r5 == null) goto L4;
        return r5;
    L4:
        BitSet r11 = new BitSet();
        Iterator<ATNConfig> r12 = r10.iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        r11.set(r12.next().alt);
        goto L6
    L8:
        return r11;
    }

    public String getDecisionDescription(Parser r5, DFA r10) {
        int r11 = r10.decision;
        int r12 = r10.atnStartState.ruleIndex;
        String[] r13 = r5.getRuleNames();
        if (r12 < 0) goto L17;
        if (r12 >= r13.length) goto L17;
        String r14 = r13[r12];
        if (r14 == null) goto L15;
        if (r14.isEmpty() == true) goto L15;
        return String.format("%d (%s)", new Object[]{Integer.valueOf(r11), r14});
    L15:
        return String.valueOf(r11);
    L17:
        return String.valueOf(r11);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.BaseErrorListener, androidx.room.jarjarred.org.antlr.v4.runtime.ANTLRErrorListener
    public void reportAmbiguity(Parser r5, DFA r10, int r11, int r12, boolean r13, BitSet r14, ATNConfigSet r15) {
        if (this.exactOnly == false) goto L6;
        if (r13 == true) goto L6;
        return;
    L6:
        r5.notifyErrorListeners(String.format("reportAmbiguity d=%s: ambigAlts=%s, input='%s'", new Object[]{getDecisionDescription(r5, r10), getConflictingAlts(r14, r15), r5.getTokenStream().getText(Interval.of(r11, r12))}));
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.BaseErrorListener, androidx.room.jarjarred.org.antlr.v4.runtime.ANTLRErrorListener
    public void reportAttemptingFullContext(Parser r5, DFA r10, int r11, int r12, BitSet r13, ATNConfigSet r14) {
        r5.notifyErrorListeners(j0.l("reportAttemptingFullContext d=", getDecisionDescription(r5, r10), ", input='", r5.getTokenStream().getText(Interval.of(r11, r12)), "'"));
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.BaseErrorListener, androidx.room.jarjarred.org.antlr.v4.runtime.ANTLRErrorListener
    public void reportContextSensitivity(Parser r5, DFA r10, int r11, int r12, int r13, ATNConfigSet r14) {
        r5.notifyErrorListeners(j0.l("reportContextSensitivity d=", getDecisionDescription(r5, r10), ", input='", r5.getTokenStream().getText(Interval.of(r11, r12)), "'"));
    }

    public DiagnosticErrorListener(boolean r5) {
        this.exactOnly = r5;
    }
}
