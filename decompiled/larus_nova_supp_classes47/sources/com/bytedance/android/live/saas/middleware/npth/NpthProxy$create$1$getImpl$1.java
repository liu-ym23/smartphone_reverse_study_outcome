package com.bytedance.android.live.saas.middleware.npth;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class NpthProxy$create$1$getImpl$1 extends MutablePropertyReference0Impl {
    public NpthProxy$create$1$getImpl$1(NpthProxy r7) {
        super(r7, NpthProxy.class, "mFunctionMap", "getMFunctionMap()Ljava/util/Map;", 0);
    }

    public Object get() {
        return ((NpthProxy) ((CallableReference) this).receiver).getMFunctionMap();
    }

    public void set(Object r2) {
        ((NpthProxy) ((CallableReference) this).receiver).setMFunctionMap((Map) r2);
    }
}
