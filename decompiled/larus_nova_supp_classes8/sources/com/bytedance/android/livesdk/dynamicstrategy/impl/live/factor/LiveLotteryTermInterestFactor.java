package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/live/factor/LiveLotteryTermInterestFactor;", "Lcom/bytedance/android/livesdk/dynamicstrategy/impl/live/factor/LiveShortTouchFactor;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLotteryTermInterestFactor extends LiveShortTouchFactor {
    public final DataCenter c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.LiveShortTouchFactor, com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        return 0;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.LiveShortTouchFactor, com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "feat_coin_lottery_amount";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.LiveShortTouchFactor
    public final Integer f() {
        return 0;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.LiveShortTouchFactor, com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
        this.c.observe("data_lottery_interest_count", this);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.LiveShortTouchFactor, com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
        this.c.removeObserver("data_lottery_interest_count", this);
    }

    public LiveLotteryTermInterestFactor(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        super(r2);
        this.c = r2;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.LiveShortTouchFactor
    public final void g(KVData r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r4.getKey()) == false) goto L7;
        return;
    L7:
        if (TextUtils.equals(r4.getKey(), "data_lottery_interest_count") == false) goto L14;
        Long r5 = (Long) r4.getData(0L);
        if (r5 != null) goto L11;
        r5 = 0L;
    L11:
        int r6 = (int) r5.longValue();
        h("feat_coin_lottery_amount", r6);
        ALogger.i("LiveLotteryTermInterestFactor", "count = " + r6);
        return;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.LiveShortTouchFactor
    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        g((KVData) r1);
    }
}
