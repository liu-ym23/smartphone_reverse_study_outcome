package com.bytedance.android.live.revenue.platform.hybrid.impl.shareview;

import android.content.Context;
import com.bytedance.android.live.revenue.platform.hybrid.api.shareview.LoadFailCode;
import com.bytedance.android.live.revenue.platform.hybrid.api.shareview.ShareViewLoadError;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T, R> implements Function {
    public final /* synthetic */ Context a;

    public c(Context r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        com.bytedance.android.live.revenue.platform.container.impl.core.h r4 = (com.bytedance.android.live.revenue.platform.container.impl.core.h) r3;
        Intrinsics.checkNotNullParameter(r4, "mgr");
        Context r0 = this.a;
        zy0.b r1 = r4.D();
        Intrinsics.checkNotNull(r1);
        if (r0 == r1.c().getContext()) goto L6;
        return Observable.error(new ShareViewLoadError(LoadFailCode.SharerCreateFailed, "service center context does not match business context"));
    L6:
        return r4.a().map(new b(r4));
    }
}
