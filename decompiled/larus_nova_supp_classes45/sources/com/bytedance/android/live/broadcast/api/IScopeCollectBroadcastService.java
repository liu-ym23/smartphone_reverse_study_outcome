package com.bytedance.android.live.broadcast.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceDummyLookup;
import com.bytedance.android.live.utility.ServiceLookup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ServiceLookup("com.bytedance.android.live.broadcast.ScopeCollectBroadcastService")
@ServiceDummyLookup("com.bytedance.android.live.broadcast.api.dummy.ScopeCollectServiceDummy")
public interface IScopeCollectBroadcastService extends IService {
    void registerScopeService();
}
