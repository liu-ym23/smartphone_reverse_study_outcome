package com.lynx.tasm.behavior.ui.utils;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum BorderStyle extends Enum<BorderStyle> {
    public static final BorderStyle DASHED = null;
    public static final BorderStyle DOTTED = null;
    public static final BorderStyle DOUBLE = null;
    public static final BorderStyle GROOVE = null;
    public static final BorderStyle HIDDEN = null;
    public static final BorderStyle INSET = null;
    public static final BorderStyle NONE = null;
    public static final BorderStyle OUTSET = null;
    public static final BorderStyle RIDGE = null;
    public static final BorderStyle SOLID = null;
    public static final /* synthetic */ BorderStyle[] a = null;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BorderStyle.values().length];
            a = r0;
            r0[BorderStyle.DASHED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L26:
            a[BorderStyle.DOTTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L32:
            a[BorderStyle.SOLID.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L42:
            a[BorderStyle.NONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L28:
            a[BorderStyle.HIDDEN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L34:
            a[BorderStyle.INSET.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L36:
            a[BorderStyle.OUTSET.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L38:
            a[BorderStyle.DOUBLE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L24:
            a[BorderStyle.GROOVE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L30:
            a[BorderStyle.RIDGE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    public static int darkenColor(int r2) {
        int r0 = (16711422 & r2) >> 1;
        return (r2 & (-16777216)) | r0;
    }

    static {
        BorderStyle r0 = new BorderStyle("SOLID", 0);
        SOLID = r0;
        BorderStyle r1 = new BorderStyle("DASHED", 1);
        DASHED = r1;
        BorderStyle r3 = new BorderStyle("DOTTED", 2);
        DOTTED = r3;
        BorderStyle r5 = new BorderStyle("DOUBLE", 3);
        DOUBLE = r5;
        BorderStyle r7 = new BorderStyle("GROOVE", 4);
        GROOVE = r7;
        BorderStyle r9 = new BorderStyle("RIDGE", 5);
        RIDGE = r9;
        BorderStyle r11 = new BorderStyle("INSET", 6);
        INSET = r11;
        BorderStyle r13 = new BorderStyle("OUTSET", 7);
        OUTSET = r13;
        BorderStyle r15 = new BorderStyle("HIDDEN", 8);
        HIDDEN = r15;
        BorderStyle r14 = new BorderStyle("NONE", 9);
        NONE = r14;
        a = new BorderStyle[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
    }

    public static BorderStyle[] values() {
        return (BorderStyle[]) a.clone();
    }

    public boolean isSolidDashedOrDotted() {
        int r0 = a.a[ordinal()];
        if (r0 != 1) goto L5;
    L10:
        return true;
    L5:
        if (r0 == 2) goto L10;
        if (r0 == 3) goto L10;
        return false;
    }

    public static BorderStyle parse(int r1) {
        if (r1 >= 0) goto L4;
        return null;
    L4:
        if (r1 <= NONE.ordinal()) goto L7;
        return null;
    L7:
        return values()[r1];
    }

    public static BorderStyle valueOf(String r1) {
        return (BorderStyle) r27.a.a(BorderStyle.class, r1);
    }

    public PathEffect getPathEffect(float r9) {
        int r0 = a.a[ordinal()];
        if (r0 == 1) goto L9;
        if (r0 == 2) goto L8;
        return null;
    L8:
        return new DashPathEffect(new float[]{r9, r9, r9, r9}, 0.0f);
    L9:
        float r10 = r9 * 3.0f;
        return new DashPathEffect(new float[]{r10, r10, r10, r10}, 0.0f);
    }

    public BorderStyle(String r1, int r2) {
        super(r1, r2);
    }

    public PathEffect getPathEffectAutoAdjust(float r4, float r5) {
        if (this == DASHED) goto L8;
        if (this == DOTTED) goto L8;
        return null;
    L8:
        if (r4 >= 1.0f) goto L12;
        r4 = 1.0f;
    L12:
        if (this != DOTTED) goto L14;
        int r0 = 2;
    L15:
        int r6 = (((int) (((r5 / ((r4 * r0) * 0.5f)) - 0.5f) * 0.5f)) * 2) + 1;
        if (r6 > 1) goto L18;
        return null;
    L18:
        float r7 = r5 / r6;
        return new DashPathEffect(new float[]{r7, r7}, 0.0f);
    L14:
        r0 = 6;
        goto L15
    }

    public static void a(Canvas r11, Paint r12, int r13, float r14, float r15, int r16, int r17, float r18, float r19, float r20, float r21) {
        r12.setPathEffect(null);
        r12.setStrokeWidth(r14);
        int r9 = -1;
    L4:
        if (r9 > 1) goto L29;
        float r1 = 0.0f;
        if (r13 == 0) goto L23;
        if (r13 != 1) goto L9;
        float r2 = r9 * r15;
        if (r9 != 1) goto L22;
    L21:
        int r0 = r16;
    L28:
        r12.setColor(r0);
        r11.drawLine(r18 + r1, r19 + r2, r20 + r1, r21 + r2, r12);
        r9 = r9 + 2;
    L22:
        r0 = r17;
        goto L28
    L9:
        if (r13 != 2) goto L11;
        float r3 = (-r15) * r9;
        if (r9 == 1) goto L26;
    L25:
        r0 = r16;
    L27:
        r1 = r3;
        r2 = 0.0f;
    L26:
        r0 = r17;
        goto L27
    L11:
        if (r13 == 3) goto L13;
        r0 = 0;
        r3 = 0.0f;
        goto L27
    L13:
        r2 = (-r15) * r9;
        if (r9 != 1) goto L21;
    L23:
        r3 = r9 * r15;
        if (r9 != 1) goto L26;
    }

    public void strokeBorderLine(Canvas r15, Paint r16, int r17, float r18, int r19, float r20, float r21, float r22, float r23, float r24, float r25) {
        boolean r4 = false;
        switch(a.a[ordinal()]) {
            case 1: goto L43;
            case 2: goto L43;
            case 3: goto L44;
            case 4: goto L42;
            case 5: goto L42;
            case 6: goto L32;
            case 7: goto L22;
            case 8: goto L19;
            case 9: goto L13;
            case 10: goto L6;
            default: goto L44;
        };
    L19:
        a(r15, r16, r17, r18 / 3.0f, r25 / 3.0f, r19, r19, r20, r21, r22, r23);
        return;
    L42:
        return;
    L43:
        PathEffect r2 = getPathEffectAutoAdjust(r25, r24);
        int r1 = r19;
    L46:
        r16.setStyle(Paint.Style.STROKE);
        r16.setColor(r1);
        r16.setPathEffect(r2);
        r16.setStrokeWidth(r18);
        r15.drawLine(r20, r21, r22, r23, r16);
        r16.setPathEffect(null);
        return;
    L44:
        r1 = r19;
    L45:
        r2 = null;
        goto L46
    L6:
        if ((r19 & 15790320) != 0) goto L8;
        r4 = true;
    L8:
        if (r4 == false) goto L10;
        a(r15, r16, r17, r18 / 2.0f, r25 / 4.0f, r19, r19 | 8421504, r20, r21, r22, r23);
        return;
    L10:
        a(r15, r16, r17, r18 / 2.0f, r25 / 4.0f, darkenColor(r19), r19, r20, r21, r22, r23);
        return;
    L13:
        if ((r19 & 15790320) != 0) goto L15;
        r4 = true;
    L15:
        if (r4 == false) goto L17;
        a(r15, r16, r17, r18 / 2.0f, r25 / 4.0f, r19 | 8421504, r19, r20, r21, r22, r23);
        return;
    L17:
        a(r15, r16, r17, r18 / 2.0f, r25 / 4.0f, r19, darkenColor(r19), r20, r21, r22, r23);
        return;
    L22:
        if ((r19 & 15790320) != 0) goto L24;
        r4 = true;
    L24:
        if (r4 == false) goto L28;
        if (r17 == 1) goto L37;
        if (r17 != 0) goto L44;
    L37:
        r1 = r19 | 8421504;
        goto L45
    L28:
        if (r17 == 3) goto L30;
        if (r17 != 2) goto L44;
    L30:
        r1 = darkenColor(r19);
        goto L45
    L32:
        if ((r19 & 15790320) != 0) goto L34;
        r4 = true;
    L34:
        if (r4 == false) goto L38;
        if (r17 == 3) goto L37;
        if (r17 != 2) goto L44;
    L38:
        if (r17 == 1) goto L40;
        if (r17 != 0) goto L44;
    L40:
        r1 = darkenColor(r19);
        goto L45
    }
}
