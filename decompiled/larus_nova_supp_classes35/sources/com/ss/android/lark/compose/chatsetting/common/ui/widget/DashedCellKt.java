package com.ss.android.lark.compose.chatsetting.common.ui.widget;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.compose.util.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DashedCellKt {
    public static final void a(Modifier r37, final ImageVector r38, final String r39, final long r40, Function0<Unit> r42, Composer r43, final int r44, final int r45) {
        Intrinsics.checkNotNullParameter(r38, "icon");
        Intrinsics.checkNotNullParameter(r39, "label");
        Composer r9 = r43.startRestartGroup(1120777858);
        int r1 = r45 & 1;
        if (r1 == 0) goto L6;
        int r4 = r44 | 6;
        Modifier r3 = r37;
    L14:
        if ((r45 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L24:
        if ((r45 & 4) == 0) goto L27;
        r4 = r4 | 384;
    L34:
        if ((r45 & 8) == 0) goto L37;
        r4 = r4 | 3072;
    L43:
        int r5 = r45 & 16;
        if (r5 == 0) goto L47;
        r4 = r4 | 24576;
    L53:
        Function0<Unit> r7 = r42;
    L54:
        int r10 = r4;
        if ((r10 & 9363) == 9362) goto L57;
    L60:
        if (r1 == 0) goto L62;
        r3 = Modifier.Companion;
    L62:
        if (r5 == 0) goto L68;
        r9.startReplaceGroup(1849434622);
        Object r2 = r9.rememberedValue();
        if (r2 != Composer.Companion.getEmpty()) goto L66;
        r2 = DashedCellKt$DashedCell$1$1.INSTANCE;
        r9.updateRememberedValue(r2);
    L66:
        r9.endReplaceGroup();
        r7 = (Function0) r2;
    L68:
        if (ComposerKt.isTraceInProgress() == false) goto L70;
        ComposerKt.traceEventStart(1120777858, r10, -1, "com.ss.android.lark.compose.chatsetting.common.ui.widget.DashedCell (DashedCell.kt:36)");
    L70:
        Alignment.Companion r0 = Alignment.Companion;
        Alignment.Horizontal r6 = r0.getCenterHorizontally();
        float r8 = 56;
        Modifier r11 = SizeKt.width-3ABfNKs(r3, Dp.constructor-impl(r8));
        MeasurePolicy r12 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), r6, r9, 48);
        long r16 = ComposablesKt.getCurrentCompositeKeyHashCode(r9, 0);
        Function0<Unit> r23 = r7;
        int r13 = (int) (r16 ^ (r16 >>> 32));
        CompositionLocalMap r14 = r9.getCurrentCompositionLocalMap();
        Modifier r15 = ComposedModifierKt.materializeModifier(r9, r11);
        ComposeUiNode.Companion r24 = ComposeUiNode.Companion;
        Function0 r17 = r24.getConstructor();
        if ((r9.getApplier() instanceof Applier) == true) goto L73;
        ComposablesKt.invalidApplier();
    L73:
        r9.startReusableNode();
        if (r9.getInserting() == false) goto L76;
        r9.createNode(r17);
    L77:
        Composer r18 = Updater.constructor-impl(r9);
        Updater.set-impl(r18, r12, r24.getSetMeasurePolicy());
        Updater.set-impl(r18, r14, r24.getSetResolvedCompositionLocals());
        Function2 r19 = r24.getSetCompositeKeyHash();
        if (r18.getInserting() == false) goto L80;
    L81:
        r18.updateRememberedValue(Integer.valueOf(r13));
        r18.apply(Integer.valueOf(r13), r19);
    L82:
        Updater.set-impl(r18, r15, r24.getSetModifier());
        ColumnScopeInstance r20 = ColumnScopeInstance.INSTANCE;
        Modifier.Companion r21 = Modifier.Companion;
        float r22 = 28;
        Modifier r25 = ClipKt.clip(SizeKt.size-3ABfNKs(r21, Dp.constructor-impl(r8)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(r22)));
        final float r26 = Dp.constructor-impl((float) 1.5d);
        final float r110 = Dp.constructor-impl(r22);
        final float r27 = Dp.constructor-impl(2);
        final float r111 = Dp.constructor-impl(3);
        final float r112 = Dp.constructor-impl(0);
        final float r28 = 0.25f;
        Modifier r29 = e.a(DrawModifierKt.drawWithCache(r25, new DashedCellKt$dashedBorder$1(r26, r27, r111, r112, r110, r40, r28)), r23, r9, (r10 << 3) & 458752);
        MeasurePolicy r30 = BoxKt.maybeCachedBoxMeasurePolicy(r0.getCenter(), false);
        long r31 = ComposablesKt.getCurrentCompositeKeyHashCode(r9, 0);
        int r32 = (int) (r31 ^ (r31 >>> 32));
        CompositionLocalMap r33 = r9.getCurrentCompositionLocalMap();
        Modifier r34 = ComposedModifierKt.materializeModifier(r9, r29);
        Function0 r35 = r24.getConstructor();
        if ((r9.getApplier() instanceof Applier) == true) goto L85;
        ComposablesKt.invalidApplier();
    L85:
        r9.startReusableNode();
        if (r9.getInserting() == false) goto L88;
        r9.createNode(r35);
    L89:
        Composer r36 = Updater.constructor-impl(r9);
        Updater.set-impl(r36, r30, r24.getSetMeasurePolicy());
        Updater.set-impl(r36, r33, r24.getSetResolvedCompositionLocals());
        Function2 r41 = r24.getSetCompositeKeyHash();
        if (r36.getInserting() == false) goto L92;
    L93:
        r36.updateRememberedValue(Integer.valueOf(r32));
        r36.apply(Integer.valueOf(r32), r41);
    L94:
        Updater.set-impl(r36, r34, r24.getSetModifier());
        BoxScopeInstance r46 = BoxScopeInstance.INSTANCE;
        int r113 = r10 >> 3;
        Modifier r310 = r3;
        IconKt.Icon-ww6aTOc(r38, r39, SizeKt.size-3ABfNKs(r21, Dp.constructor-impl(20)), r40, r9, (((r113 & 14) | 384) | (r113 & 112)) | (r10 & 7168), 0);
        r9.endNode();
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(r21, Dp.constructor-impl(6)), r9, 6);
        Composer r47 = r9;
        TextKt.Text-Nvy7gAk(r39, null, r40, null, 0, null, null, null, 0, null, null, 0, 0, false, 1, 0, null, n.b(r9).d, r47, ((r10 >> 6) & 14) | (r113 & 896), 24576, 114682);
        r47.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L97;
        ComposerKt.traceEventEnd();
    L97:
        final Modifier r48 = r310;
        final Function0<Unit> r49 = r23;
    L98:
        ScopeUpdateScope r50 = r47.endRestartGroup();
        if (r50 == null) goto L102;
        r50.updateScope(new DashedCellKt$DashedCell$3(r48, r38, r39, r40, r49, r44, r45));
        return;
    L102:
        return;
    L92:
        if (Intrinsics.areEqual(r36.rememberedValue(), Integer.valueOf(r32)) == true) goto L94;
    L88:
        r9.useNode();
        goto L89
    L80:
        if (Intrinsics.areEqual(r18.rememberedValue(), Integer.valueOf(r13)) == true) goto L82;
    L76:
        r9.useNode();
        goto L77
    L57:
        if (r9.getSkipping() == false) goto L60;
        r9.skipToGroupEnd();
        r48 = r3;
        r49 = r7;
        r47 = r9;
        goto L98
    L47:
        if ((r44 & 24576) != 0) goto L53;
        r7 = r42;
        if (r9.changedInstance(r7) == false) goto L51;
        int r114 = 16384;
    L52:
        r4 = r4 | r114;
        goto L54
    L51:
        r114 = 8192;
        goto L52
    L37:
        if ((r44 & 3072) != 0) goto L43;
        if (r9.changed(r40) == false) goto L41;
        int r51 = 2048;
    L42:
        r4 = r4 | r51;
        goto L43
    L41:
        r51 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L42
    L27:
        if ((r44 & 384) != 0) goto L34;
        if (r9.changed(r39) == false) goto L31;
        int r52 = 256;
    L32:
        r4 = r4 | r52;
        goto L34
    L31:
        r52 = 128;
        goto L32
    L17:
        if ((r44 & 48) != 0) goto L24;
        if (r9.changed(r38) == false) goto L21;
        int r53 = 32;
    L22:
        r4 = r4 | r53;
        goto L24
    L21:
        r53 = 16;
        goto L22
    L6:
        if ((r44 & 6) != 0) goto L12;
        r3 = r37;
        if (r9.changed(r3) == false) goto L10;
        int r54 = 4;
    L11:
        r4 = r54 | r44;
        goto L14
    L10:
        r54 = 2;
        goto L11
    L12:
        r3 = r37;
        r4 = r44;
        goto L14
    }
}
