package androidx.room.jarjarred.org.antlr.runtime.tree;

/* JADX INFO: loaded from: classes.dex */
public class TreePatternLexer {
    public static final int ARG = 4;
    public static final int BEGIN = 1;
    public static final int COLON = 6;
    public static final int DOT = 7;
    public static final int END = 2;
    public static final int EOF = -1;
    public static final int ID = 3;
    public static final int PERCENT = 5;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f637c;
    public boolean error;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected int f638n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected int f639p;
    protected String pattern;
    public StringBuffer sval;

    public TreePatternLexer(String r5) {
        this.f639p = -1;
        this.sval = new StringBuffer();
        this.error = false;
        this.pattern = r5;
        this.f638n = r5.length();
        consume();
    }

    public void consume() {
        int r5 = this.f639p + 1;
        this.f639p = r5;
        if (r5 < this.f638n) goto L5;
        this.f637c = -1;
        return;
    L5:
        this.f637c = this.pattern.charAt(r5);
    }

    public int nextToken() {
        this.sval.setLength(0);
    L3:
        int r5 = this.f637c;
        if (r5 == (-1)) goto L72;
        if (r5 == 32) goto L71;
        if (r5 == 10) goto L71;
        if (r5 == 13) goto L71;
        if (r5 == 9) goto L71;
        if (r5 < 97) goto L17;
        if (r5 > 122) goto L17;
    L20:
        this.sval.append((char) r5);
        consume();
    L21:
        int r10 = this.f637c;
        if (r10 < 97) goto L24;
        if (r10 > 122) goto L24;
    L31:
        this.sval.append((char) r10);
        consume();
    L24:
        if (r10 < 65) goto L27;
        if (r10 <= 90) goto L31;
    L27:
        if (r10 >= 48) goto L29;
    L30:
        if (r10 == 95) goto L31;
        return 3;
    L29:
        if (r10 <= 57) goto L31;
    L17:
        if (r5 < 65) goto L19;
        if (r5 <= 90) goto L20;
    L19:
        if (r5 == 95) goto L20;
        if (r5 != 40) goto L39;
        consume();
        return 1;
    L39:
        if (r5 != 41) goto L43;
        consume();
        return 2;
    L43:
        if (r5 != 37) goto L47;
        consume();
        return 5;
    L47:
        if (r5 != 58) goto L51;
        consume();
        return 6;
    L51:
        if (r5 != 46) goto L55;
        consume();
        return 7;
    L55:
        if (r5 != 91) goto L69;
        consume();
    L57:
        int r11 = this.f637c;
        if (r11 == 93) goto L67;
        if (r11 != 92) goto L65;
        consume();
        if (this.f637c == 93) goto L64;
        this.sval.append('\\');
    L64:
        this.sval.append((char) this.f637c);
    L66:
        consume();
        goto L57
    L65:
        this.sval.append((char) r11);
        goto L66
    L67:
        consume();
        return 4;
    L69:
        consume();
        this.error = true;
        return -1;
    L71:
        consume();
        goto L3
    L72:
        return -1;
    }
}
