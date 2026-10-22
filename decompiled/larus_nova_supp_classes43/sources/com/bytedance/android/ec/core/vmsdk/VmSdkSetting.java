package com.bytedance.android.ec.core.vmsdk;

import com.bytedance.android.ec.ab.opt.OptSetting;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@OptSetting(business = "VmSdk setting")
public final class VmSdkSetting {
    public static final Lazy a = null;

    public static final c a() {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        cl.d r10 = com.bytedance.android.ec.sdk.helper.k.a();     // Catch: Throwable -> L8
        if (r10 == null) goto L6;
        r10.g();     // Catch: Throwable -> L8
    L6:
        Object r11 = Result.constructor-impl(null);     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r11) == true) goto L14;
        r0 = r11;
    L14:
        c r12 = (c) r0;
        if (r12 == null) goto L17;
        return r12;
    L17:
        return (c) a.getValue();
    L8:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    static {
        a = LazyKt.lazy(VmSdkSetting$config$2.INSTANCE);
    }
}
