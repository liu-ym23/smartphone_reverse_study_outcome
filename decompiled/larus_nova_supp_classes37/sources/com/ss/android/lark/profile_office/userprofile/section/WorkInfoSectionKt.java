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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class WorkInfoSectionKt {
    public static final void a(final boolean r29, final boolean r30, final boolean r31, final List<String> r32, final String r33, final String r34, final String r35, final boolean r36, final Function1<? super k, Unit> r37, Composer r38, final int r39) {
        Intrinsics.checkNotNullParameter(r32, "departmentList");
        Intrinsics.checkNotNullParameter(r33, "leaderUserId");
        Intrinsics.checkNotNullParameter(r34, "leaderName");
        Intrinsics.checkNotNullParameter(r35, "cityName");
        Intrinsics.checkNotNullParameter(r37, "onIntent");
        Composer r6 = r38.startRestartGroup(1449017275);
        if ((r39 & 6) == 0) goto L5;
        int r1 = r39;
    L11:
        if ((r39 & 48) != 0) goto L18;
        if (r6.changed(r30) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r39 & 384) != 0) goto L25;
        if (r6.changed(r31) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r39 & 3072) != 0) goto L32;
        if (r6.changedInstance(r32) == false) goto L29;
        int r4 = 2048;
    L30:
        r1 = r1 | r4;
        goto L32
    L29:
        r4 = 1024;
    L32:
        if ((r39 & 24576) != 0) goto L39;
        if (r6.changed(r33) == false) goto L36;
        int r5 = 16384;
    L37:
        r1 = r1 | r5;
        goto L39
    L36:
        r5 = 8192;
    L39:
        if ((196608 & r39) != 0) goto L46;
        if (r6.changed(r34) == false) goto L43;
        int r7 = 131072;
    L44:
        r1 = r1 | r7;
        goto L46
    L43:
        r7 = 65536;
    L46:
        if ((1572864 & r39) != 0) goto L53;
        if (r6.changed(r35) == false) goto L50;
        int r8 = 1048576;
    L51:
        r1 = r1 | r8;
        goto L53
    L50:
        r8 = 524288;
    L53:
        if ((12582912 & r39) != 0) goto L60;
        if (r6.changed(r36) == false) goto L57;
        int r9 = 8388608;
    L58:
        r1 = r1 | r9;
        goto L60
    L57:
        r9 = 4194304;
    L60:
        if ((100663296 & r39) != 0) goto L67;
        if (r6.changedInstance(r37) == false) goto L64;
        int r10 = 67108864;
    L65:
        r1 = r1 | r10;
        goto L67
    L64:
        r10 = 33554432;
    L67:
        if ((38347923 & r1) != 38347922) goto L73;
        if (r6.getSkipping() == false) goto L73;
        r6.skipToGroupEnd();
        Composer r11 = r6;
    L88:
        ScopeUpdateScope r12 = r11.endRestartGroup();
        if (r12 == null) goto L93;
        r12.updateScope(new WorkInfoSectionKt$WorkInfoSection$3(r29, r30, r31, r32, r33, r34, r35, r36, r37, r39));
        return;
    L93:
        return;
    L73:
        if (ComposerKt.isTraceInProgress() == false) goto L75;
        ComposerKt.traceEventStart(1449017275, r1, -1, "com.ss.android.lark.profile_office.userprofile.section.WorkInfoSection (WorkInfoSection.kt:36)");
    L75:
        if (r29 == true) goto L85;
        if (r30 == true) goto L85;
        if (r31 == true) goto L85;
        if (ComposerKt.isTraceInProgress() == false) goto L81;
        ComposerKt.traceEventEnd();
    L81:
        ScopeUpdateScope r13 = r6.endRestartGroup();
        if (r13 == null) goto L92;
        r13.updateScope(new WorkInfoSectionKt$WorkInfoSection$1(r29, r30, r31, r32, r33, r34, r35, r36, r37, r39));
        return;
    L92:
        return;
    L85:
        float r0 = 16;
        r11 = r6;
        SurfaceKt.Surface-T9BRK9s(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Dp.constructor-impl(r0), Dp.constructor-impl(24), Dp.constructor-impl(r0), 0.0f, 8, null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(r0)), n.a(r6, 0).c.c, 0, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(318773910, true, new WorkInfoSectionKt$WorkInfoSection$2(r29, r36, r32, r37, r30, r31, r33, r34, r35), r11, 54), r11, 12582912, 120);
        if (ComposerKt.isTraceInProgress() == false) goto L88;
        ComposerKt.traceEventEnd();
        goto L88
    L5:
        if (r6.changed(r29) == false) goto L7;
        int r14 = 4;
    L8:
        r1 = r14 | r39;
        goto L11
    L7:
        r14 = 2;
        goto L8
    }
}
