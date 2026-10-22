package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m {
    public static final com.bytedance.live.datacontext.j<l> a(DataCenter r1) {
        com.bytedance.android.livesdk.interactivity.api.h r2 = com.bytedance.android.livesdk.interactivity.api.i.b(r1, 1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getPublicScreenContext();
    }
}
