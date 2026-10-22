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
import com.ss.android.lark.profile_office.userprofile.k;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DoubaoSectionKt {
    public static final void a(final boolean r23, final List<String> r24, final Function1<? super k, Unit> r25, Composer r26, final int r27) {
        Intrinsics.checkNotNullParameter(r24, "doubaoHomepageImages");
        Intrinsics.checkNotNullParameter(r25, "onIntent");
        Composer r15 = r26.startRestartGroup(1255663708);
        if ((r27 & 6) == 0) goto L5;
        int r5 = r27;
    L11:
        if ((r27 & 48) != 0) goto L18;
        if (r15.changedInstance(r24) == false) goto L15;
        int r6 = 32;
    L16:
        r5 = r5 | r6;
        goto L18
    L15:
        r6 = 16;
    L18:
        if ((r27 & 384) != 0) goto L25;
        if (r15.changedInstance(r25) == false) goto L22;
        int r7 = 256;
    L23:
        r5 = r5 | r7;
        goto L25
    L22:
        r7 = 128;
    L25:
        if ((r5 & 147) != 146) goto L31;
        if (r15.getSkipping() == false) goto L31;
        r15.skipToGroupEnd();
        Composer r4 = r15;
    L53:
        ScopeUpdateScope r8 = r4.endRestartGroup();
        if (r8 == null) goto L58;
        r8.updateScope(new DoubaoSectionKt$DoubaoSection$3(r23, r24, r25, r27));
        return;
    L58:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventStart(1255663708, r5, -1, "com.ss.android.lark.profile_office.userprofile.section.DoubaoSection (DoubaoSection.kt:29)");
    L33:
        if (r23 == false) goto L35;
        r15.startReplaceGroup(5004770);
        if ((r5 & 896) != 256) goto L44;
        boolean r9 = true;
    L45:
        Object r10 = r15.rememberedValue();
        if (r9 == false) goto L48;
    L49:
        r10 = new DoubaoSectionKt$DoubaoSection$onDoubaoHomepageClick$1$1(r25);
        r15.updateRememberedValue(r10);
    L50:
        final Function0 r11 = (Function0) r10;
        r15.endReplaceGroup();
        Modifier r16 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null);
        float r12 = 16;
        float r17 = Dp.constructor-impl(r12);
        float r19 = Dp.constructor-impl(r12);
        r4 = r15;
        SurfaceKt.Surface-T9BRK9s(PaddingKt.padding-qDBjuR0$default(r16, r17, Dp.constructor-impl(24), r19, 0.0f, 8, null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(r12)), n.a(r15, 0).c.c, 0, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1563409375, true, new DoubaoSectionKt$DoubaoSection$2(r11, r24), r15, 54), r15, 12582912, 120);
        if (ComposerKt.isTraceInProgress() == false) goto L53;
        ComposerKt.traceEventEnd();
        goto L53
    L48:
        if (r10 != Composer.Companion.getEmpty()) goto L50;
    L44:
        r9 = false;
        goto L45
    L35:
        if (ComposerKt.isTraceInProgress() == false) goto L37;
        ComposerKt.traceEventEnd();
    L37:
        ScopeUpdateScope r13 = r15.endRestartGroup();
        if (r13 == null) goto L57;
        r13.updateScope(new DoubaoSectionKt$DoubaoSection$1(r23, r24, r25, r27));
        return;
    L57:
        return;
    L5:
        if (r15.changed(r23) == false) goto L7;
        int r14 = 4;
    L8:
        r5 = r14 | r27;
        goto L11
    L7:
        r14 = 2;
        goto L8
    }
}
