package com.larus.dora.impl.util;

import com.bytedance.dora.annotation.ProductNameType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class t {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Integer r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "imageUrl");
        int r0 = ProductNameType.DORA_G.id;
        if (r1 != null) goto L6;
    L7:
        return r2;
    L6:
        if (r1.intValue() != r0) goto L7;
        if (s.a() == true) goto L13;
        return "";
    L13:
        return r2;
    }
}
