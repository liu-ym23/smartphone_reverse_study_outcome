package com.bytedance.android.livesdk.gift.platform.business.toolbar;

import com.bytedance.android.livesdk.gift.configmodel.t;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.a1;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ g a;

    public h(g r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        g r6 = this.a;
        r6.getClass();
        List<Integer> r0 = ((t) com.bytedance.android.livesdk.gift.platform.business.b.d0.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[54])).b();
        r6.i.getClass();
        if (CollectionsKt.contains(r0, a1.c()) == false) goto L6;
        Intrinsics.areEqual(r6.i.a(), 0);
        return;
    }
}
