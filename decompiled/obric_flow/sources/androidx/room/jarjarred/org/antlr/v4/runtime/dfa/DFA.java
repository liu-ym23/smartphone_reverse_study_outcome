package androidx.room.jarjarred.org.antlr.v4.runtime.dfa;

import androidx.room.jarjarred.org.antlr.v4.runtime.Vocabulary;
import androidx.room.jarjarred.org.antlr.v4.runtime.VocabularyImpl;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNConfigSet;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.DecisionState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.StarLoopEntryState;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class DFA {
    public final DecisionState atnStartState;
    public final int decision;
    private final boolean precedenceDfa;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public volatile DFAState f662s0;
    public final Map<DFAState, DFAState> states;

    public DFA(DecisionState r5) {
        this(r5, 0);
    }

    public final DFAState getPrecedenceStartState(int r5) {
        if (isPrecedenceDfa() == false) goto L13;
        if (r5 >= 0) goto L6;
        return null;
    L6:
        if (r5 < this.f662s0.edges.length) goto L9;
        return null;
    L9:
        return this.f662s0.edges[r5];
    L13:
        throw new IllegalStateException("Only precedence DFAs may contain a precedence start state.");
    }

    public List<DFAState> getStates() {
        ArrayList r5 = new ArrayList(this.states.keySet());
        Collections.sort(r5, new AnonymousClass1(this));
        return r5;
    }

    public final boolean isPrecedenceDfa() {
        return this.precedenceDfa;
    }

    @Deprecated
    public final void setPrecedenceDfa(boolean r5) {
        if (r5 != isPrecedenceDfa()) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException("The precedenceDfa field cannot change after a DFA is constructed.");
    }

    public final void setPrecedenceStartState(int r5, DFAState r10) {
        if (isPrecedenceDfa() == false) goto L19;
        if (r5 >= 0) goto L6;
        return;
    L6:
        DFAState r11 = this.f662s0;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L9:
        if (r5 < this.f662s0.edges.length) goto L13;
        DFAState r12 = this.f662s0;     // Catch: Throwable -> L11
        r12.edges = (DFAState[]) Arrays.copyOf(this.f662s0.edges, r5 + 1);     // Catch: Throwable -> L11
    L13:
        this.f662s0.edges[r5] = r10;     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L19:
        throw new IllegalStateException("Only precedence DFAs may contain a precedence start state.");
    }

    public String toLexerString() {
        if (this.f662s0 != null) goto L7;
        return "";
    L7:
        return new LexerDFASerializer(this).toString();
    }

    public String toString() {
        return toString(VocabularyImpl.EMPTY_VOCABULARY);
    }

    public DFA(DecisionState r5, int r10) {
        this.states = new HashMap();
        this.atnStartState = r5;
        this.decision = r10;
        boolean r11 = false;
        if ((r5 instanceof StarLoopEntryState) == true) goto L5;
    L7:
        this.precedenceDfa = r11;
        return;
    L5:
        if (((StarLoopEntryState) r5).isPrecedenceDecision == false) goto L7;
        DFAState r12 = new DFAState(new ATNConfigSet());
        r12.edges = new DFAState[0];
        r12.isAcceptState = false;
        r12.requiresFullContext = false;
        this.f662s0 = r12;
        r11 = true;
        goto L7
    }

    @Deprecated
    public String toString(String[] r5) {
        if (this.f662s0 != null) goto L7;
        return "";
    L7:
        return new DFASerializer(this, r5).toString();
    }

    public String toString(Vocabulary r5) {
        if (this.f662s0 != null) goto L7;
        return "";
    L7:
        return new DFASerializer(this, r5).toString();
    }
}
