package com.bytedance.android.live.effect.beauty.body;

import android.content.DialogInterface;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p implements DialogInterface.OnClickListener {
    public static final p a = null;

    static {
        a = new p();
    }

    public p() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        if (r2 == null) goto L4;
        r2.dismiss();
    L4:
        int r4 = com.bytedance.android.live.effect.utils.a.a;
        HashMap r5 = new HashMap();
        r5.put("is_reset", "0");
        com.bytedance.android.live.effect.utils.c.a("livesdk_anchor_beautybody_reset_confirm", r5, "");
    }
}
