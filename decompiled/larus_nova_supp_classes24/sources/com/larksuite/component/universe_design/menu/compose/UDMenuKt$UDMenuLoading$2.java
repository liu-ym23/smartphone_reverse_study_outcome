package com.larksuite.component.universe_design.menu.compose;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final class UDMenuKt$UDMenuLoading$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ a $colors;
    final /* synthetic */ Modifier $modifier;

    public UDMenuKt$UDMenuLoading$2(Modifier r1, a r2, int r3, int r4) {
        this.$modifier = r1;
        this.$colors = r2;
        this.$$changed = r3;
        this.$$default = r4;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r13, int r14) {
        Modifier r15 = this.$modifier;
        final a r0 = this.$colors;
        int r1 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1);
        int r3 = this.$$default;
        Composer r16 = r13.startRestartGroup(-1067391138);
        int r5 = r3 & 1;
        if (r5 == 0) goto L6;
        int r6 = r1 | 6;
    L14:
        if ((r1 & 48) != 0) goto L23;
        if ((r3 & 2) == 0) goto L18;
    L20:
        int r7 = 16;
    L21:
        r6 = r6 | r7;
        goto L23
    L18:
        if (r16.changed(r0) == false) goto L20;
        r7 = 32;
    L23:
        if ((r6 & 19) == 18) goto L25;
    L28:
        r16.startDefaults();
        if ((r1 & 1) != 0) goto L31;
    L36:
        if (r5 == 0) goto L39;
        r15 = Modifier.Companion;
    L39:
        if ((r3 & 2) == 0) goto L42;
        r0 = b.a(r16);
    L41:
        r6 = r6 & (-113);
    L42:
        r16.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L45;
        ComposerKt.traceEventStart(-1067391138, r6, -1, "com.larksuite.component.universe_design.menu.compose.UDMenuLoading (UDMenu.kt:285)");
    L45:
        UDMenuKt.b(r15, r0, PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(16)), ComposableLambdaKt.rememberComposableLambda(2141647160, true, new UDMenuKt$UDMenuLoading$1(r0), r16, 54), r16, ((r6 & 14) | 3456) | (r6 & 112), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L48;
        ComposerKt.traceEventEnd();
    L48:
        ScopeUpdateScope r17 = r16.endRestartGroup();
        if (r17 == null) goto L52;
        r17.updateScope(new UDMenuKt$UDMenuLoading$2(r15, r0, r1, r3));
        return;
    L52:
        return;
    L31:
        if (r16.getDefaultsInvalid() == true) goto L36;
        r16.skipToGroupEnd();
        if ((r3 & 2) == 0) goto L42;
    L25:
        if (r16.getSkipping() == false) goto L28;
        r16.skipToGroupEnd();
        goto L48
    L6:
        if ((r1 & 6) == 0) goto L8;
        r6 = r1;
        goto L14
    L8:
        if (r16.changed(r15) == false) goto L10;
        int r8 = 4;
    L11:
        r6 = r8 | r1;
        goto L14
    L10:
        r8 = 2;
        goto L11
    }
}
