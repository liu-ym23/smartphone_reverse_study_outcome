package com.bytedance.android.live.revenue.common;

import com.bytedance.common.utility.DigestUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "str");
        return DigestUtils.md5Hex(r1);
    }
}
