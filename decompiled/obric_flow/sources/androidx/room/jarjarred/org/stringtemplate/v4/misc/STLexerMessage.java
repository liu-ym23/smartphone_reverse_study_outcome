package androidx.room.jarjarred.org.stringtemplate.v4.misc;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.Token;

/* JADX INFO: loaded from: classes.dex */
public class STLexerMessage extends STMessage {
    public String msg;
    public String srcName;
    public Token templateToken;

    public STLexerMessage(String r5, String r10, Token r11, Throwable r12) {
        super(ErrorType.LEXER_ERROR, null, r12, null);
        this.msg = r10;
        this.templateToken = r11;
        this.srcName = r5;
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.misc.STMessage
    public String toString() {
        RecognitionException r5 = (RecognitionException) this.cause;
        int r10 = r5.line;
        int r11 = r5.charPositionInLine;
        Token r12 = this.templateToken;
        if (r12 != null) goto L5;
    L9:
        String r13 = r10 + ":" + r11;
        if (this.srcName == null) goto L13;
        StringBuilder r14 = new StringBuilder();
        a.C(r14, this.srcName, " ", r13, ": ");
        r14.append(String.format(this.error.message, new Object[]{this.msg}));
        return r14.toString();
    L13:
        StringBuilder r15 = j0.w(r13, ": ");
        r15.append(String.format(this.error.message, new Object[]{this.msg}));
        return r15.toString();
    L5:
        if (r12.getType() != 5) goto L7;
        int r16 = 2;
    L8:
        r10 = r10 + (this.templateToken.getLine() - 1);
        r11 = r11 + (this.templateToken.getCharPositionInLine() + r16);
        goto L9
    L7:
        r16 = 1;
        goto L8
    }
}
