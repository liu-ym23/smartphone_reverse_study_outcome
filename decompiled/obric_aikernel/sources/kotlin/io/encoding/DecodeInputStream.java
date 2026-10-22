package kotlin.io.encoding;

import java.io.IOException;
import java.io.InputStream;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@ExperimentalEncodingApi
final class DecodeInputStream extends InputStream {
    private final Base64 base64;
    private final byte[] byteBuffer;
    private int byteBufferEndIndex;
    private int byteBufferStartIndex;
    private final InputStream input;
    private boolean isClosed;
    private boolean isEOF;
    private final byte[] singleByteBuffer;
    private final byte[] symbolBuffer;

    public DecodeInputStream(InputStream r10, Base64 r11) {
        Intrinsics.checkNotNullParameter(r10, "input");
        Intrinsics.checkNotNullParameter(r11, "base64");
        this.input = r10;
        this.base64 = r11;
        this.singleByteBuffer = new byte[1];
        this.symbolBuffer = new byte[1024];
        this.byteBuffer = new byte[1024];
    }

    private final void copyByteBufferInto(byte[] r10, int r11, int r12) {
        byte[] r13 = this.byteBuffer;
        int r14 = this.byteBufferStartIndex;
        ArraysKt.copyInto(r13, r10, r11, r14, r14 + r12);
        this.byteBufferStartIndex += r12;
        resetByteBufferIfEmpty();
    }

    private final int decodeSymbolBufferInto(byte[] r10, int r11, int r12, int r13) {
        int r14 = this.byteBufferEndIndex;
        this.byteBufferEndIndex = r14 + this.base64.decodeIntoByteArray(this.symbolBuffer, this.byteBuffer, r14, 0, r13);
        int r15 = Math.min(getByteBufferLength(), r12 - r11);
        copyByteBufferInto(r10, r11, r15);
        shiftByteBufferToStartIfNeeded();
        return r15;
    }

    private final int getByteBufferLength() {
        return this.byteBufferEndIndex - this.byteBufferStartIndex;
    }

    private final int handlePaddingSymbol(int r10) {
        this.symbolBuffer[r10] = Base64.padSymbol;
        if ((r10 & 3) != 2) goto L9;
        int r11 = readNextSymbol();
        if (r11 < 0) goto L10;
        this.symbolBuffer[r10 + 1] = (byte) r11;
    L10:
        return r10 + 2;
    L9:
        return r10 + 1;
    }

    private final int readNextSymbol() {
        if (this.base64.isMimeScheme$kotlin_stdlib() == false) goto L5;
    L6:
        int r10 = this.input.read();
        if (r10 == (-1)) goto L10;
        if (Base64Kt.isInMimeAlphabet(r10) == false) goto L6;
    L10:
        return r10;
    L5:
        return this.input.read();
    }

    private final void resetByteBufferIfEmpty() {
        if (this.byteBufferStartIndex != this.byteBufferEndIndex) goto L6;
        this.byteBufferStartIndex = 0;
        this.byteBufferEndIndex = 0;
        return;
    }

    private final void shiftByteBufferToStartIfNeeded() {
        byte[] r10 = this.byteBuffer;
        int r11 = r10.length;
        int r12 = this.byteBufferEndIndex;
        if (((this.symbolBuffer.length / 4) * 3) <= (r11 - r12)) goto L6;
        ArraysKt.copyInto(r10, r10, 0, this.byteBufferStartIndex, r12);
        this.byteBufferEndIndex -= this.byteBufferStartIndex;
        this.byteBufferStartIndex = 0;
        return;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.isClosed == true) goto L6;
        this.isClosed = true;
        this.input.close();
        return;
    }

    @Override // java.io.InputStream
    public int read() {
        int r10 = this.byteBufferStartIndex;
        if (r10 >= this.byteBufferEndIndex) goto L6;
        int r11 = this.byteBuffer[r10] & 255;
        this.byteBufferStartIndex = r10 + 1;
        resetByteBufferIfEmpty();
        return r11;
    L6:
        int r12 = read(this.singleByteBuffer, 0, 1);
        if (r12 == (-1)) goto L12;
        if (r12 != 1) goto L11;
        return this.singleByteBuffer[0] & 255;
    L11:
        throw new IllegalStateException("Unreachable".toString());
    L12:
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "destination");
        if (r11 < 0) goto L51;
        if (r12 < 0) goto L51;
        int r13 = r11 + r12;
        if (r13 > r10.length) goto L51;
        if (this.isClosed == true) goto L49;
        if (this.isEOF == false) goto L13;
        return -1;
    L13:
        if (r12 != 0) goto L16;
        return 0;
    L16:
        if (getByteBufferLength() < r12) goto L19;
        copyByteBufferInto(r10, r11, r12);
        return r12;
    L19:
        int r14 = ((((r12 - getByteBufferLength()) + 3) - 1) / 3) * 4;
        int r15 = r11;
    L20:
        boolean r16 = this.isEOF;
        if (r16 == true) goto L43;
        if (r14 <= 0) goto L43;
        int r17 = Math.min(this.symbolBuffer.length, r14);
        int r18 = 0;
    L24:
        boolean r19 = this.isEOF;
        if (r19 == true) goto L34;
        if (r18 >= r17) goto L34;
        int r20 = readNextSymbol();
        if (r20 == (-1)) goto L33;
        if (r20 != 61) goto L31;
        r18 = handlePaddingSymbol(r18);
        goto L33
    L31:
        this.symbolBuffer[r18] = (byte) r20;
        r18 = r18 + 1;
    L33:
        this.isEOF = true;
    L34:
        if (r19 == true) goto L38;
        if (r18 == r17) goto L38;
        boolean r21 = false;
    L39:
        if (r21 == false) goto L42;
        r14 = r14 - r18;
        r15 = r15 + decodeSymbolBufferInto(r10, r15, r13, r18);
        goto L20
    L42:
        throw new IllegalStateException("Check failed.".toString());
    L38:
        r21 = true;
    L43:
        if (r15 != r11) goto L47;
        if (r16 == false) goto L47;
        return -1;
    L47:
        return r15 - r11;
    L49:
        throw new IOException("The input stream is closed.");
    L51:
        throw new IndexOutOfBoundsException("offset: " + r11 + ", length: " + r12 + ", buffer size: " + r10.length);
    }
}
