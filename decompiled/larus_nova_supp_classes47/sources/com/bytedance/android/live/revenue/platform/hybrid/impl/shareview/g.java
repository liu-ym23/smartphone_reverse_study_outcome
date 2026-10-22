package com.bytedance.android.live.revenue.platform.hybrid.impl.shareview;

import android.content.Context;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T, R> implements Function {
    public final /* synthetic */ RevShareViewServiceImpl a;
    public final /* synthetic */ Context b;

    public g(RevShareViewServiceImpl r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r4) {
        Throwable r5 = (Throwable) r4;
        Intrinsics.checkNotNullParameter(r5, "err");
        if (((Boolean) com.bytedance.android.live.revenue.platform.hybrid.api.shareview.b.f.getValue(null, com.bytedance.android.live.revenue.platform.hybrid.api.shareview.b.a[4])).booleanValue() == false) goto L7;
        r5.getMessage();
        RevShareViewServiceImpl r6 = this.a;
        Context r0 = this.b;
        r6.getClass();
        return Single.create(new RevShareViewServiceImpl$createNewSharer$1(r6, r0));
    L7:
        return Single.error(r5);
    }
}
