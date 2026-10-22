package androidx.room.jarjarred.org.antlr.v4.analysis;

import androidx.room.jarjarred.org.antlr.v4.misc.Utils;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.DecisionState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.LL1Analyzer;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntSet;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorType;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class AnalysisPipeline {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public Grammar g;

    public AnalysisPipeline(Grammar r5) {
        this.g = r5;
    }

    public static boolean disjoint(IntervalSet[] r10) {
        boolean r5 = false;
        IntervalSet r11 = new IntervalSet(new int[0]);
        if (r10 != null) goto L5;
        return false;
    L5:
        int r12 = r10.length;
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L16;
        IntSet r14 = r10[r13];
        if (r14 == null) goto L10;
        if (r14.and(r11).isNil() == false) goto L13;
        r11.addAll(r14);
        r13 = r13 + 1;
        goto L7
    L13:
        r5 = true;
        goto L16
    L10:
        return false;
    L16:
        return !r5;
    }

    public void process() {
        Grammar r5 = this.g;
        LeftRecursionDetector r10 = new LeftRecursionDetector(r5, r5.atn);
        r10.check();
        if (r10.listOfRecursiveCycles.isEmpty() == true) goto L6;
        return;
    L6:
        if (this.g.isLexer() == false) goto L8;
        processLexer();
        return;
    L8:
        processParser();
    }

    public void processLexer() {
        Iterator<Rule> r5 = this.g.rules.values().iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        Rule r10 = r5.next();
        if (r10.isFragment() == true) goto L4;
        if (new LL1Analyzer(this.g.atn).LOOK(this.g.atn.ruleToStartState[r10.index], null).contains(-2) == false) goto L4;
        Grammar r11 = this.g;
        r11.tool.errMgr.grammarError(ErrorType.EPSILON_TOKEN, r11.fileName, ((GrammarAST) r10.ast.getChild(0)).getToken(), new Object[]{r10.name});
        goto L4
    }

    public void processParser() {
        this.g.decisionLOOK = new ArrayList(this.g.atn.getNumberOfDecisions() + 1);
        Iterator<DecisionState> r5 = this.g.atn.decisionToState.iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        DecisionState r10 = r5.next();
        this.g.tool.log("LL1", "\nDECISION " + r10.decision + " in rule " + this.g.getRule(r10.ruleIndex).name);
        if (r10.nonGreedy == false) goto L8;
        IntervalSet[] r11 = new IntervalSet[r10.getNumberOfTransitions() + 1];
    L9:
        Utils.setSize(this.g.decisionLOOK, r10.decision + 1);
        this.g.decisionLOOK.set(r10.decision, r11);
        this.g.tool.log("LL1", "LL(1)? " + disjoint(r11));
        goto L4
    L8:
        r11 = new LL1Analyzer(this.g.atn).getDecisionLookahead(r10);
        this.g.tool.log("LL1", "look=" + Arrays.toString(r11));
        goto L9
    }
}
