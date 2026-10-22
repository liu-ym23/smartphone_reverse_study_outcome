package androidx.room.jarjarred.org.antlr.v4.tool;

import androidx.room.jarjarred.org.antlr.v4.runtime.BailErrorStrategy;
import androidx.room.jarjarred.org.antlr.v4.runtime.DefaultErrorStrategy;
import androidx.room.jarjarred.org.antlr.v4.runtime.InputMismatchException;
import androidx.room.jarjarred.org.antlr.v4.runtime.InterpreterRuleContext;
import androidx.room.jarjarred.org.antlr.v4.runtime.Parser;
import androidx.room.jarjarred.org.antlr.v4.runtime.ParserInterpreter;
import androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext;
import androidx.room.jarjarred.org.antlr.v4.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.v4.runtime.Token;
import androidx.room.jarjarred.org.antlr.v4.runtime.TokenStream;
import androidx.room.jarjarred.org.antlr.v4.runtime.Vocabulary;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATN;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNDeserializer;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNSerializer;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.DecisionState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.PredictionMode;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.RuleStartState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.StarLoopEntryState;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.Trees;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GrammarParserInterpreter extends ParserInterpreter {
    protected BitSet decisionStatesThatSetOuterAltNumInContext;
    protected final Grammar g;
    protected int[][] stateToAltsMap;

    public static class BailButConsumeErrorStrategy extends DefaultErrorStrategy {
        public int firstErrorTokenIndex;

        public BailButConsumeErrorStrategy() {
            this.firstErrorTokenIndex = -1;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.DefaultErrorStrategy, androidx.room.jarjarred.org.antlr.v4.runtime.ANTLRErrorStrategy
        public void recover(Parser r5, RecognitionException r10) {
            int r11 = r5.getInputStream().index();
            if (this.firstErrorTokenIndex != (-1)) goto L5;
            this.firstErrorTokenIndex = r11;
        L5:
            TokenStream r12 = r5.getInputStream();
            if (r12.index() >= (r12.size() - 1)) goto L9;
            r5.consume();
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.DefaultErrorStrategy, androidx.room.jarjarred.org.antlr.v4.runtime.ANTLRErrorStrategy
        public Token recoverInline(Parser r5) throws RecognitionException {
            int r10 = r5.getInputStream().index();
            if (this.firstErrorTokenIndex != (-1)) goto L6;
            this.firstErrorTokenIndex = r10;
        L6:
            throw new InputMismatchException(r5);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.DefaultErrorStrategy, androidx.room.jarjarred.org.antlr.v4.runtime.ANTLRErrorStrategy
        public void sync(Parser r5) {
        }
    }

    public GrammarParserInterpreter(Grammar r10, String r11, Vocabulary r12, Collection<String> r13, ATN r14, TokenStream r15) {
        super(r11, r12, r13, r14, r15);
        this.g = r10;
    }

    public static ParserInterpreter deriveTempParserInterpreter(Grammar r10, Parser r11, TokenStream r12) {
        if ((r11 instanceof ParserInterpreter) == true) goto L13;
        char[] r13 = ATNSerializer.getSerializedAsChars(r11.getATN());
        ATN r5 = new ATNDeserializer().deserialize(r13);
        ParserInterpreter r14 = new ParserInterpreter(r11.getGrammarFileName(), r11.getVocabulary(), Arrays.asList(r11.getRuleNames()), r5, r12);
    L11:
        r14.setInputStream(r12);
        r14.setErrorHandler(new BailErrorStrategy());
        r14.removeErrorListeners();
        r14.removeParseListeners();
        r14.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);
        return r14;
    L13:
        r14 = (ParserInterpreter) r11.getClass().asSubclass(ParserInterpreter.class).getConstructor(new Class[]{Grammar.class, ATN.class, TokenStream.class}).newInstance(new Object[]{r10, r11.getATN(), r11.getTokenStream()});     // Catch: Exception -> L7
    L7:
        e = move-exception;
        throw new IllegalArgumentException("can't create parser to match incoming ".concat(r11.getClass().getSimpleName()), e);
    }

    public static List<ParserRuleContext> getAllPossibleParseTrees(Grammar r5, Parser r10, TokenStream r11, int r12, BitSet r13, int r14, int r15, int r16) throws RecognitionException {
        ArrayList r17 = new ArrayList();
        ParserInterpreter r18 = deriveTempParserInterpreter(r5, r10, r11);
        if (r15 < (r11.size() - 1)) goto L5;
        r15 = r11.size() - 2;
    L5:
        int r19 = r13.nextSetBit(0);
    L6:
        if (r19 < 0) goto L11;
        r18.reset();
        r18.addDecisionOverride(r12, r14, r19);
        GrammarInterpreterRuleContext r20 = (GrammarInterpreterRuleContext) Trees.getRootOfSubtreeEnclosingRegion(r18.parse(r16), r14, r15);
        if (Trees.isAncestorOf(r18.getOverrideDecisionRoot(), r20) == false) goto L10;
        r20 = (GrammarInterpreterRuleContext) r18.getOverrideDecisionRoot();
    L10:
        r17.add(r20);
        r19 = r13.nextSetBit(r19 + 1);
        goto L6
    L11:
        return r17;
    }

    public static List<ParserRuleContext> getLookaheadParseTrees(Grammar r5, ParserInterpreter r10, TokenStream r11, int r12, int r13, int r14, int r15) {
        ArrayList r16 = new ArrayList();
        ParserInterpreter r17 = deriveTempParserInterpreter(r5, r10, r11);
        DecisionState r18 = r10.getATN().decisionToState.get(r13);
        int r19 = 1;
    L4:
        if (r19 > r18.getTransitions().length) goto L16;
        BailButConsumeErrorStrategy r20 = new BailButConsumeErrorStrategy();
        r17.setErrorHandler(r20);
        r17.reset();
        r17.addDecisionOverride(r13, r14, r19);
        ParserRuleContext r21 = r17.parse(r12);
        int r22 = r20.firstErrorTokenIndex;
        if (r22 >= 0) goto L9;
        r22 = r15;
    L9:
        int r23 = r21.getSourceInterval().f666b;
        if (r22 <= r23) goto L12;
        r22 = r23;
    L12:
        ParserRuleContext r24 = Trees.getRootOfSubtreeEnclosingRegion(r21, r14, r22);
        if (Trees.isAncestorOf(r17.getOverrideDecisionRoot(), r24) == false) goto L15;
        r24 = r17.getOverrideDecisionRoot();
    L15:
        Trees.stripChildrenOutOfRange(r24, r17.getOverrideDecisionRoot(), r14, r22);
        r16.add(r24);
        r19 = r19 + 1;
        goto L4
    L16:
        return r16;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserInterpreter
    public InterpreterRuleContext createInterpreterRuleContext(ParserRuleContext r5, int r10, int r11) {
        return new GrammarInterpreterRuleContext(r5, r10, r11);
    }

    public BitSet findOuterMostDecisionStates() {
        BitSet r5 = new BitSet(this.atn.states.size());
        int r10 = this.atn.getNumberOfDecisions();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L13;
        DecisionState r12 = this.atn.getDecisionState(r11);
        RuleStartState r13 = this.atn.ruleToStartState[r12.ruleIndex];
        if ((r12 instanceof StarLoopEntryState) == false) goto L10;
        StarLoopEntryState r14 = (StarLoopEntryState) r12;
        if (r14.isPrecedenceDecision == false) goto L12;
        r5.set(r14.transition(0).target.stateNumber);
    L12:
        r11 = r11 + 1;
        goto L3
    L10:
        if (r13.transition(0).target != r12) goto L12;
        r5.set(r12.stateNumber);
        goto L12
    L13:
        return r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserInterpreter, androidx.room.jarjarred.org.antlr.v4.runtime.Parser
    public void reset() {
        super.reset();
        this.overrideDecisionRoot = null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ParserInterpreter
    public int visitDecisionState(DecisionState r10) {
        int r5 = super.visitDecisionState(r10);
        if (r10.getNumberOfTransitions() > 1) goto L5;
    L9:
        GrammarInterpreterRuleContext r11 = (GrammarInterpreterRuleContext) this._ctx;
        if (this.decisionStatesThatSetOuterAltNumInContext.get(r10.stateNumber) == false) goto L22;
        r11.outerAltNum = r5;
        Rule r12 = this.g.getRule(r10.ruleIndex);
        if (this.atn.ruleToStartState[r12.index].isLeftRecursiveRule == false) goto L22;
        int[] r13 = this.stateToAltsMap[r10.stateNumber];
        LeftRecursiveRule r14 = (LeftRecursiveRule) this.g.getRule(r10.ruleIndex);
        if (r10.getStateType() != 3) goto L18;
        if (r13 != null) goto L21;
        r13 = r14.getPrimaryAlts();
        this.stateToAltsMap[r10.stateNumber] = r13;
    L21:
        r11.outerAltNum = r13[r5];
        goto L22
    L18:
        if (r10.getStateType() != 5) goto L21;
        if (r13 != null) goto L21;
        r13 = r14.getRecursiveOpAlts();
        this.stateToAltsMap[r10.stateNumber] = r13;
    L22:
        return r5;
    L5:
        if (r10.decision != this.overrideDecision) goto L9;
        if (this._input.index() != this.overrideDecisionInputIndex) goto L9;
        this.overrideDecisionRoot = (GrammarInterpreterRuleContext) getContext();
        goto L9
    }

    public GrammarParserInterpreter(Grammar r10, ATN r11, TokenStream r12) {
        super(r10.fileName, r10.getVocabulary(), Arrays.asList(r10.getRuleNames()), r11, r12);
        this.g = r10;
        this.decisionStatesThatSetOuterAltNumInContext = findOuterMostDecisionStates();
        this.stateToAltsMap = new int[r10.atn.states.size()][];
    }
}
