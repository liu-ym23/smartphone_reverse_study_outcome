package androidx.room.jarjarred.org.antlr.v4.runtime;

import ai.j0;
import androidx.room.jarjarred.org.antlr.runtime.debug.Profiler;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATN;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.RuleTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Pair;

/* JADX INFO: loaded from: classes.dex */
public class DefaultErrorStrategy implements ANTLRErrorStrategy {
    protected boolean errorRecoveryMode;
    protected int lastErrorIndex;
    protected IntervalSet lastErrorStates;
    protected ParserRuleContext nextTokensContext;
    protected int nextTokensState;

    public DefaultErrorStrategy() {
        this.errorRecoveryMode = false;
        this.lastErrorIndex = -1;
    }

    public void beginErrorCondition(Parser r5) {
        this.errorRecoveryMode = true;
    }

    public void consumeUntil(Parser r5, IntervalSet r10) {
        int r11 = r5.getInputStream().LA(1);
    L4:
        if (r11 == (-1)) goto L8;
        if (r10.contains(r11) == true) goto L11;
        r5.consume();
        r11 = r5.getInputStream().LA(1);
        goto L4
    L11:
        return;
    }

    public void endErrorCondition(Parser r5) {
        this.errorRecoveryMode = false;
        this.lastErrorStates = null;
        this.lastErrorIndex = -1;
    }

    public String escapeWSAndQuote(String r5) {
        return j0.k("'", r5.replace("\n", "\\n").replace("\r", "\\r").replace(Profiler.DATA_SEP, "\\t"), "'");
    }

    public IntervalSet getErrorRecoverySet(Parser r5) {
        ATN r10 = r5.getInterpreter().atn;
        RuleContext r11 = r5._ctx;
        IntervalSet r12 = new IntervalSet(new int[0]);
    L3:
        if (r11 == null) goto L7;
        int r13 = r11.invokingState;
        if (r13 < 0) goto L7;
        r12.addAll(r10.nextTokens(((RuleTransition) r10.states.get(r13).transition(0)).followState));
        r11 = r11.parent;
    L7:
        r12.remove(-2);
        return r12;
    }

    public IntervalSet getExpectedTokens(Parser r5) {
        return r5.getExpectedTokens();
    }

    public Token getMissingSymbol(Parser r11) {
        Token r5 = r11.getCurrentToken();
        IntervalSet r10 = getExpectedTokens(r11);
        if (r10.isNil() == true) goto L6;
        int r12 = r10.getMinElement();
    L5:
        int r13 = r12;
        if (r13 != (-1)) goto L11;
        String r14 = "<missing EOF>";
    L10:
        String r15 = r14;
        Token r16 = r11.getInputStream().LT(-1);
        if (r5.getType() != (-1)) goto L17;
        if (r16 == null) goto L17;
        r5 = r16;
    L17:
        return r11.getTokenFactory().create(new Pair(r5.getTokenSource(), r5.getTokenSource().getInputStream()), r13, r15, 0, -1, -1, r5.getLine(), r5.getCharPositionInLine());
    L11:
        r14 = "<missing " + r11.getVocabulary().getDisplayName(r13) + ">";
        goto L10
    L6:
        r12 = 0;
        goto L5
    }

    public String getSymbolText(Token r5) {
        return r5.getText();
    }

    public int getSymbolType(Token r5) {
        return r5.getType();
    }

    public String getTokenErrorDisplay(Token r5) {
        if (r5 != null) goto L5;
        return "<no token>";
    L5:
        String r10 = getSymbolText(r5);
        if (r10 != null) goto L12;
        if (getSymbolType(r5) != (-1)) goto L10;
        r10 = "<EOF>";
        goto L12
    L10:
        r10 = "<" + getSymbolType(r5) + ">";
    L12:
        return escapeWSAndQuote(r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ANTLRErrorStrategy
    public boolean inErrorRecoveryMode(Parser r5) {
        return this.errorRecoveryMode;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ANTLRErrorStrategy
    public void recover(Parser r5, RecognitionException r10) {
        if (this.lastErrorIndex != r5.getInputStream().index()) goto L9;
        IntervalSet r11 = this.lastErrorStates;
        if (r11 == null) goto L9;
        if (r11.contains(r5.getState()) == false) goto L9;
        r5.consume();
    L9:
        this.lastErrorIndex = r5.getInputStream().index();
        if (this.lastErrorStates != null) goto L12;
        this.lastErrorStates = new IntervalSet(new int[0]);
    L12:
        this.lastErrorStates.add(r5.getState());
        consumeUntil(r5, getErrorRecoverySet(r5));
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ANTLRErrorStrategy
    public Token recoverInline(Parser r5) throws RecognitionException {
        Token r10 = singleTokenDeletion(r5);
        if (r10 == null) goto L7;
        r5.consume();
        return r10;
    L7:
        if (singleTokenInsertion(r5) == false) goto L11;
        return getMissingSymbol(r5);
    L11:
        if (this.nextTokensContext != null) goto L14;
        throw new InputMismatchException(r5);
    L14:
        throw new InputMismatchException(r5, this.nextTokensState, this.nextTokensContext);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ANTLRErrorStrategy
    public void reportError(Parser r5, RecognitionException r10) {
        if (inErrorRecoveryMode(r5) == false) goto L5;
        return;
    L5:
        beginErrorCondition(r5);
        if ((r10 instanceof NoViableAltException) == false) goto L9;
        reportNoViableAlternative(r5, (NoViableAltException) r10);
        return;
    L9:
        if ((r10 instanceof InputMismatchException) == false) goto L12;
        reportInputMismatch(r5, (InputMismatchException) r10);
        return;
    L12:
        if ((r10 instanceof FailedPredicateException) == false) goto L14;
        reportFailedPredicate(r5, (FailedPredicateException) r10);
        return;
    L14:
        System.err.println("unknown recognition error type: ".concat(r10.getClass().getName()));
        r5.notifyErrorListeners(r10.getOffendingToken(), r10.getMessage(), r10);
    }

    public void reportFailedPredicate(Parser r5, FailedPredicateException r10) {
        StringBuilder r11 = j0.x("rule ", r5.getRuleNames()[r5._ctx.getRuleIndex()], " ");
        r11.append(r10.getMessage());
        String r12 = r11.toString();
        r5.notifyErrorListeners(r10.getOffendingToken(), r12, r10);
    }

    public void reportInputMismatch(Parser r5, InputMismatchException r10) {
        r5.notifyErrorListeners(r10.getOffendingToken(), "mismatched input " + getTokenErrorDisplay(r10.getOffendingToken()) + " expecting " + r10.getExpectedTokens().toString(r5.getVocabulary()), r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ANTLRErrorStrategy
    public void reportMatch(Parser r5) {
        endErrorCondition(r5);
    }

    public void reportMissingToken(Parser r5) {
        if (inErrorRecoveryMode(r5) == false) goto L5;
        return;
    L5:
        beginErrorCondition(r5);
        Token r10 = r5.getCurrentToken();
        r5.notifyErrorListeners(r10, "missing " + getExpectedTokens(r5).toString(r5.getVocabulary()) + " at " + getTokenErrorDisplay(r10), null);
    }

    public void reportNoViableAlternative(Parser r5, NoViableAltException r10) {
        TokenStream r11 = r5.getInputStream();
        if (r11 != null) goto L5;
        String r12 = "<unknown input>";
    L9:
        r5.notifyErrorListeners(r10.getOffendingToken(), "no viable alternative at input " + escapeWSAndQuote(r12), r10);
        return;
    L5:
        if (r10.getStartToken().getType() != (-1)) goto L7;
        r12 = "<EOF>";
        goto L9
    L7:
        r12 = r11.getText(r10.getStartToken(), r10.getOffendingToken());
        goto L9
    }

    public void reportUnwantedToken(Parser r5) {
        if (inErrorRecoveryMode(r5) == false) goto L5;
        return;
    L5:
        beginErrorCondition(r5);
        Token r10 = r5.getCurrentToken();
        String r11 = getTokenErrorDisplay(r10);
        IntervalSet r12 = getExpectedTokens(r5);
        StringBuilder r13 = j0.x("extraneous input ", r11, " expecting ");
        r13.append(r12.toString(r5.getVocabulary()));
        r5.notifyErrorListeners(r10, r13.toString(), null);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ANTLRErrorStrategy
    public void reset(Parser r5) {
        endErrorCondition(r5);
    }

    public Token singleTokenDeletion(Parser r5) {
        int r10 = r5.getInputStream().LA(2);
        if (getExpectedTokens(r5).contains(r10) == false) goto L6;
        reportUnwantedToken(r5);
        r5.consume();
        Token r11 = r5.getCurrentToken();
        reportMatch(r5);
        return r11;
    L6:
        return null;
    }

    public boolean singleTokenInsertion(Parser r10) {
        int r5 = r10.getInputStream().LA(1);
        ATNState r11 = r10.getInterpreter().atn.states.get(r10.getState()).transition(0).target;
        if (r10.getInterpreter().atn.nextTokens(r11, r10._ctx).contains(r5) == false) goto L6;
        reportMissingToken(r10);
        return true;
    L6:
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ANTLRErrorStrategy
    public void sync(Parser r5) throws RecognitionException {
        ATNState r10 = r5.getInterpreter().atn.states.get(r5.getState());
        if (inErrorRecoveryMode(r5) == false) goto L5;
        return;
    L5:
        int r11 = r5.getInputStream().LA(1);
        IntervalSet r12 = r5.getATN().nextTokens(r10);
        if (r12.contains(r11) == false) goto L10;
        this.nextTokensContext = null;
        this.nextTokensState = -1;
        return;
    L10:
        if (r12.contains(-2) == true) goto L12;
        int r13 = r10.getStateType();
        if (r13 == 3) goto L26;
        if (r13 == 4) goto L26;
        if (r13 == 5) goto L26;
        switch(r13) {
            case 9: goto L23;
            case 10: goto L26;
            case 11: goto L23;
            default: goto L31;
        };
    L23:
        reportUnwantedToken(r5);
        consumeUntil(r5, r5.getExpectedTokens().or(getErrorRecoverySet(r5)));
        return;
    L31:
        return;
    L26:
        if (singleTokenDeletion(r5) == null) goto L29;
        return;
    L29:
        throw new InputMismatchException(r5);
    L12:
        if (this.nextTokensContext != null) goto L30;
        this.nextTokensContext = r5.getContext();
        this.nextTokensState = r5.getState();
        return;
    }
}
