package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.TokenStream;

/* JADX INFO: loaded from: classes.dex */
public class LookaheadEventInfo extends DecisionEventInfo {
    public int predictedAlt;

    public LookaheadEventInfo(int r10, ATNConfigSet r11, int r12, TokenStream r13, int r14, int r15, boolean r16) {
        super(r10, r11, r13, r14, r15, r16);
        this.predictedAlt = r12;
    }
}
