package com.bytedance.android.live.revlink.impl.pk.utils;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final boolean a(DataCenter r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        boolean r1 = ((Boolean) r4.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        LiveMode r2 = LiveMode.VIDEO;
        LiveMode r5 = (LiveMode) r4.get("data_live_mode", r2);
        if (r1 == false) goto L10;
        if (r5 != r2) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }
}
