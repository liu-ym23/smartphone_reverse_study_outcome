package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.TokenStream;

/* JADX INFO: loaded from: classes.dex */
public class DecisionEventInfo {
    public final ATNConfigSet configs;
    public final int decision;
    public final boolean fullCtx;
    public final TokenStream input;
    public final int startIndex;
    public final int stopIndex;

    public DecisionEventInfo(int r5, ATNConfigSet r10, TokenStream r11, int r12, int r13, boolean r14) {
        this.decision = r5;
        this.fullCtx = r14;
        this.stopIndex = r13;
        this.input = r11;
        this.startIndex = r12;
        this.configs = r10;
    }
}
