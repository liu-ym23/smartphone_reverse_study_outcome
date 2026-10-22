package com.bytedance.android.live.recharge.exchange;

import android.content.DialogInterface;
import com.bytedance.android.live.profile.monitor.DataType;
import jw0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements DialogInterface.OnClickListener {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        com.bytedance.android.live.recharge.util.d.c(false);
        h.b(DataType.FALSE);
        r1.dismiss();
    }
}
