package com.lynx.tasm.behavior.ui.utils;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
public final enum BorderStyle extends Enum<BorderStyle> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BorderStyle f10730a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BorderStyle f10731b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BorderStyle f10732c = null;
    public static final BorderStyle d = null;
    public static final BorderStyle e = null;
    public static final BorderStyle f = null;
    public static final BorderStyle g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final BorderStyle f10733h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ BorderStyle[] f10734i = null;

    static {
        BorderStyle r5 = new BorderStyle("SOLID", 0);
        f10730a = r5;
        BorderStyle r10 = new BorderStyle("DASHED", 1);
        f10731b = r10;
        BorderStyle r11 = new BorderStyle("DOTTED", 2);
        f10732c = r11;
        BorderStyle r12 = new BorderStyle("DOUBLE", 3);
        d = r12;
        BorderStyle r13 = new BorderStyle("GROOVE", 4);
        e = r13;
        BorderStyle r14 = new BorderStyle("RIDGE", 5);
        f = r14;
        BorderStyle r15 = new BorderStyle("INSET", 6);
        BorderStyle r16 = new BorderStyle("OUTSET", 7);
        BorderStyle r17 = new BorderStyle("HIDDEN", 8);
        g = r17;
        BorderStyle r18 = new BorderStyle("NONE", 9);
        f10733h = r18;
        f10734i = new BorderStyle[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18};
    }

    public BorderStyle(String r5, int r10) {
        super(r5, r10);
    }

    public static void a(Canvas r12, Paint r13, int r14, float r15, float r16, int r17, int r18, float r19, float r20, float r21, float r22) {
        r13.setPathEffect(null);
        r13.setStrokeWidth(r15);
        int r10 = -1;
    L4:
        if (r10 > 1) goto L29;
        float r5 = 0.0f;
        if (r14 == 0) goto L23;
        if (r14 != 1) goto L9;
        float r11 = r10 * r16;
        if (r10 == 1) goto L26;
    L27:
        int r23 = r18;
    L28:
        r13.setColor(r23);
        r12.drawLine(r19 + r5, r20 + r11, r21 + r5, r22 + r11, r13);
        r10 = r10 + 2;
    L26:
        r23 = r17;
        goto L28
    L9:
        if (r14 != 2) goto L11;
        float r24 = (-r16) * r10;
        if (r10 != 1) goto L19;
    L18:
        float r110 = r24;
        r11 = 0.0f;
        r5 = r110;
    L19:
        float r111 = r24;
        r11 = 0.0f;
        r5 = r111;
        goto L26
    L11:
        if (r14 == 3) goto L13;
        r23 = 0;
        r11 = 0.0f;
        goto L28
    L13:
        r11 = (-r16) * r10;
        if (r10 != 1) goto L26;
    L23:
        r24 = r10 * r16;
        if (r10 != 1) goto L18;
    }

    public static BorderStyle valueOf(String r5) {
        return (BorderStyle) Enum.valueOf(BorderStyle.class, r5);
    }

    public static BorderStyle[] values() {
        return (BorderStyle[]) f10734i.clone();
    }

    public final void a(Canvas r16, Paint r17, int r18, float r19, int r20, float r21, float r22, float r23, float r24, float r25, float r26) {
        switch(ordinal()) {
            case 1: goto L40;
            case 2: goto L40;
            case 3: goto L37;
            case 4: goto L32;
            case 5: goto L26;
            case 6: goto L15;
            case 7: goto L7;
            case 8: goto L5;
            case 9: goto L5;
            default: goto L60;
        };
    L5:
        return;
    L37:
        a(r16, r17, r18, r19 / 3.0f, r26 / 3.0f, r20, r20, r21, r22, r23, r24);
        return;
    L60:
        int r5 = r20;
    L19:
        DashPathEffect r10 = null;
    L55:
        r17.setStyle(Paint.Style.STROKE);
        r17.setColor(r5);
        r17.setPathEffect(r10);
        r17.setStrokeWidth(r19);
        r16.drawLine(r21, r22, r23, r24, r17);
        r17.setPathEffect(null);
        return;
    L7:
        if ((r20 & 15790320) != 0) goto L11;
        if (r18 == 1) goto L18;
        if (r18 == 0) goto L18;
        r5 = r20;
    L18:
        r5 = r20 | 8421504;
        goto L19
    L11:
        if (r18 == 3) goto L24;
        if (r18 == 2) goto L24;
        r5 = r20;
    L24:
        r5 = ((r20 & 16711422) >> 1) | (r20 & ViewCompat.MEASURED_STATE_MASK);
        goto L19
    L15:
        if ((r20 & 15790320) != 0) goto L20;
        if (r18 == 3) goto L18;
        if (r18 == 2) goto L18;
        r5 = r20;
        goto L19
    L20:
        if (r18 == 1) goto L24;
        if (r18 == 0) goto L24;
        r5 = r20;
        goto L19
    L26:
        if ((r20 & 15790320) != 0) goto L29;
        a(r16, r17, r18, r19 / 2.0f, r26 / 4.0f, r20, r20 | 8421504, r21, r22, r23, r24);
        return;
    L29:
        a(r16, r17, r18, r19 / 2.0f, r26 / 4.0f, ((r20 & 16711422) >> 1) | (r20 & ViewCompat.MEASURED_STATE_MASK), r20, r21, r22, r23, r24);
        return;
    L32:
        if ((r20 & 15790320) != 0) goto L35;
        a(r16, r17, r18, r19 / 2.0f, r26 / 4.0f, r20 | 8421504, r20, r21, r22, r23, r24);
        return;
    L35:
        a(r16, r17, r18, r19 / 2.0f, r26 / 4.0f, r20, ((r20 & 16711422) >> 1) | (r20 & ViewCompat.MEASURED_STATE_MASK), r21, r22, r23, r24);
        return;
    L40:
        if (this != f10731b) goto L42;
    L44:
        float r11 = 1.0f;
        if (r26 < 1.0f) goto L48;
        r11 = r26;
    L48:
        if (this != f10732c) goto L50;
        int r12 = 2;
    L51:
        int r13 = (((int) (((r25 / ((r11 * r12) * 0.5f)) - 0.5f) * 0.5f)) * 2) + 1;
        if (r13 <= 1) goto L61;
        float r14 = r25 / r13;
        r10 = new DashPathEffect(new float[]{r14, r14}, 0.0f);
        r5 = r20;
        goto L55
    L61:
        r5 = r20;
        goto L19
    L50:
        r12 = 6;
        goto L51
    L42:
        if (this == f10732c) goto L44;
        r5 = r20;
        goto L19
    }
}
