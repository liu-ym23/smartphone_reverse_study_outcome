package com.suite.lark.platform.component.widget.floatingpanel.impl;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/suite/lark/platform/component/widget/floatingpanel/impl/FloatingPanelImpl;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class FloatingPanelService$removeCards$1 extends Lambda implements Function1<a, Unit> {
    final /* synthetic */ List<String> $ids;
    final /* synthetic */ int $type;

    public FloatingPanelService$removeCards$1(int r1, List<String> r2) {
        this.$type = r1;
        this.$ids = r2;
        super(1);
    }

    public final void invoke(a r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$runOnMain");
        int r0 = this.$type;
        final List<String> r1 = this.$ids;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r1, "ids");
        c r6 = r5.a;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r1, "ids");
        Log.i("FloatingPanelPresenter", "removeCards, ids: " + r1);
        r6.j(r0, new FloatingPanelPresenter$removeCards$1(r1));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((a) r1);
        return Unit.INSTANCE;
    }
}
