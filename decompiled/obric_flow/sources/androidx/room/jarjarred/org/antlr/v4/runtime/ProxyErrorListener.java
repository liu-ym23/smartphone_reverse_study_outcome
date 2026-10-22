package androidx.room.jarjarred.org.antlr.v4.runtime;

import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNConfigSet;
import androidx.room.jarjarred.org.antlr.v4.runtime.dfa.DFA;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ProxyErrorListener implements ANTLRErrorListener {
    private final Collection<? extends ANTLRErrorListener> delegates;

    public ProxyErrorListener(Collection<? extends ANTLRErrorListener> r5) {
        if (r5 == null) goto L7;
        this.delegates = r5;
        return;
    L7:
        throw new NullPointerException("delegates");
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ANTLRErrorListener
    public void reportAmbiguity(Parser r11, DFA r12, int r13, int r14, boolean r15, BitSet r16, ATNConfigSet r17) {
        Iterator<? extends ANTLRErrorListener> r5 = this.delegates.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().reportAmbiguity(r11, r12, r13, r14, r15, r16, r17);
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ANTLRErrorListener
    public void reportAttemptingFullContext(Parser r10, DFA r11, int r12, int r13, BitSet r14, ATNConfigSet r15) {
        Iterator<? extends ANTLRErrorListener> r16 = this.delegates.iterator();
    L4:
        if (r16.hasNext() == false) goto L6;
        r16.next().reportAttemptingFullContext(r10, r11, r12, r13, r14, r15);
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ANTLRErrorListener
    public void reportContextSensitivity(Parser r10, DFA r11, int r12, int r13, int r14, ATNConfigSet r15) {
        Iterator<? extends ANTLRErrorListener> r16 = this.delegates.iterator();
    L4:
        if (r16.hasNext() == false) goto L6;
        r16.next().reportContextSensitivity(r10, r11, r12, r13, r14, r15);
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.ANTLRErrorListener
    public void syntaxError(Recognizer<?, ?> r10, Object r11, int r12, int r13, String r14, RecognitionException r15) {
        Iterator<? extends ANTLRErrorListener> r16 = this.delegates.iterator();
    L4:
        if (r16.hasNext() == false) goto L6;
        r16.next().syntaxError(r10, r11, r12, r13, r14, r15);
        goto L4
    }
}
