package kotlin.io.encoding;

import ai.j0;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@ExperimentalEncodingApi
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0002J(\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\b\u0010\u001d\u001a\u00020\tH\u0016J \u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0016J\b\u0010 \u001a\u00020\tH\u0002J\b\u0010!\u001a\u00020\u0014H\u0002J\b\u0010\"\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lkotlin/io/encoding/DecodeInputStream;", "Ljava/io/InputStream;", "input", "base64", "Lkotlin/io/encoding/Base64;", "(Ljava/io/InputStream;Lkotlin/io/encoding/Base64;)V", "byteBuffer", "", "byteBufferEndIndex", "", "byteBufferLength", "getByteBufferLength", "()I", "byteBufferStartIndex", "isClosed", "", "isEOF", "singleByteBuffer", "symbolBuffer", "close", "", "copyByteBufferInto", "dst", "dstOffset", "length", "decodeSymbolBufferInto", "dstEndIndex", "symbolBufferLength", "handlePaddingSymbol", "read", "destination", "offset", "readNextSymbol", "resetByteBufferIfEmpty", "shiftByteBufferToStartIfNeeded", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    public DecodeInputStream(InputStream r5, Base64 r10) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Intrinsics.checkNotNullParameter(r10, "base64");
        this.input = r5;
        this.base64 = r10;
        this.singleByteBuffer = new byte[1];
        this.symbolBuffer = new byte[1024];
        this.byteBuffer = new byte[1024];
    }

    private final void copyByteBufferInto(byte[] r5, int r10, int r11) {
        byte[] r12 = this.byteBuffer;
        int r13 = this.byteBufferStartIndex;
        ArraysKt.copyInto(r12, r5, r10, r13, r13 + r11);
        this.byteBufferStartIndex += r11;
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

    private final int handlePaddingSymbol(int r5) {
        this.symbolBuffer[r5] = Base64.padSymbol;
        if ((r5 & 3) != 2) goto L9;
        int r10 = readNextSymbol();
        if (r10 < 0) goto L10;
        this.symbolBuffer[r5 + 1] = (byte) r10;
    L10:
        return r5 + 2;
    L9:
        return r5 + 1;
    }

    private final int readNextSymbol() {
        if (this.base64.isMimeScheme$kotlin_stdlib() == false) goto L5;
    L6:
        int r5 = this.input.read();
        if (r5 == (-1)) goto L10;
        if (Base64Kt.isInMimeAlphabet(r5) == false) goto L6;
    L10:
        return r5;
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
        byte[] r5 = this.byteBuffer;
        int r10 = r5.length;
        int r11 = this.byteBufferEndIndex;
        if (((this.symbolBuffer.length / 4) * 3) <= (r10 - r11)) goto L6;
        ArraysKt.copyInto(r5, r5, 0, this.byteBufferStartIndex, r11);
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
        int r5 = this.byteBufferStartIndex;
        if (r5 >= this.byteBufferEndIndex) goto L6;
        int r10 = this.byteBuffer[r5] & UByte.MAX_VALUE;
        this.byteBufferStartIndex = r5 + 1;
        resetByteBufferIfEmpty();
        return r10;
    L6:
        int r11 = read(this.singleByteBuffer, 0, 1);
        if (r11 == (-1)) goto L12;
        if (r11 != 1) goto L11;
        return this.singleByteBuffer[0] & UByte.MAX_VALUE;
    L11:
        throw new IllegalStateException("Unreachable");
    L12:
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "destination");
        if (r11 < 0) goto L47;
        if (r12 < 0) goto L47;
        int r5 = r11 + r12;
        if (r5 > r10.length) goto L47;
        if (this.isClosed == true) goto L46;
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
        int r13 = (((r12 - getByteBufferLength()) + 2) / 3) * 4;
        int r14 = r11;
    L20:
        boolean r15 = this.isEOF;
        if (r15 == true) goto L40;
        if (r13 <= 0) goto L40;
        int r16 = Math.min(this.symbolBuffer.length, r13);
        int r17 = 0;
    L24:
        boolean r18 = this.isEOF;
        if (r18 == true) goto L34;
        if (r17 >= r16) goto L34;
        int r19 = readNextSymbol();
        if (r19 != (-1)) goto L30;
        this.isEOF = true;
        goto L24
    L30:
        if (r19 != 61) goto L31;
        r17 = handlePaddingSymbol(r17);
        this.isEOF = true;
        goto L24
    L31:
        this.symbolBuffer[r17] = (byte) r19;
        r17 = r17 + 1;
    L34:
        if (r18 == true) goto L39;
        if (r17 == r16) goto L39;
        throw new IllegalStateException("Check failed.");
    L39:
        r13 = r13 - r17;
        r14 = r14 + decodeSymbolBufferInto(r10, r14, r5, r17);
    L40:
        if (r14 != r11) goto L44;
        if (r15 == false) goto L44;
        return -1;
    L44:
        return r14 - r11;
    L46:
        throw new IOException("The input stream is closed.");
    L47:
        StringBuilder r110 = j0.v("offset: ", r11, r12, ", length: ", ", buffer size: ");
        r110.append(r10.length);
        throw new IndexOutOfBoundsException(r110.toString());
    }
}
