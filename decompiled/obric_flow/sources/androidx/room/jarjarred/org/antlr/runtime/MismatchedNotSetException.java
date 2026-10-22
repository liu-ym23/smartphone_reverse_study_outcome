package androidx.room.jarjarred.org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public class MismatchedNotSetException extends MismatchedSetException {
    public MismatchedNotSetException() {
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.MismatchedSetException, java.lang.Throwable
    public String toString() {
        return "MismatchedNotSetException(" + getUnexpectedType() + "!=" + this.expecting + ")";
    }

    public MismatchedNotSetException(BitSet r5, IntStream r10) {
        super(r5, r10);
    }
}
