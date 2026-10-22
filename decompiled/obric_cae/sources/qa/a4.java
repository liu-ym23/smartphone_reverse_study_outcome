package qa;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class a4 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Charset f10206n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f10207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f10210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f10212f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f10213g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10214h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f10215i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f10216j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f10217k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CharsetEncoder f10218l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ByteBuffer f10219m;

    static {
        f10206n = Charset.forName("UTF-8");
    }

    public a4(ByteBuffer r8) {
        this.f10209c = 1;
        this.f10210d = null;
        this.f10211e = 0;
        this.f10212f = false;
        this.f10213g = false;
        this.f10215i = new int[16];
        this.f10216j = 0;
        this.f10217k = 0;
        this.f10218l = f10206n.newEncoder();
        j(r8);
    }

    public final int a() {
        if (this.f10212f == false) goto L7;
        this.f10212f = false;
        int r8 = this.f10217k;
        ByteBuffer r10 = this.f10207a;
        int r11 = this.f10208b - 4;
        this.f10208b = r11;
        r10.putInt(r11, r8);
        return r();
    L7:
        throw new AssertionError("FlatBuffers: endVector called without startVector");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int b(String r8) {
        float r10 = r8.length();
        CharsetEncoder r11 = this.f10218l;
        int r12 = (int) (r11.maxBytesPerChar() * r10);
        ByteBuffer r13 = this.f10219m;
        if (r13 != null) goto L5;
    L6:
        this.f10219m = ByteBuffer.allocate(Math.max(128, r12));
    L7:
        this.f10219m.clear();
        if ((r8 instanceof CharBuffer) == false) goto L10;
        CharBuffer r14 = (CharBuffer) r8;
    L11:
        CoderResult r15 = r11.encode(r14, this.f10219m, true);
        if (r15.isError() == true) goto L20;
    L18:
        this.f10219m.flip();
        ByteBuffer r16 = this.f10219m;
        int r17 = r16.remaining();
        c((byte) 0);
        g(1, r17, 1);
        ByteBuffer r18 = this.f10207a;
        int r19 = this.f10208b - r17;
        this.f10208b = r19;
        r18.position(r19);
        this.f10207a.put(r16);
        return a();
    L20:
        r15.throwException();     // Catch: CharacterCodingException -> L15
    L15:
        e = move-exception;
        throw new Error(e);
    L10:
        r14 = CharBuffer.wrap(r8);
        goto L11
    L5:
        if (r13.capacity() >= r12) goto L7;
        goto L6
    }

    public final void c(byte r8) {
        p(1, 0);
        ByteBuffer r10 = this.f10207a;
        int r11 = this.f10208b - 1;
        this.f10208b = r11;
        r10.put(r11, r8);
    }

    public final void d(byte r8, int r10) {
        if (r8 == 0) goto L5;
        c(r8);
        s(r10);
        return;
    }

    public final void e(int r8) {
        p(4, 0);
        int r10 = (r() - r8) + 4;
        ByteBuffer r11 = this.f10207a;
        int r12 = this.f10208b - 4;
        this.f10208b = r12;
        r11.putInt(r12, r10);
    }

    public final void f(int r8, int r10) {
        if (r10 == 0) goto L5;
        p(4, 0);
        ByteBuffer r11 = this.f10207a;
        int r12 = this.f10208b - 4;
        this.f10208b = r12;
        r11.putInt(r12, r10);
        s(r8);
        return;
    }

    public final void g(int r8, int r10, int r11) {
        if (this.f10212f == true) goto L7;
        this.f10217k = r10;
        int r12 = r8 * r10;
        p(4, r12);
        p(r11, r12);
        this.f10212f = true;
        return;
    L7:
        throw new AssertionError("FlatBuffers: object serialization must not be nested.");
    }

    public final void h(int r8, long r10) {
        if (r10 == 0) goto L6;
        p(8, 0);
        ByteBuffer r11 = this.f10207a;
        int r12 = this.f10208b - 8;
        this.f10208b = r12;
        r11.putLong(r12, r10);
        s(r8);
        return;
    }

    public final void i(int r8, short r10) {
        if (r10 == 0) goto L5;
        n(r10);
        s(r8);
        return;
    }

    public final void j(ByteBuffer r8) {
        this.f10207a = r8;
        r8.clear();
        this.f10207a.order(ByteOrder.LITTLE_ENDIAN);
        this.f10209c = 1;
        this.f10208b = this.f10207a.capacity();
        this.f10211e = 0;
        this.f10212f = false;
        this.f10213g = false;
        this.f10214h = 0;
        this.f10216j = 0;
        this.f10217k = 0;
    }

    public final int k() {
        if (this.f10210d == null) goto L36;
        if (this.f10212f == false) goto L36;
        p(4, 0);
        ByteBuffer r8 = this.f10207a;
        int r10 = this.f10208b - 4;
        this.f10208b = r10;
        r8.putInt(r10, 0);
        int r11 = r();
        int r12 = this.f10211e;
    L7:
        r12 = r12 - 1;
        if (r12 < 0) goto L14;
        int r13 = this.f10210d[r12];
        if (r13 == 0) goto L12;
        int r14 = r11 - r13;
    L13:
        n((short) r14);
        goto L7
    L12:
        r14 = 0;
        goto L13
    L14:
        n((short) (r11 - this.f10214h));
        n((short) ((this.f10211e + 2) * 2));
        int r15 = 0;
    L16:
        if (r15 >= this.f10216j) goto L26;
        int r16 = this.f10207a.capacity() - this.f10215i[r15];
        int r17 = this.f10208b;
        short r18 = this.f10207a.getShort(r16);
        if (r18 != this.f10207a.getShort(r17)) goto L25;
        int r19 = 2;
    L20:
        if (r19 >= r18) goto L24;
        if (this.f10207a.getShort(r16 + r19) != this.f10207a.getShort(r17 + r19)) goto L25;
        r19 = r19 + 2;
        goto L20
    L24:
        int r20 = this.f10215i[r15];
    L27:
        if (r20 == 0) goto L29;
        int r21 = this.f10207a.capacity() - r11;
        this.f10208b = r21;
        this.f10207a.putInt(r21, r20 - r11);
    L33:
        this.f10212f = false;
        return r11;
    L29:
        int r22 = this.f10216j;
        int[] r23 = this.f10215i;
        if (r22 != r23.length) goto L32;
        this.f10215i = Arrays.copyOf(r23, r22 * 2);
    L32:
        int[] r24 = this.f10215i;
        int r25 = this.f10216j;
        this.f10216j = r25 + 1;
        r24[r25] = r();
        ByteBuffer r26 = this.f10207a;
        r26.putInt(r26.capacity() - r11, r() - r11);
    L25:
        r15 = r15 + 1;
        goto L16
    L26:
        r20 = 0;
    L36:
        throw new AssertionError("FlatBuffers: endObject called without startObject");
    }

    public final void l(int r8) {
        if (this.f10212f == true) goto L12;
        int[] r10 = this.f10210d;
        if (r10 != null) goto L7;
    L8:
        this.f10210d = new int[r8];
    L9:
        this.f10211e = r8;
        Arrays.fill(this.f10210d, 0, r8, 0);
        this.f10212f = true;
        this.f10214h = r();
        return;
    L7:
        if (r10.length >= r8) goto L9;
    L12:
        throw new AssertionError("FlatBuffers: object serialization must not be nested.");
    }

    public final void m(int r8, int r10) {
        if (r10 == 0) goto L5;
        e(r10);
        s(r8);
        return;
    }

    public final void n(short r8) {
        p(2, 0);
        ByteBuffer r10 = this.f10207a;
        int r11 = this.f10208b - 2;
        this.f10208b = r11;
        r10.putShort(r11, r8);
    }

    public final void o(int r8) {
        p(this.f10209c, 4);
        e(r8);
        this.f10207a.position(this.f10208b);
        this.f10213g = true;
    }

    public final void p(int r8, int r10) {
        if (r8 <= this.f10209c) goto L5;
        this.f10209c = r8;
    L5:
        int r11 = ((~((this.f10207a.capacity() - this.f10208b) + r10)) + 1) & (r8 - 1);
    L7:
        if (this.f10208b >= ((r11 + r8) + r10)) goto L13;
        int r12 = this.f10207a.capacity();
        ByteBuffer r13 = this.f10207a;
        int r14 = r13.capacity();
        if (((-1073741824) & r14) != 0) goto L12;
        int r15 = r14 << 1;
        r13.position(0);
        ByteBuffer r16 = ByteBuffer.allocate(r15);
        r16.order(ByteOrder.LITTLE_ENDIAN);
        r16.position(r15 - r14);
        r16.put(r13);
        this.f10207a = r16;
        this.f10208b = (r16.capacity() - r12) + this.f10208b;
        goto L7
    L12:
        throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
    L13:
        int r17 = 0;
    L14:
        if (r17 >= r11) goto L16;
        ByteBuffer r18 = this.f10207a;
        int r19 = this.f10208b - 1;
        this.f10208b = r19;
        r18.put(r19, (byte) 0);
        r17 = r17 + 1;
        goto L14
    }

    public final byte[] q() {
        int r8 = this.f10208b;
        int r10 = this.f10207a.capacity() - this.f10208b;
        if (this.f10213g == false) goto L7;
        byte[] r11 = new byte[r10];
        this.f10207a.position(r8);
        this.f10207a.get(r11);
        return r11;
    L7:
        throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
    }

    public final int r() {
        return this.f10207a.capacity() - this.f10208b;
    }

    public final void s(int r8) {
        this.f10210d[r8] = r();
    }
}
