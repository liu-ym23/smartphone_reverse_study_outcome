package androidx.room.jarjarred.org.antlr.v4.parse;

import androidx.room.jarjarred.org.antlr.runtime.CharStream;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.v4.Tool;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorType;

/* JADX INFO: loaded from: classes.dex */
public class ToolANTLRLexer extends ANTLRLexer {
    public Tool tool;

    public ToolANTLRLexer(CharStream r5, Tool r10) {
        super(r5);
        this.tool = r10;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public void displayRecognitionError(String[] r10, RecognitionException r11) {
        String r12 = getErrorMessage(r11, r10);
        this.tool.errMgr.syntaxError(ErrorType.SYNTAX_ERROR, getSourceName(), r11.token, r11, new Object[]{r12});
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.ANTLRLexer
    public void grammarError(ErrorType r5, Token r10, Object... r11) {
        this.tool.errMgr.grammarError(r5, getSourceName(), r10, r11);
    }
}
