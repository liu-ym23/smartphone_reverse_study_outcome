package androidx.room.jarjarred.org.antlr.runtime;

import ai.j0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class LegacyCommonTokenStream implements TokenStream {
    protected int channel;
    protected Map<Integer, Integer> channelOverrideMap;
    protected boolean discardOffChannelTokens;
    protected Set<Integer> discardSet;
    protected int lastMarker;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected int f623p;
    protected int range;
    protected TokenSource tokenSource;
    protected List<Token> tokens;

    public LegacyCommonTokenStream() {
        this.channel = 0;
        this.discardOffChannelTokens = false;
        this.range = -1;
        this.f623p = -1;
        this.tokens = new ArrayList(500);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public int LA(int r5) {
        return LT(r5).getType();
    }

    public Token LB(int r5) {
        if (this.f623p != (-1)) goto L6;
        fillBuffer();
    L6:
        if (r5 != 0) goto L8;
        return null;
    L8:
        int r10 = this.f623p;
        if ((r10 - r5) >= 0) goto L11;
        return null;
    L11:
        int r11 = 1;
    L12:
        if (r11 > r5) goto L14;
        r10 = skipOffTokenChannelsReverse(r10 - 1);
        r11 = r11 + 1;
        goto L12
    L14:
        if (r10 >= 0) goto L17;
        return null;
    L17:
        return this.tokens.get(r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.TokenStream
    public Token LT(int r5) {
        if (this.f623p != (-1)) goto L5;
        fillBuffer();
    L5:
        if (r5 != 0) goto L8;
        return null;
    L8:
        if (r5 >= 0) goto L12;
        return LB(-r5);
    L12:
        if (((this.f623p + r5) - 1) >= this.tokens.size()) goto L14;
        int r10 = this.f623p;
        int r11 = 1;
    L16:
        if (r11 >= r5) goto L19;
        r10 = skipOffTokenChannels(r10 + 1);
        r11 = r11 + 1;
        goto L16
    L19:
        if (r10 < this.tokens.size()) goto L23;
        return (Token) j0.e(this.tokens, 1);
    L23:
        if (r10 <= this.range) goto L26;
        this.range = r10;
    L26:
        return this.tokens.get(r10);
    L14:
        return (Token) j0.e(this.tokens, 1);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void consume() {
        if (this.f623p >= this.tokens.size()) goto L6;
        int r5 = this.f623p + 1;
        this.f623p = r5;
        this.f623p = skipOffTokenChannels(r5);
        return;
    }

    public void discardOffChannelTokens(boolean r5) {
        this.discardOffChannelTokens = r5;
    }

    public void discardTokenType(int r5) {
        if (this.discardSet != null) goto L5;
        this.discardSet = new HashSet();
    L5:
        this.discardSet.add(Integer.valueOf(r5));
    }

    public void fillBuffer() {
        Token r5 = this.tokenSource.nextToken();
        int r10 = 0;
    L3:
        if (r5 == null) goto L23;
        if (r5.getType() == (-1)) goto L23;
        Map<Integer, Integer> r11 = this.channelOverrideMap;
        if (r11 == null) goto L11;
        Integer r12 = r11.get(Integer.valueOf(r5.getType()));
        if (r12 == null) goto L11;
        r5.setChannel(r12.intValue());
    L11:
        Set<Integer> r13 = this.discardSet;
        if (r13 == null) goto L17;
        if (r13.contains(new Integer(r5.getType())) == false) goto L17;
    L22:
        r5 = this.tokenSource.nextToken();
    L17:
        if (this.discardOffChannelTokens == true) goto L19;
    L21:
        r5.setTokenIndex(r10);
        this.tokens.add(r5);
        r10 = r10 + 1;
        goto L22
    L19:
        if (r5.getChannel() == this.channel) goto L21;
    L23:
        this.f623p = 0;
        this.f623p = skipOffTokenChannels(0);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.TokenStream
    public Token get(int r5) {
        return this.tokens.get(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public String getSourceName() {
        return getTokenSource().getSourceName();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.TokenStream
    public TokenSource getTokenSource() {
        return this.tokenSource;
    }

    public List<? extends Token> getTokens() {
        if (this.f623p != (-1)) goto L6;
        fillBuffer();
    L6:
        return this.tokens;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public int index() {
        return this.f623p;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public int mark() {
        if (this.f623p != (-1)) goto L5;
        fillBuffer();
    L5:
        int r5 = index();
        this.lastMarker = r5;
        return r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.TokenStream
    public int range() {
        return this.range;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void release(int r5) {
    }

    public void reset() {
        this.f623p = 0;
        this.lastMarker = 0;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void rewind(int r5) {
        seek(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void seek(int r5) {
        this.f623p = r5;
    }

    public void setTokenSource(TokenSource r5) {
        this.tokenSource = r5;
        this.tokens.clear();
        this.f623p = -1;
        this.channel = 0;
    }

    public void setTokenTypeChannel(int r5, int r10) {
        if (this.channelOverrideMap != null) goto L5;
        this.channelOverrideMap = new HashMap();
    L5:
        this.channelOverrideMap.put(Integer.valueOf(r5), Integer.valueOf(r10));
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public int size() {
        return this.tokens.size();
    }

    public int skipOffTokenChannels(int r5) {
        int r10 = this.tokens.size();
    L3:
        if (r5 >= r10) goto L7;
        if (this.tokens.get(r5).getChannel() == this.channel) goto L7;
        r5 = r5 + 1;
    L7:
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

    public String toString() {
        if (this.f623p != (-1)) goto L6;
        fillBuffer();
    L6:
        return toString(0, this.tokens.size() - 1);
    }

    public List<? extends Token> get(int r5, int r10) {
        if (this.f623p != (-1)) goto L5;
        fillBuffer();
    L5:
        if (r5 < 0) goto L10;
        if (r10 >= 0) goto L9;
        return null;
    L9:
        return this.tokens.subList(r5, r10);
    L10:
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void rewind() {
        seek(this.lastMarker);
    }

    public List<? extends Token> getTokens(int r5, int r10) {
        return getTokens(r5, r10, null);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.TokenStream
    public String toString(int r5, int r10) {
        if (r5 < 0) goto L16;
        if (r10 >= 0) goto L6;
        return null;
    L6:
        if (this.f623p != (-1)) goto L9;
        fillBuffer();
    L9:
        if (r10 < this.tokens.size()) goto L11;
        r10 = this.tokens.size() - 1;
    L11:
        StringBuilder r11 = new StringBuilder();
    L12:
        if (r5 > r10) goto L15;
        r11.append(this.tokens.get(r5).getText());
        r5 = r5 + 1;
        goto L12
    L15:
        return r11.toString();
    L16:
        return null;
    }

    public List<? extends Token> getTokens(int r5, int r10, BitSet r11) {
        if (this.f623p != (-1)) goto L6;
        fillBuffer();
    L6:
        if (r10 < this.tokens.size()) goto L8;
        r10 = this.tokens.size() - 1;
    L8:
        if (r5 >= 0) goto L11;
        r5 = 0;
    L11:
        if (r5 <= r10) goto L13;
        return null;
    L13:
        ArrayList r12 = new ArrayList();
    L14:
        if (r5 > r10) goto L22;
        Token r13 = this.tokens.get(r5);
        if (r11 != null) goto L18;
    L19:
        r12.add(r13);
    L20:
        r5 = r5 + 1;
        goto L14
    L18:
        if (r11.member(r13.getType()) == false) goto L20;
    L22:
        if (r12.isEmpty() == false) goto L25;
        return null;
    L25:
        return r12;
    }

    public LegacyCommonTokenStream(TokenSource r5) {
        this();
        this.tokenSource = r5;
    }

    public LegacyCommonTokenStream(TokenSource r5, int r10) {
        this(r5);
        this.channel = r10;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.TokenStream
    public String toString(Token r5, Token r10) {
        if (r5 == null) goto L6;
        if (r10 != null) goto L5;
        return null;
    L5:
        return toString(r5.getTokenIndex(), r10.getTokenIndex());
    L6:
        return null;
    }

    public List<? extends Token> getTokens(int r5, int r10, List<Integer> r11) {
        return getTokens(r5, r10, new BitSet(r11));
    }

    public List<? extends Token> getTokens(int r5, int r10, int r11) {
        return getTokens(r5, r10, BitSet.of(r11));
    }
}
