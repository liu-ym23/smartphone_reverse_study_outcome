package com.obric.common.oea.foundation.graphics.smoothcorner.a;

import android.graphics.Path;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/obric/common/oea/foundation/graphics/smoothcorner/impl/FigmaSmoothCornerImpl;", "Lcom/obric/common/oea/foundation/graphics/smoothcorner/impl/ISmoothCornerImpl;", "()V", "DEGREES_TO_RADIANS", "", "smoothness", "", "type", "", "getType", "()Ljava/lang/String;", "buildPath", "Landroid/graphics/Path;", "left", "top", "right", "bottom", "radius", "canDraw", "", "minDimension", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class c extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f7761b;
    private final float c;
    private final String d;

    public c() {
        this.f7761b = 0.017453292519943295d;
        this.c = 0.6f;
        this.d = "FigmaSmoothCornerImpl";
    }

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.a.d
    public Path a(float r51, float r52, float r53, float r54, float r55) {
        float r5 = r53 - r51;
        float r7 = Math.min(r5, r54 - r52);
        Path r15 = new Path();
        if (r55 == 0.0f) goto L14;
        if (r55 >= (0.5f * r7)) goto L14;
        float r9 = Math.min(r7 / 2.0f, (this.c + 1.0f) * r55);
        float r8 = r7 / 4.0f;
        if (r55 <= r8) goto L10;
        float r14 = this.c;
        float r10 = 1.0f - ((r55 - r8) / r8);
        float r11 = 90 * (1.0f - (r14 * r10));
        float r12 = 45 * r14;
    L11:
        float r16 = (90 - r11) / 2.0f;
        double r13 = r12 * r10;
        float r17 = (float) Math.tan(this.f7761b * r13);
        float r18 = ((float) Math.tan(((double) (r16 / 2.0f)) * this.f7761b)) * r55;
        float r3 = (float) ((Math.sin(((double) (r11 / 2.0f)) * this.f7761b) * ((double) r55)) * Math.sqrt(2.0d));
        float r19 = r18 * ((float) Math.cos(r13 * this.f7761b));
        float r0 = r19 * r17;
        float r4 = ((r9 - r3) - ((r17 + 1.0f) * r19)) / 3.0f;
        e r20 = new e(r51 + (r5 / 2.0f), r52);
        float r110 = r53 - r9;
        e r6 = new e(r110, r52);
        float r21 = r9 - (r4 * 2.0f);
        float r111 = r53 - r21;
        e r112 = new e(r111, r52);
        float r22 = r21 - r4;
        float r113 = r53 - r22;
        e r114 = new e(r113, r52);
        float r23 = r22 - r19;
        float r24 = r53 - r23;
        float r115 = r52 + r0;
        e r116 = new e(r24, r115);
        float r25 = r53 - r55;
        float r117 = r52 + r55;
        float r118 = r53 - r0;
        float r1 = r52 + r23;
        new e(r118, r1);
        float r2 = r52 + r22;
        e r119 = new e(r53, r2);
        float r26 = r52 + r21;
        e r120 = new e(r53, r26);
        float r27 = r52 + r9;
        e r121 = new e(r53, r27);
        float r28 = r54 - r9;
        e r122 = new e(r53, r28);
        float r29 = r54 - r21;
        e r123 = new e(r53, r29);
        float r30 = r54 - r22;
        e r124 = new e(r53, r30);
        float r125 = r54 - r23;
        e r31 = new e(r118, r125);
        float r32 = r54 - r55;
        float r126 = r54 - r0;
        new e(r24, r126);
        e r33 = new e(r113, r54);
        e r34 = new e(r111, r54);
        e r127 = new e(r110, r54);
        float r128 = r9 + r51;
        e r129 = new e(r128, r54);
        float r35 = r21 + r51;
        e r36 = new e(r35, r54);
        float r37 = r22 + r51;
        e r38 = new e(r37, r54);
        float r39 = r23 + r51;
        e r40 = new e(r39, r126);
        float r41 = r51 + r55;
        float r42 = r0 + r51;
        new e(r42, r125);
        e r43 = new e(r51, r30);
        e r44 = new e(r51, r29);
        e r130 = new e(r51, r28);
        e r45 = new e(r51, r27);
        e r46 = new e(r51, r26);
        e r47 = new e(r51, r2);
        e r48 = new e(r42, r1);
        new e(r39, r115);
        e r49 = new e(r37, r52);
        e r50 = new e(r35, r52);
        e r56 = new e(r128, r52);
        r15.moveTo(r20.a(), r20.b());
        r15.lineTo(r6.a(), r6.b());
        r15.cubicTo(r112.a(), r112.b(), r114.a(), r114.b(), r116.a(), r116.b());
        d.f7762a.a(r15, new e(r25, r117), r55, r16 + 270.0f, 360.0f - r16);
        r15.cubicTo(r119.a(), r119.b(), r120.a(), r120.b(), r121.a(), r121.b());
        r15.lineTo(r122.a(), r122.b());
        r15.cubicTo(r123.a(), r123.b(), r124.a(), r124.b(), r31.a(), r31.b());
        d.f7762a.a(r15, new e(r25, r32), r55, r16, 90.0f - r16);
        r15.cubicTo(r33.a(), r33.b(), r34.a(), r34.b(), r127.a(), r127.b());
        r15.lineTo(r129.a(), r129.b());
        r15.cubicTo(r36.a(), r36.b(), r38.a(), r38.b(), r40.a(), r40.b());
        d.f7762a.a(r15, new e(r41, r32), r55, r16 + 90.0f, 180.0f - r16);
        r15.cubicTo(r43.a(), r43.b(), r44.a(), r44.b(), r130.a(), r130.b());
        r15.lineTo(r45.a(), r45.b());
        r15.cubicTo(r46.a(), r46.b(), r47.a(), r47.b(), r48.a(), r48.b());
        d.f7762a.a(r15, new e(r41, r117), r55, r16 + 180.0f, 270.0f - r16);
        r15.cubicTo(r49.a(), r49.b(), r50.a(), r50.b(), r56.a(), r56.b());
        r15.close();
        return r15;
    L10:
        r10 = this.c;
        r11 = 90 * (1.0f - r10);
        r12 = 45;
    L14:
        return b(r51, r52, r53, r54, r55);
    }

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.a.d
    public boolean a(float r1, float r2) {
        if (r1 >= (r2 * 0.5f)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.common.oea.foundation.graphics.smoothcorner.a.d
    public String getType() {
        return this.d;
    }
}
