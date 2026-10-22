package com.ss.android.lark.profile_office.userprofile.component;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.ss.android.lark.compose.foundation.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ErrorComponentKt {
    public static final void a(final Function0<Unit> r73, Composer r74, final int r75) {
        Intrinsics.checkNotNullParameter(r73, "onRetry");
        Composer r12 = r74.startRestartGroup(1772065369);
        if ((r75 & 6) == 0) goto L5;
        int r11 = r75;
    L11:
        if ((r11 & 3) != 2) goto L17;
        if (r12.getSkipping() == false) goto L17;
        r12.skipToGroupEnd();
        Composer r20 = r12;
    L46:
        ScopeUpdateScope r0 = r20.endRestartGroup();
        if (r0 == null) goto L50;
        r0.updateScope(new ErrorComponentKt$ErrorComponent$2(r73, r75));
        return;
    L50:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(1772065369, r11, -1, "com.ss.android.lark.profile_office.userprofile.component.ErrorComponent (ErrorComponent.kt:31)");
    L19:
        Modifier.Companion r1 = Modifier.Companion;
        Modifier r2 = SizeKt.fillMaxSize$default(r1, 0.0f, 1, null);
        Alignment.Companion r3 = Alignment.Companion;
        MeasurePolicy r4 = BoxKt.maybeCachedBoxMeasurePolicy(r3.getCenter(), false);
        long r5 = ComposablesKt.getCurrentCompositeKeyHashCode(r12, 0);
        int r6 = (int) (r5 ^ (r5 >>> 32));
        CompositionLocalMap r7 = r12.getCurrentCompositionLocalMap();
        Modifier r8 = ComposedModifierKt.materializeModifier(r12, r2);
        ComposeUiNode.Companion r16 = ComposeUiNode.Companion;
        Function0 r9 = r16.getConstructor();
        if ((r12.getApplier() instanceof Applier) == true) goto L22;
        ComposablesKt.invalidApplier();
    L22:
        r12.startReusableNode();
        if (r12.getInserting() == false) goto L25;
        r12.createNode(r9);
    L26:
        Composer r10 = Updater.constructor-impl(r12);
        Updater.set-impl(r10, r4, r16.getSetMeasurePolicy());
        Updater.set-impl(r10, r7, r16.getSetResolvedCompositionLocals());
        Function2 r13 = r16.getSetCompositeKeyHash();
        if (r10.getInserting() == false) goto L29;
    L30:
        r10.updateRememberedValue(Integer.valueOf(r6));
        r10.apply(Integer.valueOf(r6), r13);
    L31:
        Updater.set-impl(r10, r8, r16.getSetModifier());
        BoxScopeInstance r14 = BoxScopeInstance.INSTANCE;
        Modifier r15 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(r1, 0.0f, 1, null), Dp.constructor-impl(32), 0.0f, 2, null);
        MeasurePolicy r17 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), r3.getCenterHorizontally(), r12, 48);
        long r18 = ComposablesKt.getCurrentCompositeKeyHashCode(r12, 0);
        int r19 = (int) (r18 ^ (r18 >>> 32));
        CompositionLocalMap r21 = r12.getCurrentCompositionLocalMap();
        Modifier r22 = ComposedModifierKt.materializeModifier(r12, r15);
        Function0 r23 = r16.getConstructor();
        if ((r12.getApplier() instanceof Applier) == true) goto L34;
        ComposablesKt.invalidApplier();
    L34:
        r12.startReusableNode();
        if (r12.getInserting() == false) goto L37;
        r12.createNode(r23);
    L38:
        Composer r24 = Updater.constructor-impl(r12);
        Updater.set-impl(r24, r17, r16.getSetMeasurePolicy());
        Updater.set-impl(r24, r21, r16.getSetResolvedCompositionLocals());
        Function2 r25 = r16.getSetCompositeKeyHash();
        if (r24.getInserting() == false) goto L41;
    L42:
        r24.updateRememberedValue(Integer.valueOf(r19));
        r24.apply(Integer.valueOf(r19), r25);
    L43:
        Updater.set-impl(r24, r22, r16.getSetModifier());
        ColumnScopeInstance r26 = ColumnScopeInstance.INSTANCE;
        IconKt.Icon-ww6aTOc(PainterResources_androidKt.painterResource(2131237819, r12, 0), null, SizeKt.size-3ABfNKs(r1, Dp.constructor-impl(40)), Color.Companion.getUnspecified-0d7_KjU(), r12, 3504, 0);
        float r27 = 16;
        TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(2131889966, r12, 0), PaddingKt.padding-qDBjuR0$default(r1, 0.0f, Dp.constructor-impl(r27), 0.0f, 0.0f, 13, null), n.a(r12, 0).d.a, null, 0, null, null, null, 0, null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0, 0, false, 0, 0, null, new TextStyle(0, TextUnitKt.getSp(17), FontWeight.Companion.getSemiBold(), null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777209, null), r12, 48, 12582912, 130040);
        r20 = r12;
        ButtonKt.Button(r73, PaddingKt.padding-VpY3zN4$default(SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(r1, 0.0f, Dp.constructor-impl(r27), 0.0f, 0.0f, 13, null), Dp.constructor-impl(44)), Dp.constructor-impl(28), 0.0f, 2, null), false, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)), ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(n.a(r12, 0).a.a, 0, 0, 0, r12, ButtonDefaults.$stable << 12, 14), null, null, null, null, ComposableSingletons$ErrorComponentKt.a, r20, (r11 & 14) | 805306416, 484);
        r20.endNode();
        r20.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventEnd();
        goto L46
    L41:
        if (Intrinsics.areEqual(r24.rememberedValue(), Integer.valueOf(r19)) == true) goto L43;
    L37:
        r12.useNode();
        goto L38
    L29:
        if (Intrinsics.areEqual(r10.rememberedValue(), Integer.valueOf(r6)) == true) goto L31;
    L25:
        r12.useNode();
        goto L26
    L5:
        if (r12.changedInstance(r73) == false) goto L7;
        int r28 = 4;
    L8:
        r11 = r28 | r75;
        goto L11
    L7:
        r28 = 2;
        goto L8
    }
}
