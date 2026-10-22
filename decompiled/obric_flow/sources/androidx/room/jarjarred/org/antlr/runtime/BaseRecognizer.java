package androidx.room.jarjarred.org.antlr.runtime;

import ai.j0;
import androidx.room.jarjarred.org.antlr.runtime.debug.Profiler;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseRecognizer {
    public static final int DEFAULT_TOKEN_CHANNEL = 0;
    public static final int HIDDEN = 99;
    public static final int INITIAL_FOLLOW_STACK_SIZE = 100;
    public static final int MEMO_RULE_FAILED = -2;
    public static final int MEMO_RULE_UNKNOWN = -1;
    public static final String NEXT_TOKEN_RULE_NAME = "nextToken";
    protected RecognizerSharedState state;

    public BaseRecognizer() {
        this.state = new RecognizerSharedState();
    }

    public boolean alreadyParsedRule(IntStream r5, int r10) {
        int r11 = getRuleMemoization(r10, r5.index());
        if (r11 != (-1)) goto L7;
        return false;
    L7:
        if (r11 != (-2)) goto L9;
        this.state.failed = true;
    L10:
        return true;
    L9:
        r5.seek(r11 + 1);
        goto L10
    }

    public void beginResync() {
    }

    public BitSet combineFollows(boolean r5) {
        int r10 = this.state._fsp;
        BitSet r11 = new BitSet();
    L3:
        if (r10 < 0) goto L11;
        BitSet r12 = this.state.following[r10];
        r11.orInPlace(r12);
        if (r5 == false) goto L10;
        if (r12.member(1) == false) goto L11;
        if (r10 <= 0) goto L10;
        r11.remove(1);
    L10:
        r10 = r10 - 1;
    L11:
        return r11;
    }

    public BitSet computeContextSensitiveRuleFOLLOW() {
        return combineFollows(true);
    }

    public BitSet computeErrorRecoverySet() {
        return combineFollows(false);
    }

    public void consumeUntil(IntStream r5, int r10) {
        int r11 = r5.LA(1);
    L4:
        if (r11 == (-1)) goto L7;
        if (r11 == r10) goto L10;
        r5.consume();
        r11 = r5.LA(1);
        goto L4
    L10:
        return;
    }

    public void displayRecognitionError(String[] r5, RecognitionException r10) {
        emitErrorMessage(getErrorHeader(r10) + " " + getErrorMessage(r10, r5));
    }

    public void emitErrorMessage(String r5) {
        System.err.println(r5);
    }

    public void endResync() {
    }

    public boolean failed() {
        return this.state.failed;
    }

    public int getBacktrackingLevel() {
        return this.state.backtracking;
    }

    public Object getCurrentInputSymbol(IntStream r5) {
        return null;
    }

    public String getErrorHeader(RecognitionException r5) {
        if (getSourceName() == null) goto L7;
        return getSourceName() + " line " + r5.line + ":" + r5.charPositionInLine;
    L7:
        return "line " + r5.line + ":" + r5.charPositionInLine;
    }

    public String getErrorMessage(RecognitionException r10, String[] r11) {
        String r5 = r10.getMessage();
        String r12 = "EOF";
        if ((r10 instanceof UnwantedTokenException) == false) goto L10;
        UnwantedTokenException r13 = (UnwantedTokenException) r10;
        int r14 = r13.expecting;
        if (r14 == (-1)) goto L46;
        r12 = r11[r14];
    L46:
        return "extraneous input " + getTokenErrorDisplay(r13.getUnexpectedToken()) + " expecting " + r12;
    L10:
        if ((r10 instanceof MissingTokenException) == false) goto L17;
        int r15 = ((MissingTokenException) r10).expecting;
        if (r15 == (-1)) goto L15;
        r12 = r11[r15];
    L15:
        StringBuilder r16 = j0.x("missing ", r12, " at ");
        r16.append(getTokenErrorDisplay(r10.token));
        return r16.toString();
    L17:
        if ((r10 instanceof MismatchedTokenException) == false) goto L24;
        int r17 = ((MismatchedTokenException) r10).expecting;
        if (r17 == (-1)) goto L48;
        r12 = r11[r17];
    L48:
        return "mismatched input " + getTokenErrorDisplay(r10.token) + " expecting " + r12;
    L24:
        if ((r10 instanceof MismatchedTreeNodeException) == false) goto L31;
        MismatchedTreeNodeException r18 = (MismatchedTreeNodeException) r10;
        int r19 = r18.expecting;
        if (r19 == (-1)) goto L49;
        r12 = r11[r19];
    L49:
        return "mismatched tree node: " + r18.node + " expecting " + r12;
    L31:
        if ((r10 instanceof NoViableAltException) == false) goto L34;
        return "no viable alternative at input " + getTokenErrorDisplay(r10.token);
    L34:
        if ((r10 instanceof EarlyExitException) == false) goto L37;
        return "required (...)+ loop did not match anything at input " + getTokenErrorDisplay(r10.token);
    L37:
        if ((r10 instanceof MismatchedSetException) == false) goto L40;
        return "mismatched input " + getTokenErrorDisplay(r10.token) + " expecting set " + ((MismatchedSetException) r10).expecting;
    L40:
        if ((r10 instanceof MismatchedNotSetException) == false) goto L43;
        return "mismatched input " + getTokenErrorDisplay(r10.token) + " expecting set " + ((MismatchedNotSetException) r10).expecting;
    L43:
        if ((r10 instanceof FailedPredicateException) == false) goto L54;
        FailedPredicateException r20 = (FailedPredicateException) r10;
        StringBuilder r21 = new StringBuilder("rule ");
        r21.append(r20.ruleName);
        r21.append(" failed predicate: {");
        return j0.q(r21, r20.predicateText, "}?");
    L54:
        return r5;
    }

    public String getGrammarFileName() {
        return null;
    }

    public Object getMissingSymbol(IntStream r5, RecognitionException r10, int r11, BitSet r12) {
        return null;
    }

    public int getNumberOfSyntaxErrors() {
        return this.state.syntaxErrors;
    }

    public List<String> getRuleInvocationStack() {
        String r5 = getClass().getName();
        return getRuleInvocationStack(new Throwable(), r5);
    }

    public int getRuleMemoization(int r5, int r10) {
        Map<Integer, Integer>[] r11 = this.state.ruleMemo;
        if (r11[r5] != null) goto L5;
        r11[r5] = new HashMap();
    L5:
        Integer r12 = this.state.ruleMemo[r5].get(Integer.valueOf(r10));
        if (r12 != null) goto L10;
        return -1;
    L10:
        return r12.intValue();
    }

    public int getRuleMemoizationCacheSize() {
        int r5 = 0;
        int r10 = 0;
    L3:
        Map<Integer, Integer>[] r11 = this.state.ruleMemo;
        if (r11 == null) goto L11;
        if (r5 >= r11.length) goto L11;
        Map<Integer, Integer> r12 = r11[r5];
        if (r12 == null) goto L10;
        r10 = r12.size() + r10;
    L10:
        r5 = r5 + 1;
    L11:
        return r10;
    }

    public abstract String getSourceName();

    public String getTokenErrorDisplay(Token r5) {
        String r10 = r5.getText();
        if (r10 != null) goto L9;
        if (r5.getType() != (-1)) goto L7;
        r10 = "<EOF>";
        goto L9
    L7:
        r10 = "<" + r5.getType() + ">";
    L9:
        return j0.k("'", r10.replaceAll("\n", "\\\\n").replaceAll("\r", "\\\\r").replaceAll(Profiler.DATA_SEP, "\\\\t"), "'");
    }

    public String[] getTokenNames() {
        return null;
    }

    public Object match(IntStream r5, int r10, BitSet r11) throws RecognitionException {
        Object r12 = getCurrentInputSymbol(r5);
        if (r5.LA(1) != r10) goto L6;
        r5.consume();
        RecognizerSharedState r13 = this.state;
        r13.errorRecovery = false;
        r13.failed = false;
        return r12;
    L6:
        RecognizerSharedState r14 = this.state;
        if (r14.backtracking <= 0) goto L11;
        r14.failed = true;
        return r12;
    L11:
        return recoverFromMismatchedToken(r5, r10, r11);
    }

    public void matchAny(IntStream r5) {
        RecognizerSharedState r10 = this.state;
        r10.errorRecovery = false;
        r10.failed = false;
        r5.consume();
    }

    public void memoize(IntStream r5, int r10, int r11) {
        if (this.state.failed == false) goto L5;
        int r12 = -2;
    L7:
        if (this.state.ruleMemo != null) goto L10;
        System.err.println("!!!!!!!!! memo array is null for " + getGrammarFileName());
    L10:
        if (r10 < this.state.ruleMemo.length) goto L12;
        System.err.println("!!!!!!!!! memo size is " + this.state.ruleMemo.length + ", but rule index is " + r10);
    L12:
        Map<Integer, Integer> r13 = this.state.ruleMemo[r10];
        if (r13 == null) goto L16;
        r13.put(Integer.valueOf(r11), Integer.valueOf(r12));
        return;
    L16:
        return;
    L5:
        r12 = r5.index() - 1;
        goto L7
    }

    public boolean mismatchIsMissingToken(IntStream r5, BitSet r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.member(1) == false) goto L11;
        r10 = r10.or(computeContextSensitiveRuleFOLLOW());
        if (this.state._fsp < 0) goto L11;
        r10.remove(1);
    L11:
        if (r10.member(r5.LA(1)) == false) goto L13;
    L16:
        return true;
    L13:
        if (r10.member(1) == true) goto L16;
        return false;
    }

    public boolean mismatchIsUnwantedToken(IntStream r5, int r10) {
        if (r5.LA(2) != r10) goto L5;
        return true;
    L5:
        return false;
    }

    public void pushFollow(BitSet r5) {
        RecognizerSharedState r10 = this.state;
        int r11 = r10._fsp + 1;
        BitSet[] r12 = r10.following;
        if (r11 < r12.length) goto L5;
        BitSet[] r13 = new BitSet[r12.length * 2];
        System.arraycopy(r12, 0, r13, 0, r12.length);
        this.state.following = r13;
    L5:
        RecognizerSharedState r14 = this.state;
        BitSet[] r15 = r14.following;
        int r16 = r14._fsp + 1;
        r14._fsp = r16;
        r15[r16] = r5;
    }

    public void recover(IntStream r5, RecognitionException r10) {
        if (this.state.lastErrorIndex != r5.index()) goto L5;
        r5.consume();
    L5:
        RecognizerSharedState r11 = this.state;
        r11.lastErrorIndex = r5.index();
        BitSet r12 = computeErrorRecoverySet();
        beginResync();
        consumeUntil(r5, r12);
        endResync();
    }

    public Object recoverFromMismatchedSet(IntStream r5, RecognitionException r10, BitSet r11) throws RecognitionException {
        if (mismatchIsMissingToken(r5, r11) == false) goto L6;
        reportError(r10);
        return getMissingSymbol(r5, r10, 0, r11);
    L6:
        throw r10;
    }

    public Object recoverFromMismatchedToken(IntStream r5, int r10, BitSet r11) throws RecognitionException {
        if (mismatchIsUnwantedToken(r5, r10) == false) goto L7;
        UnwantedTokenException r12 = new UnwantedTokenException(r10, r5);
        beginResync();
        r5.consume();
        endResync();
        reportError(r12);
        Object r13 = getCurrentInputSymbol(r5);
        r5.consume();
        return r13;
    L7:
        if (mismatchIsMissingToken(r5, r11) == false) goto L11;
        Object r14 = getMissingSymbol(r5, null, r10, r11);
        reportError(new MissingTokenException(r10, r5, r14));
        return r14;
    L11:
        throw new MismatchedTokenException(r10, r5);
    }

    public void reportError(RecognitionException r5) {
        RecognizerSharedState r10 = this.state;
        if (r10.errorRecovery == false) goto L5;
        return;
    L5:
        r10.syntaxErrors++;
        r10.errorRecovery = true;
        displayRecognitionError(getTokenNames(), r5);
    }

    public void reset() {
        RecognizerSharedState r5 = this.state;
        if (r5 != null) goto L5;
        return;
    L5:
        r5._fsp = -1;
        int r10 = 0;
        r5.errorRecovery = false;
        r5.lastErrorIndex = -1;
        r5.failed = false;
        r5.syntaxErrors = 0;
        r5.backtracking = 0;
    L6:
        Map<Integer, Integer>[] r11 = this.state.ruleMemo;
        if (r11 == null) goto L11;
        if (r10 >= r11.length) goto L14;
        r11[r10] = null;
        r10 = r10 + 1;
        goto L6
    L14:
        return;
    }

    public void setBacktrackingLevel(int r5) {
        this.state.backtracking = r5;
    }

    public List<String> toStrings(List<? extends Token> r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        ArrayList r10 = new ArrayList(r5.size());
        int r11 = 0;
    L7:
        if (r11 >= r5.size()) goto L9;
        r10.add(r5.get(r11).getText());
        r11 = r11 + 1;
        goto L7
    L9:
        return r10;
    }

    public void traceIn(String r5, int r10, Object r11) {
        PrintStream r12 = System.out;
        r12.print("enter " + r5 + " " + r11);
        if (this.state.backtracking <= 0) goto L5;
        r12.print(" backtracking=" + this.state.backtracking);
    L5:
        r12.println();
    }

    public void traceOut(String r5, int r10, Object r11) {
        PrintStream r12 = System.out;
        r12.print("exit " + r5 + " " + r11);
        if (this.state.backtracking <= 0) goto L8;
        r12.print(" backtracking=" + this.state.backtracking);
        if (this.state.failed == false) goto L7;
        r12.print(" failed");
        goto L8
    L7:
        r12.print(" succeeded");
    L8:
        r12.println();
    }

    public BaseRecognizer(RecognizerSharedState r5) {
        if (r5 != null) goto L5;
        r5 = new RecognizerSharedState();
    L5:
        this.state = r5;
    }

    public static List<String> getRuleInvocationStack(Throwable r5, String r10) {
        ArrayList r11 = new ArrayList();
        StackTraceElement[] r12 = r5.getStackTrace();
        int r13 = r12.length - 1;
    L3:
        if (r13 < 0) goto L15;
        StackTraceElement r14 = r12[r13];
        if (r14.getClassName().startsWith("androidx.room.jarjarred.org.antlr.runtime.") == true) goto L14;
        if (r14.getMethodName().equals(NEXT_TOKEN_RULE_NAME) == true) goto L14;
        if (r14.getClassName().equals(r10) == false) goto L14;
        r11.add(r14.getMethodName());
    L14:
        r13 = r13 - 1;
        goto L3
    L15:
        return r11;
    }

    public void consumeUntil(IntStream r5, BitSet r10) {
        int r11 = r5.LA(1);
    L4:
        if (r11 == (-1)) goto L8;
        if (r10.member(r11) == true) goto L11;
        r5.consume();
        r11 = r5.LA(1);
        goto L4
    L11:
        return;
    }
}
