package androidx.room.jarjarred.org.antlr.runtime;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ANTLRStringStream implements CharStream {
    protected int charPositionInLine;
    protected char[] data;
    protected int lastMarker;
    protected int line;
    protected int markDepth;
    protected List<CharStreamState> markers;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected int f619n;
    public String name;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected int f620p;

    public ANTLRStringStream() {
        this.f620p = 0;
        this.line = 1;
        this.charPositionInLine = 0;
        this.markDepth = 0;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public int LA(int r5) {
        if (r5 != 0) goto L6;
        return 0;
    L6:
        if (r5 >= 0) goto L10;
        r5 = r5 + 1;
        if (((this.f620p + r5) - 1) >= 0) goto L10;
        return -1;
    L10:
        int r10 = this.f620p;
        if (((r10 + r5) - 1) < this.f619n) goto L14;
        return -1;
    L14:
        return this.data[(r10 + r5) - 1];
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.CharStream
    public int LT(int r5) {
        return LA(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void consume() {
        int r5 = this.f620p;
        if (r5 >= this.f619n) goto L9;
        this.charPositionInLine++;
        if (this.data[r5] != '\n') goto L7;
        this.line++;
        this.charPositionInLine = 0;
    L7:
        this.f620p = r5 + 1;
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.CharStream
    public int getCharPositionInLine() {
        return this.charPositionInLine;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.CharStream
    public int getLine() {
        return this.line;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public String getSourceName() {
        return this.name;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public int index() {
        return this.f620p;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public int mark() {
        if (this.markers != null) goto L5;
        ArrayList r5 = new ArrayList();
        this.markers = r5;
        r5.add(null);
    L5:
        int r10 = this.markDepth + 1;
        this.markDepth = r10;
        if (r10 < this.markers.size()) goto L8;
        CharStreamState r11 = new CharStreamState();
        this.markers.add(r11);
    L9:
        r11.f622p = this.f620p;
        r11.line = this.line;
        r11.charPositionInLine = this.charPositionInLine;
        int r12 = this.markDepth;
        this.lastMarker = r12;
        return r12;
    L8:
        r11 = this.markers.get(this.markDepth);
        goto L9
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void release(int r5) {
        this.markDepth = r5 - 1;
    }

    public void reset() {
        this.f620p = 0;
        this.line = 1;
        this.charPositionInLine = 0;
        this.markDepth = 0;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void rewind(int r5) {
        CharStreamState r10 = this.markers.get(r5);
        seek(r10.f622p);
        this.line = r10.line;
        this.charPositionInLine = r10.charPositionInLine;
        release(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void seek(int r5) {
        if (r5 > this.f620p) goto L7;
        this.f620p = r5;
        return;
    L7:
        if (this.f620p >= r5) goto L9;
        consume();
        goto L7
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.CharStream
    public void setCharPositionInLine(int r5) {
        this.charPositionInLine = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.CharStream
    public void setLine(int r5) {
        this.line = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public int size() {
        return this.f619n;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.CharStream
    public String substring(int r5, int r10) {
        return new String(this.data, r5, (r10 - r5) + 1);
    }

    public String toString() {
        return new String(this.data);
    }

    public ANTLRStringStream(String r5) {
        this();
        this.data = r5.toCharArray();
        this.f619n = r5.length();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void rewind() {
        rewind(this.lastMarker);
    }

    public ANTLRStringStream(char[] r5, int r10) {
        this();
        this.data = r5;
        this.f619n = r10;
    }
}
