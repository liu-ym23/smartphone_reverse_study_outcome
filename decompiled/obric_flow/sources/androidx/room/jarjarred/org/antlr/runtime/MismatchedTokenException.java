package androidx.room.jarjarred.org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public class MismatchedTokenException extends RecognitionException {
    public int expecting;

    public MismatchedTokenException() {
        this.expecting = 0;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder r5 = new StringBuilder("MismatchedTokenException(");
        r5.append(getUnexpectedType());
        r5.append("!=");
        return androidx.constraintlayout.motion.widget.a.s(r5, this.expecting, ")");
    }

    public MismatchedTokenException(int r5, IntStream r10) {
        super(r10);
        this.expecting = r5;
    }
}
