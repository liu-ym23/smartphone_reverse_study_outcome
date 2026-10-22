package androidx.room.jarjarred.org.antlr.v4.analysis;

import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATN;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.RuleStartState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.RuleStopState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.RuleTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.OrderedHashSet;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class LeftRecursionDetector {
    public ATN atn;
    Grammar g;
    public List<Set<Rule>> listOfRecursiveCycles;
    Set<RuleStartState> rulesVisitedPerRuleCheck;

    public LeftRecursionDetector(Grammar r5, ATN r10) {
        this.listOfRecursiveCycles = new ArrayList();
        this.rulesVisitedPerRuleCheck = new HashSet();
        this.g = r5;
        this.atn = r10;
    }

    public void addRulesToCycle(Rule r10, Rule r11) {
        Iterator<Set<Rule>> r5 = this.listOfRecursiveCycles.iterator();
        boolean r12 = false;
    L4:
        if (r5.hasNext() == false) goto L11;
        Set<Rule> r13 = r5.next();
        if (r13.contains(r11) == false) goto L9;
        r13.add(r10);
        r12 = true;
    L9:
        if (r13.contains(r10) == false) goto L4;
        r13.add(r11);
        r12 = true;
        goto L4
    L11:
        if (r12 == true) goto L19;
        OrderedHashSet r14 = new OrderedHashSet();
        r14.add(r11);
        r14.add(r10);
        this.listOfRecursiveCycles.add(r14);
        return;
    }

    public void check() {
        RuleStartState[] r5 = this.atn.ruleToStartState;
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L6;
        RuleStartState r12 = r5[r11];
        this.rulesVisitedPerRuleCheck.clear();
        this.rulesVisitedPerRuleCheck.add(r12);
        check(this.g.getRule(r12.ruleIndex), r12, new HashSet());
        r11 = r11 + 1;
        goto L3
    L6:
        if (this.listOfRecursiveCycles.isEmpty() == true) goto L10;
        Grammar r13 = this.g;
        r13.tool.errMgr.leftRecursionCycles(r13.fileName, this.listOfRecursiveCycles);
        return;
    }

    public boolean check(Rule r10, ATNState r11, Set<ATNState> r12) {
        if ((r11 instanceof RuleStopState) == false) goto L6;
        return true;
    L6:
        int r5 = 0;
        if (r12.contains(r11) == false) goto L9;
        return false;
    L9:
        r12.add(r11);
        int r13 = r11.getNumberOfTransitions();
        boolean r14 = false;
    L10:
        if (r5 >= r13) goto L24;
        Transition r15 = r11.transition(r5);
        if ((r15 instanceof RuleTransition) == false) goto L20;
        RuleTransition r16 = (RuleTransition) r15;
        Rule r17 = this.g.getRule(r16.ruleIndex);
        if (this.rulesVisitedPerRuleCheck.contains((RuleStartState) r15.target) == false) goto L16;
        addRulesToCycle(r10, r17);
    L23:
        r5 = r5 + 1;
        goto L10
    L16:
        this.rulesVisitedPerRuleCheck.add((RuleStartState) r15.target);
        boolean r18 = check(r17, r15.target, new HashSet());
        this.rulesVisitedPerRuleCheck.remove((RuleStartState) r15.target);
        if (r18 == false) goto L23;
        boolean r19 = check(r10, r16.followState, r12);
    L22:
        r14 = r14 | r19;
        goto L23
    L20:
        if (r15.isEpsilon() == false) goto L23;
        r19 = check(r10, r15.target, r12);
        goto L22
    L24:
        return r14;
    }
}
