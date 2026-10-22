package androidx.room.jarjarred.org.antlr.v4.runtime;

import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.jarjarred.org.antlr.runtime.debug.Profiler;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Interval;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Pair;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class CommonToken implements WritableToken, Serializable {
    protected static final Pair<TokenSource, CharStream> EMPTY_SOURCE = null;
    protected int channel;
    protected int charPositionInLine;
    protected int index;
    protected int line;
    protected Pair<TokenSource, CharStream> source;
    protected int start;
    protected int stop;
    protected String text;
    protected int type;

    static {
        EMPTY_SOURCE = new Pair(null, null);
    }

    public CommonToken(int r5) {
        this.charPositionInLine = -1;
        this.channel = 0;
        this.index = -1;
        this.type = r5;
        this.source = EMPTY_SOURCE;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Token
    public int getChannel() {
        return this.channel;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Token
    public int getCharPositionInLine() {
        return this.charPositionInLine;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Token
    public CharStream getInputStream() {
        return this.source.f668b;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Token
    public int getLine() {
        return this.line;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Token
    public int getStartIndex() {
        return this.start;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Token
    public int getStopIndex() {
        return this.stop;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Token
    public String getText() {
        String r5 = this.text;
        if (r5 == null) goto L5;
        return r5;
    L5:
        CharStream r10 = getInputStream();
        if (r10 != null) goto L9;
        return null;
    L9:
        int r11 = r10.size();
        int r12 = this.start;
        if (r12 >= r11) goto L15;
        int r13 = this.stop;
        if (r13 < r11) goto L14;
        return "<EOF>";
    L14:
        return r10.getText(Interval.of(r12, r13));
    L15:
        return "<EOF>";
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Token
    public int getTokenIndex() {
        return this.index;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Token
    public TokenSource getTokenSource() {
        return this.source.f667a;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Token
    public int getType() {
        return this.type;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.WritableToken
    public void setChannel(int r5) {
        this.channel = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.WritableToken
    public void setCharPositionInLine(int r5) {
        this.charPositionInLine = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.WritableToken
    public void setLine(int r5) {
        this.line = r5;
    }

    public void setStartIndex(int r5) {
        this.start = r5;
    }

    public void setStopIndex(int r5) {
        this.stop = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.WritableToken
    public void setText(String r5) {
        this.text = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.WritableToken
    public void setTokenIndex(int r5) {
        this.index = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.WritableToken
    public void setType(int r5) {
        this.type = r5;
    }

    public String toString() {
        return toString(null);
    }

    public String toString(Recognizer r10) {
        if (this.channel <= 0) goto L5;
        String r5 = ",channel=" + this.channel;
    L6:
        String r11 = getText();
        if (r11 == null) goto L9;
        String r12 = r11.replace("\n", "\\n").replace("\r", "\\r").replace(Profiler.DATA_SEP, "\\t");
    L10:
        String r13 = String.valueOf(this.type);
        if (r10 == null) goto L13;
        r13 = r10.getVocabulary().getDisplayName(this.type);
    L13:
        StringBuilder r14 = new StringBuilder("[@");
        r14.append(getTokenIndex());
        r14.append(",");
        r14.append(this.start);
        r14.append(":");
        a.D(r14, this.stop, "='", r12, "',<");
        androidx.constraintlayout.motion.widget.a.C(r14, r13, ">", r5, ",");
        r14.append(this.line);
        r14.append(":");
        r14.append(getCharPositionInLine());
        r14.append("]");
        return r14.toString();
    L9:
        r12 = "<no text>";
        goto L10
    L5:
        r5 = "";
        goto L6
    }

    public CommonToken(Pair<TokenSource, CharStream> r5, int r10, int r11, int r12, int r13) {
        this.charPositionInLine = -1;
        this.index = -1;
        this.source = r5;
        this.type = r10;
        this.channel = r11;
        this.start = r12;
        this.stop = r13;
        TokenSource r14 = r5.f667a;
        if (r14 == null) goto L6;
        this.line = r14.getLine();
        this.charPositionInLine = r5.f667a.getCharPositionInLine();
        return;
    }

    public CommonToken(int r5, String r10) {
        this.charPositionInLine = -1;
        this.index = -1;
        this.type = r5;
        this.channel = 0;
        this.text = r10;
        this.source = EMPTY_SOURCE;
    }

    public CommonToken(Token r5) {
        this.charPositionInLine = -1;
        this.channel = 0;
        this.index = -1;
        this.type = r5.getType();
        this.line = r5.getLine();
        this.index = r5.getTokenIndex();
        this.charPositionInLine = r5.getCharPositionInLine();
        this.channel = r5.getChannel();
        this.start = r5.getStartIndex();
        this.stop = r5.getStopIndex();
        if ((r5 instanceof CommonToken) == false) goto L5;
        CommonToken r10 = (CommonToken) r5;
        this.text = r10.text;
        this.source = r10.source;
        return;
    L5:
        this.text = r5.getText();
        this.source = new Pair(r5.getTokenSource(), r5.getInputStream());
    }
}
