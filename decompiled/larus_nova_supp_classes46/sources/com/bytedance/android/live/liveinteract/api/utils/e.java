package com.bytedance.android.live.liveinteract.api.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public static final boolean a(DataCenter r3) {
        if (r3 == null) goto L12;
        Integer r4 = (Integer) r3.get("ktv_feed_subScene", -1);
        if (r4 == null) goto L12;
        int r5 = r4.intValue();
        if (r5 == 9) goto L10;
        ALogger.e("LinkMultiControlHelper", "feedSubScene isn't ktv:" + r5);
        return false;
    L10:
        return true;
    L12:
        return false;
    }
}
