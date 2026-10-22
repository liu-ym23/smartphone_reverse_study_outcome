package com.bytedance.crash.dumper.tools;

/* JADX INFO: loaded from: classes.dex */
public class StringDumper {
    private static final char[] CHARS_FALSE = null;
    private static final char[] CHARS_TRUE = null;
    private final BaseStringDumper mDumper;

    static {
        CHARS_TRUE = new char[]{'t', 'r', 'u', 'e'};
        CHARS_FALSE = new char[]{'f', 'a', 'l', 's', 'e'};
    }

    public StringDumper(String r10) {
        this.mDumper = createDumper(r10);
    }

    private BaseStringDumper createDumper(String r10) {
        return new CachedStringDumper(r10);
    L5:
        return new DirectStringDumper(r10);
    }

    public StringDumper append(char r10) {
        this.mDumper.append(r10);
        return this;
    }

    public StringDumper append(int r10) {
        this.mDumper.append(r10);
        return this;
    }

    public StringDumper append(long r10) {
        this.mDumper.append(r10);
        return this;
    }

    public StringDumper append(String r10) {
        if (r10 == null) goto L4;
        this.mDumper.append(r10);
    L4:
        return this;
    }

    public StringDumper append(Throwable r10) {
        append(r10.getClass().getName());
        String r11 = r10.getLocalizedMessage();
        if (r11 == null) goto L5;
        append(':').append(' ').append(r11);
    L5:
        return this;
    }

    public StringDumper append(boolean r10) {
        if (r10 == false) goto L4;
        this.mDumper.append(CHARS_TRUE);
    L5:
        return this;
    L4:
        this.mDumper.append(CHARS_FALSE);
        goto L5
    }

    public StringDumper append(byte[] r10) {
        this.mDumper.append(r10);
        return this;
    }

    public StringDumper append(char[] r10) {
        this.mDumper.append(r10);
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
