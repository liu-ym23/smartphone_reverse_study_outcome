package com.bytedance.android.live.recharge.utils;

import com.bytedance.android.live.recharge.platform.service.z;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RechargeFacadeUtilsKt {
    public static final Lazy a = null;

    public static final z a() {
        return (z) a.getValue();
    }

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, RechargeFacadeUtilsKt$rechargeFacade$2.INSTANCE);
    }
}
