package com.bytedance.android.live.recharge.platform.service;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w implements com.bytedance.android.live.wallet.e.b {
    public final /* synthetic */ PayService a;
    public final /* synthetic */ PayService.a b;

    public final void a(com.bytedance.android.live.wallet.e.c r9) {
        PayService.a r0 = this.b;
        this.a.getClass();
        String r1 = r9.b;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        Integer r3 = Integer.valueOf(r9.a);
        PayService.b.a r4 = null;
        if (r3 == null) goto L15;
        if (r3.intValue() != 1) goto L15;
        com.bytedance.android.live.wallet.e.a r5 = r9.e;
        if (r5 == null) goto L13;
        r4 = PayService.c(r5);
    L13:
        PayService.b r2 = new PayService.b(1, r1, r4, r9.d);
    L40:
        r0.a(r2);
        return;
    L15:
        if (r3 != null) goto L18;
    L23:
        if (r3 != null) goto L26;
    L31:
        if (r3 != null) goto L34;
    L39:
        r2 = new PayService.b(-1, "", null, false);
        goto L40
    L34:
        if (r3.intValue() != 6) goto L39;
        com.bytedance.android.live.wallet.e.a r10 = r9.e;
        if (r10 == null) goto L38;
        r4 = PayService.c(r10);
    L38:
        r2 = new PayService.b(6, r1, r4, false);
        goto L40
    L26:
        if (r3.intValue() != 3) goto L31;
        com.bytedance.android.live.wallet.e.a r12 = r9.e;
        if (r12 == null) goto L30;
        r4 = PayService.c(r12);
    L30:
        r2 = new PayService.b(3, r1, r4, false);
        goto L40
    L18:
        if (r3.intValue() != 2) goto L23;
        com.bytedance.android.live.wallet.e.a r13 = r9.e;
        if (r13 == null) goto L22;
        r4 = PayService.c(r13);
    L22:
        r2 = new PayService.b(2, r1, r4, false);
        goto L40
    }

    public final void b(int r3) {
        PayService.a r0 = this.b;
        this.a.getClass();
        if (r3 != 1) goto L5;
        PayService.PayProgress r4 = PayService.PayProgress.QUERY_ORDER;
    L9:
        r0.b(r4);
        return;
    L5:
        if (r3 == 2) goto L7;
        r4 = PayService.PayProgress.UNKNOWN;
        goto L9
    L7:
        r4 = PayService.PayProgress.SHOW_CASHIER;
        goto L9
    }

    public w(PayService r1, com.bytedance.android.live.recharge.utils.h r2) {
        this.a = r1;
        this.b = r2;
    }
}
