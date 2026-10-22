package com.bytedance.android.live.ktv.common.util;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class KtvCommonConfigParams {
    public static final Lazy a = null;

    public static String a() {
        return (String) a.getValue();
    }

    static {
        a = LazyKt.lazy(KtvCommonConfigParams$STORAGE_ROOT_DIR$2.INSTANCE);
    }
}
