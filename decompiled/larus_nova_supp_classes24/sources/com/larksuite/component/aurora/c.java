package com.larksuite.component.aurora;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c extends AuroraDelegate {
    @Override // com.larksuite.component.aurora.AuroraDelegate
    public final void e() {
        if (this.a.getBlurRadius$aurora_release() != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        this.a.setRenderEffect(null);
        return;
    L8:
        AuroraView r1 = this.a;
        r1.setRenderEffect(RenderEffect.createBlurEffect(r1.getBlurRadius$aurora_release(), this.a.getBlurRadius$aurora_release(), Shader.TileMode.CLAMP));
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.larksuite.component.aurora.AuroraDelegate
    public final void f() {
        e();
    }

    public c(AuroraView r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
    }

    @Override // com.larksuite.component.aurora.AuroraDelegate
    public final void b(Canvas r2, AuroraView.a r3, Function1<? super RectF, Unit> r4, Function1<? super Integer, Integer> r5) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        Intrinsics.checkNotNullParameter(r3, "blob");
        Intrinsics.checkNotNullParameter(r4, "boundModifier");
        Intrinsics.checkNotNullParameter(r5, "colorModifier");
        int r6 = ((Number) r5.invoke(Integer.valueOf(r3.a()))).intValue();
        c().setColor(r6);
        d().set(r3.c);
        r4.invoke(d());
        r2.drawOval(d(), c());
    }
}
