package com.bytedance.android.live.broadcast.api;

import com.bytedance.android.live.broadcast.api.model.AnchorVideoResolutionManager;
import com.bytedance.android.live.broadcast.api.model.IBroadcastApiService;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class BroadcastApiService implements IBroadcastApiService {
    public BroadcastApiService() {
    }

    @Override // com.bytedance.android.live.broadcast.api.model.IBroadcastApiService
    public String getCurrentResolutionKey() {
        Map<String, Pair<Integer, Integer>> r0 = AnchorVideoResolutionManager.a;
        return AnchorVideoResolutionManager.c;
    }
}
