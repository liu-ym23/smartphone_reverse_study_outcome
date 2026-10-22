package com.larus.camera.impl.edulibs.camera.internal.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Base64;
import com.larus.utils.z0;
import java.math.BigDecimal;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.larus.camera.impl.edulibs.camera.internal.util.a$a, reason: collision with other inner class name */
    public static final class C0076a {
        public final Bitmap a;

        public C0076a(Bitmap r2) {
            Intrinsics.checkNotNullParameter(r2, "bitmap");
            this.a = r2;
        }
    }

    static {
    }

    public static Bitmap a(String r2) throws Exception {
        Intrinsics.checkNotNullParameter(r2, "base64Data");
        byte[] r3 = Base64.decode(r2, 2);
        return BitmapFactory.decodeByteArray(r3, 0, r3.length);
    }

    public static double d(float r2) {
        return new BigDecimal(String.valueOf(r2)).setScale(2, 4).doubleValue();
    }

    public static C0076a b(Bitmap r4, float[] r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "bitmap");
        Intrinsics.checkNotNullParameter(r5, "points");
        int r1 = 1;
    L11:
        return new C0076a(c(r4, r5, r6, 1 / r1));
    L6:
        e = move-exception;
        r1 = r1 * 2;
        if (r1 <= 8) goto L11;
        throw e;
    }

    public static Bitmap c(Bitmap r17, float[] r18, int r19, float r20) {
        int r0 = r17.getWidth();
        int r1 = r17.getHeight();
        Intrinsics.checkNotNullParameter(r18, "points");
        Intrinsics.checkNotNullParameter(r18, "points");
        float r4 = 0.0f;
        int r10 = 0;
        if (r18.length >= 7) goto L5;
        float r3 = 0.0f;
    L6:
        int r5 = Math.round(Math.max(0.0f, r3));
        Intrinsics.checkNotNullParameter(r18, "points");
        if (r18.length >= 8) goto L9;
        float r13 = 0.0f;
    L10:
        int r14 = Math.round(Math.max(0.0f, r13));
        float r2 = r0;
        Intrinsics.checkNotNullParameter(r18, "points");
        if (r18.length < 7) goto L14;
        r4 = Math.max(Math.max(Math.max(r18[0], r18[2]), r18[4]), r18[6]);
    L14:
        int r6 = Math.round(Math.min(r2, r4));
        float r7 = r1;
        Intrinsics.checkNotNullParameter(r18, "points");
        if (r18.length >= 8) goto L17;
        float r8 = 0.0f;
    L18:
        Rect r11 = new Rect(r5, r14, r6, Math.round(Math.min(r7, r8)));
        Matrix r9 = new Matrix();
        r9.setRotate(r19, r17.getWidth() / 2, r17.getHeight() / 2);
        r9.postScale(r20, r20);
        Bitmap r12 = Bitmap.createBitmap(r17, r11.left, r11.top, r11.width(), r11.height(), r9, true);
        if (Intrinsics.areEqual(r12, r17) == true) goto L21;
    L23:
        int r15 = r19 % 90;
        if (r15 != 0) goto L26;
    L56:
        if (r12 == null) goto L58;
        return r12;
    L58:
        return r17;
    L26:
        if (r11.width() > 0) goto L28;
    L30:
        boolean r16 = false;
    L31:
        if (r15 == 0) goto L56;
        if (r16 == false) goto L56;
        double r21 = Math.toRadians(r19);
        if (r19 >= 90) goto L36;
    L41:
        Intrinsics.checkNotNull(r11);
        int r22 = r11.left;
    L42:
        int r23 = 0;
    L44:
        if (r23 >= r18.length) goto L51;
        float r24 = r18[r23];
        if (r24 < (r22 - 1)) goto L50;
        if (r24 > (r22 + 1)) goto L50;
        int r25 = r23 + 1;
        int r110 = (int) Math.abs(Math.sin(r21) * ((double) (r11.bottom - r18[r25])));
        int r26 = (int) Math.abs(Math.cos(r21) * ((double) (r18[r25] - r11.top)));
        int r27 = (int) Math.abs(((double) (r18[r25] - r11.top)) / Math.sin(r21));
        int r28 = (int) Math.abs(((double) (r11.bottom - r18[r25])) / Math.cos(r21));
        int r29 = r110;
        r10 = r27;
    L52:
        r11.set(r29, r26, r10 + r29, r28 + r26);
        Intrinsics.checkNotNull(r12);
        Bitmap r30 = Bitmap.createBitmap(r12, r11.left, r11.top, r11.width(), r11.height());
        if (Intrinsics.areEqual(r12, r30) == true) goto L55;
        Intrinsics.checkNotNull(r12);
        r12.recycle();
    L55:
        r12 = r30;
    L50:
        r23 = r23 + 2;
        goto L44
    L51:
        r29 = 0;
        r28 = 0;
        r26 = 0;
        goto L52
    L36:
        if (r19 > 180) goto L38;
    L40:
        Intrinsics.checkNotNull(r11);
        r22 = r11.right;
        goto L42
    L38:
        if (r19 >= 270) goto L40;
    L28:
        if (r11.height() <= 0) goto L30;
        r16 = true;
        goto L31
    L21:
        if (r17.getConfig() == null) goto L23;
        r12 = r17.copy(z0.b(r17.getConfig()), false);
        goto L23
    L17:
        r8 = Math.max(Math.max(Math.max(r18[1], r18[3]), r18[5]), r18[7]);
        goto L18
    L9:
        r13 = Math.min(Math.min(Math.min(r18[1], r18[3]), r18[5]), r18[7]);
        goto L10
    L5:
        r3 = Math.min(Math.min(Math.min(r18[0], r18[2]), r18[4]), r18[6]);
        goto L6
    }
}
