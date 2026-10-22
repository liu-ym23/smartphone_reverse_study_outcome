package com.bytedance.android.live.recharge.order;

import android.content.DialogInterface;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m implements DialogInterface.OnCancelListener {
    public final /* synthetic */ RechargePanelOrderService a;
    public final /* synthetic */ Ref.LongRef b;

    public m(RechargePanelOrderService r1, Ref.LongRef r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r6) {
        Ref.LongRef r7 = this.b;
        long r0 = System.currentTimeMillis();
        Ref.LongRef r2 = this.b;
        r7.element = r0 - r2.element;
        int r8 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.l("livesdk_recharge_recharge_safe_remind_popup_duration", true, r2.element / ((long) WebcastRedirectException.UNKNOWN));
        int r9 = ToastUtil.a;
        ToastUtil.b(s1.B(2131915660), 0);
        com.bytedance.android.live.recharge.panel.context.d.a(this.a.f, false);
        com.bytedance.android.live.recharge.panel.context.d.b(this.a.f, false);
    }
}
