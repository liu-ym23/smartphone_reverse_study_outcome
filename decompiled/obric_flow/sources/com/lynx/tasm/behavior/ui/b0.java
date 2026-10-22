package com.lynx.tasm.behavior.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import androidx.core.view.ViewCompat;
import com.lynx.tasm.behavior.ui.utils.BorderStyle;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BorderStyle f10421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f10422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f10423c;
    public Rect d;
    public Paint e;
    public Path f;

    public final void a(Canvas r40) {
        BorderStyle r5 = this.f10421a;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.equals(BorderStyle.f10733h) == false) goto L7;
        return;
    L7:
        if (this.f10421a.equals(BorderStyle.g) == false) goto L10;
        return;
    L10:
        if (this.f10423c < 0.001d) goto L35;
        Rect r10 = this.d;
        if (r10 != null) goto L15;
        return;
    L15:
        if (r10.width() >= 1) goto L17;
        return;
    L17:
        if (this.d.height() < 1) goto L36;
        int r12 = r40.save();
        Rect r11 = this.d;
        int r13 = r11.left;
        int r14 = r11.top;
        int r15 = r11.width();
        int r16 = r11.height();
        float r17 = this.f10423c;
        if (r17 >= 1.0f) goto L22;
        int r18 = 1;
    L23:
        Paint r19 = new Paint();
        this.e = r19;
        r19.setAntiAlias(false);
        this.e.setStyle(Paint.Style.STROKE);
        Integer r20 = this.f10422b;
        if (r20 == null) goto L27;
        int r21 = r20.intValue();
    L26:
        int r28 = r21;
        float r22 = r13;
        float r23 = r14;
        float r24 = r13 - r18;
        float r25 = r14 - r18;
        int r26 = r13 + r15;
        float r27 = r26 + r18;
        float r29 = r26;
        float r30 = r18;
        float r210 = r30 * 0.5f;
        float r211 = r23 - r210;
        r40.save();
        int r37 = r18;
        b(r40, r22, r23, r24, r25, r27, r25, r29, r23);
        int r38 = r37 * 2;
        float r110 = r15 + r38;
        this.f10421a.a(r40, this.e, 1, this.f10423c, r28, r24, r211, r27, r211, r110, r30);
        r40.restore();
        int r111 = r14 + r16;
        float r31 = r111;
        float r112 = r111 + r37;
        float r212 = r29 + r210;
        r40.save();
        b(r40, r29, r23, r29, r31, r27, r112, r27, r25);
        float r113 = r16 + r38;
        this.f10421a.a(r40, this.e, 2, this.f10423c, r28, r212, r25, r212, r112, r113, r30);
        r40.restore();
        float r213 = r31 + r210;
        r40.save();
        b(r40, r22, r31, r29, r31, r27, r112, r24, r112);
        this.f10421a.a(r40, this.e, 3, this.f10423c, r28, r27, r213, r24, r213, r110, r30);
        r40.restore();
        float r214 = r22 - r210;
        r40.save();
        b(r40, r22, r23, r24, r25, r24, r112, r22, r31);
        this.f10421a.a(r40, this.e, 0, this.f10423c, r28, r214, r112, r214, r25, r113, r30);
        r40.restore();
        this.e.setAntiAlias(true);
        r40.restoreToCount(r12);
        return;
    L27:
        r21 = ViewCompat.MEASURED_STATE_MASK;
        goto L26
    L22:
        r18 = Math.round(r17);
        goto L23
    L36:
        return;
    }

    public final void b(Canvas r5, float r10, float r11, float r12, float r13, float r14, float r15, float r16, float r17) {
        if (this.f != null) goto L5;
        this.f = new Path();
    L5:
        this.f.reset();
        this.f.moveTo(r10, r11);
        this.f.lineTo(r12, r13);
        this.f.lineTo(r14, r15);
        this.f.lineTo(r16, r17);
        this.f.lineTo(r10, r11);
        r5.clipPath(this.f);
    }
}
