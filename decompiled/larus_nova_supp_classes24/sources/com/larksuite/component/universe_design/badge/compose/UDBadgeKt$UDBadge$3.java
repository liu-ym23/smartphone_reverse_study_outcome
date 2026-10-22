package com.larksuite.component.universe_design.badge.compose;

import android.content.Context;
import android.graphics.Paint;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import com.larksuite.component.universe_design.icon.compose.d;
import com.larksuite.component.universe_design.icon.compose.g;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final class UDBadgeKt$UDBadge$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ String $contentDescription;
    final /* synthetic */ ImageVector $icon;
    final /* synthetic */ Painter $iconPainter;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ c $style;
    final /* synthetic */ String $text;

    public UDBadgeKt$UDBadge$3(c r1, Modifier r2, String r3, ImageVector r4, String r5, Painter r6, int r7, int r8) {
        this.$style = r1;
        this.$modifier = r2;
        this.$text = r3;
        this.$icon = r4;
        this.$contentDescription = r5;
        this.$iconPainter = r6;
        this.$$changed = r7;
        this.$$default = r8;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r39, int r40) {
        final c r24 = this.$style;
        Modifier r1 = this.$modifier;
        String r2 = this.$text;
        ImageVector r3 = this.$icon;
        String r4 = this.$contentDescription;
        Painter r5 = this.$iconPainter;
        int r9 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1);
        int r10 = this.$$default;
        Intrinsics.checkNotNullParameter(r24, "style");
        Composer r14 = r39.startRestartGroup(-509755328);
        if ((r10 & 1) == 0) goto L6;
        int r11 = r9 | 6;
    L13:
        int r15 = r10 & 2;
        if (r15 == 0) goto L17;
        r11 = r11 | 48;
    L23:
        int r17 = r10 & 4;
        if (r17 == 0) goto L27;
        r11 = r11 | 384;
    L33:
        int r12 = r10 & 8;
        if (r12 == 0) goto L37;
        r11 = r11 | 3072;
    L43:
        int r8 = r11;
    L44:
        int r13 = r10 & 16;
        if (r13 == 0) goto L48;
        r8 = r8 | 24576;
    L54:
        int r16 = r10 & 32;
        int r20 = 196608;
        if (r16 == 0) goto L58;
    L63:
        r8 = r8 | r20;
    L65:
        if ((r8 & 74899) == 74898) goto L67;
    L70:
        if (r15 == 0) goto L72;
        r1 = Modifier.Companion;
    L72:
        Modifier r0 = r1;
        if (r17 == 0) goto L75;
        String r19 = null;
    L76:
        if (r12 == 0) goto L78;
        ImageVector r21 = null;
    L79:
        if (r13 == 0) goto L81;
        String r110 = null;
    L82:
        if (r16 == 0) goto L84;
        Painter r22 = null;
    L86:
        if (ComposerKt.isTraceInProgress() == false) goto L88;
        ComposerKt.traceEventStart(-509755328, r8, -1, "com.larksuite.component.universe_design.badge.compose.UDBadge (UDBadge.kt:132)");
    L88:
        Context r6 = (Context) r14.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Density r7 = (Density) r14.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection r23 = (LayoutDirection) r14.consume(CompositionLocalsKt.getLocalLayoutDirection());
        UDBadgeType r25 = r24.getType();
        UDBadgeType r111 = UDBadgeType.Text;
        if (r25 != r111) goto L100;
        if (r19 != null) goto L92;
    L95:
        boolean r26 = true;
    L96:
        if (r26 == true) goto L100;
        if (r19.length() <= 0) goto L100;
        boolean r27 = true;
    L101:
        if (r27 == false) goto L103;
        UDBadgeType r29 = UDBadgeType.Icon;
    L104:
        r14.startReplaceGroup(-248579950);
        if (r27 == false) goto L107;
        d r30 = d.a;
        Painter r31 = g.c(r14, 0);
    L108:
        r14.endReplaceGroup();
        if (r27 == true) goto L113;
        if (r31 != null) goto L113;
        ImageVector r112 = r21;
    L115:
        if (r27 == false) goto L117;
        PaddingValues r32 = PaddingKt.PaddingValues-YgX7TsA$default(b.a, 0.0f, 2, null);
    L118:
        r14.startReplaceGroup(5004770);
        boolean r33 = r14.changed(r6);
        Object r34 = r14.rememberedValue();
        if (r33 == true) goto L122;
        Object r35 = r34;
        if (r34 == Composer.Companion.getEmpty()) goto L122;
    L123:
        Paint r36 = (Paint) r35;
        r14.endReplaceGroup();
        r14.startReplaceGroup(-1224400529);
        int r37 = r8 & 14;
        if (r37 != 4) goto L126;
        boolean r38 = true;
    L127:
        int r113 = r8 & 896;
        if (r113 != 256) goto L130;
        boolean r41 = true;
    L131:
        boolean r42 = ((((((r38 | r41) | r14.changed(r29.ordinal())) | r14.changed(r31)) | r14.changed(r112)) | r14.changed(r32)) | r14.changed(r7)) | r14.changed(r23.ordinal());
        Object r43 = r14.rememberedValue();
        if (r42 == false) goto L134;
    L137:
        r36.setColor(ColorKt.toArgb-8_81llA(0));
        r36.setTextSize(r7.toPx--R2X_6o(TextUnitKt.getSp(0.0f)));
        r36.setLetterSpacing(0.02f);
        float r44 = r7.toPx-0680j_4(0.0f);
        float r114 = r7.toPx-0680j_4(0.0f);
        float r45 = 2;
        float r210 = r7.toPx-0680j_4(0.0f) * r45;
        float r46 = r44 - r210;
        float r115 = (r114 * r45) + r210;
        if (r29 != r111) goto L148;
        if (r19 != null) goto L141;
    L144:
        boolean r116 = true;
    L145:
        if (r116 == true) goto L148;
        float r47 = r36.measureText(r19);
        float r48 = Math.max(r46, r47 + (r7.toPx-0680j_4(0.0f) * r45));
        float r310 = r47;
        UDBadgeType r49 = r29;
        UDBadgeType r117 = r111;
        String r311 = r110;
        String r211 = r19;
        float r50 = 0.0f;
        float r51 = 0.0f;
        Paint r118 = r36;
    L194:
        a r52 = new a(r7.toDp-u2uoSUM(r48 + r115), r7.toDp-u2uoSUM(r46 + r115), r310, r7.toDp-u2uoSUM(r51), r7.toDp-u2uoSUM(r50));
        r14.updateRememberedValue(r52);
        r43 = r52;
    L195:
        final a r53 = (a) r43;
        r14.endReplaceGroup();
        r14.startReplaceGroup(-248464879);
        if (r311 == null) goto L209;
        Modifier.Companion r54 = Modifier.Companion;
        r14.startReplaceGroup(5004770);
        if ((57344 & r8) != 16384) goto L200;
        boolean r55 = true;
    L201:
        Object r56 = r14.rememberedValue();
        if (r55 == false) goto L204;
    L207:
        final String r57 = r311;
        r56 = new UDBadgeKt$UDBadge$semanticsModifier$1$1(r57);
        r14.updateRememberedValue(r56);
    L208:
        r14.endReplaceGroup();
        boolean r59 = true;
        Modifier r60 = SemanticsModifierKt.semantics$default(r54, false, (Function1) r56, 1, null);
    L210:
        r14.endReplaceGroup();
        Modifier r119 = SizeKt.size-VpY3zN4(r0.then(r60), r53.a, r53.b);
        r14.startReplaceGroup(-1224400529);
        if (r37 != 4) goto L213;
        boolean r61 = true;
    L214:
        boolean r62 = r61 | r14.changed(r49.ordinal());
        if (r113 == 256) goto L218;
        r59 = false;
    L218:
        boolean r63 = ((r62 | r59) | r14.changedInstance(r118)) | r14.changed(r53);
        Object r64 = r14.rememberedValue();
        if (r63 == false) goto L221;
    L224:
        final UDBadgeType r65 = r49;
        final String r66 = r211;
        final Paint r67 = r118;
        Function1<ContentDrawScope, Unit> r120 = new UDBadgeKt$UDBadge$1$1(r24, r65, r66, r67, r53);
        r14.updateRememberedValue(r120);
        r64 = r120;
    L225:
        r14.endReplaceGroup();
        Modifier r68 = DrawModifierKt.drawWithContent(r119, (Function1) r64);
        MeasurePolicy r69 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), false);
        long r70 = ComposablesKt.getCurrentCompositeKeyHashCode(r14, 0);
        int r71 = (int) (r70 ^ (r70 >>> 32));
        CompositionLocalMap r72 = r14.getCurrentCompositionLocalMap();
        Modifier r73 = ComposedModifierKt.materializeModifier(r14, r68);
        ComposeUiNode.Companion r74 = ComposeUiNode.Companion;
        Function0 r75 = r74.getConstructor();
        if ((r14.getApplier() instanceof Applier) == true) goto L228;
        ComposablesKt.invalidApplier();
    L228:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L231;
        r14.createNode(r75);
    L232:
        Composer r76 = Updater.constructor-impl(r14);
        Updater.set-impl(r76, r69, r74.getSetMeasurePolicy());
        Updater.set-impl(r76, r72, r74.getSetResolvedCompositionLocals());
        Function2 r77 = r74.getSetCompositeKeyHash();
        if (r76.getInserting() == false) goto L235;
    L236:
        r76.updateRememberedValue(Integer.valueOf(r71));
        r76.apply(Integer.valueOf(r71), r77);
    L237:
        Updater.set-impl(r76, r73, r74.getSetModifier());
        BoxScopeInstance r79 = BoxScopeInstance.INSTANCE;
        r14.startReplaceGroup(-1972052919);
        if (r49 != UDBadgeType.Dot) goto L240;
    L251:
        String r80 = r57;
        Composer r81 = r14;
        String r82 = r211;
    L252:
        r81.endReplaceGroup();
        r81.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L255;
        ComposerKt.traceEventEnd();
    L255:
        String r83 = r80;
        String r84 = r82;
        ImageVector r85 = r21;
        Painter r86 = r22;
    L256:
        ScopeUpdateScope r121 = r81.endRestartGroup();
        if (r121 == null) goto L260;
        r121.updateScope(new UDBadgeKt$UDBadge$3(r24, r0, r84, r85, r83, r86, r9, r10));
        return;
    L260:
        return;
    L240:
        if (r49 == r117) goto L251;
        if (r49 != UDBadgeType.Icon) goto L250;
        if (r31 == 0) goto L245;
        r14.startReplaceGroup(-1003943653);
        r80 = r57;
        r81 = r14;
        r82 = r211;
        IconKt.Icon-ww6aTOc(r31, null, SizeKt.size-VpY3zN4(Modifier.Companion, r53.d, r53.e), 0, r81, 48, 0);
        r81.endReplaceGroup();
        goto L252
    L245:
        r80 = r57;
        r81 = r14;
        r82 = r211;
        if (r112 == null) goto L248;
        r81.startReplaceGroup(-1003574381);
        IconKt.Icon-ww6aTOc(r112, null, SizeKt.size-VpY3zN4(Modifier.Companion, r53.d, r53.e), 0, r81, 48, 0);
        r81.endReplaceGroup();
        goto L252
    L248:
        r81.startReplaceGroup(-1003246680);
        r81.endReplaceGroup();
        goto L252
    L250:
        throw new NoWhenBranchMatchedException();
    L235:
        if (Intrinsics.areEqual(r76.rememberedValue(), Integer.valueOf(r71)) == true) goto L237;
    L231:
        r14.useNode();
        goto L232
    L221:
        if (r64 != Composer.Companion.getEmpty()) goto L225;
    L213:
        r61 = false;
        goto L214
    L204:
        if (r56 == Composer.Companion.getEmpty()) goto L207;
        r57 = r311;
        goto L208
    L200:
        r55 = false;
        goto L201
    L209:
        r57 = r311;
        r59 = true;
        r60 = Modifier.Companion;
        goto L210
    L141:
        if (r19.length() == 0) goto L144;
        r116 = false;
    L148:
        if (r29 != UDBadgeType.Icon) goto L191;
        if (r31 != null) goto L151;
        if (r112 == null) goto L191;
    L151:
        float r87 = r7.toPx-0680j_4(r32.calculateTopPadding-D9Ej5fM());
        r117 = r111;
        float r122 = r7.toPx-0680j_4(r32.calculateBottomPadding-D9Ej5fM());
        r211 = r19;
        float r123 = r7.toPx-0680j_4(r32.calculateLeftPadding-u2uoSUM(r23));
        float r88 = r7.toPx-0680j_4(r32.calculateRightPadding-u2uoSUM(r23));
        float r89 = (r46 - r87) - r122;
        if (r31 == null) goto L154;
        Size r90 = Size.box-impl(r31.getIntrinsicSize-NH-jbRc());
    L155:
        if (r90 == null) goto L157;
        r311 = r110;
        float r124 = Float.intBitsToFloat((int) (r90.unbox-impl() >> 32));
    L161:
        if (r90 == null) goto L164;
        long r212 = r90.unbox-impl();
        r118 = r36;
        r49 = r29;
        float r91 = Float.intBitsToFloat((int) (r212 & 4294967295L));
    L163:
        float r312 = r91;
        float r92 = 0.0f;
    L169:
        if (r89 > r92) goto L171;
    L192:
        r48 = r46;
        r50 = 0.0f;
        r51 = 0.0f;
    L193:
        r310 = 0.0f;
        goto L194
    L171:
        if (Float.isInfinite(r124) == false) goto L173;
    L175:
        boolean r93 = false;
    L176:
        if (r93 == true) goto L178;
    L189:
        float r125 = 1.0f;
    L190:
        r51 = r125 * r89;
        float r94 = Math.max(r46, (r123 + r51) + r88);
        r50 = r89;
        r48 = r94;
        goto L193
    L178:
        if (r124 <= r92) goto L189;
        if (Float.isInfinite(r312) == false) goto L182;
    L184:
        boolean r95 = false;
    L185:
        if (r95 == false) goto L189;
        if (r312 <= r92) goto L189;
        r125 = r124 / r312;
        goto L190
    L182:
        if (Float.isNaN(r312) == true) goto L184;
        r95 = true;
        goto L185
    L173:
        if (Float.isNaN(r124) == true) goto L175;
        r93 = true;
        goto L176
    L164:
        r118 = r36;
        r49 = r29;
        if (r112 == null) goto L167;
        r91 = r7.toPx-0680j_4(r112.getDefaultHeight-D9Ej5fM());
        goto L163
    L167:
        r92 = 0.0f;
        r312 = Float.NaN;
        goto L169
    L157:
        r311 = r110;
        if (r112 == null) goto L160;
        r124 = r7.toPx-0680j_4(r112.getDefaultWidth-D9Ej5fM());
        goto L161
    L160:
        r124 = Float.NaN;
        goto L161
    L154:
        r90 = null;
    L191:
        r49 = r29;
        r117 = r111;
        r311 = r110;
        r211 = r19;
        r118 = r36;
        goto L192
    L134:
        if (r43 == Composer.Companion.getEmpty()) goto L137;
        r49 = r29;
        r117 = r111;
        r311 = r110;
        r211 = r19;
        r118 = r36;
        goto L195
    L130:
        r41 = false;
        goto L131
    L126:
        r38 = false;
    L122:
        Paint r96 = new Paint();
        r96.setAntiAlias(true);
        w08.a.a(r96, r6, 1);
        r14.updateRememberedValue(r96);
        r35 = r96;
        goto L123
    L117:
        r32 = null;
    L113:
        r112 = null;
        goto L115
    L107:
        r31 = r22;
        goto L108
    L103:
        r29 = r24.getType();
        goto L104
    L92:
        if (r19.length() == 0) goto L95;
        r26 = false;
    L100:
        r27 = false;
        goto L101
    L84:
        r22 = r5;
        goto L86
    L81:
        r110 = r4;
        goto L82
    L78:
        r21 = r3;
        goto L79
    L75:
        r19 = r2;
        goto L76
    L67:
        if (r14.getSkipping() == false) goto L70;
        r14.skipToGroupEnd();
        r0 = r1;
        r83 = r4;
        r24 = r24;
        r9 = r9;
        r10 = r10;
        r84 = r2;
        r86 = r5;
        r85 = r3;
        r81 = r14;
        goto L256
    L58:
        if ((r9 & 196608) != 0) goto L65;
        if (r14.changedInstance(r5) == false) goto L62;
        r20 = 131072;
        goto L63
    L62:
        r20 = 65536;
        goto L63
    L48:
        if ((r9 & 24576) != 0) goto L54;
        if (r14.changed(r4) == false) goto L52;
        int r126 = 16384;
    L53:
        r8 = r8 | r126;
        goto L54
    L52:
        r126 = 8192;
        goto L53
    L37:
        if ((r9 & 3072) != 0) goto L43;
        if (r14.changed(r3) == false) goto L41;
        int r97 = 2048;
    L42:
        r8 = r97 | r11;
        goto L44
    L41:
        r97 = 1024;
        goto L42
    L27:
        if ((r9 & 384) != 0) goto L33;
        if (r14.changed(r2) == false) goto L31;
        int r127 = 256;
    L32:
        r11 = r11 | r127;
        goto L33
    L31:
        r127 = 128;
        goto L32
    L17:
        if ((r9 & 48) != 0) goto L23;
        if (r14.changed(r1) == false) goto L21;
        int r128 = 32;
    L22:
        r11 = r11 | r128;
        goto L23
    L21:
        r128 = 16;
        goto L22
    L6:
        if ((r9 & 6) == 0) goto L8;
        r11 = r9;
        goto L13
    L8:
        if (r14.changed(r24) == false) goto L10;
        int r129 = 4;
    L11:
        r11 = r129 | r9;
        goto L13
    L10:
        r129 = 2;
        goto L11
    }
}
