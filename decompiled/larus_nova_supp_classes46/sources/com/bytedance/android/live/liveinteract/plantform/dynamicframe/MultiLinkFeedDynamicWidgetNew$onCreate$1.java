package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class MultiLinkFeedDynamicWidgetNew$onCreate$1 extends MutablePropertyReference0Impl {
    public MultiLinkFeedDynamicWidgetNew$onCreate$1(MultiLinkFeedDynamicWidgetNew r7) {
        super(r7, MultiLinkFeedDynamicWidgetNew.class, "handlerList", "getHandlerList()Ljava/util/List;", 0);
    }

    public Object get() {
        List<? extends lh0.a> r0 = ((MultiLinkFeedDynamicWidgetNew) ((CallableReference) this).receiver).n;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("handlerList");
    L5:
        return r0;
    }

    public void set(Object r2) {
        List<? extends lh0.a> r3 = (List) r2;
        ((MultiLinkFeedDynamicWidgetNew) ((CallableReference) this).receiver).n = r3;
    }
}
