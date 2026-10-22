package com.ss.android.lark.profile_office.userprofile.component;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.ss.android.lark.compose.foundation.n;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class NoPermissionComponentKt$NoPermissionComponent$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;

    public NoPermissionComponentKt$NoPermissionComponent$2(int r1) {
        this.$$changed = r1;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r59, int r60) {
        int r1 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1);
        Composer r14 = r59.startRestartGroup(-1184917079);
        if (r1 != 0) goto L9;
        if (r14.getSkipping() == false) goto L9;
        r14.skipToGroupEnd();
        Composer r3 = r14;
    L26:
        ScopeUpdateScope r2 = r3.endRestartGroup();
        if (r2 == null) goto L30;
        r2.updateScope(new NoPermissionComponentKt$NoPermissionComponent$2(r1));
        return;
    L30:
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-1184917079, r1, -1, "com.ss.android.lark.profile_office.userprofile.component.NoPermissionComponent (NoPermissionComponent.kt:24)");
    L11:
        Modifier.Companion r15 = Modifier.Companion;
        Modifier r4 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxSize$default(r15, 0.0f, 1, null), Dp.constructor-impl(32), 0.0f, 2, null);
        MeasurePolicy r5 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getCenter(), Alignment.Companion.getCenterHorizontally(), r14, 54);
        long r6 = ComposablesKt.getCurrentCompositeKeyHashCode(r14, 0);
        int r7 = (int) ((r6 >>> 32) ^ r6);
        CompositionLocalMap r8 = r14.getCurrentCompositionLocalMap();
        Modifier r9 = ComposedModifierKt.materializeModifier(r14, r4);
        ComposeUiNode.Companion r10 = ComposeUiNode.Companion;
        Function0 r11 = r10.getConstructor();
        if ((r14.getApplier() instanceof Applier) == true) goto L14;
        ComposablesKt.invalidApplier();
    L14:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L17;
        r14.createNode(r11);
    L18:
        Composer r12 = Updater.constructor-impl(r14);
        Updater.set-impl(r12, r5, r10.getSetMeasurePolicy());
        Updater.set-impl(r12, r8, r10.getSetResolvedCompositionLocals());
        Function2 r13 = r10.getSetCompositeKeyHash();
        if (r12.getInserting() == false) goto L21;
    L22:
        r12.updateRememberedValue(Integer.valueOf(r7));
        r12.apply(Integer.valueOf(r7), r13);
    L23:
        Updater.set-impl(r12, r9, r10.getSetModifier());
        ColumnScopeInstance r16 = ColumnScopeInstance.INSTANCE;
        IconKt.Icon-ww6aTOc(PainterResources_androidKt.painterResource(2131238001, r14, 0), null, SizeKt.size-3ABfNKs(r15, Dp.constructor-impl(40)), Color.Companion.getUnspecified-0d7_KjU(), r14, 3504, 0);
        r3 = r14;
        TextKt.Text-Nvy7gAk(StringResources_androidKt.stringResource(2131892558, r14, 0), PaddingKt.padding-qDBjuR0$default(r15, 0.0f, Dp.constructor-impl(16), 0.0f, 0.0f, 13, null), n.a(r14, 0).d.a, null, 0, null, null, null, 0, null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0, 0, false, 0, 0, null, new TextStyle(0, TextUnitKt.getSp(17), FontWeight.Companion.getSemiBold(), null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777209, null), r3, 48, 12582912, 130040);
        r3.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventEnd();
        goto L26
    L21:
        if (Intrinsics.areEqual(r12.rememberedValue(), Integer.valueOf(r7)) == true) goto L23;
    L17:
        r14.useNode();
        goto L18
    }
}
