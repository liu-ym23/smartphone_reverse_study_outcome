package com.obric.matrixpro.sdk.deviceinfoclient;

import android.os.HandlerThread;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class DeviceInfoGetter$initThreadIfNeeded$1 extends MutablePropertyReference0Impl {
    DeviceInfoGetter$initThreadIfNeeded$1(a r7) {
        super(r7, a.class, "handlerThread", "getHandlerThread()Landroid/os/HandlerThread;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return a.a((a) ZeusTransformUtils.preCheckCast(this.receiver, a.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r3) {
        a.a((a) ZeusTransformUtils.preCheckCast(this.receiver, a.class, "com.obric.memorydata.plugin"), (HandlerThread) ZeusTransformUtils.preCheckCast(r3, HandlerThread.class, "com.obric.memorydata.plugin"));
    }
}
