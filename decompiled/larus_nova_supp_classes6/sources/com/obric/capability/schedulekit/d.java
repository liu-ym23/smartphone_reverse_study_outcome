package com.obric.capability.schedulekit;

import com.obric.capabilitykit.common.ICapabilitySchedule;
import com.obric.capabilitykit.corecommon.BinderExceptionHandlerProxy;
import java.lang.reflect.Proxy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class d {
    public final ICapabilitySchedule a;
    public final ICapabilitySchedule b;

    static {
    }

    public d(ICapabilitySchedule r6) {
        Intrinsics.checkNotNullParameter(r6, "api");
        this.a = r6;
        BinderExceptionHandlerProxy.Companion r0 = BinderExceptionHandlerProxy.Companion;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        Object r2 = Proxy.newProxyInstance(ICapabilitySchedule.class.getClassLoader(), new Class[]{ICapabilitySchedule.class}, new BinderExceptionHandlerProxy(r6, "ScheduleProxy", ICapabilitySchedule.class));     // Catch: Throwable -> L8
        if (r2 == null) goto L7;
        r6 = (ICapabilitySchedule) r2;     // Catch: Throwable -> L8
    L12:
        this.b = r6;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.capabilitykit.common.ICapabilitySchedule");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        if (Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th))) == null) goto L12;
        r6.getClass().toString();
        goto L12
    }
}
