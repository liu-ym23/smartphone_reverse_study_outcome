package com.ss.android.lark.compose.groupinfo.components;

import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.material3.IconButtonKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.flow.chat.resources.CommonMainString0;
import com.ss.android.lark.flow.chat.resources.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.b0;
import org.jetbrains.compose.resources.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class GroupInfoNameInputKt {
    public static final void a(final String r76, final boolean r77, Modifier r78, final Function1<? super String, Unit> r79, Composer r80, final int r81, final int r82) {
        Intrinsics.checkNotNullParameter(r76, "groupName");
        Intrinsics.checkNotNullParameter(r79, "onNameChange");
        Composer r4 = r80.startRestartGroup(-1843945826);
        if ((r82 & 1) == 0) goto L6;
        int r6 = r81 | 6;
    L14:
        if ((r82 & 2) == 0) goto L17;
        r6 = r6 | 48;
    L23:
        int r8 = r82 & 4;
        if (r8 == 0) goto L27;
        r6 = r6 | 384;
    L33:
        Modifier r9 = r78;
    L35:
        if ((r82 & 8) == 0) goto L38;
        r6 = r6 | 3072;
    L44:
        int r10 = r6;
        if ((r10 & 1171) == 1170) goto L47;
    L50:
        if (r8 == 0) goto L52;
        Modifier r33 = Modifier.Companion;
    L54:
        if (ComposerKt.isTraceInProgress() == false) goto L56;
        ComposerKt.traceEventStart(-1843945826, r10, -1, "com.ss.android.lark.compose.groupinfo.components.NameInputSection (GroupInfoNameInput.kt:38)");
    L56:
        float r1 = 16;
        Modifier r7 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(r33, 0.0f, Dp.constructor-impl(r1), 0.0f, 0.0f, 13, null), 0.0f, 1, null), Dp.constructor-impl(r1), 0.0f, 2, null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(r1))), n.a(r4, 0).c.c, null, 2, null);
        Arrangement r11 = Arrangement.INSTANCE;
        Arrangement.Vertical r12 = r11.getTop();
        Alignment.Companion r34 = Alignment.Companion;
        MeasurePolicy r13 = ColumnKt.columnMeasurePolicy(r12, r34.getStart(), r4, 0);
        long r16 = ComposablesKt.getCurrentCompositeKeyHashCode(r4, 0);
        int r14 = (int) (r16 ^ (r16 >>> 32));
        CompositionLocalMap r15 = r4.getCurrentCompositionLocalMap();
        Modifier r17 = ComposedModifierKt.materializeModifier(r4, r7);
        ComposeUiNode.Companion r35 = ComposeUiNode.Companion;
        Function0 r18 = r35.getConstructor();
        if ((r4.getApplier() instanceof Applier) == true) goto L59;
        ComposablesKt.invalidApplier();
    L59:
        r4.startReusableNode();
        if (r4.getInserting() == false) goto L62;
        r4.createNode(r18);
    L63:
        Composer r19 = Updater.constructor-impl(r4);
        Updater.set-impl(r19, r13, r35.getSetMeasurePolicy());
        Updater.set-impl(r19, r15, r35.getSetResolvedCompositionLocals());
        Function2 r20 = r35.getSetCompositeKeyHash();
        if (r19.getInserting() == false) goto L66;
    L67:
        r19.updateRememberedValue(Integer.valueOf(r14));
        r19.apply(Integer.valueOf(r14), r20);
    L68:
        Updater.set-impl(r19, r17, r35.getSetModifier());
        ColumnScopeInstance r21 = ColumnScopeInstance.INSTANCE;
        Modifier r110 = Modifier.Companion;
        float r111 = 48;
        Modifier r22 = SizeKt.height-3ABfNKs(r110, Dp.constructor-impl(r111));
        MeasurePolicy r23 = RowKt.rowMeasurePolicy(r11.getStart(), r34.getCenterVertically(), r4, 48);
        long r112 = ComposablesKt.getCurrentCompositeKeyHashCode(r4, 0);
        int r24 = (int) (r112 ^ (r112 >>> 32));
        CompositionLocalMap r113 = r4.getCurrentCompositionLocalMap();
        Modifier r25 = ComposedModifierKt.materializeModifier(r4, r22);
        Function0 r114 = r35.getConstructor();
        if ((r4.getApplier() instanceof Applier) == true) goto L71;
        ComposablesKt.invalidApplier();
    L71:
        r4.startReusableNode();
        if (r4.getInserting() == false) goto L74;
        r4.createNode(r114);
    L75:
        Composer r26 = Updater.constructor-impl(r4);
        Updater.set-impl(r26, r23, r35.getSetMeasurePolicy());
        Updater.set-impl(r26, r113, r35.getSetResolvedCompositionLocals());
        Function2 r27 = r35.getSetCompositeKeyHash();
        if (r26.getInserting() == false) goto L78;
    L79:
        r26.updateRememberedValue(Integer.valueOf(r24));
        r26.apply(Integer.valueOf(r24), r27);
    L80:
        Updater.set-impl(r26, r25, r35.getSetModifier());
        RowScopeInstance r36 = RowScopeInstance.INSTANCE;
        Modifier r28 = PaddingKt.padding-qDBjuR0$default(r110, Dp.constructor-impl(r1), 0.0f, 0.0f, 0.0f, 14, null);
        Intrinsics.checkNotNullParameter(b.a, "<this>");
        String r29 = b0.a((z) CommonMainString0.p0.getValue(), r4);
        long r115 = TextUnitKt.getSp(16);
        FontWeight.Companion r37 = FontWeight.Companion;
        TextKt.Text-Nvy7gAk(r29, r28, n.a(r4, 0).d.a, null, r115, null, r37.getMedium(), null, 0, null, null, 0, 0, false, 0, 0, null, null, r4, 1597488, 0, 262056);
        SpacerKt.Spacer(SizeKt.width-3ABfNKs(r110, Dp.constructor-impl(r1)), r4, 6);
        Modifier r116 = RowScope.-CC.weight$default(r36, r110, 1.0f, false, 2, null);
        TextStyle r210 = new TextStyle(n.a(r4, 0).d.a, TextUnitKt.getSp(16), r37.getNormal(), null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777208, null);
        r4.startReplaceGroup(5004770);
        int r117 = r10 & 7168;
        if (r117 != 2048) goto L83;
        boolean r30 = true;
    L84:
        Object r31 = r4.rememberedValue();
        if (r30 == false) goto L87;
    L88:
        r31 = new GroupInfoNameInputKt$NameInputSection$1$1$1$1(r79);
        r4.updateRememberedValue(r31);
    L89:
        r4.endReplaceGroup();
        BasicTextFieldKt.BasicTextField(r76, (Function1) r31, r116, r77, false, r210, null, null, true, 0, 0, null, null, null, null, null, r4, ((r10 & 14) | 100663296) | ((r10 << 6) & 7168), 0, 65232);
        if (r77 == false) goto L103;
        Composer r2 = r4;
        r2.startReplaceGroup(1604079913);
        r2.startReplaceGroup(5004770);
        if (r117 != 2048) goto L94;
        boolean r32 = true;
    L95:
        Object r0 = r2.rememberedValue();
        if (r32 == false) goto L98;
    L101:
        r0 = new GroupInfoNameInputKt$NameInputSection$1$1$2$1(r79);
        r2.updateRememberedValue(r0);
    L102:
        r2.endReplaceGroup();
        Modifier r118 = r110;
        IconButtonKt.IconButton((Function0) r0, SizeKt.size-3ABfNKs(r118, Dp.constructor-impl(r111)), false, null, null, null, ComposableSingletons$GroupInfoNameInputKt.a, r2, 1572912, 60);
        r2.endReplaceGroup();
    L104:
        r2.endNode();
        r2.startReplaceGroup(-2027681248);
        if (r77 == false) goto L119;
        Modifier r3 = SizeKt.fillMaxWidth$default(r118, 0.0f, 1, null);
        MeasurePolicy r5 = BoxKt.maybeCachedBoxMeasurePolicy(r34.getTopStart(), false);
        long r38 = ComposablesKt.getCurrentCompositeKeyHashCode(r2, 0);
        int r39 = (int) (r38 ^ (r38 >>> 32));
        CompositionLocalMap r40 = r2.getCurrentCompositionLocalMap();
        Modifier r41 = ComposedModifierKt.materializeModifier(r2, r3);
        Function0 r42 = r35.getConstructor();
        if ((r2.getApplier() instanceof Applier) == true) goto L109;
        ComposablesKt.invalidApplier();
    L109:
        r2.startReusableNode();
        if (r2.getInserting() == false) goto L112;
        r2.createNode(r42);
    L113:
        Composer r43 = Updater.constructor-impl(r2);
        Updater.set-impl(r43, r5, r35.getSetMeasurePolicy());
        Updater.set-impl(r43, r40, r35.getSetResolvedCompositionLocals());
        Function2 r44 = r35.getSetCompositeKeyHash();
        if (r43.getInserting() == false) goto L116;
    L117:
        r43.updateRememberedValue(Integer.valueOf(r39));
        r43.apply(Integer.valueOf(r39), r44);
    L118:
        Updater.set-impl(r43, r41, r35.getSetModifier());
        BoxScopeInstance r45 = BoxScopeInstance.INSTANCE;
        String r46 = r76.length() + "/60";
        long r47 = TextUnitKt.getSp(12);
        TextKt.Text-Nvy7gAk(r46, PaddingKt.padding-qDBjuR0$default(r45.align(r118, r34.getBottomEnd()), 0.0f, 0.0f, Dp.constructor-impl(r1), Dp.constructor-impl(8), 3, null), n.a(r2, 0).d.c, null, r47, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, r2, 24576, 0, 262120);
        r2.endNode();
        goto L119
    L116:
        if (Intrinsics.areEqual(r43.rememberedValue(), Integer.valueOf(r39)) == true) goto L118;
    L112:
        r2.useNode();
    L119:
        r2.endReplaceGroup();
        r2.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L122;
        ComposerKt.traceEventEnd();
    L122:
        final Modifier r48 = r33;
    L123:
        ScopeUpdateScope r49 = r2.endRestartGroup();
        if (r49 == null) goto L127;
        r49.updateScope(new GroupInfoNameInputKt$NameInputSection$2(r76, r77, r48, r79, r81, r82));
        return;
    L127:
        return;
    L98:
        if (r0 != Composer.Companion.getEmpty()) goto L102;
    L94:
        r32 = false;
        goto L95
    L103:
        r2 = r4;
        r118 = r110;
        r2.startReplaceGroup(1604488834);
        SpacerKt.Spacer(SizeKt.width-3ABfNKs(r118, Dp.constructor-impl(r1)), r2, 6);
        r2.endReplaceGroup();
        goto L104
    L87:
        if (r31 != Composer.Companion.getEmpty()) goto L89;
    L83:
        r30 = false;
        goto L84
    L78:
        if (Intrinsics.areEqual(r26.rememberedValue(), Integer.valueOf(r24)) == true) goto L80;
    L74:
        r4.useNode();
        goto L75
    L66:
        if (Intrinsics.areEqual(r19.rememberedValue(), Integer.valueOf(r14)) == true) goto L68;
    L62:
        r4.useNode();
        goto L63
    L52:
        r33 = r9;
        goto L54
    L47:
        if (r4.getSkipping() == false) goto L50;
        r4.skipToGroupEnd();
        r2 = r4;
        r48 = r9;
        goto L123
    L38:
        if ((r81 & 3072) != 0) goto L44;
        if (r4.changedInstance(r79) == false) goto L42;
        int r119 = 2048;
    L43:
        r6 = r6 | r119;
        goto L44
    L42:
        r119 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L43
    L27:
        if ((r81 & 384) != 0) goto L33;
        r9 = r78;
        if (r4.changed(r9) == false) goto L31;
        int r120 = 256;
    L32:
        r6 = r6 | r120;
        goto L35
    L31:
        r120 = 128;
        goto L32
    L17:
        if ((r81 & 48) != 0) goto L23;
        if (r4.changed(r77) == false) goto L21;
        int r50 = 32;
    L22:
        r6 = r6 | r50;
        goto L23
    L21:
        r50 = 16;
        goto L22
    L6:
        if ((r81 & 6) == 0) goto L8;
        r6 = r81;
        goto L14
    L8:
        if (r4.changed(r76) == false) goto L10;
        int r51 = 4;
    L11:
        r6 = r51 | r81;
        goto L14
    L10:
        r51 = 2;
        goto L11
    }
}
