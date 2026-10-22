package com.bytedance.android.live.anchormodelink.linkroom;

import com.bytedance.ies.sdk.widgets.DataCenter;
import iy.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static g a;

    static {
    }

    public static g a(DataCenter r1) {
        if (r1 != null) goto L6;
        return a;
    L6:
        return (g) r1.get("data_new_link_dynamic_widget_service");
    }
}
