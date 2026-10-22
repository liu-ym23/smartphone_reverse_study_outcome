package n4a;

import com.lynx.tasm.event.LynxTouchEvent;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class m4 {
    public static final Charset n = null;
    public ByteBuffer a;
    public int b;
    public int c;
    public int[] d;
    public int e;
    public boolean f;
    public boolean g;
    public int h;
    public int[] i;
    public int j;
    public int k;
    public final CharsetEncoder l;
    public ByteBuffer m;

    static {
        n = Charset.forName("UTF-8");
    }

    public m4(ByteBuffer r3) {
        this.c = 1;
        this.d = null;
        this.e = 0;
        this.f = false;
        this.g = false;
        this.i = new int[16];
        this.j = 0;
        this.k = 0;
        this.l = n.newEncoder();
        j(r3);
    }

    public final void e(int r1, byte r2) {
        if (r2 == 0) goto L5;
        c(r2);
        s(r1);
        return;
    }

    public final void i(int r1, short r2) {
        if (r2 == 0) goto L5;
        n(r2);
        s(r1);
        return;
    }

    public final void j(ByteBuffer r2) {
        this.a = r2;
        r2.clear();
        this.a.order(ByteOrder.LITTLE_ENDIAN);
        this.c = 1;
        this.b = this.a.capacity();
        this.e = 0;
        this.f = false;
        this.g = false;
        this.h = 0;
        this.j = 0;
        this.k = 0;
    }

    public final void m(int r1, int r2) {
        if (r2 == 0) goto L5;
        d(r2);
        s(r1);
        return;
    }

    public final void o(int r3) {
        p(this.c, 4);
        d(r3);
        this.a.position(this.b);
        this.g = true;
    }

    public final int r() {
        return this.a.capacity() - this.b;
    }

    public final void s(int r3) {
        this.d[r3] = r();
    }

    public final int a() {
        if (this.f == false) goto L7;
        this.f = false;
        int r0 = this.k;
        ByteBuffer r1 = this.a;
        int r2 = this.b - 4;
        this.b = r2;
        r1.putInt(r2, r0);
        return r();
    L7:
        throw new AssertionError("FlatBuffers: endVector called without startVector");
    }

    public final int k() {
        if (this.d == null) goto L36;
        if (this.f == false) goto L36;
        p(4, 0);
        ByteBuffer r0 = this.a;
        int r2 = this.b - 4;
        this.b = r2;
        r0.putInt(r2, 0);
        int r1 = r();
        int r3 = this.e;
    L7:
        r3 = r3 - 1;
        if (r3 < 0) goto L14;
        int r4 = this.d[r3];
        if (r4 == 0) goto L12;
        int r5 = r1 - r4;
    L13:
        n((short) r5);
        goto L7
    L12:
        r5 = 0;
        goto L13
    L14:
        n((short) (r1 - this.h));
        n((short) ((this.e + 2) * 2));
        int r6 = 0;
    L16:
        if (r6 >= this.j) goto L26;
        int r7 = this.a.capacity() - this.i[r6];
        int r8 = this.b;
        short r9 = this.a.getShort(r7);
        if (r9 != this.a.getShort(r8)) goto L25;
        int r10 = 2;
    L20:
        if (r10 >= r9) goto L24;
        if (this.a.getShort(r7 + r10) != this.a.getShort(r8 + r10)) goto L25;
        r10 = r10 + 2;
        goto L20
    L24:
        int r11 = this.i[r6];
    L27:
        if (r11 == 0) goto L29;
        int r12 = this.a.capacity() - r1;
        this.b = r12;
        this.a.putInt(r12, r11 - r1);
    L33:
        this.f = false;
        return r1;
    L29:
        int r13 = this.j;
        int[] r14 = this.i;
        if (r13 != r14.length) goto L32;
        this.i = Arrays.copyOf(r14, r13 * 2);
    L32:
        int[] r15 = this.i;
        int r16 = this.j;
        this.j = r16 + 1;
        r15[r16] = r();
        ByteBuffer r17 = this.a;
        r17.putInt(r17.capacity() - r1, r() - r1);
    L25:
        r6 = r6 + 1;
        goto L16
    L26:
        r11 = 0;
    L36:
        throw new AssertionError("FlatBuffers: endObject called without startObject");
    }

    public final byte[] q() {
        int r0 = this.b;
        int r1 = this.a.capacity() - this.b;
        if (this.g == false) goto L7;
        byte[] r2 = new byte[r1];
        this.a.position(r0);
        this.a.get(r2);
        return r2;
    L7:
        throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
    }

    public m4() {
        this.c = 1;
        this.d = null;
        this.e = 0;
        this.f = false;
        this.g = false;
        this.i = new int[16];
        this.j = 0;
        this.k = 0;
        this.l = n.newEncoder();
        this.b = 1024;
        ByteBuffer r0 = ByteBuffer.allocate(1024);
        r0.order(ByteOrder.LITTLE_ENDIAN);
        this.a = r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int b(CharSequence r4) {
        String r5 = (String) r4;
        int r0 = (int) (r5.length() * this.l.maxBytesPerChar());
        ByteBuffer r1 = this.m;
        if (r1 != null) goto L5;
    L6:
        this.m = ByteBuffer.allocate(Math.max(LynxTouchEvent.kPseudoStateFocusTransition, r0));
    L7:
        this.m.clear();
        if ((r5 instanceof CharBuffer) == false) goto L10;
        CharBuffer r6 = (CharBuffer) r5;
    L11:
        CoderResult r7 = this.l.encode(r6, this.m, true);
        if (r7.isError() == true) goto L20;
    L18:
        this.m.flip();
        ByteBuffer r8 = this.m;
        int r2 = r8.remaining();
        c((byte) 0);
        g(1, r2, 1);
        ByteBuffer r3 = this.a;
        int r9 = this.b - r2;
        this.b = r9;
        r3.position(r9);
        this.a.put(r8);
        return a();
    L20:
        r7.throwException();     // Catch: CharacterCodingException -> L15
    L15:
        e = move-exception;
        throw new Error(e);
    L10:
        r6 = CharBuffer.wrap(r5);
        goto L11
    L5:
        if (r1.capacity() >= r0) goto L7;
        goto L6
    }

    public final void c(byte r3) {
        p(1, 0);
        ByteBuffer r0 = this.a;
        int r1 = this.b - 1;
        this.b = r1;
        r0.put(r1, r3);
    }

    public final void d(int r3) {
        p(4, 0);
        int r1 = (r() - r3) + 4;
        ByteBuffer r4 = this.a;
        int r0 = this.b - 4;
        this.b = r0;
        r4.putInt(r0, r1);
    }

    public final void l(int r3) {
        if (this.f == true) goto L12;
        int[] r0 = this.d;
        if (r0 != null) goto L7;
    L8:
        this.d = new int[r3];
    L9:
        this.e = r3;
        Arrays.fill(this.d, 0, r3, 0);
        this.f = true;
        this.h = r();
        return;
    L7:
        if (r0.length >= r3) goto L9;
    L12:
        throw new AssertionError("FlatBuffers: object serialization must not be nested.");
    }

    public final void n(short r3) {
        p(2, 0);
        ByteBuffer r0 = this.a;
        int r1 = this.b - 2;
        this.b = r1;
        r0.putShort(r1, r3);
    }

    public final void f(int r3, int r4) {
        if (r4 == 0) goto L5;
        p(4, 0);
        ByteBuffer r0 = this.a;
        int r1 = this.b - 4;
        this.b = r1;
        r0.putInt(r1, r4);
        s(r3);
        return;
    }

    public final void h(int r4, long r5) {
        if (r5 == 0) goto L6;
        p(8, 0);
        ByteBuffer r0 = this.a;
        int r1 = this.b - 8;
        this.b = r1;
        r0.putLong(r1, r5);
        s(r4);
        return;
    }

    public final void p(int r8, int r9) {
        if (r8 <= this.c) goto L5;
        this.c = r8;
    L5:
        int r0 = ((~((this.a.capacity() - this.b) + r9)) + 1) & (r8 - 1);
    L7:
        if (this.b >= ((r0 + r8) + r9)) goto L13;
        int r1 = this.a.capacity();
        ByteBuffer r2 = this.a;
        int r4 = r2.capacity();
        if (((-1073741824) & r4) != 0) goto L12;
        int r5 = r4 << 1;
        r2.position(0);
        ByteBuffer r3 = ByteBuffer.allocate(r5);
        r3.order(ByteOrder.LITTLE_ENDIAN);
        r3.position(r5 - r4);
        r3.put(r2);
        this.a = r3;
        this.b += r3.capacity() - r1;
        goto L7
    L12:
        throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
    L13:
        int r10 = 0;
    L14:
        if (r10 >= r0) goto L16;
        ByteBuffer r11 = this.a;
        int r6 = this.b - 1;
        this.b = r6;
        r11.put(r6, (byte) 0);
        r10 = r10 + 1;
        goto L14
    }

    public final void g(int r2, int r3, int r4) {
        if (this.f == true) goto L7;
        this.k = r3;
        int r5 = r2 * r3;
        p(4, r5);
        p(r4, r5);
        this.f = true;
        return;
    L7:
        throw new AssertionError("FlatBuffers: object serialization must not be nested.");
    }
}
