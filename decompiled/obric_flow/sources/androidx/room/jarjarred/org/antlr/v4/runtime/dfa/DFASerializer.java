package androidx.room.jarjarred.org.antlr.v4.runtime.dfa;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.runtime.Vocabulary;
import androidx.room.jarjarred.org.antlr.v4.runtime.VocabularyImpl;
import androidx.room.writer.DaoWriter;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class DFASerializer {
    private final DFA dfa;
    private final Vocabulary vocabulary;

    @Deprecated
    public DFASerializer(DFA r5, String[] r10) {
        this(r5, VocabularyImpl.fromTokenNames(r10));
    }

    public String getEdgeLabel(int r5) {
        return this.vocabulary.getDisplayName(r5 - 1);
    }

    public String getStateString(DFAState r5) {
        int r10 = r5.stateNumber;
        StringBuilder r11 = new StringBuilder();
        String r12 = "";
        if (r5.isAcceptState == false) goto L5;
        String r13 = ":";
    L6:
        r11.append(r13);
        r11.append("s");
        r11.append(r10);
        if (r5.requiresFullContext == false) goto L9;
        r12 = "^";
    L9:
        r11.append(r12);
        String r14 = r11.toString();
        if (r5.isAcceptState == true) goto L12;
        return r14;
    L12:
        if (r5.predicates == null) goto L15;
        StringBuilder r15 = j0.w(r14, "=>");
        r15.append(Arrays.toString(r5.predicates));
        return r15.toString();
    L15:
        StringBuilder r16 = j0.w(r14, "=>");
        r16.append(r5.prediction);
        return r16.toString();
    L5:
        r13 = "";
        goto L6
    }

    public String toString() {
        if (this.dfa.f662s0 != null) goto L5;
        return null;
    L5:
        StringBuilder r5 = new StringBuilder();
        Iterator<DFAState> r10 = this.dfa.getStates().iterator();
    L7:
        if (r10.hasNext() == false) goto L19;
        DFAState r11 = r10.next();
        DFAState[] r12 = r11.edges;
        int r13 = 0;
        if (r12 == null) goto L11;
        int r14 = r12.length;
    L12:
        if (r13 >= r14) goto L7;
        DFAState r15 = r11.edges[r13];
        if (r15 != null) goto L16;
    L18:
        r13 = r13 + 1;
        goto L12
    L16:
        if (r15.stateNumber == Integer.MAX_VALUE) goto L18;
        r5.append(getStateString(r11));
        String r16 = getEdgeLabel(r13);
        r5.append(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        r5.append(r16);
        r5.append("->");
        r5.append(getStateString(r15));
        r5.append('\n');
        goto L18
    L11:
        r14 = 0;
        goto L12
    L19:
        String r17 = r5.toString();
        if (r17.length() != 0) goto L22;
        return null;
    L22:
        return r17;
    }

    public DFASerializer(DFA r5, Vocabulary r10) {
        this.dfa = r5;
        this.vocabulary = r10;
    }
}
