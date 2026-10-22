package com.ss.android.lark.compose.chatsetting.common.ui.widget;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.ss.android.lark.compose.foundation.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class SettingGroupContainerKt {
    public static final void a(Modifier r17, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r18, Composer r19, final int r20, final int r21) {
        Intrinsics.checkNotNullParameter(r18, "content");
        Composer r4 = r19.startRestartGroup(1550706450);
        int r5 = r21 & 1;
        if (r5 == 0) goto L6;
        int r7 = r20 | 6;
        Modifier r6 = r17;
    L14:
        if ((r21 & 2) == 0) goto L17;
        r7 = r7 | 48;
    L24:
        if ((r7 & 19) == 18) goto L26;
    L29:
        if (r5 == 0) goto L31;
        final Modifier r8 = Modifier.Companion;
    L33:
        if (ComposerKt.isTraceInProgress() == false) goto L35;
        ComposerKt.traceEventStart(1550706450, r7, -1, "com.ss.android.lark.compose.chatsetting.common.ui.widget.SettingGroupContainer (SettingGroupContainer.kt:28)");
    L35:
        float r9 = 16;
        Modifier r10 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(r8, 0.0f, 1, null), Dp.constructor-impl(r9), Dp.constructor-impl(8)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(r9))), n.a(r4, 0).c.c, null, 2, null);
        int r11 = (r7 << 6) & 7168;
        int r12 = r11 >> 3;
        MeasurePolicy r13 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), r4, (r12 & 112) | (r12 & 14));
        long r14 = ComposablesKt.getCurrentCompositeKeyHashCode(r4, 0);
        int r3 = (int) ((r14 >>> 32) ^ r14);
        CompositionLocalMap r15 = r4.getCurrentCompositionLocalMap();
        Modifier r16 = ComposedModifierKt.materializeModifier(r4, r10);
        ComposeUiNode.Companion r110 = ComposeUiNode.Companion;
        Function0 r111 = r110.getConstructor();
        if ((r4.getApplier() instanceof Applier) == true) goto L38;
        ComposablesKt.invalidApplier();
    L38:
        r4.startReusableNode();
        if (r4.getInserting() == false) goto L41;
        r4.createNode(r111);
    L42:
        Composer r112 = Updater.constructor-impl(r4);
        Updater.set-impl(r112, r13, r110.getSetMeasurePolicy());
        Updater.set-impl(r112, r15, r110.getSetResolvedCompositionLocals());
        Function2 r22 = r110.getSetCompositeKeyHash();
        if (r112.getInserting() == false) goto L45;
    L46:
        r112.updateRememberedValue(Integer.valueOf(r3));
        r112.apply(Integer.valueOf(r3), r22);
    L47:
        Updater.set-impl(r112, r16, r110.getSetModifier());
        r18.invoke(ColumnScopeInstance.INSTANCE, r4, Integer.valueOf(((r11 >> 6) & 112) | 6));
        r4.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L50;
        ComposerKt.traceEventEnd();
    L50:
        ScopeUpdateScope r23 = r4.endRestartGroup();
        if (r23 == null) goto L54;
        r23.updateScope(new SettingGroupContainerKt$SettingGroupContainer$1(r8, r18, r20, r21));
        return;
    L54:
        return;
    L45:
        if (Intrinsics.areEqual(r112.rememberedValue(), Integer.valueOf(r3)) == true) goto L47;
    L41:
        r4.useNode();
        goto L42
    L31:
        r8 = r6;
        goto L33
    L26:
        if (r4.getSkipping() == false) goto L29;
        r4.skipToGroupEnd();
        r8 = r6;
        goto L50
    L17:
        if ((r20 & 48) != 0) goto L24;
        if (r4.changedInstance(r18) == false) goto L21;
        int r24 = 32;
    L22:
        r7 = r7 | r24;
        goto L24
    L21:
        r24 = 16;
        goto L22
    L6:
        if ((r20 & 6) != 0) goto L12;
        r6 = r17;
        if (r4.changed(r6) == false) goto L10;
        int r25 = 4;
    L11:
        r7 = r25 | r20;
        goto L14
    L10:
        r25 = 2;
        goto L11
    L12:
        r6 = r17;
        r7 = r20;
        goto L14
    }
}
