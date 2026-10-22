package com.ss.android.lark.compose.foundation;

import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final class LarkThemeKt$LarkTheme$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ boolean $darkTheme;

    public LarkThemeKt$LarkTheme$2(boolean r1, Function2<? super Composer, ? super Integer, Unit> r2, int r3, int r4) {
        this.$darkTheme = r1;
        this.$content = r2;
        this.$$changed = r3;
        this.$$default = r4;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r11, int r12) {
        boolean r13 = this.$darkTheme;
        final Function2<Composer, Integer, Unit> r0 = this.$content;
        int r1 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1);
        int r3 = this.$$default;
        Intrinsics.checkNotNullParameter(r0, "content");
        Composer r14 = r11.startRestartGroup(-241204900);
        if ((r1 & 6) == 0) goto L5;
        int r5 = r1;
    L13:
        if ((r3 & 2) == 0) goto L16;
        r5 = r5 | 48;
    L23:
        if ((r5 & 19) == 18) goto L25;
    L28:
        r14.startDefaults();
        if ((r1 & 1) == 0) goto L37;
        if (r14.getDefaultsInvalid() == true) goto L37;
        r14.skipToGroupEnd();
        if ((r3 & 1) != 0) goto L39;
    L40:
        r14.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L43;
        ComposerKt.traceEventStart(-241204900, r5, -1, "com.ss.android.lark.compose.foundation.LarkTheme (LarkTheme.kt:11)");
    L43:
        if (r13 == false) goto L45;
        o0 r4 = (o0) UDColorSchemeKt.b.getValue();
    L46:
        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{CompositionLocalsKt.a.provides(r4), CompositionLocalsKt.b.provides(r0.a)}, ComposableLambdaKt.rememberComposableLambda(-1207450084, true, new LarkThemeKt$LarkTheme$1(r0), r14, 54), r14, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L49;
        ComposerKt.traceEventEnd();
    L49:
        ScopeUpdateScope r15 = r14.endRestartGroup();
        if (r15 == null) goto L53;
        r15.updateScope(new LarkThemeKt$LarkTheme$2(r13, r0, r1, r3));
        return;
    L53:
        return;
    L45:
        r4 = (o0) UDColorSchemeKt.a.getValue();
    L39:
        r5 = r5 & (-15);
    L37:
        if ((r3 & 1) == 0) goto L40;
        r13 = DarkThemeKt.isSystemInDarkTheme(r14, 0);
        goto L39
    L25:
        if (r14.getSkipping() == false) goto L28;
        r14.skipToGroupEnd();
        goto L49
    L16:
        if ((r1 & 48) != 0) goto L23;
        if (r14.changedInstance(r0) == false) goto L20;
        int r7 = 32;
    L21:
        r5 = r5 | r7;
        goto L23
    L20:
        r7 = 16;
        goto L21
    L5:
        if ((r3 & 1) == 0) goto L7;
    L9:
        int r6 = 2;
    L10:
        r5 = r6 | r1;
        goto L13
    L7:
        if (r14.changed(r13) == false) goto L9;
        r6 = 4;
        goto L10
    }
}
