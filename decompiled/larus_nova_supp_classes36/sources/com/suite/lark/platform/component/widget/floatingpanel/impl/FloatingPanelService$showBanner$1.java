package com.suite.lark.platform.component.widget.floatingpanel.impl;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/suite/lark/platform/component/widget/floatingpanel/impl/FloatingPanelImpl;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class FloatingPanelService$showBanner$1 extends Lambda implements Function1<a, Unit> {
    final /* synthetic */ yoc.b $banner;

    public FloatingPanelService$showBanner$1(yoc.b r1) {
        this.$banner = r1;
        super(1);
    }

    public final void invoke(a r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$runOnMain");
        yoc.b r0 = this.$banner;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "banner");
        final c r5 = r4.a;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r0, "banner");
        Log.i("FloatingPanelPresenter", "showBanner, id: " + r0.getId() + ", chatId: " + r0.b());
        Long r1 = FloatPanelHitPoint.a;
        Statistics.sendEvent("core_float_dialog_show_banner");
        FloatingCardItem<yoc.b> r2 = r5.e;
        if (r2 == null) goto L5;
        r5.c.b(r2.e);
    L5:
        final FloatingCardItem<yoc.b> r3 = new FloatingCardItem(r0, r5.a);
        r5.e = r3;
        r5.k(new FloatingPanelPresenter$showBanner$2(r5, r3));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((a) r1);
        return Unit.INSTANCE;
    }
}
