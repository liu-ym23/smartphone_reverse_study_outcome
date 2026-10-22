package com.ss.android.lark.profile_office.userprofile.section;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.RippleKt;
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
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.ss.android.lark.compose.foundation.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SettingItemKt {
    public static final void a(final int r75, final String r76, final Function2<? super Composer, ? super Integer, Unit> r77, boolean r78, boolean r79, Function0<Unit> r80, Composer r81, final int r82, final int r83) {
        Intrinsics.checkNotNullParameter(r76, "title");
        Intrinsics.checkNotNullParameter(r77, "trailing");
        Composer r14 = r81.startRestartGroup(-616986666);
        if ((r83 & 1) == 0) goto L6;
        int r4 = r82 | 6;
    L14:
        if ((r83 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L24:
        if ((r83 & 4) == 0) goto L27;
        r4 = r4 | 384;
    L33:
        int r5 = r83 & 8;
        if (r5 == 0) goto L37;
        r4 = r4 | 3072;
    L43:
        boolean r7 = r78;
    L44:
        int r8 = r83 & 16;
        if (r8 == 0) goto L48;
        r4 = r4 | 24576;
    L54:
        boolean r9 = r79;
    L55:
        int r10 = r83 & 32;
        if (r10 == 0) goto L59;
        r4 = r4 | 196608;
    L65:
        Function0<Unit> r11 = r80;
    L66:
        int r13 = r4;
        if ((74899 & r13) != 74898) goto L73;
        if (r14.getSkipping() == false) goto L73;
        r14.skipToGroupEnd();
        final boolean r6 = r7;
        final boolean r12 = r9;
        final Function0<Unit> r15 = r11;
        Composer r16 = r14;
    L159:
        ScopeUpdateScope r17 = r16.endRestartGroup();
        if (r17 == null) goto L163;
        r17.updateScope(new SettingItemKt$SettingItem$2(r75, r76, r77, r6, r12, r15, r82, r83));
        return;
    L163:
        return;
    L73:
        if (r5 == 0) goto L75;
        boolean r28 = false;
    L77:
        if (r8 == 0) goto L79;
        boolean r29 = true;
    L81:
        if (r10 == 0) goto L83;
        Function0<Unit> r30 = null;
    L85:
        if (ComposerKt.isTraceInProgress() == false) goto L87;
        ComposerKt.traceEventStart(-616986666, r13, -1, "com.ss.android.lark.profile_office.userprofile.section.SettingItem (SettingItem.kt:39)");
    L87:
        r14.startReplaceGroup(1849434622);
        Object r18 = r14.rememberedValue();
        Composer.Companion r19 = Composer.Companion;
        if (r18 != r19.getEmpty()) goto L90;
        r18 = InteractionSourceKt.MutableInteractionSource();
        r14.updateRememberedValue(r18);
    L90:
        MutableInteractionSource r110 = (MutableInteractionSource) r18;
        r14.endReplaceGroup();
        IndicationNodeFactory r111 = RippleKt.ripple-H2RKhps$default(true, 0.0f, n.a(r14, 0).d.f, 2, null);
        Modifier.Companion r112 = Modifier.Companion;
        Arrangement r20 = Arrangement.INSTANCE;
        Arrangement.Vertical r21 = r20.getTop();
        Alignment.Companion r31 = Alignment.Companion;
        MeasurePolicy r22 = ColumnKt.columnMeasurePolicy(r21, r31.getStart(), r14, 0);
        long r113 = ComposablesKt.getCurrentCompositeKeyHashCode(r14, 0);
        int r114 = (int) (r113 ^ (r113 >>> 32));
        CompositionLocalMap r115 = r14.getCurrentCompositionLocalMap();
        Modifier r116 = ComposedModifierKt.materializeModifier(r14, r112);
        ComposeUiNode.Companion r32 = ComposeUiNode.Companion;
        Function0 r23 = r32.getConstructor();
        if ((r14.getApplier() instanceof Applier) == true) goto L93;
        ComposablesKt.invalidApplier();
    L93:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L96;
        r14.createNode(r23);
    L97:
        Composer r3 = Updater.constructor-impl(r14);
        Updater.set-impl(r3, r22, r32.getSetMeasurePolicy());
        Updater.set-impl(r3, r115, r32.getSetResolvedCompositionLocals());
        Function2 r24 = r32.getSetCompositeKeyHash();
        if (r3.getInserting() == false) goto L100;
    L101:
        r3.updateRememberedValue(Integer.valueOf(r114));
        r3.apply(Integer.valueOf(r114), r24);
    L102:
        Updater.set-impl(r3, r116, r32.getSetModifier());
        ColumnScopeInstance r25 = ColumnScopeInstance.INSTANCE;
        Modifier r117 = SizeKt.fillMaxWidth$default(r112, 0.0f, 1, null);
        r14.startReplaceGroup(726375373);
        if (r30 != null) goto L108;
        r14.startReplaceGroup(1849434622);
        Object r26 = r14.rememberedValue();
        if (r26 != r19.getEmpty()) goto L107;
        r26 = SettingItemKt$SettingItem$1$1$1.INSTANCE;
        r14.updateRememberedValue(r26);
    L107:
        r14.endReplaceGroup();
        Function0<Unit> r27 = (Function0) r26;
    L109:
        r14.endReplaceGroup();
        if (r30 == null) goto L112;
        boolean r118 = true;
    L113:
        float r119 = 16;
        Modifier r33 = PaddingKt.padding-qDBjuR0$default(ClickableKt.clickable-O2vRcR0$default(r117, r110, r111, r118, null, null, r27, 24, null), Dp.constructor-impl(r119), 0.0f, Dp.constructor-impl(r119), 0.0f, 10, null);
        MeasurePolicy r34 = RowKt.rowMeasurePolicy(r20.getStart(), r31.getTop(), r14, 0);
        long r120 = ComposablesKt.getCurrentCompositeKeyHashCode(r14, 0);
        int r35 = (int) (r120 ^ (r120 >>> 32));
        CompositionLocalMap r36 = r14.getCurrentCompositionLocalMap();
        Modifier r37 = ComposedModifierKt.materializeModifier(r14, r33);
        Function0 r38 = r32.getConstructor();
        if ((r14.getApplier() instanceof Applier) == true) goto L116;
        ComposablesKt.invalidApplier();
    L116:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L119;
        r14.createNode(r38);
    L120:
        Composer r39 = Updater.constructor-impl(r14);
        Updater.set-impl(r39, r34, r32.getSetMeasurePolicy());
        Updater.set-impl(r39, r36, r32.getSetResolvedCompositionLocals());
        Function2 r40 = r32.getSetCompositeKeyHash();
        if (r39.getInserting() == false) goto L123;
    L124:
        r39.updateRememberedValue(Integer.valueOf(r35));
        r39.apply(Integer.valueOf(r35), r40);
    L125:
        Updater.set-impl(r39, r37, r32.getSetModifier());
        RowScopeInstance r41 = RowScopeInstance.INSTANCE;
        float r42 = 12;
        Modifier r43 = PaddingKt.padding-qDBjuR0$default(r112, 0.0f, Dp.constructor-impl(r42), 0.0f, Dp.constructor-impl(r42), 5, null);
        MeasurePolicy r44 = RowKt.rowMeasurePolicy(r20.getStart(), r31.getCenterVertically(), r14, 48);
        long r45 = ComposablesKt.getCurrentCompositeKeyHashCode(r14, 0);
        int r46 = (int) (r45 ^ (r45 >>> 32));
        CompositionLocalMap r47 = r14.getCurrentCompositionLocalMap();
        Modifier r48 = ComposedModifierKt.materializeModifier(r14, r43);
        Function0 r121 = r32.getConstructor();
        if ((r14.getApplier() instanceof Applier) == true) goto L128;
        ComposablesKt.invalidApplier();
    L128:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L131;
        r14.createNode(r121);
    L132:
        Composer r49 = Updater.constructor-impl(r14);
        Updater.set-impl(r49, r44, r32.getSetMeasurePolicy());
        Updater.set-impl(r49, r47, r32.getSetResolvedCompositionLocals());
        Function2 r50 = r32.getSetCompositeKeyHash();
        if (r49.getInserting() == false) goto L135;
    L136:
        r49.updateRememberedValue(Integer.valueOf(r46));
        r49.apply(Integer.valueOf(r46), r50);
    L137:
        Updater.set-impl(r49, r48, r32.getSetModifier());
        ImageVector.Companion r122 = ImageVector.Companion;
        IconKt.Icon-ww6aTOc(VectorResources_androidKt.vectorResource(r122, r75, r14, ((r13 << 3) & 112) | 6), null, SizeKt.size-3ABfNKs(r112, Dp.constructor-impl(32)), Color.Companion.getUnspecified-0d7_KjU(), r14, 3504, 0);
        SpacerKt.Spacer(SizeKt.width-3ABfNKs(r112, Dp.constructor-impl(r119)), r14, 6);
        TextKt.Text-Nvy7gAk(r76, null, n.a(r14, 0).d.a, null, 0, null, null, null, 0, null, null, 0, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, null, new TextStyle(0, TextUnitKt.getSp(17), FontWeight.Companion.getNormal(), null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777209, null), r14, (r13 >> 3) & 14, 12607872, 110586);
        r14.endNode();
        r16 = r14;
        SpacerKt.Spacer(SizeKt.width-3ABfNKs(r112, Dp.constructor-impl(r119)), r16, 6);
        Modifier r2 = r41.align(RowScope.-CC.weight$default(r41, r112, 1.0f, false, 2, null), r31.getCenterVertically());
        MeasurePolicy r51 = BoxKt.maybeCachedBoxMeasurePolicy(r31.getCenterEnd(), false);
        long r52 = ComposablesKt.getCurrentCompositeKeyHashCode(r16, 0);
        int r53 = (int) (r52 ^ (r52 >>> 32));
        CompositionLocalMap r54 = r16.getCurrentCompositionLocalMap();
        Modifier r55 = ComposedModifierKt.materializeModifier(r16, r2);
        Function0 r56 = r32.getConstructor();
        if ((r16.getApplier() instanceof Applier) == true) goto L140;
        ComposablesKt.invalidApplier();
    L140:
        r16.startReusableNode();
        if (r16.getInserting() == false) goto L143;
        r16.createNode(r56);
    L144:
        Composer r57 = Updater.constructor-impl(r16);
        Updater.set-impl(r57, r51, r32.getSetMeasurePolicy());
        Updater.set-impl(r57, r54, r32.getSetResolvedCompositionLocals());
        Function2 r58 = r32.getSetCompositeKeyHash();
        if (r57.getInserting() == false) goto L147;
    L148:
        r57.updateRememberedValue(Integer.valueOf(r53));
        r57.apply(Integer.valueOf(r53), r58);
    L149:
        Updater.set-impl(r57, r55, r32.getSetModifier());
        BoxScopeInstance r59 = BoxScopeInstance.INSTANCE;
        r77.invoke(r16, Integer.valueOf((r13 >> 6) & 14));
        r16.endNode();
        r16.startReplaceGroup(-1015462240);
        if (r28 == false) goto L152;
        IconKt.Icon-ww6aTOc(VectorResources_androidKt.vectorResource(r122, 2131237742, r16, 6), null, r41.align(SizeKt.size-3ABfNKs(r112, Dp.constructor-impl(24)), r31.getCenterVertically()), n.a(r16, 0).d.d, r16, 48, 0);
    L152:
        r16.endReplaceGroup();
        r16.endNode();
        r16.startReplaceGroup(726437294);
        if (r29 == false) goto L155;
        DividerKt.HorizontalDivider-9IZ8Weo(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(r112, 0.0f, 1, null), Dp.constructor-impl(64), 0.0f, 0.0f, 0.0f, 14, null), Dp.constructor-impl((float) 0.5d), n.a(r16, 0).d.f, r16, 54, 0);
    L155:
        r16.endReplaceGroup();
        r16.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L158;
        ComposerKt.traceEventEnd();
    L158:
        r6 = r28;
        r12 = r29;
        r15 = r30;
        goto L159
    L147:
        if (Intrinsics.areEqual(r57.rememberedValue(), Integer.valueOf(r53)) == true) goto L149;
    L143:
        r16.useNode();
        goto L144
    L135:
        if (Intrinsics.areEqual(r49.rememberedValue(), Integer.valueOf(r46)) == true) goto L137;
    L131:
        r14.useNode();
        goto L132
    L123:
        if (Intrinsics.areEqual(r39.rememberedValue(), Integer.valueOf(r35)) == true) goto L125;
    L119:
        r14.useNode();
        goto L120
    L112:
        r118 = false;
        goto L113
    L108:
        r27 = r30;
        goto L109
    L100:
        if (Intrinsics.areEqual(r3.rememberedValue(), Integer.valueOf(r114)) == true) goto L102;
    L96:
        r14.useNode();
        goto L97
    L83:
        r30 = r11;
        goto L85
    L79:
        r29 = r9;
        goto L81
    L75:
        r28 = r7;
        goto L77
    L59:
        if ((196608 & r82) != 0) goto L65;
        r11 = r80;
        if (r14.changedInstance(r11) == false) goto L63;
        int r123 = 131072;
    L64:
        r4 = r4 | r123;
        goto L66
    L63:
        r123 = 65536;
        goto L64
    L48:
        if ((r82 & 24576) != 0) goto L54;
        r9 = r79;
        if (r14.changed(r9) == false) goto L52;
        int r124 = 16384;
    L53:
        r4 = r4 | r124;
        goto L55
    L52:
        r124 = 8192;
        goto L53
    L37:
        if ((r82 & 3072) != 0) goto L43;
        r7 = r78;
        if (r14.changed(r7) == false) goto L41;
        int r60 = 2048;
    L42:
        r4 = r4 | r60;
        goto L44
    L41:
        r60 = 1024;
        goto L42
    L27:
        if ((r82 & 384) != 0) goto L33;
        if (r14.changedInstance(r77) == false) goto L31;
        int r61 = 256;
    L32:
        r4 = r4 | r61;
        goto L33
    L31:
        r61 = 128;
        goto L32
    L17:
        if ((r82 & 48) != 0) goto L24;
        if (r14.changed(r76) == false) goto L21;
        int r62 = 32;
    L22:
        r4 = r4 | r62;
        goto L24
    L21:
        r62 = 16;
        goto L22
    L6:
        if ((r82 & 6) == 0) goto L8;
        r4 = r82;
        goto L14
    L8:
        if (r14.changed(r75) == false) goto L10;
        int r63 = 4;
    L11:
        r4 = r63 | r82;
        goto L14
    L10:
        r63 = 2;
        goto L11
    }
}
