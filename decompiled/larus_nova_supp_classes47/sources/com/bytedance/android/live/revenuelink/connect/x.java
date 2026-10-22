package com.bytedance.android.live.revenuelink.connect;

import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x {
    public static final boolean a(IRoomBase r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$isValid");
        if (IRoomKtKt.getId(r5) > 0) goto L5;
    L7:
        return false;
    L5:
        if (r5.getOwnerKt() == null) goto L7;
        return true;
    }
}
