package androidx.room.jarjarred.org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public class CommonTokenStream extends BufferedTokenStream {
    protected int channel;

    public CommonTokenStream() {
        this.channel = 0;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BufferedTokenStream
    public Token LB(int r5) {
        if (r5 == 0) goto L14;
        int r10 = this.f621p;
        if ((r10 - r5) < 0) goto L14;
        int r11 = 1;
    L8:
        if (r11 > r5) goto L10;
        r10 = skipOffTokenChannelsReverse(r10 - 1);
        r11 = r11 + 1;
        goto L8
    L10:
        if (r10 >= 0) goto L13;
        return null;
    L13:
        return this.tokens.get(r10);
    L14:
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BufferedTokenStream, androidx.room.jarjarred.org.antlr.runtime.TokenStream
    public Token LT(int r5) {
        if (this.f621p != (-1)) goto L5;
        setup();
    L5:
        if (r5 != 0) goto L8;
        return null;
    L8:
        if (r5 < 0) goto L10;
        int r10 = this.f621p;
        int r11 = 1;
    L12:
        if (r11 >= r5) goto L15;
        r10 = skipOffTokenChannels(r10 + 1);
        r11 = r11 + 1;
        goto L12
    L15:
        if (r10 <= this.range) goto L18;
        this.range = r10;
    L18:
        return this.tokens.get(r10);
    L10:
        return LB(-r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BufferedTokenStream, androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void consume() {
        if (this.f621p != (-1)) goto L5;
        setup();
    L5:
        int r5 = this.f621p + 1;
        this.f621p = r5;
        sync(r5);
    L7:
        if (this.tokens.get(this.f621p).getChannel() == this.channel) goto L9;
        int r10 = this.f621p + 1;
        this.f621p = r10;
        sync(r10);
        goto L7
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

    @Override // androidx.room.jarjarred.org.antlr.runtime.BufferedTokenStream
    public void reset() {
        super.reset();
        this.f621p = skipOffTokenChannels(0);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BufferedTokenStream
    public void setTokenSource(TokenSource r5) {
        super.setTokenSource(r5);
        this.channel = 0;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BufferedTokenStream
    public void setup() {
        int r5 = 0;
        this.f621p = 0;
        sync(0);
    L4:
        if (this.tokens.get(r5).getChannel() == this.channel) goto L6;
        r5 = r5 + 1;
        sync(r5);
        goto L4
    L6:
        this.f621p = r5;
    }

    public int skipOffTokenChannels(int r5) {
        sync(r5);
    L4:
        if (this.tokens.get(r5).getChannel() == this.channel) goto L6;
        r5 = r5 + 1;
        sync(r5);
        goto L4
    L6:
        return r5;
    }

    public int skipOffTokenChannelsReverse(int r5) {
    L2:
        if (r5 < 0) goto L6;
        if (this.tokens.get(r5).getChannel() == this.channel) goto L6;
        r5 = r5 - 1;
    L6:
        return r5;
    }

    public CommonTokenStream(TokenSource r5) {
        super(r5);
        this.channel = 0;
    }

    public CommonTokenStream(TokenSource r5, int r10) {
        this(r5);
        this.channel = r10;
    }
}
