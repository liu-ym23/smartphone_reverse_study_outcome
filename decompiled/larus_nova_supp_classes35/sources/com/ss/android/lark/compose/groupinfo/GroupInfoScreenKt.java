package com.ss.android.lark.compose.groupinfo;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.compose.groupinfo.components.GroupInfoAvatarKt;
import com.ss.android.lark.compose.groupinfo.components.GroupInfoNameInputKt;
import com.ss.android.lark.compose.groupinfo.components.GroupInfoTopBarKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class GroupInfoScreenKt {
    public static final void a(final GroupInfoViewModel r23, final com.lark.kmp.rustclient.api.d r24, final PaddingValues r25, Composer r26, final int r27) {
        Intrinsics.checkNotNullParameter(r23, "viewModel");
        Intrinsics.checkNotNullParameter(r24, "rustClient");
        Intrinsics.checkNotNullParameter(r25, "contentPadding");
        Composer r14 = r26.startRestartGroup(1961953095);
        if ((r27 & 6) == 0) goto L5;
        int r2 = r27;
    L11:
        if ((r27 & 48) != 0) goto L18;
        if (r14.changedInstance(r24) == false) goto L15;
        int r3 = 32;
    L16:
        r2 = r2 | r3;
        goto L18
    L15:
        r3 = 16;
    L18:
        if ((r27 & 384) == 0) goto L20;
    L24:
        int r10 = r2;
        if ((r10 & 147) != 146) goto L31;
        if (r14.getSkipping() == false) goto L31;
        r14.skipToGroupEnd();
    L68:
        ScopeUpdateScope r1 = r14.endRestartGroup();
        if (r1 == null) goto L72;
        r1.updateScope(new GroupInfoScreenKt$GroupInfoScreen$2(r23, r24, r25, r27));
        return;
    L72:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventStart(1961953095, r10, -1, "com.ss.android.lark.compose.groupinfo.GroupInfoScreen (GroupInfoScreen.kt:27)");
    L33:
        State r16 = SnapshotStateKt.collectAsState(r23.getUiState(), null, r14, 0, 1);
        Modifier r4 = PaddingKt.padding(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), n.a(r14, 0).c.f, null, 2, null), r25);
        Alignment.Horizontal r5 = Alignment.Companion.getCenterHorizontally();
        MeasurePolicy r6 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), r5, r14, 48);
        long r7 = ComposablesKt.getCurrentCompositeKeyHashCode(r14, 0);
        int r8 = (int) ((r7 >>> 32) ^ r7);
        CompositionLocalMap r9 = r14.getCurrentCompositionLocalMap();
        Modifier r11 = ComposedModifierKt.materializeModifier(r14, r4);
        ComposeUiNode.Companion r12 = ComposeUiNode.Companion;
        Function0 r13 = r12.getConstructor();
        if ((r14.getApplier() instanceof Applier) == true) goto L36;
        ComposablesKt.invalidApplier();
    L36:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L39;
        r14.createNode(r13);
    L40:
        Composer r15 = Updater.constructor-impl(r14);
        Updater.set-impl(r15, r6, r12.getSetMeasurePolicy());
        Updater.set-impl(r15, r9, r12.getSetResolvedCompositionLocals());
        Function2 r17 = r12.getSetCompositeKeyHash();
        if (r15.getInserting() == false) goto L43;
    L44:
        r15.updateRememberedValue(Integer.valueOf(r8));
        r15.apply(Integer.valueOf(r8), r17);
    L45:
        Updater.set-impl(r15, r11, r12.getSetModifier());
        ColumnScopeInstance r18 = ColumnScopeInstance.INSTANCE;
        boolean r19 = f.a((e) r16.getValue());
        boolean r20 = ((e) r16.getValue()).d;
        r14.startReplaceGroup(5004770);
        boolean r21 = r14.changedInstance(r23);
        Object r22 = r14.rememberedValue();
        if (r21 == false) goto L48;
    L49:
        r22 = new GroupInfoScreenKt$GroupInfoScreen$1$1$1(r23);
        r14.updateRememberedValue(r22);
    L50:
        Function0 r28 = (Function0) r22;
        r14.endReplaceGroup();
        r14.startReplaceGroup(5004770);
        boolean r29 = r14.changedInstance(r23);
        Object r30 = r14.rememberedValue();
        if (r29 == false) goto L53;
    L54:
        r30 = new GroupInfoScreenKt$GroupInfoScreen$1$2$1(r23);
        r14.updateRememberedValue(r30);
    L55:
        r14.endReplaceGroup();
        GroupInfoTopBarKt.a(r19, r20, r28, (Function0) r30, null, r14, 0, 16);
        GroupInfoAvatarKt.a(((e) r16.getValue()).b, ((e) r16.getValue()).e, r23.getChatId(), r24, ((e) r16.getValue()).f, null, r14, (r10 << 6) & 7168, 32);
        r14.startReplaceGroup(5004770);
        boolean r31 = r14.changedInstance(r23);
        Object r32 = r14.rememberedValue();
        if (r31 == false) goto L58;
    L59:
        r32 = new GroupInfoScreenKt$GroupInfoScreen$1$3$1(r23);
        r14.updateRememberedValue(r32);
    L60:
        r14.endReplaceGroup();
        GroupInfoAvatarKt.b(null, (Function0) r32, r14, 0, 1);
        String r33 = ((e) r16.getValue()).c;
        boolean r34 = ((e) r16.getValue()).d;
        r14.startReplaceGroup(5004770);
        boolean r35 = r14.changedInstance(r23);
        Object r36 = r14.rememberedValue();
        if (r35 == false) goto L63;
    L64:
        r36 = new GroupInfoScreenKt$GroupInfoScreen$1$4$1(r23);
        r14.updateRememberedValue(r36);
    L65:
        r14.endReplaceGroup();
        GroupInfoNameInputKt.a(r33, r34, null, (Function1) r36, r14, 0, 4);
        r14.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L68;
        ComposerKt.traceEventEnd();
        goto L68
    L63:
        if (r36 != Composer.Companion.getEmpty()) goto L65;
    L58:
        if (r32 != Composer.Companion.getEmpty()) goto L60;
    L53:
        if (r30 != Composer.Companion.getEmpty()) goto L55;
    L48:
        if (r22 != Composer.Companion.getEmpty()) goto L50;
    L43:
        if (Intrinsics.areEqual(r15.rememberedValue(), Integer.valueOf(r8)) == true) goto L45;
    L39:
        r14.useNode();
        goto L40
    L20:
        if (r14.changed(r25) == false) goto L22;
        int r37 = 256;
    L23:
        r2 = r2 | r37;
        goto L24
    L22:
        r37 = 128;
        goto L23
    L5:
        if (r14.changedInstance(r23) == false) goto L7;
        int r38 = 4;
    L8:
        r2 = r38 | r27;
        goto L11
    L7:
        r38 = 2;
        goto L8
    }
}
