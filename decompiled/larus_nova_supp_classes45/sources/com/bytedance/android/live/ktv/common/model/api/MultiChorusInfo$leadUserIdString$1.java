package com.bytedance.android.live.ktv.common.model.api;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class MultiChorusInfo$leadUserIdString$1 extends MutablePropertyReference0Impl {
    public MultiChorusInfo$leadUserIdString$1(i0 r7) {
        super(r7, i0.class, "leadUserId", "getLeadUserId()J", 0);
    }

    public Object get() {
        return Long.valueOf(((i0) ((CallableReference) this).receiver).leadUserId);
    }

    public void set(Object r4) {
        i0 r0 = (i0) ((CallableReference) this).receiver;
        r0.leadUserId = ((Number) r4).longValue();
    }
}
