package com.ss.android.lark.officesdk.demo.dependency;

import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class e implements jzb.a {

    @Inject
    public epb.a a;

    @Inject
    public e() {
    }

    @Override // jzb.a
    public final Pair<String, String> a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "unit");
        epb.a r5 = this.a;
        epb.a r0 = null;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mLarkDeviceIdApi");
        r5 = null;
    L6:
        String r6 = r5.getDeviceId();
        epb.a r2 = this.a;
        if (r2 == null) goto L9;
        r0 = r2;
    L11:
        return new Pair(r6, r0.getInstallId());
    L9:
        Intrinsics.throwUninitializedPropertyAccessException("mLarkDeviceIdApi");
        goto L11
    }
}
