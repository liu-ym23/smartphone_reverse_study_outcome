package com.larus.common_ui.qrcode;

import android.graphics.Bitmap;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.f;
import nv7.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarkQRCodeUtil {

    public static final enum EccLevel extends Enum<EccLevel> {
        public static final EccLevel AUTO = null;
        public static final EccLevel HIGH = null;
        public static final EccLevel LOW = null;
        public static final EccLevel MEDIUM = null;
        public static final EccLevel MEDIUM_HIGH = null;
        public static final /* synthetic */ EccLevel[] a = null;

        static {
            EccLevel r0 = new EccLevel("AUTO", 0);
            AUTO = r0;
            EccLevel r1 = new EccLevel("LOW", 1);
            LOW = r1;
            EccLevel r3 = new EccLevel("MEDIUM", 2);
            MEDIUM = r3;
            EccLevel r5 = new EccLevel("MEDIUM_HIGH", 3);
            MEDIUM_HIGH = r5;
            EccLevel r7 = new EccLevel("HIGH", 4);
            HIGH = r7;
            a = new EccLevel[]{r0, r1, r3, r5, r7};
        }

        public static EccLevel[] values() {
            return (EccLevel[]) a.clone();
        }

        public static EccLevel valueOf(String r1) {
            return (EccLevel) r27.a.a(EccLevel.class, r1);
        }

        public EccLevel(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[EccLevel.values().length];
            a = r0;
            r0[EccLevel.LOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            a[EccLevel.MEDIUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            a[EccLevel.MEDIUM_HIGH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            a[EccLevel.HIGH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            a[EccLevel.AUTO.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static ErrorCorrectionLevel a(EccLevel r1) {
        if (r1 == null) goto L4;
        int r2 = a.a[r1.ordinal()];
        if (r2 == 1) goto L18;
        if (r2 == 3) goto L16;
        if (r2 == 4) goto L14;
        return ErrorCorrectionLevel.M;
    L14:
        return ErrorCorrectionLevel.H;
    L16:
        return ErrorCorrectionLevel.Q;
    L18:
        return ErrorCorrectionLevel.L;
    L4:
        return ErrorCorrectionLevel.M;
    }

    public static Bitmap b(b r9) {
        int r6 = r9.a;
        int r7 = r9.b;
        int[] r1 = new int[r6 * r7];
        int r2 = 0;
    L3:
        if (r2 >= r7) goto L12;
        int r3 = r2 * r6;
        int r4 = 0;
    L5:
        if (r4 >= r6) goto L11;
        int r5 = r3 + r4;
        if (r9.b(r4, r2) == false) goto L9;
        int r8 = -16777216;
    L10:
        r1[r5] = r8;
        r4 = r4 + 1;
        goto L5
    L9:
        r8 = -1;
        goto L10
    L11:
        r2 = r2 + 1;
        goto L3
    L12:
        Bitmap r10 = Bitmap.createBitmap(r6, r7, Bitmap.Config.ARGB_8888);
        r10.setPixels(r1, 0, r6, 0, 0, r6, r7);
        return r10;
    }

    public static b d(b r10) {
        int[] r0 = r10.c();
        int r1 = r0[2] + 0;
        int r3 = r0[3] + 0;
        b r4 = new b(r1, r3);
        int r5 = r4.d.length;
        int r6 = 0;
    L3:
        if (r6 >= r5) goto L5;
        r4.d[r6] = 0;
        r6 = r6 + 1;
        goto L3
    L5:
        int r7 = 0;
    L7:
        if (r7 >= (r1 + 0)) goto L16;
        int r8 = 0;
    L10:
        if (r8 >= (r3 + 0)) goto L15;
        if (r10.b((r7 + 0) + r0[0], (r8 + 0) + r0[1]) == false) goto L14;
        r4.d(r7, r8);
    L14:
        r8 = r8 + 1;
        goto L10
    L15:
        r7 = r7 + 1;
        goto L7
    L16:
        return r4;
    }

    public static b c(f r10, int r11, int r12) {
        com.google.zxing.qrcode.encoder.b r13 = r10.e;
        if (r13 == null) goto L15;
        int r0 = r13.b;
        int r1 = r13.c;
        int r14 = Math.max(r11, r0);
        int r15 = Math.max(r12, r1);
        int r2 = Math.max(1, Math.min(r14 / r0, r15 / r1));
        int r4 = (r14 - (r0 * r2)) / 2;
        int r5 = (r15 - (r1 * r2)) / 2;
        b r6 = new b(r14, r15);
        int r16 = 0;
    L5:
        if (r16 >= r1) goto L13;
        int r8 = r4;
        int r7 = 0;
    L7:
        if (r7 >= r0) goto L12;
        if (r13.a(r7, r16) != 1) goto L11;
        r6.e(r8, r5, r2, r2);
    L11:
        r7 = r7 + 1;
        r8 = r8 + r2;
        goto L7
    L12:
        r16 = r16 + 1;
        r5 = r5 + r2;
        goto L5
    L13:
        return r6;
    L15:
        throw new IllegalArgumentException("QRCode matrix is null");
    }
}
