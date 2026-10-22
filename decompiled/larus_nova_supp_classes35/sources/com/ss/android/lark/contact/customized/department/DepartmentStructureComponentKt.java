package com.ss.android.lark.contact.customized.department;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.TranslateModelHandler;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mtb.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DepartmentStructureComponentKt {
    public static final void b(Composer r22, final int r23) {
        Composer r2 = r22.startRestartGroup(-166605261);
        if (r23 != 0) goto L9;
        if (r2.getSkipping() == false) goto L9;
        r2.skipToGroupEnd();
    L64:
        ScopeUpdateScope r1 = r2.endRestartGroup();
        if (r1 == null) goto L71;
        r1.updateScope(new DepartmentStructureComponentKt$DepartmentStructureSkeleton$2(r23));
        return;
    L71:
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-166605261, r23, -1, "com.ss.android.lark.contact.customized.department.DepartmentStructureSkeleton (DepartmentStructureComponent.kt:237)");
    L11:
        Modifier.Companion r3 = Modifier.Companion;
        int r5 = 0;
        MeasurePolicy r4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), r2, 0);
        long r6 = ComposablesKt.getCurrentCompositeKeyHashCode(r2, 0);
        char r7 = ' ';
        int r8 = (int) (r6 ^ (r6 >>> 32));
        CompositionLocalMap r9 = r2.getCurrentCompositionLocalMap();
        Modifier r10 = ComposedModifierKt.materializeModifier(r2, r3);
        ComposeUiNode.Companion r11 = ComposeUiNode.Companion;
        Function0 r12 = r11.getConstructor();
        if ((r2.getApplier() instanceof Applier) == true) goto L14;
        ComposablesKt.invalidApplier();
    L14:
        r2.startReusableNode();
        if (r2.getInserting() == false) goto L17;
        r2.createNode(r12);
    L18:
        Composer r13 = Updater.constructor-impl(r2);
        Updater.set-impl(r13, r4, r11.getSetMeasurePolicy());
        Updater.set-impl(r13, r9, r11.getSetResolvedCompositionLocals());
        Function2 r14 = r11.getSetCompositeKeyHash();
        if (r13.getInserting() == false) goto L21;
    L22:
        r13.updateRememberedValue(Integer.valueOf(r8));
        r13.apply(Integer.valueOf(r8), r14);
    L23:
        Updater.set-impl(r13, r10, r11.getSetModifier());
        ColumnScopeInstance r15 = ColumnScopeInstance.INSTANCE;
        r2.startReplaceGroup(-224516663);
        int r16 = 0;
    L25:
        if (r16 >= 2) goto L61;
        Modifier.Companion r17 = Modifier.Companion;
        float r18 = 16;
        Modifier r19 = PaddingKt.padding-VpY3zN4$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(r17, 0.0f, 1, null), Dp.constructor-impl(64)), Dp.constructor-impl(r18), 0.0f, 2, null);
        Alignment.Companion r110 = Alignment.Companion;
        Alignment.Vertical r20 = r110.getCenterVertically();
        Arrangement r111 = Arrangement.INSTANCE;
        MeasurePolicy r21 = RowKt.rowMeasurePolicy(r111.getStart(), r20, r2, 48);
        long r24 = ComposablesKt.getCurrentCompositeKeyHashCode(r2, r5);
        int r25 = (int) (r24 ^ (r24 >>> r7));
        CompositionLocalMap r26 = r2.getCurrentCompositionLocalMap();
        Modifier r27 = ComposedModifierKt.materializeModifier(r2, r19);
        ComposeUiNode.Companion r112 = ComposeUiNode.Companion;
        Function0 r28 = r112.getConstructor();
        if ((r2.getApplier() instanceof Applier) == true) goto L29;
        ComposablesKt.invalidApplier();
    L29:
        r2.startReusableNode();
        if (r2.getInserting() == false) goto L32;
        r2.createNode(r28);
    L33:
        Composer r29 = Updater.constructor-impl(r2);
        Updater.set-impl(r29, r21, r112.getSetMeasurePolicy());
        Updater.set-impl(r29, r26, r112.getSetResolvedCompositionLocals());
        Function2 r30 = r112.getSetCompositeKeyHash();
        if (r29.getInserting() == false) goto L36;
    L37:
        r29.updateRememberedValue(Integer.valueOf(r25));
        r29.apply(Integer.valueOf(r25), r30);
    L38:
        Updater.set-impl(r29, r27, r112.getSetModifier());
        RowScopeInstance r31 = RowScopeInstance.INSTANCE;
        final long r113 = ColorKt.Color(UIHelper.getColor(2131102045));
        SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(r17, 0.0f, 0.0f, Dp.constructor-impl(12), 0.0f, 11, null), Dp.constructor-impl(48)), RoundedCornerShapeKt.getCircleShape()), r113, null, 2, null), r2, r5);
        MeasurePolicy r32 = ColumnKt.columnMeasurePolicy(r111.getTop(), r110.getStart(), r2, r5);
        long r33 = ComposablesKt.getCurrentCompositeKeyHashCode(r2, r5);
        int r34 = (int) (r33 ^ (r33 >>> r7));
        CompositionLocalMap r35 = r2.getCurrentCompositionLocalMap();
        Modifier r36 = ComposedModifierKt.materializeModifier(r2, r17);
        Function0 r37 = r112.getConstructor();
        if ((r2.getApplier() instanceof Applier) == true) goto L41;
        ComposablesKt.invalidApplier();
    L41:
        r2.startReusableNode();
        if (r2.getInserting() == false) goto L44;
        r2.createNode(r37);
    L45:
        Composer r38 = Updater.constructor-impl(r2);
        Updater.set-impl(r38, r32, r112.getSetMeasurePolicy());
        Updater.set-impl(r38, r35, r112.getSetResolvedCompositionLocals());
        Function2 r39 = r112.getSetCompositeKeyHash();
        if (r38.getInserting() == false) goto L48;
    L49:
        r38.updateRememberedValue(Integer.valueOf(r34));
        r38.apply(Integer.valueOf(r34), r39);
    L50:
        Updater.set-impl(r38, r36, r112.getSetModifier());
        ColumnScopeInstance r40 = ColumnScopeInstance.INSTANCE;
        float r114 = 4;
        Modifier r41 = ClipKt.clip(SizeKt.size-VpY3zN4(r17, Dp.constructor-impl(100), Dp.constructor-impl(20)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(r114)));
        r2.startReplaceGroup(5004770);
        boolean r42 = r2.changed(r113);
        Object r43 = r2.rememberedValue();
        if (r42 == false) goto L53;
    L54:
        r43 = new DepartmentStructureComponentKt$DepartmentStructureSkeleton$1$1$1$1$1$1(r113);
        r2.updateRememberedValue(r43);
    L55:
        r2.endReplaceGroup();
        SpacerKt.Spacer(DrawModifierKt.drawBehind(r41, (Function1) r43), r2, r5);
        Modifier r44 = ClipKt.clip(SizeKt.size-VpY3zN4(PaddingKt.padding-qDBjuR0$default(r17, 0.0f, Dp.constructor-impl(8), 0.0f, 0.0f, 13, null), Dp.constructor-impl(240), Dp.constructor-impl(r18)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(r114)));
        r2.startReplaceGroup(5004770);
        boolean r45 = r2.changed(r113);
        Object r46 = r2.rememberedValue();
        if (r45 == false) goto L58;
    L59:
        r46 = new DepartmentStructureComponentKt$DepartmentStructureSkeleton$1$1$1$1$2$1(r113);
        r2.updateRememberedValue(r46);
    L60:
        r2.endReplaceGroup();
        SpacerKt.Spacer(DrawModifierKt.drawBehind(r44, (Function1) r46), r2, 0);
        r2.endNode();
        r2.endNode();
        r16 = r16 + 1;
        r7 = ' ';
        r5 = 0;
        goto L25
    L58:
        if (r46 != Composer.Companion.getEmpty()) goto L60;
    L53:
        if (r43 != Composer.Companion.getEmpty()) goto L55;
    L48:
        if (Intrinsics.areEqual(r38.rememberedValue(), Integer.valueOf(r34)) == true) goto L50;
    L44:
        r2.useNode();
        goto L45
    L36:
        if (Intrinsics.areEqual(r29.rememberedValue(), Integer.valueOf(r25)) == true) goto L38;
    L32:
        r2.useNode();
        goto L33
    L61:
        r2.endReplaceGroup();
        r2.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L64;
        ComposerKt.traceEventEnd();
        goto L64
    L21:
        if (Intrinsics.areEqual(r13.rememberedValue(), Integer.valueOf(r8)) == true) goto L23;
    L17:
        r2.useNode();
        goto L18
    }

    public static final void d(final Modifier r30, Composer r31, final int r32) {
        Intrinsics.checkNotNullParameter(r30, "modifier");
        Composer r15 = r31.startRestartGroup(959642780);
        if ((r32 & 6) == 0) goto L5;
        int r3 = r32;
    L11:
        if ((r3 & 3) != 2) goto L17;
        if (r15.getSkipping() == false) goto L17;
        r15.skipToGroupEnd();
        Composer r29 = r15;
    L46:
        ScopeUpdateScope r2 = r29.endRestartGroup();
        if (r2 == null) goto L50;
        r2.updateScope(new DepartmentStructureComponentKt$EmptyPage$2(r30, r32));
        return;
    L50:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(959642780, r3, -1, "com.ss.android.lark.contact.customized.department.EmptyPage (DepartmentStructureComponent.kt:215)");
    L19:
        Alignment.Companion r4 = Alignment.Companion;
        MeasurePolicy r5 = BoxKt.maybeCachedBoxMeasurePolicy(r4.getTopStart(), false);
        long r6 = ComposablesKt.getCurrentCompositeKeyHashCode(r15, 0);
        int r7 = (int) (r6 ^ (r6 >>> 32));
        CompositionLocalMap r8 = r15.getCurrentCompositionLocalMap();
        Modifier r9 = ComposedModifierKt.materializeModifier(r15, r30);
        ComposeUiNode.Companion r10 = ComposeUiNode.Companion;
        Function0 r11 = r10.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L22;
        ComposablesKt.invalidApplier();
    L22:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L25;
        r15.createNode(r11);
    L26:
        Composer r12 = Updater.constructor-impl(r15);
        Updater.set-impl(r12, r5, r10.getSetMeasurePolicy());
        Updater.set-impl(r12, r8, r10.getSetResolvedCompositionLocals());
        Function2 r13 = r10.getSetCompositeKeyHash();
        if (r12.getInserting() == false) goto L29;
    L30:
        r12.updateRememberedValue(Integer.valueOf(r7));
        r12.apply(Integer.valueOf(r7), r13);
    L31:
        Updater.set-impl(r12, r9, r10.getSetModifier());
        BoxScopeInstance r14 = BoxScopeInstance.INSTANCE;
        Alignment.Horizontal r16 = r4.getCenterHorizontally();
        Modifier.Companion r17 = Modifier.Companion;
        Modifier r18 = r14.align(r17, r4.getCenter());
        MeasurePolicy r19 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), r16, r15, 48);
        long r110 = ComposablesKt.getCurrentCompositeKeyHashCode(r15, 0);
        int r20 = (int) (r110 ^ (r110 >>> 32));
        CompositionLocalMap r21 = r15.getCurrentCompositionLocalMap();
        Modifier r22 = ComposedModifierKt.materializeModifier(r15, r18);
        Function0 r111 = r10.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L34;
        ComposablesKt.invalidApplier();
    L34:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L37;
        r15.createNode(r111);
    L38:
        Composer r112 = Updater.constructor-impl(r15);
        Updater.set-impl(r112, r19, r10.getSetMeasurePolicy());
        Updater.set-impl(r112, r21, r10.getSetResolvedCompositionLocals());
        Function2 r23 = r10.getSetCompositeKeyHash();
        if (r112.getInserting() == false) goto L41;
    L42:
        r112.updateRememberedValue(Integer.valueOf(r20));
        r112.apply(Integer.valueOf(r20), r23);
    L43:
        Updater.set-impl(r112, r22, r10.getSetModifier());
        ColumnScopeInstance r24 = ColumnScopeInstance.INSTANCE;
        ImageKt.Image(PainterResources_androidKt.painterResource(2131233633, r15, 0), null, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(r17, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(16), 7, null), Dp.constructor-impl(32)), null, null, 0.0f, null, r15, 432, 120);
        r29 = r15;
        TextKt.Text-Nvy7gAk(UIHelper.getString(2131890065), null, 0, null, TextUnitKt.getSp(17), null, FontWeight.Companion.getW600(), null, 0, null, null, 0, 0, false, 1, 0, null, null, r29, 1597440, 24576, 245678);
        r29.endNode();
        r29.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventEnd();
        goto L46
    L41:
        if (Intrinsics.areEqual(r112.rememberedValue(), Integer.valueOf(r20)) == true) goto L43;
    L37:
        r15.useNode();
        goto L38
    L29:
        if (Intrinsics.areEqual(r12.rememberedValue(), Integer.valueOf(r7)) == true) goto L31;
    L25:
        r15.useNode();
        goto L26
    L5:
        if (r15.changed(r30) == false) goto L7;
        int r25 = 4;
    L8:
        r3 = r25 | r32;
        goto L11
    L7:
        r25 = 2;
        goto L8
    }

    public static final void c(final DepartmentStructureViewModel r35, Function0<Unit> r36, Composer r37, final int r38, final int r39) {
        Intrinsics.checkNotNullParameter(r35, "vm");
        Composer r14 = r37.startRestartGroup(655572308);
        if ((r39 & 1) == 0) goto L6;
        int r4 = r38 | 6;
    L13:
        int r6 = r39 & 2;
        if (r6 == 0) goto L17;
        r4 = r4 | 48;
    L23:
        final Function0<Unit> r7 = r36;
    L25:
        if ((r4 & 19) != 18) goto L31;
        if (r14.getSkipping() == false) goto L31;
        r14.skipToGroupEnd();
        Composer r12 = r14;
    L92:
        ScopeUpdateScope r3 = r12.endRestartGroup();
        if (r3 == null) goto L96;
        r3.updateScope(new DepartmentStructureComponentKt$DepartmentStructureTitleBar$3(r35, r7, r38, r39));
        return;
    L96:
        return;
    L31:
        if (r6 == 0) goto L36;
        r14.startReplaceGroup(1849434622);
        Object r8 = r14.rememberedValue();
        if (r8 != Composer.Companion.getEmpty()) goto L35;
        r8 = DepartmentStructureComponentKt$DepartmentStructureTitleBar$1$1.INSTANCE;
        r14.updateRememberedValue(r8);
    L35:
        r14.endReplaceGroup();
        final Function0<Unit> r15 = (Function0) r8;
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventStart(655572308, r4, -1, "com.ss.android.lark.contact.customized.department.DepartmentStructureTitleBar (DepartmentStructureComponent.kt:58)");
    L40:
        Modifier.Companion r5 = Modifier.Companion;
        float r9 = 44;
        Modifier r10 = PaddingKt.padding-VpY3zN4$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(WindowInsetsPadding_androidKt.statusBarsPadding(BackgroundKt.background-bw27NRU$default(r5, n.a(r14, 0).c.b, null, 2, null)), 0.0f, 1, null), Dp.constructor-impl(r9)), Dp.constructor-impl(8), 0.0f, 2, null);
        Arrangement.Horizontal r11 = Arrangement.INSTANCE.getStart();
        Alignment.Companion r16 = Alignment.Companion;
        MeasurePolicy r13 = RowKt.rowMeasurePolicy(r11, r16.getTop(), r14, 0);
        long r17 = ComposablesKt.getCurrentCompositeKeyHashCode(r14, 0);
        int r18 = (int) (r17 ^ (r17 >>> 32));
        CompositionLocalMap r19 = r14.getCurrentCompositionLocalMap();
        Modifier r20 = ComposedModifierKt.materializeModifier(r14, r10);
        ComposeUiNode.Companion r110 = ComposeUiNode.Companion;
        Function0 r111 = r110.getConstructor();
        if ((r14.getApplier() instanceof Applier) == true) goto L43;
        ComposablesKt.invalidApplier();
    L43:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L46;
        r14.createNode(r111);
    L47:
        Composer r112 = Updater.constructor-impl(r14);
        Updater.set-impl(r112, r13, r110.getSetMeasurePolicy());
        Updater.set-impl(r112, r19, r110.getSetResolvedCompositionLocals());
        Function2 r21 = r110.getSetCompositeKeyHash();
        if (r112.getInserting() == false) goto L50;
    L51:
        r112.updateRememberedValue(Integer.valueOf(r18));
        r112.apply(Integer.valueOf(r18), r21);
    L52:
        Updater.set-impl(r112, r20, r110.getSetModifier());
        RowScopeInstance r22 = RowScopeInstance.INSTANCE;
        r14.startReplaceGroup(1849434622);
        Object r23 = r14.rememberedValue();
        Composer.Companion r30 = Composer.Companion;
        if (r23 != r30.getEmpty()) goto L55;
        r23 = InteractionSourceKt.MutableInteractionSource();
        r14.updateRememberedValue(r23);
    L55:
        MutableInteractionSource r31 = (MutableInteractionSource) r23;
        r14.endReplaceGroup();
        Painter r24 = PainterResources_androidKt.painterResource(2131233630, r14, 0);
        Modifier r25 = SizeKt.size-3ABfNKs(r5, Dp.constructor-impl(r9));
        r14.startReplaceGroup(-1633490746);
        boolean r26 = r14.changedInstance(r35);
        if ((r4 & 112) != 32) goto L58;
        boolean r27 = true;
    L59:
        boolean r28 = r27 | r26;
        Object r29 = r14.rememberedValue();
        if (r28 == false) goto L62;
    L63:
        r29 = new DepartmentStructureComponentKt$DepartmentStructureTitleBar$2$1$1(r35, r15);
        r14.updateRememberedValue(r29);
    L64:
        r14.endReplaceGroup();
        float r113 = 10;
        IconKt.Icon-ww6aTOc(r24, null, PaddingKt.padding-3ABfNKs(ClickableKt.clickable-O2vRcR0$default(r25, r31, null, false, null, null, (Function0) r29, 28, null), Dp.constructor-impl(r113)), n.a(r14, 0).d.a, r14, 48, 0);
        Modifier r32 = RowScope.-CC.weight$default(r22, SizeKt.fillMaxHeight$default(r5, 0.0f, 1, null), 1.0f, false, 2, null);
        MeasurePolicy r33 = BoxKt.maybeCachedBoxMeasurePolicy(r16.getTopStart(), false);
        long r34 = ComposablesKt.getCurrentCompositeKeyHashCode(r14, 0);
        int r40 = (int) (r34 ^ (r34 >>> 32));
        CompositionLocalMap r41 = r14.getCurrentCompositionLocalMap();
        Modifier r42 = ComposedModifierKt.materializeModifier(r14, r32);
        Function0 r43 = r110.getConstructor();
        if ((r14.getApplier() instanceof Applier) == true) goto L67;
        ComposablesKt.invalidApplier();
    L67:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L70;
        r14.createNode(r43);
    L71:
        Composer r44 = Updater.constructor-impl(r14);
        Updater.set-impl(r44, r33, r110.getSetMeasurePolicy());
        Updater.set-impl(r44, r41, r110.getSetResolvedCompositionLocals());
        Function2 r45 = r110.getSetCompositeKeyHash();
        if (r44.getInserting() == false) goto L74;
    L75:
        r44.updateRememberedValue(Integer.valueOf(r40));
        r44.apply(Integer.valueOf(r40), r45);
    L76:
        Updater.set-impl(r44, r42, r110.getSetModifier());
        BoxScopeInstance r46 = BoxScopeInstance.INSTANCE;
        DepartmentStructureViewModel.b r47 = (DepartmentStructureViewModel.b) CollectionsKt.lastOrNull((List) SnapshotStateKt.collectAsState(r35.getStack(), null, r14, 0, 1).getValue());
        if (r47 == null) goto L82;
        i r48 = r47.a;
        if (r48 == null) goto L82;
        String r49 = r48.a;
        if (r49 == null) goto L82;
    L83:
        FontWeight r114 = FontWeight.Companion.getW600();
        Function0<Unit> r310 = r15;
        TextKt.Text-Nvy7gAk(r49, SizeKt.requiredWidthIn-VpY3zN4(r46.align(r5, r16.getCenter()), Dp.constructor-impl(0), Dp.constructor-impl(TranslateModelHandler.ERROR_CODE_CANT_TRANSLATE)), 0, null, TextUnitKt.getSp(17), null, r114, null, 0, null, null, 0, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, null, null, r14, 1597440, 24960, 241580);
        r14.endNode();
        r12 = r14;
        final Context r50 = (Context) r12.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Painter r51 = PainterResources_androidKt.painterResource(2131233636, r12, 0);
        Modifier r210 = SizeKt.size-3ABfNKs(r5, Dp.constructor-impl(r9));
        r12.startReplaceGroup(5004770);
        boolean r52 = r12.changedInstance(r50);
        Object r53 = r12.rememberedValue();
        if (r52 == false) goto L86;
    L87:
        r53 = new DepartmentStructureComponentKt$DepartmentStructureTitleBar$2$3$1(r50);
        r12.updateRememberedValue(r53);
    L88:
        r12.endReplaceGroup();
        IconKt.Icon-ww6aTOc(r51, null, PaddingKt.padding-3ABfNKs(ClickableKt.clickable-O2vRcR0$default(r210, r31, null, false, null, null, (Function0) r53, 28, null), Dp.constructor-impl(r113)), n.a(r12, 0).d.a, r12, 48, 0);
        r12.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L91;
        ComposerKt.traceEventEnd();
    L91:
        r7 = r310;
        goto L92
    L86:
        if (r53 != r30.getEmpty()) goto L88;
    L82:
        r49 = BuildConfig.FLAVOR;
        goto L83
    L74:
        if (Intrinsics.areEqual(r44.rememberedValue(), Integer.valueOf(r40)) == true) goto L76;
    L70:
        r14.useNode();
        goto L71
    L62:
        if (r29 != r30.getEmpty()) goto L64;
    L58:
        r27 = false;
        goto L59
    L50:
        if (Intrinsics.areEqual(r112.rememberedValue(), Integer.valueOf(r18)) == true) goto L52;
    L46:
        r14.useNode();
        goto L47
    L36:
        r15 = r7;
        goto L38
    L17:
        if ((r38 & 48) != 0) goto L23;
        r7 = r36;
        if (r14.changedInstance(r7) == false) goto L21;
        int r54 = 32;
    L22:
        r4 = r4 | r54;
        goto L25
    L21:
        r54 = 16;
        goto L22
    L6:
        if ((r38 & 6) == 0) goto L8;
        r4 = r38;
        goto L13
    L8:
        if (r14.changedInstance(r35) == false) goto L10;
        int r55 = 4;
    L11:
        r4 = r55 | r38;
        goto L13
    L10:
        r55 = 2;
        goto L11
    }

    public static final void e(final Modifier r33, final String r34, long r35, long r37, Composer r39, final int r40, final int r41) {
        Intrinsics.checkNotNullParameter(r33, "modifier");
        Intrinsics.checkNotNullParameter(r34, "text");
        Composer r5 = r39.startRestartGroup(1561555670);
        if ((r41 & 1) == 0) goto L6;
        int r3 = r40 | 6;
    L14:
        if ((r41 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        if ((r40 & 384) != 0) goto L32;
        long r9 = r35;
        if ((r41 & 4) == 0) goto L28;
    L30:
        int r7 = 128;
    L31:
        r3 = r3 | r7;
    L34:
        if ((r40 & 3072) != 0) goto L42;
        long r11 = r37;
        if ((r41 & 8) == 0) goto L38;
    L40:
        int r8 = ChameleonContainerUtils.MAX_URL_LENGTH;
    L41:
        r3 = r3 | r8;
    L44:
        if ((r3 & 1171) == 1170) goto L46;
    L49:
        r5.startDefaults();
        if ((r40 & 1) == 0) goto L61;
        if (r5.getDefaultsInvalid() == true) goto L61;
        r5.skipToGroupEnd();
        if ((r41 & 4) == 0) goto L58;
        r3 = r3 & (-897);
    L58:
        if ((r41 & 8) != 0) goto L66;
    L67:
        long r28 = r9;
        long r30 = r11;
        int r12 = r3;
        r5.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L70;
        ComposerKt.traceEventStart(1561555670, r12, -1, "com.ss.android.lark.contact.customized.department.TextTag (DepartmentStructureComponent.kt:265)");
    L70:
        float r2 = 6;
        Modifier r4 = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU$default(ClipKt.clip(r33, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(r2))), r28, null, 2, null), Dp.constructor-impl(r2), Dp.constructor-impl(4));
        MeasurePolicy r6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        long r10 = ComposablesKt.getCurrentCompositeKeyHashCode(r5, 0);
        int r13 = (int) (r10 ^ (r10 >>> 32));
        CompositionLocalMap r14 = r5.getCurrentCompositionLocalMap();
        Modifier r15 = ComposedModifierKt.materializeModifier(r5, r4);
        ComposeUiNode.Companion r16 = ComposeUiNode.Companion;
        Function0 r17 = r16.getConstructor();
        if ((r5.getApplier() instanceof Applier) == true) goto L73;
        ComposablesKt.invalidApplier();
    L73:
        r5.startReusableNode();
        if (r5.getInserting() == false) goto L76;
        r5.createNode(r17);
    L77:
        Composer r18 = Updater.constructor-impl(r5);
        Updater.set-impl(r18, r6, r16.getSetMeasurePolicy());
        Updater.set-impl(r18, r14, r16.getSetResolvedCompositionLocals());
        Function2 r19 = r16.getSetCompositeKeyHash();
        if (r18.getInserting() == false) goto L80;
    L81:
        r18.updateRememberedValue(Integer.valueOf(r13));
        r18.apply(Integer.valueOf(r13), r19);
    L82:
        Updater.set-impl(r18, r15, r16.getSetModifier());
        BoxScopeInstance r20 = BoxScopeInstance.INSTANCE;
        int r21 = r12 >> 3;
        Composer r32 = r5;
        TextKt.Text-Nvy7gAk(r34, null, r30, null, TextUnitKt.getSp(11), null, FontWeight.Companion.getW500(), null, 0, null, null, 0, 0, false, 0, 0, null, null, r32, ((r21 & 14) | 1597440) | (r21 & 896), 0, 262058);
        r32.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L85;
        ComposerKt.traceEventEnd();
    L85:
        final long r22 = r28;
        final long r23 = r30;
    L86:
        ScopeUpdateScope r24 = r32.endRestartGroup();
        if (r24 == null) goto L90;
        r24.updateScope(new DepartmentStructureComponentKt$TextTag$2(r33, r34, r22, r23, r40, r41));
        return;
    L90:
        return;
    L80:
        if (Intrinsics.areEqual(r18.rememberedValue(), Integer.valueOf(r13)) == true) goto L82;
    L76:
        r5.useNode();
    L66:
        r3 = r3 & (-7169);
    L61:
        if ((r41 & 4) == 0) goto L64;
        r9 = ColorKt.Color(UIHelper.getColor(2131102057));
        r3 = r3 & (-897);
    L64:
        if ((r41 & 8) == 0) goto L67;
        r11 = ColorKt.Color(UIHelper.getColor(2131102049));
        goto L66
    L46:
        if (r5.getSkipping() == false) goto L49;
        r5.skipToGroupEnd();
        r32 = r5;
        r22 = r9;
        r23 = r11;
        goto L86
    L38:
        if (r5.changed(r11) == false) goto L40;
        r8 = 2048;
        goto L41
    L42:
        r11 = r37;
        goto L44
    L28:
        if (r5.changed(r9) == false) goto L30;
        r7 = 256;
        goto L31
    L32:
        r9 = r35;
        goto L34
    L17:
        if ((r40 & 48) != 0) goto L24;
        if (r5.changed(r34) == false) goto L21;
        int r25 = 32;
    L22:
        r3 = r3 | r25;
        goto L24
    L21:
        r25 = 16;
        goto L22
    L6:
        if ((r40 & 6) == 0) goto L8;
        r3 = r40;
        goto L14
    L8:
        if (r5.changed(r33) == false) goto L10;
        int r26 = 4;
    L11:
        r3 = r26 | r40;
        goto L14
    L10:
        r26 = 2;
        goto L11
    }

    public static final void a(final Modifier r26, final List<? extends mtb.c> r27, final boolean r28, Function0<Unit> r29, Function1<? super mtb.c, Unit> r30, Composer r31, final int r32, final int r33) {
        Intrinsics.checkNotNullParameter(r26, "modifier");
        Intrinsics.checkNotNullParameter(r27, Keys.API_RETURN_KEY_DATA);
        Composer r12 = r31.startRestartGroup(-377467332);
        if ((r33 & 1) == 0) goto L6;
        int r1 = r32 | 6;
    L14:
        if ((r33 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r33 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L33:
        int r2 = r33 & 8;
        if (r2 == 0) goto L37;
        r1 = r1 | 3072;
    L43:
        Function0<Unit> r5 = r29;
    L44:
        int r6 = r33 & 16;
        if (r6 == 0) goto L48;
        r1 = r1 | 24576;
    L54:
        Function1<? super mtb.c, Unit> r8 = r30;
    L55:
        int r9 = r1;
        if ((r9 & 9363) != 9362) goto L62;
        if (r12.getSkipping() == false) goto L62;
        r12.skipToGroupEnd();
        final Function0<Unit> r4 = r5;
        final Function1<? super mtb.c, Unit> r7 = r8;
    L100:
        ScopeUpdateScope r10 = r12.endRestartGroup();
        if (r10 == null) goto L104;
        r10.updateScope(new DepartmentStructureComponentKt$DepartmentStructureList$4(r26, r27, r28, r4, r7, r32, r33));
        return;
    L104:
        return;
    L62:
        if (r2 == 0) goto L67;
        r12.startReplaceGroup(1849434622);
        Object r3 = r12.rememberedValue();
        if (r3 != Composer.Companion.getEmpty()) goto L66;
        r3 = DepartmentStructureComponentKt$DepartmentStructureList$1$1.INSTANCE;
        r12.updateRememberedValue(r3);
    L66:
        r12.endReplaceGroup();
        Function0<Unit> r16 = (Function0) r3;
    L68:
        if (r6 == 0) goto L73;
        r12.startReplaceGroup(1849434622);
        Object r11 = r12.rememberedValue();
        if (r11 != Composer.Companion.getEmpty()) goto L72;
        r11 = DepartmentStructureComponentKt$DepartmentStructureList$2$1.INSTANCE;
        r12.updateRememberedValue(r11);
    L72:
        r12.endReplaceGroup();
        Function1<? super mtb.c, Unit> r17 = (Function1) r11;
    L75:
        if (ComposerKt.isTraceInProgress() == false) goto L77;
        ComposerKt.traceEventStart(-377467332, r9, -1, "com.ss.android.lark.contact.customized.department.DepartmentStructureList (DepartmentStructureComponent.kt:113)");
    L77:
        r12.startReplaceGroup(1849434622);
        Object r0 = r12.rememberedValue();
        Composer.Companion r13 = Composer.Companion;
        if (r0 != r13.getEmpty()) goto L80;
        r0 = InteractionSourceKt.MutableInteractionSource();
        r12.updateRememberedValue(r0);
    L80:
        final MutableInteractionSource r14 = (MutableInteractionSource) r0;
        r12.endReplaceGroup();
        r12.startReplaceGroup(-1224400529);
        boolean r15 = r12.changedInstance(r27);
        boolean r23 = false;
        if ((57344 & r9) != 16384) goto L83;
        boolean r18 = true;
    L84:
        boolean r19 = r15 | r18;
        if ((r9 & 896) != 256) goto L87;
        boolean r20 = true;
    L88:
        boolean r21 = r19 | r20;
        if ((r9 & 7168) != 2048) goto L91;
        r23 = true;
    L91:
        boolean r22 = r21 | r23;
        Object r24 = r12.rememberedValue();
        if (r22 == false) goto L94;
    L95:
        final Function1<? super mtb.c, Unit> r25 = r17;
        final Function0<Unit> r34 = r16;
        Function1<LazyListScope, Unit> r35 = new DepartmentStructureComponentKt$DepartmentStructureList$3$1(r27, r14, r25, r28, r34);
        r12.updateRememberedValue(r35);
        r24 = r35;
    L96:
        r12.endReplaceGroup();
        LazyDslKt.LazyColumn(r26, null, null, false, null, null, null, false, null, (Function1) r24, r12, r9 & 14, 510);
        if (ComposerKt.isTraceInProgress() == false) goto L99;
        ComposerKt.traceEventEnd();
    L99:
        r4 = r16;
        r7 = r17;
        goto L100
    L94:
        if (r24 != r13.getEmpty()) goto L96;
    L87:
        r20 = false;
        goto L88
    L83:
        r18 = false;
        goto L84
    L73:
        r17 = r8;
        goto L75
    L67:
        r16 = r5;
        goto L68
    L48:
        if ((r32 & 24576) != 0) goto L54;
        r8 = r30;
        if (r12.changedInstance(r8) == false) goto L52;
        int r36 = 16384;
    L53:
        r1 = r1 | r36;
        goto L55
    L52:
        r36 = 8192;
        goto L53
    L37:
        if ((r32 & 3072) != 0) goto L43;
        r5 = r29;
        if (r12.changedInstance(r5) == false) goto L41;
        int r37 = 2048;
    L42:
        r1 = r1 | r37;
        goto L44
    L41:
        r37 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L42
    L27:
        if ((r32 & 384) != 0) goto L33;
        if (r12.changed(r28) == false) goto L31;
        int r38 = 256;
    L32:
        r1 = r1 | r38;
        goto L33
    L31:
        r38 = 128;
        goto L32
    L17:
        if ((r32 & 48) != 0) goto L24;
        if (r12.changedInstance(r27) == false) goto L21;
        int r39 = 32;
    L22:
        r1 = r1 | r39;
        goto L24
    L21:
        r39 = 16;
        goto L22
    L6:
        if ((r32 & 6) == 0) goto L8;
        r1 = r32;
        goto L14
    L8:
        if (r12.changed(r26) == false) goto L10;
        int r40 = 4;
    L11:
        r1 = r40 | r32;
        goto L14
    L10:
        r40 = 2;
        goto L11
    }
}
