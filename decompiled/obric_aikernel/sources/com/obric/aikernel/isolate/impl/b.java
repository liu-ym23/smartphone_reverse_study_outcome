package com.obric.aikernel.isolate.impl;

import com.bytedance.apm6.util.constant.NetConst;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final boolean a(String r10, boolean r11, Function2<? super String, ? super String, String> r12) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r12, "propertyReader");
        String r13 = r12.invoke("sys.aikernel." + r10, null);
        if (r13 != null) goto L6;
        return r11;
    L6:
        if (Intrinsics.areEqual(r13, NetConst.ENCRYPT_VERISON_CODE) == false) goto L9;
    L17:
        return true;
    L9:
        if (Intrinsics.areEqual(r13, NetConst.NOT_ENCRYPT_VERISON_CODE) == false) goto L12;
    L18:
        return false;
    L12:
        if (StringsKt.equals(r13, "true", true) == true) goto L17;
        if (StringsKt.equals(r13, "false", true) == true) goto L18;
        return r11;
    }
}
