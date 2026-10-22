package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ GiftReceiverRepoService a;

    public m(GiftReceiverRepoService r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Integer r5 = (Integer) r4;
        gq2.b r6 = this.a.Qc();
        GiftReceiverRepoService r0 = this.a;
        int r1 = v.a(r0.i, r0.j);
        jy0.b.d("GiftReceiver", "observeDataLinkState change " + r1);
        r6.k();
        if (r6.d(r1, 64) == false) goto L5;
        this.a.I();
        return;
    L5:
        r6.c();
        if (r6.d(r1, 4) == false) goto L8;
        GiftReceiverRepoService r7 = this.a;
        p11.h r2 = r7.p.getPkService();
        r2.j(r7.c);
        r2.l(r7.c);
        return;
    L8:
        r6.a();
        if (r6.d(r1, 512) == false) goto L14;
        this.a.A("sceneChange");
        return;
    }
}
