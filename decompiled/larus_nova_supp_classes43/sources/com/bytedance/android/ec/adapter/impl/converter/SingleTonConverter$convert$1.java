package com.bytedance.android.ec.adapter.impl.converter;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class SingleTonConverter$convert$1 extends MutablePropertyReference0Impl {
    public SingleTonConverter$convert$1(o r10) {
        super(r10, o.class, "singleTon", "getSingleTon()Ljava/lang/Object;", 0);
    }

    public Object get() {
        Target r0 = ((o) ((CallableReference) this).receiver).b;
        if (r0 != 0) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("singleTon");
    L5:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void set(Object r10) {
        ((o) ((CallableReference) this).receiver).b = r10;
    }
}
