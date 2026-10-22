package androidx.room.jarjarred.org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public class MismatchedSetException extends RecognitionException {
    public BitSet expecting;

    public MismatchedSetException() {
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "MismatchedSetException(" + getUnexpectedType() + "!=" + this.expecting + ")";
    }

    public MismatchedSetException(BitSet r5, IntStream r10) {
        super(r10);
        this.expecting = r5;
    }
}
