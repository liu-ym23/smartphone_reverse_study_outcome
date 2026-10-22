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
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class InfoSectionKt {
    public static final void a(final boolean r27, final boolean r28, final String r29, final boolean r30, final boolean r31, final Function1<? super k, Unit> r32, Composer r33, final int r34) {
        Intrinsics.checkNotNullParameter(r29, "aliasName");
        Intrinsics.checkNotNullParameter(r32, "onIntent");
        Composer r15 = r33.startRestartGroup(-746439813);
        if ((r34 & 6) == 0) goto L5;
        int r1 = r34;
    L11:
        if ((r34 & 48) != 0) goto L18;
        if (r15.changed(r28) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r34 & 384) != 0) goto L25;
        if (r15.changed(r29) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r34 & 3072) != 0) goto L32;
        if (r15.changed(r30) == false) goto L29;
        int r4 = 2048;
    L30:
        r1 = r1 | r4;
        goto L32
    L29:
        r4 = 1024;
    L32:
        if ((r34 & 24576) != 0) goto L39;
        if (r15.changed(r31) == false) goto L36;
        int r5 = 16384;
    L37:
        r1 = r1 | r5;
        goto L39
    L36:
        r5 = 8192;
    L39:
        if ((196608 & r34) != 0) goto L46;
        if (r15.changedInstance(r32) == false) goto L43;
        int r6 = 131072;
    L44:
        r1 = r1 | r6;
        goto L46
    L43:
        r6 = 65536;
    L46:
        if ((74899 & r1) != 74898) goto L52;
        if (r15.getSkipping() == false) goto L52;
        r15.skipToGroupEnd();
        Composer r7 = r15;
    L89:
        ScopeUpdateScope r14 = r7.endRestartGroup();
        if (r14 == null) goto L94;
        r14.updateScope(new InfoSectionKt$InfoSection$3(r27, r28, r29, r30, r31, r32, r34));
        return;
    L94:
        return;
    L52:
        if (ComposerKt.isTraceInProgress() == false) goto L54;
        ComposerKt.traceEventStart(-746439813, r1, -1, "com.ss.android.lark.profile_office.userprofile.section.InfoSection (InfoSection.kt:29)");
    L54:
        if (r27 == true) goto L63;
        if (r28 == true) goto L63;
        if (ComposerKt.isTraceInProgress() == false) goto L59;
        ComposerKt.traceEventEnd();
    L59:
        ScopeUpdateScope r16 = r15.endRestartGroup();
        if (r16 == null) goto L93;
        r16.updateScope(new InfoSectionKt$InfoSection$1(r27, r28, r29, r30, r31, r32, r34));
        return;
    L93:
        return;
    L63:
        if (r30 == false) goto L65;
        int r8 = 2131890081;
    L68:
        r15.startReplaceGroup(5004770);
        int r9 = r1 & 458752;
        if (r9 != 131072) goto L71;
        boolean r10 = true;
    L72:
        Object r11 = r15.rememberedValue();
        if (r10 == false) goto L75;
    L76:
        r11 = new InfoSectionKt$InfoSection$onEditAliasClick$1$1(r32);
        r15.updateRememberedValue(r11);
    L77:
        final Function0 r12 = (Function0) r11;
        r15.endReplaceGroup();
        r15.startReplaceGroup(5004770);
        if (r9 != 131072) goto L80;
        boolean r0 = true;
    L81:
        Object r13 = r15.rememberedValue();
        if (r0 == false) goto L84;
    L85:
        r13 = new InfoSectionKt$InfoSection$onShareProfileClick$1$1(r32);
        r15.updateRememberedValue(r13);
    L86:
        final Function0 r17 = (Function0) r13;
        r15.endReplaceGroup();
        float r18 = 16;
        final int r19 = r8;
        r7 = r15;
        SurfaceKt.Surface-T9BRK9s(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Dp.constructor-impl(r18), Dp.constructor-impl(r18), Dp.constructor-impl(r18), 0.0f, 8, null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(r18)), n.a(r15, 0).c.c, 0, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(455034240, true, new InfoSectionKt$InfoSection$2(r27, r28, r12, r19, r17, r29), r15, 54), r7, 12582912, 120);
        if (ComposerKt.isTraceInProgress() == false) goto L89;
        ComposerKt.traceEventEnd();
        goto L89
    L84:
        if (r13 != Composer.Companion.getEmpty()) goto L86;
    L80:
        r0 = false;
        goto L81
    L75:
        if (r11 != Composer.Companion.getEmpty()) goto L77;
    L71:
        r10 = false;
        goto L72
    L65:
        if (r31 == false) goto L67;
        r8 = 2131889982;
        goto L68
    L67:
        r8 = 2131890070;
        goto L68
    L5:
        if (r15.changed(r27) == false) goto L7;
        int r20 = 4;
    L8:
        r1 = r20 | r34;
        goto L11
    L7:
        r20 = 2;
        goto L8
    }
}
