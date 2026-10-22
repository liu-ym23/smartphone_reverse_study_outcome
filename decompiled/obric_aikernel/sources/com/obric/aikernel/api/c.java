package com.obric.aikernel.api;

import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final String a(Object r10, Object r11) {
        if (r10 != null) goto L4;
        return "null";
    L4:
        if (r10 != r11) goto L6;
        return DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE;
    L6:
        return "custom";
    }

    public static final boolean b(Class<?> r10, d r11) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        if (Intrinsics.areEqual(r10, com.obric.aikernel.api.base.a.class) == false) goto L6;
        if (r11 != null) goto L6;
        return true;
    L6:
        return false;
    }
}
