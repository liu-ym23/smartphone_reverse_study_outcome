package com.bytedance.android.livesdk.interactivity.publicscreen.repository.first;

import com.bytedance.android.livesdk.interactivity.api.monitor.PublicScreenTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.settings.config.s0;
import io.reactivex.functions.Consumer;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ d a;

    public e(d r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        s0 r6 = PublicScreenTraceMonitor.a;
        PublicScreenTraceMonitor.k(-10026, "计时器超时，返回空列表", null);
        this.a.c("计时器超时");
        d.a(this.a, CollectionsKt.emptyList());
    }
}
