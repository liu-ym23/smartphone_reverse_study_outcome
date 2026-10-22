package com.larksuite.component.universe_design.dialog.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteractionKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
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
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import com.larksuite.component.universe_design.compose.foundation.i0;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UDListPanelDialogKt {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ListPanelSurface.values().length];
            r0[ListPanelSurface.ActionSheet.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[ListPanelSurface.ActionPanel.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            a = r0;
            int[] r1 = new int[UDDialogActionRole.values().length];
            r1[UDDialogActionRole.Primary.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r1[UDDialogActionRole.Danger.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L21:
            r1[UDDialogActionRole.Secondary.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L10:
            b = r1;
        }
    }

    public static final void c(final String r29, Composer r30, final int r31) {
        Composer r14 = r30.startRestartGroup(-1681809798);
        if ((r31 & 6) == 0) goto L5;
        int r15 = r31;
    L11:
        if ((r15 & 3) != 2) goto L17;
        if (r14.getSkipping() == false) goto L17;
        r14.skipToGroupEnd();
        Composer r210 = r14;
    L34:
        ScopeUpdateScope r0 = r210.endRestartGroup();
        if (r0 == null) goto L38;
        r0.updateScope(new UDListPanelDialogKt$ListPanelTitle$2(r29, r31));
        return;
    L38:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(-1681809798, r15, -1, "com.larksuite.component.universe_design.dialog.compose.ListPanelTitle (UDListPanelDialog.kt:205)");
    L19:
        Modifier r1 = PaddingKt.padding-VpY3zN4(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), e.s), e.t, e.u);
        MeasurePolicy r2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), false);
        long r4 = ComposablesKt.getCurrentCompositeKeyHashCode(r14, 0);
        int r5 = (int) (r4 ^ (r4 >>> 32));
        CompositionLocalMap r6 = r14.getCurrentCompositionLocalMap();
        Modifier r3 = ComposedModifierKt.materializeModifier(r14, r1);
        ComposeUiNode.Companion r7 = ComposeUiNode.Companion;
        Function0 r8 = r7.getConstructor();
        if ((r14.getApplier() instanceof Applier) == true) goto L22;
        ComposablesKt.invalidApplier();
    L22:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L25;
        r14.createNode(r8);
    L26:
        Composer r9 = Updater.constructor-impl(r14);
        Updater.set-impl(r9, r2, r7.getSetMeasurePolicy());
        Updater.set-impl(r9, r6, r7.getSetResolvedCompositionLocals());
        Function2 r10 = r7.getSetCompositeKeyHash();
        if (r9.getInserting() == false) goto L29;
    L30:
        r9.updateRememberedValue(Integer.valueOf(r5));
        r9.apply(Integer.valueOf(r5), r10);
    L31:
        Updater.set-impl(r9, r3, r7.getSetModifier());
        BoxScopeInstance r11 = BoxScopeInstance.INSTANCE;
        long r12 = i0.a(r14).d.f.c;
        TextStyle r13 = i0.b(r14).d;
        int r16 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
        r210 = r14;
        TextKt.Text-Nvy7gAk(r29, null, r12, null, 0, null, null, null, 0, null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0, r16, false, 1, 0, null, r13, r210, r15 & 14, 24960, 109562);
        r210.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventEnd();
        goto L34
    L29:
        if (Intrinsics.areEqual(r9.rememberedValue(), Integer.valueOf(r5)) == true) goto L31;
    L25:
        r14.useNode();
        goto L26
    L5:
        if (r14.changed(r29) == false) goto L7;
        int r17 = 4;
    L8:
        r15 = r17 | r31;
        goto L11
    L7:
        r17 = 2;
        goto L8
    }

    public static final void a(final b r25, final Function0<Unit> r26, Modifier r27, Composer r29, final int r210, final int r30) {
        Composer r2 = r29.startRestartGroup(1314185863);
        if ((r30 & 1) == 0) goto L6;
        int r3 = r210 | 6;
    L14:
        if ((r30 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L23:
        int r5 = r30 & 4;
        if (r5 == 0) goto L27;
        r3 = r3 | 384;
    L33:
        Modifier r6 = r27;
    L35:
        if ((r3 & 147) == 146) goto L37;
    L40:
        if (r5 == 0) goto L42;
        Modifier r15 = Modifier.Companion;
    L44:
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventStart(1314185863, r3, -1, "com.larksuite.component.universe_design.dialog.compose.ListPanelCancelButton (UDListPanelDialog.kt:273)");
    L46:
        b(new d(r25.a, r25.b, r25.c, r25.d, r25.e, Color.box-impl(i0.a(r2).d.h.a), Color.box-impl(i0.a(r2).b.a.b), Dp.box-impl(e.y)), r26, r15, i0.a(r2).d.h.a, Dp.constructor-impl(0), r2, ((r3 & 112) | 24576) | (r3 & 896), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L49;
        ComposerKt.traceEventEnd();
    L49:
        final Modifier r4 = r15;
    L50:
        ScopeUpdateScope r7 = r2.endRestartGroup();
        if (r7 == null) goto L54;
        r7.updateScope(new UDListPanelDialogKt$ListPanelCancelButton$1(r25, r26, r4, r210, r30));
        return;
    L54:
        return;
    L42:
        r15 = r6;
        goto L44
    L37:
        if (r2.getSkipping() == false) goto L40;
        r2.skipToGroupEnd();
        r4 = r6;
        goto L50
    L27:
        if ((r210 & 384) != 0) goto L33;
        r6 = r27;
        if (r2.changed(r6) == false) goto L31;
        int r8 = 256;
    L32:
        r3 = r3 | r8;
        goto L35
    L31:
        r8 = 128;
        goto L32
    L17:
        if ((r210 & 48) != 0) goto L23;
        if (r2.changedInstance(r26) == false) goto L21;
        int r9 = 32;
    L22:
        r3 = r3 | r9;
        goto L23
    L21:
        r9 = 16;
        goto L22
    L6:
        if ((r210 & 6) == 0) goto L8;
        r3 = r210;
        goto L14
    L8:
        if (r2.changed(r25) == false) goto L10;
        int r10 = 4;
    L11:
        r3 = r10 | r210;
        goto L14
    L10:
        r10 = 2;
        goto L11
    }

    public static final void b(final d r36, final Function0<Unit> r37, Modifier r38, long r39, float r41, Composer r42, final int r43, final int r44) {
        Composer r3 = r42.startRestartGroup(-1392569648);
        if ((r44 & 1) == 0) goto L6;
        int r4 = r43 | 6;
    L14:
        if ((r44 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L23:
        int r8 = r44 & 4;
        if (r8 == 0) goto L27;
        r4 = r4 | 384;
    L33:
        Modifier r10 = r38;
    L35:
        if ((r43 & 3072) == 0) goto L37;
        long r11 = r39;
    L45:
        int r13 = r44 & 16;
        if (r13 == 0) goto L49;
        r4 = r4 | 24576;
    L55:
        float r14 = r41;
    L57:
        if ((r4 & 9363) == 9362) goto L59;
    L62:
        r3.startDefaults();
        if ((r43 & 1) != 0) goto L65;
    L70:
        if (r8 == 0) goto L73;
        r10 = Modifier.Companion;
    L73:
        if ((r44 & 8) == 0) goto L75;
        r11 = i0.a(r3).d.h.a;
        r4 = r4 & (-7169);
    L75:
        if (r13 == 0) goto L77;
        final float r6 = e.w;
        int r9 = r4;
        Modifier r5 = r10;
        long r34 = r11;
    L78:
        r3.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L81;
        ComposerKt.traceEventStart(-1392569648, r9, -1, "com.larksuite.component.universe_design.dialog.compose.ListPanelItem (UDListPanelDialog.kt:231)");
    L81:
        r3.startReplaceGroup(1849434622);
        Object r0 = r3.rememberedValue();
        Composer.Companion r12 = Composer.Companion;
        if (r0 != r12.getEmpty()) goto L84;
        r0 = InteractionSourceKt.MutableInteractionSource();
        r3.updateRememberedValue(r0);
    L84:
        MutableInteractionSource r15 = (MutableInteractionSource) r0;
        r3.endReplaceGroup();
        State r1 = PressInteractionKt.collectIsPressedAsState(r15, r3, 6);
        Color r16 = r36.g;
        if (r16 == null) goto L87;
        long r17 = r16.unbox-impl();
    L88:
        Color r19 = r36.h;
        r3.startReplaceGroup(1770380271);
        if (r19 != null) goto L91;
        long r110 = i0.a(r3).b.a.b;
    L92:
        r3.endReplaceGroup();
        Dp r111 = r36.i;
        Modifier r112 = Modifier.Companion;
        if (r111 == null) goto L95;
        Modifier r113 = SizeKt.height-3ABfNKs(r112, r111.unbox-impl());
    L96:
        Modifier r7 = BackgroundKt.background-bw27NRU$default(r5.then(r113), r17, null, 2, null);
        if (((Boolean) r1.getValue()).booleanValue() == true) goto L99;
    L101:
        Modifier r114 = r7.then(r112);
        boolean r115 = r36.d;
        Role r116 = Role.box-impl(Role.Companion.getButton-o7Vup1c());
        r3.startReplaceGroup(-1633490746);
        if ((r9 & 14) != 4) goto L104;
        boolean r2 = true;
    L106:
        if ((r9 & 112) != 32) goto L108;
        boolean r20 = true;
    L109:
        boolean r21 = r2 | r20;
        Object r22 = r3.rememberedValue();
        if (r21 == false) goto L112;
    L113:
        r22 = new UDListPanelDialogKt$ListPanelItem$1$1(r36, r37);
        r3.updateRememberedValue(r22);
    L114:
        r3.endReplaceGroup();
        Modifier r23 = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-O2vRcR0$default(r114, r15, null, r115, null, r116, (Function0) r22, 8, null), e.t, r6);
        MeasurePolicy r24 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), false);
        long r117 = ComposablesKt.getCurrentCompositeKeyHashCode(r3, 0);
        int r25 = (int) (r117 ^ (r117 >>> 32));
        CompositionLocalMap r118 = r3.getCurrentCompositionLocalMap();
        Modifier r26 = ComposedModifierKt.materializeModifier(r3, r23);
        ComposeUiNode.Companion r119 = ComposeUiNode.Companion;
        Function0 r120 = r119.getConstructor();
        if ((r3.getApplier() instanceof Applier) == true) goto L117;
        ComposablesKt.invalidApplier();
    L117:
        r3.startReusableNode();
        if (r3.getInserting() == false) goto L120;
        r3.createNode(r120);
    L121:
        Composer r121 = Updater.constructor-impl(r3);
        Updater.set-impl(r121, r24, r119.getSetMeasurePolicy());
        Updater.set-impl(r121, r118, r119.getSetResolvedCompositionLocals());
        Function2 r27 = r119.getSetCompositeKeyHash();
        if (r121.getInserting() == false) goto L124;
    L125:
        r121.updateRememberedValue(Integer.valueOf(r25));
        r121.apply(Integer.valueOf(r25), r27);
    L126:
        Updater.set-impl(r121, r26, r119.getSetModifier());
        BoxScopeInstance r29 = BoxScopeInstance.INSTANCE;
        String r30 = r36.a;
        if (r36.d == false) goto L149;
        r3.startReplaceGroup(704883053);
        Color r31 = r36.f;
        if (r31 != null) goto L148;
        UDDialogActionRole r32 = r36.c;
        r3.startReplaceGroup(-1908137081);
        if (ComposerKt.isTraceInProgress() == false) goto L133;
        ComposerKt.traceEventStart(-1908137081, 0, -1, "com.larksuite.component.universe_design.dialog.compose.listTextColor (UDListPanelDialog.kt:294)");
    L133:
        int r33 = a.b[r32.ordinal()];
        if (r33 != 1) goto L136;
        r3.startReplaceGroup(231305406);
        long r35 = i0.a(r3).a();
        r3.endReplaceGroup();
    L145:
        if (ComposerKt.isTraceInProgress() == false) goto L147;
        ComposerKt.traceEventEnd();
    L147:
        r3.endReplaceGroup();
    L150:
        long r122 = r35;
        r3.endReplaceGroup();
        TextStyle r40 = r36.j;
        r3.startReplaceGroup(-2055468395);
        if (r40 != null) goto L153;
        r40 = i0.b(r3).a;
    L153:
        TextStyle r210 = r40;
        r3.endReplaceGroup();
        int r211 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
        TextKt.Text-Nvy7gAk(r30, null, r122, null, 0, null, null, null, 0, null, TextAlign.box-impl(r36.k), 0, r211, false, 1, 0, null, r210, r3, 0, 24960, 109562);
        r3.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L156;
        ComposerKt.traceEventEnd();
    L156:
        r10 = r5;
        final long r45 = r34;
    L157:
        ScopeUpdateScope r46 = r3.endRestartGroup();
        if (r46 == null) goto L161;
        final Modifier r47 = r10;
        r46.updateScope(new UDListPanelDialogKt$ListPanelItem$3(r36, r37, r47, r45, r6, r43, r44));
        return;
    L161:
        return;
    L136:
        if (r33 != 2) goto L138;
        r3.startReplaceGroup(231308006);
        r35 = i0.a(r3).d.c.a;
        r3.endReplaceGroup();
        goto L145
    L138:
        if (r33 != 3) goto L140;
        r3.startReplaceGroup(231310929);
        r35 = i0.a(r3).b();
        r3.endReplaceGroup();
        goto L145
    L140:
        r3.startReplaceGroup(231303340);
        r3.endReplaceGroup();
        throw new NoWhenBranchMatchedException();
    L148:
        r35 = r31.unbox-impl();
        goto L150
    L149:
        r3.startReplaceGroup(-2055469638);
        r35 = i0.a(r3).d.f.c;
        goto L150
    L124:
        if (Intrinsics.areEqual(r121.rememberedValue(), Integer.valueOf(r25)) == true) goto L126;
    L120:
        r3.useNode();
        goto L121
    L112:
        if (r22 != r12.getEmpty()) goto L114;
    L108:
        r20 = false;
        goto L109
    L104:
        r2 = false;
        goto L106
    L99:
        if (r36.d == false) goto L101;
        r112 = BackgroundKt.background-bw27NRU$default(r112, r110, null, 2, null);
        goto L101
    L95:
        r113 = SizeKt.defaultMinSize-VpY3zN4$default(r112, 0.0f, e.v, 1, null);
        goto L96
    L91:
        r110 = r19.unbox-impl();
        goto L92
    L87:
        r17 = r34;
    L77:
        r9 = r4;
        r5 = r10;
        r34 = r11;
        r6 = r14;
        goto L78
    L65:
        if (r3.getDefaultsInvalid() == true) goto L70;
        r3.skipToGroupEnd();
        if ((r44 & 8) == 0) goto L77;
        r4 = r4 & (-7169);
        goto L77
    L59:
        if (r3.getSkipping() == false) goto L62;
        r3.skipToGroupEnd();
        r45 = r11;
        r6 = r14;
        goto L157
    L49:
        if ((r43 & 24576) != 0) goto L55;
        r14 = r41;
        if (r3.changed(r14) == false) goto L53;
        int r123 = 16384;
    L54:
        r4 = r4 | r123;
        goto L57
    L53:
        r123 = 8192;
        goto L54
    L37:
        if ((r44 & 8) != 0) goto L41;
        r11 = r39;
        if (r3.changed(r11) == false) goto L42;
        int r124 = 2048;
    L43:
        r4 = r4 | r124;
    L42:
        r124 = 1024;
        goto L43
    L41:
        r11 = r39;
        goto L42
    L27:
        if ((r43 & 384) != 0) goto L33;
        r10 = r38;
        if (r3.changed(r10) == false) goto L31;
        int r125 = 256;
    L32:
        r4 = r4 | r125;
        goto L35
    L31:
        r125 = 128;
        goto L32
    L17:
        if ((r43 & 48) != 0) goto L23;
        if (r3.changedInstance(r37) == false) goto L21;
        int r48 = 32;
    L22:
        r4 = r4 | r48;
        goto L23
    L21:
        r48 = 16;
        goto L22
    L6:
        if ((r43 & 6) == 0) goto L8;
        r4 = r43;
        goto L14
    L8:
        if (r3.changed(r36) == false) goto L10;
        int r49 = 4;
    L11:
        r4 = r49 | r43;
        goto L14
    L10:
        r49 = 2;
        goto L11
    }

    public static final void e(final String r38, final List r39, final b r40, final Function0 r41, final Dp r42, final boolean r43, final ListPanelSurface r44, Modifier r45, Composer r46, final int r47, final int r48) {
        Composer r5 = r46.startRestartGroup(-260289486);
        if ((r48 & 1) == 0) goto L6;
        int r4 = r47 | 6;
    L14:
        if ((r48 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L24:
        if ((r48 & 4) == 0) goto L27;
        r4 = r4 | 384;
    L34:
        if ((r48 & 8) == 0) goto L37;
        r4 = r4 | 3072;
    L44:
        if ((r48 & 16) == 0) goto L47;
        r4 = r4 | 24576;
    L54:
        if ((r48 & 32) == 0) goto L57;
        r4 = r4 | 196608;
    L65:
        if ((r48 & 64) == 0) goto L68;
        r4 = r4 | 1572864;
    L74:
        int r14 = r48 & 128;
        if (r14 == 0) goto L78;
        r4 = r4 | 12582912;
    L84:
        Modifier r15 = r45;
    L86:
        if ((r4 & 4793491) == 4793490) goto L88;
    L91:
        if (r14 == 0) goto L93;
        Modifier r13 = Modifier.Companion;
    L95:
        if (ComposerKt.isTraceInProgress() == false) goto L97;
        ComposerKt.traceEventStart(-260289486, r4, -1, "com.larksuite.component.universe_design.dialog.compose.ListPanelContent (UDListPanelDialog.kt:138)");
    L97:
        float r3 = ((Density) r5.consume(CompositionLocalsKt.getLocalDensity())).toPx-0680j_4(e.B);
        r5.startReplaceGroup(1849434622);
        Object r12 = r5.rememberedValue();
        Composer.Companion r16 = Composer.Companion;
        if (r12 != r16.getEmpty()) goto L100;
        int r17 = 2;
        r12 = SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
        r5.updateRememberedValue(r12);
    L101:
        final MutableState r19 = (MutableState) r12;
        r5.endReplaceGroup();
        int[] r110 = a.a;
        int r6 = r110[r44.ordinal()];
        if (r6 == 1) goto L107;
        if (r6 != r17) goto L106;
        RoundedCornerShape r7 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(e.z);
    L108:
        int r111 = r110[r44.ordinal()];
        if (r111 != 1) goto L111;
        r5.startReplaceGroup(-1030065767);
        long r10 = i0.a(r5).d.h.a;
        r5.endReplaceGroup();
    L116:
        Arrangement r25 = Arrangement.INSTANCE;
        Arrangement.Vertical r8 = r25.getTop();
        Alignment.Companion r26 = Alignment.Companion;
        int r112 = ((r4 >> 21) & 14) >> 3;
        MeasurePolicy r9 = ColumnKt.columnMeasurePolicy(r8, r26.getStart(), r5, (r112 & 14) | (r112 & 112));
        long r113 = ComposablesKt.getCurrentCompositeKeyHashCode(r5, 0);
        long r27 = r10;
        int r11 = (int) (r113 ^ (r113 >>> 32));
        CompositionLocalMap r20 = r5.getCurrentCompositionLocalMap();
        Modifier r114 = ComposedModifierKt.materializeModifier(r5, r13);
        ComposeUiNode.Companion r29 = ComposeUiNode.Companion;
        Function0 r115 = r29.getConstructor();
        Modifier r30 = r13;
        if ((r5.getApplier() instanceof Applier) == true) goto L119;
        ComposablesKt.invalidApplier();
    L119:
        r5.startReusableNode();
        if (r5.getInserting() == false) goto L122;
        r5.createNode(r115);
    L123:
        Composer r116 = Updater.constructor-impl(r5);
        Updater.set-impl(r116, r9, r29.getSetMeasurePolicy());
        Updater.set-impl(r116, r20, r29.getSetResolvedCompositionLocals());
        Function2 r21 = r29.getSetCompositeKeyHash();
        if (r116.getInserting() == false) goto L126;
    L127:
        r116.updateRememberedValue(Integer.valueOf(r11));
        r116.apply(Integer.valueOf(r11), r21);
    L128:
        Updater.set-impl(r116, r114, r29.getSetModifier());
        ColumnScopeInstance r22 = ColumnScopeInstance.INSTANCE;
        Modifier r23 = Modifier.Companion;
        Modifier r117 = SizeKt.fillMaxWidth$default(r23, 0.0f, 1, null);
        if (r42 == null) goto L131;
        r23 = SizeKt.heightIn-VpY3zN4$default(r23, 0.0f, r42.unbox-impl(), 1, null);
    L131:
        Modifier r24 = r117.then(r23);
        Orientation r118 = Orientation.Vertical;
        r5.startReplaceGroup(5004770);
        Object r31 = r5.rememberedValue();
        if (r31 != r16.getEmpty()) goto L134;
        r31 = new UDListPanelDialogKt$ListPanelContent$1$1$1(r19);
        r5.updateRememberedValue(r31);
    L134:
        r5.endReplaceGroup();
        DraggableState r119 = DraggableKt.rememberDraggableState((Function1) r31, r5, 6);
        r5.startReplaceGroup(-1746271574);
        boolean r32 = r5.changed(r3);
        if ((r4 & 7168) != 2048) goto L137;
        boolean r120 = true;
    L138:
        boolean r33 = r32 | r120;
        Object r121 = r5.rememberedValue();
        if (r33 == false) goto L141;
    L142:
        r121 = new UDListPanelDialogKt$ListPanelContent$1$2$1(r3, r41, r19, null);
        r5.updateRememberedValue(r121);
    L143:
        r5.endReplaceGroup();
        Modifier r34 = ScrollKt.verticalScroll$default(BackgroundKt.background-bw27NRU$default(ClipKt.clip(DraggableKt.draggable$default(r24, r119, r118, r43, null, false, null, (Function3) r121, false, 184, null), r7), r27, null, 2, null), ScrollKt.rememberScrollState(0, r5, 0, 1), false, null, false, 14, null);
        int r35 = 0;
        MeasurePolicy r36 = ColumnKt.columnMeasurePolicy(r25.getTop(), r26.getStart(), r5, 0);
        long r122 = ComposablesKt.getCurrentCompositeKeyHashCode(r5, 0);
        int r37 = (int) (r122 ^ (r122 >>> 32));
        CompositionLocalMap r123 = r5.getCurrentCompositionLocalMap();
        Modifier r49 = ComposedModifierKt.materializeModifier(r5, r34);
        Function0 r124 = r29.getConstructor();
        if ((r5.getApplier() instanceof Applier) == true) goto L146;
        ComposablesKt.invalidApplier();
    L146:
        r5.startReusableNode();
        if (r5.getInserting() == false) goto L149;
        r5.createNode(r124);
    L150:
        Composer r125 = Updater.constructor-impl(r5);
        Updater.set-impl(r125, r36, r29.getSetMeasurePolicy());
        Updater.set-impl(r125, r123, r29.getSetResolvedCompositionLocals());
        Function2 r50 = r29.getSetCompositeKeyHash();
        if (r125.getInserting() == false) goto L153;
    L154:
        r125.updateRememberedValue(Integer.valueOf(r37));
        r125.apply(Integer.valueOf(r37), r50);
    L155:
        Updater.set-impl(r125, r49, r29.getSetModifier());
        r5.startReplaceGroup(-33672310);
        if (r38 != null) goto L158;
    L161:
        boolean r51 = true;
    L162:
        if (r51 == true) goto L164;
        c(r38, r5, r4 & 14);
        UDDialogKt.e(true, r5, 6);
    L164:
        r5.endReplaceGroup();
        r5.startReplaceGroup(-33667259);
        Iterator r52 = r39.iterator();
    L166:
        if (r52.hasNext() == false) goto L175;
        Object r53 = r52.next();
        int r54 = r35 + 1;
        if (r35 >= 0) goto L170;
        CollectionsKt.throwIndexOverflow();
    L170:
        Modifier r210 = r30;
        b((d) r53, r41, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), 0, 0.0f, r5, ((r4 >> 6) & 112) | 384, 24);
        r5.startReplaceGroup(-33659771);
        if (r35 >= CollectionsKt.getLastIndex(r39)) goto L174;
        UDDialogKt.e(true, r5, 6);
    L174:
        r5.endReplaceGroup();
        r35 = r54;
        r30 = r210;
        goto L166
    L175:
        Modifier r211 = r30;
        r5.endReplaceGroup();
        r5.endNode();
        r5.startReplaceGroup(-724080629);
        if (r40 == null) goto L178;
        Modifier.Companion r55 = Modifier.Companion;
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(r55, e.x), r5, 6);
        Modifier r56 = ClipKt.clip(TestTagKt.testTag(SizeKt.fillMaxWidth$default(r55, 0.0f, 1, null), "UDListPanelCancel"), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(e.z));
        int r57 = r4 >> 6;
        Composer r126 = r5;
        a(r40, r41, r56, r126, (r57 & 14) | (r57 & 112), 0);
    L179:
        r126.endReplaceGroup();
        r126.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L182;
        ComposerKt.traceEventEnd();
    L182:
        final Modifier r59 = r211;
    L183:
        ScopeUpdateScope r127 = r126.endRestartGroup();
        if (r127 == null) goto L190;
        r127.updateScope(new UDListPanelDialogKt$ListPanelContent$2(r38, r39, r40, r41, r42, r43, r44, r59, r47, r48));
        return;
    L190:
        return;
    L178:
        r126 = r5;
        goto L179
    L158:
        if (r38.length() == 0) goto L161;
        r51 = false;
        goto L162
    L153:
        if (Intrinsics.areEqual(r125.rememberedValue(), Integer.valueOf(r37)) == true) goto L155;
    L149:
        r5.useNode();
        goto L150
    L141:
        if (r121 != r16.getEmpty()) goto L143;
    L137:
        r120 = false;
        goto L138
    L126:
        if (Intrinsics.areEqual(r116.rememberedValue(), Integer.valueOf(r11)) == true) goto L128;
    L122:
        r5.useNode();
        goto L123
    L111:
        if (r111 != 2) goto L113;
        r5.startReplaceGroup(-1030063591);
        r10 = i0.a(r5).d.h.a;
        r5.endReplaceGroup();
        goto L116
    L113:
        r5.startReplaceGroup(-1030068204);
        r5.endReplaceGroup();
        throw new NoWhenBranchMatchedException();
    L106:
        throw new NoWhenBranchMatchedException();
    L107:
        float r128 = e.A;
        r7 = RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(r128, r128, 0.0f, 0.0f, 12, null);
        goto L108
    L100:
        r17 = 2;
        goto L101
    L93:
        r13 = r15;
        goto L95
    L88:
        if (r5.getSkipping() == false) goto L91;
        r5.skipToGroupEnd();
        r126 = r5;
        r59 = r15;
        goto L183
    L78:
        if ((12582912 & r47) != 0) goto L84;
        r15 = r45;
        if (r5.changed(r15) == false) goto L82;
        int r129 = 8388608;
    L83:
        r4 = r4 | r129;
        goto L86
    L82:
        r129 = 4194304;
        goto L83
    L68:
        if ((r47 & 1572864) != 0) goto L74;
        if (r5.changed(r44.ordinal()) == false) goto L72;
        int r130 = 1048576;
    L73:
        r4 = r4 | r130;
        goto L74
    L72:
        r130 = 524288;
        goto L73
    L57:
        if ((r47 & 196608) != 0) goto L65;
        if (r5.changed(r43) == false) goto L61;
        int r131 = 131072;
    L62:
        r4 = r4 | r131;
        goto L65
    L61:
        r131 = 65536;
        goto L62
    L47:
        if ((r47 & 24576) != 0) goto L54;
        if (r5.changed(r42) == false) goto L51;
        int r132 = 16384;
    L52:
        r4 = r4 | r132;
        goto L54
    L51:
        r132 = 8192;
        goto L52
    L37:
        if ((r47 & 3072) != 0) goto L44;
        if (r5.changedInstance(r41) == false) goto L41;
        int r133 = 2048;
    L42:
        r4 = r4 | r133;
        goto L44
    L41:
        r133 = 1024;
        goto L42
    L27:
        if ((r47 & 384) != 0) goto L34;
        if (r5.changed(r40) == false) goto L31;
        int r134 = 256;
    L32:
        r4 = r4 | r134;
        goto L34
    L31:
        r134 = 128;
        goto L32
    L17:
        if ((r47 & 48) != 0) goto L24;
        if (r5.changedInstance(r39) == false) goto L21;
        int r135 = 32;
    L22:
        r4 = r4 | r135;
        goto L24
    L21:
        r135 = 16;
        goto L22
    L6:
        if ((r47 & 6) == 0) goto L8;
        r4 = r47;
        goto L14
    L8:
        if (r5.changed(r38) == false) goto L10;
        int r60 = 4;
    L11:
        r4 = r60 | r47;
        goto L14
    L10:
        r60 = 2;
        goto L11
    }

    public static final void d(final boolean r29, final Function0<Unit> r30, final List<d> r31, final Modifier r32, final String r33, final b r34, final float r35, final boolean r36, final boolean r37, boolean r38, Dp r39, Composer r40, final int r41, final int r42, final int r43) {
        Intrinsics.checkNotNullParameter(r30, "onDismissRequest");
        Intrinsics.checkNotNullParameter(r31, "items");
        Intrinsics.checkNotNullParameter(r32, "modifier");
        Composer r10 = r40.startRestartGroup(-2146011937);
        if ((r43 & 1) == 0) goto L6;
        int r2 = r41 | 6;
    L14:
        if ((r43 & 2) == 0) goto L17;
        r2 = r2 | 48;
    L24:
        if ((r43 & 4) == 0) goto L27;
        r2 = r2 | 384;
    L34:
        if ((r43 & 8) == 0) goto L37;
        r2 = r2 | 3072;
    L44:
        if ((r43 & 16) == 0) goto L47;
        r2 = r2 | 24576;
    L54:
        if ((r43 & 32) == 0) goto L57;
        r2 = r2 | 196608;
    L64:
        if ((r43 & 64) == 0) goto L67;
        r2 = r2 | 1572864;
    L74:
        if ((r43 & 128) == 0) goto L77;
        r2 = r2 | 12582912;
    L84:
        if ((r43 & 256) == 0) goto L87;
        r2 = r2 | 100663296;
    L94:
        int r3 = r43 & 512;
        if (r3 == 0) goto L98;
        r2 = r2 | 805306368;
    L104:
        int r4 = r43 & 1024;
        if (r4 == 0) goto L109;
        int r19 = r42 | 6;
    L107:
        int r0 = r19;
    L117:
        if ((r2 & 306783379) != 306783378) goto L125;
        if ((r0 & 3) != 2) goto L125;
        if (r10.getSkipping() == false) goto L125;
        r10.skipToGroupEnd();
        final Dp r11 = r39;
        Composer r1 = r10;
        final boolean r12 = r38;
    L150:
        ScopeUpdateScope r13 = r1.endRestartGroup();
        if (r13 == null) goto L155;
        r13.updateScope(new UDListPanelDialogKt$UDListPanelDialog$3(r29, r30, r31, r32, r33, r34, r35, r36, r37, r12, r11, r41, r42, r43));
        return;
    L155:
        return;
    L125:
        if (r3 == 0) goto L127;
        boolean r25 = false;
    L128:
        if (r4 == 0) goto L130;
        Dp r26 = null;
    L132:
        if (ComposerKt.isTraceInProgress() == false) goto L134;
        ComposerKt.traceEventStart(-2146011937, r2, r0, "com.larksuite.component.universe_design.dialog.compose.UDListPanelDialog (UDListPanelDialog.kt:61)");
    L134:
        if (r29 == false) goto L136;
        final boolean r5 = DarkThemeKt.isSystemInDarkTheme(r10, 0);
        if (r5 == false) goto L145;
        final float r6 = 0.7f;
    L146:
        r1 = r10;
        final Dp r14 = r26;
        final boolean r15 = r25;
        AndroidDialog_androidKt.Dialog(r30, new DialogProperties(r36, r37, null, false, true, null, 36, null), ComposableLambdaKt.rememberComposableLambda(-250067402, true, new UDListPanelDialogKt$UDListPanelDialog$2(r6, r5, r35, r33, r31, r34, r30, r14, r15, r32), r1, 54), r1, ((r2 >> 3) & 14) | 384, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L149;
        ComposerKt.traceEventEnd();
    L149:
        r12 = r25;
        r11 = r26;
        goto L150
    L145:
        r6 = 0.55f;
        goto L146
    L136:
        if (ComposerKt.isTraceInProgress() == false) goto L138;
        ComposerKt.traceEventEnd();
    L138:
        ScopeUpdateScope r16 = r10.endRestartGroup();
        if (r16 == null) goto L154;
        final boolean r17 = r25;
        final Dp r110 = r26;
        r16.updateScope(new UDListPanelDialogKt$UDListPanelDialog$1(r29, r30, r31, r32, r33, r34, r35, r36, r37, r17, r110, r41, r42, r43));
        return;
    L154:
        return;
    L130:
        r26 = r39;
        goto L132
    L127:
        r25 = r38;
        goto L128
    L109:
        if ((r42 & 6) == 0) goto L111;
        r0 = r42;
        goto L117
    L111:
        if (r10.changed(r39) == false) goto L113;
        int r111 = 4;
    L114:
        r19 = r42 | r111;
        goto L107
    L113:
        r111 = 2;
        goto L114
    L98:
        if ((r41 & 805306368) != 0) goto L104;
        if (r10.changed(r38) == false) goto L102;
        int r112 = 536870912;
    L103:
        r2 = r2 | r112;
        goto L104
    L102:
        r112 = 268435456;
        goto L103
    L87:
        if ((r41 & 100663296) != 0) goto L94;
        if (r10.changed(r37) == false) goto L91;
        int r113 = 67108864;
    L92:
        r2 = r2 | r113;
        goto L94
    L91:
        r113 = 33554432;
        goto L92
    L77:
        if ((r41 & 12582912) != 0) goto L84;
        if (r10.changed(r36) == false) goto L81;
        int r7 = 8388608;
    L82:
        r2 = r2 | r7;
        goto L84
    L81:
        r7 = 4194304;
        goto L82
    L67:
        if ((r41 & 1572864) != 0) goto L74;
        if (r10.changed(r35) == false) goto L71;
        int r8 = 1048576;
    L72:
        r2 = r2 | r8;
        goto L74
    L71:
        r8 = 524288;
        goto L72
    L57:
        if ((r41 & 196608) != 0) goto L64;
        if (r10.changed(r34) == false) goto L61;
        int r9 = 131072;
    L62:
        r2 = r2 | r9;
        goto L64
    L61:
        r9 = 65536;
        goto L62
    L47:
        if ((r41 & 24576) != 0) goto L54;
        if (r10.changed(r33) == false) goto L51;
        int r20 = 16384;
    L52:
        r2 = r2 | r20;
        goto L54
    L51:
        r20 = 8192;
        goto L52
    L37:
        if ((r41 & 3072) != 0) goto L44;
        if (r10.changed(r32) == false) goto L41;
        int r21 = 2048;
    L42:
        r2 = r2 | r21;
        goto L44
    L41:
        r21 = 1024;
        goto L42
    L27:
        if ((r41 & 384) != 0) goto L34;
        if (r10.changedInstance(r31) == false) goto L31;
        int r22 = 256;
    L32:
        r2 = r2 | r22;
        goto L34
    L31:
        r22 = 128;
        goto L32
    L17:
        if ((r41 & 48) != 0) goto L24;
        if (r10.changedInstance(r30) == false) goto L21;
        int r23 = 32;
    L22:
        r2 = r2 | r23;
        goto L24
    L21:
        r23 = 16;
        goto L22
    L6:
        if ((r41 & 6) == 0) goto L8;
        r2 = r41;
        goto L14
    L8:
        if (r10.changed(r29) == false) goto L10;
        int r24 = 4;
    L11:
        r2 = r24 | r41;
        goto L14
    L10:
        r24 = 2;
        goto L11
    }
}
