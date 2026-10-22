package com.larksuite.component.universe_design.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i0 {
    static {
    }

    public static g0 a(Composer r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(678023549, 0, -1, "com.larksuite.component.universe_design.compose.foundation.UDTheme.<get-colorScheme> (UDTheme.kt:30)");
    L5:
        g0 r5 = (g0) r4.consume(CompositionLocalsKt.a);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static j0 b(Composer r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-544769436, 0, -1, "com.larksuite.component.universe_design.compose.foundation.UDTheme.<get-typography> (UDTheme.kt:35)");
    L5:
        j0 r5 = (j0) r4.consume(CompositionLocalsKt.b);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }
}
