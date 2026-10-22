package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ GiftExtraRepo a;
    public final /* synthetic */ List b;
    public final /* synthetic */ String c;

    public c(GiftExtraRepo r1, List r2) {
        this.a = r1;
        this.b = r2;
        this.c = "send gift";
    }

    public final void accept(Object r5) {
        Long r6 = (Long) r5;
        r0.a.a(this.a, this.b, this.c, null, 12);
    }
}
