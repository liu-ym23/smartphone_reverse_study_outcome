package u7a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.obric.aivoice.core.data.NameKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k {
    public static String[] c(String r9) {
        if (r9 != null) goto L5;
        return null;
    L5:
        if (r9.equalsIgnoreCase(NameKeys.UnloadStrategy_No_Strategy) == true) goto L41;
        String[] r10 = r9.split(" ");
        if (r10.length > 4) goto L39;
        int r4 = 0;
        boolean r5 = true;
    L11:
        if (r4 >= Math.min(r10.length, 4)) goto L30;
        if (r10[r4].endsWith("px") == true) goto L18;
        if (r10[r4].endsWith("%") == true) goto L18;
    L16:
        r5 = false;
    L29:
        r4 = r4 + 1;
    L18:
        if (r10[r4].endsWith("px") == false) goto L24;
        if (r10[r4].length() <= 2) goto L16;
        String r6 = r10[r4];
        r5 = r6.substring(0, r6.length() - 2).matches("[+]?[0-9]*\\.?[0-9]+");
        goto L29
    L24:
        if (r10[r4].endsWith("%") == false) goto L29;
        if (r10[r4].length() <= 1) goto L16;
        String r7 = r10[r4];
        r5 = r7.substring(0, r7.length() - 1).matches("[+]?[0-9]*\\.?[0-9]+");
        goto L29
    L30:
        if (r5 == true) goto L32;
        return null;
    L32:
        return r10;
    L39:
        return null;
    L41:
        return null;
    }

    public static float[] d(String[] r6, int r7, int r8) {
        if (r6 != null) goto L4;
        return null;
    L4:
        if (r6.length > 4) goto L28;
        float[] r0 = {0.0f, 0.0f, 0.0f, 0.0f};
        int r2 = 0;
    L8:
        if (r2 >= r6.length) goto L20;
        if (r6[r2].endsWith("px") == false) goto L13;
        String r3 = r6[r2];
        r0[r2] = CastFloatProtector.parseFloat(r3.substring(0, r3.length() - 2));
    L19:
        r2 = r2 + 1;
        goto L8
    L13:
        if (r6[r2].endsWith("%") == false) goto L19;
        if (r2 == 0) goto L18;
        if (r2 == 2) goto L18;
        String r4 = r6[r2];
        r0[r2] = CastFloatProtector.parseFloat(r4.substring(0, r4.length() - 2)) * r7;
    L18:
        String r5 = r6[r2];
        r0[r2] = CastFloatProtector.parseFloat(r5.substring(0, r5.length() - 2)) * r8;
        goto L19
    L20:
        return r0;
    L28:
        return null;
    }

    public static Matrix e(int r8, int r9, int r10, int r11, m.b r12) {
        TraceEvent.beginSection("image.NinePatchHelper.getMatrix");
        Matrix r1 = new Matrix();
        float r13 = r8;
        float r14 = r10;
        float r3 = (r13 * 1.0f) / r14;
        float r15 = r9;
        float r16 = r11;
        float r4 = (r15 * 1.0f) / r16;
        if (r12 != m.b.a) goto L6;
        r1.preScale(r3, r4);
    L18:
        TraceEvent.endSection("image.NinePatchHelper.getMatrix");
        return r1;
    L6:
        if (r12 != m.b.b) goto L12;
        if (r3 <= r4) goto L10;
        r1.setScale(r4, r4);
        r1.postTranslate((r13 - (r14 * r4)) / 2.0f, 0.0f);
        goto L18
    L10:
        r1.setScale(r3, r3);
        r1.postTranslate(0.0f, (r15 - (r16 * r3)) / 2.0f);
        goto L18
    L12:
        if (r12 == m.b.d) goto L14;
        float r17 = com.lynx.tasm.utils.i.b(1.0f, 0.0f);
        float r18 = Math.round((r13 - (r14 * r17)) * 0.5f);
        float r19 = Math.round((r15 - (r16 * r17)) * 0.5f);
        r1.setScale(r17, r17);
        r1.postTranslate(r18, r19);
        goto L18
    L14:
        if (r3 <= r4) goto L16;
        r1.setScale(r3, r3);
        r1.postTranslate(0.0f, (r15 - (r16 * r3)) / 2.0f);
        goto L18
    L16:
        r1.setScale(r4, r4);
        r1.postTranslate((r13 - (r14 * r4)) / 2.0f, 0.0f);
        goto L18
    }

    public static boolean a(int r14, int r15, int r16, int r17, m.b r18, String r19, String r20, Canvas r21, Bitmap r22, int r23) {
        TraceEvent.beginSection("image.NinePatchHelper.drawNinePatch");
        boolean r12 = false;
        float[] r5 = d(c(r19), r16, r17);     // Catch: Throwable -> L37
        if (r20 != null) goto L6;
    L13:
        float r6 = 1.0f;
    L15:
        if (r5 != null) goto L17;
    L28:
        boolean r0 = false;
    L29:
        if (r0 == true) goto L35;
        Matrix r1 = e(r14, r15, r16, r17, r18);     // Catch: Throwable -> L37
        if (r23 != 255) goto L33;
        Paint r2 = null;
    L34:
        r21.drawBitmap(r22, r1, r2);     // Catch: Throwable -> L37
    L36:
        r12 = true;
    L39:
        TraceEvent.endSection("image.NinePatchHelper.drawNinePatch");
        return r12;
    L33:
        r2 = new Paint(1);     // Catch: Throwable -> L37
        r2.setAlpha(r23);     // Catch: Throwable -> L37
        goto L34
    L35:
        b(r14, r15, r16, r17, r18, r5, r6, r21, r22, r23);     // Catch: Throwable -> L37
        goto L36
    L17:
        if (r5.length != 4) goto L28;
        if (r5[0] == 0.0f) goto L21;
    L27:
        r0 = true;
        goto L29
    L21:
        if (r5[1] != 0.0f) goto L27;
        if (r5[2] != 0.0f) goto L27;
        if (r5[3] != 0.0f) goto L27;
    L6:
        if (r20.equalsIgnoreCase(NameKeys.UnloadStrategy_No_Strategy) == true) goto L13;
        r6 = CastFloatProtector.parseFloat(r20);     // Catch: Throwable -> L10
        goto L15
    L10:
        th = move-exception;
        LLog.w("BaseRoundedCornerPostprocessor", "initCapInsetsScale error " + th.getMessage());     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        LLog.w("BaseRoundedCornerPostprocessor", "process customDraw warn " + th.getMessage());
        goto L39
    }

    public static void b(int r32, int r33, int r34, int r35, m.b r36, float[] r37, float r38, Canvas r39, Bitmap r40, int r41) {
        TraceEvent.beginSection("image.NinePatchHelper.drawWithCapInsets");
        Rect r8 = new Rect(0, 0, (int) (r37[3] * r38), (int) (r37[0] * r38));
        float r14 = r34;
        Rect r10 = new Rect(r8.right, r8.top, (int) (r14 - (r37[1] * r38)), r8.bottom);
        Rect r11 = new Rect(r10.right, r8.top, r34, r8.bottom);
        float r7 = r35;
        Rect r12 = new Rect(r8.left, r8.bottom, r8.right, (int) (r7 - (r37[2] * r38)));
        Rect r5 = new Rect(r12.right, r12.top, r10.right, r12.bottom);
        Rect r9 = new Rect(r5.right, r12.top, r11.right, r12.bottom);
        Rect r13 = new Rect(r12.left, r12.bottom, r12.right, r35);
        Rect r15 = new Rect(r13.right, r13.top, r5.right, r13.bottom);
        Rect r6 = new Rect(r15.right, r13.top, r9.right, r13.bottom);
        Rect r16 = new Rect();
        Rect r17 = new Rect();
        Rect r18 = new Rect();
        Rect r19 = new Rect();
        Rect r20 = new Rect();
        Rect r110 = new Rect();
        Rect r21 = new Rect();
        Rect r22 = new Rect();
        Rect r23 = new Rect();
        float r24 = r33;
        float r25 = r32;
        float r2 = r32 / r34;
        float r3 = r33 / r35;
        if (r36 != m.b.b) goto L8;
        if (r2 > r3) goto L12;
    L11:
        float r26 = r7 * r2;
        float r27 = ((r24 - r26) / 2.0f) + 0.0f;
        float r0 = 0.0f;
    L18:
        int r1 = (int) r0;
        r16.left = r1;
        int r4 = (int) r27;
        r16.top = r4;
        r16.right = (int) (com.lynx.tasm.utils.i.b(r37[3], 0.0f) + r0);
        r16.bottom = (int) (com.lynx.tasm.utils.i.b(r37[0], 0.0f) + r27);
        r17.left = r16.right;
        r17.top = r16.top;
        int r28 = (int) ((r0 + r25) - com.lynx.tasm.utils.i.b(r37[1], 0.0f));
        r17.right = r28;
        r17.bottom = r16.bottom;
        r18.left = r28;
        r18.top = r16.top;
        r18.right = r1 + ((int) r25);
        r18.bottom = r16.bottom;
        r19.left = r16.left;
        r19.top = r16.bottom;
        r19.right = r16.right;
        int r29 = (int) ((r27 + r26) - com.lynx.tasm.utils.i.b(r37[2], 0.0f));
        r19.bottom = r29;
        r20.left = r19.right;
        r20.top = r19.top;
        int r30 = r17.right;
        r20.right = r30;
        r20.bottom = r29;
        r110.left = r30;
        r110.top = r18.bottom;
        r110.right = r18.right;
        r110.bottom = r19.bottom;
        r21.left = r16.left;
        r21.top = r19.bottom;
        int r31 = r19.right;
        r21.right = r31;
        int r42 = r4 + ((int) r26);
        r21.bottom = r42;
        r22.left = r31;
        r22.top = r20.bottom;
        int r43 = r20.right;
        r22.right = r43;
        r22.bottom = r42;
        r23.left = r43;
        r23.top = r110.bottom;
        r23.right = r110.right;
        r23.bottom = r42;
        Paint r44 = new Paint(1);
        r44.setAlpha(r41);
        r39.drawBitmap(r40, r8, r16, r44);
        r39.drawBitmap(r40, r10, r17, r44);
        r39.drawBitmap(r40, r11, r18, r44);
        r39.drawBitmap(r40, r12, r19, r44);
        r39.drawBitmap(r40, r5, r20, r44);
        r39.drawBitmap(r40, r9, r110, r44);
        r39.drawBitmap(r40, r13, r21, r44);
        r39.drawBitmap(r40, r15, r22, r44);
        r39.drawBitmap(r40, r6, r23, r44);
        TraceEvent.endSection("image.NinePatchHelper.drawWithCapInsets");
        return;
    L12:
        float r111 = r14 * r3;
        float r45 = ((r25 - r111) / 2.0f) + 0.0f;
    L17:
        r0 = r45;
        r26 = r24;
        r25 = r111;
        r27 = 0.0f;
        goto L18
    L8:
        if (r36 != m.b.d) goto L14;
        if (r2 <= r3) goto L12;
    L14:
        if (r36 != m.b.c) goto L16;
        float r46 = com.lynx.tasm.utils.i.b(1.0f, 0.0f);
        int r47 = (int) (r14 * r46);
        int r48 = (int) (r7 * r46);
        r0 = Math.round((r32 - r47) * 0.5f);
        r27 = Math.round((r33 - r48) * 0.5f);
        r25 = r47;
        r26 = r48;
        goto L18
    L16:
        r111 = r25;
        r45 = 0.0f;
        goto L17
    }
}
