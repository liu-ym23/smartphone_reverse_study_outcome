package com.larksuite.component.universe_design.emptystate.compose;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import com.larksuite.component.universe_design.button.compose.UDButtonType;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final class UDEmptyStateKt$EmptyAction$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ a $action;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ UDButtonType $type;

    public UDEmptyStateKt$EmptyAction$2(a r1, UDButtonType r2, Modifier r3, int r4, int r5) {
        this.$type = r2;
        this.$modifier = r3;
        this.$$changed = r4;
        this.$$default = r5;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r11, int r12) {
        UDButtonType r2 = this.$type;
        Modifier.Companion r3 = this.$modifier;
        int r4 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1);
        int r5 = this.$$default;
        Composer r13 = r11.startRestartGroup(-1521701145);
        if ((r5 & 1) == 0) goto L6;
        int r0 = r4 | 6;
    L14:
        if ((r5 & 2) == 0) goto L17;
        r0 = r0 | 48;
    L23:
        int r6 = r5 & 4;
        if (r6 == 0) goto L27;
        r0 = r0 | 384;
    L34:
        if ((r0 & 147) == 146) goto L36;
    L42:
        if (r6 == 0) goto L45;
        r3 = Modifier.Companion;
    L45:
        if (ComposerKt.isTraceInProgress() == false) goto L47;
        ComposerKt.traceEventStart(-1521701145, r0, -1, "com.larksuite.component.universe_design.emptystate.compose.EmptyAction (UDEmptyState.kt:342)");
    L47:
        MeasurePolicy r14 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        long r7 = ComposablesKt.getCurrentCompositeKeyHashCode(r13, 0);
        int r1 = (int) (r7 ^ (r7 >>> 32));
        CompositionLocalMap r8 = r13.getCurrentCompositionLocalMap();
        Modifier r9 = ComposedModifierKt.materializeModifier(r13, r3);
        ComposeUiNode.Companion r10 = ComposeUiNode.Companion;
        Function0 r15 = r10.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L50;
        ComposablesKt.invalidApplier();
    L50:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L53;
        r13.createNode(r15);
    L54:
        Composer r16 = Updater.constructor-impl(r13);
        Updater.set-impl(r16, r14, r10.getSetMeasurePolicy());
        Updater.set-impl(r16, r8, r10.getSetResolvedCompositionLocals());
        Function2 r17 = r10.getSetCompositeKeyHash();
        if (r16.getInserting() == false) goto L57;
    L58:
        r16.updateRememberedValue(Integer.valueOf(r1));
        r16.apply(Integer.valueOf(r1), r17);
    L59:
        Updater.set-impl(r16, r9, r10.getSetModifier());
        BoxScopeInstance r19 = BoxScopeInstance.INSTANCE;
        throw null;
    L57:
        if (Intrinsics.areEqual(r16.rememberedValue(), Integer.valueOf(r1)) == true) goto L59;
    L53:
        r13.useNode();
        goto L54
    L36:
        if (r13.getSkipping() == false) goto L42;
        r13.skipToGroupEnd();
        ScopeUpdateScope r110 = r13.endRestartGroup();
        if (r110 == null) goto L61;
        r110.updateScope(new UDEmptyStateKt$EmptyAction$2(null, r2, r3, r4, r5));
        return;
    L61:
        return;
    L27:
        if ((r4 & 384) != 0) goto L34;
        if (r13.changed(r3) == false) goto L31;
        int r20 = 256;
    L32:
        r0 = r0 | r20;
        goto L34
    L31:
        r20 = 128;
        goto L32
    L17:
        if ((r4 & 48) != 0) goto L23;
        if (r13.changed(r2.ordinal()) == false) goto L21;
        int r21 = 32;
    L22:
        r0 = r0 | r21;
        goto L23
    L21:
        r21 = 16;
        goto L22
    L6:
        if ((r4 & 6) == 0) goto L8;
        r0 = r4;
        goto L14
    L8:
        if (r13.changed(null) == false) goto L10;
        int r22 = 4;
    L11:
        r0 = r22 | r4;
        goto L14
    L10:
        r22 = 2;
        goto L11
    }
}
