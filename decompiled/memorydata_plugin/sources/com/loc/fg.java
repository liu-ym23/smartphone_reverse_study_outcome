package com.loc;

import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class fg {
    static final Charset c = null;
    static final /* synthetic */ boolean p = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ByteBuffer f5532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f5533b;
    int d;
    int[] e;
    int f;
    boolean g;
    boolean h;
    int i;
    int[] j;
    int k;
    int l;
    boolean m;
    CharsetEncoder n;
    ByteBuffer o;

    static {
        c = Charset.forName(RpcUtils.CHARSET_UTF8);
    }

    private fg() {
        this.d = 1;
        this.e = null;
        this.f = 0;
        this.g = false;
        this.h = false;
        this.j = new int[16];
        this.k = 0;
        this.l = 0;
        this.m = false;
        this.n = c.newEncoder();
        this.f5533b = 1024;
        this.f5532a = d(1024);
    }

    public fg(ByteBuffer r3) {
        this.d = 1;
        this.e = null;
        this.f = 0;
        this.g = false;
        this.h = false;
        this.j = new int[16];
        this.k = 0;
        this.l = 0;
        this.m = false;
        this.n = c.newEncoder();
        a(r3);
    }

    private void a(long r3) {
        ByteBuffer r0 = this.f5532a;
        int r1 = this.f5533b - 8;
        this.f5533b = r1;
        r0.putLong(r1, r3);
    }

    private void a(short r3) {
        ByteBuffer r0 = this.f5532a;
        int r1 = this.f5533b - 2;
        this.f5533b = r1;
        r0.putShort(r1, r3);
    }

    private static ByteBuffer b(ByteBuffer r3) {
        int r0 = r3.capacity();
        if (((-1073741824) & r0) != 0) goto L7;
        int r1 = r0 << 1;
        r3.position(0);
        ByteBuffer r2 = d(r1);
        r2.position(r1 - r0);
        r2.put(r3);
        return r2;
    L7:
        throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
    }

    private void b(byte r3) {
        ByteBuffer r0 = this.f5532a;
        int r1 = this.f5533b - 1;
        this.f5533b = r1;
        r0.put(r1, r3);
    }

    private void b(long r3) {
        c(8, 0);
        a(r3);
    }

    private void b(short r3) {
        c(2, 0);
        a(r3);
    }

    private void b(boolean r3) {
        ByteBuffer r0 = this.f5532a;
        int r1 = this.f5533b - 1;
        this.f5533b = r1;
        r0.put(r1, r3 ? 1 : 0);
    }

    private int c(ByteBuffer r4) {
        int r0 = r4.remaining();
        a((byte) 0);
        a(1, r0, 1);
        ByteBuffer r1 = this.f5532a;
        int r2 = this.f5533b - r0;
        this.f5533b = r2;
        r1.position(r2);
        this.f5532a.put(r4);
        return a();
    }

    private void c(int r5, int r6) {
        if (r5 <= this.d) goto L5;
        this.d = r5;
    L5:
        int r0 = ((~((this.f5532a.capacity() - this.f5533b) + r6)) + 1) & (r5 - 1);
    L7:
        if (this.f5533b >= ((r0 + r5) + r6)) goto L9;
        int r1 = this.f5532a.capacity();
        ByteBuffer r2 = b(this.f5532a);
        this.f5532a = r2;
        this.f5533b += r2.capacity() - r1;
        goto L7
    L9:
        e(r0);
    }

    private void c(boolean r3) {
        c(1, 0);
        b(r3);
    }

    private int d() {
        return this.f5532a.capacity() - this.f5533b;
    }

    private static ByteBuffer d(int r1) {
        ByteBuffer r2 = ByteBuffer.allocate(r1);
        r2.order(ByteOrder.LITTLE_ENDIAN);
        return r2;
    }

    private byte[] d(int r2, int r3) {
        e();
        byte[] r4 = new byte[r3];
        this.f5532a.position(r2);
        this.f5532a.get(r4);
        return r4;
    }

    private void e() {
        if (this.h == false) goto L6;
        return;
    L6:
        throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
    }

    private void e(int r5) {
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L5;
        ByteBuffer r2 = this.f5532a;
        int r3 = this.f5533b - 1;
        this.f5533b = r3;
        r2.put(r3, (byte) 0);
        r1 = r1 + 1;
        goto L3
    }

    private void f() {
        if (this.g == true) goto L6;
        return;
    L6:
        throw new AssertionError("FlatBuffers: object serialization must not be nested.");
    }

    private void f(int r3) {
        ByteBuffer r0 = this.f5532a;
        int r1 = this.f5533b - 4;
        this.f5533b = r1;
        r0.putInt(r1, r3);
    }

    private void g(int r3) {
        c(4, 0);
        f(r3);
    }

    private void h(int r2) {
        this.e[r2] = d();
    }

    public final int a() {
        if (this.g == false) goto L7;
        this.g = false;
        f(this.l);
        return d();
    L7:
        throw new AssertionError("FlatBuffers: endVector called without startVector");
    }

    public int a(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = (int) (r5.length() * this.n.maxBytesPerChar());
        ByteBuffer r2 = this.o;
        if (r2 != null) goto L5;
    L6:
        this.o = ByteBuffer.allocate(Math.max(128, r0));
    L7:
        this.o.clear();
        if (ZeusTransformUtils.instanceOf(r5, CharBuffer.class) == false) goto L10;
        CharBuffer r6 = (CharBuffer) ZeusTransformUtils.preCheckCast(r5, CharBuffer.class, "com.obric.memorydata.plugin");
    L11:
        CoderResult r7 = this.n.encode(r6, this.o, true);
        if (r7.isError() == true) goto L20;
    L18:
        this.o.flip();
        return c(this.o);
    L20:
        r7.throwException();     // Catch: CharacterCodingException -> L15
    L15:
        e = move-exception;
        throw new Error(e);
    L10:
        r6 = CharBuffer.wrap(r5);
        goto L11
    L5:
        if (r2.capacity() >= r0) goto L7;
        goto L6
    }

    public final fg a(ByteBuffer r2) {
        this.f5532a = r2;
        r2.clear();
        this.f5532a.order(ByteOrder.LITTLE_ENDIAN);
        this.d = 1;
        this.f5533b = this.f5532a.capacity();
        this.f = 0;
        this.g = false;
        this.h = false;
        this.i = 0;
        this.k = 0;
        this.l = 0;
        return this;
    }

    public final void a(byte r3) {
        c(1, 0);
        b(r3);
    }

    public final void a(int r3) {
        c(4, 0);
        if (p == false) goto L5;
    L9:
        f((d() - r3) + 4);
        return;
    L5:
        if (r3 <= d()) goto L9;
        throw new AssertionError();
    }

    public final void a(int r2, byte r3) {
        if (this.m == true) goto L5;
        if (r3 != 0) goto L5;
        return;
    L5:
        a(r3);
        h(r2);
    }

    public final void a(int r2, int r3) {
        if (this.m == true) goto L5;
        if (r3 != 0) goto L5;
        return;
    L5:
        g(r3);
        h(r2);
    }

    public final void a(int r1, int r2, int r3) {
        f();
        this.l = r2;
        int r4 = r1 * r2;
        c(4, r4);
        c(r3, r4);
        this.g = true;
    }

    public final void a(int r3, long r4) {
        if (this.m == false) goto L5;
    L6:
        b(r4);
        h(r3);
        return;
    L5:
        if (r4 != 0) goto L6;
    }

    public final void a(int r2, short r3) {
        if (this.m == true) goto L5;
        if (r3 != 0) goto L5;
        return;
    L5:
        b(r3);
        h(r2);
    }

    public final void a(boolean r2) {
        if (this.m == true) goto L5;
        if (r2 == true) goto L5;
        return;
    L5:
        c(r2);
        h(0);
    }

    public final int b() {
        if (this.e == null) goto L35;
        if (this.g == false) goto L35;
        g(0);
        int r1 = d();
        int r2 = this.f - 1;
    L7:
        if (r2 < 0) goto L13;
        int[] r3 = this.e;
        if (r3[r2] == 0) goto L11;
        int r4 = r1 - r3[r2];
    L12:
        b((short) r4);
        r2 = r2 - 1;
        goto L7
    L11:
        r4 = 0;
        goto L12
    L13:
        b((short) (r1 - this.i));
        b((short) ((this.f + 2) * 2));
        int r5 = 0;
    L15:
        if (r5 >= this.k) goto L25;
        int r6 = this.f5532a.capacity() - this.j[r5];
        int r7 = this.f5533b;
        short r8 = this.f5532a.getShort(r6);
        if (r8 != this.f5532a.getShort(r7)) goto L24;
        int r9 = 2;
    L19:
        if (r9 >= r8) goto L23;
        if (this.f5532a.getShort(r6 + r9) != this.f5532a.getShort(r7 + r9)) goto L24;
        r9 = r9 + 2;
        goto L19
    L23:
        int r10 = this.j[r5];
    L26:
        if (r10 == 0) goto L28;
        int r11 = this.f5532a.capacity() - r1;
        this.f5533b = r11;
        this.f5532a.putInt(r11, r10 - r1);
    L32:
        this.g = false;
        return r1;
    L28:
        int r12 = this.k;
        int[] r13 = this.j;
        if (r12 != r13.length) goto L31;
        this.j = Arrays.copyOf(r13, r12 * 2);
    L31:
        int[] r14 = this.j;
        int r15 = this.k;
        this.k = r15 + 1;
        r14[r15] = d();
        ByteBuffer r16 = this.f5532a;
        r16.putInt(r16.capacity() - r1, d() - r1);
    L24:
        r5 = r5 + 1;
        goto L15
    L25:
        r10 = 0;
    L35:
        throw new AssertionError("FlatBuffers: endObject called without startObject");
    }

    public final void b(int r3) {
        f();
        int[] r0 = this.e;
        if (r0 != null) goto L5;
    L6:
        this.e = new int[r3];
    L7:
        this.f = r3;
        Arrays.fill(this.e, 0, r3, 0);
        this.g = true;
        this.i = d();
        return;
    L5:
        if (r0.length >= r3) goto L7;
        goto L6
    }

    public final void b(int r2, int r3) {
        if (this.m == true) goto L5;
        if (r3 != 0) goto L5;
        return;
    L5:
        a(r3);
        h(r2);
    }

    public final void c(int r3) {
        c(this.d, 4);
        a(r3);
        this.f5532a.position(this.f5533b);
        this.h = true;
    }

    public final byte[] c() {
        return d(this.f5533b, this.f5532a.capacity() - this.f5533b);
    }
}
