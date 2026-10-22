package com.larksuite.rucket.job.compat;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final CallbackCompatRucketJob a(Function1 r1) {
        Intrinsics.checkNotNullParameter(r1, "action");
        CallbackCompatRucketJob r0 = new CallbackCompatRucketJob(r1);
        r0.registerCallback();
        return r0;
    }
}
