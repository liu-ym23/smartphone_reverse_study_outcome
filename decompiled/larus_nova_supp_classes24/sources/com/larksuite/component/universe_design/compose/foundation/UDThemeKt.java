package com.larksuite.component.universe_design.compose.foundation;

import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UDThemeKt {
    public static final void a(final boolean r6, final Function2<? super Composer, ? super Integer, Unit> r7, Composer r8, final int r9, final int r10) {
        Intrinsics.checkNotNullParameter(r7, "content");
        Composer r11 = r8.startRestartGroup(2121500020);
        if ((r9 & 6) == 0) goto L5;
        int r1 = r9;
    L13:
        if ((r10 & 2) == 0) goto L16;
        r1 = r1 | 48;
    L23:
        if ((r1 & 19) == 18) goto L25;
    L28:
        r11.startDefaults();
        if ((r9 & 1) == 0) goto L37;
        if (r11.getDefaultsInvalid() == true) goto L37;
        r11.skipToGroupEnd();
        if ((r10 & 1) != 0) goto L39;
    L40:
        r11.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L43;
        ComposerKt.traceEventStart(2121500020, r1, -1, "com.larksuite.component.universe_design.compose.foundation.UDTheme (UDTheme.kt:11)");
    L43:
        if (r6 == false) goto L45;
        g0 r0 = (g0) UDColorSchemeKt.b.getValue();
    L46:
        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.a.provides(r0), CompositionLocalsKt.b.provides(k0.a)}, ComposableLambdaKt.rememberComposableLambda(322587188, true, new UDThemeKt$UDTheme$1(r7), r11, 54), r11, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L49;
        ComposerKt.traceEventEnd();
    L49:
        ScopeUpdateScope r12 = r11.endRestartGroup();
        if (r12 == null) goto L53;
        r12.updateScope(new UDThemeKt$UDTheme$2(r6, r7, r9, r10));
        return;
    L53:
        return;
    L45:
        r0 = (g0) UDColorSchemeKt.a.getValue();
    L39:
        r1 = r1 & (-15);
    L37:
        if ((r10 & 1) == 0) goto L40;
        r6 = DarkThemeKt.isSystemInDarkTheme(r11, 0);
        goto L39
    L25:
        if (r11.getSkipping() == false) goto L28;
        r11.skipToGroupEnd();
        goto L49
    L16:
        if ((r9 & 48) != 0) goto L23;
        if (r11.changedInstance(r7) == false) goto L20;
        int r3 = 32;
    L21:
        r1 = r1 | r3;
        goto L23
    L20:
        r3 = 16;
        goto L21
    L5:
        if ((r10 & 1) == 0) goto L7;
    L9:
        int r2 = 2;
    L10:
        r1 = r2 | r9;
        goto L13
    L7:
        if (r11.changed(r6) == false) goto L9;
        r2 = 4;
        goto L10
    }
}
