package com.tom_roush.pdfbox.filter;

import com.obric.security.agentmanager.AgentManagerErrCode;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
final class d extends FilterInputStream {
    static final short[][] c = null;
    static final short[][] d = null;
    public static final short[][] e = null;
    public static final short[][] f = null;
    static final a g = null;
    static final a h = null;
    static final b i = null;
    static final b j = null;
    static final b k = null;
    static final b l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f16100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f16101b;
    private final int m;
    private final byte[] n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private final int s;
    private int t;
    private int u;
    private int[] v;
    private int[] w;
    private int x;
    private int y;
    private int z;

    /* JADX INFO: renamed from: com.tom_roush.pdfbox.filter.d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        a f16102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        a f16103b;
        int c;
        boolean d;
        boolean e;

        private a() {
            this.d = false;
            this.e = false;
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        a a(boolean r1) {
            if (r1 == false) goto L5;
            return this.f16103b;
        L5:
            return this.f16102a;
        }

        void a(boolean r1, a r2) {
            if (r1 == true) goto L4;
            this.f16102a = r2;
            return;
        L4:
            this.f16103b = r2;
        }

        public String toString() {
            return "[leaf=" + this.e + ", value=" + this.c + ", canBeFill=" + this.d + "]";
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f16104a;

        private b() {
            this.f16104a = new a(null);
        }

        /* synthetic */ b(AnonymousClass1 r1) {
            this();
        }

        void a(int r8, int r9, int r10) {
            a r7 = this.f16104a;
            int r1 = 0;
        L3:
            if (r1 >= r8) goto L21;
            int r2 = r8 - 1;
            if (((r9 >> (r2 - r1)) & 1) != 1) goto L7;
            boolean r3 = true;
        L8:
            a r5 = r7.a(r3);
            if (r5 != null) goto L17;
            r5 = new a(null);
            if (r1 != r2) goto L13;
            r5.c = r10;
            r5.e = true;
        L13:
            if (r9 != 0) goto L15;
            r5.d = true;
        L15:
            r7.a(r3, r5);
        L18:
            r7 = r5;
            r1 = r1 + 1;
            goto L3
        L17:
            if (r5.e == false) goto L18;
            throw new IOException("node is leaf, no other following");
        L7:
            r3 = false;
            goto L8
        }

        void a(int r7, int r8, a r9) {
            a r6 = this.f16104a;
            int r1 = 0;
        L3:
            if (r1 >= r7) goto L22;
            int r2 = r7 - 1;
            if (((r8 >> (r2 - r1)) & 1) != 1) goto L7;
            boolean r3 = true;
        L8:
            a r5 = r6.a(r3);
            if (r5 != null) goto L17;
            if (r1 != r2) goto L12;
            a r4 = r9;
        L13:
            if (r8 != 0) goto L15;
            r4.d = true;
        L15:
            r6.a(r3, r4);
            r6 = r4;
        L19:
            r1 = r1 + 1;
            goto L3
        L12:
            r4 = new a(null);
            goto L13
        L17:
            if (r5.e == true) goto L21;
            r6 = r5;
            goto L19
        L21:
            throw new IOException("node is leaf, no other following");
        L7:
            r3 = false;
            goto L8
        }
    }

    static {
        c = new short[][]{new short[]{2, 3}, new short[]{2, 3}, new short[]{2, 3}, new short[]{3}, new short[]{4, 5}, new short[]{4, 5, 7}, new short[]{4, 7}, new short[]{24}, new short[]{23, 24, 55, 8, 15}, new short[]{23, 24, 40, 55, 103, 104, 108, 8, 12, 13}, new short[]{18, 19, 20, 21, 22, 23, 28, 29, 30, 31, 36, 39, 40, 43, 44, 51, 52, 53, 55, 56, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 200, 201, 202, 203, 204, 205, 210, 211, 212, 213, 214, 215, 218, 219}, new short[]{74, 75, 76, 77, 82, 83, 84, 85, 90, 91, 100, 101, 108, 109, 114, 115, 116, 117, 118, 119}};
        d = new short[][]{new short[]{3, 2}, new short[]{1, 4}, new short[]{6, 5}, new short[]{7}, new short[]{9, 8}, new short[]{10, 11, 12}, new short[]{13, 14}, new short[]{15}, new short[]{16, 17, 0, 18, 64}, new short[]{24, 25, 23, 22, 19, 20, 21, 1792, 1856, 1920}, new short[]{1984, 2048, 2112, 2176, 2240, 2304, 2368, 2432, 2496, 2560, 52, 55, 56, 59, 60, 320, 384, 448, 53, 54, 50, 51, 44, 45, 46, 47, 57, 58, 61, 256, 48, 49, 62, 63, 30, 31, 32, 33, 40, 41, 128, 192, 26, 27, 28, 29, 34, 35, 36, 37, 38, 39, 42, 43}, new short[]{640, 704, 768, 832, 1280, 1344, 1408, 1472, 1536, 1600, 1664, 1728, 512, 576, 896, 960, 1024, 1088, 1152, 1216}};
        e = new short[][]{new short[]{7, 8, 11, 12, 14, 15}, new short[]{18, 19, 20, 27, 7, 8}, new short[]{23, 24, 42, 43, 3, 52, 53, 7, 8}, new short[]{19, 23, 24, 36, 39, 40, 43, 3, 55, 4, 8, 12}, new short[]{18, 19, 20, 21, 22, 23, 26, 27, 2, 36, 37, 40, 41, 42, 43, 44, 45, 3, 50, 51, 52, 53, 54, 55, 4, 74, 75, 5, 82, 83, 84, 85, 88, 89, 90, 91, 100, 101, 103, 104, 10, 11}, new short[]{152, 153, 154, 155, 204, 205, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219}, new short[0], new short[]{8, 12, 13}, new short[]{18, 19, 20, 21, 22, 23, 28, 29, 30, 31}};
        f = new short[][]{new short[]{2, 3, 4, 5, 6, 7}, new short[]{128, 8, 9, 64, 10, 11}, new short[]{192, 1664, 16, 17, 13, 14, 15, 1, 12}, new short[]{26, 21, 28, 27, 18, 24, 25, 22, 256, 23, 20, 19}, new short[]{33, 34, 35, 36, 37, 38, 31, 32, 29, 53, 54, 39, 40, 41, 42, 43, 44, 30, 61, 62, 63, 0, 320, 384, 45, 59, 60, 46, 49, 50, 51, 52, 55, 56, 57, 58, 448, 512, 640, 576, 47, 48}, new short[]{1472, 1536, 1600, 1728, 704, 768, 832, 896, 960, 1024, 1088, 1152, 1216, 1280, 1344, 1408}, new short[0], new short[]{1792, 1856, 1920}, new short[]{1984, 2048, 2112, 2176, 2240, 2304, 2368, 2432, 2496, 2560}};
        AnonymousClass1 r3 = null;
        a r1 = new a(r3);
        g = r1;
        r1.e = true;
        r1.c = -2000;
        a r8 = new a(r3);
        h = r8;
        r8.c = -1000;
        r8.f16102a = r8;
        r8.f16103b = r1;
        b r11 = new b(r3);
        k = r11;
        r11.a(12, 0, r8);     // Catch: IOException -> L34
        r11.a(12, 1, r1);     // Catch: IOException -> L34
        i = new b(r3);
        int r2 = 0;
    L43:
    L31:
        e = move-exception;
        throw new AssertionError(e);
    L6:
        if (r2 >= c.length) goto L12;
        int r9 = 0;
    L8:
        short[][] r12 = c;     // Catch: IOException -> L31
        if (r9 >= r12[r2].length) goto L11;
        i.a(r2 + 2, r12[r2][r9], d[r2][r9]);     // Catch: IOException -> L31
        r9 = r9 + 1;     // Catch: IOException -> L31
        goto L8
    L11:
        r2 = r2 + 1;     // Catch: IOException -> L31
        goto L43
    L12:
        b r4 = i;     // Catch: IOException -> L31
        r4.a(12, 0, h);     // Catch: IOException -> L31
        r4.a(12, 1, g);     // Catch: IOException -> L31
        j = new b(r3);
        int r5 = 0;
    L37:
    L28:
        e = move-exception;
        throw new AssertionError(e);
    L15:
        if (r5 >= e.length) goto L21;
        int r10 = 0;
    L17:
        short[][] r13 = e;     // Catch: IOException -> L28
        if (r10 >= r13[r5].length) goto L20;
        j.a(r5 + 4, r13[r5][r10], f[r5][r10]);     // Catch: IOException -> L28
        r10 = r10 + 1;     // Catch: IOException -> L28
        goto L17
    L20:
        r5 = r5 + 1;     // Catch: IOException -> L28
        goto L37
    L21:
        b r6 = j;     // Catch: IOException -> L28
        r6.a(12, 0, h);     // Catch: IOException -> L28
        r6.a(12, 1, g);     // Catch: IOException -> L28
        b r0 = new b(r3);
        l = r0;
        r0.a(4, 1, AgentManagerErrCode.AGENT_ERR_CODE_BASE);     // Catch: IOException -> L25
        r0.a(3, 1, -4000);     // Catch: IOException -> L25
        r0.a(1, 1, 0);     // Catch: IOException -> L25
        r0.a(3, 3, 1);     // Catch: IOException -> L25
        r0.a(6, 3, 2);     // Catch: IOException -> L25
        r0.a(7, 3, 3);     // Catch: IOException -> L25
        r0.a(3, 2, -1);     // Catch: IOException -> L25
        r0.a(6, 2, -2);     // Catch: IOException -> L25
        r0.a(7, 2, -3);     // Catch: IOException -> L25
        return;
    L25:
        e = move-exception;
        throw new AssertionError(e);
    L34:
        e = move-exception;
        throw new AssertionError(e);
    }

    public d(InputStream r6, int r7, int r8, long r9, boolean r11) {
        super(r6);
        boolean r10 = false;
        this.z = 0;
        this.f16100a = -1;
        this.f16101b = -1;
        this.m = r7;
        this.s = r8;
        this.n = new byte[(r7 + 7) / 8];
        int r12 = r7 + 2;
        this.v = new int[r12];
        this.w = new int[r12];
        if (r8 != 2) goto L5;
        this.r = r11;
        this.o = false;
        this.p = false;
    L25:
        this.q = r10;
        return;
    L5:
        if (r8 != 3) goto L7;
        this.r = r11;
        if ((1 & r9) == 0) goto L16;
        boolean r13 = true;
    L17:
        this.o = r13;
        if ((4 & r9) == 0) goto L20;
        boolean r14 = true;
    L21:
        this.p = r14;
        if ((r9 & 2) == 0) goto L25;
    L10:
        r10 = true;
        goto L25
    L20:
        r14 = false;
        goto L21
    L16:
        r13 = false;
        goto L17
    L7:
        if (r8 != 4) goto L12;
        this.r = r11;
        this.o = false;
        this.p = false;
        if ((r9 & 2) == 0) goto L25;
    L12:
        throw new IllegalArgumentException("Illegal parameter: " + r8);
    }

    private int a(int r2, boolean r3) {
        int r0 = (this.z & (-2)) + (!r3 ? 1 : 0);
        if (r0 <= 2) goto L5;
        r0 = r0 - 2;
    L5:
        if (r2 != 0) goto L8;
        return r0;
    L8:
        if (r0 >= this.x) goto L14;
        if (r2 < this.v[r0]) goto L11;
        r0 = r0 + 2;
        goto L8
    L11:
        this.z = r0;
        return r0;
    L14:
        return -1;
    }

    private int a(b r5) {
        a r0 = r5.f16104a;
        int r1 = 0;
    L3:
        r0 = r0.a(i());
        if (r0 == null) goto L16;
        if (r0.e == false) goto L3;
        r1 = r1 + r0.c;
        if (r0.c < 64) goto L11;
        r0 = r5.f16104a;
        goto L3
    L11:
        if (r0.c < 0) goto L14;
        return r1;
    L14:
        return this.m;
    L16:
        throw new IOException("Unknown code in Huffman RLE stream");
    }

    private void a() {
        if (this.u < this.t) goto L16;
        this.t = 0;
        g();     // Catch: EOFException -> L7 ArrayIndexOutOfBoundsException -> L13
    L11:
        this.u = 0;
        return;
    L7:
        e = move-exception;
        if (this.t != 0) goto L12;
        this.t = -1;
        goto L11
    L12:
        throw e;
    L13:
        e = move-exception;
        throw new IOException("Malformed CCITT stream", e);
    }

    private void b() {
        int r0 = 0;
        this.y = 0;
        boolean r1 = true;
    L3:
        if (r1 == false) goto L5;
        b r2 = j;
    L6:
        r0 = r0 + a(r2);
        int[] r3 = this.w;
        int r4 = this.y;
        this.y = r4 + 1;
        r3[r4] = r0;
        r1 = !r1;
        if (r0 < this.m) goto L3;
        return;
    L5:
        r2 = i;
        goto L6
    }

    private void c() {
        this.x = this.y;
        int[] r0 = this.w;
        this.w = this.v;
        this.v = r0;
        int r1 = 0;
        this.y = 0;
        boolean r2 = true;
    L4:
        if (r1 >= this.m) goto L35;
        a r3 = l.f16104a;
    L6:
        r3 = r3.a(i());
        if (r3 == null) goto L4;
        if (r3.e == false) goto L6;
        int r4 = r3.c;
        if (r4 != (-4000)) goto L13;
        if (r2 == false) goto L29;
        b r5 = j;
    L30:
        int r6 = r1 + a(r5);
        int[] r7 = this.w;
        int r8 = this.y;
        this.y = r8 + 1;
        r7[r8] = r6;
        if (r2 == false) goto L33;
        b r9 = i;
    L34:
        r1 = r6 + a(r9);
        int[] r10 = this.w;
        int r11 = this.y;
        this.y = r11 + 1;
        r10[r11] = r1;
        goto L4
    L33:
        r9 = j;
        goto L34
    L29:
        r5 = i;
        goto L30
    L13:
        int r12 = a(r1, r2);
        if (r4 != (-3000)) goto L16;
        int r13 = r12 + 1;
        if (r13 >= this.x) goto L25;
        r1 = this.v[r13];
        goto L4
    L25:
        r1 = this.m;
        goto L4
    L16:
        if (r12 < this.x) goto L18;
    L21:
        int r14 = this.m;
    L22:
        r1 = r14 + r3.c;
        int[] r15 = this.w;
        int r16 = this.y;
        r15[r16] = r1;
        this.y = r16 + 1;
        r2 = !r2;
        goto L4
    L18:
        if (r12 == (-1)) goto L21;
        r14 = this.v[r12];
        goto L22
    }

    private void d() {
        if (this.r == false) goto L5;
        h();
    L5:
        b();
    }

    private void e() {
        if (this.r == false) goto L5;
        h();
    L5:
        a r0 = k.f16104a;
    L6:
        r0 = r0.a(i());
        if (r0 == null) goto L5;
        if (r0.e == false) goto L6;
        if (this.o == true) goto L14;
    L17:
        b();
        return;
    L14:
        if (i() == true) goto L17;
        c();
    }

    private void f() {
        if (this.r == false) goto L5;
        h();
    L5:
        c();
    }

    private void g() {
        int r0 = this.s;
        if (r0 != 2) goto L5;
        d();
    L13:
        this.z = 0;
        int r2 = 0;
        int r3 = 0;
        boolean r4 = true;
    L14:
        int r5 = this.y;
        if (r2 > r5) goto L54;
        int r7 = this.m;
        if (r2 == r5) goto L19;
        int r6 = this.w[r2];
    L20:
        if (r6 > r7) goto L23;
        r7 = r6;
    L23:
        int r8 = r3 / 8;
    L24:
        int r9 = r3 % 8;
        if (r9 == 0) goto L33;
        if ((r7 - r3) <= 0) goto L33;
        byte[] r10 = this.n;
        byte r11 = r10[r8];
        if (r4 == false) goto L31;
        int r12 = 0;
    L32:
        r10[r8] = (byte) (r12 | r11);
        r3 = r3 + 1;
        goto L24
    L31:
        r12 = 1 << (7 - r9);
    L33:
        if (r9 != 0) goto L43;
        r8 = r3 / 8;
        if (r4 == false) goto L37;
        int r13 = 0;
    L38:
        byte r14 = (byte) r13;
    L40:
        if ((r7 - r3) <= 7) goto L43;
        this.n[r8] = r14;
        r3 = r3 + 8;
        r8 = r8 + 1;
        goto L40
    L37:
        r13 = 255;
    L43:
        if ((r7 - r3) <= 0) goto L52;
        int r15 = r3 % 8;
        if (r15 != 0) goto L47;
        this.n[r8] = 0;
    L47:
        byte[] r16 = this.n;
        byte r17 = r16[r8];
        if (r4 == false) goto L50;
        int r18 = 0;
    L51:
        r16[r8] = (byte) (r18 | r17);
        r3 = r3 + 1;
        goto L43
    L50:
        r18 = 1 << (7 - r15);
        goto L51
    L52:
        r4 = !r4;
        r2 = r2 + 1;
        goto L14
    L19:
        r6 = r7;
        goto L20
    L54:
        if (r3 != this.m) goto L58;
        this.t = (r3 + 7) / 8;
        return;
    L58:
        throw new IOException("Sum of run-lengths does not equal scan line width: " + r3 + " > " + this.m);
    L5:
        if (r0 != 3) goto L7;
        e();
        goto L13
    L7:
        if (r0 != 4) goto L10;
        f();
        goto L13
    L10:
        throw new IllegalArgumentException("Illegal parameter: " + this.s);
    }

    private void h() {
        this.f16101b = -1;
    }

    private boolean i() {
        int r0 = this.f16101b;
        boolean r1 = false;
        if (r0 >= 0) goto L5;
    L6:
        int r2 = this.in.read();
        this.f16100a = r2;
        if (r2 == (-1)) goto L15;
        this.f16101b = 0;
    L9:
        int r3 = this.f16100a;
        if ((r3 & 128) == 0) goto L12;
        r1 = true;
    L12:
        this.f16100a = r3 << 1;
        this.f16101b++;
        return r1;
    L15:
        throw new EOFException("Unexpected end of Huffman RLE stream");
    L5:
        if (r0 <= 7) goto L9;
        goto L6
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int r0 = this.t;
        if (r0 >= 0) goto L6;
        return 0;
    L6:
        if (this.u < r0) goto L10;
        a();
        if (this.t >= 0) goto L10;
        return 0;
    L10:
        byte[] r1 = this.n;
        int r2 = this.u;
        this.u = r2 + 1;
        return r1[r2] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r4, int r5, int r6) {
        int r0 = this.t;
        if (r0 >= 0) goto L7;
        Arrays.fill(r4, r5, r5 + r6, (byte) 0);
        return r6;
    L7:
        if (this.u < r0) goto L12;
        a();
        if (this.t >= 0) goto L12;
        Arrays.fill(r4, r5, r5 + r6, (byte) 0);
        return r6;
    L12:
        int r7 = Math.min(this.t - this.u, r6);
        System.arraycopy(this.n, this.u, r4, r5, r7);
        this.u += r7;
        return r7;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new IOException("mark/reset not supported");     // Catch: Throwable -> L5
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long r5) {
        int r0 = this.t;
        if (r0 >= 0) goto L6;
        return -1;
    L6:
        if (this.u < r0) goto L10;
        a();
        if (this.t >= 0) goto L10;
        return -1;
    L10:
        int r6 = (int) Math.min(this.t - this.u, r5);
        this.u += r6;
        return r6;
    }
}
