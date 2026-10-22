package com.ss.android.lark.compose.chatsetting.quit;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.ss.android.lark.compose.chatsetting.common.ui.icon.ChatSettingIcons;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.flow.chat.resources.CommonMainString0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.b0;
import org.jetbrains.compose.resources.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class QuitGroupTitleKt {
    public static final void a(final Function0<Unit> r38, Composer r39, final int r40) {
        Intrinsics.checkNotNullParameter(r38, "onBackClick");
        Composer r15 = r39.startRestartGroup(-1924836477);
        if ((r40 & 6) == 0) goto L5;
        int r1 = r40;
    L11:
        if ((r1 & 3) != 2) goto L17;
        if (r15.getSkipping() == false) goto L17;
        r15.skipToGroupEnd();
        Composer r2 = r15;
    L49:
        ScopeUpdateScope r0 = r2.endRestartGroup();
        if (r0 == null) goto L53;
        r0.updateScope(new QuitGroupTitleKt$QuitGroupTitle$2(r38, r40));
        return;
    L53:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(-1924836477, r1, -1, "com.ss.android.lark.compose.chatsetting.quit.QuitGroupTitle (QuitGroupTitle.kt:24)");
    L19:
        Modifier.Companion r12 = Modifier.Companion;
        Modifier r3 = BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(r12, 0.0f, 1, null), Dp.constructor-impl(62)), n.a(r15, 0).c.f, null, 2, null);
        Alignment.Companion r14 = Alignment.Companion;
        MeasurePolicy r4 = BoxKt.maybeCachedBoxMeasurePolicy(r14.getTopStart(), false);
        long r5 = ComposablesKt.getCurrentCompositeKeyHashCode(r15, 0);
        int r6 = (int) (r5 ^ (r5 >>> 32));
        CompositionLocalMap r7 = r15.getCurrentCompositionLocalMap();
        Modifier r8 = ComposedModifierKt.materializeModifier(r15, r3);
        ComposeUiNode.Companion r16 = ComposeUiNode.Companion;
        Function0 r9 = r16.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L22;
        ComposablesKt.invalidApplier();
    L22:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L25;
        r15.createNode(r9);
    L26:
        Composer r10 = Updater.constructor-impl(r15);
        Updater.set-impl(r10, r4, r16.getSetMeasurePolicy());
        Updater.set-impl(r10, r7, r16.getSetResolvedCompositionLocals());
        Function2 r11 = r16.getSetCompositeKeyHash();
        if (r10.getInserting() == false) goto L29;
    L30:
        r10.updateRememberedValue(Integer.valueOf(r6));
        r10.apply(Integer.valueOf(r6), r11);
    L31:
        Updater.set-impl(r10, r8, r16.getSetModifier());
        BoxScopeInstance r13 = BoxScopeInstance.INSTANCE;
        Modifier r17 = SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(r13.align(r12, r14.getCenterStart()), Dp.constructor-impl(8), 0.0f, 0.0f, 0.0f, 14, null), Dp.constructor-impl(44));
        r15.startReplaceGroup(1849434622);
        Object r18 = r15.rememberedValue();
        if (r18 != Composer.Companion.getEmpty()) goto L34;
        r18 = InteractionSourceKt.MutableInteractionSource();
        r15.updateRememberedValue(r18);
    L34:
        r15.endReplaceGroup();
        Modifier r19 = ClickableKt.clickable-O2vRcR0$default(r17, (MutableInteractionSource) r18, null, false, null, null, r38, 28, null);
        MeasurePolicy r20 = BoxKt.maybeCachedBoxMeasurePolicy(r14.getCenter(), false);
        long r21 = ComposablesKt.getCurrentCompositeKeyHashCode(r15, 0);
        int r22 = (int) (r21 ^ (r21 >>> 32));
        CompositionLocalMap r23 = r15.getCurrentCompositionLocalMap();
        Modifier r24 = ComposedModifierKt.materializeModifier(r15, r19);
        Function0 r25 = r16.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L37;
        ComposablesKt.invalidApplier();
    L37:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L40;
        r15.createNode(r25);
    L41:
        Composer r26 = Updater.constructor-impl(r15);
        Updater.set-impl(r26, r20, r16.getSetMeasurePolicy());
        Updater.set-impl(r26, r23, r16.getSetResolvedCompositionLocals());
        Function2 r27 = r16.getSetCompositeKeyHash();
        if (r26.getInserting() == false) goto L44;
    L45:
        r26.updateRememberedValue(Integer.valueOf(r22));
        r26.apply(Integer.valueOf(r22), r27);
    L46:
        Updater.set-impl(r26, r24, r16.getSetModifier());
        IconKt.Icon-ww6aTOc((ImageVector) ChatSettingIcons.m.getValue(), "Back", null, n.a(r15, 0).d.a, r15, 48, 4);
        r15.endNode();
        Intrinsics.checkNotNullParameter(com.ss.android.lark.flow.chat.resources.b.a, "<this>");
        r2 = r15;
        TextKt.Text-Nvy7gAk(b0.a((z) CommonMainString0.C2.getValue(), r15), r13.align(r12, r14.getCenter()), n.a(r15, 0).d.a, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, n.b(r15).a, r2, 0, 0, 131064);
        r2.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L49;
        ComposerKt.traceEventEnd();
        goto L49
    L44:
        if (Intrinsics.areEqual(r26.rememberedValue(), Integer.valueOf(r22)) == true) goto L46;
    L40:
        r15.useNode();
        goto L41
    L29:
        if (Intrinsics.areEqual(r10.rememberedValue(), Integer.valueOf(r6)) == true) goto L31;
    L25:
        r15.useNode();
        goto L26
    L5:
        if (r15.changedInstance(r38) == false) goto L7;
        int r28 = 4;
    L8:
        r1 = r28 | r40;
        goto L11
    L7:
        r28 = 2;
        goto L8
    }
}
