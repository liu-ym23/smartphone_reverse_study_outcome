package com.bytedance.android.live.profit.fansclub.widget.entrance.data;

import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Predicate {
    public final /* synthetic */ i a;

    public d(i r1) {
        this.a = r1;
    }

    public final boolean test(Object r2) {
        IFollowPair r3 = (IFollowPair) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return Intrinsics.areEqual(r3.getUserIdString(), this.a.f());
    }
}
