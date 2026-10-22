package com.ss.android.lark.profile_office.userprofile.dialog;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ReportPopupKt {
    public static final void a(final float r11, final Function0<Unit> r12, final Function0<Unit> r13, Composer r14, final int r15) {
        Intrinsics.checkNotNullParameter(r12, "onDismiss");
        Intrinsics.checkNotNullParameter(r13, "onReport");
        Composer r16 = r14.startRestartGroup(-1266042672);
        if ((r15 & 6) == 0) goto L5;
        int r1 = r15;
    L11:
        if ((r15 & 48) != 0) goto L18;
        if (r16.changedInstance(r12) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r15 & 384) != 0) goto L25;
        if (r16.changedInstance(r13) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r1 & 147) != 146) goto L31;
        if (r16.getSkipping() == false) goto L31;
        r16.skipToGroupEnd();
    L36:
        ScopeUpdateScope r17 = r16.endRestartGroup();
        if (r17 == null) goto L40;
        r17.updateScope(new ReportPopupKt$ReportPopup$2(r11, r12, r13, r15));
        return;
    L40:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventStart(-1266042672, r1, -1, "com.ss.android.lark.profile_office.userprofile.dialog.ReportPopup (ReportPopup.kt:37)");
    L33:
        AndroidPopup_androidKt.Popup-K5zGePQ(Alignment.Companion.getTopEnd(), 0, r12, new PopupProperties(true, true, true, false, 8, null), ComposableLambdaKt.rememberComposableLambda(623752845, true, new ReportPopupKt$ReportPopup$1(r12, r11, r13), r16, 54), r16, ((r1 << 3) & 896) | 27654, 2);
        if (ComposerKt.isTraceInProgress() == false) goto L36;
        ComposerKt.traceEventEnd();
        goto L36
    L5:
        if (r16.changed(r11) == false) goto L7;
        int r4 = 4;
    L8:
        r1 = r4 | r15;
        goto L11
    L7:
        r4 = 2;
        goto L8
    }
}
