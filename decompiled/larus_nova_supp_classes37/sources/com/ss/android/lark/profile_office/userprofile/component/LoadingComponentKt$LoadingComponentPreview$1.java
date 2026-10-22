package com.ss.android.lark.profile_office.userprofile.component;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.ss.android.lark.compose.foundation.FlowThemeKt;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class LoadingComponentKt$LoadingComponentPreview$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;

    public LoadingComponentKt$LoadingComponentPreview$1(int r1) {
        this.$$changed = r1;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r5, int r6) {
        int r7 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1);
        Composer r8 = r5.startRestartGroup(383647313);
        if (r7 != 0) goto L9;
        if (r8.getSkipping() == false) goto L9;
        r8.skipToGroupEnd();
    L14:
        ScopeUpdateScope r9 = r8.endRestartGroup();
        if (r9 == null) goto L18;
        r9.updateScope(new LoadingComponentKt$LoadingComponentPreview$1(r7));
        return;
    L18:
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(383647313, r7, -1, "com.ss.android.lark.profile_office.userprofile.component.LoadingComponentPreview (LoadingComponent.kt:64)");
    L11:
        FlowThemeKt.a(false, ComposableSingletons$LoadingComponentKt.a, r8, 48, 1);
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventEnd();
        goto L14
    }
}
