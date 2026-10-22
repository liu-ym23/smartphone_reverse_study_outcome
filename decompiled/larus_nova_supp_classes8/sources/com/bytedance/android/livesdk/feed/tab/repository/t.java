package com.bytedance.android.livesdk.feed.tab.repository;

import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.livesdk.feed.tab.api.FeedTabApi;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t implements r {
    public final FeedTabApi a;

    public class a extends BDNetworkTagContextProviderAdapter {
        public final int triggerType() {
            return 0;
        }

        public a() {
        }
    }

    @Override // com.bytedance.android.livesdk.feed.tab.repository.r
    public final Observable<BaseListResponse<com.bytedance.android.livesdk.feed.feed.e, com.bytedance.android.livesdk.feed.feed.f>> a() {
        String r0 = (String) BDNetworkTagManager.getInstance().buildBDNetworkTag(new a()).second;
        return this.a.queryTab(0, r0).subscribeOn(Schedulers.io());
    }

    public t(FeedTabApi r1) {
        this.a = r1;
    }
}
