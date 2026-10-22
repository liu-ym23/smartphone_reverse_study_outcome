package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.runtime.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DecisionInfo {
    public long LL_ATNTransitions;
    public long LL_DFATransitions;
    public long LL_Fallback;
    public long LL_MaxLook;
    public LookaheadEventInfo LL_MaxLookEvent;
    public long LL_MinLook;
    public long LL_TotalLook;
    public long SLL_ATNTransitions;
    public long SLL_DFATransitions;
    public long SLL_MaxLook;
    public LookaheadEventInfo SLL_MaxLookEvent;
    public long SLL_MinLook;
    public long SLL_TotalLook;
    public final List<AmbiguityInfo> ambiguities;
    public final List<ContextSensitivityInfo> contextSensitivities;
    public final int decision;
    public final List<ErrorInfo> errors;
    public long invocations;
    public final List<PredicateEvalInfo> predicateEvals;
    public long timeInPrediction;

    public DecisionInfo(int r5) {
        this.contextSensitivities = new ArrayList();
        this.errors = new ArrayList();
        this.ambiguities = new ArrayList();
        this.predicateEvals = new ArrayList();
        this.decision = r5;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("{decision=");
        r5.append(this.decision);
        r5.append(", contextSensitivities=");
        r5.append(this.contextSensitivities.size());
        r5.append(", errors=");
        r5.append(this.errors.size());
        r5.append(", ambiguities=");
        r5.append(this.ambiguities.size());
        r5.append(", SLL_lookahead=");
        r5.append(this.SLL_TotalLook);
        r5.append(", SLL_ATNTransitions=");
        r5.append(this.SLL_ATNTransitions);
        r5.append(", SLL_DFATransitions=");
        r5.append(this.SLL_DFATransitions);
        r5.append(", LL_Fallback=");
        r5.append(this.LL_Fallback);
        r5.append(", LL_lookahead=");
        r5.append(this.LL_TotalLook);
        r5.append(", LL_ATNTransitions=");
        return a.t(r5, this.LL_ATNTransitions, '}');
    }
}
