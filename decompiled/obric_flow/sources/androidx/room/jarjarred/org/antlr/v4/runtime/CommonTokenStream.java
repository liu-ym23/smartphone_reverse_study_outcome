package androidx.room.jarjarred.org.antlr.v4.runtime;

/* JADX INFO: loaded from: classes.dex */
public class CommonTokenStream extends BufferedTokenStream {
    protected int channel;

    public CommonTokenStream(TokenSource r5) {
        super(r5);
        this.channel = 0;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.BufferedTokenStream
    public Token LB(int r5) {
        if (r5 == 0) goto L15;
        int r10 = this.f654p;
        if ((r10 - r5) < 0) goto L15;
        int r11 = 1;
    L8:
        if (r11 > r5) goto L11;
        if (r10 <= 0) goto L11;
        r10 = previousTokenOnChannel(r10 - 1, this.channel);
        r11 = r11 + 1;
    L11:
        if (r10 >= 0) goto L14;
        return null;
    L14:
        return this.tokens.get(r10);
    L15:
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.BufferedTokenStream, androidx.room.jarjarred.org.antlr.v4.runtime.TokenStream
    public Token LT(int r5) {
        lazyInit();
        if (r5 != 0) goto L6;
        return null;
    L6:
        if (r5 < 0) goto L8;
        int r10 = this.f654p;
        int r11 = 1;
    L10:
        if (r11 >= r5) goto L16;
        int r12 = r10 + 1;
        if (sync(r12) == false) goto L14;
        r10 = nextTokenOnChannel(r12, this.channel);
    L14:
        r11 = r11 + 1;
        goto L10
    L16:
        return this.tokens.get(r10);
    L8:
        return LB(-r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.BufferedTokenStream
    public int adjustSeekIndex(int r5) {
        return nextTokenOnChannel(r5, this.channel);
    }

    public int getNumberOfOnChannelTokens() {
        fill();
        int r5 = 0;
        int r10 = 0;
    L4:
        if (r5 >= this.tokens.size()) goto L12;
        Token r11 = this.tokens.get(r5);
        if (r11.getChannel() != this.channel) goto L9;
        r10 = r10 + 1;
    L9:
        if (r11.getType() == (-1)) goto L12;
        r5 = r5 + 1;
    L12:
        return r10;
    }

    public CommonTokenStream(TokenSource r5, int r10) {
        this(r5);
        this.channel = r10;
    }
}
