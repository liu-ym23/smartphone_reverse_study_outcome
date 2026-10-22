package com.bytedance.android.live.profit.vote.transfer;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.revenue.platform.api.core.rx.l;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T, R> implements Function {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final Object apply(Object r2) {
        ExtraResponse r3 = (ExtraResponse) r2;
        Intrinsics.checkNotNullParameter(r3, "res");
        List<com.bytedance.android.live.profit.vote.model.a> r4 = ((a) r3.data).getMVotes();
        if (r4 == null) goto L9;
        com.bytedance.android.live.profit.vote.model.a r5 = (com.bytedance.android.live.profit.vote.model.a) CollectionsKt.firstOrNull(r4);
        if (r5 == null) goto L9;
        l r0 = l.a;
        Observable r6 = Observable.just(r5);
        if (r6 == null) goto L9;
        return r6;
    L9:
        l r7 = l.a;
        return Observable.empty();
    }
}
