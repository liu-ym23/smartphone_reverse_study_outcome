package com.bytedance.android.livesdk.feed.preview;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.performance.TimeCostUtil;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ ILivePlayerClient a;
    public final /* synthetic */ LiveFeedPreview b;
    public final /* synthetic */ LifecycleOwner c;

    public c(ILivePlayerClient r1, LiveFeedPreview r2, LifecycleOwner r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onChanged(Object r3) {
        if ((!Intrinsics.areEqual((Boolean) r3, Boolean.TRUE)) == true) goto L10;
        mw1.f r4 = this.b.c;
        if (r4 == null) goto L8;
        r4.b(true);
    L8:
        Pair r5 = this.a.getVideoSize();
        LiveFeedPreview.d(this.b, ((Number) r5.getFirst()).intValue(), ((Number) r5.getSecond()).intValue());
        com.bytedance.android.live.core.performance.a r6 = com.bytedance.android.live.core.performance.a.a;
        TimeCostUtil.Tag.LiveFeedPreview.name();
        r6.getClass();
        int r7 = TimeCostUtil.a;
        return;
    }
}
