package com.bytedance.android.ec.common.impl.sku.log;

import com.bytedance.android.ec.core.event.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class SkuLog {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(SkuLog$isDebugOrLocalToast$2.INSTANCE);
    }

    public static void a(String r1, String r10) {
        Intrinsics.checkNotNullParameter(r1, a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r10, a.KEY_MSG);
        dm.a.b r0 = dm.a.a;
        dm.a.a("SkuOnlineLog_".concat(r1)).i(r10);
    }
}
