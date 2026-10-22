package com.ss.android.lark.compose.chatsetting.common.ui.widget;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ColoredSettingIconKt {
    public static final void a(final a r10, final Modifier r11, Composer r12, final int r13, final int r14) {
        Intrinsics.checkNotNullParameter(r10, "settingIcon");
        Composer r15 = r12.startRestartGroup(1178620145);
        if ((r14 & 1) == 0) goto L6;
        int r1 = r13 | 6;
    L13:
        int r2 = r14 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r1 & 19) == 18) goto L26;
    L29:
        if (r2 == 0) goto L32;
        r11 = Modifier.Companion;
    L32:
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventStart(1178620145, r1, -1, "com.ss.android.lark.compose.chatsetting.common.ui.widget.ColoredSettingIcon (ColoredSettingIcon.kt:25)");
    L34:
        Modifier r0 = BackgroundKt.background$default(ClipKt.clip(SizeKt.size-3ABfNKs(r11, Dp.constructor-impl(32)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(10))), r10.b, null, 0.0f, 6, null);
        MeasurePolicy r3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), false);
        long r4 = ComposablesKt.getCurrentCompositeKeyHashCode(r15, 0);
        int r5 = (int) ((r4 >>> 32) ^ r4);
        CompositionLocalMap r6 = r15.getCurrentCompositionLocalMap();
        Modifier r7 = ComposedModifierKt.materializeModifier(r15, r0);
        ComposeUiNode.Companion r8 = ComposeUiNode.Companion;
        Function0 r9 = r8.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L37;
        ComposablesKt.invalidApplier();
    L37:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L40;
        r15.createNode(r9);
    L41:
        Composer r16 = Updater.constructor-impl(r15);
        Updater.set-impl(r16, r3, r8.getSetMeasurePolicy());
        Updater.set-impl(r16, r6, r8.getSetResolvedCompositionLocals());
        Function2 r17 = r8.getSetCompositeKeyHash();
        if (r16.getInserting() == false) goto L44;
    L45:
        r16.updateRememberedValue(Integer.valueOf(r5));
        r16.apply(Integer.valueOf(r5), r17);
    L46:
        Updater.set-impl(r16, r7, r8.getSetModifier());
        BoxScopeInstance r18 = BoxScopeInstance.INSTANCE;
        IconKt.Icon-ww6aTOc(r10.a, null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), Color.Companion.getWhite-0d7_KjU(), r15, 3504, 0);
        r15.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L49;
        ComposerKt.traceEventEnd();
    L49:
        ScopeUpdateScope r19 = r15.endRestartGroup();
        if (r19 == null) goto L53;
        r19.updateScope(new ColoredSettingIconKt$ColoredSettingIcon$2(r10, r11, r13, r14));
        return;
    L53:
        return;
    L44:
        if (Intrinsics.areEqual(r16.rememberedValue(), Integer.valueOf(r5)) == true) goto L46;
    L40:
        r15.useNode();
        goto L41
    L26:
        if (r15.getSkipping() == false) goto L29;
        r15.skipToGroupEnd();
        goto L49
    L17:
        if ((r13 & 48) != 0) goto L24;
        if (r15.changed(r11) == false) goto L21;
        int r20 = 32;
    L22:
        r1 = r1 | r20;
        goto L24
    L21:
        r20 = 16;
        goto L22
    L6:
        if ((r13 & 6) == 0) goto L8;
        r1 = r13;
        goto L13
    L8:
        if (r15.changed(r10) == false) goto L10;
        int r21 = 4;
    L11:
        r1 = r21 | r13;
        goto L13
    L10:
        r21 = 2;
        goto L11
    }
}
