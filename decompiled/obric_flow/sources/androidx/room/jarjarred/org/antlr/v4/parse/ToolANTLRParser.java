package androidx.room.jarjarred.org.antlr.v4.parse;

import ai.j0;
import androidx.room.jarjarred.org.antlr.runtime.NoViableAltException;
import androidx.room.jarjarred.org.antlr.runtime.Parser;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.TokenStream;
import androidx.room.jarjarred.org.antlr.v4.Tool;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorType;

/* JADX INFO: loaded from: classes.dex */
public class ToolANTLRParser extends ANTLRParser {
    public Tool tool;

    public ToolANTLRParser(TokenStream r5, Tool r10) {
        super(r5);
        this.tool = r10;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public void displayRecognitionError(String[] r10, RecognitionException r11) {
        String r12 = getParserErrorMessage(this, r11);
        if (this.paraphrases.isEmpty() == true) goto L5;
        r12 = j0.D(r12, " while ", this.paraphrases.peek());
    L5:
        this.tool.errMgr.syntaxError(ErrorType.SYNTAX_ERROR, getSourceName(), r11.token, r11, new Object[]{r12});
    }

    public String getParserErrorMessage(Parser r5, RecognitionException r10) {
        if ((r10 instanceof NoViableAltException) == false) goto L6;
        return j0.j(r5.getTokenErrorDisplay(r10.token), " came as a complete surprise to me");
    L6:
        if ((r10 instanceof v4ParserException) == false) goto L9;
        return ((v4ParserException) r10).msg;
    L9:
        return r5.getErrorMessage(r10, r5.getTokenNames());
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.ANTLRParser
    public void grammarError(ErrorType r5, Token r10, Object... r11) {
        this.tool.errMgr.grammarError(r5, getSourceName(), r10, r11);
    }
}
