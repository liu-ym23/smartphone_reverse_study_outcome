package androidx.room.jarjarred.org.antlr.v4.runtime.dfa;

import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNConfig;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNConfigSet;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerActionExecutor;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.SemanticContext;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.MurmurHash;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class DFAState {
    public ATNConfigSet configs;
    public DFAState[] edges;
    public boolean isAcceptState;
    public LexerActionExecutor lexerActionExecutor;
    public PredPrediction[] predicates;
    public int prediction;
    public boolean requiresFullContext;
    public int stateNumber;

    public static class PredPrediction {
        public int alt;
        public SemanticContext pred;

        public PredPrediction(SemanticContext r5, int r10) {
            this.alt = r10;
            this.pred = r5;
        }

        public String toString() {
            StringBuilder r5 = new StringBuilder("(");
            r5.append(this.pred);
            r5.append(", ");
            return a.s(r5, this.alt, ")");
        }
    }

    public DFAState() {
        this.stateNumber = -1;
        this.configs = new ATNConfigSet();
        this.isAcceptState = false;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DFAState) == true) goto L10;
        return false;
    L10:
        return this.configs.equals(((DFAState) r5).configs);
    }

    public Set<Integer> getAltSet() {
        HashSet r5 = new HashSet();
        ATNConfigSet r10 = this.configs;
        if (r10 == null) goto L9;
        Iterator<ATNConfig> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L9;
        r5.add(Integer.valueOf(r11.next().alt));
    L9:
        if (r5.isEmpty() == false) goto L12;
        return null;
    L12:
        return r5;
    }

    public int hashCode() {
        return MurmurHash.finish(MurmurHash.update(MurmurHash.initialize(7), this.configs.hashCode()), 1);
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(this.stateNumber);
        r5.append(":");
        r5.append(this.configs);
        if (this.isAcceptState == false) goto L9;
        r5.append("=>");
        PredPrediction[] r10 = this.predicates;
        if (r10 == null) goto L7;
        r5.append(Arrays.toString(r10));
        goto L9
    L7:
        r5.append(this.prediction);
    L9:
        return r5.toString();
    }

    public DFAState(int r5) {
        this.stateNumber = -1;
        this.configs = new ATNConfigSet();
        this.isAcceptState = false;
        this.stateNumber = r5;
    }

    public DFAState(ATNConfigSet r5) {
        this.stateNumber = -1;
        new ATNConfigSet();
        this.isAcceptState = false;
        this.configs = r5;
    }
}
