package com.bytedance.android.live.recharge.widget;

import android.content.DialogInterface;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w implements DialogInterface.OnClickListener {
    public final /* synthetic */ RechargePanelWidgetComposite a;
    public final /* synthetic */ Map b;

    public w(RechargePanelWidgetComposite r1, Map r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r6, int r7) {
        int r8 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.l("livesdk_recharge_recharge_safe_remind_popup_isee_click", false, 0);
        RechargePanelWidgetComposite r9 = this.a;
        long r0 = System.currentTimeMillis();
        RechargePanelWidgetComposite r2 = this.a;
        r9.u = r0 - r2.u;
        com.bytedance.android.live.recharge.utils.m.l("livesdk_recharge_recharge_safe_remind_popup_duration", true, r2.u / ((long) WebcastRedirectException.UNKNOWN));
        this.a.w.setTwoFactoryAuthVerifyInfo((String) this.b.get("two_factory_auth_verify_info"));
        com.bytedance.android.live.recharge.util.j.a(this.a.w.getDialogContextProxy());
        r6.dismiss();
    }
}
