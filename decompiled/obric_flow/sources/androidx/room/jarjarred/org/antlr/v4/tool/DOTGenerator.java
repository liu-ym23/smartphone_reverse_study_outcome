package androidx.room.jarjarred.org.antlr.v4.tool;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.room.jarjarred.org.antlr.v4.misc.Utils;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNConfig;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNConfigSet;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.AbstractPredicateTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ActionTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.AtomTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.BlockEndState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.BlockStartState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.DecisionState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.NotSetTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.PlusBlockStartState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.PlusLoopbackState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.RangeTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.RuleStartState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.RuleStopState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.RuleTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.SetTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.StarBlockStartState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.StarLoopEntryState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.StarLoopbackState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition;
import androidx.room.jarjarred.org.antlr.v4.runtime.dfa.DFA;
import androidx.room.jarjarred.org.antlr.v4.runtime.dfa.DFAState;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntegerList;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroupFile;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class DOTGenerator {
    public static final boolean STRIP_NONREDUCED_STATES = false;
    public static STGroup stlib;
    protected String arrowhead;
    protected Grammar grammar;
    protected String rankdir;

    static {
        stlib = new STGroupFile("androidx/room/jarjarred/org/antlr/v4/tool/templates/dot/graphs.stg");
    }

    public DOTGenerator(Grammar r5) {
        this.arrowhead = "normal";
        this.rankdir = "LR";
        this.grammar = r5;
    }

    public String getDOT(DFA r11, boolean r12) {
        if (r11.f662s0 != null) goto L6;
        return null;
    L6:
        ST r5 = stlib.getInstanceOf("dfa");
        r5.add("name", "DFA" + r11.decision);
        r5.add("startState", Integer.valueOf(r11.f662s0.stateNumber));
        r5.add("rankdir", this.rankdir);
        Iterator<DFAState> r10 = r11.states.keySet().iterator();
    L8:
        if (r10.hasNext() == false) goto L13;
        DFAState r13 = r10.next();
        if (r13.isAcceptState == false) goto L8;
        ST r14 = stlib.getInstanceOf("stopstate");
        r14.add("name", "s" + r13.stateNumber);
        r14.add("label", getStateLabel(r13));
        r5.add("states", r14);
        goto L8
    L13:
        Iterator<DFAState> r15 = r11.states.keySet().iterator();
    L15:
        if (r15.hasNext() == false) goto L23;
        DFAState r16 = r15.next();
        if (r16.isAcceptState == true) goto L15;
        if (r16.stateNumber == Integer.MAX_VALUE) goto L15;
        ST r17 = stlib.getInstanceOf("state");
        r17.add("name", "s" + r16.stateNumber);
        r17.add("label", getStateLabel(r16));
        r5.add("states", r17);
        goto L15
    L23:
        Iterator<DFAState> r18 = r11.states.keySet().iterator();
    L25:
        if (r18.hasNext() == false) goto L46;
        DFAState r19 = r18.next();
        if (r19.edges == null) goto L25;
        int r20 = 0;
    L29:
        DFAState[] r21 = r19.edges;
        if (r20 >= r21.length) goto L25;
        DFAState r22 = r21[r20];
        if (r22 == null) goto L44;
        if (r22.stateNumber == Integer.MAX_VALUE) goto L44;
        int r23 = r20 - 1;
        String r24 = String.valueOf(r23);
        if (r12 == false) goto L40;
        r24 = "'" + getEdgeLabel(new StringBuilder().appendCodePoint(r20).toString()) + "'";
    L43:
        ST r25 = stlib.getInstanceOf("edge");
        r25.add("label", r24);
        r25.add("src", "s" + r19.stateNumber);
        r25.add("target", "s" + r22.stateNumber);
        r25.add("arrowhead", this.arrowhead);
        r5.add("edges", r25);
        goto L44
    L40:
        Grammar r26 = this.grammar;
        if (r26 == null) goto L43;
        r24 = r26.getTokenDisplayName(r23);
    L44:
        r20 = r20 + 1;
        goto L29
    L46:
        return Utils.sortLinesInString(r5.render());
    }

    public String getEdgeLabel(String r5) {
        return r5.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\\\n").replace("\r", "");
    }

    public String getStateLabel(DFAState r10) {
        if (r10 != null) goto L5;
        return "null";
    L5:
        StringBuilder r5 = new StringBuilder(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        r5.append('s');
        r5.append(r10.stateNumber);
        if (r10.isAcceptState == false) goto L9;
        r5.append("=>");
        r5.append(r10.prediction);
    L9:
        if (r10.requiresFullContext == false) goto L12;
        r5.append("^");
    L12:
        if (this.grammar == null) goto L42;
        Set<Integer> r11 = r10.getAltSet();
        if (r11 == null) goto L42;
        r5.append("\\n");
        IntegerList r12 = new IntegerList();
        r12.addAll(r11);
        r12.sort();
        ATNConfigSet r13 = r10.configs;
        int r14 = 0;
    L17:
        if (r14 >= r12.size()) goto L42;
        int r15 = r12.get(r14);
        if (r14 <= 0) goto L21;
        r5.append("\\n");
    L21:
        r5.append("alt");
        r5.append(r15);
        r5.append(':');
        ArrayList r16 = new ArrayList();
        Iterator<ATNConfig> r17 = r13.iterator();
    L23:
        if (r17.hasNext() == false) goto L28;
        ATNConfig r18 = r17.next();
        if (r18.alt != r15) goto L23;
        r16.add(r18);
        goto L23
    L28:
        int r19 = 0;
        int r20 = 0;
    L30:
        if (r19 >= r16.size()) goto L40;
        r20 = r20 + 1;
        r5.append(((ATNConfig) r16.get(r19)).toString(null, false));
        int r21 = r19 + 1;
        if (r21 >= r16.size()) goto L35;
        r5.append(", ");
    L35:
        if ((r20 % 5) != 0) goto L39;
        if ((r16.size() - r19) <= 3) goto L39;
        r5.append("\\n");
    L39:
        r19 = r21;
        goto L30
    L40:
        r14 = r14 + 1;
    L42:
        return r5.toString();
    }

    public String getStateLabel(ATNState r5) {
        if (r5 != null) goto L6;
        return "null";
    L6:
        if ((r5 instanceof BlockStartState) == false) goto L9;
        String r10 = "&rarr;\\n";
    L12:
        StringBuilder r11 = j0.u(r10);
        r11.append(String.valueOf(r5.stateNumber));
        String r12 = r11.toString();
        if ((r5 instanceof PlusBlockStartState) == false) goto L15;
    L24:
        r12 = j0.j(r12, "+");
    L26:
        if ((r5 instanceof DecisionState) == false) goto L31;
        DecisionState r13 = (DecisionState) r5;
        if (r13.decision < 0) goto L32;
        StringBuilder r14 = j0.w(r12, "\\nd=");
        r14.append(r13.decision);
        return r14.toString();
    L32:
        return r12;
    L31:
        return r12;
    L15:
        if ((r5 instanceof PlusLoopbackState) == true) goto L24;
        if ((r5 instanceof StarBlockStartState) == false) goto L20;
    L23:
        r12 = j0.j(r12, XPath.WILDCARD);
        goto L26
    L20:
        if ((r5 instanceof StarLoopEntryState) == true) goto L23;
        if ((r5 instanceof StarLoopbackState) == false) goto L26;
    L9:
        if ((r5 instanceof BlockEndState) == false) goto L11;
        r10 = "&larr;\\n";
        goto L12
    L11:
        r10 = "";
        goto L12
    }

    public String getDOT(ATNState r5) {
        return getDOT(r5, false);
    }

    public String getDOT(ATNState r10, boolean r11) {
        Set<String> r5 = this.grammar.rules.keySet();
        String[] r12 = new String[r5.size() + 1];
        Iterator<String> r13 = r5.iterator();
        int r14 = 0;
    L4:
        if (r13.hasNext() == false) goto L7;
        r12[r14] = r13.next();
        r14 = r14 + 1;
        goto L4
    L7:
        return getDOT(r10, r12, r11);
    }

    public String getDOT(ATNState r19, String[] r20, boolean r21) {
        if (r19 != null) goto L6;
        return null;
    L6:
        HashSet r5 = new HashSet();
        ST r10 = stlib.getInstanceOf("atn");
        r10.add("startState", Integer.valueOf(r19.stateNumber));
        r10.add("rankdir", this.rankdir);
        LinkedList r11 = new LinkedList();
        r11.add(r19);
    L8:
        if (r11.isEmpty() == true) goto L80;
        ATNState r12 = (ATNState) r11.get(0);
        if (r5.contains(r12) == true) goto L11;
        r5.add(r12);
        if ((r12 instanceof RuleStopState) == true) goto L8;
        int r13 = 0;
    L17:
        if (r13 >= r12.getNumberOfTransitions()) goto L8;
        Transition r14 = r12.transition(r13);
        if ((r14 instanceof RuleTransition) == false) goto L25;
        RuleTransition r15 = (RuleTransition) r14;
        ST r16 = stlib.getInstanceOf("edge");
        String r17 = "<" + r20[r15.ruleIndex];
        if (((RuleStartState) r15.target).isLeftRecursiveRule == false) goto L24;
        r17 = a.s(j0.w(r17, "["), r15.precedence, "]");
    L24:
        r16.add("label", r17 + ">");
        StringBuilder r18 = new StringBuilder("s");
        r18.append(r12.stateNumber);
        r16.add("src", r18.toString());
        r16.add("target", "s" + r15.followState.stateNumber);
        r16.add("arrowhead", this.arrowhead);
        r10.add("edges", r16);
        r11.add(r15.followState);
        LinkedList r22 = r11;
    L78:
        r13 = r13 + 1;
        r11 = r22;
        r5 = r5;
        goto L17
    L25:
        r5 = r5;
        if ((r14 instanceof ActionTransition) == false) goto L30;
        ST r23 = stlib.getInstanceOf("action-edge");
        r23.add("label", getEdgeLabel(r14.toString()));
    L28:
        LinkedList r110 = r11;
    L73:
        r23.add("src", "s" + r12.stateNumber);
        r23.add("target", "s" + r14.target.stateNumber);
        r23.add("arrowhead", this.arrowhead);
        if (r12.getNumberOfTransitions() <= 1) goto L76;
        r23.add("transitionIndex", Integer.valueOf(r13));
    L77:
        r10.add("edges", r23);
        r22 = r110;
        r22.add(r14.target);
        goto L78
    L76:
        r23.add("transitionIndex", Boolean.FALSE);
        goto L77
    L30:
        if ((r14 instanceof AbstractPredicateTransition) == false) goto L33;
        r23 = stlib.getInstanceOf("edge");
        r23.add("label", getEdgeLabel(r14.toString()));
        goto L28
    L33:
        if (r14.isEpsilon() == false) goto L43;
        r23 = stlib.getInstanceOf("epsilon-edge");
        r23.add("label", getEdgeLabel(r14.toString()));
        ATNState r111 = r14.target;
        if ((r111 instanceof PlusBlockStartState) == false) goto L38;
        boolean r112 = r12.equals(((PlusBlockStartState) r111).loopBackState);
    L41:
        r23.add("loopback", Boolean.valueOf(r112));
        goto L28
    L38:
        if ((r111 instanceof StarLoopEntryState) == false) goto L40;
        r112 = r12.equals(((StarLoopEntryState) r111).loopBackState);
        goto L41
    L40:
        r112 = false;
        goto L41
    L43:
        if ((r14 instanceof AtomTransition) == false) goto L51;
        r23 = stlib.getInstanceOf("edge");
        AtomTransition r113 = (AtomTransition) r14;
        String r114 = String.valueOf(r113.label);
        if (r21 == false) goto L47;
        StringBuilder r115 = new StringBuilder("'");
        r110 = r11;
        r115.append(getEdgeLabel(new StringBuilder().appendCodePoint(r113.label).toString()));
        r115.append("'");
        r114 = r115.toString();
    L50:
        r23.add("label", getEdgeLabel(r114));
        goto L73
    L47:
        r110 = r11;
        Grammar r24 = this.grammar;
        if (r24 == null) goto L50;
        r114 = r24.getTokenDisplayName(r113.label);
        goto L50
    L51:
        r110 = r11;
        if ((r14 instanceof SetTransition) == false) goto L64;
        r23 = stlib.getInstanceOf("edge");
        SetTransition r25 = (SetTransition) r14;
        String r26 = r25.label().toString();
        if (r21 == false) goto L57;
        r26 = r25.label().toString(true);
    L60:
        if ((r14 instanceof NotSetTransition) == false) goto L62;
        r26 = j0.C("~", r26);
    L62:
        r23.add("label", getEdgeLabel(r26));
        goto L73
    L57:
        if (this.grammar == null) goto L60;
        r26 = r25.label().toString(this.grammar.getVocabulary());
        goto L60
    L64:
        if ((r14 instanceof RangeTransition) == false) goto L72;
        r23 = stlib.getInstanceOf("edge");
        RangeTransition r27 = (RangeTransition) r14;
        String r28 = r27.label().toString();
        if (r21 == false) goto L69;
        r28 = r27.toString();
    L71:
        r23.add("label", getEdgeLabel(r28));
        goto L73
    L69:
        if (this.grammar == null) goto L71;
        r28 = r27.label().toString(this.grammar.getVocabulary());
        goto L71
    L72:
        r23 = stlib.getInstanceOf("edge");
        r23.add("label", getEdgeLabel(r14.toString()));
        goto L73
    L11:
        r11.remove(0);
        goto L8
    L80:
        HashSet r116 = r5;
        Iterator r29 = r116.iterator();
    L82:
        if (r29.hasNext() == false) goto L87;
        ATNState r30 = (ATNState) r29.next();
        if ((r30 instanceof RuleStopState) == false) goto L82;
        ST r31 = stlib.getInstanceOf("stopstate");
        r31.add("name", "s" + r30.stateNumber);
        r31.add("label", getStateLabel(r30));
        r10.add("states", r31);
        goto L82
    L87:
        Iterator r32 = r116.iterator();
    L89:
        if (r32.hasNext() == false) goto L95;
        ATNState r33 = (ATNState) r32.next();
        if ((r33 instanceof RuleStopState) == true) goto L89;
        ST r34 = stlib.getInstanceOf("state");
        r34.add("name", "s" + r33.stateNumber);
        r34.add("label", getStateLabel(r33));
        r34.add("transitions", r33.getTransitions());
        r10.add("states", r34);
        goto L89
    L95:
        return r10.render();
    }
}
