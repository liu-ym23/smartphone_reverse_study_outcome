package com.larksuite.component.universe_design.badge.compose;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final class UDBadgeKt$UDBadgeAnchorLayout$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ UDBadgeAnchorAlign $align;
    final /* synthetic */ Function2<Composer, Integer, Unit> $anchor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $badge;
    final /* synthetic */ boolean $isAnchorCircle;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ float $offsetX;
    final /* synthetic */ float $offsetY;

    public UDBadgeKt$UDBadgeAnchorLayout$3(Modifier r1, UDBadgeAnchorAlign r2, boolean r3, float r4, float r5, Function2<? super Composer, ? super Integer, Unit> r6, Function2<? super Composer, ? super Integer, Unit> r7, int r8, int r9) {
        this.$modifier = r1;
        this.$align = r2;
        this.$isAnchorCircle = r3;
        this.$offsetX = r4;
        this.$offsetY = r5;
        this.$anchor = r6;
        this.$badge = r7;
        this.$$changed = r8;
        this.$$default = r9;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r26, int r27) {
        Modifier r1 = this.$modifier;
        UDBadgeAnchorAlign r2 = this.$align;
        boolean r3 = this.$isAnchorCircle;
        float r4 = this.$offsetX;
        float r5 = this.$offsetY;
        Function2<Composer, Integer, Unit> r12 = this.$anchor;
        Function2<Composer, Integer, Unit> r13 = this.$badge;
        int r14 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1);
        int r15 = this.$$default;
        Intrinsics.checkNotNullParameter(r12, "anchor");
        Intrinsics.checkNotNullParameter(r13, "badge");
        Composer r8 = r26.startRestartGroup(-1412640727);
        int r9 = r15 & 1;
        if (r9 == 0) goto L6;
        int r10 = r14 | 6;
    L13:
        int r11 = r15 & 2;
        if (r11 == 0) goto L17;
        r10 = r10 | 48;
    L26:
        int r6 = r15 & 4;
        if (r6 == 0) goto L30;
        r10 = r10 | 384;
    L36:
        int r7 = r10;
    L37:
        int r16 = r15 & 8;
        if (r16 == 0) goto L41;
        r7 = r7 | 3072;
    L47:
        int r0 = r7;
    L48:
        int r17 = r15 & 16;
        if (r17 == 0) goto L52;
        r0 = r0 | 24576;
    L59:
        if ((r15 & 32) == 0) goto L62;
        r0 = r0 | 196608;
    L69:
        if ((r15 & 64) == 0) goto L72;
        r0 = r0 | 1572864;
    L78:
        UDBadgeAnchorAlign r19 = r2;
        if ((599187 & r0) == 599186) goto L81;
    L84:
        if (r9 == 0) goto L86;
        Modifier r20 = Modifier.Companion;
    L87:
        if (r11 == 0) goto L89;
        UDBadgeAnchorAlign r21 = UDBadgeAnchorAlign.RightTop;
    L91:
        if (r6 == 0) goto L93;
        r3 = false;
    L93:
        if (r16 == 0) goto L95;
        r4 = Dp.constructor-impl(0);
    L95:
        if (r17 == 0) goto L98;
        r5 = Dp.constructor-impl(0);
    L98:
        if (ComposerKt.isTraceInProgress() == false) goto L100;
        ComposerKt.traceEventStart(-1412640727, r0, -1, "com.larksuite.component.universe_design.badge.compose.UDBadgeAnchorLayout (UDBadge.kt:73)");
    L100:
        final Density r22 = (Density) r8.consume(CompositionLocalsKt.getLocalDensity());
        r8.startReplaceGroup(-1224400529);
        boolean r23 = r8.changed(r22);
        if ((r0 & 7168) != 2048) goto L103;
        boolean r110 = true;
    L104:
        boolean r24 = r23 | r110;
        if ((57344 & r0) != 16384) goto L107;
        boolean r111 = true;
    L108:
        boolean r25 = r24 | r111;
        if ((r0 & 896) != 256) goto L111;
        boolean r112 = true;
    L112:
        boolean r29 = r25 | r112;
        if ((r0 & 112) != 32) goto L115;
        boolean r113 = true;
    L116:
        boolean r30 = r29 | r113;
        Object r114 = r8.rememberedValue();
        if (r30 == false) goto L119;
    L120:
        final boolean r210 = r3;
        final UDBadgeAnchorAlign r211 = r21;
        final float r212 = r4;
        final float r213 = r5;
        r114 = new UDBadgeKt$UDBadgeAnchorLayout$1$1(r22, r210, r211, r212, r213);
        r8.updateRememberedValue(r114);
    L121:
        MeasurePolicy r115 = (MeasurePolicy) r114;
        r8.endReplaceGroup();
        long r31 = ComposablesKt.getCurrentCompositeKeyHashCode(r8, 0);
        int r32 = (int) (r31 ^ (r31 >>> 32));
        CompositionLocalMap r33 = r8.getCurrentCompositionLocalMap();
        Modifier r34 = ComposedModifierKt.materializeModifier(r8, r20);
        ComposeUiNode.Companion r116 = ComposeUiNode.Companion;
        Modifier r117 = r20;
        Function0 r35 = r116.getConstructor();
        UDBadgeAnchorAlign r214 = r21;
        if ((r8.getApplier() instanceof Applier) == true) goto L124;
        ComposablesKt.invalidApplier();
    L124:
        r8.startReusableNode();
        if (r8.getInserting() == false) goto L127;
        r8.createNode(r35);
    L128:
        Composer r36 = Updater.constructor-impl(r8);
        Updater.set-impl(r36, r115, r116.getSetMeasurePolicy());
        Updater.set-impl(r36, r33, r116.getSetResolvedCompositionLocals());
        Function2 r37 = r116.getSetCompositeKeyHash();
        if (r36.getInserting() == false) goto L131;
    L132:
        r36.updateRememberedValue(Integer.valueOf(r32));
        r36.apply(Integer.valueOf(r32), r37);
    L133:
        Updater.set-impl(r36, r34, r116.getSetModifier());
        r12.invoke(r8, Integer.valueOf((r0 >> 15) & 14));
        r13.invoke(r8, Integer.valueOf((r0 >> 18) & 14));
        r8.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L136;
        ComposerKt.traceEventEnd();
    L136:
        r19 = r214;
        boolean r38 = r3;
        float r118 = r4;
        float r119 = r5;
        Modifier r39 = r117;
    L137:
        ScopeUpdateScope r40 = r8.endRestartGroup();
        if (r40 == null) goto L141;
        r40.updateScope(new UDBadgeKt$UDBadgeAnchorLayout$3(r39, r19, r38, r118, r119, r12, r13, r14, r15));
        return;
    L141:
        return;
    L131:
        if (Intrinsics.areEqual(r36.rememberedValue(), Integer.valueOf(r32)) == true) goto L133;
    L127:
        r8.useNode();
        goto L128
    L119:
        if (r114 != Composer.Companion.getEmpty()) goto L121;
    L115:
        r113 = false;
        goto L116
    L111:
        r112 = false;
        goto L112
    L107:
        r111 = false;
        goto L108
    L103:
        r110 = false;
        goto L104
    L89:
        r21 = r19;
        goto L91
    L86:
        r20 = r1;
        goto L87
    L81:
        if (r8.getSkipping() == false) goto L84;
        r8.skipToGroupEnd();
        r38 = r3;
        r118 = r4;
        r119 = r5;
        r39 = r1;
        goto L137
    L72:
        if ((r14 & 1572864) != 0) goto L78;
        if (r8.changedInstance(r13) == false) goto L76;
        int r41 = 1048576;
    L77:
        r0 = r0 | r41;
        goto L78
    L76:
        r41 = 524288;
        goto L77
    L62:
        if ((r14 & 196608) != 0) goto L69;
        if (r8.changedInstance(r12) == false) goto L66;
        int r42 = 131072;
    L67:
        r0 = r0 | r42;
        goto L69
    L66:
        r42 = 65536;
        goto L67
    L52:
        if ((r14 & 24576) != 0) goto L59;
        if (r8.changed(r5) == false) goto L56;
        int r43 = 16384;
    L57:
        r0 = r0 | r43;
        goto L59
    L56:
        r43 = 8192;
        goto L57
    L41:
        if ((r14 & 3072) != 0) goto L47;
        if (r8.changed(r4) == false) goto L45;
        int r44 = 2048;
    L46:
        r0 = r44 | r7;
        goto L48
    L45:
        r44 = 1024;
        goto L46
    L30:
        if ((r14 & 384) != 0) goto L36;
        if (r8.changed(r3) == false) goto L34;
        int r45 = 256;
    L35:
        r7 = r45 | r10;
        goto L37
    L34:
        r45 = 128;
        goto L35
    L17:
        if ((r14 & 48) != 0) goto L26;
        if (r2 != null) goto L20;
        int r46 = -1;
    L22:
        if (r8.changed(r46) == false) goto L24;
        int r47 = 32;
    L25:
        r10 = r10 | r47;
        goto L26
    L24:
        r47 = 16;
        goto L25
    L20:
        r46 = r2.ordinal();
        goto L22
    L6:
        if ((r14 & 6) == 0) goto L8;
        r10 = r14;
        goto L13
    L8:
        if (r8.changed(r1) == false) goto L10;
        int r120 = 4;
    L11:
        r10 = r120 | r14;
        goto L13
    L10:
        r120 = 2;
        goto L11
    }
}
