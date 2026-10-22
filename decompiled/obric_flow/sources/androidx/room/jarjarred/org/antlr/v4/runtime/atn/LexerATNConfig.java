package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.MurmurHash;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.ObjectEqualityComparator;

/* JADX INFO: loaded from: classes.dex */
public class LexerATNConfig extends ATNConfig {
    private final LexerActionExecutor lexerActionExecutor;
    private final boolean passedThroughNonGreedyDecision;

    public LexerATNConfig(ATNState r5, int r10, PredictionContext r11) {
        super(r5, r10, r11, SemanticContext.NONE);
        this.passedThroughNonGreedyDecision = false;
        this.lexerActionExecutor = null;
    }

    private static boolean checkNonGreedyDecision(LexerATNConfig r5, ATNState r10) {
        if (r5.passedThroughNonGreedyDecision == false) goto L5;
    L10:
        return true;
    L5:
        if ((r10 instanceof DecisionState) == true) goto L7;
    L9:
        return false;
    L7:
        if (((DecisionState) r10).nonGreedy == false) goto L9;
        goto L9
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNConfig
    public boolean equals(ATNConfig r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LexerATNConfig) == true) goto L8;
        return false;
    L8:
        LexerATNConfig r10 = (LexerATNConfig) r5;
        if (this.passedThroughNonGreedyDecision == r10.passedThroughNonGreedyDecision) goto L12;
        return false;
    L12:
        if (ObjectEqualityComparator.INSTANCE.equals(this.lexerActionExecutor, r10.lexerActionExecutor) == true) goto L15;
        return false;
    L15:
        return super.equals(r5);
    }

    public final LexerActionExecutor getLexerActionExecutor() {
        return this.lexerActionExecutor;
    }

    public final boolean hasPassedThroughNonGreedyDecision() {
        return this.passedThroughNonGreedyDecision;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNConfig
    public int hashCode() {
        return MurmurHash.finish(MurmurHash.update(MurmurHash.update(MurmurHash.update(MurmurHash.update(MurmurHash.update(MurmurHash.update(MurmurHash.initialize(7), this.state.stateNumber), this.alt), this.context), this.semanticContext), this.passedThroughNonGreedyDecision ? 1 : 0), this.lexerActionExecutor), 6);
    }

    public LexerATNConfig(ATNState r5, int r10, PredictionContext r11, LexerActionExecutor r12) {
        super(r5, r10, r11, SemanticContext.NONE);
        this.lexerActionExecutor = r12;
        this.passedThroughNonGreedyDecision = false;
    }

    public LexerATNConfig(LexerATNConfig r5, ATNState r10) {
        super(r5, r10, r5.context, r5.semanticContext);
        this.lexerActionExecutor = r5.lexerActionExecutor;
        this.passedThroughNonGreedyDecision = checkNonGreedyDecision(r5, r10);
    }

    public LexerATNConfig(LexerATNConfig r5, ATNState r10, LexerActionExecutor r11) {
        super(r5, r10, r5.context, r5.semanticContext);
        this.lexerActionExecutor = r11;
        this.passedThroughNonGreedyDecision = checkNonGreedyDecision(r5, r10);
    }

    public LexerATNConfig(LexerATNConfig r5, ATNState r10, PredictionContext r11) {
        super(r5, r10, r11, r5.semanticContext);
        this.lexerActionExecutor = r5.lexerActionExecutor;
        this.passedThroughNonGreedyDecision = checkNonGreedyDecision(r5, r10);
    }
}
