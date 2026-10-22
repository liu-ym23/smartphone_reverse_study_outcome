package kotlin.io.encoding;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@ExperimentalEncodingApi
final class EncodeOutputStream extends OutputStream {
    private final Base64 base64;
    private final byte[] byteBuffer;
    private int byteBufferLength;
    private boolean isClosed;
    private int lineLength;
    private final OutputStream output;
    private final byte[] symbolBuffer;

    public EncodeOutputStream(OutputStream r10, Base64 r11) {
        Intrinsics.checkNotNullParameter(r10, "output");
        Intrinsics.checkNotNullParameter(r11, "base64");
        this.output = r10;
        this.base64 = r11;
        if (r11.isMimeScheme$kotlin_stdlib() == false) goto L5;
        int r12 = 76;
    L6:
        this.lineLength = r12;
        this.symbolBuffer = new byte[1024];
        this.byteBuffer = new byte[3];
        return;
    L5:
        r12 = -1;
        goto L6
    }

    private final void checkOpen() {
        if (this.isClosed == true) goto L6;
        return;
    L6:
        throw new IOException("The output stream is closed.");
    }

    private final int copyIntoByteBuffer(byte[] r10, int r11, int r12) {
        int r13 = Math.min(3 - this.byteBufferLength, r12 - r11);
        ArraysKt.copyInto(r10, this.byteBuffer, this.byteBufferLength, r11, r11 + r13);
        int r14 = this.byteBufferLength + r13;
        this.byteBufferLength = r14;
        if (r14 != 3) goto L5;
        encodeByteBufferIntoOutput();
    L5:
        return r13;
    }

    private final void encodeByteBufferIntoOutput() {
        if (encodeIntoOutput(this.byteBuffer, 0, this.byteBufferLength) != 4) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L10;
        this.byteBufferLength = 0;
        return;
    L10:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        r10 = false;
        goto L6
    }

    private final int encodeIntoOutput(byte[] r10, int r11, int r12) {
        int r13 = this.base64.encodeIntoByteArray(r10, this.symbolBuffer, 0, r11, r12);
        if (this.lineLength != 0) goto L12;
        this.output.write(Base64.Default.getMimeLineSeparatorSymbols$kotlin_stdlib());
        this.lineLength = 76;
        if (r13 > 76) goto L7;
        boolean r14 = true;
    L8:
        if (r14 == true) goto L12;
        throw new IllegalStateException("Check failed.".toString());
    L7:
        r14 = false;
    L12:
        this.output.write(this.symbolBuffer, 0, r13);
        this.lineLength -= r13;
        return r13;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.isClosed == true) goto L9;
        this.isClosed = true;
        if (this.byteBufferLength == 0) goto L7;
        encodeByteBufferIntoOutput();
    L7:
        this.output.close();
        return;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        checkOpen();
        this.output.flush();
    }

    @Override // java.io.OutputStream
    public void write(int r10) {
        checkOpen();
        byte[] r11 = this.byteBuffer;
        int r12 = this.byteBufferLength;
        int r13 = r12 + 1;
        this.byteBufferLength = r13;
        r11[r12] = (byte) r10;
        if (r13 != 3) goto L6;
        encodeByteBufferIntoOutput();
        return;
    }

    @Override // java.io.OutputStream
    public void write(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "source");
        checkOpen();
        if (r11 < 0) goto L38;
        if (r12 < 0) goto L38;
        int r13 = r11 + r12;
        if (r13 > r10.length) goto L38;
        if (r12 != 0) goto L9;
        return;
    L9:
        int r14 = this.byteBufferLength;
        if (r14 >= 3) goto L12;
        boolean r15 = true;
    L14:
        if (r15 == false) goto L36;
        if (r14 == 0) goto L20;
        r11 = r11 + copyIntoByteBuffer(r10, r11, r13);
        if (this.byteBufferLength == 0) goto L20;
        return;
    L20:
        if ((r11 + 3) > r13) goto L33;
        if (this.base64.isMimeScheme$kotlin_stdlib() == false) goto L24;
        int r16 = this.lineLength;
    L25:
        int r17 = Math.min(r16 / 4, (r13 - r11) / 3);
        int r18 = (r17 * 3) + r11;
        if (encodeIntoOutput(r10, r11, r18) != (r17 * 4)) goto L28;
        boolean r19 = true;
    L29:
        if (r19 == false) goto L32;
        r11 = r18;
        goto L20
    L32:
        throw new IllegalStateException("Check failed.".toString());
    L28:
        r19 = false;
        goto L29
    L24:
        r16 = this.symbolBuffer.length;
        goto L25
    L33:
        ArraysKt.copyInto(r10, this.byteBuffer, 0, r11, r13);
        this.byteBufferLength = r13 - r11;
        return;
    L36:
        throw new IllegalStateException("Check failed.".toString());
    L12:
        r15 = false;
    L38:
        throw new IndexOutOfBoundsException("offset: " + r11 + ", length: " + r12 + ", source size: " + r10.length);
    }
}
