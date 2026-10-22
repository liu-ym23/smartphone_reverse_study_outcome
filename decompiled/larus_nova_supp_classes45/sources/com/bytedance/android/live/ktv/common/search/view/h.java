package com.bytedance.android.live.ktv.common.search.view;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h<T> implements SingleOnSubscribe {
    public final /* synthetic */ CommonSearchContainer a;
    public final /* synthetic */ List b;

    public h(CommonSearchContainer r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(SingleEmitter<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        CommonSearchResultView r3 = CommonSearchContainer.b(this.a);
        if (r3 == null) goto L6;
        r3.a(this.b);
        return;
    }
}
