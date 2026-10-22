package com.bytedance.android.ec.core.abtest;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Object a(Object r1, Object r10) {
        Lazy r0 = ECAppInfoService.a;
        if (ECAppInfoService.h() == false) goto L6;
        return r1;
    L6:
        return r10;
    }
}
