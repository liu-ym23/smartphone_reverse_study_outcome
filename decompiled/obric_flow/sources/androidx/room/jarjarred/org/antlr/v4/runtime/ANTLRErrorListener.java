package androidx.room.jarjarred.org.antlr.v4.runtime;

import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNConfigSet;
import androidx.room.jarjarred.org.antlr.v4.runtime.dfa.DFA;
import java.util.BitSet;

/* JADX INFO: loaded from: classes.dex */
public interface ANTLRErrorListener {
    void reportAmbiguity(Parser r5, DFA r10, int r11, int r12, boolean r13, BitSet r14, ATNConfigSet r15);

    void reportAttemptingFullContext(Parser r5, DFA r10, int r11, int r12, BitSet r13, ATNConfigSet r14);

    void reportContextSensitivity(Parser r5, DFA r10, int r11, int r12, int r13, ATNConfigSet r14);

    void syntaxError(Recognizer<?, ?> r5, Object r10, int r11, int r12, String r13, RecognitionException r14);
}
