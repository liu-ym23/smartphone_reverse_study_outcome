package com.larksuite.component.universe_design.dialog.compose;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.ToggleableKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import com.larksuite.component.universe_design.checkbox.compose.UDCheckBoxKt;
import com.larksuite.component.universe_design.compose.foundation.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final void a(final boolean r33, final Function1 r34, final String r35, Modifier r36, Composer r37, final int r38, final int r39) {
        Composer r1 = r37.startRestartGroup(76930656);
        if ((r39 & 1) == 0) goto L6;
        int r3 = r38 | 6;
    L14:
        if ((r39 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L25:
        if ((r39 & 4) == 0) goto L28;
        r3 = r3 | 384;
    L34:
        int r6 = r39 & 8;
        if (r6 == 0) goto L38;
        r3 = r3 | 3072;
    L44:
        Modifier r7 = r36;
    L46:
        if ((r3 & 1171) == 1170) goto L48;
    L51:
        if (r6 == 0) goto L53;
        Modifier r32 = Modifier.Companion;
    L55:
        if (ComposerKt.isTraceInProgress() == false) goto L57;
        ComposerKt.traceEventStart(76930656, r3, -1, "com.larksuite.component.universe_design.dialog.compose.DialogCheckBoxRow (UDCheckBoxDialog.kt:74)");
    L57:
        r1.startReplaceGroup(1849434622);
        Object r8 = r1.rememberedValue();
        Composer.Companion r16 = Composer.Companion;
        if (r8 != r16.getEmpty()) goto L60;
        r8 = InteractionSourceKt.MutableInteractionSource();
        r1.updateRememberedValue(r8);
    L60:
        MutableInteractionSource r9 = (MutableInteractionSource) r8;
        r1.endReplaceGroup();
        Role r11 = Role.box-impl(Role.Companion.getCheckbox-o7Vup1c());
        Modifier r10 = ToggleableKt.toggleable-O2vRcR0$default(r32, r33, r9, null, false, r11, r34, 8, null);
        Alignment.Vertical r12 = Alignment.Companion.getCenterVertically();
        MeasurePolicy r13 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), r12, r1, 48);
        long r14 = ComposablesKt.getCurrentCompositeKeyHashCode(r1, 0);
        int r15 = (int) (r14 ^ (r14 >>> 32));
        CompositionLocalMap r17 = r1.getCurrentCompositionLocalMap();
        Modifier r19 = ComposedModifierKt.materializeModifier(r1, r10);
        ComposeUiNode.Companion r110 = ComposeUiNode.Companion;
        Function0 r111 = r110.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L63;
        ComposablesKt.invalidApplier();
    L63:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L66;
        r1.createNode(r111);
    L67:
        Composer r112 = Updater.constructor-impl(r1);
        Updater.set-impl(r112, r13, r110.getSetMeasurePolicy());
        Updater.set-impl(r112, r17, r110.getSetResolvedCompositionLocals());
        Function2 r20 = r110.getSetCompositeKeyHash();
        if (r112.getInserting() == false) goto L70;
    L71:
        r112.updateRememberedValue(Integer.valueOf(r15));
        r112.apply(Integer.valueOf(r15), r20);
    L72:
        Updater.set-impl(r112, r19, r110.getSetModifier());
        RowScopeInstance r21 = RowScopeInstance.INSTANCE;
        Modifier.Companion r113 = Modifier.Companion;
        r1.startReplaceGroup(1849434622);
        Object r0 = r1.rememberedValue();
        if (r0 != r16.getEmpty()) goto L75;
        r0 = UDCheckBoxDialogKt$DialogCheckBoxRow$2$1$1.INSTANCE;
        r1.updateRememberedValue(r0);
    L75:
        r1.endReplaceGroup();
        UDCheckBoxKt.b(r33, r34, SemanticsModifierKt.clearAndSetSemantics(r113, (Function1) r0), false, null, null, false, null, r1, (r3 & 14) | (r3 & 112), 248);
        SpacerKt.Spacer(SizeKt.width-3ABfNKs(r113, e.q), r1, 6);
        TextKt.Text-Nvy7gAk(r35, null, i0.a(r1).d.f.b, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, i0.b(r1).d, r1, (r3 >> 6) & 14, 0, 131066);
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L78;
        ComposerKt.traceEventEnd();
    L78:
        ScopeUpdateScope r22 = r1.endRestartGroup();
        if (r22 == null) goto L82;
        final Modifier r4 = r32;
        r22.updateScope(new UDCheckBoxDialogKt$DialogCheckBoxRow$3(r33, r34, r35, r4, r38, r39));
        return;
    L82:
        return;
    L70:
        if (Intrinsics.areEqual(r112.rememberedValue(), Integer.valueOf(r15)) == true) goto L72;
    L66:
        r1.useNode();
        goto L67
    L53:
        r32 = r7;
        goto L55
    L48:
        if (r1.getSkipping() == false) goto L51;
        r1.skipToGroupEnd();
        r32 = r7;
        goto L78
    L38:
        if ((r38 & 3072) != 0) goto L44;
        r7 = r36;
        if (r1.changed(r7) == false) goto L42;
        int r23 = 2048;
    L43:
        r3 = r3 | r23;
        goto L46
    L42:
        r23 = 1024;
        goto L43
    L28:
        if ((r38 & 384) != 0) goto L34;
        if (r1.changed(r35) == false) goto L32;
        int r24 = 256;
    L33:
        r3 = r3 | r24;
        goto L34
    L32:
        r24 = 128;
        goto L33
    L17:
        if ((r38 & 48) != 0) goto L25;
        if (r1.changedInstance(r34) == false) goto L21;
        int r25 = 32;
    L22:
        r3 = r3 | r25;
        goto L25
    L21:
        r25 = 16;
        goto L22
    L6:
        if ((r38 & 6) == 0) goto L8;
        r3 = r38;
        goto L14
    L8:
        if (r1.changed(r33) == false) goto L10;
        int r5 = 4;
    L11:
        r3 = r5 | r38;
        goto L14
    L10:
        r5 = 2;
        goto L11
    }
}
