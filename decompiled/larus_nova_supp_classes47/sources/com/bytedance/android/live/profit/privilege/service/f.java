package com.bytedance.android.live.profit.privilege.service;

import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f extends com.bytedance.ies.web.jsbridge2.g<Object, Object> {
    public final /* synthetic */ HybridCard a;

    public f(HybridCard r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a.release();
        return null;
    }
}
