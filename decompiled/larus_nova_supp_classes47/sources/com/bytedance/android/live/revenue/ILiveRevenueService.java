package com.bytedance.android.live.revenue;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.live.revenue.RevenueServiceImpl")
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H&R\u0014\u0010\n\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/revenue/ILiveRevenueService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/live/kmp/core/a;", "createLiveRoomInstance", "roomInstance", "Lcom/bytedance/android/live/revenue/core/b;", "createRevenueInstance", "Lgy0/a;", "getHybridService", "()Lgy0/a;", "hybridService", "Lp01/a;", "getRoomRequestService", "()Lp01/a;", "roomRequestService", "Lfy0/a;", "getWidgetService", "()Lfy0/a;", "widgetService", "liverevenue-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveRevenueService extends IService {
    com.bytedance.live.kmp.core.a createLiveRoomInstance();

    com.bytedance.android.live.revenue.core.b createRevenueInstance(com.bytedance.live.kmp.core.a r1);

    gy0.a getHybridService();

    p01.a getRoomRequestService();

    fy0.a getWidgetService();
}
