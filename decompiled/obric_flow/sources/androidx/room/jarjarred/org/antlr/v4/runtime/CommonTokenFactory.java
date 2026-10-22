package androidx.room.jarjarred.org.antlr.v4.runtime;

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Interval;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Pair;

/* JADX INFO: loaded from: classes.dex */
public class CommonTokenFactory implements TokenFactory<CommonToken> {
    public static final TokenFactory<CommonToken> DEFAULT = null;
    protected final boolean copyText;

    static {
        DEFAULT = new CommonTokenFactory();
    }

    public CommonTokenFactory(boolean r5) {
        this.copyText = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenFactory
    public /* bridge */ /* synthetic */ Token create(int r5, String r10) {
        return create(r5, r10);
    }

    public CommonTokenFactory() {
        this(false);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenFactory
    public /* bridge */ /* synthetic */ Token create(Pair r5, int r10, String r11, int r12, int r13, int r14, int r15, int r16) {
        return create(r5, r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenFactory
    public CommonToken create(Pair<TokenSource, CharStream> r10, int r11, String r12, int r13, int r14, int r15, int r16, int r17) {
        CommonToken r18 = new CommonToken(r10, r11, r13, r14, r15);
        r18.setLine(r16);
        r18.setCharPositionInLine(r17);
        if (r12 == null) goto L6;
        r18.setText(r12);
    L10:
        return r18;
    L6:
        if (this.copyText == false) goto L10;
        CharStream r19 = r10.f668b;
        if (r19 == null) goto L10;
        r18.setText(r19.getText(Interval.of(r14, r15)));
        goto L10
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenFactory
    public CommonToken create(int r5, String r10) {
        return new CommonToken(r5, r10);
    }
}
