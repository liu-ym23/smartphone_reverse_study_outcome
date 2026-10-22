package com.ss.android.lark.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n {
    static {
    }

    public static q0 b(Composer r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1356771606, 0, -1, "com.ss.android.lark.compose.foundation.FlowTheme.<get-typography> (FlowTheme.kt:41)");
    L5:
        q0 r5 = (q0) r4.consume(CompositionLocalsKt.b);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    public static m a(Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-480135742, r4, -1, "com.ss.android.lark.compose.foundation.FlowTheme.<get-colorScheme> (FlowTheme.kt:36)");
    L5:
        m r5 = (m) r3.consume(FlowThemeKt.a);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }
}
