package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.bridge.method.permission.RequestPermissionMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p0 implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ HybridFragment a;

    public p0(HybridFragment r1) {
        this.a = r1;
    }

    public final com.bytedance.ies.web.jsbridge2.f a() {
        a7.b r1 = this.a;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.android.annie.container.fragment.IInnerHybridFragment");
        return new RequestPermissionMethod((com.bytedance.android.annie.container.fragment.q) r1);
    }
}
