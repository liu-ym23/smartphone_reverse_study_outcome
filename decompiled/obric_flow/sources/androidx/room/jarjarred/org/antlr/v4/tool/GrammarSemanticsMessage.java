package androidx.room.jarjarred.org.antlr.v4.tool;

import androidx.room.jarjarred.org.antlr.runtime.Token;

/* JADX INFO: loaded from: classes.dex */
public class GrammarSemanticsMessage extends ANTLRMessage {
    public GrammarSemanticsMessage(ErrorType r5, String r10, Token r11, Object... r12) {
        super(r5, r11, r12);
        this.fileName = r10;
        if (r11 == null) goto L6;
        this.line = r11.getLine();
        this.charPosition = r11.getCharPositionInLine();
        return;
    }
}
