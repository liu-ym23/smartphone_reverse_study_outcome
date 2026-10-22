package org.apache.commons.csv;

import java.io.BufferedReader;
import java.io.Reader;

/* JADX INFO: loaded from: classes6.dex */
final class ExtendedBufferedReader extends BufferedReader {
    private boolean closed;
    private long eolCounter;
    private int lastChar;
    private long position;

    ExtendedBufferedReader(Reader r1) {
        super(r1);
        this.lastChar = -2;
    }

    @Override // java.io.BufferedReader, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
        this.lastChar = -1;
        super.close();
    }

    long getCurrentLineNumber() {
        int r0 = this.lastChar;
        if (r0 == 13) goto L14;
        if (r0 == 10) goto L14;
        if (r0 == (-2)) goto L14;
        if (r0 == (-1)) goto L14;
        return this.eolCounter + 1;
    L14:
        return this.eolCounter;
    }

    int getLastChar() {
        return this.lastChar;
    }

    long getPosition() {
        return this.position;
    }

    public boolean isClosed() {
        return this.closed;
    }

    int lookAhead() {
        super.mark(1);
        int r0 = super.read();
        super.reset();
        return r0;
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public int read() {
        int r0 = super.read();
        if (r0 != 13) goto L5;
    L8:
        this.eolCounter++;
    L9:
        this.lastChar = r0;
        this.position++;
        return r0;
    L5:
        if (r0 != 10) goto L9;
        if (this.lastChar == 13) goto L9;
        goto L8
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public int read(char[] r7, int r8, int r9) {
        if (r9 != 0) goto L5;
        return 0;
    L5:
        int r10 = super.read(r7, r8, r9);
        if (r10 <= 0) goto L21;
        int r0 = r8;
    L8:
        int r1 = r8 + r10;
        if (r0 >= r1) goto L20;
        char r2 = r7[r0];
        if (r2 != '\n') goto L17;
        if (r0 <= 0) goto L14;
        int r3 = r7[r0 - 1];
    L15:
        if (13 == r3) goto L19;
    L18:
        this.eolCounter++;
    L19:
        r0 = r0 + 1;
        goto L8
    L14:
        r3 = this.lastChar;
        goto L15
    L17:
        if (r2 != '\r') goto L19;
    L20:
        int r11 = r7[r1 - 1];
    L23:
        this.lastChar = r11;
    L24:
        this.position += (long) r10;
        return r10;
    L21:
        r11 = -1;
        if (r10 != (-1)) goto L24;
        goto L23
    }

    @Override // java.io.BufferedReader
    public String readLine() {
        String r0 = super.readLine();
        if (r0 == null) goto L5;
        this.lastChar = 10;
        this.eolCounter++;
    L6:
        return r0;
    L5:
        this.lastChar = -1;
        goto L6
    }
}
