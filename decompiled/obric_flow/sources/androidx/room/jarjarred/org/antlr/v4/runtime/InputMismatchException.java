package androidx.room.jarjarred.org.antlr.v4.runtime;

/* JADX INFO: loaded from: classes.dex */
public class InputMismatchException extends RecognitionException {
    public InputMismatchException(Parser r5) {
        super(r5, r5.getInputStream(), r5._ctx);
        setOffendingToken(r5.getCurrentToken());
    }

    public InputMismatchException(Parser r5, int r10, ParserRuleContext r11) {
        super(r5, r5.getInputStream(), r11);
        setOffendingState(r10);
        setOffendingToken(r5.getCurrentToken());
    }
}
