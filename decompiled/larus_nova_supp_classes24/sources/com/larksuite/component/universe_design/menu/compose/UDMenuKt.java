package com.larksuite.component.universe_design.menu.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteractionKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.compose.foundation.i0;
import com.larksuite.component.universe_design.menu.PositionAlign;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UDMenuKt {
    public static final void a(final Modifier r10, final a r11, final Function2<? super Composer, ? super Integer, Unit> r12, Composer r13, final int r14) {
        Composer r15 = r13.startRestartGroup(-318111654);
        if ((r14 & 6) == 0) goto L5;
        int r1 = r14;
    L11:
        if ((r14 & 48) != 0) goto L18;
        if (r15.changed(r11) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r14 & 384) != 0) goto L25;
        if (r15.changedInstance(r12) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r1 & 147) != 146) goto L31;
        if (r15.getSkipping() == false) goto L31;
        r15.skipToGroupEnd();
    L48:
        ScopeUpdateScope r16 = r15.endRestartGroup();
        if (r16 == null) goto L52;
        r16.updateScope(new UDMenuKt$UDMenuContainer$2(r10, r11, r12, r14));
        return;
    L52:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventStart(-318111654, r1, -1, "com.larksuite.component.universe_design.menu.compose.UDMenuContainer (UDMenu.kt:376)");
    L33:
        float r0 = 8;
        Modifier r4 = BorderKt.border-xT4_qwU(BackgroundKt.background-bw27NRU$default(ClipKt.clip(r10, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(r0))), r11.a, null, 2, null), Dp.constructor-impl(1), r11.b, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(r0)));
        MeasurePolicy r5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        long r6 = ComposablesKt.getCurrentCompositeKeyHashCode(r15, 0);
        int r7 = (int) (r6 ^ (r6 >>> 32));
        CompositionLocalMap r8 = r15.getCurrentCompositionLocalMap();
        Modifier r9 = ComposedModifierKt.materializeModifier(r15, r4);
        ComposeUiNode.Companion r17 = ComposeUiNode.Companion;
        Function0 r19 = r17.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L36;
        ComposablesKt.invalidApplier();
    L36:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L39;
        r15.createNode(r19);
    L40:
        Composer r20 = Updater.constructor-impl(r15);
        Updater.set-impl(r20, r5, r17.getSetMeasurePolicy());
        Updater.set-impl(r20, r8, r17.getSetResolvedCompositionLocals());
        Function2 r21 = r17.getSetCompositeKeyHash();
        if (r20.getInserting() == false) goto L43;
    L44:
        r20.updateRememberedValue(Integer.valueOf(r7));
        r20.apply(Integer.valueOf(r7), r21);
    L45:
        Updater.set-impl(r20, r9, r17.getSetModifier());
        BoxScopeInstance r22 = BoxScopeInstance.INSTANCE;
        r12.invoke(r15, Integer.valueOf((r1 >> 6) & 14));
        r15.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L48;
        ComposerKt.traceEventEnd();
        goto L48
    L43:
        if (Intrinsics.areEqual(r20.rememberedValue(), Integer.valueOf(r7)) == true) goto L45;
    L39:
        r15.useNode();
        goto L40
    L5:
        if (r15.changed(r10) == false) goto L7;
        int r23 = 4;
    L8:
        r1 = r23 | r14;
        goto L11
    L7:
        r23 = 2;
        goto L8
    }

    public static final void b(Modifier r8, a r9, final PaddingValues r10, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> r11, Composer r12, final int r13, final int r14) {
        Intrinsics.checkNotNullParameter(r11, "content");
        Composer r15 = r12.startRestartGroup(-904814550);
        int r1 = r14 & 1;
        if (r1 == 0) goto L6;
        int r2 = r13 | 6;
    L14:
        if ((r13 & 48) == 0) goto L16;
    L22:
        int r3 = r14 & 4;
        if (r3 == 0) goto L26;
        r2 = r2 | 384;
    L33:
        if ((r14 & 8) == 0) goto L36;
        r2 = r2 | 3072;
    L43:
        if ((r2 & 1171) == 1170) goto L45;
    L49:
        r15.startDefaults();
        if ((r13 & 1) != 0) goto L52;
    L57:
        if (r1 == 0) goto L60;
        r8 = Modifier.Companion;
    L60:
        if ((r14 & 2) == 0) goto L62;
        r9 = b.a(r15);
        r2 = r2 & (-113);
    L62:
        if (r3 == 0) goto L64;
        r10 = b.b;
    L64:
        r15.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L67;
        ComposerKt.traceEventStart(-904814550, r2, -1, "com.larksuite.component.universe_design.menu.compose.UDMenuCustom (UDMenu.kt:272)");
    L67:
        a(r8, r9, ComposableLambdaKt.rememberComposableLambda(-40962704, true, new UDMenuKt$UDMenuCustom$1(r10, r11), r15, 54), r15, ((r2 & 14) | 384) | (r2 & 112));
        if (ComposerKt.isTraceInProgress() == true) goto L69;
    L48:
        final Modifier r4 = r8;
        final a r5 = r9;
        final PaddingValues r6 = r10;
        ScopeUpdateScope r16 = r15.endRestartGroup();
        if (r16 == null) goto L74;
        r16.updateScope(new UDMenuKt$UDMenuCustom$2(r4, r5, r6, r11, r13, r14));
        return;
    L74:
        return;
    L69:
        ComposerKt.traceEventEnd();
        goto L48
    L52:
        if (r15.getDefaultsInvalid() == true) goto L57;
        r15.skipToGroupEnd();
        if ((r14 & 2) == 0) goto L64;
        r2 = r2 & (-113);
        goto L64
    L45:
        if (r15.getSkipping() == false) goto L49;
        r15.skipToGroupEnd();
        goto L48
    L36:
        if ((r13 & 3072) != 0) goto L43;
        if (r15.changedInstance(r11) == false) goto L40;
        int r7 = 2048;
    L41:
        r2 = r2 | r7;
        goto L43
    L40:
        r7 = 1024;
        goto L41
    L26:
        if ((r13 & 384) != 0) goto L33;
        if (r15.changed(r10) == false) goto L30;
        int r17 = 256;
    L31:
        r2 = r2 | r17;
        goto L33
    L30:
        r17 = 128;
        goto L31
    L16:
        if ((r14 & 2) == 0) goto L18;
    L20:
        int r19 = 16;
    L21:
        r2 = r2 | r19;
        goto L22
    L18:
        if (r15.changed(r9) == false) goto L20;
        r19 = 32;
        goto L21
    L6:
        if ((r13 & 6) == 0) goto L8;
        r2 = r13;
        goto L14
    L8:
        if (r15.changed(r8) == false) goto L10;
        int r20 = 4;
    L11:
        r2 = r20 | r13;
        goto L14
    L10:
        r20 = 2;
        goto L11
    }

    public static final void c(final c r57, Modifier r59, boolean r510, a r60, Function0<Unit> r61, Composer r62, final int r63, final int r64) {
        Intrinsics.checkNotNullParameter(r57, "item");
        Composer r2 = r62.startRestartGroup(-107376904);
        if ((r64 & 1) == 0) goto L6;
        int r3 = r63 | 6;
    L13:
        int r7 = r64 & 2;
        if (r7 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r9 = r59;
    L24:
        int r10 = r64 & 4;
        if (r10 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        boolean r11 = r510;
    L36:
        if ((r63 & 3072) == 0) goto L38;
        a r12 = r60;
    L47:
        if ((r3 & 1171) == 1170) goto L49;
    L52:
        r2.startDefaults();
        if ((r63 & 1) != 0) goto L55;
    L60:
        if (r7 == 0) goto L62;
        r9 = Modifier.Companion;
    L62:
        if (r10 == 0) goto L65;
        r11 = false;
    L65:
        if ((r64 & 8) == 0) goto L68;
        r3 = r3 & (-7169);
        r12 = b.a(r2);
    L68:
        if ((r64 & 16) == 0) goto L70;
        int r8 = r3;
        Modifier r4 = r9;
        boolean r20 = r11;
        a r13 = r12;
        Function0<Unit> r21 = null;
    L71:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L74;
        ComposerKt.traceEventStart(-107376904, r8, -1, "com.larksuite.component.universe_design.menu.compose.UDMenuItem (UDMenu.kt:308)");
    L74:
        r2.startReplaceGroup(1849434622);
        Object r0 = r2.rememberedValue();
        Composer.Companion r14 = Composer.Companion;
        if (r0 != r14.getEmpty()) goto L77;
        r0 = InteractionSourceKt.MutableInteractionSource();
        r2.updateRememberedValue(r0);
    L77:
        MutableInteractionSource r1 = (MutableInteractionSource) r0;
        r2.endReplaceGroup();
        if (((Boolean) PressInteractionKt.collectIsPressedAsState(r1, r2, 6).getValue()).booleanValue() == false) goto L80;
        r57.getClass();
    L80:
        long r23 = Color.Companion.getTransparent-0d7_KjU();
        r57.getClass();
        long r15 = r13.h;
        Modifier r22 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.defaultMinSize-VpY3zN4$default(r4, Dp.constructor-impl(120), 0.0f, 2, null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), r23, null, 2, null);
        Role r27 = Role.box-impl(Role.Companion.getButton-o7Vup1c());
        r2.startReplaceGroup(5004770);
        if ((r8 & 14) != 4) goto L83;
        boolean r5 = true;
    L84:
        Object r6 = r2.rememberedValue();
        if (r5 == false) goto L87;
    L88:
        r6 = new UDMenuKt$UDMenuItem$1$1(r57);
        r2.updateRememberedValue(r6);
    L89:
        r2.endReplaceGroup();
        float r16 = 12;
        float r17 = 15;
        Modifier r19 = PaddingKt.padding-qDBjuR0(ClickableKt.clickable-O2vRcR0$default(r22, r1, null, false, null, r27, (Function0) r6, 8, null), Dp.constructor-impl(r16), Dp.constructor-impl(r17), Dp.constructor-impl(r16), Dp.constructor-impl(r17));
        Alignment.Companion r24 = Alignment.Companion;
        Alignment.Vertical r25 = r24.getTop();
        Arrangement r26 = Arrangement.INSTANCE;
        MeasurePolicy r29 = RowKt.rowMeasurePolicy(r26.getStart(), r25, r2, 48);
        long r110 = ComposablesKt.getCurrentCompositeKeyHashCode(r2, 0);
        int r111 = (int) (r110 ^ (r110 >>> 32));
        CompositionLocalMap r112 = r2.getCurrentCompositionLocalMap();
        Modifier r30 = ComposedModifierKt.materializeModifier(r2, r19);
        ComposeUiNode.Companion r113 = ComposeUiNode.Companion;
        Function0 r31 = r113.getConstructor();
        if ((r2.getApplier() instanceof Applier) == true) goto L92;
        ComposablesKt.invalidApplier();
    L92:
        r2.startReusableNode();
        if (r2.getInserting() == false) goto L95;
        r2.createNode(r31);
    L96:
        Composer r32 = Updater.constructor-impl(r2);
        Updater.set-impl(r32, r29, r113.getSetMeasurePolicy());
        Updater.set-impl(r32, r112, r113.getSetResolvedCompositionLocals());
        Function2 r33 = r113.getSetCompositeKeyHash();
        if (r32.getInserting() == false) goto L99;
    L100:
        r32.updateRememberedValue(Integer.valueOf(r111));
        r32.apply(Integer.valueOf(r111), r33);
    L101:
        Updater.set-impl(r32, r30, r113.getSetModifier());
        RowScopeInstance r34 = RowScopeInstance.INSTANCE;
        r2.startReplaceGroup(-391689637);
        Modifier.Companion r35 = Modifier.Companion;
        SpacerKt.Spacer(SizeKt.size-3ABfNKs(r35, Dp.constructor-impl(20)), r2, 6);
        r2.endReplaceGroup();
        SpacerKt.Spacer(SizeKt.width-3ABfNKs(r35, Dp.constructor-impl(r16)), r2, 6);
        Modifier r36 = SizeKt.defaultMinSize-VpY3zN4$default(r35, Dp.constructor-impl(64), 0.0f, 2, null);
        MeasurePolicy r37 = ColumnKt.columnMeasurePolicy(r26.getTop(), r24.getStart(), r2, 0);
        long r38 = ComposablesKt.getCurrentCompositeKeyHashCode(r2, 0);
        int r39 = (int) (r38 ^ (r38 >>> 32));
        CompositionLocalMap r40 = r2.getCurrentCompositionLocalMap();
        Modifier r41 = ComposedModifierKt.materializeModifier(r2, r36);
        Function0 r42 = r113.getConstructor();
        if ((r2.getApplier() instanceof Applier) == true) goto L104;
        ComposablesKt.invalidApplier();
    L104:
        r2.startReusableNode();
        if (r2.getInserting() == false) goto L107;
        r2.createNode(r42);
    L108:
        Composer r43 = Updater.constructor-impl(r2);
        Updater.set-impl(r43, r37, r113.getSetMeasurePolicy());
        Updater.set-impl(r43, r40, r113.getSetResolvedCompositionLocals());
        Function2 r44 = r113.getSetCompositeKeyHash();
        if (r43.getInserting() == false) goto L111;
    L112:
        r43.updateRememberedValue(Integer.valueOf(r39));
        r43.apply(Integer.valueOf(r39), r44);
    L113:
        Updater.set-impl(r43, r41, r113.getSetModifier());
        ColumnScopeInstance r45 = ColumnScopeInstance.INSTANCE;
        Modifier r46 = SizeKt.width-3ABfNKs(r35, Dp.constructor-impl(154));
        TextStyle r47 = i0.b(r2).d.merge(new TextStyle(r15, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777214, null));
        if (r20 == false) goto L116;
        int r48 = 1;
    L117:
        final a r49 = r13;
        BasicTextKt.BasicText-RWo7tUw(null, r46, r47, null, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, r48, 0, null, null, r2, 24624, 936);
        r2.startReplaceGroup(114830574);
        r2.endReplaceGroup();
        r2.endNode();
        r2.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L120;
        ComposerKt.traceEventEnd();
    L120:
        r9 = r4;
        final boolean r50 = r20;
        final Function0<Unit> r51 = r21;
    L121:
        ScopeUpdateScope r52 = r2.endRestartGroup();
        if (r52 == null) goto L125;
        final Modifier r53 = r9;
        r52.updateScope(new UDMenuKt$UDMenuItem$3(r57, r53, r50, r49, r51, r63, r64));
        return;
    L125:
        return;
    L116:
        r48 = LKUIToast.DURATION_MAX;
        goto L117
    L111:
        if (Intrinsics.areEqual(r43.rememberedValue(), Integer.valueOf(r39)) == true) goto L113;
    L107:
        r2.useNode();
        goto L108
    L99:
        if (Intrinsics.areEqual(r32.rememberedValue(), Integer.valueOf(r111)) == true) goto L101;
    L95:
        r2.useNode();
        goto L96
    L87:
        if (r6 != r14.getEmpty()) goto L89;
    L83:
        r5 = false;
    L70:
        r21 = r61;
        r8 = r3;
        r4 = r9;
        r20 = r11;
        r13 = r12;
        goto L71
    L55:
        if (r2.getDefaultsInvalid() == true) goto L60;
        r2.skipToGroupEnd();
        if ((r64 & 8) == 0) goto L70;
        r3 = r3 & (-7169);
        goto L70
    L49:
        if (r2.getSkipping() == false) goto L52;
        r2.skipToGroupEnd();
        r51 = r61;
        r50 = r11;
        r49 = r12;
        goto L121
    L38:
        if ((r64 & 8) != 0) goto L42;
        r12 = r60;
        if (r2.changed(r12) == false) goto L43;
        int r114 = 2048;
    L44:
        r3 = r3 | r114;
    L43:
        r114 = 1024;
        goto L44
    L42:
        r12 = r60;
        goto L43
    L28:
        if ((r63 & 384) != 0) goto L34;
        r11 = r510;
        if (r2.changed(r11) == false) goto L32;
        int r115 = 256;
    L33:
        r3 = r3 | r115;
        goto L36
    L32:
        r115 = 128;
        goto L33
    L17:
        if ((r63 & 48) != 0) goto L23;
        r9 = r59;
        if (r2.changed(r9) == false) goto L21;
        int r116 = 32;
    L22:
        r3 = r3 | r116;
        goto L24
    L21:
        r116 = 16;
        goto L22
    L6:
        if ((r63 & 6) == 0) goto L8;
        r3 = r63;
        goto L13
    L8:
        if (r2.changed(r57) == false) goto L10;
        int r54 = 4;
    L11:
        r3 = r54 | r63;
        goto L13
    L10:
        r54 = 2;
        goto L11
    }

    public static final void d(final List<c> r17, Modifier r19, boolean r110, Set<Integer> r20, a r21, PaddingValues r22, Function0<Unit> r23, Composer r24, final int r25, final int r26) {
        Intrinsics.checkNotNullParameter(r17, "menuItems");
        Composer r2 = r24.startRestartGroup(-920754091);
        if ((r26 & 1) == 0) goto L6;
        int r3 = r25 | 6;
    L13:
        int r4 = r26 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r5 = r19;
    L24:
        int r6 = r26 & 4;
        if (r6 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        boolean r7 = r110;
    L35:
        int r9 = r26 & 8;
        if (r9 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        Set<Integer> r10 = r20;
    L47:
        if ((r25 & 24576) == 0) goto L49;
        a r11 = r21;
    L57:
        int r12 = r26 & 32;
        if (r12 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        PaddingValues r13 = r22;
    L68:
        int r14 = r26 & 64;
        if (r14 == 0) goto L72;
        r3 = r3 | 1572864;
    L78:
        Function0<Unit> r15 = r23;
    L80:
        if ((r3 & 599187) == 599186) goto L82;
    L86:
        r2.startDefaults();
        if ((r25 & 1) != 0) goto L89;
    L95:
        if (r4 == 0) goto L97;
        Modifier r0 = Modifier.Companion;
    L98:
        if (r6 == 0) goto L100;
        r7 = false;
    L100:
        if (r9 == 0) goto L103;
        r10 = SetsKt.emptySet();
    L103:
        if ((r26 & 16) == 0) goto L105;
        r3 = r3 & (-57345);
        r11 = b.a(r2);
    L105:
        if (r12 == 0) goto L107;
        r13 = b.a;
    L107:
        if (r14 == 0) goto L109;
        r15 = null;
    L109:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L112;
        ComposerKt.traceEventStart(-920754091, r3, -1, "com.larksuite.component.universe_design.menu.compose.UDMenuList (UDMenu.kt:241)");
    L112:
        final PaddingValues r111 = r13;
        final boolean r27 = r7;
        final a r29 = r11;
        final Function0<Unit> r210 = r15;
        final Set<Integer> r211 = r10;
        a(r0, r11, ComposableLambdaKt.rememberComposableLambda(-1088327985, true, new UDMenuKt$UDMenuList$1(r111, r17, r27, r29, r210, r211), r2, 54), r2, ((r3 >> 9) & 112) | (((r3 >> 3) & 14) | 384));
        if (ComposerKt.isTraceInProgress() == false) goto L115;
        ComposerKt.traceEventEnd();
    L115:
        r5 = r0;
    L85:
        final boolean r8 = r7;
        final Set<Integer> r16 = r10;
        final PaddingValues r30 = r13;
        final Function0<Unit> r31 = r15;
        ScopeUpdateScope r112 = r2.endRestartGroup();
        if (r112 == null) goto L120;
        final Modifier r32 = r5;
        final a r33 = r11;
        r112.updateScope(new UDMenuKt$UDMenuList$2(r17, r32, r8, r16, r33, r30, r31, r25, r26));
        return;
    L120:
        return;
    L97:
        r0 = r5;
        goto L98
    L89:
        if (r2.getDefaultsInvalid() == true) goto L95;
        r2.skipToGroupEnd();
        if ((r26 & 16) == 0) goto L94;
        r3 = r3 & (-57345);
    L94:
        r0 = r5;
        goto L109
    L82:
        if (r2.getSkipping() == false) goto L86;
        r2.skipToGroupEnd();
        goto L85
    L72:
        if ((1572864 & r25) != 0) goto L78;
        r15 = r23;
        if (r2.changedInstance(r15) == false) goto L76;
        int r113 = 1048576;
    L77:
        r3 = r3 | r113;
        goto L80
    L76:
        r113 = 524288;
        goto L77
    L61:
        if ((196608 & r25) != 0) goto L67;
        r13 = r22;
        if (r2.changed(r13) == false) goto L65;
        int r114 = 131072;
    L66:
        r3 = r3 | r114;
        goto L68
    L65:
        r114 = 65536;
        goto L66
    L49:
        if ((r26 & 16) != 0) goto L53;
        r11 = r21;
        if (r2.changed(r11) == false) goto L54;
        int r115 = 16384;
    L55:
        r3 = r3 | r115;
    L54:
        r115 = 8192;
        goto L55
    L53:
        r11 = r21;
        goto L54
    L39:
        if ((r25 & 3072) != 0) goto L45;
        r10 = r20;
        if (r2.changedInstance(r10) == false) goto L43;
        int r116 = 2048;
    L44:
        r3 = r3 | r116;
        goto L47
    L43:
        r116 = 1024;
        goto L44
    L28:
        if ((r25 & 384) != 0) goto L34;
        r7 = r110;
        if (r2.changed(r7) == false) goto L32;
        int r34 = 256;
    L33:
        r3 = r3 | r34;
        goto L35
    L32:
        r34 = 128;
        goto L33
    L17:
        if ((r25 & 48) != 0) goto L23;
        r5 = r19;
        if (r2.changed(r5) == false) goto L21;
        int r35 = 32;
    L22:
        r3 = r3 | r35;
        goto L24
    L21:
        r35 = 16;
        goto L22
    L6:
        if ((r25 & 6) == 0) goto L8;
        r3 = r25;
        goto L13
    L8:
        if (r2.changedInstance(r17) == false) goto L10;
        int r36 = 4;
    L11:
        r3 = r36 | r25;
        goto L13
    L10:
        r36 = 2;
        goto L11
    }

    public static final void e(final boolean r30, final Function0<Unit> r31, Modifier r32, UDMenuGravity r33, PositionAlign r34, float r35, boolean r36, final Function2<? super Composer, ? super Integer, Unit> r37, Composer r38, final int r39, final int r40) {
        Intrinsics.checkNotNullParameter(r31, "onDismissRequest");
        Intrinsics.checkNotNullParameter(r37, "popupContent");
        Composer r13 = r38.startRestartGroup(708270273);
        if ((r40 & 1) == 0) goto L6;
        int r2 = r39 | 6;
    L14:
        if ((r40 & 2) == 0) goto L17;
        r2 = r2 | 48;
    L23:
        int r3 = r40 & 4;
        if (r3 == 0) goto L27;
        r2 = r2 | 384;
    L33:
        Modifier r5 = r32;
    L34:
        int r6 = r40 & 8;
        if (r6 == 0) goto L38;
        r2 = r2 | 3072;
    L47:
        int r14 = r40 & 16;
        if (r14 == 0) goto L51;
        r2 = r2 | 24576;
    L60:
        int r15 = r40 & 32;
        if (r15 == 0) goto L63;
        r2 = r2 | 196608;
        float r7 = r35;
    L70:
        int r17 = r40 & 64;
        if (r17 == 0) goto L73;
        r2 = r2 | 1572864;
        boolean r4 = r36;
    L81:
        if ((r40 & 128) == 0) goto L84;
        r2 = r2 | 12582912;
    L91:
        if ((4793491 & r2) == 4793490) goto L93;
    L96:
        if (r3 == 0) goto L98;
        final Modifier r0 = Modifier.Companion;
    L99:
        if (r6 == 0) goto L101;
        UDMenuGravity r29 = UDMenuGravity.Bottom;
    L102:
        if (r14 == 0) goto L104;
        PositionAlign r16 = PositionAlign.CENTER;
    L105:
        if (r15 == 0) goto L107;
        PaddingValues r8 = b.a;
        float r19 = b.c;
    L108:
        if (r17 == 0) goto L110;
        boolean r110 = true;
    L112:
        if (ComposerKt.isTraceInProgress() == false) goto L114;
        ComposerKt.traceEventStart(708270273, r2, -1, "com.larksuite.component.universe_design.menu.compose.UDMenuPopup (UDMenu.kt:184)");
    L114:
        Density r9 = (Density) r13.consume(CompositionLocalsKt.getLocalDensity());
        int r10 = r9.roundToPx-0680j_4(r19);
        float r11 = 16;
        int r12 = r9.roundToPx-0680j_4(Dp.constructor-impl(r11));
        int r20 = r9.roundToPx-0680j_4(Dp.constructor-impl(10));
        int r21 = r9.roundToPx-0680j_4(Dp.constructor-impl(r11));
        int r22 = r9.roundToPx-0680j_4(Dp.constructor-impl(22));
        if (r30 == false) goto L130;
        r13.startReplaceGroup(-1224400529);
        boolean r111 = false;
        if ((r2 & 7168) != 2048) goto L119;
        boolean r1 = true;
    L121:
        if ((57344 & r2) != 16384) goto L123;
        r111 = true;
    L123:
        boolean r23 = (((((r1 | r111) | r13.changed(r10)) | r13.changed(r12)) | r13.changed(r20)) | r13.changed(r21)) | r13.changed(r22);
        Object r24 = r13.rememberedValue();
        if (r23 == false) goto L126;
    L127:
        r24 = new d(r29, r16, r10, r12, r20, r21, r22);
        r13.updateRememberedValue(r24);
    L128:
        r13.endReplaceGroup();
        AndroidPopup_androidKt.Popup((d) r24, r31, new PopupProperties(true, true, r110, false, 8, null), ComposableLambdaKt.rememberComposableLambda(-1821391768, true, new UDMenuKt$UDMenuPopup$2(r0, r37), r13, 54), r13, (r2 & 112) | 3072, 0);
        goto L130
    L126:
        if (r24 != Composer.Companion.getEmpty()) goto L128;
    L119:
        r1 = false;
    L130:
        if (ComposerKt.isTraceInProgress() == false) goto L132;
        ComposerKt.traceEventEnd();
    L132:
        final Modifier r25 = r0;
        final PositionAlign r26 = r16;
        final float r27 = r19;
        final boolean r41 = r110;
        final UDMenuGravity r42 = r29;
    L133:
        ScopeUpdateScope r112 = r13.endRestartGroup();
        if (r112 == null) goto L137;
        r112.updateScope(new UDMenuKt$UDMenuPopup$3(r30, r31, r25, r42, r26, r27, r41, r37, r39, r40));
        return;
    L137:
        return;
    L110:
        r110 = r4;
        goto L112
    L107:
        r19 = r7;
        goto L108
    L104:
        r16 = r34;
        goto L105
    L101:
        r29 = r33;
        goto L102
    L98:
        r0 = r5;
        goto L99
    L93:
        if (r13.getSkipping() == false) goto L96;
        r13.skipToGroupEnd();
        r25 = r5;
        r27 = r7;
        r26 = r34;
        r41 = r4;
        r42 = r33;
        goto L133
    L84:
        if ((r39 & 12582912) != 0) goto L91;
        if (r13.changedInstance(r37) == false) goto L88;
        int r43 = 8388608;
    L89:
        r2 = r2 | r43;
        goto L91
    L88:
        r43 = 4194304;
        goto L89
    L73:
        r4 = r36;
        if ((r39 & 1572864) != 0) goto L81;
        if (r13.changed(r4) == false) goto L78;
        int r113 = 1048576;
    L79:
        r2 = r2 | r113;
        goto L81
    L78:
        r113 = 524288;
        goto L79
    L63:
        r7 = r35;
        if ((r39 & 196608) != 0) goto L70;
        if (r13.changed(r7) == false) goto L68;
        int r114 = 131072;
    L69:
        r2 = r2 | r114;
        goto L70
    L68:
        r114 = 65536;
        goto L69
    L51:
        if ((r39 & 24576) != 0) goto L60;
        if (r34 != null) goto L54;
        int r115 = -1;
    L56:
        if (r13.changed(r115) == false) goto L58;
        int r116 = 16384;
    L59:
        r2 = r2 | r116;
        goto L60
    L58:
        r116 = 8192;
        goto L59
    L54:
        r115 = r34.ordinal();
        goto L56
    L38:
        if ((r39 & 3072) != 0) goto L47;
        if (r33 != null) goto L41;
        int r117 = -1;
    L43:
        if (r13.changed(r117) == false) goto L45;
        int r118 = 2048;
    L46:
        r2 = r2 | r118;
        goto L47
    L45:
        r118 = 1024;
        goto L46
    L41:
        r117 = r33.ordinal();
        goto L43
    L27:
        if ((r39 & 384) != 0) goto L33;
        r5 = r32;
        if (r13.changed(r5) == false) goto L31;
        int r44 = 256;
    L32:
        r2 = r2 | r44;
        goto L34
    L31:
        r44 = 128;
        goto L32
    L17:
        if ((r39 & 48) != 0) goto L23;
        if (r13.changedInstance(r31) == false) goto L21;
        int r45 = 32;
    L22:
        r2 = r2 | r45;
        goto L23
    L21:
        r45 = 16;
        goto L22
    L6:
        if ((r39 & 6) == 0) goto L8;
        r2 = r39;
        goto L14
    L8:
        if (r13.changed(r30) == false) goto L10;
        int r46 = 4;
    L11:
        r2 = r46 | r39;
        goto L14
    L10:
        r46 = 2;
        goto L11
    }
}
