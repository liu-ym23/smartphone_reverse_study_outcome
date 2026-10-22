package com.obric.matrixpro.sdk.deviceinfoclient;

import android.os.HandlerThread;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class DeviceInfoGetter$destroy$2 extends MutablePropertyReference0Impl {
    public DeviceInfoGetter$destroy$2(a r7) {
        super(r7, a.class, "handlerThread", "getHandlerThread()Landroid/os/HandlerThread;", 0);
    }

    public Object get() {
        a r0 = (a) ((CallableReference) this).receiver;
        HandlerThread r1 = a.a;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("handlerThread");
    L5:
        return r1;
    }

    public void set(Object r2) {
        a r0 = (a) ((CallableReference) this).receiver;
        a.a = (HandlerThread) r2;
    }
}
