package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class MultiLinkFeedDynamicWidgetNew$updateIsPreload$1 extends MutablePropertyReference0Impl {
    public MultiLinkFeedDynamicWidgetNew$updateIsPreload$1(MultiLinkFeedDynamicWidgetNew r7) {
        super(r7, MultiLinkFeedDynamicWidgetNew.class, "micSeatHandler", "getMicSeatHandler()Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/handler/feed/MicSeatFeedDynamicHandler;", 0);
    }

    public Object get() {
        mh0.p r0 = ((MultiLinkFeedDynamicWidgetNew) ((CallableReference) this).receiver).h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("micSeatHandler");
    L5:
        return r0;
    }

    public void set(Object r2) {
        mh0.p r3 = (mh0.p) r2;
        ((MultiLinkFeedDynamicWidgetNew) ((CallableReference) this).receiver).h = r3;
    }
}
