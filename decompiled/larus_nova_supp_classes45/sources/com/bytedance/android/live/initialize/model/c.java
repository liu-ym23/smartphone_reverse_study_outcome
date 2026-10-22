package com.bytedance.android.live.initialize.model;

import com.bytedance.android.live.initialize.IWTOSingleTask;
import com.bytedance.android.live.initialize.IWTOTask;
import com.bytedance.android.live.initialize.WTOSingleTaskCollection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public static final WTOTaskProxy a(IWTOTask r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$proxy");
        if ((r2 instanceof IWTOSingleTask) == false) goto L9;
        WTOSingleTaskCollection r0 = WTOSingleTaskCollection.INSTANCE;
        WTOTaskProxy r1 = r0.getSingleTask2Proxy$live_initialize_scheduler_saasRelease().get(r2);
        if (r1 != null) goto L10;
        WTOTaskProxy r3 = new WTOTaskProxy(r2);
        r0.getSingleTask2Proxy$live_initialize_scheduler_saasRelease().put(r2, r3);
        return r3;
    L10:
        return r1;
    L9:
        return new WTOTaskProxy(r2);
    }
}
