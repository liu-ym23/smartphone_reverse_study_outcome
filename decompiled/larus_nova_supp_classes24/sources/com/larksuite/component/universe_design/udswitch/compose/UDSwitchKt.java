package com.larksuite.component.universe_design.udswitch.compose;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.content.ContextCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UDSwitchKt {
    public static final float a = 0.0f;
    public static final float b = 0.0f;
    public static final float c = 0.0f;
    public static final float d = 0.0f;
    public static final float e = 0.0f;
    public static final float f = 0.0f;
    public static final float g = 0.0f;
    public static final float h = 0.0f;
    public static final float i = 0.0f;

    static {
        a = Dp.constructor-impl(44);
        float r0 = 36;
        b = Dp.constructor-impl(r0);
        float r1 = 20;
        c = Dp.constructor-impl(r1);
        d = Dp.constructor-impl(r0);
        e = Dp.constructor-impl(14);
        f = Dp.constructor-impl(7);
        g = Dp.constructor-impl(r1);
        h = Dp.constructor-impl((float) 5.43d);
        i = Dp.constructor-impl((float) 1.43d);
    }

    public static final long b(long r2, long r4) {
        if (Color.equals-impl0(r2, Color.Companion.getUnspecified-0d7_KjU()) == true) goto L5;
        return r2;
    L5:
        return r4;
    }

    public static final long c(Context r1, int r2, boolean r3, boolean r4) {
        ColorStateList r0 = ContextCompat.getColorStateList(r1, r2);
        if (r0 == null) goto L5;
        int r5 = r0.getDefaultColor();
    L6:
        if (r0 != null) goto L9;
        r0 = ColorStateList.valueOf(r5);
    L9:
        if (r3 == false) goto L12;
        if (r4 == false) goto L12;
        int[] r6 = {R.attr.state_checked, R.attr.state_enabled};
    L18:
        return ColorKt.Color(r0.getColorForState(r6, r5));
    L12:
        if (r3 == false) goto L14;
        r6 = new int[]{R.attr.state_checked, -16842910};
        goto L18
    L14:
        if (r4 == false) goto L16;
        r6 = new int[]{-16842912, R.attr.state_enabled};
        goto L18
    L16:
        r6 = new int[]{-16842912, -16842910};
        goto L18
    L5:
        r5 = ContextCompat.getColor(r1, r2);
        goto L6
    }

    public static final void a(final boolean r40, final boolean r41, final Function0<Unit> r42, final Modifier r43, final boolean r44, final a r45, final c r46, final float r47, final float r48, Composer r49, final int r50) {
        Composer r9 = r49.startRestartGroup(-1166426316);
        if ((r50 & 6) == 0) goto L5;
        int r4 = r50;
    L11:
        if ((r50 & 48) != 0) goto L18;
        if (r9.changed(r41) == false) goto L15;
        int r6 = 32;
    L16:
        r4 = r4 | r6;
        goto L18
    L15:
        r6 = 16;
    L18:
        if ((r50 & 384) != 0) goto L25;
        if (r9.changedInstance(r42) == false) goto L22;
        int r7 = 256;
    L23:
        r4 = r4 | r7;
        goto L25
    L22:
        r7 = 128;
    L25:
        if ((r50 & 3072) != 0) goto L32;
        if (r9.changed(r43) == false) goto L29;
        int r8 = 2048;
    L30:
        r4 = r4 | r8;
        goto L32
    L29:
        r8 = 1024;
    L32:
        if ((r50 & 24576) != 0) goto L39;
        if (r9.changed(r44) == false) goto L36;
        int r10 = 16384;
    L37:
        r4 = r4 | r10;
        goto L39
    L36:
        r10 = 8192;
    L39:
        if ((196608 & r50) != 0) goto L46;
        if (r9.changed(r45) == false) goto L43;
        int r11 = 131072;
    L44:
        r4 = r4 | r11;
        goto L46
    L43:
        r11 = 65536;
    L46:
        if ((1572864 & r50) != 0) goto L53;
        if (r9.changed(r46) == false) goto L50;
        int r12 = 1048576;
    L51:
        r4 = r4 | r12;
        goto L53
    L50:
        r12 = 524288;
    L53:
        if ((12582912 & r50) != 0) goto L60;
        if (r9.changed(r47) == false) goto L57;
        int r13 = 8388608;
    L58:
        r4 = r4 | r13;
        goto L60
    L57:
        r13 = 4194304;
    L60:
        if ((100663296 & r50) != 0) goto L68;
        if (r9.changed(r48) == false) goto L64;
        int r16 = 67108864;
    L65:
        r4 = r4 | r16;
        goto L68
    L64:
        r16 = 33554432;
    L68:
        if ((r4 & 38347923) != 38347922) goto L74;
        if (r9.getSkipping() == false) goto L74;
        r9.skipToGroupEnd();
        Composer r14 = r9;
    L164:
        ScopeUpdateScope r15 = r14.endRestartGroup();
        if (r15 == null) goto L168;
        r15.updateScope(new UDSwitchKt$SwitchContent$3(r40, r41, r42, r43, r44, r45, r46, r47, r48, r50));
        return;
    L168:
        return;
    L74:
        if (ComposerKt.isTraceInProgress() == false) goto L76;
        ComposerKt.traceEventStart(-1166426316, r4, -1, "com.larksuite.component.universe_design.udswitch.compose.SwitchContent (UDSwitch.kt:100)");
    L76:
        if (r44 == false) goto L79;
        if (r41 == true) goto L79;
        final boolean r3 = true;
    L80:
        if (r44 == false) goto L83;
        if (r41 == true) goto L83;
        boolean r5 = true;
    L84:
        int r17 = r4 & 14;
        r9.startReplaceGroup(-1487977711);
        if (ComposerKt.isTraceInProgress() == false) goto L87;
        ComposerKt.traceEventStart(-1487977711, r17, -1, "com.larksuite.component.universe_design.udswitch.compose.switchThumbOffset (UDSwitch.kt:179)");
    L87:
        float r19 = b;
        float r20 = g;
        float r110 = Dp.constructor-impl(r19 - r20);
        float r21 = Dp.constructor-impl(0);
        if (r9.consume(CompositionLocalsKt.getLocalLayoutDirection()) != LayoutDirection.Rtl) goto L90;
        boolean r22 = true;
    L91:
        if (r40 == false) goto L94;
        if (r22 == false) goto L94;
    L98:
        r110 = r21;
    L100:
        if (ComposerKt.isTraceInProgress() == false) goto L102;
        ComposerKt.traceEventEnd();
    L102:
        r9.endReplaceGroup();
        State r111 = AnimateAsStateKt.animateDpAsState-AjpBEmI(r110, AnimationSpecKt.tween$default(250, 0, null, 6, null), "UDSwitchThumbOffset", null, r9, 432, 8);
        r9.startReplaceGroup(1849434622);
        Object r23 = r9.rememberedValue();
        Composer.Companion r112 = Composer.Companion;
        if (r23 != r112.getEmpty()) goto L105;
        r23 = InteractionSourceKt.MutableInteractionSource();
        r9.updateRememberedValue(r23);
    L105:
        MutableInteractionSource r24 = (MutableInteractionSource) r23;
        r9.endReplaceGroup();
        long r113 = r45.b(r40, r5);
        long r30 = r45.a(r40, r5);
        if (r40 == false) goto L108;
        long r25 = r46.a;
    L109:
        long r35 = r25;
        Modifier r26 = SizeKt.requiredSize-3ABfNKs(r43, a);
        r9.startReplaceGroup(-1746271574);
        if (r17 != 4) goto L112;
        boolean r27 = true;
    L113:
        boolean r29 = r27 | r9.changed(r3);
        if ((r4 & 896) != 256) goto L116;
        boolean r31 = true;
    L117:
        boolean r32 = r29 | r31;
        Object r33 = r9.rememberedValue();
        if (r32 == false) goto L120;
    L121:
        r33 = new UDSwitchKt$SwitchContent$1$1(r40, r3, r42);
        r9.updateRememberedValue(r33);
    L122:
        r9.endReplaceGroup();
        int r210 = r4;
        Modifier r34 = ClickableKt.clickable-O2vRcR0$default(SemanticsModifierKt.semantics$default(r26, false, (Function1) r33, 1, null), r24, null, r3, null, Role.box-impl(Role.Companion.getSwitch-o7Vup1c()), r42, 8, null);
        Alignment.Companion r36 = Alignment.Companion;
        MeasurePolicy r37 = BoxKt.maybeCachedBoxMeasurePolicy(r36.getCenter(), false);
        r14 = r9;
        long r38 = ComposablesKt.getCurrentCompositeKeyHashCode(r14, 0);
        int r39 = (int) (r38 ^ (r38 >>> 32));
        CompositionLocalMap r51 = r14.getCurrentCompositionLocalMap();
        Modifier r52 = ComposedModifierKt.materializeModifier(r14, r34);
        ComposeUiNode.Companion r53 = ComposeUiNode.Companion;
        Function0 r114 = r53.getConstructor();
        if ((r14.getApplier() instanceof Applier) == true) goto L125;
        ComposablesKt.invalidApplier();
    L125:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L128;
        r14.createNode(r114);
    L129:
        Composer r115 = Updater.constructor-impl(r14);
        Updater.set-impl(r115, r37, r53.getSetMeasurePolicy());
        Updater.set-impl(r115, r51, r53.getSetResolvedCompositionLocals());
        Function2 r54 = r53.getSetCompositeKeyHash();
        if (r115.getInserting() == false) goto L132;
    L133:
        r115.updateRememberedValue(Integer.valueOf(r39));
        r115.apply(Integer.valueOf(r39), r54);
    L134:
        Updater.set-impl(r115, r52, r53.getSetModifier());
        BoxScopeInstance r55 = BoxScopeInstance.INSTANCE;
        Modifier.Companion r56 = Modifier.Companion;
        Modifier r57 = SizeKt.requiredSize-VpY3zN4(r56, r19, c);
        MeasurePolicy r59 = BoxKt.maybeCachedBoxMeasurePolicy(r36.getCenterStart(), false);
        long r116 = ComposablesKt.getCurrentCompositeKeyHashCode(r14, 0);
        int r117 = (int) (r116 ^ (r116 >>> 32));
        CompositionLocalMap r118 = r14.getCurrentCompositionLocalMap();
        Modifier r60 = ComposedModifierKt.materializeModifier(r14, r57);
        Function0 r0 = r53.getConstructor();
        if ((r14.getApplier() instanceof Applier) == true) goto L137;
        ComposablesKt.invalidApplier();
    L137:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L140;
        r14.createNode(r0);
    L141:
        Composer r1 = Updater.constructor-impl(r14);
        Updater.set-impl(r1, r59, r53.getSetMeasurePolicy());
        Updater.set-impl(r1, r118, r53.getSetResolvedCompositionLocals());
        Function2 r2 = r53.getSetCompositeKeyHash();
        if (r1.getInserting() == false) goto L144;
    L145:
        r1.updateRememberedValue(Integer.valueOf(r117));
        r1.apply(Integer.valueOf(r117), r2);
    L146:
        Updater.set-impl(r1, r60, r53.getSetModifier());
        BoxKt.Box(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-VpY3zN4(r55.align(r56, r36.getCenter()), d, e), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(f)), r113, null, 2, null), r14, 0);
        Modifier r61 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.requiredSize-3ABfNKs(OffsetKt.offset-VpY3zN4$default(r56, ((Dp) r111.getValue()).unbox-impl(), 0.0f, 2, null), r20), RoundedCornerShapeKt.getCircleShape()), r30, null, 2, null);
        MeasurePolicy r62 = BoxKt.maybeCachedBoxMeasurePolicy(r36.getCenter(), false);
        long r63 = ComposablesKt.getCurrentCompositeKeyHashCode(r14, 0);
        int r64 = (int) (r63 ^ (r63 >>> 32));
        CompositionLocalMap r65 = r14.getCurrentCompositionLocalMap();
        Modifier r66 = ComposedModifierKt.materializeModifier(r14, r61);
        Function0 r67 = r53.getConstructor();
        if ((r14.getApplier() instanceof Applier) == true) goto L149;
        ComposablesKt.invalidApplier();
    L149:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L152;
        r14.createNode(r67);
    L153:
        Composer r68 = Updater.constructor-impl(r14);
        Updater.set-impl(r68, r62, r53.getSetMeasurePolicy());
        Updater.set-impl(r68, r65, r53.getSetResolvedCompositionLocals());
        Function2 r69 = r53.getSetCompositeKeyHash();
        if (r68.getInserting() == false) goto L156;
    L157:
        r68.updateRememberedValue(Integer.valueOf(r64));
        r68.apply(Integer.valueOf(r64), r69);
    L158:
        Updater.set-impl(r68, r66, r53.getSetModifier());
        r14.startReplaceGroup(2109264593);
        if (r41 == false) goto L161;
        ProgressIndicatorKt.CircularProgressIndicator-4lLiAd8(SizeKt.size-3ABfNKs(r56, Dp.constructor-impl(2 * r47)), r35, r48, 0, StrokeCap.Companion.getRound-KaPHkGw(), 0.0f, r14, (r210 >> 18) & 896, 40);
    L161:
        r14.endReplaceGroup();
        r14.endNode();
        r14.endNode();
        r14.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L164;
        ComposerKt.traceEventEnd();
        goto L164
    L156:
        if (Intrinsics.areEqual(r68.rememberedValue(), Integer.valueOf(r64)) == true) goto L158;
    L152:
        r14.useNode();
        goto L153
    L144:
        if (Intrinsics.areEqual(r1.rememberedValue(), Integer.valueOf(r117)) == true) goto L146;
    L140:
        r14.useNode();
        goto L141
    L132:
        if (Intrinsics.areEqual(r115.rememberedValue(), Integer.valueOf(r39)) == true) goto L134;
    L128:
        r14.useNode();
        goto L129
    L120:
        if (r33 != r112.getEmpty()) goto L122;
    L116:
        r31 = false;
        goto L117
    L112:
        r27 = false;
        goto L113
    L108:
        r25 = r46.b;
    L94:
        if (r40 == true) goto L100;
        if (r22 == false) goto L98;
    L90:
        r22 = false;
    L83:
        r5 = false;
    L79:
        r3 = false;
        goto L80
    L5:
        if (r9.changed(r40) == false) goto L7;
        int r70 = 4;
    L8:
        r4 = r70 | r50;
        goto L11
    L7:
        r70 = 2;
        goto L8
    }
}
