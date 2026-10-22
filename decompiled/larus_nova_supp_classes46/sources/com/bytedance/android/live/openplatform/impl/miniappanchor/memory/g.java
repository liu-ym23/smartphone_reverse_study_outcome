package com.bytedance.android.live.openplatform.impl.miniappanchor.memory;

import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T, R> implements Function {
    public final /* synthetic */ MemoryContextService a;
    public final /* synthetic */ ShelfInfo b;

    public g(MemoryContextService r1, ShelfInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r2) {
        final ShelfCardInfo r3 = (ShelfCardInfo) r2;
        Intrinsics.checkNotNullParameter(r3, "cardInfo");
        return Observable.create(new MemoryContextService$upgradeCardInfoList$2$1(this, r3));
    }
}
