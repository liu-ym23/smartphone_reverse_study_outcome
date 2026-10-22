package com.suite.lark.platform.component.widget.floatingpanel.impl;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/suite/lark/platform/component/widget/floatingpanel/impl/FloatingPanelImpl;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class FloatingPanelService$removeCards$3 extends Lambda implements Function1<a, Unit> {
    final /* synthetic */ int $type;

    public FloatingPanelService$removeCards$3(int r1) {
        this.$type = r1;
        super(1);
    }

    public final void invoke(a r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$runOnMain");
        int r0 = this.$type;
        c r5 = r4.a;
        r5.getClass();
        Log.i("FloatingPanelPresenter", "removeCards all");
        r5.j(r0, FloatingPanelPresenter$removeCards$2.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((a) r1);
        return Unit.INSTANCE;
    }
}
