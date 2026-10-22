package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ LRUCleanStrategy.d a;
    public final /* synthetic */ Map b;

    public r(LRUCleanStrategy.d r1, Map r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        if (((Boolean) r2).booleanValue() == false) goto L6;
        LRUCleanStrategy.g(this.a.a, this.b);
        return;
    }
}
