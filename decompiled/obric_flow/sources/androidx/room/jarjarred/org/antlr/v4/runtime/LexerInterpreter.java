package androidx.room.jarjarred.org.antlr.v4.runtime;

import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATN;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNType;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerATNSimulator;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.PredictionContextCache;
import androidx.room.jarjarred.org.antlr.v4.runtime.dfa.DFA;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public class LexerInterpreter extends Lexer {
    protected final DFA[] _decisionToDFA;
    protected final PredictionContextCache _sharedContextCache;
    protected final ATN atn;
    protected final String[] channelNames;
    protected final String grammarFileName;
    protected final String[] modeNames;
    protected final String[] ruleNames;

    @Deprecated
    protected final String[] tokenNames;
    private final Vocabulary vocabulary;

    @Deprecated
    public LexerInterpreter(String r10, Collection<String> r11, Collection<String> r12, Collection<String> r13, ATN r14, CharStream r15) {
        this(r10, VocabularyImpl.fromTokenNames((String[]) r11.toArray(new String[r11.size()])), r12, new ArrayList(), r13, r14, r15);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer
    public ATN getATN() {
        return this.atn;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Lexer
    public String[] getChannelNames() {
        return this.channelNames;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer
    public String getGrammarFileName() {
        return this.grammarFileName;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Lexer
    public String[] getModeNames() {
        return this.modeNames;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer
    public String[] getRuleNames() {
        return this.ruleNames;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Lexer, androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer
    @Deprecated
    public String[] getTokenNames() {
        return this.tokenNames;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer
    public Vocabulary getVocabulary() {
        Vocabulary r5 = this.vocabulary;
        if (r5 == null) goto L6;
        return r5;
    L6:
        return super.getVocabulary();
    }

    @Deprecated
    public LexerInterpreter(String r10, Vocabulary r11, Collection<String> r12, Collection<String> r13, ATN r14, CharStream r15) {
        this(r10, r11, r12, new ArrayList(), r13, r14, r15);
    }

    public LexerInterpreter(String r5, Vocabulary r10, Collection<String> r11, Collection<String> r12, Collection<String> r13, ATN r14, CharStream r15) {
        super(r15);
        this._sharedContextCache = new PredictionContextCache();
        if (r14.grammarType != ATNType.LEXER) goto L15;
        this.grammarFileName = r5;
        this.atn = r14;
        this.tokenNames = new String[r14.maxTokenType];
        int r16 = 0;
        int r17 = 0;
    L5:
        String[] r18 = this.tokenNames;
        if (r17 >= r18.length) goto L8;
        r18[r17] = r10.getDisplayName(r17);
        r17 = r17 + 1;
        goto L5
    L8:
        this.ruleNames = (String[]) r11.toArray(new String[r11.size()]);
        this.channelNames = (String[]) r12.toArray(new String[r12.size()]);
        this.modeNames = (String[]) r13.toArray(new String[r13.size()]);
        this.vocabulary = r10;
        this._decisionToDFA = new DFA[r14.getNumberOfDecisions()];
    L9:
        DFA[] r19 = this._decisionToDFA;
        if (r16 >= r19.length) goto L12;
        r19[r16] = new DFA(r14.getDecisionState(r16), r16);
        r16 = r16 + 1;
        goto L9
    L12:
        this._interp = new LexerATNSimulator(this, r14, this._decisionToDFA, this._sharedContextCache);
        return;
    L15:
        throw new IllegalArgumentException("The ATN must be a lexer ATN.");
    }
}
