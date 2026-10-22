package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.TokenStream;

/* JADX INFO: loaded from: classes.dex */
public class PredicateEvalInfo extends DecisionEventInfo {
    public final boolean evalResult;
    public final int predictedAlt;
    public final SemanticContext semctx;

    public PredicateEvalInfo(int r10, TokenStream r11, int r12, int r13, SemanticContext r14, boolean r15, int r16, boolean r17) {
        super(r10, new ATNConfigSet(), r11, r12, r13, r17);
        this.semctx = r14;
        this.evalResult = r15;
        this.predictedAlt = r16;
    }
}
