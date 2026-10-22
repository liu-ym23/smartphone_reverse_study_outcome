package androidx.room.jarjarred.org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public class MissingTokenException extends MismatchedTokenException {
    public Object inserted;

    public MissingTokenException() {
    }

    public int getMissingType() {
        return this.expecting;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.MismatchedTokenException, java.lang.Throwable
    public String toString() {
        if (this.inserted == null) goto L9;
        if (this.token == null) goto L9;
        return "MissingTokenException(inserted " + this.inserted + " at " + this.token.getText() + ")";
    L9:
        if (this.token != null) goto L11;
        return "MissingTokenException";
    L11:
        return "MissingTokenException(at " + this.token.getText() + ")";
    }

    public MissingTokenException(int r5, IntStream r10, Object r11) {
        super(r5, r10);
        this.inserted = r11;
    }
}
