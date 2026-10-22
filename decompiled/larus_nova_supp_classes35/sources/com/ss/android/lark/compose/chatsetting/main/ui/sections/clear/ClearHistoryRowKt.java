package com.ss.android.lark.compose.chatsetting.main.ui.sections.clear;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import com.ss.android.lark.compose.chatsetting.common.platform.b;
import com.ss.android.lark.compose.chatsetting.common.ui.icon.ChatSettingIcons;
import com.ss.android.lark.compose.chatsetting.common.ui.widget.StandardSettingRowKt;
import com.ss.android.lark.compose.chatsetting.common.ui.widget.a;
import com.ss.android.lark.compose.foundation.dialog.FlowAlertDialogKt;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.flow.chat.resources.CommonMainString0;
import com.ss.android.lark.flow.chat.resources.c;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.b0;
import org.jetbrains.compose.resources.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ClearHistoryRowKt {
    public static final void a(final Function0<Unit> r25, final b r26, Composer r27, final int r28) {
        Intrinsics.checkNotNullParameter(r25, "onConfirmClick");
        Intrinsics.checkNotNullParameter(r26, "platformEffects");
        Composer r13 = r27.startRestartGroup(1931073627);
        if ((r28 & 6) == 0) goto L5;
        int r4 = r28;
    L11:
        if ((r28 & 48) == 0) goto L13;
    L20:
        int r14 = r4;
        if ((r14 & 19) != 18) goto L27;
        if (r13.getSkipping() == false) goto L27;
        r13.skipToGroupEnd();
        Composer r1 = r13;
    L80:
        ScopeUpdateScope r2 = r1.endRestartGroup();
        if (r2 == null) goto L84;
        r2.updateScope(new ClearHistoryRowKt$ClearHistoryRow$2(r25, r26, r28));
        return;
    L84:
        return;
    L27:
        if (ComposerKt.isTraceInProgress() == false) goto L29;
        ComposerKt.traceEventStart(1931073627, r14, -1, "com.ss.android.lark.compose.chatsetting.main.ui.sections.clear.ClearHistoryRow (ClearHistoryRow.kt:30)");
    L29:
        Modifier.Companion r15 = Modifier.Companion;
        MeasurePolicy r3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        long r8 = ComposablesKt.getCurrentCompositeKeyHashCode(r13, 0);
        int r5 = (int) (r8 ^ (r8 >>> 32));
        CompositionLocalMap r6 = r13.getCurrentCompositionLocalMap();
        Modifier r9 = ComposedModifierKt.materializeModifier(r13, r15);
        ComposeUiNode.Companion r10 = ComposeUiNode.Companion;
        Function0 r11 = r10.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L32;
        ComposablesKt.invalidApplier();
    L32:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L35;
        r13.createNode(r11);
    L36:
        Composer r12 = Updater.constructor-impl(r13);
        Updater.set-impl(r12, r3, r10.getSetMeasurePolicy());
        Updater.set-impl(r12, r6, r10.getSetResolvedCompositionLocals());
        Function2 r7 = r10.getSetCompositeKeyHash();
        if (r12.getInserting() == false) goto L39;
    L40:
        r12.updateRememberedValue(Integer.valueOf(r5));
        r12.apply(Integer.valueOf(r5), r7);
    L41:
        Updater.set-impl(r12, r9, r10.getSetModifier());
        BoxScopeInstance r16 = BoxScopeInstance.INSTANCE;
        r13.startReplaceGroup(1849434622);
        Object r17 = r13.rememberedValue();
        Composer.Companion r18 = Composer.Companion;
        if (r17 != r18.getEmpty()) goto L44;
        r17 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        r13.updateRememberedValue(r17);
    L44:
        final MutableState r19 = (MutableState) r17;
        r13.endReplaceGroup();
        r13.startReplaceGroup(-1633490746);
        if ((r14 & 112) != 32) goto L47;
    L52:
        boolean r20 = true;
    L53:
        Object r21 = r13.rememberedValue();
        if (r20 == false) goto L56;
    L57:
        r21 = new ClearHistoryRowKt$ClearHistoryRow$1$1$1(r26, r19);
        r13.updateRememberedValue(r21);
    L58:
        r13.endReplaceGroup();
        Modifier r22 = ClickableKt.clickable-oSLSa3U$default(r15, false, null, null, null, (Function0) r21, 15, null);
        com.ss.android.lark.flow.chat.resources.b r110 = com.ss.android.lark.flow.chat.resources.b.a;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        StandardSettingRowKt.a(r22, b0.a((z) CommonMainString0.K.getValue(), r13), new a((ImageVector) ChatSettingIcons.g.getValue(), Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.Color(4294611088L)), Color.box-impl(ColorKt.Color(4294521651L))}), 0.0f, 0.0f, 0, 14, null)), null, false, r13, 24576, 8);
        r13.startReplaceGroup(805032765);
        if (((Boolean) r19.getValue()).booleanValue() == false) goto L76;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r23 = b0.a((z) CommonMainString0.Y1.getValue(), r13);
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r24 = b0.a((z) CommonMainString0.X1.getValue(), r13);
        String r29 = b0.a(c.a(), r13);
        long r30 = n.a(r13, 0).e.a;
        r13.startReplaceGroup(-1633490746);
        if ((r14 & 14) != 4) goto L63;
        boolean r111 = true;
    L64:
        Object r31 = r13.rememberedValue();
        if (r111 == false) goto L67;
    L68:
        r31 = new ClearHistoryRowKt$ClearHistoryRow$1$2$1(r25, r19);
        r13.updateRememberedValue(r31);
    L69:
        Function0 r32 = (Function0) r31;
        r13.endReplaceGroup();
        r13.startReplaceGroup(5004770);
        Object r112 = r13.rememberedValue();
        if (r112 != r18.getEmpty()) goto L72;
        r112 = new ClearHistoryRowKt$ClearHistoryRow$1$3$1(r19);
        r13.updateRememberedValue(r112);
    L72:
        Function0 r113 = (Function0) r112;
        r13.endReplaceGroup();
        r13.startReplaceGroup(5004770);
        Object r33 = r13.rememberedValue();
        if (r33 != r18.getEmpty()) goto L75;
        r33 = new ClearHistoryRowKt$ClearHistoryRow$1$4$1(r19);
        r13.updateRememberedValue(r33);
    L75:
        r13.endReplaceGroup();
        r1 = r13;
        FlowAlertDialogKt.a(null, r23, r24, r29, r30, 0, r32, r113, (Function0) r33, true, true, r1, 918552576, 6, 33);
    L77:
        r1.endReplaceGroup();
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L80;
        ComposerKt.traceEventEnd();
        goto L80
    L67:
        if (r31 != r18.getEmpty()) goto L69;
    L63:
        r111 = false;
        goto L64
    L76:
        r1 = r13;
        goto L77
    L56:
        if (r21 != r18.getEmpty()) goto L58;
    L47:
        if ((r14 & 64) != 0) goto L49;
    L51:
        r20 = false;
        goto L53
    L49:
        if (r13.changedInstance(r26) == false) goto L51;
    L39:
        if (Intrinsics.areEqual(r12.rememberedValue(), Integer.valueOf(r5)) == true) goto L41;
    L35:
        r13.useNode();
        goto L36
    L13:
        if ((r28 & 64) != 0) goto L15;
        boolean r34 = r13.changed(r26);
    L16:
        if (r34 == false) goto L18;
        int r35 = 32;
    L19:
        r4 = r4 | r35;
        goto L20
    L18:
        r35 = 16;
        goto L19
    L15:
        r34 = r13.changedInstance(r26);
        goto L16
    L5:
        if (r13.changedInstance(r25) == false) goto L7;
        int r36 = 4;
    L8:
        r4 = r36 | r28;
        goto L11
    L7:
        r36 = 2;
        goto L8
    }
}
