package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class MinimalEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f5099b;
    private final com.google.zxing.common.c c;
    private final ErrorCorrectionLevel d;

    /* JADX INFO: renamed from: com.google.zxing.qrcode.encoder.MinimalEncoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5100a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f5101b = null;

        static {
            int[] r0 = new int[Mode.values().length];
            f5101b = r0;
            r0[Mode.KANJI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L23:
            f5101b[Mode.ALPHANUMERIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L29:
            f5101b[Mode.NUMERIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L37:
            f5101b[Mode.BYTE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L25:
            f5101b[Mode.ECI.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L10:
            int[] r3 = new int[VersionSize.values().length];
            f5100a = r3;
            r3[VersionSize.SMALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L31:
            f5100a[VersionSize.MEDIUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L35:
            f5100a[VersionSize.LARGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
            return;
        }
    }

    private static final enum VersionSize extends Enum<VersionSize> {
        private static final /* synthetic */ VersionSize[] $VALUES = null;
        public static final VersionSize LARGE = null;
        public static final VersionSize MEDIUM = null;
        public static final VersionSize SMALL = null;
        private final String description;

        static {
            VersionSize r0 = new VersionSize("SMALL", 0, "version 1-9");
            SMALL = r0;
            VersionSize r1 = new VersionSize("MEDIUM", 1, "version 10-26");
            MEDIUM = r1;
            VersionSize r3 = new VersionSize("LARGE", 2, "version 27-40");
            LARGE = r3;
            $VALUES = new VersionSize[]{r0, r1, r3};
        }

        private VersionSize(String r1, int r2, String r3) {
            super(r1, r2);
            this.description = r3;
        }

        public static VersionSize valueOf(String r2) {
            return (VersionSize) ZeusTransformUtils.preCheckCast(Enum.valueOf(VersionSize.class, r2), VersionSize.class, "com.obric.memorydata.plugin");
        }

        public static VersionSize[] values() {
            return (VersionSize[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), VersionSize[].class, "com.obric.memorydata.plugin");
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.description;
        }
    }

    private final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MinimalEncoder f5102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Mode f5103b;
        private final int c;
        private final int d;
        private final int e;
        private final a f;
        private final int g;

        private a(MinimalEncoder r6, Mode r7, int r8, int r9, int r10, a r11, com.google.zxing.qrcode.decoder.a r12) {
            this.f5102a = r6;
            this.f5103b = r7;
            this.c = r8;
            if (r7 == Mode.BYTE) goto L7;
            if (r11 == null) goto L7;
            int r0 = r11.d;
        L8:
            this.d = r0;
            this.e = r10;
            this.f = r11;
            boolean r1 = false;
            if (r11 == null) goto L11;
            int r2 = r11.g;
        L13:
            if (r7 != Mode.BYTE) goto L16;
            if (r11 != null) goto L16;
            if (r0 == 0) goto L16;
        L19:
            r1 = true;
        L20:
            int r3 = 4;
            if (r11 != null) goto L23;
        L25:
            r2 = r2 + (r7.getCharacterCountBits(r12) + 4);
        L26:
            int r13 = AnonymousClass1.f5101b[r7.ordinal()];
            if (r13 != 1) goto L29;
            r2 = r2 + 13;
        L48:
            this.g = r2;
            return;
        L29:
            if (r13 != 2) goto L31;
            if (r10 != 1) goto L45;
            int r14 = 6;
        L46:
            r2 = r2 + r14;
            goto L48
        L45:
            r14 = 11;
            goto L46
        L31:
            if (r13 == 3) goto L37;
            if (r13 != 4) goto L48;
            r2 = r2 + (MinimalEncoder.b(r6).a(MinimalEncoder.a(r6).substring(r8, r10 + r8), r9).length * 8);
            if (r1 == false) goto L48;
            r2 = r2 + 12;
            goto L48
        L37:
            if (r10 == 1) goto L42;
            if (r10 != 2) goto L41;
            r3 = 7;
            goto L42
        L41:
            r3 = 10;
        L42:
            r2 = r2 + r3;
            goto L48
        L23:
            if (r7 != r11.f5103b) goto L25;
            if (r1 == false) goto L26;
        L16:
            if (r11 == null) goto L20;
            if (r0 == r11.d) goto L20;
        L11:
            r2 = 0;
        L7:
            r0 = r9;
            goto L8
        }

        /* synthetic */ a(MinimalEncoder r1, Mode r2, int r3, int r4, int r5, a r6, com.google.zxing.qrcode.decoder.a r7, AnonymousClass1 r8) {
            this(r1, r2, r3, r4, r5, r6, r7);
        }

        static /* synthetic */ int a(a r0) {
            return r0.e;
        }

        static /* synthetic */ int b(a r0) {
            return r0.d;
        }

        static /* synthetic */ Mode c(a r0) {
            return r0.f5103b;
        }

        static /* synthetic */ int d(a r0) {
            return r0.g;
        }

        static /* synthetic */ a e(a r0) {
            return r0.f;
        }

        static /* synthetic */ int f(a r0) {
            return r0.c;
        }
    }

    final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MinimalEncoder f5104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<a> f5105b;
        private final com.google.zxing.qrcode.decoder.a c;

        final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f5106a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Mode f5107b;
            private final int c;
            private final int d;
            private final int e;

            a(b r1, Mode r2, int r3, int r4, int r5) {
                this.f5106a = r1;
                this.f5107b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
            }

            private int a() {
                if (this.f5107b != Mode.BYTE) goto L6;
                com.google.zxing.common.c r0 = MinimalEncoder.b(this.f5106a.f5104a);
                String r1 = MinimalEncoder.a(this.f5106a.f5104a);
                int r2 = this.c;
                return r0.a(r1.substring(r2, this.e + r2), this.d).length;
            L6:
                return this.e;
            }

            private int a(com.google.zxing.qrcode.decoder.a r7) {
                int r0 = 4;
                int r8 = this.f5107b.getCharacterCountBits(r7) + 4;
                int r1 = AnonymousClass1.f5101b[this.f5107b.ordinal()];
                if (r1 == 1) goto L25;
                int r3 = 0;
                if (r1 != 2) goto L7;
                int r6 = this.e;
                int r9 = r8 + ((r6 / 2) * 11);
                if ((r6 % 2) != 1) goto L30;
                r3 = 6;
            L30:
                return r9 + r3;
            L7:
                if (r1 == 3) goto L14;
                if (r1 != 4) goto L10;
                int r10 = a() * 8;
            L27:
                return r8 + r10;
            L10:
                if (r1 == 5) goto L28;
                return r8;
            L28:
                return r8 + 8;
            L14:
                int r11 = this.e;
                int r12 = r8 + ((r11 / 3) * 10);
                int r13 = r11 % 3;
                if (r13 == 1) goto L29;
                if (r13 != 2) goto L19;
                r0 = 7;
                goto L29
            L19:
                r0 = 0;
            L29:
                return r12 + r0;
            L25:
                r10 = this.e * 13;
                goto L27
            }

            static /* synthetic */ int a(a r0, com.google.zxing.qrcode.decoder.a r1) {
                return r0.a(r1);
            }

            static /* synthetic */ Mode a(a r0) {
                return r0.f5107b;
            }

            private String a(String r4) {
                StringBuilder r3 = new StringBuilder();
                int r0 = 0;
            L4:
                if (r0 >= r4.length()) goto L14;
                if (r4.charAt(r0) >= ' ') goto L8;
            L11:
                char r1 = '.';
            L12:
                r3.append(r1);
                r0 = r0 + 1;
                goto L4
            L8:
                if (r4.charAt(r0) > '~') goto L11;
                r1 = r4.charAt(r0);
                goto L12
            L14:
                return r3.toString();
            }

            private void a(com.google.zxing.common.a r4) {
                r4.a(this.f5107b.getBits(), 4);
                if (this.e <= 0) goto L6;
                r4.a(a(), this.f5107b.getCharacterCountBits(b.a(this.f5106a)));
            L6:
                if (this.f5107b != Mode.ECI) goto L9;
                r4.a(MinimalEncoder.b(this.f5106a.f5104a).b(this.d), 8);
                return;
            L9:
                if (this.e <= 0) goto L13;
                String r0 = MinimalEncoder.a(this.f5106a.f5104a);
                int r1 = this.c;
                c.a(r0.substring(r1, this.e + r1), this.f5107b, r4, MinimalEncoder.b(this.f5106a.f5104a).a(this.d));
                return;
            }

            static /* synthetic */ void a(a r0, com.google.zxing.common.a r1) {
                r0.a(r1);
            }

            public String toString() {
                StringBuilder r0 = new StringBuilder();
                r0.append(this.f5107b).append('(');
                if (this.f5107b != Mode.ECI) goto L5;
                String r4 = MinimalEncoder.b(this.f5106a.f5104a).a(this.d).displayName();
            L6:
                r0.append(r4);
                r0.append(')');
                return r0.toString();
            L5:
                String r1 = MinimalEncoder.a(this.f5106a.f5104a);
                int r2 = this.c;
                r4 = a(r1.substring(r2, this.e + r2));
                goto L6
            }
        }

        b(MinimalEncoder r13, com.google.zxing.qrcode.decoder.a r14, a r15) {
            this.f5104a = r13;
            this.f5105b = new ArrayList();
            int r0 = 0;
            int r1 = 0;
            boolean r2 = false;
        L3:
            int r3 = 1;
            if (r15 == null) goto L26;
            int r10 = r1 + a.a(r15);
            a r4 = a.e(r15);
            if (a.c(r15) != Mode.BYTE) goto L10;
            if (r4 != null) goto L10;
            if (a.b(r15) == 0) goto L10;
        L13:
            boolean r5 = true;
        L15:
            if (r5 == false) goto L17;
            r2 = true;
        L17:
            if (r4 != null) goto L19;
        L21:
            this.f5105b.add(0, new a(this, a.c(r15), a.f(r15), a.b(r15), r10));
            r10 = 0;
        L22:
            if (r5 == false) goto L24;
            this.f5105b.add(0, new a(this, Mode.ECI, a.f(r15), a.b(r15), 0));
        L24:
            r15 = r4;
            r1 = r10;
            goto L3
        L19:
            if (a.c(r4) != a.c(r15)) goto L21;
            if (r5 == false) goto L22;
        L10:
            if (r4 != null) goto L12;
        L14:
            r5 = false;
            goto L15
        L12:
            if (a.b(r15) == a.b(r4)) goto L14;
        L26:
            if (MinimalEncoder.c(r13) == false) goto L38;
            a r16 = (a) ZeusTransformUtils.preCheckCast(this.f5105b.get(0), a.class, "com.obric.memorydata.plugin");
            if (r16 != null) goto L30;
        L33:
            a r17 = (a) ZeusTransformUtils.preCheckCast(this.f5105b.get(0), a.class, "com.obric.memorydata.plugin");
            List<a> r6 = this.f5105b;
            if (a.a(r17) != Mode.ECI) goto L37;
            r0 = 1;
        L37:
            r6.add(r0, new a(this, Mode.FNC1_FIRST_POSITION, 0, 0, 0));
            goto L38
        L30:
            if (a.a(r16) == Mode.ECI) goto L33;
            if (r2 == false) goto L33;
            this.f5105b.add(0, new a(this, Mode.ECI, 0, 0, 0));
        L38:
            int r18 = r14.a();
            int r7 = AnonymousClass1.f5100a[MinimalEncoder.b(r14).ordinal()];
            if (r7 != 1) goto L41;
            int r8 = 9;
        L45:
            int r19 = a(r14);
        L46:
            if (r18 >= r8) goto L50;
            if (c.a(r19, com.google.zxing.qrcode.decoder.a.a(r18), MinimalEncoder.d(r13)) == true) goto L50;
            r18 = r18 + 1;
        L50:
            if (r18 <= r3) goto L54;
            if (c.a(r19, com.google.zxing.qrcode.decoder.a.a(r18 - 1), MinimalEncoder.d(r13)) == false) goto L54;
            r18 = r18 - 1;
        L54:
            this.c = com.google.zxing.qrcode.decoder.a.a(r18);
            return;
        L41:
            if (r7 == 2) goto L43;
            r3 = 27;
            r8 = 40;
            goto L45
        L43:
            r3 = 10;
            r8 = 26;
            goto L45
        }

        private int a(com.google.zxing.qrcode.decoder.a r5) {
            Iterator<a> r4 = this.f5105b.iterator();
            int r0 = 0;
        L4:
            if (r4.hasNext() == false) goto L6;
            r0 = r0 + a.a((a) ZeusTransformUtils.preCheckCast(r4.next(), a.class, "com.obric.memorydata.plugin"), r5);
            goto L4
        L6:
            return r0;
        }

        static /* synthetic */ com.google.zxing.qrcode.decoder.a a(b r0) {
            return r0.c;
        }

        int a() {
            return a(this.c);
        }

        void a(com.google.zxing.common.a r4) {
            Iterator<a> r3 = this.f5105b.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            a.a((a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.memorydata.plugin"), r4);
            goto L4
        }

        com.google.zxing.qrcode.decoder.a b() {
            return this.c;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            Iterator<a> r5 = this.f5105b.iterator();
            a r1 = null;
        L4:
            if (r5.hasNext() == false) goto L10;
            a r2 = (a) ZeusTransformUtils.preCheckCast(r5.next(), a.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L8;
            r0.append(",");
        L8:
            r0.append(r2.toString());
            r1 = r2;
            goto L4
        L10:
            return r0.toString();
        }
    }

    MinimalEncoder(String r2, Charset r3, boolean r4, ErrorCorrectionLevel r5) {
        this.f5098a = r2;
        this.f5099b = r4;
        this.c = new com.google.zxing.common.c(r2, r3, -1);
        this.d = r5;
    }

    static int a(Mode r3) {
        if (r3 != null) goto L5;
        return 0;
    L5:
        int r1 = AnonymousClass1.f5101b[r3.ordinal()];
        if (r1 != 1) goto L8;
        return 0;
    L8:
        if (r1 != 2) goto L10;
        return 1;
    L10:
        if (r1 != 3) goto L12;
        return 2;
    L12:
        if (r1 != 4) goto L15;
        return 3;
    L15:
        throw new IllegalStateException("Illegal mode " + r3);
    }

    static com.google.zxing.qrcode.decoder.a a(VersionSize r1) {
        int r2 = AnonymousClass1.f5100a[r1.ordinal()];
        if (r2 != 1) goto L5;
        int r3 = 9;
    L8:
        return com.google.zxing.qrcode.decoder.a.a(r3);
    L5:
        if (r2 == 2) goto L9;
        r3 = 40;
        goto L8
    L9:
        r3 = 26;
        goto L8
    }

    static b a(String r1, com.google.zxing.qrcode.decoder.a r2, Charset r3, boolean r4, ErrorCorrectionLevel r5) {
        return new MinimalEncoder(r1, r3, r4, r5).a(r2);
    }

    static /* synthetic */ String a(MinimalEncoder r0) {
        return r0.f5098a;
    }

    static boolean a(char r1) {
        if (r1 >= '0') goto L5;
    L7:
        return false;
    L5:
        if (r1 > '9') goto L7;
        return true;
    }

    static /* synthetic */ com.google.zxing.common.c b(MinimalEncoder r0) {
        return r0.c;
    }

    static VersionSize b(com.google.zxing.qrcode.decoder.a r2) {
        if (r2.a() > 9) goto L6;
        return VersionSize.SMALL;
    L6:
        if (r2.a() > 26) goto L9;
        return VersionSize.MEDIUM;
    L9:
        return VersionSize.LARGE;
    }

    static boolean b(char r0) {
        return c.a(String.valueOf(r0));
    }

    static boolean c(char r1) {
        if (c.a(r1) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ boolean c(MinimalEncoder r0) {
        return r0.f5099b;
    }

    static /* synthetic */ ErrorCorrectionLevel d(MinimalEncoder r0) {
        return r0.d;
    }

    b a(com.google.zxing.qrcode.decoder.a r9) {
        if (r9 != null) goto L15;
        int r2 = 0;
        com.google.zxing.qrcode.decoder.a[] r0 = {a(VersionSize.SMALL), a(VersionSize.MEDIUM), a(VersionSize.LARGE)};
        b[] r1 = {c(r0[0]), c(r0[1]), c(r0[2])};
        int r3 = Integer.MAX_VALUE;
        int r4 = -1;
    L4:
        if (r2 >= 3) goto L10;
        int r5 = r1[r2].a();
        if (c.a(r5, r0[r2], this.d) == false) goto L9;
        if (r5 >= r3) goto L9;
        r4 = r2;
        r3 = r5;
    L9:
        r2 = r2 + 1;
        goto L4
    L10:
        if (r4 < 0) goto L14;
        return r1[r4];
    L14:
        throw new WriterException("Data too big for any version");
    L15:
        b r6 = c(r9);
        if (c.a(r6.a(), a(b(r6.b())), this.d) == false) goto L19;
        return r6;
    L19:
        throw new WriterException("Data too big for version" + r9);
    }

    void a(com.google.zxing.qrcode.decoder.a r17, a[][][] r18, int r19, a r20) {
        int r0 = this.c.a();
        int r1 = this.c.b();
        if (r1 >= 0) goto L5;
    L7:
        r1 = 0;
    L8:
        int r12 = r0;
        int r13 = r1;
    L9:
        if (r13 >= r12) goto L15;
        if (this.c.a(this.f5098a.charAt(r19), r13) == false) goto L13;
        a(r18, r19, new a(this, Mode.BYTE, r19, r13, 1, r20, r17, null));
    L13:
        r13 = r13 + 1;
        goto L9
    L15:
        if (a(Mode.KANJI, this.f5098a.charAt(r19)) == false) goto L17;
        a(r18, r19, new a(this, Mode.KANJI, r19, 0, 1, r20, r17, null));
    L17:
        int r14 = this.f5098a.length();
        if (a(Mode.ALPHANUMERIC, this.f5098a.charAt(r19)) == false) goto L28;
        Mode r2 = Mode.ALPHANUMERIC;
        int r4 = 0;
        int r3 = r19 + 1;
        if (r3 < r14) goto L22;
    L25:
        int r5 = 1;
    L26:
        a(r18, r19, new a(this, r2, r19, r4, r5, r20, r17, null));
        goto L28
    L22:
        if (a(Mode.ALPHANUMERIC, this.f5098a.charAt(r3)) == false) goto L25;
        r5 = 2;
    L28:
        if (a(Mode.NUMERIC, this.f5098a.charAt(r19)) == false) goto L47;
        Mode r6 = Mode.NUMERIC;
        int r7 = 0;
        int r8 = r19 + 1;
        if (r8 < r14) goto L32;
    L41:
        int r9 = 1;
    L42:
        a(r18, r19, new a(this, r6, r19, r7, r9, r20, r17, null));
        return;
    L32:
        if (a(Mode.NUMERIC, this.f5098a.charAt(r8)) == false) goto L41;
        int r10 = r19 + 2;
        if (r10 < r14) goto L37;
    L40:
        r9 = 2;
        goto L42
    L37:
        if (a(Mode.NUMERIC, this.f5098a.charAt(r10)) == false) goto L40;
        r9 = 3;
        goto L42
    L47:
        return;
    L5:
        if (this.c.a(this.f5098a.charAt(r19), r1) == false) goto L7;
        r0 = r1 + 1;
        goto L8
    }

    void a(a[][][] r2, int r3, a r4) {
        a[] r1 = r2[r3 + a.a(r4)][a.b(r4)];
        int r5 = a(a.c(r4));
        if (r1[r5] != null) goto L5;
    L6:
        r1[r5] = r4;
        return;
    L5:
        if (a.d(r1[r5]) > a.d(r4)) goto L6;
    }

    boolean a(Mode r2, char r3) {
        int r1 = AnonymousClass1.f5101b[r2.ordinal()];
        if (r1 == 1) goto L18;
        if (r1 == 2) goto L16;
        if (r1 == 3) goto L14;
        if (r1 == 4) goto L12;
        return false;
    L12:
        return true;
    L14:
        return a(r3);
    L16:
        return c(r3);
    L18:
        return b(r3);
    }

    b c(com.google.zxing.qrcode.decoder.a r12) {
        int r0 = this.f5098a.length();
        int r4 = 1;
        a[][][] r1 = (a[][][]) Array.newInstance(a.class, new int[]{r0 + 1, this.c.a(), 4});
        a(r12, r1, 0, null);
    L3:
        if (r4 > r0) goto L16;
        int r3 = 0;
    L6:
        if (r3 >= this.c.a()) goto L15;
        int r6 = 0;
    L8:
        if (r6 >= 4) goto L14;
        if (r1[r4][r3][r6] == null) goto L13;
        if (r4 >= r0) goto L13;
        a(r12, r1, r4, r1[r4][r3][r6]);
    L13:
        r6 = r6 + 1;
        goto L8
    L14:
        r3 = r3 + 1;
        goto L6
    L15:
        r4 = r4 + 1;
        goto L3
    L16:
        int r5 = Integer.MAX_VALUE;
        int r7 = -1;
        int r8 = 0;
        int r9 = -1;
    L18:
        if (r8 >= this.c.a()) goto L28;
        int r10 = 0;
    L20:
        if (r10 >= 4) goto L27;
        if (r1[r0][r8][r10] == null) goto L26;
        a r11 = r1[r0][r8][r10];
        if (a.d(r11) >= r5) goto L26;
        r5 = a.d(r11);
        r7 = r8;
        r9 = r10;
    L26:
        r10 = r10 + 1;
        goto L20
    L27:
        r8 = r8 + 1;
        goto L18
    L28:
        if (r7 < 0) goto L32;
        return new b(this, r12, r1[r0][r7][r9]);
    L32:
        throw new WriterException("Internal error: failed to encode \"" + this.f5098a + "\"");
    }
}
