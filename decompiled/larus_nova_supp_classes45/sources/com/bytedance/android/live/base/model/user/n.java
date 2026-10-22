package com.bytedance.android.live.base.model.user;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n {
    public static final long a(IBaseUser r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$liveRoomIdExt");
        Intrinsics.checkNotNullParameter(r2, "$this$ownRoomExt");
        py.o r3 = r2.getOwnRoom();
        if (r3 != null) goto L7;
        return 0;
    L7:
        return r3.getId();
    }
}
