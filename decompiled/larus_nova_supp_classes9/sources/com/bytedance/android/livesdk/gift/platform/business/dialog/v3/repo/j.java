package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ GiftListCacheRepo a;

    public j(GiftListCacheRepo r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        GiftListCacheRepo r0 = this.a;
        GiftListCacheRepo.a(r0, (Map) r2);
    }
}
