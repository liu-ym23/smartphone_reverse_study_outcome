package androidx.room.jarjarred.org.antlr.v4.runtime;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Interval;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class UnbufferedCharStream implements CharStream {
    protected int currentCharIndex;
    protected int[] data;
    protected Reader input;
    protected int lastChar;
    protected int lastCharBufferStart;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected int f656n;
    public String name;
    protected int numMarkers;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected int f657p;

    public UnbufferedCharStream() {
        this(256);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public int LA(int r5) {
        if (r5 == (-1)) goto L5;
        sync(r5);
        int r10 = (this.f657p + r5) - 1;
        if (r10 < 0) goto L14;
        if (r10 < this.f656n) goto L12;
        return -1;
    L12:
        return this.data[r10];
    L14:
        throw new IndexOutOfBoundsException();
    L5:
        return this.lastChar;
    }

    public void add(int r5) {
        int r10 = this.f656n;
        int[] r11 = this.data;
        if (r10 < r11.length) goto L5;
        this.data = Arrays.copyOf(r11, r11.length * 2);
    L5:
        int[] r12 = this.data;
        int r13 = this.f656n;
        this.f656n = r13 + 1;
        r12[r13] = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public void consume() {
        if (LA(1) == (-1)) goto L12;
        int[] r5 = this.data;
        int r10 = this.f657p;
        int r11 = r5[r10];
        this.lastChar = r11;
        if (r10 == (this.f656n - 1)) goto L7;
    L9:
        this.f657p++;
        this.currentCharIndex++;
        sync(1);
        return;
    L7:
        if (this.numMarkers != 0) goto L9;
        this.f656n = 0;
        this.f657p = -1;
        this.lastCharBufferStart = r11;
        goto L9
    L12:
        throw new IllegalStateException("cannot consume EOF");
    }

    public int fill(int r10) {
        int r5 = 0;
    L3:
        if (r5 >= r10) goto L38;
        int r11 = this.f656n;
        if (r11 > 0) goto L7;
    L39:
        int r12 = nextChar();     // Catch: IOException -> L23
        if (r12 > 65535) goto L34;
        if (r12 == (-1)) goto L34;
        char r13 = (char) r12;     // Catch: IOException -> L23
        if (Character.isLowSurrogate(r13) == true) goto L33;
        if (Character.isHighSurrogate(r13) == false) goto L31;
        int r14 = nextChar();     // Catch: IOException -> L23
        if (r14 > 65535) goto L30;
        if (r14 == (-1)) goto L28;
        char r15 = (char) r14;     // Catch: IOException -> L23
        if (Character.isLowSurrogate(r15) == false) goto L26;
        add(Character.toCodePoint(r13, r15));     // Catch: IOException -> L23
    L35:
        r5 = r5 + 1;
        goto L3
    L26:
        throw new RuntimeException("Invalid UTF-16 (dangling high surrogate");     // Catch: IOException -> L23
    L28:
        throw new RuntimeException("Invalid UTF-16 (dangling high surrogate at end of file)");     // Catch: IOException -> L23
    L30:
        throw new RuntimeException("Invalid UTF-16 (high surrogate followed by code point > U+FFFF");     // Catch: IOException -> L23
    L31:
        add(r12);     // Catch: IOException -> L23
        goto L35
    L33:
        throw new RuntimeException("Invalid UTF-16 (low surrogate with no preceding high surrogate)");     // Catch: IOException -> L23
    L34:
        add(r12);     // Catch: IOException -> L23
    L23:
        e = move-exception;
        throw new RuntimeException(e);
    L7:
        if (this.data[r11 - 1] != (-1)) goto L39;
        return r5;
    L38:
        return r10;
    }

    public final int getBufferStartIndex() {
        return this.currentCharIndex - this.f657p;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public String getSourceName() {
        String r5 = this.name;
        if (r5 != null) goto L5;
        return IntStream.UNKNOWN_SOURCE_NAME;
    L5:
        if (r5.isEmpty() == false) goto L8;
        return IntStream.UNKNOWN_SOURCE_NAME;
    L8:
        return this.name;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.CharStream
    public String getText(Interval r5) {
        int r10 = r5.f665a;
        if (r10 < 0) goto L24;
        if (r5.f666b < (r10 - 1)) goto L24;
        int r11 = getBufferStartIndex();
        int r12 = this.f656n;
        if (r12 > 0) goto L9;
    L15:
        int r13 = r5.f665a;
        if (r13 >= r11) goto L18;
    L21:
        StringBuilder r14 = new StringBuilder("interval ");
        r14.append(r5);
        r14.append(" outside buffer: ");
        r14.append(r11);
        r14.append("..");
        r14.append((r11 + this.f656n) - 1);
        throw new UnsupportedOperationException(r14.toString());
    L18:
        if (r5.f666b >= (this.f656n + r11)) goto L21;
        return new String(this.data, r13 - r11, r5.length());
    L9:
        if (this.data[r12 - 1] != 65535) goto L15;
        if ((r5.length() + r5.f665a) <= (this.f656n + r11)) goto L15;
        throw new IllegalArgumentException("the interval extends past the end of the stream");
    L24:
        throw new IllegalArgumentException("invalid interval");
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public int index() {
        return this.currentCharIndex;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public int mark() {
        int r5 = this.numMarkers;
        if (r5 != 0) goto L5;
        this.lastCharBufferStart = this.lastChar;
    L5:
        int r10 = (-r5) - 1;
        this.numMarkers = r5 + 1;
        return r10;
    }

    public int nextChar() throws IOException {
        return this.input.read();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public void release(int r5) {
        int r10 = this.numMarkers;
        if (r5 != (-r10)) goto L11;
        int r11 = r10 - 1;
        this.numMarkers = r11;
        if (r11 != 0) goto L12;
        int r12 = this.f657p;
        if (r12 <= 0) goto L13;
        int[] r13 = this.data;
        System.arraycopy(r13, r12, r13, 0, this.f656n - r12);
        this.f656n -= this.f657p;
        this.f657p = 0;
        this.lastCharBufferStart = this.lastChar;
        return;
    L13:
        return;
    L12:
        return;
    L11:
        throw new IllegalStateException("release() called with an invalid marker.");
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public void seek(int r5) {
        int r10 = this.currentCharIndex;
        if (r5 != r10) goto L5;
        return;
    L5:
        if (r5 <= r10) goto L7;
        sync(r5 - r10);
        r5 = Math.min(r5, (getBufferStartIndex() + this.f656n) - 1);
    L7:
        int r11 = r5 - getBufferStartIndex();
        if (r11 < 0) goto L19;
        if (r11 >= this.f656n) goto L16;
        this.f657p = r11;
        this.currentCharIndex = r5;
        if (r11 != 0) goto L14;
        this.lastChar = this.lastCharBufferStart;
        return;
    L14:
        this.lastChar = this.data[r11 - 1];
        return;
    L16:
        StringBuilder r12 = j0.s(r5, "seek to index outside buffer: ", " not in ");
        r12.append(getBufferStartIndex());
        r12.append("..");
        r12.append(getBufferStartIndex() + this.f656n);
        throw new UnsupportedOperationException(r12.toString());
    L19:
        throw new IllegalArgumentException(j0.g(r5, "cannot seek to negative index "));
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public int size() {
        throw new UnsupportedOperationException("Unbuffered stream cannot know its size");
    }

    public void sync(int r5) {
        int r10 = (((this.f657p + r5) - 1) - this.f656n) + 1;
        if (r10 <= 0) goto L6;
        fill(r10);
        return;
    }

    public UnbufferedCharStream(int r5) {
        this.f657p = 0;
        this.numMarkers = 0;
        this.lastChar = -1;
        this.currentCharIndex = 0;
        this.f656n = 0;
        this.data = new int[r5];
    }

    public UnbufferedCharStream(InputStream r5) {
        this(r5, 256);
    }

    public UnbufferedCharStream(Reader r5) {
        this(r5, 256);
    }

    public UnbufferedCharStream(InputStream r5, int r10) {
        this(r5, r10, StandardCharsets.UTF_8);
    }

    public UnbufferedCharStream(InputStream r5, int r10, Charset r11) {
        this(r10);
        this.input = new InputStreamReader(r5, r11);
        fill(1);
    }

    public UnbufferedCharStream(Reader r5, int r10) {
        this(r10);
        this.input = r5;
        fill(1);
    }
}
