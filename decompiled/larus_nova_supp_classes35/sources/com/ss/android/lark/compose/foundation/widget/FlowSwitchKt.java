package com.ss.android.lark.compose.foundation.widget;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.compose.foundation.n;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FlowSwitchKt {
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v30, types: [boolean, int] */
    public static final void a(final a r38, final Function1<? super Boolean, Unit> r39, Modifier r40, boolean r41, FlowSwitchStyle r42, Composer r43, final int r44, final int r45) {
        Intrinsics.checkNotNullParameter(r38, "state");
        Composer r14 = r43.startRestartGroup(-371059023);
        if ((r45 & 1) == 0) goto L6;
        int r1 = r44 | 6;
    L14:
        if ((r45 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r3 = r45 & 4;
        if (r3 == 0) goto L27;
        r1 = r1 | 384;
    L33:
        Modifier r4 = r40;
    L34:
        int r5 = r45 & 8;
        if (r5 == 0) goto L38;
        r1 = r1 | 3072;
    L44:
        final boolean r12 = r41;
    L45:
        int r13 = r45 & 16;
        if (r13 == 0) goto L49;
        r1 = r1 | 24576;
    L59:
        if ((r1 & 9363) == 9362) goto L61;
    L64:
        if (r3 == 0) goto L66;
        Modifier r11 = Modifier.Companion;
    L67:
        if (r5 == 0) goto L69;
        r12 = true;
    L69:
        if (r13 == 0) goto L71;
        FlowSwitchStyle r21 = FlowSwitchStyle.NORMAL;
    L73:
        if (ComposerKt.isTraceInProgress() == false) goto L75;
        ComposerKt.traceEventStart(-371059023, r1, -1, "com.ss.android.lark.compose.foundation.widget.FlowSwitch (FlowSwitch.kt:84)");
    L75:
        Density r0 = (Density) r14.consume(CompositionLocalsKt.getLocalDensity());
        Object r6 = r14.rememberedValue();
        Composer.Companion r15 = Composer.Companion;
        if (r6 != r15.getEmpty()) goto L78;
        r6 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r14);
        r14.updateRememberedValue(r6);
    L78:
        final CoroutineScope r7 = (CoroutineScope) r6;
        float r16 = 2;
        final float r8 = r0.toPx-0680j_4(Dp.constructor-impl(Dp.constructor-impl(r21.m917getTrackWidthD9Ej5fM$flow_ud_release() - r21.m914getThumbSizeD9Ej5fM$flow_ud_release()) - Dp.constructor-impl(r21.m913getThumbPaddingD9Ej5fM$flow_ud_release() * r16)));
        r14.startReplaceGroup(1849434622);
        Object r2 = r14.rememberedValue();
        if (r2 == r15.getEmpty()) goto L81;
    L85:
        final Animatable r9 = (Animatable) r2;
        r14.endReplaceGroup();
        Boolean r10 = Boolean.valueOf(r38.a);
        Float r17 = Float.valueOf(r8);
        r14.startReplaceGroup(-1746271574);
        boolean r19 = r14.changedInstance(r9);
        int r18 = r1 & 14;
        if (r18 != 4) goto L88;
        boolean r20 = true;
    L89:
        boolean r22 = (r19 | r20) | r14.changed(r8);
        Object r23 = r14.rememberedValue();
        if (r22 == false) goto L92;
    L93:
        r23 = new FlowSwitchKt$FlowSwitch$1$1(r9, r38, r8, null);
        r14.updateRememberedValue(r23);
    L94:
        r14.endReplaceGroup();
        EffectsKt.LaunchedEffect(r10, r17, (Function2) r23, r14, 0);
        if (r12 == true) goto L101;
        r14.startReplaceGroup(1027411058);
        if (r38.a == false) goto L99;
        r14.startReplaceGroup(1027436230);
        long r24 = n.a(r14, 6).a.c;
        r14.endReplaceGroup();
    L100:
        r14.endReplaceGroup();
    L110:
        long r25 = n.a(r14, 6).b.a;
        Modifier r26 = SizeKt.size-VpY3zN4(r11, r21.m917getTrackWidthD9Ej5fM$flow_ud_release(), r21.m915getTrackHeightD9Ej5fM$flow_ud_release());
        r14.startReplaceGroup(5004770);
        int r27 = r1 & 7168;
        Modifier r28 = r11;
        if (r27 != 2048) goto L113;
        boolean r29 = true;
    L114:
        Object r110 = r14.rememberedValue();
        if (r29 == false) goto L117;
    L118:
        r110 = new FlowSwitchKt$FlowSwitch$2$1(r12);
        r14.updateRememberedValue(r110);
    L119:
        r14.endReplaceGroup();
        Modifier r30 = BackgroundKt.background-bw27NRU(SemanticsModifierKt.semantics$default(r26, false, (Function1) r110, 1, null), r24, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(r21.m916getTrackRadiusD9Ej5fM$flow_ud_release()));
        Object[] r111 = {Boolean.valueOf(r12), Boolean.valueOf(r38.b), Boolean.valueOf(r38.a), r21};
        r14.startReplaceGroup(-1746271574);
        if (r27 != 2048) goto L122;
        boolean r31 = true;
    L124:
        if (r18 != 4) goto L126;
        boolean r112 = true;
    L127:
        boolean r32 = r31 | r112;
        int r33 = r1 & 112;
        if (r33 != 32) goto L130;
        boolean r113 = true;
    L131:
        boolean r34 = r32 | r113;
        Object r114 = r14.rememberedValue();
        if (r34 == false) goto L134;
    L135:
        r114 = new FlowSwitchKt$FlowSwitch$3$1(r12, r38, r39);
        r14.updateRememberedValue(r114);
    L136:
        r14.endReplaceGroup();
        Modifier r35 = SuspendingPointerInputFilterKt.pointerInput(r30, r111, (PointerInputEventHandler) r114);
        ?? r115 = 0;
        boolean r116 = true;
        Object[] r117 = {Boolean.valueOf(r12), Boolean.valueOf(r38.b), Boolean.valueOf(r38.a), r21};
        r14.startReplaceGroup(-1224400529);
        if (r27 != 2048) goto L139;
        int r36 = 4;
        boolean r37 = true;
    L140:
        if (r18 != r36) goto L142;
        boolean r46 = true;
    L143:
        boolean r47 = (((r46 | r37) | r14.changedInstance(r9)) | r14.changed(r8)) | r14.changedInstance(r7);
        if (r33 == 32) goto L147;
        r116 = false;
    L147:
        boolean r48 = r47 | r116;
        Object r49 = r14.rememberedValue();
        if (r48 == false) goto L150;
    L153:
        final boolean r50 = r12;
        r115 = 0;
        PointerInputEventHandler r118 = new FlowSwitchKt$FlowSwitch$4$1(r50, r38, r9, r8, r7, r39);
        r14.updateRememberedValue(r118);
        r49 = r118;
    L154:
        r14.endReplaceGroup();
        Modifier r51 = SuspendingPointerInputFilterKt.pointerInput(r35, r117, (PointerInputEventHandler) r49);
        Alignment.Companion r52 = Alignment.Companion;
        MeasurePolicy r53 = BoxKt.maybeCachedBoxMeasurePolicy(r52.getCenterStart(), r115);
        long r54 = ComposablesKt.getCurrentCompositeKeyHashCode(r14, r115);
        int r55 = (int) (r54 ^ (r54 >>> 32));
        CompositionLocalMap r56 = r14.getCurrentCompositionLocalMap();
        Modifier r57 = ComposedModifierKt.materializeModifier(r14, r51);
        ComposeUiNode.Companion r58 = ComposeUiNode.Companion;
        Function0 r59 = r58.getConstructor();
        if ((r14.getApplier() instanceof Applier) == true) goto L157;
        ComposablesKt.invalidApplier();
    L157:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L160;
        r14.createNode(r59);
    L161:
        Composer r60 = Updater.constructor-impl(r14);
        Updater.set-impl(r60, r53, r58.getSetMeasurePolicy());
        Updater.set-impl(r60, r56, r58.getSetResolvedCompositionLocals());
        Function2 r61 = r58.getSetCompositeKeyHash();
        if (r60.getInserting() == false) goto L164;
    L165:
        r60.updateRememberedValue(Integer.valueOf(r55));
        r60.apply(Integer.valueOf(r55), r61);
    L166:
        Updater.set-impl(r60, r57, r58.getSetModifier());
        BoxScopeInstance r62 = BoxScopeInstance.INSTANCE;
        Modifier.Companion r63 = Modifier.Companion;
        Modifier r64 = PaddingKt.padding-VpY3zN4$default(r63, r21.m913getThumbPaddingD9Ej5fM$flow_ud_release(), 0.0f, 2, null);
        r14.startReplaceGroup(5004770);
        boolean r65 = r14.changedInstance(r9);
        Object r66 = r14.rememberedValue();
        if (r65 == false) goto L169;
    L170:
        r66 = new FlowSwitchKt$FlowSwitch$5$1$1(r9);
        r14.updateRememberedValue(r66);
    L171:
        r14.endReplaceGroup();
        Modifier r210 = OffsetKt.offset(r64, (Function1) r66);
        if (r12 == false) goto L174;
        float r67 = Dp.constructor-impl(r16);
    L175:
        Modifier r68 = BackgroundKt.background-bw27NRU(SizeKt.size-3ABfNKs(ShadowKt.shadow-s4CzXII$default(r210, r67, RoundedCornerShapeKt.getCircleShape(), false, 0, 0, 28, null), r21.m914getThumbSizeD9Ej5fM$flow_ud_release()), r25, RoundedCornerShapeKt.getCircleShape());
        MeasurePolicy r69 = BoxKt.maybeCachedBoxMeasurePolicy(r52.getCenter(), r115);
        long r70 = ComposablesKt.getCurrentCompositeKeyHashCode(r14, r115);
        int r71 = (int) (r70 ^ (r70 >>> 32));
        CompositionLocalMap r72 = r14.getCurrentCompositionLocalMap();
        Modifier r73 = ComposedModifierKt.materializeModifier(r14, r68);
        Function0 r74 = r58.getConstructor();
        if ((r14.getApplier() instanceof Applier) == true) goto L178;
        ComposablesKt.invalidApplier();
    L178:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L181;
        r14.createNode(r74);
    L182:
        Composer r75 = Updater.constructor-impl(r14);
        Updater.set-impl(r75, r69, r58.getSetMeasurePolicy());
        Updater.set-impl(r75, r72, r58.getSetResolvedCompositionLocals());
        Function2 r76 = r58.getSetCompositeKeyHash();
        if (r75.getInserting() == false) goto L185;
    L186:
        r75.updateRememberedValue(Integer.valueOf(r71));
        r75.apply(Integer.valueOf(r71), r76);
    L187:
        Updater.set-impl(r75, r73, r58.getSetModifier());
        r14.startReplaceGroup(163682125);
        if (r38.b == false) goto L195;
        if (r12 == false) goto L195;
        Modifier r119 = SizeKt.size-3ABfNKs(r63, r21.m911getLoadingIndicatorSizeD9Ej5fM$flow_ud_release());
        if (r38.a == false) goto L193;
        r14.startReplaceGroup(163689107);
        long r77 = n.a(r14, 6).e.b;
    L194:
        r14.endReplaceGroup();
        long r120 = r77;
        Composer r78 = r14;
        ProgressIndicatorKt.CircularProgressIndicator-4lLiAd8(r119, r120, r21.m912getLoadingIndicatorStrokeWidthD9Ej5fM$flow_ud_release(), 0, 0, 0.0f, r78, 0, 56);
    L196:
        r78.endReplaceGroup();
        r78.endNode();
        r78.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L199;
        ComposerKt.traceEventEnd();
    L199:
        final Modifier r79 = r28;
        final FlowSwitchStyle r80 = r21;
    L200:
        ScopeUpdateScope r81 = r78.endRestartGroup();
        if (r81 == null) goto L204;
        r81.updateScope(new FlowSwitchKt$FlowSwitch$6(r38, r39, r79, r12, r80, r44, r45));
        return;
    L204:
        return;
    L193:
        r14.startReplaceGroup(163690951);
        r77 = n.a(r14, 6).d.c;
    L195:
        r78 = r14;
        goto L196
    L185:
        if (Intrinsics.areEqual(r75.rememberedValue(), Integer.valueOf(r71)) == true) goto L187;
    L181:
        r14.useNode();
        goto L182
    L174:
        r67 = Dp.constructor-impl((float) r115);
        goto L175
    L169:
        if (r66 != r15.getEmpty()) goto L171;
    L164:
        if (Intrinsics.areEqual(r60.rememberedValue(), Integer.valueOf(r55)) == true) goto L166;
    L160:
        r14.useNode();
        goto L161
    L150:
        if (r49 != r15.getEmpty()) goto L154;
    L142:
        r46 = false;
        goto L143
    L139:
        r36 = 4;
        r37 = false;
        goto L140
    L134:
        if (r114 != r15.getEmpty()) goto L136;
    L130:
        r113 = false;
        goto L131
    L126:
        r112 = false;
        goto L127
    L122:
        r31 = false;
        goto L124
    L117:
        if (r110 != r15.getEmpty()) goto L119;
    L113:
        r29 = false;
        goto L114
    L99:
        r14.startReplaceGroup(1027516582);
        r24 = n.a(r14, 6).d.e;
        r14.endReplaceGroup();
        goto L100
    L101:
        r14.startReplaceGroup(1027613302);
        float r82 = 1.0f;
        if (r8 <= 0.0f) goto L106;
        r82 = RangesKt.coerceIn(((Number) r9.getValue()).floatValue() / r8, 0.0f, 1.0f);
    L109:
        r24 = ColorKt.lerp-jxsXWHM(n.a(r14, 6).d.f, n.a(r14, 6).e.b, r82);
        r14.endReplaceGroup();
        goto L110
    L106:
        if (r38.a == true) goto L109;
        r82 = 0.0f;
        goto L109
    L92:
        if (r23 != r15.getEmpty()) goto L94;
    L88:
        r20 = false;
        goto L89
    L81:
        if (r38.a == false) goto L83;
        float r83 = r8;
    L84:
        r2 = AnimatableKt.Animatable$default(r83, 0.0f, 2, null);
        r14.updateRememberedValue(r2);
        goto L85
    L83:
        r83 = 0.0f;
        goto L84
    L71:
        r21 = r42;
        goto L73
    L66:
        r11 = r4;
        goto L67
    L61:
        if (r14.getSkipping() == false) goto L64;
        r14.skipToGroupEnd();
        r80 = r42;
        r79 = r4;
        r12 = r12;
        r78 = r14;
        goto L200
    L49:
        if ((r44 & 24576) != 0) goto L59;
        if (r42 != null) goto L52;
        int r121 = -1;
    L54:
        if (r14.changed(r121) == false) goto L56;
        int r122 = 16384;
    L57:
        r1 = r1 | r122;
        goto L59
    L56:
        r122 = 8192;
        goto L57
    L52:
        r121 = r42.ordinal();
        goto L54
    L38:
        if ((r44 & 3072) != 0) goto L44;
        r12 = r41;
        if (r14.changed(r12) == false) goto L42;
        int r123 = 2048;
    L43:
        r1 = r1 | r123;
        goto L45
    L42:
        r123 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L43
    L27:
        if ((r44 & 384) != 0) goto L33;
        r4 = r40;
        if (r14.changed(r4) == false) goto L31;
        int r84 = 256;
    L32:
        r1 = r1 | r84;
        goto L34
    L31:
        r84 = 128;
        goto L32
    L17:
        if ((r44 & 48) != 0) goto L23;
        if (r14.changedInstance(r39) == false) goto L21;
        int r85 = 32;
    L22:
        r1 = r1 | r85;
        goto L23
    L21:
        r85 = 16;
        goto L22
    L6:
        if ((r44 & 6) == 0) goto L8;
        r1 = r44;
        goto L14
    L8:
        if (r14.changed(r38) == false) goto L10;
        int r86 = 4;
    L11:
        r1 = r86 | r44;
        goto L14
    L10:
        r86 = 2;
        goto L11
    }
}
