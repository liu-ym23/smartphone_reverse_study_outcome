package com.obric.aikernel.utils;

import com.bytedance.apm6.util.constant.NetConst;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final String a(String r10, Function0<String> r11) {
        Intrinsics.checkNotNullParameter(r11, "block");
        if (r10 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == false) goto L14;
        String r13 = r11.invoke();
        if (r13 != null) goto L15;
        return "";
    L15:
        return r13;
    L14:
        return r10;
    L5:
        if (r10.length() == 0) goto L8;
        r12 = false;
        goto L9
    }

    public static final boolean b(Boolean r10) {
        return Intrinsics.areEqual(r10, Boolean.TRUE);
    }

    public static final String c(Boolean r10) {
        if (Intrinsics.areEqual(r10, Boolean.TRUE) == false) goto L5;
        return NetConst.ENCRYPT_VERISON_CODE;
    L5:
        return NetConst.NOT_ENCRYPT_VERISON_CODE;
    }
}
