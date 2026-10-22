package com.ss.android.lark.flow.chat.resources.bridge;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.ss.android.lark.flow.chat.resources.CommonMainString0;
import com.ss.android.lark.flow.chat.resources.b;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.compose.resources.b0;
import org.jetbrains.compose.resources.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class StringDemoKt$foo$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;

    public StringDemoKt$foo$1(int r1) {
        this.$$changed = r1;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer r4, int r5) {
        int r6 = RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1);
        Composer r7 = r4.startRestartGroup(827897510);
        if (r6 != 0) goto L9;
        if (r7.getSkipping() == false) goto L9;
        r7.skipToGroupEnd();
    L14:
        ScopeUpdateScope r8 = r7.endRestartGroup();
        if (r8 == null) goto L18;
        r8.updateScope(new StringDemoKt$foo$1(r6));
        return;
    L18:
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(827897510, r6, -1, "com.ss.android.lark.flow.chat.resources.bridge.foo (stringDemo.kt:8)");
    L11:
        Intrinsics.checkNotNullParameter(b.a, "<this>");
        b0.a((z) CommonMainString0.v.getValue(), r7);
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventEnd();
        goto L14
    }
}
