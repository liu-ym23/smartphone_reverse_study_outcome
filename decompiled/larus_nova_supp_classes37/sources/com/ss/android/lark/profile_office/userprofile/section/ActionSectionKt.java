package com.ss.android.lark.profile_office.userprofile.section;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.compose.foundation.widget.a;
import com.ss.android.lark.profile_office.userprofile.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ActionSectionKt {
    public static final void a(final boolean r23, final boolean r24, final a r25, final Function1<? super k, Unit> r26, Composer r27, final int r28) {
        Intrinsics.checkNotNullParameter(r25, "blockSwitchState");
        Intrinsics.checkNotNullParameter(r26, "onIntent");
        Composer r15 = r27.startRestartGroup(-619716365);
        if ((r28 & 6) == 0) goto L5;
        int r6 = r28;
    L11:
        if ((r28 & 48) != 0) goto L18;
        if (r15.changed(r24) == false) goto L15;
        int r7 = 32;
    L16:
        r6 = r6 | r7;
        goto L18
    L15:
        r7 = 16;
    L18:
        if ((r28 & 384) != 0) goto L25;
        if (r15.changed(r25) == false) goto L22;
        int r8 = 256;
    L23:
        r6 = r6 | r8;
        goto L25
    L22:
        r8 = 128;
    L25:
        if ((r28 & 3072) != 0) goto L32;
        if (r15.changedInstance(r26) == false) goto L29;
        int r9 = 2048;
    L30:
        r6 = r6 | r9;
        goto L32
    L29:
        r9 = 1024;
    L32:
        if ((r6 & 1171) != 1170) goto L38;
        if (r15.getSkipping() == false) goto L38;
        r15.skipToGroupEnd();
        Composer r0 = r15;
    L52:
        ScopeUpdateScope r10 = r0.endRestartGroup();
        if (r10 == null) goto L57;
        r10.updateScope(new ActionSectionKt$ActionSection$3(r23, r24, r25, r26, r28));
        return;
    L57:
        return;
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventStart(-619716365, r6, -1, "com.ss.android.lark.profile_office.userprofile.section.ActionSection (ActionSection.kt:26)");
    L40:
        if (r23 == true) goto L49;
        if (r24 == true) goto L49;
        if (ComposerKt.isTraceInProgress() == false) goto L45;
        ComposerKt.traceEventEnd();
    L45:
        ScopeUpdateScope r11 = r15.endRestartGroup();
        if (r11 == null) goto L56;
        r11.updateScope(new ActionSectionKt$ActionSection$1(r23, r24, r25, r26, r28));
        return;
    L56:
        return;
    L49:
        Modifier r16 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null);
        float r1 = 16;
        float r17 = Dp.constructor-impl(r1);
        float r19 = Dp.constructor-impl(r1);
        r0 = r15;
        SurfaceKt.Surface-T9BRK9s(PaddingKt.padding-qDBjuR0$default(r16, r17, Dp.constructor-impl(r1), r19, 0.0f, 8, null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(r1)), n.a(r15, 0).c.c, 0, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1764385522, true, new ActionSectionKt$ActionSection$2(r23, r24, r26, r25), r15, 54), r0, 12582912, 120);
        if (ComposerKt.isTraceInProgress() == false) goto L52;
        ComposerKt.traceEventEnd();
        goto L52
    L5:
        if (r15.changed(r23) == false) goto L7;
        int r12 = 4;
    L8:
        r6 = r12 | r28;
        goto L11
    L7:
        r12 = 2;
        goto L8
    }
}
