package org.apache.commons.io.input;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Reader;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class CharSequenceReader extends Reader implements Serializable {
    private static final long serialVersionUID = 3724187752191401220L;
    private final CharSequence charSequence;
    private final Integer end;
    private int idx;
    private int mark;
    private final int start;

    public CharSequenceReader(CharSequence r3) {
        this((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), 0);
    }

    public CharSequenceReader(CharSequence r3, int r4) {
        this((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4, Integer.MAX_VALUE);
    }

    public CharSequenceReader(CharSequence r3, int r4, int r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 < 0) goto L13;
        if (r5 < r4) goto L11;
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        this.charSequence = r6;
        this.start = r4;
        this.end = Integer.valueOf(r5);
        this.idx = r4;
        this.mark = r4;
        return;
    L11:
        throw new IllegalArgumentException("End index is less than start " + r4 + ": " + r5);
    L13:
        throw new IllegalArgumentException("Start index is less than zero: " + r4);
    }

    private int end() {
        int r0 = this.charSequence.length();
        Integer r1 = this.end;
        if (r1 != null) goto L5;
        int r2 = Integer.MAX_VALUE;
    L7:
        return Math.min(r0, r2);
    L5:
        r2 = r1.intValue();
        goto L7
    }

    private int start() {
        return Math.min(this.charSequence.length(), this.start);
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        int r0 = this.start;
        this.idx = r0;
        this.mark = r0;
    }

    @Override // java.io.Reader
    public void mark(int r1) {
        this.mark = this.idx;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader
    public int read() {
        if (this.idx < end()) goto L6;
        return -1;
    L6:
        CharSequence r0 = this.charSequence;
        int r1 = this.idx;
        this.idx = r1 + 1;
        return r0.charAt(r1);
    }

    @Override // java.io.Reader
    public int read(char[] r6, int r7, int r8) {
        if (this.idx < end()) goto L5;
        return -1;
    L5:
        Objects.requireNonNull(r6, "array");
        if (r8 < 0) goto L29;
        if (r7 < 0) goto L29;
        if ((r7 + r8) > r6.length) goto L29;
        if (ZeusTransformUtils.instanceOf(this.charSequence, String.class) == false) goto L16;
        int r9 = Math.min(r8, end() - this.idx);
        String r0 = (String) ZeusTransformUtils.preCheckCast(this.charSequence, String.class, "com.obric.memorydata.plugin");
        int r1 = this.idx;
        r0.getChars(r1, r1 + r9, r6, r7);
    L13:
        this.idx += r9;
        return r9;
    L16:
        if (ZeusTransformUtils.instanceOf(this.charSequence, StringBuilder.class) == false) goto L19;
        r9 = Math.min(r8, end() - this.idx);
        StringBuilder r2 = (StringBuilder) ZeusTransformUtils.preCheckCast(this.charSequence, StringBuilder.class, "com.obric.memorydata.plugin");
        int r3 = this.idx;
        r2.getChars(r3, r3 + r9, r6, r7);
        goto L13
    L19:
        if (ZeusTransformUtils.instanceOf(this.charSequence, StringBuffer.class) == false) goto L21;
        r9 = Math.min(r8, end() - this.idx);
        StringBuffer r4 = (StringBuffer) ZeusTransformUtils.preCheckCast(this.charSequence, StringBuffer.class, "com.obric.memorydata.plugin");
        int r5 = this.idx;
        r4.getChars(r5, r5 + r9, r6, r7);
        goto L13
    L21:
        int r10 = 0;
        int r11 = 0;
    L22:
        if (r10 >= r8) goto L27;
        int r12 = read();
        if (r12 == (-1)) goto L25;
        r6[r7 + r10] = (char) r12;
        r11 = r11 + 1;
        r10 = r10 + 1;
        goto L22
    L25:
        return r11;
    L27:
        return r11;
    L29:
        throw new IndexOutOfBoundsException("Array Size=" + r6.length + ", offset=" + r7 + ", length=" + r8);
    }

    @Override // java.io.Reader
    public boolean ready() {
        if (this.idx >= end()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.io.Reader
    public void reset() {
        this.idx = this.mark;
    }

    @Override // java.io.Reader
    public long skip(long r5) {
        if (r5 < 0) goto L10;
        if (this.idx < end()) goto L7;
        return 0;
    L7:
        int r6 = (int) Math.min(end(), ((long) this.idx) + r5);
        int r7 = r6 - this.idx;
        this.idx = r6;
        return r7;
    L10:
        throw new IllegalArgumentException("Number of characters to skip is less than zero: " + r5);
    }

    public String toString() {
        return this.charSequence.subSequence(start(), end()).toString();
    }
}
