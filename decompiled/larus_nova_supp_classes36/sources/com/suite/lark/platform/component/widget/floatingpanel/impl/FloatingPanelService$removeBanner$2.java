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
final class FloatingPanelService$removeBanner$2 extends Lambda implements Function1<a, Unit> {
    final /* synthetic */ Function1<yoc.b, Boolean> $condition;

    /* JADX WARN: Multi-variable type inference failed */
    public FloatingPanelService$removeBanner$2(Function1<? super yoc.b, Boolean> r1) {
        this.$condition = r1;
        super(1);
    }

    public final void invoke(a r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$runOnMain");
        Function1<yoc.b, Boolean> r0 = this.$condition;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "condition");
        c r5 = r4.a;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r0, "condition");
        Log.i("FloatingPanelPresenter", "removeBanner with condition");
        FloatingCardItem<yoc.b> r1 = r5.e;
        if (r1 == null) goto L10;
        yoc.b r2 = (yoc.b) r1.a;
        if (r2 != null) goto L7;
        return;
    L7:
        if (((Boolean) r0.invoke(r2)).booleanValue() == false) goto L12;
        r5.g();
        return;
    L12:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((a) r1);
        return Unit.INSTANCE;
    }
}
