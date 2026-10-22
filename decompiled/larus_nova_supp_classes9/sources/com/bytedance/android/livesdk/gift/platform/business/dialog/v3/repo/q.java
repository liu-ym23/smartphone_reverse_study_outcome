package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import io.reactivex.functions.Action;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q implements Action {
    public final /* synthetic */ r a;

    public q(r r1) {
        this.a = r1;
    }

    public final void run() {
        GiftListRepo r0 = GiftListRepo.k;
        List r1 = this.a.b;
        r0.getClass();
        com.bytedance.android.livesdk.gift.util.d.b(GiftListRepo.c(r1), this.a.c);
    }
}
