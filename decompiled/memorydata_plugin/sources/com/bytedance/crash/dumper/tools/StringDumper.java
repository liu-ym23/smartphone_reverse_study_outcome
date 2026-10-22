package com.bytedance.crash.dumper.tools;

/* JADX INFO: loaded from: classes2.dex */
public class StringDumper {
    private static final char[] CHARS_FALSE = null;
    private static final char[] CHARS_TRUE = null;
    private final BaseStringDumper mDumper;

    static {
        CHARS_TRUE = new char[]{'t', 'r', 'u', 'e'};
        CHARS_FALSE = new char[]{'f', 'a', 'l', 's', 'e'};
    }

    public StringDumper(String r1) {
        this.mDumper = createDumper(r1);
    }

    private BaseStringDumper createDumper(String r1) {
        return new CachedStringDumper(r1);
    L5:
        return new DirectStringDumper(r1);
    }

    public StringDumper append(char r2) {
        this.mDumper.append(r2);
        return this;
    }

    public StringDumper append(int r2) {
        this.mDumper.append(r2);
        return this;
    }

    public StringDumper append(long r2) {
        this.mDumper.append(r2);
        return this;
    }

    public StringDumper append(String r2) {
        if (r2 == null) goto L4;
        this.mDumper.append(r2);
    L4:
        return this;
    }

    public StringDumper append(Throwable r3) {
        append(r3.getClass().getName());
        String r4 = r3.getLocalizedMessage();
        if (r4 == null) goto L5;
        append(':').append(' ').append(r4);
    L5:
        return this;
    }

    public StringDumper append(boolean r2) {
        if (r2 == false) goto L4;
        this.mDumper.append(CHARS_TRUE);
    L5:
        return this;
    L4:
        this.mDumper.append(CHARS_FALSE);
        goto L5
    }

    public StringDumper append(byte[] r2) {
        this.mDumper.append(r2);
        return this;
    }

    public StringDumper append(char[] r2) {
        this.mDumper.append(r2);
        return this;
    }

    public StringDumper flush() {
        this.mDumper.flush();
        return this;
    }

    public StringDumper release() {
        this.mDumper.release();
        return this;
    }
}
