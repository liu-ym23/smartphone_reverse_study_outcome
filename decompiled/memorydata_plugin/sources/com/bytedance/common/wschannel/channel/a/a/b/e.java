package com.bytedance.common.wschannel.channel.a.a.b;

import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: classes.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f2042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final BufferedSource f2043b;
    final a c;
    boolean d;
    int e;
    long f;
    boolean g;
    boolean h;
    private final long i;
    private final Buffer j;
    private final Buffer k;
    private final byte[] l;
    private final Buffer.UnsafeCursor m;

    public interface a {
        void a(int r1, String r2);

        void a(String r1);

        void a(ByteString r1);

        void b(ByteString r1);

        void c(ByteString r1);
    }

    e(boolean r3, BufferedSource r4, a r5, long r6) {
        BufferedSource r7 = (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r4, BufferedSource.class, "com.obric.memorydata.plugin");
        a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin");
        this.j = new Buffer();
        this.k = new Buffer();
        Objects.requireNonNull(r7, "source == null");
        Objects.requireNonNull(r8, "frameCallback == null");
        this.f2042a = r3;
        this.f2043b = r7;
        this.c = r8;
        this.i = r6;
        Buffer.UnsafeCursor r9 = null;
        if (r3 == false) goto L5;
        byte[] r10 = null;
    L6:
        this.l = r10;
        if (r3 == true) goto L10;
        r9 = new Buffer.UnsafeCursor();
    L10:
        this.m = r9;
        return;
    L5:
        r10 = new byte[4];
        goto L6
    }

    private void a(long r1) {
        this.f2043b.skip(r1);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private void b() {
        if (this.d == true) goto L73;
        long r0 = this.f2043b.timeout().timeoutNanos();
        this.f2043b.timeout().clearTimeout();
        int r2 = this.f2043b.readByte() & 255;
        this.f2043b.timeout().timeout(r0, TimeUnit.NANOSECONDS);
        this.e = r2 & 15;
        boolean r1 = true;
        if ((r2 & 128) == 0) goto L9;
        boolean r3 = true;
    L10:
        this.g = r3;
        if ((r2 & 8) == 0) goto L13;
        boolean r4 = true;
    L14:
        this.h = r4;
        if (r4 == false) goto L21;
        if (r3 == true) goto L21;
        throw new ProtocolException("Control frames must be final.");
    L21:
        if ((r2 & 64) == 0) goto L23;
        boolean r5 = true;
    L25:
        if ((r2 & 32) == 0) goto L27;
        boolean r6 = true;
    L29:
        if ((r2 & 16) == 0) goto L31;
        boolean r7 = true;
    L32:
        if (r5 == true) goto L68;
        if (r6 == true) goto L68;
        if (r7 == true) goto L68;
        int r8 = this.f2043b.readByte() & 255;
        if ((r8 & 128) != 0) goto L40;
        r1 = false;
    L40:
        if (r1 == this.f2042a) goto L42;
        long r9 = r8 & 127;
        this.f = r9;
        if (r9 != 126) goto L51;
        this.f = ((long) this.f2043b.readShort()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
    L58:
        if (this.h == true) goto L60;
    L64:
        if (r1 == false) goto L76;
        this.f2043b.readFully(this.l);
        return;
    L76:
        return;
    L60:
        if (this.f <= 125) goto L64;
        throw new ProtocolException("Control frame must be less than 125B.");
    L51:
        if (r9 != 127) goto L58;
        long r10 = this.f2043b.readLong();
        this.f = r10;
        if (r10 >= 0) goto L58;
        throw new ProtocolException("Frame length 0x" + Long.toHexString(this.f) + " > 0x7FFFFFFFFFFFFFFF");
    L42:
        if (this.f2042a == false) goto L44;
        String r11 = "Server-sent frames must not be masked.";
    L46:
        throw new ProtocolException(r11);
    L44:
        r11 = "Client-sent frames must be masked.";
    L68:
        throw new ProtocolException("Reserved flags are unsupported.");
    L31:
        r7 = false;
        goto L32
    L27:
        r6 = false;
        goto L29
    L23:
        r5 = false;
        goto L25
    L13:
        r4 = false;
        goto L14
    L9:
        r3 = false;
    L69:
        th = move-exception;
        this.f2043b.timeout().timeout(r0, TimeUnit.NANOSECONDS);
        throw th;
    L73:
        throw new IOException("closed");
    }

    private void c() {
        long r0 = this.f;
        if (r0 <= 0) goto L7;
        this.f2043b.readFully(this.j, r0);
        if (this.f2042a == true) goto L7;
        this.j.readAndWriteUnsafe(this.m);
        this.m.seek(0);
        d.a(this.m, this.l);
        this.m.close();
    L7:
        int r1 = this.e;
        if (r1 != 9) goto L11;
        this.c.b(this.j.readByteString());
        return;
    L11:
        if (r1 != 10) goto L14;
        this.c.c(this.j.readByteString());
        return;
    L14:
        if (r1 != 8) goto L30;
        short r2 = 1005;
        long r4 = this.j.size();
        if (r4 == 1) goto L28;
        if (r4 == 0) goto L24;
        r2 = this.j.readShort();
        String r3 = this.j.readUtf8();
        String r5 = d.a(r2);
        if (r5 != null) goto L23;
    L25:
        this.c.a(r2, r3);
        this.d = true;
        return;
    L23:
        throw new ProtocolException(r5);
    L24:
        r3 = "";
        goto L25
    L28:
        throw new ProtocolException("Malformed close payload length of 1.");
    L30:
        throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.e));
    }

    private void d() {
        int r0 = this.e;
        if (r0 != 1) goto L5;
    L9:
        f();
        if (r0 != 1) goto L12;
        this.c.a(this.k.readUtf8());
        return;
    L12:
        this.c.a(this.k.readByteString());
        return;
    L5:
        if (r0 == 2) goto L9;
        throw new ProtocolException("Unknown opcode: " + Integer.toHexString(r0));
    }

    private void e() {
    L3:
        if (this.d == true) goto L12;
        b();
        if (this.f > this.i) goto L6;
        if (this.h == false) goto L16;
        c();
        goto L3
    L16:
        return;
    L6:
        Logger.d("WsChannelSdk_ok", "frame too large,skip");
        a(this.f);
        return;
    }

    private void f() {
    L3:
        if (this.d == true) goto L18;
        long r0 = this.f;
        if (r0 <= 0) goto L10;
        this.f2043b.readFully(this.k, r0);
        if (this.f2042a == true) goto L10;
        this.k.readAndWriteUnsafe(this.m);
        this.m.seek(this.k.size() - this.f);
        d.a(this.m, this.l);
        this.m.close();
    L10:
        if (this.g == true) goto L11;
        e();
        if (this.e == 0) goto L3;
        throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.e));
    L11:
        return;
    L18:
        throw new IOException("closed");
    }

    void a() {
        b();
        if (this.f <= this.i) goto L7;
        Logger.d("WsChannelSdk_ok", "frame too large,skip");
        a(this.f);
        return;
    L7:
        if (this.h == false) goto L9;
        c();
        return;
    L9:
        d();
    }
}
