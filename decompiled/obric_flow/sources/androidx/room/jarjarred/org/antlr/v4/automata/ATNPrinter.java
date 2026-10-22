package androidx.room.jarjarred.org.antlr.v4.automata;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ActionTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.AtomTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.BlockEndState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.BlockStartState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.EpsilonTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.NotSetTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.PlusBlockStartState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.PlusLoopbackState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.RuleStartState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.RuleStopState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.RuleTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.SetTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.StarBlockStartState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.StarLoopEntryState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.StarLoopbackState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.writer.DaoWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ATNPrinter {
    Grammar g;
    Set<ATNState> marked;
    ATNState start;
    List<ATNState> work;

    public ATNPrinter(Grammar r5, ATNState r10) {
        this.g = r5;
        this.start = r10;
    }

    public String asString() {
        if (this.start != null) goto L6;
        return null;
    L6:
        this.marked = new HashSet();
        ArrayList r5 = new ArrayList();
        this.work = r5;
        r5.add(this.start);
        StringBuilder r10 = new StringBuilder();
    L8:
        if (this.work.isEmpty() == true) goto L47;
        int r11 = 0;
        ATNState r12 = this.work.remove(0);
        if (this.marked.contains(r12) == true) goto L8;
        int r13 = r12.getNumberOfTransitions();
        this.marked.add(r12);
    L13:
        if (r11 >= r13) goto L8;
        Transition r14 = r12.transition(r11);
        if ((r12 instanceof RuleStopState) == false) goto L17;
    L20:
        r10.append(getStateString(r12));
        if ((r14 instanceof EpsilonTransition) == false) goto L24;
        r10.append("->");
        r10.append(getStateString(r14.target));
        r10.append('\n');
    L45:
        r11 = r11 + 1;
        goto L13
    L24:
        if ((r14 instanceof RuleTransition) == false) goto L27;
        r10.append(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        r10.append(this.g.getRule(((RuleTransition) r14).ruleIndex).name);
        r10.append("->");
        r10.append(getStateString(r14.target));
        r10.append('\n');
        goto L45
    L27:
        if ((r14 instanceof ActionTransition) == false) goto L30;
        r10.append(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        r10.append(((ActionTransition) r14).toString());
        r10.append("->");
        r10.append(getStateString(r14.target));
        r10.append('\n');
        goto L45
    L30:
        if ((r14 instanceof SetTransition) == false) goto L42;
        SetTransition r15 = (SetTransition) r14;
        boolean r16 = r15 instanceof NotSetTransition;
        String r17 = "";
        if (this.g.isLexer() == false) goto L37;
        r10.append(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        if (r16 == false) goto L36;
        r17 = "~";
    L36:
        r10.append(r17);
        r10.append(r15.toString());
        r10.append("->");
        r10.append(getStateString(r14.target));
        r10.append('\n');
        goto L45
    L37:
        r10.append(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        if (r16 == false) goto L40;
        r17 = "~";
    L40:
        r10.append(r17);
        r10.append(r15.label().toString(this.g.getVocabulary()));
        r10.append("->");
        r10.append(getStateString(r14.target));
        r10.append('\n');
        goto L45
    L42:
        if ((r14 instanceof AtomTransition) == false) goto L44;
        String r18 = this.g.getTokenDisplayName(((AtomTransition) r14).label);
        r10.append(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        r10.append(r18);
        r10.append("->");
        r10.append(getStateString(r14.target));
        r10.append('\n');
        goto L45
    L44:
        r10.append(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        r10.append(r14.toString());
        r10.append("->");
        r10.append(getStateString(r14.target));
        r10.append('\n');
        goto L45
    L17:
        if ((r14 instanceof RuleTransition) == false) goto L19;
        this.work.add(((RuleTransition) r14).followState);
        goto L20
    L19:
        this.work.add(r14.target);
        goto L20
    L47:
        return r10.toString();
    }

    public String getStateString(ATNState r5) {
        int r10 = r5.stateNumber;
        String r11 = j0.g(r10, "s");
        if ((r5 instanceof StarBlockStartState) == false) goto L6;
        return j0.g(r10, "StarBlockStart_");
    L6:
        if ((r5 instanceof PlusBlockStartState) == false) goto L9;
        return j0.g(r10, "PlusBlockStart_");
    L9:
        if ((r5 instanceof BlockStartState) == false) goto L12;
        return j0.g(r10, "BlockStart_");
    L12:
        if ((r5 instanceof BlockEndState) == false) goto L15;
        return j0.g(r10, "BlockEnd_");
    L15:
        if ((r5 instanceof RuleStartState) == false) goto L18;
        return "RuleStart_" + this.g.getRule(r5.ruleIndex).name + "_" + r10;
    L18:
        if ((r5 instanceof RuleStopState) == false) goto L21;
        return "RuleStop_" + this.g.getRule(r5.ruleIndex).name + "_" + r10;
    L21:
        if ((r5 instanceof PlusLoopbackState) == false) goto L24;
        return j0.g(r10, "PlusLoopBack_");
    L24:
        if ((r5 instanceof StarLoopbackState) == false) goto L27;
        return j0.g(r10, "StarLoopBack_");
    L27:
        if ((r5 instanceof StarLoopEntryState) == true) goto L29;
        return r11;
    L29:
        return j0.g(r10, "StarLoopEntry_");
    }
}
