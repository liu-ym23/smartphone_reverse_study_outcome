package com.bytedance.android.livesdk.coupon.customview;

import android.widget.TextView;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ h a;
    public final /* synthetic */ long b;
    public final /* synthetic */ String c;

    public i(h r1, long r2, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r6) {
        Long r7 = (Long) r6;
        long r0 = System.currentTimeMillis();
        long r2 = this.b;
        if (r0 <= r2) goto L8;
        Disposable r1 = this.a.b;
        if (r1 == null) goto L7;
        r1.dispose();
    L7:
        h r3 = this.a;
        r3.b = null;
        ((TextView) r3.findViewById(2131390430)).setText("00:00:00 " + this.c);
        return;
    L8:
        com.bytedance.android.livesdk.coupon.util.a.a.getClass();
        String r4 = com.bytedance.android.livesdk.coupon.util.a.b(r2 - r0);
        ((TextView) this.a.findViewById(2131390430)).setText(r4 + ' ' + this.c);
    }
}
