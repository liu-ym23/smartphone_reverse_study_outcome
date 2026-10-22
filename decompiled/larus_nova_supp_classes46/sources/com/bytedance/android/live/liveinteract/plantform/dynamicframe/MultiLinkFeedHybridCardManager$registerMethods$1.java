package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkFeedHybridCardManager$registerMethods$1 implements com.bytedance.ies.web.jsbridge2.f.b {
    public final Lazy a;
    public final /* synthetic */ MultiLinkFeedHybridCardManager b;

    public final com.bytedance.ies.web.jsbridge2.f<?, ?> a() {
        return (com.bytedance.android.live.liveinteract.jsbridge.method.y) this.a.getValue();
    }

    public MultiLinkFeedHybridCardManager$registerMethods$1(MultiLinkFeedHybridCardManager r2) {
        this.b = r2;
        this.a = LazyKt.lazy(LazyThreadSafetyMode.NONE, new MultiLinkFeedHybridCardManager$registerMethods$1$registerMethod$2(this));
    }
}
