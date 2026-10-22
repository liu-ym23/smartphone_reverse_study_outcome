package androidx.room.jarjarred.org.stringtemplate.v4.misc;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.Token;

/* JADX INFO: loaded from: classes.dex */
public class STCompiletimeMessage extends STMessage {
    public String srcName;
    public Token templateToken;
    public Token token;

    public STCompiletimeMessage(ErrorType r10, String r11, Token r12, Token r13) {
        this(r10, r11, r12, r13, null);
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.misc.STMessage
    public String toString() {
        RecognitionException r5 = (RecognitionException) this.cause;
        Token r10 = this.token;
        if (r10 == null) goto L16;
        int r11 = r10.getLine();
        int r12 = this.token.getCharPositionInLine();
        Token r13 = this.templateToken;
        if (r13 != null) goto L7;
    L17:
        String r14 = r11 + ":" + r12;
        if (this.srcName == null) goto L21;
        StringBuilder r15 = new StringBuilder();
        a.C(r15, this.srcName, " ", r14, ": ");
        r15.append(String.format(this.error.message, new Object[]{this.arg, this.arg2}));
        return r15.toString();
    L21:
        StringBuilder r16 = j0.w(r14, ": ");
        r16.append(String.format(this.error.message, new Object[]{this.arg, this.arg2}));
        return r16.toString();
    L7:
        if (r13.getInputStream().equals(this.token.getInputStream()) == true) goto L17;
        if (this.templateToken.getType() != 5) goto L11;
    L14:
        int r17 = 2;
    L15:
        r11 = r11 + (this.templateToken.getLine() - 1);
        r12 = r12 + (this.templateToken.getCharPositionInLine() + r17);
        goto L17
    L11:
        if (this.templateToken.getType() == 6) goto L14;
        r17 = 1;
        goto L15
    L16:
        r11 = 0;
        r12 = -1;
        goto L17
    }

    public STCompiletimeMessage(ErrorType r10, String r11, Token r12, Token r13, Throwable r14) {
        this(r10, r11, r12, r13, r14, null);
    }

    public STCompiletimeMessage(ErrorType r10, String r11, Token r12, Token r13, Throwable r14, Object r15) {
        this(r10, r11, r12, r13, r14, r15, null);
    }

    public STCompiletimeMessage(ErrorType r10, String r11, Token r12, Token r13, Throwable r14, Object r15, Object r16) {
        super(r10, null, r14, r15, r16);
        this.templateToken = r12;
        this.token = r13;
        this.srcName = r11;
    }
}
