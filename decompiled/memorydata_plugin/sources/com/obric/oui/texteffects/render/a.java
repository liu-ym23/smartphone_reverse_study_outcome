package com.obric.oui.texteffects.render;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class a extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f14651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14652b;
    private final float c;
    private final int d;
    private final float e;

    public a(m r1, int r2, float r3, int r4, float r5) {
        this.f14651a = r1;
        this.f14652b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        b("create AnimatedCharacterSpan index=" + r2 + ", widthPx=" + r3 + ", advancePx=" + r4 + ", xCorrectionPx=" + r5);
    }

    private static void a(String r1) {
        if (com.obric.oui.texteffects.a.a() == true) goto L5;
        return;
    L5:
        if (com.obric.oui.texteffects.a.b() == false) goto L9;
        Log.d("OUITextEffects/AnimatedCharacterSpan", r1);
        return;
    }

    private static void b(String r1) {
        if (com.obric.oui.texteffects.a.a() == false) goto L6;
        Log.d("OUITextEffects/AnimatedCharacterSpan", r1);
        return;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r19, CharSequence r20, int r21, int r22, float r23, int r24, int r25, int r26, Paint r27) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r20, CharSequence.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L59;
        if (r21 >= r22) goto L59;
        TextPaint r10 = this.f14651a.n();
        com.obric.oui.texteffects.runtime.m.a r11 = this.f14651a.o();
        if (r11 != null) goto L9;
    L11:
        boolean r12 = false;
    L12:
        if (r12 == false) goto L14;
        float r14 = r11.d()[this.f14652b];
    L16:
        if (r14 > 0.001f) goto L20;
        StringBuilder r0 = new StringBuilder().append("skip draw index=").append(this.f14652b).append(", char=").append(r5.subSequence(r21, r22)).append(", alphaRatio=").append(r14).append(", hasFrame=").append(r12);
    L18:
        a(r0.toString());
        return;
    L20:
        if (r12 == false) goto L22;
        float r6 = r11.e()[this.f14652b];
    L23:
        if (r12 == false) goto L25;
        float r13 = r11.f()[this.f14652b];
    L26:
        if (r12 == false) goto L28;
        float r7 = r11.g()[this.f14652b];
    L29:
        float r15 = this.e + r23;
        boolean r28 = r12;
        int r16 = r10.getAlpha();
        if (com.obric.oui.texteffects.a.a() == false) goto L40;
        if (com.obric.oui.texteffects.a.b() == false) goto L40;
        StringBuilder r1 = new StringBuilder().append("draw index=").append(this.f14652b).append(", char=").append(r5.subSequence(r21, r22)).append(", widthPx=").append(this.c).append(", advancePx=").append(this.d).append(", xCorrectionPx=").append(this.e).append(", x=").append(r23).append(", correctedX=").append(r15).append(", y=").append(r25).append(", tx=").append(r6).append(", ty=").append(r13).append(", scale=").append(r7).append(", alphaRatio=").append(r14).append(", paintColor=0x").append(Integer.toHexString(r10.getColor())).append(", paintAlpha=").append(r10.getAlpha()).append(", hasShader=");
        if (r10.getShader() == null) goto L36;
        boolean r8 = true;
    L37:
        a(r1.append(r8).append(", hasFrame=").append(r28).toString());
        goto L40
    L36:
        r8 = false;
    L40:
        if (r7 != 1.0f) goto L43;
        r19.drawText(r5, r21, r22, r6 + r15, r25 + r13, r10);
        int r9 = r16;
    L42:
        r10.setAlpha(r9);
        return;
    L43:
        r9 = r16;
        int r17 = r19.save();
    L55:
        th = th;
        Canvas r18 = r19;
    L57:
        r18.restoreToCount(r17);
        r10.setAlpha(r9);
        throw th;
    L45:
        if (Math.abs(r7 - 1.0f) <= 0.001f) goto L49;
        r18 = r19;
        r18.scale(r7, r7, (this.c / 2.0f) + r15, r25);     // Catch: Throwable -> L53
    L50:
        r19.drawText(r5, r21, r22, r6 + r15, r25 + r13, r10);     // Catch: Throwable -> L53
        r18.restoreToCount(r17);
    L53:
        th = th;
        goto L57
    L49:
        r18 = r19;
        goto L50
    L28:
        r7 = 1.0f;
        goto L29
    L25:
        r13 = 0.0f;
        goto L26
    L22:
        r6 = 0.0f;
        goto L23
    L14:
        r14 = 1.0f;
        goto L16
    L9:
        if (this.f14652b >= r11.a()) goto L11;
        r12 = true;
    L59:
        StringBuilder r2 = new StringBuilder().append("skip draw index=").append(this.f14652b).append(", start=").append(r21).append(", end=").append(r22).append(", textNull=");
        if (r5 != null) goto L62;
        boolean r29 = true;
    L63:
        r0 = r2.append(r29);
        goto L18
    L62:
        r29 = false;
        goto L63
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        return this.d;
    }
}
