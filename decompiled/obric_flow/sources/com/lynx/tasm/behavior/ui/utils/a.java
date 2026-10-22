package com.lynx.tasm.behavior.ui.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RectF f10735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float[] f10736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Path f10737c;
    public boolean d;

    public static float[] c(float[] r17, RectF r18, float r19) {
        return new float[]{Math.max(r17[0] - (r18.left * r19), 0.0f), Math.max(r17[1] - (r18.top * r19), 0.0f), Math.max(r17[2] - (r18.right * r19), 0.0f), Math.max(r17[3] - (r18.top * r19), 0.0f), Math.max(r17[4] - (r18.right * r19), 0.0f), Math.max(r17[5] - (r18.bottom * r19), 0.0f), Math.max(r17[6] - (r18.left * r19), 0.0f), Math.max(r17[7] - (r18.bottom * r19), 0.0f)};
    }

    public final void a(Canvas r5, Paint r10) {
        if (this.d == false) goto L6;
        RectF r11 = this.f10735a;
        float[] r12 = this.f10736b;
        r5.drawRoundRect(r11, r12[0], r12[1], r10);
        return;
    L6:
        r5.drawPath(this.f10737c, r10);
    }

    public final void b(Rect r18, float[] r19, RectF r20, float r21, boolean r22) {
        if (this.f10735a != null) goto L5;
        this.f10735a = new RectF();
    L5:
        RectF r5 = this.f10735a;
        r5.left = (r20.left * r21) + r18.left;
        r5.top = (r20.top * r21) + r18.top;
        r5.right = r18.right - (r20.right * r21);
        r5.bottom = r18.bottom - (r20.bottom * r21);
        boolean r10 = true;
        int r11 = 2;
        if (r22 == false) goto L39;
        float r12 = r19[0];
        float r13 = r20.left;
        float r14 = r12 - (r13 * r21);
        float r15 = 0.0f;
        if (r13 <= 0.0f) goto L10;
        float r16 = r12 / r13;
    L11:
        float r17 = Math.max(r14, r16);
        float r23 = r19[1];
        float r24 = r20.top;
        float r110 = r23 - (r24 * r21);
        if (r24 <= 0.0f) goto L14;
        float r25 = r23 / r24;
    L15:
        float r26 = Math.max(r110, r25);
        float r27 = r19[2];
        float r111 = r20.right;
        float r112 = r27 - (r111 * r21);
        if (r111 <= 0.0f) goto L18;
        float r28 = r27 / r111;
    L19:
        float r29 = Math.max(r112, r28);
        float r113 = r19[3];
        float r114 = r20.top;
        float r115 = r113 - (r114 * r21);
        if (r114 <= 0.0f) goto L22;
        float r116 = r113 / r114;
    L23:
        float r117 = Math.max(r115, r116);
        float r118 = r19[4];
        float r119 = r20.right;
        float r120 = r118 - (r119 * r21);
        if (r119 <= 0.0f) goto L26;
        float r121 = r118 / r119;
    L27:
        float r122 = Math.max(r120, r121);
        float r123 = r19[5];
        float r124 = r20.bottom;
        float r125 = r123 - (r124 * r21);
        if (r124 <= 0.0f) goto L30;
        float r126 = r123 / r124;
    L31:
        float r127 = Math.max(r125, r126);
        float r128 = r19[6];
        float r129 = r20.left;
        float r30 = r128 - (r129 * r21);
        if (r129 <= 0.0f) goto L34;
        float r130 = r128 / r129;
    L35:
        float r31 = Math.max(r30, r130);
        float r131 = r19[7];
        float r32 = r20.bottom;
        float r132 = r131 - (r32 * r21);
        if (r32 <= 0.0f) goto L38;
        r15 = r131 / r32;
    L38:
        int r33 = 6;
        float[] r34 = {r17, r26, r29, r117, r122, r127, r31, Math.max(r132, r15)};
    L40:
        this.f10736b = r34;
    L41:
        if (r11 > r33) goto L54;
        float r35 = r34[r11] - r34[0];
        if (r35 > 1.0E-4f) goto L53;
        if (r35 < (-1.0E-4f)) goto L53;
        float r36 = r34[r11 + 1] - r34[1];
        if (r36 > 1.0E-4f) goto L53;
        if (r36 < (-1.0E-4f)) goto L53;
        r11 = r11 + 2;
    L53:
        r10 = false;
    L54:
        this.d = r10;
        Path r37 = this.f10737c;
        if (r37 != null) goto L57;
        this.f10737c = new Path();
    L58:
        this.f10737c.addRoundRect(this.f10735a, this.f10736b, Path.Direction.CW);
        return;
    L57:
        r37.reset();
        goto L58
    L34:
        r130 = 0.0f;
        goto L35
    L30:
        r126 = 0.0f;
        goto L31
    L26:
        r121 = 0.0f;
        goto L27
    L22:
        r116 = 0.0f;
        goto L23
    L18:
        r28 = 0.0f;
        goto L19
    L14:
        r25 = 0.0f;
        goto L15
    L10:
        r16 = 0.0f;
        goto L11
    L39:
        r33 = 6;
        r34 = c(r19, r20, r21);
        goto L40
    }
}
