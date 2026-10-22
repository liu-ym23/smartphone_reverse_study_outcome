package com.bytedance.ai.widget;

import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n {
    public static volatile boolean b;
    public static volatile String c;
    public final Channel<h5.k> a;

    public static final class a {
    }

    static {
    }

    public n() {
        this.a = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a), null, null, new WidgetPrefetcher$loadCache$1(this, null), 3, null);
    }
}
