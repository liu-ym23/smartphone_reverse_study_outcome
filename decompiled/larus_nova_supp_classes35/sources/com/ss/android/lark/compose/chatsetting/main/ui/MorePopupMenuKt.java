package com.ss.android.lark.compose.chatsetting.main.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MorePopupMenuKt {
    public static final void a(final Function0<Unit> r12, final Function0<Unit> r13, Composer r14, final int r15) {
        Intrinsics.checkNotNullParameter(r12, "onDismiss");
        Intrinsics.checkNotNullParameter(r13, "onReportClick");
        Composer r16 = r14.startRestartGroup(-1093617965);
        if ((r15 & 6) == 0) goto L5;
        int r1 = r15;
    L11:
        if ((r15 & 48) != 0) goto L18;
        if (r16.changedInstance(r13) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r1 & 19) != 18) goto L24;
        if (r16.getSkipping() == false) goto L24;
        r16.skipToGroupEnd();
    L29:
        ScopeUpdateScope r17 = r16.endRestartGroup();
        if (r17 == null) goto L33;
        r17.updateScope(new MorePopupMenuKt$MorePopupMenu$4(r12, r13, r15));
        return;
    L33:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(-1093617965, r1, -1, "com.ss.android.lark.compose.chatsetting.main.ui.MorePopupMenu (MorePopupMenu.kt:39)");
    L26:
        AndroidPopup_androidKt.Popup-K5zGePQ(Alignment.Companion.getTopEnd(), IntOffset.constructor-impl((((long) ((Density) r16.consume(CompositionLocalsKt.getLocalDensity())).roundToPx-0680j_4(Dp.constructor-impl(-8))) << 32) | (((long) ((Density) r16.consume(CompositionLocalsKt.getLocalDensity())).roundToPx-0680j_4(Dp.constructor-impl(44))) & 4294967295L)), r12, new PopupProperties(true, true, true, false, 8, null), ComposableLambdaKt.rememberComposableLambda(-118860042, true, new MorePopupMenuKt$MorePopupMenu$3(r13, r12), r16, 54), r16, ((r1 << 6) & 896) | 27654, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L29;
        ComposerKt.traceEventEnd();
        goto L29
    L5:
        if (r16.changedInstance(r12) == false) goto L7;
        int r3 = 4;
    L8:
        r1 = r3 | r15;
        goto L11
    L7:
        r3 = 2;
        goto L8
    }
}
