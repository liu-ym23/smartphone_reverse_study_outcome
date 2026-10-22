package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ATN {
    public static final int INVALID_ALT_NUMBER = 0;
    public final List<DecisionState> decisionToState;
    public final ATNType grammarType;
    public LexerAction[] lexerActions;
    public final int maxTokenType;
    public final Map<String, TokensStartState> modeNameToStartState;
    public final List<TokensStartState> modeToStartState;
    public RuleStartState[] ruleToStartState;
    public RuleStopState[] ruleToStopState;
    public int[] ruleToTokenType;
    public final List<ATNState> states;

    public ATN(ATNType r5, int r10) {
        this.states = new ArrayList();
        this.decisionToState = new ArrayList();
        this.modeNameToStartState = new LinkedHashMap();
        this.modeToStartState = new ArrayList();
        this.grammarType = r5;
        this.maxTokenType = r10;
    }

    public void addState(ATNState r5) {
        if (r5 == null) goto L4;
        r5.atn = this;
        r5.stateNumber = this.states.size();
    L4:
        this.states.add(r5);
    }

    public int defineDecisionState(DecisionState r5) {
        this.decisionToState.add(r5);
        int r10 = this.decisionToState.size() - 1;
        r5.decision = r10;
        return r10;
    }

    public DecisionState getDecisionState(int r5) {
        if (this.decisionToState.isEmpty() == false) goto L5;
        return null;
    L5:
        return this.decisionToState.get(r5);
    }

    public IntervalSet getExpectedTokens(int r5, RuleContext r10) {
        if (r5 < 0) goto L20;
        if (r5 >= this.states.size()) goto L20;
        IntervalSet r11 = nextTokens(this.states.get(r5));
        if (r11.contains(-2) == true) goto L8;
        return r11;
    L8:
        IntervalSet r12 = new IntervalSet(new int[0]);
        r12.addAll(r11);
        r12.remove(-2);
    L9:
        if (r10 == null) goto L16;
        if (r10.invokingState < 0) goto L16;
        if (r11.contains(-2) == false) goto L16;
        r11 = nextTokens(((RuleTransition) this.states.get(r10.invokingState).transition(0)).followState);
        r12.addAll(r11);
        r12.remove(-2);
        r10 = r10.parent;
    L16:
        if (r11.contains(-2) == false) goto L18;
        r12.add(-1);
    L18:
        return r12;
    L20:
        throw new IllegalArgumentException("Invalid state number.");
    }

    public int getNumberOfDecisions() {
        return this.decisionToState.size();
    }

    public IntervalSet nextTokens(ATNState r5, RuleContext r10) {
        return new LL1Analyzer(this).LOOK(r5, r10);
    }

    public void removeState(ATNState r5) {
        this.states.set(r5.stateNumber, null);
    }

    public IntervalSet nextTokens(ATNState r5) {
        IntervalSet r10 = r5.nextTokenWithinRule;
        if (r10 == null) goto L5;
        return r10;
    L5:
        IntervalSet r11 = nextTokens(r5, null);
        r5.nextTokenWithinRule = r11;
        r11.setReadonly(true);
        return r5.nextTokenWithinRule;
    }
}
