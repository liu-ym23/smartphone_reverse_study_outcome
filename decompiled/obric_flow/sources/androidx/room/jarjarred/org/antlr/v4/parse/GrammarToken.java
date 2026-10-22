package androidx.room.jarjarred.org.antlr.v4.parse;

import androidx.room.jarjarred.org.antlr.runtime.CommonToken;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.debug.Profiler;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;

/* JADX INFO: loaded from: classes.dex */
public class GrammarToken extends CommonToken {
    public Grammar g;
    public int originalTokenIndex;

    public GrammarToken(Grammar r5, Token r10) {
        super(r10);
        this.originalTokenIndex = -1;
        this.g = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.CommonToken, androidx.room.jarjarred.org.antlr.runtime.Token
    public int getCharPositionInLine() {
        int r5 = this.originalTokenIndex;
        if (r5 < 0) goto L7;
        return this.g.originalTokenStream.get(r5).getCharPositionInLine();
    L7:
        return super.getCharPositionInLine();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.CommonToken, androidx.room.jarjarred.org.antlr.runtime.Token
    public int getLine() {
        int r5 = this.originalTokenIndex;
        if (r5 < 0) goto L7;
        return this.g.originalTokenStream.get(r5).getLine();
    L7:
        return super.getLine();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.CommonToken
    public int getStartIndex() {
        int r5 = this.originalTokenIndex;
        if (r5 < 0) goto L7;
        return ((CommonToken) this.g.originalTokenStream.get(r5)).getStartIndex();
    L7:
        return super.getStartIndex();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.CommonToken
    public int getStopIndex() {
        return (getStartIndex() + ((super.getStopIndex() - super.getStartIndex()) + 1)) - 1;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.CommonToken, androidx.room.jarjarred.org.antlr.runtime.Token
    public int getTokenIndex() {
        return this.originalTokenIndex;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.CommonToken
    public String toString() {
        if (this.channel <= 0) goto L5;
        String r5 = ",channel=" + this.channel;
    L6:
        String r10 = getText();
        if (r10 == null) goto L9;
        String r11 = r10.replaceAll("\n", "\\\\n").replaceAll("\r", "\\\\r").replaceAll(Profiler.DATA_SEP, "\\\\t");
    L11:
        return "[@" + getTokenIndex() + "," + getStartIndex() + ":" + getStopIndex() + "='" + r11 + "',<" + getType() + ">" + r5 + "," + getLine() + ":" + getCharPositionInLine() + "]";
    L9:
        r11 = "<no text>";
        goto L11
    L5:
        r5 = "";
        goto L6
    }
}
