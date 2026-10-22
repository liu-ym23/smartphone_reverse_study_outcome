package com.larksuite.component.universe_design.emptystate.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import com.larksuite.component.universe_design.compose.foundation.i0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c {
    public static final float a = 0.0f;

    static {
        Dp.constructor-impl(245);
        a = Dp.constructor-impl(100);
    }

    public static b a(Composer r8) {
        r8.startReplaceGroup(-2021518817);
        long r1 = i0.a(r8).b();
        long r3 = i0.a(r8).d.f.b;
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-2021518817, 384, -1, "com.larksuite.component.universe_design.emptystate.compose.UDEmptyStateDefaults.colors (UDEmptyState.kt:394)");
    L5:
        b r0 = new b(r1, r3);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        r8.endReplaceGroup();
        return r0;
    }

    public static d b(Composer r10) {
        r10.startReplaceGroup(-1070150511);
        float r4 = Dp.constructor-impl(16);
        float r5 = Dp.constructor-impl(12);
        float r6 = Dp.constructor-impl(4);
        float r7 = Dp.constructor-impl(16);
        float r8 = Dp.constructor-impl(12);
        float r9 = Dp.constructor-impl(20);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1070150511, 1572864, -1, "com.larksuite.component.universe_design.emptystate.compose.UDEmptyStateDefaults.dimensions (UDEmptyState.kt:409)");
    L5:
        d r0 = new d(r4, r5, r6, r7, r8, r9);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        r10.endReplaceGroup();
        return r0;
    }
}
