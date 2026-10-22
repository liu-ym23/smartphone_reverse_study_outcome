package com.bytedance.android.live.ktv.common.model.api;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class MultiChorusInfo$chorusUserIdStringList$2 extends MutablePropertyReference0Impl {
    public MultiChorusInfo$chorusUserIdStringList$2(i0 r7) {
        super(r7, i0.class, "chorusUserOpenIds", "getChorusUserOpenIds()Ljava/util/List;", 0);
    }

    public Object get() {
        return ((i0) ((CallableReference) this).receiver).chorusUserOpenIds;
    }

    public void set(Object r2) {
        List<String> r3 = (List) r2;
        ((i0) ((CallableReference) this).receiver).chorusUserOpenIds = r3;
    }
}
