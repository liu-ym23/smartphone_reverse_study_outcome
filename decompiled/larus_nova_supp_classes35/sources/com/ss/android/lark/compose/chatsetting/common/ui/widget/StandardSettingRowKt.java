package com.ss.android.lark.compose.chatsetting.common.ui.widget;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.compose.chatsetting.common.ui.icon.ChatSettingIcons;
import com.ss.android.lark.compose.foundation.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class StandardSettingRowKt {
    public static final void a(Modifier r41, final String r42, a r43, String r44, boolean r45, Composer r46, final int r47, final int r48) {
        Intrinsics.checkNotNullParameter(r42, "title");
        Composer r15 = r46.startRestartGroup(-649859723);
        int r2 = r48 & 1;
        if (r2 == 0) goto L6;
        int r5 = r47 | 6;
        Modifier r4 = r41;
    L14:
        if ((r48 & 2) == 0) goto L17;
        r5 = r5 | 48;
    L23:
        int r6 = r48 & 4;
        if (r6 == 0) goto L27;
        r5 = r5 | 384;
    L33:
        a r8 = r43;
    L34:
        int r9 = r48 & 8;
        if (r9 == 0) goto L38;
        r5 = r5 | 3072;
    L44:
        String r10 = r44;
    L45:
        int r11 = r48 & 16;
        if (r11 == 0) goto L49;
        r5 = r5 | 24576;
    L55:
        boolean r12 = r45;
    L57:
        if ((r5 & 9363) == 9362) goto L59;
    L62:
        if (r2 == 0) goto L64;
        Modifier r13 = Modifier.Companion;
    L66:
        if (r6 == 0) goto L68;
        r8 = null;
    L68:
        if (r9 == 0) goto L70;
        String r28 = null;
    L72:
        if (r11 == 0) goto L74;
        boolean r29 = true;
    L76:
        if (ComposerKt.isTraceInProgress() == false) goto L78;
        ComposerKt.traceEventStart(-649859723, r5, -1, "com.ss.android.lark.compose.chatsetting.common.ui.widget.StandardSettingRow (StandardSettingRow.kt:30)");
    L78:
        float r7 = 12;
        Modifier r1 = PaddingKt.padding-VpY3zN4(SizeKt.heightIn-VpY3zN4$default(SizeKt.fillMaxWidth$default(r13, 0.0f, 1, null), Dp.constructor-impl(56), 0.0f, 2, null), Dp.constructor-impl(16), Dp.constructor-impl(r7));
        Alignment.Companion r27 = Alignment.Companion;
        MeasurePolicy r14 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), r27.getCenterVertically(), r15, 48);
        long r16 = ComposablesKt.getCurrentCompositeKeyHashCode(r15, 0);
        Modifier r20 = r13;
        int r17 = (int) (r16 ^ (r16 >>> 32));
        CompositionLocalMap r18 = r15.getCurrentCompositionLocalMap();
        Modifier r3 = ComposedModifierKt.materializeModifier(r15, r1);
        ComposeUiNode.Companion r30 = ComposeUiNode.Companion;
        Function0 r19 = r30.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L81;
        ComposablesKt.invalidApplier();
    L81:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L84;
        r15.createNode(r19);
    L85:
        Composer r110 = Updater.constructor-impl(r15);
        Updater.set-impl(r110, r14, r30.getSetMeasurePolicy());
        Updater.set-impl(r110, r18, r30.getSetResolvedCompositionLocals());
        Function2 r21 = r30.getSetCompositeKeyHash();
        if (r110.getInserting() == false) goto L88;
    L89:
        r110.updateRememberedValue(Integer.valueOf(r17));
        r110.apply(Integer.valueOf(r17), r21);
    L90:
        Updater.set-impl(r110, r3, r30.getSetModifier());
        RowScopeInstance r31 = RowScopeInstance.INSTANCE;
        r15.startReplaceGroup(171575366);
        if (r8 == null) goto L94;
        ColoredSettingIconKt.a(r8, null, r15, 0, 2);
        SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(r7)), r15, 6);
        Unit r22 = Unit.INSTANCE;
    L94:
        r15.endReplaceGroup();
        Modifier.Companion r111 = Modifier.Companion;
        a r39 = r8;
        Modifier r40 = r20;
        TextKt.Text-Nvy7gAk(r42, PaddingKt.padding-qDBjuR0$default(r111, 0.0f, 0.0f, Dp.constructor-impl(r7), 0.0f, 11, null), n.a(r15, 0).d.a, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, n.b(r15).b, r15, ((r5 >> 3) & 14) | 48, 0, 131064);
        Modifier r0 = RowScope.-CC.weight$default(r31, r111, 1.0f, false, 2, null);
        MeasurePolicy r23 = BoxKt.maybeCachedBoxMeasurePolicy(r27.getCenterEnd(), false);
        long r24 = ComposablesKt.getCurrentCompositeKeyHashCode(r15, 0);
        int r25 = (int) (r24 ^ (r24 >>> 32));
        CompositionLocalMap r26 = r15.getCurrentCompositionLocalMap();
        Modifier r32 = ComposedModifierKt.materializeModifier(r15, r0);
        Function0 r33 = r30.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L97;
        ComposablesKt.invalidApplier();
    L97:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L100;
        r15.createNode(r33);
    L101:
        Composer r34 = Updater.constructor-impl(r15);
        Updater.set-impl(r34, r23, r30.getSetMeasurePolicy());
        Updater.set-impl(r34, r26, r30.getSetResolvedCompositionLocals());
        Function2 r35 = r30.getSetCompositeKeyHash();
        if (r34.getInserting() == false) goto L104;
    L105:
        r34.updateRememberedValue(Integer.valueOf(r25));
        r34.apply(Integer.valueOf(r25), r35);
    L106:
        Updater.set-impl(r34, r32, r30.getSetModifier());
        BoxScopeInstance r36 = BoxScopeInstance.INSTANCE;
        r15.startReplaceGroup(-614346192);
        if (r28 != null) goto L109;
        Composer r37 = r15;
        int r38 = 0;
    L110:
        r37.endReplaceGroup();
        r37.endNode();
        r37.startReplaceGroup(171605282);
        if (r29 == false) goto L113;
        IconKt.Icon-ww6aTOc((ImageVector) ChatSettingIcons.l.getValue(), null, SizeKt.size-3ABfNKs(r111, Dp.constructor-impl(24)), n.a(r37, r38).d.d, r37, 432, 0);
    L113:
        r37.endReplaceGroup();
        r37.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L116;
        ComposerKt.traceEventEnd();
    L116:
        final String r49 = r28;
        final boolean r50 = r29;
        final a r51 = r39;
    L117:
        ScopeUpdateScope r52 = r37.endRestartGroup();
        if (r52 == null) goto L121;
        final Modifier r53 = r40;
        r52.updateScope(new StandardSettingRowKt$StandardSettingRow$2(r53, r42, r51, r49, r50, r47, r48));
        return;
    L121:
        return;
    L109:
        TextStyle r54 = n.b(r15).c;
        long r55 = n.a(r15, 0).d.b;
        r37 = r15;
        r38 = 0;
        TextKt.Text-Nvy7gAk(r28, PaddingKt.padding-qDBjuR0$default(r111, 0.0f, 0.0f, Dp.constructor-impl(4), 0.0f, 11, null), r55, null, 0, null, null, null, 0, null, null, 0, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, null, r54, r37, 48, 24960, 110584);
        Unit r56 = Unit.INSTANCE;
        goto L110
    L104:
        if (Intrinsics.areEqual(r34.rememberedValue(), Integer.valueOf(r25)) == true) goto L106;
    L100:
        r15.useNode();
        goto L101
    L88:
        if (Intrinsics.areEqual(r110.rememberedValue(), Integer.valueOf(r17)) == true) goto L90;
    L84:
        r15.useNode();
        goto L85
    L74:
        r29 = r12;
        goto L76
    L70:
        r28 = r10;
        goto L72
    L64:
        r13 = r4;
        goto L66
    L59:
        if (r15.getSkipping() == false) goto L62;
        r15.skipToGroupEnd();
        r40 = r4;
        r51 = r8;
        r49 = r10;
        r50 = r12;
        r37 = r15;
        goto L117
    L49:
        if ((r47 & 24576) != 0) goto L55;
        r12 = r45;
        if (r15.changed(r12) == false) goto L53;
        int r112 = 16384;
    L54:
        r5 = r5 | r112;
        goto L57
    L53:
        r112 = 8192;
        goto L54
    L38:
        if ((r47 & 3072) != 0) goto L44;
        r10 = r44;
        if (r15.changed(r10) == false) goto L42;
        int r113 = 2048;
    L43:
        r5 = r5 | r113;
        goto L45
    L42:
        r113 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L43
    L27:
        if ((r47 & 384) != 0) goto L33;
        r8 = r43;
        if (r15.changed(r8) == false) goto L31;
        int r57 = 256;
    L32:
        r5 = r5 | r57;
        goto L34
    L31:
        r57 = 128;
        goto L32
    L17:
        if ((r47 & 48) != 0) goto L23;
        if (r15.changed(r42) == false) goto L21;
        int r58 = 32;
    L22:
        r5 = r5 | r58;
        goto L23
    L21:
        r58 = 16;
        goto L22
    L6:
        if ((r47 & 6) != 0) goto L12;
        r4 = r41;
        if (r15.changed(r4) == false) goto L10;
        int r59 = 4;
    L11:
        r5 = r59 | r47;
        goto L14
    L10:
        r59 = 2;
        goto L11
    L12:
        r4 = r41;
        r5 = r47;
        goto L14
    }
}
