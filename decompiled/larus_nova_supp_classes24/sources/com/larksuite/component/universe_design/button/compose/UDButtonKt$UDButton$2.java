package com.larksuite.component.universe_design.button.compose;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteractionKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.core.content.ContextCompat;
import com.larksuite.component.universe_design.compose.foundation.i0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final class UDButtonKt$UDButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ a $cornerRadii;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function3<Color, Composer, Integer, Unit> $icon;
    final /* synthetic */ UDButtonIconPlacement $iconPlacement;
    final /* synthetic */ boolean $loading;
    final /* synthetic */ UDButtonLoadingPlacement $loadingPlacement;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ String $onClickLabel;
    final /* synthetic */ UDButtonShape $shape;
    final /* synthetic */ UDButtonSize $size;
    final /* synthetic */ String $text;
    final /* synthetic */ TextStyle $textStyle;
    final /* synthetic */ UDButtonType $type;

    public UDButtonKt$UDButton$2(String r3, Function0<Unit> r4, Modifier r5, UDButtonType r6, UDButtonSize r7, UDButtonShape r8, boolean r9, boolean r10, UDButtonLoadingPlacement r11, UDButtonIconPlacement r12, Function3<? super Color, ? super Composer, ? super Integer, Unit> r13, a r14, String r15, TextStyle r16, int r17, int r19, int r110) {
        this.$text = r3;
        this.$onClick = r4;
        this.$modifier = r5;
        this.$type = r6;
        this.$size = r7;
        this.$shape = r8;
        this.$enabled = r9;
        this.$loading = r10;
        this.$loadingPlacement = r11;
        this.$iconPlacement = r12;
        this.$icon = r13;
        this.$onClickLabel = r15;
        this.$textStyle = r16;
        this.$$changed = r17;
        this.$$changed1 = r19;
        this.$$default = r110;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r54, int r55) {
        String r13 = this.$text;
        Function0<Unit> r14 = this.$onClick;
        Modifier r1 = this.$modifier;
        UDButtonType r2 = this.$type;
        UDButtonSize r3 = this.$size;
        UDButtonShape r4 = this.$shape;
        boolean r5 = this.$enabled;
        boolean r6 = this.$loading;
        UDButtonLoadingPlacement r7 = this.$loadingPlacement;
        UDButtonIconPlacement r8 = this.$iconPlacement;
        Function3<Color, Composer, Integer, Unit> r9 = this.$icon;
        String r10 = this.$onClickLabel;
        TextStyle r11 = this.$textStyle;
        int r12 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1);
        int r15 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed1);
        int r16 = this.$$default;
        float r17 = UDButtonKt.a;
        Intrinsics.checkNotNullParameter(r13, "text");
        Intrinsics.checkNotNullParameter(r14, "onClick");
        Composer r19 = r54.startRestartGroup(-1349233066);
        if ((r16 & 1) == 0) goto L6;
        int r110 = r12 | 6;
    L14:
        if ((r16 & 2) == 0) goto L17;
        r110 = r110 | 48;
    L23:
        int r0 = r110;
        int r111 = r16 & 4;
        int r23 = 256;
        if (r111 == 0) goto L26;
        r0 = r0 | 384;
        String r25 = r13;
    L33:
        int r112 = r16 & 8;
        int r26 = 2048;
        if (r112 == 0) goto L37;
        r0 = r0 | 3072;
    L46:
        int r20 = r16 & 16;
        if (r20 == 0) goto L49;
        r0 = r0 | 24576;
        UDButtonType r30 = r2;
    L59:
        int r21 = r16 & 32;
        if (r21 == 0) goto L63;
        r0 = r0 | 196608;
    L72:
        r3 = r3;
    L73:
        int r22 = r16 & 64;
        int r31 = 1572864;
        if (r22 == 0) goto L77;
    L75:
        r0 = r0 | r31;
    L82:
        int r24 = r16 & 128;
        int r33 = 12582912;
        if (r24 == 0) goto L86;
    L84:
        r0 = r0 | r33;
    L91:
        int r27 = r16 & 256;
        if (r27 == 0) goto L95;
        r0 = r0 | 100663296;
    L104:
        r6 = r6;
    L105:
        int r29 = r16 & 512;
        if (r29 == 0) goto L109;
        r0 = r0 | 805306368;
    L118:
        r7 = r7;
    L119:
        int r32 = r16 & 1024;
        if (r32 == 0) goto L123;
        int r34 = r15 | 6;
    L130:
        UDButtonIconPlacement r37 = r8;
        Function3<Color, Composer, Integer, Unit> r38 = r9;
        if ((r16 & 2048) == 0) goto L134;
        r34 = r34 | 48;
    L140:
        int r35 = r34;
        int r36 = r16 & 4096;
        if (r36 == 0) goto L143;
        r35 = r35 | 384;
        int r39 = r12;
    L150:
        String r113 = r10;
    L151:
        String r114 = r113;
        int r115 = r16 & 8192;
        if (r115 == 0) goto L154;
        r35 = r35 | 3072;
        int r210 = r16;
    L161:
        TextStyle r116 = r11;
    L162:
        TextStyle r211 = r116;
        if ((r0 & 306783379) == 306783378) goto L165;
    L170:
        if (r111 == 0) goto L172;
        Modifier r117 = Modifier.Companion;
    L173:
        if (r112 == 0) goto L175;
        r30 = UDButtonType.Primary;
    L175:
        if (r20 == 0) goto L177;
        r3 = UDButtonSize.Middle;
    L177:
        if (r21 == 0) goto L179;
        UDButtonShape r118 = UDButtonShape.Rounded;
    L180:
        if (r22 == 0) goto L182;
        boolean r119 = true;
    L184:
        if (r24 == 0) goto L186;
        r6 = false;
    L186:
        if (r27 == 0) goto L188;
        r7 = UDButtonLoadingPlacement.TextStart;
    L188:
        if (r29 == 0) goto L190;
        r37 = UDButtonIconPlacement.Start;
    L190:
        if (r32 == 0) goto L192;
        r38 = null;
    L192:
        if (r36 == 0) goto L194;
        r114 = null;
    L194:
        if (r115 == 0) goto L197;
        r211 = null;
    L197:
        if (ComposerKt.isTraceInProgress() == false) goto L199;
        ComposerKt.traceEventStart(-1349233066, r0, r35, "com.larksuite.component.universe_design.button.compose.UDButton (UDButton.kt:170)");
    L199:
        r19.startReplaceGroup(1849434622);
        Object r40 = r19.rememberedValue();
        if (r40 != Composer.Companion.getEmpty()) goto L202;
        r40 = InteractionSourceKt.MutableInteractionSource();
        r19.updateRememberedValue(r40);
    L202:
        MutableInteractionSource r41 = (MutableInteractionSource) r40;
        r19.endReplaceGroup();
        State r42 = PressInteractionKt.collectIsPressedAsState(r41, r19, 6);
        Context r43 = (Context) r19.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        int r44 = r0 >> 12;
        int r45 = (r44 & 14) | (r44 & 112);
        r19.startReplaceGroup(-2075725616);
        if (ComposerKt.isTraceInProgress() == false) goto L205;
        ComposerKt.traceEventStart(-2075725616, r45, -1, "com.larksuite.component.universe_design.button.compose.toSpec (UDButton.kt:379)");
    L205:
        int r46 = UDButtonKt.a.a[r3.ordinal()];
        if (r46 != 1) goto L208;
        r19.startReplaceGroup(-1907486882);
        b r47 = new b(Dp.constructor-impl(48), Dp.constructor-impl(0), Dp.constructor-impl(28), true, i0.b(r19).a);
        r19.endReplaceGroup();
    L234:
        b r120 = r47;
        if (ComposerKt.isTraceInProgress() == false) goto L237;
        ComposerKt.traceEventEnd();
    L237:
        r19.endReplaceGroup();
        boolean r48 = ((Boolean) r42.getValue()).booleanValue();
        if (r119 == false) goto L240;
    L242:
        if (r6 == true) goto L244;
    L246:
        long r49 = UDButtonKt.d(r43, r30.getTextColorRes$universe_ui_button_release(), r119, r48);
    L247:
        long r121 = r49;
        if (r30.getLoadingBackgroundColorRes$universe_ui_button_release() == null) goto L251;
        if (r6 == false) goto L251;
        long r50 = ColorKt.Color(ContextCompat.getColor(r43, r30.getLoadingBackgroundColorRes$universe_ui_button_release().intValue()));
    L252:
        long r410 = r50;
        if (r30.getLoadingStrokeColorRes$universe_ui_button_release() == null) goto L257;
        if (r6 == false) goto L257;
        long r51 = ColorKt.Color(ContextCompat.getColor(r43, r30.getLoadingStrokeColorRes$universe_ui_button_release().intValue()));
    L260:
        Integer r52 = r30.getLoadingIndicatorColorRes$universe_ui_button_release();
        if (r52 == null) goto L263;
        long r212 = ColorKt.Color(ContextCompat.getColor(r43, r52.intValue()));
    L265:
        if (r30.getStrokeColorRes$universe_ui_button_release() == null) goto L267;
    L269:
        int r53 = 1;
    L270:
        float r56 = Dp.constructor-impl(r53);
        if (r118 != UDButtonShape.Circle) goto L273;
        RoundedCornerShape r57 = RoundedCornerShapeKt.RoundedCornerShape(50);
    L274:
        RoundedCornerShape r59 = r57;
        PaddingValues r60 = PaddingKt.PaddingValues-YgX7TsA$default(r120.c, 0.0f, 2, null);
        if (r120.d == false) goto L277;
        Modifier r61 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null);
    L278:
        Modifier r62 = r117.then(r61);
        float r63 = UDButtonKt.d;
        Modifier r64 = SizeKt.defaultMinSize-VpY3zN4(r62, r63, r63);
        if (r119 == false) goto L282;
        if (r6 == true) goto L282;
        boolean r65 = true;
    L283:
        boolean r213 = r119;
        long r510 = r51;
        Modifier r66 = ClickableKt.clickable-O2vRcR0(r64, r41, null, r65, r114, Role.box-impl(Role.Companion.getButton-o7Vup1c()), r14);
        Alignment.Companion r67 = Alignment.Companion;
        MeasurePolicy r68 = BoxKt.maybeCachedBoxMeasurePolicy(r67.getCenter(), false);
        long r69 = ComposablesKt.getCurrentCompositeKeyHashCode(r19, 0);
        int r70 = (int) (r69 ^ (r69 >>> 32));
        CompositionLocalMap r71 = r19.getCurrentCompositionLocalMap();
        Modifier r72 = ComposedModifierKt.materializeModifier(r19, r66);
        ComposeUiNode.Companion r73 = ComposeUiNode.Companion;
        Function0 r74 = r73.getConstructor();
        if ((r19.getApplier() instanceof Applier) == true) goto L286;
        ComposablesKt.invalidApplier();
    L286:
        r19.startReusableNode();
        if (r19.getInserting() == false) goto L289;
        r19.createNode(r74);
    L290:
        Composer r75 = Updater.constructor-impl(r19);
        Updater.set-impl(r75, r68, r73.getSetMeasurePolicy());
        Updater.set-impl(r75, r71, r73.getSetResolvedCompositionLocals());
        Function2 r76 = r73.getSetCompositeKeyHash();
        if (r75.getInserting() == false) goto L293;
    L294:
        r75.updateRememberedValue(Integer.valueOf(r70));
        r75.apply(Integer.valueOf(r70), r76);
    L295:
        Updater.set-impl(r75, r72, r73.getSetModifier());
        BoxScopeInstance r77 = BoxScopeInstance.INSTANCE;
        if (r120.f == false) goto L299;
        Modifier r79 = r77.matchParentSize(Modifier.Companion);
    L304:
        UDButtonShape r214 = r118;
        Modifier r80 = PaddingKt.padding(BorderKt.border-xT4_qwU(BackgroundKt.background-bw27NRU$default(ClipKt.clip(r79, r59), r410, null, 2, null), r56, r510, r59), r60);
        MeasurePolicy r81 = BoxKt.maybeCachedBoxMeasurePolicy(r67.getCenter(), false);
        long r82 = ComposablesKt.getCurrentCompositeKeyHashCode(r19, 0);
        int r83 = (int) (r82 ^ (r82 >>> 32));
        CompositionLocalMap r84 = r19.getCurrentCompositionLocalMap();
        Modifier r85 = ComposedModifierKt.materializeModifier(r19, r80);
        Function0 r86 = r73.getConstructor();
        if ((r19.getApplier() instanceof Applier) == true) goto L307;
        ComposablesKt.invalidApplier();
    L307:
        r19.startReusableNode();
        if (r19.getInserting() == false) goto L310;
        r19.createNode(r86);
    L311:
        Composer r87 = Updater.constructor-impl(r19);
        Updater.set-impl(r87, r81, r73.getSetMeasurePolicy());
        Updater.set-impl(r87, r84, r73.getSetResolvedCompositionLocals());
        Function2 r88 = r73.getSetCompositeKeyHash();
        if (r87.getInserting() == false) goto L314;
    L315:
        r87.updateRememberedValue(Integer.valueOf(r83));
        r87.apply(Integer.valueOf(r83), r88);
    L316:
        Updater.set-impl(r87, r85, r73.getSetModifier());
        if (r211 != null) goto L319;
        TextStyle r89 = r120.e;
    L320:
        int r122 = (((r0 >> 9) & 3670016) | (((r0 & 14) | (r44 & 7168)) | (57344 & r44))) | ((r35 << 21) & 29360128);
        Composer r90 = r19;
        UDButtonKt.a(r25, r89, r121, r6, r7, r212, r37, r38, r90, r122);
        r90.endNode();
        r90.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L323;
        ComposerKt.traceEventEnd();
    L323:
        Modifier r91 = r117;
        String r123 = r114;
        UDButtonShape r92 = r214;
        TextStyle r124 = r211;
        UDButtonType r93 = r30;
        UDButtonSize r94 = r3;
        boolean r95 = r213;
        boolean r96 = r6;
        UDButtonLoadingPlacement r125 = r7;
        UDButtonIconPlacement r126 = r37;
        Function3<Color, Composer, Integer, Unit> r127 = r38;
    L324:
        ScopeUpdateScope r97 = r90.endRestartGroup();
        if (r97 == null) goto L328;
        r97.updateScope(new UDButtonKt$UDButton$2(r25, r14, r91, r93, r94, r92, r95, r96, r125, r126, r127, null, r123, r124, r39, r15, r210));
        return;
    L328:
        return;
    L319:
        r89 = r211;
        goto L320
    L314:
        if (Intrinsics.areEqual(r87.rememberedValue(), Integer.valueOf(r83)) == true) goto L316;
    L310:
        r19.useNode();
        goto L311
    L299:
        Modifier.Companion r98 = Modifier.Companion;
        if (r120.d == false) goto L302;
        Modifier r99 = SizeKt.fillMaxWidth$default(r98, 0.0f, 1, null);
    L303:
        r79 = SizeKt.height-3ABfNKs(r98.then(r99), r120.a);
        goto L304
    L302:
        r99 = SizeKt.defaultMinSize-VpY3zN4$default(r98, r120.b, 0.0f, 2, null);
        goto L303
    L293:
        if (Intrinsics.areEqual(r75.rememberedValue(), Integer.valueOf(r70)) == true) goto L295;
    L289:
        r19.useNode();
    L282:
        r65 = false;
        goto L283
    L277:
        r61 = Modifier.Companion;
        goto L278
    L273:
        r57 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(6));
        goto L274
    L267:
        if (r30.getLoadingStrokeColorRes$universe_ui_button_release() != null) goto L269;
        r53 = 0;
        goto L270
    L263:
        r212 = r121;
    L257:
        if (r30.getStrokeColorRes$universe_ui_button_release() == null) goto L259;
        r51 = UDButtonKt.d(r43, r30.getStrokeColorRes$universe_ui_button_release().intValue(), r119, r48);
        goto L260
    L259:
        r51 = Color.Companion.getTransparent-0d7_KjU();
    L251:
        r50 = UDButtonKt.d(r43, r30.getBackgroundColorRes$universe_ui_button_release(), r119, r48);
        goto L252
    L244:
        if (r30.getLoadingTextColorRes$universe_ui_button_release() == null) goto L246;
        r49 = ColorKt.Color(ContextCompat.getColor(r43, r30.getLoadingTextColorRes$universe_ui_button_release().intValue()));
        goto L247
    L240:
        if (r30.getDisabledTextColorRes$universe_ui_button_release() == null) goto L242;
        r49 = ColorKt.Color(ContextCompat.getColor(r43, r30.getDisabledTextColorRes$universe_ui_button_release().intValue()));
        goto L247
    L208:
        if (r46 != 2) goto L210;
        r19.startReplaceGroup(-1907479335);
        if (r118 != UDButtonShape.Circle) goto L231;
        r19.startReplaceGroup(997713234);
        r47 = new b(Dp.constructor-impl(40), Dp.constructor-impl(166), Dp.constructor-impl(56), false, i0.b(r19).a);
        r19.endReplaceGroup();
    L232:
        r19.endReplaceGroup();
        goto L234
    L231:
        r19.startReplaceGroup(997814418);
        r47 = new b(Dp.constructor-impl(48), Dp.constructor-impl(104), Dp.constructor-impl(28), false, i0.b(r19).a);
        r19.endReplaceGroup();
        goto L232
    L210:
        if (r46 != 3) goto L212;
        r19.startReplaceGroup(-1907470859);
        if (r118 != UDButtonShape.Circle) goto L226;
        r19.startReplaceGroup(997976052);
        r47 = new b(Dp.constructor-impl(36), Dp.constructor-impl(92), Dp.constructor-impl(24), false, i0.b(r19).c);
        r19.endReplaceGroup();
    L227:
        r19.endReplaceGroup();
        goto L234
    L226:
        r19.startReplaceGroup(998075252);
        r47 = new b(Dp.constructor-impl(36), Dp.constructor-impl(76), Dp.constructor-impl(16), false, i0.b(r19).c);
        r19.endReplaceGroup();
        goto L227
    L212:
        if (r46 != 4) goto L214;
        r19.startReplaceGroup(-1907462540);
        if (r118 != UDButtonShape.Circle) goto L221;
        r19.startReplaceGroup(998233972);
        r47 = new b(Dp.constructor-impl(28), Dp.constructor-impl(68), Dp.constructor-impl(12), false, i0.b(r19).c);
        r19.endReplaceGroup();
    L222:
        r19.endReplaceGroup();
        goto L234
    L221:
        r19.startReplaceGroup(998333141);
        r47 = new b(Dp.constructor-impl(28), Dp.constructor-impl(60), Dp.constructor-impl(8), false, i0.b(r19).d);
        r19.endReplaceGroup();
        goto L222
    L214:
        if (r46 != 5) goto L216;
        r19.startReplaceGroup(-1907454217);
        float r100 = 0;
        r47 = new b(Dp.constructor-impl(r100), Dp.constructor-impl(r100), Dp.constructor-impl(r100), false, i0.b(r19).d, true);
        r19.endReplaceGroup();
        goto L234
    L216:
        r19.startReplaceGroup(-1907487226);
        r19.endReplaceGroup();
        throw new NoWhenBranchMatchedException();
    L182:
        r119 = r5;
        goto L184
    L179:
        r118 = r4;
        goto L180
    L172:
        r117 = r1;
        goto L173
    L165:
        if ((r35 & 1171) != 1170) goto L170;
        if (r19.getSkipping() == false) goto L170;
        r19.skipToGroupEnd();
        r90 = r19;
        r123 = r114;
        r124 = r211;
        r91 = r1;
        r93 = r30;
        r92 = r4;
        r94 = r3;
        r95 = r5;
        r96 = r6;
        r125 = r7;
        r126 = r37;
        r127 = r38;
        goto L324
    L154:
        r210 = r16;
        if ((r15 & 3072) != 0) goto L161;
        r116 = r11;
        if (r19.changed(r116) == true) goto L160;
        r26 = 1024;
    L160:
        r35 = r35 | r26;
        goto L162
    L143:
        r39 = r12;
        if ((r15 & 384) != 0) goto L150;
        r113 = r10;
        if (r19.changed(r113) == true) goto L149;
        r23 = 128;
    L149:
        r35 = r35 | r23;
        goto L151
    L134:
        if ((r15 & 48) != 0) goto L140;
        if (r19.changed(null) == false) goto L138;
        int r101 = 32;
    L139:
        r34 = r34 | r101;
        goto L140
    L138:
        r101 = 16;
        goto L139
    L123:
        if ((r15 & 6) == 0) goto L125;
        r34 = r15;
        goto L130
    L125:
        if (r19.changedInstance(r9) == false) goto L127;
        int r310 = 4;
    L128:
        r34 = r15 | r310;
        goto L130
    L127:
        r310 = 2;
        goto L128
    L109:
        if ((r12 & 805306368) != 0) goto L118;
        if (r8 != null) goto L112;
        int r102 = -1;
    L114:
        if (r19.changed(r102) == false) goto L116;
        int r103 = 536870912;
    L117:
        r0 = r0 | r103;
        goto L119
    L116:
        r103 = 268435456;
        goto L117
    L112:
        r102 = r8.ordinal();
        goto L114
    L95:
        if ((r12 & 100663296) != 0) goto L104;
        if (r7 != null) goto L98;
        int r104 = -1;
    L100:
        if (r19.changed(r104) == false) goto L102;
        int r105 = 67108864;
    L103:
        r0 = r0 | r105;
        goto L105
    L102:
        r105 = 33554432;
        goto L103
    L98:
        r104 = r7.ordinal();
        goto L100
    L86:
        if ((r12 & 12582912) != 0) goto L91;
        if (r19.changed(r6) == false) goto L90;
        r33 = 8388608;
        goto L84
    L90:
        r33 = 4194304;
        goto L84
    L77:
        if ((r12 & 1572864) != 0) goto L82;
        if (r19.changed(r5) == false) goto L81;
        r31 = 1048576;
        goto L75
    L81:
        r31 = 524288;
        goto L75
    L63:
        if ((r12 & 196608) != 0) goto L72;
        if (r4 != null) goto L66;
        int r106 = -1;
    L68:
        if (r19.changed(r106) == false) goto L70;
        int r107 = 131072;
    L71:
        r0 = r0 | r107;
        goto L73
    L70:
        r107 = 65536;
        goto L71
    L66:
        r106 = r4.ordinal();
        goto L68
    L49:
        r30 = r2;
        if ((r12 & 24576) != 0) goto L59;
        if (r3 != null) goto L53;
        int r108 = -1;
    L55:
        if (r19.changed(r108) == false) goto L57;
        int r109 = 16384;
    L58:
        r0 = r0 | r109;
        goto L59
    L57:
        r109 = 8192;
        goto L58
    L53:
        r108 = r3.ordinal();
        goto L55
    L37:
        if ((r12 & 3072) != 0) goto L46;
        if (r2 != null) goto L40;
        int r128 = -1;
    L42:
        if (r19.changed(r128) == false) goto L44;
        int r129 = 2048;
    L45:
        r0 = r0 | r129;
        goto L46
    L44:
        r129 = 1024;
        goto L45
    L40:
        r128 = r2.ordinal();
        goto L42
    L26:
        r25 = r13;
        if ((r12 & 384) != 0) goto L33;
        if (r19.changed(r1) == false) goto L31;
        int r130 = 256;
    L32:
        r0 = r0 | r130;
        goto L33
    L31:
        r130 = 128;
        goto L32
    L17:
        if ((r12 & 48) != 0) goto L23;
        if (r19.changedInstance(r14) == false) goto L21;
        int r215 = 32;
    L22:
        r110 = r110 | r215;
        goto L23
    L21:
        r215 = 16;
        goto L22
    L6:
        if ((r12 & 6) == 0) goto L8;
        r110 = r12;
        goto L14
    L8:
        if (r19.changed(r13) == false) goto L10;
        int r131 = 4;
    L11:
        r110 = r131 | r12;
        goto L14
    L10:
        r131 = 2;
        goto L11
    }
}
