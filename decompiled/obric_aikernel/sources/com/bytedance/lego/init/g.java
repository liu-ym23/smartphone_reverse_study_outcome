package com.bytedance.lego.init;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static final void a(Function0<Unit> r10) {
        Intrinsics.checkParameterIsNotNull(r10, "runnable");
        InitSchedulerExecutors.f2051c.a().execute(new f(r10));
    }
}
