package eba;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends ViewOutlineProvider {
    public final jba.c a;

    public a(jba.c r2) {
        Intrinsics.checkNotNullParameter(r2, "cornerRadii");
        this.a = r2;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r9, Outline r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        Intrinsics.checkNotNullParameter(r10, "outline");
        if (r9.getWidth() > 0) goto L5;
        return;
    L5:
        if (r9.getHeight() > 0) goto L7;
        return;
    L7:
        if (this.a.a() == false) goto L13;
        float r0 = Math.min(r9.getWidth(), r9.getHeight()) / 2.0f;
        jba.c r1 = this.a;
        r10.setRoundRect(0, 0, r9.getWidth(), r9.getHeight(), RangesKt.coerceAtMost(r0, ComparisonsKt.maxOf(r1.a, new float[]{r1.b, r1.c, r1.d, 0.0f})));
        return;
    }
}
