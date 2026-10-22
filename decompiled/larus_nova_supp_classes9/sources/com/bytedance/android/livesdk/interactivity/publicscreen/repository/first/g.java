package com.bytedance.android.livesdk.interactivity.publicscreen.repository.first;

import com.bytedance.android.livesdk.interactivity.api.monitor.PublicScreenTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.settings.config.s0;
import java.util.List;
import java.util.concurrent.TimeoutException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vlc.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements m {
    public final /* synthetic */ d a;

    public g(d r1) {
        this.a = r1;
    }

    public final void a(List<? extends tlc.d> r3) {
        Intrinsics.checkNotNullParameter(r3, "messages");
        this.a.c("兜底接口请求成功");
        d.a(this.a, r3);
    }

    public final void b(Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "error");
        if ((r5 instanceof TimeoutException) == false) goto L5;
        s0 r0 = PublicScreenTraceMonitor.a;
        PublicScreenTraceMonitor.k(-10024, "兜底接口请求超时", r5);
    L6:
        this.a.c("兜底接口请求失败");
        d.a(this.a, CollectionsKt.emptyList());
        return;
    L5:
        s0 r1 = PublicScreenTraceMonitor.a;
        PublicScreenTraceMonitor.k(-10024, "兜底接口请求失败", r5);
        goto L6
    }
}
