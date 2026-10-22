package com.bytedance.android.live.saas.middleware.utuid;

import com.bytedance.android.dy.saas.utuid.d;
import com.bytedance.android.dy.saas.utuid.e;
import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.base.IConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/utuid/UtUidProxy;", "Lcom/bytedance/android/live/saas/middleware/base/IConfiguration;", "Lcom/bytedance/android/dy/saas/utuid/d;", "Lcom/bytedance/android/dy/saas/utuid/e;", "conf", "Lcom/bytedance/android/live/saas/middleware/base/BaseFunction;", "create", "<init>", "()V", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class UtUidProxy implements IConfiguration<d, e> {
    public UtUidProxy() {
    }

    /* JADX INFO: renamed from: create, reason: avoid collision after fix types in other method */
    public BaseFunction<d, e> create2(e r2) {
        Intrinsics.checkNotNullParameter(r2, "conf");
        if (r2.a == true) goto L7;
        return new AnonymousClass1();
    L7:
        return new AnonymousClass2();
    }

    @Override // com.bytedance.android.live.saas.middleware.base.IConfiguration
    public /* bridge */ /* synthetic */ BaseFunction<d, e> create(e r1) {
        return create2(r1);
    }
}
