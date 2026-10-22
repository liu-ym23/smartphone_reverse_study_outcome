package com.bytedance.android.live.profit.redpacket;

import io.reactivex.functions.Consumer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c0<T> implements Consumer {
    public final /* synthetic */ RedPacketIconModel a;
    public final /* synthetic */ xr2.h b;

    public c0(RedPacketIconModel r1, xr2.h r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Pair r5 = (Pair) r4;
        Integer r0 = (Integer) r5.component1();
        int r6 = ((Number) r5.component2()).intValue();
        xr2.a r1 = this.b;
        if (r6 <= 99) goto L6;
        String r2 = "99+";
    L9:
        r1.setSuperscript(r2);
        if (r0 != null) goto L12;
        return;
    L12:
        if (r6 <= r0.intValue()) goto L16;
        this.a.activateIcon();
        return;
    L16:
        return;
    L6:
        if (r6 <= 1) goto L8;
        r2 = String.valueOf(r6);
        goto L9
    L8:
        r2 = null;
        goto L9
    }
}
