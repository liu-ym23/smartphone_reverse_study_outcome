package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
final class d extends f<CircularProgressIndicatorSpec> {
    private int c;
    private float d;
    private float e;
    private float f;

    public d(CircularProgressIndicatorSpec r1) {
        super(r1);
        this.c = 1;
    }

    private void a(Canvas r2, Paint r3, float r4, float r5, float r6) {
        r2.save();
        r2.rotate(r6);
        float r1 = this.f;
        float r7 = r4 / 2.0f;
        r2.drawRoundRect(new RectF(r1 - r7, r5, r1 + r7, -r5), r5, r5, r3);
        r2.restore();
    }

    private int c() {
        return ((CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4016a, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).g + (((CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4016a, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).h * 2);
    }

    @Override // com.google.android.material.progressindicator.f
    public int a() {
        return c();
    }

    @Override // com.google.android.material.progressindicator.f
    public void a(Canvas r7, float r8) {
        float r0 = (((CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4016a, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).g / 2.0f) + ((CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4016a, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).h;
        r7.translate(r0, r0);
        r7.rotate(-90.0f);
        float r3 = -r0;
        r7.clipRect(r3, r3, r0, r0);
        if (((CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4016a, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).i != 0) goto L5;
        int r9 = 1;
    L6:
        this.c = r9;
        this.d = ((CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4016a, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).f4011a * r8;
        this.e = ((CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4016a, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).f4012b * r8;
        this.f = (((CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4016a, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).g - ((CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4016a, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).f4011a) / 2.0f;
        if (this.f4017b.isShowing() == false) goto L11;
        if (((CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4016a, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).e != 2) goto L11;
    L14:
        float r10 = this.f + (((1.0f - r8) * ((CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4016a, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).f4011a) / 2.0f);
    L15:
        this.f = r10;
        return;
    L11:
        if (this.f4017b.isHiding() == false) goto L17;
        if (((CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4016a, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).f == 1) goto L14;
    L17:
        if (this.f4017b.isShowing() == false) goto L21;
        if (((CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4016a, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).e != 1) goto L21;
    L24:
        r10 = this.f - (((1.0f - r8) * ((CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4016a, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).f4011a) / 2.0f);
    L21:
        if (this.f4017b.isHiding() == true) goto L23;
        return;
    L23:
        if (((CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4016a, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).f == 2) goto L24;
        return;
    L5:
        r9 = -1;
        goto L6
    }

    @Override // com.google.android.material.progressindicator.f
    void a(Canvas r8, Paint r9) {
        int r0 = com.google.android.material.c.a.b(((CircularProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4016a, CircularProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).d, this.f4017b.getAlpha());
        r9.setStyle(Paint.Style.STROKE);
        r9.setStrokeCap(Paint.Cap.BUTT);
        r9.setAntiAlias(true);
        r9.setColor(r0);
        r9.setStrokeWidth(this.d);
        float r7 = this.f;
        r8.drawArc(new RectF(-r7, -r7, r7, r7), 0.0f, 360.0f, false, r9);
    }

    @Override // com.google.android.material.progressindicator.f
    void a(Canvas r12, Paint r13, float r14, float r15, int r16) {
        if (r14 != r15) goto L5;
        return;
    L5:
        r13.setStyle(Paint.Style.STROKE);
        r13.setStrokeCap(Paint.Cap.BUTT);
        r13.setAntiAlias(true);
        r13.setColor(r16);
        r13.setStrokeWidth(this.d);
        int r1 = this.c;
        float r9 = (r14 * 360.0f) * r1;
        if (r15 < r14) goto L8;
        float r0 = r15 - r14;
    L9:
        float r2 = (r0 * 360.0f) * r1;
        float r3 = this.f;
        r12.drawArc(new RectF(-r3, -r3, r3, r3), r9, r2, false, r13);
        if (this.e > 0.0f) goto L12;
        return;
    L12:
        if (Math.abs(r2) >= 360.0f) goto L16;
        r13.setStyle(Paint.Style.FILL);
        a(r12, r13, this.d, this.e, r9);
        a(r12, r13, this.d, this.e, r9 + r2);
        return;
    L16:
        return;
    L8:
        r0 = (1.0f + r15) - r14;
        goto L9
    }

    @Override // com.google.android.material.progressindicator.f
    public int b() {
        return c();
    }
}
