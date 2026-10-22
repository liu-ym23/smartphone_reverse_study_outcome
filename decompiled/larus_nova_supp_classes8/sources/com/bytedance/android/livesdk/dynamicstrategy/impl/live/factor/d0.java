package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.android.livesdk.widget.LiveUserPredictStrategy;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d0 extends DynamicFactor<Integer> {
    public final DataCenter b;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "inner_feed_stay_duration_p50";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        LiveUserPredictStrategy r0 = LiveUserPredictStrategy.c;
        DataCenter r1 = this.b;
        IRoom r2 = com.bytedance.android.live.core.utils.a0.a;
        Intrinsics.checkNotNullParameter(r1, "$this$safeFeedRoom");
        IRoom r3 = (IRoom) r1.get("data_feed_room", null);
        r0.getClass();
        return Integer.valueOf(LiveUserPredictStrategy.a(r3).a);
    }

    public d0(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.b = r2;
    }
}
