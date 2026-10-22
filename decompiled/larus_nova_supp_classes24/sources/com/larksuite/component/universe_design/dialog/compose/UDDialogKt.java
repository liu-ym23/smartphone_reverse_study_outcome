package com.larksuite.component.universe_design.dialog.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteractionKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextOverflow;
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
public final class UDDialogKt {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[UDDialogActionRole.values().length];
            r0[UDDialogActionRole.Primary.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[UDDialogActionRole.Danger.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[UDDialogActionRole.Secondary.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final void d(final String r33, Composer r34, final int r35) {
        Composer r13 = r34.startRestartGroup(68081920);
        if ((r35 & 6) == 0) goto L5;
        int r1 = r35;
    L11:
        if ((r1 & 3) != 2) goto L17;
        if (r13.getSkipping() == false) goto L17;
        r13.skipToGroupEnd();
        Composer r32 = r13;
    L28:
        ScopeUpdateScope r0 = r32.endRestartGroup();
        if (r0 == null) goto L32;
        r0.updateScope(new UDDialogKt$DialogTitle$2(r33, r35));
        return;
    L32:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(68081920, r1, -1, "com.larksuite.component.universe_design.dialog.compose.DialogTitle (UDDialog.kt:191)");
    L19:
        r13.startReplaceGroup(1849434622);
        Object r2 = r13.rememberedValue();
        Composer.Companion r3 = Composer.Companion;
        if (r2 != r3.getEmpty()) goto L22;
        r2 = SnapshotStateKt.mutableStateOf$default(TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), null, 2, null);
        r13.updateRememberedValue(r2);
    L22:
        final MutableState r4 = (MutableState) r2;
        r13.endReplaceGroup();
        Modifier r5 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null);
        float r6 = e.d;
        Modifier r7 = PaddingKt.padding-qDBjuR0(r5, r6, e.e, r6, e.f);
        long r8 = i0.a(r13).b();
        TextStyle r12 = i0.b(r13).b;
        int r9 = ((TextAlign) r4.getValue()).unbox-impl();
        int r16 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
        TextAlign r22 = TextAlign.box-impl(r9);
        r13.startReplaceGroup(5004770);
        Object r10 = r13.rememberedValue();
        if (r10 != r3.getEmpty()) goto L25;
        r10 = new UDDialogKt$DialogTitle$1$1(r4);
        r13.updateRememberedValue(r10);
    L25:
        r13.endReplaceGroup();
        r32 = r13;
        TextKt.Text-Nvy7gAk(r33, r7, r8, null, 0, null, null, null, 0, null, r22, 0, r16, false, 2, 0, (Function1) r10, r12, r32, (r1 & 14) | 48, 1597824, 44024);
        if (ComposerKt.isTraceInProgress() == false) goto L28;
        ComposerKt.traceEventEnd();
        goto L28
    L5:
        if (r13.changed(r33) == false) goto L7;
        int r11 = 4;
    L8:
        r1 = r11 | r35;
        goto L11
    L7:
        r11 = 2;
        goto L8
    }

    public static final void e(final boolean r7, Composer r8, final int r9) {
        Composer r10 = r8.startRestartGroup(-1159218036);
        if ((r9 & 6) == 0) goto L5;
        int r1 = r9;
    L11:
        if ((r1 & 3) != 2) goto L17;
        if (r10.getSkipping() == false) goto L17;
        r10.skipToGroupEnd();
    L26:
        ScopeUpdateScope r11 = r10.endRestartGroup();
        if (r11 == null) goto L30;
        r11.updateScope(new UDDialogKt$Divider$1(r7, r9));
        return;
    L30:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L20;
        ComposerKt.traceEventStart(-1159218036, r1, -1, "com.larksuite.component.universe_design.dialog.compose.Divider (UDDialog.kt:366)");
    L20:
        if (r7 == false) goto L22;
        Modifier r0 = SizeKt.defaultMinSize-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), 0.0f, e.l, 1, null);
    L23:
        BoxKt.Box(BackgroundKt.background-bw27NRU$default(r0, i0.a(r10).d.g.a, null, 2, null), r10, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventEnd();
        goto L26
    L22:
        r0 = SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(Modifier.Companion, e.l), 0.0f, 1, null);
        goto L23
    L5:
        if (r10.changed(r7) == false) goto L7;
        int r2 = 4;
    L8:
        r1 = r2 | r9;
        goto L11
    L7:
        r2 = 2;
        goto L8
    }

    public static final void c(final String r34, final float r35, Composer r36, final int r37) {
        Composer r12 = r36.startRestartGroup(1936774759);
        if ((r37 & 6) == 0) goto L5;
        int r1 = r37;
    L11:
        if ((r37 & 48) == 0) goto L13;
    L17:
        int r7 = r1;
        if ((r7 & 19) != 18) goto L24;
        if (r12.getSkipping() == false) goto L24;
        r12.skipToGroupEnd();
        Composer r33 = r12;
    L35:
        ScopeUpdateScope r0 = r33.endRestartGroup();
        if (r0 == null) goto L39;
        r0.updateScope(new UDDialogKt$DialogMessage$2(r34, r35, r37));
        return;
    L39:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(1936774759, r7, -1, "com.larksuite.component.universe_design.dialog.compose.DialogMessage (UDDialog.kt:219)");
    L26:
        r12.startReplaceGroup(1849434622);
        Object r2 = r12.rememberedValue();
        Composer.Companion r8 = Composer.Companion;
        if (r2 != r8.getEmpty()) goto L29;
        r2 = SnapshotStateKt.mutableStateOf$default(TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), null, 2, null);
        r12.updateRememberedValue(r2);
    L29:
        final MutableState r9 = (MutableState) r2;
        r12.endReplaceGroup();
        Modifier r3 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null);
        float r4 = e.d;
        Modifier r5 = PaddingKt.padding-qDBjuR0$default(r3, r4, r35, r4, 0.0f, 8, null);
        long r6 = i0.a(r12).b();
        TextStyle r10 = i0.b(r12).c;
        TextAlign r22 = TextAlign.box-impl(((TextAlign) r9.getValue()).unbox-impl());
        r12.startReplaceGroup(5004770);
        Object r11 = r12.rememberedValue();
        if (r11 != r8.getEmpty()) goto L32;
        r11 = new UDDialogKt$DialogMessage$1$1(r9);
        r12.updateRememberedValue(r11);
    L32:
        r12.endReplaceGroup();
        r33 = r12;
        TextKt.Text-Nvy7gAk(r34, r5, r6, null, 0, null, null, null, 0, null, r22, 0, 0, false, 0, 0, (Function1) r11, r10, r33, r7 & 14, 1572864, 64504);
        if (ComposerKt.isTraceInProgress() == false) goto L35;
        ComposerKt.traceEventEnd();
        goto L35
    L13:
        if (r12.changed(r35) == false) goto L15;
        int r13 = 32;
    L16:
        r1 = r1 | r13;
        goto L17
    L15:
        r13 = 16;
        goto L16
    L5:
        if (r12.changed(r34) == false) goto L7;
        int r14 = 4;
    L8:
        r1 = r14 | r37;
        goto L11
    L7:
        r14 = 2;
        goto L8
    }

    public static final void i(final List r22, final Function0 r23, Composer r24, final int r25) {
        Composer r9 = r24.startRestartGroup(-932048560);
        if ((r25 & 6) == 0) goto L5;
        int r2 = r25;
    L11:
        if ((r25 & 48) == 0) goto L13;
    L17:
        int r10 = r2;
        if ((r10 & 19) != 18) goto L24;
        if (r9.getSkipping() == false) goto L24;
        r9.skipToGroupEnd();
    L82:
        ScopeUpdateScope r1 = r9.endRestartGroup();
        if (r1 == null) goto L99;
        r1.updateScope(new UDDialogKt$HorizontalActions$2(r22, r23, r25));
        return;
    L99:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(-932048560, r10, -1, "com.larksuite.component.universe_design.dialog.compose.HorizontalActions (UDDialog.kt:271)");
    L26:
        List r3 = r22;
        Iterator r4 = r3.iterator();
    L28:
        if (r4.hasNext() == false) goto L37;
        Object r5 = r4.next();
        UDDialogActionRole r13 = ((b) r5).c;
        if (r13 != UDDialogActionRole.Primary) goto L32;
    L34:
        boolean r14 = false;
    L35:
        if (r14 == false) goto L28;
    L38:
        b r6 = (b) r5;
        if (r6 != null) goto L41;
        r6 = (b) CollectionsKt.getOrNull(r22, 1);
    L41:
        Iterator r7 = r3.iterator();
    L43:
        if (r7.hasNext() == false) goto L53;
        Object r8 = r7.next();
        UDDialogActionRole r15 = ((b) r8).c;
        if (r15 != UDDialogActionRole.Primary) goto L47;
    L50:
        boolean r16 = true;
    L51:
        if (r16 == false) goto L43;
    L54:
        b r11 = (b) r8;
        if (r11 != null) goto L57;
        r11 = (b) CollectionsKt.firstOrNull(r22);
    L57:
        List r17 = CollectionsKt.distinct(CollectionsKt.listOfNotNull(new b[]{r6, r11}));
        Modifier r12 = IntrinsicKt.height(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), IntrinsicSize.Min);
        MeasurePolicy r19 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), r9, 0);
        long r20 = ComposablesKt.getCurrentCompositeKeyHashCode(r9, 0);
        int r21 = (int) (r20 ^ (r20 >>> 32));
        CompositionLocalMap r26 = r9.getCurrentCompositionLocalMap();
        Modifier r27 = ComposedModifierKt.materializeModifier(r9, r12);
        ComposeUiNode.Companion r29 = ComposeUiNode.Companion;
        Function0 r30 = r29.getConstructor();
        if ((r9.getApplier() instanceof Applier) == true) goto L60;
        ComposablesKt.invalidApplier();
    L60:
        r9.startReusableNode();
        if (r9.getInserting() == false) goto L63;
        r9.createNode(r30);
    L64:
        Composer r31 = Updater.constructor-impl(r9);
        Updater.set-impl(r31, r19, r29.getSetMeasurePolicy());
        Updater.set-impl(r31, r26, r29.getSetResolvedCompositionLocals());
        Function2 r32 = r29.getSetCompositeKeyHash();
        if (r31.getInserting() == false) goto L67;
    L68:
        r31.updateRememberedValue(Integer.valueOf(r21));
        r31.apply(Integer.valueOf(r21), r32);
    L69:
        Updater.set-impl(r31, r27, r29.getSetModifier());
        RowScopeInstance r110 = RowScopeInstance.INSTANCE;
        r9.startReplaceGroup(-1958919392);
        Iterator r210 = r17.iterator();
        int r33 = 0;
    L71:
        if (r210.hasNext() == false) goto L79;
        Object r34 = r210.next();
        int r211 = r33 + 1;
        if (r33 >= 0) goto L75;
        CollectionsKt.throwIndexOverflow();
    L75:
        int r111 = r33;
        a((b) r34, r23, RowScope.-CC.weight$default(r110, Modifier.Companion, 1.0f, false, 2, null), r9, r10 & 112, 0);
        r9.startReplaceGroup(-1958912427);
        if (r111 >= CollectionsKt.getLastIndex(r17)) goto L78;
        e(false, r9, 6);
    L78:
        r9.endReplaceGroup();
        r33 = r211;
        goto L71
    L79:
        r9.endReplaceGroup();
        r9.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L82;
        ComposerKt.traceEventEnd();
        goto L82
    L67:
        if (Intrinsics.areEqual(r31.rememberedValue(), Integer.valueOf(r21)) == true) goto L69;
    L63:
        r9.useNode();
        goto L64
    L47:
        if (r15 == UDDialogActionRole.Danger) goto L50;
        r16 = false;
        goto L51
    L53:
        r8 = null;
        goto L54
    L32:
        if (r13 == UDDialogActionRole.Danger) goto L34;
        r14 = true;
        goto L35
    L37:
        r5 = null;
        goto L38
    L13:
        if (r9.changedInstance(r23) == false) goto L15;
        int r35 = 32;
    L16:
        r2 = r2 | r35;
        goto L17
    L15:
        r35 = 16;
        goto L16
    L5:
        if (r9.changedInstance(r22) == false) goto L7;
        int r36 = 4;
    L8:
        r2 = r36 | r25;
        goto L11
    L7:
        r36 = 2;
        goto L8
    }

    public static final void j(final List r12, final Function0 r13, Composer r14, final int r15) {
        Composer r16 = r14.startRestartGroup(-323147202);
        if ((r15 & 6) == 0) goto L5;
        int r1 = r15;
    L11:
        if ((r15 & 48) == 0) goto L13;
    L17:
        int r7 = r1;
        if ((r7 & 19) != 18) goto L24;
        if (r16.getSkipping() == false) goto L24;
        r16.skipToGroupEnd();
    L39:
        ScopeUpdateScope r17 = r16.endRestartGroup();
        if (r17 == null) goto L46;
        r17.updateScope(new UDDialogKt$VerticalActions$2(r12, r13, r15));
        return;
    L46:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(-323147202, r7, -1, "com.larksuite.component.universe_design.dialog.compose.VerticalActions (UDDialog.kt:300)");
    L26:
        List r0 = CollectionsKt.sortedWith(r12, new c());
        Iterator r8 = r0.iterator();
        int r9 = 0;
    L28:
        if (r8.hasNext() == false) goto L37;
        Object r2 = r8.next();
        int r10 = r9 + 1;
        if (r9 >= 0) goto L32;
        CollectionsKt.throwIndexOverflow();
    L32:
        a((b) r2, r13, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), r16, (r7 & 112) | 384, 0);
        r16.startReplaceGroup(-1306798026);
        if (r9 >= CollectionsKt.getLastIndex(r0)) goto L35;
        e(true, r16, 6);
    L35:
        r16.endReplaceGroup();
        r9 = r10;
        goto L28
    L37:
        if (ComposerKt.isTraceInProgress() == false) goto L39;
        ComposerKt.traceEventEnd();
        goto L39
    L13:
        if (r16.changedInstance(r13) == false) goto L15;
        int r3 = 32;
    L16:
        r1 = r1 | r3;
        goto L17
    L15:
        r3 = 16;
        goto L16
    L5:
        if (r16.changedInstance(r12) == false) goto L7;
        int r4 = 4;
    L8:
        r1 = r4 | r15;
        goto L11
    L7:
        r4 = 2;
        goto L8
    }

    public static final void a(final b r33, final Function0<Unit> r34, Modifier r35, Composer r36, final int r37, final int r38) {
        Composer r3 = r36.startRestartGroup(-1274006121);
        if ((r38 & 1) == 0) goto L6;
        int r5 = r37 | 6;
    L14:
        if ((r38 & 2) == 0) goto L17;
        r5 = r5 | 48;
    L23:
        int r8 = r38 & 4;
        if (r8 == 0) goto L27;
        r5 = r5 | 384;
    L33:
        Modifier r10 = r35;
    L35:
        if ((r5 & 147) == 146) goto L37;
    L40:
        if (r8 == 0) goto L42;
        Modifier r9 = Modifier.Companion;
    L44:
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventStart(-1274006121, r5, -1, "com.larksuite.component.universe_design.dialog.compose.DialogActionButton (UDDialog.kt:324)");
    L46:
        r3.startReplaceGroup(1849434622);
        Object r0 = r3.rememberedValue();
        Composer.Companion r11 = Composer.Companion;
        if (r0 != r11.getEmpty()) goto L49;
        r0 = InteractionSourceKt.MutableInteractionSource();
        r3.updateRememberedValue(r0);
    L49:
        MutableInteractionSource r12 = (MutableInteractionSource) r0;
        r3.endReplaceGroup();
        State r1 = PressInteractionKt.collectIsPressedAsState(r12, r3, 6);
        UDDialogActionRole r13 = r33.c;
        int r14 = a.a[r13.ordinal()];
        boolean r15 = true;
        if (r14 == 1) goto L58;
        if (r14 != 2) goto L53;
        r3.startReplaceGroup(-254188330);
        long r16 = i0.a(r3).d.c.a;
        r3.endReplaceGroup();
    L59:
        long r20 = r16;
        if (((Boolean) r1.getValue()).booleanValue() == true) goto L62;
    L64:
        r3.startReplaceGroup(710315007);
        long r17 = i0.a(r3).d.h.b;
        r3.endReplaceGroup();
    L65:
        Modifier r22 = SizeKt.defaultMinSize-VpY3zN4$default(r9, 0.0f, e.k, 1, null);
        Modifier r19 = BackgroundKt.background-bw27NRU$default(r22, r17, null, 2, null);
        boolean r110 = r33.d;
        Role r111 = Role.box-impl(Role.Companion.getButton-o7Vup1c());
        r3.startReplaceGroup(-1633490746);
        if ((r5 & 14) != 4) goto L68;
        boolean r2 = true;
    L70:
        if ((r5 & 112) == 32) goto L73;
        r15 = false;
    L73:
        boolean r4 = r2 | r15;
        Object r6 = r3.rememberedValue();
        if (r4 == false) goto L76;
    L77:
        r6 = new UDDialogKt$DialogActionButton$1$1(r33, r34);
        r3.updateRememberedValue(r6);
    L78:
        r3.endReplaceGroup();
        Modifier r7 = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-O2vRcR0$default(r19, r12, null, r110, null, r111, (Function0) r6, 8, null), e.i, e.j);
        MeasurePolicy r21 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), false);
        long r112 = ComposablesKt.getCurrentCompositeKeyHashCode(r3, 0);
        int r23 = (int) (r112 ^ (r112 >>> 32));
        CompositionLocalMap r24 = r3.getCurrentCompositionLocalMap();
        Modifier r25 = ComposedModifierKt.materializeModifier(r3, r7);
        ComposeUiNode.Companion r26 = ComposeUiNode.Companion;
        Function0 r113 = r26.getConstructor();
        if ((r3.getApplier() instanceof Applier) == true) goto L81;
        ComposablesKt.invalidApplier();
    L81:
        r3.startReusableNode();
        if (r3.getInserting() == false) goto L84;
        r3.createNode(r113);
    L85:
        Composer r114 = Updater.constructor-impl(r3);
        Updater.set-impl(r114, r21, r26.getSetMeasurePolicy());
        Updater.set-impl(r114, r24, r26.getSetResolvedCompositionLocals());
        Function2 r27 = r26.getSetCompositeKeyHash();
        if (r114.getInserting() == false) goto L88;
    L89:
        r114.updateRememberedValue(Integer.valueOf(r23));
        r114.apply(Integer.valueOf(r23), r27);
    L90:
        Updater.set-impl(r114, r25, r26.getSetModifier());
        BoxScopeInstance r29 = BoxScopeInstance.INSTANCE;
        String r30 = r33.a;
        r3.startReplaceGroup(-1300159452);
        if (r33.d == false) goto L93;
        long r31 = r20;
    L94:
        r3.endReplaceGroup();
        TextStyle r32 = i0.b(r3).c;
        TextAlign r115 = TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk());
        Modifier r39 = r9;
        TextKt.Text-Nvy7gAk(r30, null, r31, null, 0, null, null, null, 0, null, r115, 0, 0, false, 0, 0, null, r32, r3, 0, 0, 130042);
        r3.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L97;
        ComposerKt.traceEventEnd();
    L97:
        r10 = r39;
    L98:
        ScopeUpdateScope r40 = r3.endRestartGroup();
        if (r40 == null) goto L102;
        final Modifier r41 = r10;
        r40.updateScope(new UDDialogKt$DialogActionButton$3(r33, r34, r41, r37, r38));
        return;
    L102:
        return;
    L93:
        r31 = i0.a(r3).d.f.c;
        goto L94
    L88:
        if (Intrinsics.areEqual(r114.rememberedValue(), Integer.valueOf(r23)) == true) goto L90;
    L84:
        r3.useNode();
        goto L85
    L76:
        if (r6 != r11.getEmpty()) goto L78;
    L68:
        r2 = false;
        goto L70
    L62:
        if (r33.d == false) goto L64;
        r3.startReplaceGroup(710261563);
        r17 = i0.a(r3).b.a.b;
        r3.endReplaceGroup();
        goto L65
    L53:
        if (r14 != 3) goto L55;
        r3.startReplaceGroup(-254185407);
        r16 = i0.a(r3).b();
        r3.endReplaceGroup();
        goto L59
    L55:
        r3.startReplaceGroup(-254193213);
        r3.endReplaceGroup();
        throw new NoWhenBranchMatchedException();
    L58:
        r3.startReplaceGroup(-254190930);
        r16 = i0.a(r3).a();
        r3.endReplaceGroup();
        goto L59
    L42:
        r9 = r10;
        goto L44
    L37:
        if (r3.getSkipping() == false) goto L40;
        r3.skipToGroupEnd();
        goto L98
    L27:
        if ((r37 & 384) != 0) goto L33;
        r10 = r35;
        if (r3.changed(r10) == false) goto L31;
        int r116 = 256;
    L32:
        r5 = r5 | r116;
        goto L35
    L31:
        r116 = 128;
        goto L32
    L17:
        if ((r37 & 48) != 0) goto L23;
        if (r3.changedInstance(r34) == false) goto L21;
        int r42 = 32;
    L22:
        r5 = r5 | r42;
        goto L23
    L21:
        r42 = 16;
        goto L22
    L6:
        if ((r37 & 6) == 0) goto L8;
        r5 = r37;
        goto L14
    L8:
        if (r3.changed(r33) == false) goto L10;
        int r43 = 4;
    L11:
        r5 = r43 | r37;
        goto L14
    L10:
        r43 = 2;
        goto L11
    }

    public static final void b(final List<b> r8, final UDDialogActionOrientation r9, final float r10, final Function0<Unit> r11, Composer r12, final int r13) {
        Composer r14 = r12.startRestartGroup(703591497);
        if ((r13 & 6) == 0) goto L5;
        int r1 = r13;
    L11:
        if ((r13 & 48) != 0) goto L18;
        if (r14.changed(r9.ordinal()) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r13 & 384) != 0) goto L25;
        if (r14.changed(r10) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r13 & 3072) != 0) goto L32;
        if (r14.changedInstance(r11) == false) goto L29;
        int r4 = 2048;
    L30:
        r1 = r1 | r4;
        goto L32
    L29:
        r4 = 1024;
    L32:
        if ((r1 & 1171) != 1170) goto L38;
        if (r14.getSkipping() == false) goto L38;
        r14.skipToGroupEnd();
    L43:
        ScopeUpdateScope r15 = r14.endRestartGroup();
        if (r15 == null) goto L47;
        r15.updateScope(new UDDialogKt$DialogActions$2(r8, r9, r10, r11, r13));
        return;
    L47:
        return;
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventStart(703591497, r1, -1, "com.larksuite.component.universe_design.dialog.compose.DialogActions (UDDialog.kt:249)");
    L40:
        BoxWithConstraintsKt.BoxWithConstraints(null, null, false, ComposableLambdaKt.rememberComposableLambda(-1574596941, true, new UDDialogKt$DialogActions$1(r9, r8, r10, r11), r14, 54), r14, 3072, 7);
        if (ComposerKt.isTraceInProgress() == false) goto L43;
        ComposerKt.traceEventEnd();
        goto L43
    L5:
        if (r14.changedInstance(r8) == false) goto L7;
        int r5 = 4;
    L8:
        r1 = r5 | r13;
        goto L11
    L7:
        r5 = 2;
        goto L8
    }

    public static final void h(final String r21, final String r22, final List r23, final UDDialogActionOrientation r24, final Function0 r25, Modifier r26, final Function3 r27, Composer r29, final int r210, final int r30) {
        Composer r12 = r29.startRestartGroup(1055864282);
        if ((r30 & 1) == 0) goto L6;
        int r3 = r210 | 6;
    L14:
        if ((r30 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        if ((r30 & 4) == 0) goto L27;
        r3 = r3 | 384;
    L34:
        if ((r30 & 8) == 0) goto L37;
        r3 = r3 | 3072;
    L44:
        if ((r30 & 16) == 0) goto L47;
        r3 = r3 | 24576;
    L53:
        int r4 = r30 & 32;
        if (r4 == 0) goto L57;
        r3 = r3 | 196608;
    L63:
        final Modifier r6 = r26;
    L65:
        if ((r30 & 64) == 0) goto L68;
        r3 = r3 | 1572864;
    L75:
        if ((599187 & r3) == 599186) goto L77;
    L80:
        if (r4 == 0) goto L82;
        Modifier r14 = Modifier.Companion;
    L84:
        if (ComposerKt.isTraceInProgress() == false) goto L86;
        ComposerKt.traceEventStart(1055864282, r3, -1, "com.larksuite.component.universe_design.dialog.compose.DialogContent (UDDialog.kt:160)");
    L86:
        Modifier r0 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(r14, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(e.c)), i0.a(r12).d.h.b, null, 2, null);
        MeasurePolicy r5 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), r12, 0);
        long r15 = ComposablesKt.getCurrentCompositeKeyHashCode(r12, 0);
        int r7 = (int) ((r15 >>> 32) ^ r15);
        CompositionLocalMap r8 = r12.getCurrentCompositionLocalMap();
        Modifier r1 = ComposedModifierKt.materializeModifier(r12, r0);
        ComposeUiNode.Companion r9 = ComposeUiNode.Companion;
        Function0 r16 = r9.getConstructor();
        if ((r12.getApplier() instanceof Applier) == true) goto L89;
        ComposablesKt.invalidApplier();
    L89:
        r12.startReusableNode();
        if (r12.getInserting() == false) goto L92;
        r12.createNode(r16);
    L93:
        Composer r10 = Updater.constructor-impl(r12);
        Updater.set-impl(r10, r5, r9.getSetMeasurePolicy());
        Updater.set-impl(r10, r8, r9.getSetResolvedCompositionLocals());
        Function2 r11 = r9.getSetCompositeKeyHash();
        if (r10.getInserting() == false) goto L96;
    L97:
        r10.updateRememberedValue(Integer.valueOf(r7));
        r10.apply(Integer.valueOf(r7), r11);
    L98:
        Updater.set-impl(r10, r1, r9.getSetModifier());
        ColumnScopeInstance r2 = ColumnScopeInstance.INSTANCE;
        if (r21 != null) goto L101;
    L104:
        boolean r13 = true;
    L105:
        boolean r17 = !r13;
        if (r22 != null) goto L108;
    L111:
        boolean r19 = true;
    L112:
        boolean r20 = !r19;
        r12.startReplaceGroup(859090094);
        String r31 = "";
        if (r17 == false) goto L118;
        if (r21 != null) goto L116;
        String r32 = "";
    L117:
        int r110 = 0;
        d(r32, r12, 0);
    L119:
        r12.endReplaceGroup();
        r12.startReplaceGroup(859092859);
        if (r20 == false) goto L128;
        if (r22 == null) goto L124;
        r31 = r22;
    L124:
        if (r17 == false) goto L126;
        float r33 = Dp.constructor-impl(r110);
    L127:
        c(r31, r33, r12, r110);
        goto L128
    L126:
        r33 = e.e;
    L128:
        r12.endReplaceGroup();
        r12.startReplaceGroup(859099120);
        if (r27 == null) goto L132;
        r27.invoke(r2, r12, Integer.valueOf(((r3 >> 15) & 112) | 6));
    L132:
        r12.endReplaceGroup();
        r12.startReplaceGroup(859100126);
        if ((!r23.isEmpty()) == false) goto L140;
        if (r20 == true) goto L138;
        if (r27 != null) goto L138;
        float r34 = e.h;
    L139:
        float r35 = r34;
        int r36 = r3 >> 6;
        b(r23, r24, r35, r25, r12, ((r36 & 112) | (r36 & 14)) | ((r3 >> 3) & 7168));
    L138:
        r34 = e.g;
    L140:
        r12.endReplaceGroup();
        r12.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L143;
        ComposerKt.traceEventEnd();
    L143:
        r6 = r14;
    L144:
        ScopeUpdateScope r111 = r12.endRestartGroup();
        if (r111 == null) goto L148;
        r111.updateScope(new UDDialogKt$DialogContent$2(r21, r22, r23, r24, r25, r6, r27, r210, r30));
        return;
    L148:
        return;
    L116:
        r32 = r21;
        goto L117
    L118:
        r110 = 0;
        goto L119
    L108:
        if (r22.length() == 0) goto L111;
        r19 = false;
        goto L112
    L101:
        if (r21.length() == 0) goto L104;
        r13 = false;
        goto L105
    L96:
        if (Intrinsics.areEqual(r10.rememberedValue(), Integer.valueOf(r7)) == true) goto L98;
    L92:
        r12.useNode();
        goto L93
    L82:
        r14 = r6;
        goto L84
    L77:
        if (r12.getSkipping() == false) goto L80;
        r12.skipToGroupEnd();
        goto L144
    L68:
        if ((r210 & 1572864) != 0) goto L75;
        if (r12.changedInstance(r27) == false) goto L72;
        int r37 = 1048576;
    L73:
        r3 = r3 | r37;
        goto L75
    L72:
        r37 = 524288;
        goto L73
    L57:
        if ((196608 & r210) != 0) goto L63;
        r6 = r26;
        if (r12.changed(r6) == false) goto L61;
        int r38 = 131072;
    L62:
        r3 = r3 | r38;
        goto L65
    L61:
        r38 = 65536;
        goto L62
    L47:
        if ((r210 & 24576) != 0) goto L53;
        if (r12.changedInstance(r25) == false) goto L51;
        int r39 = 16384;
    L52:
        r3 = r3 | r39;
        goto L53
    L51:
        r39 = 8192;
        goto L52
    L37:
        if ((r210 & 3072) != 0) goto L44;
        if (r12.changed(r24.ordinal()) == false) goto L41;
        int r40 = 2048;
    L42:
        r3 = r3 | r40;
        goto L44
    L41:
        r40 = 1024;
        goto L42
    L27:
        if ((r210 & 384) != 0) goto L34;
        if (r12.changedInstance(r23) == false) goto L31;
        int r41 = 256;
    L32:
        r3 = r3 | r41;
        goto L34
    L31:
        r41 = 128;
        goto L32
    L17:
        if ((r210 & 48) != 0) goto L24;
        if (r12.changed(r22) == false) goto L21;
        int r42 = 32;
    L22:
        r3 = r3 | r42;
        goto L24
    L21:
        r42 = 16;
        goto L22
    L6:
        if ((r210 & 6) == 0) goto L8;
        r3 = r210;
        goto L14
    L8:
        if (r12.changed(r21) == false) goto L10;
        int r43 = 4;
    L11:
        r3 = r43 | r210;
        goto L14
    L10:
        r43 = 2;
        goto L11
    }

    public static final void f(final boolean r29, final Function0<Unit> r210, Modifier r30, String r31, String r32, List<b> r33, UDDialogActionOrientation r34, boolean r35, boolean r36, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r37, Composer r38, final int r39, final int r40) {
        Intrinsics.checkNotNullParameter(r210, "onDismissRequest");
        Composer r12 = r38.startRestartGroup(391203280);
        if ((r40 & 1) == 0) goto L6;
        int r1 = r39 | 6;
    L14:
        if ((r40 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r2 = r40 & 4;
        if (r2 == 0) goto L27;
        r1 = r1 | 384;
    L34:
        int r4 = r40 & 8;
        if (r4 == 0) goto L38;
        r1 = r1 | 3072;
    L45:
        int r6 = r40 & 16;
        if (r6 == 0) goto L49;
        r1 = r1 | 24576;
    L56:
        int r8 = r40 & 32;
        if (r8 == 0) goto L60;
        r1 = r1 | 196608;
    L67:
        int r10 = r40 & 64;
        if (r10 == 0) goto L71;
        r1 = r1 | 1572864;
    L80:
        int r0 = r40 & 128;
        if (r0 == 0) goto L84;
        r1 = r1 | 12582912;
    L90:
        int r3 = r40 & 256;
        if (r3 == 0) goto L94;
        r1 = r1 | 100663296;
    L100:
        int r5 = r40 & 512;
        if (r5 == 0) goto L104;
        r1 = r1 | 805306368;
    L111:
        if ((r1 & 306783379) == 306783378) goto L113;
    L116:
        if (r2 == 0) goto L118;
        Modifier r19 = Modifier.Companion;
    L120:
        if (r4 == 0) goto L122;
        String r110 = null;
    L123:
        if (r6 == 0) goto L125;
        String r20 = null;
    L126:
        if (r8 == 0) goto L128;
        List<b> r21 = CollectionsKt.emptyList();
    L129:
        if (r10 == 0) goto L131;
        UDDialogActionOrientation r22 = UDDialogActionOrientation.Auto;
    L133:
        if (r0 == 0) goto L135;
        boolean r23 = true;
    L136:
        if (r3 == 0) goto L138;
        boolean r24 = true;
    L139:
        if (r5 == 0) goto L141;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r25 = null;
    L143:
        if (ComposerKt.isTraceInProgress() == false) goto L145;
        ComposerKt.traceEventStart(391203280, r1, -1, "com.larksuite.component.universe_design.dialog.compose.UDDialog (UDDialog.kt:59)");
    L145:
        g(r29, r210, r19, r110, r20, r21, r22, r23, r24, false, r25, r12, (((((((((r1 & 14) | 805306368) | (r1 & 112)) | (r1 & 896)) | (r1 & 7168)) | (57344 & r1)) | (458752 & r1)) | (3670016 & r1)) | (29360128 & r1)) | (234881024 & r1), (r1 >> 27) & 14, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L148;
        ComposerKt.traceEventEnd();
    L148:
        final Modifier r7 = r19;
        final String r9 = r110;
        final String r11 = r20;
        final List<b> r13 = r21;
        final UDDialogActionOrientation r14 = r22;
        final boolean r15 = r23;
        final boolean r16 = r24;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r17 = r25;
    L149:
        ScopeUpdateScope r111 = r12.endRestartGroup();
        if (r111 == null) goto L153;
        r111.updateScope(new UDDialogKt$UDDialog$1(r29, r210, r7, r9, r11, r13, r14, r15, r16, r17, r39, r40));
        return;
    L153:
        return;
    L141:
        r25 = r37;
        goto L143
    L138:
        r24 = r36;
        goto L139
    L135:
        r23 = r35;
        goto L136
    L131:
        r22 = r34;
        goto L133
    L128:
        r21 = r33;
        goto L129
    L125:
        r20 = r32;
        goto L126
    L122:
        r110 = r31;
        goto L123
    L118:
        r19 = r30;
        goto L120
    L113:
        if (r12.getSkipping() == false) goto L116;
        r12.skipToGroupEnd();
        r7 = r30;
        r9 = r31;
        r11 = r32;
        r13 = r33;
        r14 = r34;
        r15 = r35;
        r16 = r36;
        r17 = r37;
        goto L149
    L104:
        if ((r39 & 805306368) != 0) goto L111;
        if (r12.changedInstance(r37) == false) goto L108;
        int r112 = 536870912;
    L109:
        r1 = r1 | r112;
        goto L111
    L108:
        r112 = 268435456;
        goto L109
    L94:
        if ((r39 & 100663296) != 0) goto L100;
        if (r12.changed(r36) == false) goto L98;
        int r113 = 67108864;
    L99:
        r1 = r1 | r113;
        goto L100
    L98:
        r113 = 33554432;
        goto L99
    L84:
        if ((r39 & 12582912) != 0) goto L90;
        if (r12.changed(r35) == false) goto L88;
        int r114 = 8388608;
    L89:
        r1 = r1 | r114;
        goto L90
    L88:
        r114 = 4194304;
        goto L89
    L71:
        if ((r39 & 1572864) != 0) goto L80;
        if (r34 != null) goto L74;
        int r26 = -1;
    L76:
        if (r12.changed(r26) == false) goto L78;
        int r27 = 1048576;
    L79:
        r1 = r1 | r27;
        goto L80
    L78:
        r27 = 524288;
        goto L79
    L74:
        r26 = r34.ordinal();
        goto L76
    L60:
        if ((196608 & r39) != 0) goto L67;
        if (r12.changedInstance(r33) == false) goto L64;
        int r115 = 131072;
    L65:
        r1 = r1 | r115;
        goto L67
    L64:
        r115 = 65536;
        goto L65
    L49:
        if ((r39 & 24576) != 0) goto L56;
        if (r12.changed(r32) == false) goto L53;
        int r41 = 16384;
    L54:
        r1 = r1 | r41;
        goto L56
    L53:
        r41 = 8192;
        goto L54
    L38:
        if ((r39 & 3072) != 0) goto L45;
        if (r12.changed(r31) == false) goto L42;
        int r42 = 2048;
    L43:
        r1 = r1 | r42;
        goto L45
    L42:
        r42 = 1024;
        goto L43
    L27:
        if ((r39 & 384) != 0) goto L34;
        if (r12.changed(r30) == false) goto L31;
        int r43 = 256;
    L32:
        r1 = r1 | r43;
        goto L34
    L31:
        r43 = 128;
        goto L32
    L17:
        if ((r39 & 48) != 0) goto L23;
        if (r12.changedInstance(r210) == false) goto L21;
        int r44 = 32;
    L22:
        r1 = r1 | r44;
        goto L23
    L21:
        r44 = 16;
        goto L22
    L6:
        if ((r39 & 6) == 0) goto L8;
        r1 = r39;
        goto L14
    L8:
        if (r12.changed(r29) == false) goto L10;
        int r45 = 4;
    L11:
        r1 = r45 | r39;
        goto L14
    L10:
        r45 = 2;
        goto L11
    }

    public static final void g(final boolean r36, final Function0<Unit> r37, Modifier r38, String r39, String r40, List<b> r41, UDDialogActionOrientation r42, boolean r43, boolean r44, final boolean r45, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r46, Composer r47, final int r48, final int r49, final int r50) {
        Intrinsics.checkNotNullParameter(r37, "onDismissRequest");
        Composer r12 = r47.startRestartGroup(1161919540);
        if ((r50 & 1) == 0) goto L6;
        int r2 = r48 | 6;
    L14:
        if ((r50 & 2) == 0) goto L17;
        r2 = r2 | 48;
    L23:
        int r5 = r50 & 4;
        if (r5 == 0) goto L27;
        r2 = r2 | 384;
    L34:
        int r7 = r50 & 8;
        if (r7 == 0) goto L38;
        r2 = r2 | 3072;
    L45:
        int r9 = r50 & 16;
        if (r9 == 0) goto L49;
        r2 = r2 | 24576;
    L56:
        int r11 = r50 & 32;
        if (r11 == 0) goto L60;
        r2 = r2 | 196608;
    L66:
        int r16 = r50 & 64;
        if (r16 == 0) goto L70;
        r2 = r2 | 1572864;
    L79:
        int r0 = r50 & 128;
        if (r0 == 0) goto L83;
        r2 = r2 | 12582912;
    L89:
        int r3 = r50 & 256;
        if (r3 == 0) goto L93;
        r2 = r2 | 100663296;
    L100:
        if ((r50 & 512) == 0) goto L103;
        r2 = r2 | 805306368;
    L110:
        int r4 = r50 & 1024;
        if (r4 == 0) goto L115;
        int r19 = r49 | 6;
    L113:
        int r6 = r19;
    L123:
        if ((r2 & 306783379) == 306783378) goto L125;
    L130:
        if (r5 == 0) goto L132;
        Modifier r17 = Modifier.Companion;
    L134:
        if (r7 == 0) goto L136;
        String r110 = null;
    L137:
        if (r9 == 0) goto L139;
        String r20 = null;
    L140:
        if (r11 == 0) goto L142;
        List<b> r21 = CollectionsKt.emptyList();
    L143:
        if (r16 == 0) goto L145;
        UDDialogActionOrientation r111 = UDDialogActionOrientation.Auto;
    L147:
        if (r0 == 0) goto L149;
        boolean r31 = true;
    L150:
        if (r3 == 0) goto L152;
        boolean r32 = true;
    L153:
        if (r4 == 0) goto L155;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r33 = null;
    L157:
        if (ComposerKt.isTraceInProgress() == false) goto L159;
        ComposerKt.traceEventStart(1161919540, r2, r6, "com.larksuite.component.universe_design.dialog.compose.UDDialogImpl (UDDialog.kt:88)");
    L159:
        if (r36 == false) goto L161;
        final boolean r8 = DarkThemeKt.isSystemInDarkTheme(r12, 0);
        if (r8 == false) goto L170;
        final float r10 = 0.7f;
    L171:
        final String r13 = r110;
        final String r14 = r20;
        final List<b> r15 = r21;
        final UDDialogActionOrientation r22 = r111;
        final Modifier r112 = r17;
        Composer r113 = r12;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r114 = r33;
        AndroidDialog_androidKt.Dialog(r37, new DialogProperties(r31, r32, null, false, true, null, 36, null), ComposableLambdaKt.rememberComposableLambda(-692566581, true, new UDDialogKt$UDDialogImpl$2(r10, r45, r8, r13, r14, r15, r22, r37, r112, r114), r113, 54), r113, ((r2 >> 3) & 14) | 384, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L174;
        ComposerKt.traceEventEnd();
    L174:
        final UDDialogActionOrientation r23 = r111;
        final Modifier r24 = r17;
        final String r25 = r110;
        final String r26 = r20;
        final List<b> r27 = r21;
        final boolean r29 = r31;
        final boolean r30 = r32;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r115 = r33;
    L175:
        ScopeUpdateScope r116 = r113.endRestartGroup();
        if (r116 == null) goto L180;
        r116.updateScope(new UDDialogKt$UDDialogImpl$3(r36, r37, r24, r25, r26, r27, r23, r29, r30, r45, r115, r48, r49, r50));
        return;
    L180:
        return;
    L170:
        r10 = 0.55f;
        goto L171
    L161:
        if (ComposerKt.isTraceInProgress() == false) goto L163;
        ComposerKt.traceEventEnd();
    L163:
        ScopeUpdateScope r117 = r12.endRestartGroup();
        if (r117 == null) goto L179;
        final Modifier r34 = r17;
        final String r35 = r110;
        final String r51 = r20;
        final List<b> r52 = r21;
        final UDDialogActionOrientation r53 = r111;
        final boolean r54 = r31;
        final boolean r55 = r32;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r118 = r33;
        r117.updateScope(new UDDialogKt$UDDialogImpl$1(r36, r37, r34, r35, r51, r52, r53, r54, r55, r45, r118, r48, r49, r50));
        return;
    L179:
        return;
    L155:
        r33 = r46;
        goto L157
    L152:
        r32 = r44;
        goto L153
    L149:
        r31 = r43;
        goto L150
    L145:
        r111 = r42;
        goto L147
    L142:
        r21 = r41;
        goto L143
    L139:
        r20 = r40;
        goto L140
    L136:
        r110 = r39;
        goto L137
    L132:
        r17 = r38;
        goto L134
    L125:
        if ((r6 & 3) != 2) goto L130;
        if (r12.getSkipping() == false) goto L130;
        r12.skipToGroupEnd();
        r24 = r38;
        r25 = r39;
        r26 = r40;
        r27 = r41;
        r23 = r42;
        r29 = r43;
        r30 = r44;
        r115 = r46;
        r113 = r12;
        goto L175
    L115:
        if ((r49 & 6) == 0) goto L117;
        r6 = r49;
        goto L123
    L117:
        if (r12.changedInstance(r46) == false) goto L119;
        int r119 = 4;
    L120:
        r19 = r49 | r119;
        goto L113
    L119:
        r119 = 2;
        goto L120
    L103:
        if ((r48 & 805306368) != 0) goto L110;
        if (r12.changed(r45) == false) goto L107;
        int r120 = 536870912;
    L108:
        r2 = r2 | r120;
        goto L110
    L107:
        r120 = 268435456;
        goto L108
    L93:
        if ((r48 & 100663296) != 0) goto L100;
        if (r12.changed(r44) == false) goto L97;
        int r121 = 67108864;
    L98:
        r2 = r2 | r121;
        goto L100
    L97:
        r121 = 33554432;
        goto L98
    L83:
        if ((r48 & 12582912) != 0) goto L89;
        if (r12.changed(r43) == false) goto L87;
        int r122 = 8388608;
    L88:
        r2 = r2 | r122;
        goto L89
    L87:
        r122 = 4194304;
        goto L88
    L70:
        if ((r48 & 1572864) != 0) goto L79;
        if (r42 != null) goto L73;
        int r1 = -1;
    L75:
        if (r12.changed(r1) == false) goto L77;
        int r56 = 1048576;
    L78:
        r2 = r2 | r56;
        goto L79
    L77:
        r56 = 524288;
        goto L78
    L73:
        r1 = r42.ordinal();
        goto L75
    L60:
        if ((r48 & 196608) != 0) goto L66;
        if (r12.changedInstance(r41) == false) goto L64;
        int r123 = 131072;
    L65:
        r2 = r2 | r123;
        goto L66
    L64:
        r123 = 65536;
        goto L65
    L49:
        if ((r48 & 24576) != 0) goto L56;
        if (r12.changed(r40) == false) goto L53;
        int r124 = 16384;
    L54:
        r2 = r2 | r124;
        goto L56
    L53:
        r124 = 8192;
        goto L54
    L38:
        if ((r48 & 3072) != 0) goto L45;
        if (r12.changed(r39) == false) goto L42;
        int r57 = 2048;
    L43:
        r2 = r2 | r57;
        goto L45
    L42:
        r57 = 1024;
        goto L43
    L27:
        if ((r48 & 384) != 0) goto L34;
        if (r12.changed(r38) == false) goto L31;
        int r59 = 256;
    L32:
        r2 = r2 | r59;
        goto L34
    L31:
        r59 = 128;
        goto L32
    L17:
        if ((r48 & 48) != 0) goto L23;
        if (r12.changedInstance(r37) == false) goto L21;
        int r60 = 32;
    L22:
        r2 = r2 | r60;
        goto L23
    L21:
        r60 = 16;
        goto L22
    L6:
        if ((r48 & 6) == 0) goto L8;
        r2 = r48;
        goto L14
    L8:
        if (r12.changed(r36) == false) goto L10;
        int r61 = 4;
    L11:
        r2 = r61 | r48;
        goto L14
    L10:
        r61 = 2;
        goto L11
    }
}
