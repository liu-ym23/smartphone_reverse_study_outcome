package okio;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.CharsKt;
import okio.internal.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f0 implements BufferedSource {
    public final Source a;
    public final Buffer b;
    public boolean c;

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, okio.Sink
    public final void close() {
        if (this.c == true) goto L6;
        this.c = true;
        this.a.close();
        this.b.clear();
        return;
    }

    @Override // okio.BufferedSource
    public final boolean exhausted() {
        if ((!this.c) == false) goto L12;
        if (this.b.exhausted() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.a.read(this.b, 8192) != (-1)) goto L9;
        return true;
    L12:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSource
    public final InputStream inputStream() {
        return new a(this);
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.c;
    }

    @Override // okio.BufferedSource
    public final BufferedSource peek() {
        return Okio.buffer(new c0(this));
    }

    @Override // okio.BufferedSource
    public final byte readByte() {
        require(1);
        return this.b.readByte();
    }

    @Override // okio.BufferedSource
    public final byte[] readByteArray() {
        this.b.writeAll(this.a);
        return this.b.readByteArray();
    }

    @Override // okio.BufferedSource
    public final ByteString readByteString() {
        this.b.writeAll(this.a);
        return this.b.readByteString();
    }

    @Override // okio.BufferedSource
    public final long readDecimalLong() {
        require(1);
        long r4 = 0;
    L3:
        long r6 = r4 + 1;
        if (request(r6) == false) goto L20;
        byte r8 = this.b.getByte(r4);
        if (r8 < 48) goto L10;
        if (r8 > 57) goto L10;
    L14:
        r4 = r6;
    L10:
        if (r4 != 0) goto L15;
        if (r8 == 45) goto L14;
    L15:
        if (r4 != 0) goto L20;
        throw new NumberFormatException("Expected a digit or '-' but was 0x" + Integer.toString(r8, CharsKt.checkRadix(16)));
    L20:
        return this.b.readDecimalLong();
    }

    @Override // okio.BufferedSource
    public final long readHexadecimalUnsignedLong() {
        require(1);
        int r0 = 0;
    L3:
        int r1 = r0 + 1;
        if (request(r1) == false) goto L24;
        byte r2 = this.b.getByte(r0);
        if (r2 < 48) goto L10;
        if (r2 > 57) goto L10;
    L18:
        r0 = r1;
    L10:
        if (r2 < 97) goto L14;
        if (r2 <= 102) goto L18;
    L14:
        if (r2 < 65) goto L19;
        if (r2 <= 70) goto L18;
    L19:
        if (r0 != 0) goto L24;
        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toString(r2, CharsKt.checkRadix(16)));
    L24:
        return this.b.readHexadecimalUnsignedLong();
    }

    @Override // okio.BufferedSource
    public final int readInt() {
        require(4);
        return this.b.readInt();
    }

    @Override // okio.BufferedSource
    public final int readIntLe() {
        require(4);
        return this.b.readIntLe();
    }

    @Override // okio.BufferedSource
    public final long readLong() {
        require(8);
        return this.b.readLong();
    }

    @Override // okio.BufferedSource
    public final long readLongLe() {
        require(8);
        return this.b.readLongLe();
    }

    @Override // okio.BufferedSource
    public final short readShort() {
        require(2);
        return this.b.readShort();
    }

    @Override // okio.BufferedSource
    public final short readShortLe() {
        require(2);
        return this.b.readShortLe();
    }

    @Override // okio.BufferedSource
    public final String readUtf8() {
        this.b.writeAll(this.a);
        return this.b.readUtf8();
    }

    @Override // okio.BufferedSource
    public final int readUtf8CodePoint() {
        require(1);
        byte r0 = this.b.getByte(0);
        if ((r0 & 224) != 192) goto L6;
        require(2);
    L12:
        return this.b.readUtf8CodePoint();
    L6:
        if ((r0 & 240) != 224) goto L9;
        require(3);
        goto L12
    L9:
        if ((r0 & 248) != 240) goto L12;
        require(4);
        goto L12
    }

    @Override // okio.BufferedSource
    public final String readUtf8Line() {
        long r0 = indexOf((byte) 10);
        if (r0 != (-1)) goto L9;
        if (this.b.size() != 0) goto L10;
        return null;
    L10:
        return readUtf8(this.b.size());
    L9:
        return a.b(this.b, r0);
    }

    @Override // okio.Source, okio.Sink
    public final j0 timeout() {
        return this.a.timeout();
    }

    public final String toString() {
        return "buffer(" + this.a + ')';
    }

    @Override // okio.BufferedSource
    public final String readUtf8LineStrict() {
        return readUtf8LineStrict(LongCompanionObject.MAX_VALUE);
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public final Buffer buffer() {
        return this.b;
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public final Buffer getBuffer() {
        return this.b;
    }

    public f0(Source r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        this.a = r2;
        this.b = new Buffer();
    }

    @Override // okio.BufferedSource
    public final long indexOf(byte r7) {
        return indexOf(r7, 0, LongCompanionObject.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public final long indexOfElement(ByteString r3) {
        Intrinsics.checkNotNullParameter(r3, "targetBytes");
        return indexOfElement(r3, 0);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer r6) {
        Intrinsics.checkNotNullParameter(r6, "sink");
        if (this.b.size() != 0) goto L9;
        if (this.a.read(this.b, 8192) != (-1)) goto L9;
        return -1;
    L9:
        return this.b.read(r6);
    }

    @Override // okio.BufferedSource
    public final long readAll(Sink r10) {
        Intrinsics.checkNotNullParameter(r10, "sink");
        long r2 = 0;
    L4:
        if (this.a.read(this.b, 8192) == (-1)) goto L9;
        long r4 = this.b.completeSegmentByteCount();
        if (r4 <= 0) goto L4;
        r2 = r2 + r4;
        r10.write(this.b, r4);
        goto L4
    L9:
        if (this.b.size() <= 0) goto L17;
        long r3 = r2 + this.b.size();
        Buffer r0 = this.b;
        r10.write(r0, r0.size());
        return r3;
    L17:
        return r2;
    }

    @Override // okio.BufferedSource
    public final byte[] readByteArray(long r2) {
        require(r2);
        return this.b.readByteArray(r2);
    }

    @Override // okio.BufferedSource
    public final ByteString readByteString(long r2) {
        require(r2);
        return this.b.readByteString(r2);
    }

    @Override // okio.BufferedSource
    public final void readFully(byte[] r8) {
        Intrinsics.checkNotNullParameter(r8, "sink");
        require(r8.length);     // Catch: EOFException -> L6
        this.b.readFully(r8);
        return;
    L6:
        e = move-exception;
        int r1 = 0;
    L9:
        if (this.b.size() <= 0) goto L15;
        Buffer r2 = this.b;
        int r3 = r2.read(r8, r1, (int) r2.size());
        if (r3 == (-1)) goto L14;
        r1 = r1 + r3;
        goto L9
    L14:
        throw new AssertionError();
    L15:
        throw e;
    }

    @Override // okio.BufferedSource
    public final String readString(Charset r3) {
        Intrinsics.checkNotNullParameter(r3, "charset");
        this.b.writeAll(this.a);
        return this.b.readString(r3);
    }

    @Override // okio.BufferedSource
    public final String readUtf8(long r2) {
        require(r2);
        return this.b.readUtf8(r2);
    }

    @Override // okio.BufferedSource
    public final String readUtf8LineStrict(long r13) {
        if (r13 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L29;
        if (r13 != LongCompanionObject.MAX_VALUE) goto L10;
        long r4 = Long.MAX_VALUE;
    L11:
        long r6 = indexOf((byte) 10, 0, r4);
        if (r6 == (-1)) goto L15;
        return a.b(this.b, r6);
    L15:
        if (r4 < LongCompanionObject.MAX_VALUE) goto L17;
    L26:
        Buffer r7 = new Buffer();
        Buffer r1 = this.b;
        r1.copyTo(r7, 0, Math.min(32, r1.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.b.size(), r13) + " content=" + r7.readByteString().hex() + 8230);
    L17:
        if (request(r4) == false) goto L26;
        if (this.b.getByte(r4 - 1) != 13) goto L26;
        if (request(1 + r4) == false) goto L26;
        if (this.b.getByte(r4) != 10) goto L26;
        return a.b(this.b, r4);
    L10:
        r4 = r13 + 1;
        goto L11
    L29:
        throw new IllegalArgumentException(("limit < 0: " + r13).toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    public final boolean request(long r8) {
        if (r8 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L19;
        if ((!this.c) == false) goto L17;
    L10:
        if (this.b.size() >= r8) goto L14;
        if (this.a.read(this.b, 8192) != (-1)) goto L10;
        return false;
    L14:
        return true;
    L17:
        throw new IllegalStateException("closed".toString());
    L19:
        throw new IllegalArgumentException(("byteCount < 0: " + r8).toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    public final void require(long r1) {
        if (request(r1) == false) goto L6;
        return;
    L6:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public final int select(z r7) {
        Intrinsics.checkNotNullParameter(null, "options");
        if ((!this.c) == false) goto L12;
    L4:
        Buffer r1 = this.b;
        byte[] r2 = a.a;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(null, "options");
        if (r1.head != null) goto L10;
        if (this.a.read(this.b, 8192) != (-1)) goto L4;
        return -1;
    L10:
        throw null;
    L12:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSource
    public final void skip(long r6) {
        if ((!this.c) == false) goto L16;
    L5:
        if (r6 <= 0) goto L14;
        if (this.b.size() != 0) goto L13;
        if (this.a.read(this.b, 8192) != (-1)) goto L13;
        throw new EOFException();
    L13:
        long r0 = Math.min(r6, this.b.size());
        this.b.skip(r0);
        r6 = r6 - r0;
        goto L5
    L14:
        return;
    L16:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSource
    public final long indexOf(ByteString r3) {
        Intrinsics.checkNotNullParameter(r3, "bytes");
        return indexOf(r3, 0);
    }

    @Override // okio.BufferedSource
    public final int read(byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, "sink");
        return read(r3, 0, r3.length);
    }

    @Override // okio.BufferedSource
    public final <T> T select(k0<T> r2) {
        Intrinsics.checkNotNullParameter(null, "options");
        throw null;
    }

    @Override // okio.BufferedSource
    public final long indexOf(ByteString r9, long r10) {
        Intrinsics.checkNotNullParameter(r9, "bytes");
        if ((!this.c) == false) goto L13;
    L4:
        long r0 = this.b.indexOf(r9, r10);
        if (r0 != (-1)) goto L16;
        long r1 = this.b.size();
        if (this.a.read(this.b, 8192) == (-1)) goto L10;
        r10 = Math.max(r10, (r1 - ((long) r9.size())) + 1);
        goto L4
    L10:
        return -1;
    L16:
        return r0;
    L13:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSource
    public final long indexOfElement(ByteString r9, long r10) {
        Intrinsics.checkNotNullParameter(r9, "targetBytes");
        if ((!this.c) == false) goto L13;
    L4:
        long r0 = this.b.indexOfElement(r9, r10);
        if (r0 != (-1)) goto L16;
        long r1 = this.b.size();
        if (this.a.read(this.b, 8192) == (-1)) goto L10;
        r10 = Math.max(r10, r1);
        goto L4
    L10:
        return -1;
    L16:
        return r0;
    L13:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSource
    public final boolean rangeEquals(long r8, ByteString r10) {
        Intrinsics.checkNotNullParameter(r10, "bytes");
        return rangeEquals(r8, r10, 0, r10.size());
    }

    @Override // okio.Source
    public final long read(Buffer r6, long r7) {
        Intrinsics.checkNotNullParameter(r6, "sink");
        if (r7 < 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L19;
        if ((true ^ this.c) == false) goto L17;
        if (this.b.size() != 0) goto L15;
        if (this.a.read(this.b, 8192) != (-1)) goto L15;
        return -1;
    L15:
        return this.b.read(r6, Math.min(r7, this.b.size()));
    L17:
        throw new IllegalStateException("closed".toString());
    L19:
        throw new IllegalArgumentException(("byteCount < 0: " + r7).toString());
    L5:
        r3 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    public final void readFully(Buffer r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "sink");
        require(r3);     // Catch: EOFException -> L6
        this.b.readFully(r2, r3);
        return;
    L6:
        e = move-exception;
        r2.writeAll(this.b);
        throw e;
    }

    @Override // okio.BufferedSource
    public final String readString(long r2, Charset r4) {
        Intrinsics.checkNotNullParameter(r4, "charset");
        require(r2);
        return this.b.readString(r2, r4);
    }

    @Override // okio.BufferedSource
    public final long indexOf(byte r7, long r8) {
        return indexOf(r7, r8, LongCompanionObject.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public final long indexOf(byte r9, long r10, long r12) {
        boolean r1 = true;
        if ((!this.c) == false) goto L26;
        if (0 <= r10) goto L7;
    L9:
        r1 = false;
    L10:
        if (r1 == false) goto L24;
    L12:
        if (r10 >= r12) goto L33;
        long r2 = this.b.indexOf(r9, r10, r12);
        if (r2 != (-1)) goto L22;
        long r3 = this.b.size();
        if (r3 >= r12) goto L31;
        if (this.a.read(this.b, 8192) == (-1)) goto L32;
        r10 = Math.max(r10, r3);
        goto L12
    L32:
        return -1;
    L31:
        return -1;
    L22:
        return r2;
    L33:
        return -1;
    L24:
        throw new IllegalArgumentException(("fromIndex=" + r10 + " toIndex=" + r12).toString());
    L7:
        if (r10 > r12) goto L9;
    L26:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSource
    public final int read(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "sink");
        long r7 = r12;
        b.b(r10.length, r11, r7);
        if (this.b.size() != 0) goto L8;
        if (this.a.read(this.b, 8192) != (-1)) goto L8;
        return -1;
    L8:
        return this.b.read(r10, r11, (int) Math.min(r7, this.b.size()));
    }

    @Override // okio.BufferedSource
    public final boolean rangeEquals(long r8, ByteString r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "bytes");
        if ((!this.c) == false) goto L23;
        if (r8 < 0) goto L20;
        if (r11 < 0) goto L20;
        if (r12 < 0) goto L20;
        if ((r10.size() - r11) < r12) goto L20;
        int r2 = 0;
    L12:
        if (r2 >= r12) goto L27;
        long r3 = ((long) r2) + r8;
        if (request(1 + r3) == false) goto L20;
        if (this.b.getByte(r3) != r10.getByte(r11 + r2)) goto L20;
        r2 = r2 + 1;
        goto L12
    L27:
        return true;
    L20:
        return false;
    L23:
        throw new IllegalStateException("closed".toString());
    }
}
