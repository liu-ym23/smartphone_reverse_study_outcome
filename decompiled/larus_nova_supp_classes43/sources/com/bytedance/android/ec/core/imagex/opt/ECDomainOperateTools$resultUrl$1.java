package com.bytedance.android.ec.core.imagex.opt;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECDomainOperateTools$resultUrl$1 extends MutablePropertyReference0Impl {
    public ECDomainOperateTools$resultUrl$1(q r10) {
        super(r10, q.class, "customDomain", "getCustomDomain()Ljava/lang/String;", 0);
    }

    public Object get() {
        String r0 = ((q) ((CallableReference) this).receiver).a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("customDomain");
    L5:
        return r0;
    }

    public void set(Object r10) {
        String r11 = (String) r10;
        ((q) ((CallableReference) this).receiver).a = r11;
    }
}
