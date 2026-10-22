package androidx.room.jarjarred.org.antlr.v4.runtime;

/* JADX INFO: loaded from: classes.dex */
public interface ANTLRErrorStrategy {
    boolean inErrorRecoveryMode(Parser r5);

    void recover(Parser r5, RecognitionException r10) throws RecognitionException;

    Token recoverInline(Parser r5) throws RecognitionException;

    void reportError(Parser r5, RecognitionException r10);

    void reportMatch(Parser r5);

    void reset(Parser r5);

    void sync(Parser r5) throws RecognitionException;
}
