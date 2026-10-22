package com.suite.lark.platform.component.widget.floatingpanel.impl;

import android.view.View;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.suite.lark.platform.component.widget.floatingpanel.impl.view.FloatingPanelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/suite/lark/platform/component/widget/floatingpanel/impl/FloatingPanelImpl;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class FloatingPanelService$updateBanner$1 extends Lambda implements Function1<a, Unit> {
    final /* synthetic */ yoc.b $banner;

    public FloatingPanelService$updateBanner$1(yoc.b r1) {
        this.$banner = r1;
        super(1);
    }

    public final void invoke(a r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$runOnMain");
        yoc.b r0 = this.$banner;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "banner");
        final c r7 = r6.a;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r0, "banner");
        Log.i("FloatingPanelPresenter", "updateBanner");
        FloatingCardItem<yoc.b> r2 = r7.e;
        if (r2 != null) goto L6;
        return;
    L6:
        if (((yoc.b) r2.a).a() == false) goto L9;
        Log.i("FloatingPanelPresenter", "updateBanner, do update");
        Long r1 = FloatPanelHitPoint.a;
        Statistics.sendEvent("core_float_dialog_show_banner");
        r7.c.b(r2.e);
        FloatingCardItem<yoc.b> r3 = new FloatingCardItem(r0, r7.a);
        r7.e = r3;
        FloatingPanelView r4 = r7.c();
        View r5 = (View) r3.c.getValue();
        String r8 = r3.e;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r8, "id");
        r4.e.a(r5, r8);
        r4.f();
        r7.l(r3, new FloatingPanelPresenter$updateBanner$1(r7));
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((a) r1);
        return Unit.INSTANCE;
    }
}
