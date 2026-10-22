package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LiveDanmakuCountLevel extends DynamicFactor<Integer> {
    public Disposable b;
    public final DataCenter c;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        return 0;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_danmaku_count_level";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
        com.bytedance.android.livesdk.interactivity.api.h r0 = com.bytedance.android.livesdk.interactivity.api.i.b(this.c, 1);
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.j r1 = r0.getBarrageContext();
        if (r1 == null) goto L9;
        r1.c(new LiveDanmakuCountLevel$onBind$1(this));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
        Disposable r0 = this.b;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public LiveDanmakuCountLevel(DataCenter r1) {
        this.c = r1;
    }
}
