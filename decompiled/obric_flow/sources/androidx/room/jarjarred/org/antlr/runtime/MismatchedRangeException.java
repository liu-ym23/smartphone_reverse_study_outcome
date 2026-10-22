package androidx.room.jarjarred.org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public class MismatchedRangeException extends RecognitionException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f625b;

    public MismatchedRangeException() {
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder r5 = new StringBuilder("MismatchedNotSetException(");
        r5.append(getUnexpectedType());
        r5.append(" not in [");
        r5.append(this.f624a);
        r5.append(",");
        return androidx.constraintlayout.motion.widget.a.s(r5, this.f625b, "])");
    }

    public MismatchedRangeException(int r5, int r10, IntStream r11) {
        super(r11);
        this.f624a = r5;
        this.f625b = r10;
    }
}
