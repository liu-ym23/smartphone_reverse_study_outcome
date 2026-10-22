package androidx.room.jarjarred.org.antlr.v4.tool;

import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.Token;

/* JADX INFO: loaded from: classes.dex */
public class GrammarSyntaxMessage extends ANTLRMessage {
    public GrammarSyntaxMessage(ErrorType r5, String r10, Token r11, RecognitionException r12, Object... r13) {
        super(r5, r12, r11, r13);
        this.fileName = r10;
        this.offendingToken = r11;
        if (r11 == null) goto L6;
        this.line = r11.getLine();
        this.charPosition = r11.getCharPositionInLine();
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ANTLRMessage
    public /* bridge */ /* synthetic */ Throwable getCause() {
        return getCause();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ANTLRMessage
    public RecognitionException getCause() {
        return (RecognitionException) super.getCause();
    }
}
