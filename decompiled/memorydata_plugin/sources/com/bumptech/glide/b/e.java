package com.bumptech.glide.b;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.fragment.app.FragmentTransaction;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f524a = "e";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f525b;
    private final int[] c;
    private final a.InterfaceC0055a d;
    private ByteBuffer e;
    private byte[] f;
    private short[] g;
    private byte[] h;
    private byte[] i;
    private byte[] j;
    private int[] k;
    private int l;
    private c m;
    private Bitmap n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private int s;
    private Boolean t;
    private Bitmap.Config u;

    static {
    }

    public e(a.InterfaceC0055a r3) {
        a.InterfaceC0055a r4 = (a.InterfaceC0055a) ZeusTransformUtils.wrapperContextForParams(r3, a.InterfaceC0055a.class, "com.obric.memorydata.plugin");
        this.c = new int[256];
        this.u = Bitmap.Config.ARGB_8888;
        this.d = r4;
        this.m = new c();
    }

    public e(a.InterfaceC0055a r3, c r4, ByteBuffer r5, int r6) {
        this((a.InterfaceC0055a) ZeusTransformUtils.wrapperContextForParams(r3, a.InterfaceC0055a.class, "com.obric.memorydata.plugin"));
        a(r4, r5, r6);
    }

    private int a(int r10, int r11, int r12) {
        int r1 = r10;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L4:
        if (r1 >= (this.q + r10)) goto L12;
        byte[] r7 = this.j;
        if (r1 >= r7.length) goto L12;
        if (r1 >= r11) goto L12;
        int r8 = this.f525b[r7[r1] & 255];
        if (r8 == 0) goto L11;
        r2 = r2 + ((r8 >> 24) & 255);
        r3 = r3 + ((r8 >> 16) & 255);
        r4 = r4 + ((r8 >> 8) & 255);
        r5 = r5 + (r8 & 255);
        r6 = r6 + 1;
    L11:
        r1 = r1 + 1;
    L12:
        int r13 = r10 + r12;
        int r14 = r13;
    L14:
        if (r14 >= (this.q + r13)) goto L22;
        byte[] r9 = this.j;
        if (r14 >= r9.length) goto L22;
        if (r14 >= r11) goto L22;
        int r15 = this.f525b[r9[r14] & 255];
        if (r15 == 0) goto L21;
        r2 = r2 + ((r15 >> 24) & 255);
        r3 = r3 + ((r15 >> 16) & 255);
        r4 = r4 + ((r15 >> 8) & 255);
        r5 = r5 + (r15 & 255);
        r6 = r6 + 1;
    L21:
        r14 = r14 + 1;
    L22:
        if (r6 != 0) goto L25;
        return 0;
    L25:
        return ((((r2 / r6) << 24) | ((r3 / r6) << 16)) | ((r4 / r6) << 8)) | (r5 / r6);
    }

    private Bitmap a(b r10, b r11) {
        int[] r8 = this.k;
        int r0 = 0;
        if (r11 != null) goto L9;
        Bitmap r1 = this.n;
        if (r1 == null) goto L7;
        this.d.a(r1);
    L7:
        this.n = null;
        Arrays.fill(r8, 0);
    L9:
        if (r11 != null) goto L11;
    L15:
        if (r11 != null) goto L17;
    L39:
        c(r10);
        if (r10.e == false) goto L42;
    L45:
        b(r10);
    L47:
        if (this.o == true) goto L49;
    L56:
        Bitmap r12 = m();
        int r6 = this.s;
        r12.setPixels(r8, 0, r6, 0, 0, r6, this.r);
        return r12;
    L49:
        if (r10.g == 0) goto L53;
        if (r10.g != 1) goto L56;
    L53:
        if (this.n != null) goto L55;
        this.n = m();
    L55:
        Bitmap r2 = this.n;
        int r7 = this.s;
        r2.setPixels(r8, 0, r7, 0, 0, r7, this.r);
        goto L56
    L42:
        if (this.q != 1) goto L45;
        a(r10);
        goto L47
    L17:
        if (r11.g <= 0) goto L39;
        if (r11.g != 2) goto L35;
        if (r10.f == true) goto L28;
        int r3 = this.m.l;
        if (r10.k != null) goto L25;
    L27:
        r0 = r3;
        goto L28
    L25:
        if (this.m.j != r10.h) goto L27;
    L28:
        int r4 = r11.d / this.q;
        int r5 = r11.f519b / this.q;
        int r9 = r11.c / this.q;
        int r13 = r11.f518a / this.q;
        int r14 = this.s;
        int r15 = (r5 * r14) + r13;
        int r16 = (r4 * r14) + r15;
    L29:
        if (r15 >= r16) goto L39;
        int r17 = r15 + r9;
        int r18 = r15;
    L31:
        if (r18 >= r17) goto L33;
        r8[r18] = r0;
        r18 = r18 + 1;
        goto L31
    L33:
        r15 = r15 + this.s;
        goto L29
    L35:
        if (r11.g != 3) goto L39;
        Bitmap r19 = this.n;
        if (r19 == null) goto L39;
        int r20 = this.s;
        r19.getPixels(r8, 0, r20, 0, 0, r20, this.r);
        goto L39
    L11:
        if (r11.g != 3) goto L15;
        if (this.n != null) goto L15;
        Arrays.fill(r8, 0);
        goto L15
    }

    private void a(b r19) {
        b r1 = r19;
        int[] r2 = this.k;
        int r3 = r1.d;
        int r4 = r1.f519b;
        int r5 = r1.c;
        int r6 = r1.f518a;
        if (this.l != 0) goto L5;
        boolean r7 = true;
    L6:
        int r10 = this.s;
        byte[] r11 = this.j;
        int[] r12 = this.f525b;
        int r14 = 0;
        byte r15 = -1;
    L7:
        if (r14 >= r3) goto L21;
        int r16 = (r14 + r4) * r10;
        int r17 = r16 + r6;
        int r8 = r17 + r5;
        int r9 = r16 + r10;
        if (r9 >= r8) goto L11;
        r8 = r9;
    L11:
        int r13 = r1.c * r14;
        int r18 = r17;
    L12:
        if (r18 >= r8) goto L20;
        byte r20 = r11[r13];
        int r110 = r3;
        int r21 = r20 & 255;
        if (r21 == r15) goto L19;
        int r22 = r12[r21];
        if (r22 == 0) goto L18;
        r2[r18] = r22;
        goto L19
    L18:
        r15 = r20;
    L19:
        r13 = r13 + 1;
        r18 = r18 + 1;
        r3 = r110;
        goto L12
    L20:
        r14 = r14 + 1;
        r1 = r19;
        goto L7
    L21:
        Boolean r23 = this.t;
        if (r23 == null) goto L26;
        if (r23.booleanValue() == false) goto L26;
    L30:
        boolean r24 = true;
    L32:
        this.t = Boolean.valueOf(r24);
        return;
    L26:
        if (this.t != null) goto L31;
        if (r7 == false) goto L31;
        if (r15 != (-1)) goto L30;
    L31:
        r24 = false;
        goto L32
    L5:
        r7 = false;
        goto L6
    }

    private void b(b r25) {
        int[] r2 = this.k;
        int r3 = r25.d / this.q;
        int r4 = r25.f519b / this.q;
        int r5 = r25.c / this.q;
        int r6 = r25.f518a;
        int r7 = this.q;
        int r8 = r6 / r7;
        if (this.l != 0) goto L5;
        boolean r9 = true;
    L6:
        int r12 = this.s;
        int r13 = this.r;
        byte[] r14 = this.j;
        int[] r15 = this.f525b;
        Boolean r10 = this.t;
        int r16 = 8;
        int r19 = 1;
        int r11 = 0;
        int r17 = 0;
    L7:
        Boolean r20 = r10;
        if (r11 >= r3) goto L60;
        if (r25.e == true) goto L12;
        int r22 = r3;
        int r18 = r17;
        r17 = r11;
    L26:
        int r110 = r17 + r4;
        if (r7 != 1) goto L29;
        boolean r111 = true;
    L30:
        if (r110 >= r13) goto L56;
        int r112 = r110 * r12;
        int r21 = r112 + r8;
        int r23 = r21 + r5;
        int r113 = r112 + r12;
        if (r113 >= r23) goto L34;
        r23 = r113;
    L34:
        int r24 = r18;
        int r114 = (r11 * r7) * r25.c;
        if (r111 == false) goto L46;
        int r26 = r21;
    L37:
        int r115 = r4;
        if (r26 >= r23) goto L57;
        int r27 = r15[r14[r114] & 255];
        if (r27 == 0) goto L42;
        r2[r26] = r27;
    L45:
        r114 = r114 + r7;
        r26 = r26 + 1;
        r4 = r115;
        goto L37
    L42:
        if (r9 == false) goto L45;
        if (r20 != null) goto L45;
        r20 = true;
    L57:
        int r28 = r5;
    L58:
        r10 = r20;
        r11 = r11 + 1;
        r4 = r115;
        r5 = r28;
        r3 = r22;
        r17 = r24;
        goto L7
    L46:
        r115 = r4;
        int r29 = ((r23 - r21) * r7) + r114;
        int r30 = r21;
    L47:
        r28 = r5;
        if (r30 >= r23) goto L58;
        int r31 = a(r114, r29, r25.c);
        if (r31 == 0) goto L52;
        r2[r30] = r31;
    L55:
        r114 = r114 + r7;
        r30 = r30 + 1;
        r5 = r28;
        goto L47
    L52:
        if (r9 == false) goto L55;
        if (r20 != null) goto L55;
        r20 = true;
        goto L55
    L56:
        r24 = r18;
        r115 = r4;
        goto L57
    L29:
        r111 = false;
        goto L30
    L12:
        if (r17 < r3) goto L23;
        r22 = r3;
        int r32 = r19 + 1;
        if (r32 != 2) goto L16;
        r19 = r32;
        r17 = 4;
    L24:
        r18 = r17 + r16;
        goto L26
    L16:
        if (r32 == 3) goto L21;
        r19 = r32;
        if (r32 != 4) goto L24;
        r17 = 1;
        r16 = 2;
        goto L24
    L21:
        r19 = r32;
        r16 = 4;
        r17 = 2;
        goto L24
    L23:
        r22 = r3;
        goto L24
    L60:
        if (this.t != null) goto L78;
        if (r20 != null) goto L63;
        boolean r33 = false;
    L64:
        this.t = Boolean.valueOf(r33);
        return;
    L63:
        r33 = r20.booleanValue();
        goto L64
    L78:
        return;
    L5:
        r9 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v15, types: [short] */
    /* JADX WARN: Type inference failed for: r7v17 */
    private void c(b r29) {
        e this = this;
        if (r29 == null) goto L5;
        this.e.position(r29.j);
    L5:
        if (r29 != null) goto L7;
        int r1 = this.m.f * this.m.g;
    L8:
        byte[] r2 = this.j;
        if (r2 != null) goto L11;
    L12:
        this.j = this.d.a(r1);
    L13:
        byte[] r3 = this.j;
        if (this.g != null) goto L16;
        this.g = new short[4096];
    L16:
        short[] r4 = this.g;
        if (this.h != null) goto L19;
        this.h = new byte[4096];
    L19:
        byte[] r5 = this.h;
        if (this.i != null) goto L22;
        this.i = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
    L22:
        byte[] r6 = this.i;
        int r7 = k();
        int r9 = 1 << r7;
        int r10 = r9 + 1;
        int r11 = r9 + 2;
        int r8 = r7 + 1;
        int r12 = (1 << r8) - 1;
        int r13 = 0;
        int r14 = 0;
    L23:
        if (r14 >= r9) goto L25;
        r4[r14] = 0;
        r5[r14] = (byte) r14;
        r14 = r14 + 1;
        goto L23
    L25:
        byte[] r15 = this.f;
        int r23 = r8;
        int r21 = r11;
        int r22 = r12;
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
        int r19 = 0;
        int r20 = 0;
        int r25 = 0;
        int r26 = 0;
        int r24 = -1;
    L26:
        if (r13 >= r1) goto L59;
        if (r16 != 0) goto L32;
        r16 = l();
        if (r16 <= 0) goto L30;
        r17 = 0;
        goto L32
    L30:
        this.p = 3;
    L32:
        r19 = r19 + ((r15[r17] & 255) << r18);
        r17 = r17 + 1;
        r16 = r16 - 1;
        int r27 = r18 + 8;
        r21 = r21;
        r23 = r23;
        r24 = r24;
        r8 = r8;
        r25 = r25;
    L33:
        if (r27 < r23) goto L58;
        int r28 = r11;
        int r110 = r19 & r22;
        r19 = r19 >> r23;
        r27 = r27 - r23;
        if (r110 == r9) goto L36;
        if (r110 == r10) goto L38;
        if (r24 == (-1)) goto L41;
        if (r110 < r21) goto L44;
        r6[r26] = (byte) r25;
        r26 = r26 + 1;
        short r30 = r24;
    L45:
        if (r30 < r9) goto L47;
        r6[r26] = r5[r30];
        r26 = r26 + 1;
        r30 = r4[r30];
        goto L45
    L47:
        r25 = r5[r30] & 255;
        byte r31 = (byte) r25;
        r3[r20] = r31;
    L48:
        r20 = r20 + 1;
        r13 = r13 + 1;
        if (r26 <= 0) goto L51;
        r26 = r26 - 1;
        r3[r20] = r6[r26];
        goto L48
    L51:
        byte[] r210 = r6;
        if (r21 >= 4096) goto L57;
        r4[r21] = (short) r24;
        r5[r21] = r31;
        r21 = r21 + 1;
        if ((r21 & r22) != 0) goto L57;
        if (r21 >= 4096) goto L57;
        r23 = r23 + 1;
        r22 = r22 + r21;
    L57:
        r24 = r110;
        r11 = r28;
        r27 = r27;
        r6 = r210;
        goto L33
    L44:
        r30 = r110;
        goto L45
    L41:
        r3[r20] = r5[r110];
        r20 = r20 + 1;
        r13 = r13 + 1;
        r24 = r110;
        r25 = r24;
        r11 = r28;
        r27 = r27;
        goto L33
    L38:
        r18 = r27;
        r11 = r28;
        goto L26
    L36:
        r22 = r12;
        r23 = r8;
        r21 = r28;
        r11 = r21;
        r24 = -1;
        goto L33
    L58:
        r18 = r27;
    L59:
        Arrays.fill(r3, r20, r1, (byte) 0);
        return;
    L11:
        if (r2.length >= r1) goto L13;
    L7:
        r1 = r29.d * r29.c;
        goto L8
    }

    private int k() {
        return this.e.get() & 255;
    }

    private int l() {
        int r0 = k();
        if (r0 > 0) goto L5;
        return r0;
    L5:
        ByteBuffer r1 = this.e;
        r1.get(this.f, 0, Math.min(r0, r1.remaining()));
        return r0;
    }

    private Bitmap m() {
        Boolean r0 = this.t;
        if (r0 != null) goto L5;
    L8:
        Bitmap.Config r1 = Bitmap.Config.ARGB_8888;
    L9:
        Bitmap r3 = this.d.a(this.s, this.r, r1);
        r3.setHasAlpha(true);
        return r3;
    L5:
        if (r0.booleanValue() == true) goto L8;
        r1 = this.u;
        goto L9
    }

    public int a(int r2) {
        if (r2 >= 0) goto L4;
    L6:
        return -1;
    L4:
        if (r2 >= this.m.c) goto L6;
        return ((b) ZeusTransformUtils.preCheckCast(this.m.e.get(r2), b.class, "com.obric.memorydata.plugin")).i;
    }

    @Override // com.bumptech.glide.b.a
    public ByteBuffer a() {
        return this.e;
    }

    @Override // com.bumptech.glide.b.a
    public void a(Bitmap.Config r3) {
        if (r3 != Bitmap.Config.ARGB_8888) goto L5;
    L9:
        this.u = r3;
        return;
    L5:
        if (r3 == Bitmap.Config.RGB_565) goto L9;
        throw new IllegalArgumentException("Unsupported format: " + r3 + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    public synchronized void a(c r4, ByteBuffer r5, int r6) {
        monitor-enter(this);
        if (r6 <= 0) goto L16;
        int r7 = Integer.highestOneBit(r6);     // Catch: Throwable -> L13
        this.p = 0;     // Catch: Throwable -> L13
        this.m = r4;     // Catch: Throwable -> L13
        this.l = -1;     // Catch: Throwable -> L13
        ByteBuffer r8 = r5.asReadOnlyBuffer();     // Catch: Throwable -> L13
        this.e = r8;     // Catch: Throwable -> L13
        r8.position(0);     // Catch: Throwable -> L13
        this.e.order(ByteOrder.LITTLE_ENDIAN);     // Catch: Throwable -> L13
        this.o = false;     // Catch: Throwable -> L13
        Iterator<b> r9 = r4.e.iterator();     // Catch: Throwable -> L13
    L6:
        if (r9.hasNext() == false) goto L10;
        if (((b) ZeusTransformUtils.preCheckCast(r9.next(), b.class, "com.obric.memorydata.plugin")).g != 3) goto L6;
        this.o = true;     // Catch: Throwable -> L13
    L10:
        this.q = r7;     // Catch: Throwable -> L13
        this.s = r4.f / r7;     // Catch: Throwable -> L13
        this.r = r4.g / r7;     // Catch: Throwable -> L13
        this.j = this.d.a(r4.f * r4.g);     // Catch: Throwable -> L13
        this.k = this.d.b(this.s * this.r);     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L16:
        throw new IllegalArgumentException("Sample size must be >=0, not: " + r6);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.b.a
    public void b() {
        this.l = (this.l + 1) % this.m.c;
    }

    @Override // com.bumptech.glide.b.a
    public int c() {
        if (this.m.c <= 0) goto L9;
        int r0 = this.l;
        if (r0 >= 0) goto L8;
        return 0;
    L8:
        return a(r0);
    L9:
        return 0;
    }

    @Override // com.bumptech.glide.b.a
    public int d() {
        return this.m.c;
    }

    @Override // com.bumptech.glide.b.a
    public int e() {
        return this.l;
    }

    @Override // com.bumptech.glide.b.a
    public void f() {
        this.l = -1;
    }

    @Override // com.bumptech.glide.b.a
    public int g() {
        if (this.m.m != (-1)) goto L6;
        return 1;
    L6:
        if (this.m.m != 0) goto L10;
        return 0;
    L10:
        return this.m.m + 1;
    }

    @Override // com.bumptech.glide.b.a
    public int h() {
        return (this.e.limit() + this.j.length) + (this.k.length * 4);
    }

    @Override // com.bumptech.glide.b.a
    public synchronized Bitmap i() {
        monitor-enter(this);
    L50:
        th = move-exception;
        throw th;
    L4:
        if (this.m.c > 0) goto L6;
    L7:
        String r0 = f524a;     // Catch: Throwable -> L50
        if (Log.isLoggable(r0, 3) == false) goto L10;
        Log.d(r0, "Unable to decode frame, frameCount=" + this.m.c + ", framePointer=" + this.l);     // Catch: Throwable -> L50
    L10:
        this.p = 1;     // Catch: Throwable -> L50
    L11:
        int r1 = this.p;     // Catch: Throwable -> L50
        if (r1 != 1) goto L14;
    L45:
        String r2 = f524a;     // Catch: Throwable -> L50
        if (Log.isLoggable(r2, 3) == false) goto L48;
        Log.d(r2, "Unable to decode frame, status=" + this.p);     // Catch: Throwable -> L50
    L48:
        monitor-exit(this);
        return null;
    L14:
        if (r1 == 2) goto L45;
        this.p = 0;     // Catch: Throwable -> L50
        if (this.f != null) goto L19;
        this.f = this.d.a(255);     // Catch: Throwable -> L50
    L19:
        b r5 = (b) ZeusTransformUtils.preCheckCast(this.m.e.get(this.l), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L50
        int r6 = this.l - 1;     // Catch: Throwable -> L50
        if (r6 < 0) goto L22;
        b r7 = (b) ZeusTransformUtils.preCheckCast(this.m.e.get(r6), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L50
    L24:
        if (r5.k == null) goto L26;
        int[] r8 = r5.k;     // Catch: Throwable -> L50
    L27:
        this.f525b = r8;     // Catch: Throwable -> L50
        if (r8 != null) goto L36;
        String r3 = f524a;     // Catch: Throwable -> L50
        if (Log.isLoggable(r3, 3) == false) goto L32;
        Log.d(r3, "No valid color table found for frame #" + this.l);     // Catch: Throwable -> L50
    L32:
        this.p = 1;     // Catch: Throwable -> L50
        monitor-exit(this);
        return null;
    L36:
        if (r5.f == false) goto L42;
        int[] r4 = this.f525b;     // Catch: Throwable -> L50
        System.arraycopy(r4, 0, this.c, 0, r4.length);     // Catch: Throwable -> L50
        int[] r9 = this.c;     // Catch: Throwable -> L50
        this.f525b = r9;     // Catch: Throwable -> L50
        r9[r5.h] = 0;     // Catch: Throwable -> L50
        if (r5.g != 2) goto L42;
        if (this.l != 0) goto L42;
        this.t = true;     // Catch: Throwable -> L50
    L42:
        Bitmap r10 = a(r5, r7);     // Catch: Throwable -> L50
        monitor-exit(this);
        return r10;
    L26:
        r8 = this.m.f520a;     // Catch: Throwable -> L50
        goto L27
    L22:
        r7 = null;
        goto L24
    L6:
        if (this.l >= 0) goto L11;
        goto L7
    }

    @Override // com.bumptech.glide.b.a
    public void j() {
        this.m = null;
        byte[] r1 = this.j;
        if (r1 == null) goto L5;
        this.d.a(r1);
    L5:
        int[] r2 = this.k;
        if (r2 == null) goto L8;
        this.d.a(r2);
    L8:
        Bitmap r3 = this.n;
        if (r3 == null) goto L11;
        this.d.a(r3);
    L11:
        this.n = null;
        this.e = null;
        this.t = null;
        byte[] r0 = this.f;
        if (r0 == null) goto L15;
        this.d.a(r0);
        return;
    }
}
