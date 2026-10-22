package com.larksuite.component.universe_design.icon.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.PainterResources_androidKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f {
    public static final Painter getActivity(c r2, Composer r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r3.startReplaceGroup(2063659071);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(2063659071, r4, -1, "com.larksuite.component.universe_design.icon.compose.<get-Activity> (UDIconsFilled.android.kt:13)");
    L5:
        Painter r5 = PainterResources_androidKt.painterResource(2131253527, r3, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        r3.endReplaceGroup();
        return r5;
    }
}
