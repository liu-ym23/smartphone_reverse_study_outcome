package com.lynx.tasm.behavior.ui.utils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BorderStyle.values().length];
            a = r0;
            r0[BorderStyle.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L26:
            a[BorderStyle.HIDDEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L32:
            a[BorderStyle.DASHED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L42:
            a[BorderStyle.DOTTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L28:
            a[BorderStyle.SOLID.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
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

    public static void c(Canvas r45, Paint r46, Rect r47, int[] r48, int[] r49, BorderStyle[] r50) {
        if (r48.length != 4) goto L108;
        if (r49 != null) goto L6;
        return;
    L6:
        if (r49.length == 4) goto L8;
        return;
    L8:
        if (r50.length != 4) goto L111;
        int r15 = r48[0];
        int r10 = r48[1];
        int r9 = r48[2];
        int r8 = r48[3];
        if (r15 > 0) goto L17;
        if (r9 > 0) goto L17;
        if (r10 > 0) goto L17;
        if (r8 > 0) goto L17;
        boolean r1 = false;
    L18:
        if (r1 == false) goto L105;
        int r18 = r49[0];
        int r5 = r49[1];
        int r19 = r49[2];
        int r20 = r49[3];
        int r7 = r47.left;
        int r6 = r47.top;
        r46.setAntiAlias(false);
        r46.setStyle(Paint.Style.STROKE);
        int r2 = -1;
        if (r15 <= 0) goto L22;
        int r3 = r18;
    L23:
        if (r10 <= 0) goto L25;
        int r4 = r5;
    L26:
        int r11 = r3 & r4;
        if (r9 <= 0) goto L29;
        int r12 = r19;
    L30:
        int r13 = r11 & r12;
        if (r8 <= 0) goto L33;
        r2 = r20;
    L33:
        int r14 = r2 & r13;
        if (r15 <= 0) goto L36;
        int r16 = r18;
    L37:
        if (r10 <= 0) goto L39;
        int r17 = r5;
    L40:
        int r21 = r16 | r17;
        if (r9 <= 0) goto L43;
        int r22 = r19;
    L44:
        int r23 = r21 | r22;
        if (r8 <= 0) goto L47;
        int r24 = r20;
    L49:
        if (r14 != (r23 | r24)) goto L51;
        int r25 = r14;
    L53:
        if (r25 == 0) goto L84;
        BorderStyle r26 = r50[0];
        BorderStyle r27 = r50[1];
        if (r26 != r27) goto L62;
        BorderStyle r28 = r50[2];
        if (r27 != r28) goto L62;
        if (r28 != r50[3]) goto L62;
        boolean r29 = r26.isSolidDashedOrDotted();
    L63:
        if (r29 == false) goto L84;
        if (Color.alpha(r25) == 0) goto L105;
        int r30 = r47.right;
        int r31 = r47.bottom;
        BorderStyle r110 = r50[1];
        if (r15 != r10) goto L74;
        if (r10 != r9) goto L74;
        if (r9 != r8) goto L74;
        if (r110 != BorderStyle.SOLID) goto L74;
        r46.setStyle(Paint.Style.STROKE);
        float r0 = r15;
        r46.setStrokeWidth(r0);
        r46.setColor(r25);
        float r32 = r0 * 0.5f;
        r45.drawRect(new RectF(r7 + r32, r6 + r32, r30 - r32, r31 - r32), r46);
        Paint r33 = r46;
    L106:
        r33.setAntiAlias(true);
        return;
    L74:
        if (r10 <= 0) goto L76;
        float r34 = r10;
        float r111 = r6 + (r34 * 0.5f);
        int r112 = r25;
        int r113 = r7;
        r110.strokeBorderLine(r45, r46, 1, r34, r112, r7, r111, r30 - Math.max(r9, 0), r111, r30 - r7, r34);
        int r114 = r9;
    L77:
        if (r114 <= 0) goto L79;
        float r115 = r114;
        float r35 = r30 - (r115 * 0.5f);
        int r36 = r112;
        int r37 = r6;
        int r38 = r30;
        r110.strokeBorderLine(r45, r46, 2, r115, r36, r35, r6, r35, r31 - Math.max(r8, 0), r31 - r6, r115);
        int r116 = r8;
    L80:
        if (r116 <= 0) goto L82;
        float r117 = r116;
        float r39 = r31 - (r117 * 0.5f);
        int r40 = r38;
        int r41 = r112;
        r110.strokeBorderLine(r45, r46, 3, r117, r41, r40, r39, r113 + Math.max(r15, 0), r39, r40 - r113, r117);
    L82:
        if (r15 <= 0) goto L105;
        float r118 = r15;
        float r42 = r113 + (0.5f * r118);
        int r43 = r37;
        int r44 = r112;
        r110.strokeBorderLine(r45, r46, 0, r118, r44, r42, r31, r42, r43 + Math.max(r10, 0), r31 - r43, r118);
        goto L105
    L79:
        r38 = r30;
        r37 = r6;
        r116 = r8;
        goto L80
    L76:
        r112 = r25;
        r113 = r7;
        r114 = r9;
    L62:
        r29 = false;
    L84:
        int r119 = r47.width();
        int r51 = r47.height();
        if (r10 > 0) goto L87;
    L89:
        int r310 = r6;
    L90:
        if (r11 > 0) goto L92;
    L94:
        int r120 = r310;
        int r410 = r51;
        int r411 = r10;
    L95:
        int r121 = r411;
        if (r121 > 0) goto L98;
    L100:
        int r412 = r410;
    L101:
        if (r15 <= 0) goto L105;
        if (Color.alpha(r18) == 0) goto L105;
        float r52 = r7 + r15;
        float r53 = r120 + r9;
        int r54 = r412;
        int r55 = r120 + r54;
        float r56 = r55 - r121;
        float r57 = r55;
        float r58 = r7;
        float r122 = r15;
        float r59 = r58 + (0.5f * r122);
        r45.save();
        float r60 = r120;
        a(r45, r58, r60, r52, r53, r52, r56, r58, r57);
        r50[0].strokeBorderLine(r45, r46, 0, r122, r18, r59, r57, r59, r60, r54, r122);
        r45.restore();
        goto L105
    L98:
        if (Color.alpha(r20) == 0) goto L100;
        int r123 = r410;
        int r61 = r120 + r123;
        float r62 = r61;
        int r63 = r7 + r119;
        float r64 = r63;
        float r65 = r63 - r11;
        float r66 = r61 - r121;
        float r67 = r7 + r15;
        float r124 = r121;
        float r68 = r62 - (r124 * 0.5f);
        r45.save();
        float r69 = r7;
        a(r45, r69, r62, r64, r62, r65, r66, r67, r66);
        r412 = r123;
        r50[3].strokeBorderLine(r45, r46, 3, r124, r20, r64, r68, r69, r68, r119, r124);
        r45.restore();
        goto L101
    L92:
        if (Color.alpha(r19) == 0) goto L94;
        int r70 = r7 + r119;
        float r71 = r70;
        int r125 = r310;
        int r72 = r125 + r51;
        float r73 = r72;
        float r74 = r70 - r11;
        float r75 = r9;
        float r311 = r71 - (r75 * 0.5f);
        r45.save();
        float r76 = r125;
        a(r45, r71, r76, r71, r73, r74, r72 - r8, r74, r125 + r10);
        r411 = r8;
        r410 = r51;
        r120 = r125;
        r50[2].strokeBorderLine(r45, r46, 2, r75, r19, r311, r76, r311, r73, r51, r75);
        r45.restore();
        goto L95
    L87:
        if (Color.alpha(r5) == 0) goto L89;
        float r77 = r7 + r15;
        float r78 = r6 + r10;
        int r79 = r7 + r119;
        float r80 = r79 - r9;
        float r81 = r79;
        float r82 = r6;
        float r83 = r10;
        float r312 = r82 + (r83 * 0.5f);
        r45.save();
        float r84 = r7;
        a(r45, r84, r82, r77, r78, r80, r78, r81, r82);
        r310 = r6;
        r50[1].strokeBorderLine(r45, r46, 1, r83, r5, r84, r312, r81, r312, r119, r83);
        r45.restore();
        goto L90
    L51:
        r25 = 0;
        goto L53
    L47:
        r24 = 0;
        goto L49
    L43:
        r22 = 0;
        goto L44
    L39:
        r17 = 0;
        goto L40
    L36:
        r16 = 0;
        goto L37
    L29:
        r12 = -1;
        goto L30
    L25:
        r4 = -1;
        goto L26
    L22:
        r3 = -1;
    L105:
        r33 = r46;
    L17:
        r1 = true;
        goto L18
    L111:
        return;
    }

    public static void a(Canvas r1, float r2, float r3, float r4, float r5, float r6, float r7, float r8, float r9) {
        Path r0 = new Path();
        r0.reset();
        r0.moveTo(r2, r3);
        r0.lineTo(r4, r5);
        r0.lineTo(r6, r7);
        r0.lineTo(r8, r9);
        r0.lineTo(r2, r3);
        r1.clipPath(r0);
    }

    public static void d(Canvas r9, Paint r10, BorderStyle r11, int r12, int r13, float r14, float r15, x6a.j r16, x6a.j r17) {
        switch(a.a[r11.ordinal()]) {
            case 1: goto L20;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L19;
            case 5: goto L21;
            case 6: goto L16;
            case 7: goto L12;
            case 8: goto L9;
            case 9: goto L7;
            case 10: goto L5;
            default: goto L4;
        };
    L4:
        LLog.e("BorderDrawingUtil", "Unsupported border style: " + r11);
        goto L21
    L5:
        e(r9, r10, r12, r14 / 2.0f, BorderStyle.darkenColor(r13), r13, false, r16, r17);
        return;
    L7:
        e(r9, r10, r12, r14 / 2.0f, r13, BorderStyle.darkenColor(r13), false, r16, r17);
        return;
    L9:
        e(r9, r10, r12, r14 / 3.0f, r13, r13, true, r16, r17);
        return;
    L16:
        if (r12 == 1) goto L18;
        if (r12 != 0) goto L21;
    L18:
        int r0 = BorderStyle.darkenColor(r13);
    L22:
        PathEffect r2 = null;
    L23:
        r10.setStyle(Paint.Style.STROKE);
        r10.setColor(c.a(r0, 255));
        r10.setStrokeWidth(r15);
        r10.setPathEffect(r2);
        r10.setAntiAlias(true);
        new BackgroundDrawable.RoundRectPath(r16, r17, BackgroundDrawable.RoundRectPath.Pos.CENTER).b(r9, r10);
        r10.setPathEffect(null);
        return;
    L19:
        r2 = r11.getPathEffect(r14);
        r0 = r13;
        goto L23
    L20:
        return;
    L21:
        r0 = r13;
        goto L22
    L12:
        if (r12 != 3) goto L14;
    L15:
        r0 = BorderStyle.darkenColor(r13);
        goto L22
    L14:
        if (r12 != 2) goto L21;
        goto L15
    }

    public static void e(Canvas r2, Paint r3, int r4, float r5, int r6, int r7, boolean r8, x6a.j r9, x6a.j r10) {
        r3.setPathEffect(null);
        r3.setStyle(Paint.Style.STROKE);
        r3.setStrokeWidth(r5);
        boolean r11 = true;
        if (r4 == 1) goto L7;
        if (r4 == 0) goto L7;
        r11 = false;
    L7:
        if (r11 == false) goto L9;
        int r12 = r7;
    L10:
        r3.setColor(c.a(r12, 255));
        if (r8 == false) goto L13;
        BackgroundDrawable.RoundRectPath.Pos r1 = BackgroundDrawable.RoundRectPath.Pos.OUTER3;
    L14:
        new BackgroundDrawable.RoundRectPath(r9, r10, r1).b(r2, r3);
        if (r11 == true) goto L18;
        r6 = r7;
    L18:
        r3.setColor(c.a(r6, 255));
        if (r8 == false) goto L21;
        BackgroundDrawable.RoundRectPath.Pos r13 = BackgroundDrawable.RoundRectPath.Pos.INNER3;
    L22:
        new BackgroundDrawable.RoundRectPath(r9, r10, r13).b(r2, r3);
        return;
    L21:
        r13 = BackgroundDrawable.RoundRectPath.Pos.INNER2;
        goto L22
    L13:
        r1 = BackgroundDrawable.RoundRectPath.Pos.OUTER2;
        goto L14
    L9:
        r12 = r6;
        goto L10
    }

    public static void b(Canvas r2, float r3, float r4, float r5, float r6, float r7, float r8, float r9, float r10, boolean r11, x6a.j r12, x6a.j r13) {
        if (r11 == false) goto L4;
        Path r14 = new Path();
        r14.addRoundRect(r12.a, r12.b, Path.Direction.CW);
        r2.clipPath(r14, Region.Op.INTERSECT);
        Path r15 = new Path();
        r15.addRoundRect(r13.a, r13.b, Path.Direction.CW);
        r2.clipPath(r15, Region.Op.DIFFERENCE);
    L4:
        a(r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }
}
