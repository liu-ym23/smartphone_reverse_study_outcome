package com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h {
    public static final float a = 0.0f;
    public static final int b = 0;
    public static final int c = 0;

    static {
        a = 1.1428572f;
        if (PublicScreenABHelper.c() == false) goto L5;
        float r0 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.g.a(PublicScreenABHelper.e() * 14.0f);
    L6:
        b = (int) r0;
        c = (int) com.bytedance.android.livesdk.interactivity.service.textrender.utils.g.a(16.0f);
        return;
    L5:
        r0 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.g.a(16.0f);
        goto L6
    }
}
