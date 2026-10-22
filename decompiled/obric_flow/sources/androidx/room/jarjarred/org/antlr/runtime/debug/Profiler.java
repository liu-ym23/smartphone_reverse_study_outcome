package androidx.room.jarjarred.org.antlr.runtime.debug;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.org.antlr.runtime.IntStream;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.TokenStream;
import androidx.room.jarjarred.org.antlr.runtime.misc.DoubleKeyMap;
import androidx.room.writer.DaoWriter;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/* JADX INFO: loaded from: classes.dex */
public class Profiler extends BlankDebugEventListener {
    public static final String DATA_SEP = "\t";
    public static final String RUNTIME_STATS_FILENAME = "runtime.stats";
    public static final String Version = "3";
    static boolean dump;
    public static final String newline = null;
    protected int backtrackDepth;
    protected Stack<String> currentGrammarFileName;
    protected Stack<Integer> currentLine;
    protected Stack<Integer> currentPos;
    protected Stack<String> currentRuleName;
    protected List<DecisionEvent> decisionEvents;
    protected Stack<DecisionEvent> decisionStack;
    protected DoubleKeyMap<String, Integer, DecisionDescriptor> decisions;
    protected Token lastRealTokenTouchedInDecision;
    public DebugParser parser;
    protected int ruleLevel;
    ProfileStats stats;
    protected Set<String> uniqueRules;

    public static class DecisionDescriptor {
        public float avgk;
        public boolean couldBacktrack;
        public int decision;
        public String fileName;
        public int line;
        public int maxk;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f628n;
        public int numBacktrackOccurrences;
        public int numSemPredEvals;
        public int pos;
        public String ruleName;

        public DecisionDescriptor() {
        }
    }

    public static class DecisionEvent {
        public boolean backtracks;
        public DecisionDescriptor decision;
        public boolean evalSemPred;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f629k;
        public int numMemoizationCacheHits;
        public int numMemoizationCacheMisses;
        public int startIndex;
        public long startTime;
        public long stopTime;

        public DecisionEvent() {
        }
    }

    public static class ProfileStats {
        public String Version;
        public float averageDecisionPercentBacktracks;
        public int avgDecisionMaxCyclicLookaheads;
        public int avgDecisionMaxFixedLookaheads;
        public float avgkPerBacktrackingDecisionEvent;
        public float avgkPerDecisionEvent;
        public int maxDecisionMaxCyclicLookaheads;
        public int maxDecisionMaxFixedLookaheads;
        public int maxRuleInvocationDepth;
        public int minDecisionMaxCyclicLookaheads;
        public int minDecisionMaxFixedLookaheads;
        public String name;
        public int numBacktrackOccurrences;
        public int numCharsMatched;
        public int numCyclicDecisions;
        public int numDecisionEvents;
        public int numDecisionsCovered;
        public int numDecisionsThatDoBacktrack;
        public int numDecisionsThatPotentiallyBacktrack;
        public int numFixedDecisions;
        public int numGuessingRuleInvocations;
        public int numHiddenCharsMatched;
        public int numHiddenTokens;
        public int numMemoizationCacheEntries;
        public int numMemoizationCacheHits;
        public int numMemoizationCacheMisses;
        public int numReportedErrors;
        public int numRuleInvocations;
        public int numSemanticPredicates;
        public int numTokens;
        public int numUniqueRulesInvoked;
        public int stddevDecisionMaxCyclicLookaheads;
        public int stddevDecisionMaxFixedLookaheads;

        public ProfileStats() {
        }
    }

    static {
        newline = System.getProperty("line.separator");
        dump = false;
    }

    public Profiler() {
        this.parser = null;
        this.ruleLevel = 0;
        this.uniqueRules = new HashSet();
        this.currentGrammarFileName = new Stack();
        this.currentRuleName = new Stack();
        this.currentLine = new Stack();
        this.currentPos = new Stack();
        this.decisions = new DoubleKeyMap();
        this.decisionEvents = new ArrayList();
        this.decisionStack = new Stack();
        this.stats = new ProfileStats();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void LT(int r5, Token r10) {
        if (inDecision() == false) goto L16;
        if (r5 <= 0) goto L17;
        DecisionEvent r11 = currentDecision();
        if (dump == false) goto L8;
        System.out.println("LT(" + r5 + ")=" + r10 + " index " + r10.getTokenIndex() + " relative to " + r11.decision.ruleName + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + r11.decision.decision + " start index " + r11.startIndex);
    L8:
        Token r12 = this.lastRealTokenTouchedInDecision;
        if (r12 != null) goto L11;
    L12:
        this.lastRealTokenTouchedInDecision = r10;
        if (dump == false) goto L19;
        System.out.println("set last token " + this.lastRealTokenTouchedInDecision);
        return;
    L19:
        return;
    L11:
        if (r12.getTokenIndex() < r10.getTokenIndex()) goto L12;
        return;
    L17:
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void beginBacktrack(int r5) {
        if (dump == false) goto L5;
        System.out.println("enter backtrack " + r5);
    L5:
        this.backtrackDepth++;
        DecisionEvent r10 = currentDecision();
        DecisionDescriptor r11 = r10.decision;
        if (r11.couldBacktrack == false) goto L9;
        this.stats.numBacktrackOccurrences++;
        r11.numBacktrackOccurrences++;
        r10.backtracks = true;
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void consumeHiddenToken(Token r5) {
        if (inDecision() == true) goto L6;
        this.stats.numHiddenTokens++;
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void consumeToken(Token r10) {
        if (dump == false) goto L6;
        System.out.println("consume token " + r10);
    L6:
        if (inDecision() == true) goto L9;
        this.stats.numTokens++;
        return;
    L9:
        Token r5 = this.lastRealTokenTouchedInDecision;
        if (r5 != null) goto L12;
    L13:
        this.lastRealTokenTouchedInDecision = r10;
    L14:
        DecisionEvent r11 = currentDecision();
        int r12 = r10.getTokenIndex();
        int r13 = ((r12 - r11.startIndex) - getNumberOfHiddenTokens(r11.startIndex, r12)) + 1;
        if (dump == false) goto L18;
        PrintStream r14 = System.out;
        StringBuilder r15 = j0.v("consume ", r12, r13, " ", " tokens ahead in ");
        r15.append(r11.decision.ruleName);
        r15.append(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        r15.append(r11.decision.decision);
        r15.append(" start index ");
        r15.append(r11.startIndex);
        r14.println(r15.toString());
        return;
    L18:
        return;
    L12:
        if (r5.getTokenIndex() >= r10.getTokenIndex()) goto L14;
        goto L13
    }

    public DecisionEvent currentDecision() {
        return this.decisionStack.peek();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void endBacktrack(int r5, boolean r10) {
        if (dump == false) goto L5;
        System.out.println("exit backtrack " + r5 + ": " + r10);
    L5:
        this.backtrackDepth--;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void enterDecision(int r10, boolean r11) {
        this.lastRealTokenTouchedInDecision = null;
        this.stats.numDecisionEvents++;
        int r5 = this.parser.getTokenStream().index();
        TokenStream r12 = this.parser.getTokenStream();
        if (dump == false) goto L5;
        System.out.println("enterDecision canBacktrack=" + r11 + " " + r10 + " backtrack depth " + this.backtrackDepth + " @ " + r12.get(r12.index()) + " rule " + locationDescription());
    L5:
        String r13 = this.currentGrammarFileName.peek();
        DecisionDescriptor r14 = this.decisions.get(r13, Integer.valueOf(r10));
        if (r14 != null) goto L8;
        r14 = new DecisionDescriptor();
        this.decisions.put(r13, Integer.valueOf(r10), r14);
        r14.decision = r10;
        r14.fileName = this.currentGrammarFileName.peek();
        r14.ruleName = this.currentRuleName.peek();
        r14.line = this.currentLine.peek().intValue();
        r14.pos = this.currentPos.peek().intValue();
        r14.couldBacktrack = r11;
    L8:
        r14.f628n++;
        DecisionEvent r15 = new DecisionEvent();
        this.decisionStack.push(r15);
        r15.decision = r14;
        r15.startTime = System.currentTimeMillis();
        r15.startIndex = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void enterRule(String r5, String r10) {
        this.ruleLevel++;
        this.stats.numRuleInvocations++;
        this.uniqueRules.add(r5 + ":" + r10);
        ProfileStats r11 = this.stats;
        r11.maxRuleInvocationDepth = Math.max(r11.maxRuleInvocationDepth, this.ruleLevel);
        this.currentGrammarFileName.push(r5);
        this.currentRuleName.push(r10);
    }

    public void examineRuleMemoization(IntStream r5, int r10, int r11, String r12) {
        if (dump == false) goto L6;
        PrintStream r13 = System.out;
        StringBuilder r14 = j0.x("examine memo ", r12, " at ");
        r14.append(r5.index());
        r14.append(": ");
        r14.append(r11);
        r13.println(r14.toString());
    L6:
        if (r11 != (-1)) goto L8;
        ProfileStats r15 = this.stats;
        r15.numMemoizationCacheMisses++;
        r15.numGuessingRuleInvocations++;
        currentDecision().numMemoizationCacheMisses++;
        return;
    L8:
        this.stats.numMemoizationCacheHits++;
        currentDecision().numMemoizationCacheHits++;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void exitDecision(int r5) {
        DecisionEvent r10 = this.decisionStack.pop();
        r10.stopTime = System.currentTimeMillis();
        int r11 = this.lastRealTokenTouchedInDecision.getTokenIndex();
        int r12 = getNumberOfHiddenTokens(r10.startIndex, r11);
        int r13 = ((r11 - r10.startIndex) - r12) + 1;
        r10.f629k = r13;
        DecisionDescriptor r14 = r10.decision;
        r14.maxk = Math.max(r14.maxk, r13);
        if (dump == false) goto L5;
        PrintStream r15 = System.out;
        StringBuilder r16 = j0.s(r5, "exitDecision ", " in ");
        r16.append(r10.decision.ruleName);
        r16.append(" lookahead ");
        r16.append(r10.f629k);
        r16.append(" max token ");
        r16.append(this.lastRealTokenTouchedInDecision);
        r15.println(r16.toString());
    L5:
        this.decisionEvents.add(r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void exitRule(String r5, String r10) {
        this.ruleLevel--;
        this.currentGrammarFileName.pop();
        this.currentRuleName.pop();
    }

    public List<DecisionEvent> getDecisionEvents() {
        return this.decisionEvents;
    }

    public DoubleKeyMap<String, Integer, DecisionDescriptor> getDecisionStats() {
        return this.decisions;
    }

    public String getDecisionStatsDump() {
        StringBuilder r5 = new StringBuilder("location\tn\tavgk\tmaxk\tsynpred\tsempred\tcanbacktrack\n");
        Iterator<String> r10 = this.decisions.keySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L14;
        String r11 = r10.next();
        Iterator<Integer> r12 = this.decisions.keySet(r11).iterator();
    L7:
        if (r12.hasNext() == false) goto L4;
        Integer r13 = r12.next();
        r13.intValue();
        DecisionDescriptor r14 = this.decisions.get(r11, r13);
        r5.append(r14.decision);
        r5.append("@");
        r5.append(locationDescription(r14.fileName, r14.ruleName, r14.line, r14.pos));
        r5.append(DATA_SEP);
        r5.append(r14.f628n);
        r5.append(DATA_SEP);
        r5.append(String.format("%.2f", new Object[]{Float.valueOf(r14.avgk)}));
        r5.append(DATA_SEP);
        r5.append(r14.maxk);
        r5.append(DATA_SEP);
        r5.append(r14.numBacktrackOccurrences);
        r5.append(DATA_SEP);
        r5.append(r14.numSemPredEvals);
        r5.append(DATA_SEP);
        if (r14.couldBacktrack == false) goto L11;
        String r15 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
    L12:
        r5.append(r15);
        r5.append(newline);
        goto L7
    L11:
        r15 = "0";
        goto L12
    L14:
        return r5.toString();
    }

    public int getNumberOfHiddenTokens(int r5, int r10) {
        TokenStream r11 = this.parser.getTokenStream();
        int r12 = 0;
    L4:
        if (r5 >= r11.size()) goto L10;
        if (r5 > r10) goto L10;
        if (r11.get(r5).getChannel() == 0) goto L9;
        r12 = r12 + 1;
    L9:
        r5 = r5 + 1;
    L10:
        return r12;
    }

    public ProfileStats getReport() {
        ProfileStats r5 = this.stats;
        r5.Version = "3";
        r5.name = this.parser.getClass().getName();
        ProfileStats r10 = this.stats;
        r10.numUniqueRulesInvoked = this.uniqueRules.size();
        return this.stats;
    }

    public boolean inDecision() {
        if (this.decisionStack.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void location(int r5, int r10) {
        this.currentLine.push(Integer.valueOf(r5));
        this.currentPos.push(Integer.valueOf(r10));
    }

    public String locationDescription() {
        return locationDescription(this.currentGrammarFileName.peek(), this.currentRuleName.peek(), this.currentLine.peek().intValue(), this.currentPos.peek().intValue());
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void mark(int r5) {
        if (dump == false) goto L6;
        System.out.println("mark " + r5);
        return;
    }

    public void memoize(IntStream r5, int r10, int r11, String r12) {
        if (dump == false) goto L5;
        System.out.println("memoize " + r12);
    L5:
        this.stats.numMemoizationCacheEntries++;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void recognitionException(RecognitionException r5) {
        this.stats.numReportedErrors++;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void rewind(int r5) {
        if (dump == false) goto L6;
        System.out.println("rewind " + r5);
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void semanticPredicate(boolean r5, String r10) {
        this.stats.numSemanticPredicates++;
        if (inDecision() == false) goto L8;
        DecisionEvent r11 = currentDecision();
        r11.evalSemPred = true;
        r11.decision.numSemPredEvals++;
        if (dump == false) goto L9;
        PrintStream r12 = System.out;
        StringBuilder r13 = j0.x("eval ", r10, " in ");
        r13.append(r11.decision.ruleName);
        r13.append(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        r13.append(r11.decision.decision);
        r12.println(r13.toString());
        return;
    L9:
        return;
    }

    public void setParser(DebugParser r5) {
        this.parser = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void terminate() {
        Iterator<DecisionEvent> r5 = this.decisionEvents.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        DecisionEvent r10 = r5.next();
        DecisionDescriptor r11 = r10.decision;
        float r12 = r11.avgk;
        int r13 = r10.f629k;
        r11.avgk = r12 + r13;
        ProfileStats r14 = this.stats;
        r14.avgkPerDecisionEvent += r13;
        if (r10.backtracks == false) goto L4;
        r14.avgkPerBacktrackingDecisionEvent += r13;
        goto L4
    L8:
        this.stats.averageDecisionPercentBacktracks = 0.0f;
        Iterator<DecisionDescriptor> r15 = this.decisions.values().iterator();
    L10:
        if (r15.hasNext() == false) goto L17;
        DecisionDescriptor r16 = r15.next();
        ProfileStats r17 = this.stats;
        r17.numDecisionsCovered++;
        double r18 = r16.avgk;
        int r19 = r16.f628n;
        r16.avgk = (float) (r18 / ((double) r19));
        if (r16.couldBacktrack == false) goto L15;
        r17.numDecisionsThatPotentiallyBacktrack++;
        r17.averageDecisionPercentBacktracks += r16.numBacktrackOccurrences / r19;
    L15:
        if (r16.numBacktrackOccurrences <= 0) goto L10;
        r17.numDecisionsThatDoBacktrack++;
        goto L10
    L17:
        ProfileStats r20 = this.stats;
        r20.averageDecisionPercentBacktracks = (r20.averageDecisionPercentBacktracks / r20.numDecisionsThatPotentiallyBacktrack) * 100.0f;
        r20.avgkPerDecisionEvent /= r20.numDecisionEvents;
        r20.avgkPerBacktrackingDecisionEvent = (float) (((double) r20.avgkPerBacktrackingDecisionEvent) / ((double) r20.numBacktrackOccurrences));
        PrintStream r21 = System.err;
        r21.println(toString());
        r21.println(getDecisionStatsDump());
    }

    public int[] toArray(List<Integer> r5) {
        int[] r10 = new int[r5.size()];
        int r11 = 0;
    L4:
        if (r11 >= r5.size()) goto L6;
        r10[r11] = r5.get(r11).intValue();
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    public String toNotifyString() {
        return "3\t".concat(this.parser.getClass().getName());
    }

    public String toString() {
        return toString(getReport());
    }

    public int[] trim(int[] r5, int r10) {
        if (r10 >= r5.length) goto L6;
        int[] r11 = new int[r10];
        System.arraycopy(r5, 0, r11, 0, r10);
        return r11;
    L6:
        return r5;
    }

    public static String toString(ProfileStats r5) {
        StringBuilder r10 = new StringBuilder("ANTLR Runtime Report; Profile Version ");
        r10.append(r5.Version);
        String r11 = newline;
        r10.append(r11);
        r10.append("parser name ");
        r10.append(r5.name);
        r10.append(r11);
        r10.append("Number of rule invocations ");
        r10.append(r5.numRuleInvocations);
        r10.append(r11);
        r10.append("Number of unique rules visited ");
        r10.append(r5.numUniqueRulesInvoked);
        r10.append(r11);
        r10.append("Number of decision events ");
        r10.append(r5.numDecisionEvents);
        r10.append(r11);
        r10.append("Overall average k per decision event ");
        r10.append(r5.avgkPerDecisionEvent);
        r10.append(r11);
        r10.append("Number of backtracking occurrences (can be multiple per decision) ");
        r10.append(r5.numBacktrackOccurrences);
        r10.append(r11);
        r10.append("Overall average k per decision event that backtracks ");
        r10.append(r5.avgkPerBacktrackingDecisionEvent);
        r10.append(r11);
        r10.append("Number of rule invocations while backtracking ");
        r10.append(r5.numGuessingRuleInvocations);
        r10.append(r11);
        r10.append("num decisions that potentially backtrack ");
        r10.append(r5.numDecisionsThatPotentiallyBacktrack);
        r10.append(r11);
        r10.append("num decisions that do backtrack ");
        r10.append(r5.numDecisionsThatDoBacktrack);
        r10.append(r11);
        r10.append("num decisions that potentially backtrack but don't ");
        r10.append(r5.numDecisionsThatPotentiallyBacktrack - r5.numDecisionsThatDoBacktrack);
        r10.append(r11);
        r10.append("average % of time a potentially backtracking decision backtracks ");
        r10.append(r5.averageDecisionPercentBacktracks);
        r10.append(r11);
        r10.append("num unique decisions covered ");
        r10.append(r5.numDecisionsCovered);
        r10.append(r11);
        r10.append("max rule invocation nesting depth ");
        r10.append(r5.maxRuleInvocationDepth);
        r10.append(r11);
        r10.append("rule memoization cache size ");
        r10.append(r5.numMemoizationCacheEntries);
        r10.append(r11);
        r10.append("number of rule memoization cache hits ");
        r10.append(r5.numMemoizationCacheHits);
        r10.append(r11);
        r10.append("number of rule memoization cache misses ");
        r10.append(r5.numMemoizationCacheMisses);
        r10.append(r11);
        r10.append("number of tokens ");
        r10.append(r5.numTokens);
        r10.append(r11);
        r10.append("number of hidden tokens ");
        r10.append(r5.numHiddenTokens);
        r10.append(r11);
        r10.append("number of char ");
        r10.append(r5.numCharsMatched);
        r10.append(r11);
        r10.append("number of hidden char ");
        r10.append(r5.numHiddenCharsMatched);
        r10.append(r11);
        r10.append("number of syntax errors ");
        return a.s(r10, r5.numReportedErrors, r11);
    }

    public String locationDescription(String r5, String r10, int r11, int r12) {
        StringBuilder r13 = new StringBuilder();
        r13.append(r5);
        r13.append(":");
        r13.append(r11);
        r13.append(":");
        r13.append(r12);
        return a.t(r13, "(", r10, ")");
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void rewind() {
        if (dump == false) goto L6;
        System.out.println("rewind");
        return;
    }

    public Profiler(DebugParser r5) {
        this.parser = null;
        this.ruleLevel = 0;
        this.uniqueRules = new HashSet();
        this.currentGrammarFileName = new Stack();
        this.currentRuleName = new Stack();
        this.currentLine = new Stack();
        this.currentPos = new Stack();
        this.decisions = new DoubleKeyMap();
        this.decisionEvents = new ArrayList();
        this.decisionStack = new Stack();
        this.stats = new ProfileStats();
        this.parser = r5;
    }
}
