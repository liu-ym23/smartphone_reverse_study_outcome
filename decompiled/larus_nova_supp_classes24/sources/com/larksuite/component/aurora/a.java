package com.larksuite.component.aurora;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import com.larksuite.component.universe_design.color.UDColorUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a extends AuroraDelegate {
    @Override // com.larksuite.component.aurora.AuroraDelegate
    public final void f() {
        this.a.invalidate();
    }

    public a(AuroraView r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
    }

    @Override // com.larksuite.component.aurora.AuroraDelegate
    public final void b(Canvas r19, AuroraView.a r20, Function1<? super RectF, Unit> r21, Function1<? super Integer, Integer> r22) {
        Intrinsics.checkNotNullParameter(r19, "canvas");
        Intrinsics.checkNotNullParameter(r20, "blob");
        Intrinsics.checkNotNullParameter(r21, "boundModifier");
        Intrinsics.checkNotNullParameter(r22, "colorModifier");
        d().set(r20.c);
        r21.invoke(d());
        int r1 = ((Number) r22.invoke(Integer.valueOf(r20.a()))).intValue();
        float r2 = d().width() + this.a.getBlurRadius$aurora_release();
        float r3 = d().height() + this.a.getBlurRadius$aurora_release();
        float r4 = d().centerX();
        float r5 = d().centerY();
        float r6 = Math.min(r2, r3);
        int r15 = r19.save();
        r19.scale(r2 / r6, r3 / r6, r4, r5);
        float r7 = (r6 - this.a.getBlurRadius$aurora_release()) / r6;
        c().setShader(new RadialGradient(r4, r5, r6 / 2.0f, new int[]{r1, UDColorUtils.getAlphaColor(r1, (Color.alpha(r1) / 255.0f) * Math.max(0.45f, r7)), UDColorUtils.getAlphaColor(r1, (Color.alpha(r1) / 255.0f) * Math.min(0.45f, r7)), UDColorUtils.getAlphaColor(r1, (Color.alpha(r1) / 255.0f) * 0.0f)}, new float[]{0.0f, Math.min(0.45f, r7), Math.max(0.45f, r7), 1.0f}, Shader.TileMode.CLAMP));
        float r8 = r6 / 2;
        r19.drawOval(r4 - r8, r5 - r8, r4 + r8, r5 + r8, c());
        r19.restoreToCount(r15);
    }
}
