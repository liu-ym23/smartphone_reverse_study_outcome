package com.bytedance.android.live.base.model.user;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o {
    public static final String a(IBaseUser r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$secUidExt");
        return r1.getCastSecUid();
    }

    public static final boolean b(IBaseUser r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isAdminExt");
        py.t r2 = r1.getUserAttr();
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.isAdmin();
    }

    public static final void c(IBaseUser r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$secUidExt");
        r1.setCastSecUid(r2);
    }
}
