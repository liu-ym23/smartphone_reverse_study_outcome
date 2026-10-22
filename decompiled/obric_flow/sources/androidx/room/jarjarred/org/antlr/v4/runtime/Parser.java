package androidx.room.jarjarred.org.antlr.v4.runtime;

import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATN;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNDeserializationOptions;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNDeserializer;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ParseInfo;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ParserATNSimulator;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.PredictionMode;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ProfilingATNSimulator;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.RuleTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.dfa.DFA;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntegerStack;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ErrorNode;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ErrorNodeImpl;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTreeListener;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.TerminalNode;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.TerminalNodeImpl;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.pattern.ParseTreePatternMatcher;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class Parser extends Recognizer<Token, ParserATNSimulator> {
    private static final Map<String, ATN> bypassAltsAtnCache = null;
    protected boolean _buildParseTrees;
    protected ParserRuleContext _ctx;
    protected ANTLRErrorStrategy _errHandler;
    protected TokenStream _input;
    protected List<ParseTreeListener> _parseListeners;
    protected final IntegerStack _precedenceStack;
    protected int _syntaxErrors;
    private TraceListener _tracer;
    protected boolean matchedEOF;

    public class TraceListener implements ParseTreeListener {
        final /* synthetic */ Parser this$0;

        public TraceListener(Parser r5) {
            this.this$0 = r5;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTreeListener
        public void enterEveryRule(ParserRuleContext r5) {
            System.out.println("enter   " + this.this$0.getRuleNames()[r5.getRuleIndex()] + ", LT(1)=" + this.this$0._input.LT(1).getText());
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTreeListener
        public void exitEveryRule(ParserRuleContext r5) {
            System.out.println("exit    " + this.this$0.getRuleNames()[r5.getRuleIndex()] + ", LT(1)=" + this.this$0._input.LT(1).getText());
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTreeListener
        public void visitErrorNode(ErrorNode r5) {
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTreeListener
        public void visitTerminal(TerminalNode r5) {
            System.out.println("consume " + r5.getSymbol() + " rule " + this.this$0.getRuleNames()[this.this$0._ctx.getRuleIndex()]);
        }
    }

    public static class TrimToSizeListener implements ParseTreeListener {
        public static final TrimToSizeListener INSTANCE = null;

        static {
            INSTANCE = new TrimToSizeListener();
        }

        public TrimToSizeListener() {
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTreeListener
        public void enterEveryRule(ParserRuleContext r5) {
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTreeListener
        public void exitEveryRule(ParserRuleContext r5) {
            List<ParseTree> r10 = r5.children;
            if ((r10 instanceof ArrayList) == false) goto L6;
            ((ArrayList) r10).trimToSize();
            return;
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTreeListener
        public void visitErrorNode(ErrorNode r5) {
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTreeListener
        public void visitTerminal(TerminalNode r5) {
        }
    }

    static {
        bypassAltsAtnCache = new WeakHashMap();
    }

    public Parser(TokenStream r5) {
        this._errHandler = new DefaultErrorStrategy();
        IntegerStack r10 = new IntegerStack();
        this._precedenceStack = r10;
        r10.push(0);
        this._buildParseTrees = true;
        setInputStream(r5);
    }

    public void addContextToParseTree() {
        ParserRuleContext r5 = this._ctx;
        ParserRuleContext r10 = (ParserRuleContext) r5.parent;
        if (r10 == null) goto L6;
        r10.addChild(r5);
        return;
    }

    public void addParseListener(ParseTreeListener r5) {
        if (r5 == null) goto L9;
        if (this._parseListeners != null) goto L6;
        this._parseListeners = new ArrayList();
    L6:
        this._parseListeners.add(r5);
        return;
    L9:
        throw new NullPointerException("listener");
    }

    public ParseTreePattern compileParseTreePattern(String r5, int r10) {
        if (getTokenStream() == null) goto L9;
        TokenSource r11 = getTokenStream().getTokenSource();
        if ((r11 instanceof Lexer) == false) goto L9;
        return compileParseTreePattern(r5, r10, (Lexer) r11);
    L9:
        throw new UnsupportedOperationException("Parser can't discover a lexer to use");
    }

    public Token consume() {
        Token r5 = getCurrentToken();
        if (r5.getType() == (-1)) goto L5;
        getInputStream().consume();
    L5:
        List<ParseTreeListener> r10 = this._parseListeners;
        if (r10 != null) goto L8;
    L10:
        boolean r11 = false;
    L12:
        if (this._buildParseTrees == true) goto L15;
        if (r11 == true) goto L15;
    L28:
        return r5;
    L15:
        if (this._errHandler.inErrorRecoveryMode(this) == false) goto L22;
        ParserRuleContext r12 = this._ctx;
        ErrorNode r13 = r12.addErrorNode(createErrorNode(r12, r5));
        List<ParseTreeListener> r14 = this._parseListeners;
        if (r14 == null) goto L28;
        Iterator<ParseTreeListener> r15 = r14.iterator();
    L20:
        if (r15.hasNext() == false) goto L28;
        r15.next().visitErrorNode(r13);
        goto L20
    L22:
        ParserRuleContext r16 = this._ctx;
        TerminalNode r17 = r16.addChild(createTerminalNode(r16, r5));
        List<ParseTreeListener> r18 = this._parseListeners;
        if (r18 == null) goto L28;
        Iterator<ParseTreeListener> r19 = r18.iterator();
    L26:
        if (r19.hasNext() == false) goto L28;
        r19.next().visitTerminal(r17);
        goto L26
    L8:
        if (r10.isEmpty() == true) goto L10;
        r11 = true;
        goto L12
    }

    public ErrorNode createErrorNode(ParserRuleContext r5, Token r10) {
        return new ErrorNodeImpl(r10);
    }

    public TerminalNode createTerminalNode(ParserRuleContext r5, Token r10) {
        return new TerminalNodeImpl(r10);
    }

    public void dumpDFA() {
        DFA[] r5 = ((ParserATNSimulator) this._interp).decisionToDFA;
        monitor-enter(r5);
        int r10 = 0;
        boolean r11 = false;
    L19:
        ATNInterpreter r12 = this._interp;     // Catch: Throwable -> L11
        if (r10 >= ((ParserATNSimulator) r12).decisionToDFA.length) goto L15;
        DFA r13 = ((ParserATNSimulator) r12).decisionToDFA[r10];     // Catch: Throwable -> L11
        if (r13.states.isEmpty() == true) goto L14;
        if (r11 == false) goto L13;
        System.out.println();     // Catch: Throwable -> L11
    L13:
        PrintStream r14 = System.out;     // Catch: Throwable -> L11
        r14.println("Decision " + r13.decision + ":");     // Catch: Throwable -> L11
        r14.print(r13.toString(getVocabulary()));     // Catch: Throwable -> L11
        r11 = true;
    L14:
        r10 = r10 + 1;     // Catch: Throwable -> L11
        goto L19
    L15:
        monitor-exit(r5);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void enterOuterAlt(ParserRuleContext r5, int r10) {
        r5.setAltNumber(r10);
        if (this._buildParseTrees == false) goto L9;
        ParserRuleContext r11 = this._ctx;
        if (r11 == r5) goto L9;
        ParserRuleContext r12 = (ParserRuleContext) r11.parent;
        if (r12 == null) goto L9;
        r12.removeLastChild();
        r12.addChild(r5);
    L9:
        this._ctx = r5;
    }

    @Deprecated
    public void enterRecursionRule(ParserRuleContext r5, int r10) {
        enterRecursionRule(r5, getATN().ruleToStartState[r10].stateNumber, r10, 0);
    }

    public void enterRule(ParserRuleContext r5, int r10, int r11) {
        setState(r10);
        this._ctx = r5;
        r5.start = this._input.LT(1);
        if (this._buildParseTrees == false) goto L6;
        addContextToParseTree();
    L6:
        if (this._parseListeners == null) goto L9;
        triggerEnterRuleEvent();
        return;
    }

    public void exitRule() {
        if (this.matchedEOF == false) goto L5;
        ParserRuleContext r5 = this._ctx;
        r5.stop = this._input.LT(1);
    L7:
        if (this._parseListeners == null) goto L9;
        triggerExitRuleEvent();
    L9:
        setState(this._ctx.invokingState);
        this._ctx = (ParserRuleContext) this._ctx.parent;
        return;
    L5:
        ParserRuleContext r10 = this._ctx;
        r10.stop = this._input.LT(-1);
        goto L7
    }

    public ATN getATNWithBypassAlts() {
        String r5 = getSerializedATN();
        if (r5 == null) goto L16;
        Map<String, ATN> r10 = bypassAltsAtnCache;
        monitor-enter(r10);
        ATN r11 = r10.get(r5);     // Catch: Throwable -> L9
        if (r11 != null) goto L11;
        ATNDeserializationOptions r12 = new ATNDeserializationOptions();     // Catch: Throwable -> L9
        r12.setGenerateRuleBypassTransitions(true);     // Catch: Throwable -> L9
        r11 = new ATNDeserializer(r12).deserialize(r5.toCharArray());     // Catch: Throwable -> L9
        r10.put(r5, r11);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L9
        return r11;
    L9:
        th = move-exception;
        throw th;
    L16:
        throw new UnsupportedOperationException("The current parser does not support an ATN with bypass alternatives.");
    }

    public boolean getBuildParseTree() {
        return this._buildParseTrees;
    }

    public ParserRuleContext getContext() {
        return this._ctx;
    }

    public Token getCurrentToken() {
        return this._input.LT(1);
    }

    public List<String> getDFAStrings() {
        DFA[] r5 = ((ParserATNSimulator) this._interp).decisionToDFA;
        monitor-enter(r5);
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L8
        int r11 = 0;
    L5:
        ATNInterpreter r12 = this._interp;     // Catch: Throwable -> L8
        if (r11 >= ((ParserATNSimulator) r12).decisionToDFA.length) goto L10;
        r10.add(((ParserATNSimulator) r12).decisionToDFA[r11].toString(getVocabulary()));     // Catch: Throwable -> L8
        r11 = r11 + 1;     // Catch: Throwable -> L8
        goto L5
    L10:
        monitor-exit(r5);     // Catch: Throwable -> L8
        return r10;
    L8:
        th = move-exception;
        throw th;
    }

    public ANTLRErrorStrategy getErrorHandler() {
        return this._errHandler;
    }

    public IntervalSet getExpectedTokens() {
        return getATN().getExpectedTokens(getState(), getContext());
    }

    public IntervalSet getExpectedTokensWithinCurrentRule() {
        ATN r5 = getInterpreter().atn;
        return r5.nextTokens(r5.states.get(getState()));
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer, androidx.room.jarjarred.org.antlr.v4.runtime.TokenSource
    public /* bridge */ /* synthetic */ IntStream getInputStream() {
        return getInputStream();
    }

    public ParserRuleContext getInvokingContext(int r5) {
        ParserRuleContext r10 = this._ctx;
    L3:
        if (r10 == null) goto L8;
        if (r10.getRuleIndex() == r5) goto L6;
        r10 = (ParserRuleContext) r10.parent;
        goto L3
    L6:
        return r10;
    L8:
        return null;
    }

    public int getNumberOfSyntaxErrors() {
        return this._syntaxErrors;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer
    public ParseInfo getParseInfo() {
        ParserATNSimulator r5 = getInterpreter();
        if ((r5 instanceof ProfilingATNSimulator) == true) goto L5;
        return null;
    L5:
        return new ParseInfo((ProfilingATNSimulator) r5);
    }

    public List<ParseTreeListener> getParseListeners() {
        List<ParseTreeListener> r5 = this._parseListeners;
        if (r5 == null) goto L5;
        return r5;
    L5:
        return Collections.emptyList();
    }

    public final int getPrecedence() {
        if (this._precedenceStack.isEmpty() == false) goto L7;
        return -1;
    L7:
        return this._precedenceStack.peek();
    }

    public ParserRuleContext getRuleContext() {
        return this._ctx;
    }

    public int getRuleIndex(String r5) {
        Integer r10 = getRuleIndexMap().get(r5);
        if (r10 != null) goto L5;
        return -1;
    L5:
        return r10.intValue();
    }

    public List<String> getRuleInvocationStack() {
        return getRuleInvocationStack(this._ctx);
    }

    public String getSourceName() {
        return this._input.getSourceName();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer, androidx.room.jarjarred.org.antlr.v4.runtime.TokenSource
    public TokenFactory<?> getTokenFactory() {
        return this._input.getTokenSource().getTokenFactory();
    }

    public TokenStream getTokenStream() {
        return this._input;
    }

    public boolean getTrimParseTree() {
        return getParseListeners().contains(TrimToSizeListener.INSTANCE);
    }

    public boolean inContext(String r5) {
        return false;
    }

    public boolean isExpectedToken(int r10) {
        ATN r5 = getInterpreter().atn;
        ParserRuleContext r11 = this._ctx;
        IntervalSet r12 = r5.nextTokens(r5.states.get(getState()));
        if (r12.contains(r10) == false) goto L6;
        return true;
    L6:
        if (r12.contains(-2) == true) goto L8;
        return false;
    L8:
        if (r11 == null) goto L18;
        if (r11.invokingState < 0) goto L18;
        if (r12.contains(-2) == false) goto L18;
        r12 = r5.nextTokens(((RuleTransition) r5.states.get(r11.invokingState).transition(0)).followState);
        if (r12.contains(r10) == true) goto L15;
        r11 = (ParserRuleContext) r11.parent;
        goto L8
    L15:
        return true;
    L18:
        if (r12.contains(-2) == true) goto L20;
    L22:
        return false;
    L20:
        if (r10 != (-1)) goto L22;
        return true;
    }

    public boolean isMatchedEOF() {
        return this.matchedEOF;
    }

    public boolean isTrace() {
        if (this._tracer == null) goto L5;
        return true;
    L5:
        return false;
    }

    public Token match(int r5) throws RecognitionException {
        Token r10 = getCurrentToken();
        if (r10.getType() != r5) goto L7;
        if (r5 != (-1)) goto L6;
        this.matchedEOF = true;
    L6:
        this._errHandler.reportMatch(this);
        consume();
    L12:
        return r10;
    L7:
        r10 = this._errHandler.recoverInline(this);
        if (this._buildParseTrees == false) goto L12;
        if (r10.getTokenIndex() != (-1)) goto L12;
        ParserRuleContext r11 = this._ctx;
        r11.addErrorNode(createErrorNode(r11, r10));
        goto L12
    }

    public Token matchWildcard() throws RecognitionException {
        Token r5 = getCurrentToken();
        if (r5.getType() <= 0) goto L5;
        this._errHandler.reportMatch(this);
        consume();
    L10:
        return r5;
    L5:
        r5 = this._errHandler.recoverInline(this);
        if (this._buildParseTrees == false) goto L10;
        if (r5.getTokenIndex() != (-1)) goto L10;
        ParserRuleContext r10 = this._ctx;
        r10.addErrorNode(createErrorNode(r10, r5));
        goto L10
    }

    public final void notifyErrorListeners(String r5) {
        notifyErrorListeners(getCurrentToken(), r5, null);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer
    public boolean precpred(RuleContext r5, int r10) {
        if (r10 < this._precedenceStack.peek()) goto L5;
        return true;
    L5:
        return false;
    }

    public void pushNewRecursionContext(ParserRuleContext r5, int r10, int r11) {
        ParserRuleContext r12 = this._ctx;
        r12.parent = r5;
        r12.invokingState = r10;
        r12.stop = this._input.LT(-1);
        this._ctx = r5;
        r5.start = r12.start;
        if (this._buildParseTrees == false) goto L6;
        r5.addChild(r12);
    L6:
        if (this._parseListeners == null) goto L9;
        triggerEnterRuleEvent();
        return;
    }

    public void removeParseListener(ParseTreeListener r5) {
        List<ParseTreeListener> r10 = this._parseListeners;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.remove(r5) == true) goto L7;
        return;
    L7:
        if (this._parseListeners.isEmpty() == false) goto L12;
        this._parseListeners = null;
        return;
    }

    public void removeParseListeners() {
        this._parseListeners = null;
    }

    public void reset() {
        if (getInputStream() == null) goto L5;
        getInputStream().seek(0);
    L5:
        this._errHandler.reset(this);
        this._ctx = null;
        this._syntaxErrors = 0;
        this.matchedEOF = false;
        setTrace(false);
        this._precedenceStack.clear();
        this._precedenceStack.push(0);
        ParserATNSimulator r5 = getInterpreter();
        if (r5 == null) goto L9;
        r5.reset();
        return;
    }

    public void setBuildParseTree(boolean r5) {
        this._buildParseTrees = r5;
    }

    public void setContext(ParserRuleContext r5) {
        this._ctx = r5;
    }

    public void setErrorHandler(ANTLRErrorStrategy r5) {
        this._errHandler = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer
    public final void setInputStream(IntStream r5) {
        setTokenStream((TokenStream) r5);
    }

    public void setProfile(boolean r5) {
        ParserATNSimulator r10 = getInterpreter();
        PredictionMode r11 = r10.getPredictionMode();
        if (r5 == false) goto L8;
        if ((r10 instanceof ProfilingATNSimulator) == true) goto L10;
        setInterpreter(new ProfilingATNSimulator(this));
    L10:
        getInterpreter().setPredictionMode(r11);
        return;
    L8:
        if ((r10 instanceof ProfilingATNSimulator) == false) goto L10;
        setInterpreter(new ParserATNSimulator(this, getATN(), r10.decisionToDFA, r10.getSharedContextCache()));
        goto L10
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer, androidx.room.jarjarred.org.antlr.v4.runtime.TokenSource
    public void setTokenFactory(TokenFactory<?> r5) {
        this._input.getTokenSource().setTokenFactory(r5);
    }

    public void setTokenStream(TokenStream r5) {
        this._input = null;
        reset();
        this._input = r5;
    }

    public void setTrace(boolean r5) {
        if (r5 == true) goto L4;
        removeParseListener(this._tracer);
        this._tracer = null;
        return;
    L4:
        TraceListener r10 = this._tracer;
        if (r10 == null) goto L7;
        removeParseListener(r10);
    L8:
        addParseListener(this._tracer);
        return;
    L7:
        this._tracer = new TraceListener(this);
        goto L8
    }

    public void setTrimParseTree(boolean r5) {
        if (r5 == true) goto L4;
        removeParseListener(TrimToSizeListener.INSTANCE);
        return;
    L4:
        if (getTrimParseTree() == false) goto L6;
        return;
    L6:
        addParseListener(TrimToSizeListener.INSTANCE);
    }

    public void triggerEnterRuleEvent() {
        Iterator<ParseTreeListener> r5 = this._parseListeners.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ParseTreeListener r10 = r5.next();
        r10.enterEveryRule(this._ctx);
        this._ctx.enterRule(r10);
        goto L4
    }

    public void triggerExitRuleEvent() {
        int r5 = this._parseListeners.size() - 1;
    L3:
        if (r5 < 0) goto L5;
        ParseTreeListener r10 = this._parseListeners.get(r5);
        this._ctx.exitRule(r10);
        r10.exitEveryRule(this._ctx);
        r5 = r5 - 1;
        goto L3
    }

    public void unrollRecursionContexts(ParserRuleContext r5) {
        this._precedenceStack.pop();
        ParserRuleContext r10 = this._ctx;
        r10.stop = this._input.LT(-1);
        ParserRuleContext r11 = this._ctx;
        if (this._parseListeners != null) goto L5;
        this._ctx = r5;
    L8:
        r11.parent = r5;
        if (this._buildParseTrees == false) goto L14;
        if (r5 == null) goto L15;
        r5.addChild(r11);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (this._ctx == r5) goto L8;
        triggerExitRuleEvent();
        this._ctx = (ParserRuleContext) this._ctx.parent;
        goto L5
    }

    public void enterRecursionRule(ParserRuleContext r5, int r10, int r11, int r12) {
        setState(r10);
        this._precedenceStack.push(r12);
        this._ctx = r5;
        r5.start = this._input.LT(1);
        if (this._parseListeners == null) goto L6;
        triggerEnterRuleEvent();
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer, androidx.room.jarjarred.org.antlr.v4.runtime.TokenSource
    public TokenStream getInputStream() {
        return getTokenStream();
    }

    public List<String> getRuleInvocationStack(RuleContext r5) {
        String[] r10 = getRuleNames();
        ArrayList r11 = new ArrayList();
    L3:
        if (r5 == null) goto L9;
        int r12 = r5.getRuleIndex();
        if (r12 >= 0) goto L7;
        r11.add("n/a");
    L8:
        r5 = r5.parent;
        goto L3
    L7:
        r11.add(r10[r12]);
        goto L8
    L9:
        return r11;
    }

    public void notifyErrorListeners(Token r10, String r11, RecognitionException r12) {
        this._syntaxErrors++;
        getErrorListenerDispatch().syntaxError(this, r10, r10.getLine(), r10.getCharPositionInLine(), r11, r12);
    }

    public ParseTreePattern compileParseTreePattern(String r5, int r10, Lexer r11) {
        return new ParseTreePatternMatcher(r11, this).compile(r5, r10);
    }
}
