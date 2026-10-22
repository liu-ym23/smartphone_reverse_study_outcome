package com.ss.android.lark.profile_office.userprofile.component;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.unit.Dp;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.compose.foundation.widget.FlowLoadingIndicatorKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class LoadingComponentKt {
    public static final void a(Composer r19, final int r20) {
        Composer r9 = r19.startRestartGroup(60735527);
        if (r20 != 0) goto L9;
        if (r9.getSkipping() == false) goto L9;
        r9.skipToGroupEnd();
    L26:
        ScopeUpdateScope r1 = r9.endRestartGroup();
        if (r1 == null) goto L30;
        r1.updateScope(new LoadingComponentKt$LoadingComponent$2(r20));
        return;
    L30:
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(60735527, r20, -1, "com.ss.android.lark.profile_office.userprofile.component.LoadingComponent (LoadingComponent.kt:23)");
    L11:
        long r10 = n.a(r9, 0).d.e;
        Modifier.Companion r2 = Modifier.Companion;
        float r3 = 16;
        Modifier r4 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(r2, 0.0f, 1, null), Dp.constructor-impl(r3), 0.0f, Dp.constructor-impl(r3), 0.0f, 10, null);
        MeasurePolicy r5 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getCenterHorizontally(), r9, 48);
        long r6 = ComposablesKt.getCurrentCompositeKeyHashCode(r9, 0);
        int r7 = (int) (r6 ^ (r6 >>> 32));
        CompositionLocalMap r8 = r9.getCurrentCompositionLocalMap();
        Modifier r11 = ComposedModifierKt.materializeModifier(r9, r4);
        ComposeUiNode.Companion r12 = ComposeUiNode.Companion;
        Function0 r13 = r12.getConstructor();
        if ((r9.getApplier() instanceof Applier) == true) goto L14;
        ComposablesKt.invalidApplier();
    L14:
        r9.startReusableNode();
        if (r9.getInserting() == false) goto L17;
        r9.createNode(r13);
    L18:
        Composer r14 = Updater.constructor-impl(r9);
        Updater.set-impl(r14, r5, r12.getSetMeasurePolicy());
        Updater.set-impl(r14, r8, r12.getSetResolvedCompositionLocals());
        Function2 r15 = r12.getSetCompositeKeyHash();
        if (r14.getInserting() == false) goto L21;
    L22:
        r14.updateRememberedValue(Integer.valueOf(r7));
        r14.apply(Integer.valueOf(r7), r15);
    L23:
        Updater.set-impl(r14, r11, r12.getSetModifier());
        ColumnScopeInstance r16 = ColumnScopeInstance.INSTANCE;
        BoxKt.Box(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.size-3ABfNKs(r2, Dp.constructor-impl(160)), RoundedCornerShapeKt.getCircleShape()), r10, null, 2, null), r9, 0);
        float r17 = 20;
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(r2, Dp.constructor-impl(r17)), r9, 6);
        float r18 = 120;
        float r21 = 4;
        BoxKt.Box(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(r2, Dp.constructor-impl(r18)), Dp.constructor-impl(r17)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(r21))), r10, null, 2, null), r9, 0);
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(r2, Dp.constructor-impl(8)), r9, 6);
        BoxKt.Box(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(r2, Dp.constructor-impl(r18)), Dp.constructor-impl(r17)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(r21))), r10, null, 2, null), r9, 0);
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(r2, Dp.constructor-impl(175)), r9, 6);
        FlowLoadingIndicatorKt.a(null, Dp.constructor-impl(24), n.a(r9, 0).d.c, r9, 48, 1);
        r9.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventEnd();
        goto L26
    L21:
        if (Intrinsics.areEqual(r14.rememberedValue(), Integer.valueOf(r7)) == true) goto L23;
    L17:
        r9.useNode();
        goto L18
    }
}
