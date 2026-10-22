package com.ss.android.lark.compose.chatsetting.common.ui.widget;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.compose.foundation.widget.FlowSwitchKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class SwitchSettingRowKt {
    public static final void a(final String r34, final com.ss.android.lark.compose.foundation.widget.a r35, final Function1<? super Boolean, Unit> r36, Modifier r37, a r38, boolean r39, Composer r40, final int r41, final int r42) {
        Intrinsics.checkNotNullParameter(r34, "title");
        Intrinsics.checkNotNullParameter(r35, "switchState");
        Intrinsics.checkNotNullParameter(r36, "onCheckedChange");
        Composer r13 = r40.startRestartGroup(-649251064);
        if ((r42 & 1) == 0) goto L6;
        int r2 = r41 | 6;
    L14:
        if ((r42 & 2) == 0) goto L17;
        r2 = r2 | 48;
    L24:
        if ((r42 & 4) == 0) goto L27;
        r2 = r2 | 384;
    L33:
        int r5 = r42 & 8;
        if (r5 == 0) goto L37;
        r2 = r2 | 3072;
    L43:
        Modifier r8 = r37;
    L44:
        int r9 = r42 & 16;
        if (r9 == 0) goto L48;
        r2 = r2 | 24576;
    L54:
        a r10 = r38;
    L55:
        int r11 = r42 & 32;
        if (r11 == 0) goto L59;
        r2 = r2 | 196608;
    L65:
        boolean r12 = r39;
    L67:
        if ((r2 & 74899) == 74898) goto L69;
    L72:
        if (r5 == 0) goto L75;
        r8 = Modifier.Companion;
    L75:
        if (r9 == 0) goto L78;
        r10 = null;
    L78:
        if (r11 == 0) goto L80;
        boolean r26 = true;
    L82:
        if (ComposerKt.isTraceInProgress() == false) goto L84;
        ComposerKt.traceEventStart(-649251064, r2, -1, "com.ss.android.lark.compose.chatsetting.common.ui.widget.SwitchSettingRow (SwitchSettingRow.kt:29)");
    L84:
        Modifier r1 = PaddingKt.padding-VpY3zN4(SizeKt.heightIn-VpY3zN4$default(SizeKt.fillMaxWidth$default(r8, 0.0f, 1, null), Dp.constructor-impl(56), 0.0f, 2, null), Dp.constructor-impl(16), Dp.constructor-impl(8));
        MeasurePolicy r6 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getCenterVertically(), r13, 48);
        long r14 = ComposablesKt.getCurrentCompositeKeyHashCode(r13, 0);
        int r15 = (int) (r14 ^ (r14 >>> 32));
        CompositionLocalMap r16 = r13.getCurrentCompositionLocalMap();
        Modifier r3 = ComposedModifierKt.materializeModifier(r13, r1);
        ComposeUiNode.Companion r17 = ComposeUiNode.Companion;
        Function0 r4 = r17.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L87;
        ComposablesKt.invalidApplier();
    L87:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L90;
        r13.createNode(r4);
    L91:
        Composer r7 = Updater.constructor-impl(r13);
        Updater.set-impl(r7, r6, r17.getSetMeasurePolicy());
        Updater.set-impl(r7, r16, r17.getSetResolvedCompositionLocals());
        Function2 r18 = r17.getSetCompositeKeyHash();
        if (r7.getInserting() == false) goto L94;
    L95:
        r7.updateRememberedValue(Integer.valueOf(r15));
        r7.apply(Integer.valueOf(r15), r18);
    L96:
        Updater.set-impl(r7, r3, r17.getSetModifier());
        RowScopeInstance r19 = RowScopeInstance.INSTANCE;
        r13.startReplaceGroup(1879203681);
        if (r10 == null) goto L100;
        ColoredSettingIconKt.a(r10, null, r13, 0, 2);
        SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), r13, 6);
    L100:
        r13.endReplaceGroup();
        int r27 = r2;
        Modifier r29 = r8;
        a r30 = r10;
        Composer r32 = r13;
        TextKt.Text-Nvy7gAk(r34, PaddingKt.padding-qDBjuR0$default(RowScope.-CC.weight$default(r19, Modifier.Companion, 1.0f, false, 2, null), 0.0f, 0.0f, Dp.constructor-impl(12), 0.0f, 11, null), n.a(r13, 0).d.a, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, n.b(r13).b, r32, r27 & 14, 0, 131064);
        int r0 = r27 >> 3;
        boolean r20 = r26;
        FlowSwitchKt.a(r35, r36, null, r20, null, r32, ((r0 & 112) | (r0 & 14)) | ((r27 >> 6) & 7168), 20);
        r32.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L103;
        ComposerKt.traceEventEnd();
    L103:
        final boolean r21 = r26;
        final Modifier r22 = r29;
        final a r23 = r30;
    L104:
        ScopeUpdateScope r24 = r32.endRestartGroup();
        if (r24 == null) goto L108;
        r24.updateScope(new SwitchSettingRowKt$SwitchSettingRow$2(r34, r35, r36, r22, r23, r21, r41, r42));
        return;
    L108:
        return;
    L94:
        if (Intrinsics.areEqual(r7.rememberedValue(), Integer.valueOf(r15)) == true) goto L96;
    L90:
        r13.useNode();
        goto L91
    L80:
        r26 = r12;
        goto L82
    L69:
        if (r13.getSkipping() == false) goto L72;
        r13.skipToGroupEnd();
        r22 = r8;
        r23 = r10;
        r21 = r12;
        r32 = r13;
        goto L104
    L59:
        if ((196608 & r41) != 0) goto L65;
        r12 = r39;
        if (r13.changed(r12) == false) goto L63;
        int r110 = 131072;
    L64:
        r2 = r2 | r110;
        goto L67
    L63:
        r110 = 65536;
        goto L64
    L48:
        if ((r41 & 24576) != 0) goto L54;
        r10 = r38;
        if (r13.changed(r10) == false) goto L52;
        int r111 = 16384;
    L53:
        r2 = r2 | r111;
        goto L55
    L52:
        r111 = 8192;
        goto L53
    L37:
        if ((r41 & 3072) != 0) goto L43;
        r8 = r37;
        if (r13.changed(r8) == false) goto L41;
        int r25 = 2048;
    L42:
        r2 = r2 | r25;
        goto L44
    L41:
        r25 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L42
    L27:
        if ((r41 & 384) != 0) goto L33;
        if (r13.changedInstance(r36) == false) goto L31;
        int r28 = 256;
    L32:
        r2 = r2 | r28;
        goto L33
    L31:
        r28 = 128;
        goto L32
    L17:
        if ((r41 & 48) != 0) goto L24;
        if (r13.changed(r35) == false) goto L21;
        int r31 = 32;
    L22:
        r2 = r2 | r31;
        goto L24
    L21:
        r31 = 16;
        goto L22
    L6:
        if ((r41 & 6) == 0) goto L8;
        r2 = r41;
        goto L14
    L8:
        if (r13.changed(r34) == false) goto L10;
        int r33 = 4;
    L11:
        r2 = r33 | r41;
        goto L14
    L10:
        r33 = 2;
        goto L11
    }
}
