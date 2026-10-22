package com.alibaba.excel.support.asm;

import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.Utf8;
import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public final byte[] f310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f311b;
    final byte[] c;
    private final int[] d;
    private final String[] e;
    private final h[] f;
    private final int[] g;
    private final int h;

    public e(InputStream r2) {
        this(a(r2, false));
    }

    public e(byte[] r3) {
        this(r3, 0, r3.length);
    }

    public e(byte[] r1, int r2, int r3) {
        this(r1, r2, true);
    }

    e(byte[] r10, int r11, boolean r12) {
        this.c = r10;
        this.f310a = r10;
        if (r12 == false) goto L9;
        int r13 = r11 + 6;
        if (d(r13) <= 65) goto L9;
        throw new IllegalArgumentException("Unsupported class file major version " + d(r13));
    L9:
        int r14 = c(r11 + 8);
        this.d = new int[r14];
        this.e = new String[r14];
        int r15 = r11 + 10;
        int r0 = 0;
        boolean r2 = false;
        boolean r3 = false;
        int r4 = 1;
    L10:
        if (r4 >= r14) goto L25;
        int r6 = r4 + 1;
        int r7 = r15 + 1;
        this.d[r4] = r7;
        int r5 = 3;
        switch(r10[r15]) {
            case 1: goto L20;
            case 2: goto L14;
            case 3: goto L19;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L18;
            case 7: goto L23;
            case 8: goto L23;
            case 9: goto L19;
            case 10: goto L19;
            case 11: goto L19;
            case 12: goto L19;
            case 13: goto L14;
            case 14: goto L14;
            case 15: goto L17;
            case 16: goto L23;
            case 17: goto L16;
            case 18: goto L15;
            case 19: goto L23;
            case 20: goto L23;
            default: goto L14;
        };
    L15:
        r3 = true;
        goto L19
    L16:
        r2 = true;
        r3 = true;
        goto L19
    L17:
        r5 = 4;
        goto L23
    L18:
        r5 = 9;
        r6 = r6 + 1;
    L19:
        r4 = r6;
        r5 = 5;
    L24:
        r15 = r15 + r5;
        goto L10
    L20:
        r5 = 3 + c(r7);
        if (r5 <= r0) goto L23;
        r0 = r5;
    L23:
        r4 = r6;
        goto L24
    L14:
        throw new IllegalArgumentException();
    L25:
        this.h = r0;
        this.f311b = r15;
        int[] r16 = null;
        if (r2 == false) goto L28;
        h[] r17 = new h[r14];
    L29:
        this.f = r17;
        if (r3 == false) goto L32;
        r16 = g(r0);
    L32:
        this.g = r16;
        return;
    L28:
        r17 = null;
        goto L29
    }

    private int a(int r12, boolean r13, boolean r14, i r15) {
        char[] r6 = r15.c;
        q[] r7 = r15.g;
        if (r13 == false) goto L5;
        int r1 = r12 + 1;
        int r16 = this.c[r12] & 255;
    L6:
        int r17 = 0;
        r15.p = 0;
        if (r16 >= 64) goto L10;
        r15.n = 3;
        r15.r = 0;
    L39:
        r15.m += r16 + 1;
        b(r15.m, r7);
        return r1;
    L10:
        if (r16 >= 128) goto L13;
        r16 = r16 - 64;
        r1 = a(r1, r15.s, 0, r6, r7);
        r15.n = 4;
        r15.r = 1;
        goto L39
    L13:
        if (r16 < 247) goto L42;
        int r10 = c(r1);
        r1 = r1 + 2;
        if (r16 != 247) goto L19;
        r1 = a(r1, r15.s, 0, r6, r7);
        r15.n = 4;
        r15.r = 1;
    L17:
        r16 = r10;
        goto L39
    L19:
        if (r16 < 248) goto L22;
        if (r16 >= 251) goto L22;
        r15.n = 2;
        r15.p = 251 - r16;
        r15.o -= r15.p;
    L32:
        r15.r = 0;
    L22:
        if (r16 != 251) goto L24;
        r15.n = 3;
        goto L32
    L24:
        if (r16 >= 255) goto L33;
        if (r14 == false) goto L27;
        int r18 = r15.o;
    L28:
        int r19 = r16 - 251;
        int r3 = r18;
        int r110 = r19;
    L29:
        if (r110 <= 0) goto L31;
        r1 = a(r1, r15.q, r3, r6, r7);
        r110 = r110 - 1;
        r3 = r3 + 1;
        goto L29
    L31:
        r15.n = 1;
        r15.p = r19;
        r15.o += r15.p;
        goto L32
    L27:
        r18 = 0;
        goto L28
    L33:
        int r111 = c(r1);
        int r2 = r1 + 2;
        r15.n = 0;
        r15.p = r111;
        r15.o = r111;
        int r112 = 0;
    L34:
        if (r112 >= r111) goto L36;
        r2 = a(r2, r15.q, r112, r6, r7);
        r112 = r112 + 1;
        goto L34
    L36:
        int r113 = c(r2);
        r1 = r2 + 2;
        r15.r = r113;
    L37:
        if (r17 >= r113) goto L17;
        r1 = a(r1, r15.s, r17, r6, r7);
        r17 = r17 + 1;
        goto L37
    L42:
        throw new IllegalArgumentException();
    L5:
        r15.m = -1;
        r1 = r12;
        r16 = 255;
        goto L6
    }

    private int a(int r3, Object[] r4, int r5, char[] r6, q[] r7) {
        int r1 = r3 + 1;
        switch((this.c[r3] & 255)) {
            case 0: goto L15;
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        r4[r5] = b(c(r1), r7);
    L17:
        return r1 + 2;
    L7:
        r4[r5] = c(r1, r6);
        goto L17
    L9:
        r4[r5] = v.g;
        return r1;
    L10:
        r4[r5] = v.f;
        return r1;
    L11:
        r4[r5] = v.e;
        return r1;
    L12:
        r4[r5] = v.d;
        return r1;
    L13:
        r4[r5] = v.c;
        return r1;
    L14:
        r4[r5] = v.f336b;
        return r1;
    L15:
        r4[r5] = v.f335a;
        return r1;
    L5:
        throw new IllegalArgumentException();
    }

    private int a(a r10, int r11, String r12, char[] r13) {
        int r3 = 0;
        if (r10 != null) goto L16;
        int r14 = this.c[r11] & 255;
        if (r14 == 64) goto L15;
        if (r14 == 91) goto L13;
        if (r14 == 101) goto L11;
        return r11 + 3;
    L11:
        return r11 + 5;
    L13:
        return a(null, r11 + 1, false, r13);
    L15:
        return a(null, r11 + 3, true, r13);
    L16:
        int r6 = r11 + 1;
        int r15 = this.c[r11] & 255;
        if (r15 == 64) goto L98;
        if (r15 != 70) goto L21;
    L96:
        Object r9 = f(c(r6), r13);
    L39:
        r10.a(r12, r9);
        return r6 + 2;
    L21:
        if (r15 != 83) goto L23;
        r9 = Short.valueOf((short) e(this.d[c(r6)]));
        goto L39
    L23:
        if (r15 == 99) goto L94;
        if (r15 != 101) goto L26;
        r10.a(r12, a(r6, r13), a(r6 + 2, r13));
        return r6 + 4;
    L26:
        if (r15 != 115) goto L28;
        r9 = a(r6, r13);
        goto L39
    L28:
        if (r15 == 73) goto L96;
        if (r15 == 74) goto L96;
        if (r15 == 90) goto L89;
        if (r15 == 91) goto L40;
        switch(r15) {
            case 66: goto L38;
            case 67: goto L37;
            case 68: goto L96;
            default: goto L36;
        };
    L37:
        r9 = Character.valueOf((char) e(this.d[c(r6)]));
        goto L39
    L38:
        r9 = Byte.valueOf((byte) e(this.d[c(r6)]));
        goto L39
    L36:
        throw new IllegalArgumentException();
    L40:
        int r16 = c(r6);
        int r7 = r6 + 2;
        if (r16 == 0) goto L43;
        int r0 = this.c[r7] & 255;
        if (r0 == 70) goto L84;
        if (r0 == 83) goto L80;
        if (r0 == 90) goto L72;
        if (r0 == 73) goto L68;
        if (r0 == 74) goto L64;
        switch(r0) {
            case 66: goto L60;
            case 67: goto L56;
            case 68: goto L52;
            default: goto L110;
        };
    L52:
        double[] r17 = new double[r16];
    L53:
        if (r3 >= r16) goto L55;
        r17[r3] = Double.longBitsToDouble(f(this.d[c(r7 + 1)]));
        r7 = r7 + 3;
        r3 = r3 + 1;
        goto L53
    L55:
        r10.a(r12, r17);
        return r7;
    L56:
        char[] r18 = new char[r16];
    L57:
        if (r3 >= r16) goto L59;
        r18[r3] = (char) e(this.d[c(r7 + 1)]);
        r7 = r7 + 3;
        r3 = r3 + 1;
        goto L57
    L59:
        r10.a(r12, r18);
        return r7;
    L60:
        byte[] r19 = new byte[r16];
    L61:
        if (r3 >= r16) goto L63;
        r19[r3] = (byte) e(this.d[c(r7 + 1)]);
        r7 = r7 + 3;
        r3 = r3 + 1;
        goto L61
    L63:
        r10.a(r12, r19);
        return r7;
    L110:
        return a(r10.a(r12), r7 - 2, false, r13);
    L64:
        long[] r110 = new long[r16];
    L65:
        if (r3 >= r16) goto L67;
        r110[r3] = f(this.d[c(r7 + 1)]);
        r7 = r7 + 3;
        r3 = r3 + 1;
        goto L65
    L67:
        r10.a(r12, r110);
        return r7;
    L68:
        int[] r111 = new int[r16];
    L69:
        if (r3 >= r16) goto L71;
        r111[r3] = e(this.d[c(r7 + 1)]);
        r7 = r7 + 3;
        r3 = r3 + 1;
        goto L69
    L71:
        r10.a(r12, r111);
        return r7;
    L72:
        boolean[] r112 = new boolean[r16];
        int r1 = 0;
    L73:
        if (r1 >= r16) goto L79;
        if (e(this.d[c(r7 + 1)]) == 0) goto L77;
        boolean r2 = true;
    L78:
        r112[r1] = r2;
        r7 = r7 + 3;
        r1 = r1 + 1;
        goto L73
    L77:
        r2 = false;
        goto L78
    L79:
        r10.a(r12, r112);
        return r7;
    L80:
        short[] r113 = new short[r16];
    L81:
        if (r3 >= r16) goto L83;
        r113[r3] = (short) e(this.d[c(r7 + 1)]);
        r7 = r7 + 3;
        r3 = r3 + 1;
        goto L81
    L83:
        r10.a(r12, r113);
        return r7;
    L84:
        float[] r114 = new float[r16];
    L85:
        if (r3 >= r16) goto L87;
        r114[r3] = Float.intBitsToFloat(e(this.d[c(r7 + 1)]));
        r7 = r7 + 3;
        r3 = r3 + 1;
        goto L85
    L87:
        r10.a(r12, r114);
        return r7;
    L43:
        return a(r10.a(r12), r7 - 2, false, r13);
    L89:
        if (e(this.d[c(r6)]) != 0) goto L91;
        r9 = Boolean.FALSE;
        goto L39
    L91:
        r9 = Boolean.TRUE;
        goto L39
    L94:
        r9 = aa.getType(a(r6, r13));
        goto L39
    L98:
        return a(r10.a(r12, a(r6, r13)), r6 + 2, true, r13);
    }

    private int a(a r2, int r3, boolean r4, char[] r5) {
        int r0 = c(r3);
        int r6 = r3 + 2;
        if (r4 == false) goto L7;
    L4:
        int r7 = r0 - 1;
        if (r0 <= 0) goto L10;
        r6 = a(r2, r6 + 2, a(r6, r5), r5);
        r0 = r7;
    L10:
        if (r2 == null) goto L12;
        r2.a();
    L12:
        return r6;
    L7:
        int r8 = r0 - 1;
        if (r0 <= 0) goto L10;
        r6 = a(r2, r6, null, r5);
        r0 = r8;
        goto L7
    }

    private int a(f r25, i r26, int r27) {
        i r9 = r26;
        char[] r10 = r9.c;
        String r11 = a(r27, r10);
        String r12 = a(r27 + 2, r10);
        int r0 = r27 + 4;
        int r1 = c(r0);
        int r2 = r0 + 2;
        int r3 = 0;
        c r4 = null;
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
        String r15 = null;
    L3:
        int r16 = r1 - 1;
        if (r1 <= 0) goto L22;
        String r8 = a(r2, r10);
        int r17 = e(r2 + 2);
        int r13 = r2 + 6;
        if ("Signature".equals(r8) == false) goto L9;
        r15 = a(r13, r10);
        int r21 = r13;
    L21:
        r2 = r21 + r17;
        r9 = r26;
        r1 = r16;
        goto L3
    L9:
        if ("RuntimeVisibleAnnotations".equals(r8) == false) goto L12;
        r7 = r13;
        r21 = r7;
        goto L21
    L12:
        if ("RuntimeVisibleTypeAnnotations".equals(r8) == false) goto L15;
        r5 = r13;
        r21 = r5;
        goto L21
    L15:
        if ("RuntimeInvisibleAnnotations".equals(r8) == false) goto L18;
        r6 = r13;
        r21 = r6;
        goto L21
    L18:
        if ("RuntimeInvisibleTypeAnnotations".equals(r8) == false) goto L20;
        r3 = r13;
        r21 = r3;
        goto L21
    L20:
        r21 = r13;
        c r14 = r4;
        r4 = a(r9.f316a, r8, r21, r17, r10, -1, null);
        r4.f305b = r14;
        r7 = r7;
        r6 = r6;
        r5 = r5;
        r3 = r3;
        goto L21
    L22:
        int r23 = r3;
        c r18 = r4;
        int r22 = r5;
        int r19 = r6;
        int r20 = r7;
        w r24 = r25.b(r11, r12, r15);
        if (r24 != null) goto L26;
        return r2;
    L26:
        if (r20 == 0) goto L31;
        int r28 = c(r20);
        int r29 = r20 + 2;
    L28:
        int r30 = r28 - 1;
        if (r28 <= 0) goto L31;
        r29 = a(r24.a(a(r29, r10), true), r29 + 2, true, r10);
        r28 = r30;
    L31:
        if (r19 == 0) goto L37;
        int r31 = c(r19);
        int r32 = r19 + 2;
    L33:
        int r33 = r31 - 1;
        if (r31 <= 0) goto L37;
        r32 = a(r24.a(a(r32, r10), false), r32 + 2, true, r10);
        r31 = r33;
    L37:
        if (r22 == 0) goto L43;
        int r34 = c(r22);
        int r35 = r22 + 2;
    L39:
        int r36 = r34 - 1;
        if (r34 <= 0) goto L43;
        int r37 = a(r26, r35);
        r35 = a(r24.a(r26.h, r26.i, a(r37, r10), true), r37 + 2, true, r10);
        r34 = r36;
    L43:
        if (r23 == 0) goto L48;
        int r38 = c(r23);
        int r39 = r23 + 2;
    L45:
        int r40 = r38 - 1;
        if (r38 <= 0) goto L48;
        int r41 = a(r26, r39);
        r39 = a(r24.a(r26.h, r26.i, a(r41, r10), false), r41 + 2, true, r10);
        r38 = r40;
    L48:
        c r42 = r18;
    L49:
        if (r42 == null) goto L51;
        c r43 = r42.f305b;
        r42.f305b = null;
        r24.a(r42);
        r42 = r43;
        goto L49
    L51:
        r24.a();
        return r2;
    }

    private int a(i r10, int r11) {
        int r0 = e(r11);
        int r1 = r0 >>> 24;
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L18;
        switch(r1) {
            case 16: goto L16;
            case 17: goto L16;
            case 18: goto L16;
            case 19: goto L15;
            case 20: goto L15;
            case 21: goto L15;
            case 22: goto L18;
            case 23: goto L16;
            default: goto L7;
        };
    L7:
        switch(r1) {
            case 64: goto L12;
            case 65: goto L12;
            case 66: goto L16;
            case 67: goto L11;
            case 68: goto L11;
            case 69: goto L11;
            case 70: goto L11;
            case 71: goto L10;
            case 72: goto L10;
            case 73: goto L10;
            case 74: goto L10;
            case 75: goto L10;
            default: goto L9;
        };
    L10:
        int r2 = r0 & (-16776961);
        int r12 = r11 + 4;
    L19:
        r10.h = r2;
        int r3 = b(r12);
        if (r3 != 0) goto L22;
        ab r9 = null;
    L23:
        r10.i = r9;
        return (r12 + 1) + (r3 * 2);
    L22:
        r9 = new ab(this.c, r12);
        goto L23
    L11:
        r2 = r0 & ViewCompat.MEASURED_STATE_MASK;
    L17:
        r12 = r11 + 3;
        goto L19
    L12:
        r2 = r0 & ViewCompat.MEASURED_STATE_MASK;
        int r4 = c(r11 + 1);
        r12 = r11 + 3;
        r10.j = new q[r4];
        r10.k = new q[r4];
        r10.l = new int[r4];
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L19;
        int r6 = c(r12);
        int r7 = c(r12 + 2);
        int r8 = c(r12 + 4);
        r12 = r12 + 6;
        r10.j[r5] = b(r6, r10.g);
        r10.k[r5] = b(r6 + r7, r10.g);
        r10.l[r5] = r8;
        r5 = r5 + 1;
        goto L13
    L9:
        throw new IllegalArgumentException();
    L15:
        r2 = r0 & ViewCompat.MEASURED_STATE_MASK;
        r12 = r11 + 1;
    L16:
        r2 = r0 & InputDeviceCompat.SOURCE_ANY;
    L18:
        r2 = r0 & (-65536);
        r12 = r11 + 2;
        goto L19
    }

    private static int a(InputStream r1) {
        int r2 = r1.available();
        if (r2 >= 256) goto L7;
        return 4096;
    L7:
        return Math.min(r2, 1048576);
    }

    private int a(int[] r3, int r4) {
        if (r3 != null) goto L4;
        return -1;
    L4:
        if (r4 < r3.length) goto L6;
        return -1;
    L6:
        if (b(r3[r4]) >= 67) goto L9;
        return -1;
    L9:
        return c(r3[r4] + 1);
    }

    private c a(c[] r12, String r13, int r14, int r15, char[] r16, int r17, q[] r18) {
        int r2 = r12.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L10;
        c r4 = r12[r3];
        if (r4.f304a.equals(r13) == true) goto L7;
        r3 = r3 + 1;
        goto L3
    L7:
        return r4.a(this, r14, r15, r16, r17, r18);
    L10:
        return new c(r13).a(this, r14, r15, null, -1, null);
    }

    private String a(int r6, int r7, char[] r8) {
        int r9 = r7 + r6;
        byte[] r5 = this.c;
        int r1 = 0;
    L3:
        if (r6 >= r9) goto L13;
        int r2 = r6 + 1;
        byte r10 = r5[r6];
        if ((r10 & 128) == 0) goto L6;
        if ((r10 & MessagePack.Code.NEGFIXINT_PREFIX) != 192) goto L11;
        r8[r1] = (char) (((r10 & 31) << 6) + (r5[r2] & Utf8.REPLACEMENT_BYTE));
        r1 = r1 + 1;
        r6 = r2 + 1;
        goto L3
    L11:
        int r3 = r1 + 1;
        int r4 = r2 + 1;
        int r11 = ((r10 & 15) << 12) + ((r5[r2] & Utf8.REPLACEMENT_BYTE) << 6);
        r2 = r4 + 1;
        r8[r1] = (char) (r11 + (r5[r4] & Utf8.REPLACEMENT_BYTE));
    L7:
        r6 = r2;
        r1 = r3;
        goto L3
    L6:
        r3 = r1 + 1;
        r8[r1] = (char) (r10 & ByteCompanionObject.MAX_VALUE);
        goto L7
    L13:
        return new String(r8, 0, r1);
    }

    private void a(f r8, i r9, int r10, int r11, String r12) {
        char[] r13 = r9.c;
        String r0 = d(r10, r13);
        int r1 = c(r10 + 2);
        String r2 = a(r10 + 4, r13);
        int r14 = r10 + 6;
        t r15 = r8.a(r0, r1, r2);
        if (r15 != null) goto L5;
        return;
    L5:
        if (r12 == null) goto L7;
        r15.a(r12);
    L7:
        if (r11 == 0) goto L12;
        int r16 = c(r11);
        int r17 = r11 + 2;
    L9:
        int r3 = r16 - 1;
        if (r16 <= 0) goto L12;
        r15.b(e(r17, r13));
        r17 = r17 + 2;
        r16 = r3;
    L12:
        int r18 = c(r14);
        int r19 = r14 + 2;
    L13:
        int r110 = r18 - 1;
        if (r18 <= 0) goto L16;
        String r111 = d(r19, r13);
        int r4 = c(r19 + 2);
        String r5 = a(r19 + 4, r13);
        r19 = r19 + 6;
        r15.a(r111, r4, r5);
        r18 = r110;
        goto L13
    L16:
        int r112 = c(r19);
        int r113 = r19 + 2;
    L17:
        int r114 = r112 - 1;
        String[] r6 = null;
        int r7 = 0;
        if (r112 <= 0) goto L25;
        String r115 = e(r113, r13);
        int r20 = c(r113 + 2);
        int r21 = c(r113 + 4);
        r113 = r113 + 6;
        if (r21 == 0) goto L24;
        r6 = new String[r21];
    L22:
        if (r7 >= r21) goto L24;
        r6[r7] = d(r113, r13);
        r113 = r113 + 2;
        r7 = r7 + 1;
    L24:
        r15.a(r115, r20, r6);
        r112 = r114;
        goto L17
    L25:
        int r116 = c(r113);
        int r117 = r113 + 2;
    L26:
        int r118 = r116 - 1;
        if (r116 <= 0) goto L35;
        String r119 = e(r117, r13);
        int r22 = c(r117 + 2);
        int r23 = c(r117 + 4);
        r117 = r117 + 6;
        if (r23 == 0) goto L33;
        String[] r24 = new String[r23];
        int r25 = 0;
    L31:
        if (r25 >= r23) goto L34;
        r24[r25] = d(r117, r13);
        r117 = r117 + 2;
        r25 = r25 + 1;
    L34:
        r15.b(r119, r22, r24);
        r116 = r118;
        goto L26
    L33:
        r24 = null;
        goto L34
    L35:
        int r120 = c(r117);
        int r121 = r117 + 2;
    L36:
        int r122 = r120 - 1;
        if (r120 <= 0) goto L39;
        r15.c(c(r121, r13));
        r121 = r121 + 2;
        r120 = r122;
        goto L36
    L39:
        int r123 = c(r121);
        int r124 = r121 + 2;
    L40:
        int r125 = r123 - 1;
        if (r123 <= 0) goto L46;
        String r126 = c(r124, r13);
        int r26 = c(r124 + 2);
        r124 = r124 + 4;
        String[] r27 = new String[r26];
        int r28 = 0;
    L43:
        if (r28 >= r26) goto L45;
        r27[r28] = c(r124, r13);
        r124 = r124 + 2;
        r28 = r28 + 1;
        goto L43
    L45:
        r15.a(r126, r27);
        r123 = r125;
        goto L40
    L46:
        r15.a();
    }

    private void a(i r10) {
        String r0 = r10.f;
        Object[] r1 = r10.q;
        int r4 = 0;
        if ((r10.d & 8) == 0) goto L5;
    L9:
        int r9 = 1;
    L10:
        int r2 = r9 + 1;
        char r5 = r0.charAt(r9);
        if (r5 == 'F') goto L45;
        if (r5 != 'L') goto L15;
        int r11 = r2;
    L42:
        if (r0.charAt(r11) == ';') goto L44;
        r11 = r11 + 1;
        goto L42
    L44:
        r1[r4] = r0.substring(r2, r11);
        r4 = r4 + 1;
        r9 = r11 + 1;
        goto L10
    L15:
        if (r5 == 'S') goto L38;
        if (r5 == 'I') goto L38;
        if (r5 == 'J') goto L37;
        if (r5 == 'Z') goto L38;
        if (r5 != '[') goto L24;
    L29:
        if (r0.charAt(r2) != '[') goto L32;
        r2 = r2 + 1;
        goto L29
    L32:
        if (r0.charAt(r2) != 'L') goto L36;
    L33:
        r2 = r2 + 1;
        if (r0.charAt(r2) != ';') goto L33;
    L36:
        int r3 = r2 + 1;
        r1[r4] = r0.substring(r9, r3);
        r9 = r3;
        r4 = r4 + 1;
        goto L10
    L24:
        switch(r5) {
            case 66: goto L38;
            case 67: goto L38;
            case 68: goto L27;
            default: goto L25;
        };
    L27:
        int r12 = r4 + 1;
        r1[r4] = v.d;
    L39:
        r4 = r12;
        r9 = r2;
        goto L10
    L25:
        r10.o = r4;
        return;
    L37:
        r12 = r4 + 1;
        r1[r4] = v.e;
    L38:
        r12 = r4 + 1;
        r1[r4] = v.f336b;
        goto L39
    L45:
        r12 = r4 + 1;
        r1[r4] = v.c;
        goto L39
    L5:
        if ("<init>".equals(r10.e) == false) goto L7;
        r1[0] = v.g;
    L8:
        r4 = 1;
        goto L9
    L7:
        r1[0] = c(this.f311b + 2, r10.c);
        goto L8
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 33721. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private void a(com.alibaba.excel.support.asm.r r40, com.alibaba.excel.support.asm.i r41, int r42) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0002: MOVE (r9v0 ?? I:??[OBJECT, ARRAY]) = (r40v0 ?? I:??[OBJECT, ARRAY]) A[DECLARE_VAR] in method: com.alibaba.excel.support.asm.e.a(com.alibaba.excel.support.asm.r, com.alibaba.excel.support.asm.i, int):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 3372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.excel.support.asm.e.a(com.alibaba.excel.support.asm.r, com.alibaba.excel.support.asm.i, int):void");
    }

    private static byte[] a(InputStream r6, boolean r7) {
        if (r6 == null) goto L27;
        int r0 = a(r6);
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();     // Catch: Throwable -> L22
        byte[] r2 = new byte[r0];     // Catch: Throwable -> L14
    L6:
        int r4 = r6.read(r2, 0, r0);     // Catch: Throwable -> L14
        if (r4 == (-1)) goto L9;
        r1.write(r2, 0, r4);     // Catch: Throwable -> L14
        goto L6
    L9:
        r1.flush();     // Catch: Throwable -> L14
        byte[] r3 = r1.toByteArray();     // Catch: Throwable -> L14
        r1.close();     // Catch: Throwable -> L22
        if (r7 == false) goto L13;
        r6.close();
    L13:
        return r3;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: Throwable -> L22
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        if (r7 == false) goto L25;
        r6.close();
    L25:
        throw th;
    L27:
        throw new IOException("Class not found");
    }

    private int[] a(r r11, i r12, int r13, boolean r14) {
        char[] r0 = r12.c;
        int r1 = c(r13);
        int[] r2 = new int[r1];
        int r15 = r13 + 2;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L24;
        r2[r3] = r15;
        int r4 = e(r15);
        int r5 = r4 >>> 24;
        if (r5 == 23) goto L15;
        switch(r5) {
            case 16: goto L15;
            case 17: goto L15;
            case 18: goto L15;
            default: goto L7;
        };
    L7:
        switch(r5) {
            case 64: goto L11;
            case 65: goto L11;
            case 66: goto L15;
            case 67: goto L15;
            case 68: goto L15;
            case 69: goto L15;
            case 70: goto L15;
            case 71: goto L10;
            case 72: goto L10;
            case 73: goto L10;
            case 74: goto L10;
            case 75: goto L10;
            default: goto L9;
        };
    L10:
        int r16 = r15 + 4;
    L16:
        int r6 = b(r16);
        ab r8 = null;
        if (r5 != 66) goto L22;
        if (r6 == 0) goto L21;
        r8 = new ab(this.c, r16);
    L21:
        int r17 = r16 + ((r6 * 2) + 1);
        r15 = a(r11.c(r4 & InputDeviceCompat.SOURCE_ANY, r8, a(r17, r0), r14), r17 + 2, true, r0);
    L23:
        r3 = r3 + 1;
        goto L3
    L22:
        r15 = a(null, r16 + ((r6 * 2) + 3), true, r0);
        goto L23
    L11:
        int r7 = c(r15 + 1);
        r16 = r15 + 3;
    L12:
        int r9 = r7 - 1;
        if (r7 <= 0) goto L16;
        int r10 = c(r16);
        int r18 = c(r16 + 2);
        r16 = r16 + 6;
        b(r10, r12.g);
        b(r10 + r18, r12.g);
        r7 = r9;
        goto L12
    L9:
        throw new IllegalArgumentException();
    L15:
        r16 = r15 + 3;
        goto L16
    L24:
        return r2;
    }

    private int b(f r28, i r29, int r30) {
        i r9 = r29;
        char[] r10 = r9.c;
        int r1 = c(r30);
        String r13 = a(r30 + 2, r10);
        String r14 = a(r30 + 4, r10);
        int r0 = r30 + 6;
        int r2 = c(r0);
        int r3 = r0 + 2;
        int r11 = r1;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
        c r8 = null;
        String r16 = null;
        Object r17 = null;
    L3:
        int r18 = r2 - 1;
        if (r2 <= 0) goto L36;
        String r12 = a(r3, r10);
        int r19 = e(r3 + 2);
        int r15 = r3 + 6;
        if ("ConstantValue".equals(r12) == false) goto L12;
        int r20 = c(r15);
        if (r20 != 0) goto L10;
        r17 = null;
    L14:
        int r23 = r15;
    L35:
        r3 = r23 + r19;
        r9 = r29;
        r2 = r18;
        goto L3
    L10:
        r17 = f(r20, r10);
        goto L14
    L12:
        if ("Signature".equals(r12) == false) goto L16;
        r16 = a(r15, r10);
        goto L14
    L16:
        if ("Deprecated".equals(r12) == false) goto L20;
        int r21 = 131072 | r11;
    L18:
        r11 = r21;
        goto L14
    L20:
        if ("Synthetic".equals(r12) == false) goto L23;
        r21 = r11 | 4096;
        goto L18
    L23:
        if ("RuntimeVisibleAnnotations".equals(r12) == false) goto L26;
        r7 = r15;
        r23 = r7;
        goto L35
    L26:
        if ("RuntimeVisibleTypeAnnotations".equals(r12) == false) goto L29;
        r5 = r15;
        r23 = r5;
        goto L35
    L29:
        if ("RuntimeInvisibleAnnotations".equals(r12) == false) goto L32;
        r6 = r15;
        r23 = r6;
        goto L35
    L32:
        if ("RuntimeInvisibleTypeAnnotations".equals(r12) == false) goto L34;
        r4 = r15;
        r23 = r4;
        goto L35
    L34:
        r23 = r15;
        c r24 = r8;
        r8 = a(r9.f316a, r12, r23, r19, r10, -1, null);
        r8.f305b = r24;
        r6 = r6;
        r7 = r7;
        r4 = r4;
        r5 = r5;
        goto L35
    L36:
        c r22 = r8;
        int r25 = r4;
        int r26 = r5;
        int r31 = r6;
        int r27 = r7;
        l r32 = r28.a(r11, r13, r14, r16, r17);
        if (r32 != null) goto L40;
        return r3;
    L40:
        if (r27 == 0) goto L45;
        int r33 = c(r27);
        int r34 = r27 + 2;
    L42:
        int r35 = r33 - 1;
        if (r33 <= 0) goto L45;
        r34 = a(r32.a(a(r34, r10), true), r34 + 2, true, r10);
        r33 = r35;
    L45:
        if (r31 == 0) goto L51;
        int r36 = c(r31);
        int r37 = r31 + 2;
    L47:
        int r38 = r36 - 1;
        if (r36 <= 0) goto L51;
        r37 = a(r32.a(a(r37, r10), false), r37 + 2, true, r10);
        r36 = r38;
    L51:
        if (r26 == 0) goto L57;
        int r39 = c(r26);
        int r40 = r26 + 2;
    L53:
        int r41 = r39 - 1;
        if (r39 <= 0) goto L57;
        int r42 = a(r29, r40);
        r40 = a(r32.a(r29.h, r29.i, a(r42, r10), true), r42 + 2, true, r10);
        r39 = r41;
    L57:
        if (r25 == 0) goto L62;
        int r43 = c(r25);
        int r44 = r25 + 2;
    L59:
        int r110 = r43 - 1;
        if (r43 <= 0) goto L62;
        int r45 = a(r29, r44);
        r44 = a(r32.a(r29.h, r29.i, a(r45, r10), false), r45 + 2, true, r10);
        r43 = r110;
    L62:
        c r46 = r22;
        if (r46 == null) goto L65;
        r22 = r46.f305b;
        r46.f305b = null;
        r32.a(r46);
        goto L62
    L65:
        r32.a();
        return r3;
    }

    private q b(int r1, q[] r2) {
        q r0 = a(r1, r2);
        r0.f329b = (short) (r0.f329b & (-2));
        return r0;
    }

    private void b(r r6, i r7, int r8, boolean r9) {
        int r1 = r8 + 1;
        int r10 = this.c[r8] & 255;
        r6.a(r10, r9);
        char[] r11 = r7.c;
        int r0 = 0;
    L3:
        if (r0 >= r10) goto L9;
        int r2 = c(r1);
        r1 = r1 + 2;
    L5:
        int r3 = r2 - 1;
        if (r2 <= 0) goto L8;
        r1 = a(r6.a(r0, a(r1, r11), r9), r1 + 2, true, r11);
        r2 = r3;
        goto L5
    L8:
        r0 = r0 + 1;
        goto L3
    }

    private int c(f r34, i r35, int r36) {
        char[] r11 = r35.c;
        r35.d = c(r36);
        r35.e = a(r36 + 2, r11);
        int r12 = r36 + 4;
        r35.f = a(r12, r11);
        int r0 = r36 + 6;
        int r1 = c(r0);
        int r7 = r0 + 2;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
        int r8 = 0;
        c r14 = null;
        boolean r15 = false;
        int r16 = 0;
        String[] r22 = null;
        int r23 = 0;
        int r24 = 0;
        int r25 = 0;
        int r26 = 0;
    L3:
        int r17 = r1 - 1;
        if (r1 <= 0) goto L54;
        String r9 = a(r7, r11);
        int r13 = e(r7 + 2);
        int r10 = r7 + 6;
        r2 = r2;
        if (com.tom_roush.pdfbox.pdmodel.a.d.i.K.equals(r9) == false) goto L12;
        if ((r35.f317b & 1) != 0) goto L10;
        r26 = r10;
        r2 = r2;
        int r18 = r26;
    L53:
        r7 = r18 + r13;
        r1 = r17;
        goto L3
    L10:
        int r19 = r3;
        int r20 = r4;
    L23:
        r3 = r19;
        r4 = r20;
    L24:
        r18 = r10;
        goto L53
    L12:
        if ("Exceptions".equals(r9) == false) goto L17;
        int r21 = c(r10);
        String[] r27 = new String[r21];
        int r110 = r3;
        int r28 = r4;
        int r29 = r10 + 2;
        int r30 = 0;
    L14:
        if (r30 >= r21) goto L16;
        r27[r30] = c(r29, r11);
        r29 = r29 + 2;
        r30 = r30 + 1;
        goto L14
    L16:
        r22 = r27;
        r16 = r10;
        r2 = r2;
        r3 = r110;
        r4 = r28;
        r18 = r16;
        goto L53
    L17:
        r19 = r3;
        r20 = r4;
        if ("Signature".equals(r9) == false) goto L21;
        r8 = c(r10);
        goto L23
    L21:
        if ("Deprecated".equals(r9) == false) goto L26;
        r35.d |= 131072;
        goto L23
    L26:
        if ("RuntimeVisibleAnnotations".equals(r9) == false) goto L29;
        r4 = r10;
        r2 = r2;
        r3 = r19;
        r18 = r4;
        goto L53
    L29:
        if ("RuntimeVisibleTypeAnnotations".equals(r9) == false) goto L32;
        r2 = r10;
        r18 = r2;
        r3 = r19;
        r4 = r20;
        goto L53
    L32:
        if ("AnnotationDefault".equals(r9) == false) goto L35;
        r5 = r10;
        r2 = r2;
        r3 = r19;
        r4 = r20;
        r18 = r5;
        goto L53
    L35:
        if ("Synthetic".equals(r9) == false) goto L38;
        r35.d |= 4096;
        r3 = r19;
        r4 = r20;
        r15 = true;
        goto L24
    L38:
        if ("RuntimeInvisibleAnnotations".equals(r9) == false) goto L41;
        r3 = r10;
        r2 = r2;
        r4 = r20;
        r18 = r3;
        goto L53
    L41:
        if ("RuntimeInvisibleTypeAnnotations".equals(r9) == false) goto L44;
        r23 = r10;
        r2 = r2;
        r3 = r19;
        r4 = r20;
        r18 = r23;
        goto L53
    L44:
        if ("RuntimeVisibleParameterAnnotations".equals(r9) == false) goto L47;
        r24 = r10;
        r2 = r2;
        r3 = r19;
        r4 = r20;
        r18 = r24;
        goto L53
    L47:
        if ("RuntimeInvisibleParameterAnnotations".equals(r9) == false) goto L50;
        r25 = r10;
        r2 = r2;
        r3 = r19;
        r4 = r20;
        r18 = r25;
        goto L53
    L50:
        if ("MethodParameters".equals(r9) == false) goto L52;
        r6 = r10;
        r2 = r2;
        r3 = r19;
        r4 = r20;
        r18 = r6;
        goto L53
    L52:
        r18 = r10;
        c r31 = a(r35.f316a, r9, r10, r13, r11, -1, null);
        r31.f305b = r14;
        r14 = r31;
        r8 = r8;
        r3 = r19;
        r4 = r20;
        r2 = r2;
        r5 = r5;
        r6 = r6;
        goto L53
    L54:
        int r32 = r2;
        int r210 = r3;
        int r211 = r4;
        int r33 = r5;
        int r37 = r6;
        int r111 = r8;
        int r38 = r35.d;
        String r39 = r35.e;
        String r40 = r35.f;
        if (r111 != 0) goto L57;
        String r212 = null;
    L58:
        r r112 = r34.a(r38, r39, r40, r212, r22);
        if (r112 != null) goto L62;
        return r7;
    L62:
        if (ZeusTransformUtils.instanceOf(r112, s.class) == false) goto L72;
        s r41 = (s) ZeusTransformUtils.preCheckCast(r112, s.class, "com.obric.memorydata.plugin");
        if ((r35.d & 131072) == 0) goto L66;
        boolean r42 = true;
    L68:
        if (r41.a(this, r15, r42, c(r12), r111, r16) == false) goto L72;
        r41.f(r36, r7 - r36);
        return r7;
    L66:
        r42 = false;
    L72:
        if (r37 == 0) goto L80;
        if ((r35.f317b & 2) != 0) goto L80;
        int r43 = b(r37);
        int r44 = r37 + 1;
    L76:
        int r45 = r43 - 1;
        if (r43 <= 0) goto L80;
        r112.a(a(r44, r11), c(r44 + 2));
        r44 = r44 + 4;
        r43 = r45;
    L80:
        if (r33 == 0) goto L85;
        a r46 = r112.a();
        a(r46, r33, null, r11);
        if (r46 == null) goto L85;
        r46.a();
    L85:
        if (r211 == 0) goto L91;
        int r47 = c(r211);
        int r48 = r211 + 2;
    L87:
        int r49 = r47 - 1;
        if (r47 <= 0) goto L91;
        r48 = a(r112.a(a(r48, r11), true), r48 + 2, true, r11);
        r47 = r49;
    L91:
        if (r210 == 0) goto L97;
        int r50 = c(r210);
        int r51 = r210 + 2;
    L93:
        int r52 = r50 - 1;
        if (r50 <= 0) goto L97;
        r51 = a(r112.a(a(r51, r11), false), r51 + 2, true, r11);
        r50 = r52;
    L97:
        if (r32 == 0) goto L102;
        int r53 = c(r32);
        int r54 = r32 + 2;
    L99:
        int r55 = r53 - 1;
        if (r53 <= 0) goto L102;
        int r56 = a(r35, r54);
        r54 = a(r112.a(r35.h, r35.i, a(r56, r11), true), r56 + 2, true, r11);
        r53 = r55;
    L102:
        int r57 = r23;
        if (r57 == 0) goto L108;
        int r58 = c(r57);
        int r59 = r57 + 2;
    L105:
        int r60 = r58 - 1;
        if (r58 <= 0) goto L108;
        int r61 = a(r35, r59);
        r59 = a(r112.a(r35.h, r35.i, a(r61, r11), false), r61 + 2, true, r11);
        r58 = r60;
    L108:
        int r62 = r24;
        if (r62 == 0) goto L111;
        b(r112, r35, r62, true);
    L111:
        int r63 = r25;
        if (r63 == 0) goto L114;
        b(r112, r35, r63, false);
    L114:
        if (r14 == null) goto L116;
        c r64 = r14.f305b;
        r14.f305b = null;
        r112.a(r14);
        r14 = r64;
        goto L114
    L116:
        int r113 = r26;
        if (r113 == 0) goto L119;
        r112.b();
        a(r112, r35, r113);
    L119:
        r112.c();
        return r7;
    L57:
        r212 = b(r111, r11);
        goto L58
    }

    private void c(int r2, q[] r3) {
        if (r3[r2] != null) goto L6;
        q r1 = a(r2, r3);
        r1.f329b = (short) (r1.f329b | 1);
        return;
    }

    private String g(int r2, char[] r3) {
        return a(this.d[c(r2)], r3);
    }

    private int[] g(int r6) {
        char[] r7 = new char[r6];
        int r0 = a();
        int r1 = c(r0 - 2);
    L3:
        if (r1 <= 0) goto L12;
        String r2 = a(r0, r7);
        int r3 = e(r0 + 2);
        int r4 = r0 + 6;
        if ("BootstrapMethods".equals(r2) == true) goto L6;
        r0 = r4 + r3;
        r1 = r1 - 1;
        goto L3
    L6:
        int r8 = c(r4);
        int[] r5 = new int[r8];
        int r9 = r4 + 2;
        int r10 = 0;
    L7:
        if (r10 >= r8) goto L9;
        r5[r10] = r9;
        r9 = r9 + ((c(r9 + 2) * 2) + 4);
        r10 = r10 + 1;
        goto L7
    L9:
        return r5;
    L12:
        throw new IllegalArgumentException();
    }

    private h h(int r9, char[] r10) {
        h r0 = this.f[r9];
        if (r0 == null) goto L5;
        return r0;
    L5:
        int[] r1 = this.d;
        int r2 = r1[r9];
        int r3 = r1[c(r2 + 2)];
        String r4 = a(r3, r10);
        String r5 = a(r3 + 2, r10);
        int r6 = this.g[c(r2)];
        o r7 = (o) ZeusTransformUtils.preCheckCast(f(c(r6), r10), o.class, "com.obric.memorydata.plugin");
        int r8 = c(r6 + 2);
        Object[] r11 = new Object[r8];
        int r12 = r6 + 4;
        int r13 = 0;
    L6:
        if (r13 >= r8) goto L8;
        r11[r13] = f(c(r12), r10);
        r12 = r12 + 2;
        r13 = r13 + 1;
        goto L6
    L8:
        h[] r14 = this.f;
        h r15 = new h(r4, r5, r7, r11);
        r14[r9] = r15;
        return r15;
    }

    final int a() {
        int r0 = this.f311b;
        int r1 = (r0 + 8) + (c(r0 + 6) * 2);
        int r2 = c(r1);
        int r3 = r1 + 2;
    L3:
        int r4 = r2 - 1;
        if (r2 <= 0) goto L10;
        int r5 = c(r3 + 6);
        r3 = r3 + 8;
    L6:
        int r6 = r5 - 1;
        if (r5 <= 0) goto L9;
        r3 = r3 + (e(r3 + 2) + 6);
        r5 = r6;
        goto L6
    L9:
        r2 = r4;
        goto L3
    L10:
        int r7 = c(r3);
        int r8 = r3 + 2;
    L11:
        int r9 = r7 - 1;
        if (r7 <= 0) goto L19;
        int r10 = c(r8 + 6);
        r8 = r8 + 8;
    L14:
        int r11 = r10 - 1;
        if (r10 <= 0) goto L17;
        r8 = r8 + (e(r8 + 2) + 6);
        r10 = r11;
        goto L14
    L17:
        r7 = r9;
        goto L11
    L19:
        return r8 + 2;
    }

    public int a(int r1) {
        return this.d[r1];
    }

    public q a(int r1, q[] r2) {
        if (r1 < r2.length) goto L7;
        return new q();
    L7:
        if (r2[r1] != null) goto L10;
        r2[r1] = new q();
    L10:
        return r2[r1];
    }

    public String a(int r2, char[] r3) {
        int r0 = c(r2);
        if (r2 == 0) goto L8;
        if (r0 != 0) goto L7;
        return null;
    L7:
        return b(r0, r3);
    L8:
        return null;
    }

    public void a(f r2, int r3) {
        a(r2, new c[0], r3);
    }

    public void a(f r42, c[] r43, int r44) {
        i r11 = new i();
        r11.f316a = r43;
        r11.f317b = r44;
        r11.c = new char[this.h];
        char[] r13 = r11.c;
        int r0 = this.f311b;
        int r1 = c(r0);
        String r14 = c(r0 + 2, r13);
        String r15 = c(r0 + 4, r13);
        int r2 = c(r0 + 6);
        String[] r7 = new String[r2];
        int r5 = r0 + 8;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r7[r3] = c(r5, r13);
        r5 = r5 + 2;
        r3 = r3 + 1;
        goto L3
    L5:
        int r4 = a();
        int r6 = r1;
        int r16 = c(r4 - 2);
        String r8 = null;
        String r9 = null;
        int r17 = 0;
        String r18 = null;
        int r19 = 0;
        String r20 = null;
        String r21 = null;
        int r22 = 0;
        int r23 = 0;
        int r24 = 0;
        int r25 = 0;
        int r26 = 0;
        int r27 = 0;
        c r28 = null;
        int r29 = 0;
        int r30 = 0;
        int r31 = 0;
    L6:
        if (r16 <= 0) goto L73;
        String r10 = a(r4, r13);
        int r12 = e(r4 + 2);
        int r32 = r4 + 6;
        String r34 = r8;
        if ("SourceFile".equals(r10) == false) goto L13;
        int r37 = r32;
        r9 = a(r32, r13);
    L10:
        r8 = r34;
    L72:
        r4 = r37 + r12;
        r16 = r16 - 1;
        r7 = r7;
        r5 = r5;
        goto L6
    L13:
        if ("InnerClasses".equals(r10) == false) goto L16;
        r30 = r32;
        r37 = r30;
        goto L10
    L16:
        if ("EnclosingMethod".equals(r10) == false) goto L19;
        r22 = r32;
        r37 = r22;
        goto L10
    L19:
        if ("NestHost".equals(r10) == false) goto L22;
        r37 = r32;
        r21 = c(r32, r13);
        goto L10
    L22:
        if ("NestMembers".equals(r10) == false) goto L25;
        r27 = r32;
        r37 = r27;
        goto L10
    L25:
        if ("PermittedSubclasses".equals(r10) == false) goto L28;
        r29 = r32;
        r37 = r29;
        goto L10
    L28:
        if ("Signature".equals(r10) == false) goto L32;
        r18 = a(r32, r13);
    L30:
        r37 = r32;
        goto L10
    L32:
        if ("RuntimeVisibleAnnotations".equals(r10) == false) goto L35;
        r23 = r32;
        r37 = r23;
        goto L10
    L35:
        if ("RuntimeVisibleTypeAnnotations".equals(r10) == false) goto L38;
        r25 = r32;
        r37 = r25;
        goto L10
    L38:
        if ("Deprecated".equals(r10) == false) goto L41;
        r6 = r6 | 131072;
        goto L30
    L41:
        if ("Synthetic".equals(r10) == false) goto L44;
        r6 = r6 | 4096;
        goto L30
    L44:
        if ("SourceDebugExtension".equals(r10) == false) goto L51;
        if (r12 > (this.c.length - r32)) goto L49;
        r8 = a(r32, r12, new char[r12]);
        r37 = r32;
        goto L72
    L49:
        throw new IllegalArgumentException();
    L51:
        if ("RuntimeInvisibleAnnotations".equals(r10) == false) goto L54;
        r24 = r32;
        r37 = r24;
        goto L10
    L54:
        if ("RuntimeInvisibleTypeAnnotations".equals(r10) == false) goto L57;
        r26 = r32;
        r37 = r26;
        goto L10
    L57:
        if ("Record".equals(r10) == false) goto L60;
        r6 = r6 | 65536;
        r31 = r32;
        r37 = r31;
        goto L10
    L60:
        if ("Module".equals(r10) == false) goto L63;
        r17 = r32;
        r37 = r17;
        goto L10
    L63:
        if ("ModuleMainClass".equals(r10) == false) goto L66;
        r20 = c(r32, r13);
        goto L30
    L66:
        if ("ModulePackages".equals(r10) == false) goto L69;
        r19 = r32;
        r37 = r19;
        goto L10
    L69:
        if ("BootstrapMethods".equals(r10) == true) goto L71;
        r37 = r32;
        r5 = r5;
        r12 = r12;
        r7 = r7;
        c r33 = a(r43, r10, r37, r12, r13, -1, null);
        r33.f305b = r28;
        r28 = r33;
        r6 = r6;
        r8 = r34;
        r9 = r9;
        goto L72
    L71:
        r37 = r32;
        r5 = r5;
        r12 = r12;
        r7 = r7;
        r8 = r34;
        goto L72
    L73:
        String r38 = r8;
        String r39 = r9;
        int r40 = r5;
        String[] r35 = r7;
        c r36 = r28;
        r42.a(e(this.d[1] - 7), r6, r14, r18, r15, r35);
        if ((r44 & 2) == 0) goto L76;
    L79:
        if (r17 == 0) goto L81;
        a(r42, r11, r17, r19, r20);
    L81:
        String r41 = r21;
        if (r41 == null) goto L84;
        r42.a(r41);
    L84:
        int r45 = r22;
        if (r45 == 0) goto L94;
        String r46 = c(r45, r13);
        int r47 = c(r45 + 2);
        if (r47 != 0) goto L89;
        String r48 = null;
    L90:
        if (r47 != 0) goto L92;
        String r49 = null;
    L93:
        r42.a(r46, r48, r49);
        goto L94
    L92:
        r49 = a(this.d[r47] + 2, r13);
        goto L93
    L89:
        r48 = a(this.d[r47], r13);
    L94:
        int r50 = r23;
        if (r50 == 0) goto L100;
        int r51 = c(r50);
        int r52 = r50 + 2;
    L97:
        int r53 = r51 - 1;
        if (r51 <= 0) goto L100;
        r52 = a(r42.a(a(r52, r13), true), r52 + 2, true, r13);
        r51 = r53;
    L100:
        int r54 = r24;
        if (r54 == 0) goto L106;
        int r55 = c(r54);
        int r56 = r54 + 2;
    L103:
        int r57 = r55 - 1;
        if (r55 <= 0) goto L106;
        r56 = a(r42.a(a(r56, r13), false), r56 + 2, true, r13);
        r55 = r57;
    L106:
        int r58 = r25;
        if (r58 == 0) goto L112;
        int r59 = c(r58);
        int r60 = r58 + 2;
    L109:
        int r61 = r59 - 1;
        if (r59 <= 0) goto L112;
        int r62 = a(r11, r60);
        r60 = a(r42.a(r11.h, r11.i, a(r62, r13), true), r62 + 2, true, r13);
        r59 = r61;
    L112:
        int r63 = r26;
        if (r63 == 0) goto L118;
        int r64 = c(r63);
        int r65 = r63 + 2;
    L115:
        int r66 = r64 - 1;
        if (r64 <= 0) goto L118;
        int r67 = a(r11, r65);
        r65 = a(r42.a(r11.h, r11.i, a(r67, r13), false), r67 + 2, true, r13);
        r64 = r66;
    L118:
        if (r36 == null) goto L120;
        c r68 = r36.f305b;
        r36.f305b = null;
        r42.a(r36);
        r36 = r68;
        goto L118
    L120:
        int r69 = r27;
        if (r69 == 0) goto L126;
        int r70 = c(r69);
        int r71 = r69 + 2;
    L123:
        int r72 = r70 - 1;
        if (r70 <= 0) goto L126;
        r42.b(c(r71, r13));
        r71 = r71 + 2;
        r70 = r72;
    L126:
        int r73 = r29;
        if (r73 == 0) goto L132;
        int r74 = c(r73);
        int r75 = r73 + 2;
    L129:
        int r76 = r74 - 1;
        if (r74 <= 0) goto L132;
        r42.c(c(r75, r13));
        r75 = r75 + 2;
        r74 = r76;
    L132:
        int r77 = r30;
        if (r77 == 0) goto L138;
        int r78 = c(r77);
        int r79 = r77 + 2;
    L135:
        int r80 = r78 - 1;
        if (r78 <= 0) goto L138;
        r42.a(c(r79, r13), c(r79 + 2, r13), a(r79 + 4, r13), c(r79 + 6));
        r79 = r79 + 8;
        r78 = r80;
    L138:
        int r81 = r31;
        if (r81 == 0) goto L144;
        int r82 = c(r81);
        int r83 = r81 + 2;
    L141:
        int r84 = r82 - 1;
        if (r82 <= 0) goto L144;
        r83 = a(r42, r11, r83);
        r82 = r84;
    L144:
        int r85 = c(r40);
        int r86 = r40 + 2;
    L145:
        int r87 = r85 - 1;
        if (r85 <= 0) goto L148;
        r86 = b(r42, r11, r86);
        r85 = r87;
        goto L145
    L148:
        int r88 = c(r86);
        int r89 = r86 + 2;
    L149:
        int r90 = r88 - 1;
        if (r88 <= 0) goto L152;
        r89 = c(r42, r11, r89);
        r88 = r90;
        goto L149
    L152:
        r42.a();
        return;
    L76:
        if (r39 != null) goto L78;
        if (r38 == null) goto L79;
    L78:
        r42.a(r39, r38);
        goto L79
    }

    public int b() {
        return this.d.length;
    }

    public int b(int r1) {
        return this.c[r1] & 255;
    }

    final String b(int r4, char[] r5) {
        String[] r0 = this.e;
        String r1 = r0[r4];
        if (r1 == null) goto L5;
        return r1;
    L5:
        int r2 = this.d[r4];
        String r3 = a(r2 + 2, c(r2), r5);
        r0[r4] = r3;
        return r3;
    }

    public int c() {
        return this.h;
    }

    public int c(int r2) {
        byte[] r1 = this.c;
        int r0 = (r1[r2] & 255) << 8;
        return (r1[r2 + 1] & 255) | r0;
    }

    public String c(int r1, char[] r2) {
        return g(r1, r2);
    }

    public String d(int r1, char[] r2) {
        return g(r1, r2);
    }

    public short d(int r2) {
        byte[] r1 = this.c;
        int r0 = (r1[r2] & 255) << 8;
        return (short) ((r1[r2 + 1] & 255) | r0);
    }

    public int e(int r3) {
        byte[] r2 = this.c;
        int r0 = (((r2[r3] & 255) << 24) | ((r2[r3 + 1] & 255) << 16)) | ((r2[r3 + 2] & 255) << 8);
        return (r2[r3 + 3] & 255) | r0;
    }

    public String e(int r1, char[] r2) {
        return g(r1, r2);
    }

    public long f(int r5) {
        return (((long) e(r5 + 4)) & 4294967295L) | (e(r5) << 32);
    }

    public Object f(int r7, char[] r8) {
        int r0 = this.d[r7];
        byte r1 = this.c[r0 - 1];
        switch(r1) {
            case 3: goto L28;
            case 4: goto L26;
            case 5: goto L24;
            case 6: goto L22;
            case 7: goto L20;
            case 8: goto L18;
            default: goto L4;
        };
    L4:
        switch(r1) {
            case 15: goto L11;
            case 16: goto L10;
            case 17: goto L8;
            default: goto L6;
        };
    L11:
        int r2 = b(r0);
        int r9 = this.d[c(r0 + 1)];
        int r3 = this.d[c(r9 + 2)];
        String r4 = c(r9, r8);
        String r5 = a(r3, r8);
        String r10 = a(r3 + 2, r8);
        if (this.c[r9 - 1] != 11) goto L14;
        boolean r6 = true;
    L16:
        return new o(r2, r4, r5, r10, r6);
    L14:
        r6 = false;
        goto L16
    L6:
        throw new IllegalArgumentException();
    L8:
        return h(r7, r8);
    L10:
        return aa.b(a(r0, r8));
    L18:
        return a(r0, r8);
    L20:
        return aa.a(a(r0, r8));
    L22:
        return Double.valueOf(Double.longBitsToDouble(f(r0)));
    L24:
        return Long.valueOf(f(r0));
    L26:
        return Float.valueOf(Float.intBitsToFloat(e(r0)));
    L28:
        return Integer.valueOf(e(r0));
    }
}
