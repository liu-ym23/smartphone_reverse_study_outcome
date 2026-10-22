package com.bytedance.android.livesdk.jsbridge.methods.subscribe;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements o60.e {
    public final /* synthetic */ Function0 a;

    public final void onPermissionGrant(String... r2) {
        Intrinsics.checkNotNullParameter(r2, "permissions");
    }

    public b(Function0 r1) {
        this.a = r1;
    }

    public final void onPermissionDenied(String... r2) {
        Intrinsics.checkNotNullParameter(r2, "permissions");
        this.a.invoke();
    }
}
