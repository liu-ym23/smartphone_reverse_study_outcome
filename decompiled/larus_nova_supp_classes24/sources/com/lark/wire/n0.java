package com.lark.wire;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class n0 {
    public static final byte[] h = null;
    public Buffer a;
    public Buffer b;
    public final Buffer.a c;
    public byte[] d;
    public int e;
    public final Lazy f;
    public final Lazy g;

    public static final class a {
    }

    static {
        h = new byte[0];
    }

    public final void a() {
        byte[] r0 = this.d;
        byte[] r1 = h;
        if (r0 != r1) goto L5;
        return;
    L5:
        this.c.close();
        this.b.skip(this.e);
        this.b.writeAll(this.a);
        Buffer r2 = this.a;
        this.a = this.b;
        this.b = r2;
        this.d = r1;
        this.e = 0;
    }

    public final int b() {
        return ((int) this.a.size()) + (this.d.length - this.e);
    }

    public n0() {
        this.a = new Buffer();
        this.b = new Buffer();
        this.c = new Buffer.a();
        this.d = h;
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        this.f = LazyKt.lazy(r0, new l0());
        this.g = LazyKt.lazy(r0, new m0(this));
    }

    public final void c(int r11) {
        if (this.e < r11) goto L5;
        return;
    L5:
        a();
        this.b.readAndWriteUnsafe(this.c);
        Buffer.a r0 = this.c;
        r0.getClass();
        boolean r1 = false;
        if (r11 <= 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L36;
        if (r11 > 8192) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == false) goto L34;
        Buffer r5 = r0.a;
        if (r5 == null) goto L32;
        if (r0.b == false) goto L30;
        long r6 = r5.size();
        okio.g0 r12 = r5.writableSegment$okio(r11);
        int r7 = 8192 - r12.c;
        r12.c = 8192;
        r5.setSize$okio(((long) r7) + r6);
        r0.c = r12;
        r0.d = r6;
        r0.e = r12.a;
        r0.f = 8192 - r7;
        r0.g = 8192;
        Buffer.a r13 = this.c;
        if (r13.d != 0) goto L24;
        int r2 = r13.g;
        byte[] r14 = r13.e;
        Intrinsics.checkNotNull(r14);
        if (r2 != r14.length) goto L24;
        r1 = true;
    L24:
        if (r1 == false) goto L28;
        byte[] r15 = this.c.e;
        Intrinsics.checkNotNull(r15);
        this.d = r15;
        this.e = this.c.g;
        return;
    L28:
        throw new IllegalStateException("Check failed.".toString());
    L30:
        throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
    L32:
        throw new IllegalStateException("not attached to a buffer".toString());
    L34:
        throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + r11).toString());
    L13:
        r4 = false;
        goto L14
    L36:
        throw new IllegalArgumentException(("minByteCount <= 0: " + r11).toString());
    L8:
        r3 = false;
        goto L9
    }

    public final void d(ByteString r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        int r0 = r5.size();
    L3:
        if (r0 == 0) goto L5;
        c(1);
        int r1 = Math.min(this.e, r0);
        int r2 = this.e - r1;
        this.e = r2;
        r0 = r0 - r1;
        r5.copyInto(r0, this.d, r2, r1);
        goto L3
    }

    public final void e(int r5) {
        c(4);
        int r1 = this.e - 4;
        this.e = r1;
        byte[] r0 = this.d;
        int r2 = r1 + 1;
        r0[r1] = (byte) (r5 & 255);
        int r3 = r2 + 1;
        r0[r2] = (byte) ((r5 >>> 8) & 255);
        r0[r3] = (byte) ((r5 >>> 16) & 255);
        r0[r3 + 1] = (byte) ((r5 >>> 24) & 255);
    }

    public final void f(long r9) {
        c(8);
        int r1 = this.e - 8;
        this.e = r1;
        byte[] r2 = this.d;
        int r3 = r1 + 1;
        r2[r1] = (byte) (r9 & 255);
        int r4 = r3 + 1;
        r2[r3] = (byte) ((r9 >>> 8) & 255);
        int r0 = r4 + 1;
        r2[r4] = (byte) ((r9 >>> 16) & 255);
        int r5 = r0 + 1;
        r2[r0] = (byte) ((r9 >>> 24) & 255);
        int r6 = r5 + 1;
        r2[r5] = (byte) ((r9 >>> 32) & 255);
        int r7 = r6 + 1;
        r2[r6] = (byte) ((r9 >>> 40) & 255);
        r2[r7] = (byte) ((r9 >>> 48) & 255);
        r2[r7 + 1] = (byte) ((r9 >>> 56) & 255);
    }

    public final void h(int r5) {
        int r0 = j0.b;
        int r1 = j0.a.a(r5);
        c(r1);
        int r2 = this.e - r1;
        this.e = r2;
    L4:
        if ((r5 & (-128)) == 0) goto L6;
        this.d[r2] = (byte) ((r5 & 127) | 128);
        r5 = r5 >>> 7;
        r2 = r2 + 1;
        goto L4
    L6:
        this.d[r2] = (byte) r5;
    }

    public final void i(long r8) {
        int r0 = j0.b;
        int r1 = j0.a.b(r8);
        c(r1);
        int r2 = this.e - r1;
        this.e = r2;
    L4:
        if (((-128) & r8) == 0) goto L6;
        this.d[r2] = (byte) ((127 & r8) | 128);
        r8 = r8 >>> 7;
        r2 = r2 + 1;
        goto L4
    L6:
        this.d[r2] = (byte) r8;
    }

    public final void g(int r3, FieldEncoding r4) {
        Intrinsics.checkNotNullParameter(r4, "fieldEncoding");
        int r1 = j0.b;
        Intrinsics.checkNotNullParameter(r4, "fieldEncoding");
        h((r3 << 3) | r4.getValue$wire_runtime());
    }
}
