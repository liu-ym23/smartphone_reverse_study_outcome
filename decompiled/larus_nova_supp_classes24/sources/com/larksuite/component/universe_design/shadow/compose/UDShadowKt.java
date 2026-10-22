package com.larksuite.component.universe_design.shadow.compose;

import android.graphics.Paint;
import android.graphics.RectF;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
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
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UDShadowKt {
    public static final a a = null;
    public static final a b = null;

    static {
        a = new a(ColorKt.Color(253698857), ColorKt.Color(337584937), ColorKt.Color(387916585), ColorKt.Color(438248233), ColorKt.Color(689906473), ColorKt.Color(522476507), ColorKt.Color(690248667), ColorKt.Color(774134747), ColorKt.Color(858020827), ColorKt.Color(1025792987));
        b = new a(ColorKt.Color(251658240), ColorKt.Color(335544320), ColorKt.Color(385875968), ColorKt.Color(436207616), ColorKt.Color(687865856), ColorKt.Color(522476507), ColorKt.Color(690248667), ColorKt.Color(774134747), ColorKt.Color(858020827), ColorKt.Color(1025792987));
    }

    public static final void a(Modifier r32, UDShadowSize r33, UDShadowDirection r34, long r35, float r37, PaddingValues r38, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> r39, Composer r40, final int r41, final int r42) {
        Intrinsics.checkNotNullParameter(r39, "content");
        Composer r1 = r40.startRestartGroup(-825540195);
        int r2 = r42 & 1;
        if (r2 == 0) goto L6;
        int r4 = r41 | 6;
        Modifier r3 = r32;
    L13:
        int r5 = r42 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L26:
        int r10 = r42 & 4;
        if (r10 == 0) goto L30;
        r4 = r4 | 384;
    L40:
        if ((r41 & 3072) != 0) goto L48;
        long r14 = r35;
        if ((r42 & 8) == 0) goto L44;
    L46:
        int r12 = 1024;
    L47:
        r4 = r4 | r12;
    L49:
        int r13 = r42 & 16;
        if (r13 == 0) goto L53;
        r4 = r4 | 24576;
    L59:
        float r15 = r37;
    L60:
        int r16 = r42 & 32;
        if (r16 == 0) goto L63;
        r4 = r4 | 196608;
        PaddingValues r11 = r38;
    L71:
        if ((r42 & 64) == 0) goto L74;
        r4 = r4 | 1572864;
    L81:
        if ((r4 & 599187) == 599186) goto L83;
    L86:
        r1.startDefaults();
        if ((r41 & 1) != 0) goto L89;
    L95:
        if (r2 == 0) goto L97;
        Modifier r0 = Modifier.Companion;
    L98:
        if (r5 == 0) goto L100;
        final UDShadowSize r6 = UDShadowSize.None;
    L101:
        if (r10 == 0) goto L103;
        final UDShadowDirection r7 = UDShadowDirection.None;
    L105:
        if ((r42 & 8) == 0) goto L133;
        int r8 = b.a;
        int r9 = ((r4 >> 3) & 14) | 384;
        Intrinsics.checkNotNullParameter(r6, "size");
        if (ComposerKt.isTraceInProgress() == false) goto L109;
        ComposerKt.traceEventStart(-1711305210, r9, -1, "com.larksuite.component.universe_design.shadow.compose.UDShadowDefaults.color (UDShadow.kt:88)");
    L109:
        int r17 = c.a;
        if (ComposerKt.isTraceInProgress() == false) goto L113;
        ComposerKt.traceEventStart(-984608205, 6, -1, "com.larksuite.component.universe_design.shadow.compose.UDShadowTheme.<get-colorScheme> (UDShadow.kt:124)");
    L113:
        if (DarkThemeKt.isSystemInDarkTheme(r1, 0) == false) goto L115;
        a r19 = b;
    L117:
        if (ComposerKt.isTraceInProgress() == false) goto L119;
        ComposerKt.traceEventEnd();
    L119:
        r19.getClass();
        Intrinsics.checkNotNullParameter(r6, "size");
        switch(a.C0042a.a[r6.ordinal()]) {
            case 1: goto L128;
            case 2: goto L127;
            case 3: goto L126;
            case 4: goto L125;
            case 5: goto L124;
            case 6: goto L123;
            default: goto L122;
        };
    L123:
        r14 = r19.e;
    L130:
        if (ComposerKt.isTraceInProgress() == false) goto L132;
        ComposerKt.traceEventEnd();
    L132:
        r4 = r4 & (-7169);
        goto L133
    L124:
        r14 = r19.d;
        goto L130
    L125:
        r14 = r19.c;
        goto L130
    L126:
        r14 = r19.b;
        goto L130
    L127:
        r14 = r19.a;
        goto L130
    L128:
        r14 = Color.Companion.getTransparent-0d7_KjU();
        goto L130
    L122:
        throw new NoWhenBranchMatchedException();
    L115:
        r19 = a;
    L133:
        if (r13 == 0) goto L135;
        float r20 = Dp.constructor-impl(0);
    L136:
        if (r16 == 0) goto L138;
        r11 = PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0));
    L138:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L141;
        ComposerKt.traceEventStart(-825540195, r4, -1, "com.larksuite.component.universe_design.shadow.compose.UDShadow (UDShadow.kt:36)");
    L141:
        final LayoutDirection r21 = (LayoutDirection) r1.consume(CompositionLocalsKt.getLocalLayoutDirection());
        final Density r110 = (Density) r1.consume(CompositionLocalsKt.getLocalDensity());
        float r111 = 0;
        float r22 = ComparisonsKt.maxOf(Dp.box-impl(Dp.constructor-impl(r111)), Dp.box-impl(Dp.constructor-impl(r6.m310getBlurD9Ej5fM$universe_ui_shadow_release() - Dp.constructor-impl(r6.m311getOffsetD9Ej5fM$universe_ui_shadow_release() * r7.getX$universe_ui_shadow_release())))).unbox-impl();
        float r23 = ComparisonsKt.maxOf(Dp.box-impl(Dp.constructor-impl(r111)), Dp.box-impl(Dp.constructor-impl(r6.m310getBlurD9Ej5fM$universe_ui_shadow_release() - Dp.constructor-impl(r6.m311getOffsetD9Ej5fM$universe_ui_shadow_release() * r7.getY$universe_ui_shadow_release())))).unbox-impl();
        float r24 = ComparisonsKt.maxOf(Dp.box-impl(Dp.constructor-impl(r111)), Dp.box-impl(Dp.constructor-impl(r6.m310getBlurD9Ej5fM$universe_ui_shadow_release() + Dp.constructor-impl(r6.m311getOffsetD9Ej5fM$universe_ui_shadow_release() * r7.getX$universe_ui_shadow_release())))).unbox-impl();
        float r25 = ComparisonsKt.maxOf(Dp.box-impl(Dp.constructor-impl(r111)), Dp.box-impl(Dp.constructor-impl(r6.m310getBlurD9Ej5fM$universe_ui_shadow_release() + Dp.constructor-impl(r6.m311getOffsetD9Ej5fM$universe_ui_shadow_release() * r7.getY$universe_ui_shadow_release())))).unbox-impl();
        LayoutDirection r112 = LayoutDirection.Ltr;
        if (r21 != r112) goto L144;
        float r113 = r22;
    L145:
        if (r21 != r112) goto L147;
        float r114 = r24;
    L148:
        Modifier r115 = r0;
        final PaddingValues r26 = PaddingKt.PaddingValues-a9UjIt4(ComparisonsKt.maxOf(Dp.box-impl(Dp.constructor-impl(r111)), Dp.box-impl(Dp.constructor-impl(r113 - PaddingKt.calculateStartPadding(r11, r21)))).unbox-impl(), ComparisonsKt.maxOf(Dp.box-impl(Dp.constructor-impl(r111)), Dp.box-impl(Dp.constructor-impl(r23 - r11.calculateTopPadding-D9Ej5fM()))).unbox-impl(), ComparisonsKt.maxOf(Dp.box-impl(Dp.constructor-impl(r111)), Dp.box-impl(Dp.constructor-impl(r114 - PaddingKt.calculateEndPadding(r11, r21)))).unbox-impl(), ComparisonsKt.maxOf(Dp.box-impl(Dp.constructor-impl(r111)), Dp.box-impl(Dp.constructor-impl(r25 - r11.calculateBottomPadding-D9Ej5fM()))).unbox-impl());
        r1.startReplaceGroup(1849434622);
        Object r27 = r1.rememberedValue();
        Composer.Companion r29 = Composer.Companion;
        Object r30 = r27;
        if (r27 != r29.getEmpty()) goto L151;
        Paint r31 = new Paint(1);
        r31.setStyle(Paint.Style.FILL);
        r1.updateRememberedValue(r31);
        r30 = r31;
    L151:
        final Paint r36 = (Paint) r30;
        r1.endReplaceGroup();
        r1.startReplaceGroup(1849434622);
        Object r43 = r1.rememberedValue();
        if (r43 != r29.getEmpty()) goto L154;
        r43 = new RectF();
        r1.updateRememberedValue(r43);
    L154:
        final RectF r44 = (RectF) r43;
        r1.endReplaceGroup();
        r1.startReplaceGroup(-1224400529);
        if ((r4 & 112) != 32) goto L157;
        boolean r116 = true;
    L158:
        final float r310 = r20;
        if ((r4 & 896) != 256) goto L161;
        boolean r45 = true;
    L162:
        boolean r46 = (r45 | r116) | r1.changed(r110);
        if ((458752 & r4) != 131072) goto L165;
        boolean r117 = true;
    L166:
        boolean r47 = ((r46 | r117) | r1.changed(r21.ordinal())) | r1.changed(r26);
        if ((57344 & r4) != 16384) goto L169;
        boolean r118 = true;
    L170:
        boolean r48 = (r47 | r118) | r1.changedInstance(r36);
        if (((r4 & 7168) ^ 3072) <= 2048) goto L175;
        if (r1.changed(r14) == false) goto L175;
    L176:
        boolean r119 = true;
    L178:
        boolean r49 = (r48 | r119) | r1.changedInstance(r44);
        Object r120 = r1.rememberedValue();
        if (r49 == false) goto L181;
    L182:
        final UDShadowSize r210 = r6;
        final UDShadowDirection r211 = r7;
        final long r212 = r14;
        final PaddingValues r213 = r11;
        r120 = new UDShadowKt$UDShadow$1$1(r210, r211, r110, r36, r212, r44, r213, r21, r26, r310);
        r1.updateRememberedValue(r120);
    L183:
        r1.endReplaceGroup();
        Modifier r50 = r115;
        Modifier r51 = PaddingKt.padding(PaddingKt.padding(DrawModifierKt.drawBehind(r50, (Function1) r120), r26), r11);
        MeasurePolicy r52 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        long r53 = ComposablesKt.getCurrentCompositeKeyHashCode(r1, 0);
        int r54 = (int) (r53 ^ (r53 >>> 32));
        CompositionLocalMap r55 = r1.getCurrentCompositionLocalMap();
        Modifier r56 = ComposedModifierKt.materializeModifier(r1, r51);
        ComposeUiNode.Companion r57 = ComposeUiNode.Companion;
        Function0 r121 = r57.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L186;
        ComposablesKt.invalidApplier();
    L186:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L189;
        r1.createNode(r121);
    L190:
        Composer r122 = Updater.constructor-impl(r1);
        Updater.set-impl(r122, r52, r57.getSetMeasurePolicy());
        Updater.set-impl(r122, r55, r57.getSetResolvedCompositionLocals());
        Function2 r59 = r57.getSetCompositeKeyHash();
        if (r122.getInserting() == false) goto L193;
    L194:
        r122.updateRememberedValue(Integer.valueOf(r54));
        r122.apply(Integer.valueOf(r54), r59);
    L195:
        Updater.set-impl(r122, r56, r57.getSetModifier());
        r39.invoke(BoxScopeInstance.INSTANCE, r1, Integer.valueOf(((r4 >> 15) & 112) | 6));
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L198;
        ComposerKt.traceEventEnd();
    L198:
        final float r60 = r310;
        final PaddingValues r61 = r11;
    L199:
        ScopeUpdateScope r123 = r1.endRestartGroup();
        if (r123 == null) goto L203;
        final Modifier r62 = r50;
        final long r63 = r14;
        r123.updateScope(new UDShadowKt$UDShadow$3(r62, r6, r7, r63, r60, r61, r39, r41, r42));
        return;
    L203:
        return;
    L193:
        if (Intrinsics.areEqual(r122.rememberedValue(), Integer.valueOf(r54)) == true) goto L195;
    L189:
        r1.useNode();
        goto L190
    L181:
        if (r120 != r29.getEmpty()) goto L183;
    L175:
        if ((r4 & 3072) == 2048) goto L176;
        r119 = false;
        goto L178
    L169:
        r118 = false;
        goto L170
    L165:
        r117 = false;
        goto L166
    L161:
        r45 = false;
        goto L162
    L157:
        r116 = false;
        goto L158
    L147:
        r114 = r22;
        goto L148
    L144:
        r113 = r24;
        goto L145
    L135:
        r20 = r15;
        goto L136
    L103:
        r7 = r34;
        goto L105
    L100:
        r6 = r33;
        goto L101
    L97:
        r0 = r3;
        goto L98
    L89:
        if (r1.getDefaultsInvalid() == true) goto L95;
        r1.skipToGroupEnd();
        if ((r42 & 8) == 0) goto L94;
        r4 = r4 & (-7169);
    L94:
        r6 = r33;
        r0 = r3;
        r20 = r15;
        r7 = r34;
        goto L138
    L83:
        if (r1.getSkipping() == false) goto L86;
        r1.skipToGroupEnd();
        r6 = r33;
        r50 = r3;
        r61 = r11;
        r60 = r15;
        r7 = r34;
        goto L199
    L74:
        if ((r41 & 1572864) != 0) goto L81;
        if (r1.changedInstance(r39) == false) goto L78;
        int r124 = 1048576;
    L79:
        r4 = r4 | r124;
        goto L81
    L78:
        r124 = 524288;
        goto L79
    L63:
        r11 = r38;
        if ((r41 & 196608) != 0) goto L71;
        if (r1.changed(r11) == false) goto L68;
        int r125 = 131072;
    L69:
        r4 = r4 | r125;
        goto L71
    L68:
        r125 = 65536;
        goto L69
    L53:
        if ((r41 & 24576) != 0) goto L59;
        r15 = r37;
        if (r1.changed(r15) == false) goto L57;
        int r126 = 16384;
    L58:
        r4 = r4 | r126;
        goto L60
    L57:
        r126 = 8192;
        goto L58
    L44:
        if (r1.changed(r14) == false) goto L46;
        r12 = 2048;
        goto L47
    L48:
        r14 = r35;
        goto L49
    L30:
        if ((r41 & 384) != 0) goto L40;
        if (r34 != null) goto L33;
        int r127 = -1;
    L35:
        if (r1.changed(r127) == false) goto L37;
        int r128 = 256;
    L38:
        r4 = r4 | r128;
        goto L40
    L37:
        r128 = 128;
        goto L38
    L33:
        r127 = r34.ordinal();
        goto L35
    L17:
        if ((r41 & 48) != 0) goto L26;
        if (r33 != null) goto L20;
        int r129 = -1;
    L22:
        if (r1.changed(r129) == false) goto L24;
        int r130 = 32;
    L25:
        r4 = r4 | r130;
        goto L26
    L24:
        r130 = 16;
        goto L25
    L20:
        r129 = r33.ordinal();
        goto L22
    L6:
        if ((r41 & 6) != 0) goto L12;
        r3 = r32;
        if (r1.changed(r3) == false) goto L10;
        int r64 = 4;
    L11:
        r4 = r64 | r41;
        goto L13
    L10:
        r64 = 2;
        goto L11
    L12:
        r3 = r32;
        r4 = r41;
        goto L13
    }
}
