package com.bytedance.android.live.ktv.common.model.api;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class MultiChorusUserBase$userIdString$2 extends MutablePropertyReference0Impl {
    public MultiChorusUserBase$userIdString$2(l0 r7) {
        super(r7, l0.class, "openId", "getOpenId()Ljava/lang/String;", 0);
    }

    public Object get() {
        return ((l0) ((CallableReference) this).receiver).openId;
    }

    public void set(Object r3) {
        l0 r0 = (l0) ((CallableReference) this).receiver;
        String r4 = (String) r3;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.openId = r4;
    }
}
