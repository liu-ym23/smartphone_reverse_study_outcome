package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.MurmurHash;

/* JADX INFO: loaded from: classes.dex */
public class ATNConfig {
    private static final int SUPPRESS_PRECEDENCE_FILTER = 1073741824;
    public final int alt;
    public PredictionContext context;
    public int reachesIntoOuterContext;
    public final SemanticContext semanticContext;
    public final ATNState state;

    public ATNConfig(ATNConfig r5) {
        this.state = r5.state;
        this.alt = r5.alt;
        this.context = r5.context;
        this.semanticContext = r5.semanticContext;
        this.reachesIntoOuterContext = r5.reachesIntoOuterContext;
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof ATNConfig) == true) goto L7;
        return false;
    L7:
        return equals((ATNConfig) r5);
    }

    public final int getOuterContextDepth() {
        return this.reachesIntoOuterContext & (-1073741825);
    }

    public int hashCode() {
        return MurmurHash.finish(MurmurHash.update(MurmurHash.update(MurmurHash.update(MurmurHash.update(MurmurHash.initialize(7), this.state.stateNumber), this.alt), this.context), this.semanticContext), 4);
    }

    public final boolean isPrecedenceFilterSuppressed() {
        if ((this.reachesIntoOuterContext & 1073741824) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void setPrecedenceFilterSuppressed(boolean r5) {
        if (r5 == false) goto L4;
        this.reachesIntoOuterContext |= 1073741824;
        return;
    L4:
        this.reachesIntoOuterContext &= -1073741825;
    }

    public String toString() {
        return toString(null, true);
    }

    public String toString(Recognizer<?, ?> r5, boolean r10) {
        StringBuilder r11 = new StringBuilder("(");
        r11.append(this.state);
        if (r10 == false) goto L6;
        r11.append(",");
        r11.append(this.alt);
    L6:
        if (this.context == null) goto L8;
        r11.append(",[");
        r11.append(this.context.toString());
        r11.append("]");
    L8:
        SemanticContext r12 = this.semanticContext;
        if (r12 == null) goto L14;
        if (r12 == SemanticContext.NONE) goto L14;
        r11.append(",");
        r11.append(this.semanticContext);
    L14:
        if (getOuterContextDepth() <= 0) goto L16;
        r11.append(",up=");
        r11.append(getOuterContextDepth());
    L16:
        r11.append(')');
        return r11.toString();
    }

    public boolean equals(ATNConfig r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (this.state.stateNumber != r5.state.stateNumber) goto L23;
        if (this.alt != r5.alt) goto L23;
        PredictionContext r10 = this.context;
        PredictionContext r11 = r5.context;
        if (r10 == r11) goto L18;
        if (r10 == null) goto L23;
        if (r10.equals(r11) == false) goto L23;
    L18:
        if (this.semanticContext.equals(r5.semanticContext) == false) goto L23;
        if (isPrecedenceFilterSuppressed() != r5.isPrecedenceFilterSuppressed()) goto L23;
        return true;
    L23:
        return false;
    }

    public ATNConfig(ATNState r5, int r10, PredictionContext r11) {
        this(r5, r10, r11, SemanticContext.NONE);
    }

    public ATNConfig(ATNState r5, int r10, PredictionContext r11, SemanticContext r12) {
        this.state = r5;
        this.alt = r10;
        this.context = r11;
        this.semanticContext = r12;
    }

    public ATNConfig(ATNConfig r5, ATNState r10) {
        this(r5, r10, r5.context, r5.semanticContext);
    }

    public ATNConfig(ATNConfig r5, ATNState r10, SemanticContext r11) {
        this(r5, r10, r5.context, r11);
    }

    public ATNConfig(ATNConfig r5, SemanticContext r10) {
        this(r5, r5.state, r5.context, r10);
    }

    public ATNConfig(ATNConfig r5, ATNState r10, PredictionContext r11) {
        this(r5, r10, r11, r5.semanticContext);
    }

    public ATNConfig(ATNConfig r5, ATNState r10, PredictionContext r11, SemanticContext r12) {
        this.state = r10;
        this.alt = r5.alt;
        this.context = r11;
        this.semanticContext = r12;
        this.reachesIntoOuterContext = r5.reachesIntoOuterContext;
    }
}
