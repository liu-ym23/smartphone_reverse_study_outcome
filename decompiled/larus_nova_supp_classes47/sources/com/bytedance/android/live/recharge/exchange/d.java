package com.bytedance.android.live.recharge.exchange;

import android.content.DialogInterface;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.utils.r3;
import jw0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements DialogInterface.OnClickListener {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        com.bytedance.android.live.recharge.util.d.c(true);
        h.b(DataType.TRUE);
        int r0 = ToastUtil.a;
        ToastUtil.b(s1.C(2131915506, new Object[]{r3.c()}), 0);
        r3.dismiss();
    }
}
