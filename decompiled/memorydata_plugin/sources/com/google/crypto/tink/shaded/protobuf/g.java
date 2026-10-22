package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
final class g {

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.g$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5015a = null;

        static {
            int[] r0 = new int[WireFormat.FieldType.values().length];
            f5015a = r0;
            r0[WireFormat.FieldType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L62:
            f5015a[WireFormat.FieldType.FLOAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L46:
            f5015a[WireFormat.FieldType.INT64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L58:
            f5015a[WireFormat.FieldType.UINT64.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L64:
            f5015a[WireFormat.FieldType.INT32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L48:
            f5015a[WireFormat.FieldType.UINT32.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L52:
            f5015a[WireFormat.FieldType.FIXED64.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L74:
            f5015a[WireFormat.FieldType.SFIXED64.ordinal()] = 8;     // Catch: NoSuchFieldError -> L29
        L42:
            f5015a[WireFormat.FieldType.FIXED32.ordinal()] = 9;     // Catch: NoSuchFieldError -> L30
        L68:
            f5015a[WireFormat.FieldType.SFIXED32.ordinal()] = 10;     // Catch: NoSuchFieldError -> L31
        L70:
            f5015a[WireFormat.FieldType.BOOL.ordinal()] = 11;     // Catch: NoSuchFieldError -> L32
        L54:
            f5015a[WireFormat.FieldType.SINT32.ordinal()] = 12;     // Catch: NoSuchFieldError -> L33
        L60:
            f5015a[WireFormat.FieldType.SINT64.ordinal()] = 13;     // Catch: NoSuchFieldError -> L34
        L44:
            f5015a[WireFormat.FieldType.ENUM.ordinal()] = 14;     // Catch: NoSuchFieldError -> L35
        L50:
            f5015a[WireFormat.FieldType.BYTES.ordinal()] = 15;     // Catch: NoSuchFieldError -> L36
        L72:
            f5015a[WireFormat.FieldType.STRING.ordinal()] = 16;     // Catch: NoSuchFieldError -> L37
        L40:
            f5015a[WireFormat.FieldType.GROUP.ordinal()] = 17;     // Catch: NoSuchFieldError -> L38
        L66:
            f5015a[WireFormat.FieldType.MESSAGE.ordinal()] = 18;     // Catch: NoSuchFieldError -> L39
            return;
        }
    }

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f5017b;
        public Object c;
        public final q d;

        a() {
            this.d = q.a();
        }

        a(q r1) {
            Objects.requireNonNull(r1);
            this.d = r1;
        }
    }

    static int a(int r8, byte[] r9, int r10, int r11, GeneratedMessageLite.c<?, ?> r12, GeneratedMessageLite.e<?, ?> r13, bt<bu, bu> r14, a r15) {
        w<GeneratedMessageLite.d> r0 = r12.extensions;
        int r2 = r8 >>> 3;
        if (r13.d.d() == true) goto L5;
    L21:
        Object r3 = null;
        if (r13.d() != WireFormat.FieldType.ENUM) goto L28;
        r10 = a(r9, r10, r15);
        if (r13.d.f().b(r15.f5016a) != null) goto L61;
        bn.a(r12, r2, r15.f5016a, null, r14);
        return r10;
    L61:
        int r16 = r15.f5016a;
    L62:
        r3 = Integer.valueOf(r16);
    L70:
        if (r13.e() == false) goto L72;
        r0.b(r13.d, r3);
    L74:
        return r10;
    L72:
        r0.a(r13.d, r3);
        goto L74
    L28:
        switch(AnonymousClass1.f5015a[r13.d().ordinal()]) {
            case 1: goto L67;
            case 2: goto L65;
            case 3: goto L63;
            case 4: goto L63;
            case 5: goto L60;
            case 6: goto L60;
            case 7: goto L59;
            case 8: goto L59;
            case 9: goto L58;
            case 10: goto L58;
            case 11: goto L53;
            case 12: goto L52;
            case 13: goto L51;
            case 14: goto L50;
            case 15: goto L47;
            case 16: goto L46;
            case 17: goto L38;
            case 18: goto L30;
            default: goto L70;
        };
    L30:
        bl r4 = bg.a().a(r13.c().getClass());
        if (r13.e() == false) goto L33;
        int r17 = a(r4, r9, r10, r11, r15);
        r0.b(r13.d, r15.c);
        return r17;
    L33:
        Object r18 = r0.a(r13.d);
        if (r18 != null) goto L37;
        r18 = r4.a();
        r0.a(r13.d, r18);
    L37:
        return a(r18, r4, r9, r10, r11, r15);
    L38:
        int r6 = (r2 << 3) | 4;
        bl r5 = bg.a().a(r13.c().getClass());
        if (r13.e() == false) goto L41;
        int r19 = a(r5, r9, r10, r11, r6, r15);
        r0.b(r13.d, r15.c);
        return r19;
    L41:
        Object r20 = r0.a(r13.d);
        if (r20 != null) goto L45;
        r20 = r5.a();
        r0.a(r13.d, r20);
    L45:
        return a(r20, r5, r9, r10, r11, r6, r15);
    L46:
        r10 = c(r9, r10, r15);
    L48:
        r3 = r15.c;
        goto L70
    L47:
        r10 = e(r9, r10, r15);
        goto L48
    L51:
        r10 = b(r9, r10, r15);
        long r21 = k.a(r15.f5017b);
    L64:
        r3 = Long.valueOf(r21);
        goto L70
    L52:
        r10 = a(r9, r10, r15);
        r16 = k.e(r15.f5016a);
        goto L62
    L53:
        r10 = b(r9, r10, r15);
        if (r15.f5017b == 0) goto L56;
        boolean r22 = true;
    L57:
        r3 = Boolean.valueOf(r22);
        goto L70
    L56:
        r22 = false;
        goto L57
    L58:
        r3 = Integer.valueOf(a(r9, r10));
    L66:
        r10 = r10 + 4;
        goto L70
    L59:
        r3 = Long.valueOf(b(r9, r10));
    L68:
        r10 = r10 + 8;
        goto L70
    L60:
        r10 = a(r9, r10, r15);
        goto L61
    L63:
        r10 = b(r9, r10, r15);
        r21 = r15.f5017b;
        goto L64
    L65:
        r3 = Float.valueOf(d(r9, r10));
        goto L66
    L67:
        r3 = Double.valueOf(c(r9, r10));
        goto L68
    L50:
        throw new IllegalStateException("Shouldn't reach here.");
    L5:
        if (r13.d.e() == false) goto L21;
        switch(AnonymousClass1.f5015a[r13.d().ordinal()]) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L15;
            case 9: goto L14;
            case 10: goto L14;
            case 11: goto L13;
            case 12: goto L12;
            case 13: goto L11;
            case 14: goto L10;
            default: goto L9;
        };
    L10:
        ab.i r23 = new aa();
        int r24 = a(r9, r10, r23, r15);
        bn.a(r12, r2, r23, r13.d.f(), null, r14);
    L20:
        r0.a(r13.d, r23);
        return r24;
    L11:
        r23 = new al();
        r24 = i(r9, r10, r23, r15);
        goto L20
    L12:
        r23 = new aa();
        r24 = h(r9, r10, r23, r15);
        goto L20
    L13:
        r23 = new h();
        r24 = g(r9, r10, r23, r15);
        goto L20
    L14:
        r23 = new aa();
        r24 = c(r9, r10, r23, r15);
        goto L20
    L15:
        r23 = new al();
        r24 = d(r9, r10, r23, r15);
        goto L20
    L16:
        r23 = new aa();
        r24 = a(r9, r10, r23, r15);
        goto L20
    L17:
        r23 = new al();
        r24 = b(r9, r10, r23, r15);
        goto L20
    L18:
        r23 = new x();
        r24 = e(r9, r10, r23, r15);
        goto L20
    L19:
        r23 = new n();
        r24 = f(r9, r10, r23, r15);
        goto L20
    L9:
        throw new IllegalStateException("Type cannot be packed: " + r13.d.b());
    }

    static int a(int r2, byte[] r3, int r4, int r5, ab.i<?> r6, a r7) {
        aa r8 = (aa) ZeusTransformUtils.preCheckCast((ab.i) ZeusTransformUtils.wrapperContextForParams(r6, ab.i.class, "com.obric.memorydata.plugin"), aa.class, "com.obric.memorydata.plugin");
        int r9 = a(r3, r4, r7);
    L3:
        r8.d(r7.f5016a);
        if (r9 >= r5) goto L9;
        int r0 = a(r3, r9, r7);
        if (r2 != r7.f5016a) goto L9;
        r9 = a(r3, r0, r7);
    L9:
        return r9;
    }

    static int a(int r9, byte[] r10, int r11, int r12, bu r13, a r14) {
        if (WireFormat.b(r9) == 0) goto L48;
        int r0 = WireFormat.a(r9);
        if (r0 != 0) goto L7;
        int r15 = b(r10, r11, r14);
        r13.a(r9, Long.valueOf(r14.f5017b));
        return r15;
    L7:
        if (r0 != 1) goto L9;
        r13.a(r9, Long.valueOf(b(r10, r11)));
        return r11 + 8;
    L9:
        if (r0 != 2) goto L11;
        int r16 = a(r10, r11, r14);
        int r17 = r14.f5016a;
        if (r17 < 0) goto L42;
        if (r17 > (r10.length - r16)) goto L40;
        if (r17 != 0) goto L36;
        Object r18 = ByteString.EMPTY;
    L37:
        r13.a(r9, r18);
        return r16 + r17;
    L36:
        r18 = ByteString.copyFrom(r10, r16, r17);
        goto L37
    L40:
        throw InvalidProtocolBufferException.truncatedMessage();
    L42:
        throw InvalidProtocolBufferException.negativeSize();
    L11:
        if (r0 != 3) goto L13;
        bu r6 = bu.b();
        int r7 = (r9 & (-8)) | 4;
        int r1 = 0;
    L19:
        if (r11 >= r12) goto L24;
        int r2 = a(r10, r11, r14);
        int r19 = r14.f5016a;
        r1 = r19;
        if (r19 == r7) goto L22;
        int r3 = a(r1, r10, r2, r12, r6, r14);
        r1 = r19;
        r11 = r3;
        goto L19
    L22:
        r11 = r2;
    L24:
        if (r11 > r12) goto L29;
        if (r1 != r7) goto L29;
        r13.a(r9, r6);
        return r11;
    L29:
        throw InvalidProtocolBufferException.parseFailure();
    L13:
        if (r0 != 5) goto L17;
        r13.a(r9, Integer.valueOf(a(r10, r11)));
        return r11 + 4;
    L17:
        throw InvalidProtocolBufferException.invalidTag();
    L48:
        throw InvalidProtocolBufferException.invalidTag();
    }

    static int a(int r2, byte[] r3, int r4, int r5, a r6) {
        if (WireFormat.b(r2) == 0) goto L36;
        int r0 = WireFormat.a(r2);
        if (r0 == 0) goto L34;
        if (r0 == 1) goto L32;
        if (r0 == 2) goto L30;
        if (r0 != 3) goto L13;
        int r7 = (r2 & (-8)) | 4;
        int r1 = 0;
    L19:
        if (r4 >= r5) goto L24;
        r4 = a(r3, r4, r6);
        r1 = r6.f5016a;
        if (r1 == r7) goto L24;
        r4 = a(r1, r3, r4, r5, r6);
    L24:
        if (r4 > r5) goto L28;
        if (r1 != r7) goto L28;
        return r4;
    L28:
        throw InvalidProtocolBufferException.parseFailure();
    L13:
        if (r0 != 5) goto L17;
        return r4 + 4;
    L17:
        throw InvalidProtocolBufferException.invalidTag();
    L30:
        return a(r3, r4, r6) + r6.f5016a;
    L32:
        return r4 + 8;
    L34:
        return b(r3, r4, r6);
    L36:
        throw InvalidProtocolBufferException.invalidTag();
    }

    static int a(int r11, byte[] r12, int r13, int r14, Object r15, at r16, bt<bu, bu> r17, a r18) {
        q r4 = r18.d;
        GeneratedMessageLite.e r8 = r4.a((at) ZeusTransformUtils.wrapperContextForParams(r16, at.class, "com.obric.memorydata.plugin"), r11 >>> 3);
        if (r8 == null) goto L5;
        ((GeneratedMessageLite.c) ZeusTransformUtils.preCheckCast(r15, GeneratedMessageLite.c.class, "com.obric.memorydata.plugin")).a();
        return a(r11, r12, r13, r14, (GeneratedMessageLite.c) ZeusTransformUtils.preCheckCast(r15, GeneratedMessageLite.c.class, "com.obric.memorydata.plugin"), r8, r17, r18);
    L5:
        return a(r11, r12, r13, r14, aw.c(r15), r18);
    }

    static int a(int r1, byte[] r2, int r3, a r4) {
        int r5 = r1 & 127;
        int r0 = r3 + 1;
        byte r6 = r2[r3];
        if (r6 < 0) goto L7;
        int r7 = r6 << 7;
    L5:
        r4.f5016a = r5 | r7;
        return r0;
    L7:
        int r8 = r5 | ((r6 & ByteCompanionObject.MAX_VALUE) << 7);
        int r9 = r0 + 1;
        byte r10 = r2[r0];
        if (r10 < 0) goto L12;
        int r11 = r10 << 14;
    L10:
        r4.f5016a = r8 | r11;
        return r9;
    L12:
        r5 = r8 | ((r10 & ByteCompanionObject.MAX_VALUE) << 14);
        r0 = r9 + 1;
        byte r12 = r2[r9];
        if (r12 < 0) goto L15;
        r7 = r12 << 21;
        goto L5
    L15:
        r8 = r5 | ((r12 & ByteCompanionObject.MAX_VALUE) << 21);
        r9 = r0 + 1;
        byte r13 = r2[r0];
        if (r13 < 0) goto L18;
        r11 = r13 << 28;
        goto L10
    L18:
        int r14 = r8 | ((r13 & ByteCompanionObject.MAX_VALUE) << 28);
    L19:
        int r15 = r9 + 1;
        if (r2[r9] >= 0) goto L22;
        r9 = r15;
        goto L19
    L22:
        r4.f5016a = r14;
        return r15;
    }

    static int a(long r7, byte[] r9, int r10, a r11) {
        int r0 = r10 + 1;
        byte r12 = r9[r10];
        long r8 = (r7 & 127) | (((long) (r12 & ByteCompanionObject.MAX_VALUE)) << 7);
        int r1 = 7;
    L3:
        if (r12 >= 0) goto L5;
        int r13 = r0 + 1;
        byte r2 = r9[r0];
        r1 = r1 + 7;
        r8 = r8 | (((long) (r2 & ByteCompanionObject.MAX_VALUE)) << r1);
        r0 = r13;
        r12 = r2;
        goto L3
    L5:
        r11.f5017b = r8;
        return r0;
    }

    static int a(bl<?> r2, int r3, byte[] r4, int r5, int r6, ab.i<?> r7, a r8) {
        bl r9 = (bl) ZeusTransformUtils.wrapperContextForParams(r2, bl.class, "com.obric.memorydata.plugin");
        ab.i r10 = (ab.i) ZeusTransformUtils.wrapperContextForParams(r7, ab.i.class, "com.obric.memorydata.plugin");
        int r11 = a(r9, r4, r5, r6, r8);
    L3:
        r10.add(r8.c);
        if (r11 >= r6) goto L9;
        int r0 = a(r4, r11, r8);
        if (r3 != r8.f5016a) goto L9;
        r11 = a(r9, r4, r0, r6, r8);
    L9:
        return r11;
    }

    static int a(bl r8, byte[] r9, int r10, int r11, int r12, a r13) {
        bl r14 = (bl) ZeusTransformUtils.wrapperContextForParams(r8, bl.class, "com.obric.memorydata.plugin");
        Object r7 = r14.a();
        int r15 = a(r7, r14, r9, r10, r11, r12, r13);
        r14.d(r7);
        r13.c = r7;
        return r15;
    }

    static int a(bl r7, byte[] r8, int r9, int r10, a r11) {
        bl r12 = (bl) ZeusTransformUtils.wrapperContextForParams(r7, bl.class, "com.obric.memorydata.plugin");
        Object r6 = r12.a();
        int r13 = a(r6, r12, r8, r9, r10, r11);
        r12.d(r6);
        r11.c = r6;
        return r13;
    }

    static int a(Object r7, bl r8, byte[] r9, int r10, int r11, int r12, a r13) {
        int r14 = ((aw) ZeusTransformUtils.preCheckCast((bl) ZeusTransformUtils.wrapperContextForParams(r8, bl.class, "com.obric.memorydata.plugin"), aw.class, "com.obric.memorydata.plugin")).a(r7, r9, r10, r11, r12, r13);
        r13.c = r7;
        return r14;
    }

    static int a(Object r6, bl r7, byte[] r8, int r9, int r10, a r11) {
        bl r0 = (bl) ZeusTransformUtils.wrapperContextForParams(r7, bl.class, "com.obric.memorydata.plugin");
        int r12 = r9 + 1;
        int r13 = r8[r9];
        if (r13 >= 0) goto L5;
        r12 = a(r13, r8, r12, r11);
        r13 = r11.f5016a;
    L5:
        int r3 = r12;
        if (r13 < 0) goto L12;
        if (r13 > (r10 - r3)) goto L12;
        int r14 = r13 + r3;
        r0.a(r6, r8, r3, r14, r11);
        r11.c = r6;
        return r14;
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int a(byte[] r2, int r3) {
        int r0 = ((r2[r3] & 255) | ((r2[r3 + 1] & 255) << 8)) | ((r2[r3 + 2] & 255) << 16);
        return ((r2[r3 + 3] & 255) << 24) | r0;
    }

    static int a(byte[] r2, int r3, ab.i<?> r4, a r5) {
        aa r6 = (aa) ZeusTransformUtils.preCheckCast((ab.i) ZeusTransformUtils.wrapperContextForParams(r4, ab.i.class, "com.obric.memorydata.plugin"), aa.class, "com.obric.memorydata.plugin");
        int r7 = a(r2, r3, r5);
        int r0 = r5.f5016a + r7;
    L3:
        if (r7 >= r0) goto L5;
        r7 = a(r2, r7, r5);
        r6.d(r5.f5016a);
        goto L3
    L5:
        if (r7 != r0) goto L8;
        return r7;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int a(byte[] r1, int r2, a r3) {
        int r0 = r2 + 1;
        byte r4 = r1[r2];
        if (r4 < 0) goto L7;
        r3.f5016a = r4;
        return r0;
    L7:
        return a(r4, r1, r0, r3);
    }

    static int b(int r2, byte[] r3, int r4, int r5, ab.i<?> r6, a r7) {
        al r8 = (al) ZeusTransformUtils.preCheckCast((ab.i) ZeusTransformUtils.wrapperContextForParams(r6, ab.i.class, "com.obric.memorydata.plugin"), al.class, "com.obric.memorydata.plugin");
        int r9 = b(r3, r4, r7);
    L3:
        r8.a(r7.f5017b);
        if (r9 >= r5) goto L9;
        int r0 = a(r3, r9, r7);
        if (r2 != r7.f5016a) goto L9;
        r9 = b(r3, r0, r7);
    L9:
        return r9;
    }

    static int b(bl r8, int r9, byte[] r10, int r11, int r12, ab.i<?> r13, a r14) {
        bl r15 = (bl) ZeusTransformUtils.wrapperContextForParams(r8, bl.class, "com.obric.memorydata.plugin");
        ab.i r16 = (ab.i) ZeusTransformUtils.wrapperContextForParams(r13, ab.i.class, "com.obric.memorydata.plugin");
        int r0 = (r9 & (-8)) | 4;
        int r17 = a(r15, r10, r11, r12, r0, r14);
    L3:
        r16.add(r14.c);
        if (r17 >= r12) goto L9;
        int r4 = a(r10, r17, r14);
        if (r9 != r14.f5016a) goto L9;
        r17 = a(r15, r10, r4, r12, r0, r14);
    L9:
        return r17;
    }

    static int b(byte[] r3, int r4, ab.i<?> r5, a r6) {
        al r7 = (al) ZeusTransformUtils.preCheckCast((ab.i) ZeusTransformUtils.wrapperContextForParams(r5, ab.i.class, "com.obric.memorydata.plugin"), al.class, "com.obric.memorydata.plugin");
        int r8 = a(r3, r4, r6);
        int r0 = r6.f5016a + r8;
    L3:
        if (r8 >= r0) goto L5;
        r8 = b(r3, r8, r6);
        r7.a(r6.f5017b);
        goto L3
    L5:
        if (r8 != r0) goto L8;
        return r8;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int b(byte[] r5, int r6, a r7) {
        int r0 = r6 + 1;
        long r1 = r5[r6];
        if (r1 < 0) goto L7;
        r7.f5017b = r1;
        return r0;
    L7:
        return a(r1, r5, r0, r7);
    }

    static long b(byte[] r7, int r8) {
        long r0 = ((((((((long) r7[r8]) & 255) | ((((long) r7[r8 + 1]) & 255) << 8)) | ((((long) r7[r8 + 2]) & 255) << 16)) | ((((long) r7[r8 + 3]) & 255) << 24)) | ((((long) r7[r8 + 4]) & 255) << 32)) | ((((long) r7[r8 + 5]) & 255) << 40)) | ((((long) r7[r8 + 6]) & 255) << 48);
        return ((((long) r7[r8 + 7]) & 255) << 56) | r0;
    }

    static double c(byte[] r0, int r1) {
        return Double.longBitsToDouble(b(r0, r1));
    }

    static int c(int r2, byte[] r3, int r4, int r5, ab.i<?> r6, a r7) {
        aa r8 = (aa) ZeusTransformUtils.preCheckCast((ab.i) ZeusTransformUtils.wrapperContextForParams(r6, ab.i.class, "com.obric.memorydata.plugin"), aa.class, "com.obric.memorydata.plugin");
        r8.d(a(r3, r4));
        int r9 = r4 + 4;
    L3:
        if (r9 >= r5) goto L8;
        int r0 = a(r3, r9, r7);
        if (r2 != r7.f5016a) goto L8;
        r8.d(a(r3, r0));
        r9 = r0 + 4;
    L8:
        return r9;
    }

    static int c(byte[] r2, int r3, ab.i<?> r4, a r5) {
        aa r6 = (aa) ZeusTransformUtils.preCheckCast((ab.i) ZeusTransformUtils.wrapperContextForParams(r4, ab.i.class, "com.obric.memorydata.plugin"), aa.class, "com.obric.memorydata.plugin");
        int r7 = a(r2, r3, r5);
        int r8 = r5.f5016a + r7;
    L3:
        if (r7 >= r8) goto L5;
        r6.d(a(r2, r7));
        r7 = r7 + 4;
        goto L3
    L5:
        if (r7 != r8) goto L8;
        return r7;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int c(byte[] r3, int r4, a r5) {
        int r6 = a(r3, r4, r5);
        int r0 = r5.f5016a;
        if (r0 < 0) goto L10;
        if (r0 != 0) goto L7;
        r5.c = "";
        return r6;
    L7:
        r5.c = new String(r3, r6, r0, ab.f4938b);
        return r6 + r0;
    L10:
        throw InvalidProtocolBufferException.negativeSize();
    }

    static float d(byte[] r0, int r1) {
        return Float.intBitsToFloat(a(r0, r1));
    }

    static int d(int r3, byte[] r4, int r5, int r6, ab.i<?> r7, a r8) {
        al r9 = (al) ZeusTransformUtils.preCheckCast((ab.i) ZeusTransformUtils.wrapperContextForParams(r7, ab.i.class, "com.obric.memorydata.plugin"), al.class, "com.obric.memorydata.plugin");
        r9.a(b(r4, r5));
        int r10 = r5 + 8;
    L3:
        if (r10 >= r6) goto L8;
        int r0 = a(r4, r10, r8);
        if (r3 != r8.f5016a) goto L8;
        r9.a(b(r4, r0));
        r10 = r0 + 8;
    L8:
        return r10;
    }

    static int d(byte[] r2, int r3, ab.i<?> r4, a r5) {
        al r6 = (al) ZeusTransformUtils.preCheckCast((ab.i) ZeusTransformUtils.wrapperContextForParams(r4, ab.i.class, "com.obric.memorydata.plugin"), al.class, "com.obric.memorydata.plugin");
        int r7 = a(r2, r3, r5);
        int r8 = r5.f5016a + r7;
    L3:
        if (r7 >= r8) goto L5;
        r6.a(b(r2, r7));
        r7 = r7 + 8;
        goto L3
    L5:
        if (r7 != r8) goto L8;
        return r7;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int d(byte[] r1, int r2, a r3) {
        int r4 = a(r1, r2, r3);
        int r0 = r3.f5016a;
        if (r0 < 0) goto L10;
        if (r0 != 0) goto L7;
        r3.c = "";
        return r4;
    L7:
        r3.c = Utf8.b(r1, r4, r0);
        return r4 + r0;
    L10:
        throw InvalidProtocolBufferException.negativeSize();
    }

    static int e(int r2, byte[] r3, int r4, int r5, ab.i<?> r6, a r7) {
        x r8 = (x) ZeusTransformUtils.preCheckCast((ab.i) ZeusTransformUtils.wrapperContextForParams(r6, ab.i.class, "com.obric.memorydata.plugin"), x.class, "com.obric.memorydata.plugin");
        r8.a(d(r3, r4));
        int r9 = r4 + 4;
    L3:
        if (r9 >= r5) goto L8;
        int r0 = a(r3, r9, r7);
        if (r2 != r7.f5016a) goto L8;
        r8.a(d(r3, r0));
        r9 = r0 + 4;
    L8:
        return r9;
    }

    static int e(byte[] r2, int r3, ab.i<?> r4, a r5) {
        x r6 = (x) ZeusTransformUtils.preCheckCast((ab.i) ZeusTransformUtils.wrapperContextForParams(r4, ab.i.class, "com.obric.memorydata.plugin"), x.class, "com.obric.memorydata.plugin");
        int r7 = a(r2, r3, r5);
        int r8 = r5.f5016a + r7;
    L3:
        if (r7 >= r8) goto L5;
        r6.a(d(r2, r7));
        r7 = r7 + 4;
        goto L3
    L5:
        if (r7 != r8) goto L8;
        return r7;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int e(byte[] r2, int r3, a r4) {
        int r5 = a(r2, r3, r4);
        int r0 = r4.f5016a;
        if (r0 < 0) goto L14;
        if (r0 > (r2.length - r5)) goto L12;
        if (r0 != 0) goto L9;
        r4.c = ByteString.EMPTY;
        return r5;
    L9:
        r4.c = ByteString.copyFrom(r2, r5, r0);
        return r5 + r0;
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    L14:
        throw InvalidProtocolBufferException.negativeSize();
    }

    static int f(int r3, byte[] r4, int r5, int r6, ab.i<?> r7, a r8) {
        n r9 = (n) ZeusTransformUtils.preCheckCast((ab.i) ZeusTransformUtils.wrapperContextForParams(r7, ab.i.class, "com.obric.memorydata.plugin"), n.class, "com.obric.memorydata.plugin");
        r9.a(c(r4, r5));
        int r10 = r5 + 8;
    L3:
        if (r10 >= r6) goto L8;
        int r0 = a(r4, r10, r8);
        if (r3 != r8.f5016a) goto L8;
        r9.a(c(r4, r0));
        r10 = r0 + 8;
    L8:
        return r10;
    }

    static int f(byte[] r2, int r3, ab.i<?> r4, a r5) {
        n r6 = (n) ZeusTransformUtils.preCheckCast((ab.i) ZeusTransformUtils.wrapperContextForParams(r4, ab.i.class, "com.obric.memorydata.plugin"), n.class, "com.obric.memorydata.plugin");
        int r7 = a(r2, r3, r5);
        int r8 = r5.f5016a + r7;
    L3:
        if (r7 >= r8) goto L5;
        r6.a(c(r2, r7));
        r7 = r7 + 8;
        goto L3
    L5:
        if (r7 != r8) goto L8;
        return r7;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0039 -> B:4:0x0020). Please report as a decompilation issue!!! */
    static int g(int r7, byte[] r8, int r9, int r10, ab.i<?> r11, a r12) {
        h r13 = (h) ZeusTransformUtils.preCheckCast((ab.i) ZeusTransformUtils.wrapperContextForParams(r11, ab.i.class, "com.obric.memorydata.plugin"), h.class, "com.obric.memorydata.plugin");
        int r14 = b(r8, r9, r12);
        if (r12.f5017b == 0) goto L5;
    L4:
        boolean r0 = true;
    L6:
        r13.a(r0);
        if (r14 >= r10) goto L14;
        int r1 = a(r8, r14, r12);
        if (r7 != r12.f5016a) goto L14;
        r14 = b(r8, r1, r12);
        if (r12.f5017b != 0) goto L4;
    L5:
        r0 = false;
    L14:
        return r14;
    L15:
        r0 = false;
        goto L6
    }

    static int g(byte[] r5, int r6, ab.i<?> r7, a r8) {
        h r9 = (h) ZeusTransformUtils.preCheckCast((ab.i) ZeusTransformUtils.wrapperContextForParams(r7, ab.i.class, "com.obric.memorydata.plugin"), h.class, "com.obric.memorydata.plugin");
        int r10 = a(r5, r6, r8);
        int r0 = r8.f5016a + r10;
    L3:
        if (r10 >= r0) goto L9;
        r10 = b(r5, r10, r8);
        if (r8.f5017b == 0) goto L7;
        boolean r1 = true;
    L8:
        r9.a(r1);
        goto L3
    L7:
        r1 = false;
        goto L8
    L9:
        if (r10 != r0) goto L12;
        return r10;
    L12:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int h(int r2, byte[] r3, int r4, int r5, ab.i<?> r6, a r7) {
        aa r8 = (aa) ZeusTransformUtils.preCheckCast((ab.i) ZeusTransformUtils.wrapperContextForParams(r6, ab.i.class, "com.obric.memorydata.plugin"), aa.class, "com.obric.memorydata.plugin");
        int r9 = a(r3, r4, r7);
    L3:
        r8.d(k.e(r7.f5016a));
        if (r9 >= r5) goto L9;
        int r0 = a(r3, r9, r7);
        if (r2 != r7.f5016a) goto L9;
        r9 = a(r3, r0, r7);
    L9:
        return r9;
    }

    static int h(byte[] r2, int r3, ab.i<?> r4, a r5) {
        aa r6 = (aa) ZeusTransformUtils.preCheckCast((ab.i) ZeusTransformUtils.wrapperContextForParams(r4, ab.i.class, "com.obric.memorydata.plugin"), aa.class, "com.obric.memorydata.plugin");
        int r7 = a(r2, r3, r5);
        int r0 = r5.f5016a + r7;
    L3:
        if (r7 >= r0) goto L5;
        r7 = a(r2, r7, r5);
        r6.d(k.e(r5.f5016a));
        goto L3
    L5:
        if (r7 != r0) goto L8;
        return r7;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int i(int r2, byte[] r3, int r4, int r5, ab.i<?> r6, a r7) {
        al r8 = (al) ZeusTransformUtils.preCheckCast((ab.i) ZeusTransformUtils.wrapperContextForParams(r6, ab.i.class, "com.obric.memorydata.plugin"), al.class, "com.obric.memorydata.plugin");
        int r9 = b(r3, r4, r7);
    L3:
        r8.a(k.a(r7.f5017b));
        if (r9 >= r5) goto L9;
        int r0 = a(r3, r9, r7);
        if (r2 != r7.f5016a) goto L9;
        r9 = b(r3, r0, r7);
    L9:
        return r9;
    }

    static int i(byte[] r3, int r4, ab.i<?> r5, a r6) {
        al r7 = (al) ZeusTransformUtils.preCheckCast((ab.i) ZeusTransformUtils.wrapperContextForParams(r5, ab.i.class, "com.obric.memorydata.plugin"), al.class, "com.obric.memorydata.plugin");
        int r8 = a(r3, r4, r6);
        int r0 = r6.f5016a + r8;
    L3:
        if (r8 >= r0) goto L5;
        r8 = b(r3, r8, r6);
        r7.a(k.a(r6.f5017b));
        goto L3
    L5:
        if (r8 != r0) goto L8;
        return r8;
    L8:
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0038 -> B:6:0x0016). Please report as a decompilation issue!!! */
    static int j(int r4, byte[] r5, int r6, int r7, ab.i<?> r8, a r9) {
        ab.i r10 = (ab.i) ZeusTransformUtils.wrapperContextForParams(r8, ab.i.class, "com.obric.memorydata.plugin");
        int r11 = a(r5, r6, r9);
        int r0 = r9.f5016a;
        if (r0 < 0) goto L22;
        if (r0 != 0) goto L23;
    L6:
        r10.add("");
    L9:
        if (r11 >= r7) goto L20;
        int r1 = a(r5, r11, r9);
        if (r4 != r9.f5016a) goto L20;
        r11 = a(r5, r1, r9);
        int r2 = r9.f5016a;
        if (r2 < 0) goto L19;
        if (r2 == 0) goto L6;
        r10.add(new String(r5, r11, r2, ab.f4938b));
        r11 = r11 + r2;
        goto L9
    L19:
        throw InvalidProtocolBufferException.negativeSize();
    L20:
        return r11;
    L23:
        r10.add(new String(r5, r11, r0, ab.f4938b));
        r11 = r11 + r0;
        goto L9
    L22:
        throw InvalidProtocolBufferException.negativeSize();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0040 -> B:6:0x0016). Please report as a decompilation issue!!! */
    static int k(int r5, byte[] r6, int r7, int r8, ab.i<?> r9, a r10) {
        ab.i r11 = (ab.i) ZeusTransformUtils.wrapperContextForParams(r9, ab.i.class, "com.obric.memorydata.plugin");
        int r12 = a(r6, r7, r10);
        int r0 = r10.f5016a;
        if (r0 < 0) goto L30;
        if (r0 != 0) goto L7;
    L6:
        r11.add("");
    L11:
        if (r12 >= r8) goto L26;
        int r1 = a(r6, r12, r10);
        if (r5 != r10.f5016a) goto L26;
        r12 = a(r6, r1, r10);
        int r2 = r10.f5016a;
        if (r2 < 0) goto L25;
        if (r2 == 0) goto L6;
        int r3 = r12 + r2;
        if (Utf8.a(r6, r12, r3) == false) goto L23;
        r11.add(new String(r6, r12, r2, ab.f4938b));
        r12 = r3;
        goto L11
    L23:
        throw InvalidProtocolBufferException.invalidUtf8();
    L25:
        throw InvalidProtocolBufferException.negativeSize();
    L26:
        return r12;
    L7:
        int r4 = r12 + r0;
        if (Utf8.a(r6, r12, r4) == false) goto L28;
        r11.add(new String(r6, r12, r0, ab.f4938b));
        r12 = r4;
        goto L11
    L28:
        throw InvalidProtocolBufferException.invalidUtf8();
    L30:
        throw InvalidProtocolBufferException.negativeSize();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x003d -> B:7:0x0018). Please report as a decompilation issue!!! */
    static int l(int r2, byte[] r3, int r4, int r5, ab.i<?> r6, a r7) {
        ab.i r8 = (ab.i) ZeusTransformUtils.wrapperContextForParams(r6, ab.i.class, "com.obric.memorydata.plugin");
        int r9 = a(r3, r4, r7);
        int r0 = r7.f5016a;
        if (r0 < 0) goto L27;
        if (r0 > (r3.length - r9)) goto L25;
        if (r0 != 0) goto L8;
    L7:
        r8.add(ByteString.EMPTY);
    L9:
        if (r9 >= r5) goto L23;
        int r1 = a(r3, r9, r7);
        if (r2 != r7.f5016a) goto L23;
        r9 = a(r3, r1, r7);
        int r10 = r7.f5016a;
        if (r10 < 0) goto L22;
        if (r10 > (r3.length - r9)) goto L20;
        if (r10 == 0) goto L7;
    L8:
        r8.add(ByteString.copyFrom(r3, r9, r10));
        r9 = r9 + r10;
        goto L9
    L20:
        throw InvalidProtocolBufferException.truncatedMessage();
    L22:
        throw InvalidProtocolBufferException.negativeSize();
    L23:
        return r9;
    L28:
        r8.add(ByteString.copyFrom(r3, r9, r0));
        r9 = r9 + r0;
        goto L9
    L25:
        throw InvalidProtocolBufferException.truncatedMessage();
    L27:
        throw InvalidProtocolBufferException.negativeSize();
    }
}
