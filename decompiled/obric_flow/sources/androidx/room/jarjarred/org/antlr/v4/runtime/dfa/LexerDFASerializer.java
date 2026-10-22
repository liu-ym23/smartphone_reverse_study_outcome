package androidx.room.jarjarred.org.antlr.v4.runtime.dfa;

import androidx.room.jarjarred.org.antlr.v4.runtime.VocabularyImpl;

/* JADX INFO: loaded from: classes.dex */
public class LexerDFASerializer extends DFASerializer {
    public LexerDFASerializer(DFA r5) {
        super(r5, VocabularyImpl.EMPTY_VOCABULARY);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.dfa.DFASerializer
    public String getEdgeLabel(int r5) {
        StringBuilder r10 = new StringBuilder("'").appendCodePoint(r5);
        r10.append("'");
        return r10.toString();
    }
}
