package com.bytedance.common.wschannel.channel.a.a.b;

import android.support.v4.media.session.PlaybackStateCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Timeout;

/* JADX INFO: loaded from: classes.dex */
final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f2044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Random f2045b;
    final BufferedSink c;
    final Buffer d;
    boolean e;
    final Buffer f;
    final a g;
    boolean h;
    private final byte[] i;
    private final Buffer.UnsafeCursor j;

    final class a implements Sink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f2047b;
        boolean c;
        boolean d;
        final /* synthetic */ f e;

        a(f r1) {
            this.e = r1;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.d == true) goto L7;
            f r1 = this.e;
            r1.a(this.f2046a, r1.f.size(), this.c, true);
            this.d = true;
            this.e.h = false;
            return;
        L7:
            throw new IOException("closed");
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            if (this.d == true) goto L7;
            f r1 = this.e;
            r1.a(this.f2046a, r1.f.size(), this.c, false);
            this.c = false;
            return;
        L7:
            throw new IOException("closed");
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.e.c.timeout();
        }

        @Override // okio.Sink
        public void write(Buffer r7, long r8) {
            if (this.d == true) goto L18;
            this.e.f.write(r7, r8);
            if (this.c == true) goto L7;
        L11:
            boolean r9 = false;
        L12:
            long r2 = this.e.f.completeSegmentByteCount();
            if (r2 <= 0) goto L19;
            if (r9 == true) goto L20;
            this.e.a(this.f2046a, r2, this.c, false);
            this.c = false;
            return;
        L20:
            return;
        L19:
            return;
        L7:
            if (this.f2047b == (-1)) goto L11;
            if (this.e.f.size() <= (this.f2047b - PlaybackStateCompat.ACTION_PLAY_FROM_URI)) goto L11;
            r9 = true;
            goto L12
        L18:
            throw new IOException("closed");
        }
    }

    f(boolean r3, BufferedSink r4, Random r5) {
        BufferedSink r6 = (BufferedSink) ZeusTransformUtils.wrapperContextForParams(r4, BufferedSink.class, "com.obric.memorydata.plugin");
        this.f = new Buffer();
        this.g = new a(this);
        Objects.requireNonNull(r6, "sink == null");
        Objects.requireNonNull(r5, "random == null");
        this.f2044a = r3;
        this.c = r6;
        this.d = r6.buffer();
        this.f2045b = r5;
        Buffer.UnsafeCursor r7 = null;
        if (r3 == false) goto L5;
        byte[] r8 = new byte[4];
    L6:
        this.i = r8;
        if (r3 == false) goto L9;
        r7 = new Buffer.UnsafeCursor();
    L9:
        this.j = r7;
        return;
    L5:
        r8 = null;
        goto L6
    }

    private void b(int r6, ByteString r7) {
        if (this.e == true) goto L17;
        int r0 = r7.size();
        if (r0 > 125) goto L15;
        this.d.writeByte(r6 | 128);
        if (this.f2044a == false) goto L11;
        this.d.writeByte(r0 | 128);
        this.f2045b.nextBytes(this.i);
        this.d.write(this.i);
        if (r0 <= 0) goto L12;
        long r1 = this.d.size();
        this.d.write(r7);
        this.d.readAndWriteUnsafe(this.j);
        this.j.seek(r1);
        d.a(this.j, this.i);
        this.j.close();
    L12:
        this.c.flush();
        return;
    L11:
        this.d.writeByte(r0);
        this.d.write(r7);
        goto L12
    L15:
        throw new IllegalArgumentException("Payload size must be less than or equal to 125");
    L17:
        throw new IOException("closed");
    }

    Sink a(int r3, long r4) {
        if (this.h == true) goto L7;
        this.h = true;
        this.g.f2046a = r3;
        this.g.f2047b = r4;
        this.g.c = true;
        this.g.d = false;
        return this.g;
    L7:
        throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }

    void a(int r2, long r3, boolean r5, boolean r6) {
        if (this.e == true) goto L29;
        int r0 = 0;
        if (r5 == true) goto L8;
        r2 = 0;
    L8:
        if (r6 == false) goto L10;
        r2 = r2 | 128;
    L10:
        this.d.writeByte(r2);
        if (this.f2044a == false) goto L14;
        r0 = 128;
    L14:
        if (r3 > 125) goto L17;
        this.d.writeByte(((int) r3) | r0);
    L21:
        if (this.f2044a == false) goto L25;
        this.f2045b.nextBytes(this.i);
        this.d.write(this.i);
        if (r3 <= 0) goto L26;
        long r7 = this.d.size();
        this.d.write(this.f, r3);
        this.d.readAndWriteUnsafe(this.j);
        this.j.seek(r7);
        d.a(this.j, this.i);
        this.j.close();
    L26:
        this.c.emit();
        return;
    L25:
        this.d.write(this.f, r3);
        goto L26
    L17:
        if (r3 > WebSocketProtocol.PAYLOAD_SHORT_MAX) goto L19;
        this.d.writeByte(r0 | WebSocketProtocol.PAYLOAD_SHORT);
        this.d.writeShort((int) r3);
        goto L21
    L19:
        this.d.writeByte(r0 | 127);
        this.d.writeLong(r3);
        goto L21
    L29:
        throw new IOException("closed");
    }

    void a(int r2, ByteString r3) {
        ByteString r0 = ByteString.EMPTY;
        if (r2 != 0) goto L5;
        if (r3 != null) goto L5;
    L18:
        b(8, r0);     // Catch: Throwable -> L15
        this.e = true;
        return;
    L15:
        th = move-exception;
        this.e = true;
        throw th;
    L5:
        if (r2 == 0) goto L7;
        d.b(r2);
    L7:
        Buffer r1 = new Buffer();
        r1.writeShort(r2);
        if (r3 == null) goto L10;
        r1.write(r3);
    L10:
        r0 = r1.readByteString();
        goto L18
    }

    void a(ByteString r2) {
        b(9, r2);
    }

    void b(ByteString r2) {
        b(10, r2);
    }
}
