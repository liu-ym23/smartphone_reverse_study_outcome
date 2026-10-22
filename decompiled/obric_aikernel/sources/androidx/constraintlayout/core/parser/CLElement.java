package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes.dex */
public class CLElement {
    protected static int BASE_INDENT = 2;
    protected static int MAX_LINE = 80;
    protected long end;
    private int line;
    protected CLContainer mContainer;
    private final char[] mContent;
    protected long start;

    static {
    }

    public CLElement(char[] r10) {
        this.start = -1;
        this.end = Long.MAX_VALUE;
        this.mContent = r10;
    }

    protected void addIndent(StringBuilder r10, int r11) {
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.append(' ');
        r12 = r12 + 1;
        goto L3
    }

    public String content() {
        String r10 = new String(this.mContent);
        long r11 = this.end;
        if (r11 == Long.MAX_VALUE) goto L10;
        long r12 = this.start;
        if (r11 < r12) goto L10;
        int r13 = (int) r12;
    L9:
        return r10.substring(r13, ((int) r11) + 1);
    L10:
        r11 = this.start;
        r13 = (int) r11;
        goto L9
    }

    public CLElement getContainer() {
        return this.mContainer;
    }

    protected String getDebugName() {
        if (CLParser.DEBUG == true) goto L5;
        return "";
    L5:
        return getStrClass() + " -> ";
    }

    public long getEnd() {
        return this.end;
    }

    public float getFloat() {
        if ((this instanceof CLNumber) == true) goto L5;
        return Float.NaN;
    L5:
        return ((CLNumber) this).getFloat();
    }

    public int getInt() {
        if ((this instanceof CLNumber) == true) goto L5;
        return 0;
    L5:
        return ((CLNumber) this).getInt();
    }

    public int getLine() {
        return this.line;
    }

    public long getStart() {
        return this.start;
    }

    protected String getStrClass() {
        String r10 = getClass().toString();
        return r10.substring(r10.lastIndexOf(46) + 1);
    }

    public boolean isDone() {
        if (this.end == Long.MAX_VALUE) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isStarted() {
        if (this.start <= (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean notStarted() {
        if (this.start != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public void setContainer(CLContainer r10) {
        this.mContainer = r10;
    }

    public void setEnd(long r10) {
        if (this.end == Long.MAX_VALUE) goto L5;
        return;
    L5:
        this.end = r10;
        if (CLParser.DEBUG == false) goto L8;
        System.out.println("closing " + hashCode() + " -> " + this);
    L8:
        CLContainer r11 = this.mContainer;
        if (r11 == null) goto L12;
        r11.add(this);
        return;
    }

    public void setLine(int r10) {
        this.line = r10;
    }

    public void setStart(long r10) {
        this.start = r10;
    }

    protected String toFormattedJSON(int r10, int r11) {
        return "";
    }

    protected String toJSON() {
        return "";
    }

    public String toString() {
        long r10 = this.start;
        long r11 = this.end;
        if (r10 > r11) goto L10;
        if (r11 == Long.MAX_VALUE) goto L10;
        return getStrClass() + " (" + this.start + " : " + this.end + ") <<" + new String(this.mContent).substring((int) this.start, ((int) this.end) + 1) + ">>";
    L10:
        return getClass() + " (INVALID, " + this.start + "-" + this.end + ")";
    }
}
