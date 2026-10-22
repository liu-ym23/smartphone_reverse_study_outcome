package com.bytedance.ai.widget;

import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kotlinx.coroutines.channels.f f3089a;

    public q() {
        this.f3089a = kotlinx.coroutines.channels.p.a(Integer.MAX_VALUE, 6, null);
        BuildersKt.launch$default(h0.a(t2.b.f22089a), null, null, new WidgetPrefetcher$loadCache$1(this, null), 3, null);
    }
}
