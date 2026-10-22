package com.bytedance.android.live.profit.vip;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q<T> implements Consumer {
    public static final q a = null;

    static {
        a = new q();
    }

    public q() {
    }

    public final void accept(Object r3) {
        ExtraResponse r4 = (ExtraResponse) r3;
        int r5 = w51.a.a;
        Intrinsics.checkNotNullParameter("VipRepository", "tag");
        Intrinsics.checkNotNullParameter("report VipRechargeStrategy Success", Constants.OperatorKey.MSG);
        ALogger.i("VipRepository", "report VipRechargeStrategy Success");
    }
}
