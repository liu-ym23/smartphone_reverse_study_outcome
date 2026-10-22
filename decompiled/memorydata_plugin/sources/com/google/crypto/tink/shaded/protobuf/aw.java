package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
final class aw<T> implements bl<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f4965a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Unsafe f4966b = null;
    private final int[] c;
    private final Object[] d;
    private final int e;
    private final int f;
    private final at g;
    private final boolean h;
    private final boolean i;
    private final ProtoSyntax j;
    private final boolean k;
    private final int[] l;
    private final int m;
    private final int n;
    private final ay o;
    private final ai p;
    private final bt<?, ?> q;
    private final r<?> r;
    private final ao s;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.aw$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4967a = null;

        static {
            int[] r0 = new int[WireFormat.FieldType.values().length];
            f4967a = r0;
            r0[WireFormat.FieldType.BOOL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L60:
            f4967a[WireFormat.FieldType.BYTES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L44:
            f4967a[WireFormat.FieldType.DOUBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L56:
            f4967a[WireFormat.FieldType.FIXED32.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L62:
            f4967a[WireFormat.FieldType.SFIXED32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L46:
            f4967a[WireFormat.FieldType.FIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L50:
            f4967a[WireFormat.FieldType.SFIXED64.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L70:
            f4967a[WireFormat.FieldType.FLOAT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L28
        L40:
            f4967a[WireFormat.FieldType.ENUM.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L64:
            f4967a[WireFormat.FieldType.INT32.ordinal()] = 10;     // Catch: NoSuchFieldError -> L30
        L66:
            f4967a[WireFormat.FieldType.UINT32.ordinal()] = 11;     // Catch: NoSuchFieldError -> L31
        L52:
            f4967a[WireFormat.FieldType.INT64.ordinal()] = 12;     // Catch: NoSuchFieldError -> L32
        L58:
            f4967a[WireFormat.FieldType.UINT64.ordinal()] = 13;     // Catch: NoSuchFieldError -> L33
        L42:
            f4967a[WireFormat.FieldType.MESSAGE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L34
        L48:
            f4967a[WireFormat.FieldType.SINT32.ordinal()] = 15;     // Catch: NoSuchFieldError -> L35
        L68:
            f4967a[WireFormat.FieldType.SINT64.ordinal()] = 16;     // Catch: NoSuchFieldError -> L36
        L38:
            f4967a[WireFormat.FieldType.STRING.ordinal()] = 17;     // Catch: NoSuchFieldError -> L37
            return;
        }
    }

    static {
        f4965a = new int[0];
        f4966b = bx.c();
    }

    private aw(int[] r8, Object[] r9, int r10, int r11, at r12, ProtoSyntax r13, boolean r14, int[] r15, int r16, int r17, ay r18, ai r19, bt<?, ?> r20, r<?> r21, ao r22) {
        at r2 = (at) ZeusTransformUtils.wrapperContextForParams(r12, at.class, "com.obric.memorydata.plugin");
        ay r4 = (ay) ZeusTransformUtils.wrapperContextForParams(r18, ay.class, "com.obric.memorydata.plugin");
        ao r3 = (ao) ZeusTransformUtils.wrapperContextForParams(r22, ao.class, "com.obric.memorydata.plugin");
        this.c = r8;
        this.d = r9;
        this.e = r10;
        this.f = r11;
        this.i = ZeusTransformUtils.instanceOf(r2, GeneratedMessageLite.class);
        this.j = r13;
        if (r21 != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        this.h = r5;
        this.k = r14;
        this.l = r15;
        this.m = r16;
        this.n = r17;
        this.o = r4;
        this.p = r19;
        this.q = r20;
        this.r = r21;
        this.g = r2;
        this.s = r3;
        return;
    L5:
        if (r21.a(r2) == false) goto L7;
        r5 = true;
        goto L8
    }

    private static <T> double a(T r0, long r1) {
        return bx.e(r0, r1);
    }

    private int a(int r2, int r3) {
        if (r2 >= this.e) goto L5;
        return -1;
    L5:
        if (r2 <= this.f) goto L7;
        return -1;
    L7:
        return b(r2, r3);
    }

    private <UT, UB> int a(bt<UT, UB> r1, T r2) {
        return r1.f(r1.b(r2));
    }

    private int a(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, g.a r29) {
        Unsafe r11 = f4966b;
        long r12 = this.c[r28 + 2] & 1048575;
        switch(r25) {
            case 51: goto L60;
            case 52: goto L56;
            case 53: goto L52;
            case 54: goto L52;
            case 55: goto L49;
            case 56: goto L47;
            case 57: goto L44;
            case 58: goto L38;
            case 59: goto L26;
            case 60: goto L23;
            case 61: goto L21;
            case 62: goto L49;
            case 63: goto L12;
            case 64: goto L44;
            case 65: goto L47;
            case 66: goto L10;
            case 67: goto L8;
            case 68: goto L6;
            default: goto L96;
        };
    L8:
        if (r23 != 0) goto L83;
        int r0 = g.b(r18, r19, r29);
        long r2 = k.a(r29.f5017b);
    L54:
        Object r3 = Long.valueOf(r2);
    L55:
        r11.putObject(r17, r26, r3);
    L63:
        r11.putInt(r17, r12, r22);
        return r0;
    L83:
        return r19;
    L10:
        if (r23 != 0) goto L84;
        r0 = g.a(r18, r19, r29);
        int r4 = k.e(r29.f5016a);
    L51:
        r3 = Integer.valueOf(r4);
        goto L55
    L84:
        return r19;
    L12:
        if (r23 != 0) goto L85;
        int r5 = g.a(r18, r19, r29);
        int r6 = r29.f5016a;
        ab.e r1 = c(r28);
        if (r1 != null) goto L16;
    L19:
        r11.putObject(r17, r26, Integer.valueOf(r6));
        r11.putInt(r17, r12, r22);
    L80:
        return r5;
    L16:
        if (r1.a(r6) == true) goto L19;
        c(r17).a(r21, Long.valueOf(r6));
        goto L80
    L85:
        return r19;
    L21:
        if (r23 != 2) goto L86;
        r0 = g.e(r18, r19, r29);
        r3 = r29.c;
        goto L55
    L86:
        return r19;
    L23:
        if (r23 != 2) goto L87;
        Object r13 = a(r17, r22, r28);
        int r7 = g.a(r13, a(r28), r18, r19, r20, r29);
    L25:
        a(r17, r22, r28, r13);
        return r7;
    L87:
        return r19;
    L26:
        if (r23 != 2) goto L88;
        r0 = g.a(r18, r19, r29);
        int r8 = r29.f5016a;
        if (r8 != 0) goto L31;
        r3 = "";
        goto L55
    L31:
        if ((r24 & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) != 0) goto L33;
    L37:
        r11.putObject(r17, r26, new String(r18, r0, r8, ab.f4938b));
        r0 = r0 + r8;
        goto L63
    L33:
        if (Utf8.a(r18, r0, r0 + r8) == true) goto L37;
        throw InvalidProtocolBufferException.invalidUtf8();
    L88:
        return r19;
    L38:
        if (r23 != 0) goto L89;
        r0 = g.b(r18, r19, r29);
        if (r29.f5017b == 0) goto L42;
        boolean r15 = true;
    L43:
        r3 = Boolean.valueOf(r15);
        goto L55
    L42:
        r15 = false;
        goto L43
    L89:
        return r19;
    L44:
        if (r23 != 5) goto L90;
        Object r9 = Integer.valueOf(g.a(r18, r19));
    L58:
        r11.putObject(r17, r26, r9);
        r0 = r19 + 4;
        goto L63
    L90:
        return r19;
    L49:
        if (r23 != 0) goto L92;
        r0 = g.a(r18, r19, r29);
        r4 = r29.f5016a;
        goto L51
    L92:
        return r19;
    L52:
        if (r23 != 0) goto L93;
        r0 = g.b(r18, r19, r29);
        r2 = r29.f5017b;
        goto L54
    L93:
        return r19;
    L56:
        if (r23 != 5) goto L94;
        r9 = Float.valueOf(g.d(r18, r19));
        goto L58
    L94:
        return r19;
    L6:
        if (r23 != 3) goto L65;
        r13 = a(r17, r22, r28);
        r7 = g.a(r13, a(r28), r18, r19, r20, (r21 & (-8)) | 4, r29);
        goto L25
    L65:
        return r19;
    L47:
        if (r23 != 1) goto L91;
        Object r10 = Long.valueOf(g.b(r18, r19));
    L62:
        r11.putObject(r17, r26, r10);
        r0 = r19 + 8;
        goto L63
    L91:
        return r19;
    L60:
        if (r23 != 1) goto L95;
        r10 = Double.valueOf(g.c(r18, r19));
        goto L62
    L95:
        return r19;
    L96:
        return r19;
    }

    private int a(T r14, byte[] r15, int r16, int r17, int r18, int r19, int r20, int r21, long r22, int r24, long r25, g.a r27) {
        Unsafe r9 = f4966b;
        ab.i r10 = (ab.i) ZeusTransformUtils.preCheckCast(r9.getObject(r14, r25), ab.i.class, "com.obric.memorydata.plugin");
        if (r10.a() == true) goto L10;
        int r11 = r10.size();
        if (r11 != 0) goto L7;
        int r12 = 10;
    L8:
        r10 = r10.e(r12);
        r9.putObject(r14, r25, r10);
        goto L10
    L7:
        r12 = r11 * 2;
    L10:
        switch(r24) {
            case 18: goto L61;
            case 19: goto L57;
            case 20: goto L53;
            case 21: goto L53;
            case 22: goto L49;
            case 23: goto L45;
            case 24: goto L41;
            case 25: goto L37;
            case 26: goto L32;
            case 27: goto L30;
            case 28: goto L28;
            case 29: goto L49;
            case 30: goto L23;
            case 31: goto L41;
            case 32: goto L45;
            case 33: goto L19;
            case 34: goto L15;
            case 35: goto L61;
            case 36: goto L57;
            case 37: goto L53;
            case 38: goto L53;
            case 39: goto L49;
            case 40: goto L45;
            case 41: goto L41;
            case 42: goto L37;
            case 43: goto L49;
            case 44: goto L23;
            case 45: goto L41;
            case 46: goto L45;
            case 47: goto L19;
            case 48: goto L15;
            case 49: goto L13;
            default: goto L118;
        };
    L15:
        if (r20 == 2) goto L82;
        if (r20 != 0) goto L105;
        return g.i(r18, r15, r16, r17, r10, r27);
    L105:
        return r16;
    L82:
        return g.i(r15, r16, r10, r27);
    L19:
        if (r20 == 2) goto L84;
        if (r20 != 0) goto L106;
        return g.h(r18, r15, r16, r17, r10, r27);
    L106:
        return r16;
    L84:
        return g.h(r15, r16, r10, r27);
    L23:
        if (r20 != 2) goto L25;
        int r2 = g.a(r15, r16, r10, r27);
    L27:
        ab.i r110 = r10;
        bn.a(r14, r19, r110, c(r21), null, this.q);
        return r2;
    L25:
        if (r20 != 0) goto L107;
        r2 = g.a(r18, r15, r16, r17, r10, r27);
        goto L27
    L107:
        return r16;
    L28:
        if (r20 != 2) goto L108;
        return g.l(r18, r15, r16, r17, r10, r27);
    L108:
        return r16;
    L30:
        if (r20 != 2) goto L109;
        return g.a(a(r21), r18, r15, r16, r17, r10, r27);
    L109:
        return r16;
    L32:
        if (r20 != 2) goto L110;
        long r0 = r22 & 536870912;
        ab.i r23 = r10;
        if (r0 != 0) goto L90;
        return g.j(r18, r15, r16, r17, r23, r27);
    L90:
        return g.k(r18, r15, r16, r17, r23, r27);
    L110:
        return r16;
    L37:
        if (r20 == 2) goto L91;
        if (r20 != 0) goto L111;
        return g.g(r18, r15, r16, r17, r10, r27);
    L111:
        return r16;
    L91:
        return g.g(r15, r16, r10, r27);
    L41:
        if (r20 == 2) goto L93;
        if (r20 != 5) goto L112;
        return g.c(r18, r15, r16, r17, r10, r27);
    L112:
        return r16;
    L93:
        return g.c(r15, r16, r10, r27);
    L45:
        if (r20 == 2) goto L95;
        if (r20 != 1) goto L113;
        return g.d(r18, r15, r16, r17, r10, r27);
    L113:
        return r16;
    L95:
        return g.d(r15, r16, r10, r27);
    L49:
        if (r20 == 2) goto L97;
        if (r20 != 0) goto L114;
        return g.a(r18, r15, r16, r17, r10, r27);
    L114:
        return r16;
    L97:
        return g.a(r15, r16, r10, r27);
    L53:
        if (r20 == 2) goto L99;
        if (r20 != 0) goto L115;
        return g.b(r18, r15, r16, r17, r10, r27);
    L115:
        return r16;
    L99:
        return g.b(r15, r16, r10, r27);
    L57:
        if (r20 == 2) goto L101;
        if (r20 != 5) goto L116;
        return g.e(r18, r15, r16, r17, r10, r27);
    L116:
        return r16;
    L101:
        return g.e(r15, r16, r10, r27);
    L61:
        if (r20 == 2) goto L103;
        if (r20 != 1) goto L117;
        return g.f(r18, r15, r16, r17, r10, r27);
    L117:
        return r16;
    L103:
        return g.f(r15, r16, r10, r27);
    L13:
        if (r20 != 3) goto L66;
        return g.b(a(r21), r18, r15, r16, r17, r10, r27);
    L66:
        return r16;
    L118:
        return r16;
    }

    private <K, V> int a(T r10, byte[] r11, int r12, int r13, int r14, long r15, g.a r17) {
        Unsafe r4 = f4966b;
        Object r5 = b(r14);
        Object r6 = r4.getObject(r10, r15);
        if (this.s.c(r6) == false) goto L6;
        Object r7 = this.s.e(r5);
        this.s.a(r7, r6);
        r4.putObject(r10, r15, r7);
        r6 = r7;
    L6:
        return a(r11, r12, r13, this.s.f(r5), this.s.a(r6), r17);
    }

    private int a(byte[] r1, int r2, int r3, WireFormat.FieldType r4, Class<?> r5, g.a r6) {
        switch(AnonymousClass1.f4967a[r4.ordinal()]) {
            case 1: goto L22;
            case 2: goto L32;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L12;
            case 10: goto L12;
            case 11: goto L12;
            case 12: goto L10;
            case 13: goto L10;
            case 14: goto L28;
            case 15: goto L8;
            case 16: goto L7;
            case 17: goto L27;
            default: goto L5;
        };
    L7:
        int r0 = g.b(r1, r2, r6);
        long r7 = k.a(r6.f5017b);
    L11:
        Object r8 = Long.valueOf(r7);
    L14:
        r6.c = r8;
        return r0;
    L8:
        r0 = g.a(r1, r2, r6);
        int r9 = k.e(r6.f5016a);
    L13:
        r8 = Integer.valueOf(r9);
        goto L14
    L10:
        r0 = g.b(r1, r2, r6);
        r7 = r6.f5017b;
        goto L11
    L12:
        r0 = g.a(r1, r2, r6);
        r9 = r6.f5016a;
        goto L13
    L15:
        Object r10 = Float.valueOf(g.d(r1, r2));
    L18:
        r6.c = r10;
        return r2 + 4;
    L16:
        Object r11 = Long.valueOf(g.b(r1, r2));
    L20:
        r6.c = r11;
        return r2 + 8;
    L17:
        r10 = Integer.valueOf(g.a(r1, r2));
        goto L18
    L19:
        r11 = Double.valueOf(g.c(r1, r2));
        goto L20
    L22:
        r0 = g.b(r1, r2, r6);
        if (r6.f5017b == 0) goto L25;
        boolean r12 = true;
    L26:
        r8 = Boolean.valueOf(r12);
        goto L14
    L25:
        r12 = false;
        goto L26
    L5:
        throw new RuntimeException("unsupported field type.");
    L27:
        return g.d(r1, r2, r6);
    L28:
        return g.a(bg.a().a(r5), r1, r2, r3, r6);
    L32:
        return g.e(r1, r2, r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> int a(byte[] r16, int r17, int r18, an.a<K, V> r19, Map<K, V> r20, g.a r21) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.memorydata.plugin");
        int r0 = g.a(r16, r17, r21);
        int r1 = r21.f5016a;
        if (r1 < 0) goto L30;
        if (r1 > (r18 - r0)) goto L30;
        int r12 = r0 + r1;
        K r2 = r19.f4961b;
        Object r13 = r2;
        Object r14 = r19.d;
    L7:
        if (r0 >= r12) goto L24;
        int r3 = r0 + 1;
        int r4 = r16[r0];
        if (r4 >= 0) goto L11;
        int r5 = g.a(r4, r16, r3, r21);
        int r6 = r5;
        r4 = r21.f5016a;
    L12:
        int r7 = r4 >>> 3;
        int r8 = r4 & 7;
        if (r7 != 1) goto L15;
        if (r8 != r19.f4960a.getWireType()) goto L23;
        r0 = a(r16, r6, r18, r19.f4960a, null, r21);
        r13 = r21.c;
    L23:
        r0 = g.a(r4, r16, r6, r18, r21);
        goto L7
    L15:
        if (r7 != 2) goto L23;
        if (r8 != r19.c.getWireType()) goto L23;
        r0 = a(r16, r6, r18, r19.c, r19.d.getClass(), r21);
        r14 = r21.c;
        goto L7
    L11:
        r6 = r3;
        goto L12
    L24:
        if (r0 != r12) goto L28;
        r11.put(r13, r14);
        return r12;
    L28:
        throw InvalidProtocolBufferException.parseFailure();
    L30:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static <T> aw<T> a(bj r33, ay r34, ai r35, bt<?, ?> r36, r<?> r37, ao r38) {
        String r1 = "com.obric.memorydata.plugin";
        ay r13 = (ay) ZeusTransformUtils.wrapperContextForParams(r34, ay.class, "com.obric.memorydata.plugin");
        ao r17 = (ao) ZeusTransformUtils.wrapperContextForParams(r38, ao.class, "com.obric.memorydata.plugin");
        String r0 = r33.d();
        int r2 = r0.length();
        int r3 = 0;
        if (r0.charAt(0) < 55296) goto L8;
        int r4 = 1;
    L5:
        int r7 = r4 + 1;
        if (r0.charAt(r4) < 55296) goto L9;
        r4 = r7;
    L9:
        int r5 = r7 + 1;
        int r8 = r0.charAt(r7);
        if (r8 < 55296) goto L16;
        int r9 = r8 & 8191;
        int r10 = 13;
    L12:
        int r11 = r5 + 1;
        char r6 = r0.charAt(r5);
        if (r6 < 55296) goto L15;
        r9 = r9 | ((r6 & 8191) << r10);
        r10 = r10 + 13;
        r5 = r11;
        goto L12
    L15:
        r8 = r9 | (r6 << r10);
        r5 = r11;
    L16:
        if (r8 != 0) goto L18;
        int r12 = 0;
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
        int r18 = 0;
        int[] r19 = f4965a;
        int r20 = 0;
    L75:
        Unsafe r21 = f4966b;
        Object[] r110 = r33.e();
        Class<?> r22 = r33.c().getClass();
        int[] r23 = new int[r20 * 3];
        Object[] r24 = new Object[r20 * 2];
        int r111 = r15 + r18;
        int r25 = r111;
        int r26 = r18;
        int r27 = 0;
        int r28 = 0;
    L76:
        if (r5 >= r2) goto L203;
        int r29 = r5 + 1;
        int r30 = r0.charAt(r5);
        int r210 = r2;
        if (r30 < 55296) goto L84;
        int r31 = r30 & 8191;
        int r32 = r29;
        int r211 = 13;
    L80:
        int r212 = r32 + 1;
        char r39 = r0.charAt(r32);
        ay r213 = r13;
        if (r39 < 55296) goto L83;
        r31 = r31 | ((r39 & 8191) << r211);
        r211 = r211 + 13;
        r32 = r212;
        r13 = r213;
        goto L80
    L83:
        r30 = r31 | (r39 << r211);
        int r40 = r212;
    L85:
        int r112 = r40 + 1;
        int r41 = r0.charAt(r40);
        if (r41 < 55296) goto L92;
        int r42 = r41 & 8191;
        int r113 = r112;
        int r214 = 13;
    L88:
        int r215 = r113 + 1;
        char r114 = r0.charAt(r113);
        int r216 = r111;
        if (r114 < 55296) goto L91;
        r42 = r42 | ((r114 & 8191) << r214);
        r214 = r214 + 13;
        r113 = r215;
        r111 = r216;
        goto L88
    L91:
        r41 = r42 | (r114 << r214);
        int r115 = r215;
    L93:
        int r116 = r41 & 255;
        int r217 = r18;
        if ((r41 & 1024) == 0) goto L96;
        r19[r27] = r28;
        r27 = r27 + 1;
    L96:
        int r310 = r14;
        if (r116 < 51) goto L128;
        int r117 = r115 + 1;
        int r118 = r0.charAt(r115);
        char r119 = 55296;
        if (r118 < 55296) goto L105;
        int r120 = r118 & 8191;
        int r311 = 13;
    L101:
        int r312 = r117 + 1;
        char r121 = r0.charAt(r117);
        if (r121 < r119) goto L104;
        r120 = r120 | ((r121 & 8191) << r311);
        r311 = r311 + 13;
        r117 = r312;
        r119 = 55296;
        goto L101
    L104:
        r118 = r120 | (r121 << r311);
        r117 = r312;
    L105:
        int r122 = r116 - 51;
        int r313 = r117;
        if (r122 != 9) goto L108;
    L117:
        int r123 = r16 + 1;
        r24[((r28 / 3) * 2) + 1] = r110[r16];
    L118:
        r16 = r123;
    L119:
        int r124 = r118 * 2;
        Object r125 = r110[r124];
        if (ZeusTransformUtils.instanceOf(r125, java.lang.reflect.Field.class) == false) goto L122;
        java.lang.reflect.Field r126 = (java.lang.reflect.Field) ZeusTransformUtils.preCheckCast(r125, java.lang.reflect.Field.class, r1);
    L123:
        int r218 = r16;
        int r127 = (int) r21.objectFieldOffset(r126);
        int r128 = r124 + 1;
        Object r129 = r110[r128];
        if (ZeusTransformUtils.instanceOf(r129, java.lang.reflect.Field.class) == false) goto L126;
        java.lang.reflect.Field r130 = (java.lang.reflect.Field) ZeusTransformUtils.preCheckCast(r129, java.lang.reflect.Field.class, r1);
    L127:
        r16 = r218;
        int r219 = r313;
        int r220 = r12;
        int r43 = (int) r21.objectFieldOffset(r130);
        int r131 = 0;
    L189:
        int r132 = r28 + 1;
        r23[r28] = r30;
        int r44 = r132 + 1;
        String r133 = r0;
        if ((r41 & 512) == 0) goto L192;
        int r45 = SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING;
    L193:
        String r221 = r1;
        if ((r41 & 256) == 0) goto L196;
        int r46 = SQLiteDatabase.CREATE_IF_NECESSARY;
    L197:
        int r47 = r45 | r46;
        if ((r41 & 2048) == 0) goto L200;
        int r48 = Integer.MIN_VALUE;
    L201:
        r23[r132] = ((r47 | r48) | (r116 << 20)) | r127;
        int r49 = r44 + 1;
        r23[r44] = (r131 << 20) | r43;
        r1 = r221;
        r18 = r217;
        r2 = r210;
        r12 = r220;
        r13 = r213;
        r111 = r216;
        r5 = r219;
        r14 = r310;
        r28 = r49;
        r0 = r133;
        goto L76
    L200:
        r48 = 0;
        goto L201
    L196:
        r46 = 0;
        goto L197
    L192:
        r45 = 0;
        goto L193
    L126:
        java.lang.reflect.Field r134 = a(r22, (String) ZeusTransformUtils.preCheckCast(r129, String.class, r1));
        r110[r128] = r134;
        r130 = r134;
        goto L127
    L122:
        r126 = a(r22, (String) ZeusTransformUtils.preCheckCast(r125, String.class, r1));
        r110[r124] = r126;
        goto L123
    L108:
        if (r122 == 17) goto L117;
        if (r122 != 12) goto L119;
        if (r33.a().equals(ProtoSyntax.PROTO2) == false) goto L115;
    L116:
        r123 = r16 + 1;
        r24[((r28 / 3) * 2) + 1] = r110[r16];
        goto L118
    L115:
        if ((r41 & 2048) == 0) goto L119;
    L128:
        int r135 = r16 + 1;
        java.lang.reflect.Field r136 = a(r22, (String) ZeusTransformUtils.preCheckCast(r110[r16], String.class, r1));
        if (r116 != 9) goto L131;
    L160:
        r220 = r12;
        boolean r137 = true;
        r24[((r28 / 3) * 2) + 1] = r136.getType();
    L161:
        int r138 = r135;
    L162:
        r127 = (int) r21.objectFieldOffset(r136);
        if ((r41 & 4096) == 0) goto L165;
        boolean r50 = r137;
    L166:
        if (r50 == true) goto L168;
    L182:
        r43 = 1048575;
        r219 = r115;
        r131 = 0;
    L184:
        if (r116 >= 18) goto L186;
    L188:
        r16 = r138;
        goto L189
    L186:
        if (r116 > 49) goto L188;
        r19[r25] = r127;
        r25 = r25 + 1;
        goto L188
    L168:
        if (r116 > 17) goto L182;
        int r51 = r115 + 1;
        int r139 = r0.charAt(r115);
        if (r139 < 55296) goto L176;
        int r140 = r139 & 8191;
        int r141 = 13;
    L172:
        r219 = r51 + 1;
        char r52 = r0.charAt(r51);
        if (r52 < 55296) goto L175;
        r140 = r140 | ((r52 & 8191) << r141);
        r141 = r141 + 13;
        r51 = r219;
        goto L172
    L175:
        r139 = r140 | (r52 << r141);
    L177:
        int r53 = (r3 * 2) + (r139 / 32);
        Object r142 = r110[r53];
        if (ZeusTransformUtils.instanceOf(r142, java.lang.reflect.Field.class) == false) goto L180;
        java.lang.reflect.Field r54 = (java.lang.reflect.Field) ZeusTransformUtils.preCheckCast(r142, java.lang.reflect.Field.class, r1);
    L181:
        r43 = (int) r21.objectFieldOffset(r54);
        r131 = r139 % 32;
        goto L184
    L180:
        java.lang.reflect.Field r143 = a(r22, (String) ZeusTransformUtils.preCheckCast(r142, String.class, r1));
        r110[r53] = r143;
        r54 = r143;
        goto L181
    L176:
        r219 = r51;
        goto L177
    L165:
        r50 = false;
        goto L166
    L131:
        if (r116 == 17) goto L160;
        if (r116 != 27) goto L136;
    L159:
        r220 = r12;
        r137 = true;
        r138 = r135 + 1;
        r24[((r28 / 3) * 2) + 1] = r110[r135];
        goto L162
    L136:
        if (r116 == 49) goto L159;
        if (r116 != 12) goto L141;
    L152:
        r220 = r12;
        if (r33.a() != ProtoSyntax.PROTO2) goto L155;
    L158:
        r137 = true;
        r138 = r135 + 1;
        r24[((r28 / 3) * 2) + 1] = r110[r135];
        goto L162
    L155:
        if ((r41 & 2048) != 0) goto L158;
    L157:
        r137 = true;
        goto L161
    L141:
        if (r116 == 30) goto L152;
        if (r116 == 44) goto L152;
        if (r116 != 50) goto L151;
        int r144 = r26 + 1;
        r19[r26] = r28;
        int r222 = (r28 / 3) * 2;
        int r223 = r135 + 1;
        r24[r222] = r110[r135];
        if ((r41 & 2048) == 0) goto L150;
        int r145 = r223 + 1;
        r24[r222 + 1] = r110[r223];
        r220 = r12;
        r138 = r145;
        r26 = r144;
        r137 = true;
        goto L162
    L150:
        r26 = r144;
        r138 = r223;
        r137 = true;
        r220 = r12;
        goto L162
    L151:
        r220 = r12;
        goto L157
    L92:
        r216 = r111;
        r115 = r112;
        goto L93
    L84:
        r213 = r13;
        r40 = r29;
        goto L85
    L203:
        return new aw(r23, r24, r12, r14, r33.c(), r33.a(), false, r19, r18, r111, r13, r35, r36, r37, r17);
    L18:
        int r55 = r5 + 1;
        int r56 = r0.charAt(r5);
        if (r56 < 55296) goto L25;
        int r57 = r56 & 8191;
        int r58 = 13;
    L21:
        int r146 = r55 + 1;
        char r59 = r0.charAt(r55);
        if (r59 < 55296) goto L24;
        r57 = r57 | ((r59 & 8191) << r58);
        r58 = r58 + 13;
        r55 = r146;
        goto L21
    L24:
        r56 = r57 | (r59 << r58);
        r55 = r146;
    L25:
        int r60 = r55 + 1;
        int r61 = r0.charAt(r55);
        if (r61 < 55296) goto L32;
        int r62 = r61 & 8191;
        int r147 = 13;
    L28:
        int r148 = r60 + 1;
        char r63 = r0.charAt(r60);
        if (r63 < 55296) goto L31;
        r62 = r62 | ((r63 & 8191) << r147);
        r147 = r147 + 13;
        r60 = r148;
        goto L28
    L31:
        r61 = r62 | (r63 << r147);
        r60 = r148;
    L32:
        int r149 = r60 + 1;
        r12 = r0.charAt(r60);
        if (r12 < 55296) goto L39;
        int r64 = r12 & 8191;
        int r150 = 13;
    L35:
        int r151 = r149 + 1;
        char r152 = r0.charAt(r149);
        if (r152 < 55296) goto L38;
        r64 = r64 | ((r152 & 8191) << r150);
        r150 = r150 + 13;
        r149 = r151;
        goto L35
    L38:
        r12 = r64 | (r152 << r150);
        r149 = r151;
    L39:
        int r153 = r149 + 1;
        r14 = r0.charAt(r149);
        if (r14 < 55296) goto L46;
        int r154 = r14 & 8191;
        int r155 = 13;
    L42:
        int r156 = r153 + 1;
        char r157 = r0.charAt(r153);
        if (r157 < 55296) goto L45;
        r154 = r154 | ((r157 & 8191) << r155);
        r155 = r155 + 13;
        r153 = r156;
        goto L42
    L45:
        r14 = r154 | (r157 << r155);
        r153 = r156;
    L46:
        int r158 = r153 + 1;
        int r159 = r0.charAt(r153);
        if (r159 < 55296) goto L53;
        int r160 = r159 & 8191;
        int r161 = 13;
    L49:
        int r162 = r158 + 1;
        char r163 = r0.charAt(r158);
        if (r163 < 55296) goto L52;
        r160 = r160 | ((r163 & 8191) << r161);
        r161 = r161 + 13;
        r158 = r162;
        goto L49
    L52:
        r159 = r160 | (r163 << r161);
        r158 = r162;
    L53:
        int r164 = r158 + 1;
        r15 = r0.charAt(r158);
        if (r15 < 55296) goto L60;
        int r165 = r15 & 8191;
        int r166 = 13;
    L56:
        int r167 = r164 + 1;
        char r168 = r0.charAt(r164);
        if (r168 < 55296) goto L59;
        r165 = r165 | ((r168 & 8191) << r166);
        r166 = r166 + 13;
        r164 = r167;
        goto L56
    L59:
        r15 = r165 | (r168 << r166);
        r164 = r167;
    L60:
        int r169 = r164 + 1;
        int r170 = r0.charAt(r164);
        if (r170 < 55296) goto L67;
        int r171 = r170 & 8191;
        int r172 = 13;
    L63:
        int r173 = r169 + 1;
        char r174 = r0.charAt(r169);
        if (r174 < 55296) goto L66;
        r171 = r171 | ((r174 & 8191) << r172);
        r172 = r172 + 13;
        r169 = r173;
        goto L63
    L66:
        r170 = r171 | (r174 << r172);
        r169 = r173;
    L67:
        int r175 = r169 + 1;
        r18 = r0.charAt(r169);
        if (r18 < 55296) goto L74;
        int r176 = r18 & 8191;
        int r65 = r175;
        int r177 = 13;
    L70:
        int r178 = r65 + 1;
        char r66 = r0.charAt(r65);
        if (r66 < 55296) goto L73;
        r176 = r176 | ((r66 & 8191) << r177);
        r177 = r177 + 13;
        r65 = r178;
        goto L70
    L73:
        r18 = r176 | (r66 << r177);
        r175 = r178;
    L74:
        int[] r67 = new int[(r18 + r15) + r170];
        r16 = (r56 * 2) + r61;
        r20 = r159;
        r19 = r67;
        r3 = r56;
        r5 = r175;
        goto L75
    L8:
        r7 = 1;
        goto L9
    }

    static <T> aw<T> a(br r18, ay r19, ai r20, bt<?, ?> r21, r<?> r22, ao r23) {
        ay r13 = (ay) ZeusTransformUtils.wrapperContextForParams(r19, ay.class, "com.obric.memorydata.plugin");
        ao r17 = (ao) ZeusTransformUtils.wrapperContextForParams(r23, ao.class, "com.obric.memorydata.plugin");
        u[] r0 = r18.e();
        if (r0.length != 0) goto L5;
        int r5 = 0;
        int r6 = 0;
    L6:
        int r1 = r0.length;
        int[] r3 = new int[r1 * 3];
        Object[] r4 = new Object[r1 * 2];
        int r2 = r0.length;
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
    L8:
        if (r7 >= r2) goto L18;
        u r12 = r0[r7];
        if (r12.getType() != FieldType.MAP) goto L13;
        r8 = r8 + 1;
    L17:
        r7 = r7 + 1;
        goto L8
    L13:
        if (r12.getType().id() < 18) goto L17;
        if (r12.getType().id() > 49) goto L17;
        r9 = r9 + 1;
        goto L17
    L18:
        int[] r10 = null;
        if (r8 <= 0) goto L21;
        int[] r11 = new int[r8];
    L22:
        if (r9 <= 0) goto L24;
        r10 = new int[r9];
    L24:
        int[] r14 = r18.d();
        if (r14 != null) goto L27;
        r14 = f4965a;
    L27:
        int r15 = 0;
        int r16 = 0;
        int r110 = 0;
        int r111 = 0;
        int r112 = 0;
    L29:
        if (r15 >= r0.length) goto L45;
        u r24 = r0[r15];
        int r113 = r24.a();
        a(r24, r3, r16, r4);
        if (r110 >= r14.length) goto L36;
        if (r14[r110] != r113) goto L36;
        r14[r110] = r16;
        r110 = r110 + 1;
    L36:
        if (r24.getType() != FieldType.MAP) goto L40;
        r11[r111] = r16;
        r111 = r111 + 1;
    L44:
        r15 = r15 + 1;
        r16 = r16 + 3;
        goto L29
    L40:
        if (r24.getType().id() < 18) goto L44;
        if (r24.getType().id() > 49) goto L44;
        r10[r112] = (int) bx.a(r24.b());
        r112 = r112 + 1;
        goto L44
    L45:
        if (r11 != null) goto L47;
        r11 = f4965a;
    L47:
        if (r10 != null) goto L49;
        r10 = f4965a;
    L49:
        int[] r114 = new int[(r14.length + r11.length) + r10.length];
        System.arraycopy(r14, 0, r114, 0, r14.length);
        System.arraycopy(r11, 0, r114, r14.length, r11.length);
        System.arraycopy(r10, 0, r114, r14.length + r11.length, r10.length);
        return new aw(r3, r4, r5, r6, r18.c(), r18.a(), true, r114, r14.length, r14.length + r11.length, r13, r20, r21, r22, r17);
    L21:
        r11 = null;
        goto L22
    L5:
        r5 = r0[0].a();
        r6 = r0[r0.length - 1].a();
        goto L6
    }

    static <T> aw<T> a(Class<T> r7, ar r8, ay r9, ai r10, bt<?, ?> r11, r<?> r12, ao r13) {
        ar r14 = (ar) ZeusTransformUtils.wrapperContextForParams(r8, ar.class, "com.obric.memorydata.plugin");
        ay r2 = (ay) ZeusTransformUtils.wrapperContextForParams(r9, ay.class, "com.obric.memorydata.plugin");
        ao r6 = (ao) ZeusTransformUtils.wrapperContextForParams(r13, ao.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, bj.class) == false) goto L7;
        return a((bj) ZeusTransformUtils.preCheckCast(r14, bj.class, "com.obric.memorydata.plugin"), r2, r10, r11, r12, r6);
    L7:
        return a((br) ZeusTransformUtils.preCheckCast(r14, br.class, "com.obric.memorydata.plugin"), r2, r10, r11, r12, r6);
    }

    private bl a(int r5) {
        int r6 = (r5 / 3) * 2;
        bl r0 = (bl) ZeusTransformUtils.preCheckCast(this.d[r6], bl.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        bl<T> r1 = bg.a().a((Class) ZeusTransformUtils.preCheckCast(this.d[r6 + 1], Class.class, "com.obric.memorydata.plugin"));
        this.d[r6] = r1;
        return r1;
    }

    private <K, V, UT, UB> UB a(int r5, int r6, Map<K, V> r7, ab.e r8, UB r9, bt<UT, UB> r10, Object r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        ab.e r13 = (ab.e) ZeusTransformUtils.wrapperContextForParams(r8, ab.e.class, "com.obric.memorydata.plugin");
        an.a<?, ?> r4 = this.s.f(b(r5));
        Iterator<Map.Entry<K, V>> r14 = r12.entrySet().iterator();
    L4:
        if (r14.hasNext() == false) goto L15;
        Map.Entry r15 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r13.a(((Integer) ZeusTransformUtils.preCheckCast(r15.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue()) == true) goto L4;
        if (r9 != null) goto L9;
        r9 = r10.c(r11);
    L9:
        ByteString.e r0 = ByteString.newCodedBuilder(an.a(r4, r15.getKey(), r15.getValue()));
        CodedOutputStream r2 = r0.b();
        an.a(r2, r4, r15.getKey(), r15.getValue());     // Catch: IOException -> L12
        UB r16 = r9;
        r10.a(r16, r6, r0.a());
        r14.remove();
    L12:
        e = move-exception;
        throw new RuntimeException(e);
    L15:
        return r9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object a(T r4, int r5) {
        bl r0 = a(r5);
        long r1 = k(e(r5));
        if (b(r4, r5) == false) goto L5;
        Object r3 = f4966b.getObject(r4, r1);
        if (f(r3) == false) goto L9;
        return r3;
    L9:
        Object r6 = r0.a();
        if (r3 == null) goto L12;
        r0.b(r6, r3);
    L12:
        return r6;
    L5:
        return r0.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object a(T r4, int r5, int r6) {
        bl r0 = a(r6);
        if (d(r4, r5, r6) == false) goto L5;
        Object r3 = f4966b.getObject(r4, k(e(r6)));
        if (f(r3) == false) goto L9;
        return r3;
    L9:
        Object r7 = r0.a();
        if (r3 == null) goto L12;
        r0.b(r7, r3);
    L12:
        return r7;
    L5:
        return r0.a();
    }

    private <UT, UB> UB a(Object r9, int r10, UB r11, bt<UT, UB> r12, Object r13) {
        int r2 = d(r10);
        Object r14 = bx.f(r9, k(e(r10)));
        if (r14 != null) goto L5;
        return r11;
    L5:
        ab.e r4 = c(r10);
        if (r4 != null) goto L9;
        return r11;
    L9:
        return (UB) a(r10, r2, this.s.a(r14), r4, r11, r12, r13);
    }

    private static java.lang.reflect.Field a(Class<?> r5, String r6) {
        return r5.getDeclaredField(r6);
    L4:
        java.lang.reflect.Field[] r0 = r5.getDeclaredFields();
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L11;
        java.lang.reflect.Field r3 = r0[r2];
        if (r6.equals(r3.getName()) == true) goto L8;
        r2 = r2 + 1;
        goto L5
    L8:
        return r3;
    L11:
        throw new RuntimeException("Field " + r6 + " for " + r5.getName() + " not found. Known fields are " + Arrays.toString(r0));
    }

    private void a(int r2, Object r3, Writer r4) {
        Writer r1 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L5;
        r1.a(r2, (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r1.a(r2, (ByteString) ZeusTransformUtils.preCheckCast(r3, ByteString.class, "com.obric.memorydata.plugin"));
    }

    private <K, V> void a(Writer r3, int r4, Object r5, int r6) {
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r3, Writer.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L6;
        r7.a(r4, this.s.f(b(r6)), this.s.b(r5));
        return;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 18121. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private <UT, UB, ET extends com.google.crypto.tink.shaded.protobuf.w.a<ET>> void a(com.google.crypto.tink.shaded.protobuf.bt<UT, UB> r19, com.google.crypto.tink.shaded.protobuf.r<ET> r20, T r21, com.google.crypto.tink.shaded.protobuf.bk r22, com.google.crypto.tink.shaded.protobuf.q r23) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0002: MOVE (r7v0 ?? I:??[OBJECT, ARRAY]) = (r19v0 com.google.crypto.tink.shaded.protobuf.bt<UT, UB>) A[DECLARE_VAR] in method: com.google.crypto.tink.shaded.protobuf.aw.a(com.google.crypto.tink.shaded.protobuf.bt<UT, UB>, com.google.crypto.tink.shaded.protobuf.r<ET extends com.google.crypto.tink.shaded.protobuf.w$a<ET>>, T, com.google.crypto.tink.shaded.protobuf.bk, com.google.crypto.tink.shaded.protobuf.q):void, file: classes2.dex
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
            Method dump skipped, instruction units count: 1812
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.aw.a(com.google.crypto.tink.shaded.protobuf.bt, com.google.crypto.tink.shaded.protobuf.r, java.lang.Object, com.google.crypto.tink.shaded.protobuf.bk, com.google.crypto.tink.shaded.protobuf.q):void");
    }

    private <UT, UB> void a(bt<UT, UB> r2, T r3, Writer r4) {
        Writer r1 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        r2.a(r2.b(r3), r1);
    }

    private static void a(u r8, int[] r9, int r10, Object[] r11) {
        bb r0 = r8.c();
        int r1 = 0;
        if (r0 == null) goto L6;
        int r2 = r8.getType().id() + 51;
        int r3 = (int) bx.a(r0.b());
        java.lang.reflect.Field r4 = r0.a();
    L5:
        int r5 = (int) bx.a(r4);
        int r6 = 0;
    L19:
        r9[r10] = r8.a();
        int r7 = r10 + 1;
        if (r8.i() == false) goto L22;
        int r12 = SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING;
    L24:
        if (r8.h() == false) goto L26;
        r1 = SQLiteDatabase.CREATE_IF_NECESSARY;
    L26:
        r9[r7] = ((r1 | r12) | (r2 << 20)) | r3;
        r9[r10 + 2] = r5 | (r6 << 20);
        Class<?> r13 = r8.k();
        if (r8.f() == null) goto L34;
        int r14 = (r10 / 3) * 2;
        r11[r14] = r8.f();
        if (r13 == null) goto L32;
        r11[r14 + 1] = r13;
        return;
    L32:
        if (r8.d() == null) goto L41;
        r11[r14 + 1] = r8.d();
        return;
    L41:
        return;
    L34:
        if (r13 == null) goto L37;
        r11[((r10 / 3) * 2) + 1] = r13;
        return;
    L37:
        if (r8.d() == null) goto L44;
        r11[((r10 / 3) * 2) + 1] = r8.d();
        return;
    L44:
        return;
    L22:
        r12 = 0;
        goto L24
    L6:
        FieldType r15 = r8.getType();
        r3 = (int) bx.a(r8.b());
        r2 = r15.id();
        if (r15.isList() == true) goto L16;
        if (r15.isMap() == true) goto L16;
        java.lang.reflect.Field r16 = r8.e();
        if (r16 != null) goto L13;
        r5 = 1048575;
    L14:
        r6 = Integer.numberOfTrailingZeros(r8.g());
        goto L19
    L13:
        r5 = (int) bx.a(r16);
    L16:
        if (r8.j() != null) goto L18;
        r5 = 0;
        r6 = 0;
        goto L19
    L18:
        r4 = r8.j();
        goto L5
    }

    private void a(T r4, int r5, int r6, Object r7) {
        f4966b.putObject(r4, k(e(r6)), r7);
        e(r4, r5, r6);
    }

    private void a(Object r3, int r4, bk r5) {
        bk r6 = (bk) ZeusTransformUtils.wrapperContextForParams(r5, bk.class, "com.obric.memorydata.plugin");
        if (i(r4) == false) goto L6;
        long r0 = k(r4);
        Object r2 = r6.m();
    L5:
        bx.a(r3, r0, r2);
        return;
    L6:
        boolean r7 = this.i;
        r0 = k(r4);
        if (r7 == false) goto L9;
        r2 = r6.l();
        goto L5
    L9:
        r2 = r6.n();
        goto L5
    }

    private <E> void a(Object r3, int r4, bk r5, bl<E> r6, q r7) {
        bk r8 = (bk) ZeusTransformUtils.wrapperContextForParams(r5, bk.class, "com.obric.memorydata.plugin");
        bl<T> r9 = (bl) ZeusTransformUtils.wrapperContextForParams(r6, bl.class, "com.obric.memorydata.plugin");
        long r0 = k(r4);
        r8.a(this.p.a(r3, r0), r9, r7);
    }

    private void a(T r4, int r5, Object r6) {
        f4966b.putObject(r4, k(e(r5)), r6);
        c(r4, r5);
    }

    private final <K, V> void a(Object r5, int r6, Object r7, q r8, bk r9) {
        bk r10 = (bk) ZeusTransformUtils.wrapperContextForParams(r9, bk.class, "com.obric.memorydata.plugin");
        long r0 = k(e(r6));
        Object r11 = bx.f(r5, r0);
        if (r11 != null) goto L6;
        r11 = this.s.e(r7);
        bx.a(r5, r0, r11);
    L8:
        r10.a(this.s.a(r11), this.s.f(r7), r8);
        return;
    L6:
        if (this.s.c(r11) == false) goto L8;
        Object r2 = this.s.e(r7);
        this.s.a(r2, r11);
        bx.a(r5, r0, r2);
        r11 = r2;
        goto L8
    }

    private <E> void a(Object r3, long r4, bk r6, bl<E> r7, q r8) {
        bk r9 = (bk) ZeusTransformUtils.wrapperContextForParams(r6, bk.class, "com.obric.memorydata.plugin");
        bl<T> r10 = (bl) ZeusTransformUtils.wrapperContextForParams(r7, bl.class, "com.obric.memorydata.plugin");
        r9.b(this.p.a(r3, r4), r10, r8);
    }

    private boolean a(T r2, int r3, int r4, int r5, int r6) {
        if (r4 != 1048575) goto L7;
        return b(r2, r3);
    L7:
        if ((r5 & r6) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean a(Object r2, int r3, bl r4) {
        return ((bl) ZeusTransformUtils.wrapperContextForParams(r4, bl.class, "com.obric.memorydata.plugin")).e(bx.f(r2, k(r3)));
    }

    private boolean a(T r6, T r7, int r8) {
        int r0 = e(r8);
        long r1 = k(r0);
        switch(g(r0)) {
            case 0: goto L116;
            case 1: goto L110;
            case 2: goto L104;
            case 3: goto L98;
            case 4: goto L92;
            case 5: goto L86;
            case 6: goto L80;
            case 7: goto L74;
            case 8: goto L68;
            case 9: goto L62;
            case 10: goto L56;
            case 11: goto L50;
            case 12: goto L44;
            case 13: goto L38;
            case 14: goto L32;
            case 15: goto L26;
            case 16: goto L20;
            case 17: goto L14;
            case 18: goto L12;
            case 19: goto L12;
            case 20: goto L12;
            case 21: goto L12;
            case 22: goto L12;
            case 23: goto L12;
            case 24: goto L12;
            case 25: goto L12;
            case 26: goto L12;
            case 27: goto L12;
            case 28: goto L12;
            case 29: goto L12;
            case 30: goto L12;
            case 31: goto L12;
            case 32: goto L12;
            case 33: goto L12;
            case 34: goto L12;
            case 35: goto L12;
            case 36: goto L12;
            case 37: goto L12;
            case 38: goto L12;
            case 39: goto L12;
            case 40: goto L12;
            case 41: goto L12;
            case 42: goto L12;
            case 43: goto L12;
            case 44: goto L12;
            case 45: goto L12;
            case 46: goto L12;
            case 47: goto L12;
            case 48: goto L12;
            case 49: goto L12;
            case 50: goto L12;
            case 51: goto L6;
            case 52: goto L6;
            case 53: goto L6;
            case 54: goto L6;
            case 55: goto L6;
            case 56: goto L6;
            case 57: goto L6;
            case 58: goto L6;
            case 59: goto L6;
            case 60: goto L6;
            case 61: goto L6;
            case 62: goto L6;
            case 63: goto L6;
            case 64: goto L6;
            case 65: goto L6;
            case 66: goto L6;
            case 67: goto L6;
            case 68: goto L6;
            default: goto L4;
        };
    L4:
        return true;
    L6:
        if (f(r6, r7, r8) == true) goto L8;
        return false;
    L8:
        if (bn.a(bx.f(r6, r1), bx.f(r7, r1)) == true) goto L10;
        return false;
    L10:
        return true;
    L12:
        return bn.a(bx.f(r6, r1), bx.f(r7, r1));
    L14:
        if (e(r6, r7, r8) == true) goto L16;
        return false;
    L16:
        if (bn.a(bx.f(r6, r1), bx.f(r7, r1)) == true) goto L18;
        return false;
    L18:
        return true;
    L20:
        if (e(r6, r7, r8) == true) goto L22;
        return false;
    L22:
        if (bx.b(r6, r1) == bx.b(r7, r1)) goto L24;
        return false;
    L24:
        return true;
    L26:
        if (e(r6, r7, r8) == true) goto L28;
        return false;
    L28:
        if (bx.a(r6, r1) == bx.a(r7, r1)) goto L30;
        return false;
    L30:
        return true;
    L32:
        if (e(r6, r7, r8) == true) goto L34;
        return false;
    L34:
        if (bx.b(r6, r1) == bx.b(r7, r1)) goto L36;
        return false;
    L36:
        return true;
    L38:
        if (e(r6, r7, r8) == true) goto L40;
        return false;
    L40:
        if (bx.a(r6, r1) == bx.a(r7, r1)) goto L42;
        return false;
    L42:
        return true;
    L44:
        if (e(r6, r7, r8) == true) goto L46;
        return false;
    L46:
        if (bx.a(r6, r1) == bx.a(r7, r1)) goto L48;
        return false;
    L48:
        return true;
    L50:
        if (e(r6, r7, r8) == true) goto L52;
        return false;
    L52:
        if (bx.a(r6, r1) == bx.a(r7, r1)) goto L54;
        return false;
    L54:
        return true;
    L56:
        if (e(r6, r7, r8) == true) goto L58;
        return false;
    L58:
        if (bn.a(bx.f(r6, r1), bx.f(r7, r1)) == true) goto L60;
        return false;
    L60:
        return true;
    L62:
        if (e(r6, r7, r8) == true) goto L64;
        return false;
    L64:
        if (bn.a(bx.f(r6, r1), bx.f(r7, r1)) == true) goto L66;
        return false;
    L66:
        return true;
    L68:
        if (e(r6, r7, r8) == true) goto L70;
        return false;
    L70:
        if (bn.a(bx.f(r6, r1), bx.f(r7, r1)) == true) goto L72;
        return false;
    L72:
        return true;
    L74:
        if (e(r6, r7, r8) == true) goto L76;
        return false;
    L76:
        if (bx.c(r6, r1) == bx.c(r7, r1)) goto L78;
        return false;
    L78:
        return true;
    L80:
        if (e(r6, r7, r8) == true) goto L82;
        return false;
    L82:
        if (bx.a(r6, r1) == bx.a(r7, r1)) goto L84;
        return false;
    L84:
        return true;
    L86:
        if (e(r6, r7, r8) == true) goto L88;
        return false;
    L88:
        if (bx.b(r6, r1) == bx.b(r7, r1)) goto L90;
        return false;
    L90:
        return true;
    L92:
        if (e(r6, r7, r8) == true) goto L94;
        return false;
    L94:
        if (bx.a(r6, r1) == bx.a(r7, r1)) goto L96;
        return false;
    L96:
        return true;
    L98:
        if (e(r6, r7, r8) == true) goto L100;
        return false;
    L100:
        if (bx.b(r6, r1) == bx.b(r7, r1)) goto L102;
        return false;
    L102:
        return true;
    L104:
        if (e(r6, r7, r8) == true) goto L106;
        return false;
    L106:
        if (bx.b(r6, r1) == bx.b(r7, r1)) goto L108;
        return false;
    L108:
        return true;
    L110:
        if (e(r6, r7, r8) == true) goto L112;
        return false;
    L112:
        if (Float.floatToIntBits(bx.d(r6, r1)) == Float.floatToIntBits(bx.d(r7, r1))) goto L114;
        return false;
    L114:
        return true;
    L116:
        if (e(r6, r7, r8) == true) goto L118;
        return false;
    L118:
        if (Double.doubleToLongBits(bx.e(r6, r1)) == Double.doubleToLongBits(bx.e(r7, r1))) goto L120;
        return false;
    L120:
        return true;
    }

    private static <T> float b(T r0, long r1) {
        return bx.d(r0, r1);
    }

    private int b(int r5, int r6) {
        int r0 = (this.c.length / 3) - 1;
    L3:
        if (r6 > r0) goto L10;
        int r1 = (r0 + r6) >>> 1;
        int r2 = r1 * 3;
        int r3 = d(r2);
        if (r5 == r3) goto L6;
        if (r5 < r3) goto L8;
        r6 = r1 + 1;
        goto L3
    L8:
        r0 = r1 - 1;
        goto L3
    L6:
        return r2;
    L10:
        return -1;
    }

    private Object b(int r1) {
        return this.d[(r1 / 3) * 2];
    }

    private void b(Object r3, int r4, bk r5) {
        bk r6 = (bk) ZeusTransformUtils.wrapperContextForParams(r5, bk.class, "com.obric.memorydata.plugin");
        boolean r0 = i(r4);
        ai r2 = this.p;
        if (r0 == false) goto L5;
        r6.j(r2.a(r3, k(r4)));
        return;
    L5:
        r6.i(r2.a(r3, k(r4)));
    }

    private void b(T r23, Writer r24) {
        Writer r9 = (Writer) ZeusTransformUtils.wrapperContextForParams(r24, Writer.class, "com.obric.memorydata.plugin");
        if (this.h == false) goto L7;
        w<T> r0 = this.r.a(r23);
        if (r0.c() == true) goto L7;
        Iterator r1 = r0.g();
        Map.Entry<?, ?> r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Iterator r11 = r1;
    L8:
        int r12 = this.c.length;
        Unsafe r13 = f4966b;
        int r3 = 1048575;
        int r4 = 0;
        int r5 = 0;
    L9:
        if (r5 >= r12) goto L179;
        int r6 = e(r5);
        int r7 = d(r5);
        int r10 = g(r6);
        if (r10 > 17) goto L19;
        int r15 = this.c[r5 + 2];
        Map.Entry<?, ?> r17 = r2;
        int r8 = r15 & 1048575;
        if (r8 == r3) goto L18;
        if (r8 != 1048575) goto L16;
        r4 = 0;
    L17:
        r3 = r8;
        goto L18
    L16:
        r4 = r13.getInt(r23, r8);
    L18:
        int r14 = r3;
        int r19 = 1 << (r15 >>> 20);
        Map.Entry<?, ?> r16 = r17;
    L20:
        int r18 = r4;
    L21:
        if (r16 == null) goto L28;
        if (this.r.a(r16) > r7) goto L28;
        this.r.a(r9, r16);
        if (r11.hasNext() == true) goto L26;
        r16 = null;
        goto L21
    L26:
        r16 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
    L28:
        long r20 = k(r6);
        switch(r10) {
            case 0: goto L175;
            case 1: goto L172;
            case 2: goto L169;
            case 3: goto L166;
            case 4: goto L163;
            case 5: goto L160;
            case 6: goto L157;
            case 7: goto L154;
            case 8: goto L151;
            case 9: goto L148;
            case 10: goto L145;
            case 11: goto L142;
            case 12: goto L139;
            case 13: goto L136;
            case 14: goto L133;
            case 15: goto L130;
            case 16: goto L127;
            case 17: goto L124;
            case 18: goto L123;
            case 19: goto L122;
            case 20: goto L121;
            case 21: goto L120;
            case 22: goto L119;
            case 23: goto L118;
            case 24: goto L117;
            case 25: goto L116;
            case 26: goto L115;
            case 27: goto L114;
            case 28: goto L113;
            case 29: goto L111;
            case 30: goto L109;
            case 31: goto L107;
            case 32: goto L105;
            case 33: goto L103;
            case 34: goto L101;
            case 35: goto L100;
            case 36: goto L99;
            case 37: goto L98;
            case 38: goto L97;
            case 39: goto L96;
            case 40: goto L95;
            case 41: goto L94;
            case 42: goto L93;
            case 43: goto L92;
            case 44: goto L91;
            case 45: goto L90;
            case 46: goto L89;
            case 47: goto L88;
            case 48: goto L87;
            case 49: goto L86;
            case 50: goto L85;
            case 51: goto L83;
            case 52: goto L80;
            case 53: goto L77;
            case 54: goto L74;
            case 55: goto L71;
            case 56: goto L68;
            case 57: goto L65;
            case 58: goto L62;
            case 59: goto L59;
            case 60: goto L56;
            case 61: goto L53;
            case 62: goto L50;
            case 63: goto L47;
            case 64: goto L44;
            case 65: goto L41;
            case 66: goto L38;
            case 67: goto L35;
            case 68: goto L32;
            default: goto L30;
        };
    L30:
        Iterator r110 = r11;
        int r21 = r12;
        Map.Entry<?, ?> r22 = r16;
        int r111 = r5;
    L178:
        r5 = r111 + 3;
        r3 = r14;
        r11 = r110;
        r4 = r18;
        r12 = r21;
        r2 = r22;
        goto L9
    L85:
        a(r9, r7, r13.getObject(r23, r20), r5);
        goto L30
    L86:
        bn.b(d(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, a(r5));
        goto L30
    L87:
        int r25 = d(r5);
        List r26 = (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin");
        boolean r27 = true;
    L102:
        bn.e(r25, r26, r9, r27);
        goto L30
    L88:
        boolean r28 = true;
    L104:
        bn.j(d(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, r28);
        goto L30
    L89:
        boolean r29 = true;
    L106:
        bn.g(d(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, r29);
        goto L30
    L90:
        boolean r30 = true;
    L108:
        bn.l(d(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, r30);
        goto L30
    L91:
        boolean r31 = true;
    L110:
        bn.m(d(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, r31);
        goto L30
    L92:
        boolean r32 = true;
    L112:
        bn.i(d(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, r32);
        goto L30
    L93:
        bn.n(d(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, true);
        goto L30
    L94:
        bn.k(d(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, true);
        goto L30
    L95:
        bn.f(d(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, true);
        goto L30
    L96:
        bn.h(d(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, true);
        goto L30
    L97:
        bn.d(d(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, true);
        goto L30
    L98:
        bn.c(d(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, true);
        goto L30
    L99:
        bn.b(d(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, true);
        goto L30
    L100:
        bn.a(d(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, true);
        goto L30
    L101:
        r25 = d(r5);
        r26 = (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin");
        r27 = false;
        goto L102
    L103:
        r28 = false;
        goto L104
    L105:
        r29 = false;
        goto L106
    L107:
        r30 = false;
        goto L108
    L109:
        r31 = false;
        goto L110
    L111:
        r32 = false;
        goto L112
    L113:
        bn.b(d(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9);
        goto L30
    L114:
        bn.a(d(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, a(r5));
        goto L30
    L115:
        bn.a(d(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9);
        goto L30
    L116:
        bn.n(d(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, false);
        goto L30
    L117:
        bn.k(d(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, false);
        goto L30
    L118:
        bn.f(d(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, false);
        goto L30
    L119:
        bn.h(d(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, false);
        goto L30
    L120:
        bn.d(d(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, false);
        goto L30
    L121:
        bn.c(d(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, false);
        goto L30
    L122:
        bn.b(d(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, false);
        goto L30
    L123:
        bn.a(d(r5), (List) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), List.class, "com.obric.memorydata.plugin"), r9, false);
        goto L30
    L124:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (a(r23, r5, r14, r18, r19) == false) goto L178;
        r9.b(r7, r13.getObject(r23, r20), a(r111));
        goto L178
    L127:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (a(r23, r111, r14, r18, r19) == false) goto L178;
        r9.e(r7, r13.getLong(r23, r20));
        goto L178
    L130:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (a(r23, r111, r14, r18, r19) == false) goto L178;
        r9.f(r7, r13.getInt(r23, r20));
        goto L178
    L133:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (a(r23, r111, r14, r18, r19) == false) goto L178;
        r9.b(r7, r13.getLong(r23, r20));
        goto L178
    L136:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (a(r23, r111, r14, r18, r19) == false) goto L178;
        r9.a(r7, r13.getInt(r23, r20));
        goto L178
    L139:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (a(r23, r111, r14, r18, r19) == false) goto L178;
        r9.b(r7, r13.getInt(r23, r20));
        goto L178
    L142:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (a(r23, r111, r14, r18, r19) == false) goto L178;
        r9.e(r7, r13.getInt(r23, r20));
        goto L178
    L145:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (a(r23, r111, r14, r18, r19) == false) goto L178;
        r9.a(r7, (ByteString) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), ByteString.class, "com.obric.memorydata.plugin"));
        goto L178
    L148:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (a(r23, r111, r14, r18, r19) == false) goto L178;
        r9.a(r7, r13.getObject(r23, r20), a(r111));
        goto L178
    L151:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (a(r23, r111, r14, r18, r19) == false) goto L178;
        a(r7, r13.getObject(r23, r20), r9);
        goto L178
    L154:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (a(r23, r111, r14, r18, r19) == false) goto L178;
        r9.a(r7, e(r23, r20));
        goto L178
    L157:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (a(r23, r111, r14, r18, r19) == false) goto L178;
        r9.d(r7, r13.getInt(r23, r20));
        goto L178
    L160:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (a(r23, r111, r14, r18, r19) == false) goto L178;
        r9.d(r7, r13.getLong(r23, r20));
        goto L178
    L163:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (a(r23, r111, r14, r18, r19) == false) goto L178;
        r9.c(r7, r13.getInt(r23, r20));
        goto L178
    L166:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (a(r23, r111, r14, r18, r19) == false) goto L178;
        r9.c(r7, r13.getLong(r23, r20));
        goto L178
    L169:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (a(r23, r111, r14, r18, r19) == false) goto L178;
        r9.a(r7, r13.getLong(r23, r20));
        goto L178
    L172:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (a(r23, r111, r14, r18, r19) == false) goto L178;
        r9.a(r7, b(r23, r20));
        goto L178
    L175:
        r110 = r11;
        r21 = r12;
        r22 = r16;
        r111 = r5;
        if (a(r23, r111, r14, r18, r19) == false) goto L178;
        r9.a(r7, a(r23, r20));
        goto L178
    L32:
        if (d(r23, r7, r5) == false) goto L30;
        r9.b(r7, r13.getObject(r23, r20), a(r5));
        goto L30
    L35:
        if (d(r23, r7, r5) == false) goto L30;
        r9.e(r7, i(r23, r20));
        goto L30
    L38:
        if (d(r23, r7, r5) == false) goto L30;
        r9.f(r7, h(r23, r20));
        goto L30
    L41:
        if (d(r23, r7, r5) == false) goto L30;
        r9.b(r7, i(r23, r20));
        goto L30
    L44:
        if (d(r23, r7, r5) == false) goto L30;
        r9.a(r7, h(r23, r20));
        goto L30
    L47:
        if (d(r23, r7, r5) == false) goto L30;
        r9.b(r7, h(r23, r20));
        goto L30
    L50:
        if (d(r23, r7, r5) == false) goto L30;
        r9.e(r7, h(r23, r20));
        goto L30
    L53:
        if (d(r23, r7, r5) == false) goto L30;
        r9.a(r7, (ByteString) ZeusTransformUtils.preCheckCast(r13.getObject(r23, r20), ByteString.class, "com.obric.memorydata.plugin"));
        goto L30
    L56:
        if (d(r23, r7, r5) == false) goto L30;
        r9.a(r7, r13.getObject(r23, r20), a(r5));
        goto L30
    L59:
        if (d(r23, r7, r5) == false) goto L30;
        a(r7, r13.getObject(r23, r20), r9);
        goto L30
    L62:
        if (d(r23, r7, r5) == false) goto L30;
        r9.a(r7, j(r23, r20));
        goto L30
    L65:
        if (d(r23, r7, r5) == false) goto L30;
        r9.d(r7, h(r23, r20));
        goto L30
    L68:
        if (d(r23, r7, r5) == false) goto L30;
        r9.d(r7, i(r23, r20));
        goto L30
    L71:
        if (d(r23, r7, r5) == false) goto L30;
        r9.c(r7, h(r23, r20));
        goto L30
    L74:
        if (d(r23, r7, r5) == false) goto L30;
        r9.c(r7, i(r23, r20));
        goto L30
    L77:
        if (d(r23, r7, r5) == false) goto L30;
        r9.a(r7, i(r23, r20));
        goto L30
    L80:
        if (d(r23, r7, r5) == false) goto L30;
        r9.a(r7, g(r23, r20));
        goto L30
    L83:
        if (d(r23, r7, r5) == false) goto L30;
        r9.a(r7, f(r23, r20));
        goto L30
    L19:
        r14 = r3;
        r16 = r2;
        r19 = 0;
        goto L20
    L179:
        Iterator r112 = r11;
    L180:
        if (r2 == null) goto L185;
        this.r.a(r9, r2);
        if (r112.hasNext() == true) goto L183;
        r2 = null;
        goto L180
    L183:
        r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r112.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        goto L180
    L185:
        a(this.q, r23, r9);
        return;
    L7:
        r2 = null;
        r11 = null;
        goto L8
    }

    private void b(T r6, T r7, int r8) {
        int r0 = e(r8);
        long r1 = k(r0);
        int r3 = d(r8);
        switch(g(r0)) {
            case 0: goto L61;
            case 1: goto L58;
            case 2: goto L55;
            case 3: goto L52;
            case 4: goto L49;
            case 5: goto L46;
            case 6: goto L43;
            case 7: goto L40;
            case 8: goto L37;
            case 9: goto L35;
            case 10: goto L33;
            case 11: goto L30;
            case 12: goto L27;
            case 13: goto L24;
            case 14: goto L21;
            case 15: goto L18;
            case 16: goto L15;
            case 17: goto L35;
            case 18: goto L13;
            case 19: goto L13;
            case 20: goto L13;
            case 21: goto L13;
            case 22: goto L13;
            case 23: goto L13;
            case 24: goto L13;
            case 25: goto L13;
            case 26: goto L13;
            case 27: goto L13;
            case 28: goto L13;
            case 29: goto L13;
            case 30: goto L13;
            case 31: goto L13;
            case 32: goto L13;
            case 33: goto L13;
            case 34: goto L13;
            case 35: goto L13;
            case 36: goto L13;
            case 37: goto L13;
            case 38: goto L13;
            case 39: goto L13;
            case 40: goto L13;
            case 41: goto L13;
            case 42: goto L13;
            case 43: goto L13;
            case 44: goto L13;
            case 45: goto L13;
            case 46: goto L13;
            case 47: goto L13;
            case 48: goto L13;
            case 49: goto L13;
            case 50: goto L12;
            case 51: goto L10;
            case 52: goto L10;
            case 53: goto L10;
            case 54: goto L10;
            case 55: goto L10;
            case 56: goto L10;
            case 57: goto L10;
            case 58: goto L10;
            case 59: goto L10;
            case 60: goto L8;
            case 61: goto L6;
            case 62: goto L6;
            case 63: goto L6;
            case 64: goto L6;
            case 65: goto L6;
            case 66: goto L6;
            case 67: goto L6;
            case 68: goto L8;
            default: goto L88;
        };
    L8:
        d(r6, r7, r8);
        return;
    L12:
        bn.a(this.s, r6, r7, r1);
        return;
    L13:
        this.p.a(r6, r7, r1);
        return;
    L35:
        c(r6, r7, r8);
        return;
    L88:
        return;
    L6:
        if (d(r7, r3, r8) == false) goto L65;
    L11:
        bx.a(r6, r1, bx.f(r7, r1));
        e(r6, r3, r8);
        return;
    L65:
        return;
    L10:
        if (d(r7, r3, r8) == true) goto L11;
        return;
    L15:
        if (b(r7, r8) == false) goto L71;
    L56:
        bx.a(r6, r1, bx.b(r7, r1));
    L63:
        c(r6, r8);
        return;
    L71:
        return;
    L18:
        if (b(r7, r8) == false) goto L72;
    L50:
        bx.a(r6, r1, bx.a(r7, r1));
        goto L63
    L72:
        return;
    L21:
        if (b(r7, r8) == true) goto L56;
        return;
    L24:
        if (b(r7, r8) == true) goto L50;
        return;
    L27:
        if (b(r7, r8) == true) goto L50;
        return;
    L30:
        if (b(r7, r8) == true) goto L50;
        return;
    L33:
        if (b(r7, r8) == false) goto L77;
    L38:
        bx.a(r6, r1, bx.f(r7, r1));
        goto L63
    L77:
        return;
    L37:
        if (b(r7, r8) == true) goto L38;
        return;
    L40:
        if (b(r7, r8) == false) goto L80;
        bx.a(r6, r1, bx.c(r7, r1));
        goto L63
    L80:
        return;
    L43:
        if (b(r7, r8) == true) goto L50;
        return;
    L46:
        if (b(r7, r8) == true) goto L56;
        return;
    L49:
        if (b(r7, r8) == true) goto L50;
        return;
    L52:
        if (b(r7, r8) == true) goto L56;
        return;
    L55:
        if (b(r7, r8) == true) goto L56;
        return;
    L58:
        if (b(r7, r8) == false) goto L86;
        bx.a(r6, r1, bx.d(r7, r1));
        goto L63
    L86:
        return;
    L61:
        if (b(r7, r8) == false) goto L87;
        bx.a(r6, r1, bx.e(r7, r1));
        goto L63
    }

    private boolean b(T r7, int r8) {
        int r0 = f(r8);
        long r1 = 1048575 & r0;
        if (r1 != 1048575) goto L83;
        int r6 = e(r8);
        long r2 = k(r6);
        switch(g(r6)) {
            case 0: goto L79;
            case 1: goto L75;
            case 2: goto L71;
            case 3: goto L67;
            case 4: goto L63;
            case 5: goto L59;
            case 6: goto L55;
            case 7: goto L53;
            case 8: goto L42;
            case 9: goto L39;
            case 10: goto L37;
            case 11: goto L33;
            case 12: goto L29;
            case 13: goto L25;
            case 14: goto L21;
            case 15: goto L17;
            case 16: goto L13;
            case 17: goto L9;
            default: goto L7;
        };
    L42:
        Object r9 = bx.f(r7, r2);
        if (ZeusTransformUtils.instanceOf(r9, String.class) == false) goto L47;
        return !((String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.memorydata.plugin")).isEmpty();
    L47:
        if (ZeusTransformUtils.instanceOf(r9, ByteString.class) == false) goto L51;
        return !ByteString.EMPTY.equals(r9);
    L51:
        throw new IllegalArgumentException();
    L7:
        throw new IllegalArgumentException();
    L9:
        if (bx.f(r7, r2) != null) goto L11;
        return false;
    L11:
        return true;
    L13:
        if (bx.b(r7, r2) != 0) goto L15;
        return false;
    L15:
        return true;
    L17:
        if (bx.a(r7, r2) != 0) goto L19;
        return false;
    L19:
        return true;
    L21:
        if (bx.b(r7, r2) != 0) goto L23;
        return false;
    L23:
        return true;
    L25:
        if (bx.a(r7, r2) != 0) goto L27;
        return false;
    L27:
        return true;
    L29:
        if (bx.a(r7, r2) != 0) goto L31;
        return false;
    L31:
        return true;
    L33:
        if (bx.a(r7, r2) != 0) goto L35;
        return false;
    L35:
        return true;
    L37:
        return !ByteString.EMPTY.equals(bx.f(r7, r2));
    L39:
        if (bx.f(r7, r2) != null) goto L41;
        return false;
    L41:
        return true;
    L53:
        return bx.c(r7, r2);
    L55:
        if (bx.a(r7, r2) != 0) goto L57;
        return false;
    L57:
        return true;
    L59:
        if (bx.b(r7, r2) != 0) goto L61;
        return false;
    L61:
        return true;
    L63:
        if (bx.a(r7, r2) != 0) goto L65;
        return false;
    L65:
        return true;
    L67:
        if (bx.b(r7, r2) != 0) goto L69;
        return false;
    L69:
        return true;
    L71:
        if (bx.b(r7, r2) != 0) goto L73;
        return false;
    L73:
        return true;
    L75:
        if (Float.floatToRawIntBits(bx.d(r7, r2)) != 0) goto L77;
        return false;
    L77:
        return true;
    L79:
        if (Double.doubleToRawLongBits(bx.e(r7, r2)) != 0) goto L81;
        return false;
    L81:
        return true;
    L83:
        if (((1 << (r0 >>> 20)) & bx.a(r7, r1)) != 0) goto L85;
        return false;
    L85:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean b(Object r3, int r4, int r5) {
        List r6 = (List) ZeusTransformUtils.preCheckCast(bx.f(r3, k(r4)), List.class, "com.obric.memorydata.plugin");
        if (r6.isEmpty() == false) goto L5;
        return true;
    L5:
        bl r2 = a(r5);
        int r7 = 0;
    L7:
        if (r7 >= r6.size()) goto L12;
        if (r2.e(r6.get(r7)) == false) goto L10;
        r7 = r7 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    private static <T> int c(T r0, long r1) {
        return bx.a(r0, r1);
    }

    private ab.e c(int r2) {
        return (ab.e) ZeusTransformUtils.preCheckCast(this.d[((r2 / 3) * 2) + 1], ab.e.class, "com.obric.memorydata.plugin");
    }

    static bu c(Object r3) {
        bu r0 = ((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r3, GeneratedMessageLite.class, "com.obric.memorydata.plugin")).unknownFields;
        if (r0 != bu.a()) goto L6;
        bu r1 = bu.b();
        ((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r3, GeneratedMessageLite.class, "com.obric.memorydata.plugin")).unknownFields = r1;
        return r1;
    L6:
        return r0;
    }

    private void c(T r5, int r6) {
        int r4 = f(r6);
        long r0 = 1048575 & r4;
        if (r0 != 1048575) goto L5;
        return;
    L5:
        bx.a(r5, r0, (1 << (r4 >>> 20)) | bx.a(r5, r0));
    }

    private void c(T r12, Writer r13) {
        Writer r14 = (Writer) ZeusTransformUtils.wrapperContextForParams(r13, Writer.class, "com.obric.memorydata.plugin");
        a(this.q, r12, r14);
        if (this.h == false) goto L7;
        w<T> r0 = this.r.a(r12);
        if (r0.c() == true) goto L7;
        Iterator r1 = r0.h();
        Map.Entry<?, ?> r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
    L8:
        int r4 = this.c.length - 3;
    L9:
        if (r4 < 0) goto L177;
        int r5 = e(r4);
        int r6 = d(r4);
    L11:
        if (r3 == null) goto L19;
        if (this.r.a(r3) <= r6) goto L19;
        this.r.a(r14, r3);
        if (r1.hasNext() == true) goto L16;
        r3 = null;
        goto L11
    L16:
        r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
    L19:
        switch(g(r5)) {
            case 0: goto L173;
            case 1: goto L169;
            case 2: goto L165;
            case 3: goto L161;
            case 4: goto L157;
            case 5: goto L153;
            case 6: goto L149;
            case 7: goto L145;
            case 8: goto L142;
            case 9: goto L139;
            case 10: goto L136;
            case 11: goto L132;
            case 12: goto L128;
            case 13: goto L124;
            case 14: goto L120;
            case 15: goto L116;
            case 16: goto L112;
            case 17: goto L109;
            case 18: goto L107;
            case 19: goto L106;
            case 20: goto L105;
            case 21: goto L104;
            case 22: goto L103;
            case 23: goto L102;
            case 24: goto L101;
            case 25: goto L100;
            case 26: goto L99;
            case 27: goto L98;
            case 28: goto L97;
            case 29: goto L96;
            case 30: goto L95;
            case 31: goto L94;
            case 32: goto L93;
            case 33: goto L92;
            case 34: goto L91;
            case 35: goto L90;
            case 36: goto L89;
            case 37: goto L88;
            case 38: goto L87;
            case 39: goto L86;
            case 40: goto L85;
            case 41: goto L84;
            case 42: goto L83;
            case 43: goto L82;
            case 44: goto L81;
            case 45: goto L80;
            case 46: goto L79;
            case 47: goto L78;
            case 48: goto L77;
            case 49: goto L76;
            case 50: goto L75;
            case 51: goto L73;
            case 52: goto L70;
            case 53: goto L67;
            case 54: goto L64;
            case 55: goto L61;
            case 56: goto L58;
            case 57: goto L55;
            case 58: goto L52;
            case 59: goto L49;
            case 60: goto L46;
            case 61: goto L43;
            case 62: goto L40;
            case 63: goto L37;
            case 64: goto L34;
            case 65: goto L31;
            case 66: goto L28;
            case 67: goto L25;
            case 68: goto L22;
            default: goto L176;
        };
    L75:
        a(r14, r6, bx.f(r12, k(r5)), r4);
        goto L176
    L76:
        bn.b(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, a(r4));
        goto L176
    L77:
        bn.e(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L78:
        bn.j(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L79:
        bn.g(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L80:
        bn.l(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L81:
        bn.m(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L82:
        bn.i(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L83:
        bn.n(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L84:
        bn.k(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L85:
        bn.f(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L86:
        bn.h(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L87:
        bn.d(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L88:
        bn.c(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L89:
        bn.b(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L90:
        bn.a(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, true);
        goto L176
    L91:
        bn.e(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L92:
        bn.j(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L93:
        bn.g(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L94:
        bn.l(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L95:
        bn.m(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L96:
        bn.i(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L97:
        bn.b(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14);
        goto L176
    L98:
        bn.a(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, a(r4));
        goto L176
    L99:
        bn.a(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14);
        goto L176
    L100:
        bn.n(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L101:
        bn.k(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L102:
        bn.f(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L103:
        bn.h(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L104:
        bn.d(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L105:
        bn.c(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L106:
        bn.b(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L107:
        bn.a(d(r4), (List) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), List.class, "com.obric.memorydata.plugin"), r14, false);
        goto L176
    L22:
        if (d(r12, r6, r4) == false) goto L176;
    L110:
        r14.b(r6, bx.f(r12, k(r5)), a(r4));
        goto L176
    L25:
        if (d(r12, r6, r4) == false) goto L176;
        long r7 = i(r12, k(r5));
    L114:
        r14.e(r6, r7);
        goto L176
    L28:
        if (d(r12, r6, r4) == false) goto L176;
        int r8 = h(r12, k(r5));
    L118:
        r14.f(r6, r8);
        goto L176
    L31:
        if (d(r12, r6, r4) == false) goto L176;
        long r9 = i(r12, k(r5));
    L122:
        r14.b(r6, r9);
        goto L176
    L34:
        if (d(r12, r6, r4) == false) goto L176;
        int r10 = h(r12, k(r5));
    L126:
        r14.a(r6, r10);
        goto L176
    L37:
        if (d(r12, r6, r4) == false) goto L176;
        int r11 = h(r12, k(r5));
    L130:
        r14.b(r6, r11);
        goto L176
    L40:
        if (d(r12, r6, r4) == false) goto L176;
        int r15 = h(r12, k(r5));
    L134:
        r14.e(r6, r15);
        goto L176
    L43:
        if (d(r12, r6, r4) == false) goto L176;
    L137:
        r14.a(r6, (ByteString) ZeusTransformUtils.preCheckCast(bx.f(r12, k(r5)), ByteString.class, "com.obric.memorydata.plugin"));
        goto L176
    L46:
        if (d(r12, r6, r4) == false) goto L176;
    L140:
        r14.a(r6, bx.f(r12, k(r5)), a(r4));
        goto L176
    L49:
        if (d(r12, r6, r4) == false) goto L176;
    L143:
        a(r6, bx.f(r12, k(r5)), r14);
        goto L176
    L52:
        if (d(r12, r6, r4) == false) goto L176;
        boolean r16 = j(r12, k(r5));
    L147:
        r14.a(r6, r16);
        goto L176
    L55:
        if (d(r12, r6, r4) == false) goto L176;
        int r17 = h(r12, k(r5));
    L151:
        r14.d(r6, r17);
        goto L176
    L58:
        if (d(r12, r6, r4) == false) goto L176;
        long r18 = i(r12, k(r5));
    L155:
        r14.d(r6, r18);
        goto L176
    L61:
        if (d(r12, r6, r4) == false) goto L176;
        int r19 = h(r12, k(r5));
    L159:
        r14.c(r6, r19);
        goto L176
    L64:
        if (d(r12, r6, r4) == false) goto L176;
        long r20 = i(r12, k(r5));
    L163:
        r14.c(r6, r20);
        goto L176
    L67:
        if (d(r12, r6, r4) == false) goto L176;
        long r21 = i(r12, k(r5));
    L167:
        r14.a(r6, r21);
        goto L176
    L70:
        if (d(r12, r6, r4) == false) goto L176;
        float r22 = g(r12, k(r5));
    L171:
        r14.a(r6, r22);
        goto L176
    L73:
        if (d(r12, r6, r4) == false) goto L176;
        double r23 = f(r12, k(r5));
    L175:
        r14.a(r6, r23);
        goto L176
    L109:
        if (b(r12, r4) == false) goto L176;
    L112:
        if (b(r12, r4) == false) goto L176;
        r7 = d(r12, k(r5));
        goto L114
    L116:
        if (b(r12, r4) == false) goto L176;
        r8 = c(r12, k(r5));
        goto L118
    L120:
        if (b(r12, r4) == false) goto L176;
        r9 = d(r12, k(r5));
        goto L122
    L124:
        if (b(r12, r4) == false) goto L176;
        r10 = c(r12, k(r5));
        goto L126
    L128:
        if (b(r12, r4) == false) goto L176;
        r11 = c(r12, k(r5));
        goto L130
    L132:
        if (b(r12, r4) == false) goto L176;
        r15 = c(r12, k(r5));
        goto L134
    L136:
        if (b(r12, r4) == false) goto L176;
    L139:
        if (b(r12, r4) == false) goto L176;
    L142:
        if (b(r12, r4) == false) goto L176;
    L145:
        if (b(r12, r4) == false) goto L176;
        r16 = e(r12, k(r5));
        goto L147
    L149:
        if (b(r12, r4) == false) goto L176;
        r17 = c(r12, k(r5));
        goto L151
    L153:
        if (b(r12, r4) == false) goto L176;
        r18 = d(r12, k(r5));
        goto L155
    L157:
        if (b(r12, r4) == false) goto L176;
        r19 = c(r12, k(r5));
        goto L159
    L161:
        if (b(r12, r4) == false) goto L176;
        r20 = d(r12, k(r5));
        goto L163
    L165:
        if (b(r12, r4) == false) goto L176;
        r21 = d(r12, k(r5));
        goto L167
    L169:
        if (b(r12, r4) == false) goto L176;
        r22 = b(r12, k(r5));
        goto L171
    L173:
        if (b(r12, r4) == false) goto L176;
        r23 = a(r12, k(r5));
    L176:
        r4 = r4 - 3;
    L177:
        if (r3 == null) goto L182;
        this.r.a(r14, r3);
        if (r1.hasNext() == true) goto L180;
        r3 = null;
        goto L177
    L180:
        r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        goto L177
    L182:
        return;
    L7:
        r1 = null;
        r3 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c(T r6, T r7, int r8) {
        if (b(r7, r8) == true) goto L5;
        return;
    L5:
        long r0 = k(e(r8));
        Unsafe r2 = f4966b;
        Object r3 = r2.getObject(r7, r0);
        if (r3 == null) goto L21;
        bl r9 = a(r8);
        if (b(r6, r8) == false) goto L10;
        Object r5 = r2.getObject(r6, r0);
        if (f(r5) == true) goto L18;
        Object r10 = r9.a();
        r9.b(r10, r5);
        r2.putObject(r6, r0, r10);
        r5 = r10;
    L18:
        r9.b(r5, r3);
        return;
    L10:
        if (f(r3) == true) goto L12;
        r2.putObject(r6, r0, r3);
    L13:
        c(r6, r8);
        return;
    L12:
        Object r4 = r9.a();
        r9.b(r4, r3);
        r2.putObject(r6, r0, r4);
        goto L13
    L21:
        throw new IllegalStateException("Source subfield " + d(r8) + " is present but null: " + r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [com.google.crypto.tink.shaded.protobuf.bl] */
    private boolean c(T r4, int r5, int r6) {
        Map<?, ?> r7 = this.s.b(bx.f(r4, k(r5)));
        if (r7.isEmpty() == false) goto L5;
        return true;
    L5:
        Object r8 = b(r6);
        if (this.s.f(r8).c.getJavaType() == WireFormat.JavaType.MESSAGE) goto L8;
        return true;
    L8:
        ?? r3 = 0;
        Iterator<?> r9 = r7.values().iterator();
    L10:
        if (r9.hasNext() == false) goto L18;
        Object r10 = r9.next();
        r3 = r3;
        if (r3 != 0) goto L15;
        r3 = bg.a().a(r10.getClass());
    L15:
        if (r3.e(r10) == true) goto L10;
        return false;
    L18:
        return true;
    }

    private int d(int r1) {
        return this.c[r1];
    }

    private static <T> long d(T r0, long r1) {
        return bx.b(r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d(T r7, T r8, int r9) {
        int r0 = d(r9);
        if (d(r8, r0, r9) == true) goto L5;
        return;
    L5:
        long r1 = k(e(r9));
        Unsafe r3 = f4966b;
        Object r4 = r3.getObject(r8, r1);
        if (r4 == null) goto L21;
        bl r10 = a(r9);
        if (d(r7, r0, r9) == false) goto L10;
        Object r6 = r3.getObject(r7, r1);
        if (f(r6) == true) goto L18;
        Object r11 = r10.a();
        r10.b(r11, r6);
        r3.putObject(r7, r1, r11);
        r6 = r11;
    L18:
        r10.b(r6, r4);
        return;
    L10:
        if (f(r4) == true) goto L12;
        r3.putObject(r7, r1, r4);
    L13:
        e(r7, r0, r9);
        return;
    L12:
        Object r5 = r10.a();
        r10.b(r5, r4);
        r3.putObject(r7, r1, r5);
        goto L13
    L21:
        throw new IllegalStateException("Source subfield " + d(r9) + " is present but null: " + r8);
    }

    private boolean d(T r3, int r4, int r5) {
        if (bx.a(r3, f(r5) & 1048575) != r4) goto L5;
        return true;
    L5:
        return false;
    }

    private int e(int r1) {
        return this.c[r1 + 1];
    }

    private void e(T r3, int r4, int r5) {
        bx.a(r3, f(r5) & 1048575, r4);
    }

    private static <T> boolean e(T r0, long r1) {
        return bx.c(r0, r1);
    }

    private boolean e(T r1, T r2, int r3) {
        if (b(r1, r3) != b(r2, r3)) goto L5;
        return true;
    L5:
        return false;
    }

    private static <T> double f(T r0, long r1) {
        return ((Double) ZeusTransformUtils.preCheckCast(bx.f(r0, r1), Double.class, "com.obric.memorydata.plugin")).doubleValue();
    }

    private int f(int r1) {
        return this.c[r1 + 2];
    }

    private static boolean f(Object r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, GeneratedMessageLite.class) == true) goto L8;
        return true;
    L8:
        return ((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r2, GeneratedMessageLite.class, "com.obric.memorydata.plugin")).isMutable();
    }

    private boolean f(T r3, T r4, int r5) {
        long r0 = f(r5) & 1048575;
        if (bx.a(r3, r0) != bx.a(r4, r0)) goto L5;
        return true;
    L5:
        return false;
    }

    private static <T> float g(T r0, long r1) {
        return ((Float) ZeusTransformUtils.preCheckCast(bx.f(r0, r1), Float.class, "com.obric.memorydata.plugin")).floatValue();
    }

    private static int g(int r1) {
        return (r1 & 267386880) >>> 20;
    }

    private static void g(Object r3) {
        if (f(r3) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Mutating immutable message: " + r3);
    }

    private static <T> int h(T r0, long r1) {
        return ((Integer) ZeusTransformUtils.preCheckCast(bx.f(r0, r1), Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    private static boolean h(int r1) {
        if ((r1 & SQLiteDatabase.CREATE_IF_NECESSARY) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static <T> long i(T r0, long r1) {
        return ((Long) ZeusTransformUtils.preCheckCast(bx.f(r0, r1), Long.class, "com.obric.memorydata.plugin")).longValue();
    }

    private static boolean i(int r1) {
        if ((r1 & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean j(int r1) {
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static <T> boolean j(T r0, long r1) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(bx.f(r0, r1), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private static long k(int r2) {
        return r2 & 1048575;
    }

    private int l(int r2) {
        if (r2 >= this.e) goto L5;
        return -1;
    L5:
        if (r2 <= this.f) goto L7;
        return -1;
    L7:
        return b(r2, 0);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bl
    public int a(T r10) {
        int r0 = this.c.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L82;
        int r3 = e(r1);
        int r4 = d(r1);
        long r5 = k(r3);
        int r7 = 37;
        switch(g(r3)) {
            case 0: goto L77;
            case 1: goto L75;
            case 2: goto L74;
            case 3: goto L74;
            case 4: goto L73;
            case 5: goto L74;
            case 6: goto L73;
            case 7: goto L71;
            case 8: goto L70;
            case 9: goto L66;
            case 10: goto L64;
            case 11: goto L73;
            case 12: goto L73;
            case 13: goto L73;
            case 14: goto L74;
            case 15: goto L73;
            case 16: goto L74;
            case 17: goto L61;
            case 18: goto L64;
            case 19: goto L64;
            case 20: goto L64;
            case 21: goto L64;
            case 22: goto L64;
            case 23: goto L64;
            case 24: goto L64;
            case 25: goto L64;
            case 26: goto L64;
            case 27: goto L64;
            case 28: goto L64;
            case 29: goto L64;
            case 30: goto L64;
            case 31: goto L64;
            case 32: goto L64;
            case 33: goto L64;
            case 34: goto L64;
            case 35: goto L64;
            case 36: goto L64;
            case 37: goto L64;
            case 38: goto L64;
            case 39: goto L64;
            case 40: goto L64;
            case 41: goto L64;
            case 42: goto L64;
            case 43: goto L64;
            case 44: goto L64;
            case 45: goto L64;
            case 46: goto L64;
            case 47: goto L64;
            case 48: goto L64;
            case 49: goto L64;
            case 50: goto L64;
            case 51: goto L59;
            case 52: goto L56;
            case 53: goto L53;
            case 54: goto L50;
            case 55: goto L47;
            case 56: goto L44;
            case 57: goto L41;
            case 58: goto L38;
            case 59: goto L35;
            case 60: goto L32;
            case 61: goto L29;
            case 62: goto L26;
            case 63: goto L23;
            case 64: goto L20;
            case 65: goto L17;
            case 66: goto L14;
            case 67: goto L11;
            case 68: goto L8;
            default: goto L81;
        };
    L61:
        Object r6 = bx.f(r10, r5);
        if (r6 != null) goto L68;
    L69:
        r2 = (r2 * 53) + r7;
    L68:
        r7 = r6.hashCode();
    L64:
        int r8 = r2 * 53;
        Object r9 = bx.f(r10, r5);
    L65:
        int r11 = r9.hashCode();
    L80:
        r2 = r8 + r11;
        goto L81
    L66:
        r6 = bx.f(r10, r5);
        if (r6 == null) goto L69;
    L70:
        r8 = r2 * 53;
        r11 = ((String) ZeusTransformUtils.preCheckCast(bx.f(r10, r5), String.class, "com.obric.memorydata.plugin")).hashCode();
        goto L80
    L71:
        r8 = r2 * 53;
        boolean r12 = bx.c(r10, r5);
    L72:
        r11 = ab.a(r12);
        goto L80
    L73:
        r8 = r2 * 53;
        r11 = bx.a(r10, r5);
        goto L80
    L74:
        r8 = r2 * 53;
        long r13 = bx.b(r10, r5);
    L79:
        r11 = ab.a(r13);
        goto L80
    L75:
        r8 = r2 * 53;
        float r14 = bx.d(r10, r5);
    L76:
        r11 = Float.floatToIntBits(r14);
        goto L80
    L77:
        r8 = r2 * 53;
        double r15 = bx.e(r10, r5);
    L78:
        r13 = Double.doubleToLongBits(r15);
        goto L79
    L8:
        if (d(r10, r4, r1) == false) goto L81;
    L33:
        r9 = bx.f(r10, r5);
        r8 = r2 * 53;
        goto L65
    L11:
        if (d(r10, r4, r1) == false) goto L81;
    L54:
        r8 = r2 * 53;
        r13 = i(r10, r5);
        goto L79
    L14:
        if (d(r10, r4, r1) == false) goto L81;
    L48:
        r8 = r2 * 53;
        r11 = h(r10, r5);
        goto L80
    L17:
        if (d(r10, r4, r1) == false) goto L81;
    L20:
        if (d(r10, r4, r1) == false) goto L81;
    L23:
        if (d(r10, r4, r1) == false) goto L81;
    L26:
        if (d(r10, r4, r1) == false) goto L81;
    L29:
        if (d(r10, r4, r1) == false) goto L81;
    L32:
        if (d(r10, r4, r1) == false) goto L81;
    L35:
        if (d(r10, r4, r1) == false) goto L81;
    L38:
        if (d(r10, r4, r1) == false) goto L81;
        r8 = r2 * 53;
        r12 = j(r10, r5);
        goto L72
    L41:
        if (d(r10, r4, r1) == false) goto L81;
    L44:
        if (d(r10, r4, r1) == false) goto L81;
    L47:
        if (d(r10, r4, r1) == false) goto L81;
    L50:
        if (d(r10, r4, r1) == false) goto L81;
    L53:
        if (d(r10, r4, r1) == false) goto L81;
    L56:
        if (d(r10, r4, r1) == false) goto L81;
        r8 = r2 * 53;
        r14 = g(r10, r5);
        goto L76
    L59:
        if (d(r10, r4, r1) == false) goto L81;
        r8 = r2 * 53;
        r15 = f(r10, r5);
    L81:
        r1 = r1 + 3;
        goto L3
    L82:
        int r16 = (r2 * 53) + this.q.b(r10).hashCode();
        if (this.h == true) goto L85;
        return r16;
    L85:
        return (r16 * 53) + this.r.a(r10).hashCode();
    }

    int a(T r31, byte[] r32, int r33, int r34, int r35, g.a r36) {
        aw<T> r15 = this;
        r31 = r31;
        r32 = r32;
        r34 = r34;
        r35 = r35;
        g.a r9 = r36;
        g(r31);
        Unsafe r10 = f4966b;
        int r0 = r33;
        int r2 = 0;
        int r3 = 0;
        int r5 = 0;
        int r1 = -1;
        int r6 = 1048575;
    L4:
        if (r0 >= r34) goto L137;
        int r4 = r0 + 1;
        byte r7 = r32[r0];
        if (r7 >= 0) goto L8;
        int r8 = g.a(r7, r32, r4, r9);
        int r11 = r9.f5016a;
    L9:
        int r12 = r11 >>> 3;
        int r13 = r11 & 7;
        int r37 = r8;
        if (r12 <= r1) goto L12;
        int r14 = r15.a(r12, r2 / 3);
    L13:
        int r16 = r14;
        if (r16 == (-1)) goto L15;
        int r17 = r15.c[r16 + 1];
        int r18 = g(r17);
        int r21 = r11;
        long r19 = k(r17);
        if (r18 > 17) goto L95;
        int r110 = r15.c[r16 + 2];
        int r22 = 1 << (r110 >>> 20);
        int r111 = r110 & 1048575;
        if (r111 == r6) goto L26;
        if (r6 == 1048575) goto L22;
        r10.putInt(r31, r6, r5);
    L22:
        if (r111 != 1048575) goto L24;
        int r20 = 0;
    L25:
        int r112 = r111;
        int r113 = r20;
    L28:
        switch(r18) {
            case 0: goto L88;
            case 1: goto L84;
            case 2: goto L80;
            case 3: goto L80;
            case 4: goto L76;
            case 5: goto L73;
            case 6: goto L70;
            case 7: goto L63;
            case 8: goto L57;
            case 9: goto L53;
            case 10: goto L49;
            case 11: goto L76;
            case 12: goto L39;
            case 13: goto L70;
            case 14: goto L73;
            case 15: goto L36;
            case 16: goto L33;
            case 17: goto L31;
            default: goto L29;
        };
    L39:
        int r23 = r37;
        int r114 = r12;
        int r115 = r21;
        int r24 = r16;
        if (r13 != 0) goto L94;
        r0 = g.a(r32, r23, r9);
        int r25 = r9.f5016a;
        ab.e r26 = r15.c(r24);
        if (j(r17) == false) goto L48;
        if (r26 == null) goto L48;
        if (r26.a(r25) == true) goto L48;
        c(r31).a(r115, Long.valueOf(r25));
        r2 = r24;
        r5 = r113;
        r3 = r115;
        r6 = r112;
        r1 = r114;
        r34 = r34;
        r35 = r35;
    L48:
        r10.putInt(r31, r19, r25);
    L92:
        r5 = r113 | r22;
    L93:
        r2 = r24;
        r3 = r115;
        r6 = r112;
        r1 = r114;
    L107:
        r34 = r34;
    L94:
        int r27 = r35;
        int r28 = r23;
        int r29 = r24;
        Unsafe r210 = r10;
        int r30 = r115;
        String r211 = "com.obric.memorydata.plugin";
        int r212 = r112;
        int r116 = r113;
    L127:
        if (r30 != r27) goto L130;
        if (r27 == 0) goto L130;
        aw<T> r38 = this;
        int r117 = r27;
        int r39 = r28;
        r5 = r116;
    L138:
        int r40 = r212;
        if (r40 == 1048575) goto L141;
        T r41 = r31;
        r210.putInt(r41, r40, r5);
    L142:
        bu r42 = null;
        int r118 = r38.m;
    L144:
        if (r118 >= r38.n) goto L146;
        r42 = (bu) ZeusTransformUtils.preCheckCast(a(r31, r38.l[r118], r42, r38.q, r31), bu.class, r211);
        r118 = r118 + 1;
        goto L144
    L146:
        if (r42 == null) goto L149;
        r38.q.b(r41, r42);
    L149:
        if (r117 != 0) goto L154;
        if (r39 != r34) goto L153;
    L156:
        return r39;
    L153:
        throw InvalidProtocolBufferException.parseFailure();
    L154:
        if (r39 > r34) goto L158;
        if (r30 == r117) goto L156;
    L158:
        throw InvalidProtocolBufferException.parseFailure();
    L141:
        r41 = r31;
    L130:
        int r119 = r27;
        if (this.h == true) goto L133;
    L135:
        r0 = g.a(r30, r32, r28, r34, c(r31), r36);
    L136:
        r3 = r30;
        r15 = this;
        r9 = r36;
        r5 = r116;
        r1 = r114;
        r6 = r212;
        r2 = r29;
        r35 = r119;
    L114:
        r10 = r210;
        goto L4
    L133:
        if (r36.d == q.a()) goto L135;
        r0 = g.a(r30, r32, r28, r34, r31, this.g, this.q, r36);
    L29:
        r23 = r37;
        r114 = r12;
        r115 = r21;
        r24 = r16;
        goto L94
    L31:
        if (r13 != 3) goto L29;
        Object r43 = r15.a(r31, r16);
        int r44 = (r12 << 3) | 4;
        r115 = r21;
        r114 = r12;
        r24 = r16;
        r0 = g.a(r43, r15.a(r16), r32, r37, r34, r44, r36);
    L56:
        r15.a(r31, r24, r43);
        goto L92
    L33:
        r23 = r37;
        r114 = r12;
        r115 = r21;
        r24 = r16;
        if (r13 != 0) goto L94;
        int r45 = g.b(r32, r23, r9);
        long r46 = k.a(r9.f5017b);
        long r47 = r19;
    L83:
        r10.putLong(r31, r47, r46);
        r5 = r113 | r22;
        r0 = r45;
        goto L93
    L36:
        r23 = r37;
        r114 = r12;
        r115 = r21;
        r24 = r16;
        if (r13 != 0) goto L94;
        r0 = g.a(r32, r23, r9);
        int r48 = k.e(r9.f5016a);
    L79:
        r10.putInt(r31, r19, r48);
        goto L92
    L49:
        r23 = r37;
        r114 = r12;
        r115 = r21;
        long r49 = r19;
        r24 = r16;
        if (r13 != 2) goto L94;
        r0 = g.e(r32, r23, r9);
    L52:
        r10.putObject(r31, r49, r9.c);
        goto L92
    L53:
        r23 = r37;
        r114 = r12;
        r115 = r21;
        r24 = r16;
        if (r13 != 2) goto L94;
        r43 = r15.a(r31, r24);
        r0 = g.a(r43, r15.a(r24), r32, r23, r34, r36);
        goto L56
    L57:
        r23 = r37;
        r114 = r12;
        r115 = r21;
        r49 = r19;
        r24 = r16;
        if (r13 != 2) goto L94;
        if (i(r17) == false) goto L62;
        r0 = g.d(r32, r23, r9);
        goto L52
    L62:
        r0 = g.c(r32, r23, r9);
        goto L52
    L63:
        r23 = r37;
        r114 = r12;
        r115 = r21;
        r24 = r16;
        if (r13 != 0) goto L94;
        r0 = g.b(r32, r23, r9);
        if (r9.f5017b == 0) goto L68;
        boolean r50 = true;
    L69:
        bx.a(r31, r19, r50);
        goto L92
    L68:
        r50 = false;
        goto L69
    L70:
        r23 = r37;
        r114 = r12;
        r115 = r21;
        r24 = r16;
        if (r13 != 5) goto L94;
        r10.putInt(r31, r19, g.a(r32, r23));
    L87:
        r0 = r23 + 4;
        goto L92
    L73:
        r23 = r37;
        r114 = r12;
        r115 = r21;
        r24 = r16;
        if (r13 != 1) goto L94;
        r10.putLong(r31, r19, g.b(r32, r23));
    L91:
        r0 = r23 + 8;
        goto L92
    L76:
        r23 = r37;
        r114 = r12;
        r115 = r21;
        r24 = r16;
        if (r13 != 0) goto L94;
        r0 = g.a(r32, r23, r9);
        r48 = r9.f5016a;
        goto L79
    L80:
        r23 = r37;
        r114 = r12;
        r115 = r21;
        r24 = r16;
        if (r13 != 0) goto L94;
        r45 = g.b(r32, r23, r9);
        r47 = r19;
        r46 = r9.f5017b;
        goto L83
    L84:
        r23 = r37;
        r114 = r12;
        r115 = r21;
        r24 = r16;
        if (r13 != 5) goto L94;
        bx.a(r31, r19, g.d(r32, r23));
        goto L87
    L88:
        r23 = r37;
        r114 = r12;
        r115 = r21;
        r24 = r16;
        if (r13 != 1) goto L94;
        bx.a(r31, r19, g.c(r32, r23));
        goto L91
    L24:
        r20 = r10.getInt(r31, r111);
        goto L25
    L26:
        r113 = r5;
        r112 = r6;
        goto L28
    L95:
        r114 = r12;
        if (r18 != 27) goto L109;
        if (r13 != 2) goto L108;
        ab.i r51 = (ab.i) ZeusTransformUtils.preCheckCast(r10.getObject(r31, r19), ab.i.class, "com.obric.memorydata.plugin");
        if (r51.a() == true) goto L106;
        int r52 = r51.size();
        if (r52 != 0) goto L104;
        int r53 = 10;
    L105:
        r51 = r51.e(r53);
        r10.putObject(r31, r19, r51);
        goto L106
    L104:
        r53 = r52 * 2;
    L106:
        r0 = g.a(r15.a(r16), r21, r32, r37, r34, r51, r36);
        r35 = r35;
        r2 = r16;
        r3 = r21;
        r5 = r5;
        r1 = r114;
        r6 = r6;
        goto L107
    L108:
        r116 = r5;
        r212 = r6;
        r211 = "com.obric.memorydata.plugin";
        r29 = r16;
        r210 = r10;
        int r120 = r37;
        int r310 = r21;
    L122:
        r30 = r310;
        r27 = r35;
        r28 = r120;
        goto L127
    L109:
        r116 = r5;
        r212 = r6;
        if (r18 > 49) goto L115;
        r211 = "com.obric.memorydata.plugin";
        r29 = r16;
        r210 = r10;
        r310 = r21;
        r0 = a(r31, r32, r37, r34, r21, r114, r13, r29, r17, r18, r19, r36);
        if (r0 == r37) goto L126;
    L113:
        r15 = this;
        r3 = r310;
        r35 = r35;
        r9 = r36;
        r5 = r116;
        r1 = r114;
        r6 = r212;
        r2 = r29;
    L126:
        r30 = r310;
        r28 = r0;
        r27 = r35;
        goto L127
    L115:
        r211 = "com.obric.memorydata.plugin";
        r29 = r16;
        r210 = r10;
        r120 = r37;
        r310 = r21;
        if (r18 == 50) goto L118;
        r0 = a(r31, r32, r120, r34, r310, r114, r13, r17, r18, r19, r29, r36);
        if (r0 == r120) goto L126;
    L118:
        if (r13 != 2) goto L122;
        r0 = a(r31, r32, r120, r34, r29, r19, r36);
        if (r0 == r120) goto L126;
    L15:
        r28 = r37;
        r30 = r11;
        r211 = "com.obric.memorydata.plugin";
        r116 = r5;
        r212 = r6;
        r114 = r12;
        r210 = r10;
        r27 = r35;
        r29 = 0;
        goto L127
    L12:
        r14 = r15.l(r12);
        goto L13
    L8:
        r11 = r7;
        r8 = r4;
        goto L9
    L137:
        r211 = "com.obric.memorydata.plugin";
        r212 = r6;
        r210 = r10;
        r117 = r35;
        r38 = r15;
        r39 = r0;
        r30 = r3;
        goto L138
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bl
    public T a() {
        return (T) this.o.a(this.g);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bl
    public void a(T r3, Writer r4) {
        Writer r5 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r5.a() != Writer.FieldOrder.DESCENDING) goto L5;
        c(r3, r5);
        return;
    L5:
        b(r3, r5);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bl
    public void a(T r7, bk r8, q r9) {
        bk r4 = (bk) ZeusTransformUtils.wrapperContextForParams(r8, bk.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r9);
        g(r7);
        a(this.q, this.r, r7, r4, r9);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bl
    public void a(T r8, byte[] r9, int r10, int r11, g.a r12) {
        a(r8, r9, r10, r11, 0, r12);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bl
    public boolean a(T r5, T r6) {
        int r0 = this.c.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (a(r5, r6, r2) == false) goto L6;
        r2 = r2 + 3;
        goto L3
    L6:
        return false;
    L9:
        if (this.q.b(r5).equals(this.q.b(r6)) == true) goto L12;
        return false;
    L12:
        if (this.h == true) goto L14;
        return true;
    L14:
        return this.r.a(r5).equals(this.r.a(r6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v212 */
    /* JADX WARN: Type inference failed for: r0v214 */
    /* JADX WARN: Type inference failed for: r0v216 */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v24 */
    /* JADX WARN: Type inference failed for: r15v25 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v27 */
    /* JADX WARN: Type inference failed for: r15v28 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v114 */
    /* JADX WARN: Type inference failed for: r1v115 */
    /* JADX WARN: Type inference failed for: r1v117 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // com.google.crypto.tink.shaded.protobuf.bl
    public int b(T r20) {
        Unsafe r8 = f4966b;
        int r9 = 1048575;
        ?? r10 = 0;
        int r0 = 1048575;
        ?? r1 = 0;
        int r11 = 0;
        int r12 = 0;
    L4:
        if (r11 >= this.c.length) goto L231;
        int r2 = e(r11);
        int r3 = g(r2);
        int r13 = d(r11);
        int r4 = this.c[r11 + 2];
        int r5 = r4 & r9;
        int r6 = r0;
        ?? r7 = r1;
        if (r3 > 17) goto L13;
        if (r5 == r0) goto L12;
        if (r5 != r9) goto L10;
        ?? r14 = r10;
    L11:
        r7 = r14;
        r6 = r5 == true ? 1 : 0;
        goto L12
    L10:
        r14 = r8.getInt(r20, r5 == true ? 1 : 0);
    L12:
        int r15 = r6;
        ?? r16 = r7;
        ?? r17 = 1 << (r4 >>> 20);
    L14:
        long r18 = k(r2);
        if (r3 < FieldType.DOUBLE_LIST_PACKED.id()) goto L19;
        ?? r19 = r5;
        if (r3 > FieldType.SINT64_LIST_PACKED.id()) goto L19;
    L20:
        ?? r21 = r19;
        switch(r3) {
            case 0: goto L226;
            case 1: goto L223;
            case 2: goto L220;
            case 3: goto L217;
            case 4: goto L214;
            case 5: goto L211;
            case 6: goto L208;
            case 7: goto L203;
            case 8: goto L197;
            case 9: goto L192;
            case 10: goto L189;
            case 11: goto L186;
            case 12: goto L183;
            case 13: goto L180;
            case 14: goto L177;
            case 15: goto L174;
            case 16: goto L171;
            case 17: goto L168;
            case 18: goto L165;
            case 19: goto L164;
            case 20: goto L163;
            case 21: goto L162;
            case 22: goto L161;
            case 23: goto L165;
            case 24: goto L164;
            case 25: goto L160;
            case 26: goto L159;
            case 27: goto L158;
            case 28: goto L157;
            case 29: goto L156;
            case 30: goto L155;
            case 31: goto L164;
            case 32: goto L165;
            case 33: goto L154;
            case 34: goto L153;
            case 35: goto L147;
            case 36: goto L142;
            case 37: goto L137;
            case 38: goto L132;
            case 39: goto L127;
            case 40: goto L122;
            case 41: goto L117;
            case 42: goto L112;
            case 43: goto L107;
            case 44: goto L102;
            case 45: goto L97;
            case 46: goto L92;
            case 47: goto L87;
            case 48: goto L82;
            case 49: goto L81;
            case 50: goto L80;
            case 51: goto L78;
            case 52: goto L75;
            case 53: goto L72;
            case 54: goto L69;
            case 55: goto L66;
            case 56: goto L63;
            case 57: goto L60;
            case 58: goto L57;
            case 59: goto L51;
            case 60: goto L48;
            case 61: goto L45;
            case 62: goto L42;
            case 63: goto L39;
            case 64: goto L36;
            case 65: goto L33;
            case 66: goto L30;
            case 67: goto L27;
            case 68: goto L24;
            default: goto L167;
        };
    L80:
        int r22 = this.s.a(r13, r8.getObject(r20, r18), b(r11));
    L166:
        r12 = r12 + r22;
        goto L167
    L81:
        r22 = bn.b(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"), a(r11));
        goto L166
    L82:
        int r23 = bn.c((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.k == true) goto L151;
    L152:
        r22 = (CodedOutputStream.h(r13) + CodedOutputStream.j(r23)) + r23;
    L151:
        r8.putInt(r20, r21 == true ? 1 : 0, r23);
        goto L152
    L87:
        r23 = bn.g((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.k == false) goto L152;
    L92:
        r23 = bn.i((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.k == false) goto L152;
    L97:
        r23 = bn.h((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.k == false) goto L152;
    L102:
        r23 = bn.d((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.k == false) goto L152;
    L107:
        r23 = bn.f((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.k == false) goto L152;
    L112:
        r23 = bn.j((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.k == false) goto L152;
    L117:
        r23 = bn.h((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.k == false) goto L152;
    L122:
        r23 = bn.i((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.k == false) goto L152;
    L127:
        r23 = bn.e((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.k == false) goto L152;
    L132:
        r23 = bn.b((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.k == false) goto L152;
    L137:
        r23 = bn.a((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.k == false) goto L152;
    L142:
        r23 = bn.h((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.k == false) goto L152;
    L147:
        r23 = bn.i((List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        if (r23 <= 0) goto L167;
        if (this.k == false) goto L152;
    L153:
        r22 = bn.c(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"), r10);
        goto L166
    L154:
        r22 = bn.g(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"), r10);
        goto L166
    L155:
        r22 = bn.d(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"), r10);
        goto L166
    L156:
        r22 = bn.f(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"), r10);
        goto L166
    L157:
        r22 = bn.b(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        goto L166
    L158:
        r22 = bn.a(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"), a(r11));
        goto L166
    L159:
        r22 = bn.a(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"));
        goto L166
    L160:
        r22 = bn.j(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"), r10);
        goto L166
    L161:
        r22 = bn.e(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"), r10);
        goto L166
    L162:
        r22 = bn.b(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"), r10);
        goto L166
    L163:
        r22 = bn.a(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"), r10);
        goto L166
    L164:
        r22 = bn.h(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"), r10);
        goto L166
    L165:
        r22 = bn.i(r13, (List) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), List.class, "com.obric.memorydata.plugin"), r10);
        goto L166
    L168:
        int r110 = r11;
        if (a(r20, r11, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L207;
        int r24 = CodedOutputStream.d(r13, (at) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), at.class, "com.obric.memorydata.plugin"), a(r110));
    L206:
        r12 = r12 + r24;
    L207:
        ?? r111 = 0;
    L230:
        r11 = r110 + 3;
        r0 = r15;
        r10 = r111;
        r1 = r16;
        r9 = 1048575;
        goto L4
    L171:
        int r112 = r11;
        if (a(r20, r112, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L196;
        int r25 = CodedOutputStream.h(r13, r8.getLong(r20, r18));
    L195:
        r12 = r12 + r25;
    L196:
        r110 = r112;
        goto L207
    L174:
        r112 = r11;
        if (a(r20, r112, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L196;
        r25 = CodedOutputStream.j(r13, r8.getInt(r20, r18));
        goto L195
    L177:
        r112 = r11;
        if (a(r20, r112, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L196;
        r25 = CodedOutputStream.j(r13, 0);
        goto L195
    L180:
        r112 = r11;
        if (a(r20, r112, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L196;
        r12 = r12 + CodedOutputStream.l(r13, 0);
        goto L196
    L183:
        r112 = r11;
        if (a(r20, r112, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L196;
        r25 = CodedOutputStream.m(r13, r8.getInt(r20, r18));
        goto L195
    L186:
        r112 = r11;
        if (a(r20, r112, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L196;
        r25 = CodedOutputStream.i(r13, r8.getInt(r20, r18));
        goto L195
    L189:
        r112 = r11;
        if (a(r20, r112, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L196;
        r25 = CodedOutputStream.c(r13, (ByteString) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), ByteString.class, "com.obric.memorydata.plugin"));
        goto L195
    L192:
        r112 = r11;
        if (a(r20, r112, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L196;
        r25 = bn.a(r13, r8.getObject(r20, r18), a(r112));
        goto L195
    L197:
        r112 = r11;
        if (a(r20, r112, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L196;
        Object r26 = r8.getObject(r20, r18);
        if (ZeusTransformUtils.instanceOf(r26, ByteString.class) == false) goto L202;
        r25 = CodedOutputStream.c(r13, (ByteString) ZeusTransformUtils.preCheckCast(r26, ByteString.class, "com.obric.memorydata.plugin"));
        goto L195
    L202:
        r25 = CodedOutputStream.b(r13, (String) ZeusTransformUtils.preCheckCast(r26, String.class, "com.obric.memorydata.plugin"));
        goto L195
    L203:
        r110 = r11;
        if (a(r20, r110, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L207;
        r24 = CodedOutputStream.b(r13, true);
        goto L206
    L208:
        r110 = r11;
        if (a(r20, r110, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L207;
        r111 = 0;
        int r27 = CodedOutputStream.k(r13, 0);
    L229:
        r12 = r12 + r27;
        goto L230
    L211:
        r111 = r10;
        r110 = r11;
        if (a(r20, r110, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L230;
        r27 = CodedOutputStream.i(r13, 0);
        r111 = r111;
        goto L229
    L214:
        r111 = r10;
        r110 = r11;
        if (a(r20, r110, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L230;
        r27 = CodedOutputStream.h(r13, r8.getInt(r20, r18));
        r111 = r111;
        goto L229
    L217:
        r111 = r10;
        r110 = r11;
        if (a(r20, r110, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L230;
        r27 = CodedOutputStream.g(r13, r8.getLong(r20, r18));
        r111 = r111;
        goto L229
    L220:
        r111 = r10;
        r110 = r11;
        if (a(r20, r110, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L230;
        r27 = CodedOutputStream.f(r13, r8.getLong(r20, r18));
        r111 = r111;
        goto L229
    L223:
        r111 = r10;
        r110 = r11;
        if (a(r20, r110, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L230;
        r27 = CodedOutputStream.b(r13, 0.0f);
        r111 = r111;
        goto L229
    L226:
        r111 = r10;
        r110 = r11;
        if (a(r20, r110, r15 == true ? 1 : 0, r16 == true ? 1 : 0, r17 == true ? 1 : 0) == false) goto L230;
        r27 = CodedOutputStream.b(r13, 0.0d);
        r111 = r111;
    L167:
        r111 = r10;
        r110 = r11;
        goto L230
    L24:
        if (d(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.d(r13, (at) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), at.class, "com.obric.memorydata.plugin"), a(r11));
        goto L166
    L27:
        if (d(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.h(r13, i(r20, r18));
        goto L166
    L30:
        if (d(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.j(r13, h(r20, r18));
        goto L166
    L33:
        if (d(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.j(r13, 0);
        goto L166
    L36:
        if (d(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.l(r13, r10);
        goto L166
    L39:
        if (d(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.m(r13, h(r20, r18));
        goto L166
    L42:
        if (d(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.i(r13, h(r20, r18));
        goto L166
    L45:
        if (d(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.c(r13, (ByteString) ZeusTransformUtils.preCheckCast(r8.getObject(r20, r18), ByteString.class, "com.obric.memorydata.plugin"));
        goto L166
    L48:
        if (d(r20, r13, r11) == false) goto L167;
        r22 = bn.a(r13, r8.getObject(r20, r18), a(r11));
        goto L166
    L51:
        if (d(r20, r13, r11) == false) goto L167;
        Object r28 = r8.getObject(r20, r18);
        if (ZeusTransformUtils.instanceOf(r28, ByteString.class) == false) goto L55;
        r22 = CodedOutputStream.c(r13, (ByteString) ZeusTransformUtils.preCheckCast(r28, ByteString.class, "com.obric.memorydata.plugin"));
        goto L166
    L55:
        r22 = CodedOutputStream.b(r13, (String) ZeusTransformUtils.preCheckCast(r28, String.class, "com.obric.memorydata.plugin"));
        goto L166
    L57:
        if (d(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.b(r13, true);
        goto L166
    L60:
        if (d(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.k(r13, r10);
        goto L166
    L63:
        if (d(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.i(r13, 0);
        goto L166
    L66:
        if (d(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.h(r13, h(r20, r18));
        goto L166
    L69:
        if (d(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.g(r13, i(r20, r18));
        goto L166
    L72:
        if (d(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.f(r13, i(r20, r18));
        goto L166
    L75:
        if (d(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.b(r13, 0.0f);
        goto L166
    L78:
        if (d(r20, r13, r11) == false) goto L167;
        r22 = CodedOutputStream.b(r13, 0.0d);
    L19:
        r19 = r10;
        goto L20
    L13:
        r15 = r0 == true ? 1 : 0;
        r16 = r1 == true ? 1 : 0;
        r17 = r10;
        goto L14
    L231:
        int r113 = r12 + a(this.q, r20);
        if (this.h == true) goto L234;
        return r113;
    L234:
        return r113 + this.r.a(r20).j();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bl
    public void b(T r3, T r4) {
        g(r3);
        Objects.requireNonNull(r4);
        int r0 = 0;
    L4:
        if (r0 >= this.c.length) goto L6;
        b(r3, r4, r0);
        r0 = r0 + 3;
        goto L4
    L6:
        bn.a(this.q, r3, r4);
        if (this.h == false) goto L11;
        bn.a(this.r, r3, r4);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.crypto.tink.shaded.protobuf.bl
    public void d(T r8) {
        if (f(r8) == true) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r8, GeneratedMessageLite.class) == false) goto L8;
        GeneratedMessageLite r0 = (GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r8, GeneratedMessageLite.class, "com.obric.memorydata.plugin");
        r0.clearMemoizedSerializedSize();
        r0.clearMemoizedHashCode();
        r0.markImmutable();
    L8:
        int r1 = this.c.length;
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L29;
        int r3 = e(r2);
        long r4 = k(r3);
        int r5 = g(r3);
        if (r5 == 9) goto L26;
        if (r5 == 60) goto L23;
        if (r5 == 68) goto L23;
        switch(r5) {
            case 17: goto L26;
            case 18: goto L21;
            case 19: goto L21;
            case 20: goto L21;
            case 21: goto L21;
            case 22: goto L21;
            case 23: goto L21;
            case 24: goto L21;
            case 25: goto L21;
            case 26: goto L21;
            case 27: goto L21;
            case 28: goto L21;
            case 29: goto L21;
            case 30: goto L21;
            case 31: goto L21;
            case 32: goto L21;
            case 33: goto L21;
            case 34: goto L21;
            case 35: goto L21;
            case 36: goto L21;
            case 37: goto L21;
            case 38: goto L21;
            case 39: goto L21;
            case 40: goto L21;
            case 41: goto L21;
            case 42: goto L21;
            case 43: goto L21;
            case 44: goto L21;
            case 45: goto L21;
            case 46: goto L21;
            case 47: goto L21;
            case 48: goto L21;
            case 49: goto L21;
            case 50: goto L18;
            default: goto L28;
        };
    L18:
        Unsafe r6 = f4966b;
        Object r7 = r6.getObject(r8, r4);
        if (r7 == null) goto L28;
        r6.putObject(r8, r4, this.s.d(r7));
        goto L28
    L21:
        this.p.b(r8, r4);
    L28:
        r2 = r2 + 3;
    L23:
        if (d(r8, d(r2), r2) == false) goto L28;
    L27:
        a(r2).d(f4966b.getObject(r8, r4));
    L26:
        if (b(r8, r2) == false) goto L28;
    L29:
        this.q.d(r8);
        if (this.h == false) goto L41;
        this.r.c(r8);
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.bl
    public final boolean e(T r18) {
        int r0 = 1048575;
        int r1 = 0;
        int r10 = 0;
    L4:
        if (r10 >= this.m) goto L49;
        int r11 = this.l[r10];
        int r12 = d(r11);
        int r13 = e(r11);
        int r2 = this.c[r11 + 2];
        int r4 = r2 & 1048575;
        int r14 = 1 << (r2 >>> 20);
        if (r4 == r0) goto L10;
        if (r4 == 1048575) goto L9;
        r1 = f4966b.getInt(r18, r4);
    L9:
        int r16 = r1;
        int r15 = r4;
    L12:
        if (h(r13) == true) goto L14;
    L16:
        int r3 = g(r13);
        if (r3 == 9) goto L43;
        if (r3 == 17) goto L43;
        if (r3 == 27) goto L40;
        if (r3 == 60) goto L35;
        if (r3 == 68) goto L35;
        if (r3 == 49) goto L40;
        if (r3 != 50) goto L47;
        if (c(r18, r13, r11) == true) goto L47;
        return false;
    L47:
        r10 = r10 + 1;
        r0 = r15;
        r1 = r16;
    L35:
        if (d(r18, r12, r11) == false) goto L47;
        if (a(r18, r13, a(r11)) == true) goto L47;
        return false;
    L40:
        if (b(r18, r13, r11) == true) goto L47;
        return false;
    L43:
        if (a(r18, r11, r15, r16, r14) == false) goto L47;
        if (a(r18, r13, a(r11)) == true) goto L47;
        return false;
    L14:
        if (a(r18, r11, r15, r16, r14) == true) goto L16;
        return false;
    L10:
        r15 = r0;
        r16 = r1;
        goto L12
    L49:
        if (this.h == true) goto L51;
    L53:
        return true;
    L51:
        if (this.r.a(r18).i() == true) goto L53;
        return false;
    }
}
