package com.larksuite.component.universe_design.breadcrumb.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.interaction.HoverInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteractionKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnitKt;
import com.larksuite.component.universe_design.compose.foundation.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c {
    public static final void a(final String r54, final boolean r55, final float r56, final a r57, final Function0 r59, Composer r510, final int r60) {
        Composer r1 = r510.startRestartGroup(-2098031506);
        if ((r60 & 6) == 0) goto L5;
        int r5 = r60;
    L11:
        if ((r60 & 48) != 0) goto L18;
        if (r1.changed(r55) == false) goto L15;
        int r6 = 32;
    L16:
        r5 = r5 | r6;
        goto L18
    L15:
        r6 = 16;
    L18:
        if ((r60 & 384) != 0) goto L25;
        if (r1.changed(r56) == false) goto L22;
        int r7 = 256;
    L23:
        r5 = r5 | r7;
        goto L25
    L22:
        r7 = 128;
    L25:
        if ((r60 & 3072) != 0) goto L32;
        if (r1.changed(r57) == false) goto L29;
        int r8 = 2048;
    L30:
        r5 = r5 | r8;
        goto L32
    L29:
        r8 = 1024;
    L32:
        if ((r60 & 24576) == 0) goto L34;
    L38:
        int r12 = r5;
        if ((r12 & 9363) != 9362) goto L45;
        if (r1.getSkipping() == false) goto L45;
        r1.skipToGroupEnd();
        Composer r2 = r1;
    L103:
        ScopeUpdateScope r9 = r2.endRestartGroup();
        if (r9 == null) goto L107;
        r9.updateScope(new UDBreadcrumbKt$BreadcrumbItem$3(r54, r55, r56, r57, r59, r60));
        return;
    L107:
        return;
    L45:
        if (ComposerKt.isTraceInProgress() == false) goto L48;
        ComposerKt.traceEventStart(-2098031506, r12, -1, "com.larksuite.component.universe_design.breadcrumb.compose.BreadcrumbItem (UDBreadcrumb.kt:138)");
    L48:
        if (r55 == true) goto L51;
        if (r59 == null) goto L51;
        boolean r10 = true;
    L52:
        r1.startReplaceGroup(1849434622);
        Object r11 = r1.rememberedValue();
        Composer.Companion r17 = Composer.Companion;
        if (r11 != r17.getEmpty()) goto L55;
        r11 = InteractionSourceKt.MutableInteractionSource();
        r1.updateRememberedValue(r11);
    L55:
        MutableInteractionSource r13 = (MutableInteractionSource) r11;
        r1.endReplaceGroup();
        State r14 = PressInteractionKt.collectIsPressedAsState(r13, r1, 6);
        State r15 = HoverInteractionKt.collectIsHoveredAsState(r13, r1, 6);
        if (r10 == true) goto L58;
    L60:
        if (r10 == true) goto L62;
    L64:
        long r16 = Color.Companion.getTransparent-0d7_KjU();
    L65:
        long r19 = r16;
        TextStyle r20 = i0.b(r1).c;
        if (r55 == false) goto L68;
        long r0 = r57.b;
    L69:
        TextStyle r3 = r20.merge(new TextStyle(r0, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, TextUnitKt.getSp(20), null, null, null, 0, 0, null, 16646142, null));
        Modifier r4 = Modifier.Companion;
        Modifier r21 = SizeKt.widthIn-VpY3zN4$default(SizeKt.height-3ABfNKs(r4, b.c), 0.0f, r56, 1, null);
        float r22 = b.d;
        Modifier r23 = SizeKt.defaultMinSize-VpY3zN4(r21, r22, r22);
        r1.startReplaceGroup(-1868577048);
        if (r10 == false) goto L75;
        r2 = r1;
        Modifier r24 = ClickableKt.clickable-O2vRcR0$default(HoverableKt.hoverable(r4, r13, true), r13, null, false, null, Role.box-impl(Role.Companion.getButton-o7Vup1c()), r59, 12, null);
        r2.startReplaceGroup(1849434622);
        Object r25 = r2.rememberedValue();
        if (r25 != r17.getEmpty()) goto L74;
        r25 = UDBreadcrumbKt$BreadcrumbItem$1$1.INSTANCE;
        r2.updateRememberedValue(r25);
    L74:
        r2.endReplaceGroup();
        int r26 = 1;
        Modifier r27 = SemanticsModifierKt.semantics(r24, true, (Function1) r25);
    L76:
        r2.endReplaceGroup();
        Modifier r29 = r23.then(r27);
        Alignment.Companion r30 = Alignment.Companion;
        MeasurePolicy r31 = BoxKt.maybeCachedBoxMeasurePolicy(r30.getCenterStart(), false);
        long r110 = ComposablesKt.getCurrentCompositeKeyHashCode(r2, 0);
        int r111 = (int) (r110 ^ (r110 >>> 32));
        CompositionLocalMap r32 = r2.getCurrentCompositionLocalMap();
        Modifier r33 = ComposedModifierKt.materializeModifier(r2, r29);
        ComposeUiNode.Companion r112 = ComposeUiNode.Companion;
        Function0 r113 = r112.getConstructor();
        if ((r2.getApplier() instanceof Applier) == true) goto L79;
        ComposablesKt.invalidApplier();
    L79:
        r2.startReusableNode();
        if (r2.getInserting() == false) goto L82;
        r2.createNode(r113);
    L83:
        Composer r114 = Updater.constructor-impl(r2);
        Updater.set-impl(r114, r31, r112.getSetMeasurePolicy());
        Updater.set-impl(r114, r32, r112.getSetResolvedCompositionLocals());
        Function2 r34 = r112.getSetCompositeKeyHash();
        if (r114.getInserting() == false) goto L86;
    L87:
        r114.updateRememberedValue(Integer.valueOf(r111));
        r114.apply(Integer.valueOf(r111), r34);
    L88:
        Updater.set-impl(r114, r33, r112.getSetModifier());
        BoxScopeInstance r35 = BoxScopeInstance.INSTANCE;
        Modifier r36 = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(r4, b.e), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(b.i)), r19, null, 2, null), b.f, b.g);
        MeasurePolicy r37 = BoxKt.maybeCachedBoxMeasurePolicy(r30.getCenterStart(), false);
        long r38 = ComposablesKt.getCurrentCompositeKeyHashCode(r2, 0);
        int r39 = (int) (r38 ^ (r38 >>> 32));
        CompositionLocalMap r40 = r2.getCurrentCompositionLocalMap();
        Modifier r41 = ComposedModifierKt.materializeModifier(r2, r36);
        Function0 r115 = r112.getConstructor();
        if ((r2.getApplier() instanceof Applier) == true) goto L91;
        ComposablesKt.invalidApplier();
    L91:
        r2.startReusableNode();
        if (r2.getInserting() == false) goto L94;
        r2.createNode(r115);
    L95:
        Composer r116 = Updater.constructor-impl(r2);
        Updater.set-impl(r116, r37, r112.getSetMeasurePolicy());
        Updater.set-impl(r116, r40, r112.getSetResolvedCompositionLocals());
        Function2 r42 = r112.getSetCompositeKeyHash();
        if (r116.getInserting() == false) goto L98;
    L99:
        r116.updateRememberedValue(Integer.valueOf(r39));
        r116.apply(Integer.valueOf(r39), r42);
    L100:
        Updater.set-impl(r116, r41, r112.getSetModifier());
        Composer r210 = r2;
        BasicTextKt.BasicText-RWo7tUw(r54, SizeKt.widthIn-VpY3zN4$default(r4, 0.0f, r56, r26, null), r3, null, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, null, null, r210, (r12 & 14) | 1597440, 936);
        r2.endNode();
        r2.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L103;
        ComposerKt.traceEventEnd();
        goto L103
    L98:
        if (Intrinsics.areEqual(r116.rememberedValue(), Integer.valueOf(r39)) == true) goto L100;
    L94:
        r2.useNode();
        goto L95
    L86:
        if (Intrinsics.areEqual(r114.rememberedValue(), Integer.valueOf(r111)) == true) goto L88;
    L82:
        r2.useNode();
        goto L83
    L75:
        r2 = r1;
        r26 = 1;
        r27 = r4;
        goto L76
    L68:
        r0 = r57.a;
        goto L69
    L62:
        if (((Boolean) r15.getValue()).booleanValue() == false) goto L64;
        r16 = r57.e;
        goto L65
    L58:
        if (((Boolean) r14.getValue()).booleanValue() == false) goto L60;
        r16 = r57.d;
    L51:
        r10 = false;
        goto L52
    L34:
        if (r1.changedInstance(r59) == false) goto L36;
        int r43 = 16384;
    L37:
        r5 = r5 | r43;
        goto L38
    L36:
        r43 = 8192;
        goto L37
    L5:
        if (r1.changed(r54) == false) goto L7;
        int r44 = 4;
    L8:
        r5 = r44 | r60;
        goto L11
    L7:
        r44 = 2;
        goto L8
    }
}
