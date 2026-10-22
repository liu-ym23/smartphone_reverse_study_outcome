package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class ATNState {
    public static final int BASIC = 1;
    public static final int BLOCK_END = 8;
    public static final int BLOCK_START = 3;
    public static final int INITIAL_NUM_TRANSITIONS = 4;
    public static final int INVALID_STATE_NUMBER = -1;
    public static final int INVALID_TYPE = 0;
    public static final int LOOP_END = 12;
    public static final int PLUS_BLOCK_START = 4;
    public static final int PLUS_LOOP_BACK = 11;
    public static final int RULE_START = 2;
    public static final int RULE_STOP = 7;
    public static final int STAR_BLOCK_START = 5;
    public static final int STAR_LOOP_BACK = 9;
    public static final int STAR_LOOP_ENTRY = 10;
    public static final int TOKEN_START = 6;
    public static final List<String> serializationNames = null;
    public ATN atn;
    public boolean epsilonOnlyTransitions;
    public IntervalSet nextTokenWithinRule;
    public int ruleIndex;
    public int stateNumber;
    protected final List<Transition> transitions;

    static {
        serializationNames = Collections.unmodifiableList(Arrays.asList(new String[]{"INVALID", "BASIC", "RULE_START", "BLOCK_START", "PLUS_BLOCK_START", "STAR_BLOCK_START", "TOKEN_START", "RULE_STOP", "BLOCK_END", "STAR_LOOP_BACK", "STAR_LOOP_ENTRY", "PLUS_LOOP_BACK", "LOOP_END"}));
    }

    public ATNState() {
        this.atn = null;
        this.stateNumber = -1;
        this.epsilonOnlyTransitions = false;
        this.transitions = new ArrayList(4);
    }

    public void addTransition(Transition r5) {
        addTransition(this.transitions.size(), r5);
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof ATNState) == true) goto L5;
        return false;
    L5:
        if (this.stateNumber != ((ATNState) r5).stateNumber) goto L9;
        return true;
    L9:
        return false;
    }

    public int getNumberOfTransitions() {
        return this.transitions.size();
    }

    public abstract int getStateType();

    public Transition[] getTransitions() {
        List<Transition> r5 = this.transitions;
        return (Transition[]) r5.toArray(new Transition[r5.size()]);
    }

    public int hashCode() {
        return this.stateNumber;
    }

    public boolean isNonGreedyExitState() {
        return false;
    }

    public final boolean onlyHasEpsilonTransitions() {
        return this.epsilonOnlyTransitions;
    }

    public Transition removeTransition(int r5) {
        return this.transitions.remove(r5);
    }

    public void setRuleIndex(int r5) {
        this.ruleIndex = r5;
    }

    public void setTransition(int r5, Transition r10) {
        this.transitions.set(r5, r10);
    }

    public String toString() {
        return String.valueOf(this.stateNumber);
    }

    public Transition transition(int r5) {
        return this.transitions.get(r5);
    }

    public void addTransition(int r5, Transition r10) {
        if (this.transitions.isEmpty() == false) goto L6;
        this.epsilonOnlyTransitions = r10.isEpsilon();
    L8:
        Iterator<Transition> r11 = this.transitions.iterator();
    L10:
        if (r11.hasNext() == false) goto L25;
        Transition r12 = r11.next();
        if (r12.target.stateNumber != r10.target.stateNumber) goto L10;
        if (r12.label() == null) goto L21;
        if (r10.label() == null) goto L21;
        if (r12.label().equals(r10.label()) == false) goto L21;
        return;
    L21:
        if (r12.isEpsilon() == false) goto L10;
        if (r10.isEpsilon() == false) goto L10;
        return;
    L25:
        this.transitions.add(r5, r10);
        return;
    L6:
        if (this.epsilonOnlyTransitions == r10.isEpsilon()) goto L8;
        System.err.format(Locale.getDefault(), "ATN state %d has both epsilon and non-epsilon transitions.\n", new Object[]{Integer.valueOf(this.stateNumber)});
        this.epsilonOnlyTransitions = false;
        goto L8
    }
}
