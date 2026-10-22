package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o<T> implements SingleOnSubscribe {
    public final /* synthetic */ ca0.w a;
    public final /* synthetic */ List b;

    public o(ca0.w r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(SingleEmitter<Object> r2) {
        this.a.b(this.b);
    }
}
