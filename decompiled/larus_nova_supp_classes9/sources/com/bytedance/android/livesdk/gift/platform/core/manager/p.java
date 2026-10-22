package com.bytedance.android.livesdk.gift.platform.core.manager;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p<T> implements SingleOnSubscribe {
    public final /* synthetic */ ca0.w a;
    public final /* synthetic */ List b;

    public p(ca0.w r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(SingleEmitter<Object> r3) {
        GiftManagerKt r4 = GiftManagerKt.z;
        ca0.w r0 = this.a;
        List r1 = this.b;
        r4.getClass();
        r0.b(r1);
    }
}
