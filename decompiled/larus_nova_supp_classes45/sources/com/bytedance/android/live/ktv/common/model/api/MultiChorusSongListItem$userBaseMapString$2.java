package com.bytedance.android.live.ktv.common.model.api;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class MultiChorusSongListItem$userBaseMapString$2 extends MutablePropertyReference0Impl {
    public MultiChorusSongListItem$userBaseMapString$2(k0 r7) {
        super(r7, k0.class, "openUserBaseMap", "getOpenUserBaseMap()Ljava/util/Map;", 0);
    }

    public Object get() {
        return ((k0) ((CallableReference) this).receiver).openUserBaseMap;
    }

    public void set(Object r2) {
        Map<String, l0> r3 = (Map) r2;
        ((k0) ((CallableReference) this).receiver).openUserBaseMap = r3;
    }
}
