package androidx.room.jarjarred.org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public class EarlyExitException extends RecognitionException {
    public int decisionNumber;

    public EarlyExitException() {
    }

    public EarlyExitException(int r5, IntStream r10) {
        super(r10);
        this.decisionNumber = r5;
    }
}
