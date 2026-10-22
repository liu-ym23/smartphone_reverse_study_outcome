package okio;

import java.io.EOFException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e0 implements BufferedSink {
    public final Sink a;
    public final Buffer b;
    public boolean c;

    @Override // okio.Sink, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() {
        if (this.c == false) goto L21;
        return;
    L21:
    L8:
        th = th;
    L19:
        this.a.close();     // Catch: Throwable -> L11
    L14:
        this.c = true;
        if (th == null) goto L23;
        throw th;
    L23:
        return;
    L11:
        th = move-exception;
        if (th != null) goto L14;
        th = th;
        goto L14
    L5:
        if (this.b.size() <= 0) goto L7;
        Sink r0 = this.a;     // Catch: Throwable -> L8
        Buffer r1 = this.b;     // Catch: Throwable -> L8
        r0.write(r1, r1.size());     // Catch: Throwable -> L8
    L7:
        th = null;
        goto L19
    }

    @Override // okio.BufferedSink
    public final BufferedSink emit() {
        if ((!this.c) == false) goto L9;
        long r0 = this.b.size();
        if (r0 <= 0) goto L7;
        this.a.write(this.b, r0);
    L7:
        return this;
    L9:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink emitCompleteSegments() {
        if ((!this.c) == false) goto L9;
        long r0 = this.b.completeSegmentByteCount();
        if (r0 <= 0) goto L7;
        this.a.write(this.b, r0);
    L7:
        return this;
    L9:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public final void flush() {
        if ((!this.c) == false) goto L10;
        if (this.b.size() <= 0) goto L7;
        Sink r0 = this.a;
        Buffer r1 = this.b;
        r0.write(r1, r1.size());
    L7:
        this.a.flush();
        return;
    L10:
        throw new IllegalStateException("closed".toString());
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.c;
    }

    @Override // okio.BufferedSink
    public final OutputStream outputStream() {
        return new a(this);
    }

    @Override // okio.Sink
    public final j0 timeout() {
        return this.a.timeout();
    }

    public final String toString() {
        return "buffer(" + this.a + ')';
    }

    @Override // okio.BufferedSink
    public final Buffer buffer() {
        return this.b;
    }

    @Override // okio.BufferedSink
    public final Buffer getBuffer() {
        return this.b;
    }

    public e0(Sink r2) {
        Intrinsics.checkNotNullParameter(r2, "sink");
        this.a = r2;
        this.b = new Buffer();
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        if ((!this.c) == false) goto L7;
        int r3 = this.b.write(r2);
        emitCompleteSegments();
        return r3;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final long writeAll(Source r8) {
        Intrinsics.checkNotNullParameter(r8, "source");
        long r0 = 0;
    L3:
        long r2 = r8.read(this.b, 8192);
        if (r2 == (-1)) goto L6;
        r0 = r0 + r2;
        emitCompleteSegments();
        goto L3
    L6:
        return r0;
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeByte(int r2) {
        if ((!this.c) == false) goto L7;
        this.b.writeByte(r2);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeDecimalLong(long r2) {
        if ((!this.c) == false) goto L7;
        this.b.writeDecimalLong(r2);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeHexadecimalUnsignedLong(long r2) {
        if ((!this.c) == false) goto L7;
        this.b.writeHexadecimalUnsignedLong(r2);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeInt(int r2) {
        if ((!this.c) == false) goto L7;
        this.b.writeInt(r2);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeIntLe(int r2) {
        if ((!this.c) == false) goto L7;
        this.b.writeIntLe(r2);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeLong(long r2) {
        if ((!this.c) == false) goto L7;
        this.b.writeLong(r2);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeLongLe(long r2) {
        if ((!this.c) == false) goto L7;
        this.b.writeLongLe(r2);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeShort(int r2) {
        if ((!this.c) == false) goto L7;
        this.b.writeShort(r2);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeShortLe(int r2) {
        if ((!this.c) == false) goto L7;
        this.b.writeShortLe(r2);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeUtf8(String r2) {
        Intrinsics.checkNotNullParameter(r2, "string");
        if ((!this.c) == false) goto L7;
        this.b.writeUtf8(r2);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeUtf8CodePoint(int r2) {
        if ((!this.c) == false) goto L7;
        this.b.writeUtf8CodePoint(r2);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink write(ByteString r2) {
        Intrinsics.checkNotNullParameter(r2, "byteString");
        if ((!this.c) == false) goto L7;
        this.b.write(r2);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink write(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        if ((!this.c) == false) goto L7;
        this.b.write(r2);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink write(Source r6, long r7) {
        Intrinsics.checkNotNullParameter(r6, "source");
    L4:
        if (r7 <= 0) goto L10;
        long r0 = r6.read(this.b, r7);
        if (r0 == (-1)) goto L9;
        r7 = r7 - r0;
        emitCompleteSegments();
        goto L4
    L9:
        throw new EOFException();
    L10:
        return this;
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeString(String r2, Charset r3) {
        Intrinsics.checkNotNullParameter(r2, "string");
        Intrinsics.checkNotNullParameter(r3, "charset");
        if ((!this.c) == false) goto L7;
        this.b.writeString(r2, r3);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.Sink
    public final void write(Buffer r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        if ((!this.c) == false) goto L7;
        this.b.write(r2, r3);
        emitCompleteSegments();
        return;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink write(ByteString r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "byteString");
        if ((!this.c) == false) goto L7;
        this.b.write(r2, r3, r4);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeUtf8(String r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "string");
        if ((!this.c) == false) goto L7;
        this.b.writeUtf8(r2, r3, r4);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink write(byte[] r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "source");
        if ((!this.c) == false) goto L7;
        this.b.write(r2, r3, r4);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeString(String r2, int r3, int r4, Charset r5) {
        Intrinsics.checkNotNullParameter(r2, "string");
        Intrinsics.checkNotNullParameter(r5, "charset");
        if ((!this.c) == false) goto L7;
        this.b.writeString(r2, r3, r4, r5);
        emitCompleteSegments();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }
}
