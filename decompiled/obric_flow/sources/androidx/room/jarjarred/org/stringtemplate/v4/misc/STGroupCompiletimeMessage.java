package androidx.room.jarjarred.org.stringtemplate.v4.misc;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.Token;

/* JADX INFO: loaded from: classes.dex */
public class STGroupCompiletimeMessage extends STMessage {
    public String srcName;
    public Token token;

    public STGroupCompiletimeMessage(ErrorType r10, String r11, Token r12, Throwable r13) {
        this(r10, r11, r12, r13, null);
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.misc.STMessage
    public String toString() {
        RecognitionException r5 = (RecognitionException) this.cause;
        Token r10 = this.token;
        if (r10 == null) goto L5;
        int r11 = r10.getLine();
        int r12 = this.token.getCharPositionInLine();
    L8:
        String r13 = r11 + ":" + r12;
        if (this.srcName == null) goto L12;
        StringBuilder r14 = new StringBuilder();
        a.C(r14, this.srcName, " ", r13, ": ");
        r14.append(String.format(this.error.message, new Object[]{this.arg, this.arg2}));
        return r14.toString();
    L12:
        StringBuilder r15 = j0.w(r13, ": ");
        r15.append(String.format(this.error.message, new Object[]{this.arg, this.arg2}));
        return r15.toString();
    L5:
        if (r5 == null) goto L7;
        int r16 = r5.line;
        r12 = r5.charPositionInLine;
        r11 = r16;
        goto L8
    L7:
        r11 = 0;
        r12 = -1;
        goto L8
    }

    public STGroupCompiletimeMessage(ErrorType r10, String r11, Token r12, Throwable r13, Object r14) {
        this(r10, r11, r12, r13, r14, null);
    }

    public STGroupCompiletimeMessage(ErrorType r10, String r11, Token r12, Throwable r13, Object r14, Object r15) {
        super(r10, null, r13, r14, r15);
        this.token = r12;
        this.srcName = r11;
    }
}
