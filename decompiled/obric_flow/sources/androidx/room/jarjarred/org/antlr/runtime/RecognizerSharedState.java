package androidx.room.jarjarred.org.antlr.runtime;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class RecognizerSharedState {
    public int _fsp;
    public int backtracking;
    public int channel;
    public boolean errorRecovery;
    public boolean failed;
    public BitSet[] following;
    public int lastErrorIndex;
    public Map<Integer, Integer>[] ruleMemo;
    public int syntaxErrors;
    public String text;
    public Token token;
    public int tokenStartCharIndex;
    public int tokenStartCharPositionInLine;
    public int tokenStartLine;
    public int type;

    public RecognizerSharedState() {
        this.following = new BitSet[100];
        this._fsp = -1;
        this.errorRecovery = false;
        this.lastErrorIndex = -1;
        this.failed = false;
        this.syntaxErrors = 0;
        this.backtracking = 0;
        this.tokenStartCharIndex = -1;
    }

    public RecognizerSharedState(RecognizerSharedState r5) {
        BitSet[] r10 = new BitSet[100];
        this.following = r10;
        this._fsp = -1;
        this.errorRecovery = false;
        this.lastErrorIndex = -1;
        this.failed = false;
        this.syntaxErrors = 0;
        this.backtracking = 0;
        this.tokenStartCharIndex = -1;
        int r11 = r10.length;
        BitSet[] r12 = r5.following;
        if (r11 >= r12.length) goto L5;
        this.following = new BitSet[r12.length];
    L5:
        BitSet[] r13 = r5.following;
        System.arraycopy(r13, 0, this.following, 0, r13.length);
        this._fsp = r5._fsp;
        this.errorRecovery = r5.errorRecovery;
        this.lastErrorIndex = r5.lastErrorIndex;
        this.failed = r5.failed;
        this.syntaxErrors = r5.syntaxErrors;
        this.backtracking = r5.backtracking;
        Map<Integer, Integer>[] r14 = r5.ruleMemo;
        if (r14 == null) goto L8;
        Map<Integer, Integer>[] r15 = new Map[r14.length];
        this.ruleMemo = r15;
        Map<Integer, Integer>[] r16 = r5.ruleMemo;
        System.arraycopy(r16, 0, r15, 0, r16.length);
    L8:
        this.token = r5.token;
        this.tokenStartCharIndex = r5.tokenStartCharIndex;
        this.tokenStartCharPositionInLine = r5.tokenStartCharPositionInLine;
        this.channel = r5.channel;
        this.type = r5.type;
        this.text = r5.text;
    }
}
