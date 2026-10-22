package com.bytedance.android.ec.core.utils;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.sdk.ECSdk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class y0 {
    public static boolean a;

    public static boolean a() {
        boolean r1 = true;
        if (a == false) goto L14;
    L12:
        return r1;
    L14:
        int r0 = ECSdk.a;     // Catch: Exception -> L13
        IAdapterService r10 = (IAdapterService) ECSdk.a(IAdapterService.class);     // Catch: Exception -> L13
        if (r10 == null) goto L10;
        if (r10.isLiveServiceReady() != true) goto L10;
    L11:
        a = r1;
    L10:
        r1 = false;
        goto L11
    }

    static {
    }
}
