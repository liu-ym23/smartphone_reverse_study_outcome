package com.obric.aikernel.middleware.impl.obric;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
final class DefaultProcessKeepAliveClientSdk implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DefaultProcessKeepAliveClientSdk f4571a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f4572b = null;

    static {
        f4571a = new DefaultProcessKeepAliveClientSdk();
        f4572b = LazyKt.lazy(DefaultProcessKeepAliveClientSdk$sdk$2.INSTANCE);
    }

    private DefaultProcessKeepAliveClientSdk() {
    }

    private final ka.b d() {
        return (ka.b) f4572b.getValue();
    }

    @Override // com.obric.aikernel.middleware.impl.obric.b
    public void a(String r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r12, "processName");
        d().h(r10, r11, r12);
    }

    @Override // com.obric.aikernel.middleware.impl.obric.b
    public boolean b(String r10, int r11, String r12, long r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r12, "processName");
        Intrinsics.checkNotNullParameter(r14, "reason");
        return d().f(r10, r11, r12, r13, r14);
    }

    @Override // com.obric.aikernel.middleware.impl.obric.b
    public boolean c(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        return d().g(r10, r11);
    }
}
