package com.bytedance.android.live.liveinteract.feed.datamerge;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class AbsFeedViewLinkUserMergeDataHandler$proxyIsInitialized$1 extends MutablePropertyReference0Impl {
    public AbsFeedViewLinkUserMergeDataHandler$proxyIsInitialized$1(a r7) {
        super(r7, a.class, "proxy", "getProxy()Lcom/bytedance/android/live/liveinteract/feed/datamerge/IFeedViewLinkUserMergeDataCenterProxy;", 0);
    }

    public Object get() {
        return ((a) ((CallableReference) this).receiver).c();
    }

    public void set(Object r3) {
        a r0 = (a) ((CallableReference) this).receiver;
        k r4 = (k) r3;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.a = r4;
    }
}
