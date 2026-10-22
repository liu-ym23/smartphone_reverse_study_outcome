package com.ss.android.lark.compose.chatsetting.main.ui;

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
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
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
public final class ChatSettingTitleKt {
    public static final void a(final boolean r48, Modifier r49, final Function0<Unit> r50, final Function0<Unit> r51, Composer r52, final int r53, final int r54) {
        Intrinsics.checkNotNullParameter(r50, "onBackClick");
        Intrinsics.checkNotNullParameter(r51, "onMoreClick");
        Composer r15 = r52.startRestartGroup(-710040338);
        if ((r54 & 1) == 0) goto L6;
        int r2 = r53 | 6;
    L13:
        int r3 = r54 & 2;
        if (r3 == 0) goto L17;
        r2 = r2 | 48;
    L23:
        Modifier r4 = r49;
    L25:
        if ((r54 & 4) == 0) goto L28;
        r2 = r2 | 384;
    L35:
        if ((r54 & 8) == 0) goto L38;
        r2 = r2 | 3072;
    L45:
        if ((r2 & 1171) == 1170) goto L47;
    L50:
        if (r3 == 0) goto L52;
        Modifier r14 = Modifier.Companion;
    L54:
        if (ComposerKt.isTraceInProgress() == false) goto L56;
        ComposerKt.traceEventStart(-710040338, r2, -1, "com.ss.android.lark.compose.chatsetting.main.ui.ChatSettingTitle (ChatSettingTitle.kt:28)");
    L56:
        Modifier r0 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(r14, 0.0f, 1, null), Dp.constructor-impl(62));
        Alignment.Companion r41 = Alignment.Companion;
        MeasurePolicy r5 = BoxKt.maybeCachedBoxMeasurePolicy(r41.getTopStart(), false);
        long r6 = ComposablesKt.getCurrentCompositeKeyHashCode(r15, 0);
        int r7 = (int) (r6 ^ (r6 >>> 32));
        CompositionLocalMap r8 = r15.getCurrentCompositionLocalMap();
        Modifier r1 = ComposedModifierKt.materializeModifier(r15, r0);
        ComposeUiNode.Companion r42 = ComposeUiNode.Companion;
        Function0 r9 = r42.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L59;
        ComposablesKt.invalidApplier();
    L59:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L62;
        r15.createNode(r9);
    L63:
        Composer r10 = Updater.constructor-impl(r15);
        Updater.set-impl(r10, r5, r42.getSetMeasurePolicy());
        Updater.set-impl(r10, r8, r42.getSetResolvedCompositionLocals());
        Function2 r11 = r42.getSetCompositeKeyHash();
        if (r10.getInserting() == false) goto L66;
    L67:
        r10.updateRememberedValue(Integer.valueOf(r7));
        r10.apply(Integer.valueOf(r7), r11);
    L68:
        Updater.set-impl(r10, r1, r42.getSetModifier());
        BoxScopeInstance r12 = BoxScopeInstance.INSTANCE;
        Modifier.Companion r13 = Modifier.Companion;
        float r16 = 8;
        float r17 = 44;
        Modifier r18 = SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(r12.align(r13, r41.getCenterStart()), Dp.constructor-impl(r16), 0.0f, 0.0f, 0.0f, 14, null), Dp.constructor-impl(r17));
        r15.startReplaceGroup(1849434622);
        Object r19 = r15.rememberedValue();
        Composer.Companion r43 = Composer.Companion;
        if (r19 != r43.getEmpty()) goto L71;
        r19 = InteractionSourceKt.MutableInteractionSource();
        r15.updateRememberedValue(r19);
    L71:
        r15.endReplaceGroup();
        Modifier r20 = ClickableKt.clickable-O2vRcR0$default(r18, (MutableInteractionSource) r19, null, false, null, null, r50, 28, null);
        MeasurePolicy r21 = BoxKt.maybeCachedBoxMeasurePolicy(r41.getCenter(), false);
        long r22 = ComposablesKt.getCurrentCompositeKeyHashCode(r15, 0);
        int r23 = (int) (r22 ^ (r22 >>> 32));
        CompositionLocalMap r24 = r15.getCurrentCompositionLocalMap();
        Modifier r25 = ComposedModifierKt.materializeModifier(r15, r20);
        Function0 r26 = r42.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L74;
        ComposablesKt.invalidApplier();
    L74:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L77;
        r15.createNode(r26);
    L78:
        Composer r27 = Updater.constructor-impl(r15);
        Updater.set-impl(r27, r21, r42.getSetMeasurePolicy());
        Updater.set-impl(r27, r24, r42.getSetResolvedCompositionLocals());
        Function2 r28 = r42.getSetCompositeKeyHash();
        if (r27.getInserting() == false) goto L81;
    L82:
        r27.updateRememberedValue(Integer.valueOf(r23));
        r27.apply(Integer.valueOf(r23), r28);
    L83:
        Updater.set-impl(r27, r25, r42.getSetModifier());
        IconKt.Icon-ww6aTOc((ImageVector) ChatSettingIcons.m.getValue(), "Back", null, n.a(r15, 0).d.a, r15, 48, 4);
        r15.endNode();
        Intrinsics.checkNotNullParameter(com.ss.android.lark.flow.chat.resources.b.a, "<this>");
        String r29 = b0.a((z) CommonMainString0.c.getValue(), r15);
        Modifier r47 = r14;
        TextStyle r30 = n.b(r15).a;
        TextKt.Text-Nvy7gAk(r29, r12.align(r13, r41.getCenter()), n.a(r15, 0).d.a, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, r30, r15, 0, 0, 131064);
        r15.startReplaceGroup(407027310);
        if (r48 == true) goto L101;
        Modifier r31 = SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(r12.align(r13, r41.getCenterEnd()), 0.0f, 0.0f, Dp.constructor-impl(r16), 0.0f, 11, null), Dp.constructor-impl(r17));
        r15.startReplaceGroup(1849434622);
        Object r32 = r15.rememberedValue();
        if (r32 != r43.getEmpty()) goto L88;
        r32 = InteractionSourceKt.MutableInteractionSource();
        r15.updateRememberedValue(r32);
    L88:
        r15.endReplaceGroup();
        Composer r110 = r15;
        Modifier r33 = ClickableKt.clickable-O2vRcR0$default(r31, (MutableInteractionSource) r32, null, false, null, null, r51, 28, null);
        MeasurePolicy r34 = BoxKt.maybeCachedBoxMeasurePolicy(r41.getCenter(), false);
        long r35 = ComposablesKt.getCurrentCompositeKeyHashCode(r110, 0);
        int r36 = (int) (r35 ^ (r35 >>> 32));
        CompositionLocalMap r37 = r110.getCurrentCompositionLocalMap();
        Modifier r38 = ComposedModifierKt.materializeModifier(r110, r33);
        Function0 r39 = r42.getConstructor();
        if ((r110.getApplier() instanceof Applier) == true) goto L91;
        ComposablesKt.invalidApplier();
    L91:
        r110.startReusableNode();
        if (r110.getInserting() == false) goto L94;
        r110.createNode(r39);
    L95:
        Composer r40 = Updater.constructor-impl(r110);
        Updater.set-impl(r40, r34, r42.getSetMeasurePolicy());
        Updater.set-impl(r40, r37, r42.getSetResolvedCompositionLocals());
        Function2 r44 = r42.getSetCompositeKeyHash();
        if (r40.getInserting() == false) goto L98;
    L99:
        r40.updateRememberedValue(Integer.valueOf(r36));
        r40.apply(Integer.valueOf(r36), r44);
    L100:
        Updater.set-impl(r40, r38, r42.getSetModifier());
        IconKt.Icon-ww6aTOc(ChatSettingIcons.r, "more", null, n.a(r110, 0).d.a, r110, 48, 4);
        r110.endNode();
    L102:
        r110.endReplaceGroup();
        r110.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L105;
        ComposerKt.traceEventEnd();
    L105:
        final Modifier r45 = r47;
    L106:
        ScopeUpdateScope r46 = r110.endRestartGroup();
        if (r46 == null) goto L110;
        r46.updateScope(new ChatSettingTitleKt$ChatSettingTitle$2(r48, r45, r50, r51, r53, r54));
        return;
    L110:
        return;
    L98:
        if (Intrinsics.areEqual(r40.rememberedValue(), Integer.valueOf(r36)) == true) goto L100;
    L94:
        r110.useNode();
        goto L95
    L101:
        r110 = r15;
        goto L102
    L81:
        if (Intrinsics.areEqual(r27.rememberedValue(), Integer.valueOf(r23)) == true) goto L83;
    L77:
        r15.useNode();
        goto L78
    L66:
        if (Intrinsics.areEqual(r10.rememberedValue(), Integer.valueOf(r7)) == true) goto L68;
    L62:
        r15.useNode();
        goto L63
    L52:
        r14 = r4;
        goto L54
    L47:
        if (r15.getSkipping() == false) goto L50;
        r15.skipToGroupEnd();
        r45 = r4;
        r110 = r15;
        goto L106
    L38:
        if ((r53 & 3072) != 0) goto L45;
        if (r15.changedInstance(r51) == false) goto L42;
        int r55 = 2048;
    L43:
        r2 = r2 | r55;
        goto L45
    L42:
        r55 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L43
    L28:
        if ((r53 & 384) != 0) goto L35;
        if (r15.changedInstance(r50) == false) goto L32;
        int r56 = 256;
    L33:
        r2 = r2 | r56;
        goto L35
    L32:
        r56 = 128;
        goto L33
    L17:
        if ((r53 & 48) != 0) goto L23;
        r4 = r49;
        if (r15.changed(r4) == false) goto L21;
        int r57 = 32;
    L22:
        r2 = r2 | r57;
        goto L25
    L21:
        r57 = 16;
        goto L22
    L6:
        if ((r53 & 6) == 0) goto L8;
        r2 = r53;
        goto L13
    L8:
        if (r15.changed(r48) == false) goto L10;
        int r58 = 4;
    L11:
        r2 = r58 | r53;
        goto L13
    L10:
        r58 = 2;
        goto L11
    }
}
