package com.suite.lark.platform.component.widget.floatingpanel.impl;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/suite/lark/platform/component/widget/floatingpanel/impl/FloatingPanelImpl;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class FloatingPanelService$removeCards$2 extends Lambda implements Function1<a, Unit> {
    final /* synthetic */ Function1<yoc.c, Boolean> $filter;
    final /* synthetic */ int $type;

    /* JADX WARN: Multi-variable type inference failed */
    public FloatingPanelService$removeCards$2(int r1, Function1<? super yoc.c, Boolean> r2) {
        this.$type = r1;
        this.$filter = r2;
        super(1);
    }

    public final void invoke(a r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$runOnMain");
        int r0 = this.$type;
        Function1<yoc.c, Boolean> r1 = this.$filter;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r1, "filter");
        r4.a.j(r0, r1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((a) r1);
        return Unit.INSTANCE;
    }
}
