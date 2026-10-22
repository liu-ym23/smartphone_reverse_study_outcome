package com.bytedance.android.live.saas.middleware.middlelayer;

import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.base.IConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/middlelayer/MiddleLayerProxy;", "Lcom/bytedance/android/live/saas/middleware/base/IConfiguration;", "", "Lcom/bytedance/android/live/saas/middleware/middlelayer/MiddleLayerConfig;", "()V", "create", "Lcom/bytedance/android/live/saas/middleware/base/BaseFunction;", "conf", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class MiddleLayerProxy implements IConfiguration<Object, MiddleLayerConfig> {
    public MiddleLayerProxy() {
    }

    /* JADX INFO: renamed from: create, reason: avoid collision after fix types in other method */
    public BaseFunction<Object, MiddleLayerConfig> create2(MiddleLayerConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "conf");
        return new AnonymousClass1();
    }

    @Override // com.bytedance.android.live.saas.middleware.base.IConfiguration
    public /* bridge */ /* synthetic */ BaseFunction<Object, MiddleLayerConfig> create(MiddleLayerConfig r1) {
        return create2(r1);
    }
}
