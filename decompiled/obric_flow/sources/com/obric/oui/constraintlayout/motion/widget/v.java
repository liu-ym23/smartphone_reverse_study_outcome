package com.obric.oui.constraintlayout.motion.widget;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float[] f12900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f12901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f12902c;
    public Path d;
    public final Paint e;
    public final Paint f;
    public final Paint g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f12903h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Paint f12904i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float[] f12905j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f12906k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Rect f12907l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f12908m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12909n;

    public v(MotionLayout r10) {
        this.f12909n = r10;
        this.f12907l = new Rect();
        this.f12908m = 1;
        Paint r5 = new Paint();
        this.e = r5;
        r5.setAntiAlias(true);
        r5.setColor(-21965);
        r5.setStrokeWidth(2.0f);
        Paint.Style r11 = Paint.Style.STROKE;
        r5.setStyle(r11);
        Paint r12 = new Paint();
        this.f = r12;
        r12.setAntiAlias(true);
        r12.setColor(-2067046);
        r12.setStrokeWidth(2.0f);
        r12.setStyle(r11);
        Paint r13 = new Paint();
        this.g = r13;
        r13.setAntiAlias(true);
        r13.setColor(-13391360);
        r13.setStrokeWidth(2.0f);
        r13.setStyle(r11);
        Paint r14 = new Paint();
        this.f12903h = r14;
        r14.setAntiAlias(true);
        r14.setColor(-13391360);
        r14.setTextSize(r10.getContext().getResources().getDisplayMetrics().density * 12.0f);
        this.f12905j = new float[8];
        Paint r15 = new Paint();
        this.f12904i = r15;
        r15.setAntiAlias(true);
        r13.setPathEffect(new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f));
        this.f12902c = new float[100];
        this.f12901b = new int[50];
    }

    public final void a(Canvas r23, int r24, int r25, q r26) {
        int[] r10 = this.f12901b;
        int r14 = 4;
        if (r24 != 4) goto L17;
        int r5 = 0;
        boolean r11 = false;
        boolean r15 = false;
    L6:
        if (r5 >= this.f12906k) goto L13;
        int r12 = r10[r5];
        if (r12 != 1) goto L10;
        r11 = true;
    L10:
        if (r12 != 0) goto L12;
        r15 = true;
    L12:
        r5 = r5 + 1;
        goto L6
    L13:
        if (r11 == false) goto L15;
        float[] r13 = this.f12900a;
        r23.drawLine(r13[0], r13[1], r13[r13.length - 2], r13[r13.length - 1], this.g);
    L15:
        if (r15 == false) goto L17;
        b(r23);
    L17:
        if (r24 != 2) goto L20;
        float[] r16 = this.f12900a;
        r23.drawLine(r16[0], r16[1], r16[r16.length - 2], r16[r16.length - 1], this.g);
    L20:
        if (r24 != 3) goto L22;
        b(r23);
    L22:
        r23.drawLines(this.f12900a, this.e);
        View r17 = r26.f12874b;
        if (r17 == null) goto L25;
        int r18 = r17.getWidth();
        int r19 = r26.f12874b.getHeight();
    L26:
        int r20 = 1;
    L28:
        if (r20 >= (r25 - 1)) goto L54;
        if (r24 == r14) goto L31;
    L33:
        int r21 = r20 * 2;
        float[] r22 = this.f12902c;
        float r27 = r22[r21];
        float r28 = r22[r21 + 1];
        this.d.reset();
        this.d.moveTo(r27, r28 + 10.0f);
        this.d.lineTo(r27 + 10.0f, r28);
        this.d.lineTo(r27, r28 - 10.0f);
        this.d.lineTo(r27 - 10.0f, r28);
        this.d.close();
        int r29 = r20 - 1;
        a0 r30 = (a0) r26.f12888u.get(r29);
        Paint r31 = this.f12904i;
        if (r24 != r14) goto L44;
        int r32 = r10[r29];
        if (r32 != 1) goto L39;
        d(r23, r27 - 0.0f, r28 - 0.0f);
    L43:
        r23.drawPath(this.d, r31);
    L45:
        if (r24 != 2) goto L47;
        d(r23, r27 - 0.0f, r28 - 0.0f);
    L47:
        if (r24 != 3) goto L50;
        c(r23, r27 - 0.0f, r28 - 0.0f);
    L50:
        if (r24 != 6) goto L52;
        e(r23, r27 - 0.0f, r28 - 0.0f, r18, r19);
    L52:
        r23.drawPath(this.d, r31);
    L53:
        r20 = r20 + 1;
        r14 = 4;
        goto L28
    L39:
        if (r32 != 0) goto L41;
        c(r23, r27 - 0.0f, r28 - 0.0f);
        goto L43
    L41:
        if (r32 != 2) goto L43;
        e(r23, r27 - 0.0f, r28 - 0.0f, r18, r19);
        goto L43
    L44:
        r31 = r31;
        r28 = r28;
        r27 = r27;
        r20 = r20;
        goto L45
    L31:
        if (r10[r20 - 1] != 0) goto L33;
        r20 = r20;
        goto L53
    L54:
        float[] r33 = this.f12900a;
        if (r33.length <= 1) goto L64;
        float r34 = r33[0];
        float r35 = r33[1];
        Paint r36 = this.f;
        r23.drawCircle(r34, r35, 8.0f, r36);
        float[] r37 = this.f12900a;
        r23.drawCircle(r37[r37.length - 2], r37[r37.length - 1], 8.0f, r36);
        return;
    L64:
        return;
    L25:
        r18 = 0;
        r19 = 0;
        goto L26
    }

    public final void b(Canvas r18) {
        float[] r5 = this.f12900a;
        float r10 = r5[0];
        float r11 = r5[1];
        float r12 = r5[r5.length - 2];
        float r13 = r5[r5.length - 1];
        float r14 = Math.min(r10, r12);
        float r15 = Math.max(r11, r13);
        float r16 = Math.max(r10, r12);
        float r17 = Math.max(r11, r13);
        Paint r19 = this.g;
        r18.drawLine(r14, r15, r16, r17, r19);
        r18.drawLine(Math.min(r10, r12), Math.min(r11, r13), Math.min(r10, r12), Math.max(r11, r13), r19);
    }

    public final void c(Canvas r21, float r22, float r23) {
        float[] r5 = this.f12900a;
        float r10 = r5[0];
        float r11 = r5[1];
        float r12 = r5[r5.length - 2];
        float r13 = r5[r5.length - 1];
        float r14 = Math.min(r10, r12);
        float r15 = Math.max(r11, r13);
        float r16 = r22 - Math.min(r10, r12);
        float r17 = Math.max(r11, r13) - r23;
        String r18 = "" + (((int) (((double) ((r16 * 100.0f) / Math.abs(r12 - r10))) + 0.5d)) / 100.0f);
        Paint r19 = this.f12903h;
        r19.getTextBounds(r18, 0, r18.length(), this.f12907l);
        Rect r20 = this.f12907l;
        r21.drawText(r18, ((r16 / 2.0f) - (r20.width() / 2)) + r14, r23 - 20.0f, r19);
        float r24 = Math.min(r10, r12);
        Paint r110 = this.g;
        r21.drawLine(r22, r23, r24, r23, r110);
        String r25 = "" + (((int) (((double) ((r17 * 100.0f) / Math.abs(r13 - r11))) + 0.5d)) / 100.0f);
        r19.getTextBounds(r25, 0, r25.length(), this.f12907l);
        r21.drawText(r25, r22 + 5.0f, r15 - ((r17 / 2.0f) - (r20.height() / 2)), r19);
        r21.drawLine(r22, r23, r22, Math.max(r11, r13), r110);
    }

    public final void d(Canvas r15, float r16, float r17) {
        float[] r5 = this.f12900a;
        float r10 = r5[0];
        float r11 = r5[1];
        float r12 = r5[r5.length - 2];
        float r13 = r5[r5.length - 1];
        float r14 = (float) Math.hypot(r10 - r12, r11 - r13);
        float r18 = r12 - r10;
        float r19 = r13 - r11;
        float r110 = (((r17 - r11) * r19) + ((r16 - r10) * r18)) / (r14 * r14);
        float r20 = r10 + (r18 * r110);
        float r21 = r11 + (r110 * r19);
        Path r111 = new Path();
        r111.moveTo(r16, r17);
        r111.lineTo(r20, r21);
        float r22 = (float) Math.hypot(r20 - r16, r21 - r17);
        String r23 = "" + (((int) ((r22 * 100.0f) / r14)) / 100.0f);
        Paint r112 = this.f12903h;
        r112.getTextBounds(r23, 0, r23.length(), this.f12907l);
        r15.drawTextOnPath(r23, r111, (r22 / 2.0f) - (this.f12907l.width() / 2), -20.0f, r112);
        r15.drawLine(r16, r17, r20, r21, this.g);
    }

    public final void e(Canvas r19, float r20, float r21, int r22, int r23) {
        StringBuilder r5 = new StringBuilder("");
        MotionLayout r10 = this.f12909n;
        r5.append(((int) (((double) (((r20 - (r22 / 2)) * 100.0f) / (r10.getWidth() - r22))) + 0.5d)) / 100.0f);
        String r11 = r5.toString();
        Paint r13 = this.f12903h;
        r13.getTextBounds(r11, 0, r11.length(), this.f12907l);
        Rect r12 = this.f12907l;
        r19.drawText(r11, ((r20 / 2.0f) - (r12.width() / 2)) + 0.0f, r21 - 20.0f, r13);
        float r16 = Math.min(0.0f, 1.0f);
        Paint r14 = this.g;
        r19.drawLine(r20, r21, r16, r21, r14);
        String r15 = "" + (((int) (((double) (((r21 - (r23 / 2)) * 100.0f) / (r10.getHeight() - r23))) + 0.5d)) / 100.0f);
        r13.getTextBounds(r15, 0, r15.length(), this.f12907l);
        r19.drawText(r15, r20 + 5.0f, 0.0f - ((r21 / 2.0f) - (r12.height() / 2)), r13);
        r19.drawLine(r20, r21, r20, Math.max(0.0f, 1.0f), r14);
    }
}
