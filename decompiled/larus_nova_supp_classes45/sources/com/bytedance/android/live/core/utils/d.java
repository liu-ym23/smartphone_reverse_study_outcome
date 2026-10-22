package com.bytedance.android.live.core.utils;

import com.bytedance.android.live.core.utils.rxutils.CommonTransformer;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.config.fe;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static CommonTransformer a(boolean r2) {
        if (r2 == false) goto L9;
        Integer r0 = (Integer) fe.a.getValue();
        if (r0 == null) goto L9;
        if (r0.intValue() != 2) goto L9;
        return new com.bytedance.android.live.core.utils.rxutils.h();
    L9:
        if (r2 == false) goto L17;
        Integer r3 = (Integer) fe.a.getValue();
        if (r3 == null) goto L17;
        if (r3.intValue() != 3) goto L17;
        return new com.bytedance.android.live.core.utils.rxutils.i();
    L17:
        return RxUtil.rxSchedulerHelper();
    }
}
