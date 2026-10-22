package androidx.room.jarjarred.org.antlr.v4.runtime;

import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNConfigSet;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Interval;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Utils;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class LexerNoViableAltException extends RecognitionException {
    private final ATNConfigSet deadEndConfigs;
    private final int startIndex;

    public LexerNoViableAltException(Lexer r5, CharStream r10, int r11, ATNConfigSet r12) {
        super(r5, r10, null);
        this.startIndex = r11;
        this.deadEndConfigs = r12;
    }

    public ATNConfigSet getDeadEndConfigs() {
        return this.deadEndConfigs;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RecognitionException
    public /* bridge */ /* synthetic */ IntStream getInputStream() {
        return getInputStream();
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    @Override // java.lang.Throwable
    public String toString() {
        int r5 = this.startIndex;
        if (r5 >= 0) goto L5;
    L7:
        String r10 = "";
    L8:
        Locale.getDefault();
        return "LexerNoViableAltException('" + r10 + "')";
    L5:
        if (r5 >= getInputStream().size()) goto L7;
        CharStream r11 = getInputStream();
        int r12 = this.startIndex;
        r10 = Utils.escapeWhitespace(r11.getText(Interval.of(r12, r12)), false);
        goto L8
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RecognitionException
    public CharStream getInputStream() {
        return (CharStream) super.getInputStream();
    }
}
