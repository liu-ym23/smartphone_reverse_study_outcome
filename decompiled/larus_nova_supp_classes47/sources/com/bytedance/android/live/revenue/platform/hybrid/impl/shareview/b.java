package com.bytedance.android.live.revenue.platform.hybrid.impl.shareview;

import com.bytedance.android.live.revenue.platform.hybrid.api.shareview.LoadFailCode;
import com.bytedance.android.live.revenue.platform.hybrid.api.shareview.ShareViewLoadError;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T, R> implements Function {
    public final /* synthetic */ com.bytedance.android.live.revenue.platform.container.impl.core.h a;

    public b(com.bytedance.android.live.revenue.platform.container.impl.core.h r1) {
        this.a = r1;
    }

    public final Object apply(Object r4) {
        Intrinsics.checkNotNullParameter((String) r4, "it");
        if (this.a.getServiceVersion().compareTo((String) com.bytedance.android.live.revenue.platform.hybrid.api.shareview.b.b.getValue(null, com.bytedance.android.live.revenue.platform.hybrid.api.shareview.b.a[0])) < 0) goto L7;
        return this.a;
    L7:
        throw new ShareViewLoadError(LoadFailCode.SharerNotSupported, "service center not support ShareView");
    }
}
