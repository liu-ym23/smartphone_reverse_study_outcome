package com.bytedance.android.live.saas.middleware.middlelayer;

import com.bytedance.ttnet.utils.RetrofitUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import um0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/middlelayer/NetworkServiceImpl;", "Lum0/b;", "T", "", "baseUrl", "Ljava/lang/Class;", "cls", "getService", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "<init>", "()V", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class NetworkServiceImpl implements b {
    public NetworkServiceImpl() {
    }

    public <T> T getService(String r2, Class<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "baseUrl");
        Intrinsics.checkNotNullParameter(r3, "cls");
        return (T) RetrofitUtils.createSsService(r2, r3);
    }
}
