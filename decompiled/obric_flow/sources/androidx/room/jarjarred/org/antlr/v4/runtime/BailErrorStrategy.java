package androidx.room.jarjarred.org.antlr.v4.runtime;

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.ParseCancellationException;

/* JADX INFO: loaded from: classes.dex */
public class BailErrorStrategy extends DefaultErrorStrategy {
    public BailErrorStrategy() {
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.DefaultErrorStrategy, androidx.room.jarjarred.org.antlr.v4.runtime.ANTLRErrorStrategy
    public void recover(Parser r5, RecognitionException r10) {
        ParserRuleContext r11 = r5.getContext();
    L3:
        if (r11 == null) goto L6;
        r11.exception = r10;
        r11 = r11.getParent();
        goto L3
    L6:
        throw new ParseCancellationException(r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.DefaultErrorStrategy, androidx.room.jarjarred.org.antlr.v4.runtime.ANTLRErrorStrategy
    public Token recoverInline(Parser r5) throws RecognitionException {
        InputMismatchException r10 = new InputMismatchException(r5);
        ParserRuleContext r11 = r5.getContext();
    L3:
        if (r11 == null) goto L6;
        r11.exception = r10;
        r11 = r11.getParent();
        goto L3
    L6:
        throw new ParseCancellationException(r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.DefaultErrorStrategy, androidx.room.jarjarred.org.antlr.v4.runtime.ANTLRErrorStrategy
    public void sync(Parser r5) {
    }
}
