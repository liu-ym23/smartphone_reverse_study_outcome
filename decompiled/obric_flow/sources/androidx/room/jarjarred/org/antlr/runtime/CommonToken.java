package androidx.room.jarjarred.org.antlr.runtime;

import androidx.room.jarjarred.org.antlr.runtime.debug.Profiler;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class CommonToken implements Token, Serializable {
    protected int channel;
    protected int charPositionInLine;
    protected int index;
    protected transient CharStream input;
    protected int line;
    protected int start;
    protected int stop;
    protected String text;
    protected int type;

    public CommonToken(int r5) {
        this.charPositionInLine = -1;
        this.channel = 0;
        this.index = -1;
        this.type = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.Token
    public int getChannel() {
        return this.channel;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.Token
    public int getCharPositionInLine() {
        return this.charPositionInLine;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.Token
    public CharStream getInputStream() {
        return this.input;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.Token
    public int getLine() {
        return this.line;
    }

    public int getStartIndex() {
        return this.start;
    }

    public int getStopIndex() {
        return this.stop;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.Token
    public String getText() {
        String r5 = this.text;
        if (r5 == null) goto L5;
        return r5;
    L5:
        CharStream r10 = this.input;
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
        return this.input.substring(r12, r13);
    L15:
        return "<EOF>";
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.Token
    public int getTokenIndex() {
        return this.index;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.Token
    public int getType() {
        return this.type;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.Token
    public void setChannel(int r5) {
        this.channel = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.Token
    public void setCharPositionInLine(int r5) {
        this.charPositionInLine = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.Token
    public void setInputStream(CharStream r5) {
        this.input = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.Token
    public void setLine(int r5) {
        this.line = r5;
    }

    public void setStartIndex(int r5) {
        this.start = r5;
    }

    public void setStopIndex(int r5) {
        this.stop = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.Token
    public void setText(String r5) {
        this.text = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.Token
    public void setTokenIndex(int r5) {
        this.index = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.Token
    public void setType(int r5) {
        this.type = r5;
    }

    public String toString() {
        if (this.channel <= 0) goto L5;
        String r5 = ",channel=" + this.channel;
    L6:
        String r10 = getText();
        if (r10 == null) goto L9;
        String r11 = r10.replaceAll("\n", "\\\\n").replaceAll("\r", "\\\\r").replaceAll(Profiler.DATA_SEP, "\\\\t");
    L10:
        StringBuilder r12 = new StringBuilder("[@");
        r12.append(getTokenIndex());
        r12.append(",");
        r12.append(this.start);
        r12.append(":");
        a.D(r12, this.stop, "='", r11, "',<");
        a.D(r12, this.type, ">", r5, ",");
        r12.append(this.line);
        r12.append(":");
        r12.append(getCharPositionInLine());
        r12.append("]");
        return r12.toString();
    L9:
        r11 = "<no text>";
        goto L10
    L5:
        r5 = "";
        goto L6
    }

    public CommonToken(CharStream r5, int r10, int r11, int r12, int r13) {
        this.charPositionInLine = -1;
        this.index = -1;
        this.input = r5;
        this.type = r10;
        this.channel = r11;
        this.start = r12;
        this.stop = r13;
    }

    public CommonToken(int r5, String r10) {
        this.charPositionInLine = -1;
        this.index = -1;
        this.type = r5;
        this.channel = 0;
        this.text = r10;
    }

    public CommonToken(Token r5) {
        this.charPositionInLine = -1;
        this.channel = 0;
        this.index = -1;
        this.text = r5.getText();
        this.type = r5.getType();
        this.line = r5.getLine();
        this.index = r5.getTokenIndex();
        this.charPositionInLine = r5.getCharPositionInLine();
        this.channel = r5.getChannel();
        this.input = r5.getInputStream();
        if ((r5 instanceof CommonToken) == false) goto L6;
        CommonToken r10 = (CommonToken) r5;
        this.start = r10.start;
        this.stop = r10.stop;
        return;
    }
}
