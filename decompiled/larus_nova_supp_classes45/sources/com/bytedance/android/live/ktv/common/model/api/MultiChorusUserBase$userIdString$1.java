package com.bytedance.android.live.ktv.common.model.api;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class MultiChorusUserBase$userIdString$1 extends MutablePropertyReference0Impl {
    public MultiChorusUserBase$userIdString$1(l0 r7) {
        super(r7, l0.class, "userId", "getUserId()J", 0);
    }

    public Object get() {
        return Long.valueOf(((l0) ((CallableReference) this).receiver).userId);
    }

    public void set(Object r4) {
        l0 r0 = (l0) ((CallableReference) this).receiver;
        r0.userId = ((Number) r4).longValue();
    }
}
