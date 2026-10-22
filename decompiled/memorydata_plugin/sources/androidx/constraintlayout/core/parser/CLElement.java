package androidx.constraintlayout.core.parser;

import com.volcengine.zeus.transform.ZeusTransformUtils;

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

    public CLElement(char[] r3) {
        this.start = -1;
        this.end = Long.MAX_VALUE;
        this.mContent = r3;
    }

    public void addIndent(StringBuilder r2, int r3) {
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L5;
        r2.append(' ');
        r1 = r1 + 1;
        goto L3
    }

    public String content() {
        String r0 = new String(this.mContent);
        long r1 = this.end;
        if (r1 == Long.MAX_VALUE) goto L10;
        long r3 = this.start;
        if (r1 < r3) goto L10;
        int r6 = (int) r3;
    L9:
        return r0.substring(r6, ((int) r1) + 1);
    L10:
        r1 = this.start;
        r6 = (int) r1;
        goto L9
    }

    public CLElement getContainer() {
        return this.mContainer;
    }

    public String getDebugName() {
        if (CLParser.DEBUG == true) goto L5;
        return "";
    L5:
        return getStrClass() + " -> ";
    }

    public long getEnd() {
        return this.end;
    }

    public float getFloat() {
        if (ZeusTransformUtils.instanceOf(this, CLNumber.class) == true) goto L5;
        return Float.NaN;
    L5:
        return ((CLNumber) ZeusTransformUtils.preCheckCast(this, CLNumber.class, "com.obric.memorydata.plugin")).getFloat();
    }

    public int getInt() {
        if (ZeusTransformUtils.instanceOf(this, CLNumber.class) == true) goto L5;
        return 0;
    L5:
        return ((CLNumber) ZeusTransformUtils.preCheckCast(this, CLNumber.class, "com.obric.memorydata.plugin")).getInt();
    }

    public int getLine() {
        return this.line;
    }

    public long getStart() {
        return this.start;
    }

    public String getStrClass() {
        String r1 = getClass().toString();
        return r1.substring(r1.lastIndexOf(46) + 1);
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

    public void setContainer(CLContainer r1) {
        this.mContainer = r1;
    }

    public void setEnd(long r5) {
        if (this.end == Long.MAX_VALUE) goto L5;
        return;
    L5:
        this.end = r5;
        if (CLParser.DEBUG == false) goto L8;
        System.out.println("closing " + hashCode() + " -> " + this);
    L8:
        CLContainer r6 = this.mContainer;
        if (r6 == null) goto L12;
        r6.add(this);
        return;
    }

    public void setLine(int r1) {
        this.line = r1;
    }

    public void setStart(long r1) {
        this.start = r1;
    }

    public String toFormattedJSON(int r1, int r2) {
        return "";
    }

    public String toJSON() {
        return "";
    }

    public String toString() {
        long r0 = this.start;
        long r2 = this.end;
        if (r0 <= r2) goto L5;
    L10:
        StringBuilder r4 = new StringBuilder().append(getClass()).append(" (INVALID, ").append(this.start).append("-").append(this.end);
        String r1 = ")";
    L9:
        return r4.append(r1).toString();
    L5:
        if (r2 == Long.MAX_VALUE) goto L10;
        String r3 = new String(this.mContent).substring((int) this.start, ((int) this.end) + 1);
        r4 = new StringBuilder().append(getStrClass()).append(" (").append(this.start).append(" : ").append(this.end).append(") <<").append(r3);
        r1 = ">>";
        goto L9
    }
}
