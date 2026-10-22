package com.larus.bot.impl.common.util;

import com.larus.im.callback.IIMError;
import com.larus.network.bean.BizResponse;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(IIMError r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "defaultErrorMsg");
        if (r3 != null) goto L5;
        return r4;
    L5:
        BizResponse.Companion.getClass();
        if (ArraysKt.contains(BizResponse.access$getCODE_RISK_CONTROL$cp(), r3.getCode()) == false) goto L21;
        String r0 = r3.getTips();
        if (r0 != null) goto L10;
    L13:
        boolean r1 = true;
    L14:
        if (r1 == true) goto L22;
        String r5 = r3.getTips();
        if (r5 != null) goto L20;
        return r4;
    L20:
        return r5;
    L22:
        return r4;
    L10:
        if (r0.length() == 0) goto L13;
        r1 = false;
        goto L14
    L21:
        return r4;
    }
}
