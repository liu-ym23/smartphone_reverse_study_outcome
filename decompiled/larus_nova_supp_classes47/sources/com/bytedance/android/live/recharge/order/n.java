package com.bytedance.android.live.recharge.order;

import android.content.DialogInterface;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import java.util.Map;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n implements DialogInterface.OnClickListener {
    public final /* synthetic */ RechargePanelOrderService a;
    public final /* synthetic */ Ref.LongRef b;
    public final /* synthetic */ Map c;

    public n(RechargePanelOrderService r1, Ref.LongRef r2, Map r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r6, int r7) {
        int r8 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.l("livesdk_recharge_recharge_safe_remind_popup_isee_click", false, 0);
        Ref.LongRef r9 = this.b;
        long r0 = System.currentTimeMillis();
        Ref.LongRef r2 = this.b;
        r9.element = r0 - r2.element;
        com.bytedance.android.live.recharge.utils.m.l("livesdk_recharge_recharge_safe_remind_popup_duration", true, r2.element / ((long) WebcastRedirectException.UNKNOWN));
        com.bytedance.android.live.recharge.panel.context.f r10 = this.a.f;
        r10.h = (String) this.c.get("two_factory_auth_verify_info");
        com.bytedance.android.live.recharge.util.j.a(this.a.f);
        r6.dismiss();
    }
}
