package com.bytedance.android.live.liveinteract.api;

import com.bytedance.android.live.liveinteract.LatestBanRecord;
import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Single;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface LinkBanApi {
    @GET("/webcast/review/get_latest_ban_record/")
    Single<e<LatestBanRecord>> getLatestBanRecord(@Query("ban_type") long r1);
}
