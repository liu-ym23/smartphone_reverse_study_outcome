package com.larksuite.component.aurora;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b extends AuroraDelegate {
    @Override // com.larksuite.component.aurora.AuroraDelegate
    public final void f() {
        this.a.invalidate();
    }

    @Override // com.larksuite.component.aurora.AuroraDelegate
    public final Paint a() {
        Paint r0 = super.a();
        r0.setColor(0);
        return r0;
    }

    public b(AuroraView r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
    }

    @Override // com.larksuite.component.aurora.AuroraDelegate
    public final void b(Canvas r4, AuroraView.a r5, Function1<? super RectF, Unit> r6, Function1<? super Integer, Integer> r7) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        Intrinsics.checkNotNullParameter(r5, "blob");
        Intrinsics.checkNotNullParameter(r6, "boundModifier");
        Intrinsics.checkNotNullParameter(r7, "colorModifier");
        int r8 = ((Number) r7.invoke(Integer.valueOf(r5.a()))).intValue();
        if (this.a.getBlurRadius$aurora_release() != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        c().setColor(r8);
    L9:
        c().setShadowLayer(this.a.getBlurRadius$aurora_release(), 0.0f, 0.0f, r8);
        d().set(r5.c);
        r6.invoke(d());
        r4.drawOval(d(), c());
        return;
    L8:
        c().setColor(0);
        goto L9
    L5:
        r0 = false;
        goto L6
    }
}
