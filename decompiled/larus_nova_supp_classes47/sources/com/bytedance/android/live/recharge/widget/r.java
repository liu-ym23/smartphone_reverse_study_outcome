package com.bytedance.android.live.recharge.widget;

import android.view.View;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r implements View.OnClickListener {
    public final /* synthetic */ RechargePanelWidgetComposite a;

    public r(RechargePanelWidgetComposite r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.w.getUpdateEvent().onNext(Unit.INSTANCE);
    }
}
