package androidx.room.jarjarred.org.antlr.runtime;

import androidx.room.jarjarred.org.antlr.runtime.debug.Profiler;

/* JADX INFO: loaded from: classes.dex */
public class ClassicToken implements Token {
    protected int channel;
    protected int charPositionInLine;
    protected int index;
    protected int line;
    protected String text;
    protected int type;

    public ClassicToken(int r5) {
        this.channel = 0;
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
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.Token
    public int getLine() {
        return this.line;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.Token
    public String getText() {
        return this.text;
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
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.Token
    public void setLine(int r5) {
        this.line = r5;
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
        r12.append(",'");
        r12.append(r11);
        r12.append("',<");
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

    public ClassicToken(Token r5) {
        this.channel = 0;
        this.text = r5.getText();
        this.type = r5.getType();
        this.line = r5.getLine();
        this.charPositionInLine = r5.getCharPositionInLine();
        this.channel = r5.getChannel();
    }

    public ClassicToken(int r5, String r10) {
        this.channel = 0;
        this.type = r5;
        this.text = r10;
    }

    public ClassicToken(int r5, String r10, int r11) {
        this.type = r5;
        this.text = r10;
        this.channel = r11;
    }
}
