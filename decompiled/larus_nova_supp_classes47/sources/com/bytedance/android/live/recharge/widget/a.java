package com.bytedance.android.live.recharge.widget;

import com.bytedance.android.live.profile.monitor.DataType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements com.bytedance.android.livesdk.log.filter.v {
    public final /* synthetic */ AbsRechargeWidget a;

    public final void Rd() {
    }

    public final void onRemove() {
    }

    public a(AbsRechargeWidget r1) {
        this.a = r1;
    }

    public final void L9(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "params");
        switch(r2.hashCode()) {
            case -509835515: goto L21;
            case 538882462: goto L18;
            case 1125973814: goto L15;
            case 1380621232: goto L12;
            case 1507583969: goto L9;
            case 2009019068: goto L6;
            default: goto L34;
        };
    L34:
        return;
    L6:
        if (r2.equals("livesdk_recharge_success") == false) goto L28;
    L22:
        r3.put("is_first_recharge", String.valueOf(this.a.wq()));
        if (this.a.e.d() == false) goto L25;
        String r4 = DataType.TRUE;
    L26:
        r3.put("is_include_discount_package", r4);
        return;
    L25:
        r4 = DataType.FALSE;
        goto L26
    L28:
        return;
    L9:
        if (r2.equals("livesdk_recharge_pay") == true) goto L22;
        return;
    L12:
        if (r2.equals("livesdk_recharge_leave") == true) goto L22;
        return;
    L15:
        if (r2.equals("livesdk_check_out_show") == true) goto L22;
        return;
    L18:
        if (r2.equals("livesdk_check_out_leave") == true) goto L22;
        return;
    L21:
        if (r2.equals("livesdk_recharge_fail") == true) goto L22;
    }
}
