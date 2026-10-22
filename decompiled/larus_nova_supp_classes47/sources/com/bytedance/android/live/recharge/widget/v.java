package com.bytedance.android.live.recharge.widget;

import android.content.DialogInterface;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.schema.api.WebcastRedirectException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v implements DialogInterface.OnCancelListener {
    public final /* synthetic */ RechargePanelWidgetComposite a;

    public v(RechargePanelWidgetComposite r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r6) {
        RechargePanelWidgetComposite r7 = this.a;
        long r0 = System.currentTimeMillis();
        RechargePanelWidgetComposite r2 = this.a;
        r7.u = r0 - r2.u;
        int r8 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.l("livesdk_recharge_recharge_safe_remind_popup_duration", true, r2.u / ((long) WebcastRedirectException.UNKNOWN));
        int r9 = ToastUtil.a;
        ToastUtil.b(s1.B(2131915660), 0);
        this.a.w.getPopUpOrHideRechargePageEvent().onNext(Boolean.FALSE);
        FrameLayout r10 = this.a.b;
        if (r10 == null) goto L6;
        r10.setVisibility(8);
        return;
    }
}
