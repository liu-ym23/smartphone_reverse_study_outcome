package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.TokenStream;
import java.util.BitSet;

/* JADX INFO: loaded from: classes.dex */
public class AmbiguityInfo extends DecisionEventInfo {
    public BitSet ambigAlts;

    public AmbiguityInfo(int r10, ATNConfigSet r11, BitSet r12, TokenStream r13, int r14, int r15, boolean r16) {
        super(r10, r11, r13, r14, r15, r16);
        this.ambigAlts = r12;
    }
}
