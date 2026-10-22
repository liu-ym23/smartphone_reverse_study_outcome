package com.bytedance.android.live.revlink.impl.service;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.link.model.p;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements p11.a {
    public final /* synthetic */ p11.f a;

    public c(GiftReceiverRepoService.g r1) {
        this.a = r1;
    }

    @Override // p11.a
    public final void a(int r1, List<? extends p> r2) {
        this.a.onOnlineListChanged(r2);
    }
}
