package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
final class h extends f<LinearProgressIndicatorSpec> {
    private float c;
    private float d;
    private float e;

    public h(LinearProgressIndicatorSpec r1) {
        super(r1);
        this.c = 300.0f;
    }

    @Override // com.google.android.material.progressindicator.f
    public int a() {
        return -1;
    }

    @Override // com.google.android.material.progressindicator.f
    public void a(Canvas r9, float r10) {
        Rect r0 = r9.getClipBounds();
        this.c = r0.width();
        float r1 = ((LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4016a, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).f4011a;
        r9.translate(r0.left + (r0.width() / 2.0f), (r0.top + (r0.height() / 2.0f)) + Math.max(0.0f, (r0.height() - ((LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4016a, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).f4011a) / 2.0f));
        if (((LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4016a, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).i == false) goto L6;
        r9.scale(-1.0f, 1.0f);
    L6:
        if (this.f4017b.isShowing() == false) goto L10;
        if (((LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4016a, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).e != 1) goto L10;
    L13:
        r9.scale(1.0f, -1.0f);
    L15:
        if (this.f4017b.isShowing() == false) goto L17;
    L18:
        r9.translate(0.0f, (((LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4016a, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).f4011a * (r10 - 1.0f)) / 2.0f);
    L19:
        float r2 = this.c;
        r9.clipRect((-r2) / 2.0f, (-r1) / 2.0f, r2 / 2.0f, r1 / 2.0f);
        this.d = ((LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4016a, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).f4011a * r10;
        this.e = ((LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4016a, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).f4012b * r10;
        return;
    L17:
        if (this.f4017b.isHiding() == false) goto L19;
    L10:
        if (this.f4017b.isHiding() == false) goto L15;
        if (((LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4016a, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).f != 2) goto L15;
        goto L13
    }

    @Override // com.google.android.material.progressindicator.f
    void a(Canvas r7, Paint r8) {
        int r0 = com.google.android.material.c.a.b(((LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4016a, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).d, this.f4017b.getAlpha());
        r8.setStyle(Paint.Style.FILL);
        r8.setAntiAlias(true);
        r8.setColor(r0);
        float r1 = this.c;
        float r4 = this.d;
        RectF r2 = new RectF((-r1) / 2.0f, (-r4) / 2.0f, r1 / 2.0f, r4 / 2.0f);
        float r6 = this.e;
        r7.drawRoundRect(r2, r6, r6, r8);
    }

    @Override // com.google.android.material.progressindicator.f
    public void a(Canvas r6, Paint r7, float r8, float r9, int r10) {
        if (r8 != r9) goto L5;
        return;
    L5:
        float r0 = this.c;
        float r3 = this.e;
        float r1 = ((-r0) / 2.0f) + (r8 * (r0 - (r3 * 2.0f)));
        float r11 = (((-r0) / 2.0f) + (r9 * (r0 - (r3 * 2.0f)))) + (r3 * 2.0f);
        r7.setStyle(Paint.Style.FILL);
        r7.setAntiAlias(true);
        r7.setColor(r10);
        float r12 = this.d;
        RectF r13 = new RectF(r1, (-r12) / 2.0f, r11, r12 / 2.0f);
        float r5 = this.e;
        r6.drawRoundRect(r13, r5, r5, r7);
    }

    @Override // com.google.android.material.progressindicator.f
    public int b() {
        return ((LinearProgressIndicatorSpec) ZeusTransformUtils.preCheckCast(this.f4016a, LinearProgressIndicatorSpec.class, "com.obric.memorydata.plugin")).f4011a;
    }
}
