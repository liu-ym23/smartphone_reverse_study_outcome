package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.dfa.DFA;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ParseInfo {
    protected final ProfilingATNSimulator atnSimulator;

    public ParseInfo(ProfilingATNSimulator r5) {
        this.atnSimulator = r5;
    }

    public int getDFASize() {
        DFA[] r5 = this.atnSimulator.decisionToDFA;
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r10 >= r5.length) goto L6;
        r11 = r11 + getDFASize(r10);
        r10 = r10 + 1;
        goto L4
    L6:
        return r11;
    }

    public DecisionInfo[] getDecisionInfo() {
        return this.atnSimulator.getDecisionInfo();
    }

    public List<Integer> getLLDecisions() {
        DecisionInfo[] r10 = this.atnSimulator.getDecisionInfo();
        ArrayList r5 = new ArrayList();
        int r11 = 0;
    L4:
        if (r11 >= r10.length) goto L9;
        if (r10[r11].LL_Fallback <= 0) goto L8;
        r5.add(Integer.valueOf(r11));
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        return r5;
    }

    public long getTotalATNLookaheadOps() {
        DecisionInfo[] r10 = this.atnSimulator.getDecisionInfo();
        long r5 = 0;
        int r11 = 0;
    L4:
        if (r11 >= r10.length) goto L6;
        DecisionInfo r12 = r10[r11];
        r5 = (r5 + r12.SLL_ATNTransitions) + r12.LL_ATNTransitions;
        r11 = r11 + 1;
        goto L4
    L6:
        return r5;
    }

    public long getTotalLLATNLookaheadOps() {
        DecisionInfo[] r5 = this.atnSimulator.getDecisionInfo();
        long r10 = 0;
        int r11 = 0;
    L4:
        if (r11 >= r5.length) goto L6;
        r10 = r10 + r5[r11].LL_ATNTransitions;
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    public long getTotalLLLookaheadOps() {
        DecisionInfo[] r5 = this.atnSimulator.getDecisionInfo();
        long r10 = 0;
        int r11 = 0;
    L4:
        if (r11 >= r5.length) goto L6;
        r10 = r10 + r5[r11].LL_TotalLook;
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    public long getTotalSLLATNLookaheadOps() {
        DecisionInfo[] r5 = this.atnSimulator.getDecisionInfo();
        long r10 = 0;
        int r11 = 0;
    L4:
        if (r11 >= r5.length) goto L6;
        r10 = r10 + r5[r11].SLL_ATNTransitions;
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    public long getTotalSLLLookaheadOps() {
        DecisionInfo[] r5 = this.atnSimulator.getDecisionInfo();
        long r10 = 0;
        int r11 = 0;
    L4:
        if (r11 >= r5.length) goto L6;
        r10 = r10 + r5[r11].SLL_TotalLook;
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    public long getTotalTimeInPrediction() {
        DecisionInfo[] r5 = this.atnSimulator.getDecisionInfo();
        long r10 = 0;
        int r11 = 0;
    L4:
        if (r11 >= r5.length) goto L6;
        r10 = r10 + r5[r11].timeInPrediction;
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    public int getDFASize(int r5) {
        return this.atnSimulator.decisionToDFA[r5].states.size();
    }
}
