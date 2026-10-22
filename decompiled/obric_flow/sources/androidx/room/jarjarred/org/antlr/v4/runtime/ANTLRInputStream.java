package androidx.room.jarjarred.org.antlr.v4.runtime;

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Interval;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ANTLRInputStream implements CharStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int INITIAL_BUFFER_SIZE = 1024;
    public static final int READ_BUFFER_SIZE = 1024;
    protected char[] data;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected int f652n;
    public String name;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected int f653p;

    public ANTLRInputStream() {
        this.f653p = 0;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public int LA(int r5) {
        if (r5 != 0) goto L6;
        return 0;
    L6:
        if (r5 >= 0) goto L10;
        r5 = r5 + 1;
        if (((this.f653p + r5) - 1) >= 0) goto L10;
        return -1;
    L10:
        int r10 = this.f653p;
        if (((r10 + r5) - 1) < this.f652n) goto L14;
        return -1;
    L14:
        return this.data[(r10 + r5) - 1];
    }

    public int LT(int r5) {
        return LA(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public void consume() {
        int r5 = this.f653p;
        int r10 = this.f652n;
        if (r5 >= r10) goto L8;
        if (r5 >= r10) goto L9;
        this.f653p = r5 + 1;
        return;
    L9:
        return;
    L8:
        throw new IllegalStateException("cannot consume EOF");
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
        int r11 = r5.f666b;
        int r12 = this.f652n;
        if (r11 < r12) goto L5;
        r11 = r12 - 1;
    L5:
        int r13 = (r11 - r10) + 1;
        if (r10 < r12) goto L10;
        return "";
    L10:
        return new String(this.data, r10, r13);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public int index() {
        return this.f653p;
    }

    public void load(Reader r5, int r10, int r11) throws IOException {
        if (r5 != null) goto L5;
        return;
    L5:
        if (r10 > 0) goto L7;
        r10 = 1024;
    L7:
        if (r11 > 0) goto L22;
        r11 = 1024;
    L22:
        this.data = new char[r10];     // Catch: Throwable -> L13
        int r12 = 0;
    L10:
        int r13 = r12 + r11;     // Catch: Throwable -> L13
        char[] r14 = this.data;     // Catch: Throwable -> L13
        if (r13 <= r14.length) goto L15;
        this.data = Arrays.copyOf(r14, r14.length * 2);     // Catch: Throwable -> L13
    L15:
        int r15 = r5.read(this.data, r12, r11);     // Catch: Throwable -> L13
        r12 = r12 + r15;     // Catch: Throwable -> L13
        if (r15 != (-1)) goto L10;
        this.f652n = r12 + 1;     // Catch: Throwable -> L13
        r5.close();
        return;
    L13:
        th = move-exception;
        r5.close();
        throw th;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public int mark() {
        return -1;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public void release(int r5) {
    }

    public void reset() {
        this.f653p = 0;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public void seek(int r5) {
        if (r5 > this.f653p) goto L6;
        this.f653p = r5;
        return;
    L6:
        int r10 = Math.min(r5, this.f652n);
    L8:
        if (this.f653p >= r10) goto L10;
        consume();
        goto L8
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public int size() {
        return this.f652n;
    }

    public String toString() {
        return new String(this.data);
    }

    public ANTLRInputStream(String r5) {
        this.f653p = 0;
        this.data = r5.toCharArray();
        this.f652n = r5.length();
    }

    public ANTLRInputStream(char[] r5, int r10) {
        this.f653p = 0;
        this.data = r5;
        this.f652n = r10;
    }

    public ANTLRInputStream(Reader r5) throws IOException {
        this(r5, 1024, 1024);
    }

    public ANTLRInputStream(Reader r5, int r10) throws IOException {
        this(r5, r10, 1024);
    }

    public ANTLRInputStream(Reader r5, int r10, int r11) throws IOException {
        this.f653p = 0;
        load(r5, r10, r11);
    }

    public ANTLRInputStream(InputStream r5) throws IOException {
        this(new InputStreamReader(r5), 1024);
    }

    public ANTLRInputStream(InputStream r5, int r10) throws IOException {
        this(new InputStreamReader(r5), r10);
    }

    public ANTLRInputStream(InputStream r5, int r10, int r11) throws IOException {
        this(new InputStreamReader(r5), r10, r11);
    }
}
